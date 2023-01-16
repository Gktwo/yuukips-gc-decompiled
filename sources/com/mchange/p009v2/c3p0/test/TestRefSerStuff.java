package com.mchange.p009v2.c3p0.test;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p006v1.p007db.sql.StatementUtils;
import com.mchange.p009v2.c3p0.ComboPooledDataSource;
import com.mchange.p009v2.c3p0.DriverManagerDataSource;
import com.mchange.p009v2.c3p0.PoolBackedDataSource;
import com.mchange.p009v2.c3p0.WrapperConnectionPoolDataSource;
import com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource;
import com.mchange.p009v2.naming.ReferenceableUtils;
import com.mchange.p009v2.ser.SerializableUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Referenceable;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.TestRefSerStuff */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/TestRefSerStuff.class */
public final class TestRefSerStuff {
    static String toString(DataSource ds) {
        if (ds instanceof AbstractPoolBackedDataSource) {
            return ((AbstractPoolBackedDataSource) ds).toString(true);
        }
        return ds.toString();
    }

    static void create(DataSource ds) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE TRSS_TABLE ( a_col VARCHAR(16) )");
        } finally {
            StatementUtils.attemptClose(stmt);
            ConnectionUtils.attemptClose(con);
        }
    }

    static void drop(DataSource ds) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("DROP TABLE TRSS_TABLE");
        } finally {
            StatementUtils.attemptClose(stmt);
            ConnectionUtils.attemptClose(con);
        }
    }

    static void doSomething(DataSource ds) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            if (stmt.executeUpdate("INSERT INTO TRSS_TABLE VALUES ('" + System.currentTimeMillis() + "')") != 1) {
                throw new SQLException("Insert failed somehow strange!");
            }
        } finally {
            StatementUtils.attemptClose(stmt);
            ConnectionUtils.attemptClose(con);
        }
    }

    static void doTest(DataSource checkMe) throws Exception {
        doSomething(checkMe);
        System.err.println("\tcreated:   " + toString(checkMe));
        DataSource afterSer = (DataSource) SerializableUtils.testSerializeDeserialize(checkMe);
        doSomething(afterSer);
        System.err.println("\tafter ser: " + toString(afterSer));
        DataSource afterRef = (DataSource) ReferenceableUtils.referenceToObject(((Referenceable) checkMe).getReference(), null, null, null);
        doSomething(afterRef);
        System.err.println("\tafter ref: " + toString(afterRef));
    }

    public static void main(String[] argv) {
        if (argv.length > 0) {
            System.err.println(TestRefSerStuff.class.getName() + " now requires no args. Please set everything in standard c3p0 config files.");
            return;
        }
        try {
            DriverManagerDataSource dmds = new DriverManagerDataSource();
            try {
                drop(dmds);
            } catch (Exception e) {
            }
            create(dmds);
            System.err.println("DriverManagerDataSource:");
            doTest(dmds);
            WrapperConnectionPoolDataSource wcpds = new WrapperConnectionPoolDataSource();
            wcpds.setNestedDataSource(dmds);
            PoolBackedDataSource pbds = new PoolBackedDataSource();
            pbds.setConnectionPoolDataSource(wcpds);
            System.err.println("PoolBackedDataSource:");
            doTest(pbds);
            doTest(new ComboPooledDataSource());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
