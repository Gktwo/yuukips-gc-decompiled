package net.bytebuddy.dynamic.scaffold.inline;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/inline/InliningImplementationMatcher.class */
public class InliningImplementationMatcher implements LatentMatcher<MethodDescription> {
    private final LatentMatcher<? super MethodDescription> ignoredMethods;
    private final ElementMatcher<? super MethodDescription> predefinedMethodSignatures;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.ignoredMethods.equals(((InliningImplementationMatcher) obj).ignoredMethods) && this.predefinedMethodSignatures.equals(((InliningImplementationMatcher) obj).predefinedMethodSignatures);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.ignoredMethods.hashCode()) * 31) + this.predefinedMethodSignatures.hashCode();
    }

    protected InliningImplementationMatcher(LatentMatcher<? super MethodDescription> ignoredMethods, ElementMatcher<? super MethodDescription> predefinedMethodSignatures) {
        this.ignoredMethods = ignoredMethods;
        this.predefinedMethodSignatures = predefinedMethodSignatures;
    }

    /* access modifiers changed from: protected */
    /* renamed from: of */
    public static LatentMatcher<MethodDescription> m201of(LatentMatcher<? super MethodDescription> ignoredMethods, TypeDescription originalType) {
        ElementMatcher.Junction<MethodDescription> signature;
        ElementMatcher.Junction<MethodDescription> predefinedMethodSignatures = ElementMatchers.none();
        for (MethodDescription methodDescription : originalType.getDeclaredMethods()) {
            if (methodDescription.isConstructor()) {
                signature = ElementMatchers.isConstructor();
            } else {
                signature = ElementMatchers.named(methodDescription.getName());
            }
            predefinedMethodSignatures = predefinedMethodSignatures.mo105or(signature.and(ElementMatchers.returns(methodDescription.getReturnType().asErasure())).and(ElementMatchers.takesArguments(methodDescription.getParameters().asTypeList().asErasures())));
        }
        return new InliningImplementationMatcher(ignoredMethods, predefinedMethodSignatures);
    }

    @Override // net.bytebuddy.matcher.LatentMatcher
    public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
        return ElementMatchers.not(this.ignoredMethods.resolve(typeDescription)).and(ElementMatchers.isVirtual().and(ElementMatchers.not(ElementMatchers.isFinal())).mo105or(ElementMatchers.isDeclaredBy(typeDescription))).mo105or(ElementMatchers.isDeclaredBy(typeDescription).and(ElementMatchers.not(this.predefinedMethodSignatures)));
    }
}
