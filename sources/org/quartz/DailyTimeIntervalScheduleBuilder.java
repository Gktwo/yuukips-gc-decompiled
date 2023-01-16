package org.quartz;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.quartz.DateBuilder;
import org.quartz.impl.triggers.DailyTimeIntervalTriggerImpl;
import org.quartz.spi.MutableTrigger;

/* loaded from: grasscutter.jar:org/quartz/DailyTimeIntervalScheduleBuilder.class */
public class DailyTimeIntervalScheduleBuilder extends ScheduleBuilder<DailyTimeIntervalTrigger> {
    private Set<Integer> daysOfWeek;
    private TimeOfDay startTimeOfDay;
    private TimeOfDay endTimeOfDay;
    public static final Set<Integer> ALL_DAYS_OF_THE_WEEK;
    public static final Set<Integer> MONDAY_THROUGH_FRIDAY;
    public static final Set<Integer> SATURDAY_AND_SUNDAY;
    private int interval = 1;
    private DateBuilder.IntervalUnit intervalUnit = DateBuilder.IntervalUnit.MINUTE;
    private int repeatCount = -1;
    private int misfireInstruction = 0;

    static {
        Set<Integer> t = new HashSet<>(7);
        for (int i = 1; i <= 7; i++) {
            t.add(Integer.valueOf(i));
        }
        ALL_DAYS_OF_THE_WEEK = Collections.unmodifiableSet(t);
        Set<Integer> t2 = new HashSet<>(5);
        for (int i2 = 2; i2 <= 6; i2++) {
            t2.add(Integer.valueOf(i2));
        }
        MONDAY_THROUGH_FRIDAY = Collections.unmodifiableSet(t2);
        Set<Integer> t3 = new HashSet<>(2);
        t3.add(1);
        t3.add(7);
        SATURDAY_AND_SUNDAY = Collections.unmodifiableSet(t3);
    }

    protected DailyTimeIntervalScheduleBuilder() {
    }

    public static DailyTimeIntervalScheduleBuilder dailyTimeIntervalSchedule() {
        return new DailyTimeIntervalScheduleBuilder();
    }

    @Override // org.quartz.ScheduleBuilder
    public MutableTrigger build() {
        DailyTimeIntervalTriggerImpl st = new DailyTimeIntervalTriggerImpl();
        st.setRepeatInterval(this.interval);
        st.setRepeatIntervalUnit(this.intervalUnit);
        st.setMisfireInstruction(this.misfireInstruction);
        st.setRepeatCount(this.repeatCount);
        if (this.daysOfWeek != null) {
            st.setDaysOfWeek(this.daysOfWeek);
        } else {
            st.setDaysOfWeek(ALL_DAYS_OF_THE_WEEK);
        }
        if (this.startTimeOfDay != null) {
            st.setStartTimeOfDay(this.startTimeOfDay);
        } else {
            st.setStartTimeOfDay(TimeOfDay.hourAndMinuteOfDay(0, 0));
        }
        if (this.endTimeOfDay != null) {
            st.setEndTimeOfDay(this.endTimeOfDay);
        } else {
            st.setEndTimeOfDay(TimeOfDay.hourMinuteAndSecondOfDay(23, 59, 59));
        }
        return st;
    }

    public DailyTimeIntervalScheduleBuilder withInterval(int timeInterval, DateBuilder.IntervalUnit unit) {
        if (unit == null || (!unit.equals(DateBuilder.IntervalUnit.SECOND) && !unit.equals(DateBuilder.IntervalUnit.MINUTE) && !unit.equals(DateBuilder.IntervalUnit.HOUR))) {
            throw new IllegalArgumentException("Invalid repeat IntervalUnit (must be SECOND, MINUTE or HOUR).");
        }
        validateInterval(timeInterval);
        this.interval = timeInterval;
        this.intervalUnit = unit;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder withIntervalInSeconds(int intervalInSeconds) {
        withInterval(intervalInSeconds, DateBuilder.IntervalUnit.SECOND);
        return this;
    }

    public DailyTimeIntervalScheduleBuilder withIntervalInMinutes(int intervalInMinutes) {
        withInterval(intervalInMinutes, DateBuilder.IntervalUnit.MINUTE);
        return this;
    }

    public DailyTimeIntervalScheduleBuilder withIntervalInHours(int intervalInHours) {
        withInterval(intervalInHours, DateBuilder.IntervalUnit.HOUR);
        return this;
    }

    public DailyTimeIntervalScheduleBuilder onDaysOfTheWeek(Set<Integer> onDaysOfWeek) {
        if (onDaysOfWeek == null || onDaysOfWeek.size() == 0) {
            throw new IllegalArgumentException("Days of week must be an non-empty set.");
        }
        for (Integer day : onDaysOfWeek) {
            if (!ALL_DAYS_OF_THE_WEEK.contains(day)) {
                throw new IllegalArgumentException("Invalid value for day of week: " + day);
            }
        }
        this.daysOfWeek = onDaysOfWeek;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder onDaysOfTheWeek(Integer... onDaysOfWeek) {
        Set<Integer> daysAsSet = new HashSet<>(12);
        Collections.addAll(daysAsSet, onDaysOfWeek);
        return onDaysOfTheWeek(daysAsSet);
    }

    public DailyTimeIntervalScheduleBuilder onMondayThroughFriday() {
        this.daysOfWeek = MONDAY_THROUGH_FRIDAY;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder onSaturdayAndSunday() {
        this.daysOfWeek = SATURDAY_AND_SUNDAY;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder onEveryDay() {
        this.daysOfWeek = ALL_DAYS_OF_THE_WEEK;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder startingDailyAt(TimeOfDay timeOfDay) {
        if (timeOfDay == null) {
            throw new IllegalArgumentException("Start time of day cannot be null!");
        }
        this.startTimeOfDay = timeOfDay;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder endingDailyAt(TimeOfDay timeOfDay) {
        this.endTimeOfDay = timeOfDay;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder endingDailyAfterCount(int count) {
        long intervalInMillis;
        if (count <= 0) {
            throw new IllegalArgumentException("Ending daily after count must be a positive number!");
        } else if (this.startTimeOfDay == null) {
            throw new IllegalArgumentException("You must set the startDailyAt() before calling this endingDailyAfterCount()!");
        } else {
            Date today = new Date();
            Date startTimeOfDayDate = this.startTimeOfDay.getTimeOfDayForDate(today);
            Date maxEndTimeOfDayDate = TimeOfDay.hourMinuteAndSecondOfDay(23, 59, 59).getTimeOfDayForDate(today);
            long remainingMillisInDay = maxEndTimeOfDayDate.getTime() - startTimeOfDayDate.getTime();
            if (this.intervalUnit == DateBuilder.IntervalUnit.SECOND) {
                intervalInMillis = ((long) this.interval) * 1000;
            } else if (this.intervalUnit == DateBuilder.IntervalUnit.MINUTE) {
                intervalInMillis = ((long) this.interval) * 1000 * 60;
            } else if (this.intervalUnit == DateBuilder.IntervalUnit.HOUR) {
                intervalInMillis = ((long) this.interval) * 1000 * 60 * 24;
            } else {
                throw new IllegalArgumentException("The IntervalUnit: " + this.intervalUnit + " is invalid for this trigger.");
            }
            if (remainingMillisInDay - intervalInMillis <= 0) {
                throw new IllegalArgumentException("The startTimeOfDay is too late with given Interval and IntervalUnit values.");
            }
            long maxNumOfCount = remainingMillisInDay / intervalInMillis;
            if (((long) count) > maxNumOfCount) {
                throw new IllegalArgumentException("The given count " + count + " is too large! The max you can set is " + maxNumOfCount);
            }
            Date endTimeOfDayDate = new Date(startTimeOfDayDate.getTime() + (((long) (count - 1)) * intervalInMillis));
            if (endTimeOfDayDate.getTime() > maxEndTimeOfDayDate.getTime()) {
                throw new IllegalArgumentException("The given count " + count + " is too large! The max you can set is " + maxNumOfCount);
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(endTimeOfDayDate);
            this.endTimeOfDay = TimeOfDay.hourMinuteAndSecondOfDay(cal.get(11), cal.get(12), cal.get(13));
            return this;
        }
    }

    public DailyTimeIntervalScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires() {
        this.misfireInstruction = -1;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder withMisfireHandlingInstructionDoNothing() {
        this.misfireInstruction = 2;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder withMisfireHandlingInstructionFireAndProceed() {
        this.misfireInstruction = 1;
        return this;
    }

    public DailyTimeIntervalScheduleBuilder withRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    private void validateInterval(int timeInterval) {
        if (timeInterval <= 0) {
            throw new IllegalArgumentException("Interval must be a positive value.");
        }
    }
}
