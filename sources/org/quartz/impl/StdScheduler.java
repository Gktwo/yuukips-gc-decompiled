package org.quartz.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.ListenerManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.UnableToInterruptJobException;
import org.quartz.core.QuartzScheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.JobFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/StdScheduler.class */
public class StdScheduler implements Scheduler {
    private QuartzScheduler sched;

    public StdScheduler(QuartzScheduler sched) {
        this.sched = sched;
    }

    @Override // org.quartz.Scheduler
    public String getSchedulerName() {
        return this.sched.getSchedulerName();
    }

    @Override // org.quartz.Scheduler
    public String getSchedulerInstanceId() {
        return this.sched.getSchedulerInstanceId();
    }

    @Override // org.quartz.Scheduler
    public SchedulerMetaData getMetaData() {
        return new SchedulerMetaData(getSchedulerName(), getSchedulerInstanceId(), getClass(), false, isStarted(), isInStandbyMode(), isShutdown(), this.sched.runningSince(), this.sched.numJobsExecuted(), this.sched.getJobStoreClass(), this.sched.supportsPersistence(), this.sched.isClustered(), this.sched.getThreadPoolClass(), this.sched.getThreadPoolSize(), this.sched.getVersion());
    }

    @Override // org.quartz.Scheduler
    public SchedulerContext getContext() throws SchedulerException {
        return this.sched.getSchedulerContext();
    }

    @Override // org.quartz.Scheduler
    public void start() throws SchedulerException {
        this.sched.start();
    }

    @Override // org.quartz.Scheduler
    public void startDelayed(int seconds) throws SchedulerException {
        this.sched.startDelayed(seconds);
    }

    @Override // org.quartz.Scheduler
    public void standby() {
        this.sched.standby();
    }

    @Override // org.quartz.Scheduler
    public boolean isStarted() {
        return this.sched.runningSince() != null;
    }

    @Override // org.quartz.Scheduler
    public boolean isInStandbyMode() {
        return this.sched.isInStandbyMode();
    }

    @Override // org.quartz.Scheduler
    public void shutdown() {
        this.sched.shutdown();
    }

    @Override // org.quartz.Scheduler
    public void shutdown(boolean waitForJobsToComplete) {
        this.sched.shutdown(waitForJobsToComplete);
    }

    @Override // org.quartz.Scheduler
    public boolean isShutdown() {
        return this.sched.isShutdown();
    }

    @Override // org.quartz.Scheduler
    public List<JobExecutionContext> getCurrentlyExecutingJobs() {
        return this.sched.getCurrentlyExecutingJobs();
    }

    @Override // org.quartz.Scheduler
    public void clear() throws SchedulerException {
        this.sched.clear();
    }

    @Override // org.quartz.Scheduler
    public Date scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        return this.sched.scheduleJob(jobDetail, trigger);
    }

    @Override // org.quartz.Scheduler
    public Date scheduleJob(Trigger trigger) throws SchedulerException {
        return this.sched.scheduleJob(trigger);
    }

    @Override // org.quartz.Scheduler
    public void addJob(JobDetail jobDetail, boolean replace) throws SchedulerException {
        this.sched.addJob(jobDetail, replace);
    }

    @Override // org.quartz.Scheduler
    public void addJob(JobDetail jobDetail, boolean replace, boolean storeNonDurableWhileAwaitingScheduling) throws SchedulerException {
        this.sched.addJob(jobDetail, replace, storeNonDurableWhileAwaitingScheduling);
    }

    @Override // org.quartz.Scheduler
    public boolean deleteJobs(List<JobKey> jobKeys) throws SchedulerException {
        return this.sched.deleteJobs(jobKeys);
    }

    @Override // org.quartz.Scheduler
    public void scheduleJobs(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws SchedulerException {
        this.sched.scheduleJobs(triggersAndJobs, replace);
    }

    @Override // org.quartz.Scheduler
    public void scheduleJob(JobDetail jobDetail, Set<? extends Trigger> triggersForJob, boolean replace) throws SchedulerException {
        this.sched.scheduleJob(jobDetail, triggersForJob, replace);
    }

    @Override // org.quartz.Scheduler
    public boolean unscheduleJobs(List<TriggerKey> triggerKeys) throws SchedulerException {
        return this.sched.unscheduleJobs(triggerKeys);
    }

    @Override // org.quartz.Scheduler
    public boolean deleteJob(JobKey jobKey) throws SchedulerException {
        return this.sched.deleteJob(jobKey);
    }

    @Override // org.quartz.Scheduler
    public boolean unscheduleJob(TriggerKey triggerKey) throws SchedulerException {
        return this.sched.unscheduleJob(triggerKey);
    }

    @Override // org.quartz.Scheduler
    public Date rescheduleJob(TriggerKey triggerKey, Trigger newTrigger) throws SchedulerException {
        return this.sched.rescheduleJob(triggerKey, newTrigger);
    }

    @Override // org.quartz.Scheduler
    public void triggerJob(JobKey jobKey) throws SchedulerException {
        triggerJob(jobKey, null);
    }

    @Override // org.quartz.Scheduler
    public void triggerJob(JobKey jobKey, JobDataMap data) throws SchedulerException {
        this.sched.triggerJob(jobKey, data);
    }

    @Override // org.quartz.Scheduler
    public void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
        this.sched.pauseTrigger(triggerKey);
    }

    @Override // org.quartz.Scheduler
    public void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        this.sched.pauseTriggers(matcher);
    }

    @Override // org.quartz.Scheduler
    public void pauseJob(JobKey jobKey) throws SchedulerException {
        this.sched.pauseJob(jobKey);
    }

    @Override // org.quartz.Scheduler
    public Set<String> getPausedTriggerGroups() throws SchedulerException {
        return this.sched.getPausedTriggerGroups();
    }

    @Override // org.quartz.Scheduler
    public void pauseJobs(GroupMatcher<JobKey> matcher) throws SchedulerException {
        this.sched.pauseJobs(matcher);
    }

    @Override // org.quartz.Scheduler
    public void resumeTrigger(TriggerKey triggerKey) throws SchedulerException {
        this.sched.resumeTrigger(triggerKey);
    }

    @Override // org.quartz.Scheduler
    public void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        this.sched.resumeTriggers(matcher);
    }

    @Override // org.quartz.Scheduler
    public void resumeJob(JobKey jobKey) throws SchedulerException {
        this.sched.resumeJob(jobKey);
    }

    @Override // org.quartz.Scheduler
    public void resumeJobs(GroupMatcher<JobKey> matcher) throws SchedulerException {
        this.sched.resumeJobs(matcher);
    }

    @Override // org.quartz.Scheduler
    public void pauseAll() throws SchedulerException {
        this.sched.pauseAll();
    }

    @Override // org.quartz.Scheduler
    public void resumeAll() throws SchedulerException {
        this.sched.resumeAll();
    }

    @Override // org.quartz.Scheduler
    public List<String> getJobGroupNames() throws SchedulerException {
        return this.sched.getJobGroupNames();
    }

    @Override // org.quartz.Scheduler
    public List<? extends Trigger> getTriggersOfJob(JobKey jobKey) throws SchedulerException {
        return this.sched.getTriggersOfJob(jobKey);
    }

    @Override // org.quartz.Scheduler
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws SchedulerException {
        return this.sched.getJobKeys(matcher);
    }

    @Override // org.quartz.Scheduler
    public List<String> getTriggerGroupNames() throws SchedulerException {
        return this.sched.getTriggerGroupNames();
    }

    @Override // org.quartz.Scheduler
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        return this.sched.getTriggerKeys(matcher);
    }

    @Override // org.quartz.Scheduler
    public JobDetail getJobDetail(JobKey jobKey) throws SchedulerException {
        return this.sched.getJobDetail(jobKey);
    }

    @Override // org.quartz.Scheduler
    public Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException {
        return this.sched.getTrigger(triggerKey);
    }

    @Override // org.quartz.Scheduler
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws SchedulerException {
        return this.sched.getTriggerState(triggerKey);
    }

    @Override // org.quartz.Scheduler
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws SchedulerException {
        this.sched.resetTriggerFromErrorState(triggerKey);
    }

    @Override // org.quartz.Scheduler
    public void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers) throws SchedulerException {
        this.sched.addCalendar(calName, calendar, replace, updateTriggers);
    }

    @Override // org.quartz.Scheduler
    public boolean deleteCalendar(String calName) throws SchedulerException {
        return this.sched.deleteCalendar(calName);
    }

    @Override // org.quartz.Scheduler
    public Calendar getCalendar(String calName) throws SchedulerException {
        return this.sched.getCalendar(calName);
    }

    @Override // org.quartz.Scheduler
    public List<String> getCalendarNames() throws SchedulerException {
        return this.sched.getCalendarNames();
    }

    @Override // org.quartz.Scheduler
    public boolean checkExists(JobKey jobKey) throws SchedulerException {
        return this.sched.checkExists(jobKey);
    }

    @Override // org.quartz.Scheduler
    public boolean checkExists(TriggerKey triggerKey) throws SchedulerException {
        return this.sched.checkExists(triggerKey);
    }

    @Override // org.quartz.Scheduler
    public void setJobFactory(JobFactory factory) throws SchedulerException {
        this.sched.setJobFactory(factory);
    }

    @Override // org.quartz.Scheduler
    public ListenerManager getListenerManager() throws SchedulerException {
        return this.sched.getListenerManager();
    }

    @Override // org.quartz.Scheduler
    public boolean interrupt(JobKey jobKey) throws UnableToInterruptJobException {
        return this.sched.interrupt(jobKey);
    }

    @Override // org.quartz.Scheduler
    public boolean interrupt(String fireInstanceId) throws UnableToInterruptJobException {
        return this.sched.interrupt(fireInstanceId);
    }
}
