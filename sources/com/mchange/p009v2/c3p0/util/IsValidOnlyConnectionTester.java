package com.mchange.p009v2.c3p0.util;

import com.mchange.p009v2.c3p0.AbstractConnectionTester;
import com.mchange.p009v2.c3p0.impl.DefaultConnectionTester;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.Connection;
import java.sql.SQLException;

/* renamed from: com.mchange.v2.c3p0.util.IsValidOnlyConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/util/IsValidOnlyConnectionTester.class */
public abstract class IsValidOnlyConnectionTester extends AbstractConnectionTester {
    static final MLogger logger = MLog.getLogger(IsValidOnlyConnectionTester.class);
    volatile boolean warned = false;

    protected abstract int getIsValidTimeout();

    private void checkWarn(String preferredTestQuery) {
        if (preferredTestQuery != null && !this.warned) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "preferredTestQuery or automaticTestTable has been set, which " + getClass().getSimpleName() + " does not support. preferredTestQuery and/or automaticTestTable will be ignored.");
            }
            this.warned = true;
        }
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionTester, com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public int activeCheckConnection(Connection c, String preferredTestQuery, Throwable[] rootCauseOutParamHolder) {
        checkWarn(preferredTestQuery);
        try {
            int timeout = getIsValidTimeout();
            if (c.isValid(timeout)) {
                return 0;
            }
            if (rootCauseOutParamHolder == null) {
                return -1;
            }
            rootCauseOutParamHolder[0] = new SQLException("Connection.isValid(" + timeout + ") returned false.");
            return -1;
        } catch (SQLException sqle) {
            if (rootCauseOutParamHolder != null) {
                rootCauseOutParamHolder[0] = sqle;
            }
            boolean db_invalid = DefaultConnectionTester.probableInvalidDb(sqle);
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "SQL State '" + sqle.getSQLState() + "' of Exception tested by activeCheckConnection(...) implies that the database is invalid, and the pool should refill itself with fresh Connections.", (Throwable) sqle);
            }
            return db_invalid ? -8 : -1;
        } catch (Exception e) {
            if (rootCauseOutParamHolder != null) {
                rootCauseOutParamHolder[0] = e;
            }
            if (!logger.isLoggable(MLevel.WARNING)) {
                return -1;
            }
            logger.log(MLevel.WARNING, "Unexpected non-SQLException thrown in Connection test. Reporting Connection invalid.", (Throwable) e);
            return -1;
        }
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionTester, com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public int statusOnException(Connection c, Throwable t, String preferredTestQuery, Throwable[] rootCauseOutParamHolder) {
        checkWarn(preferredTestQuery);
        try {
            if (!(t instanceof SQLException)) {
                if (logger.isLoggable(MLevel.FINE)) {
                    logger.log(MLevel.FINE, "Connection test failed because test-provoking Throwable is an unexpected, non-SQLException.", t);
                }
                if (rootCauseOutParamHolder == null) {
                    return -1;
                }
                rootCauseOutParamHolder[0] = t;
                return -1;
            } else if (!DefaultConnectionTester.probableInvalidDb((SQLException) t)) {
                return activeCheckConnection(c, preferredTestQuery, rootCauseOutParamHolder);
            } else {
                if (!logger.isLoggable(MLevel.WARNING)) {
                    return -8;
                }
                logger.log(MLevel.WARNING, "SQL State of SQLException tested by statusOnException() implies that the database is invalid, and the pool should refill itself with fresh Connections.", t);
                return -8;
            }
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Connection " + c + " failed Connection test with an Exception!", (Throwable) e);
            }
            if (rootCauseOutParamHolder == null) {
                return -1;
            }
            rootCauseOutParamHolder[0] = e;
            return -1;
        }
    }
}
