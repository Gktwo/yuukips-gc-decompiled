package com.mchange.p009v2.c3p0.test;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p006v1.p007db.sql.ResultSetUtils;
import com.mchange.p006v1.p007db.sql.StatementUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.PSLoadPoolBackedDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/PSLoadPoolBackedDataSource.class */
public final class PSLoadPoolBackedDataSource {
    static final String INSERT_STMT = "INSERT INTO testpbds VALUES ( ? , ? )";
    static final String SELECT_STMT = "SELECT count(*) FROM testpbds";
    static final String DELETE_STMT = "DELETE FROM testpbds";

    /* renamed from: ds */
    static DataSource f405ds;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0067
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void main(java.lang.String[] r4) {
        /*
            r0 = r4
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0023
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.Class<com.mchange.v2.c3p0.test.PSLoadPoolBackedDataSource> r2 = com.mchange.p009v2.c3p0.test.PSLoadPoolBackedDataSource.class
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " now requires no args. Please set everything in standard c3p0 config files."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            return
        L_0x0023:
            r0 = 0
            r5 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r7 = r0
            javax.sql.DataSource r0 = com.mchange.p009v2.c3p0.DataSources.unpooledDataSource()     // Catch: Exception -> 0x00dc
            r8 = r0
            r0 = r8
            javax.sql.DataSource r0 = com.mchange.p009v2.c3p0.DataSources.pooledDataSource(r0)     // Catch: Exception -> 0x00dc
            com.mchange.p009v2.c3p0.test.PSLoadPoolBackedDataSource.f405ds = r0     // Catch: Exception -> 0x00dc
            r0 = 0
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r8
            java.sql.Connection r0 = r0.getConnection()     // Catch: Exception -> 0x00dc, SQLException -> 0x0067, all -> 0x0085
            r9 = r0
            r0 = r9
            java.sql.Statement r0 = r0.createStatement()     // Catch: Exception -> 0x00dc, SQLException -> 0x0067, all -> 0x0085
            r10 = r0
            r0 = r10
            java.lang.String r1 = "CREATE TABLE testpbds ( a varchar(16), b varchar(16) )"
            int r0 = r0.executeUpdate(r1)     // Catch: Exception -> 0x00dc, SQLException -> 0x0067, all -> 0x0085
            r0 = r10
            boolean r0 = com.mchange.p006v1.p007db.sql.StatementUtils.attemptClose(r0)     // Catch: Exception -> 0x00dc
            r0 = r9
            boolean r0 = com.mchange.p006v1.p007db.sql.ConnectionUtils.attemptClose(r0)     // Catch: Exception -> 0x00dc
            goto L_0x0096
        L_0x0067:
            r11 = move-exception
            r0 = r11
            r0.printStackTrace()     // Catch: Exception -> 0x00dc, all -> 0x0085
            java.io.PrintStream r0 = java.lang.System.err     // Catch: Exception -> 0x00dc, all -> 0x0085
            java.lang.String r1 = "relation testpbds already exists, or something bad happened."
            r0.println(r1)     // Catch: Exception -> 0x00dc, all -> 0x0085
            r0 = r10
            boolean r0 = com.mchange.p006v1.p007db.sql.StatementUtils.attemptClose(r0)     // Catch: Exception -> 0x00dc
            r0 = r9
            boolean r0 = com.mchange.p006v1.p007db.sql.ConnectionUtils.attemptClose(r0)     // Catch: Exception -> 0x00dc
            goto L_0x0096
        L_0x0085:
            r12 = move-exception
            r0 = r10
            boolean r0 = com.mchange.p006v1.p007db.sql.StatementUtils.attemptClose(r0)     // Catch: Exception -> 0x00dc
            r0 = r9
            boolean r0 = com.mchange.p006v1.p007db.sql.ConnectionUtils.attemptClose(r0)     // Catch: Exception -> 0x00dc
            r0 = r12
            throw r0     // Catch: Exception -> 0x00dc
        L_0x0096:
            r0 = 0
            r11 = r0
        L_0x0099:
            r0 = r11
            r1 = 100
            if (r0 >= r1) goto L_0x00d9
            com.mchange.v2.c3p0.test.PSLoadPoolBackedDataSource$ChurnThread r0 = new com.mchange.v2.c3p0.test.PSLoadPoolBackedDataSource$ChurnThread     // Catch: Exception -> 0x00dc
            r1 = r0
            r1.<init>()     // Catch: Exception -> 0x00dc
            r12 = r0
            r0 = r12
            r0.start()     // Catch: Exception -> 0x00dc
            java.io.PrintStream r0 = java.lang.System.out     // Catch: Exception -> 0x00dc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: Exception -> 0x00dc
            r2 = r1
            r2.<init>()     // Catch: Exception -> 0x00dc
            java.lang.String r2 = "THREAD MADE ["
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: Exception -> 0x00dc
            r2 = r11
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: Exception -> 0x00dc
            java.lang.String r2 = "]"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: Exception -> 0x00dc
            java.lang.String r1 = r1.toString()     // Catch: Exception -> 0x00dc
            r0.println(r1)     // Catch: Exception -> 0x00dc
            r0 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r0)     // Catch: Exception -> 0x00dc
            int r11 = r11 + 1
            goto L_0x0099
        L_0x00d9:
            goto L_0x00e3
        L_0x00dc:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.test.PSLoadPoolBackedDataSource.main(java.lang.String[]):void");
    }

    /* renamed from: com.mchange.v2.c3p0.test.PSLoadPoolBackedDataSource$ChurnThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/PSLoadPoolBackedDataSource$ChurnThread.class */
    static class ChurnThread extends Thread {
        Random random = new Random();

        ChurnThread() {
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                Connection con = PSLoadPoolBackedDataSource.f405ds.getConnection();
                try {
                    try {
                        switch (this.random.nextInt(3)) {
                            case 0:
                                PSLoadPoolBackedDataSource.executeSelect(con, this.random);
                                ConnectionUtils.attemptClose(con);
                                break;
                            case 1:
                                PSLoadPoolBackedDataSource.executeInsert(con, this.random);
                                ConnectionUtils.attemptClose(con);
                                break;
                            case 2:
                                PSLoadPoolBackedDataSource.executeDelete(con, this.random);
                                ConnectionUtils.attemptClose(con);
                                break;
                            default:
                                ConnectionUtils.attemptClose(con);
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ConnectionUtils.attemptClose(con);
                    }
                    Thread.sleep(1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    static void executeInsert(Connection con, Random random) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(INSERT_STMT);
            pstmt.setInt(1, random.nextInt());
            pstmt.setInt(2, random.nextInt());
            pstmt.executeUpdate();
            System.out.println("INSERTION");
        } finally {
            StatementUtils.attemptClose(pstmt);
        }
    }

    static void executeSelect(Connection con, Random random) throws SQLException {
        long l = System.currentTimeMillis();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(SELECT_STMT);
            rs = pstmt.executeQuery();
            rs.next();
            System.out.println("SELECT [count=" + rs.getInt(1) + ", time=" + (System.currentTimeMillis() - l) + " msecs]");
            ResultSetUtils.attemptClose(rs);
            StatementUtils.attemptClose(pstmt);
        } catch (Throwable th) {
            ResultSetUtils.attemptClose(rs);
            StatementUtils.attemptClose(pstmt);
            throw th;
        }
    }

    static void executeDelete(Connection con, Random random) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(DELETE_STMT);
            System.out.println("DELETE [" + pstmt.executeUpdate() + " rows]");
            ResultSetUtils.attemptClose(null);
            StatementUtils.attemptClose(pstmt);
        } catch (Throwable th) {
            ResultSetUtils.attemptClose(null);
            StatementUtils.attemptClose(pstmt);
            throw th;
        }
    }
}
