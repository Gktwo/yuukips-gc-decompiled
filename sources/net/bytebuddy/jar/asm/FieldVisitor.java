package net.bytebuddy.jar.asm;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/FieldVisitor.class */
public abstract class FieldVisitor {
    protected final int api;

    /* renamed from: fv */
    protected FieldVisitor f3067fv;

    public FieldVisitor(int api) {
        this(api, null);
    }

    public FieldVisitor(int api, FieldVisitor fieldVisitor) {
        if (api == 589824 || api == 524288 || api == 458752 || api == 393216 || api == 327680 || api == 262144 || api == 17432576) {
            if (api == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = api;
            this.f3067fv = fieldVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + api);
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (this.f3067fv != null) {
            return this.f3067fv.visitAnnotation(descriptor, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException("This feature requires ASM5");
        } else if (this.f3067fv != null) {
            return this.f3067fv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        } else {
            return null;
        }
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f3067fv != null) {
            this.f3067fv.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        if (this.f3067fv != null) {
            this.f3067fv.visitEnd();
        }
    }
}
