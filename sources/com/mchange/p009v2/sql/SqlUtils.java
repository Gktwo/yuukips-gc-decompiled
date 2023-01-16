package com.mchange.p009v2.sql;

import com.mchange.lang.ThrowableUtils;
import com.mchange.p009v2.lang.VersionUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.ClientInfoStatus;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* renamed from: com.mchange.v2.sql.SqlUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/sql/SqlUtils.class */
public final class SqlUtils {
    static final MLogger logger = MLog.getLogger(SqlUtils.class);
    static final DateFormat tsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS");
    public static final String DRIVER_MANAGER_USER_PROPERTY = "user";
    public static final String DRIVER_MANAGER_PASSWORD_PROPERTY = "password";

    public static String escapeBadSqlPatternChars(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        int length = stringBuffer.length();
        while (i < length) {
            if (stringBuffer.charAt(i) == '\'') {
                stringBuffer.insert(i, '\'');
                length++;
                i += 2;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static synchronized String escapeAsTimestamp(Date date) {
        return "{ts '" + tsdf.format(date) + "'}";
    }

    public static SQLException toSQLException(Throwable th) {
        return toSQLException(null, th);
    }

    public static SQLException toSQLException(String str, Throwable th) {
        return toSQLException(str, null, th);
    }

    public static SQLException toSQLException(String str, String str2, Throwable th) {
        if (th instanceof SQLException) {
            if (logger.isLoggable(MLevel.FINER)) {
                SQLException sQLException = (SQLException) th;
                StringBuffer stringBuffer = new StringBuffer(255);
                stringBuffer.append("Attempted to convert SQLException to SQLException. Leaving it alone.");
                stringBuffer.append(" [SQLState: ");
                stringBuffer.append(sQLException.getSQLState());
                stringBuffer.append("; errorCode: ");
                stringBuffer.append(sQLException.getErrorCode());
                stringBuffer.append(']');
                if (str != null) {
                    stringBuffer.append(" Ignoring suggested message: '" + str + "'.");
                }
                logger.log(MLevel.FINER, stringBuffer.toString(), th);
                SQLException sQLException2 = sQLException;
                while (true) {
                    SQLException nextException = sQLException2.getNextException();
                    sQLException2 = nextException;
                    if (nextException == null) {
                        break;
                    }
                    logger.log(MLevel.FINER, "Nested SQLException or SQLWarning: ", (Throwable) sQLException2);
                }
            }
            return (SQLException) th;
        }
        if (logger.isLoggable(MLevel.FINE)) {
            logger.log(MLevel.FINE, "Converting Throwable to SQLException...", th);
        }
        if (str == null) {
            str = "An SQLException was provoked by the following failure: " + th.toString();
        }
        if (!VersionUtils.isAtLeastJavaVersion14()) {
            return new SQLException(str + System.getProperty("line.separator") + "[Cause: " + ThrowableUtils.extractStackTrace(th) + ']', str2);
        }
        SQLException sQLException3 = new SQLException(str);
        sQLException3.initCause(th);
        return sQLException3;
    }

    public static SQLClientInfoException toSQLClientInfoException(Throwable th) {
        if (th instanceof SQLClientInfoException) {
            return (SQLClientInfoException) th;
        }
        if (th.getCause() instanceof SQLClientInfoException) {
            return (SQLClientInfoException) th.getCause();
        }
        if (!(th instanceof SQLException)) {
            return new SQLClientInfoException(th.getMessage(), (Map<String, ClientInfoStatus>) null, th);
        }
        SQLException sQLException = (SQLException) th;
        return new SQLClientInfoException(sQLException.getMessage(), sQLException.getSQLState(), sQLException.getErrorCode(), null, th);
    }

    private SqlUtils() {
    }
}
