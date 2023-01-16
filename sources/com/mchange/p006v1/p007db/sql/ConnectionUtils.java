package com.mchange.p006v1.p007db.sql;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.Connection;
import java.sql.SQLException;

/* renamed from: com.mchange.v1.db.sql.ConnectionUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionUtils.class */
public final class ConnectionUtils {
    private static final MLogger logger = MLog.getLogger(ConnectionUtils.class);

    public static boolean attemptClose(Connection connection) {
        if (connection == null) {
            return true;
        }
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return false;
            }
            logger.log(MLevel.WARNING, "Connection close FAILED.", (Throwable) e);
            return false;
        }
    }

    public static boolean attemptRollback(Connection connection) {
        if (connection == null) {
            return true;
        }
        try {
            connection.rollback();
            return true;
        } catch (SQLException e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return false;
            }
            logger.log(MLevel.WARNING, "Rollback FAILED.", (Throwable) e);
            return false;
        }
    }

    private ConnectionUtils() {
    }
}
