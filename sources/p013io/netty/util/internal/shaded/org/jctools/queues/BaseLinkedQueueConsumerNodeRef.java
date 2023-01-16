package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: BaseLinkedQueue.java */
/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueueConsumerNodeRef */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/BaseLinkedQueueConsumerNodeRef.class */
public abstract class BaseLinkedQueueConsumerNodeRef<E> extends BaseLinkedQueuePad1<E> {
    private static final long C_NODE_OFFSET = UnsafeAccess.fieldOffset(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
    private LinkedQueueNode<E> consumerNode;

    final void spConsumerNode(LinkedQueueNode<E> newValue) {
        this.consumerNode = newValue;
    }

    final LinkedQueueNode<E> lvConsumerNode() {
        return (LinkedQueueNode) UnsafeAccess.UNSAFE.getObjectVolatile(this, C_NODE_OFFSET);
    }

    final LinkedQueueNode<E> lpConsumerNode() {
        return this.consumerNode;
    }
}
