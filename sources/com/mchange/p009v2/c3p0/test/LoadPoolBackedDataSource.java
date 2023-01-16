package com.mchange.p009v2.c3p0.test;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p006v1.p007db.sql.ResultSetUtils;
import com.mchange.p006v1.p007db.sql.StatementUtils;
import com.mchange.p009v2.c3p0.PooledDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.LoadPoolBackedDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/LoadPoolBackedDataSource.class */
public final class LoadPoolBackedDataSource {
    static final int NUM_THREADS = 100;
    static final int ITERATIONS_PER_THREAD = 1000;

    /* renamed from: ds */
    static DataSource f403ds;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0070
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void main(java.lang.String[] r4) {
        /*
        // Method dump skipped, instructions count: 576
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.test.LoadPoolBackedDataSource.main(java.lang.String[]):void");
    }

    /* renamed from: com.mchange.v2.c3p0.test.LoadPoolBackedDataSource$ChurnThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/LoadPoolBackedDataSource$ChurnThread.class */
    static class ChurnThread extends Thread {
        Random random = new Random();
        int num;

        public ChurnThread(int num) {
            this.num = num;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            for (int i = 0; i < 1000; i++) {
                Connection con = LoadPoolBackedDataSource.f403ds.getConnection();
                try {
                    switch (this.random.nextInt(3)) {
                        case 0:
                            LoadPoolBackedDataSource.executeSelect(con);
                            break;
                        case 1:
                            LoadPoolBackedDataSource.executeInsert(con, this.random);
                            break;
                        case 2:
                            LoadPoolBackedDataSource.executeDelete(con);
                            break;
                    }
                    PooledDataSource pds = (PooledDataSource) LoadPoolBackedDataSource.f403ds;
                    System.out.println("iteration: (" + this.num + ", " + i + ')');
                    System.out.println(pds.getNumConnectionsDefaultUser());
                    System.out.println(pds.getNumIdleConnectionsDefaultUser());
                    System.out.println(pds.getNumBusyConnectionsDefaultUser());
                    System.out.println(pds.getNumConnectionsAllUsers());
                    Thread.sleep(1);
                    ConnectionUtils.attemptClose(con);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    static void executeInsert(Connection con, Random random) throws SQLException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO testpbds VALUES ('" + random.nextInt() + "', '" + random.nextInt() + "')");
            System.out.println("INSERTION");
        } finally {
            StatementUtils.attemptClose(stmt);
        }
    }

    static void executeDelete(Connection con) throws SQLException {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM testpbds;");
            System.out.println("DELETION");
        } finally {
            StatementUtils.attemptClose(stmt);
        }
    }

    static void executeSelect(Connection con) throws SQLException {
        long l = System.currentTimeMillis();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT count(*) FROM testpbds");
            rs.next();
            System.out.println("SELECT [count=" + rs.getInt(1) + ", time=" + (System.currentTimeMillis() - l) + " msecs]");
            ResultSetUtils.attemptClose(rs);
            StatementUtils.attemptClose(stmt);
        } catch (Throwable th) {
            ResultSetUtils.attemptClose(rs);
            StatementUtils.attemptClose(stmt);
            throw th;
        }
    }

    private static void usage() {
        System.err.println("java -Djdbc.drivers=<comma_sep_list_of_drivers> " + LoadPoolBackedDataSource.class.getName() + " <jdbc_url> [<username> <password>]");
        System.exit(-1);
    }
}
