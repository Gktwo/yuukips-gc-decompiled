package org.quartz;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/TriggerUtils.class */
public class TriggerUtils {
    private TriggerUtils() {
    }

    public static List<Date> computeFireTimes(OperableTrigger trigg, Calendar cal, int numTimes) {
        Date d;
        LinkedList<Date> lst = new LinkedList<>();
        OperableTrigger t = (OperableTrigger) trigg.clone();
        if (t.getNextFireTime() == null) {
            t.computeFirstFireTime(cal);
        }
        for (int i = 0; i < numTimes && (d = t.getNextFireTime()) != null; i++) {
            lst.add(d);
            t.triggered(cal);
        }
        return Collections.unmodifiableList(lst);
    }

    public static Date computeEndTimeToAllowParticularNumberOfFirings(OperableTrigger trigg, Calendar cal, int numTimes) {
        Date d;
        OperableTrigger t = (OperableTrigger) trigg.clone();
        if (t.getNextFireTime() == null) {
            t.computeFirstFireTime(cal);
        }
        int c = 0;
        Date endTime = null;
        for (int i = 0; i < numTimes && (d = t.getNextFireTime()) != null; i++) {
            c++;
            t.triggered(cal);
            if (c == numTimes) {
                endTime = d;
            }
        }
        if (endTime == null) {
            return null;
        }
        return new Date(endTime.getTime() + 1000);
    }

    public static List<Date> computeFireTimesBetween(OperableTrigger trigg, Calendar cal, Date from, Date to) {
        LinkedList<Date> lst = new LinkedList<>();
        OperableTrigger t = (OperableTrigger) trigg.clone();
        if (t.getNextFireTime() == null) {
            t.setStartTime(from);
            t.setEndTime(to);
            t.computeFirstFireTime(cal);
        }
        while (true) {
            Date d = t.getNextFireTime();
            if (d == null) {
                break;
            } else if (d.before(from)) {
                t.triggered(cal);
            } else if (d.after(to)) {
                break;
            } else {
                lst.add(d);
                t.triggered(cal);
            }
        }
        return Collections.unmodifiableList(lst);
    }
}
