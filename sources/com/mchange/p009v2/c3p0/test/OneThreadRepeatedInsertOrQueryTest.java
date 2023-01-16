package com.mchange.p009v2.c3p0.test;

import com.mchange.p006v1.p007db.sql.ResultSetUtils;
import com.mchange.p006v1.p007db.sql.StatementUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.OneThreadRepeatedInsertOrQueryTest */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/OneThreadRepeatedInsertOrQueryTest.class */
public final class OneThreadRepeatedInsertOrQueryTest {
    static final String INSERT_STMT = "INSERT INTO testpbds VALUES ( ? , ? )";
    static final String SELECT_STMT = "SELECT count(*) FROM testpbds";
    static Random random = new Random();

    /* renamed from: ds */
    static DataSource f404ds;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x007d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void main(java.lang.String[] r4) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.test.OneThreadRepeatedInsertOrQueryTest.main(java.lang.String[]):void");
    }

    static void executeInsert(Connection con) throws SQLException {
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

    static void executeSelect(Connection con) throws SQLException {
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

    private static void usage() {
        System.err.println("java -Djdbc.drivers=<comma_sep_list_of_drivers> " + OneThreadRepeatedInsertOrQueryTest.class.getName() + " <jdbc_url> [<username> <password>]");
        System.exit(-1);
    }
}
