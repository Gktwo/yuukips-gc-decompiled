package org.quartz.impl.calendar;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;
import org.quartz.Calendar;
import org.quartz.CronExpression;

/* loaded from: grasscutter.jar:org/quartz/impl/calendar/CronCalendar.class */
public class CronCalendar extends BaseCalendar {
    static final long serialVersionUID = -8172103999750856831L;
    CronExpression cronExpression;

    public CronCalendar(String expression) throws ParseException {
        this(null, expression, null);
    }

    public CronCalendar(Calendar baseCalendar, String expression) throws ParseException {
        this(baseCalendar, expression, null);
    }

    public CronCalendar(Calendar baseCalendar, String expression, TimeZone timeZone) throws ParseException {
        super(baseCalendar);
        this.cronExpression = new CronExpression(expression);
        this.cronExpression.setTimeZone(timeZone);
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar, java.lang.Object
    public Object clone() {
        CronCalendar clone = (CronCalendar) clone();
        clone.cronExpression = new CronExpression(this.cronExpression);
        return clone;
    }

    @Override // org.quartz.impl.calendar.BaseCalendar
    public TimeZone getTimeZone() {
        return this.cronExpression.getTimeZone();
    }

    @Override // org.quartz.impl.calendar.BaseCalendar
    public void setTimeZone(TimeZone timeZone) {
        this.cronExpression.setTimeZone(timeZone);
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public boolean isTimeIncluded(long timeInMillis) {
        return (getBaseCalendar() == null || getBaseCalendar().isTimeIncluded(timeInMillis)) && !this.cronExpression.isSatisfiedBy(new Date(timeInMillis));
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public long getNextIncludedTime(long timeInMillis) {
        long nextIncludedTime = timeInMillis + 1;
        while (!isTimeIncluded(nextIncludedTime)) {
            if (this.cronExpression.isSatisfiedBy(new Date(nextIncludedTime))) {
                nextIncludedTime = this.cronExpression.getNextInvalidTimeAfter(new Date(nextIncludedTime)).getTime();
            } else if (getBaseCalendar() == null || getBaseCalendar().isTimeIncluded(nextIncludedTime)) {
                nextIncludedTime++;
            } else {
                nextIncludedTime = getBaseCalendar().getNextIncludedTime(nextIncludedTime);
            }
        }
        return nextIncludedTime;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("base calendar: [");
        if (getBaseCalendar() != null) {
            buffer.append(getBaseCalendar().toString());
        } else {
            buffer.append("null");
        }
        buffer.append("], excluded cron expression: '");
        buffer.append(this.cronExpression);
        buffer.append("'");
        return buffer.toString();
    }

    public CronExpression getCronExpression() {
        return this.cronExpression;
    }

    public void setCronExpression(String expression) throws ParseException {
        this.cronExpression = new CronExpression(expression);
    }

    public void setCronExpression(CronExpression expression) {
        if (expression == null) {
            throw new IllegalArgumentException("expression cannot be null");
        }
        this.cronExpression = expression;
    }
}
