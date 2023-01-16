package com.mchange.p009v2.c3p0;

import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.ConnectionCustomizer */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/ConnectionCustomizer.class */
public interface ConnectionCustomizer {
    void onAcquire(Connection connection, String str) throws Exception;

    void onDestroy(Connection connection, String str) throws Exception;

    void onCheckOut(Connection connection, String str) throws Exception;

    void onCheckIn(Connection connection, String str) throws Exception;
}
