package net.bytebuddy.jar.asm;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/ClassVisitor.class */
public abstract class ClassVisitor {
    protected final int api;

    /* renamed from: cv */
    protected ClassVisitor f3102cv;

    public ClassVisitor(int api) {
        this(api, null);
    }

    public ClassVisitor(int api, ClassVisitor classVisitor) {
        if (api == 589824 || api == 524288 || api == 458752 || api == 393216 || api == 327680 || api == 262144 || api == 17432576) {
            if (api == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = api;
            this.f3102cv = classVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + api);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        if (this.api < 524288 && (access & 65536) != 0) {
            throw new UnsupportedOperationException("Records requires ASM8");
        } else if (this.f3102cv != null) {
            this.f3102cv.visit(version, access, name, signature, superName, interfaces);
        }
    }

    public void visitSource(String source, String debug) {
        if (this.f3102cv != null) {
            this.f3102cv.visitSource(source, debug);
        }
    }

    public ModuleVisitor visitModule(String name, int access, String version) {
        if (this.api < 393216) {
            throw new UnsupportedOperationException("Module requires ASM6");
        } else if (this.f3102cv != null) {
            return this.f3102cv.visitModule(name, access, version);
        } else {
            return null;
        }
    }

    public void visitNestHost(String nestHost) {
        if (this.api < 458752) {
            throw new UnsupportedOperationException("NestHost requires ASM7");
        } else if (this.f3102cv != null) {
            this.f3102cv.visitNestHost(nestHost);
        }
    }

    public void visitOuterClass(String owner, String name, String descriptor) {
        if (this.f3102cv != null) {
            this.f3102cv.visitOuterClass(owner, name, descriptor);
        }
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (this.f3102cv != null) {
            return this.f3102cv.visitAnnotation(descriptor, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException("TypeAnnotation requires ASM5");
        } else if (this.f3102cv != null) {
            return this.f3102cv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        } else {
            return null;
        }
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f3102cv != null) {
            this.f3102cv.visitAttribute(attribute);
        }
    }

    public void visitNestMember(String nestMember) {
        if (this.api < 458752) {
            throw new UnsupportedOperationException("NestMember requires ASM7");
        } else if (this.f3102cv != null) {
            this.f3102cv.visitNestMember(nestMember);
        }
    }

    public void visitPermittedSubclass(String permittedSubclass) {
        if (this.api < 589824) {
            throw new UnsupportedOperationException("PermittedSubclasses requires ASM9");
        } else if (this.f3102cv != null) {
            this.f3102cv.visitPermittedSubclass(permittedSubclass);
        }
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        if (this.f3102cv != null) {
            this.f3102cv.visitInnerClass(name, outerName, innerName, access);
        }
    }

    public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {
        if (this.api < 524288) {
            throw new UnsupportedOperationException("Record requires ASM8");
        } else if (this.f3102cv != null) {
            return this.f3102cv.visitRecordComponent(name, descriptor, signature);
        } else {
            return null;
        }
    }

    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if (this.f3102cv != null) {
            return this.f3102cv.visitField(access, name, descriptor, signature, value);
        }
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (this.f3102cv != null) {
            return this.f3102cv.visitMethod(access, name, descriptor, signature, exceptions);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f3102cv != null) {
            this.f3102cv.visitEnd();
        }
    }
}
