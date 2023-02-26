package org.quartz.core;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import kcp.highway.Kcp;
import org.quartz.spi.JobStore;
import org.quartz.spi.OperableTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/core/QuartzSchedulerThread.class */
public class QuartzSchedulerThread extends Thread {

    /* renamed from: qs */
    private QuartzScheduler f3331qs;
    private QuartzSchedulerResources qsRsrcs;
    private final Object sigLock;
    private boolean signaled;
    private long signaledNextFireTime;
    private boolean paused;
    private AtomicBoolean halted;
    private Random random;
    private static long DEFAULT_IDLE_WAIT_TIME = 30000;
    private long idleWaitTime;
    private int idleWaitVariablness;
    private final Logger log;
    private static final long MIN_DELAY = 20;
    private static final long MAX_DELAY = 600000;

    /* access modifiers changed from: package-private */
    public QuartzSchedulerThread(QuartzScheduler qs, QuartzSchedulerResources qsRsrcs) {
        this(qs, qsRsrcs, qsRsrcs.getMakeSchedulerThreadDaemon(), 5);
    }

    QuartzSchedulerThread(QuartzScheduler qs, QuartzSchedulerResources qsRsrcs, boolean setDaemon, int threadPrio) {
        super(qs.getSchedulerThreadGroup(), qsRsrcs.getThreadName());
        this.sigLock = new Object();
        this.random = new Random(System.currentTimeMillis());
        this.idleWaitTime = DEFAULT_IDLE_WAIT_TIME;
        this.idleWaitVariablness = Kcp.IKCP_PROBE_INIT;
        this.log = LoggerFactory.getLogger(getClass());
        this.f3331qs = qs;
        this.qsRsrcs = qsRsrcs;
        setDaemon(setDaemon);
        if (qsRsrcs.isThreadsInheritInitializersClassLoadContext()) {
            this.log.info("QuartzSchedulerThread Inheriting ContextClassLoader of thread: " + Thread.currentThread().getName());
            setContextClassLoader(Thread.currentThread().getContextClassLoader());
        }
        setPriority(threadPrio);
        this.paused = true;
        this.halted = new AtomicBoolean(false);
    }

    /* access modifiers changed from: package-private */
    public void setIdleWaitTime(long waitTime) {
        this.idleWaitTime = waitTime;
        this.idleWaitVariablness = (int) (((double) waitTime) * 0.2d);
    }

    private long getRandomizedIdleWaitTime() {
        return this.idleWaitTime - ((long) this.random.nextInt(this.idleWaitVariablness));
    }

    /* access modifiers changed from: package-private */
    public void togglePause(boolean pause) {
        synchronized (this.sigLock) {
            this.paused = pause;
            if (this.paused) {
                signalSchedulingChange(0);
            } else {
                this.sigLock.notifyAll();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void halt(boolean wait) {
        synchronized (this.sigLock) {
            this.halted.set(true);
            if (this.paused) {
                this.sigLock.notifyAll();
            } else {
                signalSchedulingChange(0);
            }
        }
        if (wait) {
            boolean interrupted = false;
            while (true) {
                try {
                    join();
                    break;
                } catch (InterruptedException e) {
                    interrupted = true;
                } catch (Throwable th) {
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isPaused() {
        return this.paused;
    }

    public void signalSchedulingChange(long candidateNewNextFireTime) {
        synchronized (this.sigLock) {
            this.signaled = true;
            this.signaledNextFireTime = candidateNewNextFireTime;
            this.sigLock.notifyAll();
        }
    }

    public void clearSignaledSchedulingChange() {
        synchronized (this.sigLock) {
            this.signaled = false;
            this.signaledNextFireTime = 0;
        }
    }

    public boolean isScheduleChanged() {
        boolean z;
        synchronized (this.sigLock) {
            z = this.signaled;
        }
        return z;
    }

    public long getSignaledNextFireTime() {
        long j;
        synchronized (this.sigLock) {
            j = this.signaledNextFireTime;
        }
        return j;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x0031
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        /*
        // Method dump skipped, instructions count: 1041
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.core.QuartzSchedulerThread.run():void");
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    private static long computeDelayForRepeatedErrors(JobStore jobStore, int acquiresFailed) {
        char c;
        try {
            c = jobStore.getAcquireRetryDelay(acquiresFailed);
        } catch (Exception e) {
            c = 'd';
        }
        if (c < 20) {
            c = 20;
        }
        if (c > 600000) {
            c = 10176;
        }
        return c;
    }

    private boolean releaseIfScheduleChangedSignificantly(List<OperableTrigger> triggers, long triggerTime) {
        if (!isCandidateNewTimeEarlierWithinReason(triggerTime, true)) {
            return false;
        }
        for (OperableTrigger trigger : triggers) {
            this.qsRsrcs.getJobStore().releaseAcquiredTrigger(trigger);
        }
        triggers.clear();
        return true;
    }

    private boolean isCandidateNewTimeEarlierWithinReason(long oldTime, boolean clearSignal) {
        synchronized (this.sigLock) {
            if (!isScheduleChanged()) {
                return false;
            }
            boolean earlier = false;
            if (getSignaledNextFireTime() == 0) {
                earlier = true;
            } else if (getSignaledNextFireTime() < oldTime) {
                earlier = true;
            }
            if (earlier) {
                if (oldTime - System.currentTimeMillis() < (this.qsRsrcs.getJobStore().supportsPersistence() ? 70 : 7)) {
                    earlier = false;
                }
            }
            if (clearSignal) {
                clearSignaledSchedulingChange();
            }
            return earlier;
        }
    }

    public Logger getLog() {
        return this.log;
    }
}
