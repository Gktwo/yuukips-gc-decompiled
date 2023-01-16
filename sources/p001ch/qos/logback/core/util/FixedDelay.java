package p001ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.FixedDelay */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/FixedDelay.class */
public class FixedDelay implements DelayStrategy {
    private final long subsequentDelay;
    private long nextDelay;

    public FixedDelay(long initialDelay, long subsequentDelay) {
        this.nextDelay = initialDelay;
        this.subsequentDelay = subsequentDelay;
    }

    public FixedDelay(int delay) {
        this((long) delay, (long) delay);
    }

    @Override // p001ch.qos.logback.core.util.DelayStrategy
    public long nextDelay() {
        long delay = this.nextDelay;
        this.nextDelay = this.subsequentDelay;
        return delay;
    }
}
