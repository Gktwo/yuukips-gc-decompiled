package org.quartz.impl;

import dev.morphia.mapping.Mapper;
import java.io.Serializable;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.utils.ClassUtils;

/* loaded from: grasscutter.jar:org/quartz/impl/JobDetailImpl.class */
public class JobDetailImpl implements Cloneable, Serializable, JobDetail {
    private static final long serialVersionUID = -6069784757781506897L;
    private String name;
    private String group;
    private String description;
    private Class<? extends Job> jobClass;
    private JobDataMap jobDataMap;
    private boolean durability;
    private boolean shouldRecover;
    private transient JobKey key;

    public JobDetailImpl() {
        this.group = "DEFAULT";
        this.durability = false;
        this.shouldRecover = false;
        this.key = null;
    }

    public JobDetailImpl(String name, Class<? extends Job> jobClass) {
        this(name, null, jobClass);
    }

    public JobDetailImpl(String name, String group, Class<? extends Job> jobClass) {
        this.group = "DEFAULT";
        this.durability = false;
        this.shouldRecover = false;
        this.key = null;
        setName(name);
        setGroup(group);
        setJobClass(jobClass);
    }

    public JobDetailImpl(String name, String group, Class<? extends Job> jobClass, boolean durability, boolean recover) {
        this.group = "DEFAULT";
        this.durability = false;
        this.shouldRecover = false;
        this.key = null;
        setName(name);
        setGroup(group);
        setJobClass(jobClass);
        setDurability(durability);
        setRequestsRecovery(recover);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Job name cannot be empty.");
        }
        this.name = name;
        this.key = null;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        if (group == null || group.trim().length() != 0) {
            if (group == null) {
                group = "DEFAULT";
            }
            this.group = group;
            this.key = null;
            return;
        }
        throw new IllegalArgumentException("Group name cannot be empty.");
    }

    public String getFullName() {
        return this.group + Mapper.IGNORED_FIELDNAME + this.name;
    }

    @Override // org.quartz.JobDetail
    public JobKey getKey() {
        if (this.key == null) {
            if (getName() == null) {
                return null;
            }
            this.key = new JobKey(getName(), getGroup());
        }
        return this.key;
    }

    public void setKey(JobKey key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        setName(key.getName());
        setGroup(key.getGroup());
        this.key = key;
    }

    @Override // org.quartz.JobDetail
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override // org.quartz.JobDetail
    public Class<? extends Job> getJobClass() {
        return this.jobClass;
    }

    public void setJobClass(Class<? extends Job> jobClass) {
        if (jobClass == null) {
            throw new IllegalArgumentException("Job class cannot be null.");
        } else if (!Job.class.isAssignableFrom(jobClass)) {
            throw new IllegalArgumentException("Job class must implement the Job interface.");
        } else {
            this.jobClass = jobClass;
        }
    }

    @Override // org.quartz.JobDetail
    public JobDataMap getJobDataMap() {
        if (this.jobDataMap == null) {
            this.jobDataMap = new JobDataMap();
        }
        return this.jobDataMap;
    }

    public void setJobDataMap(JobDataMap jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    public void setDurability(boolean durability) {
        this.durability = durability;
    }

    public void setRequestsRecovery(boolean shouldRecover) {
        this.shouldRecover = shouldRecover;
    }

    @Override // org.quartz.JobDetail
    public boolean isDurable() {
        return this.durability;
    }

    @Override // org.quartz.JobDetail
    public boolean isPersistJobDataAfterExecution() {
        return ClassUtils.isAnnotationPresent(this.jobClass, PersistJobDataAfterExecution.class);
    }

    @Override // org.quartz.JobDetail
    public boolean isConcurrentExectionDisallowed() {
        return ClassUtils.isAnnotationPresent(this.jobClass, DisallowConcurrentExecution.class);
    }

    @Override // org.quartz.JobDetail
    public boolean requestsRecovery() {
        return this.shouldRecover;
    }

    @Override // java.lang.Object
    public String toString() {
        return "JobDetail '" + getFullName() + "':  jobClass: '" + (getJobClass() == null ? null : getJobClass().getName()) + " concurrentExectionDisallowed: " + isConcurrentExectionDisallowed() + " persistJobDataAfterExecution: " + isPersistJobDataAfterExecution() + " isDurable: " + isDurable() + " requestsRecovers: " + requestsRecovery();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof JobDetail)) {
            return false;
        }
        JobDetail other = (JobDetail) obj;
        if (other.getKey() == null || getKey() == null || !other.getKey().equals(getKey())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (getKey() == null) {
            return 0;
        }
        return getKey().hashCode();
    }

    @Override // java.lang.Object, org.quartz.JobDetail
    public Object clone() {
        try {
            JobDetailImpl copy = (JobDetailImpl) clone();
            if (this.jobDataMap != null) {
                copy.jobDataMap = (JobDataMap) this.jobDataMap.clone();
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new IncompatibleClassChangeError("Not Cloneable.");
        }
    }

    @Override // org.quartz.JobDetail
    public JobBuilder getJobBuilder() {
        return JobBuilder.newJob().ofType(getJobClass()).requestRecovery(requestsRecovery()).storeDurably(isDurable()).usingJobData(getJobDataMap()).withDescription(getDescription()).withIdentity(getKey());
    }
}
