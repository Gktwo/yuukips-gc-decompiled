package org.quartz;

import java.util.Set;
import org.quartz.DateBuilder;

/* loaded from: grasscutter.jar:org/quartz/DailyTimeIntervalTrigger.class */
public interface DailyTimeIntervalTrigger extends Trigger {
    public static final int REPEAT_INDEFINITELY = -1;
    public static final int MISFIRE_INSTRUCTION_FIRE_ONCE_NOW = 1;
    public static final int MISFIRE_INSTRUCTION_DO_NOTHING = 2;

    DateBuilder.IntervalUnit getRepeatIntervalUnit();

    int getRepeatCount();

    int getRepeatInterval();

    TimeOfDay getStartTimeOfDay();

    TimeOfDay getEndTimeOfDay();

    Set<Integer> getDaysOfWeek();

    int getTimesTriggered();

    @Override // org.quartz.Trigger
    TriggerBuilder<DailyTimeIntervalTrigger> getTriggerBuilder();
}
