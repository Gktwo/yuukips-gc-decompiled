package org.quartz.impl.calendar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TimeZone;
import org.quartz.Calendar;

/* loaded from: grasscutter.jar:org/quartz/impl/calendar/AnnualCalendar.class */
public class AnnualCalendar extends BaseCalendar implements Calendar, Serializable {
    static final long serialVersionUID = 7346867105876610961L;
    private ArrayList<java.util.Calendar> excludeDays = new ArrayList<>();
    private boolean dataSorted = false;

    public AnnualCalendar() {
    }

    public AnnualCalendar(Calendar baseCalendar) {
        super(baseCalendar);
    }

    public AnnualCalendar(TimeZone timeZone) {
        super(timeZone);
    }

    public AnnualCalendar(Calendar baseCalendar, TimeZone timeZone) {
        super(baseCalendar, timeZone);
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar, java.lang.Object
    public Object clone() {
        AnnualCalendar clone = (AnnualCalendar) clone();
        clone.excludeDays = new ArrayList<>(this.excludeDays);
        return clone;
    }

    public ArrayList<java.util.Calendar> getDaysExcluded() {
        return this.excludeDays;
    }

    public boolean isDayExcluded(java.util.Calendar day) {
        if (day == null) {
            throw new IllegalArgumentException("Parameter day must not be null");
        } else if (!isTimeIncluded(day.getTime().getTime())) {
            return true;
        } else {
            int dmonth = day.get(2);
            int dday = day.get(5);
            if (!this.dataSorted) {
                Collections.sort(this.excludeDays, new CalendarComparator());
                this.dataSorted = true;
            }
            Iterator<java.util.Calendar> iter = this.excludeDays.iterator();
            while (iter.hasNext()) {
                java.util.Calendar cl = iter.next();
                if (dmonth < cl.get(2)) {
                    return false;
                }
                if (dday == cl.get(5) && dmonth == cl.get(2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void setDaysExcluded(ArrayList<java.util.Calendar> days) {
        if (days == null) {
            this.excludeDays = new ArrayList<>();
        } else {
            this.excludeDays = days;
        }
        this.dataSorted = false;
    }

    public void setDayExcluded(java.util.Calendar day, boolean exclude) {
        if (exclude) {
            if (!isDayExcluded(day)) {
                this.excludeDays.add(day);
                this.dataSorted = false;
            }
        } else if (isDayExcluded(day)) {
            removeExcludedDay(day, true);
        }
    }

    public void removeExcludedDay(java.util.Calendar day) {
        removeExcludedDay(day, false);
    }

    private void removeExcludedDay(java.util.Calendar day, boolean isChecked) {
        if ((isChecked || isDayExcluded(day)) && !this.excludeDays.remove(day)) {
            int dmonth = day.get(2);
            int dday = day.get(5);
            Iterator<java.util.Calendar> iter = this.excludeDays.iterator();
            while (true) {
                if (!iter.hasNext()) {
                    break;
                }
                java.util.Calendar cl = iter.next();
                if (dmonth == cl.get(2) && dday == cl.get(5)) {
                    day = cl;
                    break;
                }
            }
            this.excludeDays.remove(day);
        }
    }

    @Override // org.quartz.impl.calendar.BaseCalendar, org.quartz.Calendar
    public boolean isTimeIncluded(long timeStamp) {
        return isTimeIncluded(timeStamp) && !isDayExcluded(createJavaCalendar(timeStamp));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
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
            r0 = r5
            r1 = r10
            boolean r0 = r0.isDayExcluded(r1)
            if (r0 != 0) goto L_0x0026
            r0 = r6
            return r0
        L_0x0026:
            r0 = r5
            r1 = r10
            boolean r0 = r0.isDayExcluded(r1)
            r1 = 1
            if (r0 != r1) goto L_0x003a
            r0 = r10
            r1 = 5
            r2 = 1
            r0.add(r1, r2)
            goto L_0x0026
        L_0x003a:
            r0 = r10
            java.util.Date r0 = r0.getTime()
            long r0 = r0.getTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.calendar.AnnualCalendar.getNextIncludedTime(long):long");
    }
}
