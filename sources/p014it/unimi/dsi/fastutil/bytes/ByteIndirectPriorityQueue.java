package p014it.unimi.dsi.fastutil.bytes;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteIndirectPriorityQueue.class */
public interface ByteIndirectPriorityQueue extends IndirectPriorityQueue<Byte> {
    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    Comparator<? super Byte> comparator();
}
