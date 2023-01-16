package com.mongodb.internal.connection;

import com.mongodb.assertions.Assertions;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ExponentiallyWeightedMovingAverage.class */
public class ExponentiallyWeightedMovingAverage {
    private final double alpha;
    private long average = -1;

    /* access modifiers changed from: package-private */
    public ExponentiallyWeightedMovingAverage(double alpha) {
        Assertions.isTrueArgument("alpha >= 0.0 and <= 1.0", alpha >= 0.0d && alpha <= 1.0d);
        this.alpha = alpha;
    }

    /* access modifiers changed from: package-private */
    public synchronized void reset() {
        this.average = -1;
    }

    /* access modifiers changed from: package-private */
    public synchronized long addSample(long sample) {
        if (this.average == -1) {
            this.average = sample;
        } else {
            this.average = (long) ((this.alpha * ((double) sample)) + ((1.0d - this.alpha) * ((double) this.average)));
        }
        return this.average;
    }

    /* access modifiers changed from: package-private */
    public synchronized long getAverage() {
        if (this.average == -1) {
            return 0;
        }
        return this.average;
    }
}
