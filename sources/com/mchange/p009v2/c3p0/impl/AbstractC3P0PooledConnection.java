package com.mchange.p009v2.c3p0.impl;

import com.mchange.p006v1.util.ClosableResource;
import com.mchange.p009v2.c3p0.stmt.GooGooStatementCache;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.PooledConnection;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.c3p0.impl.AbstractC3P0PooledConnection */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/AbstractC3P0PooledConnection.class */
public abstract class AbstractC3P0PooledConnection implements PooledConnection, ClosableResource {
    final Object inInternalUseLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract Connection getPhysicalConnection();

    /* access modifiers changed from: package-private */
    public abstract void initStatementCache(GooGooStatementCache gooGooStatementCache);

    /* access modifiers changed from: package-private */
    public abstract void closeMaybeCheckedOut(boolean z) throws SQLException;
}
