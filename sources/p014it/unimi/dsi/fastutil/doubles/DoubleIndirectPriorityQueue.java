package p014it.unimi.dsi.fastutil.doubles;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleIndirectPriorityQueue.class */
public interface DoubleIndirectPriorityQueue extends IndirectPriorityQueue<Double> {
    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    Comparator<? super Double> comparator();
}
