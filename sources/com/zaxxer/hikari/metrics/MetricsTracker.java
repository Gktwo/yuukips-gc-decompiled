package com.zaxxer.hikari.metrics;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/MetricsTracker.class */
public class MetricsTracker implements AutoCloseable {
    public void recordConnectionAcquiredNanos(long elapsedAcquiredNanos) {
    }

    public void recordConnectionUsageMillis(long elapsedBorrowedMillis) {
    }

    public void recordConnectionTimeout() {
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }
}
