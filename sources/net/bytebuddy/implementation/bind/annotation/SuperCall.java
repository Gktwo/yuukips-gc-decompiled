package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Callable;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;

@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/SuperCall.class */
public @interface SuperCall {
    boolean serializableProxy() default false;

    boolean fallbackToDefault() default true;

    boolean nullIfImpossible() default false;

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/annotation/SuperCall$Binder.class */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperCall> {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<SuperCall> getHandledType() {
            return SuperCall.class;
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperCall> annotation, MethodDescription source, ParameterDescription target, Implementation.Target implementationTarget, Assigner assigner, Assigner.Typing typing) {
            Implementation.SpecialMethodInvocation specialMethodInvocation;
            StackManipulation stackManipulation;
            TypeDescription targetType = target.getType().asErasure();
            if (!targetType.represents(Runnable.class) && !targetType.represents(Callable.class) && !targetType.represents(Object.class)) {
                throw new IllegalStateException("A super method call proxy can only be assigned to Runnable or Callable types: " + target);
            } else if (source.isConstructor()) {
                return annotation.load().nullIfImpossible() ? new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            } else {
                if (annotation.load().fallbackToDefault()) {
                    specialMethodInvocation = implementationTarget.invokeDominant(source.asSignatureToken());
                } else {
                    specialMethodInvocation = implementationTarget.invokeSuper(source.asSignatureToken());
                }
                Implementation.SpecialMethodInvocation specialMethodInvocation2 = specialMethodInvocation.withCheckedCompatibilityTo(source.asTypeToken());
                if (specialMethodInvocation2.isValid()) {
                    stackManipulation = new MethodCallProxy.AssignableSignatureCall(specialMethodInvocation2, annotation.load().serializableProxy());
                } else if (!annotation.load().nullIfImpossible()) {
                    return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
                } else {
                    stackManipulation = NullConstant.INSTANCE;
                }
                return new MethodDelegationBinder.ParameterBinding.Anonymous(stackManipulation);
            }
        }
    }
}
