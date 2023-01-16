package p001ch.qos.logback.core.util;

import okhttp3.internal.p021ws.WebSocketProtocol;

/* renamed from: ch.qos.logback.core.util.DefaultInvocationGate */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/DefaultInvocationGate.class */
public class DefaultInvocationGate implements InvocationGate {
    static final int MASK_DECREASE_RIGHT_SHIFT_COUNT = 2;
    private static final int MAX_MASK = 65535;
    static final int DEFAULT_MASK = 15;
    private volatile long mask;
    private long invocationCounter;
    private static final long MASK_INCREASE_THRESHOLD = 100;
    private static final long MASK_DECREASE_THRESHOLD = 800;
    private long minDelayThreshold;
    private long maxDelayThreshold;
    long lowerLimitForMaskMatch;
    long upperLimitForNoMaskMatch;

    public DefaultInvocationGate() {
        this(MASK_INCREASE_THRESHOLD, MASK_DECREASE_THRESHOLD, System.currentTimeMillis());
    }

    public DefaultInvocationGate(long minDelayThreshold, long maxDelayThreshold, long currentTime) {
        this.mask = 15;
        this.invocationCounter = 0;
        this.minDelayThreshold = minDelayThreshold;
        this.maxDelayThreshold = maxDelayThreshold;
        this.lowerLimitForMaskMatch = currentTime + minDelayThreshold;
        this.upperLimitForNoMaskMatch = currentTime + maxDelayThreshold;
    }

    @Override // p001ch.qos.logback.core.util.InvocationGate
    public final boolean isTooSoon(long currentTime) {
        long j = this.invocationCounter;
        this.invocationCounter = j + 1;
        boolean maskMatch = (j & this.mask) == this.mask;
        if (maskMatch) {
            if (currentTime < this.lowerLimitForMaskMatch) {
                increaseMask();
            }
            updateLimits(currentTime);
        } else if (currentTime > this.upperLimitForNoMaskMatch) {
            decreaseMask();
            updateLimits(currentTime);
            return false;
        }
        return !maskMatch;
    }

    private void updateLimits(long currentTime) {
        this.lowerLimitForMaskMatch = currentTime + this.minDelayThreshold;
        this.upperLimitForNoMaskMatch = currentTime + this.maxDelayThreshold;
    }

    long getMask() {
        return this.mask;
    }

    private void increaseMask() {
        if (this.mask < WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.mask = (this.mask << 1) | 1;
        }
    }

    private void decreaseMask() {
        this.mask >>>= 2;
    }

    public long getInvocationCounter() {
        return this.invocationCounter;
    }
}
