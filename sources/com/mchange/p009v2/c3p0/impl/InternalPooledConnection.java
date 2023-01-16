package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.stmt.GooGooStatementCache;
import javax.sql.PooledConnection;

/* renamed from: com.mchange.v2.c3p0.impl.InternalPooledConnection */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/InternalPooledConnection.class */
interface InternalPooledConnection extends PooledConnection {
    void initStatementCache(GooGooStatementCache gooGooStatementCache);

    GooGooStatementCache getStatementCache();

    int getConnectionStatus();
}
