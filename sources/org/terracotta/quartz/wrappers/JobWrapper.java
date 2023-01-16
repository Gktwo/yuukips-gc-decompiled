package org.terracotta.quartz.wrappers;

import java.io.Serializable;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;

/* loaded from: grasscutter.jar:org/terracotta/quartz/wrappers/JobWrapper.class */
public class JobWrapper implements Serializable {
    protected JobDetail jobDetail;

    /* access modifiers changed from: protected */
    public JobWrapper(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
    }

    public JobKey getKey() {
        return this.jobDetail.getKey();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof JobWrapper) && ((JobWrapper) obj).jobDetail.getKey().equals(this.jobDetail.getKey());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.jobDetail.getKey().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "[" + this.jobDetail.toString() + "]";
    }

    public boolean requestsRecovery() {
        return this.jobDetail.requestsRecovery();
    }

    public boolean isPersistJobDataAfterExecution() {
        return this.jobDetail.isPersistJobDataAfterExecution();
    }

    public boolean isConcurrentExectionDisallowed() {
        return this.jobDetail.isConcurrentExectionDisallowed();
    }

    public boolean isDurable() {
        return this.jobDetail.isDurable();
    }

    public JobDetail getJobDetailClone() {
        return (JobDetail) this.jobDetail.clone();
    }

    public void setJobDataMap(JobDataMap newData, JobFacade jobFacade) {
        this.jobDetail = this.jobDetail.getJobBuilder().setJobData(newData).build();
        jobFacade.put(this.jobDetail.getKey(), this);
    }

    public JobDataMap getJobDataMapClone() {
        return (JobDataMap) this.jobDetail.getJobDataMap().clone();
    }

    public boolean isInstanceof(Class clazz) {
        return clazz.isInstance(this.jobDetail);
    }
}
