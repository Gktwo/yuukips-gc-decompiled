package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.SpscLinkedQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/SpscLinkedQueue.class */
public class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return capacity();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        drain(consumer, waitStrategy, exitCondition);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return drain(consumer);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return drain(consumer, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return relaxedOffer(obj);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return relaxedPeek();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return relaxedPoll();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return peek();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public SpscLinkedQueue() {
        LinkedQueueNode<E> node = newNode();
        spProducerNode(node);
        spConsumerNode(node);
        node.soNext(null);
    }

    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        LinkedQueueNode<E> nextNode = newNode(e);
        LinkedQueueNode<E> oldNode = lpProducerNode();
        soProducerNode(nextNode);
        oldNode.soNext(nextNode);
        return true;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return MessagePassingQueueUtil.fillUnbounded(this, s);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s, int limit) {
        if (null == s) {
            throw new IllegalArgumentException("supplier is null");
        } else if (limit < 0) {
            throw new IllegalArgumentException("limit is negative:" + limit);
        } else if (limit == 0) {
            return 0;
        } else {
            LinkedQueueNode<E> tail = newNode(s.get());
            for (int i = 1; i < limit; i++) {
                LinkedQueueNode<E> temp = newNode(s.get());
                tail.spNext(temp);
                tail = temp;
            }
            LinkedQueueNode<E> oldPNode = lpProducerNode();
            soProducerNode(tail);
            oldPNode.soNext(tail);
            return limit;
        }
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }
}
