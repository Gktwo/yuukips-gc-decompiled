package org.terracotta.quartz.wrappers;

import org.quartz.JobDetail;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/terracotta/quartz/wrappers/WrapperFactory.class */
public interface WrapperFactory {
    JobWrapper createJobWrapper(JobDetail jobDetail);

    TriggerWrapper createTriggerWrapper(OperableTrigger operableTrigger, boolean z);
}
