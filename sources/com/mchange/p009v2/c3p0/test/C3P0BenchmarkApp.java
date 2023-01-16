package com.mchange.p009v2.c3p0.test;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p006v1.p007db.sql.ResultSetUtils;
import com.mchange.p006v1.p007db.sql.StatementUtils;
import com.mchange.p009v2.c3p0.ComboPooledDataSource;
import com.mchange.p009v2.c3p0.DataSources;
import com.mchange.p009v2.c3p0.DriverManagerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp.class */
public final class C3P0BenchmarkApp {
    static final String EMPTY_TABLE_CREATE = "CREATE TABLE emptyyukyuk (a varchar(8), b varchar(8))";
    static final String EMPTY_TABLE_SELECT = "SELECT * FROM emptyyukyuk";
    static final String EMPTY_TABLE_DROP = "DROP TABLE emptyyukyuk";
    static final String EMPTY_TABLE_CONDITIONAL_SELECT = "SELECT * FROM emptyyukyuk where a = ?";
    static final String N_ENTRY_TABLE_CREATE = "CREATE TABLE n_entryyukyuk (a INTEGER)";
    static final String N_ENTRY_TABLE_INSERT = "INSERT INTO n_entryyukyuk VALUES ( ? )";
    static final String N_ENTRY_TABLE_SELECT = "SELECT * FROM n_entryyukyuk";
    static final String N_ENTRY_TABLE_DROP = "DROP TABLE n_entryyukyuk";
    static final int NUM_ITERATIONS = 2000;

    public static void main(String[] argv) {
        if (argv.length > 0) {
            System.err.println(C3P0BenchmarkApp.class.getName() + " now requires no args. Please set everything in standard c3p0 config files.");
            return;
        }
        DataSource ds_unpooled = null;
        DataSource ds_pooled = null;
        try {
            ds_unpooled = new DriverManagerDataSource();
            ds_pooled = new ComboPooledDataSource();
            ds_pooled.getParentLogger().info("Pooled DataSource created.");
            create(ds_pooled);
            System.out.println("Please wait. Tests can be very slow.");
            List l = new ArrayList();
            l.add(new ConnectionAcquisitionTest());
            l.add(new StatementCreateTest());
            l.add(new StatementEmptyTableSelectTest());
            l.add(new PreparedStatementEmptyTableSelectTest());
            l.add(new PreparedStatementAcquireTest());
            l.add(new ResultSetReadTest());
            l.add(new FiveThreadPSQueryTestTest());
            int len = l.size();
            for (int i = 0; i < len; i++) {
                ((Test) l.get(i)).perform(ds_unpooled, ds_pooled, 2000);
            }
            try {
                drop(ds_pooled);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                DataSources.destroy(ds_pooled);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                DataSources.destroy(ds_unpooled);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                drop(ds_pooled);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                DataSources.destroy(ds_pooled);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                DataSources.destroy(ds_unpooled);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }

    static void create(DataSource ds) throws SQLException {
        System.err.println("Creating test schema.");
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        try {
            con = ds.getConnection();
            ps1 = con.prepareStatement(EMPTY_TABLE_CREATE);
            ps2 = con.prepareStatement(N_ENTRY_TABLE_CREATE);
            ps3 = con.prepareStatement(N_ENTRY_TABLE_INSERT);
            ps1.executeUpdate();
            ps2.executeUpdate();
            for (int i = 0; i < 2000; i++) {
                ps3.setInt(1, i);
                ps3.executeUpdate();
                System.err.print('.');
            }
            System.err.println();
            System.err.println("Test schema created.");
            StatementUtils.attemptClose(ps1);
            StatementUtils.attemptClose(ps2);
            StatementUtils.attemptClose(ps3);
            ConnectionUtils.attemptClose(con);
        } catch (Throwable th) {
            StatementUtils.attemptClose(ps1);
            StatementUtils.attemptClose(ps2);
            StatementUtils.attemptClose(ps3);
            ConnectionUtils.attemptClose(con);
            throw th;
        }
    }

    static void drop(DataSource ds) throws SQLException {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            con = ds.getConnection();
            ps1 = con.prepareStatement(EMPTY_TABLE_DROP);
            ps2 = con.prepareStatement(N_ENTRY_TABLE_DROP);
            ps1.executeUpdate();
            ps2.executeUpdate();
            System.err.println("Test schema dropped.");
            StatementUtils.attemptClose(ps1);
            StatementUtils.attemptClose(ps2);
            ConnectionUtils.attemptClose(con);
        } catch (Throwable th) {
            StatementUtils.attemptClose(ps1);
            StatementUtils.attemptClose(ps2);
            ConnectionUtils.attemptClose(con);
            throw th;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$Test */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$Test.class */
    static abstract class Test {
        String name;

        protected abstract long test(DataSource dataSource, int i) throws Exception;

        Test(String name) {
            this.name = name;
        }

        public void perform(DataSource unpooled, DataSource pooled, int iterations) throws Exception {
            double msecs_unpooled = ((double) test(unpooled, iterations)) / ((double) iterations);
            double msecs_pooled = ((double) test(pooled, iterations)) / ((double) iterations);
            System.out.println(this.name + " [ " + iterations + " iterations ]:");
            System.out.println("\tunpooled: " + msecs_unpooled + " msecs");
            System.out.println("\t  pooled: " + msecs_pooled + " msecs");
            System.out.println("\tspeed-up factor: " + (msecs_unpooled / msecs_pooled) + " times");
            System.out.println("\tspeed-up absolute: " + (msecs_unpooled - msecs_pooled) + " msecs");
            System.out.println();
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$ConnectionAcquisitionTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$ConnectionAcquisitionTest.class */
    static class ConnectionAcquisitionTest extends Test {
        ConnectionAcquisitionTest() {
            super("Connection Acquisition and Cleanup");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws Exception {
            long start = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                Connection con = null;
                try {
                    con = ds.getConnection();
                    ConnectionUtils.attemptClose(con);
                } catch (Throwable th) {
                    ConnectionUtils.attemptClose(con);
                    throw th;
                }
            }
            return System.currentTimeMillis() - start;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$StatementCreateTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$StatementCreateTest.class */
    static class StatementCreateTest extends Test {
        StatementCreateTest() {
            super("Statement Creation and Cleanup");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws SQLException {
            Connection con = null;
            try {
                con = ds.getConnection();
                long test = test(con, n);
                ConnectionUtils.attemptClose(con);
                return test;
            } catch (Throwable th) {
                ConnectionUtils.attemptClose(con);
                throw th;
            }
        }

        long test(Connection con, int n) throws SQLException {
            Statement stmt = null;
            long start = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                try {
                    stmt = con.createStatement();
                    StatementUtils.attemptClose(stmt);
                } catch (Throwable th) {
                    StatementUtils.attemptClose(stmt);
                    throw th;
                }
            }
            return System.currentTimeMillis() - start;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$StatementEmptyTableSelectTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$StatementEmptyTableSelectTest.class */
    static class StatementEmptyTableSelectTest extends Test {
        StatementEmptyTableSelectTest() {
            super("Empty Table Statement Select (on a single Statement)");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws SQLException {
            Connection con = null;
            Statement stmt = null;
            try {
                con = ds.getConnection();
                stmt = con.createStatement();
                long test = test(stmt, n);
                StatementUtils.attemptClose(stmt);
                ConnectionUtils.attemptClose(con);
                return test;
            } catch (Throwable th) {
                StatementUtils.attemptClose(stmt);
                ConnectionUtils.attemptClose(con);
                throw th;
            }
        }

        long test(Statement stmt, int n) throws SQLException {
            long start = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                stmt.executeQuery(C3P0BenchmarkApp.EMPTY_TABLE_SELECT).close();
            }
            return System.currentTimeMillis() - start;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$DataBaseMetaDataListNonexistentTablesTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$DataBaseMetaDataListNonexistentTablesTest.class */
    static class DataBaseMetaDataListNonexistentTablesTest extends Test {
        DataBaseMetaDataListNonexistentTablesTest() {
            super("DataBaseMetaDataListNonexistentTablesTest");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws SQLException {
            Connection con = null;
            try {
                con = ds.getConnection();
                long test = test(con, n);
                StatementUtils.attemptClose(null);
                ConnectionUtils.attemptClose(con);
                return test;
            } catch (Throwable th) {
                StatementUtils.attemptClose(null);
                ConnectionUtils.attemptClose(con);
                throw th;
            }
        }

        long test(Connection con, int n) throws SQLException {
            ResultSet rs = null;
            try {
                long start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    rs = con.getMetaData().getTables(null, null, "PROBABLYNOT", new String[]{"TABLE"});
                }
                long currentTimeMillis = System.currentTimeMillis() - start;
                ResultSetUtils.attemptClose(rs);
                return currentTimeMillis;
            } catch (Throwable th) {
                ResultSetUtils.attemptClose(rs);
                throw th;
            }
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$PreparedStatementAcquireTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$PreparedStatementAcquireTest.class */
    static class PreparedStatementAcquireTest extends Test {
        PreparedStatementAcquireTest() {
            super("Acquire and Cleanup a PreparedStatement (same statement, many times)");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws SQLException {
            Connection con = null;
            try {
                con = ds.getConnection();
                long start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    StatementUtils.attemptClose(con.prepareStatement(C3P0BenchmarkApp.EMPTY_TABLE_CONDITIONAL_SELECT));
                }
                long currentTimeMillis = System.currentTimeMillis() - start;
                ConnectionUtils.attemptClose(con);
                return currentTimeMillis;
            } catch (Throwable th) {
                ConnectionUtils.attemptClose(con);
                throw th;
            }
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$PreparedStatementEmptyTableSelectTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$PreparedStatementEmptyTableSelectTest.class */
    static class PreparedStatementEmptyTableSelectTest extends Test {
        PreparedStatementEmptyTableSelectTest() {
            super("Empty Table PreparedStatement Select (on a single PreparedStatement)");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws SQLException {
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(C3P0BenchmarkApp.EMPTY_TABLE_SELECT);
                long test = test(pstmt, n);
                StatementUtils.attemptClose(pstmt);
                ConnectionUtils.attemptClose(con);
                return test;
            } catch (Throwable th) {
                StatementUtils.attemptClose(pstmt);
                ConnectionUtils.attemptClose(con);
                throw th;
            }
        }

        long test(PreparedStatement pstmt, int n) throws SQLException {
            long start = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                pstmt.executeQuery().close();
            }
            return System.currentTimeMillis() - start;
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$ResultSetReadTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$ResultSetReadTest.class */
    static class ResultSetReadTest extends Test {
        ResultSetReadTest() {
            super("Reading one row / one entry from a result set");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws SQLException {
            if (n > 10000) {
                throw new IllegalArgumentException("10K max.");
            }
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                con = ds.getConnection();
                pstmt = con.prepareStatement(C3P0BenchmarkApp.N_ENTRY_TABLE_SELECT);
                rs = pstmt.executeQuery();
                long start = System.currentTimeMillis();
                for (int i = 0; i < n; i++) {
                    if (!rs.next()) {
                        System.err.println("huh?");
                    }
                    rs.getInt(1);
                }
                long currentTimeMillis = System.currentTimeMillis() - start;
                ResultSetUtils.attemptClose(rs);
                StatementUtils.attemptClose(pstmt);
                ConnectionUtils.attemptClose(con);
                return currentTimeMillis;
            } catch (Throwable th) {
                ResultSetUtils.attemptClose(rs);
                StatementUtils.attemptClose(pstmt);
                ConnectionUtils.attemptClose(con);
                throw th;
            }
        }
    }

    /* renamed from: com.mchange.v2.c3p0.test.C3P0BenchmarkApp$FiveThreadPSQueryTestTest */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/C3P0BenchmarkApp$FiveThreadPSQueryTestTest.class */
    static class FiveThreadPSQueryTestTest extends Test {
        FiveThreadPSQueryTestTest() {
            super("Five threads getting a connection, executing a query, " + System.getProperty("line.separator") + "and retrieving results concurrently via a prepared statement (in a transaction).");
        }

        @Override // com.mchange.p009v2.c3p0.test.C3P0BenchmarkApp.Test
        protected long test(DataSource ds, int n) throws Exception {
            long start = System.currentTimeMillis();
            Thread[] ts = new Thread[5];
            for (int i = 0; i < 5; i++) {
                ts[i] = new Thread(i, n, ds) { // from class: com.mchange.v2.c3p0.test.C3P0BenchmarkApp.FiveThreadPSQueryTestTest.1QueryThread
                    final /* synthetic */ int val$n;
                    final /* synthetic */ DataSource val$ds;

                    /* JADX WARN: Incorrect args count in method signature: (I)V */
                    {
                        this.val$n = r7;
                        this.val$ds = r8;
                    }

                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Connection con = null;
                        PreparedStatement pstmt = null;
                        ResultSet rs = null;
                        for (int i2 = 0; i2 < this.val$n / 5; i2++) {
                            try {
                                try {
                                    con = this.val$ds.getConnection();
                                    con.setAutoCommit(false);
                                    pstmt = con.prepareStatement(C3P0BenchmarkApp.EMPTY_TABLE_CONDITIONAL_SELECT);
                                    pstmt.setString(1, "boo");
                                    rs = pstmt.executeQuery();
                                    while (rs.next()) {
                                        System.err.println("Huh?? Empty table has values?");
                                    }
                                    con.commit();
                                    ResultSetUtils.attemptClose(rs);
                                    StatementUtils.attemptClose(pstmt);
                                    ConnectionUtils.attemptClose(con);
                                } catch (Exception e) {
                                    System.err.print("FiveThreadPSQueryTestTest exception -- ");
                                    e.printStackTrace();
                                    if (con != null) {
                                        try {
                                            con.rollback();
                                        } catch (SQLException e2) {
                                            System.err.print("Rollback on exception failed! -- ");
                                            e2.printStackTrace();
                                            ResultSetUtils.attemptClose(rs);
                                            StatementUtils.attemptClose(pstmt);
                                            ConnectionUtils.attemptClose(con);
                                            con = null;
                                        }
                                    }
                                    ResultSetUtils.attemptClose(rs);
                                    StatementUtils.attemptClose(pstmt);
                                    ConnectionUtils.attemptClose(con);
                                }
                                con = null;
                            } catch (Throwable th) {
                                ResultSetUtils.attemptClose(rs);
                                StatementUtils.attemptClose(pstmt);
                                ConnectionUtils.attemptClose(con);
                                throw th;
                            }
                        }
                    }
                };
                ts[i].start();
            }
            for (int i2 = 0; i2 < 5; i2++) {
                ts[i2].join();
            }
            return System.currentTimeMillis() - start;
        }
    }
}
