package p013io.netty.util.internal;

import java.util.Queue;

/* renamed from: io.netty.util.internal.PriorityQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/PriorityQueue.class */
public interface PriorityQueue<T> extends Queue<T> {
    boolean removeTyped(T t);

    boolean containsTyped(T t);

    void priorityChanged(T t);

    void clearIgnoringIndexes();
}
