package p014it.unimi.dsi.fastutil.floats;

import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBigListIterator.class */
public interface FloatBigListIterator extends FloatBidirectionalIterator, BigListIterator<Float> {
    default void set(float k) {
        throw new UnsupportedOperationException();
    }

    default void add(float k) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Float k) {
        set(k.floatValue());
    }

    @Deprecated
    default void add(Float k) {
        add(k.floatValue());
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
            nextFloat();
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
            previousFloat();
        }
        return (n - c) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator, p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return SafeMath.safeLongToInt(skip((long) n));
    }
}
