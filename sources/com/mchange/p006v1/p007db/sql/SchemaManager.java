package com.mchange.p006v1.p007db.sql;

import com.mchange.p006v1.util.CleanupUtils;
import com.mchange.util.impl.CommandLineParserImpl;
import java.sql.Connection;
import java.sql.DriverManager;

/* renamed from: com.mchange.v1.db.sql.SchemaManager */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/SchemaManager.class */
public class SchemaManager {
    static final String[] VALID = {"create", "drop"};

    public static void main(String[] strArr) {
        Connection connection;
        try {
            connection = null;
            try {
                CommandLineParserImpl commandLineParserImpl = new CommandLineParserImpl(strArr, VALID, null, null);
                boolean checkSwitch = commandLineParserImpl.checkSwitch("create");
                if (!commandLineParserImpl.checkArgv()) {
                    usage();
                }
                if (!(checkSwitch ^ commandLineParserImpl.checkSwitch("drop"))) {
                    usage();
                }
                String[] findUnswitchedArgs = commandLineParserImpl.findUnswitchedArgs();
                if (findUnswitchedArgs.length == 2) {
                    connection = DriverManager.getConnection(findUnswitchedArgs[0]);
                } else if (findUnswitchedArgs.length == 4) {
                    connection = DriverManager.getConnection(findUnswitchedArgs[0], findUnswitchedArgs[1], findUnswitchedArgs[2]);
                } else {
                    usage();
                }
                connection.setAutoCommit(false);
                Schema schema = (Schema) Class.forName(findUnswitchedArgs[findUnswitchedArgs.length - 1]).newInstance();
                if (checkSwitch) {
                    schema.createSchema(connection);
                    System.out.println("Schema created.");
                } else {
                    schema.dropSchema(connection);
                    System.out.println("Schema dropped.");
                }
                CleanupUtils.attemptClose(connection);
            } catch (Exception e) {
                e.printStackTrace();
                CleanupUtils.attemptClose(connection);
            }
        } catch (Throwable th) {
            CleanupUtils.attemptClose(connection);
            throw th;
        }
    }

    static void usage() {
        System.err.println("java -Djdbc.drivers=<driverclass> com.mchange.v1.db.sql.SchemaManager [-create | -drop] <jdbc_url> [<user> <password>] <schemaclass>");
        System.exit(-1);
    }
}
