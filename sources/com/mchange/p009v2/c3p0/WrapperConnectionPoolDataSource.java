package com.mchange.p009v2.c3p0;

import com.mchange.p006v1.p007db.sql.ConnectionUtils;
import com.mchange.p009v2.c3p0.cfg.C3P0Config;
import com.mchange.p009v2.c3p0.cfg.C3P0ConfigUtils;
import com.mchange.p009v2.c3p0.impl.C3P0ImplUtils;
import com.mchange.p009v2.c3p0.impl.C3P0PooledConnection;
import com.mchange.p009v2.c3p0.impl.NewPooledConnection;
import com.mchange.p009v2.c3p0.impl.WrapperConnectionPoolDataSourceBase;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.PooledConnection;

/* renamed from: com.mchange.v2.c3p0.WrapperConnectionPoolDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/WrapperConnectionPoolDataSource.class */
public final class WrapperConnectionPoolDataSource extends WrapperConnectionPoolDataSourceBase implements ConnectionPoolDataSource {
    static final MLogger logger = MLog.getLogger(WrapperConnectionPoolDataSource.class);
    ConnectionTester connectionTester;
    Map userOverrides;

    public WrapperConnectionPoolDataSource(boolean autoregister) {
        super(autoregister);
        this.connectionTester = C3P0Registry.getDefaultConnectionTester();
        setUpPropertyListeners();
        try {
            this.userOverrides = C3P0ImplUtils.parseUserOverridesAsString(getUserOverridesAsString());
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Failed to parse stringified userOverrides. " + getUserOverridesAsString(), (Throwable) e);
            }
        }
    }

    public WrapperConnectionPoolDataSource() {
        this(true);
    }

    private void setUpPropertyListeners() {
        addVetoableChangeListener(new VetoableChangeListener() { // from class: com.mchange.v2.c3p0.WrapperConnectionPoolDataSource.1
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                String propName = evt.getPropertyName();
                Object val = evt.getNewValue();
                if ("connectionTesterClassName".equals(propName)) {
                    try {
                        WrapperConnectionPoolDataSource.this.recreateConnectionTester((String) val);
                    } catch (Exception e) {
                        if (WrapperConnectionPoolDataSource.logger.isLoggable(MLevel.WARNING)) {
                            WrapperConnectionPoolDataSource.logger.log(MLevel.WARNING, "Failed to create ConnectionTester of class " + val, (Throwable) e);
                        }
                        throw new PropertyVetoException("Could not instantiate connection tester class with name '" + val + "'.", evt);
                    }
                } else if ("userOverridesAsString".equals(propName)) {
                    try {
                        WrapperConnectionPoolDataSource.this.userOverrides = C3P0ImplUtils.parseUserOverridesAsString((String) val);
                    } catch (Exception e2) {
                        if (WrapperConnectionPoolDataSource.logger.isLoggable(MLevel.WARNING)) {
                            WrapperConnectionPoolDataSource.logger.log(MLevel.WARNING, "Failed to parse stringified userOverrides. " + val, (Throwable) e2);
                        }
                        throw new PropertyVetoException("Failed to parse stringified userOverrides. " + val, evt);
                    }
                }
            }
        });
    }

    public WrapperConnectionPoolDataSource(String configName) {
        this();
        if (configName != null) {
            try {
                C3P0Config.bindNamedConfigToBean(this, configName, true);
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Error binding WrapperConnectionPoolDataSource to named-config '" + configName + "'. Some default-config values may be used.", (Throwable) e);
                }
            }
        }
    }

    @Override // javax.sql.ConnectionPoolDataSource
    public PooledConnection getPooledConnection() throws SQLException {
        return getPooledConnection((ConnectionCustomizer) null, (String) null);
    }

    @Override // com.mchange.p009v2.c3p0.impl.WrapperConnectionPoolDataSourceBase
    protected PooledConnection getPooledConnection(ConnectionCustomizer cc, String pdsIdt) throws SQLException {
        DataSource nds = getNestedDataSource();
        if (nds == null) {
            throw new SQLException("No standard DataSource has been set beneath this wrapper! [ nestedDataSource == null ]");
        }
        try {
            Connection conn = nds.getConnection();
            if (conn == null) {
                throw new SQLException("An (unpooled) DataSource returned null from its getConnection() method! DataSource: " + getNestedDataSource());
            } else if (isUsesTraditionalReflectiveProxies(getUser())) {
                return new C3P0PooledConnection(conn, this.connectionTester, isAutoCommitOnClose(getUser()), isForceIgnoreUnresolvedTransactions(getUser()), cc, pdsIdt);
            } else {
                return new NewPooledConnection(conn, this.connectionTester, isAutoCommitOnClose(getUser()), isForceIgnoreUnresolvedTransactions(getUser()), getPreferredTestQuery(getUser()), cc, pdsIdt);
            }
        } catch (RuntimeException re) {
            ConnectionUtils.attemptClose(null);
            throw re;
        } catch (SQLException e) {
            ConnectionUtils.attemptClose(null);
            throw e;
        }
    }

    @Override // javax.sql.ConnectionPoolDataSource
    public PooledConnection getPooledConnection(String user, String password) throws SQLException {
        return getPooledConnection(user, password, null, null);
    }

    @Override // com.mchange.p009v2.c3p0.impl.WrapperConnectionPoolDataSourceBase
    protected PooledConnection getPooledConnection(String user, String password, ConnectionCustomizer cc, String pdsIdt) throws SQLException {
        DataSource nds = getNestedDataSource();
        if (nds == null) {
            throw new SQLException("No standard DataSource has been set beneath this wrapper! [ nestedDataSource == null ]");
        }
        try {
            Connection conn = nds.getConnection(user, password);
            if (conn == null) {
                throw new SQLException("An (unpooled) DataSource returned null from its getConnection() method! DataSource: " + getNestedDataSource());
            } else if (isUsesTraditionalReflectiveProxies(user)) {
                return new C3P0PooledConnection(conn, this.connectionTester, isAutoCommitOnClose(user), isForceIgnoreUnresolvedTransactions(user), cc, pdsIdt);
            } else {
                return new NewPooledConnection(conn, this.connectionTester, isAutoCommitOnClose(user), isForceIgnoreUnresolvedTransactions(user), getPreferredTestQuery(user), cc, pdsIdt);
            }
        } catch (RuntimeException re) {
            ConnectionUtils.attemptClose(null);
            throw re;
        } catch (SQLException e) {
            ConnectionUtils.attemptClose(null);
            throw e;
        }
    }

    private boolean isAutoCommitOnClose(String userName) {
        if (userName == null) {
            return isAutoCommitOnClose();
        }
        Boolean override = C3P0ConfigUtils.extractBooleanOverride("autoCommitOnClose", userName, this.userOverrides);
        return override == null ? isAutoCommitOnClose() : override.booleanValue();
    }

    private boolean isForceIgnoreUnresolvedTransactions(String userName) {
        if (userName == null) {
            return isForceIgnoreUnresolvedTransactions();
        }
        Boolean override = C3P0ConfigUtils.extractBooleanOverride("forceIgnoreUnresolvedTransactions", userName, this.userOverrides);
        return override == null ? isForceIgnoreUnresolvedTransactions() : override.booleanValue();
    }

    private boolean isUsesTraditionalReflectiveProxies(String userName) {
        if (userName == null) {
            return isUsesTraditionalReflectiveProxies();
        }
        Boolean override = C3P0ConfigUtils.extractBooleanOverride("usesTraditionalReflectiveProxies", userName, this.userOverrides);
        return override == null ? isUsesTraditionalReflectiveProxies() : override.booleanValue();
    }

    private String getPreferredTestQuery(String userName) {
        if (userName == null) {
            return getPreferredTestQuery();
        }
        String override = (String) C3P0ConfigUtils.extractUserOverride("preferredTestQuery", userName, this.userOverrides);
        return override == null ? getPreferredTestQuery() : override;
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        return getNestedDataSource().getLogWriter();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter out) throws SQLException {
        getNestedDataSource().setLogWriter(out);
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int seconds) throws SQLException {
        getNestedDataSource().setLoginTimeout(seconds);
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        return getNestedDataSource().getLoginTimeout();
    }

    public String getUser() {
        try {
            return C3P0ImplUtils.findAuth(getNestedDataSource()).getUser();
        } catch (SQLException e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return null;
            }
            logger.log(MLevel.WARNING, "An Exception occurred while trying to find the 'user' property from our nested DataSource. Defaulting to no specified username.", (Throwable) e);
            return null;
        }
    }

    public String getPassword() {
        try {
            return C3P0ImplUtils.findAuth(getNestedDataSource()).getPassword();
        } catch (SQLException e) {
            if (!logger.isLoggable(MLevel.WARNING)) {
                return null;
            }
            logger.log(MLevel.WARNING, "An Exception occurred while trying to find the 'password' property from our nested DataSource. Defaulting to no specified password.", (Throwable) e);
            return null;
        }
    }

    public Map getUserOverrides() {
        return this.userOverrides;
    }

    @Override // com.mchange.p009v2.c3p0.impl.WrapperConnectionPoolDataSourceBase, java.lang.Object
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(toString());
        return sb.toString();
    }

    @Override // com.mchange.p009v2.c3p0.impl.WrapperConnectionPoolDataSourceBase
    protected String extraToStringInfo() {
        if (this.userOverrides != null) {
            return "; userOverrides: " + this.userOverrides.toString();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public synchronized void recreateConnectionTester(String className) throws Exception {
        if (className != null) {
            this.connectionTester = (ConnectionTester) Class.forName(className).newInstance();
        } else {
            this.connectionTester = C3P0Registry.getDefaultConnectionTester();
        }
    }
}
