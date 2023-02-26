package net.bytebuddy.jar.asm;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/ModuleVisitor.class */
public abstract class ModuleVisitor {
    protected final int api;

    /* renamed from: mv */
    protected ModuleVisitor f3070mv;

    public ModuleVisitor(int api) {
        this(api, null);
    }

    public ModuleVisitor(int api, ModuleVisitor moduleVisitor) {
        if (api == 589824 || api == 524288 || api == 458752 || api == 393216 || api == 327680 || api == 262144 || api == 17432576) {
            if (api == 17432576) {
                Constants.checkAsmExperimental(this);
            }
            this.api = api;
            this.f3070mv = moduleVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + api);
    }

    public void visitMainClass(String mainClass) {
        if (this.f3070mv != null) {
            this.f3070mv.visitMainClass(mainClass);
        }
    }

    public void visitPackage(String packaze) {
        if (this.f3070mv != null) {
            this.f3070mv.visitPackage(packaze);
        }
    }

    public void visitRequire(String module, int access, String version) {
        if (this.f3070mv != null) {
            this.f3070mv.visitRequire(module, access, version);
        }
    }

    public void visitExport(String packaze, int access, String... modules) {
        if (this.f3070mv != null) {
            this.f3070mv.visitExport(packaze, access, modules);
        }
    }

    public void visitOpen(String packaze, int access, String... modules) {
        if (this.f3070mv != null) {
            this.f3070mv.visitOpen(packaze, access, modules);
        }
    }

    public void visitUse(String service) {
        if (this.f3070mv != null) {
            this.f3070mv.visitUse(service);
        }
    }

    public void visitProvide(String service, String... providers) {
        if (this.f3070mv != null) {
            this.f3070mv.visitProvide(service, providers);
        }
    }

    public void visitEnd() {
        if (this.f3070mv != null) {
            this.f3070mv.visitEnd();
        }
    }
}
