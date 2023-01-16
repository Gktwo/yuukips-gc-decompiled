package com.mchange.p009v2.c3p0;

import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.UnifiedConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/UnifiedConnectionTester.class */
public interface UnifiedConnectionTester extends FullQueryConnectionTester {
    public static final int CONNECTION_IS_OKAY = 0;
    public static final int CONNECTION_IS_INVALID = -1;
    public static final int DATABASE_IS_INVALID = -8;

    @Override // com.mchange.p009v2.c3p0.ConnectionTester
    int activeCheckConnection(Connection connection);

    int activeCheckConnection(Connection connection, Throwable[] thArr);

    @Override // com.mchange.p009v2.c3p0.QueryConnectionTester
    int activeCheckConnection(Connection connection, String str);

    int activeCheckConnection(Connection connection, String str, Throwable[] thArr);

    @Override // com.mchange.p009v2.c3p0.ConnectionTester
    int statusOnException(Connection connection, Throwable th);

    int statusOnException(Connection connection, Throwable th, Throwable[] thArr);

    @Override // com.mchange.p009v2.c3p0.FullQueryConnectionTester
    int statusOnException(Connection connection, Throwable th, String str);

    int statusOnException(Connection connection, Throwable th, String str, Throwable[] thArr);

    @Override // com.mchange.p009v2.c3p0.ConnectionTester, java.lang.Object
    boolean equals(Object obj);

    @Override // com.mchange.p009v2.c3p0.ConnectionTester, java.lang.Object
    int hashCode();
}
