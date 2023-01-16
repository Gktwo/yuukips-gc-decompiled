package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIndirectPriorityQueue.class */
public interface FloatIndirectPriorityQueue extends IndirectPriorityQueue<Float> {
    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    Comparator<? super Float> comparator();
}
