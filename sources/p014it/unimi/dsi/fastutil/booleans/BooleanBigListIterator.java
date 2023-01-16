package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBigListIterator.class */
public interface BooleanBigListIterator extends BooleanBidirectionalIterator, BigListIterator<Boolean> {
    default void set(boolean k) {
        throw new UnsupportedOperationException();
    }

    default void add(boolean k) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Boolean k) {
        set(k.booleanValue());
    }

    @Deprecated
    default void add(Boolean k) {
        add(k.booleanValue());
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
            nextBoolean();
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
            previousBoolean();
        }
        return (n - c) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator, p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return SafeMath.safeLongToInt(skip((long) n));
    }
}
