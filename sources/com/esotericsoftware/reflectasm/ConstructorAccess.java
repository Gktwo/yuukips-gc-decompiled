package com.esotericsoftware.reflectasm;

import com.esotericsoftware.asm.ClassWriter;
import com.esotericsoftware.asm.MethodVisitor;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* loaded from: grasscutter.jar:com/esotericsoftware/reflectasm/ConstructorAccess.class */
public abstract class ConstructorAccess<T> {
    boolean isNonStaticMemberClass;

    public abstract T newInstance();

    public abstract T newInstance(Object obj);

    public boolean isNonStaticMemberClass() {
        return this.isNonStaticMemberClass;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:21:0x00aa
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static <T> com.esotericsoftware.reflectasm.ConstructorAccess<T> get(java.lang.Class<T> r8) {
        /*
        // Method dump skipped, instructions count: 559
        */
        throw new UnsupportedOperationException("Method not decompiled: com.esotericsoftware.reflectasm.ConstructorAccess.get(java.lang.Class):com.esotericsoftware.reflectasm.ConstructorAccess");
    }

    private static void insertConstructor(ClassWriter cw, String superclassNameInternal) {
        MethodVisitor mv = cw.visitMethod(1, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(25, 0);
        mv.visitMethodInsn(183, superclassNameInternal, "<init>", "()V");
        mv.visitInsn(177);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }

    static void insertNewInstance(ClassWriter cw, String classNameInternal) {
        MethodVisitor mv = cw.visitMethod(1, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, "()Ljava/lang/Object;", null, null);
        mv.visitCode();
        mv.visitTypeInsn(187, classNameInternal);
        mv.visitInsn(89);
        mv.visitMethodInsn(183, classNameInternal, "<init>", "()V");
        mv.visitInsn(176);
        mv.visitMaxs(2, 1);
        mv.visitEnd();
    }

    static void insertNewInstanceInner(ClassWriter cw, String classNameInternal, String enclosingClassNameInternal) {
        MethodVisitor mv = cw.visitMethod(1, TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        mv.visitCode();
        if (enclosingClassNameInternal != null) {
            mv.visitTypeInsn(187, classNameInternal);
            mv.visitInsn(89);
            mv.visitVarInsn(25, 1);
            mv.visitTypeInsn(192, enclosingClassNameInternal);
            mv.visitInsn(89);
            mv.visitMethodInsn(182, TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME, "getClass", "()Ljava/lang/Class;");
            mv.visitInsn(87);
            mv.visitMethodInsn(183, classNameInternal, "<init>", "(L" + enclosingClassNameInternal + ";)V");
            mv.visitInsn(176);
            mv.visitMaxs(4, 2);
        } else {
            mv.visitTypeInsn(187, "java/lang/UnsupportedOperationException");
            mv.visitInsn(89);
            mv.visitLdcInsn("Not an inner class.");
            mv.visitMethodInsn(183, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
            mv.visitInsn(191);
            mv.visitMaxs(3, 2);
        }
        mv.visitEnd();
    }
}
