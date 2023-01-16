package org.quartz;

import java.util.Date;
import org.quartz.Trigger;
import org.quartz.spi.MutableTrigger;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/TriggerBuilder.class */
public class TriggerBuilder<T extends Trigger> {
    private TriggerKey key;
    private String description;
    private Date endTime;
    private String calendarName;
    private JobKey jobKey;
    private Date startTime = new Date();
    private int priority = 5;
    private JobDataMap jobDataMap = new JobDataMap();
    private ScheduleBuilder<?> scheduleBuilder = null;

    private TriggerBuilder() {
    }

    public static TriggerBuilder<Trigger> newTrigger() {
        return new TriggerBuilder<>();
    }

    public T build() {
        if (this.scheduleBuilder == null) {
            this.scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        }
        MutableTrigger trig = this.scheduleBuilder.build();
        trig.setCalendarName(this.calendarName);
        trig.setDescription(this.description);
        trig.setStartTime(this.startTime);
        trig.setEndTime(this.endTime);
        if (this.key == null) {
            this.key = new TriggerKey(Key.createUniqueName(null), null);
        }
        trig.setKey(this.key);
        if (this.jobKey != null) {
            trig.setJobKey(this.jobKey);
        }
        trig.setPriority(this.priority);
        if (!this.jobDataMap.isEmpty()) {
            trig.setJobDataMap(this.jobDataMap);
        }
        return trig;
    }

    public TriggerBuilder<T> withIdentity(String name) {
        this.key = new TriggerKey(name, null);
        return this;
    }

    public TriggerBuilder<T> withIdentity(String name, String group) {
        this.key = new TriggerKey(name, group);
        return this;
    }

    public TriggerBuilder<T> withIdentity(TriggerKey triggerKey) {
        this.key = triggerKey;
        return this;
    }

    public TriggerBuilder<T> withDescription(String triggerDescription) {
        this.description = triggerDescription;
        return this;
    }

    public TriggerBuilder<T> withPriority(int triggerPriority) {
        this.priority = triggerPriority;
        return this;
    }

    public TriggerBuilder<T> modifiedByCalendar(String calName) {
        this.calendarName = calName;
        return this;
    }

    public TriggerBuilder<T> startAt(Date triggerStartTime) {
        this.startTime = triggerStartTime;
        return this;
    }

    public TriggerBuilder<T> startNow() {
        this.startTime = new Date();
        return this;
    }

    public TriggerBuilder<T> endAt(Date triggerEndTime) {
        this.endTime = triggerEndTime;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.quartz.TriggerBuilder<T extends org.quartz.Trigger> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.quartz.ScheduleBuilder<SBT extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <SBT extends T> TriggerBuilder<SBT> withSchedule(ScheduleBuilder<SBT> schedBuilder) {
        this.scheduleBuilder = schedBuilder;
        return this;
    }

    public TriggerBuilder<T> forJob(JobKey keyOfJobToFire) {
        this.jobKey = keyOfJobToFire;
        return this;
    }

    public TriggerBuilder<T> forJob(String jobName) {
        this.jobKey = new JobKey(jobName, null);
        return this;
    }

    public TriggerBuilder<T> forJob(String jobName, String jobGroup) {
        this.jobKey = new JobKey(jobName, jobGroup);
        return this;
    }

    public TriggerBuilder<T> forJob(JobDetail jobDetail) {
        JobKey k = jobDetail.getKey();
        if (k.getName() == null) {
            throw new IllegalArgumentException("The given job has not yet had a name assigned to it.");
        }
        this.jobKey = k;
        return this;
    }

    public TriggerBuilder<T> usingJobData(String dataKey, String value) {
        this.jobDataMap.put(dataKey, value);
        return this;
    }

    public TriggerBuilder<T> usingJobData(String dataKey, Integer value) {
        this.jobDataMap.put(dataKey, (Object) value);
        return this;
    }

    public TriggerBuilder<T> usingJobData(String dataKey, Long value) {
        this.jobDataMap.put(dataKey, (Object) value);
        return this;
    }

    public TriggerBuilder<T> usingJobData(String dataKey, Float value) {
        this.jobDataMap.put(dataKey, (Object) value);
        return this;
    }

    public TriggerBuilder<T> usingJobData(String dataKey, Double value) {
        this.jobDataMap.put(dataKey, (Object) value);
        return this;
    }

    public TriggerBuilder<T> usingJobData(String dataKey, Boolean value) {
        this.jobDataMap.put(dataKey, (Object) value);
        return this;
    }

    public TriggerBuilder<T> usingJobData(JobDataMap newJobDataMap) {
        for (String dataKey : this.jobDataMap.keySet()) {
            newJobDataMap.put(dataKey, this.jobDataMap.get(dataKey));
        }
        this.jobDataMap = newJobDataMap;
        return this;
    }
}
