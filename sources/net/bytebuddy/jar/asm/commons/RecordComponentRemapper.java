package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/commons/RecordComponentRemapper.class */
public class RecordComponentRemapper extends RecordComponentVisitor {
    protected final Remapper remapper;

    public RecordComponentRemapper(RecordComponentVisitor recordComponentVisitor, Remapper remapper) {
        this(Opcodes.ASM9, recordComponentVisitor, remapper);
    }

    /* access modifiers changed from: protected */
    public RecordComponentRemapper(int api, RecordComponentVisitor recordComponentVisitor, Remapper remapper) {
        super(api, recordComponentVisitor);
        this.remapper = remapper;
    }

    @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitAnnotation(this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
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
