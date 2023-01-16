package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import java.util.function.BiPredicate;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/Equivalence.class */
public abstract class Equivalence<T> implements BiPredicate<T, T> {
    @ForOverride
    protected abstract boolean doEquivalent(T t, T t2);

    @ForOverride
    protected abstract int doHash(T t);

    public final boolean equivalent(T a, T b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return doEquivalent(a, b);
    }

    @Override // java.util.function.BiPredicate
    @Deprecated
    public final boolean test(T t, T u) {
        return equivalent(t, u);
    }

    public final int hash(T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    public final <S extends T> Wrapper<S> wrap(S reference) {
        return new Wrapper<>(reference);
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Equivalence$Wrapper.class */
    public static final class Wrapper<T> implements Serializable {
        private final Equivalence<? super T> equivalence;
        private final T reference;
        private static final long serialVersionUID = 0;

        private Wrapper(Equivalence<? super T> equivalence, T reference) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.reference = reference;
        }

        public T get() {
            return this.reference;
        }

        /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: T, ? super T */
        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper<?> that = (Wrapper) obj;
            if (this.equivalence.equals(that.equivalence)) {
                return this.equivalence.equivalent((T) this.reference, (T) that.reference);
            }
            return false;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // java.lang.Object
        public int hashCode() {
            return this.equivalence.hash((T) this.reference);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final Predicate<T> equivalentTo(T target) {
        return new EquivalentToPredicate(this, target);
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Equivalence$EquivalentToPredicate.class */
    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private final Equivalence<T> equivalence;
        private final T target;
        private static final long serialVersionUID = 0;

        EquivalentToPredicate(Equivalence<T> equivalence, T target) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.target = target;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T input) {
            return this.equivalence.equivalent(input, this.target);
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate<?> that = (EquivalentToPredicate) obj;
            return this.equivalence.equals(that.equivalence) && Objects.equal(this.target, that.target);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Equivalence$Equals.class */
    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object a, Object b) {
            return a.equals(b);
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object o) {
            return o.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Equivalence$Identity.class */
    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        Identity() {
        }

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object a, Object b) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object o) {
            return System.identityHashCode(o);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}
