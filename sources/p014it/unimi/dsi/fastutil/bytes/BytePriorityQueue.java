package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.bytes.BytePriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/BytePriorityQueue.class */
public interface BytePriorityQueue extends PriorityQueue<Byte> {
    void enqueue(byte b);

    byte dequeueByte();

    byte firstByte();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    Comparator<? super Byte> comparator();

    default byte lastByte() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void enqueue(Byte x) {
        enqueue(x.byteValue());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Byte dequeue() {
        return Byte.valueOf(dequeueByte());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Byte first() {
        return Byte.valueOf(firstByte());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Byte last() {
        return Byte.valueOf(lastByte());
    }
}
