package com.mchange.p009v2.c3p0.impl;

import com.mchange.p006v1.p007db.sql.ResultSetUtils;
import com.mchange.p006v1.p007db.sql.StatementUtils;
import com.mchange.p009v2.c3p0.AbstractConnectionTester;
import com.mchange.p009v2.c3p0.cfg.C3P0Config;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.mchange.v2.c3p0.impl.DefaultConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/DefaultConnectionTester.class */
public final class DefaultConnectionTester extends AbstractConnectionTester {
    private static final String PROP_KEY = "com.mchange.v2.c3p0.impl.DefaultConnectionTester.querylessTestRunner";
    private static final String IS_VALID_TIMEOUT_KEY = "com.mchange.v2.c3p0.impl.DefaultConnectionTester.isValidTimeout";
    static final int IS_VALID_TIMEOUT;
    static final String CONNECTION_TESTING_URL = "http://www.mchange.com/projects/c3p0/#configuring_connection_testing";
    static final Set INVALID_DB_STATES;
    private final QuerylessTestRunner querylessTestRunner;
    static final MLogger logger = MLog.getLogger(DefaultConnectionTester.class);
    static final int HASH_CODE = DefaultConnectionTester.class.getName().hashCode();
    static final QuerylessTestRunner METADATA_TABLESEARCH = new QuerylessTestRunner() { // from class: com.mchange.v2.c3p0.impl.DefaultConnectionTester.1
        @Override // com.mchange.p009v2.c3p0.impl.DefaultConnectionTester.QuerylessTestRunner
        public int activeCheckConnectionNoQuery(Connection c, Throwable[] rootCauseOutParamHolder) {
            ResultSet rs;
            try {
                rs = null;
                try {
                    rs = c.getMetaData().getTables(null, null, "PROBABLYNOT", new String[]{"TABLE"});
                    ResultSetUtils.attemptClose(rs);
                    return 0;
                } catch (SQLException e) {
                    if (DefaultConnectionTester.logger.isLoggable(MLevel.FINE)) {
                        DefaultConnectionTester.logger.log(MLevel.FINE, "Connection " + c + " failed default system-table Connection test with an Exception!", (Throwable) e);
                    }
                    if (rootCauseOutParamHolder != null) {
                        rootCauseOutParamHolder[0] = e;
                    }
                    String state = e.getSQLState();
                    if (DefaultConnectionTester.INVALID_DB_STATES.contains(state)) {
                        if (DefaultConnectionTester.logger.isLoggable(MLevel.WARNING)) {
                            DefaultConnectionTester.logger.log(MLevel.WARNING, "SQL State '" + state + "' of Exception which occurred during a Connection test (fallback DatabaseMetaData test) implies that the database is invalid, and the pool should refill itself with fresh Connections.", (Throwable) e);
                        }
                        ResultSetUtils.attemptClose(rs);
                        return -8;
                    }
                    ResultSetUtils.attemptClose(rs);
                    return -1;
                } catch (Exception e2) {
                    if (DefaultConnectionTester.logger.isLoggable(MLevel.FINE)) {
                        DefaultConnectionTester.logger.log(MLevel.FINE, "Connection " + c + " failed default system-table Connection test with an Exception!", (Throwable) e2);
                    }
                    if (rootCauseOutParamHolder != null) {
                        rootCauseOutParamHolder[0] = e2;
                    }
                    ResultSetUtils.attemptClose(rs);
                    return -1;
                }
            } catch (Throwable th) {
                ResultSetUtils.attemptClose(rs);
                throw th;
            }
        }
    };
    static final QuerylessTestRunner IS_VALID = new QuerylessTestRunner() { // from class: com.mchange.v2.c3p0.impl.DefaultConnectionTester.2
        @Override // com.mchange.p009v2.c3p0.impl.DefaultConnectionTester.QuerylessTestRunner
        public int activeCheckConnectionNoQuery(Connection c, Throwable[] rootCauseOutParamHolder) {
            try {
                if (c.isValid(DefaultConnectionTester.IS_VALID_TIMEOUT)) {
                    return 0;
                }
                if (rootCauseOutParamHolder == null) {
                    return -1;
                }
                rootCauseOutParamHolder[0] = new SQLException("Connection.isValid(" + DefaultConnectionTester.IS_VALID_TIMEOUT + ") returned false.");
                return -1;
            } catch (SQLException e) {
                if (rootCauseOutParamHolder != null) {
                    rootCauseOutParamHolder[0] = e;
                }
                String state = e.getSQLState();
                if (!DefaultConnectionTester.INVALID_DB_STATES.contains(state)) {
                    return -1;
                }
                if (!DefaultConnectionTester.logger.isLoggable(MLevel.WARNING)) {
                    return -8;
                }
                DefaultConnectionTester.logger.log(MLevel.WARNING, "SQL State '" + state + "' of Exception which occurred during a Connection test (fallback DatabaseMetaData test) implies that the database is invalid, and the pool should refill itself with fresh Connections.", (Throwable) e);
                return -8;
            } catch (Exception e2) {
                if (rootCauseOutParamHolder == null) {
                    return -1;
                }
                rootCauseOutParamHolder[0] = e2;
                return -1;
            }
        }
    };
    static final QuerylessTestRunner SWITCH = new QuerylessTestRunner() { // from class: com.mchange.v2.c3p0.impl.DefaultConnectionTester.3
        @Override // com.mchange.p009v2.c3p0.impl.DefaultConnectionTester.QuerylessTestRunner
        public int activeCheckConnectionNoQuery(Connection c, Throwable[] rootCauseOutParamHolder) {
            int out;
            try {
                out = DefaultConnectionTester.IS_VALID.activeCheckConnectionNoQuery(c, rootCauseOutParamHolder);
            } catch (AbstractMethodError e) {
                out = DefaultConnectionTester.METADATA_TABLESEARCH.activeCheckConnectionNoQuery(c, rootCauseOutParamHolder);
            }
            return out;
        }
    };
    static final QuerylessTestRunner THREAD_LOCAL = new ThreadLocalQuerylessTestRunner();

    /* renamed from: com.mchange.v2.c3p0.impl.DefaultConnectionTester$QuerylessTestRunner */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/DefaultConnectionTester$QuerylessTestRunner.class */
    public interface QuerylessTestRunner extends Serializable {
        int activeCheckConnectionNoQuery(Connection connection, Throwable[] thArr);
    }

    static {
        Set temp = new HashSet();
        temp.add("08001");
        temp.add("08007");
        INVALID_DB_STATES = Collections.unmodifiableSet(temp);
        int isValidTimeout = -1;
        String timeoutStr = C3P0Config.getMultiPropertiesConfig().getProperty(IS_VALID_TIMEOUT_KEY);
        if (timeoutStr != null) {
            try {
                isValidTimeout = Integer.parseInt(timeoutStr);
            } catch (NumberFormatException e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Could not parse value set for com.mchange.v2.c3p0.impl.DefaultConnectionTester.isValidTimeout ['" + timeoutStr + "'] into int.", (Throwable) e);
                }
            }
        }
        if (isValidTimeout <= 0) {
            isValidTimeout = 0;
        } else if (logger.isLoggable(MLevel.INFO)) {
            logger.log(MLevel.INFO, "Connection.isValid(...) based Connection tests will timeout and fail after " + isValidTimeout + " seconds.");
        }
        IS_VALID_TIMEOUT = isValidTimeout;
    }

    public static boolean probableInvalidDb(SQLException sqle) {
        return INVALID_DB_STATES.contains(sqle.getSQLState());
    }

    private static QuerylessTestRunner reflectTestRunner(String propval) {
        try {
            if (propval.indexOf(46) >= 0) {
                return (QuerylessTestRunner) Class.forName(propval).newInstance();
            }
            return (QuerylessTestRunner) DefaultConnectionTester.class.getDeclaredField(propval).get(null);
        } catch (Exception e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return null;
            }
            logger.log(MLevel.WARNING, "Specified QuerylessTestRunner '" + propval + "' could not be found or instantiated. Reverting to default 'SWITCH'", (Throwable) e);
            return null;
        }
    }

    public DefaultConnectionTester() {
        QuerylessTestRunner defaultQuerylessTestRunner = SWITCH;
        String prop = C3P0Config.getMultiPropertiesConfig().getProperty(PROP_KEY);
        if (prop == null) {
            this.querylessTestRunner = defaultQuerylessTestRunner;
            return;
        }
        QuerylessTestRunner reflected = reflectTestRunner(prop.trim());
        this.querylessTestRunner = reflected != null ? reflected : defaultQuerylessTestRunner;
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionTester, com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public int activeCheckConnection(Connection c, String query, Throwable[] rootCauseOutParamHolder) {
        ResultSet rs;
        Statement stmt;
        if (query == null) {
            return this.querylessTestRunner.activeCheckConnectionNoQuery(c, rootCauseOutParamHolder);
        }
        try {
            stmt = null;
            rs = null;
            try {
                try {
                    stmt = c.createStatement();
                    rs = stmt.executeQuery(query);
                    ResultSetUtils.attemptClose(rs);
                    StatementUtils.attemptClose(stmt);
                    return 0;
                } catch (Exception e) {
                    if (logger.isLoggable(MLevel.FINE)) {
                        logger.log(MLevel.FINE, "Connection " + c + " failed Connection test with an Exception!", (Throwable) e);
                    }
                    if (rootCauseOutParamHolder != null) {
                        rootCauseOutParamHolder[0] = e;
                    }
                    ResultSetUtils.attemptClose(rs);
                    StatementUtils.attemptClose(stmt);
                    return -1;
                }
            } catch (SQLException e2) {
                if (logger.isLoggable(MLevel.FINE)) {
                    logger.log(MLevel.FINE, "Connection " + c + " failed Connection test with an Exception! [query=" + query + "]", (Throwable) e2);
                }
                if (rootCauseOutParamHolder != null) {
                    rootCauseOutParamHolder[0] = e2;
                }
                String state = e2.getSQLState();
                if (INVALID_DB_STATES.contains(state)) {
                    if (logger.isLoggable(MLevel.WARNING)) {
                        logger.log(MLevel.WARNING, "SQL State '" + state + "' of Exception which occurred during a Connection test (test with query '" + query + "') implies that the database is invalid, and the pool should refill itself with fresh Connections.", (Throwable) e2);
                    }
                    ResultSetUtils.attemptClose(rs);
                    StatementUtils.attemptClose(stmt);
                    return -8;
                }
                ResultSetUtils.attemptClose(rs);
                StatementUtils.attemptClose(stmt);
                return -1;
            }
        } catch (Throwable th) {
            ResultSetUtils.attemptClose(rs);
            StatementUtils.attemptClose(stmt);
            throw th;
        }
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionTester, com.mchange.p009v2.c3p0.UnifiedConnectionTester
    public int statusOnException(Connection c, Throwable t, String query, Throwable[] rootCauseOutParamHolder) {
        if (logger.isLoggable(MLevel.FINER)) {
            logger.log(MLevel.FINER, "Testing a Connection in response to an Exception:", t);
        }
        try {
            if (t instanceof SQLException) {
                String state = ((SQLException) t).getSQLState();
                if (!INVALID_DB_STATES.contains(state)) {
                    return activeCheckConnection(c, query, rootCauseOutParamHolder);
                }
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "SQL State '" + state + "' of Exception tested by statusOnException() implies that the database is invalid, and the pool should refill itself with fresh Connections.", t);
                }
                return -8;
            }
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Connection test failed because test-provoking Throwable is an unexpected, non-SQLException.", t);
            }
            if (rootCauseOutParamHolder != null) {
                rootCauseOutParamHolder[0] = t;
            }
            return -1;
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Connection " + c + " failed Connection test with an Exception!", (Throwable) e);
            }
            if (rootCauseOutParamHolder != null) {
                rootCauseOutParamHolder[0] = e;
            }
            return -1;
        }
    }

    private static String queryInfo(String query) {
        return query == null ? "[using Connection.isValid(...) if supported, or else traditional default query]" : "[query=" + query + "]";
    }

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester, com.mchange.p009v2.c3p0.ConnectionTester, java.lang.Object
    public boolean equals(Object o) {
        return o != null && o.getClass() == DefaultConnectionTester.class;
    }

    @Override // com.mchange.p009v2.c3p0.UnifiedConnectionTester, com.mchange.p009v2.c3p0.ConnectionTester, java.lang.Object
    public int hashCode() {
        return HASH_CODE;
    }
}
