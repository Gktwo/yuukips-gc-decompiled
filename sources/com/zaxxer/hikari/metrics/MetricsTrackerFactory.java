package com.zaxxer.hikari.metrics;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/MetricsTrackerFactory.class */
public interface MetricsTrackerFactory {
    MetricsTracker create(String str, PoolStats poolStats);
}
