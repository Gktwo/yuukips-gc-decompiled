package org.quartz.impl.jdbcjobstore;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.ByteArrayOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/DB2v7Delegate.class */
public class DB2v7Delegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected void setBytes(PreparedStatement ps, int index, ByteArrayOutputStream baos) throws SQLException {
        ps.setObject(index, baos == null ? null : baos.toByteArray(), RetcodeOuterClass.Retcode.RET_ORDER_INFO_NOT_EXIST_VALUE);
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected void setBoolean(PreparedStatement ps, int index, boolean val) throws SQLException {
        ps.setString(index, val ? "1" : "0");
    }
}
