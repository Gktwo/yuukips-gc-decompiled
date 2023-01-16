package org.quartz.spi;

import java.util.Date;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/spi/TimeBroker.class */
public interface TimeBroker {
    Date getCurrentTime() throws SchedulerException;

    void initialize() throws SchedulerConfigException;

    void shutdown();
}
