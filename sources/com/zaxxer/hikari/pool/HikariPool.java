package com.zaxxer.hikari.pool;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariPoolMXBean;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import com.zaxxer.hikari.metrics.PoolStats;
import com.zaxxer.hikari.metrics.dropwizard.CodahaleHealthChecker;
import com.zaxxer.hikari.metrics.dropwizard.CodahaleMetricsTrackerFactory;
import com.zaxxer.hikari.pool.PoolBase;
import com.zaxxer.hikari.util.ClockSource;
import com.zaxxer.hikari.util.ConcurrentBag;
import com.zaxxer.hikari.util.SuspendResumeLock;
import com.zaxxer.hikari.util.UtilityElf;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/HikariPool.class */
public class HikariPool extends PoolBase implements HikariPoolMXBean, ConcurrentBag.IBagStateListener {
    private static final ClockSource clockSource = ClockSource.INSTANCE;
    private static final int POOL_NORMAL = 0;
    private static final int POOL_SUSPENDED = 1;
    private static final int POOL_SHUTDOWN = 2;
    private volatile int poolState;
    private final Collection<Runnable> addConnectionQueue;
    private final ThreadPoolExecutor addConnectionExecutor;
    private final ThreadPoolExecutor closeConnectionExecutor;
    private ScheduledExecutorService houseKeepingExecutorService;
    private final ProxyLeakTask leakTask;
    private final SuspendResumeLock suspendResumeLock;
    private PoolBase.MetricsTrackerDelegate metricsTracker;
    private final Logger LOGGER = LoggerFactory.getLogger(HikariPool.class);
    private final long ALIVE_BYPASS_WINDOW_MS = Long.getLong("com.zaxxer.hikari.aliveBypassWindowMs", TimeUnit.MILLISECONDS.toMillis(500)).longValue();
    private final long HOUSEKEEPING_PERIOD_MS = Long.getLong("com.zaxxer.hikari.housekeeping.periodMs", TimeUnit.SECONDS.toMillis(30)).longValue();
    private final PoolEntryCreator POOL_ENTRY_CREATOR = new PoolEntryCreator(null);
    private final ConcurrentBag<PoolEntry> connectionBag = new ConcurrentBag<>(this);

    @Override // com.zaxxer.hikari.pool.PoolBase
    public /* bridge */ /* synthetic */ DataSource getUnwrappedDataSource() {
        return getUnwrappedDataSource();
    }

    @Override // com.zaxxer.hikari.pool.PoolBase
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public HikariPool(HikariConfig config) {
        super(config);
        this.suspendResumeLock = config.isAllowPoolSuspension() ? new SuspendResumeLock() : SuspendResumeLock.FAUX_LOCK;
        initializeHouseKeepingExecutorService();
        checkFailFast();
        if (config.getMetricsTrackerFactory() != null) {
            setMetricsTrackerFactory(config.getMetricsTrackerFactory());
        } else {
            setMetricRegistry(config.getMetricRegistry());
        }
        setHealthCheckRegistry(config.getHealthCheckRegistry());
        registerMBeans(this);
        ThreadFactory threadFactory = config.getThreadFactory();
        LinkedBlockingQueue<Runnable> addConnectionQueue = new LinkedBlockingQueue<>(config.getMaximumPoolSize() + 1);
        this.addConnectionQueue = Collections.unmodifiableCollection(addConnectionQueue);
        this.addConnectionExecutor = UtilityElf.createThreadPoolExecutor(addConnectionQueue, this.poolName + " connection adder", threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        this.closeConnectionExecutor = UtilityElf.createThreadPoolExecutor(config.getMaximumPoolSize(), this.poolName + " connection closer", threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
        this.leakTask = new ProxyLeakTask(config.getLeakDetectionThreshold(), this.houseKeepingExecutorService);
        this.houseKeepingExecutorService.scheduleWithFixedDelay(new HouseKeeper(), 100, this.HOUSEKEEPING_PERIOD_MS, TimeUnit.MILLISECONDS);
    }

    public final Connection getConnection() throws SQLException {
        return getConnection(this.connectionTimeout);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    public final Connection getConnection(long hardTimeout) throws SQLException {
        try {
            this.suspendResumeLock.acquire();
            long startTime = clockSource.currentTime();
            char c = hardTimeout;
            do {
                try {
                    PoolEntry poolEntry = this.connectionBag.borrow(c, TimeUnit.MILLISECONDS);
                    if (poolEntry == null) {
                        break;
                    }
                    long now = clockSource.currentTime();
                    if (poolEntry.isMarkedEvicted() || (clockSource.elapsedMillis(poolEntry.lastAccessed, now) > this.ALIVE_BYPASS_WINDOW_MS && !isConnectionAlive(poolEntry.connection))) {
                        closeConnection(poolEntry, "(connection is evicted or dead)");
                        c = hardTimeout - clockSource.elapsedMillis(startTime);
                    } else {
                        this.metricsTracker.recordBorrowStats(poolEntry, startTime);
                        Connection createProxyConnection = poolEntry.createProxyConnection(this.leakTask.schedule(poolEntry), now);
                        this.suspendResumeLock.release();
                        return createProxyConnection;
                    }
                } catch (InterruptedException e) {
                    throw new SQLException(this.poolName + " - Interrupted during connection acquisition", e);
                }
            } while (c > 0);
            throw createTimeoutException(startTime);
        } finally {
            this.suspendResumeLock.release();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x00e8
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final synchronized void shutdown() throws java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 368
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zaxxer.hikari.pool.HikariPool.shutdown():void");
    }

    public final void evictConnection(Connection connection) {
        ProxyConnection proxyConnection = (ProxyConnection) connection;
        proxyConnection.cancelLeakTask();
        try {
            softEvictConnection(proxyConnection.getPoolEntry(), "(connection evicted by user)", !connection.isClosed());
        } catch (SQLException e) {
        }
    }

    public void setMetricRegistry(Object metricRegistry) {
        if (metricRegistry != null) {
            setMetricsTrackerFactory(new CodahaleMetricsTrackerFactory((MetricRegistry) metricRegistry));
        } else {
            setMetricsTrackerFactory(null);
        }
    }

    public void setMetricsTrackerFactory(MetricsTrackerFactory metricsTrackerFactory) {
        if (metricsTrackerFactory != null) {
            this.metricsTracker = new PoolBase.MetricsTrackerDelegate(metricsTrackerFactory.create(this.config.getPoolName(), getPoolStats()));
        } else {
            this.metricsTracker = new PoolBase.NopMetricsTrackerDelegate();
        }
    }

    public void setHealthCheckRegistry(Object healthCheckRegistry) {
        if (healthCheckRegistry != null) {
            CodahaleHealthChecker.registerHealthChecks(this, this.config, (HealthCheckRegistry) healthCheckRegistry);
        }
    }

    @Override // com.zaxxer.hikari.util.ConcurrentBag.IBagStateListener
    public Future<Boolean> addBagItem(int waiting) {
        if (waiting - this.addConnectionQueue.size() >= 0) {
            return this.addConnectionExecutor.submit(this.POOL_ENTRY_CREATOR);
        }
        return CompletableFuture.completedFuture(Boolean.TRUE);
    }

    @Override // com.zaxxer.hikari.HikariPoolMXBean
    public final int getActiveConnections() {
        return this.connectionBag.getCount(1);
    }

    @Override // com.zaxxer.hikari.HikariPoolMXBean
    public final int getIdleConnections() {
        return this.connectionBag.getCount(0);
    }

    @Override // com.zaxxer.hikari.HikariPoolMXBean
    public final int getTotalConnections() {
        return this.connectionBag.size();
    }

    @Override // com.zaxxer.hikari.HikariPoolMXBean
    public final int getThreadsAwaitingConnection() {
        return this.connectionBag.getWaitingThreadCount();
    }

    @Override // com.zaxxer.hikari.HikariPoolMXBean
    public void softEvictConnections() {
        for (PoolEntry poolEntry : this.connectionBag.values()) {
            softEvictConnection(poolEntry, "(connection evicted)", false);
        }
    }

    @Override // com.zaxxer.hikari.HikariPoolMXBean
    public final synchronized void suspendPool() {
        if (this.suspendResumeLock == SuspendResumeLock.FAUX_LOCK) {
            throw new IllegalStateException(this.poolName + " - is not suspendable");
        } else if (this.poolState != 1) {
            this.suspendResumeLock.suspend();
            this.poolState = 1;
        }
    }

    @Override // com.zaxxer.hikari.HikariPoolMXBean
    public final synchronized void resumePool() {
        if (this.poolState == 1) {
            this.poolState = 0;
            fillPool();
            this.suspendResumeLock.resume();
        }
    }

    final void logPoolState(String... prefix) {
        if (this.LOGGER.isDebugEnabled()) {
            Logger logger = this.LOGGER;
            Object[] objArr = new Object[6];
            objArr[0] = this.poolName;
            objArr[1] = prefix.length > 0 ? prefix[0] : "";
            objArr[2] = Integer.valueOf(getTotalConnections());
            objArr[3] = Integer.valueOf(getActiveConnections());
            objArr[4] = Integer.valueOf(getIdleConnections());
            objArr[5] = Integer.valueOf(getThreadsAwaitingConnection());
            logger.debug("{} - {}stats (total={}, active={}, idle={}, waiting={})", objArr);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.zaxxer.hikari.pool.PoolBase
    public final void recycle(PoolEntry poolEntry) {
        this.metricsTracker.recordConnectionUsage(poolEntry);
        this.connectionBag.requite(poolEntry);
    }

    /* access modifiers changed from: package-private */
    public final void closeConnection(PoolEntry poolEntry, final String closureReason) {
        if (this.connectionBag.remove(poolEntry)) {
            final Connection connection = poolEntry.close();
            this.closeConnectionExecutor.execute(new Runnable() { // from class: com.zaxxer.hikari.pool.HikariPool.1
                @Override // java.lang.Runnable
                public void run() {
                    HikariPool.this.quietlyCloseConnection(connection, closureReason);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public PoolEntry createPoolEntry() {
        try {
            final PoolEntry poolEntry = newPoolEntry();
            long maxLifetime = this.config.getMaxLifetime();
            if (maxLifetime > 0) {
                poolEntry.setFutureEol(this.houseKeepingExecutorService.schedule(new Runnable() { // from class: com.zaxxer.hikari.pool.HikariPool.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HikariPool.this.softEvictConnection(poolEntry, "(connection has passed maxLifetime)", false);
                    }
                }, maxLifetime - (maxLifetime > AbstractComponentTracker.LINGERING_TIMEOUT ? ThreadLocalRandom.current().nextLong(maxLifetime / 40) : 0), TimeUnit.MILLISECONDS));
            }
            this.LOGGER.debug("{} - Added connection {}", this.poolName, poolEntry.connection);
            return poolEntry;
        } catch (Exception e) {
            if (this.poolState != 0) {
                return null;
            }
            this.LOGGER.debug("{} - Cannot acquire connection from data source", this.poolName, e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void fillPool() {
        int connectionsToAdd = Math.min(this.config.getMaximumPoolSize() - getTotalConnections(), this.config.getMinimumIdle() - getIdleConnections()) - this.addConnectionQueue.size();
        int i = 0;
        while (i < connectionsToAdd) {
            this.addConnectionExecutor.submit(i < connectionsToAdd - 1 ? this.POOL_ENTRY_CREATOR : new PoolEntryCreator("After adding "));
            i++;
        }
    }

    private void abortActiveConnections(ExecutorService assassinExecutor) {
        for (PoolEntry poolEntry : this.connectionBag.values(1)) {
            try {
                poolEntry.close().abort(assassinExecutor);
                this.connectionBag.remove(poolEntry);
            } catch (Throwable th) {
                this.connectionBag.remove(poolEntry);
                throw th;
            }
        }
    }

    private void checkFailFast() {
        long initializationTimeout = this.config.getInitializationFailTimeout();
        if (initializationTimeout >= 0) {
            long startTime = clockSource.currentTime();
            do {
                PoolEntry poolEntry = createPoolEntry();
                if (poolEntry == null) {
                    if (getLastConnectionFailure() instanceof PoolBase.ConnectionSetupException) {
                        throwPoolInitializationException(getLastConnectionFailure().getCause());
                    }
                    UtilityElf.quietlySleep(1000);
                } else if (this.config.getMinimumIdle() > 0) {
                    this.connectionBag.add(poolEntry);
                    this.LOGGER.debug("{} - Added connection {}", this.poolName, poolEntry.connection);
                    return;
                } else {
                    quietlyCloseConnection(poolEntry.close(), "(initialization check complete and minimumIdle is zero)");
                    return;
                }
            } while (clockSource.elapsedMillis(startTime) < initializationTimeout);
            if (initializationTimeout > 0) {
                throwPoolInitializationException(getLastConnectionFailure());
            }
        }
    }

    private void throwPoolInitializationException(Throwable t) {
        this.LOGGER.error("{} - Exception during pool initialization.", this.poolName, t);
        destroyHouseKeepingExecutorService();
        throw new PoolInitializationException(t);
    }

    /* access modifiers changed from: private */
    public void softEvictConnection(PoolEntry poolEntry, String reason, boolean owner) {
        poolEntry.markEvicted();
        if (owner || this.connectionBag.reserve(poolEntry)) {
            closeConnection(poolEntry, reason);
        }
    }

    private void initializeHouseKeepingExecutorService() {
        if (this.config.getScheduledExecutor() == null) {
            ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, this.config.getThreadFactory() != null ? this.config.getThreadFactory() : new UtilityElf.DefaultThreadFactory(this.poolName + " housekeeper", true), new ThreadPoolExecutor.DiscardPolicy());
            executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            executor.setRemoveOnCancelPolicy(true);
            this.houseKeepingExecutorService = executor;
            return;
        }
        this.houseKeepingExecutorService = this.config.getScheduledExecutor();
    }

    private void destroyHouseKeepingExecutorService() {
        if (this.config.getScheduledExecutor() == null) {
            this.houseKeepingExecutorService.shutdownNow();
        }
    }

    private PoolStats getPoolStats() {
        return new PoolStats(TimeUnit.SECONDS.toMillis(1)) { // from class: com.zaxxer.hikari.pool.HikariPool.3
            @Override // com.zaxxer.hikari.metrics.PoolStats
            protected void update() {
                this.pendingThreads = HikariPool.this.getThreadsAwaitingConnection();
                this.idleConnections = HikariPool.this.getIdleConnections();
                this.totalConnections = HikariPool.this.getTotalConnections();
                this.activeConnections = HikariPool.this.getActiveConnections();
            }
        };
    }

    private SQLException createTimeoutException(long startTime) {
        logPoolState("Timeout failure ");
        this.metricsTracker.recordConnectionTimeout();
        String sqlState = null;
        Throwable originalException = getLastConnectionFailure();
        if (originalException instanceof SQLException) {
            sqlState = ((SQLException) originalException).getSQLState();
        }
        SQLException connectionException = new SQLTransientConnectionException(this.poolName + " - Connection is not available, request timed out after " + clockSource.elapsedMillis(startTime) + "ms.", sqlState, originalException);
        if (originalException instanceof SQLException) {
            connectionException.setNextException((SQLException) originalException);
        }
        return connectionException;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/HikariPool$PoolEntryCreator.class */
    public final class PoolEntryCreator implements Callable<Boolean> {
        private final String afterPrefix;

        PoolEntryCreator(String afterPrefix) {
            this.afterPrefix = afterPrefix;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long sleepBackoff = 250;
            while (HikariPool.this.poolState == 0 && shouldCreateAnotherConnection()) {
                PoolEntry poolEntry = HikariPool.this.createPoolEntry();
                if (poolEntry != null) {
                    HikariPool.this.connectionBag.add(poolEntry);
                    HikariPool.this.LOGGER.debug("{} - Added connection {}", HikariPool.this.poolName, poolEntry.connection);
                    if (this.afterPrefix != null) {
                        HikariPool.this.logPoolState(this.afterPrefix);
                    }
                    return Boolean.TRUE;
                }
                UtilityElf.quietlySleep(sleepBackoff);
                sleepBackoff = Math.min(TimeUnit.SECONDS.toMillis(10), Math.min(HikariPool.this.connectionTimeout, (long) (((double) sleepBackoff) * 1.5d)));
            }
            return Boolean.FALSE;
        }

        private boolean shouldCreateAnotherConnection() {
            return HikariPool.this.getTotalConnections() < HikariPool.this.config.getMaximumPoolSize() && (HikariPool.this.connectionBag.getWaitingThreadCount() > 0 || HikariPool.this.getIdleConnections() < HikariPool.this.config.getMinimumIdle());
        }
    }

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/HikariPool$HouseKeeper.class */
    private class HouseKeeper implements Runnable {
        private volatile long previous;

        private HouseKeeper() {
            this.previous = HikariPool.clockSource.plusMillis(HikariPool.clockSource.currentTime(), -HikariPool.this.HOUSEKEEPING_PERIOD_MS);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HikariPool.this.connectionTimeout = HikariPool.this.config.getConnectionTimeout();
                HikariPool.this.validationTimeout = HikariPool.this.config.getValidationTimeout();
                HikariPool.this.leakTask.updateLeakDetectionThreshold(HikariPool.this.config.getLeakDetectionThreshold());
                long idleTimeout = HikariPool.this.config.getIdleTimeout();
                long now = HikariPool.clockSource.currentTime();
                if (HikariPool.clockSource.plusMillis(now, 128) < HikariPool.clockSource.plusMillis(this.previous, HikariPool.this.HOUSEKEEPING_PERIOD_MS)) {
                    HikariPool.this.LOGGER.warn("{} - Retrograde clock change detected (housekeeper delta={}), soft-evicting connections from pool.", HikariPool.this.poolName, HikariPool.clockSource.elapsedDisplayString(this.previous, now));
                    this.previous = now;
                    HikariPool.this.softEvictConnections();
                    HikariPool.this.fillPool();
                    return;
                }
                if (now > HikariPool.clockSource.plusMillis(this.previous, (3 * HikariPool.this.HOUSEKEEPING_PERIOD_MS) / 2)) {
                    HikariPool.this.LOGGER.warn("{} - Thread starvation or clock leap detected (housekeeper delta={}).", HikariPool.this.poolName, HikariPool.clockSource.elapsedDisplayString(this.previous, now));
                }
                this.previous = now;
                String afterPrefix = "Pool ";
                if (idleTimeout > 0) {
                    List<PoolEntry> idleList = HikariPool.this.connectionBag.values(0);
                    int removable = idleList.size() - HikariPool.this.config.getMinimumIdle();
                    if (removable > 0) {
                        HikariPool.this.logPoolState("Before cleanup ");
                        afterPrefix = "After cleanup  ";
                        Collections.sort(idleList, PoolEntry.LASTACCESS_COMPARABLE);
                        for (PoolEntry poolEntry : idleList) {
                            if (HikariPool.clockSource.elapsedMillis(poolEntry.lastAccessed, now) > idleTimeout && HikariPool.this.connectionBag.reserve(poolEntry)) {
                                HikariPool.this.closeConnection(poolEntry, "(connection has passed idleTimeout)");
                                removable--;
                                if (removable == 0) {
                                    break;
                                }
                            }
                        }
                    }
                }
                HikariPool.this.logPoolState(afterPrefix);
                HikariPool.this.fillPool();
            } catch (Exception e) {
                HikariPool.this.LOGGER.error("Unexpected exception in housekeeping task", (Throwable) e);
            }
        }
    }

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/HikariPool$PoolInitializationException.class */
    public static class PoolInitializationException extends RuntimeException {
        private static final long serialVersionUID = 929872118275916520L;

        public PoolInitializationException(Throwable t) {
            super("Failed to initialize pool: " + t.getMessage(), t);
        }
    }

    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/HikariPool$CompletableFuture.class */
    public static class CompletableFuture<T> implements Future<T> {
        private T result;

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: U */
        /* JADX WARN: Multi-variable type inference failed */
        public static <U> Future<U> completedFuture(U value) {
            CompletableFuture<U> f = new CompletableFuture<>();
            ((CompletableFuture) f).result = value;
            return f;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.result;
        }

        @Override // java.util.concurrent.Future
        public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.result;
        }
    }
}
