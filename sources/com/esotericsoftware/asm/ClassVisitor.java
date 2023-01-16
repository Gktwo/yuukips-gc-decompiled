package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/ClassVisitor.class */
public abstract class ClassVisitor {
    protected final int api;

    /* renamed from: cv */
    protected ClassVisitor f39cv;

    public ClassVisitor(int i) {
        this(i, null);
    }

    public ClassVisitor(int i, ClassVisitor classVisitor) {
        if (i == 262144 || i == 327680) {
            this.api = i;
            this.f39cv = classVisitor;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        if (this.f39cv != null) {
            this.f39cv.visit(i, i2, str, str2, str3, strArr);
        }
    }

    public void visitSource(String str, String str2) {
        if (this.f39cv != null) {
            this.f39cv.visitSource(str, str2);
        }
    }

    public void visitOuterClass(String str, String str2, String str3) {
        if (this.f39cv != null) {
            this.f39cv.visitOuterClass(str, str2, str3);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        if (this.f39cv != null) {
            return this.f39cv.visitAnnotation(str, z);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        if (this.api < 327680) {
            throw new RuntimeException();
        } else if (this.f39cv != null) {
            return this.f39cv.visitTypeAnnotation(i, typePath, str, z);
        } else {
            return null;
        }
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f39cv != null) {
            this.f39cv.visitAttribute(attribute);
        }
    }

    public void visitInnerClass(String str, String str2, String str3, int i) {
        if (this.f39cv != null) {
            this.f39cv.visitInnerClass(str, str2, str3, i);
        }
    }

    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        if (this.f39cv != null) {
            return this.f39cv.visitField(i, str, str2, str3, obj);
        }
        return null;
    }

    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        if (this.f39cv != null) {
            return this.f39cv.visitMethod(i, str, str2, str3, strArr);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f39cv != null) {
            this.f39cv.visitEnd();
        }
    }
}
