package org.quartz;

/* loaded from: grasscutter.jar:org/quartz/SimpleTrigger.class */
public interface SimpleTrigger extends Trigger {
    public static final long serialVersionUID = -3735980074222850397L;
    public static final int MISFIRE_INSTRUCTION_FIRE_NOW = 1;
    public static final int MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT = 2;
    public static final int MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_REMAINING_REPEAT_COUNT = 3;
    public static final int MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT = 4;
    public static final int MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_EXISTING_COUNT = 5;
    public static final int REPEAT_INDEFINITELY = -1;

    int getRepeatCount();

    long getRepeatInterval();

    int getTimesTriggered();

    @Override // org.quartz.Trigger
    TriggerBuilder<SimpleTrigger> getTriggerBuilder();
}
