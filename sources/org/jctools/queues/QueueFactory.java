package org.jctools.queues;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;

@Deprecated
/* loaded from: grasscutter.jar:org/jctools/queues/QueueFactory.class */
public class QueueFactory {
    public static <E> Queue<E> newQueue(ConcurrentQueueSpec qs) {
        if (qs.isBounded()) {
            if (qs.isSpsc()) {
                return new SpscArrayQueue(qs.capacity);
            }
            if (qs.isMpsc()) {
                if (qs.ordering != Ordering.NONE) {
                    return new MpscArrayQueue(qs.capacity);
                }
                return new MpscCompoundQueue(qs.capacity);
            } else if (qs.isSpmc()) {
                return new SpmcArrayQueue(qs.capacity);
            } else {
                return new MpmcArrayQueue(qs.capacity);
            }
        } else if (qs.isSpsc()) {
            return new SpscLinkedQueue();
        } else {
            if (qs.isMpsc()) {
                return new MpscLinkedQueue();
            }
            return new ConcurrentLinkedQueue();
        }
    }
}
