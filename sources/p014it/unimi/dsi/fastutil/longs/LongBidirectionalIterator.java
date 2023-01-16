package p014it.unimi.dsi.fastutil.longs;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBidirectionalIterator.class */
public interface LongBidirectionalIterator extends LongIterator, ObjectBidirectionalIterator<Long> {
    long previousLong();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Long previous() {
        return Long.valueOf(previousLong());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousLong();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
