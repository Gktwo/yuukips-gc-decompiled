package p013io.netty.util.internal.shaded.org.jctools.queues;

import org.jline.builtins.Tmux;
import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.LinkedQueueNode */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/LinkedQueueNode.class */
public final class LinkedQueueNode<E> {
    private static final long NEXT_OFFSET = UnsafeAccess.fieldOffset(LinkedQueueNode.class, Tmux.CMD_NEXT);
    private E value;
    private volatile LinkedQueueNode<E> next;

    /* access modifiers changed from: package-private */
    public LinkedQueueNode() {
        this(null);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode(E val) {
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

    public void soNext(LinkedQueueNode<E> n) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, NEXT_OFFSET, n);
    }

    public void spNext(LinkedQueueNode<E> n) {
        UnsafeAccess.UNSAFE.putObject(this, NEXT_OFFSET, n);
    }

    public LinkedQueueNode<E> lvNext() {
        return this.next;
    }
}
