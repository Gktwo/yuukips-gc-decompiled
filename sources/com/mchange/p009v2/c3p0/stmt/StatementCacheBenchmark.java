package com.mchange.p009v2.c3p0.stmt;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p006v1.p007db.sql.StatementUtils;
import com.mchange.p009v2.c3p0.DriverManagerDataSourceFactory;
import com.mchange.p009v2.c3p0.PoolBackedDataSourceFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.stmt.StatementCacheBenchmark */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/StatementCacheBenchmark.class */
public final class StatementCacheBenchmark {
    static final String EMPTY_TABLE_CREATE = "CREATE TABLE emptyyukyuk (a varchar(8), b varchar(8))";
    static final String EMPTY_TABLE_SELECT = "SELECT * FROM emptyyukyuk";
    static final String EMPTY_TABLE_DROP = "DROP TABLE emptyyukyuk";
    static final String EMPTY_TABLE_CONDITIONAL_SELECT = "SELECT * FROM emptyyukyuk where a = ?";
    static final int NUM_ITERATIONS = 2000;

    public static void main(String[] argv) {
        DataSource ds_pooled;
        try {
            ds_pooled = null;
            try {
                String jdbc_url = null;
                String username = null;
                String password = null;
                if (argv.length == 3) {
                    jdbc_url = argv[0];
                    username = argv[1];
                    password = argv[2];
                } else if (argv.length == 1) {
                    jdbc_url = argv[0];
                    username = null;
                    password = null;
                } else {
                    usage();
                }
                if (!jdbc_url.startsWith("jdbc:")) {
                    usage();
                }
                DataSource ds_unpooled = DriverManagerDataSourceFactory.create(jdbc_url, username, password);
                ds_pooled = PoolBackedDataSourceFactory.create(jdbc_url, username, password, 5, 20, 5, 0, 100);
                create(ds_pooled);
                perform(ds_pooled, "pooled");
                perform(ds_unpooled, "unpooled");
                try {
                    drop(ds_pooled);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    drop(ds_pooled);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            try {
                drop(ds_pooled);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    private static void perform(DataSource ds, String name) throws SQLException {
        Connection c = null;
        try {
            c = ds.getConnection();
            long start = System.currentTimeMillis();
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                c.prepareStatement(EMPTY_TABLE_CONDITIONAL_SELECT).close();
            }
            System.err.println(name + " --> " + (((float) (System.currentTimeMillis() - start)) / 2000.0f) + " [" + NUM_ITERATIONS + " iterations]");
            StatementUtils.attemptClose(null);
            ConnectionUtils.attemptClose(c);
        } catch (Throwable th) {
            StatementUtils.attemptClose(null);
            ConnectionUtils.attemptClose(c);
            throw th;
        }
    }

    private static void usage() {
        System.err.println("java -Djdbc.drivers=<comma_sep_list_of_drivers> " + StatementCacheBenchmark.class.getName() + " <jdbc_url> [<username> <password>]");
        System.exit(-1);
    }

    static void create(DataSource ds) throws SQLException {
        System.err.println("Creating test schema.");
        Connection con = null;
        PreparedStatement ps1 = null;
        try {
            con = ds.getConnection();
            ps1 = con.prepareStatement(EMPTY_TABLE_CREATE);
            ps1.executeUpdate();
            System.err.println("Test schema created.");
        } finally {
            StatementUtils.attemptClose(ps1);
            ConnectionUtils.attemptClose(con);
        }
    }

    static void drop(DataSource ds) throws SQLException {
        Connection con = null;
        PreparedStatement ps1 = null;
        try {
            con = ds.getConnection();
            ps1 = con.prepareStatement(EMPTY_TABLE_DROP);
            ps1.executeUpdate();
            System.err.println("Test schema dropped.");
        } finally {
            StatementUtils.attemptClose(ps1);
            ConnectionUtils.attemptClose(con);
        }
    }
}
