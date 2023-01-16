package p014it.unimi.dsi.fastutil.doubles;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.DoublePredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoublePredicate.class */
public interface DoublePredicate extends Predicate<Double>, java.util.function.DoublePredicate {
    @Deprecated
    default boolean test(Double t) {
        return test(t.doubleValue());
    }

    @Override // java.util.function.DoublePredicate
    default DoublePredicate and(java.util.function.DoublePredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    default DoublePredicate and(DoublePredicate other) {
        return and((java.util.function.DoublePredicate) other);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Double> and(Predicate<? super Double> other) {
        return and(other);
    }

    @Override // java.util.function.Predicate, java.util.function.DoublePredicate
    default DoublePredicate negate() {
        return t -> {
            return !test(t);
        };
    }

    @Override // java.util.function.DoublePredicate
    default DoublePredicate or(java.util.function.DoublePredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    /* renamed from: or */
    default DoublePredicate m873or(DoublePredicate other) {
        return or((java.util.function.DoublePredicate) other);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Double> or(Predicate<? super Double> other) {
        return or(other);
    }
}
