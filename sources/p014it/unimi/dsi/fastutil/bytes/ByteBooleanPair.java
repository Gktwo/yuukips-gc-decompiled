package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBooleanPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBooleanPair.class */
public interface ByteBooleanPair extends Pair<Byte, Boolean> {
    byte leftByte();

    boolean rightBoolean();

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte left() {
        return Byte.valueOf(leftByte());
    }

    default ByteBooleanPair left(byte l) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteBooleanPair left(Byte l) {
        return left(l.byteValue());
    }

    default byte firstByte() {
        return leftByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte first() {
        return Byte.valueOf(firstByte());
    }

    default ByteBooleanPair first(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteBooleanPair first(Byte l) {
        return first(l.byteValue());
    }

    default byte keyByte() {
        return firstByte();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Byte key() {
        return Byte.valueOf(keyByte());
    }

    default ByteBooleanPair key(byte l) {
        return left(l);
    }

    @Deprecated
    default ByteBooleanPair key(Byte l) {
        return key(l.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean right() {
        return Boolean.valueOf(rightBoolean());
    }

    default ByteBooleanPair right(boolean r) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default ByteBooleanPair right(Boolean l) {
        return right(l.booleanValue());
    }

    default boolean secondBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean second() {
        return Boolean.valueOf(secondBoolean());
    }

    default ByteBooleanPair second(boolean r) {
        return right(r);
    }

    @Deprecated
    default ByteBooleanPair second(Boolean l) {
        return second(l.booleanValue());
    }

    default boolean valueBoolean() {
        return rightBoolean();
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    @Deprecated
    default Boolean value() {
        return Boolean.valueOf(valueBoolean());
    }

    default ByteBooleanPair value(boolean r) {
        return right(r);
    }

    @Deprecated
    default ByteBooleanPair value(Boolean l) {
        return value(l.booleanValue());
    }

    /* renamed from: of */
    static ByteBooleanPair m1084of(byte left, boolean right) {
        return new ByteBooleanImmutablePair(left, right);
    }

    static Comparator<ByteBooleanPair> lexComparator() {
        return x, y -> {
            int t = Byte.compare(x.leftByte(), y.leftByte());
            return t != 0 ? t : Boolean.compare(x.rightBoolean(), y.rightBoolean());
        };
    }
}
