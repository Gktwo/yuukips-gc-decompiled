package org.quartz;

import java.text.ParseException;
import java.util.TimeZone;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.spi.MutableTrigger;

/* loaded from: grasscutter.jar:org/quartz/CronScheduleBuilder.class */
public class CronScheduleBuilder extends ScheduleBuilder<CronTrigger> {
    private CronExpression cronExpression;
    private int misfireInstruction = 0;

    protected CronScheduleBuilder(CronExpression cronExpression) {
        if (cronExpression == null) {
            throw new NullPointerException("cronExpression cannot be null");
        }
        this.cronExpression = cronExpression;
    }

    @Override // org.quartz.ScheduleBuilder
    public MutableTrigger build() {
        CronTriggerImpl ct = new CronTriggerImpl();
        ct.setCronExpression(this.cronExpression);
        ct.setTimeZone(this.cronExpression.getTimeZone());
        ct.setMisfireInstruction(this.misfireInstruction);
        return ct;
    }

    public static CronScheduleBuilder cronSchedule(String cronExpression) {
        try {
            return cronSchedule(new CronExpression(cronExpression));
        } catch (ParseException e) {
            throw new RuntimeException("CronExpression '" + cronExpression + "' is invalid.", e);
        }
    }

    public static CronScheduleBuilder cronScheduleNonvalidatedExpression(String cronExpression) throws ParseException {
        return cronSchedule(new CronExpression(cronExpression));
    }

    private static CronScheduleBuilder cronScheduleNoParseException(String presumedValidCronExpression) {
        try {
            return cronSchedule(new CronExpression(presumedValidCronExpression));
        } catch (ParseException e) {
            throw new RuntimeException("CronExpression '" + presumedValidCronExpression + "' is invalid, which should not be possible, please report bug to Quartz developers.", e);
        }
    }

    public static CronScheduleBuilder cronSchedule(CronExpression cronExpression) {
        return new CronScheduleBuilder(cronExpression);
    }

    public static CronScheduleBuilder dailyAtHourAndMinute(int hour, int minute) {
        DateBuilder.validateHour(hour);
        DateBuilder.validateMinute(minute);
        return cronScheduleNoParseException(String.format("0 %d %d ? * *", Integer.valueOf(minute), Integer.valueOf(hour)));
    }

    public static CronScheduleBuilder atHourAndMinuteOnGivenDaysOfWeek(int hour, int minute, Integer... daysOfWeek) {
        if (daysOfWeek == null || daysOfWeek.length == 0) {
            throw new IllegalArgumentException("You must specify at least one day of week.");
        }
        for (Integer num : daysOfWeek) {
            DateBuilder.validateDayOfWeek(num.intValue());
        }
        DateBuilder.validateHour(hour);
        DateBuilder.validateMinute(minute);
        String cronExpression = String.format("0 %d %d ? * %d", Integer.valueOf(minute), Integer.valueOf(hour), daysOfWeek[0]);
        for (int i = 1; i < daysOfWeek.length; i++) {
            cronExpression = cronExpression + "," + daysOfWeek[i];
        }
        return cronScheduleNoParseException(cronExpression);
    }

    public static CronScheduleBuilder weeklyOnDayAndHourAndMinute(int dayOfWeek, int hour, int minute) {
        DateBuilder.validateDayOfWeek(dayOfWeek);
        DateBuilder.validateHour(hour);
        DateBuilder.validateMinute(minute);
        return cronScheduleNoParseException(String.format("0 %d %d ? * %d", Integer.valueOf(minute), Integer.valueOf(hour), Integer.valueOf(dayOfWeek)));
    }

    public static CronScheduleBuilder monthlyOnDayAndHourAndMinute(int dayOfMonth, int hour, int minute) {
        DateBuilder.validateDayOfMonth(dayOfMonth);
        DateBuilder.validateHour(hour);
        DateBuilder.validateMinute(minute);
        return cronScheduleNoParseException(String.format("0 %d %d %d * ?", Integer.valueOf(minute), Integer.valueOf(hour), Integer.valueOf(dayOfMonth)));
    }

    public CronScheduleBuilder inTimeZone(TimeZone timezone) {
        this.cronExpression.setTimeZone(timezone);
        return this;
    }

    public CronScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires() {
        this.misfireInstruction = -1;
        return this;
    }

    public CronScheduleBuilder withMisfireHandlingInstructionDoNothing() {
        this.misfireInstruction = 2;
        return this;
    }

    public CronScheduleBuilder withMisfireHandlingInstructionFireAndProceed() {
        this.misfireInstruction = 1;
        return this;
    }
}
