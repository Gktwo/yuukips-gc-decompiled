package org.quartz.impl.triggers;

import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.LongCompanionObject;
import org.quartz.ScheduleBuilder;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;

/* loaded from: grasscutter.jar:org/quartz/impl/triggers/SimpleTriggerImpl.class */
public class SimpleTriggerImpl extends AbstractTrigger<SimpleTrigger> implements SimpleTrigger, CoreTrigger {
    private static final long serialVersionUID = -3735980074222850397L;
    private static final int YEAR_TO_GIVEUP_SCHEDULING_AT = Calendar.getInstance().get(1) + 100;
    private Date startTime;
    private Date endTime;
    private Date nextFireTime;
    private Date previousFireTime;
    private int repeatCount;
    private long repeatInterval;
    private int timesTriggered;
    private boolean complete;

    public SimpleTriggerImpl() {
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatCount = 0;
        this.repeatInterval = 0;
        this.timesTriggered = 0;
        this.complete = false;
    }

    @Deprecated
    public SimpleTriggerImpl(String name) {
        this(name, (String) null);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, String group) {
        this(name, group, new Date(), null, 0, 0);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, int repeatCount, long repeatInterval) {
        this(name, null, repeatCount, repeatInterval);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, String group, int repeatCount, long repeatInterval) {
        this(name, group, new Date(), null, repeatCount, repeatInterval);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, Date startTime) {
        this(name, (String) null, startTime);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, String group, Date startTime) {
        this(name, group, startTime, null, 0, 0);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, Date startTime, Date endTime, int repeatCount, long repeatInterval) {
        this(name, null, startTime, endTime, repeatCount, repeatInterval);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, String group, Date startTime, Date endTime, int repeatCount, long repeatInterval) {
        super(name, group);
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatCount = 0;
        this.repeatInterval = 0;
        this.timesTriggered = 0;
        this.complete = false;
        setStartTime(startTime);
        setEndTime(endTime);
        setRepeatCount(repeatCount);
        setRepeatInterval(repeatInterval);
    }

    @Deprecated
    public SimpleTriggerImpl(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, int repeatCount, long repeatInterval) {
        super(name, group, jobName, jobGroup);
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.repeatCount = 0;
        this.repeatInterval = 0;
        this.timesTriggered = 0;
        this.complete = false;
        setStartTime(startTime);
        setEndTime(endTime);
        setRepeatCount(repeatCount);
        setRepeatInterval(repeatInterval);
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getStartTime() {
        return this.startTime;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.MutableTrigger
    public void setStartTime(Date startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
        Date eTime = getEndTime();
        if (eTime == null || startTime == null || !eTime.before(startTime)) {
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

    @Override // org.quartz.SimpleTrigger
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

    @Override // org.quartz.SimpleTrigger
    public long getRepeatInterval() {
        return this.repeatInterval;
    }

    public void setRepeatInterval(long repeatInterval) {
        if (repeatInterval < 0) {
            throw new IllegalArgumentException("Repeat interval must be >= 0");
        }
        this.repeatInterval = repeatInterval;
    }

    @Override // org.quartz.SimpleTrigger
    public int getTimesTriggered() {
        return this.timesTriggered;
    }

    public void setTimesTriggered(int timesTriggered) {
        this.timesTriggered = timesTriggered;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger
    protected boolean validateMisfireInstruction(int misfireInstruction) {
        if (misfireInstruction >= -1 && misfireInstruction <= 5) {
            return true;
        }
        return false;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void updateAfterMisfire(org.quartz.Calendar cal) {
        int instr = getMisfireInstruction();
        if (instr != -1) {
            if (instr == 0) {
                instr = getRepeatCount() == 0 ? 1 : getRepeatCount() == -1 ? 4 : 2;
            } else if (instr == 1 && getRepeatCount() != 0) {
                instr = 3;
            }
            if (instr == 1) {
                setNextFireTime(new Date());
            } else if (instr == 5) {
                Date newFireTime = getFireTimeAfter(new Date());
                while (newFireTime != null && cal != null && !cal.isTimeIncluded(newFireTime.getTime())) {
                    newFireTime = getFireTimeAfter(newFireTime);
                    if (newFireTime == null) {
                        break;
                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(newFireTime);
                    if (c.get(1) > YEAR_TO_GIVEUP_SCHEDULING_AT) {
                        newFireTime = null;
                    }
                }
                setNextFireTime(newFireTime);
            } else if (instr == 4) {
                Date newFireTime2 = getFireTimeAfter(new Date());
                while (newFireTime2 != null && cal != null && !cal.isTimeIncluded(newFireTime2.getTime())) {
                    newFireTime2 = getFireTimeAfter(newFireTime2);
                    if (newFireTime2 == null) {
                        break;
                    }
                    Calendar c2 = Calendar.getInstance();
                    c2.setTime(newFireTime2);
                    if (c2.get(1) > YEAR_TO_GIVEUP_SCHEDULING_AT) {
                        newFireTime2 = null;
                    }
                }
                if (newFireTime2 != null) {
                    setTimesTriggered(getTimesTriggered() + computeNumTimesFiredBetween(this.nextFireTime, newFireTime2));
                }
                setNextFireTime(newFireTime2);
            } else if (instr == 2) {
                Date newFireTime3 = new Date();
                if (!(this.repeatCount == 0 || this.repeatCount == -1)) {
                    setRepeatCount(getRepeatCount() - getTimesTriggered());
                    setTimesTriggered(0);
                }
                if (getEndTime() == null || !getEndTime().before(newFireTime3)) {
                    setStartTime(newFireTime3);
                    setNextFireTime(newFireTime3);
                    return;
                }
                setNextFireTime(null);
            } else if (instr == 3) {
                Date newFireTime4 = new Date();
                int timesMissed = computeNumTimesFiredBetween(this.nextFireTime, newFireTime4);
                if (!(this.repeatCount == 0 || this.repeatCount == -1)) {
                    int remainingCount = getRepeatCount() - (getTimesTriggered() + timesMissed);
                    if (remainingCount <= 0) {
                        remainingCount = 0;
                    }
                    setRepeatCount(remainingCount);
                    setTimesTriggered(0);
                }
                if (getEndTime() == null || !getEndTime().before(newFireTime4)) {
                    setStartTime(newFireTime4);
                    setNextFireTime(newFireTime4);
                    return;
                }
                setNextFireTime(null);
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
        if (this.complete) {
            return null;
        }
        if (this.timesTriggered > this.repeatCount && this.repeatCount != -1) {
            return null;
        }
        if (afterTime == null) {
            afterTime = new Date();
        }
        if (this.repeatCount == 0 && afterTime.compareTo(getStartTime()) >= 0) {
            return null;
        }
        long startMillis = getStartTime().getTime();
        long afterMillis = afterTime.getTime();
        long endMillis = getEndTime() == null ? LongCompanionObject.MAX_VALUE : getEndTime().getTime();
        if (endMillis <= afterMillis) {
            return null;
        }
        if (afterMillis < startMillis) {
            return new Date(startMillis);
        }
        long numberOfTimesExecuted = ((afterMillis - startMillis) / this.repeatInterval) + 1;
        if (numberOfTimesExecuted > ((long) this.repeatCount) && this.repeatCount != -1) {
            return null;
        }
        Date time = new Date(startMillis + (numberOfTimesExecuted * this.repeatInterval));
        if (endMillis <= time.getTime()) {
            return null;
        }
        return time;
    }

    public Date getFireTimeBefore(Date end) {
        if (end.getTime() < getStartTime().getTime()) {
            return null;
        }
        return new Date(getStartTime().getTime() + (((long) computeNumTimesFiredBetween(getStartTime(), end)) * this.repeatInterval));
    }

    public int computeNumTimesFiredBetween(Date start, Date end) {
        if (this.repeatInterval < 1) {
            return 0;
        }
        return (int) ((end.getTime() - start.getTime()) / this.repeatInterval);
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getFinalFireTime() {
        if (this.repeatCount == 0) {
            return this.startTime;
        }
        if (this.repeatCount != -1) {
            long lastTrigger = this.startTime.getTime() + (((long) this.repeatCount) * this.repeatInterval);
            if (getEndTime() == null || lastTrigger < getEndTime().getTime()) {
                return new Date(lastTrigger);
            }
            return getFireTimeBefore(getEndTime());
        } else if (getEndTime() == null) {
            return null;
        } else {
            return getFireTimeBefore(getEndTime());
        }
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public boolean mayFireAgain() {
        return getNextFireTime() != null;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void validate() throws SchedulerException {
        validate();
        if (this.repeatCount != 0 && this.repeatInterval < 1) {
            throw new SchedulerException("Repeat Interval cannot be zero.");
        }
    }

    @Override // org.quartz.impl.triggers.CoreTrigger
    public boolean hasAdditionalProperties() {
        return false;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public ScheduleBuilder<SimpleTrigger> getScheduleBuilder() {
        SimpleScheduleBuilder sb = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(getRepeatInterval()).withRepeatCount(getRepeatCount());
        switch (getMisfireInstruction()) {
            case 1:
                sb.withMisfireHandlingInstructionFireNow();
                break;
            case 2:
                sb.withMisfireHandlingInstructionNowWithExistingCount();
                break;
            case 3:
                sb.withMisfireHandlingInstructionNowWithRemainingCount();
                break;
            case 4:
                sb.withMisfireHandlingInstructionNextWithRemainingCount();
                break;
            case 5:
                sb.withMisfireHandlingInstructionNextWithExistingCount();
                break;
        }
        return sb;
    }
}
