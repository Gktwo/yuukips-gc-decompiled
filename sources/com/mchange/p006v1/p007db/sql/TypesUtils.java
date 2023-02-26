package com.mchange.p006v1.p007db.sql;

import dev.morphia.mapping.codec.reader.ArrayState;
import org.quartz.impl.jdbcjobstore.Constants;
import p001ch.qos.logback.core.joran.action.ActionConst;
import p013io.netty.channel.SelectStrategy;

/* renamed from: com.mchange.v1.db.sql.TypesUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/TypesUtils.class */
public final class TypesUtils {
    public static String getNameForSqlTypeCode(int i) throws UnsupportedTypeException {
        switch (i) {
            case -7:
                return "BIT";
            case -6:
                return "TINYINT";
            case -5:
                return "BIGINT";
            case -4:
                return "LONGVARBINARY";
            case SelectStrategy.BUSY_WAIT /* -3 */:
                return "VARBINARY";
            case -2:
                return "BINARY";
            case -1:
                return "LONGVARCHAR";
            case 0:
                return ActionConst.NULL;
            case 1:
                return "CHAR";
            case 2:
                return "NUMERIC";
            case 3:
                return "DECIMAL";
            case 4:
                return "INTEGER";
            case 5:
                return "SMALLINT";
            case 6:
                return "FLOAT";
            case 7:
                return "REAL";
            case 8:
                return "DOUBLE";
            case 12:
                return "VARCHAR";
            case 91:
                return "DATE";
            case 92:
                return "TIME";
            case 93:
                return "TIMESTAMP";
            case RET_DUNGEON_CANDIDATE_TEAM_NOT_ALL_READY_VALUE:
                throw new UnsupportedTypeException("Type OTHER cannot be represented as a String.");
            case 2000:
                throw new UnsupportedTypeException("Type JAVA_OBJECT cannot be represented as a String.");
            case 2002:
                return "STRUCT";
            case 2003:
                return ArrayState.NAME;
            case 2004:
                return Constants.TTYPE_BLOB;
            case 2005:
                return "CLOB";
            case 2006:
                return "REF";
            default:
                throw new UnsupportedTypeException("Type code: " + i + " is unknown.");
        }
    }

    private TypesUtils() {
    }
}
