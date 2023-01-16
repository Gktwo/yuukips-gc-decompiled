package org.quartz.impl.triggers;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import org.quartz.DailyTimeIntervalScheduleBuilder;
import org.quartz.DailyTimeIntervalTrigger;
import org.quartz.DateBuilder;
import org.quartz.ScheduleBuilder;
import org.quartz.SchedulerException;
import org.quartz.TimeOfDay;

/* loaded from: grasscutter.jar:org/quartz/impl/triggers/DailyTimeIntervalTriggerImpl.class */
public class DailyTimeIntervalTriggerImpl extends AbstractTrigger<DailyTimeIntervalTrigger> implements DailyTimeIntervalTrigger, CoreTrigger {
    private static final long serialVersionUID = -632667786771388749L;
    private static final int YEAR_TO_GIVEUP_SCHEDULING_AT = Calendar.getInstance().get(1) + 100;
    private Date startTime;
    private Date endTime;
    private Date nextFireTime;
    private Date previousFireTime;
    private int repeatCount;
    private int repeatInterval;
    private DateBuilder.IntervalUnit repeatIntervalUnit;
    private Set<Integer> daysOfWeek;
    private TimeOfDay startTimeOfDay;
    private TimeOfDay endTimeOfDay;
    private int timesTriggered;
    private boolean complete;

    public DailyTimeIntervalTriggerImpl() {
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatCount = -1;
        this.repeatInterval = 1;
        this.repeatIntervalUnit = DateBuilder.IntervalUnit.MINUTE;
        this.timesTriggered = 0;
        this.complete = false;
    }

    public DailyTimeIntervalTriggerImpl(String name, TimeOfDay startTimeOfDay, TimeOfDay endTimeOfDay, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        this(name, null, startTimeOfDay, endTimeOfDay, intervalUnit, repeatInterval);
    }

    public DailyTimeIntervalTriggerImpl(String name, String group, TimeOfDay startTimeOfDay, TimeOfDay endTimeOfDay, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        this(name, group, new Date(), null, startTimeOfDay, endTimeOfDay, intervalUnit, repeatInterval);
    }

    public DailyTimeIntervalTriggerImpl(String name, Date startTime, Date endTime, TimeOfDay startTimeOfDay, TimeOfDay endTimeOfDay, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        this(name, null, startTime, endTime, startTimeOfDay, endTimeOfDay, intervalUnit, repeatInterval);
    }

    public DailyTimeIntervalTriggerImpl(String name, String group, Date startTime, Date endTime, TimeOfDay startTimeOfDay, TimeOfDay endTimeOfDay, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        super(name, group);
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatCount = -1;
        this.repeatInterval = 1;
        this.repeatIntervalUnit = DateBuilder.IntervalUnit.MINUTE;
        this.timesTriggered = 0;
        this.complete = false;
        setStartTime(startTime);
        setEndTime(endTime);
        setRepeatIntervalUnit(intervalUnit);
        setRepeatInterval(repeatInterval);
        setStartTimeOfDay(startTimeOfDay);
        setEndTimeOfDay(endTimeOfDay);
    }

    public DailyTimeIntervalTriggerImpl(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, TimeOfDay startTimeOfDay, TimeOfDay endTimeOfDay, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        super(name, group, jobName, jobGroup);
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatCount = -1;
        this.repeatInterval = 1;
        this.repeatIntervalUnit = DateBuilder.IntervalUnit.MINUTE;
        this.timesTriggered = 0;
        this.complete = false;
        setStartTime(startTime);
        setEndTime(endTime);
        setRepeatIntervalUnit(intervalUnit);
        setRepeatInterval(repeatInterval);
        setStartTimeOfDay(startTimeOfDay);
        setEndTimeOfDay(endTimeOfDay);
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getStartTime() {
        if (this.startTime == null) {
            this.startTime = new Date();
        }
        return this.startTime;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.MutableTrigger
    public void setStartTime(Date startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
        Date eTime = getEndTime();
        if (eTime == null || !eTime.before(startTime)) {
            this.startTime = startTime;
            return;
        }
        throw new IllegalArgumentException("End time cannot be before start time");
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getEndTime() {
        return this.endTime;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.MutableTrigger
    public void setEndTime(Date endTime) {
        Date sTime = getStartTime();
        if (sTime == null || endTime == null || !sTime.after(endTime)) {
            this.endTime = endTime;
            return;
        }
        throw new IllegalArgumentException("End time cannot be before start time");
    }

    @Override // org.quartz.DailyTimeIntervalTrigger
    public DateBuilder.IntervalUnit getRepeatIntervalUnit() {
        return this.repeatIntervalUnit;
    }

    public void setRepeatIntervalUnit(DateBuilder.IntervalUnit intervalUnit) {
        if (this.repeatIntervalUnit == null || (!this.repeatIntervalUnit.equals(DateBuilder.IntervalUnit.SECOND) && !this.repeatIntervalUnit.equals(DateBuilder.IntervalUnit.MINUTE) && !this.repeatIntervalUnit.equals(DateBuilder.IntervalUnit.HOUR))) {
            throw new IllegalArgumentException("Invalid repeat IntervalUnit (must be SECOND, MINUTE or HOUR).");
        }
        this.repeatIntervalUnit = intervalUnit;
    }

    @Override // org.quartz.DailyTimeIntervalTrigger
    public int getRepeatInterval() {
        return this.repeatInterval;
    }

    public void setRepeatInterval(int repeatInterval) {
        if (repeatInterval < 0) {
            throw new IllegalArgumentException("Repeat interval must be >= 1");
        }
        this.repeatInterval = repeatInterval;
    }

    @Override // org.quartz.DailyTimeIntervalTrigger
    public int getTimesTriggered() {
        return this.timesTriggered;
    }

    public void setTimesTriggered(int timesTriggered) {
        this.timesTriggered = timesTriggered;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger
    protected boolean validateMisfireInstruction(int misfireInstruction) {
        return misfireInstruction >= -1 && misfireInstruction <= 2;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void updateAfterMisfire(org.quartz.Calendar cal) {
        int instr = getMisfireInstruction();
        if (instr != -1) {
            if (instr == 0) {
                instr = 1;
            }
            if (instr == 2) {
                Date newFireTime = getFireTimeAfter(new Date());
                while (newFireTime != null && cal != null && !cal.isTimeIncluded(newFireTime.getTime())) {
                    newFireTime = getFireTimeAfter(newFireTime);
                }
                setNextFireTime(newFireTime);
            } else if (instr == 1) {
                setNextFireTime(new Date());
            }
        }
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void triggered(org.quartz.Calendar calendar) {
        this.timesTriggered++;
        this.previousFireTime = this.nextFireTime;
        this.nextFireTime = getFireTimeAfter(this.nextFireTime);
        while (this.nextFireTime != null && calendar != null && !calendar.isTimeIncluded(this.nextFireTime.getTime())) {
            this.nextFireTime = getFireTimeAfter(this.nextFireTime);
            if (this.nextFireTime == null) {
                break;
            }
            Calendar c = Calendar.getInstance();
            c.setTime(this.nextFireTime);
            if (c.get(1) > YEAR_TO_GIVEUP_SCHEDULING_AT) {
                this.nextFireTime = null;
            }
        }
        if (this.nextFireTime == null) {
            this.complete = true;
        }
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void updateWithNewCalendar(org.quartz.Calendar calendar, long misfireThreshold) {
        this.nextFireTime = getFireTimeAfter(this.previousFireTime);
        if (this.nextFireTime != null && calendar != null) {
            Date now = new Date();
            while (this.nextFireTime != null && !calendar.isTimeIncluded(this.nextFireTime.getTime())) {
                this.nextFireTime = getFireTimeAfter(this.nextFireTime);
                if (this.nextFireTime != null) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(this.nextFireTime);
                    if (c.get(1) > YEAR_TO_GIVEUP_SCHEDULING_AT) {
                        this.nextFireTime = null;
                    }
                    if (this.nextFireTime != null && this.nextFireTime.before(now) && now.getTime() - this.nextFireTime.getTime() >= misfireThreshold) {
                        this.nextFireTime = getFireTimeAfter(this.nextFireTime);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public Date computeFirstFireTime(org.quartz.Calendar calendar) {
        this.nextFireTime = getFireTimeAfter(new Date(getStartTime().getTime() - 1000));
        while (this.nextFireTime != null && calendar != null && !calendar.isTimeIncluded(this.nextFireTime.getTime())) {
            this.nextFireTime = getFireTimeAfter(this.nextFireTime);
            if (this.nextFireTime == null) {
                break;
            }
            Calendar c = Calendar.getInstance();
            c.setTime(this.nextFireTime);
            if (c.get(1) > YEAR_TO_GIVEUP_SCHEDULING_AT) {
                return null;
            }
        }
        return this.nextFireTime;
    }

    private Calendar createCalendarTime(Date dateTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        return cal;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getNextFireTime() {
        return this.nextFireTime;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getPreviousFireTime() {
        return this.previousFireTime;
    }

    @Override // org.quartz.spi.OperableTrigger
    public void setNextFireTime(Date nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    @Override // org.quartz.spi.OperableTrigger
    public void setPreviousFireTime(Date previousFireTime) {
        this.previousFireTime = previousFireTime;
    }

    /* JADX WARN: Type inference failed for: r0v50, types: [long] */
    /* JADX WARN: Type inference failed for: r0v58, types: [long] */
    /* JADX WARN: Type inference failed for: r0v60, types: [long] */
    /* JADX WARN: Type inference failed for: r0v68, types: [long] */
    /* JADX WARN: Type inference failed for: r0v70, types: [long] */
    /* JADX WARN: Type inference failed for: r0v78, types: [long] */
    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getFireTimeAfter(Date afterTime) {
        Date afterTime2;
        Date fireTimeEndDate;
        if (this.complete) {
            return null;
        }
        if (this.repeatCount != -1 && this.timesTriggered > this.repeatCount) {
            return null;
        }
        if (afterTime == null) {
            afterTime2 = new Date(System.currentTimeMillis() + 1000);
        } else {
            afterTime2 = new Date(afterTime.getTime() + 1000);
        }
        if (afterTime2.before(this.startTime)) {
            afterTime2 = this.startTime;
        }
        boolean afterTimePastEndTimeOfDay = false;
        if (this.endTimeOfDay != null) {
            afterTimePastEndTimeOfDay = afterTime2.getTime() > this.endTimeOfDay.getTimeOfDayForDate(afterTime2).getTime();
        }
        Date fireTime = advanceToNextDayOfWeekIfNecessary(afterTime2, afterTimePastEndTimeOfDay);
        if (fireTime == null) {
            return null;
        }
        if (this.endTimeOfDay == null) {
            fireTimeEndDate = new TimeOfDay(23, 59, 59).getTimeOfDayForDate(fireTime);
        } else {
            fireTimeEndDate = this.endTimeOfDay.getTimeOfDayForDate(fireTime);
        }
        Date fireTimeStartDate = this.startTimeOfDay.getTimeOfDayForDate(fireTime);
        if (fireTime.before(fireTimeStartDate)) {
            return fireTimeStartDate;
        }
        long secondsAfterStart = (fireTime.getTime() - fireTimeStartDate.getTime()) / 1000;
        long repeatLong = (long) getRepeatInterval();
        Calendar sTime = createCalendarTime(fireTimeStartDate);
        DateBuilder.IntervalUnit repeatUnit = getRepeatIntervalUnit();
        if (repeatUnit.equals(DateBuilder.IntervalUnit.SECOND)) {
            char c = secondsAfterStart / repeatLong;
            if (secondsAfterStart % repeatLong != 0) {
                c++;
            }
            sTime.add(13, getRepeatInterval() * ((int) c));
            fireTime = sTime.getTime();
        } else if (repeatUnit.equals(DateBuilder.IntervalUnit.MINUTE)) {
            char c2 = secondsAfterStart / (repeatLong * 60);
            if (secondsAfterStart % (repeatLong * 60) != 0) {
                c2++;
            }
            sTime.add(12, getRepeatInterval() * ((int) c2));
            fireTime = sTime.getTime();
        } else if (repeatUnit.equals(DateBuilder.IntervalUnit.HOUR)) {
            char c3 = secondsAfterStart / ((repeatLong * 60) * 60);
            if (secondsAfterStart % ((repeatLong * 60) * 60) != 0) {
                c3++;
            }
            sTime.add(11, getRepeatInterval() * ((int) c3));
            fireTime = sTime.getTime();
        }
        if (fireTime.after(fireTimeEndDate)) {
            fireTime = this.startTimeOfDay.getTimeOfDayForDate(advanceToNextDayOfWeekIfNecessary(fireTime, isSameDay(fireTime, fireTimeEndDate)));
        }
        return fireTime;
    }

    private boolean isSameDay(Date d1, Date d2) {
        Calendar c1 = createCalendarTime(d1);
        Calendar c2 = createCalendarTime(d2);
        return c1.get(1) == c2.get(1) && c1.get(6) == c2.get(6);
    }

    private Date advanceToNextDayOfWeekIfNecessary(Date fireTime, boolean forceToAdvanceNextDay) {
        Calendar fireTimeStartDateCal = createCalendarTime(getStartTimeOfDay().getTimeOfDayForDate(fireTime));
        int dayOfWeekOfFireTime = fireTimeStartDateCal.get(7);
        Set<Integer> daysOfWeekToFire = getDaysOfWeek();
        if (forceToAdvanceNextDay || !daysOfWeekToFire.contains(Integer.valueOf(dayOfWeekOfFireTime))) {
            int i = 1;
            while (true) {
                if (i > 7) {
                    break;
                }
                fireTimeStartDateCal.add(5, 1);
                if (daysOfWeekToFire.contains(Integer.valueOf(fireTimeStartDateCal.get(7)))) {
                    fireTime = fireTimeStartDateCal.getTime();
                    break;
                }
                i++;
            }
        }
        Date eTime = getEndTime();
        if (eTime == null || fireTime.getTime() <= eTime.getTime()) {
            return fireTime;
        }
        return null;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getFinalFireTime() {
        if (this.complete || getEndTime() == null) {
            return null;
        }
        Date eTime = getEndTime();
        if (this.endTimeOfDay != null) {
            Date endTimeOfDayDate = this.endTimeOfDay.getTimeOfDayForDate(eTime);
            if (eTime.getTime() < endTimeOfDayDate.getTime()) {
                eTime = endTimeOfDayDate;
            }
        }
        return eTime;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public boolean mayFireAgain() {
        return getNextFireTime() != null;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void validate() throws SchedulerException {
        validate();
        if (this.repeatIntervalUnit == null || (!this.repeatIntervalUnit.equals(DateBuilder.IntervalUnit.SECOND) && !this.repeatIntervalUnit.equals(DateBuilder.IntervalUnit.MINUTE) && !this.repeatIntervalUnit.equals(DateBuilder.IntervalUnit.HOUR))) {
            throw new SchedulerException("Invalid repeat IntervalUnit (must be SECOND, MINUTE or HOUR).");
        } else if (this.repeatInterval < 1) {
            throw new SchedulerException("Repeat Interval cannot be zero.");
        } else if (this.repeatIntervalUnit == DateBuilder.IntervalUnit.SECOND && ((long) this.repeatInterval) > DateBuilder.SECONDS_IN_MOST_DAYS) {
            throw new SchedulerException("repeatInterval can not exceed 24 hours (" + DateBuilder.SECONDS_IN_MOST_DAYS + " seconds). Given " + this.repeatInterval);
        } else if (this.repeatIntervalUnit == DateBuilder.IntervalUnit.MINUTE && ((long) this.repeatInterval) > DateBuilder.SECONDS_IN_MOST_DAYS / 60) {
            throw new SchedulerException("repeatInterval can not exceed 24 hours (" + (DateBuilder.SECONDS_IN_MOST_DAYS / 60) + " minutes). Given " + this.repeatInterval);
        } else if (this.repeatIntervalUnit == DateBuilder.IntervalUnit.HOUR && this.repeatInterval > 24) {
            throw new SchedulerException("repeatInterval can not exceed 24 hours. Given " + this.repeatInterval + " hours.");
        } else if (getEndTimeOfDay() != null && !getStartTimeOfDay().equals(getEndTimeOfDay()) && !getStartTimeOfDay().before(getEndTimeOfDay())) {
            throw new SchedulerException("StartTimeOfDay " + this.startTimeOfDay + " should not come after endTimeOfDay " + this.endTimeOfDay);
        }
    }

    @Override // org.quartz.DailyTimeIntervalTrigger
    public Set<Integer> getDaysOfWeek() {
        if (this.daysOfWeek == null) {
            this.daysOfWeek = DailyTimeIntervalScheduleBuilder.ALL_DAYS_OF_THE_WEEK;
        }
        return this.daysOfWeek;
    }

    public void setDaysOfWeek(Set<Integer> daysOfWeek) {
        if (daysOfWeek == null || daysOfWeek.size() == 0) {
            throw new IllegalArgumentException("DaysOfWeek set must be a set that contains at least one day.");
        } else if (daysOfWeek.size() == 0) {
            throw new IllegalArgumentException("DaysOfWeek set must contain at least one day.");
        } else {
            this.daysOfWeek = daysOfWeek;
        }
    }

    @Override // org.quartz.DailyTimeIntervalTrigger
    public TimeOfDay getStartTimeOfDay() {
        if (this.startTimeOfDay == null) {
            this.startTimeOfDay = new TimeOfDay(0, 0, 0);
        }
        return this.startTimeOfDay;
    }

    public void setStartTimeOfDay(TimeOfDay startTimeOfDay) {
        if (startTimeOfDay == null) {
            throw new IllegalArgumentException("Start time of day cannot be null");
        }
        TimeOfDay eTime = getEndTimeOfDay();
        if (eTime == null || !eTime.before(startTimeOfDay)) {
            this.startTimeOfDay = startTimeOfDay;
            return;
        }
        throw new IllegalArgumentException("End time of day cannot be before start time of day");
    }

    @Override // org.quartz.DailyTimeIntervalTrigger
    public TimeOfDay getEndTimeOfDay() {
        return this.endTimeOfDay;
    }

    public void setEndTimeOfDay(TimeOfDay endTimeOfDay) {
        if (endTimeOfDay == null) {
            throw new IllegalArgumentException("End time of day cannot be null");
        } else if (getStartTimeOfDay() == null || !endTimeOfDay.before(endTimeOfDay)) {
            this.endTimeOfDay = endTimeOfDay;
        } else {
            throw new IllegalArgumentException("End time of day cannot be before start time of day");
        }
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public ScheduleBuilder<DailyTimeIntervalTrigger> getScheduleBuilder() {
        DailyTimeIntervalScheduleBuilder cb = DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule().withInterval(getRepeatInterval(), getRepeatIntervalUnit()).onDaysOfTheWeek(getDaysOfWeek()).startingDailyAt(getStartTimeOfDay()).endingDailyAt(getEndTimeOfDay());
        switch (getMisfireInstruction()) {
            case 1:
                cb.withMisfireHandlingInstructionFireAndProceed();
                break;
            case 2:
                cb.withMisfireHandlingInstructionDoNothing();
                break;
        }
        return cb;
    }

    @Override // org.quartz.impl.triggers.CoreTrigger
    public boolean hasAdditionalProperties() {
        return false;
    }

    @Override // org.quartz.DailyTimeIntervalTrigger
    public int getRepeatCount() {
        return this.repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        if (repeatCount >= 0 || repeatCount == -1) {
            this.repeatCount = repeatCount;
            return;
        }
        throw new IllegalArgumentException("Repeat count must be >= 0, use the constant REPEAT_INDEFINITELY for infinite.");
    }
}
