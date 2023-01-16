package org.quartz;

import java.util.Collection;

/* loaded from: grasscutter.jar:org/quartz/SchedulerFactory.class */
public interface SchedulerFactory {
    Scheduler getScheduler() throws SchedulerException;

    Scheduler getScheduler(String str) throws SchedulerException;

    Collection<Scheduler> getAllSchedulers() throws SchedulerException;
}
