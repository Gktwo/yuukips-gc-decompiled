package org.quartz.impl.calendar;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;
import org.quartz.Calendar;

/* loaded from: grasscutter.jar:org/quartz/impl/calendar/HolidayCalendar.class */
public class HolidayCalendar extends BaseCalendar implements Calendar, Serializable {
    static final long serialVersionUID = -7590908752291814693L;
    private TreeSet<Date> dates = new TreeSet<>();

    public HolidayCalendar() {
    }

    public HolidayCalendar(Calendar baseCalendar) {
        super(baseCalendar);
    }

    public HolidayCalendar(TimeZone timeZone) {
        super(timeZone);
    }

    public HolidayCalendar(Calendar baseCalendar, TimeZone timeZone) {
        super(baseCalendar, timeZone);
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar, java.lang.Object
    public Object clone() {
        HolidayCalendar clone = (HolidayCalendar) clone();
        clone.dates = new TreeSet<>((SortedSet<Date>) this.dates);
        return clone;
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public boolean isTimeIncluded(long timeStamp) {
        if (!isTimeIncluded(timeStamp)) {
            return false;
        }
        return !this.dates.contains(getStartOfDayJavaCalendar(timeStamp).getTime());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
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
            r1 = r6
            long r0 = r0.getNextIncludedTime(r1)
            r8 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0014
            r0 = r8
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0014
            r0 = r8
            r6 = r0
        L_0x0014:
            r0 = r5
            r1 = r6
            java.util.Calendar r0 = r0.getStartOfDayJavaCalendar(r1)
            r10 = r0
        L_0x001b:
            r0 = r5
            r1 = r10
            java.util.Date r1 = r1.getTime()
            long r1 = r1.getTime()
            boolean r0 = r0.isTimeIncluded(r1)
            if (r0 != 0) goto L_0x0034
            r0 = r10
            r1 = 5
            r2 = 1
            r0.add(r1, r2)
            goto L_0x001b
        L_0x0034:
            r0 = r10
            java.util.Date r0 = r0.getTime()
            long r0 = r0.getTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.calendar.HolidayCalendar.getNextIncludedTime(long):long");
    }

    public void addExcludedDate(Date excludedDate) {
        this.dates.add(getStartOfDayJavaCalendar(excludedDate.getTime()).getTime());
    }

    public void removeExcludedDate(Date dateToRemove) {
        this.dates.remove(getStartOfDayJavaCalendar(dateToRemove.getTime()).getTime());
    }

    public SortedSet<Date> getExcludedDates() {
        return Collections.unmodifiableSortedSet(this.dates);
    }
}
