package org.quartz.impl.matchers;

import org.quartz.Matcher;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/impl/matchers/NotMatcher.class */
public class NotMatcher<T extends Key<?>> implements Matcher<T> {
    private static final long serialVersionUID = -2856769076151741391L;
    protected Matcher<T> operand;

    protected NotMatcher(Matcher<T> operand) {
        if (operand == null) {
            throw new IllegalArgumentException("Non-null operand required!");
        }
        this.operand = operand;
    }

    public static <U extends Key<?>> NotMatcher<U> not(Matcher<U> operand) {
        return new NotMatcher<>(operand);
    }

    @Override // org.quartz.Matcher
    public boolean isMatch(T key) {
        return !this.operand.isMatch(key);
    }

    public Matcher<T> getOperand() {
        return this.operand;
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public int hashCode() {
        return (31 * 1) + (this.operand == null ? 0 : this.operand.hashCode());
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NotMatcher<?> other = (NotMatcher) obj;
        if (this.operand == null) {
            if (other.operand != null) {
                return false;
            }
            return true;
        } else if (!this.operand.equals(other.operand)) {
            return false;
        } else {
            return true;
        }
    }
}
