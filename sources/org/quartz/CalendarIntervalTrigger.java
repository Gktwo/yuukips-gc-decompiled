package org.quartz;

import java.util.TimeZone;
import org.quartz.DateBuilder;

/* loaded from: grasscutter.jar:org/quartz/CalendarIntervalTrigger.class */
public interface CalendarIntervalTrigger extends Trigger {
    public static final int MISFIRE_INSTRUCTION_FIRE_ONCE_NOW = 1;
    public static final int MISFIRE_INSTRUCTION_DO_NOTHING = 2;

    DateBuilder.IntervalUnit getRepeatIntervalUnit();

    int getRepeatInterval();

    int getTimesTriggered();

    TimeZone getTimeZone();

    boolean isPreserveHourOfDayAcrossDaylightSavings();

    boolean isSkipDayIfHourDoesNotExist();

    @Override // org.quartz.Trigger
    TriggerBuilder<CalendarIntervalTrigger> getTriggerBuilder();
}
