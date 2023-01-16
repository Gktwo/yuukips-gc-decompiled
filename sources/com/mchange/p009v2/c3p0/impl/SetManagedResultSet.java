package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.sql.filter.FilterResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.c3p0.impl.SetManagedResultSet */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/SetManagedResultSet.class */
public abstract class SetManagedResultSet extends FilterResultSet {
    Set activeResultSets;

    /* access modifiers changed from: package-private */
    public SetManagedResultSet(Set activeResultSets) {
        this.activeResultSets = activeResultSets;
    }

    /* access modifiers changed from: package-private */
    public SetManagedResultSet(ResultSet inner, Set activeResultSets) {
        super(inner);
        this.activeResultSets = activeResultSets;
    }

    @Override // com.mchange.p009v2.sql.filter.FilterResultSet
    public synchronized void setInner(ResultSet inner) {
        this.inner = inner;
        this.activeResultSets.add(inner);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterResultSet, java.sql.ResultSet, java.lang.AutoCloseable
    public synchronized void close() throws SQLException {
        if (this.inner != null) {
            this.inner.close();
            this.activeResultSets.remove(this.inner);
            this.inner = null;
        }
    }
}
