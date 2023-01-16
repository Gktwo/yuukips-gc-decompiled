package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.TypePath;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/commons/FieldRemapper.class */
public class FieldRemapper extends FieldVisitor {
    protected final Remapper remapper;

    public FieldRemapper(FieldVisitor fieldVisitor, Remapper remapper) {
        this(Opcodes.ASM9, fieldVisitor, remapper);
    }

    /* access modifiers changed from: protected */
    public FieldRemapper(int api, FieldVisitor fieldVisitor, Remapper remapper) {
        super(api, fieldVisitor);
        this.remapper = remapper;
    }

    @Override // net.bytebuddy.jar.asm.FieldVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitAnnotation(this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.FieldVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
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
