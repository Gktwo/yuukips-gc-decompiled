package org.quartz.commonj;

import commonj.work.WorkManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.quartz.spi.ThreadExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/commonj/WorkManagerThreadExecutor.class */
public class WorkManagerThreadExecutor implements ThreadExecutor {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private String workManagerName;
    private WorkManager workManager;

    @Override // org.quartz.spi.ThreadExecutor
    public void execute(Thread thread) {
        try {
            this.workManager.schedule(new DelegatingWork(thread));
        } catch (Exception e) {
            this.log.error("Error attempting to schedule QuartzSchedulerThread: " + e.getMessage(), (Throwable) e);
        }
    }

    @Override // org.quartz.spi.ThreadExecutor
    public void initialize() {
        try {
            this.workManager = (WorkManager) new InitialContext().lookup(this.workManagerName);
        } catch (NamingException e) {
            throw new IllegalStateException("Could not locate WorkManager: " + e.getMessage(), e);
        }
    }

    public void setWorkManagerName(String workManagerName) {
        this.workManagerName = workManagerName;
    }
}
