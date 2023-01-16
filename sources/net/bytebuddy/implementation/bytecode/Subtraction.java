package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/Subtraction.class */
public enum Subtraction implements StackManipulation {
    INTEGER(100, StackSize.SINGLE),
    LONG(101, StackSize.DOUBLE),
    FLOAT(102, StackSize.SINGLE),
    DOUBLE(103, StackSize.DOUBLE);
    
    private final int opcode;
    private final StackSize stackSize;

    Subtraction(int opcode, StackSize stackSize) {
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
