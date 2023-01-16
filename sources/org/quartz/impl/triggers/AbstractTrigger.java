package org.quartz.impl.triggers;

import dev.morphia.mapping.Mapper;
import java.util.Date;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.spi.OperableTrigger;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/impl/triggers/AbstractTrigger.class */
public abstract class AbstractTrigger<T extends Trigger> implements OperableTrigger {
    private static final long serialVersionUID = -3904243490805975570L;
    private String name;
    private String jobName;
    private String description;
    private JobDataMap jobDataMap;
    private String group = "DEFAULT";
    private String jobGroup = "DEFAULT";
    private boolean volatility = false;
    private String calendarName = null;
    private String fireInstanceId = null;
    private int misfireInstruction = 0;
    private int priority = 5;
    private transient TriggerKey key = null;

    @Override // org.quartz.spi.OperableTrigger
    public abstract void triggered(Calendar calendar);

    @Override // org.quartz.spi.OperableTrigger
    public abstract Date computeFirstFireTime(Calendar calendar);

    @Override // org.quartz.Trigger
    public abstract boolean mayFireAgain();

    @Override // org.quartz.Trigger
    public abstract Date getStartTime();

    @Override // org.quartz.spi.MutableTrigger
    public abstract void setStartTime(Date date);

    @Override // org.quartz.spi.MutableTrigger
    public abstract void setEndTime(Date date);

    @Override // org.quartz.Trigger
    public abstract Date getEndTime();

    @Override // org.quartz.Trigger
    public abstract Date getNextFireTime();

    @Override // org.quartz.Trigger
    public abstract Date getPreviousFireTime();

    @Override // org.quartz.Trigger
    public abstract Date getFireTimeAfter(Date date);

    @Override // org.quartz.Trigger
    public abstract Date getFinalFireTime();

    protected abstract boolean validateMisfireInstruction(int i);

    @Override // org.quartz.spi.OperableTrigger
    public abstract void updateAfterMisfire(Calendar calendar);

    @Override // org.quartz.spi.OperableTrigger
    public abstract void updateWithNewCalendar(Calendar calendar, long j);

    @Override // org.quartz.Trigger
    public abstract ScheduleBuilder<T> getScheduleBuilder();

    public AbstractTrigger() {
    }

    public AbstractTrigger(String name) {
        setName(name);
        setGroup(null);
    }

    public AbstractTrigger(String name, String group) {
        setName(name);
        setGroup(group);
    }

    public AbstractTrigger(String name, String group, String jobName, String jobGroup) {
        setName(name);
        setGroup(group);
        setJobName(jobName);
        setJobGroup(jobGroup);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Trigger name cannot be null or empty.");
        }
        this.name = name;
        this.key = null;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        if (group == null || group.trim().length() != 0) {
            if (group == null) {
                group = "DEFAULT";
            }
            this.group = group;
            this.key = null;
            return;
        }
        throw new IllegalArgumentException("Group name cannot be an empty string.");
    }

    @Override // org.quartz.spi.MutableTrigger
    public void setKey(TriggerKey key) {
        setName(key.getName());
        setGroup(key.getGroup());
        this.key = key;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        if (jobName == null || jobName.trim().length() == 0) {
            throw new IllegalArgumentException("Job name cannot be null or empty.");
        }
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return this.jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        if (jobGroup == null || jobGroup.trim().length() != 0) {
            if (jobGroup == null) {
                jobGroup = "DEFAULT";
            }
            this.jobGroup = jobGroup;
            return;
        }
        throw new IllegalArgumentException("Group name cannot be null or empty.");
    }

    @Override // org.quartz.spi.MutableTrigger
    public void setJobKey(JobKey key) {
        setJobName(key.getName());
        setJobGroup(key.getGroup());
    }

    public String getFullName() {
        return this.group + Mapper.IGNORED_FIELDNAME + this.name;
    }

    @Override // org.quartz.Trigger
    public TriggerKey getKey() {
        if (this.key == null) {
            if (getName() == null) {
                return null;
            }
            this.key = new TriggerKey(getName(), getGroup());
        }
        return this.key;
    }

    @Override // org.quartz.Trigger
    public JobKey getJobKey() {
        if (getJobName() == null) {
            return null;
        }
        return new JobKey(getJobName(), getJobGroup());
    }

    public String getFullJobName() {
        return this.jobGroup + Mapper.IGNORED_FIELDNAME + this.jobName;
    }

    @Override // org.quartz.Trigger
    public String getDescription() {
        return this.description;
    }

    @Override // org.quartz.spi.MutableTrigger
    public void setDescription(String description) {
        this.description = description;
    }

    @Override // org.quartz.spi.MutableTrigger
    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    @Override // org.quartz.Trigger
    public String getCalendarName() {
        return this.calendarName;
    }

    @Override // org.quartz.Trigger
    public JobDataMap getJobDataMap() {
        if (this.jobDataMap == null) {
            this.jobDataMap = new JobDataMap();
        }
        return this.jobDataMap;
    }

    @Override // org.quartz.spi.MutableTrigger
    public void setJobDataMap(JobDataMap jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    @Override // org.quartz.Trigger
    public int getPriority() {
        return this.priority;
    }

    @Override // org.quartz.spi.MutableTrigger
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override // org.quartz.spi.OperableTrigger
    public Trigger.CompletedExecutionInstruction executionComplete(JobExecutionContext context, JobExecutionException result) {
        if (result != null && result.refireImmediately()) {
            return Trigger.CompletedExecutionInstruction.RE_EXECUTE_JOB;
        }
        if (result != null && result.unscheduleFiringTrigger()) {
            return Trigger.CompletedExecutionInstruction.SET_TRIGGER_COMPLETE;
        }
        if (result != null && result.unscheduleAllTriggers()) {
            return Trigger.CompletedExecutionInstruction.SET_ALL_JOB_TRIGGERS_COMPLETE;
        }
        if (!mayFireAgain()) {
            return Trigger.CompletedExecutionInstruction.DELETE_TRIGGER;
        }
        return Trigger.CompletedExecutionInstruction.NOOP;
    }

    @Override // org.quartz.spi.MutableTrigger
    public void setMisfireInstruction(int misfireInstruction) {
        if (!validateMisfireInstruction(misfireInstruction)) {
            throw new IllegalArgumentException("The misfire instruction code is invalid for this type of trigger.");
        }
        this.misfireInstruction = misfireInstruction;
    }

    @Override // org.quartz.Trigger
    public int getMisfireInstruction() {
        return this.misfireInstruction;
    }

    @Override // org.quartz.spi.OperableTrigger
    public void validate() throws SchedulerException {
        if (this.name == null) {
            throw new SchedulerException("Trigger's name cannot be null");
        } else if (this.group == null) {
            throw new SchedulerException("Trigger's group cannot be null");
        } else if (this.jobName == null) {
            throw new SchedulerException("Trigger's related Job's name cannot be null");
        } else if (this.jobGroup == null) {
            throw new SchedulerException("Trigger's related Job's group cannot be null");
        }
    }

    @Override // org.quartz.spi.OperableTrigger
    public void setFireInstanceId(String id) {
        this.fireInstanceId = id;
    }

    @Override // org.quartz.spi.OperableTrigger
    public String getFireInstanceId() {
        return this.fireInstanceId;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Trigger '" + getFullName() + "':  triggerClass: '" + getClass().getName() + " calendar: '" + getCalendarName() + "' misfireInstruction: " + getMisfireInstruction() + " nextFireTime: " + getNextFireTime();
    }

    @Override // org.quartz.Trigger
    public int compareTo(Trigger other) {
        if (other.getKey() == null && getKey() == null) {
            return 0;
        }
        if (other.getKey() == null) {
            return -1;
        }
        if (getKey() == null) {
            return 1;
        }
        return getKey().compareTo((Key) other.getKey());
    }

    @Override // org.quartz.Trigger, java.lang.Object
    public boolean equals(Object o) {
        if (!(o instanceof Trigger)) {
            return false;
        }
        Trigger other = (Trigger) o;
        return (other.getKey() == null || getKey() == null || !getKey().equals(other.getKey())) ? false : true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (getKey() == null) {
            return hashCode();
        }
        return getKey().hashCode();
    }

    @Override // org.quartz.spi.MutableTrigger, java.lang.Object
    public Object clone() {
        try {
            AbstractTrigger<?> copy = (AbstractTrigger) clone();
            if (this.jobDataMap != null) {
                copy.jobDataMap = (JobDataMap) this.jobDataMap.clone();
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new IncompatibleClassChangeError("Not Cloneable.");
        }
    }

    @Override // org.quartz.Trigger
    public TriggerBuilder<T> getTriggerBuilder() {
        return (TriggerBuilder<T>) TriggerBuilder.newTrigger().forJob(getJobKey()).modifiedByCalendar(getCalendarName()).usingJobData(getJobDataMap()).withDescription(getDescription()).endAt(getEndTime()).withIdentity(getKey()).withPriority(getPriority()).startAt(getStartTime()).withSchedule(getScheduleBuilder());
    }
}
