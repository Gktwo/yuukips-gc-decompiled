package org.quartz.impl.jdbcjobstore.oracle.weblogic;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.quartz.impl.jdbcjobstore.oracle.OracleDelegate;
import weblogic.jdbc.vendor.oracle.OracleThinBlob;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/oracle/weblogic/WebLogicOracleDelegate.class */
public class WebLogicOracleDelegate extends OracleDelegate {
    /* access modifiers changed from: protected */
    @Override // org.quartz.impl.jdbcjobstore.oracle.OracleDelegate
    public Blob writeDataToBlob(ResultSet rs, int column, byte[] data) throws SQLException {
        Blob blob = rs.getBlob(column);
        if (blob == null) {
            throw new SQLException("Driver's Blob representation is null!");
        } else if (blob instanceof OracleThinBlob) {
            ((OracleThinBlob) blob).putBytes(1, data);
            return blob;
        } else if (!blob.getClass().getPackage().getName().startsWith("weblogic.")) {
            return writeDataToBlob(rs, column, data);
        } else {
            try {
                blob.getClass().getMethod("putBytes", Long.TYPE, byte[].class).invoke(blob, new Long(1), data);
            } catch (Exception e) {
                try {
                    blob.getClass().getMethod("setBytes", Long.TYPE, byte[].class).invoke(blob, new Long(1), data);
                } catch (Exception e2) {
                    throw new SQLException("Unable to find putBytes(long,byte[]) or setBytes(long,byte[]) methods on blob: " + e2);
                }
            }
            return blob;
        }
    }
}
