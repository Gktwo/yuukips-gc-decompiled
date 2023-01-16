package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;
import java.util.HashSet;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.Synchronization;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JTANonClusteredSemaphore.class */
public class JTANonClusteredSemaphore implements Semaphore {
    public static final String DEFAULT_TRANSACTION_MANANGER_LOCATION = "java:TransactionManager";
    ThreadLocal<HashSet<String>> lockOwners = new ThreadLocal<>();
    HashSet<String> locks = new HashSet<>();
    private final Logger log = LoggerFactory.getLogger(getClass());
    private String transactionManagerJNDIName = DEFAULT_TRANSACTION_MANANGER_LOCATION;

    protected Logger getLog() {
        return this.log;
    }

    public void setTransactionManagerJNDIName(String transactionManagerJNDIName) {
        this.transactionManagerJNDIName = transactionManagerJNDIName;
    }

    private HashSet<String> getThreadLocks() {
        HashSet<String> threadLocks = this.lockOwners.get();
        if (threadLocks == null) {
            threadLocks = new HashSet<>();
            this.lockOwners.set(threadLocks);
        }
        return threadLocks;
    }

    @Override // org.quartz.impl.jdbcjobstore.Semaphore
    public synchronized boolean obtainLock(Connection conn, String lockName) throws LockException {
        String lockName2 = lockName.intern();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Lock '" + lockName2 + "' is desired by: " + Thread.currentThread().getName());
        }
        if (!isLockOwner(conn, lockName2)) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Lock '" + lockName2 + "' is being obtained: " + Thread.currentThread().getName());
            }
            while (this.locks.contains(lockName2)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Lock '" + lockName2 + "' was not obtained by: " + Thread.currentThread().getName());
                    }
                }
            }
            Transaction t = getTransaction();
            if (t != null) {
                try {
                    t.registerSynchronization(new SemaphoreSynchronization(lockName2));
                } catch (Exception e2) {
                    throw new LockException("Failed to register semaphore with Transaction.", e2);
                }
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("Lock '" + lockName2 + "' given to: " + Thread.currentThread().getName());
            }
            getThreadLocks().add(lockName2);
            this.locks.add(lockName2);
            return true;
        } else if (!this.log.isDebugEnabled()) {
            return true;
        } else {
            this.log.debug("Lock '" + lockName2 + "' already owned by: " + Thread.currentThread().getName() + " -- but not owner!", (Throwable) new Exception("stack-trace of wrongful returner"));
            return true;
        }
    }

    protected Transaction getTransaction() throws LockException {
        InitialContext ic;
        try {
            ic = null;
            try {
                try {
                    ic = new InitialContext();
                    Transaction transaction = ((TransactionManager) ic.lookup(this.transactionManagerJNDIName)).getTransaction();
                    if (ic != null) {
                        try {
                            ic.close();
                        } catch (NamingException e) {
                        }
                    }
                    return transaction;
                } catch (NamingException e2) {
                    throw new LockException("Failed to find TransactionManager in JNDI under name: " + this.transactionManagerJNDIName, e2);
                }
            } catch (SystemException e3) {
                throw new LockException("Failed to get Transaction from TransactionManager", e3);
            }
        } catch (Throwable th) {
            if (ic != null) {
                try {
                    ic.close();
                } catch (NamingException e4) {
                }
            }
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.Semaphore
    public synchronized void releaseLock(String lockName) throws LockException {
        releaseLock(lockName, false);
    }

    protected synchronized void releaseLock(String lockName, boolean fromSynchronization) throws LockException {
        String lockName2 = lockName.intern();
        if (isLockOwner(null, lockName2)) {
            if (fromSynchronization || getTransaction() == null) {
                if (getLog().isDebugEnabled()) {
                    getLog().debug("Lock '" + lockName2 + "' returned by: " + Thread.currentThread().getName());
                }
                getThreadLocks().remove(lockName2);
                this.locks.remove(lockName2);
                notify();
            } else if (getLog().isDebugEnabled()) {
                getLog().debug("Lock '" + lockName2 + "' is in a JTA transaction.  Return deferred by: " + Thread.currentThread().getName());
            }
        } else if (getLog().isDebugEnabled()) {
            getLog().debug("Lock '" + lockName2 + "' attempt to return by: " + Thread.currentThread().getName() + " -- but not owner!", (Throwable) new Exception("stack-trace of wrongful returner"));
        }
    }

    public synchronized boolean isLockOwner(Connection conn, String lockName) {
        return getThreadLocks().contains(lockName.intern());
    }

    @Override // org.quartz.impl.jdbcjobstore.Semaphore
    public boolean requiresConnection() {
        return false;
    }

    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/JTANonClusteredSemaphore$SemaphoreSynchronization.class */
    private class SemaphoreSynchronization implements Synchronization {
        private String lockName;

        public SemaphoreSynchronization(String lockName) {
            this.lockName = lockName;
        }

        public void beforeCompletion() {
        }

        public void afterCompletion(int status) {
            try {
                JTANonClusteredSemaphore.this.releaseLock(this.lockName, true);
            } catch (LockException e) {
            }
        }
    }
}
