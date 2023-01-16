package p014it.unimi.dsi.fastutil.booleans;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanPredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanPredicate.class */
public interface BooleanPredicate extends Predicate<Boolean> {
    boolean test(boolean z);

    static BooleanPredicate identity() {
        return b -> {
            return b;
        };
    }

    static BooleanPredicate negation() {
        return b -> {
            return !b;
        };
    }

    @Deprecated
    default boolean test(Boolean t) {
        return test(t.booleanValue());
    }

    default BooleanPredicate and(BooleanPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Boolean> and(Predicate<? super Boolean> other) {
        return and(other);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanPredicate' to match base method */
    @Override // java.util.function.Predicate
    default Predicate<Boolean> negate() {
        return t -> {
            return !test(t);
        };
    }

    /* renamed from: or */
    default BooleanPredicate m1126or(BooleanPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Boolean> or(Predicate<? super Boolean> other) {
        return or(other);
    }
}
