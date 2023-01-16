package p014it.unimi.dsi.fastutil.doubles;

import p014it.unimi.dsi.fastutil.BigListIterator;
import p014it.unimi.dsi.fastutil.SafeMath;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBigListIterator.class */
public interface DoubleBigListIterator extends DoubleBidirectionalIterator, BigListIterator<Double> {
    default void set(double k) {
        throw new UnsupportedOperationException();
    }

    default void add(double k) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Double k) {
        set(k.doubleValue());
    }

    @Deprecated
    default void add(Double k) {
        add(k.doubleValue());
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
            nextDouble();
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
            previousDouble();
        }
        return (n - c) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator, p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return SafeMath.safeLongToInt(skip((long) n));
    }
}
