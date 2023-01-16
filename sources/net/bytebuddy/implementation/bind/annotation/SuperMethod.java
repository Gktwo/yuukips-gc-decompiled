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
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
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

@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/SuperMethod.class */
public @interface SuperMethod {
    boolean cached() default true;

    boolean privileged() default false;

    boolean fallbackToDefault() default true;

    boolean nullIfImpossible() default false;

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/SuperMethod$Binder.class */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperMethod> {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<SuperMethod> getHandledType() {
            return SuperMethod.class;
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperMethod> annotation, MethodDescription source, ParameterDescription target, Implementation.Target implementationTarget, Assigner assigner, Assigner.Typing typing) {
            Implementation.SpecialMethodInvocation specialMethodInvocation;
            if (!target.getType().asErasure().isAssignableFrom(Method.class)) {
                throw new IllegalStateException("Cannot assign Method type to " + target);
            } else if (source.isMethod()) {
                if (annotation.load().fallbackToDefault()) {
                    specialMethodInvocation = implementationTarget.invokeDominant(source.asSignatureToken());
                } else {
                    specialMethodInvocation = implementationTarget.invokeSuper(source.asSignatureToken());
                }
                Implementation.SpecialMethodInvocation specialMethodInvocation2 = specialMethodInvocation.withCheckedCompatibilityTo(source.asTypeToken());
                if (specialMethodInvocation2.isValid()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(new DelegationMethod(specialMethodInvocation2, annotation.load().cached(), annotation.load().privileged()));
                }
                if (annotation.load().nullIfImpossible()) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
                }
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else if (annotation.load().nullIfImpossible()) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE);
            } else {
                return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/SuperMethod$Binder$DelegationMethod.class */
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
