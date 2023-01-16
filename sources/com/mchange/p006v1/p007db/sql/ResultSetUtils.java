package com.mchange.p006v1.p007db.sql;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.ResultSet;
import java.sql.SQLException;

/* renamed from: com.mchange.v1.db.sql.ResultSetUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ResultSetUtils.class */
public final class ResultSetUtils {
    private static final MLogger logger = MLog.getLogger(ResultSetUtils.class);

    public static boolean attemptClose(ResultSet resultSet) {
        if (resultSet == null) {
            return true;
        }
        try {
            resultSet.close();
            return true;
        } catch (SQLException e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return false;
            }
            logger.log(MLevel.WARNING, "ResultSet close FAILED.", (Throwable) e);
            return false;
        }
    }

    private ResultSetUtils() {
    }
}
