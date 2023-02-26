package org.quartz.impl;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import org.quartz.Scheduler;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.core.QuartzScheduler;
import org.quartz.core.QuartzSchedulerResources;
import org.quartz.spi.ThreadPool;
import org.quartz.utils.C3p0PoolingConnectionProvider;
import org.quartz.utils.PoolingConnectionProvider;
import org.quartz.utils.PropertiesParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/StdSchedulerFactory.class */
public class StdSchedulerFactory implements SchedulerFactory {
    public static final String PROPERTIES_FILE = "org.quartz.properties";
    public static final String PROP_SCHED_INSTANCE_NAME = "org.quartz.scheduler.instanceName";
    public static final String PROP_SCHED_INSTANCE_ID = "org.quartz.scheduler.instanceId";
    public static final String PROP_SCHED_INSTANCE_ID_GENERATOR_PREFIX = "org.quartz.scheduler.instanceIdGenerator";
    public static final String PROP_SCHED_INSTANCE_ID_GENERATOR_CLASS = "org.quartz.scheduler.instanceIdGenerator.class";
    public static final String PROP_SCHED_THREAD_NAME = "org.quartz.scheduler.threadName";
    public static final String PROP_SCHED_BATCH_TIME_WINDOW = "org.quartz.scheduler.batchTriggerAcquisitionFireAheadTimeWindow";
    public static final String PROP_SCHED_MAX_BATCH_SIZE = "org.quartz.scheduler.batchTriggerAcquisitionMaxCount";
    public static final String PROP_SCHED_JMX_EXPORT = "org.quartz.scheduler.jmx.export";
    public static final String PROP_SCHED_JMX_OBJECT_NAME = "org.quartz.scheduler.jmx.objectName";
    public static final String PROP_SCHED_JMX_PROXY = "org.quartz.scheduler.jmx.proxy";
    public static final String PROP_SCHED_JMX_PROXY_CLASS = "org.quartz.scheduler.jmx.proxy.class";
    public static final String PROP_SCHED_RMI_EXPORT = "org.quartz.scheduler.rmi.export";
    public static final String PROP_SCHED_RMI_PROXY = "org.quartz.scheduler.rmi.proxy";
    public static final String PROP_SCHED_RMI_HOST = "org.quartz.scheduler.rmi.registryHost";
    public static final String PROP_SCHED_RMI_PORT = "org.quartz.scheduler.rmi.registryPort";
    public static final String PROP_SCHED_RMI_SERVER_PORT = "org.quartz.scheduler.rmi.serverPort";
    public static final String PROP_SCHED_RMI_CREATE_REGISTRY = "org.quartz.scheduler.rmi.createRegistry";
    public static final String PROP_SCHED_RMI_BIND_NAME = "org.quartz.scheduler.rmi.bindName";
    public static final String PROP_SCHED_WRAP_JOB_IN_USER_TX = "org.quartz.scheduler.wrapJobExecutionInUserTransaction";
    public static final String PROP_SCHED_USER_TX_URL = "org.quartz.scheduler.userTransactionURL";
    public static final String PROP_SCHED_IDLE_WAIT_TIME = "org.quartz.scheduler.idleWaitTime";
    public static final String PROP_SCHED_DB_FAILURE_RETRY_INTERVAL = "org.quartz.scheduler.dbFailureRetryInterval";
    public static final String PROP_SCHED_MAKE_SCHEDULER_THREAD_DAEMON = "org.quartz.scheduler.makeSchedulerThreadDaemon";

    /* renamed from: PROP_SCHED_SCHEDULER_THREADS_INHERIT_CONTEXT_CLASS_LOADER_OF_INITIALIZING_THREAD */
    public static final String f3334xbc3ceae7 = "org.quartz.scheduler.threadsInheritContextClassLoaderOfInitializer";
    public static final String PROP_SCHED_CLASS_LOAD_HELPER_CLASS = "org.quartz.scheduler.classLoadHelper.class";
    public static final String PROP_SCHED_JOB_FACTORY_CLASS = "org.quartz.scheduler.jobFactory.class";
    public static final String PROP_SCHED_JOB_FACTORY_PREFIX = "org.quartz.scheduler.jobFactory";
    public static final String PROP_SCHED_INTERRUPT_JOBS_ON_SHUTDOWN = "org.quartz.scheduler.interruptJobsOnShutdown";
    public static final String PROP_SCHED_INTERRUPT_JOBS_ON_SHUTDOWN_WITH_WAIT = "org.quartz.scheduler.interruptJobsOnShutdownWithWait";
    public static final String PROP_SCHED_CONTEXT_PREFIX = "org.quartz.context.key";
    public static final String PROP_THREAD_POOL_PREFIX = "org.quartz.threadPool";
    public static final String PROP_THREAD_POOL_CLASS = "org.quartz.threadPool.class";
    public static final String PROP_JOB_STORE_PREFIX = "org.quartz.jobStore";
    public static final String PROP_JOB_STORE_LOCK_HANDLER_PREFIX = "org.quartz.jobStore.lockHandler";
    public static final String PROP_JOB_STORE_LOCK_HANDLER_CLASS = "org.quartz.jobStore.lockHandler.class";
    public static final String PROP_TABLE_PREFIX = "tablePrefix";
    public static final String PROP_SCHED_NAME = "schedName";
    public static final String PROP_JOB_STORE_CLASS = "org.quartz.jobStore.class";
    public static final String PROP_JOB_STORE_USE_PROP = "org.quartz.jobStore.useProperties";
    public static final String PROP_DATASOURCE_PREFIX = "org.quartz.dataSource";
    public static final String PROP_CONNECTION_PROVIDER_CLASS = "connectionProvider.class";
    @Deprecated
    public static final String PROP_DATASOURCE_DRIVER = "driver";
    @Deprecated
    public static final String PROP_DATASOURCE_URL = "URL";
    @Deprecated
    public static final String PROP_DATASOURCE_USER = "user";
    @Deprecated
    public static final String PROP_DATASOURCE_PASSWORD = "password";
    @Deprecated
    public static final String PROP_DATASOURCE_MAX_CONNECTIONS = "maxConnections";
    @Deprecated
    public static final String PROP_DATASOURCE_VALIDATION_QUERY = "validationQuery";
    public static final String PROP_DATASOURCE_JNDI_URL = "jndiURL";
    public static final String PROP_DATASOURCE_JNDI_ALWAYS_LOOKUP = "jndiAlwaysLookup";
    public static final String PROP_DATASOURCE_JNDI_INITIAL = "java.naming.factory.initial";
    public static final String PROP_DATASOURCE_JNDI_PROVDER = "java.naming.provider.url";
    public static final String PROP_DATASOURCE_JNDI_PRINCIPAL = "java.naming.security.principal";
    public static final String PROP_DATASOURCE_JNDI_CREDENTIALS = "java.naming.security.credentials";
    public static final String PROP_PLUGIN_PREFIX = "org.quartz.plugin";
    public static final String PROP_PLUGIN_CLASS = "class";
    public static final String PROP_JOB_LISTENER_PREFIX = "org.quartz.jobListener";
    public static final String PROP_TRIGGER_LISTENER_PREFIX = "org.quartz.triggerListener";
    public static final String PROP_LISTENER_CLASS = "class";
    public static final String DEFAULT_INSTANCE_ID = "NON_CLUSTERED";
    public static final String AUTO_GENERATE_INSTANCE_ID = "AUTO";
    public static final String PROP_THREAD_EXECUTOR = "org.quartz.threadExecutor";
    public static final String PROP_THREAD_EXECUTOR_CLASS = "org.quartz.threadExecutor.class";
    public static final String SYSTEM_PROPERTY_AS_INSTANCE_ID = "SYS_PROP";
    public static final String MANAGEMENT_REST_SERVICE_ENABLED = "org.quartz.managementRESTService.enabled";
    public static final String MANAGEMENT_REST_SERVICE_HOST_PORT = "org.quartz.managementRESTService.bind";
    private PropertiesParser cfg;
    private SchedulerException initException = null;
    private String propSrc = null;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public StdSchedulerFactory() {
    }

    public StdSchedulerFactory(Properties props) throws SchedulerException {
        initialize(props);
    }

    public StdSchedulerFactory(String fileName) throws SchedulerException {
        initialize(fileName);
    }

    public Logger getLog() {
        return this.log;
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initialize() throws org.quartz.SchedulerException {
        /*
        // Method dump skipped, instructions count: 516
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.StdSchedulerFactory.initialize():void");
    }

    static Properties overrideWithSysProps(Properties props, Logger log) {
        Properties sysProps = null;
        try {
            sysProps = System.getProperties();
        } catch (AccessControlException e) {
            log.warn("Skipping overriding quartz properties with System properties during initialization because of an AccessControlException.  This is likely due to not having read/write access for java.util.PropertyPermission as required by java.lang.System.getProperties().  To resolve this warning, either add this permission to your policy file or use a non-default version of initialize().", (Throwable) e);
        }
        if (sysProps != null) {
            Enumeration<?> en = sysProps.propertyNames();
            while (en.hasMoreElements()) {
                Object name = en.nextElement();
                Object value = sysProps.get(name);
                if ((name instanceof String) && (value instanceof String)) {
                    props.setProperty((String) name, (String) value);
                }
            }
        }
        return props;
    }

    public void initialize(String filename) throws SchedulerException {
        InputStream is;
        if (this.cfg == null) {
            if (this.initException != null) {
                throw this.initException;
            }
            try {
                Properties props = new Properties();
                is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
                try {
                    if (is != null) {
                        is = new BufferedInputStream(is);
                        this.propSrc = "the specified file : '" + filename + "' from the class resource path.";
                    } else {
                        is = new BufferedInputStream(new FileInputStream(filename));
                        this.propSrc = "the specified file : '" + filename + "'";
                    }
                    props.load(is);
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                        }
                    }
                    initialize(props);
                } catch (IOException ioe) {
                    this.initException = new SchedulerException("Properties file: '" + filename + "' could not be read.", ioe);
                    throw this.initException;
                }
            } catch (Throwable th) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        }
    }

    public void initialize(InputStream propertiesStream) throws SchedulerException {
        if (this.cfg == null) {
            if (this.initException != null) {
                throw this.initException;
            }
            Properties props = new Properties();
            if (propertiesStream != null) {
                try {
                    props.load(propertiesStream);
                    this.propSrc = "an externally opened InputStream.";
                    initialize(props);
                } catch (IOException e) {
                    this.initException = new SchedulerException("Error loading property data from InputStream", e);
                    throw this.initException;
                }
            } else {
                this.initException = new SchedulerException("Error loading property data from InputStream - InputStream is null.");
                throw this.initException;
            }
        }
    }

    public void initialize(Properties props) throws SchedulerException {
        if (this.propSrc == null) {
            this.propSrc = "an externally provided properties instance.";
        }
        this.cfg = new PropertiesParser(props);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:198:0x0960
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private org.quartz.Scheduler instantiate() throws org.quartz.SchedulerException {
        /*
        // Method dump skipped, instructions count: 4538
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.StdSchedulerFactory.instantiate():org.quartz.Scheduler");
    }

    private void populateProviderWithExtraProps(PoolingConnectionProvider cp, Properties props) throws Exception {
        Properties copyProps = new Properties();
        copyProps.putAll(props);
        copyProps.remove("driver");
        copyProps.remove("URL");
        copyProps.remove("user");
        copyProps.remove("password");
        copyProps.remove("maxConnections");
        copyProps.remove("validationQuery");
        copyProps.remove(PoolingConnectionProvider.POOLING_PROVIDER);
        if (cp instanceof C3p0PoolingConnectionProvider) {
            copyProps.remove(C3p0PoolingConnectionProvider.DB_MAX_CACHED_STATEMENTS_PER_CONNECTION);
            copyProps.remove(C3p0PoolingConnectionProvider.DB_VALIDATE_ON_CHECKOUT);
            copyProps.remove(C3p0PoolingConnectionProvider.DB_IDLE_VALIDATION_SECONDS);
            copyProps.remove(C3p0PoolingConnectionProvider.DB_DISCARD_IDLE_CONNECTIONS_SECONDS);
        }
        setBeanProps(cp.getDataSource(), copyProps);
    }

    private void shutdownFromInstantiateException(ThreadPool tp, QuartzScheduler qs, boolean tpInited, boolean qsInited) {
        try {
            if (qsInited) {
                qs.shutdown(false);
            } else if (tpInited) {
                tp.shutdown(false);
            }
        } catch (Exception e) {
            getLog().error("Got another exception while shutting down after instantiation exception", (Throwable) e);
        }
    }

    protected Scheduler instantiate(QuartzSchedulerResources rsrcs, QuartzScheduler qs) {
        return new StdScheduler(qs);
    }

    private void setBeanProps(Object obj, Properties props) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IntrospectionException, SchedulerConfigException {
        String refName;
        props.remove("class");
        props.remove(PoolingConnectionProvider.POOLING_PROVIDER);
        PropertyDescriptor[] propDescs = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
        PropertiesParser pp = new PropertiesParser(props);
        Enumeration<Object> keys = props.keys();
        while (keys.hasMoreElements()) {
            String name = (String) keys.nextElement();
            Method setMeth = getSetMethod("set" + name.substring(0, 1).toUpperCase(Locale.US) + name.substring(1), propDescs);
            if (setMeth == null) {
                throw new NoSuchMethodException("No setter for property '" + name + "'");
            }
            try {
                Class<?>[] params = setMeth.getParameterTypes();
                if (params.length != 1) {
                    throw new NoSuchMethodException("No 1-argument setter for property '" + name + "'");
                }
                PropertiesParser refProps = pp;
                String refName2 = pp.getStringProperty(name);
                if (refName2 == null || !refName2.startsWith("$@")) {
                    refName = name;
                } else {
                    refName = refName2.substring(2);
                    refProps = this.cfg;
                }
                if (params[0].equals(Integer.TYPE)) {
                    setMeth.invoke(obj, Integer.valueOf(refProps.getIntProperty(refName)));
                } else if (params[0].equals(Long.TYPE)) {
                    setMeth.invoke(obj, Long.valueOf(refProps.getLongProperty(refName)));
                } else if (params[0].equals(Float.TYPE)) {
                    setMeth.invoke(obj, Float.valueOf(refProps.getFloatProperty(refName)));
                } else if (params[0].equals(Double.TYPE)) {
                    setMeth.invoke(obj, Double.valueOf(refProps.getDoubleProperty(refName)));
                } else if (params[0].equals(Boolean.TYPE)) {
                    setMeth.invoke(obj, Boolean.valueOf(refProps.getBooleanProperty(refName)));
                } else if (params[0].equals(String.class)) {
                    setMeth.invoke(obj, refProps.getStringProperty(refName));
                } else {
                    throw new NoSuchMethodException("No primitive-type setter for property '" + name + "'");
                }
            } catch (NumberFormatException nfe) {
                throw new SchedulerConfigException("Could not parse property '" + name + "' into correct data type: " + nfe.toString());
            }
        }
    }

    private Method getSetMethod(String name, PropertyDescriptor[] props) {
        for (PropertyDescriptor propertyDescriptor : props) {
            Method wMeth = propertyDescriptor.getWriteMethod();
            if (wMeth != null && wMeth.getName().equals(name)) {
                return wMeth;
            }
        }
        return null;
    }

    private Class<?> loadClass(String className) throws ClassNotFoundException, SchedulerConfigException {
        try {
            ClassLoader cl = findClassloader();
            if (cl != null) {
                return cl.loadClass(className);
            }
            throw new SchedulerConfigException("Unable to find a class loader on the current thread or class.");
        } catch (ClassNotFoundException e) {
            if (getClass().getClassLoader() != null) {
                return getClass().getClassLoader().loadClass(className);
            }
            throw e;
        }
    }

    private ClassLoader findClassloader() {
        if (Thread.currentThread().getContextClassLoader() == null && getClass().getClassLoader() != null) {
            Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        }
        return Thread.currentThread().getContextClassLoader();
    }

    private String getSchedulerName() {
        return this.cfg.getStringProperty(PROP_SCHED_INSTANCE_NAME, "QuartzScheduler");
    }

    @Override // org.quartz.SchedulerFactory
    public Scheduler getScheduler() throws SchedulerException {
        if (this.cfg == null) {
            initialize();
        }
        SchedulerRepository schedRep = SchedulerRepository.getInstance();
        Scheduler sched = schedRep.lookup(getSchedulerName());
        if (sched != null) {
            if (!sched.isShutdown()) {
                return sched;
            }
            schedRep.remove(getSchedulerName());
        }
        return instantiate();
    }

    public static Scheduler getDefaultScheduler() throws SchedulerException {
        return new StdSchedulerFactory().getScheduler();
    }

    @Override // org.quartz.SchedulerFactory
    public Scheduler getScheduler(String schedName) throws SchedulerException {
        return SchedulerRepository.getInstance().lookup(schedName);
    }

    @Override // org.quartz.SchedulerFactory
    public Collection<Scheduler> getAllSchedulers() throws SchedulerException {
        return SchedulerRepository.getInstance().lookupAll();
    }
}
