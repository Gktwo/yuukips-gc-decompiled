package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: BaseMpscLinkedArrayQueue.java */
/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueueConsumerFields */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/BaseMpscLinkedArrayQueueConsumerFields.class */
public abstract class BaseMpscLinkedArrayQueueConsumerFields<E> extends BaseMpscLinkedArrayQueuePad2<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseMpscLinkedArrayQueueConsumerFields.class, "consumerIndex");
    private volatile long consumerIndex;
    protected long consumerMask;
    protected E[] consumerBuffer;

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, C_INDEX_OFFSET);
    }

    final void soConsumerIndex(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, newValue);
    }
}
