package org.quartz.impl.matchers;

import org.quartz.Matcher;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/impl/matchers/AndMatcher.class */
public class AndMatcher<T extends Key<?>> implements Matcher<T> {
    private static final long serialVersionUID = 4697276220890670941L;
    protected Matcher<T> leftOperand;
    protected Matcher<T> rightOperand;

    protected AndMatcher(Matcher<T> leftOperand, Matcher<T> rightOperand) {
        if (leftOperand == null || rightOperand == null) {
            throw new IllegalArgumentException("Two non-null operands required!");
        }
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public static <U extends Key<?>> AndMatcher<U> and(Matcher<U> leftOperand, Matcher<U> rightOperand) {
        return new AndMatcher<>(leftOperand, rightOperand);
    }

    @Override // org.quartz.Matcher
    public boolean isMatch(T key) {
        return this.leftOperand.isMatch(key) && this.rightOperand.isMatch(key);
    }

    public Matcher<T> getLeftOperand() {
        return this.leftOperand;
    }

    public Matcher<T> getRightOperand() {
        return this.rightOperand;
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public int hashCode() {
        return (31 * ((31 * 1) + (this.leftOperand == null ? 0 : this.leftOperand.hashCode()))) + (this.rightOperand == null ? 0 : this.rightOperand.hashCode());
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AndMatcher<?> other = (AndMatcher) obj;
        if (this.leftOperand == null) {
            if (other.leftOperand != null) {
                return false;
            }
        } else if (!this.leftOperand.equals(other.leftOperand)) {
            return false;
        }
        if (this.rightOperand == null) {
            if (other.rightOperand != null) {
                return false;
            }
            return true;
        } else if (!this.rightOperand.equals(other.rightOperand)) {
            return false;
        } else {
            return true;
        }
    }
}
