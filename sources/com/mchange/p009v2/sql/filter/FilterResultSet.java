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

/* renamed from: com.mchange.v2.sql.filter.FilterResultSet */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/filter/FilterResultSet.class */
public abstract class FilterResultSet implements ResultSet {
    protected ResultSet inner;

    private void __setInner(ResultSet resultSet) {
        this.inner = resultSet;
    }

    public FilterResultSet(ResultSet resultSet) {
        __setInner(resultSet);
    }

    public FilterResultSet() {
    }

    public void setInner(ResultSet resultSet) {
        __setInner(resultSet);
    }

    public ResultSet getInner() {
        return this.inner;
    }

    @Override // java.sql.ResultSet
    public void clearWarnings() throws SQLException {
        this.inner.clearWarnings();
    }

    @Override // java.sql.ResultSet
    public int getHoldability() throws SQLException {
        return this.inner.getHoldability();
    }

    @Override // java.sql.ResultSet
    public ResultSetMetaData getMetaData() throws SQLException {
        return this.inner.getMetaData();
    }

    @Override // java.sql.ResultSet
    public SQLWarning getWarnings() throws SQLException {
        return this.inner.getWarnings();
    }

    @Override // java.sql.ResultSet
    public boolean isClosed() throws SQLException {
        return this.inner.isClosed();
    }

    @Override // java.sql.ResultSet
    public void updateBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
        this.inner.updateBigDecimal(i, bigDecimal);
    }

    @Override // java.sql.ResultSet
    public void updateBigDecimal(String str, BigDecimal bigDecimal) throws SQLException {
        this.inner.updateBigDecimal(str, bigDecimal);
    }

    @Override // java.sql.ResultSet
    public boolean absolute(int i) throws SQLException {
        return this.inner.absolute(i);
    }

    @Override // java.sql.ResultSet
    public void afterLast() throws SQLException {
        this.inner.afterLast();
    }

    @Override // java.sql.ResultSet
    public void beforeFirst() throws SQLException {
        this.inner.beforeFirst();
    }

    @Override // java.sql.ResultSet
    public void cancelRowUpdates() throws SQLException {
        this.inner.cancelRowUpdates();
    }

    @Override // java.sql.ResultSet
    public void deleteRow() throws SQLException {
        this.inner.deleteRow();
    }

    @Override // java.sql.ResultSet
    public int findColumn(String str) throws SQLException {
        return this.inner.findColumn(str);
    }

    @Override // java.sql.ResultSet
    public boolean first() throws SQLException {
        return this.inner.first();
    }

    @Override // java.sql.ResultSet
    public InputStream getAsciiStream(int i) throws SQLException {
        return this.inner.getAsciiStream(i);
    }

    @Override // java.sql.ResultSet
    public InputStream getAsciiStream(String str) throws SQLException {
        return this.inner.getAsciiStream(str);
    }

    @Override // java.sql.ResultSet
    public BigDecimal getBigDecimal(String str, int i) throws SQLException {
        return this.inner.getBigDecimal(str, i);
    }

    @Override // java.sql.ResultSet
    public BigDecimal getBigDecimal(String str) throws SQLException {
        return this.inner.getBigDecimal(str);
    }

    @Override // java.sql.ResultSet
    public BigDecimal getBigDecimal(int i) throws SQLException {
        return this.inner.getBigDecimal(i);
    }

    @Override // java.sql.ResultSet
    public BigDecimal getBigDecimal(int i, int i2) throws SQLException {
        return this.inner.getBigDecimal(i, i2);
    }

    @Override // java.sql.ResultSet
    public InputStream getBinaryStream(String str) throws SQLException {
        return this.inner.getBinaryStream(str);
    }

    @Override // java.sql.ResultSet
    public InputStream getBinaryStream(int i) throws SQLException {
        return this.inner.getBinaryStream(i);
    }

    @Override // java.sql.ResultSet
    public Blob getBlob(String str) throws SQLException {
        return this.inner.getBlob(str);
    }

    @Override // java.sql.ResultSet
    public Blob getBlob(int i) throws SQLException {
        return this.inner.getBlob(i);
    }

    @Override // java.sql.ResultSet
    public Reader getCharacterStream(int i) throws SQLException {
        return this.inner.getCharacterStream(i);
    }

    @Override // java.sql.ResultSet
    public Reader getCharacterStream(String str) throws SQLException {
        return this.inner.getCharacterStream(str);
    }

    @Override // java.sql.ResultSet
    public Clob getClob(int i) throws SQLException {
        return this.inner.getClob(i);
    }

    @Override // java.sql.ResultSet
    public Clob getClob(String str) throws SQLException {
        return this.inner.getClob(str);
    }

    @Override // java.sql.ResultSet
    public int getConcurrency() throws SQLException {
        return this.inner.getConcurrency();
    }

    @Override // java.sql.ResultSet
    public String getCursorName() throws SQLException {
        return this.inner.getCursorName();
    }

    @Override // java.sql.ResultSet
    public int getFetchDirection() throws SQLException {
        return this.inner.getFetchDirection();
    }

    @Override // java.sql.ResultSet
    public int getFetchSize() throws SQLException {
        return this.inner.getFetchSize();
    }

    @Override // java.sql.ResultSet
    public Reader getNCharacterStream(int i) throws SQLException {
        return this.inner.getNCharacterStream(i);
    }

    @Override // java.sql.ResultSet
    public Reader getNCharacterStream(String str) throws SQLException {
        return this.inner.getNCharacterStream(str);
    }

    @Override // java.sql.ResultSet
    public NClob getNClob(String str) throws SQLException {
        return this.inner.getNClob(str);
    }

    @Override // java.sql.ResultSet
    public NClob getNClob(int i) throws SQLException {
        return this.inner.getNClob(i);
    }

    @Override // java.sql.ResultSet
    public String getNString(int i) throws SQLException {
        return this.inner.getNString(i);
    }

    @Override // java.sql.ResultSet
    public String getNString(String str) throws SQLException {
        return this.inner.getNString(str);
    }

    @Override // java.sql.ResultSet
    public int getRow() throws SQLException {
        return this.inner.getRow();
    }

    @Override // java.sql.ResultSet
    public RowId getRowId(int i) throws SQLException {
        return this.inner.getRowId(i);
    }

    @Override // java.sql.ResultSet
    public RowId getRowId(String str) throws SQLException {
        return this.inner.getRowId(str);
    }

    @Override // java.sql.ResultSet
    public SQLXML getSQLXML(String str) throws SQLException {
        return this.inner.getSQLXML(str);
    }

    @Override // java.sql.ResultSet
    public SQLXML getSQLXML(int i) throws SQLException {
        return this.inner.getSQLXML(i);
    }

    @Override // java.sql.ResultSet
    public Statement getStatement() throws SQLException {
        return this.inner.getStatement();
    }

    @Override // java.sql.ResultSet
    public InputStream getUnicodeStream(int i) throws SQLException {
        return this.inner.getUnicodeStream(i);
    }

    @Override // java.sql.ResultSet
    public InputStream getUnicodeStream(String str) throws SQLException {
        return this.inner.getUnicodeStream(str);
    }

    @Override // java.sql.ResultSet
    public void insertRow() throws SQLException {
        this.inner.insertRow();
    }

    @Override // java.sql.ResultSet
    public boolean isAfterLast() throws SQLException {
        return this.inner.isAfterLast();
    }

    @Override // java.sql.ResultSet
    public boolean isBeforeFirst() throws SQLException {
        return this.inner.isBeforeFirst();
    }

    @Override // java.sql.ResultSet
    public boolean isFirst() throws SQLException {
        return this.inner.isFirst();
    }

    @Override // java.sql.ResultSet
    public boolean isLast() throws SQLException {
        return this.inner.isLast();
    }

    @Override // java.sql.ResultSet
    public boolean last() throws SQLException {
        return this.inner.last();
    }

    @Override // java.sql.ResultSet
    public void moveToCurrentRow() throws SQLException {
        this.inner.moveToCurrentRow();
    }

    @Override // java.sql.ResultSet
    public void moveToInsertRow() throws SQLException {
        this.inner.moveToInsertRow();
    }

    @Override // java.sql.ResultSet
    public void refreshRow() throws SQLException {
        this.inner.refreshRow();
    }

    @Override // java.sql.ResultSet
    public boolean relative(int i) throws SQLException {
        return this.inner.relative(i);
    }

    @Override // java.sql.ResultSet
    public boolean rowDeleted() throws SQLException {
        return this.inner.rowDeleted();
    }

    @Override // java.sql.ResultSet
    public boolean rowInserted() throws SQLException {
        return this.inner.rowInserted();
    }

    @Override // java.sql.ResultSet
    public boolean rowUpdated() throws SQLException {
        return this.inner.rowUpdated();
    }

    @Override // java.sql.ResultSet
    public void setFetchDirection(int i) throws SQLException {
        this.inner.setFetchDirection(i);
    }

    @Override // java.sql.ResultSet
    public void setFetchSize(int i) throws SQLException {
        this.inner.setFetchSize(i);
    }

    @Override // java.sql.ResultSet
    public void updateArray(String str, Array array) throws SQLException {
        this.inner.updateArray(str, array);
    }

    @Override // java.sql.ResultSet
    public void updateArray(int i, Array array) throws SQLException {
        this.inner.updateArray(i, array);
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(int i, InputStream inputStream) throws SQLException {
        this.inner.updateAsciiStream(i, inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.updateAsciiStream(i, inputStream, i2);
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(String str, InputStream inputStream) throws SQLException {
        this.inner.updateAsciiStream(str, inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.updateAsciiStream(str, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(String str, InputStream inputStream, int i) throws SQLException {
        this.inner.updateAsciiStream(str, inputStream, i);
    }

    @Override // java.sql.ResultSet
    public void updateAsciiStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.updateAsciiStream(i, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBinaryStream(i, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(String str, InputStream inputStream) throws SQLException {
        this.inner.updateBinaryStream(str, inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(int i, InputStream inputStream) throws SQLException {
        this.inner.updateBinaryStream(i, inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBinaryStream(str, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(int i, InputStream inputStream, int i2) throws SQLException {
        this.inner.updateBinaryStream(i, inputStream, i2);
    }

    @Override // java.sql.ResultSet
    public void updateBinaryStream(String str, InputStream inputStream, int i) throws SQLException {
        this.inner.updateBinaryStream(str, inputStream, i);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(int i, Blob blob) throws SQLException {
        this.inner.updateBlob(i, blob);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(String str, Blob blob) throws SQLException {
        this.inner.updateBlob(str, blob);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(String str, InputStream inputStream) throws SQLException {
        this.inner.updateBlob(str, inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(String str, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBlob(str, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(int i, InputStream inputStream, long j) throws SQLException {
        this.inner.updateBlob(i, inputStream, j);
    }

    @Override // java.sql.ResultSet
    public void updateBlob(int i, InputStream inputStream) throws SQLException {
        this.inner.updateBlob(i, inputStream);
    }

    @Override // java.sql.ResultSet
    public void updateBoolean(String str, boolean z) throws SQLException {
        this.inner.updateBoolean(str, z);
    }

    @Override // java.sql.ResultSet
    public void updateBoolean(int i, boolean z) throws SQLException {
        this.inner.updateBoolean(i, z);
    }

    @Override // java.sql.ResultSet
    public void updateByte(String str, byte b) throws SQLException {
        this.inner.updateByte(str, b);
    }

    @Override // java.sql.ResultSet
    public void updateByte(int i, byte b) throws SQLException {
        this.inner.updateByte(i, b);
    }

    @Override // java.sql.ResultSet
    public void updateBytes(String str, byte[] bArr) throws SQLException {
        this.inner.updateBytes(str, bArr);
    }

    @Override // java.sql.ResultSet
    public void updateBytes(int i, byte[] bArr) throws SQLException {
        this.inner.updateBytes(i, bArr);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(String str, Reader reader) throws SQLException {
        this.inner.updateCharacterStream(str, reader);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(String str, Reader reader, int i) throws SQLException {
        this.inner.updateCharacterStream(str, reader, i);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.updateCharacterStream(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(String str, Reader reader, long j) throws SQLException {
        this.inner.updateCharacterStream(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.updateCharacterStream(i, reader);
    }

    @Override // java.sql.ResultSet
    public void updateCharacterStream(int i, Reader reader, int i2) throws SQLException {
        this.inner.updateCharacterStream(i, reader, i2);
    }

    @Override // java.sql.ResultSet
    public void updateClob(String str, Reader reader, long j) throws SQLException {
        this.inner.updateClob(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateClob(int i, Reader reader, long j) throws SQLException {
        this.inner.updateClob(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateClob(String str, Reader reader) throws SQLException {
        this.inner.updateClob(str, reader);
    }

    @Override // java.sql.ResultSet
    public void updateClob(int i, Reader reader) throws SQLException {
        this.inner.updateClob(i, reader);
    }

    @Override // java.sql.ResultSet
    public void updateClob(int i, Clob clob) throws SQLException {
        this.inner.updateClob(i, clob);
    }

    @Override // java.sql.ResultSet
    public void updateClob(String str, Clob clob) throws SQLException {
        this.inner.updateClob(str, clob);
    }

    @Override // java.sql.ResultSet
    public void updateDate(int i, Date date) throws SQLException {
        this.inner.updateDate(i, date);
    }

    @Override // java.sql.ResultSet
    public void updateDate(String str, Date date) throws SQLException {
        this.inner.updateDate(str, date);
    }

    @Override // java.sql.ResultSet
    public void updateDouble(int i, double d) throws SQLException {
        this.inner.updateDouble(i, d);
    }

    @Override // java.sql.ResultSet
    public void updateDouble(String str, double d) throws SQLException {
        this.inner.updateDouble(str, d);
    }

    @Override // java.sql.ResultSet
    public void updateFloat(String str, float f) throws SQLException {
        this.inner.updateFloat(str, f);
    }

    @Override // java.sql.ResultSet
    public void updateFloat(int i, float f) throws SQLException {
        this.inner.updateFloat(i, f);
    }

    @Override // java.sql.ResultSet
    public void updateInt(String str, int i) throws SQLException {
        this.inner.updateInt(str, i);
    }

    @Override // java.sql.ResultSet
    public void updateInt(int i, int i2) throws SQLException {
        this.inner.updateInt(i, i2);
    }

    @Override // java.sql.ResultSet
    public void updateLong(String str, long j) throws SQLException {
        this.inner.updateLong(str, j);
    }

    @Override // java.sql.ResultSet
    public void updateLong(int i, long j) throws SQLException {
        this.inner.updateLong(i, j);
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(int i, Reader reader) throws SQLException {
        this.inner.updateNCharacterStream(i, reader);
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(String str, Reader reader) throws SQLException {
        this.inner.updateNCharacterStream(str, reader);
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(String str, Reader reader, long j) throws SQLException {
        this.inner.updateNCharacterStream(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateNCharacterStream(int i, Reader reader, long j) throws SQLException {
        this.inner.updateNCharacterStream(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(int i, Reader reader) throws SQLException {
        this.inner.updateNClob(i, reader);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(String str, Reader reader) throws SQLException {
        this.inner.updateNClob(str, reader);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(int i, Reader reader, long j) throws SQLException {
        this.inner.updateNClob(i, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(int i, NClob nClob) throws SQLException {
        this.inner.updateNClob(i, nClob);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(String str, Reader reader, long j) throws SQLException {
        this.inner.updateNClob(str, reader, j);
    }

    @Override // java.sql.ResultSet
    public void updateNClob(String str, NClob nClob) throws SQLException {
        this.inner.updateNClob(str, nClob);
    }

    @Override // java.sql.ResultSet
    public void updateNString(String str, String str2) throws SQLException {
        this.inner.updateNString(str, str2);
    }

    @Override // java.sql.ResultSet
    public void updateNString(int i, String str) throws SQLException {
        this.inner.updateNString(i, str);
    }

    @Override // java.sql.ResultSet
    public void updateNull(int i) throws SQLException {
        this.inner.updateNull(i);
    }

    @Override // java.sql.ResultSet
    public void updateNull(String str) throws SQLException {
        this.inner.updateNull(str);
    }

    @Override // java.sql.ResultSet
    public void updateObject(int i, Object obj) throws SQLException {
        this.inner.updateObject(i, obj);
    }

    @Override // java.sql.ResultSet
    public void updateObject(String str, Object obj) throws SQLException {
        this.inner.updateObject(str, obj);
    }

    @Override // java.sql.ResultSet
    public void updateObject(String str, Object obj, int i) throws SQLException {
        this.inner.updateObject(str, obj, i);
    }

    @Override // java.sql.ResultSet
    public void updateObject(int i, Object obj, int i2) throws SQLException {
        this.inner.updateObject(i, obj, i2);
    }

    @Override // java.sql.ResultSet
    public void updateRef(int i, Ref ref) throws SQLException {
        this.inner.updateRef(i, ref);
    }

    @Override // java.sql.ResultSet
    public void updateRef(String str, Ref ref) throws SQLException {
        this.inner.updateRef(str, ref);
    }

    @Override // java.sql.ResultSet
    public void updateRow() throws SQLException {
        this.inner.updateRow();
    }

    @Override // java.sql.ResultSet
    public void updateRowId(int i, RowId rowId) throws SQLException {
        this.inner.updateRowId(i, rowId);
    }

    @Override // java.sql.ResultSet
    public void updateRowId(String str, RowId rowId) throws SQLException {
        this.inner.updateRowId(str, rowId);
    }

    @Override // java.sql.ResultSet
    public void updateSQLXML(int i, SQLXML sqlxml) throws SQLException {
        this.inner.updateSQLXML(i, sqlxml);
    }

    @Override // java.sql.ResultSet
    public void updateSQLXML(String str, SQLXML sqlxml) throws SQLException {
        this.inner.updateSQLXML(str, sqlxml);
    }

    @Override // java.sql.ResultSet
    public void updateShort(String str, short s) throws SQLException {
        this.inner.updateShort(str, s);
    }

    @Override // java.sql.ResultSet
    public void updateShort(int i, short s) throws SQLException {
        this.inner.updateShort(i, s);
    }

    @Override // java.sql.ResultSet
    public void updateString(String str, String str2) throws SQLException {
        this.inner.updateString(str, str2);
    }

    @Override // java.sql.ResultSet
    public void updateString(int i, String str) throws SQLException {
        this.inner.updateString(i, str);
    }

    @Override // java.sql.ResultSet
    public void updateTime(String str, Time time) throws SQLException {
        this.inner.updateTime(str, time);
    }

    @Override // java.sql.ResultSet
    public void updateTime(int i, Time time) throws SQLException {
        this.inner.updateTime(i, time);
    }

    @Override // java.sql.ResultSet
    public void updateTimestamp(String str, Timestamp timestamp) throws SQLException {
        this.inner.updateTimestamp(str, timestamp);
    }

    @Override // java.sql.ResultSet
    public void updateTimestamp(int i, Timestamp timestamp) throws SQLException {
        this.inner.updateTimestamp(i, timestamp);
    }

    @Override // java.sql.ResultSet
    public boolean wasNull() throws SQLException {
        return this.inner.wasNull();
    }

    public Object getObject(int i, Class cls) throws SQLException {
        return this.inner.getObject(i, cls);
    }

    @Override // java.sql.ResultSet
    public Object getObject(String str) throws SQLException {
        return this.inner.getObject(str);
    }

    public Object getObject(String str, Class cls) throws SQLException {
        return this.inner.getObject(str, cls);
    }

    @Override // java.sql.ResultSet
    public Object getObject(int i, Map map) throws SQLException {
        return this.inner.getObject(i, map);
    }

    @Override // java.sql.ResultSet
    public Object getObject(String str, Map map) throws SQLException {
        return this.inner.getObject(str, map);
    }

    @Override // java.sql.ResultSet
    public Object getObject(int i) throws SQLException {
        return this.inner.getObject(i);
    }

    @Override // java.sql.ResultSet
    public boolean getBoolean(String str) throws SQLException {
        return this.inner.getBoolean(str);
    }

    @Override // java.sql.ResultSet
    public boolean getBoolean(int i) throws SQLException {
        return this.inner.getBoolean(i);
    }

    @Override // java.sql.ResultSet
    public byte getByte(int i) throws SQLException {
        return this.inner.getByte(i);
    }

    @Override // java.sql.ResultSet
    public byte getByte(String str) throws SQLException {
        return this.inner.getByte(str);
    }

    @Override // java.sql.ResultSet
    public short getShort(String str) throws SQLException {
        return this.inner.getShort(str);
    }

    @Override // java.sql.ResultSet
    public short getShort(int i) throws SQLException {
        return this.inner.getShort(i);
    }

    @Override // java.sql.ResultSet
    public int getInt(String str) throws SQLException {
        return this.inner.getInt(str);
    }

    @Override // java.sql.ResultSet
    public int getInt(int i) throws SQLException {
        return this.inner.getInt(i);
    }

    @Override // java.sql.ResultSet
    public long getLong(String str) throws SQLException {
        return this.inner.getLong(str);
    }

    @Override // java.sql.ResultSet
    public long getLong(int i) throws SQLException {
        return this.inner.getLong(i);
    }

    @Override // java.sql.ResultSet
    public float getFloat(int i) throws SQLException {
        return this.inner.getFloat(i);
    }

    @Override // java.sql.ResultSet
    public float getFloat(String str) throws SQLException {
        return this.inner.getFloat(str);
    }

    @Override // java.sql.ResultSet
    public double getDouble(int i) throws SQLException {
        return this.inner.getDouble(i);
    }

    @Override // java.sql.ResultSet
    public double getDouble(String str) throws SQLException {
        return this.inner.getDouble(str);
    }

    @Override // java.sql.ResultSet
    public byte[] getBytes(String str) throws SQLException {
        return this.inner.getBytes(str);
    }

    @Override // java.sql.ResultSet
    public byte[] getBytes(int i) throws SQLException {
        return this.inner.getBytes(i);
    }

    @Override // java.sql.ResultSet
    public Array getArray(int i) throws SQLException {
        return this.inner.getArray(i);
    }

    @Override // java.sql.ResultSet
    public Array getArray(String str) throws SQLException {
        return this.inner.getArray(str);
    }

    @Override // java.sql.ResultSet
    public boolean next() throws SQLException {
        return this.inner.next();
    }

    @Override // java.sql.ResultSet
    public URL getURL(int i) throws SQLException {
        return this.inner.getURL(i);
    }

    @Override // java.sql.ResultSet
    public URL getURL(String str) throws SQLException {
        return this.inner.getURL(str);
    }

    @Override // java.sql.ResultSet, java.lang.AutoCloseable
    public void close() throws SQLException {
        this.inner.close();
    }

    @Override // java.sql.ResultSet
    public int getType() throws SQLException {
        return this.inner.getType();
    }

    @Override // java.sql.ResultSet
    public boolean previous() throws SQLException {
        return this.inner.previous();
    }

    @Override // java.sql.ResultSet
    public Ref getRef(String str) throws SQLException {
        return this.inner.getRef(str);
    }

    @Override // java.sql.ResultSet
    public Ref getRef(int i) throws SQLException {
        return this.inner.getRef(i);
    }

    @Override // java.sql.ResultSet
    public String getString(int i) throws SQLException {
        return this.inner.getString(i);
    }

    @Override // java.sql.ResultSet
    public String getString(String str) throws SQLException {
        return this.inner.getString(str);
    }

    @Override // java.sql.ResultSet
    public Date getDate(int i, Calendar calendar) throws SQLException {
        return this.inner.getDate(i, calendar);
    }

    @Override // java.sql.ResultSet
    public Date getDate(String str, Calendar calendar) throws SQLException {
        return this.inner.getDate(str, calendar);
    }

    @Override // java.sql.ResultSet
    public Date getDate(String str) throws SQLException {
        return this.inner.getDate(str);
    }

    @Override // java.sql.ResultSet
    public Date getDate(int i) throws SQLException {
        return this.inner.getDate(i);
    }

    @Override // java.sql.ResultSet
    public Time getTime(int i) throws SQLException {
        return this.inner.getTime(i);
    }

    @Override // java.sql.ResultSet
    public Time getTime(String str, Calendar calendar) throws SQLException {
        return this.inner.getTime(str, calendar);
    }

    @Override // java.sql.ResultSet
    public Time getTime(String str) throws SQLException {
        return this.inner.getTime(str);
    }

    @Override // java.sql.ResultSet
    public Time getTime(int i, Calendar calendar) throws SQLException {
        return this.inner.getTime(i, calendar);
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(int i) throws SQLException {
        return this.inner.getTimestamp(i);
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(String str) throws SQLException {
        return this.inner.getTimestamp(str);
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(String str, Calendar calendar) throws SQLException {
        return this.inner.getTimestamp(str, calendar);
    }

    @Override // java.sql.ResultSet
    public Timestamp getTimestamp(int i, Calendar calendar) throws SQLException {
        return this.inner.getTimestamp(i, calendar);
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
