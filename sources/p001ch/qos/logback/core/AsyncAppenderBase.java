package p001ch.qos.logback.core;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import p001ch.qos.logback.core.spi.AppenderAttachable;
import p001ch.qos.logback.core.spi.AppenderAttachableImpl;
import p001ch.qos.logback.core.util.InterruptUtil;

/* renamed from: ch.qos.logback.core.AsyncAppenderBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/AsyncAppenderBase.class */
public class AsyncAppenderBase<E> extends UnsynchronizedAppenderBase<E> implements AppenderAttachable<E> {
    BlockingQueue<E> blockingQueue;
    public static final int DEFAULT_QUEUE_SIZE = 256;
    static final int UNDEFINED = -1;
    public static final int DEFAULT_MAX_FLUSH_TIME = 1000;
    AppenderAttachableImpl<E> aai = new AppenderAttachableImpl<>();
    int queueSize = 256;
    int appenderCount = 0;
    int discardingThreshold = -1;
    boolean neverBlock = false;
    AsyncAppenderBase<E>.Worker worker = new Worker();
    int maxFlushTime = 1000;

    protected boolean isDiscardable(E eventObject) {
        return false;
    }

    protected void preprocess(E eventObject) {
    }

    @Override // p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (!isStarted()) {
            if (this.appenderCount == 0) {
                addError("No attached appenders found.");
            } else if (this.queueSize < 1) {
                addError("Invalid queue size [" + this.queueSize + "]");
            } else {
                this.blockingQueue = new ArrayBlockingQueue(this.queueSize);
                if (this.discardingThreshold == -1) {
                    this.discardingThreshold = this.queueSize / 5;
                }
                addInfo("Setting discardingThreshold to " + this.discardingThreshold);
                this.worker.setDaemon(true);
                this.worker.setName("AsyncAppender-Worker-" + getName());
                start();
                this.worker.start();
            }
        }
    }

    @Override // p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        InterruptUtil interruptUtil;
        if (isStarted()) {
            try {
                stop();
                this.worker.interrupt();
                interruptUtil = new InterruptUtil(this.context);
                try {
                    interruptUtil.maskInterruptFlag();
                    this.worker.join((long) this.maxFlushTime);
                    if (this.worker.isAlive()) {
                        addWarn("Max queue flush timeout (" + this.maxFlushTime + " ms) exceeded. Approximately " + this.blockingQueue.size() + " queued events were possibly discarded.");
                    } else {
                        addInfo("Queue flush finished successfully within timeout.");
                    }
                    interruptUtil.unmaskInterruptFlag();
                } catch (InterruptedException e) {
                    addError("Failed to join worker thread. " + this.blockingQueue.size() + " queued events may be discarded.", e);
                    interruptUtil.unmaskInterruptFlag();
                }
            } catch (Throwable th) {
                interruptUtil.unmaskInterruptFlag();
                throw th;
            }
        }
    }

    @Override // p001ch.qos.logback.core.UnsynchronizedAppenderBase
    protected void append(E eventObject) {
        if (!isQueueBelowDiscardingThreshold() || !isDiscardable(eventObject)) {
            preprocess(eventObject);
            put(eventObject);
        }
    }

    private boolean isQueueBelowDiscardingThreshold() {
        return this.blockingQueue.remainingCapacity() < this.discardingThreshold;
    }

    private void put(E eventObject) {
        if (this.neverBlock) {
            this.blockingQueue.offer(eventObject);
        } else {
            putUninterruptibly(eventObject);
        }
    }

    private void putUninterruptibly(E eventObject) {
        this.blockingQueue.put(eventObject);
        if (0 != 0) {
            Thread.currentThread().interrupt();
        }
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public int getDiscardingThreshold() {
        return this.discardingThreshold;
    }

    public void setDiscardingThreshold(int discardingThreshold) {
        this.discardingThreshold = discardingThreshold;
    }

    public int getMaxFlushTime() {
        return this.maxFlushTime;
    }

    public void setMaxFlushTime(int maxFlushTime) {
        this.maxFlushTime = maxFlushTime;
    }

    public int getNumberOfElementsInQueue() {
        return this.blockingQueue.size();
    }

    public void setNeverBlock(boolean neverBlock) {
        this.neverBlock = neverBlock;
    }

    public boolean isNeverBlock() {
        return this.neverBlock;
    }

    public int getRemainingCapacity() {
        return this.blockingQueue.remainingCapacity();
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public void addAppender(Appender<E> newAppender) {
        if (this.appenderCount == 0) {
            this.appenderCount++;
            addInfo("Attaching appender named [" + newAppender.getName() + "] to AsyncAppender.");
            this.aai.addAppender(newAppender);
            return;
        }
        addWarn("One and only one appender may be attached to AsyncAppender.");
        addWarn("Ignoring additional appender named [" + newAppender.getName() + "]");
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public Iterator<Appender<E>> iteratorForAppenders() {
        return this.aai.iteratorForAppenders();
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public Appender<E> getAppender(String name) {
        return this.aai.getAppender(name);
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public boolean isAttached(Appender<E> eAppender) {
        return this.aai.isAttached(eAppender);
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public void detachAndStopAllAppenders() {
        this.aai.detachAndStopAllAppenders();
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(Appender<E> eAppender) {
        return this.aai.detachAppender(eAppender);
    }

    @Override // p001ch.qos.logback.core.spi.AppenderAttachable
    public boolean detachAppender(String name) {
        return this.aai.detachAppender(name);
    }

    /* renamed from: ch.qos.logback.core.AsyncAppenderBase$Worker */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/AsyncAppenderBase$Worker.class */
    class Worker extends Thread {
        Worker() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: ch.qos.logback.core.spi.AppenderAttachableImpl<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncAppenderBase<E> parent = AsyncAppenderBase.this;
            AppenderAttachableImpl<E> aai = parent.aai;
            while (parent.isStarted()) {
                try {
                    aai.appendLoopOnAppenders(parent.blockingQueue.take());
                } catch (InterruptedException e) {
                }
            }
            AsyncAppenderBase.this.addInfo("Worker thread will flush remaining events before exiting. ");
            for (Object obj : parent.blockingQueue) {
                aai.appendLoopOnAppenders(obj);
                parent.blockingQueue.remove(obj);
            }
            aai.detachAndStopAllAppenders();
        }
    }
}
