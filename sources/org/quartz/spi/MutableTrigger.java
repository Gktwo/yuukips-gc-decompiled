package org.quartz.spi;

import java.util.Date;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/* loaded from: grasscutter.jar:org/quartz/spi/MutableTrigger.class */
public interface MutableTrigger extends Trigger {
    void setKey(TriggerKey triggerKey);

    void setJobKey(JobKey jobKey);

    void setDescription(String str);

    void setCalendarName(String str);

    void setJobDataMap(JobDataMap jobDataMap);

    void setPriority(int i);

    void setStartTime(Date date);

    void setEndTime(Date date);

    void setMisfireInstruction(int i);

    @Override // java.lang.Object
    Object clone();
}
