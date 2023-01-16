package org.quartz.management;

import org.quartz.core.QuartzScheduler;

/* loaded from: grasscutter.jar:org/quartz/management/ManagementServer.class */
public interface ManagementServer {
    void start();

    void stop();

    void register(QuartzScheduler quartzScheduler);

    void unregister(QuartzScheduler quartzScheduler);

    boolean hasRegistered();
}
