package javassist.compiler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Opcode;
import javassist.compiler.MemberResolver;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.AssignExpr;
import javassist.compiler.ast.BinExpr;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.CondExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.InstanceOfExpr;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;
import javassist.compiler.ast.Visitor;
import okhttp3.HttpUrl;
import org.jline.console.Printer;

/* loaded from: grasscutter.jar:javassist/compiler/TypeChecker.class */
public class TypeChecker extends Visitor implements Opcode, TokenId {
    static final String javaLangObject = "java.lang.Object";
    static final String jvmJavaLangObject = "java/lang/Object";
    static final String jvmJavaLangString = "java/lang/String";
    static final String jvmJavaLangClass = "java/lang/Class";
    protected int exprType;
    protected int arrayDim;
    protected String className;
    protected MemberResolver resolver;
    protected CtClass thisClass;
    protected MethodInfo thisMethod = null;

    public TypeChecker(CtClass cc, ClassPool cp) {
        this.resolver = new MemberResolver(cp);
        this.thisClass = cc;
    }

    protected static String argTypesToString(int[] types, int[] dims, String[] cnames) {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append('(');
        int n = types.length;
        if (n > 0) {
            int i = 0;
            while (true) {
                typeToString(sbuf, types[i], dims[i], cnames[i]);
                i++;
                if (i >= n) {
                    break;
                }
                sbuf.append(',');
            }
        }
        sbuf.append(')');
        return sbuf.toString();
    }

    protected static StringBuffer typeToString(StringBuffer sbuf, int type, int dim, String cname) {
        String s;
        if (type == 307) {
            s = MemberResolver.jvmToJavaName(cname);
        } else if (type == 412) {
            s = "Object";
        } else {
            try {
                s = MemberResolver.getTypeName(type);
            } catch (CompileError e) {
                s = "?";
            }
        }
        sbuf.append(s);
        while (true) {
            dim--;
            if (dim <= 0) {
                return sbuf;
            }
            sbuf.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
    }

    public void setThisMethod(MethodInfo m) {
        this.thisMethod = m;
    }

    protected static void fatal() throws CompileError {
        throw new CompileError("fatal");
    }

    protected String getThisName() {
        return MemberResolver.javaToJvmName(this.thisClass.getName());
    }

    protected String getSuperName() throws CompileError {
        return MemberResolver.javaToJvmName(MemberResolver.getSuperclass(this.thisClass).getName());
    }

    protected String resolveClassName(ASTList name) throws CompileError {
        return this.resolver.resolveClassName(name);
    }

    protected String resolveClassName(String jvmName) throws CompileError {
        return this.resolver.resolveJvmClassName(jvmName);
    }

    @Override // javassist.compiler.ast.Visitor
    public void atNewExpr(NewExpr expr) throws CompileError {
        if (expr.isArray()) {
            atNewArrayExpr(expr);
            return;
        }
        CtClass clazz = this.resolver.lookupClassByName(expr.getClassName());
        String cname = clazz.getName();
        atMethodCallCore(clazz, "<init>", expr.getArguments());
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = MemberResolver.javaToJvmName(cname);
    }

    public void atNewArrayExpr(NewExpr expr) throws CompileError {
        int type = expr.getArrayType();
        ASTList size = expr.getArraySize();
        ASTList classname = expr.getClassName();
        ASTree init = expr.getInitializer();
        if (init != null) {
            init.accept(this);
        }
        if (size.length() > 1) {
            atMultiNewArray(type, classname, size);
            return;
        }
        ASTree sizeExpr = size.head();
        if (sizeExpr != null) {
            sizeExpr.accept(this);
        }
        this.exprType = type;
        this.arrayDim = 1;
        if (type == 307) {
            this.className = resolveClassName(classname);
        } else {
            this.className = null;
        }
    }

    @Override // javassist.compiler.ast.Visitor
    public void atArrayInit(ArrayInit init) throws CompileError {
        ASTList list = init;
        while (list != null) {
            ASTree h = list.head();
            list = list.tail();
            if (h != null) {
                h.accept(this);
            }
        }
    }

    protected void atMultiNewArray(int type, ASTList classname, ASTList size) throws CompileError {
        ASTree s;
        int dim = size.length();
        int count = 0;
        while (size != null && (s = size.head()) != null) {
            count++;
            s.accept(this);
            size = size.tail();
        }
        this.exprType = type;
        this.arrayDim = dim;
        if (type == 307) {
            this.className = resolveClassName(classname);
        } else {
            this.className = null;
        }
    }

    @Override // javassist.compiler.ast.Visitor
    public void atAssignExpr(AssignExpr expr) throws CompileError {
        int op = expr.getOperator();
        ASTree left = expr.oprand1();
        ASTree right = expr.oprand2();
        if (left instanceof Variable) {
            atVariableAssign(expr, op, (Variable) left, ((Variable) left).getDeclarator(), right);
        } else if (!(left instanceof Expr) || ((Expr) left).getOperator() != 65) {
            atFieldAssign(expr, op, left, right);
        } else {
            atArrayAssign(expr, op, (Expr) left, right);
        }
    }

    private void atVariableAssign(Expr expr, int op, Variable var, Declarator d, ASTree right) throws CompileError {
        int varType = d.getType();
        int varArray = d.getArrayDim();
        String varClass = d.getClassName();
        if (op != 61) {
            atVariable(var);
        }
        right.accept(this);
        this.exprType = varType;
        this.arrayDim = varArray;
        this.className = varClass;
    }

    private void atArrayAssign(Expr expr, int op, Expr array, ASTree right) throws CompileError {
        atArrayRead(array.oprand1(), array.oprand2());
        int aType = this.exprType;
        int aDim = this.arrayDim;
        String cname = this.className;
        right.accept(this);
        this.exprType = aType;
        this.arrayDim = aDim;
        this.className = cname;
    }

    /* access modifiers changed from: protected */
    public void atFieldAssign(Expr expr, int op, ASTree left, ASTree right) throws CompileError {
        atFieldRead(fieldAccess(left));
        int fType = this.exprType;
        int fDim = this.arrayDim;
        String cname = this.className;
        right.accept(this);
        this.exprType = fType;
        this.arrayDim = fDim;
        this.className = cname;
    }

    @Override // javassist.compiler.ast.Visitor
    public void atCondExpr(CondExpr expr) throws CompileError {
        booleanExpr(expr.condExpr());
        expr.thenExpr().accept(this);
        int type1 = this.exprType;
        int dim1 = this.arrayDim;
        String str = this.className;
        expr.elseExpr().accept(this);
        if (dim1 != 0 || dim1 != this.arrayDim) {
            return;
        }
        if (CodeGen.rightIsStrong(type1, this.exprType)) {
            expr.setThen(new CastExpr(this.exprType, 0, expr.thenExpr()));
        } else if (CodeGen.rightIsStrong(this.exprType, type1)) {
            expr.setElse(new CastExpr(type1, 0, expr.elseExpr()));
            this.exprType = type1;
        }
    }

    @Override // javassist.compiler.ast.Visitor
    public void atBinExpr(BinExpr expr) throws CompileError {
        int token = expr.getOperator();
        if (CodeGen.lookupBinOp(token) < 0) {
            booleanExpr(expr);
        } else if (token == 43) {
            Expr e = atPlusExpr(expr);
            if (e != null) {
                expr.setOprand1(CallExpr.makeCall(Expr.make(46, e, new Member(Printer.TO_STRING)), null));
                expr.setOprand2(null);
                this.className = jvmJavaLangString;
            }
        } else {
            ASTree left = expr.oprand1();
            ASTree right = expr.oprand2();
            left.accept(this);
            int type1 = this.exprType;
            right.accept(this);
            if (!isConstant(expr, token, left, right)) {
                computeBinExprType(expr, token, type1);
            }
        }
    }

    private Expr atPlusExpr(BinExpr expr) throws CompileError {
        ASTree left = expr.oprand1();
        ASTree right = expr.oprand2();
        if (right == null) {
            left.accept(this);
            return null;
        }
        if (isPlusExpr(left)) {
            Expr newExpr = atPlusExpr((BinExpr) left);
            if (newExpr != null) {
                right.accept(this);
                this.exprType = 307;
                this.arrayDim = 0;
                this.className = "java/lang/StringBuffer";
                return makeAppendCall(newExpr, right);
            }
        } else {
            left.accept(this);
        }
        int type1 = this.exprType;
        int dim1 = this.arrayDim;
        String cname = this.className;
        right.accept(this);
        if (isConstant(expr, 43, left, right)) {
            return null;
        }
        if ((type1 == 307 && dim1 == 0 && jvmJavaLangString.equals(cname)) || (this.exprType == 307 && this.arrayDim == 0 && jvmJavaLangString.equals(this.className))) {
            ASTree e = new NewExpr(ASTList.make(new Symbol("java"), new Symbol("lang"), new Symbol("StringBuffer")), null);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/StringBuffer";
            return makeAppendCall(makeAppendCall(e, left), right);
        }
        computeBinExprType(expr, 43, type1);
        return null;
    }

    private boolean isConstant(BinExpr expr, int op, ASTree left, ASTree right) throws CompileError {
        ASTree left2 = stripPlusExpr(left);
        ASTree right2 = stripPlusExpr(right);
        ASTree newExpr = null;
        if ((left2 instanceof StringL) && (right2 instanceof StringL) && op == 43) {
            newExpr = new StringL(((StringL) left2).get() + ((StringL) right2).get());
        } else if (left2 instanceof IntConst) {
            newExpr = ((IntConst) left2).compute(op, right2);
        } else if (left2 instanceof DoubleConst) {
            newExpr = ((DoubleConst) left2).compute(op, right2);
        }
        if (newExpr == null) {
            return false;
        }
        expr.setOperator(43);
        expr.setOprand1(newExpr);
        expr.setOprand2(null);
        newExpr.accept(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static ASTree stripPlusExpr(ASTree expr) {
        ASTree cexpr;
        if (expr instanceof BinExpr) {
            BinExpr e = (BinExpr) expr;
            if (e.getOperator() == 43 && e.oprand2() == null) {
                return e.getLeft();
            }
        } else if (expr instanceof Expr) {
            Expr e2 = (Expr) expr;
            int op = e2.getOperator();
            if (op == 35) {
                ASTree cexpr2 = getConstantFieldValue((Member) e2.oprand2());
                if (cexpr2 != null) {
                    return cexpr2;
                }
            } else if (op == 43 && e2.getRight() == null) {
                return e2.getLeft();
            }
        } else if ((expr instanceof Member) && (cexpr = getConstantFieldValue((Member) expr)) != null) {
            return cexpr;
        }
        return expr;
    }

    private static ASTree getConstantFieldValue(Member mem) {
        return getConstantFieldValue(mem.getField());
    }

    public static ASTree getConstantFieldValue(CtField f) {
        Object value;
        if (f == null || (value = f.getConstantValue()) == null) {
            return null;
        }
        if (value instanceof String) {
            return new StringL((String) value);
        }
        if ((value instanceof Double) || (value instanceof Float)) {
            return new DoubleConst(((Number) value).doubleValue(), value instanceof Double ? 405 : 404);
        } else if (value instanceof Number) {
            return new IntConst(((Number) value).longValue(), value instanceof Long ? 403 : 402);
        } else if (!(value instanceof Boolean)) {
            return null;
        } else {
            return new Keyword(((Boolean) value).booleanValue() ? 410 : 411);
        }
    }

    private static boolean isPlusExpr(ASTree expr) {
        return (expr instanceof BinExpr) && ((BinExpr) expr).getOperator() == 43;
    }

    private static Expr makeAppendCall(ASTree target, ASTree arg) {
        return CallExpr.makeCall(Expr.make(46, target, new Member("append")), new ASTList(arg));
    }

    private void computeBinExprType(BinExpr expr, int token, int type1) throws CompileError {
        int type2 = this.exprType;
        if (token == 364 || token == 366 || token == 370) {
            this.exprType = type1;
        } else {
            insertCast(expr, type1, type2);
        }
        if (CodeGen.isP_INT(this.exprType) && this.exprType != 301) {
            this.exprType = 324;
        }
    }

    private void booleanExpr(ASTree expr) throws CompileError {
        int op = CodeGen.getCompOperator(expr);
        if (op == 358) {
            BinExpr bexpr = (BinExpr) expr;
            bexpr.oprand1().accept(this);
            int type1 = this.exprType;
            int dim1 = this.arrayDim;
            bexpr.oprand2().accept(this);
            if (dim1 == 0 && this.arrayDim == 0) {
                insertCast(bexpr, type1, this.exprType);
            }
        } else if (op == 33) {
            ((Expr) expr).oprand1().accept(this);
        } else if (op == 369 || op == 368) {
            BinExpr bexpr2 = (BinExpr) expr;
            bexpr2.oprand1().accept(this);
            bexpr2.oprand2().accept(this);
        } else {
            expr.accept(this);
        }
        this.exprType = 301;
        this.arrayDim = 0;
    }

    private void insertCast(BinExpr expr, int type1, int type2) throws CompileError {
        if (CodeGen.rightIsStrong(type1, type2)) {
            expr.setLeft(new CastExpr(type2, 0, expr.oprand1()));
        } else {
            this.exprType = type1;
        }
    }

    @Override // javassist.compiler.ast.Visitor
    public void atCastExpr(CastExpr expr) throws CompileError {
        String cname = resolveClassName(expr.getClassName());
        expr.getOprand().accept(this);
        this.exprType = expr.getType();
        this.arrayDim = expr.getArrayDim();
        this.className = cname;
    }

    @Override // javassist.compiler.ast.Visitor
    public void atInstanceOfExpr(InstanceOfExpr expr) throws CompileError {
        expr.getOprand().accept(this);
        this.exprType = 301;
        this.arrayDim = 0;
    }

    @Override // javassist.compiler.ast.Visitor
    public void atExpr(Expr expr) throws CompileError {
        int token = expr.getOperator();
        ASTree oprand = expr.oprand1();
        if (token == 46) {
            String member = ((Symbol) expr.oprand2()).get();
            if (member.equals("length")) {
                try {
                    atArrayLength(expr);
                } catch (NoFieldException e) {
                    atFieldRead(expr);
                }
            } else if (member.equals("class")) {
                atClassObject(expr);
            } else {
                atFieldRead(expr);
            }
        } else if (token == 35) {
            if (((Symbol) expr.oprand2()).get().equals("class")) {
                atClassObject(expr);
            } else {
                atFieldRead(expr);
            }
        } else if (token == 65) {
            atArrayRead(oprand, expr.oprand2());
        } else if (token == 362 || token == 363) {
            atPlusPlus(token, oprand, expr);
        } else if (token == 33) {
            booleanExpr(expr);
        } else if (token == 67) {
            fatal();
        } else {
            oprand.accept(this);
            if (isConstant(expr, token, oprand)) {
                return;
            }
            if ((token == 45 || token == 126) && CodeGen.isP_INT(this.exprType)) {
                this.exprType = 324;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    private boolean isConstant(Expr expr, int op, ASTree oprand) {
        char c;
        ASTree oprand2 = stripPlusExpr(oprand);
        if (oprand2 instanceof IntConst) {
            IntConst c2 = (IntConst) oprand2;
            long v = c2.get();
            if (op == 45) {
                c = -v;
            } else if (op != 126) {
                return false;
            } else {
                c = v ^ -1;
            }
            c2.set(c);
        } else if (!(oprand2 instanceof DoubleConst)) {
            return false;
        } else {
            DoubleConst c3 = (DoubleConst) oprand2;
            if (op != 45) {
                return false;
            }
            c3.set(-c3.get());
        }
        expr.setOperator(43);
        return true;
    }

    @Override // javassist.compiler.ast.Visitor
    public void atCallExpr(CallExpr expr) throws CompileError {
        String mname = null;
        CtClass targetClass = null;
        ASTree method = expr.oprand1();
        ASTList args = (ASTList) expr.oprand2();
        if (method instanceof Member) {
            mname = ((Member) method).get();
            targetClass = this.thisClass;
        } else if (method instanceof Keyword) {
            mname = "<init>";
            targetClass = ((Keyword) method).get() == 336 ? MemberResolver.getSuperclass(this.thisClass) : this.thisClass;
        } else if (method instanceof Expr) {
            Expr e = (Expr) method;
            mname = ((Symbol) e.oprand2()).get();
            int op = e.getOperator();
            if (op == 35) {
                targetClass = this.resolver.lookupClass(((Symbol) e.oprand1()).get(), false);
            } else if (op == 46) {
                ASTree target = e.oprand1();
                String classFollowedByDotSuper = isDotSuper(target);
                if (classFollowedByDotSuper != null) {
                    targetClass = MemberResolver.getSuperInterface(this.thisClass, classFollowedByDotSuper);
                } else {
                    try {
                        target.accept(this);
                    } catch (NoFieldException nfe) {
                        if (nfe.getExpr() != target) {
                            throw nfe;
                        }
                        this.exprType = 307;
                        this.arrayDim = 0;
                        this.className = nfe.getField();
                        e.setOperator(35);
                        e.setOprand1(new Symbol(MemberResolver.jvmToJavaName(this.className)));
                    }
                    if (this.arrayDim > 0) {
                        targetClass = this.resolver.lookupClass(javaLangObject, true);
                    } else if (this.exprType == 307) {
                        targetClass = this.resolver.lookupClassByJvmName(this.className);
                    } else {
                        badMethod();
                    }
                }
            } else {
                badMethod();
            }
        } else {
            fatal();
        }
        expr.setMethod(atMethodCallCore(targetClass, mname, args));
    }

    private static void badMethod() throws CompileError {
        throw new CompileError("bad method");
    }

    /* access modifiers changed from: package-private */
    public static String isDotSuper(ASTree target) {
        if (!(target instanceof Expr)) {
            return null;
        }
        Expr e = (Expr) target;
        if (e.getOperator() != 46) {
            return null;
        }
        ASTree right = e.oprand2();
        if (!(right instanceof Keyword) || ((Keyword) right).get() != 336) {
            return null;
        }
        return ((Symbol) e.oprand1()).get();
    }

    public MemberResolver.Method atMethodCallCore(CtClass targetClass, String mname, ASTList args) throws CompileError {
        String msg;
        int nargs = getMethodArgsLength(args);
        int[] types = new int[nargs];
        int[] dims = new int[nargs];
        String[] cnames = new String[nargs];
        atMethodArgs(args, types, dims, cnames);
        MemberResolver.Method found = this.resolver.lookupMethod(targetClass, this.thisClass, this.thisMethod, mname, types, dims, cnames);
        if (found == null) {
            String clazz = targetClass.getName();
            String signature = argTypesToString(types, dims, cnames);
            if (mname.equals("<init>")) {
                msg = "cannot find constructor " + clazz + signature;
            } else {
                msg = mname + signature + " not found in " + clazz;
            }
            throw new CompileError(msg);
        }
        setReturnType(found.info.getDescriptor());
        return found;
    }

    public int getMethodArgsLength(ASTList args) {
        return ASTList.length(args);
    }

    public void atMethodArgs(ASTList args, int[] types, int[] dims, String[] cnames) throws CompileError {
        int i = 0;
        while (args != null) {
            args.head().accept(this);
            types[i] = this.exprType;
            dims[i] = this.arrayDim;
            cnames[i] = this.className;
            i++;
            args = args.tail();
        }
    }

    void setReturnType(String desc) throws CompileError {
        int i = desc.indexOf(41);
        if (i < 0) {
            badMethod();
        }
        int i2 = i + 1;
        char c = desc.charAt(i2);
        int dim = 0;
        while (c == '[') {
            dim++;
            i2++;
            c = desc.charAt(i2);
        }
        this.arrayDim = dim;
        if (c == 'L') {
            int j = desc.indexOf(59, i2 + 1);
            if (j < 0) {
                badMethod();
            }
            this.exprType = 307;
            this.className = desc.substring(i2 + 1, j);
            return;
        }
        this.exprType = MemberResolver.descToType(c);
        this.className = null;
    }

    private void atFieldRead(ASTree expr) throws CompileError {
        atFieldRead(fieldAccess(expr));
    }

    private void atFieldRead(CtField f) throws CompileError {
        String type = f.getFieldInfo2().getDescriptor();
        int i = 0;
        int dim = 0;
        char c = type.charAt(0);
        while (c == '[') {
            dim++;
            i++;
            c = type.charAt(i);
        }
        this.arrayDim = dim;
        this.exprType = MemberResolver.descToType(c);
        if (c == 'L') {
            this.className = type.substring(i + 1, type.indexOf(59, i + 1));
        } else {
            this.className = null;
        }
    }

    protected CtField fieldAccess(ASTree expr) throws CompileError {
        if (expr instanceof Member) {
            Member mem = (Member) expr;
            String name = mem.get();
            try {
                CtField f = this.thisClass.getField(name);
                if (Modifier.isStatic(f.getModifiers())) {
                    mem.setField(f);
                }
                return f;
            } catch (NotFoundException e) {
                throw new NoFieldException(name, expr);
            }
        } else {
            if (expr instanceof Expr) {
                Expr e2 = (Expr) expr;
                int op = e2.getOperator();
                if (op == 35) {
                    Member mem2 = (Member) e2.oprand2();
                    CtField f2 = this.resolver.lookupField(((Symbol) e2.oprand1()).get(), mem2);
                    mem2.setField(f2);
                    return f2;
                } else if (op == 46) {
                    try {
                        e2.oprand1().accept(this);
                        CompileError err = null;
                        try {
                            if (this.exprType == 307 && this.arrayDim == 0) {
                                return this.resolver.lookupFieldByJvmName(this.className, (Symbol) e2.oprand2());
                            }
                        } catch (CompileError ce) {
                            err = ce;
                        }
                        ASTree oprnd1 = e2.oprand1();
                        if (oprnd1 instanceof Symbol) {
                            return fieldAccess2(e2, ((Symbol) oprnd1).get());
                        }
                        if (err != null) {
                            throw err;
                        }
                    } catch (NoFieldException nfe) {
                        if (nfe.getExpr() == e2.oprand1()) {
                            return fieldAccess2(e2, nfe.getField());
                        }
                        throw nfe;
                    }
                }
            }
            throw new CompileError("bad field access");
        }
    }

    private CtField fieldAccess2(Expr e, String jvmClassName) throws CompileError {
        Member fname = (Member) e.oprand2();
        CtField f = this.resolver.lookupFieldByJvmName2(jvmClassName, fname, e);
        e.setOperator(35);
        e.setOprand1(new Symbol(MemberResolver.jvmToJavaName(jvmClassName)));
        fname.setField(f);
        return f;
    }

    public void atClassObject(Expr expr) throws CompileError {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/Class";
    }

    public void atArrayLength(Expr expr) throws CompileError {
        expr.oprand1().accept(this);
        if (this.arrayDim == 0) {
            throw new NoFieldException("length", expr);
        }
        this.exprType = 324;
        this.arrayDim = 0;
    }

    public void atArrayRead(ASTree array, ASTree index) throws CompileError {
        array.accept(this);
        int type = this.exprType;
        int dim = this.arrayDim;
        String cname = this.className;
        index.accept(this);
        this.exprType = type;
        this.arrayDim = dim - 1;
        this.className = cname;
    }

    private void atPlusPlus(int token, ASTree oprand, Expr expr) throws CompileError {
        if (oprand == null) {
            oprand = expr.oprand2();
        }
        if (oprand instanceof Variable) {
            Declarator d = ((Variable) oprand).getDeclarator();
            this.exprType = d.getType();
            this.arrayDim = d.getArrayDim();
            return;
        }
        if (oprand instanceof Expr) {
            Expr e = (Expr) oprand;
            if (e.getOperator() == 65) {
                atArrayRead(e.oprand1(), e.oprand2());
                int t = this.exprType;
                if (t == 324 || t == 303 || t == 306 || t == 334) {
                    this.exprType = 324;
                    return;
                }
                return;
            }
        }
        atFieldPlusPlus(oprand);
    }

    protected void atFieldPlusPlus(ASTree oprand) throws CompileError {
        atFieldRead(fieldAccess(oprand));
        int t = this.exprType;
        if (t == 324 || t == 303 || t == 306 || t == 334) {
            this.exprType = 324;
        }
    }

    @Override // javassist.compiler.ast.Visitor
    public void atMember(Member mem) throws CompileError {
        atFieldRead(mem);
    }

    @Override // javassist.compiler.ast.Visitor
    public void atVariable(Variable v) throws CompileError {
        Declarator d = v.getDeclarator();
        this.exprType = d.getType();
        this.arrayDim = d.getArrayDim();
        this.className = d.getClassName();
    }

    @Override // javassist.compiler.ast.Visitor
    public void atKeyword(Keyword k) throws CompileError {
        this.arrayDim = 0;
        int token = k.get();
        switch (token) {
            case TokenId.SUPER:
            case 339:
                this.exprType = 307;
                if (token == 339) {
                    this.className = getThisName();
                    return;
                } else {
                    this.className = getSuperName();
                    return;
                }
            case 410:
            case 411:
                this.exprType = 301;
                return;
            case 412:
                this.exprType = 412;
                return;
            default:
                fatal();
                return;
        }
    }

    @Override // javassist.compiler.ast.Visitor
    public void atStringL(StringL s) throws CompileError {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = jvmJavaLangString;
    }

    @Override // javassist.compiler.ast.Visitor
    public void atIntConst(IntConst i) throws CompileError {
        this.arrayDim = 0;
        int type = i.getType();
        if (type == 402 || type == 401) {
            this.exprType = type == 402 ? 324 : TokenId.CHAR;
        } else {
            this.exprType = TokenId.LONG;
        }
    }

    @Override // javassist.compiler.ast.Visitor
    public void atDoubleConst(DoubleConst d) throws CompileError {
        this.arrayDim = 0;
        if (d.getType() == 405) {
            this.exprType = TokenId.DOUBLE;
        } else {
            this.exprType = 317;
        }
    }
}
