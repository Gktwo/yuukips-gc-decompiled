package org.quartz.core;

import dev.morphia.mapping.Mapper;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.quartz.Calendar;
import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.ListenerManager;
import org.quartz.Matcher;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.TriggerListener;
import org.quartz.UnableToInterruptJobException;
import org.quartz.core.jmx.QuartzSchedulerMBean;
import org.quartz.impl.SchedulerRepository;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.simpl.PropertySettingJobFactory;
import org.quartz.spi.JobFactory;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.SchedulerPlugin;
import org.quartz.spi.SchedulerSignaler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/core/QuartzScheduler.class */
public class QuartzScheduler implements RemotableQuartzScheduler {
    private static String VERSION_MAJOR;
    private static String VERSION_MINOR;
    private static String VERSION_ITERATION;
    private QuartzSchedulerResources resources;
    private QuartzSchedulerThread schedThread;
    private ThreadGroup threadGroup;
    ExecutingJobsManager jobMgr;
    ErrorLogger errLogger;
    private SchedulerSignaler signaler;
    private SchedulerContext context = new SchedulerContext();
    private ListenerManager listenerManager = new ListenerManagerImpl();
    private HashMap<String, JobListener> internalJobListeners = new HashMap<>(10);
    private HashMap<String, TriggerListener> internalTriggerListeners = new HashMap<>(10);
    private ArrayList<SchedulerListener> internalSchedulerListeners = new ArrayList<>(10);
    private JobFactory jobFactory = new PropertySettingJobFactory();
    private Random random = new Random();
    private ArrayList<Object> holdToPreventGC = new ArrayList<>(5);
    private boolean signalOnSchedulingChange = true;
    private volatile boolean closed = false;
    private volatile boolean shuttingDown = false;
    private boolean boundRemotely = false;
    private QuartzSchedulerMBean jmxBean = null;
    private Date initialStart = null;
    private final Logger log = LoggerFactory.getLogger(getClass());

    static {
        InputStream is;
        try {
            VERSION_MAJOR = "UNKNOWN";
            VERSION_MINOR = "UNKNOWN";
            VERSION_ITERATION = "UNKNOWN";
            Properties props = new Properties();
            is = null;
            try {
                InputStream is2 = QuartzScheduler.class.getResourceAsStream("quartz-build.properties");
                if (is2 != null) {
                    props.load(is2);
                    String version = props.getProperty("version");
                    if (version != null) {
                        String[] versionComponents = version.split("\\.");
                        VERSION_MAJOR = versionComponents[0];
                        VERSION_MINOR = versionComponents[1];
                        if (versionComponents.length > 2) {
                            VERSION_ITERATION = versionComponents[2];
                        } else {
                            VERSION_ITERATION = "0";
                        }
                    } else {
                        LoggerFactory.getLogger(QuartzScheduler.class).error("Can't parse Quartz version from quartz-build.properties");
                    }
                }
                if (is2 != null) {
                    try {
                        is2.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                LoggerFactory.getLogger(QuartzScheduler.class).error("Error loading version info from quartz-build.properties.", (Throwable) e2);
                if (0 != 0) {
                    try {
                        is.close();
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    is.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    public QuartzScheduler(QuartzSchedulerResources resources, long idleWaitTime, @Deprecated long dbRetryInterval) throws SchedulerException {
        this.jobMgr = null;
        this.errLogger = null;
        this.resources = resources;
        if (resources.getJobStore() instanceof JobListener) {
            addInternalJobListener((JobListener) resources.getJobStore());
        }
        this.schedThread = new QuartzSchedulerThread(this, resources);
        resources.getThreadExecutor().execute(this.schedThread);
        if (idleWaitTime > 0) {
            this.schedThread.setIdleWaitTime(idleWaitTime);
        }
        this.jobMgr = new ExecutingJobsManager();
        addInternalJobListener(this.jobMgr);
        this.errLogger = new ErrorLogger();
        addInternalSchedulerListener(this.errLogger);
        this.signaler = new SchedulerSignalerImpl(this, this.schedThread);
        getLog().info("Quartz Scheduler v." + getVersion() + " created.");
    }

    public void initialize() throws SchedulerException {
        try {
            bind();
            if (this.resources.getJMXExport()) {
                try {
                    registerJMX();
                } catch (Exception e) {
                    throw new SchedulerException("Unable to register scheduler with MBeanServer.", e);
                }
            }
            getLog().info("Scheduler meta-data: " + new SchedulerMetaData(getSchedulerName(), getSchedulerInstanceId(), getClass(), this.boundRemotely, runningSince() != null, isInStandbyMode(), isShutdown(), runningSince(), numJobsExecuted(), getJobStoreClass(), supportsPersistence(), isClustered(), getThreadPoolClass(), getThreadPoolSize(), getVersion()).toString());
        } catch (Exception re) {
            throw new SchedulerException("Unable to bind scheduler to RMI Registry.", re);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public String getVersion() {
        return getVersionMajor() + Mapper.IGNORED_FIELDNAME + getVersionMinor() + Mapper.IGNORED_FIELDNAME + getVersionIteration();
    }

    public static String getVersionMajor() {
        return VERSION_MAJOR;
    }

    public static String getVersionMinor() {
        return VERSION_MINOR;
    }

    public static String getVersionIteration() {
        return VERSION_ITERATION;
    }

    public SchedulerSignaler getSchedulerSignaler() {
        return this.signaler;
    }

    public Logger getLog() {
        return this.log;
    }

    private void registerJMX() throws Exception {
        String jmxObjectName = this.resources.getJMXObjectName();
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        this.jmxBean = new QuartzSchedulerMBeanImpl(this);
        mbs.registerMBean(this.jmxBean, new ObjectName(jmxObjectName));
    }

    private void unregisterJMX() throws Exception {
        String jmxObjectName = this.resources.getJMXObjectName();
        ManagementFactory.getPlatformMBeanServer().unregisterMBean(new ObjectName(jmxObjectName));
        this.jmxBean.setSampledStatisticsEnabled(false);
        getLog().info("Scheduler unregistered from name '" + jmxObjectName + "' in the local MBeanServer.");
    }

    private void bind() throws RemoteException {
        RemotableQuartzScheduler exportable;
        Registry registry;
        String host = this.resources.getRMIRegistryHost();
        if (host != null && host.length() != 0) {
            if (this.resources.getRMIServerPort() > 0) {
                exportable = (RemotableQuartzScheduler) UnicastRemoteObject.exportObject(this, this.resources.getRMIServerPort());
            } else {
                exportable = UnicastRemoteObject.exportObject(this);
            }
            if (this.resources.getRMICreateRegistryStrategy().equals(QuartzSchedulerResources.CREATE_REGISTRY_AS_NEEDED)) {
                try {
                    registry = LocateRegistry.getRegistry(this.resources.getRMIRegistryPort());
                    registry.list();
                } catch (Exception e) {
                    registry = LocateRegistry.createRegistry(this.resources.getRMIRegistryPort());
                }
            } else if (this.resources.getRMICreateRegistryStrategy().equals(QuartzSchedulerResources.CREATE_REGISTRY_ALWAYS)) {
                try {
                    registry = LocateRegistry.createRegistry(this.resources.getRMIRegistryPort());
                } catch (Exception e2) {
                    registry = LocateRegistry.getRegistry(this.resources.getRMIRegistryPort());
                }
            } else {
                registry = LocateRegistry.getRegistry(this.resources.getRMIRegistryHost(), this.resources.getRMIRegistryPort());
            }
            String bindName = this.resources.getRMIBindName();
            registry.rebind(bindName, exportable);
            this.boundRemotely = true;
            getLog().info("Scheduler bound to RMI registry under name '" + bindName + "'");
        }
    }

    private void unBind() throws RemoteException {
        String host = this.resources.getRMIRegistryHost();
        if (host != null && host.length() != 0) {
            Registry registry = LocateRegistry.getRegistry(this.resources.getRMIRegistryHost(), this.resources.getRMIRegistryPort());
            String bindName = this.resources.getRMIBindName();
            try {
                registry.unbind(bindName);
                UnicastRemoteObject.unexportObject(this, true);
            } catch (NotBoundException e) {
            }
            getLog().info("Scheduler un-bound from name '" + bindName + "' in RMI registry");
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public String getSchedulerName() {
        return this.resources.getName();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public String getSchedulerInstanceId() {
        return this.resources.getInstanceId();
    }

    public ThreadGroup getSchedulerThreadGroup() {
        if (this.threadGroup == null) {
            this.threadGroup = new ThreadGroup("QuartzScheduler:" + getSchedulerName());
            if (this.resources.getMakeSchedulerThreadDaemon()) {
                this.threadGroup.setDaemon(true);
            }
        }
        return this.threadGroup;
    }

    public void addNoGCObject(Object obj) {
        this.holdToPreventGC.add(obj);
    }

    public boolean removeNoGCObject(Object obj) {
        return this.holdToPreventGC.remove(obj);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public SchedulerContext getSchedulerContext() throws SchedulerException {
        return this.context;
    }

    public boolean isSignalOnSchedulingChange() {
        return this.signalOnSchedulingChange;
    }

    public void setSignalOnSchedulingChange(boolean signalOnSchedulingChange) {
        this.signalOnSchedulingChange = signalOnSchedulingChange;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void start() throws SchedulerException {
        if (this.shuttingDown || this.closed) {
            throw new SchedulerException("The Scheduler cannot be restarted after shutdown() has been called.");
        }
        notifySchedulerListenersStarting();
        if (this.initialStart == null) {
            this.initialStart = new Date();
            this.resources.getJobStore().schedulerStarted();
            startPlugins();
        } else {
            this.resources.getJobStore().schedulerResumed();
        }
        this.schedThread.togglePause(false);
        getLog().info("Scheduler " + this.resources.getUniqueIdentifier() + " started.");
        notifySchedulerListenersStarted();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void startDelayed(final int seconds) throws SchedulerException {
        if (this.shuttingDown || this.closed) {
            throw new SchedulerException("The Scheduler cannot be restarted after shutdown() has been called.");
        }
        new Thread(new Runnable() { // from class: org.quartz.core.QuartzScheduler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(((long) seconds) * 1000);
                } catch (InterruptedException e) {
                }
                try {
                    QuartzScheduler.this.start();
                } catch (SchedulerException se) {
                    QuartzScheduler.this.getLog().error("Unable to start scheduler after startup delay.", (Throwable) se);
                }
            }
        }).start();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void standby() {
        this.resources.getJobStore().schedulerPaused();
        this.schedThread.togglePause(true);
        getLog().info("Scheduler " + this.resources.getUniqueIdentifier() + " paused.");
        notifySchedulerListenersInStandbyMode();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean isInStandbyMode() {
        return this.schedThread.isPaused();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date runningSince() {
        if (this.initialStart == null) {
            return null;
        }
        return new Date(this.initialStart.getTime());
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public int numJobsExecuted() {
        return this.jobMgr.getNumJobsFired();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Class<?> getJobStoreClass() {
        return this.resources.getJobStore().getClass();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean supportsPersistence() {
        return this.resources.getJobStore().supportsPersistence();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean isClustered() {
        return this.resources.getJobStore().isClustered();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Class<?> getThreadPoolClass() {
        return this.resources.getThreadPool().getClass();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public int getThreadPoolSize() {
        return this.resources.getThreadPool().getPoolSize();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void shutdown() {
        shutdown(false);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void shutdown(boolean waitForJobsToComplete) {
        if (!(this.shuttingDown || this.closed)) {
            this.shuttingDown = true;
            getLog().info("Scheduler " + this.resources.getUniqueIdentifier() + " shutting down.");
            standby();
            this.schedThread.halt(waitForJobsToComplete);
            notifySchedulerListenersShuttingdown();
            if ((this.resources.isInterruptJobsOnShutdown() && !waitForJobsToComplete) || (this.resources.isInterruptJobsOnShutdownWithWait() && waitForJobsToComplete)) {
                for (JobExecutionContext job : getCurrentlyExecutingJobs()) {
                    if (job.getJobInstance() instanceof InterruptableJob) {
                        try {
                            ((InterruptableJob) job.getJobInstance()).interrupt();
                        } catch (Throwable e) {
                            getLog().warn("Encountered error when interrupting job {} during shutdown: {}", job.getJobDetail().getKey(), e);
                        }
                    }
                }
            }
            this.resources.getThreadPool().shutdown(waitForJobsToComplete);
            this.closed = true;
            if (this.resources.getJMXExport()) {
                try {
                    unregisterJMX();
                } catch (Exception e2) {
                }
            }
            if (this.boundRemotely) {
                try {
                    unBind();
                } catch (RemoteException e3) {
                }
            }
            shutdownPlugins();
            this.resources.getJobStore().shutdown();
            notifySchedulerListenersShutdown();
            SchedulerRepository.getInstance().remove(this.resources.getName());
            this.holdToPreventGC.clear();
            getLog().info("Scheduler " + this.resources.getUniqueIdentifier() + " shutdown complete.");
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean isShutdown() {
        return this.closed;
    }

    public boolean isShuttingDown() {
        return this.shuttingDown;
    }

    public boolean isStarted() {
        return !this.shuttingDown && !this.closed && !isInStandbyMode() && this.initialStart != null;
    }

    public void validateState() throws SchedulerException {
        if (isShutdown()) {
            throw new SchedulerException("The Scheduler has been shutdown.");
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List<JobExecutionContext> getCurrentlyExecutingJobs() {
        return this.jobMgr.getExecutingJobs();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        validateState();
        if (jobDetail == null) {
            throw new SchedulerException("JobDetail cannot be null");
        } else if (trigger == null) {
            throw new SchedulerException("Trigger cannot be null");
        } else if (jobDetail.getKey() == null) {
            throw new SchedulerException("Job's key cannot be null");
        } else if (jobDetail.getJobClass() == null) {
            throw new SchedulerException("Job's class cannot be null");
        } else {
            OperableTrigger trig = (OperableTrigger) trigger;
            if (trigger.getJobKey() == null) {
                trig.setJobKey(jobDetail.getKey());
            } else if (!trigger.getJobKey().equals(jobDetail.getKey())) {
                throw new SchedulerException("Trigger does not reference given job!");
            }
            trig.validate();
            Calendar cal = null;
            if (trigger.getCalendarName() != null) {
                cal = this.resources.getJobStore().retrieveCalendar(trigger.getCalendarName());
            }
            Date ft = trig.computeFirstFireTime(cal);
            if (ft == null) {
                throw new SchedulerException("Based on configured schedule, the given trigger '" + trigger.getKey() + "' will never fire.");
            }
            this.resources.getJobStore().storeJobAndTrigger(jobDetail, trig);
            notifySchedulerListenersJobAdded(jobDetail);
            notifySchedulerThread(trigger.getNextFireTime().getTime());
            notifySchedulerListenersSchduled(trigger);
            return ft;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date scheduleJob(Trigger trigger) throws SchedulerException {
        validateState();
        if (trigger == null) {
            throw new SchedulerException("Trigger cannot be null");
        }
        OperableTrigger trig = (OperableTrigger) trigger;
        trig.validate();
        Calendar cal = null;
        if (trigger.getCalendarName() != null) {
            cal = this.resources.getJobStore().retrieveCalendar(trigger.getCalendarName());
            if (cal == null) {
                throw new SchedulerException("Calendar not found: " + trigger.getCalendarName());
            }
        }
        Date ft = trig.computeFirstFireTime(cal);
        if (ft == null) {
            throw new SchedulerException("Based on configured schedule, the given trigger '" + trigger.getKey() + "' will never fire.");
        }
        this.resources.getJobStore().storeTrigger(trig, false);
        notifySchedulerThread(trigger.getNextFireTime().getTime());
        notifySchedulerListenersSchduled(trigger);
        return ft;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void addJob(JobDetail jobDetail, boolean replace) throws SchedulerException {
        addJob(jobDetail, replace, false);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void addJob(JobDetail jobDetail, boolean replace, boolean storeNonDurableWhileAwaitingScheduling) throws SchedulerException {
        validateState();
        if (storeNonDurableWhileAwaitingScheduling || jobDetail.isDurable()) {
            this.resources.getJobStore().storeJob(jobDetail, replace);
            notifySchedulerThread(0);
            notifySchedulerListenersJobAdded(jobDetail);
            return;
        }
        throw new SchedulerException("Jobs added with no trigger must be durable.");
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean deleteJob(JobKey jobKey) throws SchedulerException {
        validateState();
        boolean result = false;
        for (Trigger trigger : getTriggersOfJob(jobKey)) {
            if (!unscheduleJob(trigger.getKey())) {
                throw new SchedulerException("Unable to unschedule trigger [" + trigger.getKey() + "] while deleting job [" + jobKey + "]");
            }
            result = true;
        }
        boolean result2 = this.resources.getJobStore().removeJob(jobKey) || result;
        if (result2) {
            notifySchedulerThread(0);
            notifySchedulerListenersJobDeleted(jobKey);
        }
        return result2;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean deleteJobs(List<JobKey> jobKeys) throws SchedulerException {
        validateState();
        boolean result = this.resources.getJobStore().removeJobs(jobKeys);
        notifySchedulerThread(0);
        for (JobKey key : jobKeys) {
            notifySchedulerListenersJobDeleted(key);
        }
        return result;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void scheduleJobs(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws SchedulerException {
        Set<? extends Trigger> triggers;
        validateState();
        for (Map.Entry<JobDetail, Set<? extends Trigger>> e : triggersAndJobs.entrySet()) {
            JobDetail job = e.getKey();
            if (!(job == null || (triggers = e.getValue()) == null)) {
                for (Trigger trigger : triggers) {
                    OperableTrigger opt = (OperableTrigger) trigger;
                    opt.setJobKey(job.getKey());
                    opt.validate();
                    Calendar cal = null;
                    if (trigger.getCalendarName() != null) {
                        cal = this.resources.getJobStore().retrieveCalendar(trigger.getCalendarName());
                        if (cal == null) {
                            throw new SchedulerException("Calendar '" + trigger.getCalendarName() + "' not found for trigger: " + trigger.getKey());
                        }
                    }
                    if (opt.computeFirstFireTime(cal) == null) {
                        throw new SchedulerException("Based on configured schedule, the given trigger will never fire.");
                    }
                }
                continue;
            }
        }
        this.resources.getJobStore().storeJobsAndTriggers(triggersAndJobs, replace);
        notifySchedulerThread(0);
        for (JobDetail job2 : triggersAndJobs.keySet()) {
            notifySchedulerListenersJobAdded(job2);
            for (Trigger trigger2 : triggersAndJobs.get(job2)) {
                notifySchedulerListenersSchduled(trigger2);
            }
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void scheduleJob(JobDetail jobDetail, Set<? extends Trigger> triggersForJob, boolean replace) throws SchedulerException {
        Map<JobDetail, Set<? extends Trigger>> triggersAndJobs = new HashMap<>();
        triggersAndJobs.put(jobDetail, triggersForJob);
        scheduleJobs(triggersAndJobs, replace);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean unscheduleJobs(List<TriggerKey> triggerKeys) throws SchedulerException {
        validateState();
        boolean result = this.resources.getJobStore().removeTriggers(triggerKeys);
        notifySchedulerThread(0);
        for (TriggerKey key : triggerKeys) {
            notifySchedulerListenersUnscheduled(key);
        }
        return result;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean unscheduleJob(TriggerKey triggerKey) throws SchedulerException {
        validateState();
        if (!this.resources.getJobStore().removeTrigger(triggerKey)) {
            return false;
        }
        notifySchedulerThread(0);
        notifySchedulerListenersUnscheduled(triggerKey);
        return true;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date rescheduleJob(TriggerKey triggerKey, Trigger newTrigger) throws SchedulerException {
        validateState();
        if (triggerKey == null) {
            throw new IllegalArgumentException("triggerKey cannot be null");
        } else if (newTrigger == null) {
            throw new IllegalArgumentException("newTrigger cannot be null");
        } else {
            OperableTrigger trig = (OperableTrigger) newTrigger;
            Trigger oldTrigger = getTrigger(triggerKey);
            if (oldTrigger == null) {
                return null;
            }
            trig.setJobKey(oldTrigger.getJobKey());
            trig.validate();
            Calendar cal = null;
            if (newTrigger.getCalendarName() != null) {
                cal = this.resources.getJobStore().retrieveCalendar(newTrigger.getCalendarName());
            }
            Date ft = trig.computeFirstFireTime(cal);
            if (ft == null) {
                throw new SchedulerException("Based on configured schedule, the given trigger will never fire.");
            } else if (!this.resources.getJobStore().replaceTrigger(triggerKey, trig)) {
                return null;
            } else {
                notifySchedulerThread(newTrigger.getNextFireTime().getTime());
                notifySchedulerListenersUnscheduled(triggerKey);
                notifySchedulerListenersSchduled(newTrigger);
                return ft;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String newTriggerId() {
        /*
            r9 = this;
            r0 = r9
            java.util.Random r0 = r0.random
            long r0 = r0.nextLong()
            r10 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0011
            r0 = r10
            long r0 = -r0
            r10 = r0
        L_0x0011:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "MT_"
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r10
            r2 = 30
            long r3 = java.lang.System.currentTimeMillis()
            r4 = 7
            long r3 = r3 % r4
            int r3 = (int) r3
            int r2 = r2 + r3
            java.lang.String r1 = java.lang.Long.toString(r1, r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.core.QuartzScheduler.newTriggerId():java.lang.String");
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void triggerJob(JobKey jobKey, JobDataMap data) throws SchedulerException {
        validateState();
        OperableTrigger trig = (OperableTrigger) TriggerBuilder.newTrigger().withIdentity(newTriggerId(), "DEFAULT").forJob(jobKey).build();
        trig.computeFirstFireTime(null);
        if (data != null) {
            trig.setJobDataMap(data);
        }
        boolean collision = true;
        while (collision) {
            try {
                this.resources.getJobStore().storeTrigger(trig, false);
                collision = false;
            } catch (ObjectAlreadyExistsException e) {
                trig.setKey(new TriggerKey(newTriggerId(), "DEFAULT"));
            }
        }
        notifySchedulerThread(trig.getNextFireTime().getTime());
        notifySchedulerListenersSchduled(trig);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void triggerJob(OperableTrigger trig) throws SchedulerException {
        validateState();
        trig.computeFirstFireTime(null);
        boolean collision = true;
        while (collision) {
            try {
                this.resources.getJobStore().storeTrigger(trig, false);
                collision = false;
            } catch (ObjectAlreadyExistsException e) {
                trig.setKey(new TriggerKey(newTriggerId(), "DEFAULT"));
            }
        }
        notifySchedulerThread(trig.getNextFireTime().getTime());
        notifySchedulerListenersSchduled(trig);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
        validateState();
        this.resources.getJobStore().pauseTrigger(triggerKey);
        notifySchedulerThread(0);
        notifySchedulerListenersPausedTrigger(triggerKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        validateState();
        if (matcher == null) {
            matcher = GroupMatcher.groupEquals("DEFAULT");
        }
        Collection<String> pausedGroups = this.resources.getJobStore().pauseTriggers(matcher);
        notifySchedulerThread(0);
        for (String pausedGroup : pausedGroups) {
            notifySchedulerListenersPausedTriggers(pausedGroup);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseJob(JobKey jobKey) throws SchedulerException {
        validateState();
        this.resources.getJobStore().pauseJob(jobKey);
        notifySchedulerThread(0);
        notifySchedulerListenersPausedJob(jobKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseJobs(GroupMatcher<JobKey> groupMatcher) throws SchedulerException {
        validateState();
        if (groupMatcher == null) {
            groupMatcher = GroupMatcher.groupEquals("DEFAULT");
        }
        Collection<String> pausedGroups = this.resources.getJobStore().pauseJobs(groupMatcher);
        notifySchedulerThread(0);
        for (String pausedGroup : pausedGroups) {
            notifySchedulerListenersPausedJobs(pausedGroup);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeTrigger(TriggerKey triggerKey) throws SchedulerException {
        validateState();
        this.resources.getJobStore().resumeTrigger(triggerKey);
        notifySchedulerThread(0);
        notifySchedulerListenersResumedTrigger(triggerKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        validateState();
        if (matcher == null) {
            matcher = GroupMatcher.groupEquals("DEFAULT");
        }
        Collection<String> pausedGroups = this.resources.getJobStore().resumeTriggers(matcher);
        notifySchedulerThread(0);
        for (String pausedGroup : pausedGroups) {
            notifySchedulerListenersResumedTriggers(pausedGroup);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Set<String> getPausedTriggerGroups() throws SchedulerException {
        return this.resources.getJobStore().getPausedTriggerGroups();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeJob(JobKey jobKey) throws SchedulerException {
        validateState();
        this.resources.getJobStore().resumeJob(jobKey);
        notifySchedulerThread(0);
        notifySchedulerListenersResumedJob(jobKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeJobs(GroupMatcher<JobKey> matcher) throws SchedulerException {
        validateState();
        if (matcher == null) {
            matcher = GroupMatcher.groupEquals("DEFAULT");
        }
        Collection<String> resumedGroups = this.resources.getJobStore().resumeJobs(matcher);
        notifySchedulerThread(0);
        for (String pausedGroup : resumedGroups) {
            notifySchedulerListenersResumedJobs(pausedGroup);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseAll() throws SchedulerException {
        validateState();
        this.resources.getJobStore().pauseAll();
        notifySchedulerThread(0);
        notifySchedulerListenersPausedTriggers(null);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeAll() throws SchedulerException {
        validateState();
        this.resources.getJobStore().resumeAll();
        notifySchedulerThread(0);
        notifySchedulerListenersResumedTrigger(null);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List<String> getJobGroupNames() throws SchedulerException {
        validateState();
        return this.resources.getJobStore().getJobGroupNames();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws SchedulerException {
        validateState();
        if (matcher == null) {
            matcher = GroupMatcher.groupEquals("DEFAULT");
        }
        return this.resources.getJobStore().getJobKeys(matcher);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List<? extends Trigger> getTriggersOfJob(JobKey jobKey) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().getTriggersForJob(jobKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List<String> getTriggerGroupNames() throws SchedulerException {
        validateState();
        return this.resources.getJobStore().getTriggerGroupNames();
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        validateState();
        if (matcher == null) {
            matcher = GroupMatcher.groupEquals("DEFAULT");
        }
        return this.resources.getJobStore().getTriggerKeys(matcher);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public JobDetail getJobDetail(JobKey jobKey) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().retrieveJob(jobKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().retrieveTrigger(triggerKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean checkExists(JobKey jobKey) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().checkExists(jobKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean checkExists(TriggerKey triggerKey) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().checkExists(triggerKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void clear() throws SchedulerException {
        validateState();
        this.resources.getJobStore().clearAllSchedulingData();
        notifySchedulerListenersUnscheduled(null);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().getTriggerState(triggerKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws SchedulerException {
        validateState();
        this.resources.getJobStore().resetTriggerFromErrorState(triggerKey);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers) throws SchedulerException {
        validateState();
        this.resources.getJobStore().storeCalendar(calName, calendar, replace, updateTriggers);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean deleteCalendar(String calName) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().removeCalendar(calName);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Calendar getCalendar(String calName) throws SchedulerException {
        validateState();
        return this.resources.getJobStore().retrieveCalendar(calName);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List<String> getCalendarNames() throws SchedulerException {
        validateState();
        return this.resources.getJobStore().getCalendarNames();
    }

    public ListenerManager getListenerManager() {
        return this.listenerManager;
    }

    public void addInternalJobListener(JobListener jobListener) {
        if (jobListener.getName() == null || jobListener.getName().length() == 0) {
            throw new IllegalArgumentException("JobListener name cannot be empty.");
        }
        synchronized (this.internalJobListeners) {
            this.internalJobListeners.put(jobListener.getName(), jobListener);
        }
    }

    public boolean removeInternalJobListener(String name) {
        boolean z;
        synchronized (this.internalJobListeners) {
            z = this.internalJobListeners.remove(name) != null;
        }
        return z;
    }

    public List<JobListener> getInternalJobListeners() {
        List<JobListener> unmodifiableList;
        synchronized (this.internalJobListeners) {
            unmodifiableList = Collections.unmodifiableList(new LinkedList(this.internalJobListeners.values()));
        }
        return unmodifiableList;
    }

    public JobListener getInternalJobListener(String name) {
        JobListener jobListener;
        synchronized (this.internalJobListeners) {
            jobListener = this.internalJobListeners.get(name);
        }
        return jobListener;
    }

    public void addInternalTriggerListener(TriggerListener triggerListener) {
        if (triggerListener.getName() == null || triggerListener.getName().length() == 0) {
            throw new IllegalArgumentException("TriggerListener name cannot be empty.");
        }
        synchronized (this.internalTriggerListeners) {
            this.internalTriggerListeners.put(triggerListener.getName(), triggerListener);
        }
    }

    public boolean removeinternalTriggerListener(String name) {
        boolean z;
        synchronized (this.internalTriggerListeners) {
            z = this.internalTriggerListeners.remove(name) != null;
        }
        return z;
    }

    public List<TriggerListener> getInternalTriggerListeners() {
        List<TriggerListener> unmodifiableList;
        synchronized (this.internalTriggerListeners) {
            unmodifiableList = Collections.unmodifiableList(new LinkedList(this.internalTriggerListeners.values()));
        }
        return unmodifiableList;
    }

    public TriggerListener getInternalTriggerListener(String name) {
        TriggerListener triggerListener;
        synchronized (this.internalTriggerListeners) {
            triggerListener = this.internalTriggerListeners.get(name);
        }
        return triggerListener;
    }

    public void addInternalSchedulerListener(SchedulerListener schedulerListener) {
        synchronized (this.internalSchedulerListeners) {
            this.internalSchedulerListeners.add(schedulerListener);
        }
    }

    public boolean removeInternalSchedulerListener(SchedulerListener schedulerListener) {
        boolean remove;
        synchronized (this.internalSchedulerListeners) {
            remove = this.internalSchedulerListeners.remove(schedulerListener);
        }
        return remove;
    }

    public List<SchedulerListener> getInternalSchedulerListeners() {
        List<SchedulerListener> unmodifiableList;
        synchronized (this.internalSchedulerListeners) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(this.internalSchedulerListeners));
        }
        return unmodifiableList;
    }

    /* access modifiers changed from: protected */
    public void notifyJobStoreJobComplete(OperableTrigger trigger, JobDetail detail, Trigger.CompletedExecutionInstruction instCode) {
        this.resources.getJobStore().triggeredJobComplete(trigger, detail, instCode);
    }

    /* access modifiers changed from: protected */
    public void notifyJobStoreJobVetoed(OperableTrigger trigger, JobDetail detail, Trigger.CompletedExecutionInstruction instCode) {
        this.resources.getJobStore().triggeredJobComplete(trigger, detail, instCode);
    }

    protected void notifySchedulerThread(long candidateNewNextFireTime) {
        if (isSignalOnSchedulingChange()) {
            this.signaler.signalSchedulingChange(candidateNewNextFireTime);
        }
    }

    private List<TriggerListener> buildTriggerListenerList() throws SchedulerException {
        List<TriggerListener> allListeners = new LinkedList<>();
        allListeners.addAll(getListenerManager().getTriggerListeners());
        allListeners.addAll(getInternalTriggerListeners());
        return allListeners;
    }

    private List<JobListener> buildJobListenerList() throws SchedulerException {
        List<JobListener> allListeners = new LinkedList<>();
        allListeners.addAll(getListenerManager().getJobListeners());
        allListeners.addAll(getInternalJobListeners());
        return allListeners;
    }

    private List<SchedulerListener> buildSchedulerListenerList() {
        List<SchedulerListener> allListeners = new LinkedList<>();
        allListeners.addAll(getListenerManager().getSchedulerListeners());
        allListeners.addAll(getInternalSchedulerListeners());
        return allListeners;
    }

    private boolean matchJobListener(JobListener listener, JobKey key) {
        List<Matcher<JobKey>> matchers = getListenerManager().getJobListenerMatchers(listener.getName());
        if (matchers == null) {
            return true;
        }
        for (Matcher<JobKey> matcher : matchers) {
            if (matcher.isMatch(key)) {
                return true;
            }
        }
        return false;
    }

    private boolean matchTriggerListener(TriggerListener listener, TriggerKey key) {
        List<Matcher<TriggerKey>> matchers = getListenerManager().getTriggerListenerMatchers(listener.getName());
        if (matchers == null) {
            return true;
        }
        for (Matcher<TriggerKey> matcher : matchers) {
            if (matcher.isMatch(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean notifyTriggerListenersFired(JobExecutionContext jec) throws SchedulerException {
        boolean vetoedExecution = false;
        for (TriggerListener tl : buildTriggerListenerList()) {
            try {
                if (matchTriggerListener(tl, jec.getTrigger().getKey())) {
                    tl.triggerFired(jec.getTrigger(), jec);
                    if (tl.vetoJobExecution(jec.getTrigger(), jec)) {
                        vetoedExecution = true;
                    }
                }
            } catch (Exception e) {
                throw new SchedulerException("TriggerListener '" + tl.getName() + "' threw exception: " + e.getMessage(), e);
            }
        }
        return vetoedExecution;
    }

    public void notifyTriggerListenersMisfired(Trigger trigger) throws SchedulerException {
        for (TriggerListener tl : buildTriggerListenerList()) {
            try {
                if (matchTriggerListener(tl, trigger.getKey())) {
                    tl.triggerMisfired(trigger);
                }
            } catch (Exception e) {
                throw new SchedulerException("TriggerListener '" + tl.getName() + "' threw exception: " + e.getMessage(), e);
            }
        }
    }

    public void notifyTriggerListenersComplete(JobExecutionContext jec, Trigger.CompletedExecutionInstruction instCode) throws SchedulerException {
        for (TriggerListener tl : buildTriggerListenerList()) {
            try {
                if (matchTriggerListener(tl, jec.getTrigger().getKey())) {
                    tl.triggerComplete(jec.getTrigger(), jec, instCode);
                }
            } catch (Exception e) {
                throw new SchedulerException("TriggerListener '" + tl.getName() + "' threw exception: " + e.getMessage(), e);
            }
        }
    }

    public void notifyJobListenersToBeExecuted(JobExecutionContext jec) throws SchedulerException {
        for (JobListener jl : buildJobListenerList()) {
            try {
                if (matchJobListener(jl, jec.getJobDetail().getKey())) {
                    jl.jobToBeExecuted(jec);
                }
            } catch (Exception e) {
                throw new SchedulerException("JobListener '" + jl.getName() + "' threw exception: " + e.getMessage(), e);
            }
        }
    }

    public void notifyJobListenersWasVetoed(JobExecutionContext jec) throws SchedulerException {
        for (JobListener jl : buildJobListenerList()) {
            try {
                if (matchJobListener(jl, jec.getJobDetail().getKey())) {
                    jl.jobExecutionVetoed(jec);
                }
            } catch (Exception e) {
                throw new SchedulerException("JobListener '" + jl.getName() + "' threw exception: " + e.getMessage(), e);
            }
        }
    }

    public void notifyJobListenersWasExecuted(JobExecutionContext jec, JobExecutionException je) throws SchedulerException {
        for (JobListener jl : buildJobListenerList()) {
            try {
                if (matchJobListener(jl, jec.getJobDetail().getKey())) {
                    jl.jobWasExecuted(jec, je);
                }
            } catch (Exception e) {
                throw new SchedulerException("JobListener '" + jl.getName() + "' threw exception: " + e.getMessage(), e);
            }
        }
    }

    public void notifySchedulerListenersError(String msg, SchedulerException se) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.schedulerError(msg, se);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of error: ", (Throwable) e);
                getLog().error("  Original error (for notification) was: " + msg, (Throwable) se);
            }
        }
    }

    public void notifySchedulerListenersSchduled(Trigger trigger) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.jobScheduled(trigger);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of scheduled job.  Triger=" + trigger.getKey(), (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersUnscheduled(TriggerKey triggerKey) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            if (triggerKey == null) {
                try {
                    sl.schedulingDataCleared();
                } catch (Exception e) {
                    getLog().error("Error while notifying SchedulerListener of unscheduled job.  Triger=" + (triggerKey == null ? "ALL DATA" : triggerKey), (Throwable) e);
                }
            } else {
                sl.jobUnscheduled(triggerKey);
            }
        }
    }

    public void notifySchedulerListenersFinalized(Trigger trigger) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.triggerFinalized(trigger);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of finalized trigger.  Triger=" + trigger.getKey(), (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersPausedTrigger(TriggerKey triggerKey) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.triggerPaused(triggerKey);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of paused trigger: " + triggerKey, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersPausedTriggers(String group) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.triggersPaused(group);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of paused trigger group." + group, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersResumedTrigger(TriggerKey key) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.triggerResumed(key);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of resumed trigger: " + key, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersResumedTriggers(String group) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.triggersResumed(group);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of resumed group: " + group, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersPausedJob(JobKey key) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.jobPaused(key);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of paused job: " + key, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersPausedJobs(String group) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.jobsPaused(group);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of paused job group: " + group, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersResumedJob(JobKey key) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.jobResumed(key);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of resumed job: " + key, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersResumedJobs(String group) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.jobsResumed(group);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of resumed job group: " + group, (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersInStandbyMode() {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.schedulerInStandbyMode();
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of inStandByMode.", (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersStarted() {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.schedulerStarted();
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of startup.", (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersStarting() {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.schedulerStarting();
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of startup.", (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersShutdown() {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.schedulerShutdown();
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of shutdown.", (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersShuttingdown() {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.schedulerShuttingdown();
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of shutdown.", (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersJobAdded(JobDetail jobDetail) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.jobAdded(jobDetail);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of JobAdded.", (Throwable) e);
            }
        }
    }

    public void notifySchedulerListenersJobDeleted(JobKey jobKey) {
        for (SchedulerListener sl : buildSchedulerListenerList()) {
            try {
                sl.jobDeleted(jobKey);
            } catch (Exception e) {
                getLog().error("Error while notifying SchedulerListener of JobAdded.", (Throwable) e);
            }
        }
    }

    public void setJobFactory(JobFactory factory) throws SchedulerException {
        if (factory == null) {
            throw new IllegalArgumentException("JobFactory cannot be set to null!");
        }
        getLog().info("JobFactory set to: " + factory);
        this.jobFactory = factory;
    }

    public JobFactory getJobFactory() {
        return this.jobFactory;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean interrupt(JobKey jobKey) throws UnableToInterruptJobException {
        boolean interrupted = false;
        for (JobExecutionContext jec : getCurrentlyExecutingJobs()) {
            JobDetail jobDetail = jec.getJobDetail();
            if (jobKey.equals(jobDetail.getKey())) {
                Job job = jec.getJobInstance();
                if (job instanceof InterruptableJob) {
                    ((InterruptableJob) job).interrupt();
                    interrupted = true;
                } else {
                    throw new UnableToInterruptJobException("Job " + jobDetail.getKey() + " can not be interrupted, since it does not implement " + InterruptableJob.class.getName());
                }
            }
        }
        return interrupted;
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean interrupt(String fireInstanceId) throws UnableToInterruptJobException {
        for (JobExecutionContext jec : getCurrentlyExecutingJobs()) {
            if (jec.getFireInstanceId().equals(fireInstanceId)) {
                Job job = jec.getJobInstance();
                if (job instanceof InterruptableJob) {
                    ((InterruptableJob) job).interrupt();
                    return true;
                }
                throw new UnableToInterruptJobException("Job " + jec.getJobDetail().getKey() + " can not be interrupted, since it does not implement " + InterruptableJob.class.getName());
            }
        }
        return false;
    }

    private void shutdownPlugins() {
        for (SchedulerPlugin plugin : this.resources.getSchedulerPlugins()) {
            plugin.shutdown();
        }
    }

    private void startPlugins() {
        for (SchedulerPlugin plugin : this.resources.getSchedulerPlugins()) {
            plugin.start();
        }
    }
}
