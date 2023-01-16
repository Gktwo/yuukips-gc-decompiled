package com.zaxxer.hikari;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import com.zaxxer.hikari.util.PropertyElf;
import com.zaxxer.hikari.util.UtilityElf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.TreeSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import kotlin.jvm.internal.LongCompanionObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/HikariConfig.class */
public class HikariConfig implements HikariConfigMXBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(HikariConfig.class);
    private static final long CONNECTION_TIMEOUT = TimeUnit.SECONDS.toMillis(30);
    private static final long VALIDATION_TIMEOUT = TimeUnit.SECONDS.toMillis(5);
    private static final long IDLE_TIMEOUT = TimeUnit.MINUTES.toMillis(10);
    private static final long MAX_LIFETIME = TimeUnit.MINUTES.toMillis(30);
    private static final int DEFAULT_POOL_SIZE = 10;
    private static boolean unitTest;
    private volatile long connectionTimeout;
    private volatile long validationTimeout;
    private volatile long idleTimeout;
    private volatile long leakDetectionThreshold;
    private volatile long maxLifetime;
    private volatile int maxPoolSize;
    private volatile int minIdle;
    private long initializationFailTimeout;
    private String catalog;
    private String connectionInitSql;
    private String connectionTestQuery;
    private String dataSourceClassName;
    private String dataSourceJndiName;
    private String driverClassName;
    private String jdbcUrl;
    private String password;
    private String poolName;
    private String transactionIsolationName;
    private String username;
    private boolean isAutoCommit;
    private boolean isReadOnly;
    private boolean isIsolateInternalQueries;
    private boolean isRegisterMbeans;
    private boolean isAllowPoolSuspension;
    private DataSource dataSource;
    private Properties dataSourceProperties;
    private ThreadFactory threadFactory;
    private ScheduledExecutorService scheduledExecutor;
    private MetricsTrackerFactory metricsTrackerFactory;
    private Object metricRegistry;
    private Object healthCheckRegistry;
    private Properties healthCheckProperties;

    public HikariConfig() {
        this.dataSourceProperties = new Properties();
        this.healthCheckProperties = new Properties();
        this.minIdle = -1;
        this.maxPoolSize = -1;
        this.maxLifetime = MAX_LIFETIME;
        this.connectionTimeout = CONNECTION_TIMEOUT;
        this.validationTimeout = VALIDATION_TIMEOUT;
        this.idleTimeout = IDLE_TIMEOUT;
        this.initializationFailTimeout = 1;
        this.isAutoCommit = true;
        String systemProp = System.getProperty("hikaricp.configurationFile");
        if (systemProp != null) {
            loadProperties(systemProp);
        }
    }

    public HikariConfig(Properties properties) {
        this();
        PropertyElf.setTargetFromProperties(this, properties);
    }

    public HikariConfig(String propertyFileName) {
        this();
        loadProperties(propertyFileName);
    }

    public String getCatalog() {
        return this.catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getConnectionTestQuery() {
        return this.connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    public String getConnectionInitSql() {
        return this.connectionInitSql;
    }

    public void setConnectionInitSql(String connectionInitSql) {
        this.connectionInitSql = connectionInitSql;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public long getConnectionTimeout() {
        return this.connectionTimeout;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setConnectionTimeout(long connectionTimeoutMs) {
        if (connectionTimeoutMs == 0) {
            this.connectionTimeout = 2147483647L;
        } else if (connectionTimeoutMs < 250) {
            throw new IllegalArgumentException("connectionTimeout cannot be less than 250ms");
        } else {
            this.connectionTimeout = connectionTimeoutMs;
        }
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public long getValidationTimeout() {
        return this.validationTimeout;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setValidationTimeout(long validationTimeoutMs) {
        if (validationTimeoutMs < 250) {
            throw new IllegalArgumentException("validationTimeout cannot be less than 250ms");
        }
        this.validationTimeout = validationTimeoutMs;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataSourceClassName() {
        return this.dataSourceClassName;
    }

    public void setDataSourceClassName(String className) {
        this.dataSourceClassName = className;
    }

    public void addDataSourceProperty(String propertyName, Object value) {
        this.dataSourceProperties.put(propertyName, value);
    }

    public String getDataSourceJNDI() {
        return this.dataSourceJndiName;
    }

    public void setDataSourceJNDI(String jndiDataSource) {
        this.dataSourceJndiName = jndiDataSource;
    }

    public Properties getDataSourceProperties() {
        return this.dataSourceProperties;
    }

    public void setDataSourceProperties(Properties dsProperties) {
        this.dataSourceProperties.putAll(dsProperties);
    }

    public String getDriverClassName() {
        return this.driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        Class<?> driverClass = null;
        try {
            driverClass = getClass().getClassLoader().loadClass(driverClassName);
            LOGGER.debug("Driver class found in the HikariConfig class classloader {}", getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            ClassLoader threadContextClassLoader = Thread.currentThread().getContextClassLoader();
            if (threadContextClassLoader == null || threadContextClassLoader == getClass().getClassLoader()) {
                LOGGER.error("Failed to load class of driverClassName {} in HikariConfig class classloader {}", driverClassName, getClass().getClassLoader());
            } else {
                try {
                    driverClass = threadContextClassLoader.loadClass(driverClassName);
                    LOGGER.debug("Driver class found in Thread context class loader {}", threadContextClassLoader);
                } catch (ClassNotFoundException e2) {
                    LOGGER.error("Failed to load class of driverClassName {} in either of HikariConfig class classloader {} or Thread context classloader {}", driverClassName, getClass().getClassLoader(), threadContextClassLoader);
                }
            }
        }
        if (driverClass == null) {
            throw new RuntimeException("Failed to load class of driverClassName [" + driverClassName + "] in either of HikariConfig class loader or Thread context classloader");
        }
        try {
            driverClass.newInstance();
            this.driverClassName = driverClassName;
        } catch (Exception e3) {
            throw new RuntimeException("Failed to instantiate class " + driverClassName, e3);
        }
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public long getIdleTimeout() {
        return this.idleTimeout;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setIdleTimeout(long idleTimeoutMs) {
        if (idleTimeoutMs < 0) {
            throw new IllegalArgumentException("idleTimeout cannot be negative");
        }
        this.idleTimeout = idleTimeoutMs;
    }

    public String getJdbcUrl() {
        return this.jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public boolean isAutoCommit() {
        return this.isAutoCommit;
    }

    public void setAutoCommit(boolean isAutoCommit) {
        this.isAutoCommit = isAutoCommit;
    }

    public boolean isAllowPoolSuspension() {
        return this.isAllowPoolSuspension;
    }

    public void setAllowPoolSuspension(boolean isAllowPoolSuspension) {
        this.isAllowPoolSuspension = isAllowPoolSuspension;
    }

    public long getInitializationFailTimeout() {
        return this.initializationFailTimeout;
    }

    public void setInitializationFailTimeout(long initializationFailTimeout) {
        this.initializationFailTimeout = initializationFailTimeout;
    }

    @Deprecated
    public boolean isInitializationFailFast() {
        return this.initializationFailTimeout > 0;
    }

    @Deprecated
    public void setInitializationFailFast(boolean failFast) {
        LOGGER.warn("The initializationFailFast propery is deprecated, see initializationFailTimeout");
        this.initializationFailTimeout = (long) (failFast ? 1 : -1);
    }

    public boolean isIsolateInternalQueries() {
        return this.isIsolateInternalQueries;
    }

    public void setIsolateInternalQueries(boolean isolate) {
        this.isIsolateInternalQueries = isolate;
    }

    @Deprecated
    public boolean isJdbc4ConnectionTest() {
        return false;
    }

    @Deprecated
    public void setJdbc4ConnectionTest(boolean useIsValid) {
        LOGGER.warn("The jdbcConnectionTest property is now deprecated, see the documentation for connectionTestQuery");
    }

    public MetricsTrackerFactory getMetricsTrackerFactory() {
        return this.metricsTrackerFactory;
    }

    public void setMetricsTrackerFactory(MetricsTrackerFactory metricsTrackerFactory) {
        if (this.metricRegistry != null) {
            throw new IllegalStateException("cannot use setMetricsTrackerFactory() and setMetricRegistry() together");
        }
        this.metricsTrackerFactory = metricsTrackerFactory;
    }

    public Object getMetricRegistry() {
        return this.metricRegistry;
    }

    public void setMetricRegistry(Object metricRegistry) {
        if (this.metricsTrackerFactory != null) {
            throw new IllegalStateException("cannot use setMetricRegistry() and setMetricsTrackerFactory() together");
        }
        if (metricRegistry != null) {
            if (metricRegistry instanceof String) {
                try {
                    metricRegistry = new InitialContext().lookup((String) metricRegistry);
                } catch (NamingException e) {
                    throw new IllegalArgumentException((Throwable) e);
                }
            }
            if (!(metricRegistry instanceof MetricRegistry)) {
                throw new IllegalArgumentException("Class must be an instance of com.codahale.metrics.MetricRegistry");
            }
        }
        this.metricRegistry = metricRegistry;
    }

    public Object getHealthCheckRegistry() {
        return this.healthCheckRegistry;
    }

    public void setHealthCheckRegistry(Object healthCheckRegistry) {
        if (healthCheckRegistry != null) {
            if (healthCheckRegistry instanceof String) {
                try {
                    healthCheckRegistry = new InitialContext().lookup((String) healthCheckRegistry);
                } catch (NamingException e) {
                    throw new IllegalArgumentException((Throwable) e);
                }
            }
            if (!(healthCheckRegistry instanceof HealthCheckRegistry)) {
                throw new IllegalArgumentException("Class must be an instance of com.codahale.metrics.health.HealthCheckRegistry");
            }
        }
        this.healthCheckRegistry = healthCheckRegistry;
    }

    public Properties getHealthCheckProperties() {
        return this.healthCheckProperties;
    }

    public void setHealthCheckProperties(Properties healthCheckProperties) {
        this.healthCheckProperties.putAll(healthCheckProperties);
    }

    public void addHealthCheckProperty(String key, String value) {
        this.healthCheckProperties.setProperty(key, value);
    }

    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.isReadOnly = readOnly;
    }

    public boolean isRegisterMbeans() {
        return this.isRegisterMbeans;
    }

    public void setRegisterMbeans(boolean register) {
        this.isRegisterMbeans = register;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public long getLeakDetectionThreshold() {
        return this.leakDetectionThreshold;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setLeakDetectionThreshold(long leakDetectionThresholdMs) {
        this.leakDetectionThreshold = leakDetectionThresholdMs;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public long getMaxLifetime() {
        return this.maxLifetime;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setMaxLifetime(long maxLifetimeMs) {
        this.maxLifetime = maxLifetimeMs;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public int getMaximumPoolSize() {
        return this.maxPoolSize;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setMaximumPoolSize(int maxPoolSize) {
        if (maxPoolSize < 1) {
            throw new IllegalArgumentException("maxPoolSize cannot be less than 1");
        }
        this.maxPoolSize = maxPoolSize;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public int getMinimumIdle() {
        return this.minIdle;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setMinimumIdle(int minIdle) {
        if (minIdle < 0) {
            throw new IllegalArgumentException("minimumIdle cannot be negative");
        }
        this.minIdle = minIdle;
    }

    public String getPassword() {
        return this.password;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setPassword(String password) {
        this.password = password;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public String getPoolName() {
        return this.poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    @Deprecated
    public ScheduledThreadPoolExecutor getScheduledExecutorService() {
        return (ScheduledThreadPoolExecutor) this.scheduledExecutor;
    }

    @Deprecated
    public void setScheduledExecutorService(ScheduledThreadPoolExecutor executor) {
        this.scheduledExecutor = executor;
    }

    public ScheduledExecutorService getScheduledExecutor() {
        return this.scheduledExecutor;
    }

    public void setScheduledExecutor(ScheduledExecutorService executor) {
        this.scheduledExecutor = executor;
    }

    public String getTransactionIsolation() {
        return this.transactionIsolationName;
    }

    public void setTransactionIsolation(String isolationLevel) {
        this.transactionIsolationName = isolationLevel;
    }

    public String getUsername() {
        return this.username;
    }

    @Override // com.zaxxer.hikari.HikariConfigMXBean
    public void setUsername(String username) {
        this.username = username;
    }

    public ThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    public void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void validate() {
        if (this.poolName == null) {
            this.poolName = "HikariPool-" + generatePoolNumber();
        } else if (this.isRegisterMbeans && this.poolName.contains(EmitterKt.COMMENT_PREFIX)) {
            throw new IllegalArgumentException("poolName cannot contain ':' when used with JMX");
        }
        this.catalog = UtilityElf.getNullIfEmpty(this.catalog);
        this.connectionInitSql = UtilityElf.getNullIfEmpty(this.connectionInitSql);
        this.connectionTestQuery = UtilityElf.getNullIfEmpty(this.connectionTestQuery);
        this.transactionIsolationName = UtilityElf.getNullIfEmpty(this.transactionIsolationName);
        this.dataSourceClassName = UtilityElf.getNullIfEmpty(this.dataSourceClassName);
        this.dataSourceJndiName = UtilityElf.getNullIfEmpty(this.dataSourceJndiName);
        this.driverClassName = UtilityElf.getNullIfEmpty(this.driverClassName);
        this.jdbcUrl = UtilityElf.getNullIfEmpty(this.jdbcUrl);
        if (this.dataSource != null) {
            if (this.dataSourceClassName != null) {
                LOGGER.warn("{} - using dataSource and ignoring dataSourceClassName.", this.poolName);
            }
        } else if (this.dataSourceClassName != null) {
            if (this.driverClassName != null) {
                LOGGER.error("{} - cannot use driverClassName and dataSourceClassName together.", this.poolName);
                throw new IllegalStateException("cannot use driverClassName and dataSourceClassName together.");
            } else if (this.jdbcUrl != null) {
                LOGGER.warn("{} - using dataSourceClassName and ignoring jdbcUrl.", this.poolName);
            }
        } else if (this.jdbcUrl == null) {
            if (this.driverClassName != null) {
                LOGGER.error("{} - jdbcUrl is required with driverClassName.", this.poolName);
                throw new IllegalArgumentException("jdbcUrl is required with driverClassName.");
            } else {
                LOGGER.error("{} - dataSource or dataSourceClassName or jdbcUrl is required.", this.poolName);
                throw new IllegalArgumentException("dataSource or dataSourceClassName or jdbcUrl is required.");
            }
        }
        validateNumerics();
        if (LOGGER.isDebugEnabled() || unitTest) {
            logConfiguration();
        }
    }

    private void validateNumerics() {
        if (this.maxLifetime != 0 && this.maxLifetime < TimeUnit.SECONDS.toMillis(30)) {
            LOGGER.warn("{} - maxLifetime is less than 30000ms, setting to default {}ms.", this.poolName, Long.valueOf(MAX_LIFETIME));
            this.maxLifetime = MAX_LIFETIME;
        }
        if (this.idleTimeout + TimeUnit.SECONDS.toMillis(1) > this.maxLifetime && this.maxLifetime > 0) {
            LOGGER.warn("{} - idleTimeout is close to or more than maxLifetime, disabling it.", this.poolName);
            this.idleTimeout = 0;
        }
        if (this.idleTimeout != 0 && this.idleTimeout < TimeUnit.SECONDS.toMillis(10)) {
            LOGGER.warn("{} - idleTimeout is less than 10000ms, setting to default {}ms.", this.poolName, Long.valueOf(IDLE_TIMEOUT));
            this.idleTimeout = IDLE_TIMEOUT;
        }
        if (this.leakDetectionThreshold > 0 && !unitTest && (this.leakDetectionThreshold < TimeUnit.SECONDS.toMillis(2) || (this.leakDetectionThreshold > this.maxLifetime && this.maxLifetime > 0))) {
            LOGGER.warn("{} - leakDetectionThreshold is less than 2000ms or more than maxLifetime, disabling it.", this.poolName);
            this.leakDetectionThreshold = 0;
        }
        if (this.connectionTimeout < 250) {
            LOGGER.warn("{} - connectionTimeout is less than 250ms, setting to {}ms.", this.poolName, Long.valueOf(CONNECTION_TIMEOUT));
            this.connectionTimeout = CONNECTION_TIMEOUT;
        }
        if (this.validationTimeout < 250) {
            LOGGER.warn("{} - validationTimeout is less than 250ms, setting to {}ms.", this.poolName, Long.valueOf(VALIDATION_TIMEOUT));
            this.validationTimeout = VALIDATION_TIMEOUT;
        }
        if (this.maxPoolSize < 1) {
            this.maxPoolSize = this.minIdle <= 0 ? 10 : this.minIdle;
        }
        if (this.minIdle < 0 || this.minIdle > this.maxPoolSize) {
            this.minIdle = this.maxPoolSize;
        }
    }

    private void logConfiguration() {
        LOGGER.debug("{} - configuration:", this.poolName);
        for (String prop : new TreeSet<>(PropertyElf.getPropertyNames(HikariConfig.class))) {
            try {
                Object value = PropertyElf.getProperty(prop, this);
                if ("dataSourceProperties".equals(prop)) {
                    Properties dsProps = PropertyElf.copyProperties(this.dataSourceProperties);
                    dsProps.setProperty("password", "<masked>");
                    value = dsProps;
                }
                if ("initializationFailTimeout".equals(prop) && this.initializationFailTimeout == LongCompanionObject.MAX_VALUE) {
                    value = "infinite";
                }
                if ("initializationFailTimeout".equals(prop) && this.initializationFailTimeout <= 0) {
                    value = "none";
                } else if ("transactionIsolation".equals(prop) && this.transactionIsolationName == null) {
                    value = "default";
                } else if (prop.matches("scheduledExecutorService|threadFactory") && value == null) {
                    value = "internal";
                } else if (prop.contains("password")) {
                    value = "<masked>";
                } else if (value instanceof String) {
                    value = "\"" + value + "\"";
                } else if (value == null) {
                    value = "none";
                }
                LOGGER.debug((prop + "................................................").substring(0, 32) + value);
            } catch (Exception e) {
            }
        }
    }

    protected void loadProperties(String propertyFileName) {
        File propFile = new File(propertyFileName);
        try {
            InputStream is = propFile.isFile() ? new FileInputStream(propFile) : getClass().getResourceAsStream(propertyFileName);
            if (is != null) {
                Properties props = new Properties();
                props.load(is);
                PropertyElf.setTargetFromProperties(this, props);
                if (is != null) {
                    if (0 != 0) {
                        is.close();
                    } else {
                        is.close();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Cannot find property file: " + propertyFileName);
        } catch (IOException io) {
            throw new RuntimeException("Failed to read property file", io);
        }
    }

    private int generatePoolNumber() {
        int next;
        synchronized (System.getProperties()) {
            next = Integer.getInteger("com.zaxxer.hikari.pool_number", 0).intValue() + 1;
            System.setProperty("com.zaxxer.hikari.pool_number", String.valueOf(next));
        }
        return next;
    }

    public void copyState(HikariConfig other) {
        Field[] declaredFields = HikariConfig.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (!Modifier.isFinal(field.getModifiers())) {
                field.setAccessible(true);
                try {
                    field.set(other, field.get(this));
                } catch (Exception e) {
                    throw new RuntimeException("Failed to copy HikariConfig state: " + e.getMessage(), e);
                }
            }
        }
    }
}
