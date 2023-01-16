package p013io.netty.util.internal.shaded.org.jctools.queues;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/IndexedQueueSizeUtil.class */
public final class IndexedQueueSizeUtil {

    /* renamed from: io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue */
    /* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/IndexedQueueSizeUtil$IndexedQueue.class */
    public interface IndexedQueue {
        long lvConsumerIndex();

        long lvProducerIndex();

        @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        int capacity();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    public static int size(IndexedQueue iq) {
        long currentProducerIndex;
        char lvConsumerIndex = iq.lvConsumerIndex();
        do {
            currentProducerIndex = iq.lvProducerIndex();
            lvConsumerIndex = iq.lvConsumerIndex();
        } while (lvConsumerIndex != lvConsumerIndex);
        long size = currentProducerIndex - lvConsumerIndex;
        if (size > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (size < 0) {
            return 0;
        }
        if (iq.capacity() == -1 || size <= ((long) iq.capacity())) {
            return (int) size;
        }
        return iq.capacity();
    }

    public static boolean isEmpty(IndexedQueue iq) {
        return iq.lvConsumerIndex() >= iq.lvProducerIndex();
    }
}
