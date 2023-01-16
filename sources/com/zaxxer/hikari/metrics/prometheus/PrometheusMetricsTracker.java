package com.zaxxer.hikari.metrics.prometheus;

import com.zaxxer.hikari.metrics.MetricsTracker;
import io.prometheus.client.Counter;
import io.prometheus.client.Summary;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/prometheus/PrometheusMetricsTracker.class */
class PrometheusMetricsTracker extends MetricsTracker {
    private final Counter.Child connectionTimeoutCounter;
    private final Summary.Child elapsedAcquiredSummary;
    private final Summary.Child elapsedBorrowedSummary;

    /* access modifiers changed from: package-private */
    public PrometheusMetricsTracker(String poolName) {
        this.connectionTimeoutCounter = (Counter.Child) Counter.build().name("hikaricp_connection_timeout_count").labelNames(new String[]{"pool"}).help("Connection timeout count").register().labels(new String[]{poolName});
        this.elapsedAcquiredSummary = (Summary.Child) Summary.build().name("hikaricp_connection_acquired_nanos").labelNames(new String[]{"pool"}).help("Connection acquired time").register().labels(new String[]{poolName});
        this.elapsedBorrowedSummary = (Summary.Child) Summary.build().name("hikaricp_connection_usage_millis").labelNames(new String[]{"pool"}).help("Connection usage").register().labels(new String[]{poolName});
    }

    @Override // com.zaxxer.hikari.metrics.MetricsTracker
    public void recordConnectionAcquiredNanos(long elapsedAcquiredNanos) {
        this.elapsedAcquiredSummary.observe((double) elapsedAcquiredNanos);
    }

    @Override // com.zaxxer.hikari.metrics.MetricsTracker
    public void recordConnectionUsageMillis(long elapsedBorrowedMillis) {
        this.elapsedBorrowedSummary.observe((double) elapsedBorrowedMillis);
    }

    @Override // com.zaxxer.hikari.metrics.MetricsTracker
    public void recordConnectionTimeout() {
        this.connectionTimeoutCounter.inc();
    }
}
