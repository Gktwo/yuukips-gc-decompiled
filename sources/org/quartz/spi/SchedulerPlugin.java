package org.quartz.spi;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/spi/SchedulerPlugin.class */
public interface SchedulerPlugin {
    void initialize(String str, Scheduler scheduler, ClassLoadHelper classLoadHelper) throws SchedulerException;

    void start();

    void shutdown();
}
