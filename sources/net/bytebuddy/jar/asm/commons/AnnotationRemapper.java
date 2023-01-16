package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Opcodes;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/commons/AnnotationRemapper.class */
public class AnnotationRemapper extends AnnotationVisitor {
    protected final String descriptor;
    protected final Remapper remapper;

    @Deprecated
    public AnnotationRemapper(AnnotationVisitor annotationVisitor, Remapper remapper) {
        this((String) null, annotationVisitor, remapper);
    }

    public AnnotationRemapper(String descriptor, AnnotationVisitor annotationVisitor, Remapper remapper) {
        this(Opcodes.ASM9, descriptor, annotationVisitor, remapper);
    }

    @Deprecated
    protected AnnotationRemapper(int api, AnnotationVisitor annotationVisitor, Remapper remapper) {
        this(api, null, annotationVisitor, remapper);
    }

    /* access modifiers changed from: protected */
    public AnnotationRemapper(int api, String descriptor, AnnotationVisitor annotationVisitor, Remapper remapper) {
        super(api, annotationVisitor);
        this.descriptor = descriptor;
        this.remapper = remapper;
    }

    @Override // net.bytebuddy.jar.asm.AnnotationVisitor
    public void visit(String name, Object value) {
        visit(mapAnnotationAttributeName(name), this.remapper.mapValue(value));
    }

    @Override // net.bytebuddy.jar.asm.AnnotationVisitor
    public void visitEnum(String name, String descriptor, String value) {
        visitEnum(mapAnnotationAttributeName(name), this.remapper.mapDesc(descriptor), value);
    }

    @Override // net.bytebuddy.jar.asm.AnnotationVisitor
    public AnnotationVisitor visitAnnotation(String name, String descriptor) {
        AnnotationVisitor annotationVisitor = visitAnnotation(mapAnnotationAttributeName(name), this.remapper.mapDesc(descriptor));
        if (annotationVisitor == null) {
            return null;
        }
        if (annotationVisitor == this.f3100av) {
            return this;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.AnnotationVisitor
    public AnnotationVisitor visitArray(String name) {
        AnnotationVisitor annotationVisitor = visitArray(mapAnnotationAttributeName(name));
        if (annotationVisitor == null) {
            return null;
        }
        if (annotationVisitor == this.f3100av) {
            return this;
        }
        return createAnnotationRemapper(null, annotationVisitor);
    }

    @Deprecated
    protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, null, annotationVisitor, this.remapper);
    }

    protected AnnotationVisitor createAnnotationRemapper(String descriptor, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, descriptor, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }

    /* access modifiers changed from: package-private */
    public final AnnotationVisitor orDeprecatedValue(AnnotationVisitor deprecatedAnnotationVisitor) {
        if (deprecatedAnnotationVisitor.getClass() == getClass()) {
            AnnotationRemapper deprecatedAnnotationRemapper = (AnnotationRemapper) deprecatedAnnotationVisitor;
            if (deprecatedAnnotationRemapper.api == this.api && deprecatedAnnotationRemapper.f3100av == this.f3100av && deprecatedAnnotationRemapper.remapper == this.remapper) {
                return this;
            }
        }
        return deprecatedAnnotationVisitor;
    }

    private String mapAnnotationAttributeName(String name) {
        if (this.descriptor == null) {
            return name;
        }
        return this.remapper.mapAnnotationAttributeName(this.descriptor, name);
    }
}
