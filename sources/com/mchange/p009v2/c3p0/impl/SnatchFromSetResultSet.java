package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.sql.filter.FilterResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/* renamed from: com.mchange.v2.c3p0.impl.SnatchFromSetResultSet */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/SnatchFromSetResultSet.class */
final class SnatchFromSetResultSet extends FilterResultSet {
    Set activeResultSets;

    SnatchFromSetResultSet(Set activeResultSets) {
        this.activeResultSets = activeResultSets;
    }

    @Override // com.mchange.p009v2.sql.filter.FilterResultSet
    public synchronized void setInner(ResultSet inner) {
        this.inner = inner;
        this.activeResultSets.add(inner);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterResultSet, java.sql.ResultSet, java.lang.AutoCloseable
    public synchronized void close() throws SQLException {
        this.inner.close();
        this.activeResultSets.remove(this.inner);
        this.inner = null;
    }
}
