package com.zaxxer.hikari.pool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyResultSet.class */
public abstract class ProxyResultSet implements ResultSet {
    protected final ProxyConnection connection;
    protected final ProxyStatement statement;
    protected final ResultSet delegate;

    /* access modifiers changed from: protected */
    public ProxyResultSet(ProxyConnection connection, ProxyStatement statement, ResultSet resultSet) {
        this.connection = connection;
        this.statement = statement;
        this.delegate = resultSet;
    }

    /* access modifiers changed from: package-private */
    public final SQLException checkException(SQLException e) {
        return this.connection.checkException(e);
    }

    @Override // java.lang.Object
    public String toString() {
        return new StringBuilder(64).append(getClass().getSimpleName()).append('@').append(System.identityHashCode(this)).append(" wrapping ").append(this.delegate).toString();
    }

    @Override // java.sql.ResultSet
    public final Statement getStatement() throws SQLException {
        return this.statement;
    }

    @Override // java.sql.ResultSet
    public void updateRow() throws SQLException {
        this.connection.markCommitStateDirty();
        this.delegate.updateRow();
    }

    @Override // java.sql.ResultSet
    public void insertRow() throws SQLException {
        this.connection.markCommitStateDirty();
        this.delegate.insertRow();
    }

    @Override // java.sql.ResultSet
    public void deleteRow() throws SQLException {
        this.connection.markCommitStateDirty();
        this.delegate.deleteRow();
    }

    @Override // java.sql.Wrapper
    public final <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this.delegate)) {
            return (T) this.delegate;
        }
        if (this.delegate instanceof Wrapper) {
            return (T) this.delegate.unwrap(iface);
        }
        throw new SQLException("Wrapped ResultSet is not an instance of " + iface);
    }
}
