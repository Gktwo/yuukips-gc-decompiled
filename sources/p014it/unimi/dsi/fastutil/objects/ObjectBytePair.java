package p014it.unimi.dsi.fastutil.objects;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBytePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBytePair.class */
public interface ObjectBytePair<K> extends Pair<K, Byte> {
    byte rightByte();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte right() {
        return Byte.valueOf(rightByte());
    }

    default ObjectBytePair<K> right(byte r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ObjectBytePair<K> right(Byte l) {
        return right(l.byteValue());
    }

    default byte secondByte() {
        return rightByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte second() {
        return Byte.valueOf(secondByte());
    }

    default ObjectBytePair<K> second(byte r) {
        return right(r);
    }

    @Deprecated
    default ObjectBytePair<K> second(Byte l) {
        return second(l.byteValue());
    }

    default byte valueByte() {
        return rightByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte value() {
        return Byte.valueOf(valueByte());
    }

    default ObjectBytePair<K> value(byte r) {
        return right(r);
    }

    @Deprecated
    default ObjectBytePair<K> value(Byte l) {
        return value(l.byteValue());
    }

    /* renamed from: of */
    static <K> ObjectBytePair<K> m573of(K left, byte right) {
        return new ObjectByteImmutablePair(left, right);
    }

    static <K> Comparator<ObjectBytePair<K>> lexComparator() {
        return x, y -> {
            int t = ((Comparable) x.left()).compareTo(y.left());
            return t != 0 ? t : Byte.compare(x.rightByte(), y.rightByte());
        };
    }
}
