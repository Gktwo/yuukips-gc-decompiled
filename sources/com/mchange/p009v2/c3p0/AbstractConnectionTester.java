package com.mchange.p009v2.c3p0;

import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.AbstractConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/AbstractConnectionTester.class */
public abstract class AbstractConnectionTester implements UnifiedConnectionTester {
    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public abstract int activeCheckConnection(Connection connection, String str, Throwable[] thArr);

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public abstract int statusOnException(Connection connection, Throwable th, String str, Throwable[] thArr);

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester, com.mchange.p009v2.c3p0.ConnectionTester
    public int activeCheckConnection(Connection c) {
        return activeCheckConnection(c, null, null);
    }

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public int activeCheckConnection(Connection c, Throwable[] rootCauseOutParamHolder) {
        return activeCheckConnection(c, null, rootCauseOutParamHolder);
    }

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester, com.mchange.p009v2.c3p0.QueryConnectionTester
    public int activeCheckConnection(Connection c, String preferredTestQuery) {
        return activeCheckConnection(c, preferredTestQuery, null);
    }

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester, com.mchange.p009v2.c3p0.ConnectionTester
    public int statusOnException(Connection c, Throwable t) {
        return statusOnException(c, t, null, null);
    }

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public int statusOnException(Connection c, Throwable t, Throwable[] rootCauseOutParamHolder) {
        return statusOnException(c, t, null, rootCauseOutParamHolder);
    }

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester, com.mchange.p009v2.c3p0.FullQueryConnectionTester
    public int statusOnException(Connection c, Throwable t, String preferredTestQuery) {
        return statusOnException(c, t, preferredTestQuery, null);
    }
}
