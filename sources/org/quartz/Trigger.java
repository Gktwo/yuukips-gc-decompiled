package org.quartz;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/Trigger.class */
public interface Trigger extends Serializable, Cloneable, Comparable<Trigger> {
    public static final long serialVersionUID = -3904243490805975570L;
    public static final int MISFIRE_INSTRUCTION_SMART_POLICY = 0;
    public static final int MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY = -1;
    public static final int DEFAULT_PRIORITY = 5;

    /* loaded from: grasscutter.jar:org/quartz/Trigger$CompletedExecutionInstruction.class */
    public enum CompletedExecutionInstruction {
        NOOP,
        RE_EXECUTE_JOB,
        SET_TRIGGER_COMPLETE,
        DELETE_TRIGGER,
        SET_ALL_JOB_TRIGGERS_COMPLETE,
        SET_TRIGGER_ERROR,
        SET_ALL_JOB_TRIGGERS_ERROR
    }

    /* loaded from: grasscutter.jar:org/quartz/Trigger$TriggerState.class */
    public enum TriggerState {
        NONE,
        NORMAL,
        PAUSED,
        COMPLETE,
        ERROR,
        BLOCKED
    }

    TriggerKey getKey();

    JobKey getJobKey();

    String getDescription();

    String getCalendarName();

    JobDataMap getJobDataMap();

    int getPriority();

    boolean mayFireAgain();

    Date getStartTime();

    Date getEndTime();

    Date getNextFireTime();

    Date getPreviousFireTime();

    Date getFireTimeAfter(Date date);

    Date getFinalFireTime();

    int getMisfireInstruction();

    TriggerBuilder<? extends Trigger> getTriggerBuilder();

    ScheduleBuilder<? extends Trigger> getScheduleBuilder();

    @Override // java.lang.Object
    boolean equals(Object obj);

    int compareTo(Trigger trigger);

    /* loaded from: grasscutter.jar:org/quartz/Trigger$TriggerTimeComparator.class */
    public static class TriggerTimeComparator implements Comparator<Trigger>, Serializable {
        private static final long serialVersionUID = -3904243490805975570L;

        public static int compare(Date nextFireTime1, int priority1, TriggerKey key1, Date nextFireTime2, int priority2, TriggerKey key2) {
            if (!(nextFireTime1 == null && nextFireTime2 == null)) {
                if (nextFireTime1 == null) {
                    return 1;
                }
                if (nextFireTime2 == null || nextFireTime1.before(nextFireTime2)) {
                    return -1;
                }
                if (nextFireTime1.after(nextFireTime2)) {
                    return 1;
                }
            }
            int comp = priority2 - priority1;
            if (comp != 0) {
                return comp;
            }
            return key1.compareTo((Key) key2);
        }

        public int compare(Trigger t1, Trigger t2) {
            return compare(t1.getNextFireTime(), t1.getPriority(), t1.getKey(), t2.getNextFireTime(), t2.getPriority(), t2.getKey());
        }
    }
}
