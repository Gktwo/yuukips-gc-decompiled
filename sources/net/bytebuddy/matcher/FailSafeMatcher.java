package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/FailSafeMatcher.class */
public class FailSafeMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super T> matcher;
    private final boolean fallback;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.fallback == ((FailSafeMatcher) obj).fallback && this.matcher.equals(((FailSafeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + (this.fallback ? 1 : 0);
    }

    public FailSafeMatcher(ElementMatcher<? super T> matcher, boolean fallback) {
        this.matcher = matcher;
        this.fallback = fallback;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(T target) {
        try {
            return this.matcher.matches(target);
        } catch (Exception e) {
            return this.fallback;
        }
    }

    public String toString() {
        return "failSafe(try(" + this.matcher + ") or " + this.fallback + ")";
    }
}
