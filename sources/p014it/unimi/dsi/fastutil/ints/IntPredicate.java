package p014it.unimi.dsi.fastutil.ints;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.ints.IntPredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntPredicate.class */
public interface IntPredicate extends Predicate<Integer>, java.util.function.IntPredicate {
    @Deprecated
    default boolean test(Integer t) {
        return test(t.intValue());
    }

    @Override // java.util.function.IntPredicate
    default IntPredicate and(java.util.function.IntPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    default IntPredicate and(IntPredicate other) {
        return and((java.util.function.IntPredicate) other);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Integer> and(Predicate<? super Integer> other) {
        return and(other);
    }

    @Override // java.util.function.Predicate, java.util.function.IntPredicate
    default IntPredicate negate() {
        return t -> {
            return !test(t);
        };
    }

    @Override // java.util.function.IntPredicate
    default IntPredicate or(java.util.function.IntPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    /* renamed from: or */
    default IntPredicate m705or(IntPredicate other) {
        return or((java.util.function.IntPredicate) other);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Integer> or(Predicate<? super Integer> other) {
        return or(other);
    }
}
