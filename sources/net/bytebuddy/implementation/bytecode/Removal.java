package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/Removal.class */
public enum Removal implements StackManipulation {
    ZERO(StackSize.ZERO, 0) {
        @Override // net.bytebuddy.implementation.bytecode.Removal, net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            return StackManipulation.Size.ZERO;
        }
    },
    SINGLE(StackSize.SINGLE, 87),
    DOUBLE(StackSize.DOUBLE, 88);
    
    private final StackManipulation.Size size;
    private final int opcode;

    Removal(StackSize stackSize, int opcode) {
        this.size = stackSize.toDecreasingSize();
        this.opcode = opcode;
    }

    /* renamed from: of */
    public static StackManipulation m124of(TypeDefinition typeDefinition) {
        switch (typeDefinition.getStackSize()) {
            case SINGLE:
                return SINGLE;
            case DOUBLE:
                return DOUBLE;
            case ZERO:
                return ZERO;
            default:
                throw new AssertionError();
        }
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitInsn(this.opcode);
        return this.size;
    }
}
