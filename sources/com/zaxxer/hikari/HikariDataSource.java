package com.zaxxer.hikari;

import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import com.zaxxer.hikari.pool.HikariPool;
import java.io.Closeable;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/HikariDataSource.class */
public class HikariDataSource extends HikariConfig implements DataSource, Closeable {
    private static final Logger LOGGER = LoggerFactory.getLogger(HikariDataSource.class);
    private final AtomicBoolean isShutdown;
    private final HikariPool fastPathPool;
    private volatile HikariPool pool;

    public HikariDataSource() {
        this.isShutdown = new AtomicBoolean();
        this.fastPathPool = null;
    }

    public HikariDataSource(HikariConfig configuration) {
        this.isShutdown = new AtomicBoolean();
        configuration.validate();
        configuration.copyState(this);
        LOGGER.info("{} - Starting...", configuration.getPoolName());
        HikariPool hikariPool = new HikariPool(this);
        this.fastPathPool = hikariPool;
        this.pool = hikariPool;
        LOGGER.info("{} - Start completed.", configuration.getPoolName());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x006f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // javax.sql.DataSource
    public java.sql.Connection getConnection() throws java.sql.SQLException {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.isClosed()
            if (r0 == 0) goto L_0x0027
            java.sql.SQLException r0 = new java.sql.SQLException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "HikariDataSource "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r5
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " has been closed."
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0027:
            r0 = r5
            com.zaxxer.hikari.pool.HikariPool r0 = r0.fastPathPool
            if (r0 == 0) goto L_0x0036
            r0 = r5
            com.zaxxer.hikari.pool.HikariPool r0 = r0.fastPathPool
            java.sql.Connection r0 = r0.getConnection()
            return r0
        L_0x0036:
            r0 = r5
            com.zaxxer.hikari.pool.HikariPool r0 = r0.pool
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L_0x009e
            r0 = r5
            r1 = r0
            r7 = r1
            monitor-enter(r0)
            r0 = r5
            com.zaxxer.hikari.pool.HikariPool r0 = r0.pool     // Catch: all -> 0x0097
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L_0x0092
            r0 = r5
            r0.validate()     // Catch: all -> 0x0097
            org.slf4j.Logger r0 = com.zaxxer.hikari.HikariDataSource.LOGGER     // Catch: all -> 0x0097
            java.lang.String r1 = "{} - Starting..."
            r2 = r5
            java.lang.String r2 = r2.getPoolName()     // Catch: all -> 0x0097
            r0.info(r1, r2)     // Catch: all -> 0x0097
            r0 = r5
            com.zaxxer.hikari.pool.HikariPool r1 = new com.zaxxer.hikari.pool.HikariPool     // Catch: PoolInitializationException -> 0x006f, all -> 0x0097
            r2 = r1
            r3 = r5
            r2.<init>(r3)     // Catch: PoolInitializationException -> 0x006f, all -> 0x0097
            r2 = r1
            r6 = r2
            r0.pool = r1     // Catch: PoolInitializationException -> 0x006f, all -> 0x0097
            goto L_0x0084
        L_0x006f:
            r8 = move-exception
            r0 = r8
            java.lang.Throwable r0 = r0.getCause()     // Catch: all -> 0x0097
            boolean r0 = r0 instanceof java.sql.SQLException     // Catch: all -> 0x0097
            if (r0 == 0) goto L_0x0082
            r0 = r8
            java.lang.Throwable r0 = r0.getCause()     // Catch: all -> 0x0097
            java.sql.SQLException r0 = (java.sql.SQLException) r0     // Catch: all -> 0x0097
            throw r0     // Catch: all -> 0x0097
        L_0x0082:
            r0 = r8
            throw r0     // Catch: all -> 0x0097
        L_0x0084:
            org.slf4j.Logger r0 = com.zaxxer.hikari.HikariDataSource.LOGGER     // Catch: all -> 0x0097
            java.lang.String r1 = "{} - Start completed."
            r2 = r5
            java.lang.String r2 = r2.getPoolName()     // Catch: all -> 0x0097
            r0.info(r1, r2)     // Catch: all -> 0x0097
        L_0x0092:
            r0 = r7
            monitor-exit(r0)     // Catch: all -> 0x0097
            goto L_0x009e
        L_0x0097:
            r9 = move-exception
            r0 = r7
            monitor-exit(r0)     // Catch: all -> 0x0097
            r0 = r9
            throw r0
        L_0x009e:
            r0 = r6
            java.sql.Connection r0 = r0.getConnection()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zaxxer.hikari.HikariDataSource.getConnection():java.sql.Connection");
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String username, String password) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        HikariPool p = this.pool;
        if (p != null) {
            return p.getUnwrappedDataSource().getLogWriter();
        }
        return null;
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter out) throws SQLException {
        HikariPool p = this.pool;
        if (p != null) {
            p.getUnwrappedDataSource().setLogWriter(out);
        }
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int seconds) throws SQLException {
        HikariPool p = this.pool;
        if (p != null) {
            p.getUnwrappedDataSource().setLoginTimeout(seconds);
        }
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        HikariPool p = this.pool;
        if (p != null) {
            return p.getUnwrappedDataSource().getLoginTimeout();
        }
        return 0;
    }

    @Override // javax.sql.CommonDataSource
    public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.zaxxer.hikari.HikariDataSource */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, javax.sql.DataSource, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.sql.Wrapper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T unwrap(java.lang.Class<T> r6) throws java.sql.SQLException {
        /*
            r5 = this;
            r0 = r6
            r1 = r5
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L_0x000a
            r0 = r5
            return r0
        L_0x000a:
            r0 = r5
            com.zaxxer.hikari.pool.HikariPool r0 = r0.pool
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L_0x002e
            r0 = r7
            javax.sql.DataSource r0 = r0.getUnwrappedDataSource()
            r8 = r0
            r0 = r6
            r1 = r8
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L_0x0022
            r0 = r8
            return r0
        L_0x0022:
            r0 = r8
            if (r0 == 0) goto L_0x002e
            r0 = r8
            r1 = r6
            java.lang.Object r0 = r0.unwrap(r1)
            return r0
        L_0x002e:
            java.sql.SQLException r0 = new java.sql.SQLException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Wrapped DataSource is not an instance of "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zaxxer.hikari.HikariDataSource.unwrap(java.lang.Class):java.lang.Object");
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        if (iface.isInstance(this)) {
            return true;
        }
        HikariPool p = this.pool;
        if (p == null) {
            return false;
        }
        DataSource unwrappedDataSource = p.getUnwrappedDataSource();
        if (iface.isInstance(unwrappedDataSource)) {
            return true;
        }
        if (unwrappedDataSource != null) {
            return unwrappedDataSource.isWrapperFor(iface);
        }
        return false;
    }

    @Override // com.zaxxer.hikari.HikariConfig
    public void setMetricRegistry(Object metricRegistry) {
        boolean isAlreadySet = getMetricRegistry() != null;
        setMetricRegistry(metricRegistry);
        HikariPool p = this.pool;
        if (p == null) {
            return;
        }
        if (isAlreadySet) {
            throw new IllegalStateException("MetricRegistry can only be set one time");
        }
        p.setMetricRegistry(getMetricRegistry());
    }

    @Override // com.zaxxer.hikari.HikariConfig
    public void setMetricsTrackerFactory(MetricsTrackerFactory metricsTrackerFactory) {
        boolean isAlreadySet = getMetricsTrackerFactory() != null;
        setMetricsTrackerFactory(metricsTrackerFactory);
        HikariPool p = this.pool;
        if (p == null) {
            return;
        }
        if (isAlreadySet) {
            throw new IllegalStateException("MetricsTrackerFactory can only be set one time");
        }
        p.setMetricsTrackerFactory(getMetricsTrackerFactory());
    }

    @Override // com.zaxxer.hikari.HikariConfig
    public void setHealthCheckRegistry(Object healthCheckRegistry) {
        boolean isAlreadySet = getHealthCheckRegistry() != null;
        setHealthCheckRegistry(healthCheckRegistry);
        HikariPool p = this.pool;
        if (p == null) {
            return;
        }
        if (isAlreadySet) {
            throw new IllegalStateException("HealthCheckRegistry can only be set one time");
        }
        p.setHealthCheckRegistry(getHealthCheckRegistry());
    }

    public HikariPoolMXBean getHikariPoolMXBean() {
        return this.pool;
    }

    public HikariConfigMXBean getHikariConfigMXBean() {
        return this;
    }

    public void evictConnection(Connection connection) {
        HikariPool p;
        if (!isClosed() && (p = this.pool) != null && connection.getClass().getName().startsWith("com.zaxxer.hikari")) {
            p.evictConnection(connection);
        }
    }

    @Deprecated
    public void suspendPool() {
        HikariPool p;
        if (!isClosed() && (p = this.pool) != null) {
            p.suspendPool();
        }
    }

    @Deprecated
    public void resumePool() {
        HikariPool p;
        if (!isClosed() && (p = this.pool) != null) {
            p.resumePool();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HikariPool p;
        if (!this.isShutdown.getAndSet(true) && (p = this.pool) != null) {
            try {
                LOGGER.info("{} - Shutdown initiated...", getPoolName());
                p.shutdown();
                LOGGER.info("{} - Shutdown completed.", getPoolName());
            } catch (InterruptedException e) {
                LOGGER.warn("{} - Interrupted during closing", getPoolName(), e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean isClosed() {
        return this.isShutdown.get();
    }

    @Deprecated
    public void shutdown() {
        LOGGER.warn("The shutdown() method has been deprecated, please use the close() method instead");
        close();
    }

    @Override // java.lang.Object
    public String toString() {
        return "HikariDataSource (" + this.pool + ")";
    }
}
