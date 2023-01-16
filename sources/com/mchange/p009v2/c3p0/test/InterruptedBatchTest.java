package com.mchange.p009v2.c3p0.test;

import com.mchange.p009v2.c3p0.ComboPooledDataSource;
import com.mchange.p009v2.c3p0.DataSources;
import com.mchange.p009v2.c3p0.DriverManagerDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.InterruptedBatchTest */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/InterruptedBatchTest.class */
public final class InterruptedBatchTest {
    static DataSource ds_unpooled = null;
    static DataSource ds_pooled = null;

    public static void main(String[] argv) {
        if (argv.length > 0) {
            System.err.println(C3P0BenchmarkApp.class.getName() + " now requires no args. Please set everything in standard c3p0 config files.");
            return;
        }
        try {
            ds_unpooled = new DriverManagerDataSource();
            ds_pooled = new ComboPooledDataSource();
            attemptSetupTable();
            performTransaction(true);
            performTransaction(false);
            checkCount();
            try {
                DataSources.destroy(ds_pooled);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                DataSources.destroy(ds_unpooled);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                DataSources.destroy(ds_pooled);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                DataSources.destroy(ds_unpooled);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static void performTransaction(boolean throwAnException) throws SQLException {
        Connection con;
        PreparedStatement prepStat;
        try {
            con = null;
            prepStat = null;
            try {
                Connection con2 = ds_pooled.getConnection();
                con2.setAutoCommit(false);
                PreparedStatement prepStat2 = con2.prepareStatement("INSERT INTO CG_TAROPT_LOG(CO_ID, ENTDATE, CS_SEQNO, DESCRIPTION) VALUES (?,?,?,?)");
                prepStat2.setLong(1, -665);
                prepStat2.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                prepStat2.setInt(3, 1);
                prepStat2.setString(4, "time: " + System.currentTimeMillis());
                prepStat2.addBatch();
                if (throwAnException) {
                    throw new NullPointerException("my exception");
                }
                prepStat2.executeBatch();
                con2.commit();
                if (prepStat2 != null) {
                    try {
                        prepStat2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    con2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                System.out.println("exception caught (NPE expected): ");
                e3.printStackTrace();
                if (0 != 0) {
                    try {
                        prepStat.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        con.close();
                    }
                }
                try {
                    con.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    prepStat.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    con.close();
                    throw th;
                }
            }
            try {
                con.close();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            throw th;
        }
    }

    private static void attemptSetupTable() throws Exception {
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds_pooled.getConnection();
            stmt = con.createStatement();
            try {
                stmt.executeUpdate("CREATE TABLE CG_TAROPT_LOG ( CO_ID INTEGER, ENTDATE TIMESTAMP, CS_SEQNO INTEGER, DESCRIPTION VARCHAR(32) )");
            } catch (SQLException e) {
                System.err.println("Table already constructed?");
                e.printStackTrace();
            }
            stmt.executeUpdate("DELETE FROM CG_TAROPT_LOG");
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                stmt.close();
            } catch (SQLException e4) {
                e4.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    private static void checkCount() throws Exception {
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds_pooled.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM CG_TAROPT_LOG");
            rs.next();
            System.out.println(rs.getInt(1) + " rows found. (one row expected.)");
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                stmt.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }
}
