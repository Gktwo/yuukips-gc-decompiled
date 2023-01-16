package org.quartz.impl.triggers;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.ScheduleBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/triggers/CronTriggerImpl.class */
public class CronTriggerImpl extends AbstractTrigger<CronTrigger> implements CronTrigger, CoreTrigger {
    private static final long serialVersionUID = -8644953146451592766L;
    private static final Logger LOGGER = LoggerFactory.getLogger(CronTriggerImpl.class);
    protected static final int YEAR_TO_GIVEUP_SCHEDULING_AT = CronExpression.MAX_YEAR;
    private CronExpression cronEx;
    private Date startTime;
    private Date endTime;
    private Date nextFireTime;
    private Date previousFireTime;
    private transient TimeZone timeZone;

    public CronTriggerImpl() {
        this.cronEx = null;
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.timeZone = null;
        setStartTime(new Date());
        setTimeZone(TimeZone.getDefault());
    }

    @Deprecated
    public CronTriggerImpl(String name) {
        this(name, null);
    }

    @Deprecated
    public CronTriggerImpl(String name, String group) {
        super(name, group);
        this.cronEx = null;
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.timeZone = null;
        setStartTime(new Date());
        setTimeZone(TimeZone.getDefault());
    }

    @Deprecated
    public CronTriggerImpl(String name, String group, String cronExpression) throws ParseException {
        super(name, group);
        this.cronEx = null;
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.timeZone = null;
        setCronExpression(cronExpression);
        setStartTime(new Date());
        setTimeZone(TimeZone.getDefault());
    }

    @Deprecated
    public CronTriggerImpl(String name, String group, String jobName, String jobGroup) {
        super(name, group, jobName, jobGroup);
        this.cronEx = null;
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.timeZone = null;
        setStartTime(new Date());
        setTimeZone(TimeZone.getDefault());
    }

    @Deprecated
    public CronTriggerImpl(String name, String group, String jobName, String jobGroup, String cronExpression) throws ParseException {
        this(name, group, jobName, jobGroup, null, null, cronExpression, TimeZone.getDefault());
    }

    @Deprecated
    public CronTriggerImpl(String name, String group, String jobName, String jobGroup, String cronExpression, TimeZone timeZone) throws ParseException {
        this(name, group, jobName, jobGroup, null, null, cronExpression, timeZone);
    }

    @Deprecated
    public CronTriggerImpl(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, String cronExpression) throws ParseException {
        super(name, group, jobName, jobGroup);
        this.cronEx = null;
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.timeZone = null;
        setCronExpression(cronExpression);
        setStartTime(startTime == null ? new Date() : startTime);
        if (endTime != null) {
            setEndTime(endTime);
        }
        setTimeZone(TimeZone.getDefault());
    }

    @Deprecated
    public CronTriggerImpl(String name, String group, String jobName, String jobGroup, Date startTime, Date endTime, String cronExpression, TimeZone timeZone) throws ParseException {
        super(name, group, jobName, jobGroup);
        this.cronEx = null;
        this.startTime = null;
        this.endTime = null;
        this.nextFireTime = null;
        this.previousFireTime = null;
        this.timeZone = null;
        setCronExpression(cronExpression);
        setStartTime(startTime == null ? new Date() : startTime);
        if (endTime != null) {
            setEndTime(endTime);
        }
        if (timeZone == null) {
            setTimeZone(TimeZone.getDefault());
        } else {
            setTimeZone(timeZone);
        }
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.MutableTrigger, java.lang.Object
    public Object clone() {
        CronTriggerImpl copy = (CronTriggerImpl) clone();
        if (this.cronEx != null) {
            copy.setCronExpression(new CronExpression(this.cronEx));
        }
        return copy;
    }

    public void setCronExpression(String cronExpression) throws ParseException {
        TimeZone origTz = getTimeZone();
        this.cronEx = new CronExpression(cronExpression);
        this.cronEx.setTimeZone(origTz);
    }

    @Override // org.quartz.CronTrigger
    public String getCronExpression() {
        if (this.cronEx == null) {
            return null;
        }
        return this.cronEx.getCronExpression();
    }

    public void setCronExpression(CronExpression cronExpression) {
        this.cronEx = cronExpression;
        this.timeZone = cronExpression.getTimeZone();
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
        if (eTime == null || !eTime.before(startTime)) {
            Calendar cl = Calendar.getInstance();
            cl.setTime(startTime);
            cl.set(14, 0);
            this.startTime = cl.getTime();
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

    @Override // org.quartz.CronTrigger
    public TimeZone getTimeZone() {
        if (this.cronEx != null) {
            return this.cronEx.getTimeZone();
        }
        if (this.timeZone == null) {
            this.timeZone = TimeZone.getDefault();
        }
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        if (this.cronEx != null) {
            this.cronEx.setTimeZone(timeZone);
        }
        this.timeZone = timeZone;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getFireTimeAfter(Date afterTime) {
        if (afterTime == null) {
            afterTime = new Date();
        }
        if (getStartTime().after(afterTime)) {
            afterTime = new Date(getStartTime().getTime() - 1000);
        }
        if (getEndTime() != null && afterTime.compareTo(getEndTime()) >= 0) {
            return null;
        }
        Date pot = getTimeAfter(afterTime);
        if (getEndTime() == null || pot == null || !pot.after(getEndTime())) {
            return pot;
        }
        return null;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public Date getFinalFireTime() {
        Date resultTime;
        if (getEndTime() != null) {
            resultTime = getTimeBefore(new Date(getEndTime().getTime() + 1000));
        } else {
            resultTime = this.cronEx == null ? null : this.cronEx.getFinalFireTime();
        }
        if (resultTime == null || getStartTime() == null || !resultTime.before(getStartTime())) {
            return resultTime;
        }
        return null;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public boolean mayFireAgain() {
        return getNextFireTime() != null;
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

    public boolean willFireOn(Calendar test) {
        return willFireOn(test, false);
    }

    public boolean willFireOn(Calendar test, boolean dayOnly) {
        Calendar test2 = (Calendar) test.clone();
        test2.set(14, 0);
        if (dayOnly) {
            test2.set(11, 0);
            test2.set(12, 0);
            test2.set(13, 0);
        }
        Date testTime = test2.getTime();
        Date fta = getFireTimeAfter(new Date(test2.getTime().getTime() - 1000));
        if (fta == null) {
            return false;
        }
        Calendar p = Calendar.getInstance(test2.getTimeZone());
        p.setTime(fta);
        int year = p.get(1);
        int month = p.get(2);
        int day = p.get(5);
        if (dayOnly) {
            return year == test2.get(1) && month == test2.get(2) && day == test2.get(5);
        }
        while (fta.before(testTime)) {
            fta = getFireTimeAfter(fta);
        }
        return fta.equals(testTime);
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.spi.OperableTrigger
    public void triggered(org.quartz.Calendar calendar) {
        this.previousFireTime = this.nextFireTime;
        this.nextFireTime = getFireTimeAfter(this.nextFireTime);
        while (this.nextFireTime != null && calendar != null && !calendar.isTimeIncluded(this.nextFireTime.getTime())) {
            this.nextFireTime = getFireTimeAfter(this.nextFireTime);
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
                    Calendar c = new GregorianCalendar();
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
        }
        return this.nextFireTime;
    }

    @Override // org.quartz.CronTrigger
    public String getExpressionSummary() {
        if (this.cronEx == null) {
            return null;
        }
        return this.cronEx.getExpressionSummary();
    }

    @Override // org.quartz.impl.triggers.CoreTrigger
    public boolean hasAdditionalProperties() {
        return false;
    }

    @Override // org.quartz.impl.triggers.AbstractTrigger, org.quartz.Trigger
    public ScheduleBuilder<CronTrigger> getScheduleBuilder() {
        CronScheduleBuilder cb = CronScheduleBuilder.cronSchedule(getCronExpression()).inTimeZone(getTimeZone());
        int misfireInstruction = getMisfireInstruction();
        switch (misfireInstruction) {
            case -1:
                cb.withMisfireHandlingInstructionIgnoreMisfires();
                break;
            case 0:
                break;
            case 1:
                cb.withMisfireHandlingInstructionFireAndProceed();
                break;
            case 2:
                cb.withMisfireHandlingInstructionDoNothing();
                break;
            default:
                LOGGER.warn("Unrecognized misfire policy {}. Derived builder will use the default cron trigger behavior (MISFIRE_INSTRUCTION_FIRE_ONCE_NOW)", Integer.valueOf(misfireInstruction));
                break;
        }
        return cb;
    }

    protected Date getTimeAfter(Date afterTime) {
        if (this.cronEx == null) {
            return null;
        }
        return this.cronEx.getTimeAfter(afterTime);
    }

    protected Date getTimeBefore(Date eTime) {
        if (this.cronEx == null) {
            return null;
        }
        return this.cronEx.getTimeBefore(eTime);
    }
}
