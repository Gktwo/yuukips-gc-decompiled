package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/AnnotationVisitor.class */
public abstract class AnnotationVisitor {
    protected final int api;

    /* renamed from: av */
    protected AnnotationVisitor f22av;

    public AnnotationVisitor(int i) {
        this(i, null);
    }

    public AnnotationVisitor(int i, AnnotationVisitor annotationVisitor) {
        if (i == 262144 || i == 327680) {
            this.api = i;
            this.f22av = annotationVisitor;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void visit(String str, Object obj) {
        if (this.f22av != null) {
            this.f22av.visit(str, obj);
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        if (this.f22av != null) {
            this.f22av.visitEnum(str, str2, str3);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        if (this.f22av != null) {
            return this.f22av.visitAnnotation(str, str2);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String str) {
        if (this.f22av != null) {
            return this.f22av.visitArray(str);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f22av != null) {
            this.f22av.visitEnd();
        }
    }
}
