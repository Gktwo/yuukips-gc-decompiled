package net.bytebuddy.implementation.auxiliary;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/auxiliary/MethodCallProxy.class */
public class MethodCallProxy implements AuxiliaryType {
    private static final String FIELD_NAME_PREFIX = "argument";
    private final Implementation.SpecialMethodInvocation specialMethodInvocation;
    private final boolean serializableProxy;
    private final Assigner assigner;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.serializableProxy == ((MethodCallProxy) obj).serializableProxy && this.specialMethodInvocation.equals(((MethodCallProxy) obj).specialMethodInvocation) && this.assigner.equals(((MethodCallProxy) obj).assigner);
    }

    public int hashCode() {
        return (((((getClass().hashCode() * 31) + this.specialMethodInvocation.hashCode()) * 31) + (this.serializableProxy ? 1 : 0)) * 31) + this.assigner.hashCode();
    }

    public MethodCallProxy(Implementation.SpecialMethodInvocation specialMethodInvocation, boolean serializableProxy) {
        this(specialMethodInvocation, serializableProxy, Assigner.DEFAULT);
    }

    public MethodCallProxy(Implementation.SpecialMethodInvocation specialMethodInvocation, boolean serializableProxy, Assigner assigner) {
        this.specialMethodInvocation = specialMethodInvocation;
        this.serializableProxy = serializableProxy;
        this.assigner = assigner;
    }

    private static LinkedHashMap<String, TypeDescription> extractFields(MethodDescription methodDescription) {
        LinkedHashMap<String, TypeDescription> typeDescriptions = new LinkedHashMap<>();
        int currentIndex = 0;
        if (!methodDescription.isStatic()) {
            currentIndex = 0 + 1;
            typeDescriptions.put(fieldName(0), methodDescription.getDeclaringType().asErasure());
        }
        Iterator it = methodDescription.getParameters().iterator();
        while (it.hasNext()) {
            currentIndex++;
            typeDescriptions.put(fieldName(currentIndex), ((ParameterDescription) it.next()).getType().asErasure());
        }
        return typeDescriptions;
    }

    private static String fieldName(int index) {
        return FIELD_NAME_PREFIX + index;
    }

    @Override // net.bytebuddy.implementation.auxiliary.AuxiliaryType
    public DynamicType make(String auxiliaryTypeName, ClassFileVersion classFileVersion, MethodAccessorFactory methodAccessorFactory) {
        MethodDescription accessorMethod = methodAccessorFactory.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.DEFAULT);
        LinkedHashMap<String, TypeDescription> parameterFields = extractFields(accessorMethod);
        DynamicType.Builder<?> builder = new ByteBuddy(classFileVersion).with(TypeValidation.DISABLED).with(PrecomputedMethodGraph.INSTANCE).subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name(auxiliaryTypeName).modifiers(DEFAULT_TYPE_MODIFIER).implement(Runnable.class, Callable.class).intercept(new MethodCall(accessorMethod, this.assigner)).implement(this.serializableProxy ? new Class[]{Serializable.class} : new Class[0]).defineConstructor(new ModifierContributor.ForMethod[0]).withParameters(parameterFields.values()).intercept(ConstructorCall.INSTANCE);
        for (Map.Entry<String, TypeDescription> field : parameterFields.entrySet()) {
            builder = builder.defineField(field.getKey(), field.getValue(), Visibility.PRIVATE);
        }
        return builder.make();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/auxiliary/MethodCallProxy$PrecomputedMethodGraph.class */
    protected enum PrecomputedMethodGraph implements MethodGraph.Compiler {
        INSTANCE;
        
        private final MethodGraph.Linked methodGraph;

        @SuppressFBWarnings(value = {"SE_BAD_FIELD_STORE"}, justification = "Precomputed method graph is not intended for serialization")
        PrecomputedMethodGraph() {
            LinkedHashMap<MethodDescription.SignatureToken, MethodGraph.Node> nodes = new LinkedHashMap<>();
            MethodDescription callMethod = new MethodDescription.Latent(TypeDescription.ForLoadedType.m247of(Callable.class), "call", 1025, Collections.emptyList(), TypeDescription.Generic.OBJECT, Collections.emptyList(), Collections.singletonList(TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(Exception.class)), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
            nodes.put(callMethod.asSignatureToken(), new MethodGraph.Node.Simple(callMethod));
            MethodDescription runMethod = new MethodDescription.Latent(TypeDescription.ForLoadedType.m247of(Runnable.class), "run", 1025, Collections.emptyList(), TypeDescription.Generic.VOID, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
            nodes.put(runMethod.asSignatureToken(), new MethodGraph.Node.Simple(runMethod));
            MethodGraph methodGraph = new MethodGraph.Simple(nodes);
            this.methodGraph = new MethodGraph.Linked.Delegation(methodGraph, methodGraph, Collections.emptyMap());
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
        public MethodGraph.Linked compile(TypeDescription typeDescription) {
            return compile(typeDescription, typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler
        public MethodGraph.Linked compile(TypeDefinition typeDefinition, TypeDescription viewPoint) {
            return this.methodGraph;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/auxiliary/MethodCallProxy$ConstructorCall.class */
    protected enum ConstructorCall implements Implementation {
        INSTANCE;
        
        private final MethodDescription objectTypeDefaultConstructor = (MethodDescription) TypeDescription.OBJECT.getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly();

        ConstructorCall() {
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target implementationTarget) {
            return new Appender(implementationTarget.getInstrumentedType());
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/auxiliary/MethodCallProxy$ConstructorCall$Appender.class */
        protected static class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.instrumentedType.hashCode();
            }

            private Appender(TypeDescription instrumentedType) {
                this.instrumentedType = instrumentedType;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
                FieldList<?> fieldList = this.instrumentedType.getDeclaredFields();
                StackManipulation[] fieldLoading = new StackManipulation[fieldList.size()];
                int index = 0;
                Iterator it = fieldList.iterator();
                while (it.hasNext()) {
                    fieldLoading[index] = new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodVariableAccess.load((ParameterDescription) instrumentedMethod.getParameters().get(index)), FieldAccess.forField((FieldDescription) it.next()).write());
                    index++;
                }
                return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(ConstructorCall.INSTANCE.objectTypeDefaultConstructor), new StackManipulation.Compound(fieldLoading), MethodReturn.VOID).apply(methodVisitor, implementationContext).getMaximalSize(), instrumentedMethod.getStackSize());
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/auxiliary/MethodCallProxy$MethodCall.class */
    protected static class MethodCall implements Implementation {
        private final MethodDescription accessorMethod;
        private final Assigner assigner;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.accessorMethod.equals(((MethodCall) obj).accessorMethod) && this.assigner.equals(((MethodCall) obj).assigner);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.accessorMethod.hashCode()) * 31) + this.assigner.hashCode();
        }

        protected MethodCall(MethodDescription accessorMethod, Assigner assigner) {
            this.accessorMethod = accessorMethod;
            this.assigner = assigner;
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target implementationTarget) {
            return new Appender(implementationTarget.getInstrumentedType());
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/auxiliary/MethodCallProxy$MethodCall$Appender.class */
        protected class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType) && MethodCall.this.equals(MethodCall.this);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + MethodCall.this.hashCode();
            }

            private Appender(TypeDescription instrumentedType) {
                this.instrumentedType = instrumentedType;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
                FieldList<?> fieldList = this.instrumentedType.getDeclaredFields();
                List<StackManipulation> fieldLoadings = new ArrayList<>(fieldList.size());
                Iterator it = fieldList.iterator();
                while (it.hasNext()) {
                    fieldLoadings.add(new StackManipulation.Compound(MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription) it.next()).read()));
                }
                return new ByteCodeAppender.Size(new StackManipulation.Compound(new StackManipulation.Compound(fieldLoadings), MethodInvocation.invoke(MethodCall.this.accessorMethod), MethodCall.this.assigner.assign(MethodCall.this.accessorMethod.getReturnType(), instrumentedMethod.getReturnType(), Assigner.Typing.DYNAMIC), MethodReturn.m108of(instrumentedMethod.getReturnType())).apply(methodVisitor, implementationContext).getMaximalSize(), instrumentedMethod.getStackSize());
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/auxiliary/MethodCallProxy$AssignableSignatureCall.class */
    public static class AssignableSignatureCall implements StackManipulation {
        private final Implementation.SpecialMethodInvocation specialMethodInvocation;
        private final boolean serializable;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.serializable == ((AssignableSignatureCall) obj).serializable && this.specialMethodInvocation.equals(((AssignableSignatureCall) obj).specialMethodInvocation);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.specialMethodInvocation.hashCode()) * 31) + (this.serializable ? 1 : 0);
        }

        public AssignableSignatureCall(Implementation.SpecialMethodInvocation specialMethodInvocation, boolean serializable) {
            this.specialMethodInvocation = specialMethodInvocation;
            this.serializable = serializable;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            TypeDescription auxiliaryType = implementationContext.register(new MethodCallProxy(this.specialMethodInvocation, this.serializable));
            return new StackManipulation.Compound(TypeCreation.m119of(auxiliaryType), Duplication.SINGLE, MethodVariableAccess.allArgumentsOf(this.specialMethodInvocation.getMethodDescription()).prependThisReference(), MethodInvocation.invoke((MethodDescription.InDefinedShape) auxiliaryType.getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly())).apply(methodVisitor, implementationContext);
        }
    }
}
