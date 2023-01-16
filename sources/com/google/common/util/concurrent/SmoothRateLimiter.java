package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/SmoothRateLimiter.class */
abstract class SmoothRateLimiter extends RateLimiter {
    double storedPermits;
    double maxPermits;
    double stableIntervalMicros;
    private long nextFreeTicketMicros;

    abstract void doSetRate(double d, double d2);

    abstract long storedPermitsToWaitTime(double d, double d2);

    abstract double coolDownIntervalMicros();

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/SmoothRateLimiter$SmoothWarmingUp.class */
    static final class SmoothWarmingUp extends SmoothRateLimiter {
        private final long warmupPeriodMicros;
        private double slope;
        private double thresholdPermits;
        private double coldFactor;

        /* access modifiers changed from: package-private */
        public SmoothWarmingUp(RateLimiter.SleepingStopwatch stopwatch, long warmupPeriod, TimeUnit timeUnit, double coldFactor) {
            super(stopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(warmupPeriod);
            this.coldFactor = coldFactor;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double permitsPerSecond, double stableIntervalMicros) {
            double oldMaxPermits = this.maxPermits;
            double coldIntervalMicros = stableIntervalMicros * this.coldFactor;
            this.thresholdPermits = (0.5d * ((double) this.warmupPeriodMicros)) / stableIntervalMicros;
            this.maxPermits = this.thresholdPermits + ((2.0d * ((double) this.warmupPeriodMicros)) / (stableIntervalMicros + coldIntervalMicros));
            this.slope = (coldIntervalMicros - stableIntervalMicros) / (this.maxPermits - this.thresholdPermits);
            if (oldMaxPermits == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
            } else {
                this.storedPermits = oldMaxPermits == 0.0d ? this.maxPermits : (this.storedPermits * this.maxPermits) / oldMaxPermits;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v0 */
        /* JADX WARN: Type inference failed for: r15v1 */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r0v18, types: [double] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r15v5 */
        /* JADX WARNING: Unknown variable types count: 2 */
        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        /* Code decompiled incorrectly, please refer to instructions dump. */
        long storedPermitsToWaitTime(double r9, double r11) {
            /*
                r8 = this;
                r0 = r9
                r1 = r8
                double r1 = r1.thresholdPermits
                double r0 = r0 - r1
                r13 = r0
                r0 = 0
                r15 = r0
                r0 = r13
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L_0x003d
                r0 = r13
                r1 = r11
                double r0 = java.lang.Math.min(r0, r1)
                r17 = r0
                r0 = r8
                r1 = r13
                double r0 = r0.permitsToTime(r1)
                r1 = r8
                r2 = r13
                r3 = r17
                double r2 = r2 - r3
                double r1 = r1.permitsToTime(r2)
                double r0 = r0 + r1
                r19 = r0
                r0 = r17
                r1 = r19
                double r0 = r0 * r1
                r1 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r0 = r0 / r1
                long r0 = (long) r0
                r15 = r0
                r0 = r11
                r1 = r17
                double r0 = r0 - r1
                r11 = r0
            L_0x003d:
                r0 = r15
                r1 = r8
                double r1 = r1.stableIntervalMicros
                r2 = r11
                double r1 = r1 * r2
                long r1 = (long) r1
                long r0 = r0 + r1
                r15 = r0
                r0 = r15
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SmoothRateLimiter.SmoothWarmingUp.storedPermitsToWaitTime(double, double):long");
        }

        private double permitsToTime(double permits) {
            return this.stableIntervalMicros + (permits * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return ((double) this.warmupPeriodMicros) / this.maxPermits;
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/util/concurrent/SmoothRateLimiter$SmoothBursty.class */
    static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        /* access modifiers changed from: package-private */
        public SmoothBursty(RateLimiter.SleepingStopwatch stopwatch, double maxBurstSeconds) {
            super(stopwatch);
            this.maxBurstSeconds = maxBurstSeconds;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double permitsPerSecond, double stableIntervalMicros) {
            double oldMaxPermits = this.maxPermits;
            this.maxPermits = this.maxBurstSeconds * permitsPerSecond;
            if (oldMaxPermits == Double.POSITIVE_INFINITY) {
                this.storedPermits = this.maxPermits;
            } else {
                this.storedPermits = oldMaxPermits == 0.0d ? 0.0d : (this.storedPermits * this.maxPermits) / oldMaxPermits;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double storedPermits, double permitsToTake) {
            return 0;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch stopwatch) {
        super(stopwatch);
        this.nextFreeTicketMicros = 0;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final void doSetRate(double permitsPerSecond, long nowMicros) {
        resync(nowMicros);
        double stableIntervalMicros = ((double) TimeUnit.SECONDS.toMicros(1)) / permitsPerSecond;
        this.stableIntervalMicros = stableIntervalMicros;
        doSetRate(permitsPerSecond, stableIntervalMicros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double doGetRate() {
        return ((double) TimeUnit.SECONDS.toMicros(1)) / this.stableIntervalMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long queryEarliestAvailable(long nowMicros) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long reserveEarliestAvailable(int requiredPermits, long nowMicros) {
        resync(nowMicros);
        long returnValue = this.nextFreeTicketMicros;
        double storedPermitsToSpend = Math.min((double) requiredPermits, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, storedPermitsToSpend) + ((long) ((((double) requiredPermits) - storedPermitsToSpend) * this.stableIntervalMicros)));
        this.storedPermits -= storedPermitsToSpend;
        return returnValue;
    }

    void resync(long nowMicros) {
        if (nowMicros > this.nextFreeTicketMicros) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (((double) (nowMicros - this.nextFreeTicketMicros)) / coolDownIntervalMicros()));
            this.nextFreeTicketMicros = nowMicros;
        }
    }
}
