package org.quartz;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: grasscutter.jar:org/quartz/DateBuilder.class */
public class DateBuilder {
    public static final int SUNDAY = 1;
    public static final int MONDAY = 2;
    public static final int TUESDAY = 3;
    public static final int WEDNESDAY = 4;
    public static final int THURSDAY = 5;
    public static final int FRIDAY = 6;
    public static final int SATURDAY = 7;
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;
    public static final long MILLISECONDS_IN_MINUTE = 60000;
    public static final long MILLISECONDS_IN_HOUR = 3600000;
    public static final long SECONDS_IN_MOST_DAYS = 86400;
    public static final long MILLISECONDS_IN_DAY = 86400000;
    private int month;
    private int day;
    private int year;
    private int hour;
    private int minute;
    private int second;

    /* renamed from: tz */
    private TimeZone f3328tz;

    /* renamed from: lc */
    private Locale f3329lc;
    private static final int MAX_YEAR = Calendar.getInstance().get(1) + 100;

    /* loaded from: grasscutter.jar:org/quartz/DateBuilder$IntervalUnit.class */
    public enum IntervalUnit {
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    private DateBuilder() {
        Calendar cal = Calendar.getInstance();
        this.month = cal.get(2) + 1;
        this.day = cal.get(5);
        this.year = cal.get(1);
        this.hour = cal.get(11);
        this.minute = cal.get(12);
        this.second = cal.get(13);
    }

    private DateBuilder(TimeZone tz) {
        Calendar cal = Calendar.getInstance(tz);
        this.f3328tz = tz;
        this.month = cal.get(2) + 1;
        this.day = cal.get(5);
        this.year = cal.get(1);
        this.hour = cal.get(11);
        this.minute = cal.get(12);
        this.second = cal.get(13);
    }

    private DateBuilder(Locale lc) {
        Calendar cal = Calendar.getInstance(lc);
        this.f3329lc = lc;
        this.month = cal.get(2) + 1;
        this.day = cal.get(5);
        this.year = cal.get(1);
        this.hour = cal.get(11);
        this.minute = cal.get(12);
        this.second = cal.get(13);
    }

    private DateBuilder(TimeZone tz, Locale lc) {
        Calendar cal = Calendar.getInstance(tz, lc);
        this.f3328tz = tz;
        this.f3329lc = lc;
        this.month = cal.get(2) + 1;
        this.day = cal.get(5);
        this.year = cal.get(1);
        this.hour = cal.get(11);
        this.minute = cal.get(12);
        this.second = cal.get(13);
    }

    public static DateBuilder newDate() {
        return new DateBuilder();
    }

    public static DateBuilder newDateInTimezone(TimeZone tz) {
        return new DateBuilder(tz);
    }

    public static DateBuilder newDateInLocale(Locale lc) {
        return new DateBuilder(lc);
    }

    public static DateBuilder newDateInTimeZoneAndLocale(TimeZone tz, Locale lc) {
        return new DateBuilder(tz, lc);
    }

    public Date build() {
        Calendar cal;
        if (this.f3328tz != null && this.f3329lc != null) {
            cal = Calendar.getInstance(this.f3328tz, this.f3329lc);
        } else if (this.f3328tz != null) {
            cal = Calendar.getInstance(this.f3328tz);
        } else if (this.f3329lc != null) {
            cal = Calendar.getInstance(this.f3329lc);
        } else {
            cal = Calendar.getInstance();
        }
        cal.set(1, this.year);
        cal.set(2, this.month - 1);
        cal.set(5, this.day);
        cal.set(11, this.hour);
        cal.set(12, this.minute);
        cal.set(13, this.second);
        cal.set(14, 0);
        return cal.getTime();
    }

    public DateBuilder atHourOfDay(int atHour) {
        validateHour(atHour);
        this.hour = atHour;
        return this;
    }

    public DateBuilder atMinute(int atMinute) {
        validateMinute(atMinute);
        this.minute = atMinute;
        return this;
    }

    public DateBuilder atSecond(int atSecond) {
        validateSecond(atSecond);
        this.second = atSecond;
        return this;
    }

    public DateBuilder atHourMinuteAndSecond(int atHour, int atMinute, int atSecond) {
        validateHour(atHour);
        validateMinute(atMinute);
        validateSecond(atSecond);
        this.hour = atHour;
        this.second = atSecond;
        this.minute = atMinute;
        return this;
    }

    public DateBuilder onDay(int onDay) {
        validateDayOfMonth(onDay);
        this.day = onDay;
        return this;
    }

    public DateBuilder inMonth(int inMonth) {
        validateMonth(inMonth);
        this.month = inMonth;
        return this;
    }

    public DateBuilder inMonthOnDay(int inMonth, int onDay) {
        validateMonth(inMonth);
        validateDayOfMonth(onDay);
        this.month = inMonth;
        this.day = onDay;
        return this;
    }

    public DateBuilder inYear(int inYear) {
        validateYear(inYear);
        this.year = inYear;
        return this;
    }

    public DateBuilder inTimeZone(TimeZone timezone) {
        this.f3328tz = timezone;
        return this;
    }

    public DateBuilder inLocale(Locale locale) {
        this.f3329lc = locale;
        return this;
    }

    public static Date futureDate(int interval, IntervalUnit unit) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.setLenient(true);
        c.add(translate(unit), interval);
        return c.getTime();
    }

    private static int translate(IntervalUnit unit) {
        switch (unit) {
            case DAY:
                return 6;
            case HOUR:
                return 11;
            case MINUTE:
                return 12;
            case MONTH:
                return 2;
            case SECOND:
                return 13;
            case MILLISECOND:
                return 14;
            case WEEK:
                return 3;
            case YEAR:
                return 1;
            default:
                throw new IllegalArgumentException("Unknown IntervalUnit");
        }
    }

    public static Date tomorrowAt(int hour, int minute, int second) {
        validateSecond(second);
        validateMinute(minute);
        validateHour(hour);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setLenient(true);
        c.add(6, 1);
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, second);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date todayAt(int hour, int minute, int second) {
        return dateOf(hour, minute, second);
    }

    public static Date dateOf(int hour, int minute, int second) {
        validateSecond(second);
        validateMinute(minute);
        validateHour(hour);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setLenient(true);
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, second);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date dateOf(int hour, int minute, int second, int dayOfMonth, int month) {
        validateSecond(second);
        validateMinute(minute);
        validateHour(hour);
        validateDayOfMonth(dayOfMonth);
        validateMonth(month);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(2, month - 1);
        c.set(5, dayOfMonth);
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, second);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date dateOf(int hour, int minute, int second, int dayOfMonth, int month, int year) {
        validateSecond(second);
        validateMinute(minute);
        validateHour(hour);
        validateDayOfMonth(dayOfMonth);
        validateMonth(month);
        validateYear(year);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(1, year);
        c.set(2, month - 1);
        c.set(5, dayOfMonth);
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, second);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date evenHourDateAfterNow() {
        return evenHourDate(null);
    }

    public static Date evenHourDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setLenient(true);
        c.set(11, c.get(11) + 1);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date evenHourDateBefore(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date evenMinuteDateAfterNow() {
        return evenMinuteDate(null);
    }

    public static Date evenMinuteDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setLenient(true);
        c.set(12, c.get(12) + 1);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date evenMinuteDateBefore(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date evenSecondDateAfterNow() {
        return evenSecondDate(null);
    }

    public static Date evenSecondDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setLenient(true);
        c.set(13, c.get(13) + 1);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date evenSecondDateBefore(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date nextGivenMinuteDate(Date date, int minuteBase) {
        if (minuteBase < 0 || minuteBase > 59) {
            throw new IllegalArgumentException("minuteBase must be >=0 and <= 59");
        }
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setLenient(true);
        if (minuteBase == 0) {
            c.set(11, c.get(11) + 1);
            c.set(12, 0);
            c.set(13, 0);
            c.set(14, 0);
            return c.getTime();
        }
        int nextMinuteOccurance = minuteBase * ((c.get(12) / minuteBase) + 1);
        if (nextMinuteOccurance < 60) {
            c.set(12, nextMinuteOccurance);
            c.set(13, 0);
            c.set(14, 0);
            return c.getTime();
        }
        c.set(11, c.get(11) + 1);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date nextGivenSecondDate(Date date, int secondBase) {
        if (secondBase < 0 || secondBase > 59) {
            throw new IllegalArgumentException("secondBase must be >=0 and <= 59");
        }
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setLenient(true);
        if (secondBase == 0) {
            c.set(12, c.get(12) + 1);
            c.set(13, 0);
            c.set(14, 0);
            return c.getTime();
        }
        int nextSecondOccurance = secondBase * ((c.get(13) / secondBase) + 1);
        if (nextSecondOccurance < 60) {
            c.set(13, nextSecondOccurance);
            c.set(14, 0);
            return c.getTime();
        }
        c.set(12, c.get(12) + 1);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }

    public static Date translateTime(Date date, TimeZone src, TimeZone dest) {
        Date newDate = new Date();
        newDate.setTime(date.getTime() - ((long) (dest.getOffset(date.getTime()) - src.getOffset(date.getTime()))));
        return newDate;
    }

    public static void validateDayOfWeek(int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new IllegalArgumentException("Invalid day of week.");
        }
    }

    public static void validateHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Invalid hour (must be >= 0 and <= 23).");
        }
    }

    public static void validateMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute (must be >= 0 and <= 59).");
        }
    }

    public static void validateSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid second (must be >= 0 and <= 59).");
        }
    }

    public static void validateDayOfMonth(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day of month.");
        }
    }

    public static void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month (must be >= 1 and <= 12.");
        }
    }

    public static void validateYear(int year) {
        if (year < 0 || year > MAX_YEAR) {
            throw new IllegalArgumentException("Invalid year (must be >= 0 and <= " + MAX_YEAR);
        }
    }
}
