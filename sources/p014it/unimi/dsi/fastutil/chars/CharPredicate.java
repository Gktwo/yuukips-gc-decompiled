package p014it.unimi.dsi.fastutil.chars;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.CharPredicate */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharPredicate.class */
public interface CharPredicate extends Predicate<Character>, IntPredicate {
    boolean test(char c);

    @Override // java.util.function.IntPredicate
    @Deprecated
    default boolean test(int t) {
        return test(SafeMath.safeIntToChar(t));
    }

    @Deprecated
    default boolean test(Character t) {
        return test(t.charValue());
    }

    default CharPredicate and(CharPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) && other.test(other);
        };
    }

    @Override // java.util.function.IntPredicate
    default CharPredicate and(IntPredicate other) {
        CharPredicate charPredicate;
        if (other instanceof CharPredicate) {
            charPredicate = (CharPredicate) other;
        } else {
            Objects.requireNonNull(other);
            charPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return and(charPredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Character> and(Predicate<? super Character> other) {
        return and(other);
    }

    @Override // java.util.function.Predicate, java.util.function.IntPredicate
    default CharPredicate negate() {
        return t -> {
            return !test(t);
        };
    }

    /* renamed from: or */
    default CharPredicate m958or(CharPredicate other) {
        Objects.requireNonNull(other);
        return t -> {
            return test(other) || other.test(other);
        };
    }

    @Override // java.util.function.IntPredicate
    default CharPredicate or(IntPredicate other) {
        CharPredicate charPredicate;
        if (other instanceof CharPredicate) {
            charPredicate = (CharPredicate) other;
        } else {
            Objects.requireNonNull(other);
            charPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return m958or(charPredicate);
    }

    @Override // java.util.function.Predicate
    @Deprecated
    default Predicate<Character> or(Predicate<? super Character> other) {
        return or(other);
    }
}
