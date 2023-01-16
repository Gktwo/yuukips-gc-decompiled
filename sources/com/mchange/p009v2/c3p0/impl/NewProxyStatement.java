package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.C3P0ProxyStatement;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.sql.SqlUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.HashSet;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

/* renamed from: com.mchange.v2.c3p0.impl.NewProxyStatement */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/NewProxyStatement.class */
public final class NewProxyStatement implements Statement, C3P0ProxyStatement, ProxyResultSetDetachable {
    protected Statement inner;
    private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyStatement");
    volatile NewPooledConnection parentPooledConnection;
    ConnectionEventListener cel;
    boolean is_cached;
    NewProxyConnection creatorProxy;
    HashSet myProxyResultSets;

    private void __setInner(Statement inner) {
        this.inner = inner;
    }

    NewProxyStatement(Statement inner) {
        this.cel = new ConnectionEventListener() { // from class: com.mchange.v2.c3p0.impl.NewProxyStatement.1
            @Override // javax.sql.ConnectionEventListener
            public void connectionErrorOccurred(ConnectionEvent evt) {
            }

            @Override // javax.sql.ConnectionEventListener
            public void connectionClosed(ConnectionEvent evt) {
                NewProxyStatement.this.detach();
            }
        };
        this.myProxyResultSets = new HashSet();
        __setInner(inner);
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
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyStatement.close():void");
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

    NewProxyStatement(Statement inner, NewPooledConnection parentPooledConnection) {
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
        return Statement.class == intfcl || intfcl.isAssignableFrom(this.inner.getClass());
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
    public NewProxyStatement(Statement inner, NewPooledConnection parentPooledConnection, boolean cached, NewProxyConnection cProxy) {
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
