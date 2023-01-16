package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/DBSemaphore.class */
public abstract class DBSemaphore implements Semaphore, Constants, StdJDBCConstants, TablePrefixAware {
    private String sql;
    private String insertSql;
    private String tablePrefix;
    private String schedName;
    private String expandedSQL;
    private String expandedInsertSQL;
    private final Logger log = LoggerFactory.getLogger(getClass());
    ThreadLocal<HashSet<String>> lockOwners = new ThreadLocal<>();
    private String schedNameLiteral = null;

    protected abstract void executeSQL(Connection connection, String str, String str2, String str3) throws LockException;

    public DBSemaphore(String tablePrefix, String schedName, String defaultSQL, String defaultInsertSQL) {
        this.tablePrefix = tablePrefix;
        this.schedName = schedName;
        setSQL(defaultSQL);
        setInsertSQL(defaultInsertSQL);
    }

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
    public boolean obtainLock(Connection conn, String lockName) throws LockException {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Lock '" + lockName + "' is desired by: " + Thread.currentThread().getName());
        }
        if (!isLockOwner(lockName)) {
            executeSQL(conn, lockName, this.expandedSQL, this.expandedInsertSQL);
            if (this.log.isDebugEnabled()) {
                this.log.debug("Lock '" + lockName + "' given to: " + Thread.currentThread().getName());
            }
            getThreadLocks().add(lockName);
            return true;
        } else if (!this.log.isDebugEnabled()) {
            return true;
        } else {
            this.log.debug("Lock '" + lockName + "' Is already owned by: " + Thread.currentThread().getName());
            return true;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.Semaphore
    public void releaseLock(String lockName) {
        if (isLockOwner(lockName)) {
            if (getLog().isDebugEnabled()) {
                getLog().debug("Lock '" + lockName + "' returned by: " + Thread.currentThread().getName());
            }
            getThreadLocks().remove(lockName);
        } else if (getLog().isDebugEnabled()) {
            getLog().warn("Lock '" + lockName + "' attempt to return by: " + Thread.currentThread().getName() + " -- but not owner!", (Throwable) new Exception("stack-trace of wrongful returner"));
        }
    }

    public boolean isLockOwner(String lockName) {
        return getThreadLocks().contains(lockName);
    }

    @Override // org.quartz.impl.jdbcjobstore.Semaphore
    public boolean requiresConnection() {
        return true;
    }

    protected String getSQL() {
        return this.sql;
    }

    protected void setSQL(String sql) {
        if (!(sql == null || sql.trim().length() == 0)) {
            this.sql = sql.trim();
        }
        setExpandedSQL();
    }

    protected void setInsertSQL(String insertSql) {
        if (!(insertSql == null || insertSql.trim().length() == 0)) {
            this.insertSql = insertSql.trim();
        }
        setExpandedSQL();
    }

    private void setExpandedSQL() {
        if (getTablePrefix() != null && getSchedName() != null && this.sql != null && this.insertSql != null) {
            this.expandedSQL = Util.rtp(this.sql, getTablePrefix(), getSchedulerNameLiteral());
            this.expandedInsertSQL = Util.rtp(this.insertSql, getTablePrefix(), getSchedulerNameLiteral());
        }
    }

    protected String getSchedulerNameLiteral() {
        if (this.schedNameLiteral == null) {
            this.schedNameLiteral = "'" + this.schedName + "'";
        }
        return this.schedNameLiteral;
    }

    public String getSchedName() {
        return this.schedName;
    }

    @Override // org.quartz.impl.jdbcjobstore.TablePrefixAware
    public void setSchedName(String schedName) {
        this.schedName = schedName;
        setExpandedSQL();
    }

    protected String getTablePrefix() {
        return this.tablePrefix;
    }

    @Override // org.quartz.impl.jdbcjobstore.TablePrefixAware
    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
        setExpandedSQL();
    }
}
