package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/Multiplication.class */
public enum Multiplication implements StackManipulation {
    INTEGER(104, StackSize.SINGLE),
    LONG(105, StackSize.DOUBLE),
    FLOAT(106, StackSize.SINGLE),
    DOUBLE(107, StackSize.DOUBLE);
    
    private final int opcode;
    private final StackSize stackSize;

    Multiplication(int opcode, StackSize stackSize) {
        this.opcode = opcode;
        this.stackSize = stackSize;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitInsn(this.opcode);
        return this.stackSize.toDecreasingSize();
    }
}
