package org.quartz.impl.calendar;

import java.io.Serializable;
import java.util.TimeZone;
import org.quartz.Calendar;

/* loaded from: grasscutter.jar:org/quartz/impl/calendar/WeeklyCalendar.class */
public class WeeklyCalendar extends BaseCalendar implements Calendar, Serializable {
    static final long serialVersionUID = -6809298821229007586L;
    private boolean[] excludeDays;
    private boolean excludeAll;

    public WeeklyCalendar() {
        this(null, null);
    }

    public WeeklyCalendar(Calendar baseCalendar) {
        this(baseCalendar, null);
    }

    public WeeklyCalendar(TimeZone timeZone) {
        super(null, timeZone);
        this.excludeDays = new boolean[8];
        this.excludeAll = false;
    }

    public WeeklyCalendar(Calendar baseCalendar, TimeZone timeZone) {
        super(baseCalendar, timeZone);
        this.excludeDays = new boolean[8];
        this.excludeAll = false;
        this.excludeDays[1] = true;
        this.excludeDays[7] = true;
        this.excludeAll = areAllDaysExcluded();
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar, java.lang.Object
    public Object clone() {
        WeeklyCalendar clone = (WeeklyCalendar) clone();
        clone.excludeDays = (boolean[]) this.excludeDays.clone();
        return clone;
    }

    public boolean[] getDaysExcluded() {
        return this.excludeDays;
    }

    public boolean isDayExcluded(int wday) {
        return this.excludeDays[wday];
    }

    public void setDaysExcluded(boolean[] weekDays) {
        if (weekDays != null) {
            this.excludeDays = weekDays;
            this.excludeAll = areAllDaysExcluded();
        }
    }

    public void setDayExcluded(int wday, boolean exclude) {
        this.excludeDays[wday] = exclude;
        this.excludeAll = areAllDaysExcluded();
    }

    public boolean areAllDaysExcluded() {
        return isDayExcluded(1) && isDayExcluded(2) && isDayExcluded(3) && isDayExcluded(4) && isDayExcluded(5) && isDayExcluded(6) && isDayExcluded(7);
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public boolean isTimeIncluded(long timeStamp) {
        return !this.excludeAll && isTimeIncluded(timeStamp) && !isDayExcluded(createJavaCalendar(timeStamp).get(7));
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
            r1 = 7
            int r0 = r0.get(r1)
            r11 = r0
            r0 = r5
            r1 = r11
            boolean r0 = r0.isDayExcluded(r1)
            if (r0 != 0) goto L_0x0039
            r0 = r6
            return r0
        L_0x0039:
            r0 = r5
            r1 = r11
            boolean r0 = r0.isDayExcluded(r1)
            r1 = 1
            if (r0 != r1) goto L_0x0056
            r0 = r10
            r1 = 5
            r2 = 1
            r0.add(r1, r2)
            r0 = r10
            r1 = 7
            int r0 = r0.get(r1)
            r11 = r0
            goto L_0x0039
        L_0x0056:
            r0 = r10
            java.util.Date r0 = r0.getTime()
            long r0 = r0.getTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.calendar.WeeklyCalendar.getNextIncludedTime(long):long");
    }
}
