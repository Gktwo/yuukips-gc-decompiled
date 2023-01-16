package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.DeclaredByType;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/DeclaringTypeMatcher.class */
public class DeclaringTypeMatcher<T extends DeclaredByType> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDescription.Generic> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((DeclaringTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.DeclaringTypeMatcher<T extends net.bytebuddy.description.DeclaredByType> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((DeclaringTypeMatcher<T>) ((DeclaredByType) obj));
    }

    public DeclaringTypeMatcher(ElementMatcher<? super TypeDescription.Generic> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(T target) {
        TypeDefinition declaringType = target.getDeclaringType();
        return declaringType != null && this.matcher.matches(declaringType.asGenericType());
    }

    public String toString() {
        return "declaredBy(" + this.matcher + ")";
    }
}
