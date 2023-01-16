package com.mchange.p009v2.c3p0.mbean;

import com.mchange.p009v2.c3p0.ComboPooledDataSource;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NamingException;

/* renamed from: com.mchange.v2.c3p0.mbean.C3P0PooledDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/mbean/C3P0PooledDataSource.class */
public class C3P0PooledDataSource implements C3P0PooledDataSourceMBean {
    private static final MLogger logger = MLog.getLogger(C3P0PooledDataSource.class);
    String jndiName;
    ComboPooledDataSource combods = new ComboPooledDataSource();

    private void rebind() throws NamingException {
        rebind(null);
    }

    private void rebind(String unbindName) throws NamingException {
        Context ictx = new InitialContext();
        if (unbindName != null) {
            ictx.unbind(unbindName);
        }
        if (this.jndiName != null) {
            Name name = ictx.getNameParser(this.jndiName).parse(this.jndiName);
            Context ctx = ictx;
            int max = name.size() - 1;
            for (int i = 0; i < max; i++) {
                try {
                    ctx = ctx.createSubcontext(name.get(i));
                } catch (NameAlreadyBoundException e) {
                    ctx = (Context) ctx.lookup(name.get(i));
                }
            }
            ictx.rebind(this.jndiName, this.combods);
        }
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setJndiName(String jndiName) throws NamingException {
        String unbindName = this.jndiName;
        this.jndiName = jndiName;
        rebind(unbindName);
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getJndiName() {
        return this.jndiName;
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getDescription() {
        return this.combods.getDescription();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setDescription(String description) throws NamingException {
        this.combods.setDescription(description);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getDriverClass() {
        return this.combods.getDriverClass();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setDriverClass(String driverClass) throws PropertyVetoException, NamingException {
        this.combods.setDriverClass(driverClass);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getJdbcUrl() {
        return this.combods.getJdbcUrl();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setJdbcUrl(String jdbcUrl) throws NamingException {
        this.combods.setJdbcUrl(jdbcUrl);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getUser() {
        return this.combods.getUser();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setUser(String user) throws NamingException {
        this.combods.setUser(user);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getPassword() {
        return this.combods.getPassword();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setPassword(String password) throws NamingException {
        this.combods.setPassword(password);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getCheckoutTimeout() {
        return this.combods.getCheckoutTimeout();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setCheckoutTimeout(int checkoutTimeout) throws NamingException {
        this.combods.setCheckoutTimeout(checkoutTimeout);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getAcquireIncrement() {
        return this.combods.getAcquireIncrement();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setAcquireIncrement(int acquireIncrement) throws NamingException {
        this.combods.setAcquireIncrement(acquireIncrement);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getAcquireRetryAttempts() {
        return this.combods.getAcquireRetryAttempts();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setAcquireRetryAttempts(int acquireRetryAttempts) throws NamingException {
        this.combods.setAcquireRetryAttempts(acquireRetryAttempts);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getAcquireRetryDelay() {
        return this.combods.getAcquireRetryDelay();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setAcquireRetryDelay(int acquireRetryDelay) throws NamingException {
        this.combods.setAcquireRetryDelay(acquireRetryDelay);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public boolean isAutoCommitOnClose() {
        return this.combods.isAutoCommitOnClose();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setAutoCommitOnClose(boolean autoCommitOnClose) throws NamingException {
        this.combods.setAutoCommitOnClose(autoCommitOnClose);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getConnectionTesterClassName() {
        return this.combods.getConnectionTesterClassName();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setConnectionTesterClassName(String connectionTesterClassName) throws PropertyVetoException, NamingException {
        this.combods.setConnectionTesterClassName(connectionTesterClassName);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getAutomaticTestTable() {
        return this.combods.getAutomaticTestTable();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setAutomaticTestTable(String automaticTestTable) throws NamingException {
        this.combods.setAutomaticTestTable(automaticTestTable);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public boolean isForceIgnoreUnresolvedTransactions() {
        return this.combods.isForceIgnoreUnresolvedTransactions();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setForceIgnoreUnresolvedTransactions(boolean forceIgnoreUnresolvedTransactions) throws NamingException {
        this.combods.setForceIgnoreUnresolvedTransactions(forceIgnoreUnresolvedTransactions);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getIdleConnectionTestPeriod() {
        return this.combods.getIdleConnectionTestPeriod();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) throws NamingException {
        this.combods.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getInitialPoolSize() {
        return this.combods.getInitialPoolSize();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setInitialPoolSize(int initialPoolSize) throws NamingException {
        this.combods.setInitialPoolSize(initialPoolSize);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getMaxIdleTime() {
        return this.combods.getMaxIdleTime();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setMaxIdleTime(int maxIdleTime) throws NamingException {
        this.combods.setMaxIdleTime(maxIdleTime);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getMaxPoolSize() {
        return this.combods.getMaxPoolSize();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setMaxPoolSize(int maxPoolSize) throws NamingException {
        this.combods.setMaxPoolSize(maxPoolSize);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getMaxStatements() {
        return this.combods.getMaxStatements();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setMaxStatements(int maxStatements) throws NamingException {
        this.combods.setMaxStatements(maxStatements);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getMaxStatementsPerConnection() {
        return this.combods.getMaxStatementsPerConnection();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setMaxStatementsPerConnection(int maxStatementsPerConnection) throws NamingException {
        this.combods.setMaxStatementsPerConnection(maxStatementsPerConnection);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getMinPoolSize() {
        return this.combods.getMinPoolSize();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setMinPoolSize(int minPoolSize) throws NamingException {
        this.combods.setMinPoolSize(minPoolSize);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getPropertyCycle() {
        return this.combods.getPropertyCycle();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setPropertyCycle(int propertyCycle) throws NamingException {
        this.combods.setPropertyCycle(propertyCycle);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public boolean isBreakAfterAcquireFailure() {
        return this.combods.isBreakAfterAcquireFailure();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setBreakAfterAcquireFailure(boolean breakAfterAcquireFailure) throws NamingException {
        this.combods.setBreakAfterAcquireFailure(breakAfterAcquireFailure);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public boolean isTestConnectionOnCheckout() {
        return this.combods.isTestConnectionOnCheckout();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) throws NamingException {
        this.combods.setTestConnectionOnCheckout(testConnectionOnCheckout);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public boolean isTestConnectionOnCheckin() {
        return this.combods.isTestConnectionOnCheckin();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) throws NamingException {
        this.combods.setTestConnectionOnCheckin(testConnectionOnCheckin);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public boolean isUsesTraditionalReflectiveProxies() {
        return this.combods.isUsesTraditionalReflectiveProxies();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setUsesTraditionalReflectiveProxies(boolean usesTraditionalReflectiveProxies) throws NamingException {
        this.combods.setUsesTraditionalReflectiveProxies(usesTraditionalReflectiveProxies);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getPreferredTestQuery() {
        return this.combods.getPreferredTestQuery();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setPreferredTestQuery(String preferredTestQuery) throws NamingException {
        this.combods.setPreferredTestQuery(preferredTestQuery);
        rebind();
    }

    public String getDataSourceName() {
        return this.combods.getDataSourceName();
    }

    public void setDataSourceName(String name) throws NamingException {
        this.combods.setDataSourceName(name);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumHelperThreads() {
        return this.combods.getNumHelperThreads();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setNumHelperThreads(int numHelperThreads) throws NamingException {
        this.combods.setNumHelperThreads(numHelperThreads);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public String getFactoryClassLocation() {
        return this.combods.getFactoryClassLocation();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void setFactoryClassLocation(String factoryClassLocation) throws NamingException {
        this.combods.setFactoryClassLocation(factoryClassLocation);
        rebind();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumUserPools() throws SQLException {
        return this.combods.getNumUserPools();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumConnectionsDefaultUser() throws SQLException {
        return this.combods.getNumConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumIdleConnectionsDefaultUser() throws SQLException {
        return this.combods.getNumIdleConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumBusyConnectionsDefaultUser() throws SQLException {
        return this.combods.getNumBusyConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumUnclosedOrphanedConnectionsDefaultUser() throws SQLException {
        return this.combods.getNumUnclosedOrphanedConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumConnections(String username, String password) throws SQLException {
        return this.combods.getNumConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumIdleConnections(String username, String password) throws SQLException {
        return this.combods.getNumIdleConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumBusyConnections(String username, String password) throws SQLException {
        return this.combods.getNumBusyConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumUnclosedOrphanedConnections(String username, String password) throws SQLException {
        return this.combods.getNumUnclosedOrphanedConnections(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumConnectionsAllUsers() throws SQLException {
        return this.combods.getNumConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumIdleConnectionsAllUsers() throws SQLException {
        return this.combods.getNumIdleConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumBusyConnectionsAllUsers() throws SQLException {
        return this.combods.getNumBusyConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public int getNumUnclosedOrphanedConnectionsAllUsers() throws SQLException {
        return this.combods.getNumUnclosedOrphanedConnectionsAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void softResetDefaultUser() throws SQLException {
        this.combods.softResetDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void softReset(String username, String password) throws SQLException {
        this.combods.softReset(username, password);
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void softResetAllUsers() throws SQLException {
        this.combods.softResetAllUsers();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void hardReset() throws SQLException {
        this.combods.hardReset();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void close() throws SQLException {
        this.combods.close();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void create() throws Exception {
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void start() throws Exception {
        logger.log(MLevel.INFO, "Bound C3P0 PooledDataSource to name ''{0}''. Starting...", this.jndiName);
        this.combods.getNumBusyConnectionsDefaultUser();
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void stop() {
    }

    @Override // com.mchange.p009v2.c3p0.mbean.C3P0PooledDataSourceMBean
    public void destroy() {
    }
}
