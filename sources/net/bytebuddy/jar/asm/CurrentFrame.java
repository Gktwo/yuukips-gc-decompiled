package net.bytebuddy.jar.asm;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/CurrentFrame.class */
final class CurrentFrame extends Frame {
    /* access modifiers changed from: package-private */
    public CurrentFrame(Label owner) {
        super(owner);
    }

    /* access modifiers changed from: package-private */
    @Override // net.bytebuddy.jar.asm.Frame
    public void execute(int opcode, int arg, Symbol symbolArg, SymbolTable symbolTable) {
        execute(opcode, arg, symbolArg, symbolTable);
        Frame successor = new Frame(null);
        merge(symbolTable, successor, 0);
        copyFrom(successor);
    }
}
