package com.mchange.p009v2.c3p0.debug;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.sql.filter.FilterConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;

/* renamed from: com.mchange.v2.c3p0.debug.CloseLoggingConnectionWrapper */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/debug/CloseLoggingConnectionWrapper.class */
public class CloseLoggingConnectionWrapper extends FilterConnection {
    static final MLogger logger = MLog.getLogger(CloseLoggingConnectionWrapper.class);
    final MLevel level;

    public CloseLoggingConnectionWrapper(Connection conn, MLevel level) {
        super(conn);
        this.level = level;
    }

    @Override // com.mchange.p009v2.sql.filter.FilterConnection, java.sql.Connection, java.lang.AutoCloseable
    public void close() throws SQLException {
        close();
        if (logger.isLoggable(this.level)) {
            logger.log(this.level, "DEBUG: A Connection has closed been close()ed without error.", (Throwable) new SQLWarning("DEBUG STACK TRACE -- Connection.close() was called."));
        }
    }
}
