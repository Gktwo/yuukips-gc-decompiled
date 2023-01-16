package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/constant/DoubleConstant.class */
public enum DoubleConstant implements StackManipulation {
    ZERO(14),
    ONE(15);
    
    private static final StackManipulation.Size SIZE = StackSize.DOUBLE.toIncreasingSize();
    private final int opcode;

    DoubleConstant(int opcode) {
        this.opcode = opcode;
    }

    public static StackManipulation forValue(double value) {
        if (value == 0.0d) {
            return ZERO;
        }
        if (value == 1.0d) {
            return ONE;
        }
        return new ConstantPool(value);
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitInsn(this.opcode);
        return SIZE;
    }

    /* access modifiers changed from: protected */
    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/constant/DoubleConstant$ConstantPool.class */
    public static class ConstantPool implements StackManipulation {
        private final double value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Double.compare(this.value, ((ConstantPool) obj).value) == 0;
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            return hashCode + ((int) (hashCode ^ (Double.doubleToLongBits(this.value) >>> 32)));
        }

        protected ConstantPool(double value) {
            this.value = value;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            methodVisitor.visitLdcInsn(Double.valueOf(this.value));
            return DoubleConstant.SIZE;
        }
    }
}
