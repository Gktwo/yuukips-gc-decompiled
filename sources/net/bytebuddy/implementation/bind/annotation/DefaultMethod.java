package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;

@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/DefaultMethod.class */
public @interface DefaultMethod {
    boolean cached() default true;

    boolean privileged() default false;

    Class<?> targetType() default void.class;

    boolean nullIfImpossible() default false;

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/DefaultMethod$Binder.class */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultMethod> {
        INSTANCE;
        
        private static final MethodDescription.InDefinedShape CACHED;
        private static final MethodDescription.InDefinedShape PRIVILEGED;
        private static final MethodDescription.InDefinedShape TARGET_TYPE;
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE;

        static {
            MethodList<MethodDescription.InDefinedShape> methodList = TypeDescription.ForLoadedType.m247of(DefaultMethod.class).getDeclaredMethods();
            CACHED = (MethodDescription.InDefinedShape) methodList.filter(ElementMatchers.named("cached")).getOnly();
            PRIVILEGED = (MethodDescription.InDefinedShape) methodList.filter(ElementMatchers.named("privileged")).getOnly();
            TARGET_TYPE = (MethodDescription.InDefinedShape) methodList.filter(ElementMatchers.named("targetType")).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) methodList.filter(ElementMatchers.named("nullIfImpossible")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<DefaultMethod> getHandledType() {
            return DefaultMethod.class;
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultMethod> annotation, MethodDescription source, ParameterDescription target, Implementation.Target implementationTarget, Assigner assigner, Assigner.Typing typing) {
            if (!target.getType().asErasure().isAssignableFrom(Method.class)) {
                throw new IllegalStateException("Cannot assign Method type to " + target);
            } else if (source.isMethod()) {
                TypeDescription typeDescription = (TypeDescription) annotation.getValue(TARGET_TYPE).resolve(TypeDescription.class);
                Implementation.SpecialMethodInvocation specialMethodInvocation = (typeDescription.represents(Void.TYPE) ? MethodLocator.ForImplicitType.INSTANCE : new MethodLocator.ForExplicitType(typeDescription)).resolve(implementationTarget, source).withCheckedCompatibilityTo(source.asTypeToken());
                if (specialMethodInvocation.isValid()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(new DelegationMethod(specialMethodInvocation, ((Boolean) annotation.getValue(CACHED).resolve(Boolean.class)).booleanValue(), ((Boolean) annotation.getValue(PRIVILEGED).resolve(Boolean.class)).booleanValue()));
                }
                if (((Boolean) annotation.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
                }
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else if (((Boolean) annotation.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
            } else {
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/DefaultMethod$Binder$MethodLocator.class */
        protected interface MethodLocator {
            Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription);

            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/DefaultMethod$Binder$MethodLocator$ForImplicitType.class */
            public enum ForImplicitType implements MethodLocator {
                INSTANCE;

                @Override // net.bytebuddy.implementation.bind.annotation.DefaultMethod.Binder.MethodLocator
                public Implementation.SpecialMethodInvocation resolve(Implementation.Target implementationTarget, MethodDescription source) {
                    return implementationTarget.invokeDefault(source.asSignatureToken());
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/DefaultMethod$Binder$MethodLocator$ForExplicitType.class */
            public static class ForExplicitType implements MethodLocator {
                private final TypeDescription typeDescription;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForExplicitType) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                protected ForExplicitType(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                @Override // net.bytebuddy.implementation.bind.annotation.DefaultMethod.Binder.MethodLocator
                public Implementation.SpecialMethodInvocation resolve(Implementation.Target implementationTarget, MethodDescription source) {
                    if (this.typeDescription.isInterface()) {
                        return implementationTarget.invokeDefault(source.asSignatureToken(), TargetType.resolve(this.typeDescription, implementationTarget.getInstrumentedType()));
                    }
                    throw new IllegalStateException(source + " method carries default method call parameter on non-interface type");
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/DefaultMethod$Binder$DelegationMethod.class */
        protected static class DelegationMethod implements StackManipulation {
            private final Implementation.SpecialMethodInvocation specialMethodInvocation;
            private final boolean cached;
            private final boolean privileged;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.cached == ((DelegationMethod) obj).cached && this.privileged == ((DelegationMethod) obj).privileged && this.specialMethodInvocation.equals(((DelegationMethod) obj).specialMethodInvocation);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.specialMethodInvocation.hashCode()) * 31) + (this.cached ? 1 : 0)) * 31) + (this.privileged ? 1 : 0);
            }

            protected DelegationMethod(Implementation.SpecialMethodInvocation specialMethodInvocation, boolean cached, boolean privileged) {
                this.specialMethodInvocation = specialMethodInvocation;
                this.cached = cached;
                this.privileged = privileged;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public boolean isValid() {
                return this.specialMethodInvocation.isValid();
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                StackManipulation methodConstant;
                if (this.privileged) {
                    methodConstant = MethodConstant.ofPrivileged(implementationContext.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC));
                } else {
                    methodConstant = MethodConstant.m112of(implementationContext.registerAccessorFor(this.specialMethodInvocation, MethodAccessorFactory.AccessType.PUBLIC));
                }
                return (this.cached ? FieldAccess.forField(implementationContext.cache(methodConstant, TypeDescription.ForLoadedType.m247of(Method.class))).read() : methodConstant).apply(methodVisitor, implementationContext);
            }
        }
    }
}
