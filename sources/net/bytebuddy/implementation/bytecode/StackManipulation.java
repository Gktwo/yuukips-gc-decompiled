package net.bytebuddy.implementation.bytecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/StackManipulation.class */
public interface StackManipulation {
    boolean isValid();

    Size apply(MethodVisitor methodVisitor, Implementation.Context context);

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/StackManipulation$Illegal.class */
    public enum Illegal implements StackManipulation {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return false;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            throw new IllegalStateException("An illegal stack manipulation must not be applied");
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/StackManipulation$Trivial.class */
    public enum Trivial implements StackManipulation {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            return StackSize.ZERO.toIncreasingSize();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/StackManipulation$Size.class */
    public static class Size {
        public static final Size ZERO = new Size(0, 0);
        private final int sizeImpact;
        private final int maximalSize;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.sizeImpact == ((Size) obj).sizeImpact && this.maximalSize == ((Size) obj).maximalSize;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.sizeImpact) * 31) + this.maximalSize;
        }

        public Size(int sizeImpact, int maximalSize) {
            this.sizeImpact = sizeImpact;
            this.maximalSize = maximalSize;
        }

        public int getSizeImpact() {
            return this.sizeImpact;
        }

        public int getMaximalSize() {
            return this.maximalSize;
        }

        public Size aggregate(Size other) {
            return aggregate(other.sizeImpact, other.maximalSize);
        }

        private Size aggregate(int sizeChange, int interimMaximalSize) {
            return new Size(this.sizeImpact + sizeChange, Math.max(this.maximalSize, this.sizeImpact + interimMaximalSize));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/StackManipulation$Compound.class */
    public static class Compound implements StackManipulation {
        private final List<StackManipulation> stackManipulations;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.stackManipulations.equals(((Compound) obj).stackManipulations);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.stackManipulations.hashCode();
        }

        public Compound(StackManipulation... stackManipulation) {
            this(Arrays.asList(stackManipulation));
        }

        public Compound(List<? extends StackManipulation> stackManipulations) {
            this.stackManipulations = new ArrayList();
            for (StackManipulation stackManipulation : stackManipulations) {
                if (stackManipulation instanceof Compound) {
                    this.stackManipulations.addAll(((Compound) stackManipulation).stackManipulations);
                } else if (!(stackManipulation instanceof Trivial)) {
                    this.stackManipulations.add(stackManipulation);
                }
            }
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            for (StackManipulation stackManipulation : this.stackManipulations) {
                if (!stackManipulation.isValid()) {
                    return false;
                }
            }
            return true;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            Size size = Size.ZERO;
            for (StackManipulation stackManipulation : this.stackManipulations) {
                size = size.aggregate(stackManipulation.apply(methodVisitor, implementationContext));
            }
            return size;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/StackManipulation$Simple.class */
    public static class Simple implements StackManipulation {
        private final Dispatcher dispatcher;

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/StackManipulation$Simple$Dispatcher.class */
        public interface Dispatcher {
            Size apply(MethodVisitor methodVisitor, Implementation.Context context);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((Simple) obj).dispatcher);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.dispatcher.hashCode();
        }

        public Simple(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            return this.dispatcher.apply(methodVisitor, implementationContext);
        }
    }
}
