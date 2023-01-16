package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.Iterator;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/BaseLinkedAtomicQueue.class */
public abstract class BaseLinkedAtomicQueue<E> extends BaseLinkedAtomicQueuePad2<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return getClass().getName();
    }

    protected final LinkedQueueAtomicNode<E> newNode() {
        return new LinkedQueueAtomicNode<>();
    }

    protected final LinkedQueueAtomicNode<E> newNode(E e) {
        return new LinkedQueueAtomicNode<>(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        LinkedQueueAtomicNode<E> chaserNode = lvConsumerNode();
        LinkedQueueAtomicNode<E> producerNode = lvProducerNode();
        int size = 0;
        while (chaserNode != producerNode && chaserNode != null && size < Integer.MAX_VALUE) {
            LinkedQueueAtomicNode<E> next = chaserNode.lvNext();
            if (next == chaserNode) {
                return size;
            }
            chaserNode = next;
            size++;
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    protected E getSingleConsumerNodeValue(LinkedQueueAtomicNode<E> currConsumerNode, LinkedQueueAtomicNode<E> nextNode) {
        E nextValue = nextNode.getAndNullValue();
        currConsumerNode.soNext(currConsumerNode);
        spConsumerNode(nextNode);
        return nextValue;
    }

    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        LinkedQueueAtomicNode<E> currConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return getSingleConsumerNodeValue(currConsumerNode, nextNode);
        }
        if (currConsumerNode != lvProducerNode()) {
            return getSingleConsumerNodeValue(currConsumerNode, spinWaitForNextNode(currConsumerNode));
        }
        return null;
    }

    @Override // java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        LinkedQueueAtomicNode<E> currConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return nextNode.lpValue();
        }
        if (currConsumerNode != lvProducerNode()) {
            return spinWaitForNextNode(currConsumerNode).lpValue();
        }
        return null;
    }

    LinkedQueueAtomicNode<E> spinWaitForNextNode(LinkedQueueAtomicNode<E> currNode) {
        LinkedQueueAtomicNode<E> nextNode;
        do {
            nextNode = currNode.lvNext();
        } while (nextNode == null);
        return nextNode;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        LinkedQueueAtomicNode<E> currConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> nextNode = currConsumerNode.lvNext();
        if (nextNode != null) {
            return getSingleConsumerNodeValue(currConsumerNode, nextNode);
        }
        return null;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        LinkedQueueAtomicNode<E> nextNode = lpConsumerNode().lvNext();
        if (nextNode != null) {
            return nextNode.lpValue();
        }
        return null;
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c, int limit) {
        if (null == c) {
            throw new IllegalArgumentException("c is null");
        } else if (limit < 0) {
            throw new IllegalArgumentException("limit is negative: " + limit);
        } else if (limit == 0) {
            return 0;
        } else {
            LinkedQueueAtomicNode<E> chaserNode = lpConsumerNode();
            for (int i = 0; i < limit; i++) {
                LinkedQueueAtomicNode<E> nextNode = chaserNode.lvNext();
                if (nextNode == null) {
                    return i;
                }
                E nextValue = getSingleConsumerNodeValue(chaserNode, nextNode);
                chaserNode = nextNode;
                c.accept(nextValue);
            }
            return limit;
        }
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return MessagePassingQueueUtil.drain(this, c);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, wait, exit);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }
}
