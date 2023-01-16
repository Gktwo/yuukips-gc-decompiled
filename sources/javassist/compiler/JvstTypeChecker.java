package javassist.compiler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.Symbol;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* loaded from: grasscutter.jar:javassist/compiler/JvstTypeChecker.class */
public class JvstTypeChecker extends TypeChecker {
    private JvstCodeGen codeGen;

    public JvstTypeChecker(CtClass cc, ClassPool cp, JvstCodeGen gen) {
        super(cc, cp);
        this.codeGen = gen;
    }

    public void addNullIfVoid() {
        if (this.exprType == 344) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME;
        }
    }

    @Override // javassist.compiler.TypeChecker, javassist.compiler.ast.Visitor
    public void atMember(Member mem) throws CompileError {
        String name = mem.get();
        if (name.equals(this.codeGen.paramArrayName)) {
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME;
        } else if (name.equals(JvstCodeGen.sigName)) {
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME;
        } else if (name.equals("$type") || name.equals(JvstCodeGen.clazzName)) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME;
        } else {
            atMember(mem);
        }
    }

    @Override // javassist.compiler.TypeChecker
    protected void atFieldAssign(Expr expr, int op, ASTree left, ASTree right) throws CompileError {
        if (!(left instanceof Member) || !((Member) left).get().equals(this.codeGen.paramArrayName)) {
            atFieldAssign(expr, op, left, right);
            return;
        }
        right.accept(this);
        CtClass[] params = this.codeGen.paramTypeList;
        if (params != null) {
            for (CtClass ctClass : params) {
                compileUnwrapValue(ctClass);
            }
        }
    }

    @Override // javassist.compiler.TypeChecker, javassist.compiler.ast.Visitor
    public void atCastExpr(CastExpr expr) throws CompileError {
        ASTList classname = expr.getClassName();
        if (classname != null && expr.getArrayDim() == 0) {
            ASTree p = classname.head();
            if ((p instanceof Symbol) && classname.tail() == null) {
                String typename = ((Symbol) p).get();
                if (typename.equals(this.codeGen.returnCastName)) {
                    atCastToRtype(expr);
                    return;
                } else if (typename.equals(JvstCodeGen.wrapperCastName)) {
                    atCastToWrapper(expr);
                    return;
                }
            }
        }
        atCastExpr(expr);
    }

    protected void atCastToRtype(CastExpr expr) throws CompileError {
        CtClass returnType = this.codeGen.returnType;
        expr.getOprand().accept(this);
        if (this.exprType == 344 || CodeGen.isRefType(this.exprType) || this.arrayDim > 0) {
            compileUnwrapValue(returnType);
        } else if (returnType instanceof CtPrimitiveType) {
            this.exprType = MemberResolver.descToType(((CtPrimitiveType) returnType).getDescriptor());
            this.arrayDim = 0;
            this.className = null;
        }
    }

    protected void atCastToWrapper(CastExpr expr) throws CompileError {
        expr.getOprand().accept(this);
        if (!CodeGen.isRefType(this.exprType) && this.arrayDim <= 0 && (this.resolver.lookupClass(this.exprType, this.arrayDim, this.className) instanceof CtPrimitiveType)) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME;
        }
    }

    @Override // javassist.compiler.TypeChecker, javassist.compiler.ast.Visitor
    public void atCallExpr(CallExpr expr) throws CompileError {
        ASTree method = expr.oprand1();
        if (method instanceof Member) {
            String name = ((Member) method).get();
            if (this.codeGen.procHandler != null && name.equals(this.codeGen.proceedName)) {
                this.codeGen.procHandler.setReturnType(this, (ASTList) expr.oprand2());
                return;
            } else if (name.equals(JvstCodeGen.cflowName)) {
                atCflow((ASTList) expr.oprand2());
                return;
            }
        }
        atCallExpr(expr);
    }

    protected void atCflow(ASTList cname) throws CompileError {
        this.exprType = 324;
        this.arrayDim = 0;
        this.className = null;
    }

    public boolean isParamListName(ASTList args) {
        if (this.codeGen.paramTypeList == null || args == null || args.tail() != null) {
            return false;
        }
        ASTree left = args.head();
        return (left instanceof Member) && ((Member) left).get().equals(this.codeGen.paramListName);
    }

    @Override // javassist.compiler.TypeChecker
    public int getMethodArgsLength(ASTList args) {
        String pname = this.codeGen.paramListName;
        int n = 0;
        while (args != null) {
            ASTree a = args.head();
            if (!(a instanceof Member) || !((Member) a).get().equals(pname)) {
                n++;
            } else if (this.codeGen.paramTypeList != null) {
                n += this.codeGen.paramTypeList.length;
            }
            args = args.tail();
        }
        return n;
    }

    @Override // javassist.compiler.TypeChecker
    public void atMethodArgs(ASTList args, int[] types, int[] dims, String[] cnames) throws CompileError {
        CtClass[] params = this.codeGen.paramTypeList;
        String pname = this.codeGen.paramListName;
        int i = 0;
        while (args != null) {
            ASTree a = args.head();
            if (!(a instanceof Member) || !((Member) a).get().equals(pname)) {
                a.accept(this);
                types[i] = this.exprType;
                dims[i] = this.arrayDim;
                cnames[i] = this.className;
                i++;
            } else if (params != null) {
                for (CtClass p : params) {
                    setType(p);
                    types[i] = this.exprType;
                    dims[i] = this.arrayDim;
                    cnames[i] = this.className;
                    i++;
                }
            }
            args = args.tail();
        }
    }

    /* access modifiers changed from: package-private */
    public void compileInvokeSpecial(ASTree target, String classname, String methodname, String descriptor, ASTList args) throws CompileError {
        target.accept(this);
        int nargs = getMethodArgsLength(args);
        atMethodArgs(args, new int[nargs], new int[nargs], new String[nargs]);
        setReturnType(descriptor);
        addNullIfVoid();
    }

    protected void compileUnwrapValue(CtClass type) throws CompileError {
        if (type == CtClass.voidType) {
            addNullIfVoid();
        } else {
            setType(type);
        }
    }

    public void setType(CtClass type) throws CompileError {
        setType(type, 0);
    }

    private void setType(CtClass type, int dim) throws CompileError {
        if (type.isPrimitive()) {
            this.exprType = MemberResolver.descToType(((CtPrimitiveType) type).getDescriptor());
            this.arrayDim = dim;
            this.className = null;
        } else if (type.isArray()) {
            try {
                setType(type.getComponentType(), dim + 1);
            } catch (NotFoundException e) {
                throw new CompileError("undefined type: " + type.getName());
            }
        } else {
            this.exprType = 307;
            this.arrayDim = dim;
            this.className = MemberResolver.javaToJvmName(type.getName());
        }
    }
}