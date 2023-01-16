package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.C3P0ProxyConnection;
import com.mchange.p009v2.c3p0.C3P0ProxyStatement;
import com.mchange.p009v2.c3p0.ConnectionCustomizer;
import com.mchange.p009v2.c3p0.ConnectionTester;
import com.mchange.p009v2.c3p0.stmt.GooGooStatementCache;
import com.mchange.p009v2.c3p0.util.ConnectionEventSupport;
import com.mchange.p009v2.c3p0.util.StatementEventSupport;
import com.mchange.p009v2.lang.ObjectUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.sql.SqlUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.sql.ConnectionEventListener;
import javax.sql.StatementEventListener;

/* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnection */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnection.class */
public final class C3P0PooledConnection extends AbstractC3P0PooledConnection {
    static final MLogger logger = MLog.getLogger(C3P0PooledConnection.class);
    static final Class[] PROXY_CTOR_ARGS = {InvocationHandler.class};
    static final Constructor CON_PROXY_CTOR;
    static final Method RS_CLOSE_METHOD;
    static final Method STMT_CLOSE_METHOD;
    static final Object[] CLOSE_ARGS;
    static final Set OBJECT_METHODS;
    final ConnectionTester connectionTester;
    final boolean autoCommitOnClose;
    final boolean forceIgnoreUnresolvedTransactions;
    final boolean supports_setTypeMap;
    final boolean supports_setHoldability;
    final int dflt_txn_isolation;
    final String dflt_catalog;
    final int dflt_holdability;
    volatile Connection physicalConnection;
    ProxyConnection exposedProxy;
    volatile GooGooStatementCache scache;
    final ConnectionEventSupport ces = new ConnectionEventSupport(this);
    final StatementEventSupport ses = new StatementEventSupport(this);
    volatile Exception invalidatingException = null;
    int connection_status = 0;
    final Set uncachedActiveStatements = Collections.synchronizedSet(new HashSet());
    volatile boolean isolation_lvl_nondefault = false;
    volatile boolean catalog_nondefault = false;
    volatile boolean holdability_nondefault = false;

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnection$ProxyConnection */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnection$ProxyConnection.class */
    public interface ProxyConnection extends C3P0ProxyConnection {
        void silentClose(boolean z) throws SQLException;
    }

    static {
        try {
            CON_PROXY_CTOR = createProxyConstructor(ProxyConnection.class);
            Class[] argClasses = new Class[0];
            RS_CLOSE_METHOD = ResultSet.class.getMethod("close", argClasses);
            STMT_CLOSE_METHOD = Statement.class.getMethod("close", argClasses);
            CLOSE_ARGS = new Object[0];
            OBJECT_METHODS = Collections.unmodifiableSet(new HashSet(Arrays.asList(Object.class.getMethods())));
        } catch (Exception e) {
            logger.log(MLevel.SEVERE, "An Exception occurred in static initializer of" + C3P0PooledConnection.class.getName(), (Throwable) e);
            throw new InternalError("Something is very wrong, or this is a pre 1.3 JVM.We cannot set up dynamic proxies and/or methods!");
        }
    }

    private static Constructor createProxyConstructor(Class intfc) throws NoSuchMethodException {
        return Proxy.getProxyClass(C3P0PooledConnection.class.getClassLoader(), intfc).getConstructor(PROXY_CTOR_ARGS);
    }

    public C3P0PooledConnection(Connection con, ConnectionTester connectionTester, boolean autoCommitOnClose, boolean forceIgnoreUnresolvedTransactions, ConnectionCustomizer cc, String pdsIdt) throws SQLException {
        if (cc != null) {
            try {
                cc.onAcquire(con, pdsIdt);
            } catch (Exception e) {
                throw SqlUtils.toSQLException(e);
            }
        }
        this.physicalConnection = con;
        this.connectionTester = connectionTester;
        this.autoCommitOnClose = autoCommitOnClose;
        this.forceIgnoreUnresolvedTransactions = forceIgnoreUnresolvedTransactions;
        this.supports_setTypeMap = C3P0ImplUtils.supportsMethod(con, "setTypeMap", new Class[]{Map.class});
        this.supports_setHoldability = C3P0ImplUtils.supportsMethod(con, "setHoldability", new Class[]{Integer.TYPE});
        this.dflt_txn_isolation = con.getTransactionIsolation();
        this.dflt_catalog = con.getCatalog();
        this.dflt_holdability = this.supports_setHoldability ? con.getHoldability() : 2;
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractC3P0PooledConnection
    Connection getPhysicalConnection() {
        return this.physicalConnection;
    }

    boolean isClosed() throws SQLException {
        return this.physicalConnection == null;
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractC3P0PooledConnection
    void initStatementCache(GooGooStatementCache scache) {
        this.scache = scache;
    }

    @Override // javax.sql.PooledConnection
    public synchronized Connection getConnection() throws SQLException {
        if (this.exposedProxy == null) {
            return getCreateNewConnection();
        }
        logger.warning("c3p0 -- Uh oh... getConnection() was called on a PooledConnection when it had already provided a client with a Connection that has not yet been closed. This probably indicates a bug in the connection pool!!!");
        return this.exposedProxy;
    }

    private Connection getCreateNewConnection() throws SQLException {
        try {
            ensureOkay();
            ProxyConnection createProxyConnection = createProxyConnection();
            this.exposedProxy = createProxyConnection;
            return createProxyConnection;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            logger.log(MLevel.WARNING, "Failed to acquire connection!", (Throwable) e2);
            throw new SQLException("Failed to acquire connection!");
        }
    }

    public void closeAll() throws SQLException {
        if (this.scache != null) {
            this.scache.closeAll(this.physicalConnection);
        }
    }

    @Override // javax.sql.PooledConnection, com.mchange.p006v1.util.ClosableResource
    public void close() throws SQLException {
        close(false);
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractC3P0PooledConnection
    synchronized void closeMaybeCheckedOut(boolean checked_out) throws SQLException {
        if (checked_out) {
            try {
                C3P0ImplUtils.resetTxnState(this.physicalConnection, this.forceIgnoreUnresolvedTransactions, this.autoCommitOnClose, false);
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.FINER)) {
                    logger.log(MLevel.FINER, "Failed to reset the transaction state of  " + this.physicalConnection + "just prior to close(). Only relevant at all if this was a Connection being forced close()ed midtransaction.", (Throwable) e);
                }
            }
        }
        close(false);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:31:0x00e8
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private synchronized void close(boolean r6) throws java.sql.SQLException {
        /*
        // Method dump skipped, instructions count: 421
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.C3P0PooledConnection.close(boolean):void");
    }

    @Override // javax.sql.PooledConnection
    public void addConnectionEventListener(ConnectionEventListener listener) {
        this.ces.addConnectionEventListener(listener);
    }

    @Override // javax.sql.PooledConnection
    public void removeConnectionEventListener(ConnectionEventListener listener) {
        this.ces.removeConnectionEventListener(listener);
    }

    @Override // javax.sql.PooledConnection
    public void addStatementEventListener(StatementEventListener sel) {
        if (logger.isLoggable(MLevel.INFO)) {
            logger.info("Per the JDBC4 spec, " + getClass().getName() + " accepts StatementListeners, but for now there is no circumstance under which they are notified!");
        }
        this.ses.addStatementEventListener(sel);
    }

    @Override // javax.sql.PooledConnection
    public void removeStatementEventListener(StatementEventListener sel) {
        this.ses.removeStatementEventListener(sel);
    }

    private void reset() throws SQLException {
        reset(false);
    }

    /* access modifiers changed from: private */
    public void reset(boolean known_resolved_txn) throws SQLException {
        ensureOkay();
        C3P0ImplUtils.resetTxnState(this.physicalConnection, this.forceIgnoreUnresolvedTransactions, this.autoCommitOnClose, known_resolved_txn);
        if (this.isolation_lvl_nondefault) {
            this.physicalConnection.setTransactionIsolation(this.dflt_txn_isolation);
            this.isolation_lvl_nondefault = false;
        }
        if (this.catalog_nondefault) {
            this.physicalConnection.setCatalog(this.dflt_catalog);
            this.catalog_nondefault = false;
        }
        if (this.holdability_nondefault) {
            this.physicalConnection.setHoldability(this.dflt_holdability);
            this.holdability_nondefault = false;
        }
        try {
            this.physicalConnection.setReadOnly(false);
        } catch (Throwable t) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "A Throwable occurred while trying to reset the readOnly property of our Connection to false!", t);
            }
        }
        try {
            if (this.supports_setTypeMap) {
                this.physicalConnection.setTypeMap(Collections.EMPTY_MAP);
            }
        } catch (Throwable t2) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "A Throwable occurred while trying to reset the typeMap property of our Connection to Collections.EMPTY_MAP!", t2);
            }
        }
    }

    boolean closeAndRemoveResultSets(Set rsSet) {
        boolean okay = true;
        synchronized (rsSet) {
            Iterator ii = rsSet.iterator();
            while (ii.hasNext()) {
                try {
                    ((ResultSet) ii.next()).close();
                    ii.remove();
                } catch (SQLException e) {
                    logger.log(MLevel.WARNING, "An exception occurred while cleaning up a ResultSet.", (Throwable) e);
                    okay = false;
                    ii.remove();
                } catch (Throwable th) {
                    ii.remove();
                    throw th;
                }
            }
        }
        return okay;
    }

    void ensureOkay() throws SQLException {
        if (this.physicalConnection == null) {
            throw new SQLException(this.invalidatingException == null ? "Connection is closed or broken." : "Connection is broken. Invalidating Exception: " + this.invalidatingException.toString());
        }
    }

    boolean closeAndRemoveResourcesInSet(Set s, Method closeMethod) {
        Set temp;
        boolean okay = true;
        synchronized (s) {
            temp = new HashSet(s);
        }
        for (Object rsrc : temp) {
            try {
                try {
                    closeMethod.invoke(rsrc, CLOSE_ARGS);
                    s.remove(rsrc);
                } catch (Exception e) {
                    Throwable t = e;
                    if (t instanceof InvocationTargetException) {
                        t = ((InvocationTargetException) e).getTargetException();
                    }
                    logger.log(MLevel.WARNING, "An exception occurred while cleaning up a resource.", t);
                    okay = false;
                    s.remove(rsrc);
                }
            } catch (Throwable th) {
                s.remove(rsrc);
                throw th;
            }
        }
        return okay;
    }

    /* access modifiers changed from: private */
    public SQLException cleanupUncachedActiveStatements() {
        if (closeAndRemoveResourcesInSet(this.uncachedActiveStatements, STMT_CLOSE_METHOD)) {
            return null;
        }
        return new SQLException("An exception occurred while trying to clean up orphaned resources.");
    }

    ProxyConnection createProxyConnection() throws Exception {
        return (ProxyConnection) CON_PROXY_CTOR.newInstance(new ProxyConnectionInvocationHandler());
    }

    Statement createProxyStatement(Statement innerStmt) throws Exception {
        return createProxyStatement(false, innerStmt);
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnection$StatementProxyingSetManagedResultSet */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnection$StatementProxyingSetManagedResultSet.class */
    public static class StatementProxyingSetManagedResultSet extends SetManagedResultSet {
        private Statement proxyStatement;

        StatementProxyingSetManagedResultSet(Set activeResultSets) {
            super(activeResultSets);
        }

        public void setProxyStatement(Statement proxyStatement) {
            this.proxyStatement = proxyStatement;
        }

        @Override // com.mchange.p009v2.sql.filter.FilterResultSet, java.sql.ResultSet
        public Statement getStatement() throws SQLException {
            return this.proxyStatement == null ? getStatement() : this.proxyStatement;
        }
    }

    Statement createProxyStatement(boolean inner_is_cached, Statement innerStmt) throws Exception {
        Set activeResultSets = Collections.synchronizedSet(new HashSet());
        Connection parentConnection = this.exposedProxy;
        if (parentConnection == null) {
            logger.warning("PROBABLE C3P0 BUG -- " + this + ": created a proxy Statement when there is no active, exposed proxy Connection???");
        }
        StatementProxyingSetManagedResultSet mainResultSet = new StatementProxyingSetManagedResultSet(activeResultSets);
        if (innerStmt instanceof CallableStatement) {
            return new C3P0ProxyStatement((CallableStatement) innerStmt, innerStmt, mainResultSet, activeResultSets, inner_is_cached, parentConnection) { // from class: com.mchange.v2.c3p0.impl.C3P0PooledConnection.1ProxyCallableStatement
                AnonymousClass1WrapperStatementHelper wsh;
                final /* synthetic */ Statement val$innerStmt;
                final /* synthetic */ StatementProxyingSetManagedResultSet val$mainResultSet;
                final /* synthetic */ Set val$activeResultSets;
                final /* synthetic */ boolean val$inner_is_cached;
                final /* synthetic */ Connection val$parentConnection;

                /* JADX WARN: Incorrect args count in method signature: (Ljava/sql/CallableStatement;)V */
                {
                    this.val$innerStmt = r14;
                    this.val$mainResultSet = r15;
                    this.val$activeResultSets = r16;
                    this.val$inner_is_cached = r17;
                    this.val$parentConnection = r18;
                    this.wsh = new Object(this, is, this.val$inner_is_cached, this.val$activeResultSets, this.val$mainResultSet, this.val$innerStmt) { // from class: com.mchange.v2.c3p0.impl.C3P0PooledConnection.1WrapperStatementHelper
                        Statement wrapperStmt;
                        Statement nakedInner;
                        final /* synthetic */ boolean val$inner_is_cached;
                        final /* synthetic */ Set val$activeResultSets;
                        final /* synthetic */ StatementProxyingSetManagedResultSet val$mainResultSet;
                        final /* synthetic */ Statement val$innerStmt;

                        /* JADX WARN: Incorrect args count in method signature: (Ljava/sql/Statement;Ljava/sql/Statement;)V */
                        {
                            this.val$inner_is_cached = r7;
                            this.val$activeResultSets = r8;
                            this.val$mainResultSet = r9;
                            this.val$innerStmt = r10;
                            this.wrapperStmt = wrapperStmt;
                            this.nakedInner = nakedInner;
                            if (!this.val$inner_is_cached) {
                                C3P0PooledConnection.this.uncachedActiveStatements.add(wrapperStmt);
                            }
                        }

                        private boolean closeAndRemoveActiveResultSets() {
                            return C3P0PooledConnection.this.closeAndRemoveResultSets(this.val$activeResultSets);
                        }

                        public ResultSet wrap(ResultSet rs) {
                            if (this.val$mainResultSet.getInner() == null) {
                                this.val$mainResultSet.setInner(rs);
                                this.val$mainResultSet.setProxyStatement(this.wrapperStmt);
                                return this.val$mainResultSet;
                            }
                            StatementProxyingSetManagedResultSet out = new StatementProxyingSetManagedResultSet(this.val$activeResultSets);
                            out.setInner(rs);
                            out.setProxyStatement(this.wrapperStmt);
                            return out;
                        }

                        public void doClose() throws SQLException {
                            boolean okay = closeAndRemoveActiveResultSets();
                            if (this.val$inner_is_cached) {
                                C3P0PooledConnection.this.scache.checkinStatement(this.val$innerStmt);
                            } else {
                                this.val$innerStmt.close();
                                C3P0PooledConnection.this.uncachedActiveStatements.remove(this.wrapperStmt);
                            }
                            if (!okay) {
                                throw new SQLException("Failed to close an orphaned ResultSet properly.");
                            }
                        }

                        public Object doRawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
                            if (target == C3P0ProxyStatement.RAW_STATEMENT) {
                                target = this.nakedInner;
                            }
                            int len = args.length;
                            for (int i = 0; i < len; i++) {
                                if (args[i] == C3P0ProxyStatement.RAW_STATEMENT) {
                                    args[i] = this.nakedInner;
                                }
                            }
                            Object out = m.invoke(target, args);
                            if (out instanceof ResultSet) {
                                out = wrap((ResultSet) out);
                            }
                            return out;
                        }
                    };
                }

                @Override // com.mchange.p009v2.sql.filter.FilterCallableStatement, java.sql.Statement
                public Connection getConnection() {
                    return this.val$parentConnection;
                }

                @Override // com.mchange.p009v2.sql.filter.FilterCallableStatement, java.sql.Statement
                public ResultSet getResultSet() throws SQLException {
                    return this.wsh.wrap(getResultSet());
                }

                @Override // com.mchange.p009v2.sql.filter.FilterCallableStatement, java.sql.Statement
                public ResultSet getGeneratedKeys() throws SQLException {
                    return this.wsh.wrap(getGeneratedKeys());
                }

                @Override // com.mchange.p009v2.sql.filter.FilterCallableStatement, java.sql.Statement
                public ResultSet executeQuery(String sql) throws SQLException {
                    return this.wsh.wrap(executeQuery(sql));
                }

                @Override // com.mchange.p009v2.sql.filter.FilterCallableStatement, java.sql.PreparedStatement
                public ResultSet executeQuery() throws SQLException {
                    return this.wsh.wrap(executeQuery());
                }

                @Override // com.mchange.p009v2.c3p0.C3P0ProxyStatement
                public Object rawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
                    return this.wsh.doRawStatementOperation(m, target, args);
                }

                @Override // com.mchange.p009v2.sql.filter.FilterCallableStatement, java.sql.Statement, java.lang.AutoCloseable
                public void close() throws SQLException {
                    this.wsh.doClose();
                }
            };
        }
        if (innerStmt instanceof PreparedStatement) {
            return new C3P0ProxyStatement((PreparedStatement) innerStmt, innerStmt, mainResultSet, activeResultSets, inner_is_cached, parentConnection) { // from class: com.mchange.v2.c3p0.impl.C3P0PooledConnection.1ProxyPreparedStatement
                AnonymousClass1WrapperStatementHelper wsh;
                final /* synthetic */ Statement val$innerStmt;
                final /* synthetic */ StatementProxyingSetManagedResultSet val$mainResultSet;
                final /* synthetic */ Set val$activeResultSets;
                final /* synthetic */ boolean val$inner_is_cached;
                final /* synthetic */ Connection val$parentConnection;

                /* JADX WARN: Incorrect args count in method signature: (Ljava/sql/PreparedStatement;)V */
                {
                    this.val$innerStmt = r14;
                    this.val$mainResultSet = r15;
                    this.val$activeResultSets = r16;
                    this.val$inner_is_cached = r17;
                    this.val$parentConnection = r18;
                    this.wsh = new Object(this, ps, this.val$inner_is_cached, this.val$activeResultSets, this.val$mainResultSet, this.val$innerStmt) { // from class: com.mchange.v2.c3p0.impl.C3P0PooledConnection.1WrapperStatementHelper
                        Statement wrapperStmt;
                        Statement nakedInner;
                        final /* synthetic */ boolean val$inner_is_cached;
                        final /* synthetic */ Set val$activeResultSets;
                        final /* synthetic */ StatementProxyingSetManagedResultSet val$mainResultSet;
                        final /* synthetic */ Statement val$innerStmt;

                        /* JADX WARN: Incorrect args count in method signature: (Ljava/sql/Statement;Ljava/sql/Statement;)V */
                        {
                            this.val$inner_is_cached = r7;
                            this.val$activeResultSets = r8;
                            this.val$mainResultSet = r9;
                            this.val$innerStmt = r10;
                            this.wrapperStmt = wrapperStmt;
                            this.nakedInner = nakedInner;
                            if (!this.val$inner_is_cached) {
                                C3P0PooledConnection.this.uncachedActiveStatements.add(wrapperStmt);
                            }
                        }

                        private boolean closeAndRemoveActiveResultSets() {
                            return C3P0PooledConnection.this.closeAndRemoveResultSets(this.val$activeResultSets);
                        }

                        public ResultSet wrap(ResultSet rs) {
                            if (this.val$mainResultSet.getInner() == null) {
                                this.val$mainResultSet.setInner(rs);
                                this.val$mainResultSet.setProxyStatement(this.wrapperStmt);
                                return this.val$mainResultSet;
                            }
                            StatementProxyingSetManagedResultSet out = new StatementProxyingSetManagedResultSet(this.val$activeResultSets);
                            out.setInner(rs);
                            out.setProxyStatement(this.wrapperStmt);
                            return out;
                        }

                        public void doClose() throws SQLException {
                            boolean okay = closeAndRemoveActiveResultSets();
                            if (this.val$inner_is_cached) {
                                C3P0PooledConnection.this.scache.checkinStatement(this.val$innerStmt);
                            } else {
                                this.val$innerStmt.close();
                                C3P0PooledConnection.this.uncachedActiveStatements.remove(this.wrapperStmt);
                            }
                            if (!okay) {
                                throw new SQLException("Failed to close an orphaned ResultSet properly.");
                            }
                        }

                        public Object doRawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
                            if (target == C3P0ProxyStatement.RAW_STATEMENT) {
                                target = this.nakedInner;
                            }
                            int len = args.length;
                            for (int i = 0; i < len; i++) {
                                if (args[i] == C3P0ProxyStatement.RAW_STATEMENT) {
                                    args[i] = this.nakedInner;
                                }
                            }
                            Object out = m.invoke(target, args);
                            if (out instanceof ResultSet) {
                                out = wrap((ResultSet) out);
                            }
                            return out;
                        }
                    };
                }

                @Override // com.mchange.p009v2.sql.filter.FilterPreparedStatement, java.sql.Statement
                public Connection getConnection() {
                    return this.val$parentConnection;
                }

                @Override // com.mchange.p009v2.sql.filter.FilterPreparedStatement, java.sql.Statement
                public ResultSet getResultSet() throws SQLException {
                    return this.wsh.wrap(getResultSet());
                }

                @Override // com.mchange.p009v2.sql.filter.FilterPreparedStatement, java.sql.Statement
                public ResultSet getGeneratedKeys() throws SQLException {
                    return this.wsh.wrap(getGeneratedKeys());
                }

                @Override // com.mchange.p009v2.sql.filter.FilterPreparedStatement, java.sql.Statement
                public ResultSet executeQuery(String sql) throws SQLException {
                    return this.wsh.wrap(executeQuery(sql));
                }

                @Override // com.mchange.p009v2.sql.filter.FilterPreparedStatement, java.sql.PreparedStatement
                public ResultSet executeQuery() throws SQLException {
                    return this.wsh.wrap(executeQuery());
                }

                @Override // com.mchange.p009v2.c3p0.C3P0ProxyStatement
                public Object rawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
                    return this.wsh.doRawStatementOperation(m, target, args);
                }

                @Override // com.mchange.p009v2.sql.filter.FilterPreparedStatement, java.sql.Statement, java.lang.AutoCloseable
                public void close() throws SQLException {
                    this.wsh.doClose();
                }
            };
        }
        return new C3P0ProxyStatement(innerStmt, innerStmt, mainResultSet, activeResultSets, inner_is_cached, parentConnection) { // from class: com.mchange.v2.c3p0.impl.C3P0PooledConnection.1ProxyStatement
            AnonymousClass1WrapperStatementHelper wsh;
            final /* synthetic */ Statement val$innerStmt;
            final /* synthetic */ StatementProxyingSetManagedResultSet val$mainResultSet;
            final /* synthetic */ Set val$activeResultSets;
            final /* synthetic */ boolean val$inner_is_cached;
            final /* synthetic */ Connection val$parentConnection;

            /* JADX WARN: Incorrect args count in method signature: (Ljava/sql/Statement;)V */
            {
                this.val$innerStmt = r14;
                this.val$mainResultSet = r15;
                this.val$activeResultSets = r16;
                this.val$inner_is_cached = r17;
                this.val$parentConnection = r18;
                this.wsh = new Object(this, s, this.val$inner_is_cached, this.val$activeResultSets, this.val$mainResultSet, this.val$innerStmt) { // from class: com.mchange.v2.c3p0.impl.C3P0PooledConnection.1WrapperStatementHelper
                    Statement wrapperStmt;
                    Statement nakedInner;
                    final /* synthetic */ boolean val$inner_is_cached;
                    final /* synthetic */ Set val$activeResultSets;
                    final /* synthetic */ StatementProxyingSetManagedResultSet val$mainResultSet;
                    final /* synthetic */ Statement val$innerStmt;

                    /* JADX WARN: Incorrect args count in method signature: (Ljava/sql/Statement;Ljava/sql/Statement;)V */
                    {
                        this.val$inner_is_cached = r7;
                        this.val$activeResultSets = r8;
                        this.val$mainResultSet = r9;
                        this.val$innerStmt = r10;
                        this.wrapperStmt = wrapperStmt;
                        this.nakedInner = nakedInner;
                        if (!this.val$inner_is_cached) {
                            C3P0PooledConnection.this.uncachedActiveStatements.add(wrapperStmt);
                        }
                    }

                    private boolean closeAndRemoveActiveResultSets() {
                        return C3P0PooledConnection.this.closeAndRemoveResultSets(this.val$activeResultSets);
                    }

                    public ResultSet wrap(ResultSet rs) {
                        if (this.val$mainResultSet.getInner() == null) {
                            this.val$mainResultSet.setInner(rs);
                            this.val$mainResultSet.setProxyStatement(this.wrapperStmt);
                            return this.val$mainResultSet;
                        }
                        StatementProxyingSetManagedResultSet out = new StatementProxyingSetManagedResultSet(this.val$activeResultSets);
                        out.setInner(rs);
                        out.setProxyStatement(this.wrapperStmt);
                        return out;
                    }

                    public void doClose() throws SQLException {
                        boolean okay = closeAndRemoveActiveResultSets();
                        if (this.val$inner_is_cached) {
                            C3P0PooledConnection.this.scache.checkinStatement(this.val$innerStmt);
                        } else {
                            this.val$innerStmt.close();
                            C3P0PooledConnection.this.uncachedActiveStatements.remove(this.wrapperStmt);
                        }
                        if (!okay) {
                            throw new SQLException("Failed to close an orphaned ResultSet properly.");
                        }
                    }

                    public Object doRawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
                        if (target == C3P0ProxyStatement.RAW_STATEMENT) {
                            target = this.nakedInner;
                        }
                        int len = args.length;
                        for (int i = 0; i < len; i++) {
                            if (args[i] == C3P0ProxyStatement.RAW_STATEMENT) {
                                args[i] = this.nakedInner;
                            }
                        }
                        Object out = m.invoke(target, args);
                        if (out instanceof ResultSet) {
                            out = wrap((ResultSet) out);
                        }
                        return out;
                    }
                };
            }

            @Override // com.mchange.p009v2.sql.filter.FilterStatement, java.sql.Statement
            public Connection getConnection() {
                return this.val$parentConnection;
            }

            @Override // com.mchange.p009v2.sql.filter.FilterStatement, java.sql.Statement
            public ResultSet getResultSet() throws SQLException {
                return this.wsh.wrap(getResultSet());
            }

            @Override // com.mchange.p009v2.sql.filter.FilterStatement, java.sql.Statement
            public ResultSet getGeneratedKeys() throws SQLException {
                return this.wsh.wrap(getGeneratedKeys());
            }

            @Override // com.mchange.p009v2.sql.filter.FilterStatement, java.sql.Statement
            public ResultSet executeQuery(String sql) throws SQLException {
                return this.wsh.wrap(executeQuery(sql));
            }

            @Override // com.mchange.p009v2.c3p0.C3P0ProxyStatement
            public Object rawStatementOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException {
                return this.wsh.doRawStatementOperation(m, target, args);
            }

            @Override // com.mchange.p009v2.sql.filter.FilterStatement, java.sql.Statement, java.lang.AutoCloseable
            public void close() throws SQLException {
                this.wsh.doClose();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnection$ProxyConnectionInvocationHandler */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnection$ProxyConnectionInvocationHandler.class */
    public final class ProxyConnectionInvocationHandler implements InvocationHandler {
        Connection activeConnection;
        DatabaseMetaData metaData = null;
        boolean connection_error_signaled = false;
        final Set activeMetaDataResultSets = new HashSet();
        Set doRawResultSets = null;
        boolean txn_known_resolved = true;

        ProxyConnectionInvocationHandler() {
            this.activeConnection = C3P0PooledConnection.this.physicalConnection;
        }

        @Override // java.lang.Object
        public String toString() {
            return "C3P0ProxyConnection [Invocation Handler: " + toString() + ']';
        }

        private Object doRawConnectionOperation(Method m, Object target, Object[] args) throws IllegalAccessException, InvocationTargetException, SQLException, Exception {
            if (this.activeConnection == null) {
                throw new SQLException("Connection previously closed. You cannot operate on a closed Connection.");
            }
            if (target == C3P0ProxyConnection.RAW_CONNECTION) {
                target = this.activeConnection;
            }
            int len = args.length;
            for (int i = 0; i < len; i++) {
                if (args[i] == C3P0ProxyConnection.RAW_CONNECTION) {
                    args[i] = this.activeConnection;
                }
            }
            Object out = m.invoke(target, args);
            if (out instanceof Statement) {
                out = C3P0PooledConnection.this.createProxyStatement(false, (Statement) out);
            } else if (out instanceof ResultSet) {
                if (this.doRawResultSets == null) {
                    this.doRawResultSets = new HashSet();
                }
                out = new NullStatementSetManagedResultSet((ResultSet) out, this.doRawResultSets);
            }
            return out;
        }

        @Override // java.lang.reflect.InvocationHandler
        public synchronized Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            if (C3P0PooledConnection.OBJECT_METHODS.contains(m)) {
                return m.invoke(this, args);
            }
            try {
                String mname = m.getName();
                if (this.activeConnection != null) {
                    if (mname.equals("rawConnectionOperation")) {
                        C3P0PooledConnection.this.ensureOkay();
                        this.txn_known_resolved = false;
                        return doRawConnectionOperation((Method) args[0], args[1], (Object[]) args[2]);
                    } else if (mname.equals("setTransactionIsolation")) {
                        C3P0PooledConnection.this.ensureOkay();
                        m.invoke(this.activeConnection, args);
                        C3P0PooledConnection.this.isolation_lvl_nondefault = ((Integer) args[0]).intValue() != C3P0PooledConnection.this.dflt_txn_isolation;
                        return null;
                    } else if (mname.equals("setCatalog")) {
                        C3P0PooledConnection.this.ensureOkay();
                        m.invoke(this.activeConnection, args);
                        C3P0PooledConnection.this.catalog_nondefault = ObjectUtils.eqOrBothNull((String) args[0], C3P0PooledConnection.this.dflt_catalog);
                        return null;
                    } else if (mname.equals("setHoldability")) {
                        C3P0PooledConnection.this.ensureOkay();
                        m.invoke(this.activeConnection, args);
                        int holdability = ((Integer) args[0]).intValue();
                        C3P0PooledConnection.this.holdability_nondefault = holdability != C3P0PooledConnection.this.dflt_holdability;
                        return null;
                    } else if (mname.equals("createStatement")) {
                        C3P0PooledConnection.this.ensureOkay();
                        this.txn_known_resolved = false;
                        return C3P0PooledConnection.this.createProxyStatement((Statement) m.invoke(this.activeConnection, args));
                    } else if (mname.equals("prepareStatement")) {
                        C3P0PooledConnection.this.ensureOkay();
                        this.txn_known_resolved = false;
                        if (C3P0PooledConnection.this.scache == null) {
                            return C3P0PooledConnection.this.createProxyStatement((Statement) m.invoke(this.activeConnection, args));
                        }
                        return C3P0PooledConnection.this.createProxyStatement(true, (Statement) C3P0PooledConnection.this.scache.checkoutStatement(C3P0PooledConnection.this.physicalConnection, m, args));
                    } else if (mname.equals("prepareCall")) {
                        C3P0PooledConnection.this.ensureOkay();
                        this.txn_known_resolved = false;
                        if (C3P0PooledConnection.this.scache == null) {
                            return C3P0PooledConnection.this.createProxyStatement((Statement) m.invoke(this.activeConnection, args));
                        }
                        return C3P0PooledConnection.this.createProxyStatement(true, (Statement) C3P0PooledConnection.this.scache.checkoutStatement(C3P0PooledConnection.this.physicalConnection, m, args));
                    } else if (mname.equals("getMetaData")) {
                        C3P0PooledConnection.this.ensureOkay();
                        this.txn_known_resolved = false;
                        DatabaseMetaData innerMd = this.activeConnection.getMetaData();
                        if (this.metaData == null) {
                            synchronized (C3P0PooledConnection.this) {
                                this.metaData = new SetManagedDatabaseMetaData(innerMd, this.activeMetaDataResultSets, C3P0PooledConnection.this.exposedProxy);
                            }
                        }
                        return this.metaData;
                    } else if (mname.equals("silentClose")) {
                        doSilentClose(proxy, ((Boolean) args[0]).booleanValue(), this.txn_known_resolved);
                        return null;
                    } else if (mname.equals("close")) {
                        Exception e = doSilentClose(proxy, false, this.txn_known_resolved);
                        if (!this.connection_error_signaled) {
                            C3P0PooledConnection.this.ces.fireConnectionClosed();
                        }
                        if (e == null) {
                            return null;
                        }
                        throw e;
                    } else {
                        C3P0PooledConnection.this.ensureOkay();
                        this.txn_known_resolved = false;
                        return m.invoke(this.activeConnection, args);
                    }
                } else if (mname.equals("close") || mname.equals("silentClose")) {
                    return null;
                } else {
                    if (mname.equals("isClosed")) {
                        return Boolean.TRUE;
                    }
                    throw new SQLException("You can't operate on a closed connection!!!");
                }
            } catch (InvocationTargetException e2) {
                SQLException sqle = handleMaybeFatalToPooledConnection(e2.getTargetException(), proxy, false);
                sqle.fillInStackTrace();
                throw sqle;
            }
        }

        private Exception doSilentClose(Object proxyConnection, boolean pooled_connection_is_dead) {
            return doSilentClose(proxyConnection, pooled_connection_is_dead, false);
        }

        private Exception doSilentClose(Object proxyConnection, boolean pooled_connection_is_dead, boolean known_resolved_txn) {
            String errSource;
            if (this.activeConnection == null) {
                return null;
            }
            synchronized (C3P0PooledConnection.this) {
                if (C3P0PooledConnection.this.exposedProxy == proxyConnection) {
                    C3P0PooledConnection.this.exposedProxy = null;
                } else {
                    C3P0PooledConnection.logger.warning("(c3p0 issue) doSilentClose( ... ) called on a proxyConnection other than the current exposed proxy for its PooledConnection. [exposedProxy: " + C3P0PooledConnection.this.exposedProxy + ", proxyConnection: " + proxyConnection);
                }
            }
            Exception out = null;
            Exception exc1 = null;
            Exception exc3 = null;
            Exception exc4 = null;
            if (!pooled_connection_is_dead) {
                try {
                    C3P0PooledConnection.this.reset(known_resolved_txn);
                } catch (Exception e) {
                    exc1 = e;
                }
            }
            Exception exc2 = C3P0PooledConnection.this.cleanupUncachedActiveStatements();
            if (this.doRawResultSets != null) {
                this.activeMetaDataResultSets.addAll(this.doRawResultSets);
                errSource = "DataBaseMetaData or raw Connection operation";
            } else {
                errSource = "DataBaseMetaData";
            }
            if (!C3P0PooledConnection.this.closeAndRemoveResultSets(this.activeMetaDataResultSets)) {
                exc3 = new SQLException("Failed to close some " + errSource + " Result Sets.");
            }
            if (C3P0PooledConnection.this.scache != null) {
                try {
                    C3P0PooledConnection.this.scache.checkinAll(C3P0PooledConnection.this.physicalConnection);
                } catch (Exception e2) {
                    exc4 = e2;
                }
            }
            if (exc1 != null) {
                handleMaybeFatalToPooledConnection(exc1, proxyConnection, true);
                out = exc1;
            } else if (exc2 != null) {
                handleMaybeFatalToPooledConnection(exc2, proxyConnection, true);
                out = exc2;
            } else if (exc3 != null) {
                handleMaybeFatalToPooledConnection(exc3, proxyConnection, true);
                out = exc3;
            } else if (exc4 != null) {
                handleMaybeFatalToPooledConnection(exc4, proxyConnection, true);
                out = exc4;
            }
            this.activeConnection = null;
            return out;
        }

        private SQLException handleMaybeFatalToPooledConnection(Throwable t, Object proxyConnection, boolean already_closed) {
            SQLException sqle = SqlUtils.toSQLException(t);
            int status = C3P0PooledConnection.this.connectionTester.statusOnException(C3P0PooledConnection.this.physicalConnection, sqle);
            C3P0PooledConnection.this.updateConnectionStatus(status);
            if (status != 0) {
                C3P0PooledConnection.logger.log(MLevel.INFO, C3P0PooledConnection.this + " will no longer be pooled because it has been marked invalid by an Exception.", t);
                C3P0PooledConnection.this.invalidatingException = sqle;
                if (!this.connection_error_signaled) {
                    C3P0PooledConnection.this.ces.fireConnectionErrorOccurred(sqle);
                    this.connection_error_signaled = true;
                }
            }
            return sqle;
        }
    }

    public synchronized int getConnectionStatus() {
        return this.connection_status;
    }

    /* access modifiers changed from: private */
    public synchronized void updateConnectionStatus(int status) {
        switch (this.connection_status) {
            case -8:
                return;
            case -1:
                if (status == -8) {
                    doBadUpdate(status);
                    return;
                }
                return;
            case 0:
                if (status != 0) {
                    doBadUpdate(status);
                    return;
                }
                return;
            default:
                throw new InternalError(this + " -- Illegal Connection Status: " + this.connection_status);
        }
    }

    private void doBadUpdate(int new_status) {
        this.connection_status = new_status;
        try {
            close(true);
        } catch (SQLException e) {
            logger.log(MLevel.WARNING, "Broken Connection Close Error. ", (Throwable) e);
        }
    }
}
