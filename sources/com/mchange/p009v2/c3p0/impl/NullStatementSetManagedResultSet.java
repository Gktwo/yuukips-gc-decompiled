package com.mchange.p009v2.c3p0.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.c3p0.impl.NullStatementSetManagedResultSet */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/NullStatementSetManagedResultSet.class */
public final class NullStatementSetManagedResultSet extends SetManagedResultSet {
    NullStatementSetManagedResultSet(Set activeResultSets) {
        super(activeResultSets);
    }

    /* access modifiers changed from: package-private */
    public NullStatementSetManagedResultSet(ResultSet inner, Set activeResultSets) {
        super(inner, activeResultSets);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterResultSet, java.sql.ResultSet
    public Statement getStatement() {
        return null;
    }
}
