package net.bytebuddy.implementation;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/SuperMethodCall.class */
public enum SuperMethodCall implements Implementation.Composable {
    INSTANCE;

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target implementationTarget) {
        return new Appender(implementationTarget, Appender.TerminationHandler.RETURNING);
    }

    @Override // net.bytebuddy.implementation.Implementation.Composable
    public Implementation andThen(Implementation implementation) {
        return new Implementation.Compound(WithoutReturn.INSTANCE, implementation);
    }

    @Override // net.bytebuddy.implementation.Implementation.Composable
    public Implementation.Composable andThen(Implementation.Composable implementation) {
        return new Implementation.Compound.Composable(WithoutReturn.INSTANCE, implementation);
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/SuperMethodCall$WithoutReturn.class */
    protected enum WithoutReturn implements Implementation {
        INSTANCE;

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target implementationTarget) {
            return new Appender(implementationTarget, Appender.TerminationHandler.DROPPING);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/SuperMethodCall$Appender.class */
    protected static class Appender implements ByteCodeAppender {
        private final Implementation.Target implementationTarget;
        private final TerminationHandler terminationHandler;

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/SuperMethodCall$Appender$TerminationHandler.class */
        protected enum TerminationHandler {
            RETURNING {
                @Override // net.bytebuddy.implementation.SuperMethodCall.Appender.TerminationHandler
                /* renamed from: of */
                protected StackManipulation mo141of(MethodDescription methodDescription) {
                    return MethodReturn.m108of(methodDescription.getReturnType());
                }
            },
            DROPPING {
                @Override // net.bytebuddy.implementation.SuperMethodCall.Appender.TerminationHandler
                /* renamed from: of */
                protected StackManipulation mo141of(MethodDescription methodDescription) {
                    return Removal.m124of(methodDescription.getReturnType());
                }
            };

            /* renamed from: of */
            protected abstract StackManipulation mo141of(MethodDescription methodDescription);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.terminationHandler.equals(((Appender) obj).terminationHandler) && this.implementationTarget.equals(((Appender) obj).implementationTarget);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.implementationTarget.hashCode()) * 31) + this.terminationHandler.hashCode();
        }

        protected Appender(Implementation.Target implementationTarget, TerminationHandler terminationHandler) {
            this.implementationTarget = implementationTarget;
            this.terminationHandler = terminationHandler;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
            StackManipulation superMethodCall = this.implementationTarget.invokeDominant(instrumentedMethod.asSignatureToken()).withCheckedCompatibilityTo(instrumentedMethod.asTypeToken());
            if (superMethodCall.isValid()) {
                return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(instrumentedMethod).prependThisReference(), superMethodCall, this.terminationHandler.mo141of(instrumentedMethod)).apply(methodVisitor, implementationContext).getMaximalSize(), instrumentedMethod.getStackSize());
            }
            throw new IllegalStateException("Cannot call super (or default) method for " + instrumentedMethod);
        }
    }
}
