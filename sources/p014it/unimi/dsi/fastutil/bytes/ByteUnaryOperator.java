package p014it.unimi.dsi.fastutil.bytes;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.bytes.ByteUnaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteUnaryOperator.class */
public interface ByteUnaryOperator extends UnaryOperator<Byte>, IntUnaryOperator {
    byte apply(byte b);

    static ByteUnaryOperator identity() {
        return i -> {
            return i;
        };
    }

    static ByteUnaryOperator negation() {
        return i -> {
            return (byte) (-i);
        };
    }

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int x) {
        return apply(SafeMath.safeIntToByte(x));
    }

    @Deprecated
    default Byte apply(Byte x) {
        return Byte.valueOf(apply(x.byteValue()));
    }
}
