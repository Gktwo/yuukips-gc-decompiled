package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/FieldVisitor.class */
public abstract class FieldVisitor {
    protected final int api;

    /* renamed from: fv */
    protected FieldVisitor f103fv;

    public FieldVisitor(int i) {
        this(i, null);
    }

    public FieldVisitor(int i, FieldVisitor fieldVisitor) {
        if (i == 262144 || i == 327680) {
            this.api = i;
            this.f103fv = fieldVisitor;
            return;
        }
        throw new IllegalArgumentException();
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        if (this.f103fv != null) {
            return this.f103fv.visitAnnotation(str, z);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        if (this.api < 327680) {
            throw new RuntimeException();
        } else if (this.f103fv != null) {
            return this.f103fv.visitTypeAnnotation(i, typePath, str, z);
        } else {
            return null;
        }
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f103fv != null) {
            this.f103fv.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        if (this.f103fv != null) {
            this.f103fv.visitEnd();
        }
    }
}
