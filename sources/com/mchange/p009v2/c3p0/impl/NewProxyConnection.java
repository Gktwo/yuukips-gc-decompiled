package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.C3P0ProxyConnection;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.sql.SqlUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

/* renamed from: com.mchange.v2.c3p0.impl.NewProxyConnection */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/NewProxyConnection.class */
public final class NewProxyConnection implements Connection, C3P0ProxyConnection {
    protected Connection inner;
    boolean txn_known_resolved;
    DatabaseMetaData metaData;
    private static final MLogger logger = MLog.getLogger("com.mchange.v2.c3p0.impl.NewProxyConnection");
    volatile NewPooledConnection parentPooledConnection;
    ConnectionEventListener cel;

    private void __setInner(Connection inner) {
        this.inner = inner;
    }

    NewProxyConnection(Connection inner) {
        this.txn_known_resolved = true;
        this.metaData = null;
        this.cel = new ConnectionEventListener() { // from class: com.mchange.v2.c3p0.impl.NewProxyConnection.1
            @Override // javax.sql.ConnectionEventListener
            public void connectionErrorOccurred(ConnectionEvent evt) {
            }

            @Override // javax.sql.ConnectionEventListener
            public void connectionClosed(ConnectionEvent evt) {
                NewProxyConnection.this.detach();
            }
        };
        __setInner(inner);
    }

    @Override // java.sql.Connection
    public synchronized void setReadOnly(boolean a) throws SQLException {
        try {
            this.inner.setReadOnly(a);
            this.parentPooledConnection.markNewReadOnly(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public synchronized void close() throws SQLException {
        try {
            if (!isDetached()) {
                NewPooledConnection npc = this.parentPooledConnection;
                detach();
                npc.markClosedProxyConnection(this, this.txn_known_resolved);
                this.inner = null;
            } else if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, this + ": close() called more than once.");
            }
        } catch (NullPointerException exc) {
            if (!isDetached()) {
                throw exc;
            } else if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, this + ": close() called more than once.");
            }
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized boolean isReadOnly() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.isReadOnly();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Statement createStatement(int a, int b, int c) throws SQLException {
        try {
            this.txn_known_resolved = false;
            Statement innerStmt = this.inner.createStatement(a, b, c);
            this.parentPooledConnection.markActiveUncachedStatement(innerStmt);
            return new NewProxyStatement(innerStmt, this.parentPooledConnection, false, this);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Statement createStatement() throws SQLException {
        try {
            this.txn_known_resolved = false;
            Statement innerStmt = this.inner.createStatement();
            this.parentPooledConnection.markActiveUncachedStatement(innerStmt);
            return new NewProxyStatement(innerStmt, this.parentPooledConnection, false, this);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Statement createStatement(int a, int b) throws SQLException {
        try {
            this.txn_known_resolved = false;
            Statement innerStmt = this.inner.createStatement(a, b);
            this.parentPooledConnection.markActiveUncachedStatement(innerStmt);
            return new NewProxyStatement(innerStmt, this.parentPooledConnection, false, this);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0083
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.PreparedStatement prepareStatement(java.lang.String r8, int r9, int r10, int r11) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareStatement(java.lang.String, int, int, int):java.sql.PreparedStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0071
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.PreparedStatement prepareStatement(java.lang.String r8, int r9, int r10) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareStatement(java.lang.String, int, int):java.sql.PreparedStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x004b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.PreparedStatement prepareStatement(java.lang.String r8) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareStatement(java.lang.String):java.sql.PreparedStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0056
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.PreparedStatement prepareStatement(java.lang.String r8, int[] r9) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareStatement(java.lang.String, int[]):java.sql.PreparedStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x005e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.PreparedStatement prepareStatement(java.lang.String r8, int r9) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareStatement(java.lang.String, int):java.sql.PreparedStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0056
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.PreparedStatement prepareStatement(java.lang.String r8, java.lang.String[] r9) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareStatement(java.lang.String, java.lang.String[]):java.sql.PreparedStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0071
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.CallableStatement prepareCall(java.lang.String r8, int r9, int r10) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareCall(java.lang.String, int, int):java.sql.CallableStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x004b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.CallableStatement prepareCall(java.lang.String r8) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareCall(java.lang.String):java.sql.CallableStatement");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0083
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized java.sql.CallableStatement prepareCall(java.lang.String r8, int r9, int r10, int r11) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.prepareCall(java.lang.String, int, int, int):java.sql.CallableStatement");
    }

    @Override // java.sql.Connection
    public synchronized DatabaseMetaData getMetaData() throws SQLException {
        try {
            this.txn_known_resolved = false;
            if (this.metaData == null) {
                this.metaData = new NewProxyDatabaseMetaData(this.inner.getMetaData(), this.parentPooledConnection, this);
            }
            return this.metaData;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void setTransactionIsolation(int a) throws SQLException {
        try {
            this.inner.setTransactionIsolation(a);
            this.parentPooledConnection.markNewTxnIsolation(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void setCatalog(String a) throws SQLException {
        try {
            this.inner.setCatalog(a);
            this.parentPooledConnection.markNewCatalog(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void setHoldability(int a) throws SQLException {
        try {
            this.inner.setHoldability(a);
            this.parentPooledConnection.markNewHoldability(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void setTypeMap(Map a) throws SQLException {
        try {
            this.inner.setTypeMap(a);
            this.parentPooledConnection.markNewTypeMap(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized SQLWarning getWarnings() throws SQLException {
        try {
            return this.inner.getWarnings();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void clearWarnings() throws SQLException {
        try {
            this.inner.clearWarnings();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized boolean isClosed() throws SQLException {
        try {
            return isDetached();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void commit() throws SQLException {
        try {
            this.inner.commit();
            this.txn_known_resolved = true;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void rollback(Savepoint a) throws SQLException {
        try {
            this.inner.rollback(a);
            this.txn_known_resolved = true;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void rollback() throws SQLException {
        try {
            this.inner.rollback();
            this.txn_known_resolved = true;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void setAutoCommit(boolean a) throws SQLException {
        try {
            this.inner.setAutoCommit(a);
            this.txn_known_resolved = true;
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
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
        jadx.core.utils.exceptions.JadxRuntimeException: Try blocks wrapping queue limit reached! Please report as an issue!
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:88)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:452)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized void setClientInfo(java.lang.String r5, java.lang.String r6) throws java.sql.SQLClientInfoException {
        /*
            r4 = this;
            r0 = r4
            r1 = 0
            r0.txn_known_resolved = r1     // Catch: NullPointerException -> 0x0013, Exception -> 0x0024, Exception -> 0x003d
            r0 = r4
            java.sql.Connection r0 = r0.inner     // Catch: NullPointerException -> 0x0013, Exception -> 0x0024, Exception -> 0x003d
            r1 = r5
            r2 = r6
            r0.setClientInfo(r1, r2)     // Catch: NullPointerException -> 0x0013, Exception -> 0x0024, Exception -> 0x003d
            goto L_0x003a
        L_0x0013:
            r7 = move-exception
            r0 = r4
            boolean r0 = r0.isDetached()     // Catch: Exception -> 0x003d
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = "You can't operate on a closed Connection!!!"
            r1 = r7
            java.sql.SQLException r0 = com.mchange.p009v2.sql.SqlUtils.toSQLException(r0, r1)     // Catch: Exception -> 0x003d
            throw r0     // Catch: Exception -> 0x003d
        L_0x0022:
            r0 = r7
            throw r0     // Catch: Exception -> 0x003d
        L_0x0024:
            r7 = move-exception
            r0 = r4
            boolean r0 = r0.isDetached()     // Catch: Exception -> 0x003d
            if (r0 != 0) goto L_0x0035
            r0 = r4
            com.mchange.v2.c3p0.impl.NewPooledConnection r0 = r0.parentPooledConnection     // Catch: Exception -> 0x003d
            r1 = r7
            java.sql.SQLException r0 = r0.handleThrowable(r1)     // Catch: Exception -> 0x003d
            throw r0     // Catch: Exception -> 0x003d
        L_0x0035:
            r0 = r7
            java.sql.SQLException r0 = com.mchange.p009v2.sql.SqlUtils.toSQLException(r0)     // Catch: Exception -> 0x003d
            throw r0     // Catch: Exception -> 0x003d
        L_0x003a:
            goto L_0x0043
        L_0x003d:
            r7 = move-exception
            r0 = r7
            java.sql.SQLClientInfoException r0 = com.mchange.p009v2.sql.SqlUtils.toSQLClientInfoException(r0)
            throw r0
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.setClientInfo(java.lang.String, java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Try blocks wrapping queue limit reached! Please report as an issue!
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:88)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:452)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.sql.Connection
    public synchronized void setClientInfo(java.util.Properties r4) throws java.sql.SQLClientInfoException {
        /*
            r3 = this;
            r0 = r3
            r1 = 0
            r0.txn_known_resolved = r1     // Catch: NullPointerException -> 0x0012, Exception -> 0x0023, Exception -> 0x003c
            r0 = r3
            java.sql.Connection r0 = r0.inner     // Catch: NullPointerException -> 0x0012, Exception -> 0x0023, Exception -> 0x003c
            r1 = r4
            r0.setClientInfo(r1)     // Catch: NullPointerException -> 0x0012, Exception -> 0x0023, Exception -> 0x003c
            goto L_0x0039
        L_0x0012:
            r5 = move-exception
            r0 = r3
            boolean r0 = r0.isDetached()     // Catch: Exception -> 0x003c
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = "You can't operate on a closed Connection!!!"
            r1 = r5
            java.sql.SQLException r0 = com.mchange.p009v2.sql.SqlUtils.toSQLException(r0, r1)     // Catch: Exception -> 0x003c
            throw r0     // Catch: Exception -> 0x003c
        L_0x0021:
            r0 = r5
            throw r0     // Catch: Exception -> 0x003c
        L_0x0023:
            r5 = move-exception
            r0 = r3
            boolean r0 = r0.isDetached()     // Catch: Exception -> 0x003c
            if (r0 != 0) goto L_0x0034
            r0 = r3
            com.mchange.v2.c3p0.impl.NewPooledConnection r0 = r0.parentPooledConnection     // Catch: Exception -> 0x003c
            r1 = r5
            java.sql.SQLException r0 = r0.handleThrowable(r1)     // Catch: Exception -> 0x003c
            throw r0     // Catch: Exception -> 0x003c
        L_0x0034:
            r0 = r5
            java.sql.SQLException r0 = com.mchange.p009v2.sql.SqlUtils.toSQLException(r0)     // Catch: Exception -> 0x003c
            throw r0     // Catch: Exception -> 0x003c
        L_0x0039:
            goto L_0x0042
        L_0x003c:
            r5 = move-exception
            r0 = r5
            java.sql.SQLClientInfoException r0 = com.mchange.p009v2.sql.SqlUtils.toSQLClientInfoException(r0)
            throw r0
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.NewProxyConnection.setClientInfo(java.util.Properties):void");
    }

    @Override // java.sql.Connection
    public synchronized boolean isValid(int a) throws SQLException {
        try {
            if (isDetached()) {
                return false;
            }
            return this.inner.isValid(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public synchronized void abort(Executor a) throws SQLException {
        try {
            this.txn_known_resolved = false;
            this.inner.abort(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized String nativeSQL(String a) throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.nativeSQL(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized boolean getAutoCommit() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getAutoCommit();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized String getCatalog() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getCatalog();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized int getTransactionIsolation() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getTransactionIsolation();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Map getTypeMap() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getTypeMap();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized int getHoldability() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getHoldability();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Savepoint setSavepoint(String a) throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.setSavepoint(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Savepoint setSavepoint() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.setSavepoint();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized void releaseSavepoint(Savepoint a) throws SQLException {
        try {
            this.txn_known_resolved = false;
            this.inner.releaseSavepoint(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Clob createClob() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.createClob();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Blob createBlob() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.createBlob();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized NClob createNClob() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.createNClob();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized SQLXML createSQLXML() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.createSQLXML();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Properties getClientInfo() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getClientInfo();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized String getClientInfo(String a) throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getClientInfo(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Array createArrayOf(String a, Object[] b) throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.createArrayOf(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    @Override // java.sql.Connection
    public synchronized Struct createStruct(String a, Object[] b) throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.createStruct(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public synchronized void setSchema(String a) throws SQLException {
        try {
            this.txn_known_resolved = false;
            this.inner.setSchema(a);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public synchronized String getSchema() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getSchema();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public synchronized void setNetworkTimeout(Executor a, int b) throws SQLException {
        try {
            this.txn_known_resolved = false;
            this.inner.setNetworkTimeout(a, b);
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
            }
            throw exc;
        } catch (Exception exc2) {
            if (!isDetached()) {
                throw this.parentPooledConnection.handleThrowable(exc2);
            }
            throw SqlUtils.toSQLException(exc2);
        }
    }

    public synchronized int getNetworkTimeout() throws SQLException {
        try {
            this.txn_known_resolved = false;
            return this.inner.getNetworkTimeout();
        } catch (NullPointerException exc) {
            if (isDetached()) {
                throw SqlUtils.toSQLException("You can't operate on a closed Connection!!!", exc);
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
    public synchronized Object unwrap(Class a) throws SQLException {
        if (isWrapperForInner(a)) {
            return this.inner.unwrap(a);
        }
        if (isWrapperForThis(a)) {
            return this;
        }
        throw new SQLException(this + " is not a wrapper for or implementation of " + a.getName());
    }

    @Override // java.sql.Wrapper
    public synchronized boolean isWrapperFor(Class a) throws SQLException {
        return isWrapperForInner(a) || isWrapperForThis(a);
    }

    @Override // com.mchange.p009v2.c3p0.C3P0ProxyConnection
    public Object rawConnectionOperation(Method m, Object target, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
        maybeDirtyTransaction();
        if (this.inner == null) {
            throw new SQLException("You cannot operate on a closed Connection!");
        }
        if (target == C3P0ProxyConnection.RAW_CONNECTION) {
            target = this.inner;
        }
        int len = args.length;
        for (int i = 0; i < len; i++) {
            if (args[i] == C3P0ProxyConnection.RAW_CONNECTION) {
                args[i] = this.inner;
            }
        }
        Object out = m.invoke(target, args);
        if (out instanceof CallableStatement) {
            CallableStatement innerStmt = (CallableStatement) out;
            this.parentPooledConnection.markActiveUncachedStatement(innerStmt);
            out = new NewProxyCallableStatement(innerStmt, this.parentPooledConnection, false, this);
        } else if (out instanceof PreparedStatement) {
            PreparedStatement innerStmt2 = (PreparedStatement) out;
            this.parentPooledConnection.markActiveUncachedStatement(innerStmt2);
            out = new NewProxyPreparedStatement(innerStmt2, this.parentPooledConnection, false, this);
        } else if (out instanceof Statement) {
            Statement innerStmt3 = (Statement) out;
            this.parentPooledConnection.markActiveUncachedStatement(innerStmt3);
            out = new NewProxyStatement(innerStmt3, this.parentPooledConnection, false, this);
        } else if (out instanceof ResultSet) {
            ResultSet innerRs = (ResultSet) out;
            this.parentPooledConnection.markActiveRawConnectionResultSet(innerRs);
            out = new NewProxyResultSet(innerRs, this.parentPooledConnection, this.inner, this);
        } else if (out instanceof DatabaseMetaData) {
            out = new NewProxyDatabaseMetaData((DatabaseMetaData) out, this.parentPooledConnection);
        }
        return out;
    }

    /* access modifiers changed from: package-private */
    public synchronized void maybeDirtyTransaction() {
        this.txn_known_resolved = false;
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

    /* access modifiers changed from: package-private */
    public NewProxyConnection(Connection inner, NewPooledConnection parentPooledConnection) {
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
        return Connection.class == intfcl || intfcl.isAssignableFrom(this.inner.getClass());
    }

    private boolean isWrapperForThis(Class intfcl) {
        return intfcl.isAssignableFrom(getClass());
    }
}
