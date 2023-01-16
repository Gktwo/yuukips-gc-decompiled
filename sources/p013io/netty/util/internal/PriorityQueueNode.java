package p013io.netty.util.internal;

/* renamed from: io.netty.util.internal.PriorityQueueNode */
/* loaded from: grasscutter.jar:io/netty/util/internal/PriorityQueueNode.class */
public interface PriorityQueueNode {
    public static final int INDEX_NOT_IN_QUEUE = -1;

    int priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue);

    void priorityQueueIndex(DefaultPriorityQueue<?> defaultPriorityQueue, int i);
}
