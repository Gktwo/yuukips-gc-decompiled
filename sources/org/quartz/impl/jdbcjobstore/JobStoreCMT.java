package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;
import java.sql.SQLException;
import org.quartz.JobPersistenceException;
import org.quartz.SchedulerConfigException;
import org.quartz.impl.jdbcjobstore.JobStoreSupport;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.SchedulerSignaler;
import org.quartz.utils.DBConnectionManager;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JobStoreCMT.class */
public class JobStoreCMT extends JobStoreSupport {
    protected String nonManagedTxDsName;
    protected boolean dontSetNonManagedTXConnectionAutoCommitFalse = false;
    protected boolean setTxIsolationLevelReadCommitted = false;

    public void setNonManagedTXDataSource(String nonManagedTxDsName) {
        this.nonManagedTxDsName = nonManagedTxDsName;
    }

    public String getNonManagedTXDataSource() {
        return this.nonManagedTxDsName;
    }

    public boolean isDontSetNonManagedTXConnectionAutoCommitFalse() {
        return this.dontSetNonManagedTXConnectionAutoCommitFalse;
    }

    public void setDontSetNonManagedTXConnectionAutoCommitFalse(boolean b) {
        this.dontSetNonManagedTXConnectionAutoCommitFalse = b;
    }

    public boolean isTxIsolationLevelReadCommitted() {
        return this.setTxIsolationLevelReadCommitted;
    }

    public void setTxIsolationLevelReadCommitted(boolean b) {
        this.setTxIsolationLevelReadCommitted = b;
    }

    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport, org.quartz.spi.JobStore
    public void initialize(ClassLoadHelper loadHelper, SchedulerSignaler signaler) throws SchedulerConfigException {
        if (this.nonManagedTxDsName == null) {
            throw new SchedulerConfigException("Non-ManagedTX DataSource name not set!  If your 'org.quartz.jobStore.dataSource' is XA, then set 'org.quartz.jobStore.nonManagedTXDataSource' to a non-XA datasource (for the same DB).  Otherwise, you can set them to be the same.");
        }
        if (getLockHandler() == null) {
            setUseDBLocks(true);
        }
        initialize(loadHelper, signaler);
        getLog().info("JobStoreCMT initialized.");
    }

    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport, org.quartz.spi.JobStore
    public void shutdown() {
        shutdown();
        try {
            DBConnectionManager.getInstance().shutdown(getNonManagedTXDataSource());
        } catch (SQLException sqle) {
            getLog().warn("Database connection shutdown unsuccessful.", (Throwable) sqle);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport
    protected Connection getNonManagedTXConnection() throws JobPersistenceException {
        try {
            Connection conn = DBConnectionManager.getInstance().getConnection(getNonManagedTXDataSource());
            if (conn == null) {
                throw new JobPersistenceException("Could not get connection from DataSource '" + getNonManagedTXDataSource() + "'");
            }
            Connection conn2 = getAttributeRestoringConnection(conn);
            try {
                if (!isDontSetNonManagedTXConnectionAutoCommitFalse()) {
                    conn2.setAutoCommit(false);
                }
                if (isTxIsolationLevelReadCommitted()) {
                    conn2.setTransactionIsolation(2);
                }
            } catch (SQLException sqle) {
                getLog().warn("Failed to override connection auto commit/transaction isolation.", (Throwable) sqle);
            } catch (Throwable e) {
                try {
                    conn2.close();
                } catch (Throwable th) {
                }
                throw new JobPersistenceException("Failure setting up connection.", e);
            }
            return conn2;
        } catch (SQLException sqle2) {
            throw new JobPersistenceException("Failed to obtain DB connection from data source '" + getNonManagedTXDataSource() + "': " + sqle2.toString(), sqle2);
        } catch (Throwable e2) {
            throw new JobPersistenceException("Failed to obtain DB connection from data source '" + getNonManagedTXDataSource() + "': " + e2.toString(), e2);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.JobStoreSupport
    protected Object executeInLock(String lockName, JobStoreSupport.TransactionCallback txCallback) throws JobPersistenceException {
        boolean transOwner = false;
        Connection conn = null;
        if (lockName != null) {
            try {
                if (getLockHandler().requiresConnection()) {
                    conn = getConnection();
                }
                transOwner = getLockHandler().obtainLock(conn, lockName);
            } catch (Throwable th) {
                try {
                    releaseLock(lockName, transOwner);
                    cleanupConnection(conn);
                    throw th;
                } catch (Throwable th2) {
                    cleanupConnection(conn);
                    throw th2;
                }
            }
        }
        if (conn == null) {
            conn = getConnection();
        }
        Object execute = txCallback.execute(conn);
        try {
            releaseLock(lockName, transOwner);
            cleanupConnection(conn);
            return execute;
        } catch (Throwable th3) {
            cleanupConnection(conn);
            throw th3;
        }
    }
}
