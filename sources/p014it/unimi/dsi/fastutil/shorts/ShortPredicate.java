package p014it.unimi.dsi.fastutil.shorts;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.shorts.ShortPredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortPredicate.class */
public interface ShortPredicate extends Predicate<Short>, IntPredicate {
    boolean test(short s);

    @Override // java.util.function.IntPredicate
    @Deprecated
    default boolean test(int t) {
        return test(SafeMath.safeIntToShort(t));
    }

    @Deprecated
    default boolean test(Short t) {
        return test(t.shortValue());
    }

    default ShortPredicate and(ShortPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    @Override // java.util.function.IntPredicate
    default ShortPredicate and(IntPredicate other) {
        ShortPredicate shortPredicate;
        if (other instanceof ShortPredicate) {
            shortPredicate = (ShortPredicate) other;
        } else {
            Objects.requireNonNull(other);
            shortPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return and(shortPredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Short> and(Predicate<? super Short> other) {
        return and(other);
    }

    @Override // java.util.function.Predicate, java.util.function.IntPredicate
    default ShortPredicate negate() {
        return t -> {
            return !test(t);
        };
    }

    /* renamed from: or */
    default ShortPredicate m397or(ShortPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    @Override // java.util.function.IntPredicate
    default ShortPredicate or(IntPredicate other) {
        ShortPredicate shortPredicate;
        if (other instanceof ShortPredicate) {
            shortPredicate = (ShortPredicate) other;
        } else {
            Objects.requireNonNull(other);
            shortPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return m397or(shortPredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Short> or(Predicate<? super Short> other) {
        return or(other);
    }
}
