package org.jctools.queues.atomic;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jctools.queues.spec.ConcurrentQueueSpec;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/AtomicQueueFactory.class */
public class AtomicQueueFactory {
    public static <E> Queue<E> newQueue(ConcurrentQueueSpec qs) {
        if (qs.isBounded()) {
            if (qs.isSpsc()) {
                return new SpscAtomicArrayQueue(qs.capacity);
            }
            if (qs.isMpsc()) {
                return new MpscAtomicArrayQueue(qs.capacity);
            }
            if (qs.isSpmc()) {
                return new SpmcAtomicArrayQueue(qs.capacity);
            }
            return new MpmcAtomicArrayQueue(qs.capacity);
        } else if (qs.isSpsc()) {
            return new SpscLinkedAtomicQueue();
        } else {
            if (qs.isMpsc()) {
                return new MpscLinkedAtomicQueue();
            }
            return new ConcurrentLinkedQueue();
        }
    }
}
