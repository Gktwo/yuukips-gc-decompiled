package com.mchange.p009v2.c3p0.test;

import javax.naming.InitialContext;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.test.JndiLookupTest */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/JndiLookupTest.class */
public final class JndiLookupTest {
    public static void main(String[] argv) {
        try {
            String dmds_name = null;
            String cpds_name = null;
            String pbds_name = null;
            if (argv.length == 3) {
                dmds_name = argv[0];
                cpds_name = argv[1];
                pbds_name = argv[2];
            } else {
                usage();
            }
            InitialContext ctx = new InitialContext();
            ((DataSource) ctx.lookup(dmds_name)).getConnection().close();
            System.out.println("DriverManagerDataSource " + dmds_name + " sucessfully looked up and checked.");
            ((ConnectionPoolDataSource) ctx.lookup(cpds_name)).getPooledConnection().close();
            System.out.println("ConnectionPoolDataSource " + cpds_name + " sucessfully looked up and checked.");
            ((DataSource) ctx.lookup(pbds_name)).getConnection().close();
            System.out.println("PoolBackedDataSource " + pbds_name + " sucessfully looked up and checked.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void usage() {
        System.err.println("java " + JndiLookupTest.class.getName() + " \\");
        System.err.println("\t<dmds_name> <wcpds_name> <wpbds_name>");
        System.exit(-1);
    }
}
