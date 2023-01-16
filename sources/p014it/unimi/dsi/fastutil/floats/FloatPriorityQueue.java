package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.PriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatPriorityQueue.class */
public interface FloatPriorityQueue extends PriorityQueue<Float> {
    void enqueue(float f);

    float dequeueFloat();

    float firstFloat();

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    Comparator<? super Float> comparator();

    default float lastFloat() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void enqueue(Float x) {
        enqueue(x.floatValue());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Float dequeue() {
        return Float.valueOf(dequeueFloat());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Float first() {
        return Float.valueOf(firstFloat());
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    @Deprecated
    default Float last() {
        return Float.valueOf(lastFloat());
    }
}
