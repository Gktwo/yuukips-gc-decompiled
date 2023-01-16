package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.TypePath;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/commons/MethodRemapper.class */
public class MethodRemapper extends MethodVisitor {
    protected final Remapper remapper;

    public MethodRemapper(MethodVisitor methodVisitor, Remapper remapper) {
        this(Opcodes.ASM9, methodVisitor, remapper);
    }

    /* access modifiers changed from: protected */
    public MethodRemapper(int api, MethodVisitor methodVisitor, Remapper remapper) {
        super(api, methodVisitor);
        this.remapper = remapper;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitAnnotationDefault() {
        AnnotationVisitor annotationVisitor = visitAnnotationDefault();
        if (annotationVisitor == null) {
            return annotationVisitor;
        }
        return createAnnotationRemapper(null, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitAnnotation(this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return annotationVisitor;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return annotationVisitor;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitParameterAnnotation(int parameter, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitParameterAnnotation(parameter, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return annotationVisitor;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        visitFrame(type, numLocal, remapFrameTypes(numLocal, local), numStack, remapFrameTypes(numStack, stack));
    }

    private Object[] remapFrameTypes(int numTypes, Object[] frameTypes) {
        if (frameTypes == null) {
            return frameTypes;
        }
        Object[] remappedFrameTypes = null;
        for (int i = 0; i < numTypes; i++) {
            if (frameTypes[i] instanceof String) {
                if (remappedFrameTypes == null) {
                    remappedFrameTypes = new Object[numTypes];
                    System.arraycopy(frameTypes, 0, remappedFrameTypes, 0, numTypes);
                }
                remappedFrameTypes[i] = this.remapper.mapType((String) frameTypes[i]);
            }
        }
        return remappedFrameTypes == null ? frameTypes : remappedFrameTypes;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        visitFieldInsn(opcode, this.remapper.mapType(owner), this.remapper.mapFieldName(owner, name, descriptor), this.remapper.mapDesc(descriptor));
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMethodInsn(int opcodeAndSource, String owner, String name, String descriptor, boolean isInterface) {
        if (this.api >= 327680 || (opcodeAndSource & 256) != 0) {
            visitMethodInsn(opcodeAndSource, this.remapper.mapType(owner), this.remapper.mapMethodName(owner, name, descriptor), this.remapper.mapMethodDesc(descriptor), isInterface);
        } else {
            visitMethodInsn(opcodeAndSource, owner, name, descriptor, isInterface);
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        Object[] remappedBootstrapMethodArguments = new Object[bootstrapMethodArguments.length];
        for (int i = 0; i < bootstrapMethodArguments.length; i++) {
            remappedBootstrapMethodArguments[i] = this.remapper.mapValue(bootstrapMethodArguments[i]);
        }
        visitInvokeDynamicInsn(this.remapper.mapInvokeDynamicMethodName(name, descriptor), this.remapper.mapMethodDesc(descriptor), (Handle) this.remapper.mapValue(bootstrapMethodHandle), remappedBootstrapMethodArguments);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTypeInsn(int opcode, String type) {
        visitTypeInsn(opcode, this.remapper.mapType(type));
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLdcInsn(Object value) {
        visitLdcInsn(this.remapper.mapValue(value));
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        visitMultiANewArrayInsn(this.remapper.mapDesc(descriptor), numDimensions);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitInsnAnnotation(typeRef, typePath, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return annotationVisitor;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        visitTryCatchBlock(start, end, handler, type == null ? null : this.remapper.mapType(type));
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitTryCatchAnnotation(typeRef, typePath, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return annotationVisitor;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        visitLocalVariable(name, this.remapper.mapDesc(descriptor), this.remapper.mapSignature(signature, true), start, end, index);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitLocalVariableAnnotation(typeRef, typePath, start, end, index, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return annotationVisitor;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Deprecated
    protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, null, annotationVisitor, this.remapper);
    }

    protected AnnotationVisitor createAnnotationRemapper(String descriptor, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, descriptor, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }
}
