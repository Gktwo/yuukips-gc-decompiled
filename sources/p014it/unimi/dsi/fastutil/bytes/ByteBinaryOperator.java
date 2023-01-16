package p014it.unimi.dsi.fastutil.bytes;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBinaryOperator.class */
public interface ByteBinaryOperator extends BinaryOperator<Byte>, IntBinaryOperator {
    byte apply(byte b, byte b2);

    @Override // java.util.function.IntBinaryOperator
    @Deprecated
    default int applyAsInt(int x, int y) {
        return apply(SafeMath.safeIntToByte(x), SafeMath.safeIntToByte(y));
    }

    @Deprecated
    default Byte apply(Byte x, Byte y) {
        return Byte.valueOf(apply(x.byteValue(), y.byteValue()));
    }
}
