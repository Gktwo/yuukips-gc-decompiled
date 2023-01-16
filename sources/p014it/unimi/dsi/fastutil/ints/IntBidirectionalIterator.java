package p014it.unimi.dsi.fastutil.ints;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.ints.IntBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBidirectionalIterator.class */
public interface IntBidirectionalIterator extends IntIterator, ObjectBidirectionalIterator<Integer> {
    int previousInt();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Integer previous() {
        return Integer.valueOf(previousInt());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousInt();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
