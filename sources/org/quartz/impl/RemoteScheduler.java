package org.quartz.impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
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
import org.quartz.core.RemotableQuartzScheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.JobFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/RemoteScheduler.class */
public class RemoteScheduler implements Scheduler {
    private RemotableQuartzScheduler rsched;
    private String schedId;
    private String rmiHost;
    private int rmiPort;

    public RemoteScheduler(String schedId, String host, int port) {
        this.schedId = schedId;
        this.rmiHost = host;
        this.rmiPort = port;
    }

    protected RemotableQuartzScheduler getRemoteScheduler() throws SchedulerException {
        if (this.rsched != null) {
            return this.rsched;
        }
        try {
            this.rsched = LocateRegistry.getRegistry(this.rmiHost, this.rmiPort).lookup(this.schedId);
            return this.rsched;
        } catch (Exception e) {
            throw new SchedulerException("Could not get handle to remote scheduler: " + e.getMessage(), e);
        }
    }

    protected SchedulerException invalidateHandleCreateException(String msg, Exception cause) {
        this.rsched = null;
        return new SchedulerException(msg, cause);
    }

    @Override // org.quartz.Scheduler
    public String getSchedulerName() throws SchedulerException {
        try {
            return getRemoteScheduler().getSchedulerName();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public String getSchedulerInstanceId() throws SchedulerException {
        try {
            return getRemoteScheduler().getSchedulerInstanceId();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public SchedulerMetaData getMetaData() throws SchedulerException {
        try {
            RemotableQuartzScheduler sched = getRemoteScheduler();
            return new SchedulerMetaData(getSchedulerName(), getSchedulerInstanceId(), getClass(), true, isStarted(), isInStandbyMode(), isShutdown(), sched.runningSince(), sched.numJobsExecuted(), sched.getJobStoreClass(), sched.supportsPersistence(), sched.isClustered(), sched.getThreadPoolClass(), sched.getThreadPoolSize(), sched.getVersion());
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public SchedulerContext getContext() throws SchedulerException {
        try {
            return getRemoteScheduler().getSchedulerContext();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void start() throws SchedulerException {
        try {
            getRemoteScheduler().start();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void startDelayed(int seconds) throws SchedulerException {
        try {
            getRemoteScheduler().startDelayed(seconds);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void standby() throws SchedulerException {
        try {
            getRemoteScheduler().standby();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean isStarted() throws SchedulerException {
        try {
            return getRemoteScheduler().runningSince() != null;
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean isInStandbyMode() throws SchedulerException {
        try {
            return getRemoteScheduler().isInStandbyMode();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void shutdown() throws SchedulerException {
        try {
            String schedulerName = getSchedulerName();
            getRemoteScheduler().shutdown();
            SchedulerRepository.getInstance().remove(schedulerName);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void shutdown(boolean waitForJobsToComplete) throws SchedulerException {
        try {
            String schedulerName = getSchedulerName();
            getRemoteScheduler().shutdown(waitForJobsToComplete);
            SchedulerRepository.getInstance().remove(schedulerName);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean isShutdown() throws SchedulerException {
        try {
            return getRemoteScheduler().isShutdown();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public List<JobExecutionContext> getCurrentlyExecutingJobs() throws SchedulerException {
        try {
            return getRemoteScheduler().getCurrentlyExecutingJobs();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Date scheduleJob(JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        try {
            return getRemoteScheduler().scheduleJob(jobDetail, trigger);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Date scheduleJob(Trigger trigger) throws SchedulerException {
        try {
            return getRemoteScheduler().scheduleJob(trigger);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void addJob(JobDetail jobDetail, boolean replace) throws SchedulerException {
        try {
            getRemoteScheduler().addJob(jobDetail, replace);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void addJob(JobDetail jobDetail, boolean replace, boolean storeNonDurableWhileAwaitingScheduling) throws SchedulerException {
        try {
            getRemoteScheduler().addJob(jobDetail, replace, storeNonDurableWhileAwaitingScheduling);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean deleteJobs(List<JobKey> jobKeys) throws SchedulerException {
        try {
            return getRemoteScheduler().deleteJobs(jobKeys);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void scheduleJobs(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws SchedulerException {
        try {
            getRemoteScheduler().scheduleJobs(triggersAndJobs, replace);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void scheduleJob(JobDetail jobDetail, Set<? extends Trigger> triggersForJob, boolean replace) throws SchedulerException {
        try {
            getRemoteScheduler().scheduleJob(jobDetail, triggersForJob, replace);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean unscheduleJobs(List<TriggerKey> triggerKeys) throws SchedulerException {
        try {
            return getRemoteScheduler().unscheduleJobs(triggerKeys);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean deleteJob(JobKey jobKey) throws SchedulerException {
        try {
            return getRemoteScheduler().deleteJob(jobKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean unscheduleJob(TriggerKey triggerKey) throws SchedulerException {
        try {
            return getRemoteScheduler().unscheduleJob(triggerKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Date rescheduleJob(TriggerKey triggerKey, Trigger newTrigger) throws SchedulerException {
        try {
            return getRemoteScheduler().rescheduleJob(triggerKey, newTrigger);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void triggerJob(JobKey jobKey) throws SchedulerException {
        triggerJob(jobKey, null);
    }

    @Override // org.quartz.Scheduler
    public void triggerJob(JobKey jobKey, JobDataMap data) throws SchedulerException {
        try {
            getRemoteScheduler().triggerJob(jobKey, data);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void pauseTrigger(TriggerKey triggerKey) throws SchedulerException {
        try {
            getRemoteScheduler().pauseTrigger(triggerKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        try {
            getRemoteScheduler().pauseTriggers(matcher);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void pauseJob(JobKey jobKey) throws SchedulerException {
        try {
            getRemoteScheduler().pauseJob(jobKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void pauseJobs(GroupMatcher<JobKey> matcher) throws SchedulerException {
        try {
            getRemoteScheduler().pauseJobs(matcher);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void resumeTrigger(TriggerKey triggerKey) throws SchedulerException {
        try {
            getRemoteScheduler().resumeTrigger(triggerKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        try {
            getRemoteScheduler().resumeTriggers(matcher);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void resumeJob(JobKey jobKey) throws SchedulerException {
        try {
            getRemoteScheduler().resumeJob(jobKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void resumeJobs(GroupMatcher<JobKey> matcher) throws SchedulerException {
        try {
            getRemoteScheduler().resumeJobs(matcher);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void pauseAll() throws SchedulerException {
        try {
            getRemoteScheduler().pauseAll();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void resumeAll() throws SchedulerException {
        try {
            getRemoteScheduler().resumeAll();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public List<String> getJobGroupNames() throws SchedulerException {
        try {
            return getRemoteScheduler().getJobGroupNames();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws SchedulerException {
        try {
            return getRemoteScheduler().getJobKeys(matcher);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public List<? extends Trigger> getTriggersOfJob(JobKey jobKey) throws SchedulerException {
        try {
            return getRemoteScheduler().getTriggersOfJob(jobKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public List<String> getTriggerGroupNames() throws SchedulerException {
        try {
            return getRemoteScheduler().getTriggerGroupNames();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws SchedulerException {
        try {
            return getRemoteScheduler().getTriggerKeys(matcher);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public JobDetail getJobDetail(JobKey jobKey) throws SchedulerException {
        try {
            return getRemoteScheduler().getJobDetail(jobKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean checkExists(JobKey jobKey) throws SchedulerException {
        try {
            return getRemoteScheduler().checkExists(jobKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean checkExists(TriggerKey triggerKey) throws SchedulerException {
        try {
            return getRemoteScheduler().checkExists(triggerKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void clear() throws SchedulerException {
        try {
            getRemoteScheduler().clear();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Trigger getTrigger(TriggerKey triggerKey) throws SchedulerException {
        try {
            return getRemoteScheduler().getTrigger(triggerKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws SchedulerException {
        try {
            return getRemoteScheduler().getTriggerState(triggerKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws SchedulerException {
        try {
            getRemoteScheduler().resetTriggerFromErrorState(triggerKey);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers) throws SchedulerException {
        try {
            getRemoteScheduler().addCalendar(calName, calendar, replace, updateTriggers);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean deleteCalendar(String calName) throws SchedulerException {
        try {
            return getRemoteScheduler().deleteCalendar(calName);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Calendar getCalendar(String calName) throws SchedulerException {
        try {
            return getRemoteScheduler().getCalendar(calName);
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public List<String> getCalendarNames() throws SchedulerException {
        try {
            return getRemoteScheduler().getCalendarNames();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public Set<String> getPausedTriggerGroups() throws SchedulerException {
        try {
            return getRemoteScheduler().getPausedTriggerGroups();
        } catch (RemoteException re) {
            throw invalidateHandleCreateException("Error communicating with remote scheduler.", re);
        }
    }

    @Override // org.quartz.Scheduler
    public ListenerManager getListenerManager() throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }

    @Override // org.quartz.Scheduler
    public boolean interrupt(JobKey jobKey) throws UnableToInterruptJobException {
        try {
            return getRemoteScheduler().interrupt(jobKey);
        } catch (RemoteException re) {
            throw new UnableToInterruptJobException(invalidateHandleCreateException("Error communicating with remote scheduler.", re));
        } catch (SchedulerException se) {
            throw new UnableToInterruptJobException(se);
        }
    }

    @Override // org.quartz.Scheduler
    public boolean interrupt(String fireInstanceId) throws UnableToInterruptJobException {
        try {
            return getRemoteScheduler().interrupt(fireInstanceId);
        } catch (RemoteException re) {
            throw new UnableToInterruptJobException(invalidateHandleCreateException("Error communicating with remote scheduler.", re));
        } catch (SchedulerException se) {
            throw new UnableToInterruptJobException(se);
        }
    }

    @Override // org.quartz.Scheduler
    public void setJobFactory(JobFactory factory) throws SchedulerException {
        throw new SchedulerException("Operation not supported for remote schedulers.");
    }
}
