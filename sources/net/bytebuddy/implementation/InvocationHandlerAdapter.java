package net.bytebuddy.implementation;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/InvocationHandlerAdapter.class */
public abstract class InvocationHandlerAdapter implements Implementation.Composable {
    private static final TypeDescription.Generic INVOCATION_HANDLER_TYPE = TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(InvocationHandler.class);
    private static final boolean UNCACHED = false;
    private static final boolean CACHED = true;
    private static final boolean UNPRIVILEGED = false;
    private static final boolean PRIVILEGED = true;
    private static final boolean RETURNING = true;
    private static final boolean DROPPING = false;
    protected final String fieldName;
    protected final boolean cached;
    protected final boolean privileged;
    protected final boolean returning;
    protected final Assigner assigner;

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/InvocationHandlerAdapter$AssignerConfigurable.class */
    public interface AssignerConfigurable extends Implementation.Composable {
        Implementation.Composable withAssigner(Assigner assigner);
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/InvocationHandlerAdapter$WithoutPrivilegeConfiguration.class */
    public interface WithoutPrivilegeConfiguration extends AssignerConfigurable {
        AssignerConfigurable withPrivilegedLookup();
    }

    public abstract WithoutPrivilegeConfiguration withoutMethodCache();

    @Override // net.bytebuddy.implementation.InvocationHandlerAdapter.AssignerConfigurable
    public abstract Implementation withAssigner(Assigner assigner);

    @Override // net.bytebuddy.implementation.InvocationHandlerAdapter.WithoutPrivilegeConfiguration
    public abstract AssignerConfigurable withPrivilegedLookup();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.cached == ((InvocationHandlerAdapter) obj).cached && this.privileged == ((InvocationHandlerAdapter) obj).privileged && this.returning == ((InvocationHandlerAdapter) obj).returning && this.fieldName.equals(((InvocationHandlerAdapter) obj).fieldName) && this.assigner.equals(((InvocationHandlerAdapter) obj).assigner);
    }

    public int hashCode() {
        return (((((((((getClass().hashCode() * 31) + this.fieldName.hashCode()) * 31) + (this.cached ? 1 : 0)) * 31) + (this.privileged ? 1 : 0)) * 31) + (this.returning ? 1 : 0)) * 31) + this.assigner.hashCode();
    }

    protected InvocationHandlerAdapter(String fieldName, boolean cached, boolean privileged, boolean returning, Assigner assigner) {
        this.fieldName = fieldName;
        this.cached = cached;
        this.privileged = privileged;
        this.returning = returning;
        this.assigner = assigner;
    }

    /* renamed from: of */
    public static InvocationHandlerAdapter m182of(InvocationHandler invocationHandler) {
        return m181of(invocationHandler, "invocationHandler$" + RandomString.hashOf(invocationHandler.getClass().hashCode() ^ invocationHandler.hashCode()));
    }

    /* renamed from: of */
    public static InvocationHandlerAdapter m181of(InvocationHandler invocationHandler, String fieldName) {
        return new ForInstance(fieldName, true, false, true, Assigner.DEFAULT, invocationHandler);
    }

    public static InvocationHandlerAdapter toField(String name) {
        return toField(name, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
    }

    public static InvocationHandlerAdapter toField(String name, FieldLocator.Factory fieldLocatorFactory) {
        return new ForField(name, true, false, true, Assigner.DEFAULT, fieldLocatorFactory);
    }

    private List<StackManipulation> argumentValuesOf(MethodDescription instrumentedMethod) {
        TypeList.Generic<TypeDescription.Generic> parameterTypes = instrumentedMethod.getParameters().asTypeList();
        List<StackManipulation> instruction = new ArrayList<>(parameterTypes.size());
        int currentIndex = 1;
        for (TypeDescription.Generic parameterType : parameterTypes) {
            instruction.add(new StackManipulation.Compound(MethodVariableAccess.m107of(parameterType).loadFrom(currentIndex), this.assigner.assign(parameterType, TypeDescription.Generic.OBJECT, Assigner.Typing.STATIC)));
            currentIndex += parameterType.getStackSize().getSize();
        }
        return instruction;
    }

    protected ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod, StackManipulation preparingManipulation, FieldDescription fieldDescription) {
        MethodConstant.CanCache methodConstant;
        if (instrumentedMethod.isStatic() || instrumentedMethod.isConstructor()) {
            throw new IllegalStateException("It is not possible to apply an invocation handler onto the static method or constructor " + instrumentedMethod);
        }
        if (this.privileged) {
            methodConstant = MethodConstant.ofPrivileged(instrumentedMethod.asDefined());
        } else {
            methodConstant = MethodConstant.m112of(instrumentedMethod.asDefined());
        }
        StackManipulation[] stackManipulationArr = new StackManipulation[7];
        stackManipulationArr[0] = preparingManipulation;
        stackManipulationArr[1] = FieldAccess.forField(fieldDescription).read();
        stackManipulationArr[2] = MethodVariableAccess.loadThis();
        stackManipulationArr[3] = this.cached ? methodConstant.cached() : methodConstant;
        stackManipulationArr[4] = ArrayFactory.forType(TypeDescription.Generic.OBJECT).withValues(argumentValuesOf(instrumentedMethod));
        stackManipulationArr[5] = MethodInvocation.invoke((MethodDescription) INVOCATION_HANDLER_TYPE.getDeclaredMethods().filter(ElementMatchers.isAbstract()).getOnly());
        stackManipulationArr[6] = this.returning ? new StackManipulation.Compound(this.assigner.assign(TypeDescription.Generic.OBJECT, instrumentedMethod.getReturnType(), Assigner.Typing.DYNAMIC), MethodReturn.m108of(instrumentedMethod.getReturnType())) : Removal.SINGLE;
        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulationArr).apply(methodVisitor, implementationContext).getMaximalSize(), instrumentedMethod.getStackSize());
    }

    /* access modifiers changed from: protected */
    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/InvocationHandlerAdapter$ForInstance.class */
    public static class ForInstance extends InvocationHandlerAdapter implements WithoutPrivilegeConfiguration {
        private static final String PREFIX = "invocationHandler";
        protected final InvocationHandler invocationHandler;

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public boolean equals(Object obj) {
            if (!equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.invocationHandler.equals(((ForInstance) obj).invocationHandler);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public int hashCode() {
            return (hashCode() * 31) + this.invocationHandler.hashCode();
        }

        protected ForInstance(String fieldName, boolean cached, boolean privileged, boolean returning, Assigner assigner, InvocationHandler invocationHandler) {
            super(fieldName, cached, privileged, returning, assigner);
            this.invocationHandler = invocationHandler;
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public WithoutPrivilegeConfiguration withoutMethodCache() {
            return new ForInstance(this.fieldName, false, this.privileged, this.returning, this.assigner, this.invocationHandler);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.AssignerConfigurable
        public Implementation.Composable withAssigner(Assigner assigner) {
            return new ForInstance(this.fieldName, this.cached, this.privileged, this.returning, assigner, this.invocationHandler);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.WithoutPrivilegeConfiguration
        public AssignerConfigurable withPrivilegedLookup() {
            return new ForInstance(this.fieldName, this.cached, true, this.returning, this.assigner, this.invocationHandler);
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation andThen(Implementation implementation) {
            return new Implementation.Compound(new ForInstance(this.fieldName, this.cached, this.privileged, false, this.assigner, this.invocationHandler), implementation);
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation.Composable andThen(Implementation.Composable implementation) {
            return new Implementation.Compound.Composable(new ForInstance(this.fieldName, this.cached, this.privileged, false, this.assigner, this.invocationHandler), implementation);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            if (instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.fieldName).and(ElementMatchers.fieldType(InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE.asErasure()))).isEmpty()) {
                return instrumentedType.withField(new FieldDescription.Token(this.fieldName, 4169, InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE)).withInitializer(new LoadedTypeInitializer.ForStaticField(this.fieldName, this.invocationHandler));
            }
            throw new IllegalStateException("Field with name " + this.fieldName + " and type " + InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE.asErasure() + " already declared by " + instrumentedType);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target implementationTarget) {
            return new Appender(implementationTarget.getInstrumentedType());
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/InvocationHandlerAdapter$ForInstance$Appender.class */
        protected class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType) && ForInstance.this.equals(ForInstance.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + ForInstance.this.hashCode();
            }

            protected Appender(TypeDescription instrumentedType) {
                this.instrumentedType = instrumentedType;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
                return ForInstance.this.apply(methodVisitor, implementationContext, instrumentedMethod, StackManipulation.Trivial.INSTANCE, (FieldDescription) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(ForInstance.this.fieldName).and(ElementMatchers.genericFieldType(InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE))).getOnly());
            }
        }
    }

    /* access modifiers changed from: protected */
    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/InvocationHandlerAdapter$ForField.class */
    public static class ForField extends InvocationHandlerAdapter implements WithoutPrivilegeConfiguration {
        private final FieldLocator.Factory fieldLocatorFactory;

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public boolean equals(Object obj) {
            if (!equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fieldLocatorFactory.equals(((ForField) obj).fieldLocatorFactory);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public int hashCode() {
            return (hashCode() * 31) + this.fieldLocatorFactory.hashCode();
        }

        protected ForField(String fieldName, boolean cached, boolean privileged, boolean returning, Assigner assigner, FieldLocator.Factory fieldLocatorFactory) {
            super(fieldName, cached, privileged, returning, assigner);
            this.fieldLocatorFactory = fieldLocatorFactory;
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public WithoutPrivilegeConfiguration withoutMethodCache() {
            return new ForField(this.fieldName, false, this.privileged, this.returning, this.assigner, this.fieldLocatorFactory);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.AssignerConfigurable
        public Implementation.Composable withAssigner(Assigner assigner) {
            return new ForField(this.fieldName, this.cached, this.privileged, this.returning, assigner, this.fieldLocatorFactory);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.WithoutPrivilegeConfiguration
        public AssignerConfigurable withPrivilegedLookup() {
            return new ForField(this.fieldName, this.cached, true, this.returning, this.assigner, this.fieldLocatorFactory);
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation andThen(Implementation implementation) {
            return new Implementation.Compound(new ForField(this.fieldName, this.cached, this.privileged, false, this.assigner, this.fieldLocatorFactory), implementation);
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation.Composable andThen(Implementation.Composable implementation) {
            return new Implementation.Compound.Composable(new ForField(this.fieldName, this.cached, this.privileged, false, this.assigner, this.fieldLocatorFactory), implementation);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target implementationTarget) {
            FieldLocator.Resolution resolution = this.fieldLocatorFactory.make(implementationTarget.getInstrumentedType()).locate(this.fieldName);
            if (!resolution.isResolved()) {
                throw new IllegalStateException("Could not find a field named '" + this.fieldName + "' for " + implementationTarget.getInstrumentedType());
            } else if (resolution.getField().getType().asErasure().isAssignableTo(InvocationHandler.class)) {
                return new Appender(resolution.getField());
            } else {
                throw new IllegalStateException("Field " + resolution.getField() + " does not declare a type that is assignable to invocation handler");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/InvocationHandlerAdapter$ForField$Appender.class */
        protected class Appender implements ByteCodeAppender {
            private final FieldDescription fieldDescription;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Appender) obj).fieldDescription) && ForField.this.equals(ForField.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + ForField.this.hashCode();
            }

            protected Appender(FieldDescription fieldDescription) {
                this.fieldDescription = fieldDescription;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
                return ForField.this.apply(methodVisitor, implementationContext, instrumentedMethod, this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), this.fieldDescription);
            }
        }
    }
}
