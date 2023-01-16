package com.zaxxer.hikari.metrics.prometheus;

import com.zaxxer.hikari.metrics.MetricsTracker;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import com.zaxxer.hikari.metrics.PoolStats;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/prometheus/PrometheusMetricsTrackerFactory.class */
public class PrometheusMetricsTrackerFactory implements MetricsTrackerFactory {
    @Override // com.zaxxer.hikari.metrics.MetricsTrackerFactory
    public MetricsTracker create(String poolName, PoolStats poolStats) {
        new HikariCPCollector(poolName, poolStats).register();
        return new PrometheusMetricsTracker(poolName);
    }
}
