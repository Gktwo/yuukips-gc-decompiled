package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/NegatingMatcher.class */
public class NegatingMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super T> matcher;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((NegatingMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public NegatingMatcher(ElementMatcher<? super T> matcher) {
        this.matcher = matcher;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(T target) {
        return !this.matcher.matches(target);
    }

    public String toString() {
        return "not(" + this.matcher + ')';
    }
}
