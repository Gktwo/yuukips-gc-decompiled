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

/* renamed from: com.mchange.v2.sql.filter.FilterConnection */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/FilterConnection.class */
public abstract class FilterConnection implements Connection {
    protected Connection inner;

    private void __setInner(Connection connection) {
        this.inner = connection;
    }

    public FilterConnection(Connection connection) {
        __setInner(connection);
    }

    public FilterConnection() {
    }

    public void setInner(Connection connection) {
        __setInner(connection);
    }

    public Connection getInner() {
        return this.inner;
    }

    @Override // java.sql.Connection
    public void commit() throws SQLException {
        this.inner.commit();
    }

    @Override // java.sql.Connection
    public void clearWarnings() throws SQLException {
        this.inner.clearWarnings();
    }

    @Override // java.sql.Connection
    public Array createArrayOf(String str, Object[] objArr) throws SQLException {
        return this.inner.createArrayOf(str, objArr);
    }

    @Override // java.sql.Connection
    public Blob createBlob() throws SQLException {
        return this.inner.createBlob();
    }

    @Override // java.sql.Connection
    public Clob createClob() throws SQLException {
        return this.inner.createClob();
    }

    @Override // java.sql.Connection
    public NClob createNClob() throws SQLException {
        return this.inner.createNClob();
    }

    @Override // java.sql.Connection
    public SQLXML createSQLXML() throws SQLException {
        return this.inner.createSQLXML();
    }

    @Override // java.sql.Connection
    public Statement createStatement(int i, int i2, int i3) throws SQLException {
        return this.inner.createStatement(i, i2, i3);
    }

    @Override // java.sql.Connection
    public Statement createStatement(int i, int i2) throws SQLException {
        return this.inner.createStatement(i, i2);
    }

    @Override // java.sql.Connection
    public Statement createStatement() throws SQLException {
        return this.inner.createStatement();
    }

    @Override // java.sql.Connection
    public Struct createStruct(String str, Object[] objArr) throws SQLException {
        return this.inner.createStruct(str, objArr);
    }

    @Override // java.sql.Connection
    public boolean getAutoCommit() throws SQLException {
        return this.inner.getAutoCommit();
    }

    @Override // java.sql.Connection
    public String getCatalog() throws SQLException {
        return this.inner.getCatalog();
    }

    @Override // java.sql.Connection
    public String getClientInfo(String str) throws SQLException {
        return this.inner.getClientInfo(str);
    }

    @Override // java.sql.Connection
    public Properties getClientInfo() throws SQLException {
        return this.inner.getClientInfo();
    }

    @Override // java.sql.Connection
    public int getHoldability() throws SQLException {
        return this.inner.getHoldability();
    }

    @Override // java.sql.Connection
    public DatabaseMetaData getMetaData() throws SQLException {
        return this.inner.getMetaData();
    }

    public int getNetworkTimeout() throws SQLException {
        return this.inner.getNetworkTimeout();
    }

    public String getSchema() throws SQLException {
        return this.inner.getSchema();
    }

    @Override // java.sql.Connection
    public int getTransactionIsolation() throws SQLException {
        return this.inner.getTransactionIsolation();
    }

    @Override // java.sql.Connection
    public Map getTypeMap() throws SQLException {
        return this.inner.getTypeMap();
    }

    @Override // java.sql.Connection
    public SQLWarning getWarnings() throws SQLException {
        return this.inner.getWarnings();
    }

    @Override // java.sql.Connection
    public boolean isClosed() throws SQLException {
        return this.inner.isClosed();
    }

    @Override // java.sql.Connection
    public String nativeSQL(String str) throws SQLException {
        return this.inner.nativeSQL(str);
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str, int i, int i2, int i3) throws SQLException {
        return this.inner.prepareCall(str, i, i2, i3);
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str, int i, int i2) throws SQLException {
        return this.inner.prepareCall(str, i, i2);
    }

    @Override // java.sql.Connection
    public CallableStatement prepareCall(String str) throws SQLException {
        return this.inner.prepareCall(str);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i, int i2, int i3) throws SQLException {
        return this.inner.prepareStatement(str, i, i2, i3);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i) throws SQLException {
        return this.inner.prepareStatement(str, i);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int[] iArr) throws SQLException {
        return this.inner.prepareStatement(str, iArr);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, String[] strArr) throws SQLException {
        return this.inner.prepareStatement(str, strArr);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str) throws SQLException {
        return this.inner.prepareStatement(str);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String str, int i, int i2) throws SQLException {
        return this.inner.prepareStatement(str, i, i2);
    }

    @Override // java.sql.Connection
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        this.inner.releaseSavepoint(savepoint);
    }

    @Override // java.sql.Connection
    public void rollback() throws SQLException {
        this.inner.rollback();
    }

    @Override // java.sql.Connection
    public void rollback(Savepoint savepoint) throws SQLException {
        this.inner.rollback(savepoint);
    }

    @Override // java.sql.Connection
    public void setAutoCommit(boolean z) throws SQLException {
        this.inner.setAutoCommit(z);
    }

    @Override // java.sql.Connection
    public void setCatalog(String str) throws SQLException {
        this.inner.setCatalog(str);
    }

    @Override // java.sql.Connection
    public void setClientInfo(String str, String str2) throws SQLClientInfoException {
        this.inner.setClientInfo(str, str2);
    }

    @Override // java.sql.Connection
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        this.inner.setClientInfo(properties);
    }

    @Override // java.sql.Connection
    public void setHoldability(int i) throws SQLException {
        this.inner.setHoldability(i);
    }

    public void setNetworkTimeout(Executor executor, int i) throws SQLException {
        this.inner.setNetworkTimeout(executor, i);
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint() throws SQLException {
        return this.inner.setSavepoint();
    }

    @Override // java.sql.Connection
    public Savepoint setSavepoint(String str) throws SQLException {
        return this.inner.setSavepoint(str);
    }

    public void setSchema(String str) throws SQLException {
        this.inner.setSchema(str);
    }

    @Override // java.sql.Connection
    public void setTransactionIsolation(int i) throws SQLException {
        this.inner.setTransactionIsolation(i);
    }

    @Override // java.sql.Connection
    public void setTypeMap(Map map) throws SQLException {
        this.inner.setTypeMap(map);
    }

    @Override // java.sql.Connection
    public void setReadOnly(boolean z) throws SQLException {
        this.inner.setReadOnly(z);
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        this.inner.close();
    }

    @Override // java.sql.Connection
    public boolean isValid(int i) throws SQLException {
        return this.inner.isValid(i);
    }

    @Override // java.sql.Connection
    public boolean isReadOnly() throws SQLException {
        return this.inner.isReadOnly();
    }

    public void abort(Executor executor) throws SQLException {
        this.inner.abort(executor);
    }

    @Override // java.sql.Wrapper
    public boolean isWrapperFor(Class cls) throws SQLException {
        return this.inner.isWrapperFor(cls);
    }

    @Override // java.sql.Wrapper
    public Object unwrap(Class cls) throws SQLException {
        return this.inner.unwrap(cls);
    }
}
