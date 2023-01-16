package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/SimpleSemaphore.class */
public class SimpleSemaphore implements Semaphore {
    ThreadLocal<HashSet<String>> lockOwners = new ThreadLocal<>();
    HashSet<String> locks = new HashSet<>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Logger getLog() {
        return this.log;
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
    public synchronized boolean obtainLock(Connection conn, String lockName) {
        String lockName2 = lockName.intern();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Lock '" + lockName2 + "' is desired by: " + Thread.currentThread().getName());
        }
        if (!isLockOwner(lockName2)) {
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

    @Override // org.quartz.impl.jdbcjobstore.Semaphore
    public synchronized void releaseLock(String lockName) {
        String lockName2 = lockName.intern();
        if (isLockOwner(lockName2)) {
            if (getLog().isDebugEnabled()) {
                getLog().debug("Lock '" + lockName2 + "' retuned by: " + Thread.currentThread().getName());
            }
            getThreadLocks().remove(lockName2);
            this.locks.remove(lockName2);
            notifyAll();
        } else if (getLog().isDebugEnabled()) {
            getLog().debug("Lock '" + lockName2 + "' attempt to retun by: " + Thread.currentThread().getName() + " -- but not owner!", (Throwable) new Exception("stack-trace of wrongful returner"));
        }
    }

    public synchronized boolean isLockOwner(String lockName) {
        return getThreadLocks().contains(lockName.intern());
    }

    @Override // org.quartz.impl.jdbcjobstore.Semaphore
    public boolean requiresConnection() {
        return false;
    }
}
