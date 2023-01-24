package com.zaxxer.hikari.metrics.dropwizard;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/dropwizard/CodahaleHealthChecker.class */
public final class CodahaleHealthChecker {
    public static void registerHealthChecks(HikariPool pool, final HikariConfig hikariConfig, HealthCheckRegistry registry) {
        Properties healthCheckProperties = hikariConfig.getHealthCheckProperties();
        MetricRegistry metricRegistry = (MetricRegistry) hikariConfig.getMetricRegistry();
        registry.register(MetricRegistry.name(hikariConfig.getPoolName(), new String[]{"pool", "ConnectivityCheck"}), new ConnectivityHealthCheck(pool, Long.parseLong(healthCheckProperties.getProperty("connectivityCheckTimeoutMs", String.valueOf(hikariConfig.getConnectionTimeout())))));
        long expected99thPercentile = Long.parseLong(healthCheckProperties.getProperty("expected99thPercentileMs", "0"));
        if (metricRegistry != null && expected99thPercentile > 0) {
            SortedMap<String, Timer> timers = metricRegistry.getTimers(new MetricFilter() { // from class: com.zaxxer.hikari.metrics.dropwizard.CodahaleHealthChecker.1
                public boolean matches(String name, Metric metric) {
                    return name.equals(MetricRegistry.name(hikariConfig.getPoolName(), new String[]{"pool", "Wait"}));
                }
            });
            if (!timers.isEmpty()) {
                registry.register(MetricRegistry.name(hikariConfig.getPoolName(), new String[]{"pool", "Connection99Percent"}), new Connection99Percent(timers.entrySet().iterator().next().getValue(), expected99thPercentile));
            }
        }
    }

    private CodahaleHealthChecker() {
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/dropwizard/CodahaleHealthChecker$ConnectivityHealthCheck.class */
    public static class ConnectivityHealthCheck extends HealthCheck {
        private final HikariPool pool;
        private final long checkTimeoutMs;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0, types: [long] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v10 */
        ConnectivityHealthCheck(HikariPool pool, long j) {
            this.pool = pool;
            this.checkTimeoutMs = (((j > 0 ? 1 : (j == 0 ? 0 : -1)) <= 0 || (j > 2147483647L ? 1 : (j == 2147483647L ? 0 : -1)) == 0) ? TimeUnit.SECONDS.toMillis(10) : j) == true ? 1 : 0;
        }

        protected HealthCheck.Result check() throws Exception {
            try {
                Connection connection = this.pool.getConnection(this.checkTimeoutMs);
                HealthCheck.Result healthy = HealthCheck.Result.healthy();
                if (connection != null) {
                    if (0 != 0) {
                        connection.close();
                    } else {
                        connection.close();
                    }
                }
                return healthy;
            } catch (SQLException e) {
                return HealthCheck.Result.unhealthy(e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/metrics/dropwizard/CodahaleHealthChecker$Connection99Percent.class */
    public static class Connection99Percent extends HealthCheck {
        private final Timer waitTimer;
        private final long expected99thPercentile;

        Connection99Percent(Timer waitTimer, long expected99thPercentile) {
            this.waitTimer = waitTimer;
            this.expected99thPercentile = expected99thPercentile;
        }

        protected HealthCheck.Result check() throws Exception {
            long the99thPercentile = TimeUnit.NANOSECONDS.toMillis(Math.round(this.waitTimer.getSnapshot().get99thPercentile()));
            return the99thPercentile <= this.expected99thPercentile ? HealthCheck.Result.healthy() : HealthCheck.Result.unhealthy("99th percentile connection wait time of %dms exceeds the threshold %dms", new Object[]{Long.valueOf(the99thPercentile), Long.valueOf(this.expected99thPercentile)});
        }
    }
}
