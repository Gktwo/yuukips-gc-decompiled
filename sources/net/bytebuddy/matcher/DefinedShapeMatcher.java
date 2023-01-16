package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ByteCodeElement.TypeDependant;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/DefinedShapeMatcher.class */
public class DefinedShapeMatcher<T extends ByteCodeElement.TypeDependant<S, ?>, S extends ByteCodeElement.TypeDependant<?, ?>> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super S> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((DefinedShapeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.DefinedShapeMatcher<T extends net.bytebuddy.description.ByteCodeElement$TypeDependant<S, ?>, S extends net.bytebuddy.description.ByteCodeElement$TypeDependant<?, ?>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((DefinedShapeMatcher<T, S>) ((ByteCodeElement.TypeDependant) obj));
    }

    public DefinedShapeMatcher(ElementMatcher<? super S> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(T target) {
        return this.matcher.matches(target.asDefined());
    }

    public String toString() {
        return "isDefinedAs(" + this.matcher + ')';
    }
}
