package com.mchange.p009v2.c3p0;

import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.QueryConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/QueryConnectionTester.class */
public interface QueryConnectionTester extends ConnectionTester {
    int activeCheckConnection(Connection connection, String str);
}
