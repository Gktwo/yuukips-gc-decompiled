package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.BidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBidirectionalIterator.class */
public interface ObjectBidirectionalIterator<K> extends ObjectIterator<K>, BidirectionalIterator<K> {
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previous();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
