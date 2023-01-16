package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.Opcodes;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/commons/ModuleRemapper.class */
public class ModuleRemapper extends ModuleVisitor {
    protected final Remapper remapper;

    public ModuleRemapper(ModuleVisitor moduleVisitor, Remapper remapper) {
        this(Opcodes.ASM9, moduleVisitor, remapper);
    }

    /* access modifiers changed from: protected */
    public ModuleRemapper(int api, ModuleVisitor moduleVisitor, Remapper remapper) {
        super(api, moduleVisitor);
        this.remapper = remapper;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitMainClass(String mainClass) {
        visitMainClass(this.remapper.mapType(mainClass));
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitPackage(String packaze) {
        visitPackage(this.remapper.mapPackageName(packaze));
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitRequire(String module, int access, String version) {
        visitRequire(this.remapper.mapModuleName(module), access, version);
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitExport(String packaze, int access, String... modules) {
        String[] remappedModules = null;
        if (modules != null) {
            remappedModules = new String[modules.length];
            for (int i = 0; i < modules.length; i++) {
                remappedModules[i] = this.remapper.mapModuleName(modules[i]);
            }
        }
        visitExport(this.remapper.mapPackageName(packaze), access, remappedModules);
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitOpen(String packaze, int access, String... modules) {
        String[] remappedModules = null;
        if (modules != null) {
            remappedModules = new String[modules.length];
            for (int i = 0; i < modules.length; i++) {
                remappedModules[i] = this.remapper.mapModuleName(modules[i]);
            }
        }
        visitOpen(this.remapper.mapPackageName(packaze), access, remappedModules);
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitUse(String service) {
        visitUse(this.remapper.mapType(service));
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitProvide(String service, String... providers) {
        String[] remappedProviders = new String[providers.length];
        for (int i = 0; i < providers.length; i++) {
            remappedProviders[i] = this.remapper.mapType(providers[i]);
        }
        visitProvide(this.remapper.mapType(service), remappedProviders);
    }
}
