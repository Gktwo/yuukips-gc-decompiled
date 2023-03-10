package net.bytebuddy.jar.asm;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/RecordComponentVisitor.class */
public abstract class RecordComponentVisitor {
    protected final int api;
    RecordComponentVisitor delegate;

    public RecordComponentVisitor(int api) {
        this(api, null);
    }

    public RecordComponentVisitor(int api, RecordComponentVisitor recordComponentVisitor) {
        if (api == 589824 || api == 524288 || api == 458752 || api == 393216 || api == 327680 || api == 262144 || api == 17432576) {
            if (api == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = api;
            this.delegate = recordComponentVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + api);
    }

    public RecordComponentVisitor getDelegate() {
        return this.delegate;
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (this.delegate != null) {
            return this.delegate.visitAnnotation(descriptor, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.delegate != null) {
            return this.delegate.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.delegate != null) {
            this.delegate.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        if (this.delegate != null) {
            this.delegate.visitEnd();
        }
    }
}
