package org.quartz.impl.jdbcjobstore;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/PostgreSQLDelegate.class */
public class PostgreSQLDelegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        byte[] bytes = rs.getBytes(colName);
        Object obj = null;
        if (!(bytes == null || bytes.length == 0)) {
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
            try {
                obj = in.readObject();
                in.close();
            } catch (Throwable th) {
                in.close();
                throw th;
            }
        }
        return obj;
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getJobDataFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        if (!canUseProperties()) {
            return getObjectFromBlob(rs, colName);
        }
        byte[] bytes = rs.getBytes(colName);
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return new ByteArrayInputStream(bytes);
    }
}
