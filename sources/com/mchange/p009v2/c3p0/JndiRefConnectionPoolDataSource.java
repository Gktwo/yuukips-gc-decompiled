package com.mchange.p009v2.c3p0;

import com.mchange.p009v2.beans.BeansUtils;
import com.mchange.p009v2.c3p0.impl.C3P0ImplUtils;
import com.mchange.p009v2.c3p0.impl.C3P0JavaBeanObjectFactory;
import com.mchange.p009v2.c3p0.impl.IdentityTokenResolvable;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.naming.JavaBeanReferenceMaker;
import java.beans.PropertyVetoException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
import org.quartz.utils.C3p0PoolingConnectionProvider;

/* renamed from: com.mchange.v2.c3p0.JndiRefConnectionPoolDataSource */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/JndiRefConnectionPoolDataSource.class */
public final class JndiRefConnectionPoolDataSource extends IdentityTokenResolvable implements ConnectionPoolDataSource, Serializable, Referenceable {
    JndiRefForwardingDataSource jrfds;
    WrapperConnectionPoolDataSource wcpds;
    String identityToken;
    static final MLogger logger = MLog.getLogger(JndiRefConnectionPoolDataSource.class);
    static final Collection IGNORE_PROPS = Arrays.asList("reference", "pooledConnection");
    static final JavaBeanReferenceMaker referenceMaker = new JavaBeanReferenceMaker();

    static {
        referenceMaker.setFactoryClassName(C3P0JavaBeanObjectFactory.class.getName());
        referenceMaker.addReferenceProperty("acquireIncrement");
        referenceMaker.addReferenceProperty("acquireRetryAttempts");
        referenceMaker.addReferenceProperty("acquireRetryDelay");
        referenceMaker.addReferenceProperty("autoCommitOnClose");
        referenceMaker.addReferenceProperty("automaticTestTable");
        referenceMaker.addReferenceProperty("checkoutTimeout");
        referenceMaker.addReferenceProperty("connectionTesterClassName");
        referenceMaker.addReferenceProperty("factoryClassLocation");
        referenceMaker.addReferenceProperty("forceIgnoreUnresolvedTransactions");
        referenceMaker.addReferenceProperty("idleConnectionTestPeriod");
        referenceMaker.addReferenceProperty("identityToken");
        referenceMaker.addReferenceProperty("initialPoolSize");
        referenceMaker.addReferenceProperty("jndiEnv");
        referenceMaker.addReferenceProperty("jndiLookupCaching");
        referenceMaker.addReferenceProperty("jndiName");
        referenceMaker.addReferenceProperty(C3p0PoolingConnectionProvider.DB_DISCARD_IDLE_CONNECTIONS_SECONDS);
        referenceMaker.addReferenceProperty("maxPoolSize");
        referenceMaker.addReferenceProperty("maxStatements");
        referenceMaker.addReferenceProperty("maxStatementsPerConnection");
        referenceMaker.addReferenceProperty("minPoolSize");
        referenceMaker.addReferenceProperty("preferredTestQuery");
        referenceMaker.addReferenceProperty("propertyCycle");
        referenceMaker.addReferenceProperty("testConnectionOnCheckin");
        referenceMaker.addReferenceProperty("testConnectionOnCheckout");
        referenceMaker.addReferenceProperty("usesTraditionalReflectiveProxies");
    }

    public JndiRefConnectionPoolDataSource() {
        this(true);
    }

    public JndiRefConnectionPoolDataSource(boolean autoregister) {
        this.jrfds = new JndiRefForwardingDataSource();
        this.wcpds = new WrapperConnectionPoolDataSource();
        this.wcpds.setNestedDataSource(this.jrfds);
        if (autoregister) {
            this.identityToken = C3P0ImplUtils.allocateIdentityToken(this);
            C3P0Registry.reregister(this);
        }
    }

    public boolean isJndiLookupCaching() {
        return this.jrfds.isCaching();
    }

    public void setJndiLookupCaching(boolean caching) {
        this.jrfds.setCaching(caching);
    }

    public Hashtable getJndiEnv() {
        return this.jrfds.getJndiEnv();
    }

    public void setJndiEnv(Hashtable jndiEnv) {
        this.jrfds.setJndiEnv(jndiEnv);
    }

    public Object getJndiName() {
        return this.jrfds.getJndiName();
    }

    public void setJndiName(Object jndiName) throws PropertyVetoException {
        this.jrfds.setJndiName(jndiName);
    }

    public int getAcquireIncrement() {
        return this.wcpds.getAcquireIncrement();
    }

    public void setAcquireIncrement(int acquireIncrement) {
        this.wcpds.setAcquireIncrement(acquireIncrement);
    }

    public int getAcquireRetryAttempts() {
        return this.wcpds.getAcquireRetryAttempts();
    }

    public void setAcquireRetryAttempts(int ara) {
        this.wcpds.setAcquireRetryAttempts(ara);
    }

    public int getAcquireRetryDelay() {
        return this.wcpds.getAcquireRetryDelay();
    }

    public void setAcquireRetryDelay(int ard) {
        this.wcpds.setAcquireRetryDelay(ard);
    }

    public boolean isAutoCommitOnClose() {
        return this.wcpds.isAutoCommitOnClose();
    }

    public void setAutoCommitOnClose(boolean autoCommitOnClose) {
        this.wcpds.setAutoCommitOnClose(autoCommitOnClose);
    }

    public void setAutomaticTestTable(String att) {
        this.wcpds.setAutomaticTestTable(att);
    }

    public String getAutomaticTestTable() {
        return this.wcpds.getAutomaticTestTable();
    }

    public void setBreakAfterAcquireFailure(boolean baaf) {
        this.wcpds.setBreakAfterAcquireFailure(baaf);
    }

    public boolean isBreakAfterAcquireFailure() {
        return this.wcpds.isBreakAfterAcquireFailure();
    }

    public void setCheckoutTimeout(int ct) {
        this.wcpds.setCheckoutTimeout(ct);
    }

    public int getCheckoutTimeout() {
        return this.wcpds.getCheckoutTimeout();
    }

    public String getConnectionTesterClassName() {
        return this.wcpds.getConnectionTesterClassName();
    }

    public void setConnectionTesterClassName(String connectionTesterClassName) throws PropertyVetoException {
        this.wcpds.setConnectionTesterClassName(connectionTesterClassName);
    }

    public boolean isForceIgnoreUnresolvedTransactions() {
        return this.wcpds.isForceIgnoreUnresolvedTransactions();
    }

    public void setForceIgnoreUnresolvedTransactions(boolean forceIgnoreUnresolvedTransactions) {
        this.wcpds.setForceIgnoreUnresolvedTransactions(forceIgnoreUnresolvedTransactions);
    }

    @Override // com.mchange.p009v2.c3p0.impl.IdentityTokenized
    public String getIdentityToken() {
        return this.identityToken;
    }

    @Override // com.mchange.p009v2.c3p0.impl.IdentityTokenized
    public void setIdentityToken(String identityToken) {
        this.identityToken = identityToken;
    }

    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        this.wcpds.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
    }

    public int getIdleConnectionTestPeriod() {
        return this.wcpds.getIdleConnectionTestPeriod();
    }

    public int getInitialPoolSize() {
        return this.wcpds.getInitialPoolSize();
    }

    public void setInitialPoolSize(int initialPoolSize) {
        this.wcpds.setInitialPoolSize(initialPoolSize);
    }

    public int getMaxIdleTime() {
        return this.wcpds.getMaxIdleTime();
    }

    public void setMaxIdleTime(int maxIdleTime) {
        this.wcpds.setMaxIdleTime(maxIdleTime);
    }

    public int getMaxPoolSize() {
        return this.wcpds.getMaxPoolSize();
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.wcpds.setMaxPoolSize(maxPoolSize);
    }

    public int getMaxStatements() {
        return this.wcpds.getMaxStatements();
    }

    public void setMaxStatements(int maxStatements) {
        this.wcpds.setMaxStatements(maxStatements);
    }

    public int getMaxStatementsPerConnection() {
        return this.wcpds.getMaxStatementsPerConnection();
    }

    public void setMaxStatementsPerConnection(int mspc) {
        this.wcpds.setMaxStatementsPerConnection(mspc);
    }

    public int getMinPoolSize() {
        return this.wcpds.getMinPoolSize();
    }

    public void setMinPoolSize(int minPoolSize) {
        this.wcpds.setMinPoolSize(minPoolSize);
    }

    public String getPreferredTestQuery() {
        return this.wcpds.getPreferredTestQuery();
    }

    public void setPreferredTestQuery(String ptq) {
        this.wcpds.setPreferredTestQuery(ptq);
    }

    public int getPropertyCycle() {
        return this.wcpds.getPropertyCycle();
    }

    public void setPropertyCycle(int propertyCycle) {
        this.wcpds.setPropertyCycle(propertyCycle);
    }

    public boolean isTestConnectionOnCheckin() {
        return this.wcpds.isTestConnectionOnCheckin();
    }

    public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
        this.wcpds.setTestConnectionOnCheckin(testConnectionOnCheckin);
    }

    public boolean isTestConnectionOnCheckout() {
        return this.wcpds.isTestConnectionOnCheckout();
    }

    public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) {
        this.wcpds.setTestConnectionOnCheckout(testConnectionOnCheckout);
    }

    public boolean isUsesTraditionalReflectiveProxies() {
        return this.wcpds.isUsesTraditionalReflectiveProxies();
    }

    public void setUsesTraditionalReflectiveProxies(boolean utrp) {
        this.wcpds.setUsesTraditionalReflectiveProxies(utrp);
    }

    public String getFactoryClassLocation() {
        return this.jrfds.getFactoryClassLocation();
    }

    public void setFactoryClassLocation(String factoryClassLocation) {
        this.jrfds.setFactoryClassLocation(factoryClassLocation);
        this.wcpds.setFactoryClassLocation(factoryClassLocation);
    }

    public Reference getReference() throws NamingException {
        return referenceMaker.createReference(this);
    }

    @Override // javax.sql.ConnectionPoolDataSource
    public PooledConnection getPooledConnection() throws SQLException {
        return this.wcpds.getPooledConnection();
    }

    @Override // javax.sql.ConnectionPoolDataSource
    public PooledConnection getPooledConnection(String user, String password) throws SQLException {
        return this.wcpds.getPooledConnection(user, password);
    }

    @Override // javax.sql.CommonDataSource
    public PrintWriter getLogWriter() throws SQLException {
        return this.wcpds.getLogWriter();
    }

    @Override // javax.sql.CommonDataSource
    public void setLogWriter(PrintWriter out) throws SQLException {
        this.wcpds.setLogWriter(out);
    }

    @Override // javax.sql.CommonDataSource
    public void setLoginTimeout(int seconds) throws SQLException {
        this.wcpds.setLoginTimeout(seconds);
    }

    @Override // javax.sql.CommonDataSource
    public int getLoginTimeout() throws SQLException {
        return this.wcpds.getLoginTimeout();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer sb = new StringBuffer(512);
        sb.append(toString());
        sb.append(" [");
        try {
            BeansUtils.appendPropNamesAndValues(sb, this, IGNORE_PROPS);
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "An exception occurred while extracting property names and values for toString()", (Throwable) e);
            }
            sb.append(e.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // javax.sql.CommonDataSource
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException("javax.sql.DataSource.getParentLogger() is not currently supported by " + getClass().getName());
    }
}
