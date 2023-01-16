package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: BaseLinkedQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/BaseLinkedQueueConsumerNodeRef.class */
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
