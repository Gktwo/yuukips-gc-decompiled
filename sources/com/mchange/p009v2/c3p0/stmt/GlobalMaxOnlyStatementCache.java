package com.mchange.p009v2.c3p0.stmt;

import com.mchange.p009v2.async.AsynchronousRunner;
import com.mchange.p009v2.c3p0.stmt.GooGooStatementCache;
import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.stmt.GlobalMaxOnlyStatementCache */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/GlobalMaxOnlyStatementCache.class */
public final class GlobalMaxOnlyStatementCache extends GooGooStatementCache {
    int max_statements;
    GooGooStatementCache.Deathmarch globalDeathmarch = new GooGooStatementCache.Deathmarch();

    public GlobalMaxOnlyStatementCache(AsynchronousRunner blockingTaskAsyncRunner, AsynchronousRunner deferredStatementDestroyer, int max_statements) {
        super(blockingTaskAsyncRunner, deferredStatementDestroyer);
        this.max_statements = max_statements;
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    protected GooGooStatementCache.ConnectionStatementManager createConnectionStatementManager() {
        return new GooGooStatementCache.SimpleConnectionStatementManager();
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    void addStatementToDeathmarches(Object pstmt, Connection physicalConnection) {
        this.globalDeathmarch.deathmarchStatement(pstmt);
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    void removeStatementFromDeathmarches(Object pstmt, Connection physicalConnection) {
        this.globalDeathmarch.undeathmarchStatement(pstmt);
    }

    @Override // com.mchange.p009v2.c3p0.stmt.GooGooStatementCache
    boolean prepareAssimilateNewStatement(Connection pcon) {
        int global_size = countCachedStatements();
        return global_size < this.max_statements || (global_size == this.max_statements && this.globalDeathmarch.cullNext());
    }
}
