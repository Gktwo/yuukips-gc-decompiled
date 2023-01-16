package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.C3P0ProxyStatement;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.sql.SqlUtils;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

/* renamed from: com.mchange.v2.c3p0.impl.NewProxyPreparedStatement */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/NewProxyPreparedStatement.class */
public final class NewProxyPreparedStatement implements PreparedStatement, C3P0ProxyStatement, ProxyResultSetDetachable {
    protected PreparedStatement inner;
    private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyPreparedStatement");
    volatile NewPooledConnection parentPooledConnection;
    ConnectionEventListener cel;
    boolean is_cached;
    NewProxyConnection creatorProxy;
    HashSet myProxyResultSets;

    private void __setInner(PreparedStatement inner) {
        this.inner = inner;
    }

    NewProxyPreparedStatement(PreparedStatement inner) {
        this.cel = new ConnectionEventListener() { // from class: com.mchange.v2.c3p0.impl.NewProxyPreparedStatement.1
            @Override // javax.sql.ConnectionEventListener
            public void connectionErrorOccurred(ConnectionEvent evt) {
            }

            @Override // javax.sql.ConnectionEventListener
            public void connectionClosed(ConnectionEvent evt) {
                NewProxyPreparedStatement.this.detach();
            }
        };
        this.myProxyResultSets = new HashSet();
        __setInner(inner);
    }

    @Override // java.sql.PreparedStatement
    public final boolean execute() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.execute();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBoolean(int a, boolean b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBoolean(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setByte(int a, byte b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setByte(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setShort(int a, short b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setShort(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setInt(int a, int b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setInt(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setLong(int a, long b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setLong(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setFloat(int a, float b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setFloat(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setDouble(int a, double b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setDouble(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setTimestamp(int a, Timestamp b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setTimestamp(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setTimestamp(int a, Timestamp b, Calendar c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setTimestamp(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final ResultSetMetaData getMetaData() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getMetaData();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setTime(int a, Time b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setTime(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setTime(int a, Time b, Calendar c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setTime(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setURL(int a, URL b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setURL(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final ResultSet executeQuery() throws SQLException {
        try {
            maybeDirtyTransaction();
            ResultSet innerResultSet = this.inner.executeQuery();
            if (innerResultSet == null) {
                return null;
            }
            this.parentPooledConnection.markActiveResultSetForStatement(this.inner, innerResultSet);
            NewProxyResultSet out = new NewProxyResultSet(innerResultSet, this.parentPooledConnection, this.inner, this);
            synchronized (this.myProxyResultSets) {
                this.myProxyResultSets.add(out);
            }
            return out;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final int executeUpdate() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeUpdate();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void addBatch() throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.addBatch();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long executeLargeUpdate() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeLargeUpdate();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNull(int a, int b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNull(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNull(int a, int b, String c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNull(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBigDecimal(int a, BigDecimal b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBigDecimal(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setString(int a, String b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setString(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBytes(int a, byte[] b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBytes(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setDate(int a, Date b, Calendar c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setDate(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setDate(int a, Date b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setDate(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setAsciiStream(int a, InputStream b, int c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setAsciiStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setAsciiStream(int a, InputStream b, long c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setAsciiStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setAsciiStream(int a, InputStream b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setAsciiStream(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setUnicodeStream(int a, InputStream b, int c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setUnicodeStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBinaryStream(int a, InputStream b, int c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBinaryStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBinaryStream(int a, InputStream b, long c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBinaryStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBinaryStream(int a, InputStream b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBinaryStream(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void clearParameters() throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.clearParameters();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setObject(int a, Object b, int c, int d) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setObject(a, b, c, d);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final void setObject(int a, Object b, SQLType c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setObject(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final void setObject(int a, Object b, SQLType c, int d) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setObject(a, b, c, d);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setObject(int a, Object b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setObject(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setObject(int a, Object b, int c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setObject(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setCharacterStream(int a, Reader b, int c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setCharacterStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setCharacterStream(int a, Reader b, long c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setCharacterStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setCharacterStream(int a, Reader b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setCharacterStream(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setRef(int a, Ref b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setRef(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBlob(int a, InputStream b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBlob(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBlob(int a, InputStream b, long c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBlob(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setBlob(int a, Blob b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setBlob(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setClob(int a, Reader b, long c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setClob(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setClob(int a, Reader b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setClob(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setClob(int a, Clob b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setClob(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setArray(int a, Array b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setArray(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final ParameterMetaData getParameterMetaData() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getParameterMetaData();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setRowId(int a, RowId b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setRowId(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNString(int a, String b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNString(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNCharacterStream(int a, Reader b, long c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNCharacterStream(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNCharacterStream(int a, Reader b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNCharacterStream(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNClob(int a, Reader b, long c) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNClob(a, b, c);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNClob(int a, NClob b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNClob(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setNClob(int a, Reader b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setNClob(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.PreparedStatement
    public final void setSQLXML(int a, SQLXML b) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setSQLXML(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean execute(String a, String[] b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.execute(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean execute(String a) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.execute(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean execute(String a, int b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.execute(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean execute(String a, int[] b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.execute(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:32:0x00c6
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Statement, java.lang.AutoCloseable
    public final void close() throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyPreparedStatement.close():void");
    }

    @Override // java.sql.Statement
    public final SQLWarning getWarnings() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getWarnings();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void clearWarnings() throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.clearWarnings();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean isClosed() throws SQLException {
        try {
            maybeDirtyTransaction();
            return isDetached();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final Connection getConnection() throws SQLException {
        try {
            maybeDirtyTransaction();
            if (!isDetached()) {
                return this.creatorProxy;
            }
            throw new SQLException("You cannot operate on a closed Statement!");
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final ResultSet executeQuery(String a) throws SQLException {
        try {
            maybeDirtyTransaction();
            ResultSet innerResultSet = this.inner.executeQuery(a);
            if (innerResultSet == null) {
                return null;
            }
            this.parentPooledConnection.markActiveResultSetForStatement(this.inner, innerResultSet);
            NewProxyResultSet out = new NewProxyResultSet(innerResultSet, this.parentPooledConnection, this.inner, this);
            synchronized (this.myProxyResultSets) {
                this.myProxyResultSets.add(out);
            }
            return out;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int executeUpdate(String a, int[] b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeUpdate(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int executeUpdate(String a, int b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeUpdate(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int executeUpdate(String a) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeUpdate(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int executeUpdate(String a, String[] b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeUpdate(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getMaxFieldSize() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getMaxFieldSize();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setMaxFieldSize(int a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setMaxFieldSize(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getMaxRows() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getMaxRows();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setMaxRows(int a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setMaxRows(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setEscapeProcessing(boolean a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setEscapeProcessing(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getQueryTimeout() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getQueryTimeout();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setQueryTimeout(int a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setQueryTimeout(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void cancel() throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.cancel();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setCursorName(String a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setCursorName(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final ResultSet getResultSet() throws SQLException {
        try {
            maybeDirtyTransaction();
            ResultSet innerResultSet = this.inner.getResultSet();
            if (innerResultSet == null) {
                return null;
            }
            this.parentPooledConnection.markActiveResultSetForStatement(this.inner, innerResultSet);
            NewProxyResultSet out = new NewProxyResultSet(innerResultSet, this.parentPooledConnection, this.inner, this);
            synchronized (this.myProxyResultSets) {
                this.myProxyResultSets.add(out);
            }
            return out;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getUpdateCount() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getUpdateCount();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean getMoreResults(int a) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getMoreResults(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean getMoreResults() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getMoreResults();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setFetchDirection(int a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setFetchDirection(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getFetchDirection() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getFetchDirection();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setFetchSize(int a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setFetchSize(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getFetchSize() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getFetchSize();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getResultSetConcurrency() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getResultSetConcurrency();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getResultSetType() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getResultSetType();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void addBatch(String a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.addBatch(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void clearBatch() throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.clearBatch();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int[] executeBatch() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeBatch();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final ResultSet getGeneratedKeys() throws SQLException {
        try {
            maybeDirtyTransaction();
            ResultSet innerResultSet = this.inner.getGeneratedKeys();
            if (innerResultSet == null) {
                return null;
            }
            this.parentPooledConnection.markActiveResultSetForStatement(this.inner, innerResultSet);
            NewProxyResultSet out = new NewProxyResultSet(innerResultSet, this.parentPooledConnection, this.inner, this);
            synchronized (this.myProxyResultSets) {
                this.myProxyResultSets.add(out);
            }
            return out;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final int getResultSetHoldability() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getResultSetHoldability();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final void setPoolable(boolean a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setPoolable(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Statement
    public final boolean isPoolable() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.isPoolable();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final void closeOnCompletion() throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.closeOnCompletion();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final boolean isCloseOnCompletion() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.isCloseOnCompletion();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long getLargeUpdateCount() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getLargeUpdateCount();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final void setLargeMaxRows(long a) throws SQLException {
        try {
            maybeDirtyTransaction();
            this.inner.setLargeMaxRows(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long getLargeMaxRows() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.getLargeMaxRows();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long[] executeLargeBatch() throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeLargeBatch();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long executeLargeUpdate(String a, String[] b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeLargeUpdate(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long executeLargeUpdate(String a, int[] b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeLargeUpdate(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long executeLargeUpdate(String a, int b) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeLargeUpdate(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public final long executeLargeUpdate(String a) throws SQLException {
        try {
            maybeDirtyTransaction();
            return this.inner.executeLargeUpdate(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Statement!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Wrapper
    public final Object unwrap(Class a) throws SQLException {
        if (isWrapperForInner(a)) {
            return this.inner.unwrap(a);
        }
        if (isWrapperForThis(a)) {
            return this;
        }
        throw new SQLException(this + " is not a wrapper for or implementation of " + a.getName());
    }

    @Override // java.sql.Wrapper
    public final boolean isWrapperFor(Class a) throws SQLException {
        return isWrapperForInner(a) || isWrapperForThis(a);
    }

    void attach(NewPooledConnection parentPooledConnection) {
        this.parentPooledConnection = parentPooledConnection;
        parentPooledConnection.addConnectionEventListener(this.cel);
    }

    /* access modifiers changed from: private */
    public void detach() {
        this.parentPooledConnection.removeConnectionEventListener(this.cel);
        this.parentPooledConnection = null;
    }

    NewProxyPreparedStatement(PreparedStatement inner, NewPooledConnection parentPooledConnection) {
        this(inner);
        attach(parentPooledConnection);
    }

    boolean isDetached() {
        return this.parentPooledConnection == null;
    }

    @Override // java.lang.Object
    public String toString() {
        return toString() + " [wrapping: " + this.inner + "]";
    }

    private boolean isWrapperForInner(Class intfcl) {
        return PreparedStatement.class == intfcl || intfcl.isAssignableFrom(this.inner.getClass());
    }

    private boolean isWrapperForThis(Class intfcl) {
        return intfcl.isAssignableFrom(getClass());
    }

    @Override // com.mchange.p009v2.c3p0.impl.ProxyResultSetDetachable
    public void detachProxyResultSet(ResultSet prs) {
        synchronized (this.myProxyResultSets) {
            this.myProxyResultSets.remove(prs);
        }
    }

    /* access modifiers changed from: package-private */
    public NewProxyPreparedStatement(PreparedStatement inner, NewPooledConnection parentPooledConnection, boolean cached, NewProxyConnection cProxy) {
        this(inner, parentPooledConnection);
        this.is_cached = cached;
        this.creatorProxy = cProxy;
    }

    @Override // com.mchange.p009v2.c3p0.C3P0ProxyStatement
    public Object rawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
        maybeDirtyTransaction();
        if (target == C3P0ProxyStatement.RAW_STATEMENT) {
            target = this.inner;
        }
        int len = args.length;
        for (int i = 0; i < len; i++) {
            if (args[i] == C3P0ProxyStatement.RAW_STATEMENT) {
                args[i] = this.inner;
            }
        }
        Object out = m.invoke(target, args);
        if (out instanceof ResultSet) {
            ResultSet innerResultSet = (ResultSet) out;
            this.parentPooledConnection.markActiveResultSetForStatement(this.inner, innerResultSet);
            out = new NewProxyResultSet(innerResultSet, this.parentPooledConnection, this.inner, this);
        }
        return out;
    }

    void maybeDirtyTransaction() {
        if (this.creatorProxy != null) {
            this.creatorProxy.maybeDirtyTransaction();
        }
    }
}
