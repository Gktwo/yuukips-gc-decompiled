package com.mchange.p009v2.async;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.util.ResourceClosedException;

/* renamed from: com.mchange.v2.async.RoundRobinAsynchronousRunner */
/* loaded from: grasscutter.jar:com/mchange/v2/async/RoundRobinAsynchronousRunner.class */
public class RoundRobinAsynchronousRunner implements AsynchronousRunner, Queuable {
    private static final MLogger logger = MLog.getLogger(RoundRobinAsynchronousRunner.class);
    final RunnableQueue[] rqs;
    int task_turn = 0;
    int view_turn = 0;

    public RoundRobinAsynchronousRunner(int i, boolean z) {
        this.rqs = new RunnableQueue[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.rqs[i2] = new CarefulRunnableQueue(z, false);
        }
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void postRunnable(Runnable runnable) {
        try {
            int i = this.task_turn;
            this.task_turn = (this.task_turn + 1) % this.rqs.length;
            this.rqs[i].postRunnable(runnable);
        } catch (NullPointerException e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "NullPointerException while posting Runnable -- Probably we're closed.", (Throwable) e);
            }
            close(true);
            throw new ResourceClosedException("Attempted to use a RoundRobinAsynchronousRunner in a closed or broken state.");
        }
    }

    @Override // com.mchange.p009v2.async.Queuable
    public synchronized RunnableQueue asRunnableQueue() {
        try {
            int i = this.view_turn;
            this.view_turn = (this.view_turn + 1) % this.rqs.length;
            return new RunnableQueueView(i);
        } catch (NullPointerException e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "NullPointerException in asRunnableQueue() -- Probably we're closed.", (Throwable) e);
            }
            close(true);
            throw new ResourceClosedException("Attempted to use a RoundRobinAsynchronousRunner in a closed or broken state.");
        }
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void close(boolean z) {
        int length = this.rqs.length;
        for (int i = 0; i < length; i++) {
            attemptClose(this.rqs[i], z);
            this.rqs[i] = null;
        }
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner, com.mchange.p006v1.util.ClosableResource
    public void close() {
        close(true);
    }

    static void attemptClose(RunnableQueue runnableQueue, boolean z) {
        try {
            runnableQueue.close(z);
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "RunnableQueue close FAILED.", (Throwable) e);
            }
        }
    }

    /* renamed from: com.mchange.v2.async.RoundRobinAsynchronousRunner$RunnableQueueView */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/RoundRobinAsynchronousRunner$RunnableQueueView.class */
    class RunnableQueueView implements RunnableQueue {
        final int rq_num;

        RunnableQueueView(int i) {
            this.rq_num = i;
        }

        @Override // com.mchange.p009v2.async.AsynchronousRunner
        public void postRunnable(Runnable runnable) {
            RoundRobinAsynchronousRunner.this.rqs[this.rq_num].postRunnable(runnable);
        }

        @Override // com.mchange.p009v2.async.AsynchronousRunner
        public void close(boolean z) {
        }

        @Override // com.mchange.p009v2.async.AsynchronousRunner, com.mchange.p006v1.util.ClosableResource
        public void close() {
        }
    }
}
