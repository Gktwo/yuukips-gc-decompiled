package p013io.netty.handler.traffic;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.traffic.TrafficCounter */
/* loaded from: grasscutter.jar:io/netty/handler/traffic/TrafficCounter.class */
public class TrafficCounter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(TrafficCounter.class);
    private final AtomicLong currentWrittenBytes;
    private final AtomicLong currentReadBytes;
    private long writingTime;
    private long readingTime;
    private final AtomicLong cumulativeWrittenBytes;
    private final AtomicLong cumulativeReadBytes;
    private long lastCumulativeTime;
    private long lastWriteThroughput;
    private long lastReadThroughput;
    final AtomicLong lastTime;
    private volatile long lastWrittenBytes;
    private volatile long lastReadBytes;
    private volatile long lastWritingTime;
    private volatile long lastReadingTime;
    private final AtomicLong realWrittenBytes;
    private long realWriteThroughput;
    final AtomicLong checkInterval;
    final String name;
    final AbstractTrafficShapingHandler trafficShapingHandler;
    final ScheduledExecutorService executor;
    Runnable monitor;
    volatile ScheduledFuture<?> scheduledFuture;
    volatile boolean monitorActive;

    public static long milliSecondFromNano() {
        return System.nanoTime() / 1000000;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.traffic.TrafficCounter$TrafficMonitoringTask */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/TrafficCounter$TrafficMonitoringTask.class */
    public final class TrafficMonitoringTask implements Runnable {
        private TrafficMonitoringTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TrafficCounter.this.monitorActive) {
                TrafficCounter.this.resetAccounting(TrafficCounter.milliSecondFromNano());
                if (TrafficCounter.this.trafficShapingHandler != null) {
                    TrafficCounter.this.trafficShapingHandler.doAccounting(TrafficCounter.this);
                }
            }
        }
    }

    public synchronized void start() {
        if (!this.monitorActive) {
            this.lastTime.set(milliSecondFromNano());
            long localCheckInterval = this.checkInterval.get();
            if (localCheckInterval > 0 && this.executor != null) {
                this.monitorActive = true;
                this.monitor = new TrafficMonitoringTask();
                this.scheduledFuture = this.executor.scheduleAtFixedRate(this.monitor, 0, localCheckInterval, TimeUnit.MILLISECONDS);
            }
        }
    }

    public synchronized void stop() {
        if (this.monitorActive) {
            this.monitorActive = false;
            resetAccounting(milliSecondFromNano());
            if (this.trafficShapingHandler != null) {
                this.trafficShapingHandler.doAccounting(this);
            }
            if (this.scheduledFuture != null) {
                this.scheduledFuture.cancel(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void resetAccounting(long newLastTime) {
        long interval = newLastTime - this.lastTime.getAndSet(newLastTime);
        if (interval != 0) {
            if (logger.isDebugEnabled() && interval > (checkInterval() << 1)) {
                logger.debug("Acct schedule not ok: " + interval + " > 2*" + checkInterval() + " from " + this.name);
            }
            this.lastReadBytes = this.currentReadBytes.getAndSet(0);
            this.lastWrittenBytes = this.currentWrittenBytes.getAndSet(0);
            this.lastReadThroughput = (this.lastReadBytes * 1000) / interval;
            this.lastWriteThroughput = (this.lastWrittenBytes * 1000) / interval;
            this.realWriteThroughput = (this.realWrittenBytes.getAndSet(0) * 1000) / interval;
            this.lastWritingTime = Math.max(this.lastWritingTime, this.writingTime);
            this.lastReadingTime = Math.max(this.lastReadingTime, this.readingTime);
        }
    }

    public TrafficCounter(ScheduledExecutorService executor, String name, long checkInterval) {
        this.currentWrittenBytes = new AtomicLong();
        this.currentReadBytes = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.lastTime = new AtomicLong();
        this.realWrittenBytes = new AtomicLong();
        this.checkInterval = new AtomicLong(1000);
        this.name = (String) ObjectUtil.checkNotNull(name, "name");
        this.trafficShapingHandler = null;
        this.executor = executor;
        init(checkInterval);
    }

    public TrafficCounter(AbstractTrafficShapingHandler trafficShapingHandler, ScheduledExecutorService executor, String name, long checkInterval) {
        this.currentWrittenBytes = new AtomicLong();
        this.currentReadBytes = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.lastTime = new AtomicLong();
        this.realWrittenBytes = new AtomicLong();
        this.checkInterval = new AtomicLong(1000);
        this.name = (String) ObjectUtil.checkNotNull(name, "name");
        this.trafficShapingHandler = (AbstractTrafficShapingHandler) ObjectUtil.checkNotNullWithIAE(trafficShapingHandler, "trafficShapingHandler");
        this.executor = executor;
        init(checkInterval);
    }

    private void init(long checkInterval) {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.writingTime = milliSecondFromNano();
        this.readingTime = this.writingTime;
        this.lastWritingTime = this.writingTime;
        this.lastReadingTime = this.writingTime;
        configure(checkInterval);
    }

    public void configure(long newCheckInterval) {
        long newInterval = (newCheckInterval / 10) * 10;
        if (this.checkInterval.getAndSet(newInterval) == newInterval) {
            return;
        }
        if (newInterval <= 0) {
            stop();
            this.lastTime.set(milliSecondFromNano());
            return;
        }
        stop();
        start();
    }

    void bytesRecvFlowControl(long recv) {
        this.currentReadBytes.addAndGet(recv);
        this.cumulativeReadBytes.addAndGet(recv);
    }

    void bytesWriteFlowControl(long write) {
        this.currentWrittenBytes.addAndGet(write);
        this.cumulativeWrittenBytes.addAndGet(write);
    }

    /* access modifiers changed from: package-private */
    public void bytesRealWriteFlowControl(long write) {
        this.realWrittenBytes.addAndGet(write);
    }

    public long checkInterval() {
        return this.checkInterval.get();
    }

    public long lastReadThroughput() {
        return this.lastReadThroughput;
    }

    public long lastWriteThroughput() {
        return this.lastWriteThroughput;
    }

    public long lastReadBytes() {
        return this.lastReadBytes;
    }

    public long lastWrittenBytes() {
        return this.lastWrittenBytes;
    }

    public long currentReadBytes() {
        return this.currentReadBytes.get();
    }

    public long currentWrittenBytes() {
        return this.currentWrittenBytes.get();
    }

    public long lastTime() {
        return this.lastTime.get();
    }

    public long cumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long cumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public long lastCumulativeTime() {
        return this.lastCumulativeTime;
    }

    public AtomicLong getRealWrittenBytes() {
        return this.realWrittenBytes;
    }

    public long getRealWriteThroughput() {
        return this.realWriteThroughput;
    }

    public void resetCumulativeTime() {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.cumulativeReadBytes.set(0);
        this.cumulativeWrittenBytes.set(0);
    }

    public String name() {
        return this.name;
    }

    @Deprecated
    public long readTimeToWait(long size, long limitTraffic, long maxTime) {
        return readTimeToWait(size, limitTraffic, maxTime, milliSecondFromNano());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /* JADX WARN: Type inference failed for: r33v1, types: [long] */
    /* JADX WARN: Type inference failed for: r33v2 */
    /* JADX WARN: Type inference failed for: r29v2, types: [long] */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v6 */
    /* JADX WARN: Type inference failed for: r33v4 */
    /* JADX WARN: Type inference failed for: r33v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readTimeToWait(long r9, long r11, long r13, long r15) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.TrafficCounter.readTimeToWait(long, long, long, long):long");
    }

    @Deprecated
    public long writeTimeToWait(long size, long limitTraffic, long maxTime) {
        return writeTimeToWait(size, limitTraffic, maxTime, milliSecondFromNano());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /* JADX WARN: Type inference failed for: r33v1, types: [long] */
    /* JADX WARN: Type inference failed for: r33v2 */
    /* JADX WARN: Type inference failed for: r29v2, types: [long] */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v6 */
    /* JADX WARN: Type inference failed for: r33v4 */
    /* JADX WARN: Type inference failed for: r33v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long writeTimeToWait(long r9, long r11, long r13, long r15) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.TrafficCounter.writeTimeToWait(long, long, long, long):long");
    }

    public String toString() {
        return new StringBuilder(165).append("Monitor ").append(this.name).append(" Current Speed Read: ").append(this.lastReadThroughput >> 10).append(" KB/s, ").append("Asked Write: ").append(this.lastWriteThroughput >> 10).append(" KB/s, ").append("Real Write: ").append(this.realWriteThroughput >> 10).append(" KB/s, ").append("Current Read: ").append(this.currentReadBytes.get() >> 10).append(" KB, ").append("Current asked Write: ").append(this.currentWrittenBytes.get() >> 10).append(" KB, ").append("Current real Write: ").append(this.realWrittenBytes.get() >> 10).append(" KB").toString();
    }
}
