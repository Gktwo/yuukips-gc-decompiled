package org.terracotta.quartz.wrappers;

import org.quartz.JobDetail;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/terracotta/quartz/wrappers/DefaultWrapperFactory.class */
public class DefaultWrapperFactory implements WrapperFactory {
    @Override // org.terracotta.quartz.wrappers.WrapperFactory
    public JobWrapper createJobWrapper(JobDetail jobDetail) {
        return new JobWrapper(jobDetail);
    }

    @Override // org.terracotta.quartz.wrappers.WrapperFactory
    public TriggerWrapper createTriggerWrapper(OperableTrigger trigger, boolean jobDisallowsConcurrence) {
        return new TriggerWrapper(trigger, jobDisallowsConcurrence);
    }
}
