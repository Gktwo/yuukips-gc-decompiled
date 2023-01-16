package org.quartz.impl.calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;
import org.quartz.Calendar;

/* loaded from: grasscutter.jar:org/quartz/impl/calendar/BaseCalendar.class */
public class BaseCalendar implements Calendar, Serializable, Cloneable {
    static final long serialVersionUID = 3106623404629760239L;
    private Calendar baseCalendar;
    private String description;
    private TimeZone timeZone;

    public BaseCalendar() {
    }

    public BaseCalendar(Calendar baseCalendar) {
        setBaseCalendar(baseCalendar);
    }

    public BaseCalendar(TimeZone timeZone) {
        setTimeZone(timeZone);
    }

    public BaseCalendar(Calendar baseCalendar, TimeZone timeZone) {
        setBaseCalendar(baseCalendar);
        setTimeZone(timeZone);
    }

    @Override // org.quartz.Calendar, java.lang.Object
    public Object clone() {
        try {
            BaseCalendar clone = (BaseCalendar) clone();
            if (getBaseCalendar() != null) {
                clone.baseCalendar = (Calendar) getBaseCalendar().clone();
            }
            if (getTimeZone() != null) {
                clone.timeZone = (TimeZone) getTimeZone().clone();
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new IncompatibleClassChangeError("Not Cloneable.");
        }
    }

    @Override // org.quartz.Calendar
    public void setBaseCalendar(Calendar baseCalendar) {
        this.baseCalendar = baseCalendar;
    }

    @Override // org.quartz.Calendar
    public Calendar getBaseCalendar() {
        return this.baseCalendar;
    }

    @Override // org.quartz.Calendar
    public String getDescription() {
        return this.description;
    }

    @Override // org.quartz.Calendar
    public void setDescription(String description) {
        this.description = description;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override // org.quartz.Calendar
    public boolean isTimeIncluded(long timeStamp) {
        if (timeStamp > 0) {
            return this.baseCalendar == null || this.baseCalendar.isTimeIncluded(timeStamp);
        }
        throw new IllegalArgumentException("timeStamp must be greater 0");
    }

    @Override // org.quartz.Calendar
    public long getNextIncludedTime(long timeStamp) {
        if (timeStamp <= 0) {
            throw new IllegalArgumentException("timeStamp must be greater 0");
        } else if (this.baseCalendar != null) {
            return this.baseCalendar.getNextIncludedTime(timeStamp);
        } else {
            return timeStamp;
        }
    }

    protected java.util.Calendar createJavaCalendar(long timeStamp) {
        java.util.Calendar calendar = createJavaCalendar();
        calendar.setTime(new Date(timeStamp));
        return calendar;
    }

    protected java.util.Calendar createJavaCalendar() {
        return getTimeZone() == null ? java.util.Calendar.getInstance() : java.util.Calendar.getInstance(getTimeZone());
    }

    protected java.util.Calendar getStartOfDayJavaCalendar(long timeInMillis) {
        java.util.Calendar startOfDay = createJavaCalendar(timeInMillis);
        startOfDay.set(11, 0);
        startOfDay.set(12, 0);
        startOfDay.set(13, 0);
        startOfDay.set(14, 0);
        return startOfDay;
    }

    protected java.util.Calendar getEndOfDayJavaCalendar(long timeInMillis) {
        java.util.Calendar endOfDay = createJavaCalendar(timeInMillis);
        endOfDay.set(11, 23);
        endOfDay.set(12, 59);
        endOfDay.set(13, 59);
        endOfDay.set(14, 999);
        return endOfDay;
    }
}
