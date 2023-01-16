package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/Division.class */
public enum Division implements StackManipulation {
    INTEGER(108, StackSize.SINGLE),
    LONG(109, StackSize.DOUBLE),
    FLOAT(110, StackSize.SINGLE),
    DOUBLE(111, StackSize.DOUBLE);
    
    private final int opcode;
    private final StackSize stackSize;

    Division(int opcode, StackSize stackSize) {
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
