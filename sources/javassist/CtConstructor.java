package javassist;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

/* loaded from: grasscutter.jar:javassist/CtConstructor.class */
public final class CtConstructor extends CtBehavior {
    /* access modifiers changed from: protected */
    public CtConstructor(MethodInfo minfo, CtClass declaring) {
        super(declaring, minfo);
    }

    public CtConstructor(CtClass[] parameters, CtClass declaring) {
        this((MethodInfo) null, declaring);
        this.methodInfo = new MethodInfo(declaring.getClassFile2().getConstPool(), "<init>", Descriptor.ofConstructor(parameters));
        setModifiers(1);
    }

    public CtConstructor(CtConstructor src, CtClass declaring, ClassMap map) throws CannotCompileException {
        this((MethodInfo) null, declaring);
        copy(src, true, map);
    }

    public boolean isConstructor() {
        return this.methodInfo.isConstructor();
    }

    public boolean isClassInitializer() {
        return this.methodInfo.isStaticInitializer();
    }

    @Override // javassist.CtBehavior
    public String getLongName() {
        return getDeclaringClass().getName() + (isConstructor() ? Descriptor.toString(getSignature()) : ".<clinit>()");
    }

    @Override // javassist.CtMember
    public String getName() {
        if (this.methodInfo.isStaticInitializer()) {
            return "<clinit>";
        }
        return this.declaringClass.getSimpleName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        if (r0.hasNext() == false) goto L_0x007b;
     */
    @Override // javassist.CtBehavior
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r6 = this;
            r0 = r6
            javassist.bytecode.MethodInfo r0 = r0.getMethodInfo2()
            javassist.bytecode.CodeAttribute r0 = r0.getCodeAttribute()
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L_0x000e
            r0 = 0
            return r0
        L_0x000e:
            r0 = r7
            javassist.bytecode.ConstPool r0 = r0.getConstPool()
            r8 = r0
            r0 = r7
            javassist.bytecode.CodeIterator r0 = r0.iterator()
            r9 = r0
            r0 = r9
            r1 = r9
            int r1 = r1.next()     // Catch: BadBytecode -> 0x0081
            int r0 = r0.byteAt(r1)     // Catch: BadBytecode -> 0x0081
            r12 = r0
            r0 = r12
            r1 = 177(0xb1, float:2.48E-43)
            if (r0 == r1) goto L_0x007b
            r0 = r12
            r1 = 42
            if (r0 != r1) goto L_0x007f
            r0 = r9
            r1 = r9
            int r1 = r1.next()     // Catch: BadBytecode -> 0x0081
            r2 = r1
            r10 = r2
            int r0 = r0.byteAt(r1)     // Catch: BadBytecode -> 0x0081
            r1 = 183(0xb7, float:2.56E-43)
            if (r0 != r1) goto L_0x007f
            r0 = r8
            r1 = r6
            java.lang.String r1 = r1.getSuperclassName()     // Catch: BadBytecode -> 0x0081
            r2 = r9
            r3 = r10
            r4 = 1
            int r3 = r3 + r4
            int r2 = r2.u16bitAt(r3)     // Catch: BadBytecode -> 0x0081
            int r0 = r0.isConstructor(r1, r2)     // Catch: BadBytecode -> 0x0081
            r1 = r0
            r11 = r1
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = "()V"
            r1 = r8
            r2 = r11
            java.lang.String r1 = r1.getUtf8Info(r2)     // Catch: BadBytecode -> 0x0081
            boolean r0 = r0.equals(r1)     // Catch: BadBytecode -> 0x0081
            if (r0 == 0) goto L_0x007f
            r0 = r9
            r1 = r9
            int r1 = r1.next()     // Catch: BadBytecode -> 0x0081
            int r0 = r0.byteAt(r1)     // Catch: BadBytecode -> 0x0081
            r1 = 177(0xb1, float:2.48E-43)
            if (r0 != r1) goto L_0x007f
            r0 = r9
            boolean r0 = r0.hasNext()     // Catch: BadBytecode -> 0x0081
            if (r0 != 0) goto L_0x007f
        L_0x007b:
            r0 = 1
            goto L_0x0080
        L_0x007f:
            r0 = 0
        L_0x0080:
            return r0
        L_0x0081:
            r10 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.CtConstructor.isEmpty():boolean");
    }

    private String getSuperclassName() {
        return this.declaringClass.getClassFile2().getSuperclass();
    }

    public boolean callsSuper() throws CannotCompileException {
        CodeAttribute codeAttr = this.methodInfo.getCodeAttribute();
        if (codeAttr == null) {
            return false;
        }
        try {
            return codeAttr.iterator().skipSuperConstructor() >= 0;
        } catch (BadBytecode e) {
            throw new CannotCompileException(e);
        }
    }

    @Override // javassist.CtBehavior
    public void setBody(String src) throws CannotCompileException {
        if (src == null) {
            if (isClassInitializer()) {
                src = ";";
            } else {
                src = "super();";
            }
        }
        setBody(src);
    }

    public void setBody(CtConstructor src, ClassMap map) throws CannotCompileException {
        setBody0(src.declaringClass, src.methodInfo, this.declaringClass, this.methodInfo, map);
    }

    public void insertBeforeBody(String src) throws CannotCompileException {
        CtClass cc = this.declaringClass;
        cc.checkModify();
        if (isClassInitializer()) {
            throw new CannotCompileException("class initializer");
        }
        CodeAttribute ca = this.methodInfo.getCodeAttribute();
        CodeIterator iterator = ca.iterator();
        Bytecode b = new Bytecode(this.methodInfo.getConstPool(), ca.getMaxStack(), ca.getMaxLocals());
        b.setStackDepth(ca.getMaxStack());
        Javac jv = new Javac(b, cc);
        try {
            jv.recordParams(getParameterTypes(), false);
            jv.compileStmnt(src);
            ca.setMaxStack(b.getMaxStack());
            ca.setMaxLocals(b.getMaxLocals());
            iterator.skipConstructor();
            iterator.insert(b.getExceptionTable(), iterator.insertEx(b.get()));
            this.methodInfo.rebuildStackMapIf6(cc.getClassPool(), cc.getClassFile2());
        } catch (NotFoundException e) {
            throw new CannotCompileException(e);
        } catch (BadBytecode e2) {
            throw new CannotCompileException(e2);
        } catch (CompileError e3) {
            throw new CannotCompileException(e3);
        }
    }

    @Override // javassist.CtBehavior
    int getStartPosOfBody(CodeAttribute ca) throws CannotCompileException {
        CodeIterator ci = ca.iterator();
        try {
            ci.skipConstructor();
            return ci.next();
        } catch (BadBytecode e) {
            throw new CannotCompileException(e);
        }
    }

    public CtMethod toMethod(String name, CtClass declaring) throws CannotCompileException {
        return toMethod(name, declaring, null);
    }

    public CtMethod toMethod(String name, CtClass declaring, ClassMap map) throws CannotCompileException {
        CodeAttribute ca;
        CtMethod method = new CtMethod(null, declaring);
        method.copy(this, false, map);
        if (isConstructor() && (ca = method.getMethodInfo2().getCodeAttribute()) != null) {
            removeConsCall(ca);
            try {
                this.methodInfo.rebuildStackMapIf6(declaring.getClassPool(), declaring.getClassFile2());
            } catch (BadBytecode e) {
                throw new CannotCompileException(e);
            }
        }
        method.setName(name);
        return method;
    }

    private static void removeConsCall(CodeAttribute ca) throws CannotCompileException {
        CodeIterator iterator = ca.iterator();
        try {
            int pos = iterator.skipConstructor();
            if (pos >= 0) {
                String desc = ca.getConstPool().getMethodrefType(iterator.u16bitAt(pos + 1));
                int num = Descriptor.numOfParameters(desc) + 1;
                if (num > 3) {
                    pos = iterator.insertGapAt(pos, num - 3, false).position;
                }
                int pos2 = pos + 1;
                iterator.writeByte(87, pos);
                iterator.writeByte(0, pos2);
                iterator.writeByte(0, pos2 + 1);
                Descriptor.Iterator it = new Descriptor.Iterator(desc);
                while (true) {
                    it.next();
                    if (!it.isParameter()) {
                        break;
                    }
                    pos2++;
                    iterator.writeByte(it.is2byte() ? 88 : 87, pos2);
                }
            }
        } catch (BadBytecode e) {
            throw new CannotCompileException(e);
        }
    }
}
