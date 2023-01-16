package com.mchange.p009v2.c3p0.mbean;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.naming.NamingException;

/* renamed from: com.mchange.v2.c3p0.mbean.C3P0PooledDataSourceMBean */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/mbean/C3P0PooledDataSourceMBean.class */
public interface C3P0PooledDataSourceMBean {
    void setJndiName(String str) throws NamingException;

    String getJndiName();

    String getDescription();

    void setDescription(String str) throws NamingException;

    String getDriverClass();

    void setDriverClass(String str) throws PropertyVetoException, NamingException;

    String getJdbcUrl();

    void setJdbcUrl(String str) throws NamingException;

    String getUser();

    void setUser(String str) throws NamingException;

    String getPassword();

    void setPassword(String str) throws NamingException;

    int getCheckoutTimeout();

    void setCheckoutTimeout(int i) throws NamingException;

    int getAcquireIncrement();

    void setAcquireIncrement(int i) throws NamingException;

    int getAcquireRetryAttempts();

    void setAcquireRetryAttempts(int i) throws NamingException;

    int getAcquireRetryDelay();

    void setAcquireRetryDelay(int i) throws NamingException;

    boolean isAutoCommitOnClose();

    void setAutoCommitOnClose(boolean z) throws NamingException;

    String getConnectionTesterClassName();

    void setConnectionTesterClassName(String str) throws PropertyVetoException, NamingException;

    String getAutomaticTestTable();

    void setAutomaticTestTable(String str) throws NamingException;

    boolean isForceIgnoreUnresolvedTransactions();

    void setForceIgnoreUnresolvedTransactions(boolean z) throws NamingException;

    int getIdleConnectionTestPeriod();

    void setIdleConnectionTestPeriod(int i) throws NamingException;

    int getInitialPoolSize();

    void setInitialPoolSize(int i) throws NamingException;

    int getMaxIdleTime();

    void setMaxIdleTime(int i) throws NamingException;

    int getMaxPoolSize();

    void setMaxPoolSize(int i) throws NamingException;

    int getMaxStatements();

    void setMaxStatements(int i) throws NamingException;

    int getMaxStatementsPerConnection();

    void setMaxStatementsPerConnection(int i) throws NamingException;

    int getMinPoolSize();

    void setMinPoolSize(int i) throws NamingException;

    int getPropertyCycle();

    void setPropertyCycle(int i) throws NamingException;

    boolean isBreakAfterAcquireFailure();

    void setBreakAfterAcquireFailure(boolean z) throws NamingException;

    boolean isTestConnectionOnCheckout();

    void setTestConnectionOnCheckout(boolean z) throws NamingException;

    boolean isTestConnectionOnCheckin();

    void setTestConnectionOnCheckin(boolean z) throws NamingException;

    boolean isUsesTraditionalReflectiveProxies();

    void setUsesTraditionalReflectiveProxies(boolean z) throws NamingException;

    String getPreferredTestQuery();

    void setPreferredTestQuery(String str) throws NamingException;

    int getNumHelperThreads();

    void setNumHelperThreads(int i) throws NamingException;

    String getFactoryClassLocation();

    void setFactoryClassLocation(String str) throws NamingException;

    int getNumUserPools() throws SQLException;

    int getNumConnectionsDefaultUser() throws SQLException;

    int getNumIdleConnectionsDefaultUser() throws SQLException;

    int getNumBusyConnectionsDefaultUser() throws SQLException;

    int getNumUnclosedOrphanedConnectionsDefaultUser() throws SQLException;

    int getNumConnections(String str, String str2) throws SQLException;

    int getNumIdleConnections(String str, String str2) throws SQLException;

    int getNumBusyConnections(String str, String str2) throws SQLException;

    int getNumUnclosedOrphanedConnections(String str, String str2) throws SQLException;

    int getNumBusyConnectionsAllUsers() throws SQLException;

    int getNumIdleConnectionsAllUsers() throws SQLException;

    int getNumConnectionsAllUsers() throws SQLException;

    int getNumUnclosedOrphanedConnectionsAllUsers() throws SQLException;

    void softResetDefaultUser() throws SQLException;

    void softReset(String str, String str2) throws SQLException;

    void softResetAllUsers() throws SQLException;

    void hardReset() throws SQLException;

    void close() throws SQLException;

    void create() throws Exception;

    void start() throws Exception;

    void stop();

    void destroy();
}
