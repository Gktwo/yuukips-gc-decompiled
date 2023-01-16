package net.bytebuddy.jar.asm;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/AnnotationVisitor.class */
public abstract class AnnotationVisitor {
    protected final int api;

    /* renamed from: av */
    protected AnnotationVisitor f3100av;

    public AnnotationVisitor(int api) {
        this(api, null);
    }

    public AnnotationVisitor(int api, AnnotationVisitor annotationVisitor) {
        if (api == 589824 || api == 524288 || api == 458752 || api == 393216 || api == 327680 || api == 262144 || api == 17432576) {
            if (api == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = api;
            this.f3100av = annotationVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + api);
    }

    public void visit(String name, Object value) {
        if (this.f3100av != null) {
            this.f3100av.visit(name, value);
        }
    }

    public void visitEnum(String name, String descriptor, String value) {
        if (this.f3100av != null) {
            this.f3100av.visitEnum(name, descriptor, value);
        }
    }

    public AnnotationVisitor visitAnnotation(String name, String descriptor) {
        if (this.f3100av != null) {
            return this.f3100av.visitAnnotation(name, descriptor);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String name) {
        if (this.f3100av != null) {
            return this.f3100av.visitArray(name);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f3100av != null) {
            this.f3100av.visitEnd();
        }
    }
}
