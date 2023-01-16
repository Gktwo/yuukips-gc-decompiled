package net.bytebuddy.dynamic.scaffold.inline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.CompoundList;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/inline/RebaseImplementationTarget.class */
public class RebaseImplementationTarget extends Implementation.Target.AbstractBase {
    private final Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> rebaseableMethods;

    @Override // net.bytebuddy.implementation.Implementation.Target.AbstractBase
    public boolean equals(Object obj) {
        if (!equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.rebaseableMethods.equals(((RebaseImplementationTarget) obj).rebaseableMethods);
    }

    @Override // net.bytebuddy.implementation.Implementation.Target.AbstractBase
    public int hashCode() {
        return (hashCode() * 31) + this.rebaseableMethods.hashCode();
    }

    protected RebaseImplementationTarget(TypeDescription instrumentedType, MethodGraph.Linked methodGraph, Implementation.Target.AbstractBase.DefaultMethodInvocation defaultMethodInvocation, Map<MethodDescription.SignatureToken, MethodRebaseResolver.Resolution> rebaseableMethods) {
        super(instrumentedType, methodGraph, defaultMethodInvocation);
        this.rebaseableMethods = rebaseableMethods;
    }

    /* renamed from: of */
    protected static Implementation.Target m198of(TypeDescription instrumentedType, MethodGraph.Linked methodGraph, ClassFileVersion classFileVersion, MethodRebaseResolver methodRebaseResolver) {
        return new RebaseImplementationTarget(instrumentedType, methodGraph, Implementation.Target.AbstractBase.DefaultMethodInvocation.m183of(classFileVersion), methodRebaseResolver.asTokenMap());
    }

    @Override // net.bytebuddy.implementation.Implementation.Target
    public Implementation.SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken token) {
        MethodRebaseResolver.Resolution resolution = this.rebaseableMethods.get(token);
        if (resolution == null) {
            return invokeSuper(this.methodGraph.getSuperClassGraph().locate(token));
        }
        return invokeSuper(resolution);
    }

    private Implementation.SpecialMethodInvocation invokeSuper(MethodGraph.Node node) {
        return node.getSort().isResolved() ? Implementation.SpecialMethodInvocation.Simple.m184of(node.getRepresentative(), this.instrumentedType.getSuperClass().asErasure()) : Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
    }

    private Implementation.SpecialMethodInvocation invokeSuper(MethodRebaseResolver.Resolution resolution) {
        if (resolution.isRebased()) {
            return RebasedMethodInvocation.m197of(resolution.getResolvedMethod(), this.instrumentedType, resolution.getPrependedParameters());
        }
        return Implementation.SpecialMethodInvocation.Simple.m184of(resolution.getResolvedMethod(), this.instrumentedType);
    }

    @Override // net.bytebuddy.implementation.Implementation.Target
    public TypeDescription getOriginType() {
        return this.instrumentedType;
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/inline/RebaseImplementationTarget$RebasedMethodInvocation.class */
    public static class RebasedMethodInvocation extends Implementation.SpecialMethodInvocation.AbstractBase {
        private final MethodDescription methodDescription;
        private final TypeDescription instrumentedType;
        private final StackManipulation stackManipulation;
        private final TypeList prependedParameters;

        protected RebasedMethodInvocation(MethodDescription methodDescription, TypeDescription instrumentedType, StackManipulation stackManipulation, TypeList prependedParameters) {
            this.methodDescription = methodDescription;
            this.instrumentedType = instrumentedType;
            this.stackManipulation = stackManipulation;
            this.prependedParameters = prependedParameters;
        }

        /* renamed from: of */
        protected static Implementation.SpecialMethodInvocation m197of(MethodDescription resolvedMethod, TypeDescription instrumentedType, TypeList prependedParameters) {
            StackManipulation stackManipulation;
            if (resolvedMethod.isStatic()) {
                stackManipulation = MethodInvocation.invoke(resolvedMethod);
            } else {
                stackManipulation = MethodInvocation.invoke(resolvedMethod).special(instrumentedType);
            }
            if (!stackManipulation.isValid()) {
                return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
            }
            List<StackManipulation> stackManipulations = new ArrayList<>(prependedParameters.size() + 1);
            Iterator it = prependedParameters.iterator();
            while (it.hasNext()) {
                stackManipulations.add(DefaultValue.m113of((TypeDescription) it.next()));
            }
            stackManipulations.add(stackManipulation);
            return new RebasedMethodInvocation(resolvedMethod, instrumentedType, new StackManipulation.Compound(stackManipulations), prependedParameters);
        }

        @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
        public MethodDescription getMethodDescription() {
            return this.methodDescription;
        }

        @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
        public TypeDescription getTypeDescription() {
            return this.instrumentedType;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            return this.stackManipulation.apply(methodVisitor, implementationContext);
        }

        @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
        public Implementation.SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken token) {
            if (this.methodDescription.asTypeToken().equals(new MethodDescription.TypeToken(token.getReturnType(), CompoundList.m80of((List) token.getParameterTypes(), (List) this.prependedParameters)))) {
                return this;
            }
            return Implementation.SpecialMethodInvocation.Illegal.INSTANCE;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/inline/RebaseImplementationTarget$Factory.class */
    public static class Factory implements Implementation.Target.Factory {
        private final MethodRebaseResolver methodRebaseResolver;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.methodRebaseResolver.equals(((Factory) obj).methodRebaseResolver);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.methodRebaseResolver.hashCode();
        }

        public Factory(MethodRebaseResolver methodRebaseResolver) {
            this.methodRebaseResolver = methodRebaseResolver;
        }

        @Override // net.bytebuddy.implementation.Implementation.Target.Factory
        public Implementation.Target make(TypeDescription instrumentedType, MethodGraph.Linked methodGraph, ClassFileVersion classFileVersion) {
            return RebaseImplementationTarget.m198of(instrumentedType, methodGraph, classFileVersion, this.methodRebaseResolver);
        }
    }
}
