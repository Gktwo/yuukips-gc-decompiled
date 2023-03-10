package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: BaseLinkedQueue.java */
/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueueProducerNodeRef */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/BaseLinkedQueueProducerNodeRef.class */
public abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    static final long P_NODE_OFFSET = UnsafeAccess.fieldOffset(BaseLinkedQueueProducerNodeRef.class, "producerNode");
    private volatile LinkedQueueNode<E> producerNode;

    final void spProducerNode(LinkedQueueNode<E> newValue) {
        UnsafeAccess.UNSAFE.putObject(this, P_NODE_OFFSET, newValue);
    }

    final void soProducerNode(LinkedQueueNode<E> newValue) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, P_NODE_OFFSET, newValue);
    }

    final LinkedQueueNode<E> lvProducerNode() {
        return this.producerNode;
    }

    final boolean casProducerNode(LinkedQueueNode<E> expect, LinkedQueueNode<E> newValue) {
        return UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, expect, newValue);
    }

    final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode;
    }
}
