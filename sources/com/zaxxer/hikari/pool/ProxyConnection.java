package com.zaxxer.hikari.pool;

import com.zaxxer.hikari.util.ClockSource;
import com.zaxxer.hikari.util.FastList;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import org.jline.console.Printer;
import org.jline.reader.LineReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyConnection.class */
public abstract class ProxyConnection implements Connection {
    static final int DIRTY_BIT_READONLY = 1;
    static final int DIRTY_BIT_AUTOCOMMIT = 2;
    static final int DIRTY_BIT_ISOLATION = 4;
    static final int DIRTY_BIT_CATALOG = 8;
    static final int DIRTY_BIT_NETTIMEOUT = 16;
    protected Connection delegate;
    private final PoolEntry poolEntry;
    private final ProxyLeakTask leakTask;
    private final FastList<Statement> openStatements;
    private int dirtyBits;
    private long lastAccess;
    private boolean isCommitStateDirty;
    private boolean isReadOnly;
    private boolean isAutoCommit;
    private int networkTimeout;
    private int transactionIsolation;
    private String dbcatalog;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyConnection.class);
    private static final ClockSource clockSource = ClockSource.INSTANCE;
    private static final Set<String> ERROR_STATES = new HashSet();
    private static final Set<Integer> ERROR_CODES = new HashSet();

    static {
        ERROR_STATES.add("57P01");
        ERROR_STATES.add("57P02");
        ERROR_STATES.add("57P03");
        ERROR_STATES.add("01002");
        ERROR_STATES.add("JZ0C0");
        ERROR_STATES.add("JZ0C1");
        ERROR_CODES.add(500150);
        ERROR_CODES.add(2399);
    }

    /* access modifiers changed from: protected */
    public ProxyConnection(PoolEntry poolEntry, Connection connection, FastList<Statement> openStatements, ProxyLeakTask leakTask, long now, boolean isReadOnly, boolean isAutoCommit) {
        this.poolEntry = poolEntry;
        this.delegate = connection;
        this.openStatements = openStatements;
        this.leakTask = leakTask;
        this.lastAccess = now;
        this.isReadOnly = isReadOnly;
        this.isAutoCommit = isAutoCommit;
    }

    @Override // java.lang.Object
    public final String toString() {
        return new StringBuilder(64).append(getClass().getSimpleName()).append('@').append(System.identityHashCode(this)).append(" wrapping ").append(this.delegate).toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean getAutoCommitState() {
        return this.isAutoCommit;
    }

    /* access modifiers changed from: package-private */
    public final String getCatalogState() {
        return this.dbcatalog;
    }

    /* access modifiers changed from: package-private */
    public final int getTransactionIsolationState() {
        return this.transactionIsolation;
    }

    /* access modifiers changed from: package-private */
    public final boolean getReadOnlyState() {
        return this.isReadOnly;
    }

    /* access modifiers changed from: package-private */
    public final int getNetworkTimeoutState() {
        return this.networkTimeout;
    }

    /* access modifiers changed from: package-private */
    public final PoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    /* access modifiers changed from: package-private */
    public final SQLException checkException(SQLException sqle) {
        SQLException nse = sqle;
        int depth = 0;
        while (this.delegate != ClosedConnection.CLOSED_CONNECTION && nse != null && depth < 10) {
            String sqlState = nse.getSQLState();
            if ((sqlState == null || !sqlState.startsWith("08")) && !ERROR_STATES.contains(sqlState) && !ERROR_CODES.contains(Integer.valueOf(nse.getErrorCode()))) {
                nse = nse.getNextException();
            } else {
                LOGGER.warn("{} - Connection {} marked as broken because of SQLSTATE({}), ErrorCode({})", this.poolEntry.getPoolName(), this.delegate, sqlState, Integer.valueOf(nse.getErrorCode()), nse);
                this.leakTask.cancel();
                this.poolEntry.evict("(connection is broken)");
                this.delegate = ClosedConnection.CLOSED_CONNECTION;
            }
            depth++;
        }
        return sqle;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void untrackStatement(Statement statement) {
        this.openStatements.remove(statement);
    }

    /* access modifiers changed from: package-private */
    public final void markCommitStateDirty() {
        if (this.isAutoCommit) {
            this.lastAccess = clockSource.currentTime();
        } else {
            this.isCommitStateDirty = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelLeakTask() {
        this.leakTask.cancel();
    }

    private synchronized <T extends Statement> T trackStatement(T statement) {
        this.openStatements.add(statement);
        return statement;
    }

    private synchronized void closeStatements() {
        int size = this.openStatements.size();
        if (size > 0) {
            for (int i = 0; i < size && this.delegate != ClosedConnection.CLOSED_CONNECTION; i++) {
                try {
                    Statement statement = this.openStatements.get(i);
                    if (statement != null) {
                        if (0 != 0) {
                            statement.close();
                        } else {
                            statement.close();
                        }
                    }
                } catch (SQLException e) {
                    checkException(e);
                }
            }
            this.openStatements.clear();
        }
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public final void close() throws SQLException {
        closeStatements();
        if (this.delegate != ClosedConnection.CLOSED_CONNECTION) {
            try {
                this.leakTask.cancel();
                if (this.isCommitStateDirty && !this.isAutoCommit) {
                    this.delegate.rollback();
                    this.lastAccess = clockSource.currentTime();
                    LOGGER.debug("{} - Executed rollback on connection {} due to dirty commit state on close().", this.poolEntry.getPoolName(), this.delegate);
                }
                if (this.dirtyBits != 0) {
                    this.poolEntry.resetConnectionState(this, this.dirtyBits);
                    this.lastAccess = clockSource.currentTime();
                }
                this.delegate.clearWarnings();
            } catch (SQLException e) {
                if (!this.poolEntry.isMarkedEvicted()) {
                    throw checkException(e);
                }
            } finally {
                this.delegate = ClosedConnection.CLOSED_CONNECTION;
                this.poolEntry.recycle(this.lastAccess);
            }
        }
    }

    @Override // java.sql.Connection
    public boolean isClosed() throws SQLException {
        return this.delegate == ClosedConnection.CLOSED_CONNECTION;
    }

    @Override // java.sql.Connection
    public Statement createStatement() throws SQLException {
        return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement()));
    }

    @Override // java.sql.Connection
    public Statement createStatement(int resultSetType, int concurrency) throws SQLException {
        return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement(resultSetType, concurrency)));
    }

    @Override // java.sql.Connection
    public Statement createStatement(int resultSetType, int concurrency, int holdability) throws SQLException {
        return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement(resultSetType, concurrency, holdability)));
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String sql) throws SQLException {
        return ProxyFactory.getProxyCallableStatement(this, (CallableStatement) trackStatement(this.delegate.prepareCall(sql)));
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String sql, int resultSetType, int concurrency) throws SQLException {
        return ProxyFactory.getProxyCallableStatement(this, (CallableStatement) trackStatement(this.delegate.prepareCall(sql, resultSetType, concurrency)));
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String sql, int resultSetType, int concurrency, int holdability) throws SQLException {
        return ProxyFactory.getProxyCallableStatement(this, (CallableStatement) trackStatement(this.delegate.prepareCall(sql, resultSetType, concurrency, holdability)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(sql)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(sql, autoGeneratedKeys)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String sql, int resultSetType, int concurrency) throws SQLException {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(sql, resultSetType, concurrency)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String sql, int resultSetType, int concurrency, int holdability) throws SQLException {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(sql, resultSetType, concurrency, holdability)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(sql, columnIndexes)));
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return ProxyFactory.getProxyPreparedStatement(this, (PreparedStatement) trackStatement(this.delegate.prepareStatement(sql, columnNames)));
    }

    @Override // java.sql.Connection
    public void commit() throws SQLException {
        this.delegate.commit();
        this.isCommitStateDirty = false;
        this.lastAccess = clockSource.currentTime();
    }

    @Override // java.sql.Connection
    public void rollback() throws SQLException {
        this.delegate.rollback();
        this.isCommitStateDirty = false;
        this.lastAccess = clockSource.currentTime();
    }

    @Override // java.sql.Connection
    public void rollback(Savepoint savepoint) throws SQLException {
        this.delegate.rollback(savepoint);
        this.isCommitStateDirty = false;
        this.lastAccess = clockSource.currentTime();
    }

    @Override // java.sql.Connection
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        this.delegate.setAutoCommit(autoCommit);
        this.isAutoCommit = autoCommit;
        this.dirtyBits |= 2;
    }

    @Override // java.sql.Connection
    public void setReadOnly(boolean readOnly) throws SQLException {
        this.delegate.setReadOnly(readOnly);
        this.isReadOnly = readOnly;
        this.isCommitStateDirty = false;
        this.dirtyBits |= 1;
    }

    @Override // java.sql.Connection
    public void setTransactionIsolation(int level) throws SQLException {
        this.delegate.setTransactionIsolation(level);
        this.transactionIsolation = level;
        this.dirtyBits |= 4;
    }

    @Override // java.sql.Connection
    public void setCatalog(String catalog) throws SQLException {
        this.delegate.setCatalog(catalog);
        this.dbcatalog = catalog;
        this.dirtyBits |= 8;
    }

    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        this.delegate.setNetworkTimeout(executor, milliseconds);
        this.networkTimeout = milliseconds;
        this.dirtyBits |= 16;
    }

    @Override // java.sql.Wrapper
    public final boolean isWrapperFor(Class<?> iface) throws SQLException {
        return iface.isInstance(this.delegate) || ((this.delegate instanceof Wrapper) && this.delegate.isWrapperFor(iface));
    }

    @Override // java.sql.Wrapper
    public final <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this.delegate)) {
            return (T) this.delegate;
        }
        if (this.delegate instanceof Wrapper) {
            return (T) this.delegate.unwrap(iface);
        }
        throw new SQLException("Wrapped connection is not an instance of " + iface);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyConnection$ClosedConnection.class */
    public static final class ClosedConnection {
        static final Connection CLOSED_CONNECTION = getClosedConnection();

        private ClosedConnection() {
        }

        private static Connection getClosedConnection() {
            return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[]{Connection.class}, new InvocationHandler() { // from class: com.zaxxer.hikari.pool.ProxyConnection.ClosedConnection.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    String methodName = method.getName();
                    if (LineReader.SEND_BREAK.equals(methodName)) {
                        return Void.TYPE;
                    }
                    if ("isValid".equals(methodName)) {
                        return Boolean.FALSE;
                    }
                    if (Printer.TO_STRING.equals(methodName)) {
                        return ClosedConnection.class.getCanonicalName();
                    }
                    throw new SQLException("Connection is closed");
                }
            });
        }
    }
}
