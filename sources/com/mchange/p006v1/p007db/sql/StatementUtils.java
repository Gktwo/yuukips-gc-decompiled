package com.mchange.p006v1.p007db.sql;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.SQLException;
import java.sql.Statement;

/* renamed from: com.mchange.v1.db.sql.StatementUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/StatementUtils.class */
public final class StatementUtils {
    private static final MLogger logger = MLog.getLogger(StatementUtils.class);

    public static boolean attemptClose(Statement statement) {
        if (statement == null) {
            return true;
        }
        try {
            statement.close();
            return true;
        } catch (SQLException e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return false;
            }
            logger.log(MLevel.WARNING, "Statement close FAILED.", (Throwable) e);
            return false;
        }
    }

    private StatementUtils() {
    }
}
