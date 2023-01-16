package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedQueueAtomicNode */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/LinkedQueueAtomicNode.class */
public final class LinkedQueueAtomicNode<E> extends AtomicReference<LinkedQueueAtomicNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    /* access modifiers changed from: package-private */
    public LinkedQueueAtomicNode() {
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueAtomicNode(E val) {
        spValue(val);
    }

    public E getAndNullValue() {
        E temp = lpValue();
        spValue(null);
        return temp;
    }

    public E lpValue() {
        return this.value;
    }

    public void spValue(E newValue) {
        this.value = newValue;
    }

    public void soNext(LinkedQueueAtomicNode<E> n) {
        lazySet(n);
    }

    public void spNext(LinkedQueueAtomicNode<E> n) {
        lazySet(n);
    }

    public LinkedQueueAtomicNode<E> lvNext() {
        return get();
    }
}
