package com.mchange.p006v1.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/* renamed from: com.mchange.v1.util.CleanupUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/CleanupUtils.class */
public final class CleanupUtils {
    public static void attemptClose(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void attemptClose(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void attemptRollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private CleanupUtils() {
    }
}
