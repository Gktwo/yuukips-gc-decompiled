package com.zaxxer.hikari.metrics.prometheus;

import com.zaxxer.hikari.metrics.PoolStats;
import io.prometheus.client.Collector;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/prometheus/HikariCPCollector.class */
class HikariCPCollector extends Collector {
    private final PoolStats poolStats;
    private final List<String> labelNames = Collections.singletonList("pool");
    private final List<String> labelValues;

    /* access modifiers changed from: package-private */
    public HikariCPCollector(String poolName, PoolStats poolStats) {
        this.poolStats = poolStats;
        this.labelValues = Collections.singletonList(poolName);
    }

    public List<Collector.MetricFamilySamples> collect() {
        return Arrays.asList(createSample("hikaricp_active_connections", "Active connections", (double) this.poolStats.getActiveConnections()), createSample("hikaricp_idle_connections", "Idle connections", (double) this.poolStats.getIdleConnections()), createSample("hikaricp_pending_threads", "Pending threads", (double) this.poolStats.getPendingThreads()), createSample("hikaricp_connections", "The number of current connections", (double) this.poolStats.getTotalConnections()));
    }

    private Collector.MetricFamilySamples createSample(String name, String helpMessage, double value) {
        return new Collector.MetricFamilySamples(name, Collector.Type.GAUGE, helpMessage, Collections.singletonList(new Collector.MetricFamilySamples.Sample(name, this.labelNames, this.labelValues, value)));
    }
}
