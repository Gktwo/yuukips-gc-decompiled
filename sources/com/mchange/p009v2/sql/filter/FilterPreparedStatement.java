package com.mchange.p009v2.sql.filter;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

/* renamed from: com.mchange.v2.sql.filter.FilterPreparedStatement */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/FilterPreparedStatement.class */
public abstract class FilterPreparedStatement implements PreparedStatement {
    protected PreparedStatement inner;

    private void __setInner(PreparedStatement preparedStatement) {
        this.inner = preparedStatement;
    }

    public FilterPreparedStatement(PreparedStatement preparedStatement) {
        __setInner(preparedStatement);
    }

    public FilterPreparedStatement() {
    }

    public void setInner(PreparedStatement preparedStatement) {
        __setInner(preparedStatement);
    }

    public PreparedStatement getInner() {
        return this.inner;
    }

    @Override // java.sql.PreparedStatement
    public boolean execute() throws SQLException {
        return this.inner.execute();
    }

    @Override // java.sql.PreparedStatement
    public ResultSetMetaData getMetaData() throws SQLException {
        return this.inner.getMetaData();
    }

    @Override // java.sql.PreparedStatement
    public void setArray(int i, Array array) throws SQLException {
        this.inner.setArray(i, array);
    }

    @Override // java.sql.PreparedStatement
    public void addBatch() throws SQLException {
        this.inner.addBatch();
    }

    @Override // java.sql.PreparedStatement
    public ResultSet executeQuery() throws SQLException {
        return this.inner.executeQuery();
    }

    @Override // java.sql.PreparedStatement
    public int executeUpdate() throws SQLException {
        return this.inner.executeUpdate();
    }

    @Override // java.sql.PreparedStatement
    public void clearParameters() throws SQLException {
        this.inner.clearParameters();
    }

    @Override // java.sql.PreparedStatement
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return this.inner.getParameterMetaData();
    }

    @Override // java.sql.PreparedStatement
    public void setAsciiStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.setAsciiStream(i, inputStream, j);
    }

    @Override // java.sql.PreparedStatement
    public void setAsciiStream(int i, InputStream inputStream) throws SQLException {
        this.inner.setAsciiStream(i, inputStream);
    }

    @Override // java.sql.PreparedStatement
    public void setAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.setAsciiStream(i, inputStream, i2);
    }

    @Override // java.sql.PreparedStatement
    public void setBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        this.inner.setBigDecimal(i, bigDecimal);
    }

    @Override // java.sql.PreparedStatement
    public void setBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.setBinaryStream(i, inputStream, i2);
    }

    @Override // java.sql.PreparedStatement
    public void setBinaryStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.setBinaryStream(i, inputStream, j);
    }

    @Override // java.sql.PreparedStatement
    public void setBinaryStream(int i, InputStream inputStream) throws SQLException {
        this.inner.setBinaryStream(i, inputStream);
    }

    @Override // java.sql.PreparedStatement
    public void setBlob(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.setBlob(i, inputStream, j);
    }

    @Override // java.sql.PreparedStatement
    public void setBlob(int i, Blob blob) throws SQLException {
        this.inner.setBlob(i, blob);
    }

    @Override // java.sql.PreparedStatement
    public void setBlob(int i, InputStream inputStream) throws SQLException {
        this.inner.setBlob(i, inputStream);
    }

    @Override // java.sql.PreparedStatement
    public void setBytes(int i, byte[] bArr) throws SQLException {
        this.inner.setBytes(i, bArr);
    }

    @Override // java.sql.PreparedStatement
    public void setCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.setCharacterStream(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public void setCharacterStream(int i, Reader reader, int i2) throws SQLException {
        this.inner.setCharacterStream(i, reader, i2);
    }

    @Override // java.sql.PreparedStatement
    public void setCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.setCharacterStream(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public void setClob(int i, Reader reader, long j) throws SQLException {
        this.inner.setClob(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public void setClob(int i, Reader reader) throws SQLException {
        this.inner.setClob(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public void setClob(int i, Clob clob) throws SQLException {
        this.inner.setClob(i, clob);
    }

    @Override // java.sql.PreparedStatement
    public void setDate(int i, Date date) throws SQLException {
        this.inner.setDate(i, date);
    }

    @Override // java.sql.PreparedStatement
    public void setDate(int i, Date date, Calendar calendar) throws SQLException {
        this.inner.setDate(i, date, calendar);
    }

    @Override // java.sql.PreparedStatement
    public void setNCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.setNCharacterStream(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public void setNCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.setNCharacterStream(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public void setNClob(int i, Reader reader) throws SQLException {
        this.inner.setNClob(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public void setNClob(int i, Reader reader, long j) throws SQLException {
        this.inner.setNClob(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public void setNClob(int i, NClob nClob) throws SQLException {
        this.inner.setNClob(i, nClob);
    }

    @Override // java.sql.PreparedStatement
    public void setNString(int i, String str) throws SQLException {
        this.inner.setNString(i, str);
    }

    @Override // java.sql.PreparedStatement
    public void setNull(int i, int i2) throws SQLException {
        this.inner.setNull(i, i2);
    }

    @Override // java.sql.PreparedStatement
    public void setNull(int i, int i2, String str) throws SQLException {
        this.inner.setNull(i, i2, str);
    }

    @Override // java.sql.PreparedStatement
    public void setObject(int i, Object obj, int i2) throws SQLException {
        this.inner.setObject(i, obj, i2);
    }

    @Override // java.sql.PreparedStatement
    public void setObject(int i, Object obj, int i2, int i3) throws SQLException {
        this.inner.setObject(i, obj, i2, i3);
    }

    @Override // java.sql.PreparedStatement
    public void setObject(int i, Object obj) throws SQLException {
        this.inner.setObject(i, obj);
    }

    @Override // java.sql.PreparedStatement
    public void setRef(int i, Ref ref) throws SQLException {
        this.inner.setRef(i, ref);
    }

    @Override // java.sql.PreparedStatement
    public void setRowId(int i, RowId rowId) throws SQLException {
        this.inner.setRowId(i, rowId);
    }

    @Override // java.sql.PreparedStatement
    public void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
        this.inner.setSQLXML(i, sqlxml);
    }

    @Override // java.sql.PreparedStatement
    public void setString(int i, String str) throws SQLException {
        this.inner.setString(i, str);
    }

    @Override // java.sql.PreparedStatement
    public void setUnicodeStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.setUnicodeStream(i, inputStream, i2);
    }

    @Override // java.sql.PreparedStatement
    public void setBoolean(int i, boolean z) throws SQLException {
        this.inner.setBoolean(i, z);
    }

    @Override // java.sql.PreparedStatement
    public void setByte(int i, byte b) throws SQLException {
        this.inner.setByte(i, b);
    }

    @Override // java.sql.PreparedStatement
    public void setDouble(int i, double d) throws SQLException {
        this.inner.setDouble(i, d);
    }

    @Override // java.sql.PreparedStatement
    public void setFloat(int i, float f) throws SQLException {
        this.inner.setFloat(i, f);
    }

    @Override // java.sql.PreparedStatement
    public void setInt(int i, int i2) throws SQLException {
        this.inner.setInt(i, i2);
    }

    @Override // java.sql.PreparedStatement
    public void setLong(int i, long j) throws SQLException {
        this.inner.setLong(i, j);
    }

    @Override // java.sql.PreparedStatement
    public void setShort(int i, short s) throws SQLException {
        this.inner.setShort(i, s);
    }

    @Override // java.sql.PreparedStatement
    public void setTimestamp(int i, Timestamp timestamp, Calendar calendar) throws SQLException {
        this.inner.setTimestamp(i, timestamp, calendar);
    }

    @Override // java.sql.PreparedStatement
    public void setTimestamp(int i, Timestamp timestamp) throws SQLException {
        this.inner.setTimestamp(i, timestamp);
    }

    @Override // java.sql.PreparedStatement
    public void setURL(int i, URL url) throws SQLException {
        this.inner.setURL(i, url);
    }

    @Override // java.sql.PreparedStatement
    public void setTime(int i, Time time, Calendar calendar) throws SQLException {
        this.inner.setTime(i, time, calendar);
    }

    @Override // java.sql.PreparedStatement
    public void setTime(int i, Time time) throws SQLException {
        this.inner.setTime(i, time);
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int i) throws SQLException {
        return this.inner.execute(str, i);
    }

    @Override // java.sql.Statement
    public boolean execute(String str, String[] strArr) throws SQLException {
        return this.inner.execute(str, strArr);
    }

    @Override // java.sql.Statement
    public boolean execute(String str) throws SQLException {
        return this.inner.execute(str);
    }

    @Override // java.sql.Statement
    public boolean execute(String str, int[] iArr) throws SQLException {
        return this.inner.execute(str, iArr);
    }

    @Override // java.sql.Statement
    public void clearWarnings() throws SQLException {
        this.inner.clearWarnings();
    }

    @Override // java.sql.Statement
    public SQLWarning getWarnings() throws SQLException {
        return this.inner.getWarnings();
    }

    @Override // java.sql.Statement
    public boolean isClosed() throws SQLException {
        return this.inner.isClosed();
    }

    @Override // java.sql.Statement
    public int getFetchDirection() throws SQLException {
        return this.inner.getFetchDirection();
    }

    @Override // java.sql.Statement
    public int getFetchSize() throws SQLException {
        return this.inner.getFetchSize();
    }

    @Override // java.sql.Statement
    public void setFetchDirection(int i) throws SQLException {
        this.inner.setFetchDirection(i);
    }

    @Override // java.sql.Statement
    public void setFetchSize(int i) throws SQLException {
        this.inner.setFetchSize(i);
    }

    @Override // java.sql.Statement
    public Connection getConnection() throws SQLException {
        return this.inner.getConnection();
    }

    @Override // java.sql.Statement
    public int getResultSetHoldability() throws SQLException {
        return this.inner.getResultSetHoldability();
    }

    @Override // java.sql.Statement
    public void addBatch(String str) throws SQLException {
        this.inner.addBatch(str);
    }

    @Override // java.sql.Statement
    public void cancel() throws SQLException {
        this.inner.cancel();
    }

    @Override // java.sql.Statement
    public void clearBatch() throws SQLException {
        this.inner.clearBatch();
    }

    public void closeOnCompletion() throws SQLException {
        this.inner.closeOnCompletion();
    }

    @Override // java.sql.Statement
    public int[] executeBatch() throws SQLException {
        return this.inner.executeBatch();
    }

    @Override // java.sql.Statement
    public ResultSet executeQuery(String str) throws SQLException {
        return this.inner.executeQuery(str);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int[] iArr) throws SQLException {
        return this.inner.executeUpdate(str, iArr);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, String[] strArr) throws SQLException {
        return this.inner.executeUpdate(str, strArr);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str) throws SQLException {
        return this.inner.executeUpdate(str);
    }

    @Override // java.sql.Statement
    public int executeUpdate(String str, int i) throws SQLException {
        return this.inner.executeUpdate(str, i);
    }

    @Override // java.sql.Statement
    public ResultSet getGeneratedKeys() throws SQLException {
        return this.inner.getGeneratedKeys();
    }

    @Override // java.sql.Statement
    public int getMaxFieldSize() throws SQLException {
        return this.inner.getMaxFieldSize();
    }

    @Override // java.sql.Statement
    public int getMaxRows() throws SQLException {
        return this.inner.getMaxRows();
    }

    @Override // java.sql.Statement
    public boolean getMoreResults() throws SQLException {
        return this.inner.getMoreResults();
    }

    @Override // java.sql.Statement
    public boolean getMoreResults(int i) throws SQLException {
        return this.inner.getMoreResults(i);
    }

    @Override // java.sql.Statement
    public int getQueryTimeout() throws SQLException {
        return this.inner.getQueryTimeout();
    }

    @Override // java.sql.Statement
    public ResultSet getResultSet() throws SQLException {
        return this.inner.getResultSet();
    }

    @Override // java.sql.Statement
    public int getResultSetConcurrency() throws SQLException {
        return this.inner.getResultSetConcurrency();
    }

    @Override // java.sql.Statement
    public int getResultSetType() throws SQLException {
        return this.inner.getResultSetType();
    }

    @Override // java.sql.Statement
    public int getUpdateCount() throws SQLException {
        return this.inner.getUpdateCount();
    }

    public boolean isCloseOnCompletion() throws SQLException {
        return this.inner.isCloseOnCompletion();
    }

    @Override // java.sql.Statement
    public boolean isPoolable() throws SQLException {
        return this.inner.isPoolable();
    }

    @Override // java.sql.Statement
    public void setCursorName(String str) throws SQLException {
        this.inner.setCursorName(str);
    }

    @Override // java.sql.Statement
    public void setEscapeProcessing(boolean z) throws SQLException {
        this.inner.setEscapeProcessing(z);
    }

    @Override // java.sql.Statement
    public void setMaxFieldSize(int i) throws SQLException {
        this.inner.setMaxFieldSize(i);
    }

    @Override // java.sql.Statement
    public void setMaxRows(int i) throws SQLException {
        this.inner.setMaxRows(i);
    }

    @Override // java.sql.Statement
    public void setPoolable(boolean z) throws SQLException {
        this.inner.setPoolable(z);
    }

    @Override // java.sql.Statement
    public void setQueryTimeout(int i) throws SQLException {
        this.inner.setQueryTimeout(i);
    }

    @Override // java.sql.Statement, java.lang.AutoCloseable
    public void close() throws SQLException {
        this.inner.close();
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
