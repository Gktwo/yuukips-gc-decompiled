package org.quartz.p026ee.jta;

import javax.naming.InitialContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* renamed from: org.quartz.ee.jta.UserTransactionHelper */
/* loaded from: grasscutter.jar:org/quartz/ee/jta/UserTransactionHelper.class */
public class UserTransactionHelper {
    public static final String DEFAULT_USER_TX_LOCATION = "java:comp/UserTransaction";
    private static String userTxURL = DEFAULT_USER_TX_LOCATION;

    private UserTransactionHelper() {
    }

    public static String getUserTxLocation() {
        return userTxURL;
    }

    public static void setUserTxLocation(String userTxURL2) {
        if (userTxURL2 != null) {
            userTxURL = userTxURL2;
        }
    }

    public static UserTransaction lookupUserTransaction() throws SchedulerException {
        return new UserTransactionWithContext();
    }

    public static void returnUserTransaction(UserTransaction userTransaction) {
        if (userTransaction != null && (userTransaction instanceof UserTransactionWithContext)) {
            ((UserTransactionWithContext) userTransaction).closeContext();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: org.quartz.ee.jta.UserTransactionHelper$UserTransactionWithContext */
    /* loaded from: grasscutter.jar:org/quartz/ee/jta/UserTransactionHelper$UserTransactionWithContext.class */
    public static class UserTransactionWithContext implements UserTransaction {
        InitialContext context;
        UserTransaction userTransaction;

        public UserTransactionWithContext() throws SchedulerException {
            try {
                this.context = new InitialContext();
                try {
                    this.userTransaction = (UserTransaction) this.context.lookup(UserTransactionHelper.userTxURL);
                    if (this.userTransaction == null) {
                        closeContext();
                        throw new SchedulerException("UserTransactionHelper could not lookup/create UserTransaction from the InitialContext.");
                    }
                } catch (Throwable t) {
                    closeContext();
                    throw new SchedulerException("UserTransactionHelper could not lookup/create UserTransaction.", t);
                }
            } catch (Throwable t2) {
                throw new SchedulerException("UserTransactionHelper failed to create InitialContext to lookup/create UserTransaction.", t2);
            }
        }

        public void closeContext() {
            try {
                if (this.context != null) {
                    this.context.close();
                }
            } catch (Throwable t) {
                getLog().warn("Failed to close InitialContext used to get a UserTransaction.", t);
            }
            this.context = null;
        }

        protected void finalize() throws Throwable {
            try {
                if (this.context != null) {
                    getLog().warn("UserTransaction was never returned to the UserTransactionHelper.");
                    closeContext();
                }
            } finally {
                finalize();
            }
        }

        private static Logger getLog() {
            return LoggerFactory.getLogger(UserTransactionWithContext.class);
        }

        public void begin() throws NotSupportedException, SystemException {
            this.userTransaction.begin();
        }

        public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
            this.userTransaction.commit();
        }

        public void rollback() throws IllegalStateException, SecurityException, SystemException {
            this.userTransaction.rollback();
        }

        public void setRollbackOnly() throws IllegalStateException, SystemException {
            this.userTransaction.setRollbackOnly();
        }

        public int getStatus() throws SystemException {
            return this.userTransaction.getStatus();
        }

        public void setTransactionTimeout(int seconds) throws SystemException {
            this.userTransaction.setTransactionTimeout(seconds);
        }
    }
}
