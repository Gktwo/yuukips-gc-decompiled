package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/BooleanMatcher.class */
public class BooleanMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private static final BooleanMatcher<?> TRUE = new BooleanMatcher<>(true);
    private static final BooleanMatcher<?> FALSE = new BooleanMatcher<>(false);
    protected final boolean matches;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matches == ((BooleanMatcher) obj).matches;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + (this.matches ? 1 : 0);
    }

    /* renamed from: of */
    public static <T> ElementMatcher.Junction<T> m106of(boolean matches) {
        return matches ? TRUE : FALSE;
    }

    public BooleanMatcher(boolean matches) {
        this.matches = matches;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(T target) {
        return this.matches;
    }

    public String toString() {
        return Boolean.toString(this.matches);
    }
}
