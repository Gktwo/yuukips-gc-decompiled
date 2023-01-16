package p014it.unimi.dsi.fastutil.doubles;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBidirectionalIterator.class */
public interface DoubleBidirectionalIterator extends DoubleIterator, ObjectBidirectionalIterator<Double> {
    double previousDouble();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Double previous() {
        return Double.valueOf(previousDouble());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousDouble();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
