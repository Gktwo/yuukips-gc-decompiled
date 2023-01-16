package com.mchange.p009v2.c3p0.stmt;

import com.mchange.p006v1.util.ClosableResource;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

/* renamed from: com.mchange.v2.c3p0.stmt.StatementCache */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/StatementCache.class */
public interface StatementCache extends ClosableResource {
    Object checkoutStatement(Connection connection, Method method, Object[] objArr) throws SQLException;

    void checkinStatement(Object obj) throws SQLException;

    void checkinAll(Connection connection) throws SQLException;

    void closeAll(Connection connection) throws SQLException;

    @Override // com.mchange.p006v1.util.ClosableResource
    void close() throws SQLException;
}
