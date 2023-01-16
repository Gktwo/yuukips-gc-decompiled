package com.mchange.p009v2.c3p0.stmt;

import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.c3p0.stmt.GooGooStatementCache;
import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.stmt.PerConnectionMaxOnlyStatementCache */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/PerConnectionMaxOnlyStatementCache.class */
public final class PerConnectionMaxOnlyStatementCache extends GooGooStatementCache {
    int max_statements_per_connection;
    GooGooStatementCache.DeathmarchConnectionStatementManager dcsm;

    public PerConnectionMaxOnlyStatementCache(AsynchronousRunner blockingTaskAsyncRunner, AsynchronousRunner deferredStatementDestroyer, int max_statements_per_connection) {
        super(blockingTaskAsyncRunner, deferredStatementDestroyer);
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
        this.dcsm.getDeathmarch(physicalConnection).deathmarchStatement(pstmt);
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    void removeStatementFromDeathmarches(Object pstmt, Connection physicalConnection) {
        this.dcsm.getDeathmarch(physicalConnection).undeathmarchStatement(pstmt);
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    boolean prepareAssimilateNewStatement(Connection pcon) {
        int cxn_stmt_count = this.dcsm.getNumStatementsForConnection(pcon);
        return cxn_stmt_count < this.max_statements_per_connection || (cxn_stmt_count == this.max_statements_per_connection && this.dcsm.getDeathmarch(pcon).cullNext());
    }
}
