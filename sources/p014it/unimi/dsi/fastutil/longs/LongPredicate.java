package p014it.unimi.dsi.fastutil.longs;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.LongPredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongPredicate.class */
public interface LongPredicate extends Predicate<Long>, java.util.function.LongPredicate {
    @Deprecated
    default boolean test(Long t) {
        return test(t.longValue());
    }

    @Override // java.util.function.LongPredicate
    default LongPredicate and(java.util.function.LongPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    default LongPredicate and(LongPredicate other) {
        return and((java.util.function.LongPredicate) other);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Long> and(Predicate<? super Long> other) {
        return and(other);
    }

    @Override // java.util.function.Predicate, java.util.function.LongPredicate
    default LongPredicate negate() {
        return t -> {
            return !test(t);
        };
    }

    @Override // java.util.function.LongPredicate
    default LongPredicate or(java.util.function.LongPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    /* renamed from: or */
    default LongPredicate m620or(LongPredicate other) {
        return or((java.util.function.LongPredicate) other);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Long> or(Predicate<? super Long> other) {
        return or(other);
    }
}
