package net.bytebuddy.jar.asm.commons;

import java.util.List;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/commons/ClassRemapper.class */
public class ClassRemapper extends ClassVisitor {
    protected final Remapper remapper;
    protected String className;

    public ClassRemapper(ClassVisitor classVisitor, Remapper remapper) {
        this(Opcodes.ASM9, classVisitor, remapper);
    }

    /* access modifiers changed from: protected */
    public ClassRemapper(int api, ClassVisitor classVisitor, Remapper remapper) {
        super(api, classVisitor);
        this.remapper = remapper;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        visit(version, access, this.remapper.mapType(name), this.remapper.mapSignature(signature, false), this.remapper.mapType(superName), interfaces == null ? null : this.remapper.mapTypes(interfaces));
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public ModuleVisitor visitModule(String name, int flags, String version) {
        ModuleVisitor moduleVisitor = visitModule(this.remapper.mapModuleName(name), flags, version);
        if (moduleVisitor == null) {
            return null;
        }
        return createModuleRemapper(moduleVisitor);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitAnnotation(this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(descriptor, annotationVisitor);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visitAttribute(Attribute attribute) {
        if (attribute instanceof ModuleHashesAttribute) {
            List<String> modules = ((ModuleHashesAttribute) attribute).modules;
            for (int i = 0; i < modules.size(); i++) {
                modules.set(i, this.remapper.mapModuleName(modules.get(i)));
            }
        }
        visitAttribute(attribute);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {
        RecordComponentVisitor recordComponentVisitor = visitRecordComponent(this.remapper.mapRecordComponentName(this.className, name, descriptor), this.remapper.mapDesc(descriptor), this.remapper.mapSignature(signature, true));
        if (recordComponentVisitor == null) {
            return null;
        }
        return createRecordComponentRemapper(recordComponentVisitor);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        FieldVisitor fieldVisitor = visitField(access, this.remapper.mapFieldName(this.className, name, descriptor), this.remapper.mapDesc(descriptor), this.remapper.mapSignature(signature, true), value == null ? null : this.remapper.mapValue(value));
        if (fieldVisitor == null) {
            return null;
        }
        return createFieldRemapper(fieldVisitor);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = visitMethod(access, this.remapper.mapMethodName(this.className, name, descriptor), this.remapper.mapMethodDesc(descriptor), this.remapper.mapSignature(signature, false), exceptions == null ? null : this.remapper.mapTypes(exceptions));
        if (methodVisitor == null) {
            return null;
        }
        return createMethodRemapper(methodVisitor);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        visitInnerClass(this.remapper.mapType(name), outerName == null ? null : this.remapper.mapType(outerName), innerName == null ? null : this.remapper.mapInnerClassName(name, outerName, innerName), access);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visitOuterClass(String owner, String name, String descriptor) {
        visitOuterClass(this.remapper.mapType(owner), name == null ? null : this.remapper.mapMethodName(owner, name, descriptor), descriptor == null ? null : this.remapper.mapMethodDesc(descriptor));
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visitNestHost(String nestHost) {
        visitNestHost(this.remapper.mapType(nestHost));
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visitNestMember(String nestMember) {
        visitNestMember(this.remapper.mapType(nestMember));
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visitPermittedSubclass(String permittedSubclass) {
        visitPermittedSubclass(this.remapper.mapType(permittedSubclass));
    }

    protected FieldVisitor createFieldRemapper(FieldVisitor fieldVisitor) {
        return new FieldRemapper(this.api, fieldVisitor, this.remapper);
    }

    protected MethodVisitor createMethodRemapper(MethodVisitor methodVisitor) {
        return new MethodRemapper(this.api, methodVisitor, this.remapper);
    }

    @Deprecated
    protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, null, annotationVisitor, this.remapper);
    }

    protected AnnotationVisitor createAnnotationRemapper(String descriptor, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, descriptor, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }

    protected ModuleVisitor createModuleRemapper(ModuleVisitor moduleVisitor) {
        return new ModuleRemapper(this.api, moduleVisitor, this.remapper);
    }

    protected RecordComponentVisitor createRecordComponentRemapper(RecordComponentVisitor recordComponentVisitor) {
        return new RecordComponentRemapper(this.api, recordComponentVisitor, this.remapper);
    }
}
