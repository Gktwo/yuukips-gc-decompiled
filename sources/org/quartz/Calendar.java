package org.quartz;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/quartz/Calendar.class */
public interface Calendar extends Serializable, Cloneable {
    public static final int MONTH = 0;

    void setBaseCalendar(Calendar calendar);

    Calendar getBaseCalendar();

    boolean isTimeIncluded(long j);

    long getNextIncludedTime(long j);

    String getDescription();

    void setDescription(String str);

    @Override // java.lang.Object
    Object clone();
}
