package p013io.netty.handler.traffic;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.traffic.GlobalChannelTrafficCounter */
/* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalChannelTrafficCounter.class */
public class GlobalChannelTrafficCounter extends TrafficCounter {
    public GlobalChannelTrafficCounter(GlobalChannelTrafficShapingHandler trafficShapingHandler, ScheduledExecutorService executor, String name, long checkInterval) {
        super(trafficShapingHandler, executor, name, checkInterval);
        ObjectUtil.checkNotNullWithIAE(executor, "executor");
    }

    /* renamed from: io.netty.handler.traffic.GlobalChannelTrafficCounter$MixedTrafficMonitoringTask */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalChannelTrafficCounter$MixedTrafficMonitoringTask.class */
    private static class MixedTrafficMonitoringTask implements Runnable {
        private final GlobalChannelTrafficShapingHandler trafficShapingHandler1;
        private final TrafficCounter counter;

        MixedTrafficMonitoringTask(GlobalChannelTrafficShapingHandler trafficShapingHandler, TrafficCounter counter) {
            this.trafficShapingHandler1 = trafficShapingHandler;
            this.counter = counter;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.counter.monitorActive) {
                long newLastTime = TrafficCounter.milliSecondFromNano();
                this.counter.resetAccounting(newLastTime);
                for (GlobalChannelTrafficShapingHandler.PerChannel perChannel : this.trafficShapingHandler1.channelQueues.values()) {
                    perChannel.channelTrafficCounter.resetAccounting(newLastTime);
                }
                this.trafficShapingHandler1.doAccounting(this.counter);
            }
        }
    }

    @Override // p013io.netty.handler.traffic.TrafficCounter
    public synchronized void start() {
        if (!this.monitorActive) {
            this.lastTime.set(milliSecondFromNano());
            long localCheckInterval = this.checkInterval.get();
            if (localCheckInterval > 0) {
                this.monitorActive = true;
                this.monitor = new MixedTrafficMonitoringTask((GlobalChannelTrafficShapingHandler) this.trafficShapingHandler, this);
                this.scheduledFuture = this.executor.scheduleAtFixedRate(this.monitor, 0, localCheckInterval, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // p013io.netty.handler.traffic.TrafficCounter
    public synchronized void stop() {
        if (this.monitorActive) {
            this.monitorActive = false;
            resetAccounting(milliSecondFromNano());
            this.trafficShapingHandler.doAccounting(this);
            if (this.scheduledFuture != null) {
                this.scheduledFuture.cancel(true);
            }
        }
    }

    @Override // p013io.netty.handler.traffic.TrafficCounter
    public void resetCumulativeTime() {
        for (GlobalChannelTrafficShapingHandler.PerChannel perChannel : ((GlobalChannelTrafficShapingHandler) this.trafficShapingHandler).channelQueues.values()) {
            perChannel.channelTrafficCounter.resetCumulativeTime();
        }
        resetCumulativeTime();
    }
}
