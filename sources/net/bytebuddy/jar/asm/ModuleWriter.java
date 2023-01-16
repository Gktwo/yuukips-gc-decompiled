package net.bytebuddy.jar.asm;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/ModuleWriter.class */
public final class ModuleWriter extends ModuleVisitor {
    private final SymbolTable symbolTable;
    private final int moduleNameIndex;
    private final int moduleFlags;
    private final int moduleVersionIndex;
    private int requiresCount;
    private int exportsCount;
    private int opensCount;
    private int usesCount;
    private int providesCount;
    private int packageCount;
    private int mainClassIndex;
    private final ByteVector requires = new ByteVector();
    private final ByteVector exports = new ByteVector();
    private final ByteVector opens = new ByteVector();
    private final ByteVector usesIndex = new ByteVector();
    private final ByteVector provides = new ByteVector();
    private final ByteVector packageIndex = new ByteVector();

    /* access modifiers changed from: package-private */
    public ModuleWriter(SymbolTable symbolTable, int name, int access, int version) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable;
        this.moduleNameIndex = name;
        this.moduleFlags = access;
        this.moduleVersionIndex = version;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitMainClass(String mainClass) {
        this.mainClassIndex = this.symbolTable.addConstantClass(mainClass).index;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitPackage(String packaze) {
        this.packageIndex.putShort(this.symbolTable.addConstantPackage(packaze).index);
        this.packageCount++;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitRequire(String module, int access, String version) {
        this.requires.putShort(this.symbolTable.addConstantModule(module).index).putShort(access).putShort(version == null ? 0 : this.symbolTable.addConstantUtf8(version));
        this.requiresCount++;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitExport(String packaze, int access, String... modules) {
        this.exports.putShort(this.symbolTable.addConstantPackage(packaze).index).putShort(access);
        if (modules == null) {
            this.exports.putShort(0);
        } else {
            this.exports.putShort(modules.length);
            for (String module : modules) {
                this.exports.putShort(this.symbolTable.addConstantModule(module).index);
            }
        }
        this.exportsCount++;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitOpen(String packaze, int access, String... modules) {
        this.opens.putShort(this.symbolTable.addConstantPackage(packaze).index).putShort(access);
        if (modules == null) {
            this.opens.putShort(0);
        } else {
            this.opens.putShort(modules.length);
            for (String module : modules) {
                this.opens.putShort(this.symbolTable.addConstantModule(module).index);
            }
        }
        this.opensCount++;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitUse(String service) {
        this.usesIndex.putShort(this.symbolTable.addConstantClass(service).index);
        this.usesCount++;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitProvide(String service, String... providers) {
        this.provides.putShort(this.symbolTable.addConstantClass(service).index);
        this.provides.putShort(providers.length);
        for (String provider : providers) {
            this.provides.putShort(this.symbolTable.addConstantClass(provider).index);
        }
        this.providesCount++;
    }

    @Override // net.bytebuddy.jar.asm.ModuleVisitor
    public void visitEnd() {
    }

    /* access modifiers changed from: package-private */
    public int getAttributeCount() {
        return 1 + (this.packageCount > 0 ? 1 : 0) + (this.mainClassIndex > 0 ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public int computeAttributesSize() {
        this.symbolTable.addConstantUtf8("Module");
        int size = 22 + this.requires.length + this.exports.length + this.opens.length + this.usesIndex.length + this.provides.length;
        if (this.packageCount > 0) {
            this.symbolTable.addConstantUtf8("ModulePackages");
            size += 8 + this.packageIndex.length;
        }
        if (this.mainClassIndex > 0) {
            this.symbolTable.addConstantUtf8("ModuleMainClass");
            size += 8;
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public void putAttributes(ByteVector output) {
        output.putShort(this.symbolTable.addConstantUtf8("Module")).putInt(16 + this.requires.length + this.exports.length + this.opens.length + this.usesIndex.length + this.provides.length).putShort(this.moduleNameIndex).putShort(this.moduleFlags).putShort(this.moduleVersionIndex).putShort(this.requiresCount).putByteArray(this.requires.data, 0, this.requires.length).putShort(this.exportsCount).putByteArray(this.exports.data, 0, this.exports.length).putShort(this.opensCount).putByteArray(this.opens.data, 0, this.opens.length).putShort(this.usesCount).putByteArray(this.usesIndex.data, 0, this.usesIndex.length).putShort(this.providesCount).putByteArray(this.provides.data, 0, this.provides.length);
        if (this.packageCount > 0) {
            output.putShort(this.symbolTable.addConstantUtf8("ModulePackages")).putInt(2 + this.packageIndex.length).putShort(this.packageCount).putByteArray(this.packageIndex.data, 0, this.packageIndex.length);
        }
        if (this.mainClassIndex > 0) {
            output.putShort(this.symbolTable.addConstantUtf8("ModuleMainClass")).putInt(2).putShort(this.mainClassIndex);
        }
    }
}
