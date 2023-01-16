package org.quartz;

import java.util.TimeZone;

/* loaded from: grasscutter.jar:org/quartz/CronTrigger.class */
public interface CronTrigger extends Trigger {
    public static final long serialVersionUID = -8644953146451592766L;
    public static final int MISFIRE_INSTRUCTION_FIRE_ONCE_NOW = 1;
    public static final int MISFIRE_INSTRUCTION_DO_NOTHING = 2;

    String getCronExpression();

    TimeZone getTimeZone();

    String getExpressionSummary();

    @Override // org.quartz.Trigger
    TriggerBuilder<CronTrigger> getTriggerBuilder();
}
