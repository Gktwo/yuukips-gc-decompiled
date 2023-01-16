package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/WebLogicDelegate.class */
public class WebLogicDelegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        Object obj = null;
        Blob blobLocator = rs.getBlob(colName);
        InputStream binaryInput = null;
        if (null != blobLocator) {
            try {
                if (blobLocator.length() > 0) {
                    binaryInput = blobLocator.getBinaryStream();
                }
            } catch (Exception e) {
            }
        }
        if (null != binaryInput) {
            ObjectInputStream in = new ObjectInputStream(binaryInput);
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
        Blob blobLocator = rs.getBlob(colName);
        InputStream binaryInput = null;
        if (null != blobLocator) {
            try {
                if (blobLocator.length() > 0) {
                    binaryInput = blobLocator.getBinaryStream();
                }
            } catch (Exception e) {
            }
        }
        return binaryInput;
    }
}
