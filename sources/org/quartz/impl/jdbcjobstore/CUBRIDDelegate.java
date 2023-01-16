package org.quartz.impl.jdbcjobstore;

import com.mchange.p009v2.c3p0.C3P0ProxyConnection;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/CUBRIDDelegate.class */
public class CUBRIDDelegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        Object obj = null;
        Blob blob = rs.getBlob(colName);
        byte[] bytes = blob.getBytes(1, (int) blob.length());
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
        Blob blob = rs.getBlob(colName);
        byte[] bytes = blob.getBytes(1, (int) blob.length());
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return new ByteArrayInputStream(bytes);
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected void setBytes(PreparedStatement ps, int index, ByteArrayOutputStream baos) throws SQLException {
        byte[] byteArray;
        if (baos == null) {
            byteArray = new byte[0];
        } else {
            byteArray = baos.toByteArray();
        }
        Connection conn = ps.getConnection();
        if (conn instanceof C3P0ProxyConnection) {
            try {
                Blob blob = (Blob) ((C3P0ProxyConnection) conn).rawConnectionOperation(Connection.class.getMethod("createBlob", new Class[0]), C3P0ProxyConnection.RAW_CONNECTION, new Object[0]);
                blob.setBytes(1, byteArray);
                ps.setBlob(index, blob);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            Blob blob2 = ps.getConnection().createBlob();
            blob2.setBytes(1, byteArray);
            ps.setBlob(index, blob2);
        }
    }
}
