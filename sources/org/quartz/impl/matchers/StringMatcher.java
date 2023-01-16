package org.quartz.impl.matchers;

import org.quartz.Matcher;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/impl/matchers/StringMatcher.class */
public abstract class StringMatcher<T extends Key<?>> implements Matcher<T> {
    private static final long serialVersionUID = -2757924162611145836L;
    protected String compareTo;
    protected StringOperatorName compareWith;

    /* loaded from: grasscutter.jar:org/quartz/impl/matchers/StringMatcher$StringOperatorName.class */
    public enum StringOperatorName {
        EQUALS {
            @Override // org.quartz.impl.matchers.StringMatcher.StringOperatorName
            public boolean evaluate(String value, String compareTo) {
                return value.equals(compareTo);
            }
        },
        STARTS_WITH {
            @Override // org.quartz.impl.matchers.StringMatcher.StringOperatorName
            public boolean evaluate(String value, String compareTo) {
                return value.startsWith(compareTo);
            }
        },
        ENDS_WITH {
            @Override // org.quartz.impl.matchers.StringMatcher.StringOperatorName
            public boolean evaluate(String value, String compareTo) {
                return value.endsWith(compareTo);
            }
        },
        CONTAINS {
            @Override // org.quartz.impl.matchers.StringMatcher.StringOperatorName
            public boolean evaluate(String value, String compareTo) {
                return value.contains(compareTo);
            }
        },
        ANYTHING {
            @Override // org.quartz.impl.matchers.StringMatcher.StringOperatorName
            public boolean evaluate(String value, String compareTo) {
                return true;
            }
        };

        public abstract boolean evaluate(String str, String str2);
    }

    protected abstract String getValue(T t);

    /* access modifiers changed from: protected */
    public StringMatcher(String compareTo, StringOperatorName compareWith) {
        if (compareTo == null) {
            throw new IllegalArgumentException("CompareTo value cannot be null!");
        } else if (compareWith == null) {
            throw new IllegalArgumentException("CompareWith operator cannot be null!");
        } else {
            this.compareTo = compareTo;
            this.compareWith = compareWith;
        }
    }

    @Override // org.quartz.Matcher
    public boolean isMatch(T key) {
        return this.compareWith.evaluate(getValue(key), this.compareTo);
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public int hashCode() {
        return (31 * ((31 * 1) + (this.compareTo == null ? 0 : this.compareTo.hashCode()))) + (this.compareWith == null ? 0 : this.compareWith.hashCode());
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StringMatcher<?> other = (StringMatcher) obj;
        if (this.compareTo == null) {
            if (other.compareTo != null) {
                return false;
            }
        } else if (!this.compareTo.equals(other.compareTo)) {
            return false;
        }
        if (this.compareWith == null) {
            if (other.compareWith != null) {
                return false;
            }
            return true;
        } else if (!this.compareWith.equals(other.compareWith)) {
            return false;
        } else {
            return true;
        }
    }

    public String getCompareToValue() {
        return this.compareTo;
    }

    public StringOperatorName getCompareWithOperator() {
        return this.compareWith;
    }
}
