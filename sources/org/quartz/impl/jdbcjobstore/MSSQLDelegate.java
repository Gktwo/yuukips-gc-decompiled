package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/MSSQLDelegate.class */
public class MSSQLDelegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        InputStream binaryInput = rs.getBinaryStream(colName);
        if (binaryInput == null || binaryInput.available() == 0) {
            return null;
        }
        ObjectInputStream in = new ObjectInputStream(binaryInput);
        try {
            Object obj = in.readObject();
            in.close();
            return obj;
        } catch (Throwable th) {
            in.close();
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getJobDataFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        if (canUseProperties()) {
            return rs.getBinaryStream(colName);
        }
        return getObjectFromBlob(rs, colName);
    }
}
