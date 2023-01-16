package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/visitor/MetadataAwareClassVisitor.class */
public abstract class MetadataAwareClassVisitor extends ClassVisitor {
    private boolean triggerNestHost = true;
    private boolean triggerOuterClass = true;
    private boolean triggerAttributes = true;

    /* access modifiers changed from: protected */
    public MetadataAwareClassVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    protected void onNestHost() {
    }

    protected void onOuterType() {
    }

    protected void onAfterAttributes() {
    }

    private void considerTriggerNestHost() {
        if (this.triggerNestHost) {
            this.triggerNestHost = false;
            onNestHost();
        }
    }

    private void considerTriggerOuterClass() {
        if (this.triggerOuterClass) {
            this.triggerOuterClass = false;
            onOuterType();
        }
    }

    private void considerTriggerAfterAttributes() {
        if (this.triggerAttributes) {
            this.triggerAttributes = false;
            onAfterAttributes();
        }
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitNestHost(String nestHost) {
        this.triggerNestHost = false;
        onVisitNestHost(nestHost);
    }

    protected void onVisitNestHost(String nestHost) {
        visitNestHost(nestHost);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitOuterClass(String owner, String name, String descriptor) {
        considerTriggerNestHost();
        this.triggerOuterClass = false;
        onVisitOuterClass(owner, name, descriptor);
    }

    protected void onVisitOuterClass(String owner, String name, String descriptor) {
        visitOuterClass(owner, name, descriptor);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitPermittedSubclass(String permittedSubclass) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitPermittedSubclass(permittedSubclass);
    }

    protected void onVisitPermittedSubclass(String permittedSubclass) {
        visitPermittedSubclass(permittedSubclass);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitRecordComponent(name, descriptor, signature);
    }

    protected RecordComponentVisitor onVisitRecordComponent(String name, String descriptor, String signature) {
        return visitRecordComponent(name, descriptor, signature);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return onVisitAnnotation(descriptor, visible);
    }

    protected AnnotationVisitor onVisitAnnotation(String descriptor, boolean visible) {
        return visitAnnotation(descriptor, visible);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final AnnotationVisitor visitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return onVisitTypeAnnotation(typeReference, typePath, descriptor, visible);
    }

    protected AnnotationVisitor onVisitTypeAnnotation(int typeReference, TypePath typePath, String descriptor, boolean visible) {
        return visitTypeAnnotation(typeReference, typePath, descriptor, visible);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitAttribute(Attribute attribute) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        onVisitAttribute(attribute);
    }

    protected void onVisitAttribute(Attribute attribute) {
        visitAttribute(attribute);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitNestMember(String nestMember) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitNestMember(nestMember);
    }

    protected void onVisitNestMember(String nestMember) {
        visitNestMember(nestMember);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitInnerClass(String name, String outerName, String innerName, int modifiers) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitInnerClass(name, outerName, innerName, modifiers);
    }

    protected void onVisitInnerClass(String name, String outerName, String innerName, int modifiers) {
        visitInnerClass(name, outerName, innerName, modifiers);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final FieldVisitor visitField(int modifiers, String internalName, String descriptor, String signature, Object defaultValue) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitField(modifiers, internalName, descriptor, signature, defaultValue);
    }

    protected FieldVisitor onVisitField(int modifiers, String internalName, String descriptor, String signature, Object defaultValue) {
        return visitField(modifiers, internalName, descriptor, signature, defaultValue);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final MethodVisitor visitMethod(int modifiers, String internalName, String descriptor, String signature, String[] exception) {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitMethod(modifiers, internalName, descriptor, signature, exception);
    }

    protected MethodVisitor onVisitMethod(int modifiers, String internalName, String descriptor, String signature, String[] exception) {
        return visitMethod(modifiers, internalName, descriptor, signature, exception);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitEnd() {
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitEnd();
    }

    protected void onVisitEnd() {
        visitEnd();
    }
}
