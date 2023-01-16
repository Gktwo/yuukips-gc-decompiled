package p014it.unimi.dsi.fastutil.bytes;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.bytes.BytePredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/BytePredicate.class */
public interface BytePredicate extends Predicate<Byte>, IntPredicate {
    boolean test(byte b);

    @Override // java.util.function.IntPredicate
    @Deprecated
    default boolean test(int t) {
        return test(SafeMath.safeIntToByte(t));
    }

    @Deprecated
    default boolean test(Byte t) {
        return test(t.byteValue());
    }

    default BytePredicate and(BytePredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    @Override // java.util.function.IntPredicate
    default BytePredicate and(IntPredicate other) {
        BytePredicate bytePredicate;
        if (other instanceof BytePredicate) {
            bytePredicate = (BytePredicate) other;
        } else {
            Objects.requireNonNull(other);
            bytePredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return and(bytePredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Byte> and(Predicate<? super Byte> other) {
        return and(other);
    }

    @Override // java.util.function.Predicate, java.util.function.IntPredicate
    default BytePredicate negate() {
        return t -> {
            return !test(t);
        };
    }

    /* renamed from: or */
    default BytePredicate m1043or(BytePredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    @Override // java.util.function.IntPredicate
    default BytePredicate or(IntPredicate other) {
        BytePredicate bytePredicate;
        if (other instanceof BytePredicate) {
            bytePredicate = (BytePredicate) other;
        } else {
            Objects.requireNonNull(other);
            bytePredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return m1043or(bytePredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Byte> or(Predicate<? super Byte> other) {
        return or(other);
    }
}
