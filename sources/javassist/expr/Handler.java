package javassist.expr;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

/* loaded from: grasscutter.jar:javassist/expr/Handler.class */
public class Handler extends Expr {
    private static String EXCEPTION_NAME = "$1";
    private ExceptionTable etable;
    private int index;

    /* access modifiers changed from: protected */
    public Handler(ExceptionTable et, int nth, CodeIterator it, CtClass declaring, MethodInfo m) {
        super(et.handlerPc(nth), it, declaring, m);
        this.etable = et;
        this.index = nth;
    }

    @Override // javassist.expr.Expr
    public CtBehavior where() {
        return where();
    }

    @Override // javassist.expr.Expr
    public int getLineNumber() {
        return getLineNumber();
    }

    @Override // javassist.expr.Expr
    public String getFileName() {
        return getFileName();
    }

    @Override // javassist.expr.Expr
    public CtClass[] mayThrow() {
        return mayThrow();
    }

    public CtClass getType() throws NotFoundException {
        int type = this.etable.catchType(this.index);
        if (type == 0) {
            return null;
        }
        return this.thisClass.getClassPool().getCtClass(getConstPool().getClassInfo(type));
    }

    public boolean isFinally() {
        return this.etable.catchType(this.index) == 0;
    }

    @Override // javassist.expr.Expr
    public void replace(String statement) throws CannotCompileException {
        throw new RuntimeException("not implemented yet");
    }

    public void insertBefore(String src) throws CannotCompileException {
        this.edited = true;
        getConstPool();
        CodeAttribute ca = this.iterator.get();
        Javac jv = new Javac(this.thisClass);
        Bytecode b = jv.getBytecode();
        b.setStackDepth(1);
        b.setMaxLocals(ca.getMaxLocals());
        try {
            CtClass type = getType();
            int var = jv.recordVariable(type, EXCEPTION_NAME);
            jv.recordReturnType(type, false);
            b.addAstore(var);
            jv.compileStmnt(src);
            b.addAload(var);
            int oldHandler = this.etable.handlerPc(this.index);
            b.addOpcode(167);
            b.addIndex(((oldHandler - this.iterator.getCodeLength()) - b.currentPc()) + 1);
            this.maxStack = b.getMaxStack();
            this.maxLocals = b.getMaxLocals();
            int pos = this.iterator.append(b.get());
            this.iterator.append(b.getExceptionTable(), pos);
            this.etable.setHandlerPc(this.index, pos);
        } catch (NotFoundException e) {
            throw new CannotCompileException(e);
        } catch (CompileError e2) {
            throw new CannotCompileException(e2);
        }
    }
}
