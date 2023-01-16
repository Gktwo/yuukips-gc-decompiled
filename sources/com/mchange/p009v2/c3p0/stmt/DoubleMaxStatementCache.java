package com.mchange.p009v2.c3p0.stmt;

import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.c3p0.stmt.GooGooStatementCache;
import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.stmt.DoubleMaxStatementCache */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/DoubleMaxStatementCache.class */
public final class DoubleMaxStatementCache extends GooGooStatementCache {
    int max_statements;
    GooGooStatementCache.Deathmarch globalDeathmarch = new GooGooStatementCache.Deathmarch();
    int max_statements_per_connection;
    GooGooStatementCache.DeathmarchConnectionStatementManager dcsm;

    public DoubleMaxStatementCache(AsynchronousRunner blockingTaskAsyncRunner, AsynchronousRunner deferredStatementDestroyer, int max_statements, int max_statements_per_connection) {
        super(blockingTaskAsyncRunner, deferredStatementDestroyer);
        this.max_statements = max_statements;
        this.max_statements_per_connection = max_statements_per_connection;
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    protected GooGooStatementCache.ConnectionStatementManager createConnectionStatementManager() {
        GooGooStatementCache.DeathmarchConnectionStatementManager deathmarchConnectionStatementManager = new GooGooStatementCache.DeathmarchConnectionStatementManager();
        this.dcsm = deathmarchConnectionStatementManager;
        return deathmarchConnectionStatementManager;
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    void addStatementToDeathmarches(Object pstmt, Connection physicalConnection) {
        this.globalDeathmarch.deathmarchStatement(pstmt);
        this.dcsm.getDeathmarch(physicalConnection).deathmarchStatement(pstmt);
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    void removeStatementFromDeathmarches(Object pstmt, Connection physicalConnection) {
        this.globalDeathmarch.undeathmarchStatement(pstmt);
        this.dcsm.getDeathmarch(physicalConnection).undeathmarchStatement(pstmt);
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    boolean prepareAssimilateNewStatement(Connection pcon) {
        int cxn_stmt_count = this.dcsm.getNumStatementsForConnection(pcon);
        if (cxn_stmt_count >= this.max_statements_per_connection) {
            return cxn_stmt_count == this.max_statements_per_connection && this.dcsm.getDeathmarch(pcon).cullNext();
        }
        int global_size = countCachedStatements();
        return global_size < this.max_statements || (global_size == this.max_statements && this.globalDeathmarch.cullNext());
    }
}
