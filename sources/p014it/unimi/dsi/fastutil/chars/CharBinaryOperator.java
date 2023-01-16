package p014it.unimi.dsi.fastutil.chars;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.CharBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBinaryOperator.class */
public interface CharBinaryOperator extends BinaryOperator<Character>, IntBinaryOperator {
    char apply(char c, char c2);

    @Override // java.util.function.IntBinaryOperator
    @Deprecated
    default int applyAsInt(int x, int y) {
        return apply(SafeMath.safeIntToChar(x), SafeMath.safeIntToChar(y));
    }

    @Deprecated
    default Character apply(Character x, Character y) {
        return Character.valueOf(apply(x.charValue(), y.charValue()));
    }
}
