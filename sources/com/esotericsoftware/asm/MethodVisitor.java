package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/MethodVisitor.class */
public abstract class MethodVisitor {
    protected final int api;

    /* renamed from: mv */
    protected MethodVisitor f155mv;

    public MethodVisitor(int i) {
        this(i, null);
    }

    public MethodVisitor(int i, MethodVisitor methodVisitor) {
        if (i == 262144 || i == 327680) {
            this.api = i;
            this.f155mv = methodVisitor;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void visitParameter(String str, int i) {
        if (this.api < 327680) {
            throw new RuntimeException();
        } else if (this.f155mv != null) {
            this.f155mv.visitParameter(str, i);
        }
    }

    public AnnotationVisitor visitAnnotationDefault() {
        if (this.f155mv != null) {
            return this.f155mv.visitAnnotationDefault();
        }
        return null;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        if (this.f155mv != null) {
            return this.f155mv.visitAnnotation(str, z);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        if (this.api < 327680) {
            throw new RuntimeException();
        } else if (this.f155mv != null) {
            return this.f155mv.visitTypeAnnotation(i, typePath, str, z);
        } else {
            return null;
        }
    }

    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        if (this.f155mv != null) {
            return this.f155mv.visitParameterAnnotation(i, str, z);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f155mv != null) {
            this.f155mv.visitAttribute(attribute);
        }
    }

    public void visitCode() {
        if (this.f155mv != null) {
            this.f155mv.visitCode();
        }
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        if (this.f155mv != null) {
            this.f155mv.visitFrame(i, i2, objArr, i3, objArr2);
        }
    }

    public void visitInsn(int i) {
        if (this.f155mv != null) {
            this.f155mv.visitInsn(i);
        }
    }

    public void visitIntInsn(int i, int i2) {
        if (this.f155mv != null) {
            this.f155mv.visitIntInsn(i, i2);
        }
    }

    public void visitVarInsn(int i, int i2) {
        if (this.f155mv != null) {
            this.f155mv.visitVarInsn(i, i2);
        }
    }

    public void visitTypeInsn(int i, String str) {
        if (this.f155mv != null) {
            this.f155mv.visitTypeInsn(i, str);
        }
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        if (this.f155mv != null) {
            this.f155mv.visitFieldInsn(i, str, str2, str3);
        }
    }

    public void visitMethodInsn(int i, String str, String str2, String str3) {
        if (this.api >= 327680) {
            visitMethodInsn(i, str, str2, str3, i == 185);
        } else if (this.f155mv != null) {
            this.f155mv.visitMethodInsn(i, str, str2, str3);
        }
    }

    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        if (this.api < 327680) {
            if (z != (i == 185)) {
                throw new IllegalArgumentException("INVOKESPECIAL/STATIC on interfaces require ASM 5");
            }
            visitMethodInsn(i, str, str2, str3);
        } else if (this.f155mv != null) {
            this.f155mv.visitMethodInsn(i, str, str2, str3, z);
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        if (this.f155mv != null) {
            this.f155mv.visitInvokeDynamicInsn(str, str2, handle, objArr);
        }
    }

    public void visitJumpInsn(int i, Label label) {
        if (this.f155mv != null) {
            this.f155mv.visitJumpInsn(i, label);
        }
    }

    public void visitLabel(Label label) {
        if (this.f155mv != null) {
            this.f155mv.visitLabel(label);
        }
    }

    public void visitLdcInsn(Object obj) {
        if (this.f155mv != null) {
            this.f155mv.visitLdcInsn(obj);
        }
    }

    public void visitIincInsn(int i, int i2) {
        if (this.f155mv != null) {
            this.f155mv.visitIincInsn(i, i2);
        }
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        if (this.f155mv != null) {
            this.f155mv.visitTableSwitchInsn(i, i2, label, labelArr);
        }
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        if (this.f155mv != null) {
            this.f155mv.visitLookupSwitchInsn(label, iArr, labelArr);
        }
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        if (this.f155mv != null) {
            this.f155mv.visitMultiANewArrayInsn(str, i);
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int i, TypePath typePath, String str, boolean z) {
        if (this.api < 327680) {
            throw new RuntimeException();
        } else if (this.f155mv != null) {
            return this.f155mv.visitInsnAnnotation(i, typePath, str, z);
        } else {
            return null;
        }
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        if (this.f155mv != null) {
            this.f155mv.visitTryCatchBlock(label, label2, label3, str);
        }
    }

    public AnnotationVisitor visitTryCatchAnnotation(int i, TypePath typePath, String str, boolean z) {
        if (this.api < 327680) {
            throw new RuntimeException();
        } else if (this.f155mv != null) {
            return this.f155mv.visitTryCatchAnnotation(i, typePath, str, z);
        } else {
            return null;
        }
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        if (this.f155mv != null) {
            this.f155mv.visitLocalVariable(str, str2, str3, label, label2, i);
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int i, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z) {
        if (this.api < 327680) {
            throw new RuntimeException();
        } else if (this.f155mv != null) {
            return this.f155mv.visitLocalVariableAnnotation(i, typePath, labelArr, labelArr2, iArr, str, z);
        } else {
            return null;
        }
    }

    public void visitLineNumber(int i, Label label) {
        if (this.f155mv != null) {
            this.f155mv.visitLineNumber(i, label);
        }
    }

    public void visitMaxs(int i, int i2) {
        if (this.f155mv != null) {
            this.f155mv.visitMaxs(i, i2);
        }
    }

    public void visitEnd() {
        if (this.f155mv != null) {
            this.f155mv.visitEnd();
        }
    }
}
