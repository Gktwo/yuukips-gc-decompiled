package com.zaxxer.hikari.util;

import java.util.concurrent.Semaphore;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/util/SuspendResumeLock.class */
public class SuspendResumeLock {
    public static final SuspendResumeLock FAUX_LOCK = new SuspendResumeLock(false) { // from class: com.zaxxer.hikari.util.SuspendResumeLock.1
        @Override // com.zaxxer.hikari.util.SuspendResumeLock
        public void acquire() {
        }

        @Override // com.zaxxer.hikari.util.SuspendResumeLock
        public void release() {
        }

        @Override // com.zaxxer.hikari.util.SuspendResumeLock
        public void suspend() {
        }

        @Override // com.zaxxer.hikari.util.SuspendResumeLock
        public void resume() {
        }
    };
    private static final int MAX_PERMITS = 10000;
    private final Semaphore acquisitionSemaphore;

    public SuspendResumeLock() {
        this(true);
    }

    private SuspendResumeLock(boolean createSemaphore) {
        this.acquisitionSemaphore = createSemaphore ? new Semaphore(10000, true) : null;
    }

    public void acquire() {
        this.acquisitionSemaphore.acquireUninterruptibly();
    }

    public void release() {
        this.acquisitionSemaphore.release();
    }

    public void suspend() {
        this.acquisitionSemaphore.acquireUninterruptibly(10000);
    }

    public void resume() {
        this.acquisitionSemaphore.release(10000);
    }
}
