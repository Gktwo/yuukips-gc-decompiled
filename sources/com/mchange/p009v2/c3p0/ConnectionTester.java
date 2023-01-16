package com.mchange.p009v2.c3p0;

import java.io.Serializable;
import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.ConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/ConnectionTester.class */
public interface ConnectionTester extends Serializable {
    public static final int CONNECTION_IS_OKAY = 0;
    public static final int CONNECTION_IS_INVALID = -1;
    public static final int DATABASE_IS_INVALID = -8;

    int activeCheckConnection(Connection connection);

    int statusOnException(Connection connection, Throwable th);

    @Override // java.lang.Object
    boolean equals(Object obj);

    @Override // java.lang.Object
    int hashCode();
}
