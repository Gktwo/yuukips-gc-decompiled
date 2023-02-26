package com.mchange.p009v2.c3p0.stmt;

import com.mchange.p006v1.p007db.sql.StatementUtils;
import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.p010io.IndentedWriter;
import com.mchange.p009v2.sql.SqlUtils;
import com.mchange.p009v2.util.ResourceClosedException;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache.class */
public abstract class GooGooStatementCache {
    private static final MLogger logger = MLog.getLogger(GooGooStatementCache.class);
    private static final int DESTROY_NEVER = 0;
    private static final int DESTROY_IF_CHECKED_IN = 1;
    private static final int DESTROY_IF_CHECKED_OUT = 2;
    private static final int DESTROY_ALWAYS = 3;
    private static final boolean CULL_ONLY_FROM_UNUSED_CONNECTIONS = false;
    AsynchronousRunner blockingTaskAsyncRunner;
    StatementDestructionManager destructo;
    HashMap stmtToKey = new HashMap();
    HashMap keyToKeyRec = new HashMap();
    HashSet checkedOut = new HashSet();
    HashSet removalPending = new HashSet();
    ConnectionStatementManager cxnStmtMgr = createConnectionStatementManager();

    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$SimpleConnectionStatementManager */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$SimpleConnectionStatementManager.class */
    protected static final class SimpleConnectionStatementManager extends ConnectionStatementManager {
    }

    abstract ConnectionStatementManager createConnectionStatementManager();

    abstract boolean prepareAssimilateNewStatement(Connection connection);

    abstract void addStatementToDeathmarches(Object obj, Connection connection);

    abstract void removeStatementFromDeathmarches(Object obj, Connection connection);

    public GooGooStatementCache(AsynchronousRunner blockingTaskAsyncRunner, AsynchronousRunner deferredStatementDestroyer) {
        this.blockingTaskAsyncRunner = blockingTaskAsyncRunner;
        this.destructo = deferredStatementDestroyer != null ? new CautiousStatementDestructionManager(deferredStatementDestroyer) : new IncautiousStatementDestructionManager(blockingTaskAsyncRunner);
    }

    public synchronized int getNumStatements() {
        if (isClosed()) {
            return -1;
        }
        return countCachedStatements();
    }

    public synchronized int getNumStatementsCheckedOut() {
        if (isClosed()) {
            return -1;
        }
        return this.checkedOut.size();
    }

    public synchronized int getNumConnectionsWithCachedStatements() {
        if (isClosed()) {
            return -1;
        }
        return this.cxnStmtMgr.getNumConnectionsWithCachedStatements();
    }

    public synchronized String dumpStatementCacheStatus() {
        if (isClosed()) {
            return this + "status: Closed.";
        }
        StringWriter sw = new StringWriter(2048);
        IndentedWriter iw = new IndentedWriter(sw);
        try {
            iw.print(this);
            iw.println(" status:");
            iw.upIndent();
            iw.println("core stats:");
            iw.upIndent();
            iw.print("num cached statements: ");
            iw.println(countCachedStatements());
            iw.print("num cached statements in use: ");
            iw.println(this.checkedOut.size());
            iw.print("num connections with cached statements: ");
            iw.println(this.cxnStmtMgr.getNumConnectionsWithCachedStatements());
            iw.downIndent();
            iw.println("cached statement dump:");
            iw.upIndent();
            for (Connection pcon : this.cxnStmtMgr.connectionSet()) {
                iw.print(pcon);
                iw.println(':');
                iw.upIndent();
                for (Object obj : this.cxnStmtMgr.statementSet(pcon)) {
                    iw.println(obj);
                }
                iw.downIndent();
            }
            iw.downIndent();
            iw.downIndent();
            return sw.toString();
        } catch (IOException e) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, "Huh? We've seen an IOException writing to s StringWriter?!", (Throwable) e);
            }
            return e.toString();
        }
    }

    public void waitMarkConnectionInUse(Connection physicalConnection) throws InterruptedException {
        this.destructo.waitMarkConnectionInUse(physicalConnection);
    }

    public boolean tryMarkConnectionInUse(Connection physicalConnection) {
        return this.destructo.tryMarkConnectionInUse(physicalConnection);
    }

    public void unmarkConnectionInUse(Connection physicalConnection) {
        this.destructo.unmarkConnectionInUse(physicalConnection);
    }

    public Boolean inUse(Connection physicalConnection) {
        return this.destructo.tvlInUse(physicalConnection);
    }

    public int getStatementDestroyerNumConnectionsInUse() {
        return this.destructo.getNumConnectionsInUse();
    }

    public int getStatementDestroyerNumConnectionsWithDeferredDestroyStatements() {
        return this.destructo.getNumConnectionsWithDeferredDestroyStatements();
    }

    public int getStatementDestroyerNumDeferredDestroyStatements() {
        return this.destructo.getNumDeferredDestroyStatements();
    }

    public synchronized Object checkoutStatement(Connection physicalConnection, Method stmtProducingMethod, Object[] args) throws SQLException, ResourceClosedException {
        Object out;
        try {
            StatementCacheKey key = StatementCacheKey.find(physicalConnection, stmtProducingMethod, args);
            LinkedList l = checkoutQueue(key);
            if (l == null || l.isEmpty()) {
                out = acquireStatement(physicalConnection, stmtProducingMethod, args);
                if (prepareAssimilateNewStatement(physicalConnection)) {
                    assimilateNewCheckedOutStatement(key, physicalConnection, out);
                }
            } else {
                logger.finest(getClass().getName() + " ----> CACHE HIT");
                out = l.get(0);
                l.remove(0);
                if (!this.checkedOut.add(out)) {
                    throw new RuntimeException("Internal inconsistency: Checking out a statement marked as already checked out!");
                }
                removeStatementFromDeathmarches(out, physicalConnection);
            }
            if (logger.isLoggable(MLevel.FINEST)) {
                logger.finest("checkoutStatement: " + statsString());
            }
            return out;
        } catch (NullPointerException npe) {
            if (this.checkedOut == null) {
                if (logger.isLoggable(MLevel.FINE)) {
                    logger.log(MLevel.FINE, "A client attempted to work with a closed Statement cache, provoking a NullPointerException. c3p0 recovers, but this should be rare.", (Throwable) npe);
                }
                throw new ResourceClosedException(npe);
            }
            throw npe;
        }
    }

    public synchronized void checkinStatement(Object pstmt) throws SQLException {
        if (this.checkedOut == null) {
            this.destructo.synchronousDestroyStatement(pstmt);
        } else if (this.checkedOut.remove(pstmt)) {
            try {
                refreshStatement((PreparedStatement) pstmt);
                StatementCacheKey key = (StatementCacheKey) this.stmtToKey.get(pstmt);
                if (key == null) {
                    throw new RuntimeException("Internal inconsistency: A checked-out statement has no key associated with it!");
                }
                checkoutQueue(key).add(pstmt);
                addStatementToDeathmarches(pstmt, key.physicalConnection);
                if (logger.isLoggable(MLevel.FINEST)) {
                    logger.finest("checkinStatement(): " + statsString());
                }
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.INFO)) {
                    logger.log(MLevel.INFO, "Problem with checked-in Statement, discarding.", (Throwable) e);
                }
                this.checkedOut.add(pstmt);
                removeStatement(pstmt, 3);
            }
        } else if (!ourResource(pstmt)) {
            this.destructo.uncheckedDestroyStatement(pstmt);
        }
    }

    public synchronized void checkinAll(Connection pcon) throws SQLException {
        Set stmtSet = this.cxnStmtMgr.statementSet(pcon);
        if (stmtSet != null) {
            for (Object stmt : stmtSet) {
                if (this.checkedOut.contains(stmt)) {
                    checkinStatement(stmt);
                }
            }
        }
        if (logger.isLoggable(MLevel.FINEST)) {
            logger.log(MLevel.FINEST, "checkinAll(): " + statsString());
        }
    }

    public void closeAll(Connection pcon) throws SQLException {
        if (!isClosed()) {
            if (logger.isLoggable(MLevel.FINEST)) {
                logger.log(MLevel.FINEST, "ENTER METHOD: closeAll( " + pcon + " )! -- num_connections: " + this.cxnStmtMgr.getNumConnectionsWithCachedStatements());
            }
            Set<Object> stmtSet = null;
            synchronized (this) {
                Set cSet = this.cxnStmtMgr.statementSet(pcon);
                if (cSet != null) {
                    stmtSet = new HashSet(cSet);
                    for (Object stmt : stmtSet) {
                        removeStatement(stmt, 0);
                    }
                }
            }
            if (stmtSet != null) {
                for (Object stmt2 : stmtSet) {
                    this.destructo.synchronousDestroyStatement(stmt2);
                }
            }
            if (logger.isLoggable(MLevel.FINEST)) {
                logger.finest("closeAll(): " + statsString());
            }
        }
    }

    public synchronized void close() throws SQLException {
        if (!isClosed()) {
            for (Object obj : this.stmtToKey.keySet()) {
                this.destructo.synchronousDestroyStatement(obj);
            }
            this.destructo.close();
            this.cxnStmtMgr = null;
            this.stmtToKey = null;
            this.keyToKeyRec = null;
            this.checkedOut = null;
        } else if (logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, this + ": duplicate call to close() [not harmful! -- debug only!]", (Throwable) new Exception("DUPLICATE CLOSE DEBUG STACK TRACE."));
        }
    }

    public synchronized boolean isClosed() {
        return this.cxnStmtMgr == null;
    }

    final int countCachedStatements() {
        return this.stmtToKey.size();
    }

    private void assimilateNewCheckedOutStatement(StatementCacheKey key, Connection pConn, Object ps) {
        this.stmtToKey.put(ps, key);
        if (keySet(key) == null) {
            this.keyToKeyRec.put(key, new KeyRec());
        } else {
            if (logger.isLoggable(MLevel.INFO)) {
                logger.info("Multiply-cached PreparedStatement: " + key.stmtText);
            }
            if (logger.isLoggable(MLevel.FINE)) {
                logger.fine("(The same statement has already been prepared by this Connection, and that other instance has not yet been closed, so the statement pool has to prepare a second PreparedStatement object rather than reusing the previously-cached Statement. The new Statement will be cached, in case you frequently need multiple copies of this Statement.)");
            }
        }
        keySet(key).add(ps);
        this.cxnStmtMgr.addStatementForConnection(ps, pConn);
        if (logger.isLoggable(MLevel.FINEST)) {
            logger.finest("cxnStmtMgr.statementSet( " + pConn + " ).size(): " + this.cxnStmtMgr.statementSet(pConn).size());
        }
        this.checkedOut.add(ps);
    }

    /* access modifiers changed from: private */
    public void removeStatement(Object ps, int destruction_policy) {
        synchronized (this.removalPending) {
            if (!this.removalPending.contains(ps)) {
                this.removalPending.add(ps);
                StatementCacheKey sck = (StatementCacheKey) this.stmtToKey.remove(ps);
                removeFromKeySet(sck, ps);
                Connection pConn = sck.physicalConnection;
                if (!this.checkedOut.contains(ps)) {
                    removeStatementFromDeathmarches(ps, pConn);
                    removeFromCheckoutQueue(sck, ps);
                    if ((destruction_policy & 1) != 0) {
                        this.destructo.deferredDestroyStatement(pConn, ps);
                    }
                } else {
                    this.checkedOut.remove(ps);
                    if ((destruction_policy & 2) != 0) {
                        this.destructo.deferredDestroyStatement(pConn, ps);
                    }
                }
                if (!this.cxnStmtMgr.removeStatementForConnection(ps, pConn) && logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, this + " removed a statement that apparently wasn't in a statement set!!!", (Throwable) new Exception("LOG STACK TRACE"));
                }
                synchronized (this.removalPending) {
                    this.removalPending.remove(ps);
                }
            }
        }
    }

    private Object acquireStatement(final Connection pConn, final Method stmtProducingMethod, final Object[] args) throws SQLException {
        try {
            final Object[] outHolder = new Object[1];
            final Throwable[] exceptionHolder = new Throwable[1];
            this.blockingTaskAsyncRunner.postRunnable(new Runnable() { // from class: com.mchange.v2.c3p0.stmt.GooGooStatementCache.1StmtAcquireTask
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            outHolder[0] = stmtProducingMethod.invoke(pConn, args);
                            synchronized (GooGooStatementCache.this) {
                                try {
                                    GooGooStatementCache.this.notifyAll();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (InvocationTargetException e) {
                            exceptionHolder[0] = e.getTargetException();
                            synchronized (GooGooStatementCache.this) {
                                try {
                                    GooGooStatementCache.this.notifyAll();
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        } catch (Exception e2) {
                            exceptionHolder[0] = e2;
                            synchronized (GooGooStatementCache.this) {
                                try {
                                    GooGooStatementCache.this.notifyAll();
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        synchronized (GooGooStatementCache.this) {
                            try {
                                GooGooStatementCache.this.notifyAll();
                                throw th4;
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        }
                    }
                }
            });
            while (outHolder[0] == null && exceptionHolder[0] == null) {
                wait();
            }
            if (exceptionHolder[0] == null) {
                return outHolder[0];
            }
            throw new SQLException("A problem occurred while trying to acquire a cached PreparedStatement in a background thread.", exceptionHolder[0]);
        } catch (InterruptedException e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    private KeyRec keyRec(StatementCacheKey key) {
        return (KeyRec) this.keyToKeyRec.get(key);
    }

    private HashSet keySet(StatementCacheKey key) {
        KeyRec rec = keyRec(key);
        if (rec == null) {
            return null;
        }
        return rec.allStmts;
    }

    private boolean removeFromKeySet(StatementCacheKey key, Object pstmt) {
        HashSet stmtSet = keySet(key);
        boolean out = stmtSet.remove(pstmt);
        if (stmtSet.isEmpty() && checkoutQueue(key).isEmpty()) {
            this.keyToKeyRec.remove(key);
        }
        return out;
    }

    private LinkedList checkoutQueue(StatementCacheKey key) {
        KeyRec rec = keyRec(key);
        if (rec == null) {
            return null;
        }
        return rec.checkoutQueue;
    }

    private boolean removeFromCheckoutQueue(StatementCacheKey key, Object pstmt) {
        LinkedList q = checkoutQueue(key);
        boolean out = q.remove(pstmt);
        if (q.isEmpty() && keySet(key).isEmpty()) {
            this.keyToKeyRec.remove(key);
        }
        return out;
    }

    private boolean ourResource(Object ps) {
        return this.stmtToKey.keySet().contains(ps);
    }

    private void refreshStatement(PreparedStatement ps) throws Exception {
        ps.clearParameters();
        ps.clearBatch();
    }

    /* access modifiers changed from: private */
    public void printStats() {
        int total_size = countCachedStatements();
        int checked_out_size = this.checkedOut.size();
        int num_connections = this.cxnStmtMgr.getNumConnectionsWithCachedStatements();
        int num_keys = this.keyToKeyRec.size();
        System.err.print(getClass().getName() + " stats -- ");
        System.err.print("total size: " + total_size);
        System.err.print("; checked out: " + checked_out_size);
        System.err.print("; num connections: " + num_connections);
        System.err.println("; num keys: " + num_keys);
    }

    private String statsString() {
        int total_size = countCachedStatements();
        int checked_out_size = this.checkedOut.size();
        int num_connections = this.cxnStmtMgr.getNumConnectionsWithCachedStatements();
        int num_keys = this.keyToKeyRec.size();
        StringBuffer sb = new StringBuffer(255);
        sb.append(getClass().getName());
        sb.append(" stats -- ");
        sb.append("total size: ");
        sb.append(total_size);
        sb.append("; checked out: ");
        sb.append(checked_out_size);
        sb.append("; num connections: ");
        sb.append(num_connections);
        int in_use = this.destructo.countConnectionsInUse();
        if (in_use >= 0) {
            sb.append("; num connections in use: ");
            sb.append(in_use);
        }
        sb.append("; num keys: ");
        sb.append(num_keys);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$KeyRec */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$KeyRec.class */
    public static class KeyRec {
        HashSet allStmts;
        LinkedList checkoutQueue;

        private KeyRec() {
            this.allStmts = new HashSet();
            this.checkoutQueue = new LinkedList();
        }
    }

    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$Deathmarch */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$Deathmarch.class */
    protected class Deathmarch {
        TreeMap longsToStmts = new TreeMap();
        HashMap stmtsToLongs = new HashMap();
        long last_long = -1;
        static final /* synthetic */ boolean $assertionsDisabled;

        /* access modifiers changed from: protected */
        public Deathmarch() {
        }

        static {
            $assertionsDisabled = !GooGooStatementCache.class.desiredAssertionStatus();
        }

        public void deathmarchStatement(Object ps) {
            if (!$assertionsDisabled && !Thread.holdsLock(GooGooStatementCache.this)) {
                throw new AssertionError();
            } else if (((Long) this.stmtsToLongs.get(ps)) != null) {
                throw new RuntimeException("Internal inconsistency: A statement is being double-deathmatched. no checked-out statements should be in a deathmarch already; no already checked-in statement should be deathmarched!");
            } else {
                Long youth = getNextLong();
                this.stmtsToLongs.put(ps, youth);
                this.longsToStmts.put(youth, ps);
            }
        }

        public void undeathmarchStatement(Object ps) {
            if ($assertionsDisabled || Thread.holdsLock(GooGooStatementCache.this)) {
                Long old = (Long) this.stmtsToLongs.remove(ps);
                if (old == null) {
                    throw new RuntimeException("Internal inconsistency: A (not new) checking-out statement is not in deathmarch.");
                }
                this.longsToStmts.remove(old);
                if (old == null) {
                    throw new RuntimeException("Internal inconsistency: A (not new) checking-out statement is not in deathmarch.");
                }
                return;
            }
            throw new AssertionError();
        }

        public boolean cullNext() {
            if ($assertionsDisabled || Thread.holdsLock(GooGooStatementCache.this)) {
                Object cullMeStmt = null;
                StatementCacheKey sck = null;
                if (!this.longsToStmts.isEmpty()) {
                    cullMeStmt = this.longsToStmts.get((Long) this.longsToStmts.firstKey());
                }
                if (cullMeStmt == null) {
                    return false;
                }
                if (0 == 0) {
                    sck = (StatementCacheKey) GooGooStatementCache.this.stmtToKey.get(cullMeStmt);
                }
                if (GooGooStatementCache.logger.isLoggable(MLevel.FINEST)) {
                    GooGooStatementCache.logger.finest("CULLING: " + sck.stmtText);
                }
                GooGooStatementCache.this.removeStatement(cullMeStmt, 3);
                if (!contains(cullMeStmt)) {
                    return true;
                }
                throw new RuntimeException("Inconsistency!!! Statement culled from deathmarch failed to be removed by removeStatement( ... )!");
            }
            throw new AssertionError();
        }

        public boolean contains(Object ps) {
            return this.stmtsToLongs.keySet().contains(ps);
        }

        public int size() {
            return this.longsToStmts.size();
        }

        private Long getNextLong() {
            long j = this.last_long + 1;
            this.last_long = j;
            return new Long(j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$ConnectionStatementManager */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$ConnectionStatementManager.class */
    public static abstract class ConnectionStatementManager {
        Map cxnToStmtSets = new HashMap();

        protected ConnectionStatementManager() {
        }

        public int getNumConnectionsWithCachedStatements() {
            return this.cxnToStmtSets.size();
        }

        public Set connectionSet() {
            return this.cxnToStmtSets.keySet();
        }

        public Set statementSet(Connection pcon) {
            return (Set) this.cxnToStmtSets.get(pcon);
        }

        public int getNumStatementsForConnection(Connection pcon) {
            Set stmtSet = statementSet(pcon);
            if (stmtSet == null) {
                return 0;
            }
            return stmtSet.size();
        }

        public void addStatementForConnection(Object ps, Connection pcon) {
            HashSet stmtSet = statementSet(pcon);
            if (stmtSet == null) {
                stmtSet = new HashSet();
                this.cxnToStmtSets.put(pcon, stmtSet);
            }
            stmtSet.add(ps);
        }

        public boolean removeStatementForConnection(Object ps, Connection pcon) {
            boolean out;
            Set stmtSet = statementSet(pcon);
            if (stmtSet != null) {
                out = stmtSet.remove(ps);
                if (stmtSet.isEmpty()) {
                    this.cxnToStmtSets.remove(pcon);
                }
            } else {
                out = false;
            }
            return out;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$DeathmarchConnectionStatementManager */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$DeathmarchConnectionStatementManager.class */
    protected final class DeathmarchConnectionStatementManager extends ConnectionStatementManager {
        Map cxnsToDms = new HashMap();

        /* access modifiers changed from: protected */
        public DeathmarchConnectionStatementManager() {
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.ConnectionStatementManager
        public void addStatementForConnection(Object ps, Connection pcon) {
            addStatementForConnection(ps, pcon);
            if (((Deathmarch) this.cxnsToDms.get(pcon)) == null) {
                this.cxnsToDms.put(pcon, new Deathmarch());
            }
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.ConnectionStatementManager
        public boolean removeStatementForConnection(Object ps, Connection pcon) {
            boolean out = removeStatementForConnection(ps, pcon);
            if (out && statementSet(pcon) == null) {
                this.cxnsToDms.remove(pcon);
            }
            return out;
        }

        public Deathmarch getDeathmarch(Connection pcon) {
            return (Deathmarch) this.cxnsToDms.get(pcon);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$StatementDestructionManager */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$StatementDestructionManager.class */
    public abstract class StatementDestructionManager {
        AsynchronousRunner runner;

        abstract void waitMarkConnectionInUse(Connection connection) throws InterruptedException;

        abstract boolean tryMarkConnectionInUse(Connection connection);

        abstract void unmarkConnectionInUse(Connection connection);

        abstract void deferredDestroyStatement(Object obj, Object obj2);

        abstract int countConnectionsInUse();

        abstract boolean knownInUse(Connection connection);

        abstract Boolean tvlInUse(Connection connection);

        abstract int getNumConnectionsInUse();

        abstract int getNumConnectionsWithDeferredDestroyStatements();

        abstract int getNumDeferredDestroyStatements();

        abstract void close();

        StatementDestructionManager(AsynchronousRunner runner) {
            this.runner = runner;
        }

        final void uncheckedDestroyStatement(final Object pstmt) {
            this.runner.postRunnable(new Runnable() { // from class: com.mchange.v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager.1UncheckedStatementCloseTask
                @Override // java.lang.Runnable
                public void run() {
                    StatementUtils.attemptClose((PreparedStatement) pstmt);
                }
            });
        }

        final void synchronousDestroyStatement(Object pstmt) {
            StatementUtils.attemptClose((PreparedStatement) pstmt);
        }
    }

    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$IncautiousStatementDestructionManager */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$IncautiousStatementDestructionManager.class */
    private final class IncautiousStatementDestructionManager extends StatementDestructionManager {
        IncautiousStatementDestructionManager(AsynchronousRunner runner) {
            super(runner);
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        void waitMarkConnectionInUse(Connection physicalConnection) throws InterruptedException {
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        boolean tryMarkConnectionInUse(Connection physicalConnection) {
            return true;
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        void unmarkConnectionInUse(Connection physicalConnection) {
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        void deferredDestroyStatement(Object parentConnection, Object pstmt) {
            uncheckedDestroyStatement(pstmt);
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        void close() {
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        int countConnectionsInUse() {
            return -1;
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        boolean knownInUse(Connection pCon) {
            return false;
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        Boolean tvlInUse(Connection pCon) {
            return null;
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        int getNumConnectionsInUse() {
            return -1;
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        int getNumConnectionsWithDeferredDestroyStatements() {
            return -1;
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        int getNumDeferredDestroyStatements() {
            return -1;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.stmt.GooGooStatementCache$CautiousStatementDestructionManager */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GooGooStatementCache$CautiousStatementDestructionManager.class */
    private final class CautiousStatementDestructionManager extends StatementDestructionManager {
        AsynchronousRunner deferredStatementDestroyer;
        static final /* synthetic */ boolean $assertionsDisabled;
        HashSet inUseConnections = new HashSet();
        HashMap connectionsToZombieStatementSets = new HashMap();
        boolean closed = false;

        static {
            $assertionsDisabled = !GooGooStatementCache.class.desiredAssertionStatus();
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized void close() {
            this.closed = true;
        }

        CautiousStatementDestructionManager(AsynchronousRunner deferredStatementDestroyer) {
            super(deferredStatementDestroyer);
            this.deferredStatementDestroyer = deferredStatementDestroyer;
        }

        private String trace() {
            Set<Object> keys = this.connectionsToZombieStatementSets.keySet();
            int sum = 0;
            for (Object con : keys) {
                Set stmts = (Set) this.connectionsToZombieStatementSets.get(con);
                synchronized (stmts) {
                    sum += stmts == null ? 0 : stmts.size();
                }
            }
            return getClass().getName() + " [connections in use: " + this.inUseConnections.size() + "; connections with deferred statements: " + keys.size() + "; statements to destroy: " + sum + "]";
        }

        private void printAllStats() {
            GooGooStatementCache.this.printStats();
            System.err.println(trace());
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized void waitMarkConnectionInUse(Connection physicalConnection) throws InterruptedException {
            if (!this.closed) {
                Set stmts = statementsUnderDestruction(physicalConnection);
                if (stmts != null) {
                    if (GooGooStatementCache.logger.isLoggable(MLevel.FINE)) {
                        GooGooStatementCache.logger.log(MLevel.FINE, "A connection is waiting to be accepted by the Statement cache because " + stmts.size() + " cached Statements are still being destroyed.");
                    }
                    while (!stmts.isEmpty()) {
                        wait();
                    }
                }
                this.inUseConnections.add(physicalConnection);
            }
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized boolean tryMarkConnectionInUse(Connection physicalConnection) {
            if (this.closed) {
                return true;
            }
            Set stmts = statementsUnderDestruction(physicalConnection);
            if (stmts != null) {
                int sz = stmts.size();
                if (!GooGooStatementCache.logger.isLoggable(MLevel.FINE)) {
                    return false;
                }
                GooGooStatementCache.logger.log(MLevel.FINE, "A connection could not be accepted by the Statement cache because " + sz + " cached Statements are still being destroyed.");
                return false;
            }
            this.inUseConnections.add(physicalConnection);
            return true;
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized void unmarkConnectionInUse(Connection physicalConnection) {
            this.inUseConnections.remove(physicalConnection);
            if (((Set) this.connectionsToZombieStatementSets.get(physicalConnection)) != null) {
                destroyAllTrackedStatements(physicalConnection);
            }
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized void deferredDestroyStatement(Object parentConnection, Object pstmt) {
            if (this.closed) {
                uncheckedDestroyStatement(pstmt);
            } else if (this.inUseConnections.contains(parentConnection)) {
                Set s = (Set) this.connectionsToZombieStatementSets.get(parentConnection);
                if (s == null) {
                    s = Collections.synchronizedSet(new HashSet());
                    this.connectionsToZombieStatementSets.put(parentConnection, s);
                }
                s.add(pstmt);
            } else {
                uncheckedDestroyStatement(pstmt);
            }
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized int countConnectionsInUse() {
            return this.inUseConnections.size();
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized boolean knownInUse(Connection pCon) {
            return this.inUseConnections.contains(pCon);
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        Boolean tvlInUse(Connection pCon) {
            return Boolean.valueOf(knownInUse(pCon));
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized int getNumConnectionsInUse() {
            return this.inUseConnections.size();
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized int getNumConnectionsWithDeferredDestroyStatements() {
            return this.connectionsToZombieStatementSets.keySet().size();
        }

        @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache.StatementDestructionManager
        synchronized int getNumDeferredDestroyStatements() {
            int sum = 0;
            for (Object con : this.connectionsToZombieStatementSets.keySet()) {
                Set stmts = (Set) this.connectionsToZombieStatementSets.get(con);
                synchronized (stmts) {
                    sum += stmts == null ? 0 : stmts.size();
                }
            }
            return sum;
        }

        private void trackedDestroyStatement(final Object parentConnection, final Object pstmt) {
            Runnable r = new Runnable() { // from class: com.mchange.v2.c3p0.stmt.GooGooStatementCache.CautiousStatementDestructionManager.1TrackedStatementCloseTask
                static final /* synthetic */ boolean $assertionsDisabled;

                static {
                    $assertionsDisabled = !GooGooStatementCache.class.desiredAssertionStatus();
                }

                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CautiousStatementDestructionManager.this) {
                        Set stmts = (Set) CautiousStatementDestructionManager.this.connectionsToZombieStatementSets.get(parentConnection);
                        if (stmts != null) {
                            StatementUtils.attemptClose((PreparedStatement) pstmt);
                            boolean removed1 = stmts.remove(pstmt);
                            if (!$assertionsDisabled && !removed1) {
                                throw new AssertionError();
                            } else if (stmts.isEmpty()) {
                                Object removed2 = CautiousStatementDestructionManager.this.connectionsToZombieStatementSets.remove(parentConnection);
                                if ($assertionsDisabled || removed2 == stmts) {
                                    CautiousStatementDestructionManager.this.notifyAll();
                                } else {
                                    throw new AssertionError();
                                }
                            }
                        }
                    }
                }
            };
            if (!this.closed) {
                this.deferredStatementDestroyer.postRunnable(r);
            } else {
                r.run();
            }
        }

        private void destroyAllTrackedStatements(final Object parentConnection) {
            Runnable r = new Runnable() { // from class: com.mchange.v2.c3p0.stmt.GooGooStatementCache.CautiousStatementDestructionManager.1TrackedDestroyAllStatementsTask
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CautiousStatementDestructionManager.this) {
                        Set stmts = (Set) CautiousStatementDestructionManager.this.connectionsToZombieStatementSets.remove(parentConnection);
                        if (stmts != null) {
                            Iterator ii = stmts.iterator();
                            while (ii.hasNext()) {
                                StatementUtils.attemptClose((PreparedStatement) ii.next());
                                ii.remove();
                            }
                            CautiousStatementDestructionManager.this.notifyAll();
                        }
                    }
                }
            };
            if (!this.closed) {
                this.deferredStatementDestroyer.postRunnable(r);
            } else {
                r.run();
            }
        }

        private Set statementsUnderDestruction(Object parentConnection) {
            if ($assertionsDisabled || Thread.holdsLock(this)) {
                return (Set) this.connectionsToZombieStatementSets.get(parentConnection);
            }
            throw new AssertionError();
        }
    }
}
