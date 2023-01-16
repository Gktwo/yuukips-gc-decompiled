package org.quartz.plugins;

import javax.transaction.UserTransaction;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.p026ee.jta.UserTransactionHelper;
import org.quartz.spi.SchedulerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/plugins/SchedulerPluginWithUserTransactionSupport.class */
public abstract class SchedulerPluginWithUserTransactionSupport implements SchedulerPlugin {
    private String name;
    private Scheduler scheduler;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private boolean wrapInUserTransaction = false;

    protected void start(UserTransaction userTransaction) {
    }

    protected void shutdown(UserTransaction userTransaction) {
    }

    protected Logger getLog() {
        return this.log;
    }

    protected String getName() {
        return this.name;
    }

    protected Scheduler getScheduler() {
        return this.scheduler;
    }

    public void initialize(String pname, Scheduler sched) throws SchedulerException {
        this.name = pname;
        this.scheduler = sched;
    }

    public boolean getWrapInUserTransaction() {
        return this.wrapInUserTransaction;
    }

    public void setWrapInUserTransaction(boolean wrapInUserTransaction) {
        this.wrapInUserTransaction = wrapInUserTransaction;
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void start() {
        UserTransaction userTransaction = startUserTransaction();
        try {
            start(userTransaction);
            resolveUserTransaction(userTransaction);
        } catch (Throwable th) {
            resolveUserTransaction(userTransaction);
            throw th;
        }
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void shutdown() {
        UserTransaction userTransaction = startUserTransaction();
        try {
            shutdown(userTransaction);
            resolveUserTransaction(userTransaction);
        } catch (Throwable th) {
            resolveUserTransaction(userTransaction);
            throw th;
        }
    }

    private UserTransaction startUserTransaction() {
        if (!this.wrapInUserTransaction) {
            return null;
        }
        UserTransaction userTransaction = null;
        try {
            userTransaction = UserTransactionHelper.lookupUserTransaction();
            userTransaction.begin();
        } catch (Throwable t) {
            UserTransactionHelper.returnUserTransaction(userTransaction);
            userTransaction = null;
            getLog().error("Failed to start UserTransaction for plugin: " + getName(), t);
        }
        return userTransaction;
    }

    private void resolveUserTransaction(UserTransaction userTransaction) {
        if (userTransaction != null) {
            try {
                if (userTransaction.getStatus() == 1) {
                    userTransaction.rollback();
                } else {
                    userTransaction.commit();
                }
            } finally {
                UserTransactionHelper.returnUserTransaction(userTransaction);
            }
        }
    }
}
