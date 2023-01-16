package p014it.unimi.dsi.fastutil.bytes;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteListIterator.class */
public interface ByteListIterator extends ByteBidirectionalIterator, ListIterator<Byte> {
    default void set(byte k) {
        throw new UnsupportedOperationException();
    }

    default void add(byte k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Byte k) {
        set(k.byteValue());
    }

    @Deprecated
    default void add(Byte k) {
        add(k.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator, java.util.Iterator
    @Deprecated
    default Byte next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Byte previous() {
        return previous();
    }
}
