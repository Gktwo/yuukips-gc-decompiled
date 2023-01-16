package javassist.expr;

import java.util.List;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtPrimitiveType;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Opcode;
import javassist.compiler.Javac;
import javassist.expr.ExprEditor;

/* loaded from: grasscutter.jar:javassist/expr/Expr.class */
public abstract class Expr implements Opcode {
    int currentPos;
    CodeIterator iterator;
    CtClass thisClass;
    MethodInfo thisMethod;
    boolean edited;
    int maxLocals;
    int maxStack;
    static final String javaLangObject = "java.lang.Object";

    public abstract void replace(String str) throws CannotCompileException;

    /* access modifiers changed from: protected */
    public Expr(int pos, CodeIterator i, CtClass declaring, MethodInfo m) {
        this.currentPos = pos;
        this.iterator = i;
        this.thisClass = declaring;
        this.thisMethod = m;
    }

    public CtClass getEnclosingClass() {
        return this.thisClass;
    }

    protected final ConstPool getConstPool() {
        return this.thisMethod.getConstPool();
    }

    /* access modifiers changed from: protected */
    public final boolean edited() {
        return this.edited;
    }

    /* access modifiers changed from: protected */
    public final int locals() {
        return this.maxLocals;
    }

    /* access modifiers changed from: protected */
    public final int stack() {
        return this.maxStack;
    }

    protected final boolean withinStatic() {
        return (this.thisMethod.getAccessFlags() & 8) != 0;
    }

    public CtBehavior where() {
        MethodInfo mi = this.thisMethod;
        CtBehavior[] cb = this.thisClass.getDeclaredBehaviors();
        for (int i = cb.length - 1; i >= 0; i--) {
            if (cb[i].getMethodInfo2() == mi) {
                return cb[i];
            }
        }
        CtConstructor init = this.thisClass.getClassInitializer();
        if (init != null && init.getMethodInfo2() == mi) {
            return init;
        }
        for (int i2 = cb.length - 1; i2 >= 0; i2--) {
            if (this.thisMethod.getName().equals(cb[i2].getMethodInfo2().getName()) && this.thisMethod.getDescriptor().equals(cb[i2].getMethodInfo2().getDescriptor())) {
                return cb[i2];
            }
        }
        throw new RuntimeException("fatal: not found");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0076
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public javassist.CtClass[] mayThrow() {
        /*
            r5 = this;
            r0 = r5
            javassist.CtClass r0 = r0.thisClass
            javassist.ClassPool r0 = r0.getClassPool()
            r6 = r0
            r0 = r5
            javassist.bytecode.MethodInfo r0 = r0.thisMethod
            javassist.bytecode.ConstPool r0 = r0.getConstPool()
            r7 = r0
            java.util.LinkedList r0 = new java.util.LinkedList
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r5
            javassist.bytecode.MethodInfo r0 = r0.thisMethod     // Catch: NullPointerException -> 0x0081
            javassist.bytecode.CodeAttribute r0 = r0.getCodeAttribute()     // Catch: NullPointerException -> 0x0081
            r9 = r0
            r0 = r9
            javassist.bytecode.ExceptionTable r0 = r0.getExceptionTable()     // Catch: NullPointerException -> 0x0081
            r10 = r0
            r0 = r5
            int r0 = r0.currentPos     // Catch: NullPointerException -> 0x0081
            r11 = r0
            r0 = r10
            int r0 = r0.size()     // Catch: NullPointerException -> 0x0081
            r12 = r0
            r0 = 0
            r13 = r0
        L_0x0038:
            r0 = r13
            r1 = r12
            if (r0 >= r1) goto L_0x007e
            r0 = r10
            r1 = r13
            int r0 = r0.startPc(r1)     // Catch: NullPointerException -> 0x0081
            r1 = r11
            if (r0 > r1) goto L_0x0078
            r0 = r11
            r1 = r10
            r2 = r13
            int r1 = r1.endPc(r2)     // Catch: NullPointerException -> 0x0081
            if (r0 >= r1) goto L_0x0078
            r0 = r10
            r1 = r13
            int r0 = r0.catchType(r1)     // Catch: NullPointerException -> 0x0081
            r14 = r0
            r0 = r14
            if (r0 <= 0) goto L_0x0078
            r0 = r8
            r1 = r6
            r2 = r7
            r3 = r14
            java.lang.String r2 = r2.getClassInfo(r3)     // Catch: NullPointerException -> 0x0081, NotFoundException -> 0x0076
            javassist.CtClass r1 = r1.get(r2)     // Catch: NullPointerException -> 0x0081, NotFoundException -> 0x0076
            addClass(r0, r1)     // Catch: NullPointerException -> 0x0081, NotFoundException -> 0x0076
            goto L_0x0078
        L_0x0076:
            r15 = move-exception
        L_0x0078:
            int r13 = r13 + 1
            goto L_0x0038
        L_0x007e:
            goto L_0x0083
        L_0x0081:
            r9 = move-exception
        L_0x0083:
            r0 = r5
            javassist.bytecode.MethodInfo r0 = r0.thisMethod
            javassist.bytecode.ExceptionsAttribute r0 = r0.getExceptionsAttribute()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L_0x00c4
            r0 = r9
            java.lang.String[] r0 = r0.getExceptions()
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L_0x00c4
            r0 = r10
            int r0 = r0.length
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x00a5:
            r0 = r12
            r1 = r11
            if (r0 >= r1) goto L_0x00c4
            r0 = r8
            r1 = r6
            r2 = r10
            r3 = r12
            r2 = r2[r3]     // Catch: NotFoundException -> 0x00bc
            javassist.CtClass r1 = r1.get(r2)     // Catch: NotFoundException -> 0x00bc
            addClass(r0, r1)     // Catch: NotFoundException -> 0x00bc
            goto L_0x00be
        L_0x00bc:
            r13 = move-exception
        L_0x00be:
            int r12 = r12 + 1
            goto L_0x00a5
        L_0x00c4:
            r0 = r8
            r1 = r8
            int r1 = r1.size()
            javassist.CtClass[] r1 = new javassist.CtClass[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            javassist.CtClass[] r0 = (javassist.CtClass[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.expr.Expr.mayThrow():javassist.CtClass[]");
    }

    private static void addClass(List<CtClass> list, CtClass c) {
        if (!list.contains(c)) {
            list.add(c);
        }
    }

    public int indexOfBytecode() {
        return this.currentPos;
    }

    public int getLineNumber() {
        return this.thisMethod.getLineNumber(this.currentPos);
    }

    public String getFileName() {
        ClassFile cf = this.thisClass.getClassFile2();
        if (cf == null) {
            return null;
        }
        return cf.getSourceFile();
    }

    static final boolean checkResultValue(CtClass retType, String prog) throws CannotCompileException {
        boolean hasIt = prog.indexOf(Javac.resultVarName) >= 0;
        if (hasIt || retType == CtClass.voidType) {
            return hasIt;
        }
        throw new CannotCompileException("the resulting value is not stored in $_");
    }

    static final void storeStack(CtClass[] params, boolean isStaticCall, int regno, Bytecode bytecode) {
        storeStack0(0, params.length, params, regno + 1, bytecode);
        if (isStaticCall) {
            bytecode.addOpcode(1);
        }
        bytecode.addAstore(regno);
    }

    private static void storeStack0(int i, int n, CtClass[] params, int regno, Bytecode bytecode) {
        int size;
        if (i < n) {
            CtClass c = params[i];
            if (c instanceof CtPrimitiveType) {
                size = ((CtPrimitiveType) c).getDataSize();
            } else {
                size = 1;
            }
            storeStack0(i + 1, n, params, regno + size, bytecode);
            bytecode.addStore(regno, c);
        }
    }

    public void replace(String statement, ExprEditor recursive) throws CannotCompileException {
        replace(statement);
        if (recursive != null) {
            runEditor(recursive, this.iterator);
        }
    }

    protected void replace0(int pos, Bytecode bytecode, int size) throws BadBytecode {
        byte[] code = bytecode.get();
        this.edited = true;
        int gap = code.length - size;
        for (int i = 0; i < size; i++) {
            this.iterator.writeByte(0, pos + i);
        }
        if (gap > 0) {
            pos = this.iterator.insertGapAt(pos, gap, false).position;
        }
        this.iterator.write(code, pos);
        this.iterator.insert(bytecode.getExceptionTable(), pos);
        this.maxLocals = bytecode.getMaxLocals();
        this.maxStack = bytecode.getMaxStack();
    }

    protected void runEditor(ExprEditor ed, CodeIterator oldIterator) throws CannotCompileException {
        CodeAttribute codeAttr = oldIterator.get();
        int orgLocals = codeAttr.getMaxLocals();
        int orgStack = codeAttr.getMaxStack();
        int newLocals = locals();
        codeAttr.setMaxStack(stack());
        codeAttr.setMaxLocals(newLocals);
        ExprEditor.LoopContext context = new ExprEditor.LoopContext(newLocals);
        int size = oldIterator.getCodeLength();
        int endPos = oldIterator.lookAhead();
        oldIterator.move(this.currentPos);
        if (ed.doit(this.thisClass, this.thisMethod, context, oldIterator, endPos)) {
            this.edited = true;
        }
        oldIterator.move((endPos + oldIterator.getCodeLength()) - size);
        codeAttr.setMaxLocals(orgLocals);
        codeAttr.setMaxStack(orgStack);
        this.maxLocals = context.maxLocals;
        this.maxStack += context.maxStack;
    }
}
