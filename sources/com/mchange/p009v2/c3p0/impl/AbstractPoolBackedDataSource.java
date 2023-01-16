package com.mchange.p009v2.c3p0.impl;

import com.mchange.lang.ThrowableUtils;
import com.mchange.p009v2.c3p0.C3P0Registry;
import com.mchange.p009v2.c3p0.PooledDataSource;
import com.mchange.p009v2.c3p0.cfg.C3P0Config;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import javax.sql.ConnectionPoolDataSource;

/* renamed from: com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/AbstractPoolBackedDataSource.class */
public abstract class AbstractPoolBackedDataSource extends PoolBackedDataSourceBase implements PooledDataSource {
    static final MLogger logger = MLog.getLogger(AbstractPoolBackedDataSource.class);
    static final String NO_CPDS_ERR_MSG = "Attempted to use an uninitialized PoolBackedDataSource. Please call setConnectionPoolDataSource( ... ) to initialize.";
    transient C3P0PooledConnectionPoolManager poolManager;
    transient boolean is_closed = false;
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public abstract String toString(boolean z);

    /* access modifiers changed from: protected */
    public AbstractPoolBackedDataSource(boolean autoregister) {
        super(autoregister);
        setUpPropertyEvents();
    }

    private void setUpPropertyEvents() {
        addPropertyChangeListener(new PropertyChangeListener() { // from class: com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                AbstractPoolBackedDataSource.this.resetPoolManager(false);
            }
        });
    }

    protected void initializeNamedConfig(String configName, boolean shouldBindUserOverridesAsString) {
        if (configName != null) {
            try {
                C3P0Config.bindNamedConfigToBean(this, configName, shouldBindUserOverridesAsString);
                if (getDataSourceName().equals(getIdentityToken())) {
                    setDataSourceName(configName);
                }
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Error binding PoolBackedDataSource to named-config '" + configName + "'. Some default-config values may be used.", (Throwable) e);
                }
            }
        }
    }

    @Override // com.mchange.p009v2.c3p0.impl.PoolBackedDataSourceBase, com.mchange.p009v2.c3p0.PooledDataSource
    public String getDataSourceName() {
        String out = getDataSourceName();
        if (out == null) {
            out = getIdentityToken();
        }
        return out;
    }

    @Override // javax.sql.DataSource
    public Connection getConnection() throws SQLException {
        return getPoolManager().getPool().checkoutPooledConnection().getConnection();
    }

    @Override // javax.sql.DataSource
    public Connection getConnection(String username, String password) throws SQLException {
        return getPoolManager().getPool(username, password).checkoutPooledConnection().getConnection();
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        return assertCpds().getLogWriter();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter out) throws SQLException {
        assertCpds().setLogWriter(out);
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        return assertCpds().getLoginTimeout();
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int seconds) throws SQLException {
        assertCpds().setLoginTimeout(seconds);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumConnections() throws SQLException {
        return getPoolManager().getPool().getNumConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumIdleConnections() throws SQLException {
        return getPoolManager().getPool().getNumIdleConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumBusyConnections() throws SQLException {
        return getPoolManager().getPool().getNumBusyConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumUnclosedOrphanedConnections() throws SQLException {
        return getPoolManager().getPool().getNumUnclosedOrphanedConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumConnectionsDefaultUser() throws SQLException {
        return getNumConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumIdleConnectionsDefaultUser() throws SQLException {
        return getNumIdleConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumBusyConnectionsDefaultUser() throws SQLException {
        return getNumBusyConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumUnclosedOrphanedConnectionsDefaultUser() throws SQLException {
        return getNumUnclosedOrphanedConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumStatementsDefaultUser() throws SQLException {
        return getPoolManager().getPool().getStatementCacheNumStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumCheckedOutDefaultUser() throws SQLException {
        return getPoolManager().getPool().getStatementCacheNumCheckedOut();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumConnectionsWithCachedStatementsDefaultUser() throws SQLException {
        return getPoolManager().getPool().getStatementCacheNumConnectionsWithCachedStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public float getEffectivePropertyCycleDefaultUser() throws SQLException {
        return getPoolManager().getPool().getEffectivePropertyCycle();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public long getStartTimeMillisDefaultUser() throws SQLException {
        return getPoolManager().getPool().getStartTime();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public long getUpTimeMillisDefaultUser() throws SQLException {
        return getPoolManager().getPool().getUpTime();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public long getNumFailedCheckinsDefaultUser() throws SQLException {
        return getPoolManager().getPool().getNumFailedCheckins();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public long getNumFailedCheckoutsDefaultUser() throws SQLException {
        return getPoolManager().getPool().getNumFailedCheckouts();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public long getNumFailedIdleTestsDefaultUser() throws SQLException {
        return getPoolManager().getPool().getNumFailedIdleTests();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumThreadsAwaitingCheckoutDefaultUser() throws SQLException {
        return getPoolManager().getPool().getNumThreadsAwaitingCheckout();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getThreadPoolSize() throws SQLException {
        return getPoolManager().getThreadPoolSize();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getThreadPoolNumActiveThreads() throws SQLException {
        return getPoolManager().getThreadPoolNumActiveThreads();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getThreadPoolNumIdleThreads() throws SQLException {
        return getPoolManager().getThreadPoolNumIdleThreads();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getThreadPoolNumTasksPending() throws SQLException {
        return getPoolManager().getThreadPoolNumTasksPending();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleThreadPoolStackTraces() throws SQLException {
        return getPoolManager().getThreadPoolStackTraces();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleThreadPoolStatus() throws SQLException {
        return getPoolManager().getThreadPoolStatus();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleStatementCacheStatusDefaultUser() throws SQLException {
        return getPoolManager().getPool().dumpStatementCacheStatus();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleStatementCacheStatus(String username, String password) throws SQLException {
        return assertAuthPool(username, password).dumpStatementCacheStatus();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastAcquisitionFailureDefaultUser() throws SQLException {
        return getPoolManager().getPool().getLastAcquisitionFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastCheckinFailureDefaultUser() throws SQLException {
        return getPoolManager().getPool().getLastCheckinFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastCheckoutFailureDefaultUser() throws SQLException {
        return getPoolManager().getPool().getLastCheckoutFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastIdleTestFailureDefaultUser() throws SQLException {
        return getPoolManager().getPool().getLastIdleTestFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastConnectionTestFailureDefaultUser() throws SQLException {
        return getPoolManager().getPool().getLastConnectionTestFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastAcquisitionFailure(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getLastAcquisitionFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastCheckinFailure(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getLastCheckinFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastCheckoutFailure(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getLastCheckoutFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastIdleTestFailure(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getLastIdleTestFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Throwable getLastConnectionTestFailure(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getLastConnectionTestFailure();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumThreadsAwaitingCheckout(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumThreadsAwaitingCheckout();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastAcquisitionFailureStackTraceDefaultUser() throws SQLException {
        Throwable t = getLastAcquisitionFailureDefaultUser();
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastCheckinFailureStackTraceDefaultUser() throws SQLException {
        Throwable t = getLastCheckinFailureDefaultUser();
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastCheckoutFailureStackTraceDefaultUser() throws SQLException {
        Throwable t = getLastCheckoutFailureDefaultUser();
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastIdleTestFailureStackTraceDefaultUser() throws SQLException {
        Throwable t = getLastIdleTestFailureDefaultUser();
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastConnectionTestFailureStackTraceDefaultUser() throws SQLException {
        Throwable t = getLastConnectionTestFailureDefaultUser();
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastAcquisitionFailureStackTrace(String username, String password) throws SQLException {
        Throwable t = getLastAcquisitionFailure(username, password);
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastCheckinFailureStackTrace(String username, String password) throws SQLException {
        Throwable t = getLastCheckinFailure(username, password);
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastCheckoutFailureStackTrace(String username, String password) throws SQLException {
        Throwable t = getLastCheckoutFailure(username, password);
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastIdleTestFailureStackTrace(String username, String password) throws SQLException {
        Throwable t = getLastIdleTestFailure(username, password);
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleLastConnectionTestFailureStackTrace(String username, String password) throws SQLException {
        Throwable t = getLastConnectionTestFailure(username, password);
        if (t == null) {
            return null;
        }
        return ThrowableUtils.extractStackTrace(t);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public void softResetDefaultUser() throws SQLException {
        getPoolManager().getPool().reset();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumConnections(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumIdleConnections(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumIdleConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumBusyConnections(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumBusyConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumUnclosedOrphanedConnections(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumUnclosedOrphanedConnections();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumStatements(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getStatementCacheNumStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumCheckedOut(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getStatementCacheNumCheckedOut();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumConnectionsWithCachedStatements(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getStatementCacheNumConnectionsWithCachedStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public float getEffectivePropertyCycle(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getEffectivePropertyCycle();
    }

    public long getStartTimeMillis(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getStartTime();
    }

    public long getUpTimeMillis(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getUpTime();
    }

    public long getNumFailedCheckins(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumFailedCheckins();
    }

    public long getNumFailedCheckouts(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumFailedCheckouts();
    }

    public long getNumFailedIdleTests(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getNumFailedIdleTests();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public void softReset(String username, String password) throws SQLException {
        assertAuthPool(username, password).reset();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumBusyConnectionsAllUsers() throws SQLException {
        return getPoolManager().getNumBusyConnectionsAllAuths();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumIdleConnectionsAllUsers() throws SQLException {
        return getPoolManager().getNumIdleConnectionsAllAuths();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumConnectionsAllUsers() throws SQLException {
        return getPoolManager().getNumConnectionsAllAuths();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumUnclosedOrphanedConnectionsAllUsers() throws SQLException {
        return getPoolManager().getNumUnclosedOrphanedConnectionsAllAuths();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumStatementsAllUsers() throws SQLException {
        return getPoolManager().getStatementCacheNumStatementsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumCheckedOutStatementsAllUsers() throws SQLException {
        return getPoolManager().getStatementCacheNumCheckedOutStatementsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementCacheNumConnectionsWithCachedStatementsAllUsers() throws SQLException {
        return getPoolManager().getStatementCacheNumConnectionsWithCachedStatementsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumConnectionsInUseAllUsers() throws SQLException {
        return getPoolManager().getStatementDestroyerNumConnectionsInUseAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    /* renamed from: getStatementDestroyerNumConnectionsWithDeferredDestroyStatementsAllUsers */
    public int mo1285x7f0e7943() throws SQLException {
        return getPoolManager().m1283x7f0e7943();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumDeferredDestroyStatementsAllUsers() throws SQLException {
        return getPoolManager().getStatementDestroyerNumDeferredDestroyStatementsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumConnectionsInUseDefaultUser() throws SQLException {
        return getPoolManager().getPool().getStatementDestroyerNumConnectionsInUse();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    /* renamed from: getStatementDestroyerNumConnectionsWithDeferredDestroyStatementsDefaultUser */
    public int mo1284xa0bf87d0() throws SQLException {
        return getPoolManager().getPool().getStatementDestroyerNumConnectionsWithDeferredDestroyStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumDeferredDestroyStatementsDefaultUser() throws SQLException {
        return getPoolManager().getPool().getStatementDestroyerNumDeferredDestroyStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumThreads() throws SQLException {
        return getPoolManager().getStatementDestroyerNumThreads();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumActiveThreads() throws SQLException {
        return getPoolManager().getStatementDestroyerNumActiveThreads();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumIdleThreads() throws SQLException {
        return getPoolManager().getStatementDestroyerNumIdleThreads();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumTasksPending() throws SQLException {
        return getPoolManager().getStatementDestroyerNumTasksPending();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumConnectionsInUse(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getStatementDestroyerNumConnectionsInUse();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumConnectionsWithDeferredDestroyStatements(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getStatementDestroyerNumConnectionsWithDeferredDestroyStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getStatementDestroyerNumDeferredDestroyStatements(String username, String password) throws SQLException {
        return assertAuthPool(username, password).getStatementDestroyerNumDeferredDestroyStatements();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleStatementDestroyerStackTraces() throws SQLException {
        return getPoolManager().getStatementDestroyerStackTraces();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public String sampleStatementDestroyerStatus() throws SQLException {
        return getPoolManager().getStatementDestroyerStatus();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public void softResetAllUsers() throws SQLException {
        getPoolManager().softResetAllAuths();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public int getNumUserPools() throws SQLException {
        return getPoolManager().getNumManagedAuths();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public Collection getAllUsers() throws SQLException {
        LinkedList out = new LinkedList();
        for (DbAuth dbAuth : getPoolManager().getManagedAuths()) {
            out.add(dbAuth.getUser());
        }
        return Collections.unmodifiableList(out);
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public synchronized void hardReset() {
        resetPoolManager();
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public void close() {
        synchronized (this) {
            resetPoolManager();
            this.is_closed = true;
        }
        C3P0Registry.markClosed(this);
        if (logger.isLoggable(MLevel.FINEST)) {
            logger.log(MLevel.FINEST, getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " has been closed. ", (Throwable) new Exception("DEBUG STACK TRACE for PoolBackedDataSource.close()."));
        }
    }

    @Override // com.mchange.p009v2.c3p0.PooledDataSource
    public void close(boolean force_destroy) {
        close();
    }

    public synchronized void resetPoolManager() {
        resetPoolManager(true);
    }

    public synchronized void resetPoolManager(boolean close_checked_out_connections) {
        if (this.poolManager != null) {
            this.poolManager.close(close_checked_out_connections);
            this.poolManager = null;
        }
    }

    private synchronized ConnectionPoolDataSource assertCpds() throws SQLException {
        if (this.is_closed) {
            throw new SQLException(this + " has been closed() -- you can no longer use it.");
        }
        ConnectionPoolDataSource out = getConnectionPoolDataSource();
        if (out != null) {
            return out;
        }
        throw new SQLException(NO_CPDS_ERR_MSG);
    }

    private synchronized C3P0PooledConnectionPoolManager getPoolManager() throws SQLException {
        if (this.poolManager == null) {
            this.poolManager = new C3P0PooledConnectionPoolManager(assertCpds(), null, null, getNumHelperThreads(), getIdentityToken(), getDataSourceName());
            if (logger.isLoggable(MLevel.INFO)) {
                logger.info("Initializing c3p0 pool... " + toString(true));
            }
        }
        return this.poolManager;
    }

    private C3P0PooledConnectionPool assertAuthPool(String username, String password) throws SQLException {
        C3P0PooledConnectionPool authPool = getPoolManager().getPool(username, password, false);
        if (authPool != null) {
            return authPool;
        }
        throw new SQLException("No pool has been yet been established for Connections authenticated by user '" + username + "' with the password provided. [Use getConnection( username, password ) to initialize such a pool.]");
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeShort(1);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        short version = ois.readShort();
        switch (version) {
            case 1:
                setUpPropertyEvents();
                return;
            default:
                throw new IOException("Unsupported Serialized Version: " + ((int) version));
        }
    }

    protected final boolean isWrapperForThis(Class<?> iface) {
        return iface.isAssignableFrom(getClass());
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return isWrapperForThis(iface);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.sql.Wrapper
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (isWrapperForThis(iface)) {
            return this;
        }
        throw new SQLException(this + " is not a wrapper for or implementation of " + iface.getName());
    }
}
