package net.bytebuddy.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

/* loaded from: grasscutter.jar:net/bytebuddy/matcher/ElementMatcher.class */
public interface ElementMatcher<T> {
    boolean matches(T t);

    /* loaded from: grasscutter.jar:net/bytebuddy/matcher/ElementMatcher$Junction.class */
    public interface Junction<S> extends ElementMatcher<S> {
        <U extends S> Junction<U> and(ElementMatcher<? super U> elementMatcher);

        /* renamed from: or */
        <U extends S> Junction<U> mo105or(ElementMatcher<? super U> elementMatcher);

        /* loaded from: grasscutter.jar:net/bytebuddy/matcher/ElementMatcher$Junction$AbstractBase.class */
        public static abstract class AbstractBase<V> implements Junction<V> {
            @Override // net.bytebuddy.matcher.ElementMatcher.Junction
            public <U extends V> Junction<U> and(ElementMatcher<? super U> other) {
                return new Conjunction(this, other);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction
            /* renamed from: or */
            public <U extends V> Junction<U> mo105or(ElementMatcher<? super U> other) {
                return new Disjunction(this, other);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/matcher/ElementMatcher$Junction$Conjunction.class */
        public static class Conjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public Conjunction(ElementMatcher<? super W>... matcher) {
                this(Arrays.asList(matcher));
            }

            public Conjunction(List<ElementMatcher<? super W>> matchers) {
                this.matchers = new ArrayList(matchers.size());
                for (ElementMatcher<? super W> matcher : matchers) {
                    if (matcher instanceof Conjunction) {
                        this.matchers.addAll(((Conjunction) matcher).matchers);
                    } else {
                        this.matchers.add(matcher);
                    }
                }
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(W target) {
                for (ElementMatcher<? super W> matcher : this.matchers) {
                    if (!matcher.matches(target)) {
                        return false;
                    }
                }
                return true;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("(");
                boolean first = true;
                for (ElementMatcher<? super W> matcher : this.matchers) {
                    if (first) {
                        first = false;
                    } else {
                        stringBuilder.append(" and ");
                    }
                    stringBuilder.append(matcher);
                }
                return stringBuilder.append(")").toString();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/matcher/ElementMatcher$Junction$Disjunction.class */
        public static class Disjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.matchers.hashCode();
            }

            public Disjunction(ElementMatcher<? super W>... matcher) {
                this(Arrays.asList(matcher));
            }

            public Disjunction(List<ElementMatcher<? super W>> matchers) {
                this.matchers = new ArrayList(matchers.size());
                for (ElementMatcher<? super W> matcher : matchers) {
                    if (matcher instanceof Disjunction) {
                        this.matchers.addAll(((Disjunction) matcher).matchers);
                    } else {
                        this.matchers.add(matcher);
                    }
                }
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(W target) {
                for (ElementMatcher<? super W> matcher : this.matchers) {
                    if (matcher.matches(target)) {
                        return true;
                    }
                }
                return false;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("(");
                boolean first = true;
                for (ElementMatcher<? super W> matcher : this.matchers) {
                    if (first) {
                        first = false;
                    } else {
                        stringBuilder.append(" or ");
                    }
                    stringBuilder.append(matcher);
                }
                return stringBuilder.append(")").toString();
            }
        }
    }
}
