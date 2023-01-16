package com.mchange.p009v2.c3p0;

import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.FullQueryConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/FullQueryConnectionTester.class */
public interface FullQueryConnectionTester extends QueryConnectionTester {
    int statusOnException(Connection connection, Throwable th, String str);
}
