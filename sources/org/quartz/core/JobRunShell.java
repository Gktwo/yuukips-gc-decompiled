package org.quartz.core;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.JobExecutionContextImpl;
import org.quartz.listeners.SchedulerListenerSupport;
import org.quartz.spi.TriggerFiredBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/core/JobRunShell.class */
public class JobRunShell extends SchedulerListenerSupport implements Runnable {
    protected TriggerFiredBundle firedTriggerBundle;
    protected Scheduler scheduler;
    protected JobExecutionContextImpl jec = null;

    /* renamed from: qs */
    protected QuartzScheduler f3366qs = null;
    protected volatile boolean shutdownRequested = false;
    private final Logger log = LoggerFactory.getLogger(getClass());

    /* loaded from: grasscutter.jar:org/quartz/core/JobRunShell$VetoedException.class */
    static class VetoedException extends Exception {
        private static final long serialVersionUID = 1539955697495918463L;
    }

    public JobRunShell(Scheduler scheduler, TriggerFiredBundle bndle) {
        this.firedTriggerBundle = null;
        this.scheduler = null;
        this.scheduler = scheduler;
        this.firedTriggerBundle = bndle;
    }

    @Override // org.quartz.listeners.SchedulerListenerSupport, org.quartz.SchedulerListener
    public void schedulerShuttingdown() {
        requestShutdown();
    }

    @Override // org.quartz.listeners.SchedulerListenerSupport
    protected Logger getLog() {
        return this.log;
    }

    public void initialize(QuartzScheduler sched) throws SchedulerException {
        this.f3366qs = sched;
        JobDetail jobDetail = this.firedTriggerBundle.getJobDetail();
        try {
            this.jec = new JobExecutionContextImpl(this.scheduler, this.firedTriggerBundle, sched.getJobFactory().newJob(this.firedTriggerBundle, this.scheduler));
        } catch (SchedulerException se) {
            sched.notifySchedulerListenersError("An error occured instantiating job to be executed. job= '" + jobDetail.getKey() + "'", se);
            throw se;
        } catch (Throwable ncdfe) {
            SchedulerException se2 = new SchedulerException("Problem instantiating class '" + jobDetail.getJobClass().getName() + "' - ", ncdfe);
            sched.notifySchedulerListenersError("An error occured instantiating job to be executed. job= '" + jobDetail.getKey() + "'", se2);
            throw se2;
        }
    }

    public void requestShutdown() {
        this.shutdownRequested = true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x006f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.lang.Runnable
    public void run() {
        /*
        // Method dump skipped, instructions count: 711
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.core.JobRunShell.run():void");
    }

    protected void begin() throws SchedulerException {
    }

    protected void complete(boolean successfulExecution) throws SchedulerException {
    }

    public void passivate() {
        this.jec = null;
        this.f3366qs = null;
    }

    private boolean notifyListenersBeginning(JobExecutionContext jobExCtxt) throws VetoedException {
        try {
            if (this.f3366qs.notifyTriggerListenersFired(jobExCtxt)) {
                try {
                    this.f3366qs.notifyJobListenersWasVetoed(jobExCtxt);
                } catch (SchedulerException se) {
                    this.f3366qs.notifySchedulerListenersError("Unable to notify JobListener(s) of vetoed execution while firing trigger (Trigger and Job will NOT be fired!). trigger= " + jobExCtxt.getTrigger().getKey() + " job= " + jobExCtxt.getJobDetail().getKey(), se);
                }
                throw new VetoedException();
            }
            try {
                this.f3366qs.notifyJobListenersToBeExecuted(jobExCtxt);
                return true;
            } catch (SchedulerException se2) {
                this.f3366qs.notifySchedulerListenersError("Unable to notify JobListener(s) of Job to be executed: (Job will NOT be executed!). trigger= " + jobExCtxt.getTrigger().getKey() + " job= " + jobExCtxt.getJobDetail().getKey(), se2);
                return false;
            }
        } catch (SchedulerException se3) {
            this.f3366qs.notifySchedulerListenersError("Unable to notify TriggerListener(s) while firing trigger (Trigger and Job will NOT be fired!). trigger= " + jobExCtxt.getTrigger().getKey() + " job= " + jobExCtxt.getJobDetail().getKey(), se3);
            return false;
        }
    }

    private boolean notifyJobListenersComplete(JobExecutionContext jobExCtxt, JobExecutionException jobExEx) {
        try {
            this.f3366qs.notifyJobListenersWasExecuted(jobExCtxt, jobExEx);
            return true;
        } catch (SchedulerException se) {
            this.f3366qs.notifySchedulerListenersError("Unable to notify JobListener(s) of Job that was executed: (error will be ignored). trigger= " + jobExCtxt.getTrigger().getKey() + " job= " + jobExCtxt.getJobDetail().getKey(), se);
            return false;
        }
    }

    private boolean notifyTriggerListenersComplete(JobExecutionContext jobExCtxt, Trigger.CompletedExecutionInstruction instCode) {
        try {
            this.f3366qs.notifyTriggerListenersComplete(jobExCtxt, instCode);
            if (jobExCtxt.getTrigger().getNextFireTime() != null) {
                return true;
            }
            this.f3366qs.notifySchedulerListenersFinalized(jobExCtxt.getTrigger());
            return true;
        } catch (SchedulerException se) {
            this.f3366qs.notifySchedulerListenersError("Unable to notify TriggerListener(s) of Job that was executed: (error will be ignored). trigger= " + jobExCtxt.getTrigger().getKey() + " job= " + jobExCtxt.getJobDetail().getKey(), se);
            return false;
        }
    }
}
