package com.zaxxer.hikari.metrics.dropwizard;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.zaxxer.hikari.metrics.MetricsTracker;
import com.zaxxer.hikari.metrics.PoolStats;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/dropwizard/CodaHaleMetricsTracker.class */
public final class CodaHaleMetricsTracker extends MetricsTracker {
    private final String poolName;
    private final Timer connectionObtainTimer;
    private final Histogram connectionUsage;
    private final Meter connectionTimeoutMeter;
    private final MetricRegistry registry;
    private static final String METRIC_CATEGORY = "pool";
    private static final String METRIC_NAME_WAIT = "Wait";
    private static final String METRIC_NAME_USAGE = "Usage";
    private static final String METRIC_NAME_TIMEOUT_RATE = "ConnectionTimeoutRate";
    private static final String METRIC_NAME_TOTAL_CONNECTIONS = "TotalConnections";
    private static final String METRIC_NAME_IDLE_CONNECTIONS = "IdleConnections";
    private static final String METRIC_NAME_ACTIVE_CONNECTIONS = "ActiveConnections";
    private static final String METRIC_NAME_PENDING_CONNECTIONS = "PendingConnections";

    public CodaHaleMetricsTracker(String poolName, final PoolStats poolStats, MetricRegistry registry) {
        this.poolName = poolName;
        this.registry = registry;
        this.connectionObtainTimer = registry.timer(MetricRegistry.name(poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_WAIT}));
        this.connectionUsage = registry.histogram(MetricRegistry.name(poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_USAGE}));
        this.connectionTimeoutMeter = registry.meter(MetricRegistry.name(poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_TIMEOUT_RATE}));
        registry.register(MetricRegistry.name(poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_TOTAL_CONNECTIONS}), new Gauge<Integer>() { // from class: com.zaxxer.hikari.metrics.dropwizard.CodaHaleMetricsTracker.1
            public Integer getValue() {
                return Integer.valueOf(poolStats.getTotalConnections());
            }
        });
        registry.register(MetricRegistry.name(poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_IDLE_CONNECTIONS}), new Gauge<Integer>() { // from class: com.zaxxer.hikari.metrics.dropwizard.CodaHaleMetricsTracker.2
            public Integer getValue() {
                return Integer.valueOf(poolStats.getIdleConnections());
            }
        });
        registry.register(MetricRegistry.name(poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_ACTIVE_CONNECTIONS}), new Gauge<Integer>() { // from class: com.zaxxer.hikari.metrics.dropwizard.CodaHaleMetricsTracker.3
            public Integer getValue() {
                return Integer.valueOf(poolStats.getActiveConnections());
            }
        });
        registry.register(MetricRegistry.name(poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_PENDING_CONNECTIONS}), new Gauge<Integer>() { // from class: com.zaxxer.hikari.metrics.dropwizard.CodaHaleMetricsTracker.4
            public Integer getValue() {
                return Integer.valueOf(poolStats.getPendingThreads());
            }
        });
    }

    @Override // com.zaxxer.hikari.metrics.MetricsTracker, java.lang.AutoCloseable
    public void close() {
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_WAIT}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_USAGE}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_TIMEOUT_RATE}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_TOTAL_CONNECTIONS}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_IDLE_CONNECTIONS}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_ACTIVE_CONNECTIONS}));
        this.registry.remove(MetricRegistry.name(this.poolName, new String[]{METRIC_CATEGORY, METRIC_NAME_PENDING_CONNECTIONS}));
    }

    @Override // com.zaxxer.hikari.metrics.MetricsTracker
    public void recordConnectionAcquiredNanos(long elapsedAcquiredNanos) {
        this.connectionObtainTimer.update(elapsedAcquiredNanos, TimeUnit.NANOSECONDS);
    }

    @Override // com.zaxxer.hikari.metrics.MetricsTracker
    public void recordConnectionUsageMillis(long elapsedBorrowedMillis) {
        this.connectionUsage.update(elapsedBorrowedMillis);
    }

    @Override // com.zaxxer.hikari.metrics.MetricsTracker
    public void recordConnectionTimeout() {
        this.connectionTimeoutMeter.mark();
    }

    public Timer getConnectionAcquisitionTimer() {
        return this.connectionObtainTimer;
    }

    public Histogram getConnectionDurationHistogram() {
        return this.connectionUsage;
    }
}
