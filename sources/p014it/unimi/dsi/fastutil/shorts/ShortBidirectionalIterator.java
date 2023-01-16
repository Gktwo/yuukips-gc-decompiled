package p014it.unimi.dsi.fastutil.shorts;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBidirectionalIterator.class */
public interface ShortBidirectionalIterator extends ShortIterator, ObjectBidirectionalIterator<Short> {
    short previousShort();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Short previous() {
        return Short.valueOf(previousShort());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousShort();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
