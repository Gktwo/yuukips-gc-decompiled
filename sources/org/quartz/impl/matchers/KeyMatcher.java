package org.quartz.impl.matchers;

import org.quartz.Matcher;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/impl/matchers/KeyMatcher.class */
public class KeyMatcher<T extends Key<?>> implements Matcher<T> {
    private static final long serialVersionUID = 1230009869074992437L;
    protected T compareTo;

    protected KeyMatcher(T compareTo) {
        this.compareTo = compareTo;
    }

    public static <U extends Key<?>> KeyMatcher<U> keyEquals(U compareTo) {
        return new KeyMatcher<>(compareTo);
    }

    @Override // org.quartz.Matcher
    public boolean isMatch(T key) {
        return this.compareTo.equals(key);
    }

    public T getCompareToValue() {
        return this.compareTo;
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public int hashCode() {
        return (31 * 1) + (this.compareTo == null ? 0 : this.compareTo.hashCode());
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyMatcher<?> other = (KeyMatcher) obj;
        if (this.compareTo == null) {
            if (other.compareTo != null) {
                return false;
            }
            return true;
        } else if (!this.compareTo.equals(other.compareTo)) {
            return false;
        } else {
            return true;
        }
    }
}
