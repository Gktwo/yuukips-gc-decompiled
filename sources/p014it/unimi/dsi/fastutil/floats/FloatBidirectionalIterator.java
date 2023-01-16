package p014it.unimi.dsi.fastutil.floats;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBidirectionalIterator.class */
public interface FloatBidirectionalIterator extends FloatIterator, ObjectBidirectionalIterator<Float> {
    float previousFloat();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Float previous() {
        return Float.valueOf(previousFloat());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousFloat();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
