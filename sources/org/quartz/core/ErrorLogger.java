package org.quartz.core;

import org.quartz.SchedulerException;
import org.quartz.listeners.SchedulerListenerSupport;

/* compiled from: QuartzScheduler.java */
/* loaded from: grasscutter.jar:org/quartz/core/ErrorLogger.class */
class ErrorLogger extends SchedulerListenerSupport {
    @Override // org.quartz.listeners.SchedulerListenerSupport, org.quartz.SchedulerListener
    public void schedulerError(String msg, SchedulerException cause) {
        getLog().error(msg, (Throwable) cause);
    }
}
