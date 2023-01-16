package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MessagePassingQueueUtil.class */
public final class MessagePassingQueueUtil {
    public static <E> int drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c, int limit) {
        E e;
        if (null == c) {
            throw new IllegalArgumentException("c is null");
        } else if (limit < 0) {
            throw new IllegalArgumentException("limit is negative: " + limit);
        } else if (limit == 0) {
            return 0;
        } else {
            int i = 0;
            while (i < limit && (e = queue.relaxedPoll()) != null) {
                c.accept(e);
                i++;
            }
            return i;
        }
    }

    public static <E> int drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c) {
        if (null == c) {
            throw new IllegalArgumentException("c is null");
        }
        int i = 0;
        while (true) {
            E e = queue.relaxedPoll();
            if (e == null) {
                return i;
            }
            i++;
            c.accept(e);
        }
    }

    public static <E> void drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        if (null == c) {
            throw new IllegalArgumentException("c is null");
        } else if (null == wait) {
            throw new IllegalArgumentException("wait is null");
        } else if (null == exit) {
            throw new IllegalArgumentException("exit condition is null");
        } else {
            int idleCounter = 0;
            while (exit.keepRunning()) {
                E e = queue.relaxedPoll();
                if (e == null) {
                    idleCounter = wait.idle(idleCounter);
                } else {
                    idleCounter = 0;
                    c.accept(e);
                }
            }
        }
    }

    public static <E> void fill(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        if (null == wait) {
            throw new IllegalArgumentException("waiter is null");
        } else if (null == exit) {
            throw new IllegalArgumentException("exit condition is null");
        } else {
            int idleCounter = 0;
            while (exit.keepRunning()) {
                if (q.fill(s, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                    idleCounter = wait.idle(idleCounter);
                } else {
                    idleCounter = 0;
                }
            }
        }
    }

    public static <E> int fillBounded(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s) {
        return fillInBatchesToLimit(q, s, PortableJvmInfo.RECOMENDED_OFFER_BATCH, q.capacity());
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s, int batch, int limit) {
        char c = 0;
        do {
            int filled = q.fill(s, batch);
            if (filled == 0) {
                return (int) c;
            }
            c += (long) filled;
        } while (c <= ((long) limit));
        return (int) c;
    }

    public static <E> int fillUnbounded(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s) {
        return fillInBatchesToLimit(q, s, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
    }
}
