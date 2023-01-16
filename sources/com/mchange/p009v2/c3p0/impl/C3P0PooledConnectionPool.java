package com.mchange.p009v2.c3p0.impl;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.async.ThreadPoolAsynchronousRunner;
import com.mchange.p009v2.c3p0.ConnectionCustomizer;
import com.mchange.p009v2.c3p0.ConnectionTester;
import com.mchange.p009v2.c3p0.QueryConnectionTester;
import com.mchange.p009v2.c3p0.UnifiedConnectionTester;
import com.mchange.p009v2.c3p0.WrapperConnectionPoolDataSource;
import com.mchange.p009v2.c3p0.stmt.DoubleMaxStatementCache;
import com.mchange.p009v2.c3p0.stmt.GlobalMaxOnlyStatementCache;
import com.mchange.p009v2.c3p0.stmt.GooGooStatementCache;
import com.mchange.p009v2.c3p0.stmt.PerConnectionMaxOnlyStatementCache;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.resourcepool.CannotAcquireResourceException;
import com.mchange.p009v2.resourcepool.ResourcePool;
import com.mchange.p009v2.resourcepool.ResourcePoolException;
import com.mchange.p009v2.resourcepool.ResourcePoolFactory;
import com.mchange.p009v2.resourcepool.TimeoutException;
import com.mchange.p009v2.sql.SqlUtils;
import dev.morphia.mapping.Mapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

/* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnectionPool.class */
public final class C3P0PooledConnectionPool {
    private static final boolean ASYNCHRONOUS_CONNECTION_EVENT_LISTENER = false;

    /* renamed from: rp */
    final ResourcePool f399rp;
    final ConnectionTester connectionTester;
    final GooGooStatementCache scache;
    final boolean c3p0PooledConnections;
    final boolean effectiveStatementCache;
    final int checkoutTimeout;
    final AsynchronousRunner sharedTaskRunner;
    final AsynchronousRunner deferredStatementDestroyer;
    final InUseLockFetcher inUseLockFetcher;
    private static final Throwable[] EMPTY_THROWABLE_HOLDER = new Throwable[1];
    static final MLogger logger = MLog.getLogger(C3P0PooledConnectionPool.class);
    private static InUseLockFetcher RESOURCE_ITSELF_IN_USE_LOCK_FETCHER = new ResourceItselfInUseLockFetcher();
    private static InUseLockFetcher C3P0_POOLED_CONNECION_NESTED_LOCK_LOCK_FETCHER = new C3P0PooledConnectionNestedLockLockFetcher();

    /* renamed from: cl */
    final ConnectionEventListener f400cl = new ConnectionEventListenerImpl();
    final ThrowableHolderPool thp = new ThrowableHolderPool();

    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool$InUseLockFetcher */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnectionPool$InUseLockFetcher.class */
    private interface InUseLockFetcher {
        Object getInUseLock(Object obj);
    }

    public int getStatementDestroyerNumConnectionsInUse() {
        if (this.scache == null) {
            return -1;
        }
        return this.scache.getStatementDestroyerNumConnectionsInUse();
    }

    public int getStatementDestroyerNumConnectionsWithDeferredDestroyStatements() {
        if (this.scache == null) {
            return -1;
        }
        return this.scache.getStatementDestroyerNumConnectionsWithDeferredDestroyStatements();
    }

    public int getStatementDestroyerNumDeferredDestroyStatements() {
        if (this.scache == null) {
            return -1;
        }
        return this.scache.getStatementDestroyerNumDeferredDestroyStatements();
    }

    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool$ResourceItselfInUseLockFetcher */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnectionPool$ResourceItselfInUseLockFetcher.class */
    private static class ResourceItselfInUseLockFetcher implements InUseLockFetcher {
        private ResourceItselfInUseLockFetcher() {
        }

        @Override // com.mchange.p009v2.c3p0.impl.C3P0PooledConnectionPool.InUseLockFetcher
        public Object getInUseLock(Object resc) {
            return resc;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool$C3P0PooledConnectionNestedLockLockFetcher */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnectionPool$C3P0PooledConnectionNestedLockLockFetcher.class */
    private static class C3P0PooledConnectionNestedLockLockFetcher implements InUseLockFetcher {
        private C3P0PooledConnectionNestedLockLockFetcher() {
        }

        @Override // com.mchange.p009v2.c3p0.impl.C3P0PooledConnectionPool.InUseLockFetcher
        public Object getInUseLock(Object resc) {
            return ((AbstractC3P0PooledConnection) resc).inInternalUseLock;
        }
    }

    /* access modifiers changed from: package-private */
    public C3P0PooledConnectionPool(final ConnectionPoolDataSource cpds, final DbAuth auth, int min, int max, int start, int inc, int acq_retry_attempts, int acq_retry_delay, boolean break_after_acq_failure, int checkoutTimeout, int idleConnectionTestPeriod, int maxIdleTime, int maxIdleTimeExcessConnections, int maxConnectionAge, int propertyCycle, int unreturnedConnectionTimeout, boolean debugUnreturnedConnectionStackTraces, boolean forceSynchronousCheckins, final boolean testConnectionOnCheckout, final boolean testConnectionOnCheckin, int maxStatements, int maxStatementsPerConnection, final ConnectionTester connectionTester, final ConnectionCustomizer connectionCustomizer, final String testQuery, ResourcePoolFactory fact, ThreadPoolAsynchronousRunner taskRunner, ThreadPoolAsynchronousRunner deferredStatementDestroyer, final String parentDataSourceIdentityToken) throws SQLException {
        try {
            if (maxStatements > 0 && maxStatementsPerConnection > 0) {
                this.scache = new DoubleMaxStatementCache(taskRunner, deferredStatementDestroyer, maxStatements, maxStatementsPerConnection);
            } else if (maxStatementsPerConnection > 0) {
                this.scache = new PerConnectionMaxOnlyStatementCache(taskRunner, deferredStatementDestroyer, maxStatementsPerConnection);
            } else if (maxStatements > 0) {
                this.scache = new GlobalMaxOnlyStatementCache(taskRunner, deferredStatementDestroyer, maxStatements);
            } else {
                this.scache = null;
            }
            this.connectionTester = connectionTester;
            this.checkoutTimeout = checkoutTimeout;
            this.sharedTaskRunner = taskRunner;
            this.deferredStatementDestroyer = deferredStatementDestroyer;
            this.c3p0PooledConnections = cpds instanceof WrapperConnectionPoolDataSource;
            this.effectiveStatementCache = this.c3p0PooledConnections && this.scache != null;
            this.inUseLockFetcher = this.c3p0PooledConnections ? C3P0_POOLED_CONNECION_NESTED_LOCK_LOCK_FETCHER : RESOURCE_ITSELF_IN_USE_LOCK_FETCHER;
            ResourcePool.Manager manager = new ResourcePool.Manager() { // from class: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool.1PooledConnectionResourcePoolManager
                final boolean connectionTesterIsDefault;
                static final /* synthetic */ boolean $assertionsDisabled;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.connectionTesterIsDefault = connectionTester instanceof DefaultConnectionTester;
                }

                static {
                    $assertionsDisabled = !C3P0PooledConnectionPool.class.desiredAssertionStatus();
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x00f3
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                    */
                @Override // com.mchange.p009v2.resourcepool.ResourcePool.Manager
                public java.lang.Object acquireResource() throws java.lang.Exception {
                    /*
                    // Method dump skipped, instructions count: 419
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.C3P0PooledConnectionPool.AnonymousClass1PooledConnectionResourcePoolManager.acquireResource():java.lang.Object");
                }

                @Override // com.mchange.p009v2.resourcepool.ResourcePool.Manager
                public void refurbishResourceOnCheckout(Object resc) throws Exception {
                    synchronized (C3P0PooledConnectionPool.this.inUseLockFetcher.getInUseLock(resc)) {
                        if (connectionCustomizer != null) {
                            Connection physicalConnection = ((AbstractC3P0PooledConnection) resc).getPhysicalConnection();
                            C3P0PooledConnectionPool.this.waitMarkPhysicalConnectionInUse(physicalConnection);
                            if (testConnectionOnCheckout) {
                                try {
                                    if (C3P0PooledConnectionPool.logger.isLoggable(MLevel.FINER)) {
                                        finerLoggingTestPooledConnection(resc, "CHECKOUT");
                                    } else {
                                        testPooledConnection(resc);
                                    }
                                } catch (ClassCastException e) {
                                    throw SqlUtils.toSQLException("Cannot use a ConnectionCustomizer with a non-c3p0 PooledConnection. PooledConnection: " + resc + "; ConnectionPoolDataSource: " + cpds.getClass().getName(), e);
                                }
                            }
                            connectionCustomizer.onCheckOut(physicalConnection, parentDataSourceIdentityToken);
                            C3P0PooledConnectionPool.this.unmarkPhysicalConnectionInUse(physicalConnection);
                        } else if (testConnectionOnCheckout) {
                            PooledConnection pc = (PooledConnection) resc;
                            C3P0PooledConnectionPool.this.waitMarkPooledConnectionInUse(pc);
                            if ($assertionsDisabled || !Boolean.FALSE.equals(C3P0PooledConnectionPool.this.pooledConnectionInUse(pc))) {
                                if (C3P0PooledConnectionPool.logger.isLoggable(MLevel.FINER)) {
                                    finerLoggingTestPooledConnection(pc, "CHECKOUT");
                                } else {
                                    testPooledConnection(pc);
                                }
                                C3P0PooledConnectionPool.this.unmarkPooledConnectionInUse(pc);
                            } else {
                                throw new AssertionError();
                            }
                        }
                    }
                }

                /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
                    jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 9, insn: 0x00a5: MOVE  (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('physicalConnection' java.sql.Connection)]), block:B:21:0x00a2
                    	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
                    	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
                    	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
                    	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
                    */
                @Override // com.mchange.p009v2.resourcepool.ResourcePool.Manager
                public void refurbishResourceOnCheckin(
/*
[311] Method generation error in method: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool.1PooledConnectionResourcePoolManager.refurbishResourceOnCheckin(java.lang.Object):void, file: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnectionPool$1PooledConnectionResourcePoolManager.class
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v0 ??
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
                	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:195)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:151)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:344)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                
*/

                @Override // com.mchange.p009v2.resourcepool.ResourcePool.Manager
                public void refurbishIdleResource(Object resc) throws Exception {
                    synchronized (C3P0PooledConnectionPool.this.inUseLockFetcher.getInUseLock(resc)) {
                        PooledConnection pc = (PooledConnection) resc;
                        C3P0PooledConnectionPool.this.waitMarkPooledConnectionInUse(pc);
                        if (C3P0PooledConnectionPool.logger.isLoggable(MLevel.FINER)) {
                            finerLoggingTestPooledConnection(resc, "IDLE CHECK");
                        } else {
                            testPooledConnection(resc);
                        }
                        C3P0PooledConnectionPool.this.unmarkPooledConnectionInUse(pc);
                    }
                }

                private void finerLoggingTestPooledConnection(Object resc, String testImpetus) throws Exception {
                    finerLoggingTestPooledConnection(resc, null, testImpetus);
                }

                private void finerLoggingTestPooledConnection(Object resc, Connection proxyConn, String testImpetus) throws Exception {
                    C3P0PooledConnectionPool.logger.finer("Testing PooledConnection [" + resc + "] on " + testImpetus + Mapper.IGNORED_FIELDNAME);
                    try {
                        testPooledConnection(resc, proxyConn);
                        C3P0PooledConnectionPool.logger.finer("Test of PooledConnection [" + resc + "] on " + testImpetus + " has SUCCEEDED.");
                    } catch (Exception e) {
                        C3P0PooledConnectionPool.logger.log(MLevel.FINER, "Test of PooledConnection [" + resc + "] on " + testImpetus + " has FAILED.", (Throwable) e);
                        e.fillInStackTrace();
                        throw e;
                    }
                }

                private void testPooledConnection(Object resc) throws Exception {
                    testPooledConnection(resc, null);
                }

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                private void testPooledConnection(Object resc, Connection proxyConn) throws Exception {
                    Throwable[] throwableHolder;
                    Connection openedConn;
                    Throwable rootCause;
                    int status;
                    Exception throwMe;
                    Connection testConn;
                    PooledConnection pc = (PooledConnection) resc;
                    if ($assertionsDisabled || !Boolean.FALSE.equals(C3P0PooledConnectionPool.this.pooledConnectionInUse(pc))) {
                        try {
                            throwableHolder = C3P0PooledConnectionPool.EMPTY_THROWABLE_HOLDER;
                            openedConn = null;
                            rootCause = null;
                            try {
                                if (C3P0PooledConnectionPool.this.scache != null) {
                                    if (testQuery == null && this.connectionTesterIsDefault && C3P0PooledConnectionPool.this.c3p0PooledConnections) {
                                        testConn = ((AbstractC3P0PooledConnection) pc).getPhysicalConnection();
                                    } else if (proxyConn == null) {
                                        testConn = pc.getConnection();
                                        openedConn = testConn;
                                    } else {
                                        testConn = proxyConn;
                                    }
                                } else if (C3P0PooledConnectionPool.this.c3p0PooledConnections) {
                                    testConn = ((AbstractC3P0PooledConnection) pc).getPhysicalConnection();
                                } else if (proxyConn == null) {
                                    testConn = pc.getConnection();
                                    openedConn = testConn;
                                } else {
                                    testConn = proxyConn;
                                }
                                if (testQuery == null) {
                                    status = connectionTester.activeCheckConnection(testConn);
                                } else if (connectionTester instanceof UnifiedConnectionTester) {
                                    throwableHolder = C3P0PooledConnectionPool.this.thp.getThrowableHolder();
                                    status = ((UnifiedConnectionTester) connectionTester).activeCheckConnection(testConn, testQuery, throwableHolder);
                                } else if (connectionTester instanceof QueryConnectionTester) {
                                    status = ((QueryConnectionTester) connectionTester).activeCheckConnection(testConn, testQuery);
                                } else {
                                    C3P0PooledConnectionPool.logger.warning("[c3p0] testQuery '" + testQuery + "' ignored. Please set a ConnectionTester that implements com.mchange.v2.c3p0.QueryConnectionTester, or use the DefaultConnectionTester, to test with the testQuery.");
                                    status = connectionTester.activeCheckConnection(testConn);
                                }
                                if (rootCause == null) {
                                    rootCause = throwableHolder[0];
                                } else if (throwableHolder[0] != null && C3P0PooledConnectionPool.logger.isLoggable(MLevel.FINE)) {
                                    C3P0PooledConnectionPool.logger.log(MLevel.FINE, "Internal Connection Test Exception", throwableHolder[0]);
                                }
                                if (throwableHolder != C3P0PooledConnectionPool.EMPTY_THROWABLE_HOLDER) {
                                    C3P0PooledConnectionPool.this.thp.returnThrowableHolder(throwableHolder);
                                }
                                ConnectionUtils.attemptClose(openedConn);
                            } catch (Exception e) {
                                C3P0PooledConnectionPool.logger.log(MLevel.FINE, "A Connection test failed with an Exception.", e);
                                status = -1;
                                rootCause = e;
                                if (rootCause == null) {
                                    rootCause = throwableHolder[0];
                                } else if (throwableHolder[0] != null && C3P0PooledConnectionPool.logger.isLoggable(MLevel.FINE)) {
                                    C3P0PooledConnectionPool.logger.log(MLevel.FINE, "Internal Connection Test Exception", throwableHolder[0]);
                                }
                                if (throwableHolder != C3P0PooledConnectionPool.EMPTY_THROWABLE_HOLDER) {
                                    C3P0PooledConnectionPool.this.thp.returnThrowableHolder(throwableHolder);
                                }
                                ConnectionUtils.attemptClose(openedConn);
                            }
                            switch (status) {
                                case -8:
                                    C3P0PooledConnectionPool.this.f399rp.resetPool();
                                    break;
                                case -1:
                                    break;
                                case 0:
                                    return;
                                default:
                                    throw new Error("Bad Connection Tester (" + connectionTester + ") returned invalid status (" + status + ").");
                            }
                            if (rootCause == null) {
                                throwMe = new SQLException("Connection is invalid");
                            } else {
                                throwMe = SqlUtils.toSQLException("Connection is invalid", rootCause);
                            }
                            throw throwMe;
                        } catch (Throwable th) {
                            if (rootCause == null) {
                                Throwable th2 = throwableHolder[0];
                            } else if (throwableHolder[0] != null && C3P0PooledConnectionPool.logger.isLoggable(MLevel.FINE)) {
                                C3P0PooledConnectionPool.logger.log(MLevel.FINE, "Internal Connection Test Exception", throwableHolder[0]);
                            }
                            if (throwableHolder != C3P0PooledConnectionPool.EMPTY_THROWABLE_HOLDER) {
                                C3P0PooledConnectionPool.this.thp.returnThrowableHolder(throwableHolder);
                            }
                            ConnectionUtils.attemptClose(openedConn);
                            throw th;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0040
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                    */
                @Override // com.mchange.p009v2.resourcepool.ResourcePool.Manager
                public void destroyResource(java.lang.Object r6, boolean r7) throws java.lang.Exception {
                    /*
                    // Method dump skipped, instructions count: 375
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.impl.C3P0PooledConnectionPool.AnonymousClass1PooledConnectionResourcePoolManager.destroyResource(java.lang.Object, boolean):void");
                }
            };
            synchronized (fact) {
                fact.setMin(min);
                fact.setMax(max);
                fact.setStart(start);
                fact.setIncrement(inc);
                fact.setIdleResourceTestPeriod((long) (idleConnectionTestPeriod * 1000));
                fact.setResourceMaxIdleTime((long) (maxIdleTime * 1000));
                fact.setExcessResourceMaxIdleTime((long) (maxIdleTimeExcessConnections * 1000));
                fact.setResourceMaxAge((long) (maxConnectionAge * 1000));
                fact.setExpirationEnforcementDelay((long) (propertyCycle * 1000));
                fact.setDestroyOverdueResourceTime((long) (unreturnedConnectionTimeout * 1000));
                fact.setDebugStoreCheckoutStackTrace(debugUnreturnedConnectionStackTraces);
                fact.setForceSynchronousCheckins(forceSynchronousCheckins);
                fact.setAcquisitionRetryAttempts(acq_retry_attempts);
                fact.setAcquisitionRetryDelay(acq_retry_delay);
                fact.setBreakOnAcquisitionFailure(break_after_acq_failure);
                this.f399rp = fact.createPool(manager);
            }
        } catch (ResourcePoolException e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public PooledConnection checkoutPooledConnection() throws SQLException {
        try {
            PooledConnection pc = (PooledConnection) checkoutAndMarkConnectionInUse();
            pc.addConnectionEventListener(this.f400cl);
            return pc;
        } catch (CannotAcquireResourceException e) {
            throw SqlUtils.toSQLException("Connections could not be acquired from the underlying database!", "08001", e);
        } catch (TimeoutException e2) {
            throw SqlUtils.toSQLException("An attempt by a client to checkout a Connection has timed out.", e2);
        } catch (Exception e3) {
            throw SqlUtils.toSQLException(e3);
        }
    }

    /* access modifiers changed from: private */
    public void waitMarkPhysicalConnectionInUse(Connection physicalConnection) throws InterruptedException {
        if (this.effectiveStatementCache) {
            this.scache.waitMarkConnectionInUse(physicalConnection);
        }
    }

    private boolean tryMarkPhysicalConnectionInUse(Connection physicalConnection) {
        if (this.effectiveStatementCache) {
            return this.scache.tryMarkConnectionInUse(physicalConnection);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void unmarkPhysicalConnectionInUse(Connection physicalConnection) {
        if (this.effectiveStatementCache) {
            this.scache.unmarkConnectionInUse(physicalConnection);
        }
    }

    /* access modifiers changed from: private */
    public void waitMarkPooledConnectionInUse(PooledConnection pooledCon) throws InterruptedException {
        if (this.c3p0PooledConnections) {
            waitMarkPhysicalConnectionInUse(((AbstractC3P0PooledConnection) pooledCon).getPhysicalConnection());
        }
    }

    private boolean tryMarkPooledConnectionInUse(PooledConnection pooledCon) {
        if (this.c3p0PooledConnections) {
            return tryMarkPhysicalConnectionInUse(((AbstractC3P0PooledConnection) pooledCon).getPhysicalConnection());
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void unmarkPooledConnectionInUse(PooledConnection pooledCon) {
        if (this.c3p0PooledConnections) {
            unmarkPhysicalConnectionInUse(((AbstractC3P0PooledConnection) pooledCon).getPhysicalConnection());
        }
    }

    private Boolean physicalConnectionInUse(Connection physicalConnection) throws InterruptedException {
        if (physicalConnection == null || !this.effectiveStatementCache) {
            return null;
        }
        return this.scache.inUse(physicalConnection);
    }

    /* access modifiers changed from: private */
    public Boolean pooledConnectionInUse(PooledConnection pc) throws InterruptedException {
        if (pc == null || !this.effectiveStatementCache) {
            return null;
        }
        return this.scache.inUse(((AbstractC3P0PooledConnection) pc).getPhysicalConnection());
    }

    private Object checkoutAndMarkConnectionInUse() throws TimeoutException, CannotAcquireResourceException, ResourcePoolException, InterruptedException {
        Object out = null;
        boolean success = false;
        while (!success) {
            try {
                out = this.f399rp.checkoutResource((long) this.checkoutTimeout);
                if (out instanceof AbstractC3P0PooledConnection) {
                    success = tryMarkPhysicalConnectionInUse(((AbstractC3P0PooledConnection) out).getPhysicalConnection());
                } else {
                    success = true;
                }
                if (!success && out != null) {
                    try {
                        this.f399rp.checkinResource(out);
                    } catch (Exception e) {
                        logger.log(MLevel.WARNING, "Failed to check in a Connection that was unusable due to pending Statement closes.", (Throwable) e);
                    }
                }
            } catch (Throwable th) {
                if (!success && out != null) {
                    try {
                        this.f399rp.checkinResource(out);
                    } catch (Exception e2) {
                        logger.log(MLevel.WARNING, "Failed to check in a Connection that was unusable due to pending Statement closes.", (Throwable) e2);
                        throw th;
                    }
                }
                throw th;
            }
        }
        return out;
    }

    private void unmarkConnectionInUseAndCheckin(PooledConnection pcon) throws ResourcePoolException {
        if (this.effectiveStatementCache) {
            try {
                unmarkPhysicalConnectionInUse(((AbstractC3P0PooledConnection) pcon).getPhysicalConnection());
            } catch (ClassCastException e) {
                if (logger.isLoggable(MLevel.SEVERE)) {
                    logger.log(MLevel.SEVERE, "You are checking a non-c3p0 PooledConnection implementation intoa c3p0 PooledConnectionPool instance that expects only c3p0-generated PooledConnections.This isn't good, and may indicate a c3p0 bug, or an unusual (and unspported) use of the c3p0 library.", (Throwable) e);
                }
            }
        }
        this.f399rp.checkinResource(pcon);
    }

    public void checkinPooledConnection(PooledConnection pcon) throws SQLException {
        try {
            pcon.removeConnectionEventListener(this.f400cl);
            unmarkConnectionInUseAndCheckin(pcon);
        } catch (ResourcePoolException e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public float getEffectivePropertyCycle() throws SQLException {
        try {
            return ((float) this.f399rp.getEffectiveExpirationEnforcementDelay()) / 1000.0f;
        } catch (ResourcePoolException e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public int getNumThreadsAwaitingCheckout() throws SQLException {
        try {
            return this.f399rp.getNumCheckoutWaiters();
        } catch (ResourcePoolException e) {
            throw SqlUtils.toSQLException(e);
        }
    }

    public int getStatementCacheNumStatements() {
        if (this.scache == null) {
            return 0;
        }
        return this.scache.getNumStatements();
    }

    public int getStatementCacheNumCheckedOut() {
        if (this.scache == null) {
            return 0;
        }
        return this.scache.getNumStatementsCheckedOut();
    }

    public int getStatementCacheNumConnectionsWithCachedStatements() {
        if (this.scache == null) {
            return 0;
        }
        return this.scache.getNumConnectionsWithCachedStatements();
    }

    public String dumpStatementCacheStatus() {
        return this.scache == null ? "Statement caching disabled." : this.scache.dumpStatementCacheStatus();
    }

    public void close() throws SQLException {
        close(true);
    }

    public void close(boolean close_outstanding_connections) throws SQLException {
        Exception throwMe = null;
        try {
            if (this.scache != null) {
                this.scache.close();
            }
        } catch (SQLException e) {
            throwMe = e;
        }
        try {
            this.f399rp.close(close_outstanding_connections);
        } catch (ResourcePoolException e2) {
            if (throwMe != null && logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "An Exception occurred while closing the StatementCache.", (Throwable) throwMe);
            }
            throwMe = e2;
        }
        if (throwMe != null) {
            throw SqlUtils.toSQLException(throwMe);
        }
    }

    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool$ConnectionEventListenerImpl */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnectionPool$ConnectionEventListenerImpl.class */
    class ConnectionEventListenerImpl implements ConnectionEventListener {
        ConnectionEventListenerImpl() {
        }

        @Override // javax.sql.ConnectionEventListener
        public void connectionClosed(ConnectionEvent evt) {
            doCheckinResource(evt);
        }

        private void doCheckinResource(ConnectionEvent evt) {
            try {
                C3P0PooledConnectionPool.this.checkinPooledConnection((PooledConnection) evt.getSource());
            } catch (Exception e) {
                C3P0PooledConnectionPool.logger.log(MLevel.WARNING, "An Exception occurred while trying to check a PooledConection into a ResourcePool.", (Throwable) e);
            }
        }

        @Override // javax.sql.ConnectionEventListener
        public void connectionErrorOccurred(ConnectionEvent evt) {
            int status;
            if (C3P0PooledConnectionPool.logger.isLoggable(MLevel.FINE)) {
                C3P0PooledConnectionPool.logger.fine("CONNECTION ERROR OCCURRED!");
            }
            PooledConnection pc = (PooledConnection) evt.getSource();
            if (pc instanceof C3P0PooledConnection) {
                status = ((C3P0PooledConnection) pc).getConnectionStatus();
            } else if (pc instanceof NewPooledConnection) {
                status = ((NewPooledConnection) pc).getConnectionStatus();
            } else {
                status = -1;
            }
            doMarkPoolStatus(pc, status);
        }

        private void doMarkPoolStatus(PooledConnection pc, int status) {
            try {
                switch (status) {
                    case -8:
                        if (C3P0PooledConnectionPool.logger.isLoggable(MLevel.WARNING)) {
                            C3P0PooledConnectionPool.logger.warning("A ConnectionTest has failed, reporting that all previously acquired Connections are likely invalid. The pool will be reset.");
                        }
                        C3P0PooledConnectionPool.this.f399rp.resetPool();
                        break;
                    case -1:
                        C3P0PooledConnectionPool.this.f399rp.markBroken(pc);
                        break;
                    case 0:
                        throw new RuntimeException("connectionErrorOcccurred() should only be called for errors fatal to the Connection.");
                    default:
                        throw new RuntimeException("Bad Connection Tester (" + C3P0PooledConnectionPool.this.connectionTester + ") returned invalid status (" + status + ").");
                }
            } catch (ResourcePoolException e) {
                C3P0PooledConnectionPool.logger.log(MLevel.WARNING, "Uh oh... our resource pool is probably broken!", (Throwable) e);
            }
        }
    }

    public int getNumConnections() throws SQLException {
        try {
            return this.f399rp.getPoolSize();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public int getNumIdleConnections() throws SQLException {
        try {
            return this.f399rp.getAvailableCount();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public int getNumBusyConnections() throws SQLException {
        try {
            return this.f399rp.getAwaitingCheckinNotExcludedCount();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public int getNumUnclosedOrphanedConnections() throws SQLException {
        try {
            return this.f399rp.getExcludedCount();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public long getStartTime() throws SQLException {
        try {
            return this.f399rp.getStartTime();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public long getUpTime() throws SQLException {
        try {
            return this.f399rp.getUpTime();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public long getNumFailedCheckins() throws SQLException {
        try {
            return this.f399rp.getNumFailedCheckins();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public long getNumFailedCheckouts() throws SQLException {
        try {
            return this.f399rp.getNumFailedCheckouts();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public long getNumFailedIdleTests() throws SQLException {
        try {
            return this.f399rp.getNumFailedIdleTests();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public Throwable getLastCheckinFailure() throws SQLException {
        try {
            return this.f399rp.getLastCheckinFailure();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public Throwable getLastCheckoutFailure() throws SQLException {
        try {
            return this.f399rp.getLastCheckoutFailure();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public Throwable getLastIdleTestFailure() throws SQLException {
        try {
            return this.f399rp.getLastIdleCheckFailure();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public Throwable getLastConnectionTestFailure() throws SQLException {
        try {
            return this.f399rp.getLastResourceTestFailure();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public Throwable getLastAcquisitionFailure() throws SQLException {
        try {
            return this.f399rp.getLastAcquisitionFailure();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    public void reset() throws SQLException {
        try {
            this.f399rp.resetPool();
        } catch (Exception e) {
            logger.log(MLevel.WARNING, (String) null, (Throwable) e);
            throw SqlUtils.toSQLException(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool$ThrowableHolderPool */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0PooledConnectionPool$ThrowableHolderPool.class */
    public static final class ThrowableHolderPool {

        /* renamed from: l */
        LinkedList f401l = new LinkedList();

        ThrowableHolderPool() {
        }

        synchronized Throwable[] getThrowableHolder() {
            if (this.f401l.size() == 0) {
                return new Throwable[1];
            }
            return (Throwable[]) this.f401l.remove(0);
        }

        synchronized void returnThrowableHolder(Throwable[] th) {
            th[0] = null;
            this.f401l.add(th);
        }
    }
}
