package com.mchange.p009v2.sql.filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/* renamed from: com.mchange.v2.sql.filter.SynchronizedFilterStatement */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/SynchronizedFilterStatement.class */
public abstract class SynchronizedFilterStatement implements Statement {
    protected Statement inner;

    private void __setInner(Statement statement) {
        this.inner = statement;
    }

    public SynchronizedFilterStatement(Statement statement) {
        __setInner(statement);
    }

    public SynchronizedFilterStatement() {
    }

    public synchronized void setInner(Statement statement) {
        __setInner(statement);
    }

    public synchronized Statement getInner() {
        return this.inner;
    }

    @Override // java.sql.Statement
    public synchronized boolean execute(String str, int i) throws SQLException {
        return this.inner.execute(str, i);
    }

    @Override // java.sql.Statement
    public synchronized boolean execute(String str, String[] strArr) throws SQLException {
        return this.inner.execute(str, strArr);
    }

    @Override // java.sql.Statement
    public synchronized boolean execute(String str) throws SQLException {
        return this.inner.execute(str);
    }

    @Override // java.sql.Statement
    public synchronized boolean execute(String str, int[] iArr) throws SQLException {
        return this.inner.execute(str, iArr);
    }

    @Override // java.sql.Statement
    public synchronized void clearWarnings() throws SQLException {
        this.inner.clearWarnings();
    }

    @Override // java.sql.Statement
    public synchronized SQLWarning getWarnings() throws SQLException {
        return this.inner.getWarnings();
    }

    @Override // java.sql.Statement
    public synchronized boolean isClosed() throws SQLException {
        return this.inner.isClosed();
    }

    @Override // java.sql.Statement
    public synchronized int getFetchDirection() throws SQLException {
        return this.inner.getFetchDirection();
    }

    @Override // java.sql.Statement
    public synchronized int getFetchSize() throws SQLException {
        return this.inner.getFetchSize();
    }

    @Override // java.sql.Statement
    public synchronized void setFetchDirection(int i) throws SQLException {
        this.inner.setFetchDirection(i);
    }

    @Override // java.sql.Statement
    public synchronized void setFetchSize(int i) throws SQLException {
        this.inner.setFetchSize(i);
    }

    @Override // java.sql.Statement
    public synchronized Connection getConnection() throws SQLException {
        return this.inner.getConnection();
    }

    @Override // java.sql.Statement
    public synchronized int getResultSetHoldability() throws SQLException {
        return this.inner.getResultSetHoldability();
    }

    @Override // java.sql.Statement
    public synchronized void addBatch(String str) throws SQLException {
        this.inner.addBatch(str);
    }

    @Override // java.sql.Statement
    public synchronized void cancel() throws SQLException {
        this.inner.cancel();
    }

    @Override // java.sql.Statement
    public synchronized void clearBatch() throws SQLException {
        this.inner.clearBatch();
    }

    public synchronized void closeOnCompletion() throws SQLException {
        this.inner.closeOnCompletion();
    }

    @Override // java.sql.Statement
    public synchronized int[] executeBatch() throws SQLException {
        return this.inner.executeBatch();
    }

    @Override // java.sql.Statement
    public synchronized ResultSet executeQuery(String str) throws SQLException {
        return this.inner.executeQuery(str);
    }

    @Override // java.sql.Statement
    public synchronized int executeUpdate(String str, int[] iArr) throws SQLException {
        return this.inner.executeUpdate(str, iArr);
    }

    @Override // java.sql.Statement
    public synchronized int executeUpdate(String str, String[] strArr) throws SQLException {
        return this.inner.executeUpdate(str, strArr);
    }

    @Override // java.sql.Statement
    public synchronized int executeUpdate(String str) throws SQLException {
        return this.inner.executeUpdate(str);
    }

    @Override // java.sql.Statement
    public synchronized int executeUpdate(String str, int i) throws SQLException {
        return this.inner.executeUpdate(str, i);
    }

    @Override // java.sql.Statement
    public synchronized ResultSet getGeneratedKeys() throws SQLException {
        return this.inner.getGeneratedKeys();
    }

    @Override // java.sql.Statement
    public synchronized int getMaxFieldSize() throws SQLException {
        return this.inner.getMaxFieldSize();
    }

    @Override // java.sql.Statement
    public synchronized int getMaxRows() throws SQLException {
        return this.inner.getMaxRows();
    }

    @Override // java.sql.Statement
    public synchronized boolean getMoreResults() throws SQLException {
        return this.inner.getMoreResults();
    }

    @Override // java.sql.Statement
    public synchronized boolean getMoreResults(int i) throws SQLException {
        return this.inner.getMoreResults(i);
    }

    @Override // java.sql.Statement
    public synchronized int getQueryTimeout() throws SQLException {
        return this.inner.getQueryTimeout();
    }

    @Override // java.sql.Statement
    public synchronized ResultSet getResultSet() throws SQLException {
        return this.inner.getResultSet();
    }

    @Override // java.sql.Statement
    public synchronized int getResultSetConcurrency() throws SQLException {
        return this.inner.getResultSetConcurrency();
    }

    @Override // java.sql.Statement
    public synchronized int getResultSetType() throws SQLException {
        return this.inner.getResultSetType();
    }

    @Override // java.sql.Statement
    public synchronized int getUpdateCount() throws SQLException {
        return this.inner.getUpdateCount();
    }

    public synchronized boolean isCloseOnCompletion() throws SQLException {
        return this.inner.isCloseOnCompletion();
    }

    @Override // java.sql.Statement
    public synchronized boolean isPoolable() throws SQLException {
        return this.inner.isPoolable();
    }

    @Override // java.sql.Statement
    public synchronized void setCursorName(String str) throws SQLException {
        this.inner.setCursorName(str);
    }

    @Override // java.sql.Statement
    public synchronized void setEscapeProcessing(boolean z) throws SQLException {
        this.inner.setEscapeProcessing(z);
    }

    @Override // java.sql.Statement
    public synchronized void setMaxFieldSize(int i) throws SQLException {
        this.inner.setMaxFieldSize(i);
    }

    @Override // java.sql.Statement
    public synchronized void setMaxRows(int i) throws SQLException {
        this.inner.setMaxRows(i);
    }

    @Override // java.sql.Statement
    public synchronized void setPoolable(boolean z) throws SQLException {
        this.inner.setPoolable(z);
    }

    @Override // java.sql.Statement
    public synchronized void setQueryTimeout(int i) throws SQLException {
        this.inner.setQueryTimeout(i);
    }

    @Override // java.sql.Statement, java.lang.AutoCloseable
    public synchronized void close() throws SQLException {
        this.inner.close();
    }

    @Override // java.sql.Wrapper
    public synchronized boolean isWrapperFor(Class cls) throws SQLException {
        return this.inner.isWrapperFor(cls);
    }

    @Override // java.sql.Wrapper
    public synchronized Object unwrap(Class cls) throws SQLException {
        return this.inner.unwrap(cls);
    }
}
