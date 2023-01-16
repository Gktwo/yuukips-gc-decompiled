package p014it.unimi.dsi.fastutil.longs;

import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBigListIterator.class */
public interface LongBigListIterator extends LongBidirectionalIterator, BigListIterator<Long> {
    default void set(long k) {
        throw new UnsupportedOperationException();
    }

    default void add(long k) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Long k) {
        set(k.longValue());
    }

    @Deprecated
    default void add(Long k) {
        add(k.longValue());
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
            nextLong();
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
            previousLong();
        }
        return (n - c) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBidirectionalIterator, p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return SafeMath.safeLongToInt(skip((long) n));
    }
}
