package org.quartz;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/quartz/JobDetail.class */
public interface JobDetail extends Serializable, Cloneable {
    JobKey getKey();

    String getDescription();

    Class<? extends Job> getJobClass();

    JobDataMap getJobDataMap();

    boolean isDurable();

    boolean isPersistJobDataAfterExecution();

    boolean isConcurrentExectionDisallowed();

    boolean requestsRecovery();

    @Override // java.lang.Object
    Object clone();

    JobBuilder getJobBuilder();
}
