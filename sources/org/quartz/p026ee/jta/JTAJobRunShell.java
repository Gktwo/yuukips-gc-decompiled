package org.quartz.p026ee.jta;

import javax.transaction.UserTransaction;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.core.JobRunShell;
import org.quartz.spi.TriggerFiredBundle;

/* renamed from: org.quartz.ee.jta.JTAJobRunShell */
/* loaded from: grasscutter.jar:org/quartz/ee/jta/JTAJobRunShell.class */
public class JTAJobRunShell extends JobRunShell {
    private final Integer transactionTimeout;

    /* renamed from: ut */
    private UserTransaction f3368ut;

    public JTAJobRunShell(Scheduler scheduler, TriggerFiredBundle bndle) {
        super(scheduler, bndle);
        this.transactionTimeout = null;
    }

    public JTAJobRunShell(Scheduler scheduler, TriggerFiredBundle bndle, int timeout) {
        super(scheduler, bndle);
        this.transactionTimeout = Integer.valueOf(timeout);
    }

    @Override // org.quartz.core.JobRunShell
    protected void begin() throws SchedulerException {
        boolean beganSuccessfully;
        try {
            cleanupUserTransaction();
            beganSuccessfully = false;
            try {
                getLog().debug("Looking up UserTransaction.");
                this.f3368ut = UserTransactionHelper.lookupUserTransaction();
                if (this.transactionTimeout != null) {
                    this.f3368ut.setTransactionTimeout(this.transactionTimeout.intValue());
                }
                getLog().debug("Beginning UserTransaction.");
                this.f3368ut.begin();
                beganSuccessfully = true;
                if (1 == 0) {
                    cleanupUserTransaction();
                }
            } catch (SchedulerException se) {
                throw se;
            } catch (Exception nse) {
                throw new SchedulerException("JTAJobRunShell could not start UserTransaction.", nse);
            }
        } catch (Throwable th) {
            if (!beganSuccessfully) {
                cleanupUserTransaction();
            }
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0025
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.quartz.core.JobRunShell
    protected void complete(boolean r6) throws org.quartz.SchedulerException {
        /*
            r5 = this;
            r0 = r5
            javax.transaction.UserTransaction r0 = r0.f3368ut
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            r0 = r5
            javax.transaction.UserTransaction r0 = r0.f3368ut     // Catch: all -> 0x0082, SystemException -> 0x0025
            int r0 = r0.getStatus()     // Catch: all -> 0x0082, SystemException -> 0x0025
            r1 = 1
            if (r0 != r1) goto L_0x0022
            r0 = r5
            org.slf4j.Logger r0 = r0.getLog()     // Catch: all -> 0x0082, SystemException -> 0x0025
            java.lang.String r1 = "UserTransaction marked for rollback only."
            r0.debug(r1)     // Catch: all -> 0x0082, SystemException -> 0x0025
            r0 = 0
            r6 = r0
        L_0x0022:
            goto L_0x0031
        L_0x0025:
            r7 = move-exception
            org.quartz.SchedulerException r0 = new org.quartz.SchedulerException     // Catch: all -> 0x0082
            r1 = r0
            java.lang.String r2 = "JTAJobRunShell could not read UserTransaction status."
            r3 = r7
            r1.<init>(r2, r3)     // Catch: all -> 0x0082
            throw r0     // Catch: all -> 0x0082
        L_0x0031:
            r0 = r6
            if (r0 == 0) goto L_0x0058
            r0 = r5
            org.slf4j.Logger r0 = r0.getLog()     // Catch: Exception -> 0x004c, all -> 0x0082
            java.lang.String r1 = "Committing UserTransaction."
            r0.debug(r1)     // Catch: Exception -> 0x004c, all -> 0x0082
            r0 = r5
            javax.transaction.UserTransaction r0 = r0.f3368ut     // Catch: Exception -> 0x004c, all -> 0x0082
            r0.commit()     // Catch: Exception -> 0x004c, all -> 0x0082
            goto L_0x007b
        L_0x004c:
            r7 = move-exception
            org.quartz.SchedulerException r0 = new org.quartz.SchedulerException     // Catch: all -> 0x0082
            r1 = r0
            java.lang.String r2 = "JTAJobRunShell could not commit UserTransaction."
            r3 = r7
            r1.<init>(r2, r3)     // Catch: all -> 0x0082
            throw r0     // Catch: all -> 0x0082
        L_0x0058:
            r0 = r5
            org.slf4j.Logger r0 = r0.getLog()     // Catch: Exception -> 0x006f, all -> 0x0082
            java.lang.String r1 = "Rolling-back UserTransaction."
            r0.debug(r1)     // Catch: Exception -> 0x006f, all -> 0x0082
            r0 = r5
            javax.transaction.UserTransaction r0 = r0.f3368ut     // Catch: Exception -> 0x006f, all -> 0x0082
            r0.rollback()     // Catch: Exception -> 0x006f, all -> 0x0082
            goto L_0x007b
        L_0x006f:
            r7 = move-exception
            org.quartz.SchedulerException r0 = new org.quartz.SchedulerException     // Catch: all -> 0x0082
            r1 = r0
            java.lang.String r2 = "JTAJobRunShell could not rollback UserTransaction."
            r3 = r7
            r1.<init>(r2, r3)     // Catch: all -> 0x0082
            throw r0     // Catch: all -> 0x0082
        L_0x007b:
            r0 = r5
            r0.cleanupUserTransaction()
            goto L_0x0089
        L_0x0082:
            r8 = move-exception
            r0 = r5
            r0.cleanupUserTransaction()
            r0 = r8
            throw r0
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.p026ee.jta.JTAJobRunShell.complete(boolean):void");
    }

    @Override // org.quartz.core.JobRunShell
    public void passivate() {
        cleanupUserTransaction();
        passivate();
    }

    private void cleanupUserTransaction() {
        if (this.f3368ut != null) {
            UserTransactionHelper.returnUserTransaction(this.f3368ut);
            this.f3368ut = null;
        }
    }
}
