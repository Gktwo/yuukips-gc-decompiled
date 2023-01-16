package net.bytebuddy.implementation.bind;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bind/MethodNameEqualityResolver.class */
public enum MethodNameEqualityResolver implements MethodDelegationBinder.AmbiguityResolver {
    INSTANCE;

    @Override // net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver
    public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription source, MethodDelegationBinder.MethodBinding left, MethodDelegationBinder.MethodBinding right) {
        boolean leftEquals = left.getTarget().getName().equals(source.getName());
        if (leftEquals ^ right.getTarget().getName().equals(source.getName())) {
            return leftEquals ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
        }
        return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS;
    }
}
