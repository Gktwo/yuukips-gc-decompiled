package com.mchange.p009v2.sql.filter;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
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
import java.util.Map;

/* renamed from: com.mchange.v2.sql.filter.SynchronizedFilterCallableStatement */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/SynchronizedFilterCallableStatement.class */
public abstract class SynchronizedFilterCallableStatement implements CallableStatement {
    protected CallableStatement inner;

    private void __setInner(CallableStatement callableStatement) {
        this.inner = callableStatement;
    }

    public SynchronizedFilterCallableStatement(CallableStatement callableStatement) {
        __setInner(callableStatement);
    }

    public SynchronizedFilterCallableStatement() {
    }

    public synchronized void setInner(CallableStatement callableStatement) {
        __setInner(callableStatement);
    }

    public synchronized CallableStatement getInner() {
        return this.inner;
    }

    @Override // java.sql.CallableStatement
    public synchronized BigDecimal getBigDecimal(int i, int i2) throws SQLException {
        return this.inner.getBigDecimal(i, i2);
    }

    @Override // java.sql.CallableStatement
    public synchronized BigDecimal getBigDecimal(String str) throws SQLException {
        return this.inner.getBigDecimal(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized BigDecimal getBigDecimal(int i) throws SQLException {
        return this.inner.getBigDecimal(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Blob getBlob(int i) throws SQLException {
        return this.inner.getBlob(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Blob getBlob(String str) throws SQLException {
        return this.inner.getBlob(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Reader getCharacterStream(int i) throws SQLException {
        return this.inner.getCharacterStream(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Reader getCharacterStream(String str) throws SQLException {
        return this.inner.getCharacterStream(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Clob getClob(int i) throws SQLException {
        return this.inner.getClob(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Clob getClob(String str) throws SQLException {
        return this.inner.getClob(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Reader getNCharacterStream(int i) throws SQLException {
        return this.inner.getNCharacterStream(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Reader getNCharacterStream(String str) throws SQLException {
        return this.inner.getNCharacterStream(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized NClob getNClob(String str) throws SQLException {
        return this.inner.getNClob(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized NClob getNClob(int i) throws SQLException {
        return this.inner.getNClob(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized String getNString(int i) throws SQLException {
        return this.inner.getNString(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized String getNString(String str) throws SQLException {
        return this.inner.getNString(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized RowId getRowId(String str) throws SQLException {
        return this.inner.getRowId(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized RowId getRowId(int i) throws SQLException {
        return this.inner.getRowId(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized SQLXML getSQLXML(String str) throws SQLException {
        return this.inner.getSQLXML(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized SQLXML getSQLXML(int i) throws SQLException {
        return this.inner.getSQLXML(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized boolean wasNull() throws SQLException {
        return this.inner.wasNull();
    }

    @Override // java.sql.CallableStatement
    public synchronized void registerOutParameter(String str, int i, String str2) throws SQLException {
        this.inner.registerOutParameter(str, i, str2);
    }

    @Override // java.sql.CallableStatement
    public synchronized void registerOutParameter(int i, int i2) throws SQLException {
        this.inner.registerOutParameter(i, i2);
    }

    @Override // java.sql.CallableStatement
    public synchronized void registerOutParameter(int i, int i2, String str) throws SQLException {
        this.inner.registerOutParameter(i, i2, str);
    }

    @Override // java.sql.CallableStatement
    public synchronized void registerOutParameter(String str, int i, int i2) throws SQLException {
        this.inner.registerOutParameter(str, i, i2);
    }

    @Override // java.sql.CallableStatement
    public synchronized void registerOutParameter(String str, int i) throws SQLException {
        this.inner.registerOutParameter(str, i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void registerOutParameter(int i, int i2, int i3) throws SQLException {
        this.inner.registerOutParameter(i, i2, i3);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setAsciiStream(String str, InputStream inputStream) throws SQLException {
        this.inner.setAsciiStream(str, inputStream);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setAsciiStream(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.setAsciiStream(str, inputStream, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setAsciiStream(String str, InputStream inputStream, int i) throws SQLException {
        this.inner.setAsciiStream(str, inputStream, i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBigDecimal(String str, BigDecimal bigDecimal) throws SQLException {
        this.inner.setBigDecimal(str, bigDecimal);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBinaryStream(String str, InputStream inputStream) throws SQLException {
        this.inner.setBinaryStream(str, inputStream);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBinaryStream(String str, InputStream inputStream, int i) throws SQLException {
        this.inner.setBinaryStream(str, inputStream, i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBinaryStream(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.setBinaryStream(str, inputStream, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBlob(String str, Blob blob) throws SQLException {
        this.inner.setBlob(str, blob);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBlob(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.setBlob(str, inputStream, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBlob(String str, InputStream inputStream) throws SQLException {
        this.inner.setBlob(str, inputStream);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBytes(String str, byte[] bArr) throws SQLException {
        this.inner.setBytes(str, bArr);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setCharacterStream(String str, Reader reader, long j) throws SQLException {
        this.inner.setCharacterStream(str, reader, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setCharacterStream(String str, Reader reader) throws SQLException {
        this.inner.setCharacterStream(str, reader);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setCharacterStream(String str, Reader reader, int i) throws SQLException {
        this.inner.setCharacterStream(str, reader, i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setClob(String str, Reader reader) throws SQLException {
        this.inner.setClob(str, reader);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setClob(String str, Clob clob) throws SQLException {
        this.inner.setClob(str, clob);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setClob(String str, Reader reader, long j) throws SQLException {
        this.inner.setClob(str, reader, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setDate(String str, Date date, Calendar calendar) throws SQLException {
        this.inner.setDate(str, date, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setDate(String str, Date date) throws SQLException {
        this.inner.setDate(str, date);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNCharacterStream(String str, Reader reader) throws SQLException {
        this.inner.setNCharacterStream(str, reader);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNCharacterStream(String str, Reader reader, long j) throws SQLException {
        this.inner.setNCharacterStream(str, reader, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNClob(String str, Reader reader, long j) throws SQLException {
        this.inner.setNClob(str, reader, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNClob(String str, NClob nClob) throws SQLException {
        this.inner.setNClob(str, nClob);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNClob(String str, Reader reader) throws SQLException {
        this.inner.setNClob(str, reader);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNString(String str, String str2) throws SQLException {
        this.inner.setNString(str, str2);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNull(String str, int i, String str2) throws SQLException {
        this.inner.setNull(str, i, str2);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setNull(String str, int i) throws SQLException {
        this.inner.setNull(str, i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setObject(String str, Object obj) throws SQLException {
        this.inner.setObject(str, obj);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setObject(String str, Object obj, int i, int i2) throws SQLException {
        this.inner.setObject(str, obj, i, i2);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setObject(String str, Object obj, int i) throws SQLException {
        this.inner.setObject(str, obj, i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setRowId(String str, RowId rowId) throws SQLException {
        this.inner.setRowId(str, rowId);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setSQLXML(String str, SQLXML sqlxml) throws SQLException {
        this.inner.setSQLXML(str, sqlxml);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setString(String str, String str2) throws SQLException {
        this.inner.setString(str, str2);
    }

    @Override // java.sql.CallableStatement
    public synchronized Object getObject(String str) throws SQLException {
        return this.inner.getObject(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Object getObject(String str, Map map) throws SQLException {
        return this.inner.getObject(str, map);
    }

    public synchronized Object getObject(int i, Class cls) throws SQLException {
        return this.inner.getObject(i, cls);
    }

    @Override // java.sql.CallableStatement
    public synchronized Object getObject(int i) throws SQLException {
        return this.inner.getObject(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Object getObject(int i, Map map) throws SQLException {
        return this.inner.getObject(i, map);
    }

    public synchronized Object getObject(String str, Class cls) throws SQLException {
        return this.inner.getObject(str, cls);
    }

    @Override // java.sql.CallableStatement
    public synchronized boolean getBoolean(String str) throws SQLException {
        return this.inner.getBoolean(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized boolean getBoolean(int i) throws SQLException {
        return this.inner.getBoolean(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized byte getByte(String str) throws SQLException {
        return this.inner.getByte(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized byte getByte(int i) throws SQLException {
        return this.inner.getByte(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized short getShort(String str) throws SQLException {
        return this.inner.getShort(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized short getShort(int i) throws SQLException {
        return this.inner.getShort(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized int getInt(int i) throws SQLException {
        return this.inner.getInt(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized int getInt(String str) throws SQLException {
        return this.inner.getInt(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized long getLong(int i) throws SQLException {
        return this.inner.getLong(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized long getLong(String str) throws SQLException {
        return this.inner.getLong(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized float getFloat(int i) throws SQLException {
        return this.inner.getFloat(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized float getFloat(String str) throws SQLException {
        return this.inner.getFloat(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized double getDouble(String str) throws SQLException {
        return this.inner.getDouble(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized double getDouble(int i) throws SQLException {
        return this.inner.getDouble(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized byte[] getBytes(int i) throws SQLException {
        return this.inner.getBytes(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized byte[] getBytes(String str) throws SQLException {
        return this.inner.getBytes(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Array getArray(int i) throws SQLException {
        return this.inner.getArray(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Array getArray(String str) throws SQLException {
        return this.inner.getArray(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized URL getURL(int i) throws SQLException {
        return this.inner.getURL(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized URL getURL(String str) throws SQLException {
        return this.inner.getURL(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setBoolean(String str, boolean z) throws SQLException {
        this.inner.setBoolean(str, z);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setByte(String str, byte b) throws SQLException {
        this.inner.setByte(str, b);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setDouble(String str, double d) throws SQLException {
        this.inner.setDouble(str, d);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setFloat(String str, float f) throws SQLException {
        this.inner.setFloat(str, f);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setInt(String str, int i) throws SQLException {
        this.inner.setInt(str, i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setLong(String str, long j) throws SQLException {
        this.inner.setLong(str, j);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setShort(String str, short s) throws SQLException {
        this.inner.setShort(str, s);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setTimestamp(String str, Timestamp timestamp) throws SQLException {
        this.inner.setTimestamp(str, timestamp);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setTimestamp(String str, Timestamp timestamp, Calendar calendar) throws SQLException {
        this.inner.setTimestamp(str, timestamp, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized Ref getRef(int i) throws SQLException {
        return this.inner.getRef(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Ref getRef(String str) throws SQLException {
        return this.inner.getRef(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized String getString(String str) throws SQLException {
        return this.inner.getString(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized String getString(int i) throws SQLException {
        return this.inner.getString(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setURL(String str, URL url) throws SQLException {
        this.inner.setURL(str, url);
    }

    @Override // java.sql.CallableStatement
    public synchronized Date getDate(int i, Calendar calendar) throws SQLException {
        return this.inner.getDate(i, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized Date getDate(int i) throws SQLException {
        return this.inner.getDate(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Date getDate(String str, Calendar calendar) throws SQLException {
        return this.inner.getDate(str, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized Date getDate(String str) throws SQLException {
        return this.inner.getDate(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Time getTime(String str) throws SQLException {
        return this.inner.getTime(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Time getTime(int i) throws SQLException {
        return this.inner.getTime(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Time getTime(String str, Calendar calendar) throws SQLException {
        return this.inner.getTime(str, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized Time getTime(int i, Calendar calendar) throws SQLException {
        return this.inner.getTime(i, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setTime(String str, Time time, Calendar calendar) throws SQLException {
        this.inner.setTime(str, time, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized void setTime(String str, Time time) throws SQLException {
        this.inner.setTime(str, time);
    }

    @Override // java.sql.CallableStatement
    public synchronized Timestamp getTimestamp(String str, Calendar calendar) throws SQLException {
        return this.inner.getTimestamp(str, calendar);
    }

    @Override // java.sql.CallableStatement
    public synchronized Timestamp getTimestamp(int i) throws SQLException {
        return this.inner.getTimestamp(i);
    }

    @Override // java.sql.CallableStatement
    public synchronized Timestamp getTimestamp(String str) throws SQLException {
        return this.inner.getTimestamp(str);
    }

    @Override // java.sql.CallableStatement
    public synchronized Timestamp getTimestamp(int i, Calendar calendar) throws SQLException {
        return this.inner.getTimestamp(i, calendar);
    }

    @Override // java.sql.PreparedStatement
    public synchronized boolean execute() throws SQLException {
        return this.inner.execute();
    }

    @Override // java.sql.PreparedStatement
    public synchronized ResultSetMetaData getMetaData() throws SQLException {
        return this.inner.getMetaData();
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setArray(int i, Array array) throws SQLException {
        this.inner.setArray(i, array);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void addBatch() throws SQLException {
        this.inner.addBatch();
    }

    @Override // java.sql.PreparedStatement
    public synchronized ResultSet executeQuery() throws SQLException {
        return this.inner.executeQuery();
    }

    @Override // java.sql.PreparedStatement
    public synchronized int executeUpdate() throws SQLException {
        return this.inner.executeUpdate();
    }

    @Override // java.sql.PreparedStatement
    public synchronized void clearParameters() throws SQLException {
        this.inner.clearParameters();
    }

    @Override // java.sql.PreparedStatement
    public synchronized ParameterMetaData getParameterMetaData() throws SQLException {
        return this.inner.getParameterMetaData();
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setAsciiStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.setAsciiStream(i, inputStream, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setAsciiStream(int i, InputStream inputStream) throws SQLException {
        this.inner.setAsciiStream(i, inputStream);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.setAsciiStream(i, inputStream, i2);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        this.inner.setBigDecimal(i, bigDecimal);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.setBinaryStream(i, inputStream, i2);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBinaryStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.setBinaryStream(i, inputStream, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBinaryStream(int i, InputStream inputStream) throws SQLException {
        this.inner.setBinaryStream(i, inputStream);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBlob(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.setBlob(i, inputStream, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBlob(int i, Blob blob) throws SQLException {
        this.inner.setBlob(i, blob);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBlob(int i, InputStream inputStream) throws SQLException {
        this.inner.setBlob(i, inputStream);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBytes(int i, byte[] bArr) throws SQLException {
        this.inner.setBytes(i, bArr);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.setCharacterStream(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setCharacterStream(int i, Reader reader, int i2) throws SQLException {
        this.inner.setCharacterStream(i, reader, i2);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.setCharacterStream(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setClob(int i, Reader reader, long j) throws SQLException {
        this.inner.setClob(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setClob(int i, Reader reader) throws SQLException {
        this.inner.setClob(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setClob(int i, Clob clob) throws SQLException {
        this.inner.setClob(i, clob);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setDate(int i, Date date) throws SQLException {
        this.inner.setDate(i, date);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setDate(int i, Date date, Calendar calendar) throws SQLException {
        this.inner.setDate(i, date, calendar);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.setNCharacterStream(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.setNCharacterStream(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNClob(int i, Reader reader) throws SQLException {
        this.inner.setNClob(i, reader);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNClob(int i, Reader reader, long j) throws SQLException {
        this.inner.setNClob(i, reader, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNClob(int i, NClob nClob) throws SQLException {
        this.inner.setNClob(i, nClob);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNString(int i, String str) throws SQLException {
        this.inner.setNString(i, str);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNull(int i, int i2) throws SQLException {
        this.inner.setNull(i, i2);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setNull(int i, int i2, String str) throws SQLException {
        this.inner.setNull(i, i2, str);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setObject(int i, Object obj, int i2) throws SQLException {
        this.inner.setObject(i, obj, i2);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setObject(int i, Object obj, int i2, int i3) throws SQLException {
        this.inner.setObject(i, obj, i2, i3);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setObject(int i, Object obj) throws SQLException {
        this.inner.setObject(i, obj);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setRef(int i, Ref ref) throws SQLException {
        this.inner.setRef(i, ref);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setRowId(int i, RowId rowId) throws SQLException {
        this.inner.setRowId(i, rowId);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
        this.inner.setSQLXML(i, sqlxml);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setString(int i, String str) throws SQLException {
        this.inner.setString(i, str);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setUnicodeStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.setUnicodeStream(i, inputStream, i2);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setBoolean(int i, boolean z) throws SQLException {
        this.inner.setBoolean(i, z);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setByte(int i, byte b) throws SQLException {
        this.inner.setByte(i, b);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setDouble(int i, double d) throws SQLException {
        this.inner.setDouble(i, d);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setFloat(int i, float f) throws SQLException {
        this.inner.setFloat(i, f);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setInt(int i, int i2) throws SQLException {
        this.inner.setInt(i, i2);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setLong(int i, long j) throws SQLException {
        this.inner.setLong(i, j);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setShort(int i, short s) throws SQLException {
        this.inner.setShort(i, s);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setTimestamp(int i, Timestamp timestamp, Calendar calendar) throws SQLException {
        this.inner.setTimestamp(i, timestamp, calendar);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setTimestamp(int i, Timestamp timestamp) throws SQLException {
        this.inner.setTimestamp(i, timestamp);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setURL(int i, URL url) throws SQLException {
        this.inner.setURL(i, url);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setTime(int i, Time time, Calendar calendar) throws SQLException {
        this.inner.setTime(i, time, calendar);
    }

    @Override // java.sql.PreparedStatement
    public synchronized void setTime(int i, Time time) throws SQLException {
        this.inner.setTime(i, time);
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
