package kcp.highway.threadPool.order;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jctools.queues.MpscLinkedQueue;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/order/OrderedThreadSession.class */
public class OrderedThreadSession {

    /* renamed from: id */
    private int f3086id;
    private Queue<Runnable> queue;
    private final AtomicBoolean processingCompleted;
    private int runTaskCount;

    public OrderedThreadSession() {
        this(new MpscLinkedQueue());
    }

    public OrderedThreadSession(Queue<Runnable> queue) {
        this(queue, Integer.MAX_VALUE);
    }

    public OrderedThreadSession(Queue<Runnable> queue, int runTaskCount) {
        this.processingCompleted = new AtomicBoolean(true);
        this.runTaskCount = 0;
        this.queue = queue;
        this.runTaskCount = runTaskCount;
    }

    public void setQueue(Queue<Runnable> queue) {
        this.queue = queue;
    }

    public Queue<Runnable> getQueue() {
        return this.queue;
    }

    public AtomicBoolean getProcessingCompleted() {
        return this.processingCompleted;
    }

    public int getRunTaskCount() {
        return this.runTaskCount;
    }

    public int getId() {
        return this.f3086id;
    }

    public void setId(int id) {
        this.f3086id = id;
    }

    public void setRunTaskCount(int runTaskCount) {
        this.runTaskCount = runTaskCount;
    }
}
