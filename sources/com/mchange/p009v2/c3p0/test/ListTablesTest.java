package com.mchange.p009v2.c3p0.test;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p006v1.p007db.sql.ResultSetUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.ListTablesTest */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/ListTablesTest.class */
public final class ListTablesTest {
    public static void main(String[] argv) {
        try {
            DataSource ds = (DataSource) new InitialContext().lookup(argv[0]);
            System.err.println(ds.getClass());
            Connection con = ds.getConnection();
            ResultSet rs = con.getMetaData().getTables(null, null, "%", null);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
            ResultSetUtils.attemptClose(rs);
            ConnectionUtils.attemptClose(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
