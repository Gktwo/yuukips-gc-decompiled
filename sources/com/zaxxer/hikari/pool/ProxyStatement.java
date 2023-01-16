package com.zaxxer.hikari.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyStatement.class */
public abstract class ProxyStatement implements Statement {
    protected final ProxyConnection connection;
    protected final Statement delegate;
    private boolean isClosed;
    private ResultSet proxyResultSet;

    /* access modifiers changed from: protected */
    public ProxyStatement(ProxyConnection connection, Statement statement) {
        this.connection = connection;
        this.delegate = statement;
    }

    /* access modifiers changed from: package-private */
    public final SQLException checkException(SQLException e) {
        return this.connection.checkException(e);
    }

    @Override // java.lang.Object
    public final String toString() {
        String delegateToString = this.delegate.toString();
        return new StringBuilder(64 + delegateToString.length()).append(getClass().getSimpleName()).append('@').append(System.identityHashCode(this)).append(" wrapping ").append(delegateToString).toString();
    }

    @Override // java.sql.Statement, java.lang.AutoCloseable
    public final void close() throws SQLException {
        synchronized (this) {
            if (!this.isClosed) {
                this.isClosed = true;
                this.connection.untrackStatement(this.delegate);
                try {
                    this.delegate.close();
                } catch (SQLException e) {
                    throw this.connection.checkException(e);
                }
            }
        }
    }

    @Override // java.sql.Statement
    public Connection getConnection() throws SQLException {
        return this.connection;
    }

    @Override // java.sql.Statement
    public boolean execute(String sql) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(sql);
    }

    @Override // java.sql.Statement
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(sql, autoGeneratedKeys);
    }

    @Override // java.sql.Statement
    public ResultSet executeQuery(String sql) throws SQLException {
        this.connection.markCommitStateDirty();
        return ProxyFactory.getProxyResultSet(this.connection, this, this.delegate.executeQuery(sql));
    }

    @Override // java.sql.Statement
    public int executeUpdate(String sql) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(sql);
    }

    @Override // java.sql.Statement
    public int[] executeBatch() throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.executeBatch();
    }

    @Override // java.sql.Statement
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(sql, autoGeneratedKeys);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(sql, columnIndexes);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.executeUpdate(sql, columnNames);
    }

    @Override // java.sql.Statement
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(sql, columnIndexes);
    }

    @Override // java.sql.Statement
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        this.connection.markCommitStateDirty();
        return this.delegate.execute(sql, columnNames);
    }

    @Override // java.sql.Statement
    public ResultSet getResultSet() throws SQLException {
        ResultSet resultSet = this.delegate.getResultSet();
        if (resultSet == null) {
            this.proxyResultSet = null;
        } else if (this.proxyResultSet == null || ((ProxyResultSet) this.proxyResultSet).delegate != resultSet) {
            this.proxyResultSet = ProxyFactory.getProxyResultSet(this.connection, this, resultSet);
        }
        return this.proxyResultSet;
    }

    @Override // java.sql.Wrapper
    public final <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this.delegate)) {
            return (T) this.delegate;
        }
        if (this.delegate instanceof Wrapper) {
            return (T) this.delegate.unwrap(iface);
        }
        throw new SQLException("Wrapped statement is not an instance of " + iface);
    }
}
