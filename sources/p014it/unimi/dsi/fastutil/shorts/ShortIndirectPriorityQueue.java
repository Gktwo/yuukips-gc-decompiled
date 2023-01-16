package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIndirectPriorityQueue.class */
public interface ShortIndirectPriorityQueue extends IndirectPriorityQueue<Short> {
    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    Comparator<? super Short> comparator();
}
