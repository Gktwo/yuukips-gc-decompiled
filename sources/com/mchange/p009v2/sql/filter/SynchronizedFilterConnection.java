package com.mchange.p009v2.sql.filter;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/* renamed from: com.mchange.v2.sql.filter.SynchronizedFilterConnection */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/SynchronizedFilterConnection.class */
public abstract class SynchronizedFilterConnection implements Connection {
    protected Connection inner;

    private void __setInner(Connection connection) {
        this.inner = connection;
    }

    public SynchronizedFilterConnection(Connection connection) {
        __setInner(connection);
    }

    public SynchronizedFilterConnection() {
    }

    public synchronized void setInner(Connection connection) {
        __setInner(connection);
    }

    public synchronized Connection getInner() {
        return this.inner;
    }

    @Override // java.sql.Connection
    public synchronized void commit() throws SQLException {
        this.inner.commit();
    }

    @Override // java.sql.Connection
    public synchronized void clearWarnings() throws SQLException {
        this.inner.clearWarnings();
    }

    @Override // java.sql.Connection
    public synchronized Array createArrayOf(String str, Object[] objArr) throws SQLException {
        return this.inner.createArrayOf(str, objArr);
    }

    @Override // java.sql.Connection
    public synchronized Blob createBlob() throws SQLException {
        return this.inner.createBlob();
    }

    @Override // java.sql.Connection
    public synchronized Clob createClob() throws SQLException {
        return this.inner.createClob();
    }

    @Override // java.sql.Connection
    public synchronized NClob createNClob() throws SQLException {
        return this.inner.createNClob();
    }

    @Override // java.sql.Connection
    public synchronized SQLXML createSQLXML() throws SQLException {
        return this.inner.createSQLXML();
    }

    @Override // java.sql.Connection
    public synchronized Statement createStatement(int i, int i2, int i3) throws SQLException {
        return this.inner.createStatement(i, i2, i3);
    }

    @Override // java.sql.Connection
    public synchronized Statement createStatement(int i, int i2) throws SQLException {
        return this.inner.createStatement(i, i2);
    }

    @Override // java.sql.Connection
    public synchronized Statement createStatement() throws SQLException {
        return this.inner.createStatement();
    }

    @Override // java.sql.Connection
    public synchronized Struct createStruct(String str, Object[] objArr) throws SQLException {
        return this.inner.createStruct(str, objArr);
    }

    @Override // java.sql.Connection
    public synchronized boolean getAutoCommit() throws SQLException {
        return this.inner.getAutoCommit();
    }

    @Override // java.sql.Connection
    public synchronized String getCatalog() throws SQLException {
        return this.inner.getCatalog();
    }

    @Override // java.sql.Connection
    public synchronized String getClientInfo(String str) throws SQLException {
        return this.inner.getClientInfo(str);
    }

    @Override // java.sql.Connection
    public synchronized Properties getClientInfo() throws SQLException {
        return this.inner.getClientInfo();
    }

    @Override // java.sql.Connection
    public synchronized int getHoldability() throws SQLException {
        return this.inner.getHoldability();
    }

    @Override // java.sql.Connection
    public synchronized DatabaseMetaData getMetaData() throws SQLException {
        return this.inner.getMetaData();
    }

    public synchronized int getNetworkTimeout() throws SQLException {
        return this.inner.getNetworkTimeout();
    }

    public synchronized String getSchema() throws SQLException {
        return this.inner.getSchema();
    }

    @Override // java.sql.Connection
    public synchronized int getTransactionIsolation() throws SQLException {
        return this.inner.getTransactionIsolation();
    }

    @Override // java.sql.Connection
    public synchronized Map getTypeMap() throws SQLException {
        return this.inner.getTypeMap();
    }

    @Override // java.sql.Connection
    public synchronized SQLWarning getWarnings() throws SQLException {
        return this.inner.getWarnings();
    }

    @Override // java.sql.Connection
    public synchronized boolean isClosed() throws SQLException {
        return this.inner.isClosed();
    }

    @Override // java.sql.Connection
    public synchronized String nativeSQL(String str) throws SQLException {
        return this.inner.nativeSQL(str);
    }

    @Override // java.sql.Connection
    public synchronized CallableStatement prepareCall(String str, int i, int i2, int i3) throws SQLException {
        return this.inner.prepareCall(str, i, i2, i3);
    }

    @Override // java.sql.Connection
    public synchronized CallableStatement prepareCall(String str, int i, int i2) throws SQLException {
        return this.inner.prepareCall(str, i, i2);
    }

    @Override // java.sql.Connection
    public synchronized CallableStatement prepareCall(String str) throws SQLException {
        return this.inner.prepareCall(str);
    }

    @Override // java.sql.Connection
    public synchronized PreparedStatement prepareStatement(String str, int i, int i2, int i3) throws SQLException {
        return this.inner.prepareStatement(str, i, i2, i3);
    }

    @Override // java.sql.Connection
    public synchronized PreparedStatement prepareStatement(String str, int i) throws SQLException {
        return this.inner.prepareStatement(str, i);
    }

    @Override // java.sql.Connection
    public synchronized PreparedStatement prepareStatement(String str, int[] iArr) throws SQLException {
        return this.inner.prepareStatement(str, iArr);
    }

    @Override // java.sql.Connection
    public synchronized PreparedStatement prepareStatement(String str, String[] strArr) throws SQLException {
        return this.inner.prepareStatement(str, strArr);
    }

    @Override // java.sql.Connection
    public synchronized PreparedStatement prepareStatement(String str) throws SQLException {
        return this.inner.prepareStatement(str);
    }

    @Override // java.sql.Connection
    public synchronized PreparedStatement prepareStatement(String str, int i, int i2) throws SQLException {
        return this.inner.prepareStatement(str, i, i2);
    }

    @Override // java.sql.Connection
    public synchronized void releaseSavepoint(Savepoint savepoint) throws SQLException {
        this.inner.releaseSavepoint(savepoint);
    }

    @Override // java.sql.Connection
    public synchronized void rollback() throws SQLException {
        this.inner.rollback();
    }

    @Override // java.sql.Connection
    public synchronized void rollback(Savepoint savepoint) throws SQLException {
        this.inner.rollback(savepoint);
    }

    @Override // java.sql.Connection
    public synchronized void setAutoCommit(boolean z) throws SQLException {
        this.inner.setAutoCommit(z);
    }

    @Override // java.sql.Connection
    public synchronized void setCatalog(String str) throws SQLException {
        this.inner.setCatalog(str);
    }

    @Override // java.sql.Connection
    public synchronized void setClientInfo(String str, String str2) throws SQLClientInfoException {
        this.inner.setClientInfo(str, str2);
    }

    @Override // java.sql.Connection
    public synchronized void setClientInfo(Properties properties) throws SQLClientInfoException {
        this.inner.setClientInfo(properties);
    }

    @Override // java.sql.Connection
    public synchronized void setHoldability(int i) throws SQLException {
        this.inner.setHoldability(i);
    }

    public synchronized void setNetworkTimeout(Executor executor, int i) throws SQLException {
        this.inner.setNetworkTimeout(executor, i);
    }

    @Override // java.sql.Connection
    public synchronized Savepoint setSavepoint() throws SQLException {
        return this.inner.setSavepoint();
    }

    @Override // java.sql.Connection
    public synchronized Savepoint setSavepoint(String str) throws SQLException {
        return this.inner.setSavepoint(str);
    }

    public synchronized void setSchema(String str) throws SQLException {
        this.inner.setSchema(str);
    }

    @Override // java.sql.Connection
    public synchronized void setTransactionIsolation(int i) throws SQLException {
        this.inner.setTransactionIsolation(i);
    }

    @Override // java.sql.Connection
    public synchronized void setTypeMap(Map map) throws SQLException {
        this.inner.setTypeMap(map);
    }

    @Override // java.sql.Connection
    public synchronized void setReadOnly(boolean z) throws SQLException {
        this.inner.setReadOnly(z);
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public synchronized void close() throws SQLException {
        this.inner.close();
    }

    @Override // java.sql.Connection
    public synchronized boolean isValid(int i) throws SQLException {
        return this.inner.isValid(i);
    }

    @Override // java.sql.Connection
    public synchronized boolean isReadOnly() throws SQLException {
        return this.inner.isReadOnly();
    }

    public synchronized void abort(Executor executor) throws SQLException {
        this.inner.abort(executor);
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
