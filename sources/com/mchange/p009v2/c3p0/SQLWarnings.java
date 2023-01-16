package com.mchange.p009v2.c3p0;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;

/* renamed from: com.mchange.v2.c3p0.SQLWarnings */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/SQLWarnings.class */
public final class SQLWarnings {
    static final MLogger logger = MLog.getLogger(SQLWarnings.class);

    public static void logAndClearWarnings(Connection con) throws SQLException {
        if (logger.isLoggable(MLevel.INFO)) {
            for (SQLWarning w = con.getWarnings(); w != null; w = w.getNextWarning()) {
                logger.log(MLevel.INFO, w.getMessage(), (Throwable) w);
            }
        }
        con.clearWarnings();
    }
}
