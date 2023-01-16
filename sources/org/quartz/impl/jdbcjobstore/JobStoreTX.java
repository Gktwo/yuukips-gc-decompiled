package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;
import org.quartz.JobPersistenceException;
import org.quartz.SchedulerConfigException;
import org.quartz.impl.jdbcjobstore.JobStoreSupport;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.SchedulerSignaler;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreTX.class */
public class JobStoreTX extends JobStoreSupport {
    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport, org.quartz.spi.JobStore
    public void initialize(ClassLoadHelper classLoadHelper, SchedulerSignaler schedSignaler) throws SchedulerConfigException {
        initialize(classLoadHelper, schedSignaler);
        getLog().info("JobStoreTX initialized.");
    }

    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport
    protected Connection getNonManagedTXConnection() throws JobPersistenceException {
        return getConnection();
    }

    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport
    protected Object executeInLock(String lockName, JobStoreSupport.TransactionCallback txCallback) throws JobPersistenceException {
        return executeInNonManagedTXLock(lockName, txCallback, null);
    }
}
