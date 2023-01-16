package org.quartz.impl.calendar;

import java.io.Serializable;
import java.util.TimeZone;
import org.quartz.Calendar;

/* loaded from: grasscutter.jar:org/quartz/impl/calendar/MonthlyCalendar.class */
public class MonthlyCalendar extends BaseCalendar implements Calendar, Serializable {
    static final long serialVersionUID = 419164961091807944L;
    private static final int MAX_DAYS_IN_MONTH = 31;
    private boolean[] excludeDays;
    private boolean excludeAll;

    public MonthlyCalendar() {
        this(null, null);
    }

    public MonthlyCalendar(Calendar baseCalendar) {
        this(baseCalendar, null);
    }

    public MonthlyCalendar(TimeZone timeZone) {
        this(null, timeZone);
    }

    public MonthlyCalendar(Calendar baseCalendar, TimeZone timeZone) {
        super(baseCalendar, timeZone);
        this.excludeDays = new boolean[31];
        this.excludeAll = false;
        this.excludeAll = areAllDaysExcluded();
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar, java.lang.Object
    public Object clone() {
        MonthlyCalendar clone = (MonthlyCalendar) clone();
        clone.excludeDays = (boolean[]) this.excludeDays.clone();
        return clone;
    }

    public boolean[] getDaysExcluded() {
        return this.excludeDays;
    }

    public boolean isDayExcluded(int day) {
        if (day >= 1 && day <= 31) {
            return this.excludeDays[day - 1];
        }
        throw new IllegalArgumentException("The day parameter must be in the range of 1 to 31");
    }

    public void setDaysExcluded(boolean[] days) {
        if (days == null) {
            throw new IllegalArgumentException("The days parameter cannot be null.");
        } else if (days.length < 31) {
            throw new IllegalArgumentException("The days parameter must have a length of at least 31 elements.");
        } else {
            this.excludeDays = days;
            this.excludeAll = areAllDaysExcluded();
        }
    }

    public void setDayExcluded(int day, boolean exclude) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("The day parameter must be in the range of 1 to 31");
        }
        this.excludeDays[day - 1] = exclude;
        this.excludeAll = areAllDaysExcluded();
    }

    public boolean areAllDaysExcluded() {
        for (int i = 1; i <= 31; i++) {
            if (!isDayExcluded(i)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public boolean isTimeIncluded(long timeStamp) {
        return !this.excludeAll && isTimeIncluded(timeStamp) && !isDayExcluded(createJavaCalendar(timeStamp).get(5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getNextIncludedTime(long r6) {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.excludeAll
            r1 = 1
            if (r0 != r1) goto L_0x000a
            r0 = 0
            return r0
        L_0x000a:
            r0 = r5
            r1 = r6
            long r0 = r0.getNextIncludedTime(r1)
            r8 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            r0 = r8
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            r0 = r8
            r6 = r0
        L_0x001e:
            r0 = r5
            r1 = r6
            java.util.Calendar r0 = r0.getStartOfDayJavaCalendar(r1)
            r10 = r0
            r0 = r10
            r1 = 5
            int r0 = r0.get(r1)
            r11 = r0
            r0 = r5
            r1 = r11
            boolean r0 = r0.isDayExcluded(r1)
            if (r0 != 0) goto L_0x0038
            r0 = r6
            return r0
        L_0x0038:
            r0 = r5
            r1 = r11
            boolean r0 = r0.isDayExcluded(r1)
            r1 = 1
            if (r0 != r1) goto L_0x0054
            r0 = r10
            r1 = 5
            r2 = 1
            r0.add(r1, r2)
            r0 = r10
            r1 = 5
            int r0 = r0.get(r1)
            r11 = r0
            goto L_0x0038
        L_0x0054:
            r0 = r10
            java.util.Date r0 = r0.getTime()
            long r0 = r0.getTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.calendar.MonthlyCalendar.getNextIncludedTime(long):long");
    }
}
