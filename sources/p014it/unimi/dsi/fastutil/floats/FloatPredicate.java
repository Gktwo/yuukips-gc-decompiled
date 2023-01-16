package p014it.unimi.dsi.fastutil.floats;

import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.FloatPredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatPredicate.class */
public interface FloatPredicate extends Predicate<Float>, DoublePredicate {
    boolean test(float f);

    @Override // java.util.function.DoublePredicate
    @Deprecated
    default boolean test(double t) {
        return test(SafeMath.safeDoubleToFloat(t));
    }

    @Deprecated
    default boolean test(Float t) {
        return test(t.floatValue());
    }

    default FloatPredicate and(FloatPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    @Override // java.util.function.DoublePredicate
    default FloatPredicate and(DoublePredicate other) {
        FloatPredicate floatPredicate;
        if (other instanceof FloatPredicate) {
            floatPredicate = (FloatPredicate) other;
        } else {
            Objects.requireNonNull(other);
            floatPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return and(floatPredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Float> and(Predicate<? super Float> other) {
        return and(other);
    }

    @Override // java.util.function.Predicate, java.util.function.DoublePredicate
    default FloatPredicate negate() {
        return t -> {
            return !test(t);
        };
    }

    /* renamed from: or */
    default FloatPredicate m789or(FloatPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    @Override // java.util.function.DoublePredicate
    default FloatPredicate or(DoublePredicate other) {
        FloatPredicate floatPredicate;
        if (other instanceof FloatPredicate) {
            floatPredicate = (FloatPredicate) other;
        } else {
            Objects.requireNonNull(other);
            floatPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return m789or(floatPredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Float> or(Predicate<? super Float> other) {
        return or(other);
    }
}
