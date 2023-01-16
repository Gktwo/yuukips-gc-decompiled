package org.quartz.impl.calendar;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.quartz.Calendar;

/* loaded from: grasscutter.jar:org/quartz/impl/calendar/DailyCalendar.class */
public class DailyCalendar extends BaseCalendar {
    static final long serialVersionUID = -7561220099904944039L;
    private static final String invalidHourOfDay = "Invalid hour of day: ";
    private static final String invalidMinute = "Invalid minute: ";
    private static final String invalidSecond = "Invalid second: ";
    private static final String invalidMillis = "Invalid millis: ";
    private static final String invalidTimeRange = "Invalid time range: ";
    private static final String separator = " - ";
    private static final long oneMillis = 1;
    private static final String colon = ":";
    private int rangeStartingHourOfDay;
    private int rangeStartingMinute;
    private int rangeStartingSecond;
    private int rangeStartingMillis;
    private int rangeEndingHourOfDay;
    private int rangeEndingMinute;
    private int rangeEndingSecond;
    private int rangeEndingMillis;
    private boolean invertTimeRange = false;

    public DailyCalendar(String rangeStartingTime, String rangeEndingTime) {
        setTimeRange(rangeStartingTime, rangeEndingTime);
    }

    public DailyCalendar(Calendar baseCalendar, String rangeStartingTime, String rangeEndingTime) {
        super(baseCalendar);
        setTimeRange(rangeStartingTime, rangeEndingTime);
    }

    public DailyCalendar(int rangeStartingHourOfDay, int rangeStartingMinute, int rangeStartingSecond, int rangeStartingMillis, int rangeEndingHourOfDay, int rangeEndingMinute, int rangeEndingSecond, int rangeEndingMillis) {
        setTimeRange(rangeStartingHourOfDay, rangeStartingMinute, rangeStartingSecond, rangeStartingMillis, rangeEndingHourOfDay, rangeEndingMinute, rangeEndingSecond, rangeEndingMillis);
    }

    public DailyCalendar(Calendar baseCalendar, int rangeStartingHourOfDay, int rangeStartingMinute, int rangeStartingSecond, int rangeStartingMillis, int rangeEndingHourOfDay, int rangeEndingMinute, int rangeEndingSecond, int rangeEndingMillis) {
        super(baseCalendar);
        setTimeRange(rangeStartingHourOfDay, rangeStartingMinute, rangeStartingSecond, rangeStartingMillis, rangeEndingHourOfDay, rangeEndingMinute, rangeEndingSecond, rangeEndingMillis);
    }

    public DailyCalendar(java.util.Calendar rangeStartingCalendar, java.util.Calendar rangeEndingCalendar) {
        setTimeRange(rangeStartingCalendar, rangeEndingCalendar);
    }

    public DailyCalendar(Calendar baseCalendar, java.util.Calendar rangeStartingCalendar, java.util.Calendar rangeEndingCalendar) {
        super(baseCalendar);
        setTimeRange(rangeStartingCalendar, rangeEndingCalendar);
    }

    public DailyCalendar(long rangeStartingTimeInMillis, long rangeEndingTimeInMillis) {
        setTimeRange(rangeStartingTimeInMillis, rangeEndingTimeInMillis);
    }

    public DailyCalendar(Calendar baseCalendar, long rangeStartingTimeInMillis, long rangeEndingTimeInMillis) {
        super(baseCalendar);
        setTimeRange(rangeStartingTimeInMillis, rangeEndingTimeInMillis);
    }

    public DailyCalendar(TimeZone timeZone, long rangeStartingTimeInMillis, long rangeEndingTimeInMillis) {
        super(timeZone);
        setTimeRange(rangeStartingTimeInMillis, rangeEndingTimeInMillis);
    }

    public DailyCalendar(Calendar baseCalendar, TimeZone timeZone, long rangeStartingTimeInMillis, long rangeEndingTimeInMillis) {
        super(baseCalendar, timeZone);
        setTimeRange(rangeStartingTimeInMillis, rangeEndingTimeInMillis);
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar, java.lang.Object
    public Object clone() {
        return (DailyCalendar) clone();
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public boolean isTimeIncluded(long timeInMillis) {
        if (getBaseCalendar() != null && !getBaseCalendar().isTimeIncluded(timeInMillis)) {
            return false;
        }
        long startOfDayInMillis = getStartOfDayJavaCalendar(timeInMillis).getTime().getTime();
        long endOfDayInMillis = getEndOfDayJavaCalendar(timeInMillis).getTime().getTime();
        long timeRangeStartingTimeInMillis = getTimeRangeStartingTimeInMillis(timeInMillis);
        long timeRangeEndingTimeInMillis = getTimeRangeEndingTimeInMillis(timeInMillis);
        return !this.invertTimeRange ? (timeInMillis > startOfDayInMillis && timeInMillis < timeRangeStartingTimeInMillis) || (timeInMillis > timeRangeEndingTimeInMillis && timeInMillis < endOfDayInMillis) : timeInMillis >= timeRangeStartingTimeInMillis && timeInMillis <= timeRangeEndingTimeInMillis;
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public long getNextIncludedTime(long timeInMillis) {
        long nextIncludedTime = timeInMillis + oneMillis;
        while (!isTimeIncluded(nextIncludedTime)) {
            if (!this.invertTimeRange) {
                if (nextIncludedTime >= getTimeRangeStartingTimeInMillis(nextIncludedTime) && nextIncludedTime <= getTimeRangeEndingTimeInMillis(nextIncludedTime)) {
                    nextIncludedTime = getTimeRangeEndingTimeInMillis(nextIncludedTime) + oneMillis;
                } else if (getBaseCalendar() == null || getBaseCalendar().isTimeIncluded(nextIncludedTime)) {
                    nextIncludedTime += oneMillis;
                } else {
                    nextIncludedTime = getBaseCalendar().getNextIncludedTime(nextIncludedTime);
                }
            } else if (nextIncludedTime < getTimeRangeStartingTimeInMillis(nextIncludedTime)) {
                nextIncludedTime = getTimeRangeStartingTimeInMillis(nextIncludedTime);
            } else if (nextIncludedTime > getTimeRangeEndingTimeInMillis(nextIncludedTime)) {
                nextIncludedTime = getEndOfDayJavaCalendar(nextIncludedTime).getTime().getTime() + oneMillis;
            } else if (getBaseCalendar() == null || getBaseCalendar().isTimeIncluded(nextIncludedTime)) {
                nextIncludedTime += oneMillis;
            } else {
                nextIncludedTime = getBaseCalendar().getNextIncludedTime(nextIncludedTime);
            }
        }
        return nextIncludedTime;
    }

    public long getTimeRangeStartingTimeInMillis(long timeInMillis) {
        java.util.Calendar rangeStartingTime = createJavaCalendar(timeInMillis);
        rangeStartingTime.set(11, this.rangeStartingHourOfDay);
        rangeStartingTime.set(12, this.rangeStartingMinute);
        rangeStartingTime.set(13, this.rangeStartingSecond);
        rangeStartingTime.set(14, this.rangeStartingMillis);
        return rangeStartingTime.getTime().getTime();
    }

    public long getTimeRangeEndingTimeInMillis(long timeInMillis) {
        java.util.Calendar rangeEndingTime = createJavaCalendar(timeInMillis);
        rangeEndingTime.set(11, this.rangeEndingHourOfDay);
        rangeEndingTime.set(12, this.rangeEndingMinute);
        rangeEndingTime.set(13, this.rangeEndingSecond);
        rangeEndingTime.set(14, this.rangeEndingMillis);
        return rangeEndingTime.getTime().getTime();
    }

    public boolean getInvertTimeRange() {
        return this.invertTimeRange;
    }

    public void setInvertTimeRange(boolean flag) {
        this.invertTimeRange = flag;
    }

    @Override // java.lang.Object
    public String toString() {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        numberFormatter.setMaximumFractionDigits(0);
        numberFormatter.setMinimumIntegerDigits(2);
        StringBuffer buffer = new StringBuffer();
        buffer.append("base calendar: [");
        if (getBaseCalendar() != null) {
            buffer.append(getBaseCalendar().toString());
        } else {
            buffer.append("null");
        }
        buffer.append("], time range: '");
        buffer.append(numberFormatter.format((long) this.rangeStartingHourOfDay));
        buffer.append(":");
        buffer.append(numberFormatter.format((long) this.rangeStartingMinute));
        buffer.append(":");
        buffer.append(numberFormatter.format((long) this.rangeStartingSecond));
        buffer.append(":");
        numberFormatter.setMinimumIntegerDigits(3);
        buffer.append(numberFormatter.format((long) this.rangeStartingMillis));
        numberFormatter.setMinimumIntegerDigits(2);
        buffer.append(separator);
        buffer.append(numberFormatter.format((long) this.rangeEndingHourOfDay));
        buffer.append(":");
        buffer.append(numberFormatter.format((long) this.rangeEndingMinute));
        buffer.append(":");
        buffer.append(numberFormatter.format((long) this.rangeEndingSecond));
        buffer.append(":");
        numberFormatter.setMinimumIntegerDigits(3);
        buffer.append(numberFormatter.format((long) this.rangeEndingMillis));
        buffer.append("', inverted: " + this.invertTimeRange + "]");
        return buffer.toString();
    }

    private String[] split(String string, String delim) {
        ArrayList<String> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(string, delim);
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    public void setTimeRange(String rangeStartingTimeString, String rangeEndingTimeString) {
        int rStartingSecond;
        int rStartingMillis;
        int rEndingSecond;
        int rEndingMillis;
        String[] rangeStartingTime = split(rangeStartingTimeString, ":");
        if (rangeStartingTime.length < 2 || rangeStartingTime.length > 4) {
            throw new IllegalArgumentException("Invalid time string '" + rangeStartingTimeString + "'");
        }
        int rStartingHourOfDay = Integer.parseInt(rangeStartingTime[0]);
        int rStartingMinute = Integer.parseInt(rangeStartingTime[1]);
        if (rangeStartingTime.length > 2) {
            rStartingSecond = Integer.parseInt(rangeStartingTime[2]);
        } else {
            rStartingSecond = 0;
        }
        if (rangeStartingTime.length == 4) {
            rStartingMillis = Integer.parseInt(rangeStartingTime[3]);
        } else {
            rStartingMillis = 0;
        }
        String[] rEndingTime = split(rangeEndingTimeString, ":");
        if (rEndingTime.length < 2 || rEndingTime.length > 4) {
            throw new IllegalArgumentException("Invalid time string '" + rangeEndingTimeString + "'");
        }
        int rEndingHourOfDay = Integer.parseInt(rEndingTime[0]);
        int rEndingMinute = Integer.parseInt(rEndingTime[1]);
        if (rEndingTime.length > 2) {
            rEndingSecond = Integer.parseInt(rEndingTime[2]);
        } else {
            rEndingSecond = 0;
        }
        if (rEndingTime.length == 4) {
            rEndingMillis = Integer.parseInt(rEndingTime[3]);
        } else {
            rEndingMillis = 0;
        }
        setTimeRange(rStartingHourOfDay, rStartingMinute, rStartingSecond, rStartingMillis, rEndingHourOfDay, rEndingMinute, rEndingSecond, rEndingMillis);
    }

    public void setTimeRange(int rangeStartingHourOfDay, int rangeStartingMinute, int rangeStartingSecond, int rangeStartingMillis, int rangeEndingHourOfDay, int rangeEndingMinute, int rangeEndingSecond, int rangeEndingMillis) {
        validate(rangeStartingHourOfDay, rangeStartingMinute, rangeStartingSecond, rangeStartingMillis);
        validate(rangeEndingHourOfDay, rangeEndingMinute, rangeEndingSecond, rangeEndingMillis);
        java.util.Calendar startCal = createJavaCalendar();
        startCal.set(11, rangeStartingHourOfDay);
        startCal.set(12, rangeStartingMinute);
        startCal.set(13, rangeStartingSecond);
        startCal.set(14, rangeStartingMillis);
        java.util.Calendar endCal = createJavaCalendar();
        endCal.set(11, rangeEndingHourOfDay);
        endCal.set(12, rangeEndingMinute);
        endCal.set(13, rangeEndingSecond);
        endCal.set(14, rangeEndingMillis);
        if (!startCal.before(endCal)) {
            throw new IllegalArgumentException(invalidTimeRange + rangeStartingHourOfDay + ":" + rangeStartingMinute + ":" + rangeStartingSecond + ":" + rangeStartingMillis + separator + rangeEndingHourOfDay + ":" + rangeEndingMinute + ":" + rangeEndingSecond + ":" + rangeEndingMillis);
        }
        this.rangeStartingHourOfDay = rangeStartingHourOfDay;
        this.rangeStartingMinute = rangeStartingMinute;
        this.rangeStartingSecond = rangeStartingSecond;
        this.rangeStartingMillis = rangeStartingMillis;
        this.rangeEndingHourOfDay = rangeEndingHourOfDay;
        this.rangeEndingMinute = rangeEndingMinute;
        this.rangeEndingSecond = rangeEndingSecond;
        this.rangeEndingMillis = rangeEndingMillis;
    }

    public void setTimeRange(java.util.Calendar rangeStartingCalendar, java.util.Calendar rangeEndingCalendar) {
        setTimeRange(rangeStartingCalendar.get(11), rangeStartingCalendar.get(12), rangeStartingCalendar.get(13), rangeStartingCalendar.get(14), rangeEndingCalendar.get(11), rangeEndingCalendar.get(12), rangeEndingCalendar.get(13), rangeEndingCalendar.get(14));
    }

    public void setTimeRange(long rangeStartingTime, long rangeEndingTime) {
        setTimeRange(createJavaCalendar(rangeStartingTime), createJavaCalendar(rangeEndingTime));
    }

    private void validate(int hourOfDay, int minute, int second, int millis) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            throw new IllegalArgumentException(invalidHourOfDay + hourOfDay);
        } else if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException(invalidMinute + minute);
        } else if (second < 0 || second > 59) {
            throw new IllegalArgumentException(invalidSecond + second);
        } else if (millis < 0 || millis > 999) {
            throw new IllegalArgumentException(invalidMillis + millis);
        }
    }
}
