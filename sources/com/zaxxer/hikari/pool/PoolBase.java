package com.zaxxer.hikari.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.metrics.MetricsTracker;
import com.zaxxer.hikari.util.ClockSource;
import com.zaxxer.hikari.util.DriverDataSource;
import com.zaxxer.hikari.util.PropertyElf;
import com.zaxxer.hikari.util.UtilityElf;
import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/PoolBase.class */
public abstract class PoolBase {
    protected final HikariConfig config;
    protected final String poolName;
    protected long connectionTimeout;
    protected long validationTimeout;
    private static final String[] RESET_STATES = {"readOnly", "autoCommit", "isolation", "catalog", "netTimeout"};
    private static final int UNINITIALIZED = -1;
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private int defaultTransactionIsolation;
    private int transactionIsolation;
    private Executor netTimeoutExecutor;
    private DataSource dataSource;
    private final String catalog;
    private final boolean isReadOnly;
    private final boolean isAutoCommit;
    private final boolean isUseJdbc4Validation;
    private final boolean isIsolateInternalQueries;
    private final AtomicReference<Throwable> lastConnectionFailure;
    private volatile boolean isValidChecked;
    private final Logger LOGGER = LoggerFactory.getLogger(PoolBase.class);
    private int networkTimeout = -1;
    private int isQueryTimeoutSupported = -1;
    private int isNetworkTimeoutSupported = -1;

    abstract void recycle(PoolEntry poolEntry);

    /* access modifiers changed from: package-private */
    public PoolBase(HikariConfig config) {
        this.config = config;
        this.catalog = config.getCatalog();
        this.isReadOnly = config.isReadOnly();
        this.isAutoCommit = config.isAutoCommit();
        this.transactionIsolation = UtilityElf.getTransactionIsolation(config.getTransactionIsolation());
        this.isUseJdbc4Validation = config.getConnectionTestQuery() == null;
        this.isIsolateInternalQueries = config.isIsolateInternalQueries();
        this.poolName = config.getPoolName();
        this.connectionTimeout = config.getConnectionTimeout();
        this.validationTimeout = config.getValidationTimeout();
        this.lastConnectionFailure = new AtomicReference<>();
        initializeDataSource();
    }

    public String toString() {
        return this.poolName;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0039
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    void quietlyCloseConnection(java.sql.Connection r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = r8
            if (r0 == 0) goto L_0x0064
            r0 = r7
            org.slf4j.Logger r0 = r0.LOGGER     // Catch: Throwable -> 0x0045
            java.lang.String r1 = "{} - Closing connection {}: {}"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Throwable -> 0x0045
            r3 = r2
            r4 = 0
            r5 = r7
            java.lang.String r5 = r5.poolName     // Catch: Throwable -> 0x0045
            r3[r4] = r5     // Catch: Throwable -> 0x0045
            r3 = r2
            r4 = 1
            r5 = r8
            r3[r4] = r5     // Catch: Throwable -> 0x0045
            r3 = r2
            r4 = 2
            r5 = r9
            r3[r4] = r5     // Catch: Throwable -> 0x0045
            r0.debug(r1, r2)     // Catch: Throwable -> 0x0045
            r0 = r7
            r1 = r8
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch: Throwable -> 0x0045, all -> 0x0039
            r3 = 15
            long r2 = r2.toMillis(r3)     // Catch: Throwable -> 0x0045, all -> 0x0039
            r0.setNetworkTimeout(r1, r2)     // Catch: Throwable -> 0x0045, all -> 0x0039
            r0 = r8
            r0.close()     // Catch: Throwable -> 0x0045
            goto L_0x0042
        L_0x0039:
            r10 = move-exception
            r0 = r8
            r0.close()     // Catch: Throwable -> 0x0045
            r0 = r10
            throw r0     // Catch: Throwable -> 0x0045
        L_0x0042:
            goto L_0x0064
        L_0x0045:
            r10 = move-exception
            r0 = r7
            org.slf4j.Logger r0 = r0.LOGGER
            java.lang.String r1 = "{} - Closing connection {} failed"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            java.lang.String r5 = r5.poolName
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r8
            r3[r4] = r5
            r3 = r2
            r4 = 2
            r5 = r10
            r3[r4] = r5
            r0.debug(r1, r2)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zaxxer.hikari.pool.PoolBase.quietlyCloseConnection(java.sql.Connection, java.lang.String):void");
    }

    /* JADX INFO: finally extract failed */
    boolean isConnectionAlive(Connection connection) {
        try {
            if (this.isUseJdbc4Validation) {
                boolean isValid = connection.isValid((int) TimeUnit.MILLISECONDS.toSeconds(Math.max(1000L, this.validationTimeout)));
                if (this.isIsolateInternalQueries && !this.isAutoCommit) {
                    connection.rollback();
                }
                return isValid;
            }
            setNetworkTimeout(connection, this.validationTimeout);
            Statement statement = connection.createStatement();
            Throwable th = null;
            try {
                try {
                    if (this.isNetworkTimeoutSupported != 1) {
                        setQueryTimeout(statement, (int) TimeUnit.MILLISECONDS.toSeconds(Math.max(1000L, this.validationTimeout)));
                    }
                    statement.execute(this.config.getConnectionTestQuery());
                    if (statement != null) {
                        if (0 != 0) {
                            try {
                                statement.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            statement.close();
                        }
                    }
                    if (this.isIsolateInternalQueries && !this.isAutoCommit) {
                        connection.rollback();
                    }
                    setNetworkTimeout(connection, (long) this.networkTimeout);
                    return true;
                } finally {
                }
            } catch (Throwable th3) {
                if (statement != null) {
                    if (th != null) {
                        try {
                            statement.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        statement.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException e) {
            this.lastConnectionFailure.set(e);
            this.LOGGER.warn("{} - Failed to validate connection {} ({})", this.poolName, connection, e.getMessage());
            return false;
        }
    }

    Throwable getLastConnectionFailure() {
        return this.lastConnectionFailure.get();
    }

    public DataSource getUnwrappedDataSource() {
        return this.dataSource;
    }

    PoolEntry newPoolEntry() throws Exception {
        return new PoolEntry(newConnection(), this, this.isReadOnly, this.isAutoCommit);
    }

    void resetConnectionState(Connection connection, ProxyConnection proxyConnection, int dirtyBits) throws SQLException {
        int resetBits = 0;
        if (!((dirtyBits & 1) == 0 || proxyConnection.getReadOnlyState() == this.isReadOnly)) {
            connection.setReadOnly(this.isReadOnly);
            resetBits = 0 | 1;
        }
        if (!((dirtyBits & 2) == 0 || proxyConnection.getAutoCommitState() == this.isAutoCommit)) {
            connection.setAutoCommit(this.isAutoCommit);
            resetBits |= 2;
        }
        if (!((dirtyBits & 4) == 0 || proxyConnection.getTransactionIsolationState() == this.transactionIsolation)) {
            connection.setTransactionIsolation(this.transactionIsolation);
            resetBits |= 4;
        }
        if (!((dirtyBits & 8) == 0 || this.catalog == null || this.catalog.equals(proxyConnection.getCatalogState()))) {
            connection.setCatalog(this.catalog);
            resetBits |= 8;
        }
        if (!((dirtyBits & 16) == 0 || proxyConnection.getNetworkTimeoutState() == this.networkTimeout)) {
            setNetworkTimeout(connection, (long) this.networkTimeout);
            resetBits |= 16;
        }
        if (resetBits != 0 && this.LOGGER.isDebugEnabled()) {
            this.LOGGER.debug("{} - Reset ({}) on connection {}", this.poolName, stringFromResetBits(resetBits), connection);
        }
    }

    void shutdownNetworkTimeoutExecutor() {
        if (this.netTimeoutExecutor instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) this.netTimeoutExecutor).shutdownNow();
        }
    }

    void registerMBeans(HikariPool hikariPool) {
        if (this.config.isRegisterMbeans()) {
            try {
                MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
                ObjectName beanConfigName = new ObjectName("com.zaxxer.hikari:type=PoolConfig (" + this.poolName + ")");
                ObjectName beanPoolName = new ObjectName("com.zaxxer.hikari:type=Pool (" + this.poolName + ")");
                if (!mBeanServer.isRegistered(beanConfigName)) {
                    mBeanServer.registerMBean(this.config, beanConfigName);
                    mBeanServer.registerMBean(hikariPool, beanPoolName);
                } else {
                    this.LOGGER.error("{} - JMX name ({}) is already registered.", this.poolName, this.poolName);
                }
            } catch (Exception e) {
                this.LOGGER.warn("{} - Failed to register management beans.", this.poolName, e);
            }
        }
    }

    void unregisterMBeans() {
        if (this.config.isRegisterMbeans()) {
            try {
                MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
                ObjectName beanConfigName = new ObjectName("com.zaxxer.hikari:type=PoolConfig (" + this.poolName + ")");
                ObjectName beanPoolName = new ObjectName("com.zaxxer.hikari:type=Pool (" + this.poolName + ")");
                if (mBeanServer.isRegistered(beanConfigName)) {
                    mBeanServer.unregisterMBean(beanConfigName);
                    mBeanServer.unregisterMBean(beanPoolName);
                }
            } catch (Exception e) {
                this.LOGGER.warn("{} - Failed to unregister management beans.", this.poolName, e);
            }
        }
    }

    private void initializeDataSource() {
        String jdbcUrl = this.config.getJdbcUrl();
        String username = this.config.getUsername();
        String password = this.config.getPassword();
        String dsClassName = this.config.getDataSourceClassName();
        String driverClassName = this.config.getDriverClassName();
        Properties dataSourceProperties = this.config.getDataSourceProperties();
        DataSource dataSource = this.config.getDataSource();
        if (dsClassName != null && dataSource == null) {
            dataSource = (DataSource) UtilityElf.createInstance(dsClassName, DataSource.class, new Object[0]);
            PropertyElf.setTargetFromProperties(dataSource, dataSourceProperties);
        } else if (jdbcUrl != null && dataSource == null) {
            dataSource = new DriverDataSource(jdbcUrl, driverClassName, dataSourceProperties, username, password);
        }
        if (dataSource != null) {
            setLoginTimeout(dataSource);
            createNetworkTimeoutExecutor(dataSource, dsClassName, jdbcUrl);
        }
        this.dataSource = dataSource;
    }

    Connection newConnection() throws Exception {
        try {
            String username = this.config.getUsername();
            Connection connection = username == null ? this.dataSource.getConnection() : this.dataSource.getConnection(username, this.config.getPassword());
            if (connection == null) {
                throw new SQLTransientConnectionException("DataSource returned null unexpectedly");
            }
            setupConnection(connection);
            this.lastConnectionFailure.set(null);
            return connection;
        } catch (Exception e) {
            if (0 != 0) {
                quietlyCloseConnection(null, "(Failed to create/setup connection)");
            } else if (getLastConnectionFailure() == null) {
                this.LOGGER.debug("{} - Failed to create/setup connection: {}", this.poolName, e.getMessage());
            }
            this.lastConnectionFailure.set(e);
            throw e;
        }
    }

    private void setupConnection(Connection connection) throws ConnectionSetupException {
        try {
            if (this.networkTimeout == -1) {
                this.networkTimeout = getAndSetNetworkTimeout(connection, this.validationTimeout);
            } else {
                setNetworkTimeout(connection, this.validationTimeout);
            }
            connection.setReadOnly(this.isReadOnly);
            connection.setAutoCommit(this.isAutoCommit);
            checkDriverSupport(connection);
            if (this.transactionIsolation != this.defaultTransactionIsolation) {
                connection.setTransactionIsolation(this.transactionIsolation);
            }
            if (this.catalog != null) {
                connection.setCatalog(this.catalog);
            }
            executeSql(connection, this.config.getConnectionInitSql(), true);
            setNetworkTimeout(connection, (long) this.networkTimeout);
        } catch (SQLException e) {
            throw new ConnectionSetupException(e);
        }
    }

    private void checkDriverSupport(Connection connection) throws SQLException {
        if (!this.isValidChecked) {
            try {
                if (this.isUseJdbc4Validation) {
                    connection.isValid(1);
                } else {
                    executeSql(connection, this.config.getConnectionTestQuery(), false);
                }
                try {
                    this.defaultTransactionIsolation = connection.getTransactionIsolation();
                    if (this.transactionIsolation == -1) {
                        this.transactionIsolation = this.defaultTransactionIsolation;
                    }
                } catch (SQLException e) {
                    this.LOGGER.warn("{} - Default transaction isolation level detection failed. ({})", this.poolName, e.getMessage());
                } finally {
                    this.isValidChecked = true;
                }
            } catch (Throwable e2) {
                this.LOGGER.error("{} - Failed to execute" + (this.isUseJdbc4Validation ? " isValid() for connection, configure" : "") + " connection test query. ({})", this.poolName, e2.getMessage());
                throw e2;
            }
        }
    }

    private void setQueryTimeout(Statement statement, int timeoutSec) {
        if (this.isQueryTimeoutSupported != 0) {
            try {
                statement.setQueryTimeout(timeoutSec);
                this.isQueryTimeoutSupported = 1;
            } catch (Throwable e) {
                if (this.isQueryTimeoutSupported == -1) {
                    this.isQueryTimeoutSupported = 0;
                    this.LOGGER.info("{} - Failed to set query timeout for statement. ({})", this.poolName, e.getMessage());
                }
            }
        }
    }

    private int getAndSetNetworkTimeout(Connection connection, long timeoutMs) {
        if (this.isNetworkTimeoutSupported == 0) {
            return 0;
        }
        try {
            int originalTimeout = connection.getNetworkTimeout();
            connection.setNetworkTimeout(this.netTimeoutExecutor, (int) timeoutMs);
            this.isNetworkTimeoutSupported = 1;
            return originalTimeout;
        } catch (Throwable e) {
            if (this.isNetworkTimeoutSupported != -1) {
                return 0;
            }
            this.isNetworkTimeoutSupported = 0;
            this.LOGGER.info("{} - Driver does not support get/set network timeout for connections. ({})", this.poolName, e.getMessage());
            if (this.validationTimeout < TimeUnit.SECONDS.toMillis(1)) {
                this.LOGGER.warn("{} - A validationTimeout of less than 1 second cannot be honored on drivers without setNetworkTimeout() support.", this.poolName);
                return 0;
            } else if (this.validationTimeout % TimeUnit.SECONDS.toMillis(1) == 0) {
                return 0;
            } else {
                this.LOGGER.warn("{} - A validationTimeout with fractional second granularity cannot be honored on drivers without setNetworkTimeout() support.", this.poolName);
                return 0;
            }
        }
    }

    private void setNetworkTimeout(Connection connection, long timeoutMs) throws SQLException {
        if (this.isNetworkTimeoutSupported == 1) {
            connection.setNetworkTimeout(this.netTimeoutExecutor, (int) timeoutMs);
        }
    }

    private void executeSql(Connection connection, String sql, boolean isCommit) throws SQLException {
        if (sql != null) {
            Statement statement = connection.createStatement();
            Throwable th = null;
            try {
                statement.execute(sql);
                if (statement != null) {
                    if (0 != 0) {
                        try {
                            statement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        statement.close();
                    }
                }
                if (this.isIsolateInternalQueries && !this.isAutoCommit) {
                    if (isCommit) {
                        connection.commit();
                    } else {
                        connection.rollback();
                    }
                }
            } catch (Throwable th3) {
                if (statement != null) {
                    if (0 != 0) {
                        try {
                            statement.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        statement.close();
                    }
                }
                throw th3;
            }
        }
    }

    private void createNetworkTimeoutExecutor(DataSource dataSource, String dsClassName, String jdbcUrl) {
        if ((dsClassName == null || !dsClassName.contains("Mysql")) && ((jdbcUrl == null || !jdbcUrl.contains("mysql")) && (dataSource == null || !dataSource.getClass().getName().contains("Mysql")))) {
            ThreadFactory threadFactory = this.config.getThreadFactory();
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool(threadFactory != null ? threadFactory : new UtilityElf.DefaultThreadFactory(this.poolName + " network timeout executor", true));
            executor.setKeepAliveTime(15, TimeUnit.SECONDS);
            executor.allowCoreThreadTimeOut(true);
            this.netTimeoutExecutor = executor;
            return;
        }
        this.netTimeoutExecutor = new SynchronousExecutor();
    }

    private void setLoginTimeout(DataSource dataSource) {
        if (this.connectionTimeout != 2147483647L) {
            try {
                dataSource.setLoginTimeout(Math.max(1, (int) TimeUnit.MILLISECONDS.toSeconds(500 + this.connectionTimeout)));
            } catch (Throwable e) {
                this.LOGGER.info("{} - Failed to set login timeout for data source. ({})", this.poolName, e.getMessage());
            }
        }
    }

    private String stringFromResetBits(int bits) {
        StringBuilder sb = new StringBuilder();
        for (int ndx = 0; ndx < RESET_STATES.length; ndx++) {
            if ((bits & (1 << ndx)) != 0) {
                sb.append(RESET_STATES[ndx]).append(", ");
            }
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/PoolBase$ConnectionSetupException.class */
    public static class ConnectionSetupException extends Exception {
        private static final long serialVersionUID = 929872118275916521L;

        public ConnectionSetupException(Throwable t) {
            super(t);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/PoolBase$SynchronousExecutor.class */
    public static class SynchronousExecutor implements Executor {
        private SynchronousExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            try {
                command.run();
            } catch (Throwable t) {
                LoggerFactory.getLogger(PoolBase.class).debug("Failed to execute: {}", command, t);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/PoolBase$MetricsTrackerDelegate.class */
    public static class MetricsTrackerDelegate implements AutoCloseable {
        final MetricsTracker tracker;

        protected MetricsTrackerDelegate() {
            this.tracker = null;
        }

        /* access modifiers changed from: package-private */
        public MetricsTrackerDelegate(MetricsTracker tracker) {
            this.tracker = tracker;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            this.tracker.close();
        }

        /* access modifiers changed from: package-private */
        public void recordConnectionUsage(PoolEntry poolEntry) {
            this.tracker.recordConnectionUsageMillis(poolEntry.getMillisSinceBorrowed());
        }

        /* access modifiers changed from: package-private */
        public void recordBorrowStats(PoolEntry poolEntry, long startTime) {
            long now = ClockSource.INSTANCE.currentTime();
            poolEntry.lastBorrowed = now;
            this.tracker.recordConnectionAcquiredNanos(ClockSource.INSTANCE.elapsedNanos(startTime, now));
        }

        /* access modifiers changed from: package-private */
        public void recordConnectionTimeout() {
            this.tracker.recordConnectionTimeout();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/PoolBase$NopMetricsTrackerDelegate.class */
    public static final class NopMetricsTrackerDelegate extends MetricsTrackerDelegate {
        /* access modifiers changed from: package-private */
        @Override // com.zaxxer.hikari.pool.PoolBase.MetricsTrackerDelegate
        public void recordConnectionUsage(PoolEntry poolEntry) {
        }

        @Override // com.zaxxer.hikari.pool.PoolBase.MetricsTrackerDelegate, java.lang.AutoCloseable
        public void close() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.zaxxer.hikari.pool.PoolBase.MetricsTrackerDelegate
        public void recordBorrowStats(PoolEntry poolEntry, long startTime) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.zaxxer.hikari.pool.PoolBase.MetricsTrackerDelegate
        public void recordConnectionTimeout() {
        }
    }
}
