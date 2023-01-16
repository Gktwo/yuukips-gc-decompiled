package com.mchange.p009v2.c3p0.util;

import com.mchange.p009v2.sql.filter.FilterConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;

/* renamed from: com.mchange.v2.c3p0.util.CloseReportingConnectionWrapper */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/util/CloseReportingConnectionWrapper.class */
public class CloseReportingConnectionWrapper extends FilterConnection {
    public CloseReportingConnectionWrapper(Connection conn) {
        super(conn);
    }

    @Override // com.mchange.p009v2.sql.filter.FilterConnection, java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        new SQLWarning("Connection.close() called!").printStackTrace();
        close();
    }
}
