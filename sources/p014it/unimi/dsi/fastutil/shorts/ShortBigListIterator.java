package p014it.unimi.dsi.fastutil.shorts;

import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBigListIterator.class */
public interface ShortBigListIterator extends ShortBidirectionalIterator, BigListIterator<Short> {
    default void set(short k) {
        throw new UnsupportedOperationException();
    }

    default void add(short k) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Short k) {
        set(k.shortValue());
    }

    @Deprecated
    default void add(Short k) {
        add(k.shortValue());
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
            nextShort();
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
            previousShort();
        }
        return (n - c) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator, p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return SafeMath.safeLongToInt(skip((long) n));
    }
}
