package p014it.unimi.dsi.fastutil.booleans;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBidirectionalIterator.class */
public interface BooleanBidirectionalIterator extends BooleanIterator, ObjectBidirectionalIterator<Boolean> {
    boolean previousBoolean();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Boolean previous() {
        return Boolean.valueOf(previousBoolean());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousBoolean();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
