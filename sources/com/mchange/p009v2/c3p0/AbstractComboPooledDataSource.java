package com.mchange.p009v2.c3p0;

import com.mchange.p009v2.beans.BeansUtils;
import com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource;
import com.mchange.p009v2.lang.ObjectUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.naming.Referenceable;
import javax.sql.DataSource;

/* renamed from: com.mchange.v2.c3p0.AbstractComboPooledDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/AbstractComboPooledDataSource.class */
public abstract class AbstractComboPooledDataSource extends AbstractPoolBackedDataSource implements PooledDataSource, Serializable, Referenceable {
    static final MLogger logger = MLog.getLogger(AbstractComboPooledDataSource.class);
    static final Set TO_STRING_IGNORE_PROPS = new HashSet(Arrays.asList("connection", "lastAcquisitionFailureDefaultUser", "lastCheckinFailureDefaultUser", "lastCheckoutFailureDefaultUser", "lastConnectionTestFailureDefaultUser", "lastIdleTestFailureDefaultUser", "logWriter", "loginTimeout", "numBusyConnections", "numBusyConnectionsAllUsers", "numBusyConnectionsDefaultUser", "numConnections", "numConnectionsAllUsers", "numConnectionsDefaultUser", "numFailedCheckinsDefaultUser", "numFailedCheckoutsDefaultUser", "numFailedIdleTestsDefaultUser", "numIdleConnections", "numIdleConnectionsAllUsers", "numThreadsAwaitingCheckoutDefaultUser", "numIdleConnectionsDefaultUser", "numUnclosedOrphanedConnections", "numUnclosedOrphanedConnectionsAllUsers", "numUnclosedOrphanedConnectionsDefaultUser", "numUserPools", "effectivePropertyCycleDefaultUser", "parentLogger", "startTimeMillisDefaultUser", "statementCacheNumCheckedOutDefaultUser", "statementCacheNumCheckedOutStatementsAllUsers", "statementCacheNumConnectionsWithCachedStatementsAllUsers", "statementCacheNumConnectionsWithCachedStatementsDefaultUser", "statementCacheNumStatementsAllUsers", "statementCacheNumStatementsDefaultUser", "statementDestroyerNumConnectionsInUseAllUsers", "statementDestroyerNumConnectionsWithDeferredDestroyStatementsAllUsers", "statementDestroyerNumDeferredDestroyStatementsAllUsers", "statementDestroyerNumConnectionsInUseDefaultUser", "statementDestroyerNumConnectionsWithDeferredDestroyStatementsDefaultUser", "statementDestroyerNumDeferredDestroyStatementsDefaultUser", "statementDestroyerNumThreads", "statementDestroyerNumActiveThreads", "statementDestroyerNumIdleThreads", "statementDestroyerNumTasksPending", "threadPoolSize", "threadPoolNumActiveThreads", "threadPoolNumIdleThreads", "threadPoolNumTasksPending", "threadPoolStackTraces", "threadPoolStatus", "overrideDefaultUser", "overrideDefaultPassword", "password", "reference", "upTimeMillisDefaultUser", "user", "userOverridesAsString", "allUsers", "connectionPoolDataSource", "propertyChangeListeners", "vetoableChangeListeners"));
    transient DriverManagerDataSource dmds;
    transient WrapperConnectionPoolDataSource wcpds;
    private static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    private static boolean diff(int a, int b) {
        return a != b;
    }

    private static boolean diff(boolean a, boolean b) {
        return a != b;
    }

    private static boolean diff(Object a, Object b) {
        return !ObjectUtils.eqOrBothNull(a, b);
    }

    public AbstractComboPooledDataSource() {
        this(true);
    }

    public AbstractComboPooledDataSource(boolean autoregister) {
        super(autoregister);
        this.dmds = new DriverManagerDataSource();
        this.wcpds = new WrapperConnectionPoolDataSource();
        this.wcpds.setNestedDataSource(this.dmds);
        try {
            setConnectionPoolDataSource(this.wcpds);
            setUpPropertyEvents();
        } catch (PropertyVetoException e) {
            logger.log(MLevel.WARNING, "Hunh??? This can't happen. We haven't set up any listeners to veto the property change yet!", (Throwable) e);
            throw new RuntimeException("Hunh??? This can't happen. We haven't set up any listeners to veto the property change yet! " + e);
        }
    }

    private void setUpPropertyEvents() {
        addVetoableChangeListener(new VetoableChangeListener() { // from class: com.mchange.v2.c3p0.AbstractComboPooledDataSource.1
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                String propName = evt.getPropertyName();
                Object val = evt.getNewValue();
                if (!"connectionPoolDataSource".equals(propName)) {
                    return;
                }
                if (val instanceof WrapperConnectionPoolDataSource) {
                    DataSource nested = ((WrapperConnectionPoolDataSource) val).getNestedDataSource();
                    if (!(nested instanceof DriverManagerDataSource)) {
                        throw new PropertyVetoException(getClass().getName() + " requires that its unpooled DataSource  be set at all times, and that it be a com.mchange.v2.c3p0.DriverManagerDataSource. Bad: " + nested, evt);
                    }
                    return;
                }
                throw new PropertyVetoException(getClass().getName() + " requires that its ConnectionPoolDataSource  be set at all times, and that it be a com.mchange.v2.c3p0.WrapperConnectionPoolDataSource. Bad: " + val, evt);
            }
        });
        addPropertyChangeListener(new PropertyChangeListener() { // from class: com.mchange.v2.c3p0.AbstractComboPooledDataSource.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                String propName = evt.getPropertyName();
                evt.getNewValue();
                if ("connectionPoolDataSource".equals(propName)) {
                    AbstractComboPooledDataSource.this.updateLocalVarsFromCpdsProp();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateLocalVarsFromCpdsProp() {
        this.wcpds = (WrapperConnectionPoolDataSource) getConnectionPoolDataSource();
        this.dmds = (DriverManagerDataSource) this.wcpds.getNestedDataSource();
    }

    public AbstractComboPooledDataSource(String configName) {
        this();
        initializeNamedConfig(configName, true);
    }

    public String getDescription() {
        return this.dmds.getDescription();
    }

    public void setDescription(String description) {
        this.dmds.setDescription(description);
    }

    public String getDriverClass() {
        return this.dmds.getDriverClass();
    }

    public void setDriverClass(String driverClass) throws PropertyVetoException {
        this.dmds.setDriverClass(driverClass);
    }

    public boolean isForceUseNamedDriverClass() {
        return this.dmds.isForceUseNamedDriverClass();
    }

    public void setForceUseNamedDriverClass(boolean forceUseNamedDriverClass) {
        this.dmds.setForceUseNamedDriverClass(forceUseNamedDriverClass);
    }

    public String getJdbcUrl() {
        return this.dmds.getJdbcUrl();
    }

    public void setJdbcUrl(String jdbcUrl) {
        if (diff(this.dmds.getJdbcUrl(), jdbcUrl)) {
            this.dmds.setJdbcUrl(jdbcUrl);
            resetPoolManager(false);
        }
    }

    public Properties getProperties() {
        return this.dmds.getProperties();
    }

    public void setProperties(Properties properties) {
        if (diff(this.dmds.getProperties(), properties)) {
            this.dmds.setProperties(properties);
            resetPoolManager(false);
        }
    }

    public String getUser() {
        return this.dmds.getUser();
    }

    public void setUser(String user) {
        if (diff(this.dmds.getUser(), user)) {
            this.dmds.setUser(user);
            resetPoolManager(false);
        }
    }

    public String getPassword() {
        return this.dmds.getPassword();
    }

    public void setPassword(String password) {
        if (diff(this.dmds.getPassword(), password)) {
            this.dmds.setPassword(password);
            resetPoolManager(false);
        }
    }

    public int getCheckoutTimeout() {
        return this.wcpds.getCheckoutTimeout();
    }

    public void setCheckoutTimeout(int checkoutTimeout) {
        if (diff(this.wcpds.getCheckoutTimeout(), checkoutTimeout)) {
            this.wcpds.setCheckoutTimeout(checkoutTimeout);
            resetPoolManager(false);
        }
    }

    public int getAcquireIncrement() {
        return this.wcpds.getAcquireIncrement();
    }

    public void setAcquireIncrement(int acquireIncrement) {
        if (diff(this.wcpds.getAcquireIncrement(), acquireIncrement)) {
            this.wcpds.setAcquireIncrement(acquireIncrement);
            resetPoolManager(false);
        }
    }

    public int getAcquireRetryAttempts() {
        return this.wcpds.getAcquireRetryAttempts();
    }

    public void setAcquireRetryAttempts(int acquireRetryAttempts) {
        if (diff(this.wcpds.getAcquireRetryAttempts(), acquireRetryAttempts)) {
            this.wcpds.setAcquireRetryAttempts(acquireRetryAttempts);
            resetPoolManager(false);
        }
    }

    public int getAcquireRetryDelay() {
        return this.wcpds.getAcquireRetryDelay();
    }

    public void setAcquireRetryDelay(int acquireRetryDelay) {
        if (diff(this.wcpds.getAcquireRetryDelay(), acquireRetryDelay)) {
            this.wcpds.setAcquireRetryDelay(acquireRetryDelay);
            resetPoolManager(false);
        }
    }

    public boolean isAutoCommitOnClose() {
        return this.wcpds.isAutoCommitOnClose();
    }

    public void setAutoCommitOnClose(boolean autoCommitOnClose) {
        if (diff(this.wcpds.isAutoCommitOnClose(), autoCommitOnClose)) {
            this.wcpds.setAutoCommitOnClose(autoCommitOnClose);
            resetPoolManager(false);
        }
    }

    public String getContextClassLoaderSource() {
        return this.wcpds.getContextClassLoaderSource();
    }

    public void setContextClassLoaderSource(String contextClassLoaderSource) throws PropertyVetoException {
        if (diff(this.wcpds.getContextClassLoaderSource(), contextClassLoaderSource)) {
            this.wcpds.setContextClassLoaderSource(contextClassLoaderSource);
            resetPoolManager(false);
        }
    }

    public String getConnectionTesterClassName() {
        return this.wcpds.getConnectionTesterClassName();
    }

    public void setConnectionTesterClassName(String connectionTesterClassName) throws PropertyVetoException {
        if (diff(this.wcpds.getConnectionTesterClassName(), connectionTesterClassName)) {
            this.wcpds.setConnectionTesterClassName(connectionTesterClassName);
            resetPoolManager(false);
        }
    }

    public String getAutomaticTestTable() {
        return this.wcpds.getAutomaticTestTable();
    }

    public void setAutomaticTestTable(String automaticTestTable) {
        if (diff(this.wcpds.getAutomaticTestTable(), automaticTestTable)) {
            this.wcpds.setAutomaticTestTable(automaticTestTable);
            resetPoolManager(false);
        }
    }

    public boolean isForceIgnoreUnresolvedTransactions() {
        return this.wcpds.isForceIgnoreUnresolvedTransactions();
    }

    public void setForceIgnoreUnresolvedTransactions(boolean forceIgnoreUnresolvedTransactions) {
        if (diff(this.wcpds.isForceIgnoreUnresolvedTransactions(), forceIgnoreUnresolvedTransactions)) {
            this.wcpds.setForceIgnoreUnresolvedTransactions(forceIgnoreUnresolvedTransactions);
            resetPoolManager(false);
        }
    }

    public boolean isPrivilegeSpawnedThreads() {
        return this.wcpds.isPrivilegeSpawnedThreads();
    }

    public void setPrivilegeSpawnedThreads(boolean privilegeSpawnedThreads) {
        if (diff(this.wcpds.isPrivilegeSpawnedThreads(), privilegeSpawnedThreads)) {
            this.wcpds.setPrivilegeSpawnedThreads(privilegeSpawnedThreads);
            resetPoolManager(false);
        }
    }

    public int getIdleConnectionTestPeriod() {
        return this.wcpds.getIdleConnectionTestPeriod();
    }

    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        if (diff(this.wcpds.getIdleConnectionTestPeriod(), idleConnectionTestPeriod)) {
            this.wcpds.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
            resetPoolManager(false);
        }
    }

    public int getInitialPoolSize() {
        return this.wcpds.getInitialPoolSize();
    }

    public void setInitialPoolSize(int initialPoolSize) {
        if (diff(this.wcpds.getInitialPoolSize(), initialPoolSize)) {
            this.wcpds.setInitialPoolSize(initialPoolSize);
            resetPoolManager(false);
        }
    }

    public int getMaxIdleTime() {
        return this.wcpds.getMaxIdleTime();
    }

    public void setMaxIdleTime(int maxIdleTime) {
        if (diff(this.wcpds.getMaxIdleTime(), maxIdleTime)) {
            this.wcpds.setMaxIdleTime(maxIdleTime);
            resetPoolManager(false);
        }
    }

    public int getMaxPoolSize() {
        return this.wcpds.getMaxPoolSize();
    }

    public void setMaxPoolSize(int maxPoolSize) {
        if (diff(this.wcpds.getMaxPoolSize(), maxPoolSize)) {
            this.wcpds.setMaxPoolSize(maxPoolSize);
            resetPoolManager(false);
        }
    }

    public int getMaxStatements() {
        return this.wcpds.getMaxStatements();
    }

    public void setMaxStatements(int maxStatements) {
        if (diff(this.wcpds.getMaxStatements(), maxStatements)) {
            this.wcpds.setMaxStatements(maxStatements);
            resetPoolManager(false);
        }
    }

    public int getMaxStatementsPerConnection() {
        return this.wcpds.getMaxStatementsPerConnection();
    }

    public void setMaxStatementsPerConnection(int maxStatementsPerConnection) {
        if (diff(this.wcpds.getMaxStatementsPerConnection(), maxStatementsPerConnection)) {
            this.wcpds.setMaxStatementsPerConnection(maxStatementsPerConnection);
            resetPoolManager(false);
        }
    }

    public int getMinPoolSize() {
        return this.wcpds.getMinPoolSize();
    }

    public void setMinPoolSize(int minPoolSize) {
        if (diff(this.wcpds.getMinPoolSize(), minPoolSize)) {
            this.wcpds.setMinPoolSize(minPoolSize);
            resetPoolManager(false);
        }
    }

    public String getOverrideDefaultUser() {
        return this.wcpds.getOverrideDefaultUser();
    }

    public void setOverrideDefaultUser(String overrideDefaultUser) {
        if (diff(this.wcpds.getOverrideDefaultUser(), overrideDefaultUser)) {
            this.wcpds.setOverrideDefaultUser(overrideDefaultUser);
            resetPoolManager(false);
        }
    }

    public String getOverrideDefaultPassword() {
        return this.wcpds.getOverrideDefaultPassword();
    }

    public void setOverrideDefaultPassword(String overrideDefaultPassword) {
        if (diff(this.wcpds.getOverrideDefaultPassword(), overrideDefaultPassword)) {
            this.wcpds.setOverrideDefaultPassword(overrideDefaultPassword);
            resetPoolManager(false);
        }
    }

    public int getPropertyCycle() {
        return this.wcpds.getPropertyCycle();
    }

    public void setPropertyCycle(int propertyCycle) {
        if (diff(this.wcpds.getPropertyCycle(), propertyCycle)) {
            this.wcpds.setPropertyCycle(propertyCycle);
            resetPoolManager(false);
        }
    }

    public boolean isBreakAfterAcquireFailure() {
        return this.wcpds.isBreakAfterAcquireFailure();
    }

    public void setBreakAfterAcquireFailure(boolean breakAfterAcquireFailure) {
        if (diff(this.wcpds.isBreakAfterAcquireFailure(), breakAfterAcquireFailure)) {
            this.wcpds.setBreakAfterAcquireFailure(breakAfterAcquireFailure);
            resetPoolManager(false);
        }
    }

    public boolean isTestConnectionOnCheckout() {
        return this.wcpds.isTestConnectionOnCheckout();
    }

    public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) {
        if (diff(this.wcpds.isTestConnectionOnCheckout(), testConnectionOnCheckout)) {
            this.wcpds.setTestConnectionOnCheckout(testConnectionOnCheckout);
            resetPoolManager(false);
        }
    }

    public boolean isTestConnectionOnCheckin() {
        return this.wcpds.isTestConnectionOnCheckin();
    }

    public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
        if (diff(this.wcpds.isTestConnectionOnCheckin(), testConnectionOnCheckin)) {
            this.wcpds.setTestConnectionOnCheckin(testConnectionOnCheckin);
            resetPoolManager(false);
        }
    }

    public boolean isUsesTraditionalReflectiveProxies() {
        return this.wcpds.isUsesTraditionalReflectiveProxies();
    }

    public void setUsesTraditionalReflectiveProxies(boolean usesTraditionalReflectiveProxies) {
        if (diff(this.wcpds.isUsesTraditionalReflectiveProxies(), usesTraditionalReflectiveProxies)) {
            this.wcpds.setUsesTraditionalReflectiveProxies(usesTraditionalReflectiveProxies);
            resetPoolManager(false);
        }
    }

    public String getPreferredTestQuery() {
        return this.wcpds.getPreferredTestQuery();
    }

    public void setPreferredTestQuery(String preferredTestQuery) {
        if (diff(this.wcpds.getPreferredTestQuery(), preferredTestQuery)) {
            this.wcpds.setPreferredTestQuery(preferredTestQuery);
            resetPoolManager(false);
        }
    }

    public int getMaxAdministrativeTaskTime() {
        return this.wcpds.getMaxAdministrativeTaskTime();
    }

    public void setMaxAdministrativeTaskTime(int maxAdministrativeTaskTime) {
        if (diff(this.wcpds.getMaxAdministrativeTaskTime(), maxAdministrativeTaskTime)) {
            this.wcpds.setMaxAdministrativeTaskTime(maxAdministrativeTaskTime);
            resetPoolManager(false);
        }
    }

    public int getMaxIdleTimeExcessConnections() {
        return this.wcpds.getMaxIdleTimeExcessConnections();
    }

    public void setMaxIdleTimeExcessConnections(int maxIdleTimeExcessConnections) {
        if (diff(this.wcpds.getMaxIdleTimeExcessConnections(), maxIdleTimeExcessConnections)) {
            this.wcpds.setMaxIdleTimeExcessConnections(maxIdleTimeExcessConnections);
            resetPoolManager(false);
        }
    }

    public int getMaxConnectionAge() {
        return this.wcpds.getMaxConnectionAge();
    }

    public void setMaxConnectionAge(int maxConnectionAge) {
        if (diff(this.wcpds.getMaxConnectionAge(), maxConnectionAge)) {
            this.wcpds.setMaxConnectionAge(maxConnectionAge);
            resetPoolManager(false);
        }
    }

    public String getConnectionCustomizerClassName() {
        return this.wcpds.getConnectionCustomizerClassName();
    }

    public void setConnectionCustomizerClassName(String connectionCustomizerClassName) {
        if (diff(this.wcpds.getConnectionCustomizerClassName(), connectionCustomizerClassName)) {
            this.wcpds.setConnectionCustomizerClassName(connectionCustomizerClassName);
            resetPoolManager(false);
        }
    }

    public int getUnreturnedConnectionTimeout() {
        return this.wcpds.getUnreturnedConnectionTimeout();
    }

    public void setUnreturnedConnectionTimeout(int unreturnedConnectionTimeout) {
        if (diff(this.wcpds.getUnreturnedConnectionTimeout(), unreturnedConnectionTimeout)) {
            this.wcpds.setUnreturnedConnectionTimeout(unreturnedConnectionTimeout);
            resetPoolManager(false);
        }
    }

    public String getUserOverridesAsString() {
        return this.wcpds.getUserOverridesAsString();
    }

    public void setUserOverridesAsString(String uoas) throws PropertyVetoException {
        if (diff(this.wcpds.getUserOverridesAsString(), uoas)) {
            this.wcpds.setUserOverridesAsString(uoas);
            resetPoolManager(false);
        }
    }

    public Map getUserOverrides() {
        return this.wcpds.getUserOverrides();
    }

    public boolean isDebugUnreturnedConnectionStackTraces() {
        return this.wcpds.isDebugUnreturnedConnectionStackTraces();
    }

    public void setDebugUnreturnedConnectionStackTraces(boolean debugUnreturnedConnectionStackTraces) {
        if (diff(this.wcpds.isDebugUnreturnedConnectionStackTraces(), debugUnreturnedConnectionStackTraces)) {
            this.wcpds.setDebugUnreturnedConnectionStackTraces(debugUnreturnedConnectionStackTraces);
            resetPoolManager(false);
        }
    }

    public boolean isForceSynchronousCheckins() {
        return this.wcpds.isForceSynchronousCheckins();
    }

    public void setForceSynchronousCheckins(boolean forceSynchronousCheckins) {
        if (diff(this.wcpds.isForceSynchronousCheckins(), forceSynchronousCheckins)) {
            this.wcpds.setForceSynchronousCheckins(forceSynchronousCheckins);
            resetPoolManager(false);
        }
    }

    public int getStatementCacheNumDeferredCloseThreads() {
        return this.wcpds.getStatementCacheNumDeferredCloseThreads();
    }

    public void setStatementCacheNumDeferredCloseThreads(int statementCacheNumDeferredCloseThreads) {
        if (diff(this.wcpds.getStatementCacheNumDeferredCloseThreads(), statementCacheNumDeferredCloseThreads)) {
            this.wcpds.setStatementCacheNumDeferredCloseThreads(statementCacheNumDeferredCloseThreads);
            resetPoolManager(false);
        }
    }

    @Override // com.mchange.p009v2.c3p0.impl.PoolBackedDataSourceBase
    public String getFactoryClassLocation() {
        return getFactoryClassLocation();
    }

    @Override // com.mchange.p009v2.c3p0.impl.PoolBackedDataSourceBase
    public void setFactoryClassLocation(String factoryClassLocation) {
        if (diff(this.dmds.getFactoryClassLocation(), factoryClassLocation) || diff(this.wcpds.getFactoryClassLocation(), factoryClassLocation) || diff(getFactoryClassLocation(), factoryClassLocation)) {
            this.dmds.setFactoryClassLocation(factoryClassLocation);
            this.wcpds.setFactoryClassLocation(factoryClassLocation);
            setFactoryClassLocation(factoryClassLocation);
        }
    }

    @Override // com.mchange.p009v2.c3p0.impl.PoolBackedDataSourceBase, java.lang.Object
    public String toString() {
        return toString(false);
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource
    public String toString(boolean show_config) {
        if (!show_config) {
            return getClass().getName() + "[ identityToken -> " + getIdentityToken() + ", dataSourceName -> " + getDataSourceName() + " ]";
        }
        StringBuffer sb = new StringBuffer(512);
        sb.append(getClass().getName());
        sb.append(" [ ");
        try {
            BeansUtils.appendPropNamesAndValues(sb, this, TO_STRING_IGNORE_PROPS);
        } catch (Exception e) {
            sb.append(e.toString());
        }
        sb.append(" ]");
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeShort(1);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        short version = ois.readShort();
        switch (version) {
            case 1:
                updateLocalVarsFromCpdsProp();
                setUpPropertyEvents();
                return;
            default:
                throw new IOException("Unsupported Serialized Version: " + ((int) version));
        }
    }

    private boolean isWrapperForDmds(Class<?> iface) {
        return iface.isAssignableFrom(this.dmds.getClass());
    }

    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource, java.sql.Wrapper
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return isWrapperForDmds(iface) || isWrapperForThis(iface);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.mchange.v2.c3p0.AbstractComboPooledDataSource */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mchange.p009v2.c3p0.impl.AbstractPoolBackedDataSource, java.sql.Wrapper
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (isWrapperForDmds(iface)) {
            return (T) this.dmds.unwrap(iface);
        }
        if (isWrapperForThis(iface)) {
            return this;
        }
        throw new SQLException(this + " is not a wrapper for or implementation of " + iface.getName());
    }
}
