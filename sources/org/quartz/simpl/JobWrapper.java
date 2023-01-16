package org.quartz.simpl;

import org.quartz.JobDetail;
import org.quartz.JobKey;

/* compiled from: RAMJobStore.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/quartz/simpl/JobWrapper.class */
public class JobWrapper {
    public JobKey key;
    public JobDetail jobDetail;

    /* access modifiers changed from: package-private */
    public JobWrapper(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
        this.key = jobDetail.getKey();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JobWrapper) || !((JobWrapper) obj).key.equals(this.key)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.key.hashCode();
    }
}
