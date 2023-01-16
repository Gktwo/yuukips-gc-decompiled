package p014it.unimi.dsi.fastutil.chars;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.CharUnaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharUnaryOperator.class */
public interface CharUnaryOperator extends UnaryOperator<Character>, IntUnaryOperator {
    char apply(char c);

    static CharUnaryOperator identity() {
        return i -> {
            return i;
        };
    }

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int x) {
        return apply(SafeMath.safeIntToChar(x));
    }

    @Deprecated
    default Character apply(Character x) {
        return Character.valueOf(apply(x.charValue()));
    }
}
