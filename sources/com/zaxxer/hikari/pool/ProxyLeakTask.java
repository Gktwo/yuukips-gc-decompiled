package com.zaxxer.hikari.pool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyLeakTask.class */
public class ProxyLeakTask implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyLeakTask.class);
    private static final ProxyLeakTask NO_LEAK = new ProxyLeakTask() { // from class: com.zaxxer.hikari.pool.ProxyLeakTask.1
        @Override // com.zaxxer.hikari.pool.ProxyLeakTask
        public void cancel() {
        }
    };
    private ScheduledExecutorService executorService;
    private long leakDetectionThreshold;
    private ScheduledFuture<?> scheduledFuture;
    private String connectionName;
    private Exception exception;
    private boolean isLeaked;

    /* access modifiers changed from: package-private */
    public ProxyLeakTask(long leakDetectionThreshold, ScheduledExecutorService executorService) {
        this.executorService = executorService;
        this.leakDetectionThreshold = leakDetectionThreshold;
    }

    private ProxyLeakTask(ProxyLeakTask parent, PoolEntry poolEntry) {
        this.exception = new Exception("Apparent connection leak detected");
        this.connectionName = poolEntry.connection.toString();
        this.scheduledFuture = parent.executorService.schedule(this, parent.leakDetectionThreshold, TimeUnit.MILLISECONDS);
    }

    private ProxyLeakTask() {
    }

    /* access modifiers changed from: package-private */
    public ProxyLeakTask schedule(PoolEntry bagEntry) {
        return this.leakDetectionThreshold == 0 ? NO_LEAK : new ProxyLeakTask(this, bagEntry);
    }

    /* access modifiers changed from: package-private */
    public void updateLeakDetectionThreshold(long leakDetectionThreshold) {
        this.leakDetectionThreshold = leakDetectionThreshold;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.isLeaked = true;
        StackTraceElement[] stackTrace = this.exception.getStackTrace();
        StackTraceElement[] trace = new StackTraceElement[stackTrace.length - 5];
        System.arraycopy(stackTrace, 5, trace, 0, trace.length);
        this.exception.setStackTrace(trace);
        LOGGER.warn("Connection leak detection triggered for {}, stack trace follows", this.connectionName, this.exception);
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.scheduledFuture.cancel(false);
        if (this.isLeaked) {
            LOGGER.info("Previously reported leaked connection {} was returned to the pool (unleaked)", this.connectionName);
        }
    }
}
