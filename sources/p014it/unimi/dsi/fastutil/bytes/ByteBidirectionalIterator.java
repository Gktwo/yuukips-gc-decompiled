package p014it.unimi.dsi.fastutil.bytes;

import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBidirectionalIterator.class */
public interface ByteBidirectionalIterator extends ByteIterator, ObjectBidirectionalIterator<Byte> {
    byte previousByte();

    @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Byte previous() {
        return Byte.valueOf(previousByte());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
    default int back(int n) {
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasPrevious()) {
                break;
            }
            previousByte();
        }
        return (n - i) - 1;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
    default int skip(int n) {
        return skip(n);
    }
}
