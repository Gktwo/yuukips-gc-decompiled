package org.quartz.plugins.interrupt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.listeners.TriggerListenerSupport;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.SchedulerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/quartz/plugins/interrupt/JobInterruptMonitorPlugin.class */
public class JobInterruptMonitorPlugin extends TriggerListenerSupport implements SchedulerPlugin {
    private static final String JOB_INTERRUPT_MONITOR_KEY = "JOB_INTERRUPT_MONITOR_KEY";
    private String name;
    private ScheduledExecutorService executor;
    private ScheduledFuture future;
    private Scheduler scheduler;
    public static final String AUTO_INTERRUPTIBLE = "AutoInterruptable";
    public static final String MAX_RUN_TIME = "MaxRunTime";
    private long DEFAULT_MAX_RUNTIME = 300000;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override // org.quartz.spi.SchedulerPlugin
    public void start() {
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void shutdown() {
        this.executor.shutdown();
    }

    @Override // org.quartz.listeners.TriggerListenerSupport
    protected Logger getLog() {
        return this.log;
    }

    public ScheduledFuture scheduleJobInterruptMonitor(JobKey jobkey, long delay) {
        return this.executor.schedule(new InterruptMonitor(jobkey, this.scheduler), delay, TimeUnit.MILLISECONDS);
    }

    public long getDefaultMaxRunTime() {
        return this.DEFAULT_MAX_RUNTIME;
    }

    public void setDefaultMaxRunTime(long defaultMaxRunTime) {
        this.DEFAULT_MAX_RUNTIME = defaultMaxRunTime;
    }

    @Override // org.quartz.TriggerListener
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.quartz.listeners.TriggerListenerSupport, org.quartz.TriggerListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void triggerFired(org.quartz.Trigger r7, org.quartz.JobExecutionContext r8) {
        /*
            r6 = this;
            r0 = r8
            org.quartz.JobDetail r0 = r0.getJobDetail()     // Catch: SchedulerException -> 0x0089
            org.quartz.JobDataMap r0 = r0.getJobDataMap()     // Catch: SchedulerException -> 0x0089
            java.lang.String r1 = "AutoInterruptable"
            boolean r0 = r0.getBoolean(r1)     // Catch: SchedulerException -> 0x0089
            if (r0 == 0) goto L_0x0086
            r0 = r8
            org.quartz.Scheduler r0 = r0.getScheduler()     // Catch: SchedulerException -> 0x0089
            org.quartz.SchedulerContext r0 = r0.getContext()     // Catch: SchedulerException -> 0x0089
            java.lang.String r1 = "JOB_INTERRUPT_MONITOR_KEY"
            java.lang.Object r0 = r0.get(r1)     // Catch: SchedulerException -> 0x0089
            org.quartz.plugins.interrupt.JobInterruptMonitorPlugin r0 = (org.quartz.plugins.interrupt.JobInterruptMonitorPlugin) r0     // Catch: SchedulerException -> 0x0089
            r9 = r0
            r0 = r6
            long r0 = r0.DEFAULT_MAX_RUNTIME     // Catch: SchedulerException -> 0x0089
            r10 = r0
            r0 = r8
            org.quartz.JobDetail r0 = r0.getJobDetail()     // Catch: SchedulerException -> 0x0089
            org.quartz.JobDataMap r0 = r0.getJobDataMap()     // Catch: SchedulerException -> 0x0089
            java.lang.String r1 = "MaxRunTime"
            java.lang.Object r0 = r0.get(r1)     // Catch: SchedulerException -> 0x0089
            if (r0 == 0) goto L_0x0052
            r0 = r8
            org.quartz.JobDetail r0 = r0.getJobDetail()     // Catch: SchedulerException -> 0x0089
            org.quartz.JobDataMap r0 = r0.getJobDataMap()     // Catch: SchedulerException -> 0x0089
            java.lang.String r1 = "MaxRunTime"
            long r0 = r0.getLong(r1)     // Catch: SchedulerException -> 0x0089
            r10 = r0
        L_0x0052:
            r0 = r6
            r1 = r9
            r2 = r8
            org.quartz.JobDetail r2 = r2.getJobDetail()     // Catch: SchedulerException -> 0x0089
            org.quartz.JobKey r2 = r2.getKey()     // Catch: SchedulerException -> 0x0089
            r3 = r10
            java.util.concurrent.ScheduledFuture r1 = r1.scheduleJobInterruptMonitor(r2, r3)     // Catch: SchedulerException -> 0x0089
            r0.future = r1     // Catch: SchedulerException -> 0x0089
            r0 = r6
            org.slf4j.Logger r0 = r0.getLog()     // Catch: SchedulerException -> 0x0089
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: SchedulerException -> 0x0089
            r2 = r1
            r2.<init>()     // Catch: SchedulerException -> 0x0089
            java.lang.String r2 = "Job's Interrupt Monitor has been scheduled to interrupt with the delay :"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: SchedulerException -> 0x0089
            r2 = r6
            long r2 = r2.DEFAULT_MAX_RUNTIME     // Catch: SchedulerException -> 0x0089
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: SchedulerException -> 0x0089
            java.lang.String r1 = r1.toString()     // Catch: SchedulerException -> 0x0089
            r0.debug(r1)     // Catch: SchedulerException -> 0x0089
        L_0x0086:
            goto L_0x00aa
        L_0x0089:
            r9 = move-exception
            r0 = r6
            org.slf4j.Logger r0 = r0.getLog()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "Error scheduling interrupt monitor "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r9
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = r9
            r0.info(r1, r2)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.plugins.interrupt.JobInterruptMonitorPlugin.triggerFired(org.quartz.Trigger, org.quartz.JobExecutionContext):void");
    }

    @Override // org.quartz.listeners.TriggerListenerSupport, org.quartz.TriggerListener
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        if (this.future != null) {
            this.future.cancel(true);
        }
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void initialize(String name, Scheduler scheduler, ClassLoadHelper helper) throws SchedulerException {
        getLog().info("Registering Job Interrupt Monitor Plugin");
        this.name = name;
        this.executor = Executors.newScheduledThreadPool(1);
        scheduler.getContext().put(JOB_INTERRUPT_MONITOR_KEY, (Object) this);
        this.scheduler = scheduler;
        this.scheduler.getListenerManager().addTriggerListener(this);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/quartz/plugins/interrupt/JobInterruptMonitorPlugin$InterruptMonitor.class */
    public static class InterruptMonitor implements Runnable {
        private final JobKey jobKey;
        private final Scheduler scheduler;
        private final Logger log = LoggerFactory.getLogger(getClass());

        InterruptMonitor(JobKey jobKey, Scheduler scheduler) {
            this.jobKey = jobKey;
            this.scheduler = scheduler;
        }

        protected Logger getLog() {
            return this.log;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                getLog().info("Interrupting Job as it ran more than the configured max time. Job Details [" + this.jobKey.getName() + EmitterKt.COMMENT_PREFIX + this.jobKey.getGroup() + "]");
                this.scheduler.interrupt(this.jobKey);
            } catch (SchedulerException x) {
                getLog().info("Error interrupting Job: " + x.getMessage(), (Throwable) x);
            }
        }
    }
}
