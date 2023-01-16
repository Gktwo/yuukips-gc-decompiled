package javassist.convert;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;

/* loaded from: grasscutter.jar:javassist/convert/TransformCall.class */
public class TransformCall extends Transformer {
    protected String classname;
    protected String methodname;
    protected String methodDescriptor;
    protected String newClassname;
    protected String newMethodname;
    protected boolean newMethodIsPrivate;
    protected int newIndex;
    protected ConstPool constPool;

    public TransformCall(Transformer next, CtMethod origMethod, CtMethod substMethod) {
        this(next, origMethod.getName(), substMethod);
        this.classname = origMethod.getDeclaringClass().getName();
    }

    public TransformCall(Transformer next, String oldMethodName, CtMethod substMethod) {
        super(next);
        this.methodname = oldMethodName;
        this.methodDescriptor = substMethod.getMethodInfo2().getDescriptor();
        String name = substMethod.getDeclaringClass().getName();
        this.newClassname = name;
        this.classname = name;
        this.newMethodname = substMethod.getName();
        this.constPool = null;
        this.newMethodIsPrivate = Modifier.isPrivate(substMethod.getModifiers());
    }

    @Override // javassist.convert.Transformer
    public void initialize(ConstPool cp, CodeAttribute attr) {
        if (this.constPool != cp) {
            this.newIndex = 0;
        }
    }

    @Override // javassist.convert.Transformer
    public int transform(CtClass clazz, int pos, CodeIterator iterator, ConstPool cp) throws BadBytecode {
        int index;
        String cname;
        int c = iterator.byteAt(pos);
        if ((c == 185 || c == 183 || c == 184 || c == 182) && (cname = cp.eqMember(this.methodname, this.methodDescriptor, (index = iterator.u16bitAt(pos + 1)))) != null && matchClass(cname, clazz.getClassPool())) {
            pos = match(c, pos, iterator, cp.getNameAndTypeDescriptor(cp.getMemberNameAndType(index)), cp);
        }
        return pos;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0044
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private boolean matchClass(java.lang.String r5, javassist.ClassPool r6) {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r0 = r0.classname
            r1 = r5
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            r0 = 1
            return r0
        L_0x000d:
            r0 = r6
            r1 = r5
            javassist.CtClass r0 = r0.get(r1)     // Catch: NotFoundException -> 0x004b
            r7 = r0
            r0 = r6
            r1 = r4
            java.lang.String r1 = r1.classname     // Catch: NotFoundException -> 0x004b
            javassist.CtClass r0 = r0.get(r1)     // Catch: NotFoundException -> 0x004b
            r8 = r0
            r0 = r7
            r1 = r8
            boolean r0 = r0.subtypeOf(r1)     // Catch: NotFoundException -> 0x004b
            if (r0 == 0) goto L_0x0048
            r0 = r7
            r1 = r4
            java.lang.String r1 = r1.methodname     // Catch: NotFoundException -> 0x004b, NotFoundException -> 0x0044
            r2 = r4
            java.lang.String r2 = r2.methodDescriptor     // Catch: NotFoundException -> 0x004b, NotFoundException -> 0x0044
            javassist.CtMethod r0 = r0.getMethod(r1, r2)     // Catch: NotFoundException -> 0x004b, NotFoundException -> 0x0044
            r9 = r0
            r0 = r9
            javassist.CtClass r0 = r0.getDeclaringClass()     // Catch: NotFoundException -> 0x004b, NotFoundException -> 0x0044
            java.lang.String r0 = r0.getName()     // Catch: NotFoundException -> 0x004b, NotFoundException -> 0x0044
            r1 = r4
            java.lang.String r1 = r1.classname     // Catch: NotFoundException -> 0x004b, NotFoundException -> 0x0044
            boolean r0 = r0.equals(r1)     // Catch: NotFoundException -> 0x004b, NotFoundException -> 0x0044
            return r0
        L_0x0044:
            r9 = move-exception
            r0 = 1
            return r0
        L_0x0048:
            goto L_0x004e
        L_0x004b:
            r7 = move-exception
            r0 = 0
            return r0
        L_0x004e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.convert.TransformCall.matchClass(java.lang.String, javassist.ClassPool):boolean");
    }

    protected int match(int c, int pos, CodeIterator iterator, int typedesc, ConstPool cp) throws BadBytecode {
        if (this.newIndex == 0) {
            int nt = cp.addNameAndTypeInfo(cp.addUtf8Info(this.newMethodname), typedesc);
            int ci = cp.addClassInfo(this.newClassname);
            if (c == 185) {
                this.newIndex = cp.addInterfaceMethodrefInfo(ci, nt);
            } else {
                if (this.newMethodIsPrivate && c == 182) {
                    iterator.writeByte(183, pos);
                }
                this.newIndex = cp.addMethodrefInfo(ci, nt);
            }
            this.constPool = cp;
        }
        iterator.write16bit(this.newIndex, pos + 1);
        return pos;
    }
}
