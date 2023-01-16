package org.quartz.core;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.NotCompliantMBeanException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.StandardMBean;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.core.jmx.JobDetailSupport;
import org.quartz.core.jmx.JobExecutionContextSupport;
import org.quartz.core.jmx.QuartzSchedulerMBean;
import org.quartz.core.jmx.TriggerSupport;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.AbstractTrigger;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/core/QuartzSchedulerMBeanImpl.class */
public class QuartzSchedulerMBeanImpl extends StandardMBean implements NotificationEmitter, QuartzSchedulerMBean, JobListener, SchedulerListener {
    private final QuartzScheduler scheduler;
    private static final SampledStatistics NULL_SAMPLED_STATISTICS = new NullSampledStatisticsImpl();
    private static final MBeanNotificationInfo[] NOTIFICATION_INFO = {new MBeanNotificationInfo(new String[]{QuartzSchedulerMBean.SCHEDULER_STARTED, QuartzSchedulerMBean.SCHEDULER_PAUSED, QuartzSchedulerMBean.SCHEDULER_SHUTDOWN}, Notification.class.getName(), "QuartzScheduler JMX Event")};
    protected final Emitter emitter = new Emitter();
    protected final AtomicLong sequenceNumber = new AtomicLong();
    private SampledStatistics sampledStatistics = NULL_SAMPLED_STATISTICS;
    private boolean sampledStatisticsEnabled = false;

    /* access modifiers changed from: protected */
    public QuartzSchedulerMBeanImpl(QuartzScheduler scheduler) throws NotCompliantMBeanException {
        super(QuartzSchedulerMBean.class);
        this.scheduler = scheduler;
        this.scheduler.addInternalJobListener(this);
        this.scheduler.addInternalSchedulerListener(this);
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public TabularData getCurrentlyExecutingJobs() throws Exception {
        try {
            return JobExecutionContextSupport.toTabularData(this.scheduler.getCurrentlyExecutingJobs());
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public TabularData getAllJobDetails() throws Exception {
        try {
            List<JobDetail> detailList = new ArrayList<>();
            for (String jobGroupName : this.scheduler.getJobGroupNames()) {
                for (JobKey jobKey : this.scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName))) {
                    detailList.add(this.scheduler.getJobDetail(jobKey));
                }
            }
            return JobDetailSupport.toTabularData((JobDetail[]) detailList.toArray(new JobDetail[detailList.size()]));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public List<CompositeData> getAllTriggers() throws Exception {
        try {
            List<Trigger> triggerList = new ArrayList<>();
            for (String triggerGroupName : this.scheduler.getTriggerGroupNames()) {
                for (TriggerKey triggerKey : this.scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(triggerGroupName))) {
                    triggerList.add(this.scheduler.getTrigger(triggerKey));
                }
            }
            return TriggerSupport.toCompositeList(triggerList);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void addJob(CompositeData jobDetail, boolean replace) throws Exception {
        try {
            this.scheduler.addJob(JobDetailSupport.newJobDetail(jobDetail), replace);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    private static void invokeSetter(Object target, String attribute, Object value) throws Exception {
        Method setter = findMethod(target.getClass(), "set" + Character.toUpperCase(attribute.charAt(0)) + attribute.substring(1), new Class[]{value.getClass()});
        if (setter != null) {
            setter.invoke(target, value);
            return;
        }
        throw new Exception("Unable to find setter for attribute '" + attribute + "' and value '" + value + "'");
    }

    private static Class<?> getWrapperIfPrimitive(Class<?> c) {
        Class<?> result = c;
        try {
            Field f = c.getField("TYPE");
            f.setAccessible(true);
            result = (Class) f.get(null);
        } catch (Exception e) {
        }
        return result;
    }

    private static Method findMethod(Class<?> targetType, String methodName, Class<?>[] argTypes) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(targetType);
        if (beanInfo == null) {
            return null;
        }
        for (MethodDescriptor methodDesc : beanInfo.getMethodDescriptors()) {
            Method method = methodDesc.getMethod();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (methodName.equals(method.getName()) && argTypes.length == parameterTypes.length) {
                boolean matchedArgTypes = true;
                int i = 0;
                while (true) {
                    if (i >= argTypes.length) {
                        break;
                    } else if (getWrapperIfPrimitive(argTypes[i]) != parameterTypes[i]) {
                        matchedArgTypes = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (matchedArgTypes) {
                    return method;
                }
            }
        }
        return null;
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void scheduleBasicJob(Map<String, Object> jobDetailInfo, Map<String, Object> triggerInfo) throws Exception {
        try {
            JobDetail jobDetail = JobDetailSupport.newJobDetail(jobDetailInfo);
            OperableTrigger trigger = TriggerSupport.newTrigger(triggerInfo);
            this.scheduler.deleteJob(jobDetail.getKey());
            this.scheduler.scheduleJob(jobDetail, trigger);
        } catch (ParseException pe) {
            throw pe;
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void scheduleJob(Map<String, Object> abstractJobInfo, Map<String, Object> abstractTriggerInfo) throws Exception {
        try {
            String triggerClassName = (String) abstractTriggerInfo.remove("triggerClass");
            if (triggerClassName == null) {
                throw new IllegalArgumentException("No triggerClass specified");
            }
            Trigger trigger = (Trigger) Class.forName(triggerClassName).newInstance();
            String jobDetailClassName = (String) abstractJobInfo.remove("jobDetailClass");
            if (jobDetailClassName == null) {
                throw new IllegalArgumentException("No jobDetailClass specified");
            }
            JobDetail jobDetail = (JobDetail) Class.forName(jobDetailClassName).newInstance();
            String jobClassName = (String) abstractJobInfo.remove("jobClass");
            if (jobClassName == null) {
                throw new IllegalArgumentException("No jobClass specified");
            }
            abstractJobInfo.put("jobClass", Class.forName(jobClassName));
            for (Map.Entry<String, Object> entry : abstractTriggerInfo.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ("jobDataMap".equals(key)) {
                    value = new JobDataMap((Map) value);
                }
                invokeSetter(trigger, key, value);
            }
            for (Map.Entry<String, Object> entry2 : abstractJobInfo.entrySet()) {
                String key2 = entry2.getKey();
                Object value2 = entry2.getValue();
                if ("jobDataMap".equals(key2)) {
                    value2 = new JobDataMap((Map) value2);
                }
                invokeSetter(jobDetail, key2, value2);
            }
            AbstractTrigger<?> at = (AbstractTrigger) trigger;
            at.setKey(new TriggerKey(at.getName(), at.getGroup()));
            Date startDate = at.getStartTime();
            if (startDate == null || startDate.before(new Date())) {
                at.setStartTime(new Date());
            }
            this.scheduler.deleteJob(jobDetail.getKey());
            this.scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void scheduleJob(String jobName, String jobGroup, Map<String, Object> abstractTriggerInfo) throws Exception {
        try {
            JobKey jobKey = new JobKey(jobName, jobGroup);
            if (this.scheduler.getJobDetail(jobKey) == null) {
                throw new IllegalArgumentException("No such job '" + jobKey + "'");
            }
            String triggerClassName = (String) abstractTriggerInfo.remove("triggerClass");
            if (triggerClassName == null) {
                throw new IllegalArgumentException("No triggerClass specified");
            }
            Trigger trigger = (Trigger) Class.forName(triggerClassName).newInstance();
            for (Map.Entry<String, Object> entry : abstractTriggerInfo.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ("jobDataMap".equals(key)) {
                    value = new JobDataMap((Map) value);
                }
                invokeSetter(trigger, key, value);
            }
            AbstractTrigger<?> at = (AbstractTrigger) trigger;
            at.setKey(new TriggerKey(at.getName(), at.getGroup()));
            Date startDate = at.getStartTime();
            if (startDate == null || startDate.before(new Date())) {
                at.setStartTime(new Date());
            }
            this.scheduler.scheduleJob(trigger);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void addJob(Map<String, Object> abstractJobInfo, boolean replace) throws Exception {
        try {
            String jobDetailClassName = (String) abstractJobInfo.remove("jobDetailClass");
            if (jobDetailClassName == null) {
                throw new IllegalArgumentException("No jobDetailClass specified");
            }
            JobDetail jobDetail = (JobDetail) Class.forName(jobDetailClassName).newInstance();
            String jobClassName = (String) abstractJobInfo.remove("jobClass");
            if (jobClassName == null) {
                throw new IllegalArgumentException("No jobClass specified");
            }
            abstractJobInfo.put("jobClass", Class.forName(jobClassName));
            for (Map.Entry<String, Object> entry : abstractJobInfo.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ("jobDataMap".equals(key)) {
                    value = new JobDataMap((Map) value);
                }
                invokeSetter(jobDetail, key, value);
            }
            this.scheduler.addJob(jobDetail, replace);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    private Exception newPlainException(Exception e) {
        String type = e.getClass().getName();
        if (type.startsWith("java.") || type.startsWith("javax.")) {
            return e;
        }
        Exception result = new Exception(e.getMessage());
        result.setStackTrace(e.getStackTrace());
        return result;
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void deleteCalendar(String calendarName) throws Exception {
        try {
            this.scheduler.deleteCalendar(calendarName);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public boolean deleteJob(String jobName, String jobGroupName) throws Exception {
        try {
            return this.scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public List<String> getCalendarNames() throws Exception {
        try {
            return this.scheduler.getCalendarNames();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public CompositeData getJobDetail(String jobName, String jobGroupName) throws Exception {
        try {
            return JobDetailSupport.toCompositeData(this.scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName)));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public List<String> getJobGroupNames() throws Exception {
        try {
            return this.scheduler.getJobGroupNames();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public List<String> getJobNames(String groupName) throws Exception {
        try {
            List<String> jobNames = new ArrayList<>();
            for (JobKey key : this.scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                jobNames.add(key.getName());
            }
            return jobNames;
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public String getJobStoreClassName() {
        return this.scheduler.getJobStoreClass().getName();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public Set<String> getPausedTriggerGroups() throws Exception {
        try {
            return this.scheduler.getPausedTriggerGroups();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public CompositeData getTrigger(String name, String groupName) throws Exception {
        try {
            return TriggerSupport.toCompositeData(this.scheduler.getTrigger(TriggerKey.triggerKey(name, groupName)));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public List<String> getTriggerGroupNames() throws Exception {
        try {
            return this.scheduler.getTriggerGroupNames();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public List<String> getTriggerNames(String groupName) throws Exception {
        try {
            List<String> triggerNames = new ArrayList<>();
            for (TriggerKey key : this.scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(groupName))) {
                triggerNames.add(key.getName());
            }
            return triggerNames;
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public String getTriggerState(String triggerName, String triggerGroupName) throws Exception {
        try {
            return this.scheduler.getTriggerState(TriggerKey.triggerKey(triggerName, triggerGroupName)).name();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public List<CompositeData> getTriggersOfJob(String jobName, String jobGroupName) throws Exception {
        try {
            return TriggerSupport.toCompositeList(this.scheduler.getTriggersOfJob(JobKey.jobKey(jobName, jobGroupName)));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public boolean interruptJob(String jobName, String jobGroupName) throws Exception {
        try {
            return this.scheduler.interrupt(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public boolean interruptJob(String fireInstanceId) throws Exception {
        try {
            return this.scheduler.interrupt(fireInstanceId);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public Date scheduleJob(String jobName, String jobGroup, String triggerName, String triggerGroup) throws Exception {
        try {
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            JobDetail jobDetail = this.scheduler.getJobDetail(jobKey);
            if (jobDetail == null) {
                throw new IllegalArgumentException("No such job: " + jobKey);
            }
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
            Trigger trigger = this.scheduler.getTrigger(triggerKey);
            if (trigger != null) {
                return this.scheduler.scheduleJob(jobDetail, trigger);
            }
            throw new IllegalArgumentException("No such trigger: " + triggerKey);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public boolean unscheduleJob(String triggerName, String triggerGroup) throws Exception {
        try {
            return this.scheduler.unscheduleJob(TriggerKey.triggerKey(triggerName, triggerGroup));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void clear() throws Exception {
        try {
            this.scheduler.clear();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public String getVersion() {
        return this.scheduler.getVersion();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public boolean isShutdown() {
        return this.scheduler.isShutdown();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public boolean isStarted() {
        return this.scheduler.isStarted();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void start() throws Exception {
        try {
            this.scheduler.start();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void shutdown() {
        this.scheduler.shutdown();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void standby() {
        this.scheduler.standby();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public boolean isStandbyMode() {
        return this.scheduler.isInStandbyMode();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public String getSchedulerName() {
        return this.scheduler.getSchedulerName();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public String getSchedulerInstanceId() {
        return this.scheduler.getSchedulerInstanceId();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public String getThreadPoolClassName() {
        return this.scheduler.getThreadPoolClass().getName();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public int getThreadPoolSize() {
        return this.scheduler.getThreadPoolSize();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseJob(String jobName, String jobGroup) throws Exception {
        try {
            this.scheduler.pauseJob(JobKey.jobKey(jobName, jobGroup));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    public void pauseJobs(GroupMatcher<JobKey> matcher) throws Exception {
        try {
            this.scheduler.pauseJobs(matcher);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseJobGroup(String jobGroup) throws Exception {
        pauseJobs(GroupMatcher.groupEquals(jobGroup));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseJobsStartingWith(String jobGroupPrefix) throws Exception {
        pauseJobs(GroupMatcher.groupStartsWith(jobGroupPrefix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseJobsEndingWith(String jobGroupSuffix) throws Exception {
        pauseJobs(GroupMatcher.groupEndsWith(jobGroupSuffix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseJobsContaining(String jobGroupToken) throws Exception {
        pauseJobs(GroupMatcher.groupContains(jobGroupToken));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseJobsAll() throws Exception {
        pauseJobs(GroupMatcher.anyJobGroup());
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseAllTriggers() throws Exception {
        try {
            this.scheduler.pauseAll();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    private void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws Exception {
        try {
            this.scheduler.pauseTriggers(matcher);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseTriggerGroup(String triggerGroup) throws Exception {
        pauseTriggers(GroupMatcher.groupEquals(triggerGroup));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseTriggersStartingWith(String triggerGroupPrefix) throws Exception {
        pauseTriggers(GroupMatcher.groupStartsWith(triggerGroupPrefix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseTriggersEndingWith(String triggerGroupSuffix) throws Exception {
        pauseTriggers(GroupMatcher.groupEndsWith(triggerGroupSuffix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseTriggersContaining(String triggerGroupToken) throws Exception {
        pauseTriggers(GroupMatcher.groupContains(triggerGroupToken));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseTriggersAll() throws Exception {
        pauseTriggers(GroupMatcher.anyTriggerGroup());
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void pauseTrigger(String triggerName, String triggerGroup) throws Exception {
        try {
            this.scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeAllTriggers() throws Exception {
        try {
            this.scheduler.resumeAll();
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeJob(String jobName, String jobGroup) throws Exception {
        try {
            this.scheduler.resumeJob(JobKey.jobKey(jobName, jobGroup));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    public void resumeJobs(GroupMatcher<JobKey> matcher) throws Exception {
        try {
            this.scheduler.resumeJobs(matcher);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeJobGroup(String jobGroup) throws Exception {
        resumeJobs(GroupMatcher.groupEquals(jobGroup));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeJobsStartingWith(String jobGroupPrefix) throws Exception {
        resumeJobs(GroupMatcher.groupStartsWith(jobGroupPrefix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeJobsEndingWith(String jobGroupSuffix) throws Exception {
        resumeJobs(GroupMatcher.groupEndsWith(jobGroupSuffix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeJobsContaining(String jobGroupToken) throws Exception {
        resumeJobs(GroupMatcher.groupContains(jobGroupToken));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeJobsAll() throws Exception {
        resumeJobs(GroupMatcher.anyJobGroup());
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeTrigger(String triggerName, String triggerGroup) throws Exception {
        try {
            this.scheduler.resumeTrigger(TriggerKey.triggerKey(triggerName, triggerGroup));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    private void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws Exception {
        try {
            this.scheduler.resumeTriggers(matcher);
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeTriggerGroup(String triggerGroup) throws Exception {
        resumeTriggers(GroupMatcher.groupEquals(triggerGroup));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeTriggersStartingWith(String triggerGroupPrefix) throws Exception {
        resumeTriggers(GroupMatcher.groupStartsWith(triggerGroupPrefix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeTriggersEndingWith(String triggerGroupSuffix) throws Exception {
        resumeTriggers(GroupMatcher.groupEndsWith(triggerGroupSuffix));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeTriggersContaining(String triggerGroupToken) throws Exception {
        resumeTriggers(GroupMatcher.groupContains(triggerGroupToken));
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void resumeTriggersAll() throws Exception {
        resumeTriggers(GroupMatcher.anyTriggerGroup());
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void triggerJob(String jobName, String jobGroup, Map<String, String> jobDataMap) throws Exception {
        try {
            this.scheduler.triggerJob(JobKey.jobKey(jobName, jobGroup), new JobDataMap(jobDataMap));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    public void triggerJob(CompositeData trigger) throws Exception {
        try {
            this.scheduler.triggerJob(TriggerSupport.newTrigger(trigger));
        } catch (Exception e) {
            throw newPlainException(e);
        }
    }

    @Override // org.quartz.SchedulerListener
    public void jobAdded(JobDetail jobDetail) {
        sendNotification(QuartzSchedulerMBean.JOB_ADDED, JobDetailSupport.toCompositeData(jobDetail));
    }

    @Override // org.quartz.SchedulerListener
    public void jobDeleted(JobKey jobKey) {
        Map<String, String> map = new HashMap<>();
        map.put("jobName", jobKey.getName());
        map.put("jobGroup", jobKey.getGroup());
        sendNotification(QuartzSchedulerMBean.JOB_DELETED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void jobScheduled(Trigger trigger) {
        sendNotification(QuartzSchedulerMBean.JOB_SCHEDULED, TriggerSupport.toCompositeData(trigger));
    }

    @Override // org.quartz.SchedulerListener
    public void jobUnscheduled(TriggerKey triggerKey) {
        Map<String, String> map = new HashMap<>();
        map.put("triggerName", triggerKey.getName());
        map.put("triggerGroup", triggerKey.getGroup());
        sendNotification(QuartzSchedulerMBean.JOB_UNSCHEDULED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void schedulingDataCleared() {
        sendNotification(QuartzSchedulerMBean.SCHEDULING_DATA_CLEARED);
    }

    @Override // org.quartz.SchedulerListener
    public void jobPaused(JobKey jobKey) {
        Map<String, String> map = new HashMap<>();
        map.put("jobName", jobKey.getName());
        map.put("jobGroup", jobKey.getGroup());
        sendNotification(QuartzSchedulerMBean.JOBS_PAUSED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void jobsPaused(String jobGroup) {
        Map<String, String> map = new HashMap<>();
        map.put("jobName", null);
        map.put("jobGroup", jobGroup);
        sendNotification(QuartzSchedulerMBean.JOBS_PAUSED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void jobsResumed(String jobGroup) {
        Map<String, String> map = new HashMap<>();
        map.put("jobName", null);
        map.put("jobGroup", jobGroup);
        sendNotification(QuartzSchedulerMBean.JOBS_RESUMED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void jobResumed(JobKey jobKey) {
        Map<String, String> map = new HashMap<>();
        map.put("jobName", jobKey.getName());
        map.put("jobGroup", jobKey.getGroup());
        sendNotification(QuartzSchedulerMBean.JOBS_RESUMED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerError(String msg, SchedulerException cause) {
        sendNotification(QuartzSchedulerMBean.SCHEDULER_ERROR, cause.getMessage());
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerStarted() {
        sendNotification(QuartzSchedulerMBean.SCHEDULER_STARTED);
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerStarting() {
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerInStandbyMode() {
        sendNotification(QuartzSchedulerMBean.SCHEDULER_PAUSED);
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerShutdown() {
        this.scheduler.removeInternalSchedulerListener(this);
        this.scheduler.removeInternalJobListener(getName());
        sendNotification(QuartzSchedulerMBean.SCHEDULER_SHUTDOWN);
    }

    @Override // org.quartz.SchedulerListener
    public void schedulerShuttingdown() {
    }

    @Override // org.quartz.SchedulerListener
    public void triggerFinalized(Trigger trigger) {
        Map<String, String> map = new HashMap<>();
        map.put("triggerName", trigger.getKey().getName());
        map.put("triggerGroup", trigger.getKey().getGroup());
        sendNotification(QuartzSchedulerMBean.TRIGGER_FINALIZED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void triggersPaused(String triggerGroup) {
        Map<String, String> map = new HashMap<>();
        map.put("triggerName", null);
        map.put("triggerGroup", triggerGroup);
        sendNotification(QuartzSchedulerMBean.TRIGGERS_PAUSED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void triggerPaused(TriggerKey triggerKey) {
        Map<String, String> map = new HashMap<>();
        if (triggerKey != null) {
            map.put("triggerName", triggerKey.getName());
            map.put("triggerGroup", triggerKey.getGroup());
        }
        sendNotification(QuartzSchedulerMBean.TRIGGERS_PAUSED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void triggersResumed(String triggerGroup) {
        Map<String, String> map = new HashMap<>();
        map.put("triggerName", null);
        map.put("triggerGroup", triggerGroup);
        sendNotification(QuartzSchedulerMBean.TRIGGERS_RESUMED, map);
    }

    @Override // org.quartz.SchedulerListener
    public void triggerResumed(TriggerKey triggerKey) {
        Map<String, String> map = new HashMap<>();
        if (triggerKey != null) {
            map.put("triggerName", triggerKey.getName());
            map.put("triggerGroup", triggerKey.getGroup());
        }
        sendNotification(QuartzSchedulerMBean.TRIGGERS_RESUMED, map);
    }

    @Override // org.quartz.JobListener
    public String getName() {
        return "QuartzSchedulerMBeanImpl.listener";
    }

    @Override // org.quartz.JobListener
    public void jobExecutionVetoed(JobExecutionContext context) {
        try {
            sendNotification(QuartzSchedulerMBean.JOB_EXECUTION_VETOED, JobExecutionContextSupport.toCompositeData(context));
        } catch (Exception e) {
            throw new RuntimeException(newPlainException(e));
        }
    }

    @Override // org.quartz.JobListener
    public void jobToBeExecuted(JobExecutionContext context) {
        try {
            sendNotification(QuartzSchedulerMBean.JOB_TO_BE_EXECUTED, JobExecutionContextSupport.toCompositeData(context));
        } catch (Exception e) {
            throw new RuntimeException(newPlainException(e));
        }
    }

    @Override // org.quartz.JobListener
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        try {
            sendNotification(QuartzSchedulerMBean.JOB_WAS_EXECUTED, JobExecutionContextSupport.toCompositeData(context));
        } catch (Exception e) {
            throw new RuntimeException(newPlainException(e));
        }
    }

    public void sendNotification(String eventType) {
        sendNotification(eventType, null, null);
    }

    public void sendNotification(String eventType, Object data) {
        sendNotification(eventType, data, null);
    }

    public void sendNotification(String eventType, Object data, String msg) {
        Notification notif = new Notification(eventType, this, this.sequenceNumber.incrementAndGet(), System.currentTimeMillis(), msg);
        if (data != null) {
            notif.setUserData(data);
        }
        this.emitter.sendNotification(notif);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/quartz/core/QuartzSchedulerMBeanImpl$Emitter.class */
    public class Emitter extends NotificationBroadcasterSupport {
        private Emitter() {
        }

        public MBeanNotificationInfo[] getNotificationInfo() {
            return QuartzSchedulerMBeanImpl.this.getNotificationInfo();
        }
    }

    public void addNotificationListener(NotificationListener notif, NotificationFilter filter, Object callBack) {
        this.emitter.addNotificationListener(notif, filter, callBack);
    }

    public MBeanNotificationInfo[] getNotificationInfo() {
        return NOTIFICATION_INFO;
    }

    public void removeNotificationListener(NotificationListener listener) throws ListenerNotFoundException {
        this.emitter.removeNotificationListener(listener);
    }

    public void removeNotificationListener(NotificationListener notif, NotificationFilter filter, Object callBack) throws ListenerNotFoundException {
        this.emitter.removeNotificationListener(notif, filter, callBack);
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public synchronized boolean isSampledStatisticsEnabled() {
        return this.sampledStatisticsEnabled;
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public void setSampledStatisticsEnabled(boolean enabled) {
        if (enabled != this.sampledStatisticsEnabled) {
            this.sampledStatisticsEnabled = enabled;
            if (enabled) {
                this.sampledStatistics = new SampledStatisticsImpl(this.scheduler);
            } else {
                this.sampledStatistics.shutdown();
                this.sampledStatistics = NULL_SAMPLED_STATISTICS;
            }
            sendNotification(QuartzSchedulerMBean.SAMPLED_STATISTICS_ENABLED, Boolean.valueOf(enabled));
        }
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public long getJobsCompletedMostRecentSample() {
        return this.sampledStatistics.getJobsCompletedMostRecentSample();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public long getJobsExecutedMostRecentSample() {
        return this.sampledStatistics.getJobsExecutingMostRecentSample();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public long getJobsScheduledMostRecentSample() {
        return this.sampledStatistics.getJobsScheduledMostRecentSample();
    }

    @Override // org.quartz.core.jmx.QuartzSchedulerMBean
    public Map<String, Long> getPerformanceMetrics() {
        Map<String, Long> result = new HashMap<>();
        result.put("JobsCompleted", Long.valueOf(getJobsCompletedMostRecentSample()));
        result.put("JobsExecuted", Long.valueOf(getJobsExecutedMostRecentSample()));
        result.put("JobsScheduled", Long.valueOf(getJobsScheduledMostRecentSample()));
        return result;
    }
}
