package p014it.unimi.dsi.fastutil.longs;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.longs.LongIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIndirectPriorityQueue.class */
public interface LongIndirectPriorityQueue extends IndirectPriorityQueue<Long> {
    /* Return type fixed from 'it.unimi.dsi.fastutil.longs.LongComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    Comparator<? super Long> comparator();
}
