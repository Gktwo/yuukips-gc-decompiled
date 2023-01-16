package com.mchange.p006v1.p007db.sql;

import com.mchange.lang.ThrowableUtils;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.mchange.v1.db.sql.SqlUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/SqlUtils.class */
public final class SqlUtils {
    static final DateFormat tsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS");

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

    public static String escapeAsTimestamp(Date date) {
        return "{ts '" + tsdf.format(date) + "'}";
    }

    public static SQLException toSQLException(Throwable th) {
        if (th instanceof SQLException) {
            return (SQLException) th;
        }
        th.printStackTrace();
        return new SQLException(ThrowableUtils.extractStackTrace(th));
    }

    private SqlUtils() {
    }
}
