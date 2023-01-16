package org.quartz.impl.triggers;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.LongCompanionObject;
import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.CalendarIntervalTrigger;
import org.quartz.DateBuilder;
import org.quartz.ScheduleBuilder;
import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/impl/triggers/CalendarIntervalTriggerImpl.class */
public class CalendarIntervalTriggerImpl extends AbstractTrigger<CalendarIntervalTrigger> implements CalendarIntervalTrigger, CoreTrigger {
    private static final long serialVersionUID = -2635982274232850343L;
    private static final int YEAR_TO_GIVEUP_SCHEDULING_AT = Calendar.getInstance().get(1) + 100;
    private Date startTime;
    private Date endTime;
    private Date nextFireTime;
    private Date previousFireTime;
    private int repeatInterval;
    private DateBuilder.IntervalUnit repeatIntervalUnit;
    private TimeZone timeZone;
    private boolean preserveHourOfDayAcrossDaylightSavings;
    private boolean skipDayIfHourDoesNotExist;
    private int timesTriggered;
    private boolean complete;

    public CalendarIntervalTriggerImpl() {
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatInterval = 0;
        this.repeatIntervalUnit = DateBuilder.IntervalUnit.DAY;
        this.preserveHourOfDayAcrossDaylightSavings = false;
        this.skipDayIfHourDoesNotExist = false;
        this.timesTriggered = 0;
        this.complete = false;
    }

    public CalendarIntervalTriggerImpl(String name, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        this(name, null, intervalUnit, repeatInterval);
    }

    public CalendarIntervalTriggerImpl(String name, String group, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        this(name, group, new Date(), null, intervalUnit, repeatInterval);
    }

    public CalendarIntervalTriggerImpl(String name, Date startTime, Date endTime, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        this(name, null, startTime, endTime, intervalUnit, repeatInterval);
    }

    public CalendarIntervalTriggerImpl(String name, String group, Date startTime, Date endTime, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        super(name, group);
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatInterval = 0;
        this.repeatIntervalUnit = DateBuilder.IntervalUnit.DAY;
        this.preserveHourOfDayAcrossDaylightSavings = false;
        this.skipDayIfHourDoesNotExist = false;
        this.timesTriggered = 0;
        this.complete = false;
        setStartTime(startTime);
        setEndTime(endTime);
        setRepeatIntervalUnit(intervalUnit);
        setRepeatInterval(repeatInterval);
    }

    public CalendarIntervalTriggerImpl(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, DateBuilder.IntervalUnit intervalUnit, int repeatInterval) {
        super(name, group, jobName, jobGroup);
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatInterval = 0;
        this.repeatIntervalUnit = DateBuilder.IntervalUnit.DAY;
        this.preserveHourOfDayAcrossDaylightSavings = false;
        this.skipDayIfHourDoesNotExist = false;
        this.timesTriggered = 0;
        this.complete = false;
        setStartTime(startTime);
        setEndTime(endTime);
        setRepeatIntervalUnit(intervalUnit);
        setRepeatInterval(repeatInterval);
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

    @Override // org.quartz.CalendarIntervalTrigger
    public DateBuilder.IntervalUnit getRepeatIntervalUnit() {
        return this.repeatIntervalUnit;
    }

    public void setRepeatIntervalUnit(DateBuilder.IntervalUnit intervalUnit) {
        this.repeatIntervalUnit = intervalUnit;
    }

    @Override // org.quartz.CalendarIntervalTrigger
    public int getRepeatInterval() {
        return this.repeatInterval;
    }

    public void setRepeatInterval(int repeatInterval) {
        if (repeatInterval < 0) {
            throw new IllegalArgumentException("Repeat interval must be >= 1");
        }
        this.repeatInterval = repeatInterval;
    }

    @Override // org.quartz.CalendarIntervalTrigger
    public TimeZone getTimeZone() {
        if (this.timeZone == null) {
            this.timeZone = TimeZone.getDefault();
        }
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override // org.quartz.CalendarIntervalTrigger
    public boolean isPreserveHourOfDayAcrossDaylightSavings() {
        return this.preserveHourOfDayAcrossDaylightSavings;
    }

    public void setPreserveHourOfDayAcrossDaylightSavings(boolean preserveHourOfDayAcrossDaylightSavings) {
        this.preserveHourOfDayAcrossDaylightSavings = preserveHourOfDayAcrossDaylightSavings;
    }

    @Override // org.quartz.CalendarIntervalTrigger
    public boolean isSkipDayIfHourDoesNotExist() {
        return this.skipDayIfHourDoesNotExist;
    }

    public void setSkipDayIfHourDoesNotExist(boolean skipDayIfHourDoesNotExist) {
        this.skipDayIfHourDoesNotExist = skipDayIfHourDoesNotExist;
    }

    @Override // org.quartz.CalendarIntervalTrigger
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
            if (this.nextFireTime != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(this.nextFireTime);
                if (c.get(1) > YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    this.nextFireTime = null;
                }
            } else {
                return;
            }
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
        this.nextFireTime = getStartTime();
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

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getFireTimeAfter(Date afterTime) {
        return getFireTimeAfter(afterTime, false);
    }

    /* JADX WARN: Type inference failed for: r0v153, types: [long] */
    /* JADX WARN: Type inference failed for: r0v161, types: [long] */
    /* JADX WARN: Type inference failed for: r0v163, types: [long] */
    /* JADX WARN: Type inference failed for: r0v171, types: [long] */
    /* JADX WARN: Type inference failed for: r0v173, types: [long] */
    /* JADX WARN: Type inference failed for: r0v181, types: [long] */
    protected Date getFireTimeAfter(Date afterTime, boolean ignoreEndTime) {
        long jumpCount;
        long jumpCount2;
        if (this.complete) {
            return null;
        }
        if (afterTime == null) {
            afterTime = new Date();
        }
        long startMillis = getStartTime().getTime();
        long afterMillis = afterTime.getTime();
        long endMillis = getEndTime() == null ? LongCompanionObject.MAX_VALUE : getEndTime().getTime();
        if (!ignoreEndTime && endMillis <= afterMillis) {
            return null;
        }
        if (afterMillis < startMillis) {
            return new Date(startMillis);
        }
        long secondsAfterStart = 1 + ((afterMillis - startMillis) / 1000);
        Date time = null;
        long repeatLong = (long) getRepeatInterval();
        Calendar.getInstance().setTime(afterTime);
        Calendar sTime = Calendar.getInstance();
        if (this.timeZone != null) {
            sTime.setTimeZone(this.timeZone);
        }
        sTime.setTime(getStartTime());
        sTime.setLenient(true);
        if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.SECOND)) {
            char c = secondsAfterStart / repeatLong;
            if (secondsAfterStart % repeatLong != 0) {
                c++;
            }
            sTime.add(13, getRepeatInterval() * ((int) c));
            time = sTime.getTime();
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.MINUTE)) {
            char c2 = secondsAfterStart / (repeatLong * 60);
            if (secondsAfterStart % (repeatLong * 60) != 0) {
                c2++;
            }
            sTime.add(12, getRepeatInterval() * ((int) c2));
            time = sTime.getTime();
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.HOUR)) {
            char c3 = secondsAfterStart / ((repeatLong * 60) * 60);
            if (secondsAfterStart % ((repeatLong * 60) * 60) != 0) {
                c3++;
            }
            sTime.add(11, getRepeatInterval() * ((int) c3));
            time = sTime.getTime();
        } else {
            int initialHourOfDay = sTime.get(11);
            if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.DAY)) {
                sTime.setLenient(true);
                long jumpCount3 = secondsAfterStart / (((repeatLong * 24) * 60) * 60);
                if (jumpCount3 > 20) {
                    if (jumpCount3 < 50) {
                        jumpCount2 = (long) (((double) jumpCount3) * 0.8d);
                    } else if (jumpCount3 < 500) {
                        jumpCount2 = (long) (((double) jumpCount3) * 0.9d);
                    } else {
                        jumpCount2 = (long) (((double) jumpCount3) * 0.95d);
                    }
                    sTime.add(6, (int) (((long) getRepeatInterval()) * jumpCount2));
                }
                while (!sTime.getTime().after(afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(6, getRepeatInterval());
                }
                while (daylightSavingHourShiftOccurredAndAdvanceNeeded(sTime, initialHourOfDay, afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(6, getRepeatInterval());
                }
                time = sTime.getTime();
            } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.WEEK)) {
                sTime.setLenient(true);
                long jumpCount4 = secondsAfterStart / ((((repeatLong * 7) * 24) * 60) * 60);
                if (jumpCount4 > 20) {
                    if (jumpCount4 < 50) {
                        jumpCount = (long) (((double) jumpCount4) * 0.8d);
                    } else if (jumpCount4 < 500) {
                        jumpCount = (long) (((double) jumpCount4) * 0.9d);
                    } else {
                        jumpCount = (long) (((double) jumpCount4) * 0.95d);
                    }
                    sTime.add(3, (int) (((long) getRepeatInterval()) * jumpCount));
                }
                while (!sTime.getTime().after(afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(3, getRepeatInterval());
                }
                while (daylightSavingHourShiftOccurredAndAdvanceNeeded(sTime, initialHourOfDay, afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(3, getRepeatInterval());
                }
                time = sTime.getTime();
            } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.MONTH)) {
                sTime.setLenient(true);
                while (!sTime.getTime().after(afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(2, getRepeatInterval());
                }
                while (daylightSavingHourShiftOccurredAndAdvanceNeeded(sTime, initialHourOfDay, afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(2, getRepeatInterval());
                }
                time = sTime.getTime();
            } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.YEAR)) {
                while (!sTime.getTime().after(afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(1, getRepeatInterval());
                }
                while (daylightSavingHourShiftOccurredAndAdvanceNeeded(sTime, initialHourOfDay, afterTime) && sTime.get(1) < YEAR_TO_GIVEUP_SCHEDULING_AT) {
                    sTime.add(1, getRepeatInterval());
                }
                time = sTime.getTime();
            }
        }
        if (ignoreEndTime || endMillis > time.getTime()) {
            return time;
        }
        return null;
    }

    private boolean daylightSavingHourShiftOccurredAndAdvanceNeeded(Calendar newTime, int initialHourOfDay, Date afterTime) {
        if (!isPreserveHourOfDayAcrossDaylightSavings() || newTime.get(11) == initialHourOfDay) {
            return false;
        }
        newTime.set(11, initialHourOfDay);
        if (newTime.get(11) != initialHourOfDay) {
            return isSkipDayIfHourDoesNotExist();
        }
        return !newTime.getTime().after(afterTime);
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getFinalFireTime() {
        if (this.complete || getEndTime() == null) {
            return null;
        }
        Date fTime = getFireTimeAfter(new Date(getEndTime().getTime() - 1000), true);
        if (fTime.equals(getEndTime())) {
            return fTime;
        }
        Calendar lTime = Calendar.getInstance();
        if (this.timeZone != null) {
            lTime.setTimeZone(this.timeZone);
        }
        lTime.setTime(fTime);
        lTime.setLenient(true);
        if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.SECOND)) {
            lTime.add(13, -1 * getRepeatInterval());
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.MINUTE)) {
            lTime.add(12, -1 * getRepeatInterval());
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.HOUR)) {
            lTime.add(11, -1 * getRepeatInterval());
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.DAY)) {
            lTime.add(6, -1 * getRepeatInterval());
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.WEEK)) {
            lTime.add(3, -1 * getRepeatInterval());
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.MONTH)) {
            lTime.add(2, -1 * getRepeatInterval());
        } else if (getRepeatIntervalUnit().equals(DateBuilder.IntervalUnit.YEAR)) {
            lTime.add(1, -1 * getRepeatInterval());
        }
        return lTime.getTime();
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public boolean mayFireAgain() {
        return getNextFireTime() != null;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void validate() throws SchedulerException {
        validate();
        if (this.repeatInterval < 1) {
            throw new SchedulerException("Repeat Interval cannot be zero.");
        }
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public ScheduleBuilder<CalendarIntervalTrigger> getScheduleBuilder() {
        CalendarIntervalScheduleBuilder cb = CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withInterval(getRepeatInterval(), getRepeatIntervalUnit());
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
}
