package p014it.unimi.dsi.fastutil.bytes;

import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBigListIterator.class */
public interface ByteBigListIterator extends ByteBidirectionalIterator, BigListIterator<Byte> {
    default void set(byte k) {
        throw new UnsupportedOperationException();
    }

    default void add(byte k) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Byte k) {
        set(k.byteValue());
    }

    @Deprecated
    default void add(Byte k) {
        add(k.byteValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    default long skip(long n) {
        char c = n;
        while (true) {
            c--;
            if (c == 0 || !hasNext()) {
                break;
            }
            nextByte();
        }
        return (n - c) - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    default long back(long n) {
        char c = n;
        while (true) {
            c--;
            if (c == 0 || !hasPrevious()) {
                break;
            }
            previousByte();
        }
        return (n - c) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return SafeMath.safeLongToInt(skip((long) n));
    }
}
