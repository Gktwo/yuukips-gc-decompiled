package org.quartz;

import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.quartz.spi.MutableTrigger;

/* loaded from: grasscutter.jar:org/quartz/SimpleScheduleBuilder.class */
public class SimpleScheduleBuilder extends ScheduleBuilder<SimpleTrigger> {
    private long interval = 0;
    private int repeatCount = 0;
    private int misfireInstruction = 0;

    protected SimpleScheduleBuilder() {
    }

    public static SimpleScheduleBuilder simpleSchedule() {
        return new SimpleScheduleBuilder();
    }

    public static SimpleScheduleBuilder repeatMinutelyForever() {
        return simpleSchedule().withIntervalInMinutes(1).repeatForever();
    }

    public static SimpleScheduleBuilder repeatMinutelyForever(int minutes) {
        return simpleSchedule().withIntervalInMinutes(minutes).repeatForever();
    }

    public static SimpleScheduleBuilder repeatSecondlyForever() {
        return simpleSchedule().withIntervalInSeconds(1).repeatForever();
    }

    public static SimpleScheduleBuilder repeatSecondlyForever(int seconds) {
        return simpleSchedule().withIntervalInSeconds(seconds).repeatForever();
    }

    public static SimpleScheduleBuilder repeatHourlyForever() {
        return simpleSchedule().withIntervalInHours(1).repeatForever();
    }

    public static SimpleScheduleBuilder repeatHourlyForever(int hours) {
        return simpleSchedule().withIntervalInHours(hours).repeatForever();
    }

    public static SimpleScheduleBuilder repeatMinutelyForTotalCount(int count) {
        if (count >= 1) {
            return simpleSchedule().withIntervalInMinutes(1).withRepeatCount(count - 1);
        }
        throw new IllegalArgumentException("Total count of firings must be at least one! Given count: " + count);
    }

    public static SimpleScheduleBuilder repeatMinutelyForTotalCount(int count, int minutes) {
        if (count >= 1) {
            return simpleSchedule().withIntervalInMinutes(minutes).withRepeatCount(count - 1);
        }
        throw new IllegalArgumentException("Total count of firings must be at least one! Given count: " + count);
    }

    public static SimpleScheduleBuilder repeatSecondlyForTotalCount(int count) {
        if (count >= 1) {
            return simpleSchedule().withIntervalInSeconds(1).withRepeatCount(count - 1);
        }
        throw new IllegalArgumentException("Total count of firings must be at least one! Given count: " + count);
    }

    public static SimpleScheduleBuilder repeatSecondlyForTotalCount(int count, int seconds) {
        if (count >= 1) {
            return simpleSchedule().withIntervalInSeconds(seconds).withRepeatCount(count - 1);
        }
        throw new IllegalArgumentException("Total count of firings must be at least one! Given count: " + count);
    }

    public static SimpleScheduleBuilder repeatHourlyForTotalCount(int count) {
        if (count >= 1) {
            return simpleSchedule().withIntervalInHours(1).withRepeatCount(count - 1);
        }
        throw new IllegalArgumentException("Total count of firings must be at least one! Given count: " + count);
    }

    public static SimpleScheduleBuilder repeatHourlyForTotalCount(int count, int hours) {
        if (count >= 1) {
            return simpleSchedule().withIntervalInHours(hours).withRepeatCount(count - 1);
        }
        throw new IllegalArgumentException("Total count of firings must be at least one! Given count: " + count);
    }

    @Override // org.quartz.ScheduleBuilder
    public MutableTrigger build() {
        SimpleTriggerImpl st = new SimpleTriggerImpl();
        st.setRepeatInterval(this.interval);
        st.setRepeatCount(this.repeatCount);
        st.setMisfireInstruction(this.misfireInstruction);
        return st;
    }

    public SimpleScheduleBuilder withIntervalInMilliseconds(long intervalInMillis) {
        this.interval = intervalInMillis;
        return this;
    }

    public SimpleScheduleBuilder withIntervalInSeconds(int intervalInSeconds) {
        this.interval = ((long) intervalInSeconds) * 1000;
        return this;
    }

    public SimpleScheduleBuilder withIntervalInMinutes(int intervalInMinutes) {
        this.interval = ((long) intervalInMinutes) * 60000;
        return this;
    }

    public SimpleScheduleBuilder withIntervalInHours(int intervalInHours) {
        this.interval = ((long) intervalInHours) * 3600000;
        return this;
    }

    public SimpleScheduleBuilder withRepeatCount(int triggerRepeatCount) {
        this.repeatCount = triggerRepeatCount;
        return this;
    }

    public SimpleScheduleBuilder repeatForever() {
        this.repeatCount = -1;
        return this;
    }

    public SimpleScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires() {
        this.misfireInstruction = -1;
        return this;
    }

    public SimpleScheduleBuilder withMisfireHandlingInstructionFireNow() {
        this.misfireInstruction = 1;
        return this;
    }

    public SimpleScheduleBuilder withMisfireHandlingInstructionNextWithExistingCount() {
        this.misfireInstruction = 5;
        return this;
    }

    public SimpleScheduleBuilder withMisfireHandlingInstructionNextWithRemainingCount() {
        this.misfireInstruction = 4;
        return this;
    }

    public SimpleScheduleBuilder withMisfireHandlingInstructionNowWithExistingCount() {
        this.misfireInstruction = 2;
        return this;
    }

    public SimpleScheduleBuilder withMisfireHandlingInstructionNowWithRemainingCount() {
        this.misfireInstruction = 3;
        return this;
    }
}
