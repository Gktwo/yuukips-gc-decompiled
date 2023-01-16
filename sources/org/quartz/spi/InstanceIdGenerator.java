package org.quartz.spi;

import org.quartz.SchedulerException;

/* loaded from: grasscutter.jar:org/quartz/spi/InstanceIdGenerator.class */
public interface InstanceIdGenerator {
    String generateInstanceId() throws SchedulerException;
}
