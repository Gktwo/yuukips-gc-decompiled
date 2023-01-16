package org.quartz.impl;

import java.util.Collection;
import java.util.Map;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.core.JobRunShellFactory;
import org.quartz.core.QuartzScheduler;
import org.quartz.core.QuartzSchedulerResources;
import org.quartz.simpl.CascadingClassLoadHelper;
import org.quartz.simpl.RAMJobStore;
import org.quartz.simpl.SimpleThreadPool;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.JobStore;
import org.quartz.spi.SchedulerPlugin;
import org.quartz.spi.ThreadExecutor;
import org.quartz.spi.ThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/DirectSchedulerFactory.class */
public class DirectSchedulerFactory implements SchedulerFactory {
    public static final String DEFAULT_INSTANCE_ID = "SIMPLE_NON_CLUSTERED";
    public static final String DEFAULT_SCHEDULER_NAME = "SimpleQuartzScheduler";
    private static final boolean DEFAULT_JMX_EXPORT = false;
    private static final int DEFAULT_BATCH_MAX_SIZE = 1;
    private static final long DEFAULT_BATCH_TIME_WINDOW = 0;
    private boolean initialized = false;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String DEFAULT_JMX_OBJECTNAME = null;
    private static final DefaultThreadExecutor DEFAULT_THREAD_EXECUTOR = new DefaultThreadExecutor();
    private static DirectSchedulerFactory instance = new DirectSchedulerFactory();

    protected Logger getLog() {
        return this.log;
    }

    protected DirectSchedulerFactory() {
    }

    public static DirectSchedulerFactory getInstance() {
        return instance;
    }

    public void createVolatileScheduler(int maxThreads) throws SchedulerException {
        createScheduler(new SimpleThreadPool(maxThreads, 5), new RAMJobStore());
    }

    public void createRemoteScheduler(String rmiHost, int rmiPort) throws SchedulerException {
        createRemoteScheduler(DEFAULT_SCHEDULER_NAME, DEFAULT_INSTANCE_ID, rmiHost, rmiPort);
    }

    public void createRemoteScheduler(String schedulerName, String schedulerInstanceId, String rmiHost, int rmiPort) throws SchedulerException {
        createRemoteScheduler(schedulerName, schedulerInstanceId, null, rmiHost, rmiPort);
    }

    public void createRemoteScheduler(String schedulerName, String schedulerInstanceId, String rmiBindName, String rmiHost, int rmiPort) throws SchedulerException {
        SchedulerRepository.getInstance().bind(new RemoteScheduler(rmiBindName != null ? rmiBindName : QuartzSchedulerResources.getUniqueIdentifier(schedulerName, schedulerInstanceId), rmiHost, rmiPort));
        this.initialized = true;
    }

    public void createScheduler(ThreadPool threadPool, JobStore jobStore) throws SchedulerException {
        createScheduler(DEFAULT_SCHEDULER_NAME, DEFAULT_INSTANCE_ID, threadPool, jobStore);
    }

    public void createScheduler(String schedulerName, String schedulerInstanceId, ThreadPool threadPool, JobStore jobStore) throws SchedulerException {
        createScheduler(schedulerName, schedulerInstanceId, threadPool, jobStore, null, 0, -1, -1);
    }

    public void createScheduler(String schedulerName, String schedulerInstanceId, ThreadPool threadPool, JobStore jobStore, String rmiRegistryHost, int rmiRegistryPort, long idleWaitTime, long dbFailureRetryInterval) throws SchedulerException {
        createScheduler(schedulerName, schedulerInstanceId, threadPool, jobStore, null, rmiRegistryHost, rmiRegistryPort, idleWaitTime, dbFailureRetryInterval, false, DEFAULT_JMX_OBJECTNAME);
    }

    public void createScheduler(String schedulerName, String schedulerInstanceId, ThreadPool threadPool, JobStore jobStore, Map<String, SchedulerPlugin> schedulerPluginMap, String rmiRegistryHost, int rmiRegistryPort, long idleWaitTime, long dbFailureRetryInterval, boolean jmxExport, String jmxObjectName) throws SchedulerException {
        createScheduler(schedulerName, schedulerInstanceId, threadPool, DEFAULT_THREAD_EXECUTOR, jobStore, schedulerPluginMap, rmiRegistryHost, rmiRegistryPort, idleWaitTime, dbFailureRetryInterval, jmxExport, jmxObjectName);
    }

    public void createScheduler(String schedulerName, String schedulerInstanceId, ThreadPool threadPool, ThreadExecutor threadExecutor, JobStore jobStore, Map<String, SchedulerPlugin> schedulerPluginMap, String rmiRegistryHost, int rmiRegistryPort, long idleWaitTime, long dbFailureRetryInterval, boolean jmxExport, String jmxObjectName) throws SchedulerException {
        createScheduler(schedulerName, schedulerInstanceId, threadPool, DEFAULT_THREAD_EXECUTOR, jobStore, schedulerPluginMap, rmiRegistryHost, rmiRegistryPort, idleWaitTime, dbFailureRetryInterval, jmxExport, jmxObjectName, 1, 0);
    }

    public void createScheduler(String schedulerName, String schedulerInstanceId, ThreadPool threadPool, ThreadExecutor threadExecutor, JobStore jobStore, Map<String, SchedulerPlugin> schedulerPluginMap, String rmiRegistryHost, int rmiRegistryPort, long idleWaitTime, long dbFailureRetryInterval, boolean jmxExport, String jmxObjectName, int maxBatchSize, long batchTimeWindow) throws SchedulerException {
        JobRunShellFactory jrsf = new StdJobRunShellFactory();
        threadPool.setInstanceName(schedulerName);
        threadPool.initialize();
        QuartzSchedulerResources qrs = new QuartzSchedulerResources();
        qrs.setName(schedulerName);
        qrs.setInstanceId(schedulerInstanceId);
        SchedulerDetailsSetter.setDetails(threadPool, schedulerName, schedulerInstanceId);
        qrs.setJobRunShellFactory(jrsf);
        qrs.setThreadPool(threadPool);
        qrs.setThreadExecutor(threadExecutor);
        qrs.setJobStore(jobStore);
        qrs.setMaxBatchSize(maxBatchSize);
        qrs.setBatchTimeWindow(batchTimeWindow);
        qrs.setRMIRegistryHost(rmiRegistryHost);
        qrs.setRMIRegistryPort(rmiRegistryPort);
        qrs.setJMXExport(jmxExport);
        if (jmxObjectName != null) {
            qrs.setJMXObjectName(jmxObjectName);
        }
        if (schedulerPluginMap != null) {
            for (SchedulerPlugin schedulerPlugin : schedulerPluginMap.values()) {
                qrs.addSchedulerPlugin(schedulerPlugin);
            }
        }
        QuartzScheduler qs = new QuartzScheduler(qrs, idleWaitTime, dbFailureRetryInterval);
        ClassLoadHelper cch = new CascadingClassLoadHelper();
        cch.initialize();
        SchedulerDetailsSetter.setDetails(jobStore, schedulerName, schedulerInstanceId);
        jobStore.initialize(cch, qs.getSchedulerSignaler());
        Scheduler scheduler = new StdScheduler(qs);
        jrsf.initialize(scheduler);
        qs.initialize();
        if (schedulerPluginMap != null) {
            for (Map.Entry<String, SchedulerPlugin> pluginEntry : schedulerPluginMap.entrySet()) {
                pluginEntry.getValue().initialize(pluginEntry.getKey(), scheduler, cch);
            }
        }
        getLog().info("Quartz scheduler '" + scheduler.getSchedulerName());
        getLog().info("Quartz scheduler version: " + qs.getVersion());
        SchedulerRepository schedRep = SchedulerRepository.getInstance();
        qs.addNoGCObject(schedRep);
        schedRep.bind(scheduler);
        this.initialized = true;
    }

    @Override // org.quartz.SchedulerFactory
    public Scheduler getScheduler() throws SchedulerException {
        if (this.initialized) {
            return getScheduler(DEFAULT_SCHEDULER_NAME);
        }
        throw new SchedulerException("you must call createRemoteScheduler or createScheduler methods before calling getScheduler()");
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
