package org.quartz.impl.jdbcjobstore;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/DB2v8Delegate.class */
public class DB2v8Delegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected void setBoolean(PreparedStatement ps, int index, boolean val) throws SQLException {
        ps.setInt(index, val ? 1 : 0);
    }
}
