package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/base/Predicates.class */
public final class Predicates {
    private Predicates() {
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> components) {
        return new AndPredicate(defensiveCopy(components));
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... components) {
        return new AndPredicate(defensiveCopy(components));
    }

    public static <T> Predicate<T> and(Predicate<? super T> first, Predicate<? super T> second) {
        return new AndPredicate(asList((Predicate) Preconditions.checkNotNull(first), (Predicate) Preconditions.checkNotNull(second)));
    }

    /* renamed from: or */
    public static <T> Predicate<T> m1460or(Iterable<? extends Predicate<? super T>> components) {
        return new OrPredicate(defensiveCopy(components));
    }

    @SafeVarargs
    /* renamed from: or */
    public static <T> Predicate<T> m1459or(Predicate<? super T>... components) {
        return new OrPredicate(defensiveCopy(components));
    }

    /* renamed from: or */
    public static <T> Predicate<T> m1461or(Predicate<? super T> first, Predicate<? super T> second) {
        return new OrPredicate(asList((Predicate) Preconditions.checkNotNull(first), (Predicate) Preconditions.checkNotNull(second)));
    }

    public static <T> Predicate<T> equalTo(T target) {
        return target == null ? isNull() : new IsEqualToPredicate(target);
    }

    @GwtIncompatible
    public static Predicate<Object> instanceOf(Class<?> clazz) {
        return new InstanceOfPredicate(clazz);
    }

    @Beta
    @GwtIncompatible
    public static Predicate<Class<?>> subtypeOf(Class<?> clazz) {
        return new SubtypeOfPredicate(clazz);
    }

    /* renamed from: in */
    public static <T> Predicate<T> m1462in(Collection<? extends T> target) {
        return new InPredicate(target);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }

    @GwtIncompatible
    public static Predicate<CharSequence> containsPattern(String pattern) {
        return new ContainsPatternFromStringPredicate(pattern);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(Pattern pattern) {
        return new ContainsPatternPredicate(new JdkPattern(pattern));
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$ObjectPredicate.class */
    public enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE {
            @Override // com.google.common.base.Predicate
            public boolean apply(Object o) {
                return true;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            @Override // com.google.common.base.Predicate
            public boolean apply(Object o) {
                return false;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            @Override // com.google.common.base.Predicate
            public boolean apply(Object o) {
                return o == null;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            @Override // com.google.common.base.Predicate
            public boolean apply(Object o) {
                return o != null;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$NotPredicate.class */
    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        final Predicate<T> predicate;
        private static final long serialVersionUID = 0;

        NotPredicate(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return !this.predicate.apply(t);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.predicate.hashCode() ^ -1;
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$AndPredicate.class */
    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private final List<? extends Predicate<? super T>> components;
        private static final long serialVersionUID = 0;

        private AndPredicate(List<? extends Predicate<? super T>> components) {
            this.components = components;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (!((Predicate) this.components.get(i)).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            return Predicates.toStringHelper("and", this.components);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$OrPredicate.class */
    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private final List<? extends Predicate<? super T>> components;
        private static final long serialVersionUID = 0;

        private OrPredicate(List<? extends Predicate<? super T>> components) {
            this.components = components;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (((Predicate) this.components.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof OrPredicate) {
                return this.components.equals(((OrPredicate) obj).components);
            }
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            return Predicates.toStringHelper("or", this.components);
        }
    }

    /* access modifiers changed from: private */
    public static String toStringHelper(String methodName, Iterable<?> components) {
        StringBuilder builder = new StringBuilder("Predicates.").append(methodName).append('(');
        boolean first = true;
        for (Object o : components) {
            if (!first) {
                builder.append(',');
            }
            builder.append(o);
            first = false;
        }
        return builder.append(')').toString();
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$IsEqualToPredicate.class */
    private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private final T target;
        private static final long serialVersionUID = 0;

        private IsEqualToPredicate(T target) {
            this.target = target;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$InstanceOfPredicate.class */
    private static class InstanceOfPredicate implements Predicate<Object>, Serializable {
        private final Class<?> clazz;
        private static final long serialVersionUID = 0;

        private InstanceOfPredicate(Class<?> clazz) {
            this.clazz = (Class) Preconditions.checkNotNull(clazz);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(Object o) {
            return this.clazz.isInstance(o);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.clazz.hashCode();
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.clazz == ((InstanceOfPredicate) obj).clazz;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$SubtypeOfPredicate.class */
    private static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private final Class<?> clazz;
        private static final long serialVersionUID = 0;

        private SubtypeOfPredicate(Class<?> clazz) {
            this.clazz = (Class) Preconditions.checkNotNull(clazz);
        }

        public boolean apply(Class<?> input) {
            return this.clazz.isAssignableFrom(input);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.clazz.hashCode();
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            return (obj instanceof SubtypeOfPredicate) && this.clazz == ((SubtypeOfPredicate) obj).clazz;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + ")";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$InPredicate.class */
    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private final Collection<?> target;
        private static final long serialVersionUID = 0;

        private InPredicate(Collection<?> target) {
            this.target = (Collection) Preconditions.checkNotNull(target);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException e) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$CompositionPredicate.class */
    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {

        /* renamed from: p */
        final Predicate<B> f260p;

        /* renamed from: f */
        final Function<A, ? extends B> f261f;
        private static final long serialVersionUID = 0;

        private CompositionPredicate(Predicate<B> p, Function<A, ? extends B> f) {
            this.f260p = (Predicate) Preconditions.checkNotNull(p);
            this.f261f = (Function) Preconditions.checkNotNull(f);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.base.Predicate<B> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Predicate
        public boolean apply(A a) {
            return this.f260p.apply(this.f261f.apply(a));
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate<?, ?> that = (CompositionPredicate) obj;
            return this.f261f.equals(that.f261f) && this.f260p.equals(that.f260p);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.f261f.hashCode() ^ this.f260p.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return this.f260p + "(" + this.f261f + ")";
        }
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$ContainsPatternPredicate.class */
    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        final CommonPattern pattern;
        private static final long serialVersionUID = 0;

        ContainsPatternPredicate(CommonPattern pattern) {
            this.pattern = (CommonPattern) Preconditions.checkNotNull(pattern);
        }

        public boolean apply(CharSequence t) {
            return this.pattern.matcher(t).find();
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof ContainsPatternPredicate)) {
                return false;
            }
            ContainsPatternPredicate that = (ContainsPatternPredicate) obj;
            return Objects.equal(this.pattern.pattern(), that.pattern.pattern()) && this.pattern.flags() == that.pattern.flags();
        }

        @Override // java.lang.Object
        public String toString() {
            return "Predicates.contains(" + MoreObjects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString() + ")";
        }
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/base/Predicates$ContainsPatternFromStringPredicate.class */
    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        ContainsPatternFromStringPredicate(String string) {
            super(Platform.compilePattern(string));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate, java.lang.Object
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> first, Predicate<? super T> second) {
        return Arrays.asList(first, second);
    }

    private static <T> List<T> defensiveCopy(T... array) {
        return defensiveCopy(Arrays.asList(array));
    }

    static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T element : iterable) {
            arrayList.add(Preconditions.checkNotNull(element));
        }
        return arrayList;
    }
}
