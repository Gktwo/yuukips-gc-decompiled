package com.mchange.p009v2.sql.filter;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/* renamed from: com.mchange.v2.sql.filter.SynchronizedFilterResultSet */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/SynchronizedFilterResultSet.class */
public abstract class SynchronizedFilterResultSet implements ResultSet {
    protected ResultSet inner;

    private void __setInner(ResultSet resultSet) {
        this.inner = resultSet;
    }

    public SynchronizedFilterResultSet(ResultSet resultSet) {
        __setInner(resultSet);
    }

    public SynchronizedFilterResultSet() {
    }

    public synchronized void setInner(ResultSet resultSet) {
        __setInner(resultSet);
    }

    public synchronized ResultSet getInner() {
        return this.inner;
    }

    @Override // java.sql.ResultSet
    public synchronized void clearWarnings() throws SQLException {
        this.inner.clearWarnings();
    }

    @Override // java.sql.ResultSet
    public synchronized int getHoldability() throws SQLException {
        return this.inner.getHoldability();
    }

    @Override // java.sql.ResultSet
    public synchronized ResultSetMetaData getMetaData() throws SQLException {
        return this.inner.getMetaData();
    }

    @Override // java.sql.ResultSet
    public synchronized SQLWarning getWarnings() throws SQLException {
        return this.inner.getWarnings();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean isClosed() throws SQLException {
        return this.inner.isClosed();
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        this.inner.updateBigDecimal(i, bigDecimal);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBigDecimal(String str, BigDecimal bigDecimal) throws SQLException {
        this.inner.updateBigDecimal(str, bigDecimal);
    }

    @Override // java.sql.ResultSet
    public synchronized boolean absolute(int i) throws SQLException {
        return this.inner.absolute(i);
    }

    @Override // java.sql.ResultSet
    public synchronized void afterLast() throws SQLException {
        this.inner.afterLast();
    }

    @Override // java.sql.ResultSet
    public synchronized void beforeFirst() throws SQLException {
        this.inner.beforeFirst();
    }

    @Override // java.sql.ResultSet
    public synchronized void cancelRowUpdates() throws SQLException {
        this.inner.cancelRowUpdates();
    }

    @Override // java.sql.ResultSet
    public synchronized void deleteRow() throws SQLException {
        this.inner.deleteRow();
    }

    @Override // java.sql.ResultSet
    public synchronized int findColumn(String str) throws SQLException {
        return this.inner.findColumn(str);
    }

    @Override // java.sql.ResultSet
    public synchronized boolean first() throws SQLException {
        return this.inner.first();
    }

    @Override // java.sql.ResultSet
    public synchronized InputStream getAsciiStream(int i) throws SQLException {
        return this.inner.getAsciiStream(i);
    }

    @Override // java.sql.ResultSet
    public synchronized InputStream getAsciiStream(String str) throws SQLException {
        return this.inner.getAsciiStream(str);
    }

    @Override // java.sql.ResultSet
    public synchronized BigDecimal getBigDecimal(String str, int i) throws SQLException {
        return this.inner.getBigDecimal(str, i);
    }

    @Override // java.sql.ResultSet
    public synchronized BigDecimal getBigDecimal(String str) throws SQLException {
        return this.inner.getBigDecimal(str);
    }

    @Override // java.sql.ResultSet
    public synchronized BigDecimal getBigDecimal(int i) throws SQLException {
        return this.inner.getBigDecimal(i);
    }

    @Override // java.sql.ResultSet
    public synchronized BigDecimal getBigDecimal(int i, int i2) throws SQLException {
        return this.inner.getBigDecimal(i, i2);
    }

    @Override // java.sql.ResultSet
    public synchronized InputStream getBinaryStream(String str) throws SQLException {
        return this.inner.getBinaryStream(str);
    }

    @Override // java.sql.ResultSet
    public synchronized InputStream getBinaryStream(int i) throws SQLException {
        return this.inner.getBinaryStream(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Blob getBlob(String str) throws SQLException {
        return this.inner.getBlob(str);
    }

    @Override // java.sql.ResultSet
    public synchronized Blob getBlob(int i) throws SQLException {
        return this.inner.getBlob(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Reader getCharacterStream(int i) throws SQLException {
        return this.inner.getCharacterStream(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Reader getCharacterStream(String str) throws SQLException {
        return this.inner.getCharacterStream(str);
    }

    @Override // java.sql.ResultSet
    public synchronized Clob getClob(int i) throws SQLException {
        return this.inner.getClob(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Clob getClob(String str) throws SQLException {
        return this.inner.getClob(str);
    }

    @Override // java.sql.ResultSet
    public synchronized int getConcurrency() throws SQLException {
        return this.inner.getConcurrency();
    }

    @Override // java.sql.ResultSet
    public synchronized String getCursorName() throws SQLException {
        return this.inner.getCursorName();
    }

    @Override // java.sql.ResultSet
    public synchronized int getFetchDirection() throws SQLException {
        return this.inner.getFetchDirection();
    }

    @Override // java.sql.ResultSet
    public synchronized int getFetchSize() throws SQLException {
        return this.inner.getFetchSize();
    }

    @Override // java.sql.ResultSet
    public synchronized Reader getNCharacterStream(int i) throws SQLException {
        return this.inner.getNCharacterStream(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Reader getNCharacterStream(String str) throws SQLException {
        return this.inner.getNCharacterStream(str);
    }

    @Override // java.sql.ResultSet
    public synchronized NClob getNClob(String str) throws SQLException {
        return this.inner.getNClob(str);
    }

    @Override // java.sql.ResultSet
    public synchronized NClob getNClob(int i) throws SQLException {
        return this.inner.getNClob(i);
    }

    @Override // java.sql.ResultSet
    public synchronized String getNString(int i) throws SQLException {
        return this.inner.getNString(i);
    }

    @Override // java.sql.ResultSet
    public synchronized String getNString(String str) throws SQLException {
        return this.inner.getNString(str);
    }

    @Override // java.sql.ResultSet
    public synchronized int getRow() throws SQLException {
        return this.inner.getRow();
    }

    @Override // java.sql.ResultSet
    public synchronized RowId getRowId(int i) throws SQLException {
        return this.inner.getRowId(i);
    }

    @Override // java.sql.ResultSet
    public synchronized RowId getRowId(String str) throws SQLException {
        return this.inner.getRowId(str);
    }

    @Override // java.sql.ResultSet
    public synchronized SQLXML getSQLXML(String str) throws SQLException {
        return this.inner.getSQLXML(str);
    }

    @Override // java.sql.ResultSet
    public synchronized SQLXML getSQLXML(int i) throws SQLException {
        return this.inner.getSQLXML(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Statement getStatement() throws SQLException {
        return this.inner.getStatement();
    }

    @Override // java.sql.ResultSet
    public synchronized InputStream getUnicodeStream(int i) throws SQLException {
        return this.inner.getUnicodeStream(i);
    }

    @Override // java.sql.ResultSet
    public synchronized InputStream getUnicodeStream(String str) throws SQLException {
        return this.inner.getUnicodeStream(str);
    }

    @Override // java.sql.ResultSet
    public synchronized void insertRow() throws SQLException {
        this.inner.insertRow();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean isAfterLast() throws SQLException {
        return this.inner.isAfterLast();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean isBeforeFirst() throws SQLException {
        return this.inner.isBeforeFirst();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean isFirst() throws SQLException {
        return this.inner.isFirst();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean isLast() throws SQLException {
        return this.inner.isLast();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean last() throws SQLException {
        return this.inner.last();
    }

    @Override // java.sql.ResultSet
    public synchronized void moveToCurrentRow() throws SQLException {
        this.inner.moveToCurrentRow();
    }

    @Override // java.sql.ResultSet
    public synchronized void moveToInsertRow() throws SQLException {
        this.inner.moveToInsertRow();
    }

    @Override // java.sql.ResultSet
    public synchronized void refreshRow() throws SQLException {
        this.inner.refreshRow();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean relative(int i) throws SQLException {
        return this.inner.relative(i);
    }

    @Override // java.sql.ResultSet
    public synchronized boolean rowDeleted() throws SQLException {
        return this.inner.rowDeleted();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean rowInserted() throws SQLException {
        return this.inner.rowInserted();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean rowUpdated() throws SQLException {
        return this.inner.rowUpdated();
    }

    @Override // java.sql.ResultSet
    public synchronized void setFetchDirection(int i) throws SQLException {
        this.inner.setFetchDirection(i);
    }

    @Override // java.sql.ResultSet
    public synchronized void setFetchSize(int i) throws SQLException {
        this.inner.setFetchSize(i);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateArray(String str, Array array) throws SQLException {
        this.inner.updateArray(str, array);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateArray(int i, Array array) throws SQLException {
        this.inner.updateArray(i, array);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateAsciiStream(int i, InputStream inputStream) throws SQLException {
        this.inner.updateAsciiStream(i, inputStream);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.updateAsciiStream(i, inputStream, i2);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateAsciiStream(String str, InputStream inputStream) throws SQLException {
        this.inner.updateAsciiStream(str, inputStream);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateAsciiStream(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.updateAsciiStream(str, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateAsciiStream(String str, InputStream inputStream, int i) throws SQLException {
        this.inner.updateAsciiStream(str, inputStream, i);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateAsciiStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.updateAsciiStream(i, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBinaryStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBinaryStream(i, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBinaryStream(String str, InputStream inputStream) throws SQLException {
        this.inner.updateBinaryStream(str, inputStream);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBinaryStream(int i, InputStream inputStream) throws SQLException {
        this.inner.updateBinaryStream(i, inputStream);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBinaryStream(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBinaryStream(str, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.updateBinaryStream(i, inputStream, i2);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBinaryStream(String str, InputStream inputStream, int i) throws SQLException {
        this.inner.updateBinaryStream(str, inputStream, i);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBlob(int i, Blob blob) throws SQLException {
        this.inner.updateBlob(i, blob);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBlob(String str, Blob blob) throws SQLException {
        this.inner.updateBlob(str, blob);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBlob(String str, InputStream inputStream) throws SQLException {
        this.inner.updateBlob(str, inputStream);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBlob(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBlob(str, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBlob(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBlob(i, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBlob(int i, InputStream inputStream) throws SQLException {
        this.inner.updateBlob(i, inputStream);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBoolean(String str, boolean z) throws SQLException {
        this.inner.updateBoolean(str, z);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBoolean(int i, boolean z) throws SQLException {
        this.inner.updateBoolean(i, z);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateByte(String str, byte b) throws SQLException {
        this.inner.updateByte(str, b);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateByte(int i, byte b) throws SQLException {
        this.inner.updateByte(i, b);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBytes(String str, byte[] bArr) throws SQLException {
        this.inner.updateBytes(str, bArr);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateBytes(int i, byte[] bArr) throws SQLException {
        this.inner.updateBytes(i, bArr);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateCharacterStream(String str, Reader reader) throws SQLException {
        this.inner.updateCharacterStream(str, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateCharacterStream(String str, Reader reader, int i) throws SQLException {
        this.inner.updateCharacterStream(str, reader, i);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.updateCharacterStream(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateCharacterStream(String str, Reader reader, long j) throws SQLException {
        this.inner.updateCharacterStream(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.updateCharacterStream(i, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateCharacterStream(int i, Reader reader, int i2) throws SQLException {
        this.inner.updateCharacterStream(i, reader, i2);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateClob(String str, Reader reader, long j) throws SQLException {
        this.inner.updateClob(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateClob(int i, Reader reader, long j) throws SQLException {
        this.inner.updateClob(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateClob(String str, Reader reader) throws SQLException {
        this.inner.updateClob(str, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateClob(int i, Reader reader) throws SQLException {
        this.inner.updateClob(i, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateClob(int i, Clob clob) throws SQLException {
        this.inner.updateClob(i, clob);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateClob(String str, Clob clob) throws SQLException {
        this.inner.updateClob(str, clob);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateDate(int i, Date date) throws SQLException {
        this.inner.updateDate(i, date);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateDate(String str, Date date) throws SQLException {
        this.inner.updateDate(str, date);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateDouble(int i, double d) throws SQLException {
        this.inner.updateDouble(i, d);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateDouble(String str, double d) throws SQLException {
        this.inner.updateDouble(str, d);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateFloat(String str, float f) throws SQLException {
        this.inner.updateFloat(str, f);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateFloat(int i, float f) throws SQLException {
        this.inner.updateFloat(i, f);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateInt(String str, int i) throws SQLException {
        this.inner.updateInt(str, i);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateInt(int i, int i2) throws SQLException {
        this.inner.updateInt(i, i2);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateLong(String str, long j) throws SQLException {
        this.inner.updateLong(str, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateLong(int i, long j) throws SQLException {
        this.inner.updateLong(i, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.updateNCharacterStream(i, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNCharacterStream(String str, Reader reader) throws SQLException {
        this.inner.updateNCharacterStream(str, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNCharacterStream(String str, Reader reader, long j) throws SQLException {
        this.inner.updateNCharacterStream(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.updateNCharacterStream(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNClob(int i, Reader reader) throws SQLException {
        this.inner.updateNClob(i, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNClob(String str, Reader reader) throws SQLException {
        this.inner.updateNClob(str, reader);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNClob(int i, Reader reader, long j) throws SQLException {
        this.inner.updateNClob(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNClob(int i, NClob nClob) throws SQLException {
        this.inner.updateNClob(i, nClob);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNClob(String str, Reader reader, long j) throws SQLException {
        this.inner.updateNClob(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNClob(String str, NClob nClob) throws SQLException {
        this.inner.updateNClob(str, nClob);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNString(String str, String str2) throws SQLException {
        this.inner.updateNString(str, str2);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNString(int i, String str) throws SQLException {
        this.inner.updateNString(i, str);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNull(int i) throws SQLException {
        this.inner.updateNull(i);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateNull(String str) throws SQLException {
        this.inner.updateNull(str);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateObject(int i, Object obj) throws SQLException {
        this.inner.updateObject(i, obj);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateObject(String str, Object obj) throws SQLException {
        this.inner.updateObject(str, obj);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateObject(String str, Object obj, int i) throws SQLException {
        this.inner.updateObject(str, obj, i);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateObject(int i, Object obj, int i2) throws SQLException {
        this.inner.updateObject(i, obj, i2);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateRef(int i, Ref ref) throws SQLException {
        this.inner.updateRef(i, ref);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateRef(String str, Ref ref) throws SQLException {
        this.inner.updateRef(str, ref);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateRow() throws SQLException {
        this.inner.updateRow();
    }

    @Override // java.sql.ResultSet
    public synchronized void updateRowId(int i, RowId rowId) throws SQLException {
        this.inner.updateRowId(i, rowId);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateRowId(String str, RowId rowId) throws SQLException {
        this.inner.updateRowId(str, rowId);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateSQLXML(int i, SQLXML sqlxml) throws SQLException {
        this.inner.updateSQLXML(i, sqlxml);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateSQLXML(String str, SQLXML sqlxml) throws SQLException {
        this.inner.updateSQLXML(str, sqlxml);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateShort(String str, short s) throws SQLException {
        this.inner.updateShort(str, s);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateShort(int i, short s) throws SQLException {
        this.inner.updateShort(i, s);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateString(String str, String str2) throws SQLException {
        this.inner.updateString(str, str2);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateString(int i, String str) throws SQLException {
        this.inner.updateString(i, str);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateTime(String str, Time time) throws SQLException {
        this.inner.updateTime(str, time);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateTime(int i, Time time) throws SQLException {
        this.inner.updateTime(i, time);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateTimestamp(String str, Timestamp timestamp) throws SQLException {
        this.inner.updateTimestamp(str, timestamp);
    }

    @Override // java.sql.ResultSet
    public synchronized void updateTimestamp(int i, Timestamp timestamp) throws SQLException {
        this.inner.updateTimestamp(i, timestamp);
    }

    @Override // java.sql.ResultSet
    public synchronized boolean wasNull() throws SQLException {
        return this.inner.wasNull();
    }

    public synchronized Object getObject(int i, Class cls) throws SQLException {
        return this.inner.getObject(i, cls);
    }

    @Override // java.sql.ResultSet
    public synchronized Object getObject(String str) throws SQLException {
        return this.inner.getObject(str);
    }

    public synchronized Object getObject(String str, Class cls) throws SQLException {
        return this.inner.getObject(str, cls);
    }

    @Override // java.sql.ResultSet
    public synchronized Object getObject(int i, Map map) throws SQLException {
        return this.inner.getObject(i, map);
    }

    @Override // java.sql.ResultSet
    public synchronized Object getObject(String str, Map map) throws SQLException {
        return this.inner.getObject(str, map);
    }

    @Override // java.sql.ResultSet
    public synchronized Object getObject(int i) throws SQLException {
        return this.inner.getObject(i);
    }

    @Override // java.sql.ResultSet
    public synchronized boolean getBoolean(String str) throws SQLException {
        return this.inner.getBoolean(str);
    }

    @Override // java.sql.ResultSet
    public synchronized boolean getBoolean(int i) throws SQLException {
        return this.inner.getBoolean(i);
    }

    @Override // java.sql.ResultSet
    public synchronized byte getByte(int i) throws SQLException {
        return this.inner.getByte(i);
    }

    @Override // java.sql.ResultSet
    public synchronized byte getByte(String str) throws SQLException {
        return this.inner.getByte(str);
    }

    @Override // java.sql.ResultSet
    public synchronized short getShort(String str) throws SQLException {
        return this.inner.getShort(str);
    }

    @Override // java.sql.ResultSet
    public synchronized short getShort(int i) throws SQLException {
        return this.inner.getShort(i);
    }

    @Override // java.sql.ResultSet
    public synchronized int getInt(String str) throws SQLException {
        return this.inner.getInt(str);
    }

    @Override // java.sql.ResultSet
    public synchronized int getInt(int i) throws SQLException {
        return this.inner.getInt(i);
    }

    @Override // java.sql.ResultSet
    public synchronized long getLong(String str) throws SQLException {
        return this.inner.getLong(str);
    }

    @Override // java.sql.ResultSet
    public synchronized long getLong(int i) throws SQLException {
        return this.inner.getLong(i);
    }

    @Override // java.sql.ResultSet
    public synchronized float getFloat(int i) throws SQLException {
        return this.inner.getFloat(i);
    }

    @Override // java.sql.ResultSet
    public synchronized float getFloat(String str) throws SQLException {
        return this.inner.getFloat(str);
    }

    @Override // java.sql.ResultSet
    public synchronized double getDouble(int i) throws SQLException {
        return this.inner.getDouble(i);
    }

    @Override // java.sql.ResultSet
    public synchronized double getDouble(String str) throws SQLException {
        return this.inner.getDouble(str);
    }

    @Override // java.sql.ResultSet
    public synchronized byte[] getBytes(String str) throws SQLException {
        return this.inner.getBytes(str);
    }

    @Override // java.sql.ResultSet
    public synchronized byte[] getBytes(int i) throws SQLException {
        return this.inner.getBytes(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Array getArray(int i) throws SQLException {
        return this.inner.getArray(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Array getArray(String str) throws SQLException {
        return this.inner.getArray(str);
    }

    @Override // java.sql.ResultSet
    public synchronized boolean next() throws SQLException {
        return this.inner.next();
    }

    @Override // java.sql.ResultSet
    public synchronized URL getURL(int i) throws SQLException {
        return this.inner.getURL(i);
    }

    @Override // java.sql.ResultSet
    public synchronized URL getURL(String str) throws SQLException {
        return this.inner.getURL(str);
    }

    @Override // java.sql.ResultSet, java.lang.AutoCloseable
    public synchronized void close() throws SQLException {
        this.inner.close();
    }

    @Override // java.sql.ResultSet
    public synchronized int getType() throws SQLException {
        return this.inner.getType();
    }

    @Override // java.sql.ResultSet
    public synchronized boolean previous() throws SQLException {
        return this.inner.previous();
    }

    @Override // java.sql.ResultSet
    public synchronized Ref getRef(String str) throws SQLException {
        return this.inner.getRef(str);
    }

    @Override // java.sql.ResultSet
    public synchronized Ref getRef(int i) throws SQLException {
        return this.inner.getRef(i);
    }

    @Override // java.sql.ResultSet
    public synchronized String getString(int i) throws SQLException {
        return this.inner.getString(i);
    }

    @Override // java.sql.ResultSet
    public synchronized String getString(String str) throws SQLException {
        return this.inner.getString(str);
    }

    @Override // java.sql.ResultSet
    public synchronized Date getDate(int i, Calendar calendar) throws SQLException {
        return this.inner.getDate(i, calendar);
    }

    @Override // java.sql.ResultSet
    public synchronized Date getDate(String str, Calendar calendar) throws SQLException {
        return this.inner.getDate(str, calendar);
    }

    @Override // java.sql.ResultSet
    public synchronized Date getDate(String str) throws SQLException {
        return this.inner.getDate(str);
    }

    @Override // java.sql.ResultSet
    public synchronized Date getDate(int i) throws SQLException {
        return this.inner.getDate(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Time getTime(int i) throws SQLException {
        return this.inner.getTime(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Time getTime(String str, Calendar calendar) throws SQLException {
        return this.inner.getTime(str, calendar);
    }

    @Override // java.sql.ResultSet
    public synchronized Time getTime(String str) throws SQLException {
        return this.inner.getTime(str);
    }

    @Override // java.sql.ResultSet
    public synchronized Time getTime(int i, Calendar calendar) throws SQLException {
        return this.inner.getTime(i, calendar);
    }

    @Override // java.sql.ResultSet
    public synchronized Timestamp getTimestamp(int i) throws SQLException {
        return this.inner.getTimestamp(i);
    }

    @Override // java.sql.ResultSet
    public synchronized Timestamp getTimestamp(String str) throws SQLException {
        return this.inner.getTimestamp(str);
    }

    @Override // java.sql.ResultSet
    public synchronized Timestamp getTimestamp(String str, Calendar calendar) throws SQLException {
        return this.inner.getTimestamp(str, calendar);
    }

    @Override // java.sql.ResultSet
    public synchronized Timestamp getTimestamp(int i, Calendar calendar) throws SQLException {
        return this.inner.getTimestamp(i, calendar);
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
