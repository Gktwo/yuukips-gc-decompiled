package net.bytebuddy.implementation;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation.class */
public class MethodDelegation implements Implementation.Composable {
    private final ImplementationDelegate implementationDelegate;
    private final List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
    private final MethodDelegationBinder.AmbiguityResolver ambiguityResolver;
    private final MethodDelegationBinder.TerminationHandler terminationHandler;
    private final MethodDelegationBinder.BindingResolver bindingResolver;
    private final Assigner assigner;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.implementationDelegate.equals(((MethodDelegation) obj).implementationDelegate) && this.parameterBinders.equals(((MethodDelegation) obj).parameterBinders) && this.ambiguityResolver.equals(((MethodDelegation) obj).ambiguityResolver) && this.terminationHandler.equals(((MethodDelegation) obj).terminationHandler) && this.bindingResolver.equals(((MethodDelegation) obj).bindingResolver) && this.assigner.equals(((MethodDelegation) obj).assigner);
    }

    public int hashCode() {
        return (((((((((((getClass().hashCode() * 31) + this.implementationDelegate.hashCode()) * 31) + this.parameterBinders.hashCode()) * 31) + this.ambiguityResolver.hashCode()) * 31) + this.terminationHandler.hashCode()) * 31) + this.bindingResolver.hashCode()) * 31) + this.assigner.hashCode();
    }

    protected MethodDelegation(ImplementationDelegate implementationDelegate, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders, MethodDelegationBinder.AmbiguityResolver ambiguityResolver, MethodDelegationBinder.BindingResolver bindingResolver) {
        this(implementationDelegate, parameterBinders, ambiguityResolver, MethodDelegationBinder.TerminationHandler.Default.RETURNING, bindingResolver, Assigner.DEFAULT);
    }

    private MethodDelegation(ImplementationDelegate implementationDelegate, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders, MethodDelegationBinder.AmbiguityResolver ambiguityResolver, MethodDelegationBinder.TerminationHandler terminationHandler, MethodDelegationBinder.BindingResolver bindingResolver, Assigner assigner) {
        this.implementationDelegate = implementationDelegate;
        this.parameterBinders = parameterBinders;
        this.terminationHandler = terminationHandler;
        this.ambiguityResolver = ambiguityResolver;
        this.bindingResolver = bindingResolver;
        this.assigner = assigner;
    }

    /* renamed from: to */
    public static MethodDelegation m171to(Class<?> type) {
        return withDefaultConfiguration().m155to(type);
    }

    /* renamed from: to */
    public static MethodDelegation m158to(TypeDescription typeDescription) {
        return withDefaultConfiguration().m142to(typeDescription);
    }

    /* renamed from: to */
    public static MethodDelegation m170to(Object target) {
        return withDefaultConfiguration().m154to(target);
    }

    /* renamed from: to */
    public static MethodDelegation m159to(Object target, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().m143to(target, methodGraphCompiler);
    }

    /* renamed from: to */
    public static MethodDelegation m169to(Object target, String fieldName) {
        return withDefaultConfiguration().m153to(target, fieldName);
    }

    /* renamed from: to */
    public static MethodDelegation m168to(Object target, String fieldName, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().m152to(target, fieldName, methodGraphCompiler);
    }

    /* renamed from: to */
    public static MethodDelegation m167to(Object target, Type type) {
        return withDefaultConfiguration().m151to(target, type);
    }

    /* renamed from: to */
    public static MethodDelegation m164to(Object target, Type type, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().m148to(target, type, methodGraphCompiler);
    }

    /* renamed from: to */
    public static MethodDelegation m166to(Object target, Type type, String fieldName) {
        return withDefaultConfiguration().m150to(target, type, fieldName);
    }

    /* renamed from: to */
    public static MethodDelegation m165to(Object target, Type type, String fieldName, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().m149to(target, type, fieldName, methodGraphCompiler);
    }

    /* renamed from: to */
    public static MethodDelegation m163to(Object target, TypeDefinition typeDefinition) {
        return withDefaultConfiguration().m147to(target, typeDefinition);
    }

    /* renamed from: to */
    public static MethodDelegation m160to(Object target, TypeDefinition typeDefinition, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().m144to(target, typeDefinition, methodGraphCompiler);
    }

    /* renamed from: to */
    public static MethodDelegation m162to(Object target, TypeDefinition typeDefinition, String fieldName) {
        return withDefaultConfiguration().m146to(target, typeDefinition, fieldName);
    }

    /* renamed from: to */
    public static MethodDelegation m161to(Object target, TypeDefinition typeDefinition, String fieldName, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().m145to(target, typeDefinition, fieldName, methodGraphCompiler);
    }

    public static MethodDelegation toConstructor(Class<?> type) {
        return withDefaultConfiguration().toConstructor(type);
    }

    public static MethodDelegation toConstructor(TypeDescription typeDescription) {
        return withDefaultConfiguration().toConstructor(typeDescription);
    }

    public static MethodDelegation toField(String name) {
        return withDefaultConfiguration().toField(name);
    }

    public static MethodDelegation toField(String name, FieldLocator.Factory fieldLocatorFactory) {
        return withDefaultConfiguration().toField(name, fieldLocatorFactory);
    }

    public static MethodDelegation toField(String name, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().toField(name, methodGraphCompiler);
    }

    public static MethodDelegation toField(String name, FieldLocator.Factory fieldLocatorFactory, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().toField(name, fieldLocatorFactory, methodGraphCompiler);
    }

    public static MethodDelegation toMethodReturnOf(String name) {
        return withDefaultConfiguration().toMethodReturnOf(name);
    }

    public static MethodDelegation toMethodReturnOf(String name, MethodGraph.Compiler methodGraphCompiler) {
        return withDefaultConfiguration().toMethodReturnOf(name, methodGraphCompiler);
    }

    public static WithCustomProperties withDefaultConfiguration() {
        return new WithCustomProperties(MethodDelegationBinder.AmbiguityResolver.DEFAULT, TargetMethodAnnotationDrivenBinder.ParameterBinder.DEFAULTS);
    }

    public static WithCustomProperties withEmptyConfiguration() {
        return new WithCustomProperties(MethodDelegationBinder.AmbiguityResolver.NoOp.INSTANCE, Collections.emptyList());
    }

    public Implementation.Composable withAssigner(Assigner assigner) {
        return new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, this.terminationHandler, this.bindingResolver, assigner);
    }

    @Override // net.bytebuddy.implementation.Implementation.Composable
    public Implementation andThen(Implementation implementation) {
        return new Implementation.Compound(new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, MethodDelegationBinder.TerminationHandler.Default.DROPPING, this.bindingResolver, this.assigner), implementation);
    }

    @Override // net.bytebuddy.implementation.Implementation.Composable
    public Implementation.Composable andThen(Implementation.Composable implementation) {
        return new Implementation.Compound.Composable(new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, MethodDelegationBinder.TerminationHandler.Default.DROPPING, this.bindingResolver, this.assigner), implementation);
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return this.implementationDelegate.prepare(instrumentedType);
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target implementationTarget) {
        ImplementationDelegate.Compiled compiled = this.implementationDelegate.compile(implementationTarget.getInstrumentedType());
        return new Appender(implementationTarget, new MethodDelegationBinder.Processor(compiled.getRecords(), this.ambiguityResolver, this.bindingResolver), this.terminationHandler, this.assigner, compiled);
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate.class */
    public interface ImplementationDelegate extends InstrumentedType.Prepareable {
        public static final String FIELD_NAME_PREFIX = "delegate";

        Compiled compile(TypeDescription typeDescription);

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$Compiled.class */
        public interface Compiled {
            StackManipulation prepare(MethodDescription methodDescription);

            MethodDelegationBinder.MethodInvoker invoke();

            List<MethodDelegationBinder.Record> getRecords();

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$Compiled$ForStaticCall.class */
            public static class ForStaticCall implements Compiled {
                private final List<MethodDelegationBinder.Record> records;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.records.equals(((ForStaticCall) obj).records);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.records.hashCode();
                }

                protected ForStaticCall(List<MethodDelegationBinder.Record> records) {
                    this.records = records;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription instrumentedMethod) {
                    return StackManipulation.Trivial.INSTANCE;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return MethodDelegationBinder.MethodInvoker.Simple.INSTANCE;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$Compiled$ForField.class */
            public static class ForField implements Compiled {
                private final FieldDescription fieldDescription;
                private final List<MethodDelegationBinder.Record> records;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForField) obj).fieldDescription) && this.records.equals(((ForField) obj).records);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.fieldDescription.hashCode()) * 31) + this.records.hashCode();
                }

                protected ForField(FieldDescription fieldDescription, List<MethodDelegationBinder.Record> records) {
                    this.fieldDescription = fieldDescription;
                    this.records = records;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription instrumentedMethod) {
                    if (!instrumentedMethod.isStatic() || this.fieldDescription.isStatic()) {
                        StackManipulation[] stackManipulationArr = new StackManipulation[2];
                        stackManipulationArr[0] = this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis();
                        stackManipulationArr[1] = FieldAccess.forField(this.fieldDescription).read();
                        return new StackManipulation.Compound(stackManipulationArr);
                    }
                    throw new IllegalStateException("Cannot read " + this.fieldDescription + " from " + instrumentedMethod);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return new MethodDelegationBinder.MethodInvoker.Virtual(this.fieldDescription.getType().asErasure());
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$Compiled$ForMethodReturn.class */
            public static class ForMethodReturn implements Compiled {
                private final MethodDescription methodDescription;
                private final List<MethodDelegationBinder.Record> records;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForMethodReturn) obj).methodDescription) && this.records.equals(((ForMethodReturn) obj).records);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.records.hashCode();
                }

                protected ForMethodReturn(MethodDescription methodDescription, List<MethodDelegationBinder.Record> records) {
                    this.methodDescription = methodDescription;
                    this.records = records;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription instrumentedMethod) {
                    if (!instrumentedMethod.isStatic() || this.methodDescription.isStatic()) {
                        StackManipulation[] stackManipulationArr = new StackManipulation[2];
                        stackManipulationArr[0] = this.methodDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis();
                        stackManipulationArr[1] = MethodInvocation.invoke(this.methodDescription);
                        return new StackManipulation.Compound(stackManipulationArr);
                    }
                    throw new IllegalStateException("Cannot invoke " + this.methodDescription + " from " + instrumentedMethod);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return new MethodDelegationBinder.MethodInvoker.Virtual(this.methodDescription.getReturnType().asErasure());
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$Compiled$ForConstruction.class */
            public static class ForConstruction implements Compiled {
                private final TypeDescription typeDescription;
                private final List<MethodDelegationBinder.Record> records;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForConstruction) obj).typeDescription) && this.records.equals(((ForConstruction) obj).records);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.records.hashCode();
                }

                protected ForConstruction(TypeDescription typeDescription, List<MethodDelegationBinder.Record> records) {
                    this.typeDescription = typeDescription;
                    this.records = records;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription instrumentedMethod) {
                    return new StackManipulation.Compound(TypeCreation.m119of(this.typeDescription), Duplication.SINGLE);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return MethodDelegationBinder.MethodInvoker.Simple.INSTANCE;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$ForStaticMethod.class */
        public static class ForStaticMethod implements ImplementationDelegate {
            private final List<MethodDelegationBinder.Record> records;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.records.equals(((ForStaticMethod) obj).records);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.records.hashCode();
            }

            protected ForStaticMethod(List<MethodDelegationBinder.Record> records) {
                this.records = records;
            }

            /* renamed from: of */
            protected static ImplementationDelegate m156of(MethodList<?> methods, MethodDelegationBinder methodDelegationBinder) {
                List<MethodDelegationBinder.Record> records = new ArrayList<>(methods.size());
                Iterator it = methods.iterator();
                while (it.hasNext()) {
                    records.add(methodDelegationBinder.compile((MethodDescription) it.next()));
                }
                return new ForStaticMethod(records);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription instrumentedType) {
                return new Compiled.ForStaticCall(this.records);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$ForField.class */
        public static abstract class ForField implements ImplementationDelegate {
            protected final String fieldName;
            protected final MethodGraph.Compiler methodGraphCompiler;
            protected final List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
            protected final ElementMatcher<? super MethodDescription> matcher;

            protected abstract FieldDescription resolve(TypeDescription typeDescription);

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldName.equals(((ForField) obj).fieldName) && this.methodGraphCompiler.equals(((ForField) obj).methodGraphCompiler) && this.parameterBinders.equals(((ForField) obj).parameterBinders) && this.matcher.equals(((ForField) obj).matcher);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.fieldName.hashCode()) * 31) + this.methodGraphCompiler.hashCode()) * 31) + this.parameterBinders.hashCode()) * 31) + this.matcher.hashCode();
            }

            protected ForField(String fieldName, MethodGraph.Compiler methodGraphCompiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders, ElementMatcher<? super MethodDescription> matcher) {
                this.fieldName = fieldName;
                this.methodGraphCompiler = methodGraphCompiler;
                this.parameterBinders = parameterBinders;
                this.matcher = matcher;
            }

            /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription>, net.bytebuddy.matcher.ElementMatcher<? super T> */
            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription instrumentedType) {
                FieldDescription fieldDescription = resolve(instrumentedType);
                if (!fieldDescription.getType().asErasure().isVisibleTo(instrumentedType)) {
                    throw new IllegalStateException(fieldDescription + " is not visible to " + instrumentedType);
                }
                MethodList<MethodDescription> candidates = this.methodGraphCompiler.compile(fieldDescription.getType(), instrumentedType).listNodes().asMethodList().filter(this.matcher);
                List<MethodDelegationBinder.Record> records = new ArrayList<>(candidates.size());
                MethodDelegationBinder methodDelegationBinder = TargetMethodAnnotationDrivenBinder.m129of(this.parameterBinders);
                for (MethodDescription candidate : candidates) {
                    records.add(methodDelegationBinder.compile(candidate));
                }
                return new Compiled.ForField(fieldDescription, records);
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$ForField$WithInstance.class */
            public static class WithInstance extends ForField {
                private final Object target;
                private final TypeDescription.Generic fieldType;

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.target.equals(((WithInstance) obj).target) && this.fieldType.equals(((WithInstance) obj).fieldType);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public int hashCode() {
                    return (((hashCode() * 31) + this.target.hashCode()) * 31) + this.fieldType.hashCode();
                }

                protected WithInstance(String fieldName, MethodGraph.Compiler methodGraphCompiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders, ElementMatcher<? super MethodDescription> matcher, Object target, TypeDescription.Generic fieldType) {
                    super(fieldName, methodGraphCompiler, parameterBinders, matcher);
                    this.target = target;
                    this.fieldType = fieldType;
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    if (instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.fieldName).and(ElementMatchers.fieldType(this.fieldType.asErasure()))).isEmpty()) {
                        return instrumentedType.withField(new FieldDescription.Token(this.fieldName, 4169, this.fieldType)).withInitializer(new LoadedTypeInitializer.ForStaticField(this.fieldName, this.target));
                    }
                    throw new IllegalStateException("Field with name " + this.fieldName + " and type " + this.fieldType.asErasure() + " already declared by " + instrumentedType);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                protected FieldDescription resolve(TypeDescription instrumentedType) {
                    if (this.fieldType.asErasure().isVisibleTo(instrumentedType)) {
                        return (FieldDescription) instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.fieldName).and(ElementMatchers.fieldType(this.fieldType.asErasure()))).getOnly();
                    }
                    throw new IllegalStateException(this.fieldType + " is not visible to " + instrumentedType);
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$ForField$WithLookup.class */
            public static class WithLookup extends ForField {
                private final FieldLocator.Factory fieldLocatorFactory;

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldLocatorFactory.equals(((WithLookup) obj).fieldLocatorFactory);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public int hashCode() {
                    return (hashCode() * 31) + this.fieldLocatorFactory.hashCode();
                }

                protected WithLookup(String fieldName, MethodGraph.Compiler methodGraphCompiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders, ElementMatcher<? super MethodDescription> matcher, FieldLocator.Factory fieldLocatorFactory) {
                    super(fieldName, methodGraphCompiler, parameterBinders, matcher);
                    this.fieldLocatorFactory = fieldLocatorFactory;
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                protected FieldDescription resolve(TypeDescription instrumentedType) {
                    FieldLocator.Resolution resolution = this.fieldLocatorFactory.make(instrumentedType).locate(this.fieldName);
                    if (resolution.isResolved()) {
                        return resolution.getField();
                    }
                    throw new IllegalStateException("Could not locate " + this.fieldName + " on " + instrumentedType);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$ForMethodReturn.class */
        public static class ForMethodReturn implements ImplementationDelegate {
            private final String name;
            private final MethodGraph.Compiler methodGraphCompiler;
            private final List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
            private final ElementMatcher<? super MethodDescription> matcher;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.name.equals(((ForMethodReturn) obj).name) && this.methodGraphCompiler.equals(((ForMethodReturn) obj).methodGraphCompiler) && this.parameterBinders.equals(((ForMethodReturn) obj).parameterBinders) && this.matcher.equals(((ForMethodReturn) obj).matcher);
            }

            public int hashCode() {
                return (((((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.methodGraphCompiler.hashCode()) * 31) + this.parameterBinders.hashCode()) * 31) + this.matcher.hashCode();
            }

            protected ForMethodReturn(String name, MethodGraph.Compiler methodGraphCompiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders, ElementMatcher<? super MethodDescription> matcher) {
                this.name = name;
                this.methodGraphCompiler = methodGraphCompiler;
                this.parameterBinders = parameterBinders;
                this.matcher = matcher;
            }

            /* JADX DEBUG: Type inference failed for r1v13. Raw type applied. Possible types: net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription>, net.bytebuddy.matcher.ElementMatcher<? super T> */
            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription instrumentedType) {
                MethodList targets = new MethodList.Explicit(CompoundList.m80of(instrumentedType.getDeclaredMethods().filter(ElementMatchers.isStatic().mo105or(ElementMatchers.isPrivate())), (List) this.methodGraphCompiler.compile(instrumentedType).listNodes().asMethodList())).filter(ElementMatchers.named(this.name).and(ElementMatchers.takesArguments(0)).and(ElementMatchers.not(ElementMatchers.returns(ElementMatchers.isPrimitive().mo105or(ElementMatchers.isArray())))));
                if (targets.size() != 1) {
                    throw new IllegalStateException(instrumentedType + " does not define method without arguments with name " + this.name + ": " + targets);
                } else if (!((MethodDescription) targets.getOnly()).getReturnType().asErasure().isVisibleTo(instrumentedType)) {
                    throw new IllegalStateException(targets.getOnly() + " is not visible to " + instrumentedType);
                } else {
                    MethodList<MethodDescription> candidates = this.methodGraphCompiler.compile(((MethodDescription) targets.getOnly()).getReturnType(), instrumentedType).listNodes().asMethodList().filter(this.matcher);
                    List<MethodDelegationBinder.Record> records = new ArrayList<>(candidates.size());
                    MethodDelegationBinder methodDelegationBinder = TargetMethodAnnotationDrivenBinder.m129of(this.parameterBinders);
                    for (MethodDescription candidate : candidates) {
                        records.add(methodDelegationBinder.compile(candidate));
                    }
                    return new Compiled.ForMethodReturn((MethodDescription) targets.get(0), records);
                }
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$ImplementationDelegate$ForConstruction.class */
        public static class ForConstruction implements ImplementationDelegate {
            private final TypeDescription typeDescription;
            private final List<MethodDelegationBinder.Record> records;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForConstruction) obj).typeDescription) && this.records.equals(((ForConstruction) obj).records);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.records.hashCode();
            }

            protected ForConstruction(TypeDescription typeDescription, List<MethodDelegationBinder.Record> records) {
                this.typeDescription = typeDescription;
                this.records = records;
            }

            /* renamed from: of */
            protected static ImplementationDelegate m157of(TypeDescription typeDescription, MethodList<?> methods, MethodDelegationBinder methodDelegationBinder) {
                List<MethodDelegationBinder.Record> records = new ArrayList<>(methods.size());
                Iterator it = methods.iterator();
                while (it.hasNext()) {
                    records.add(methodDelegationBinder.compile((MethodDescription) it.next()));
                }
                return new ForConstruction(typeDescription, records);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription instrumentedType) {
                return new Compiled.ForConstruction(this.typeDescription, this.records);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$Appender.class */
    protected static class Appender implements ByteCodeAppender {
        private final Implementation.Target implementationTarget;
        private final MethodDelegationBinder.Record processor;
        private final MethodDelegationBinder.TerminationHandler terminationHandler;
        private final Assigner assigner;
        private final ImplementationDelegate.Compiled compiled;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.implementationTarget.equals(((Appender) obj).implementationTarget) && this.processor.equals(((Appender) obj).processor) && this.terminationHandler.equals(((Appender) obj).terminationHandler) && this.assigner.equals(((Appender) obj).assigner) && this.compiled.equals(((Appender) obj).compiled);
        }

        public int hashCode() {
            return (((((((((getClass().hashCode() * 31) + this.implementationTarget.hashCode()) * 31) + this.processor.hashCode()) * 31) + this.terminationHandler.hashCode()) * 31) + this.assigner.hashCode()) * 31) + this.compiled.hashCode();
        }

        protected Appender(Implementation.Target implementationTarget, MethodDelegationBinder.Record processor, MethodDelegationBinder.TerminationHandler terminationHandler, Assigner assigner, ImplementationDelegate.Compiled compiled) {
            this.implementationTarget = implementationTarget;
            this.processor = processor;
            this.terminationHandler = terminationHandler;
            this.assigner = assigner;
            this.compiled = compiled;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
            return new ByteCodeAppender.Size(new StackManipulation.Compound(this.compiled.prepare(instrumentedMethod), this.processor.bind(this.implementationTarget, instrumentedMethod, this.terminationHandler, this.compiled.invoke(), this.assigner)).apply(methodVisitor, implementationContext).getMaximalSize(), instrumentedMethod.getStackSize());
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/MethodDelegation$WithCustomProperties.class */
    public static class WithCustomProperties {
        private final MethodDelegationBinder.AmbiguityResolver ambiguityResolver;
        private final List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
        private final MethodDelegationBinder.BindingResolver bindingResolver;
        private final ElementMatcher<? super MethodDescription> matcher;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.ambiguityResolver.equals(((WithCustomProperties) obj).ambiguityResolver) && this.parameterBinders.equals(((WithCustomProperties) obj).parameterBinders) && this.bindingResolver.equals(((WithCustomProperties) obj).bindingResolver) && this.matcher.equals(((WithCustomProperties) obj).matcher);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.ambiguityResolver.hashCode()) * 31) + this.parameterBinders.hashCode()) * 31) + this.bindingResolver.hashCode()) * 31) + this.matcher.hashCode();
        }

        protected WithCustomProperties(MethodDelegationBinder.AmbiguityResolver ambiguityResolver, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders) {
            this(ambiguityResolver, parameterBinders, MethodDelegationBinder.BindingResolver.Default.INSTANCE, ElementMatchers.any());
        }

        private WithCustomProperties(MethodDelegationBinder.AmbiguityResolver ambiguityResolver, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders, MethodDelegationBinder.BindingResolver bindingResolver, ElementMatcher<? super MethodDescription> matcher) {
            this.ambiguityResolver = ambiguityResolver;
            this.parameterBinders = parameterBinders;
            this.bindingResolver = bindingResolver;
            this.matcher = matcher;
        }

        public WithCustomProperties withResolvers(MethodDelegationBinder.AmbiguityResolver... ambiguityResolver) {
            return withResolvers(Arrays.asList(ambiguityResolver));
        }

        public WithCustomProperties withResolvers(List<? extends MethodDelegationBinder.AmbiguityResolver> ambiguityResolvers) {
            return new WithCustomProperties(new MethodDelegationBinder.AmbiguityResolver.Compound(CompoundList.m82of(this.ambiguityResolver, ambiguityResolvers)), this.parameterBinders, this.bindingResolver, this.matcher);
        }

        public WithCustomProperties withBinders(TargetMethodAnnotationDrivenBinder.ParameterBinder<?>... parameterBinder) {
            return withBinders(Arrays.asList(parameterBinder));
        }

        public WithCustomProperties withBinders(List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders) {
            return new WithCustomProperties(this.ambiguityResolver, CompoundList.m80of((List) this.parameterBinders, (List) parameterBinders), this.bindingResolver, this.matcher);
        }

        public WithCustomProperties withBindingResolver(MethodDelegationBinder.BindingResolver bindingResolver) {
            return new WithCustomProperties(this.ambiguityResolver, this.parameterBinders, bindingResolver, this.matcher);
        }

        public WithCustomProperties filter(ElementMatcher<? super MethodDescription> matcher) {
            return new WithCustomProperties(this.ambiguityResolver, this.parameterBinders, this.bindingResolver, new ElementMatcher.Junction.Conjunction(this.matcher, matcher));
        }

        /* renamed from: to */
        public MethodDelegation m155to(Class<?> type) {
            return m142to(TypeDescription.ForLoadedType.m247of(type));
        }

        /* renamed from: to */
        public MethodDelegation m142to(TypeDescription typeDescription) {
            if (typeDescription.isArray()) {
                throw new IllegalArgumentException("Cannot delegate to array " + typeDescription);
            } else if (!typeDescription.isPrimitive()) {
                return new MethodDelegation(ImplementationDelegate.ForStaticMethod.m156of(typeDescription.getDeclaredMethods().filter(ElementMatchers.isStatic().and(this.matcher)), TargetMethodAnnotationDrivenBinder.m129of(this.parameterBinders)), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
            } else {
                throw new IllegalArgumentException("Cannot delegate to primitive " + typeDescription);
            }
        }

        /* renamed from: to */
        public MethodDelegation m154to(Object target) {
            return m143to(target, MethodGraph.Compiler.DEFAULT);
        }

        /* renamed from: to */
        public MethodDelegation m143to(Object target, MethodGraph.Compiler methodGraphCompiler) {
            return m148to(target, target.getClass(), methodGraphCompiler);
        }

        /* renamed from: to */
        public MethodDelegation m153to(Object target, String fieldName) {
            return m152to(target, fieldName, MethodGraph.Compiler.DEFAULT);
        }

        /* renamed from: to */
        public MethodDelegation m152to(Object target, String fieldName, MethodGraph.Compiler methodGraphCompiler) {
            return m149to(target, target.getClass(), fieldName, methodGraphCompiler);
        }

        /* renamed from: to */
        public MethodDelegation m151to(Object target, Type type) {
            return m148to(target, type, MethodGraph.Compiler.DEFAULT);
        }

        /* renamed from: to */
        public MethodDelegation m148to(Object target, Type type, MethodGraph.Compiler methodGraphCompiler) {
            return m149to(target, type, "delegate$" + RandomString.hashOf(target.getClass().hashCode() ^ target.hashCode()), methodGraphCompiler);
        }

        /* renamed from: to */
        public MethodDelegation m150to(Object target, Type type, String fieldName) {
            return m149to(target, type, fieldName, MethodGraph.Compiler.DEFAULT);
        }

        /* renamed from: to */
        public MethodDelegation m149to(Object target, Type type, String fieldName, MethodGraph.Compiler methodGraphCompiler) {
            return m145to(target, TypeDefinition.Sort.describe(type), fieldName, methodGraphCompiler);
        }

        /* renamed from: to */
        public MethodDelegation m147to(Object target, TypeDefinition typeDefinition) {
            return m144to(target, typeDefinition, MethodGraph.Compiler.DEFAULT);
        }

        /* renamed from: to */
        public MethodDelegation m144to(Object target, TypeDefinition typeDefinition, MethodGraph.Compiler methodGraphCompiler) {
            return m145to(target, typeDefinition, "delegate$" + RandomString.hashOf(target.getClass().hashCode() ^ target.hashCode()), methodGraphCompiler);
        }

        /* renamed from: to */
        public MethodDelegation m146to(Object target, TypeDefinition typeDefinition, String fieldName) {
            return m145to(target, typeDefinition, fieldName, MethodGraph.Compiler.DEFAULT);
        }

        /* renamed from: to */
        public MethodDelegation m145to(Object target, TypeDefinition typeDefinition, String fieldName, MethodGraph.Compiler methodGraphCompiler) {
            if (typeDefinition.asErasure().isInstance(target)) {
                return new MethodDelegation(new ImplementationDelegate.ForField.WithInstance(fieldName, methodGraphCompiler, this.parameterBinders, this.matcher, target, typeDefinition.asGenericType()), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
            }
            throw new IllegalArgumentException(target + " is not an instance of " + typeDefinition);
        }

        public MethodDelegation toConstructor(Class<?> type) {
            return toConstructor(TypeDescription.ForLoadedType.m247of(type));
        }

        public MethodDelegation toConstructor(TypeDescription typeDescription) {
            return new MethodDelegation(ImplementationDelegate.ForConstruction.m157of(typeDescription, typeDescription.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(this.matcher)), TargetMethodAnnotationDrivenBinder.m129of(this.parameterBinders)), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
        }

        public MethodDelegation toField(String name) {
            return toField(name, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
        }

        public MethodDelegation toField(String name, FieldLocator.Factory fieldLocatorFactory) {
            return toField(name, fieldLocatorFactory, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation toField(String name, MethodGraph.Compiler methodGraphCompiler) {
            return toField(name, FieldLocator.ForClassHierarchy.Factory.INSTANCE, methodGraphCompiler);
        }

        public MethodDelegation toField(String name, FieldLocator.Factory fieldLocatorFactory, MethodGraph.Compiler methodGraphCompiler) {
            return new MethodDelegation(new ImplementationDelegate.ForField.WithLookup(name, methodGraphCompiler, this.parameterBinders, this.matcher, fieldLocatorFactory), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
        }

        public MethodDelegation toMethodReturnOf(String name) {
            return toMethodReturnOf(name, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation toMethodReturnOf(String name, MethodGraph.Compiler methodGraphCompiler) {
            return new MethodDelegation(new ImplementationDelegate.ForMethodReturn(name, methodGraphCompiler, this.parameterBinders, this.matcher), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
        }
    }
}
