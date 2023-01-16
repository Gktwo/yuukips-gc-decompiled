package com.mchange.p006v1.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.mchange.v1.util.AbstractResourcePool */
/* loaded from: grasscutter.jar:com/mchange/v1/util/AbstractResourcePool.class */
public abstract class AbstractResourcePool {
    private static final boolean TRACE = true;
    private static final boolean DEBUG = true;
    private static RunnableQueue sharedQueue = new SimpleRunnableQueue();
    Set managed;
    List unused;
    int start;
    int max;
    int inc;
    int num_acq_attempts;
    int acq_attempt_delay;

    /* renamed from: rq */
    RunnableQueue f385rq;
    boolean initted;
    boolean broken;

    protected abstract Object acquireResource() throws Exception;

    protected abstract void refurbishResource(Object obj) throws BrokenObjectException;

    protected abstract void destroyResource(Object obj) throws Exception;

    /* access modifiers changed from: protected */
    public AbstractResourcePool(int i, int i2, int i3) {
        this(i, i2, i3, sharedQueue);
    }

    protected AbstractResourcePool(int i, int i2, int i3, RunnableQueue runnableQueue) {
        this.managed = new HashSet();
        this.unused = new LinkedList();
        this.num_acq_attempts = Integer.MAX_VALUE;
        this.acq_attempt_delay = 50;
        this.initted = false;
        this.broken = false;
        this.start = i;
        this.max = i2;
        this.inc = i3;
        this.f385rq = runnableQueue;
    }

    protected synchronized void init() throws Exception {
        for (int i = 0; i < this.start; i++) {
            assimilateResource();
        }
        this.initted = true;
    }

    protected Object checkoutResource() throws BrokenObjectException, InterruptedException, Exception {
        return checkoutResource(0);
    }

    protected synchronized Object checkoutResource(long j) throws BrokenObjectException, InterruptedException, TimeoutException, Exception {
        if (!this.initted) {
            init();
        }
        ensureNotBroken();
        if (this.unused.size() == 0) {
            if (this.managed.size() < this.max) {
                postAcquireMore();
            }
            awaitAvailable(j);
        }
        Object obj = this.unused.get(0);
        this.unused.remove(0);
        try {
            refurbishResource(obj);
            trace();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            removeResource(obj);
            return checkoutResource(j);
        }
    }

    protected synchronized void checkinResource(Object obj) throws BrokenObjectException {
        if (!this.managed.contains(obj)) {
            throw new IllegalArgumentException("ResourcePool: Tried to check-in a foreign resource!");
        }
        this.unused.add(obj);
        notifyAll();
        trace();
    }

    protected synchronized void markBad(Object obj) throws Exception {
        removeResource(obj);
    }

    /* access modifiers changed from: protected */
    @Override // com.mchange.p006v1.p007db.sql.ConnectionBundlePool, com.mchange.p006v1.util.ClosableResource
    public synchronized void close() throws Exception {
        this.broken = true;
        for (Object obj : this.managed) {
            try {
                removeResource(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void postAcquireMore() throws InterruptedException {
        this.f385rq.postRunnable(new AcquireTask());
    }

    private void awaitAvailable(long j) throws InterruptedException, TimeoutException {
        int size;
        while (true) {
            size = this.unused.size();
            if (size != 0) {
                break;
            }
            wait(j);
        }
        if (size == 0) {
            throw new TimeoutException();
        }
    }

    /* access modifiers changed from: private */
    public void acquireMore() throws Exception {
        int size = this.managed.size();
        for (int i = 0; i < Math.min(this.inc, this.max - size); i++) {
            assimilateResource();
        }
    }

    private void assimilateResource() throws Exception {
        Object acquireResource = acquireResource();
        this.managed.add(acquireResource);
        this.unused.add(acquireResource);
        notifyAll();
        trace();
    }

    private void removeResource(Object obj) throws Exception {
        this.managed.remove(obj);
        this.unused.remove(obj);
        destroyResource(obj);
        trace();
    }

    private void ensureNotBroken() throws BrokenObjectException {
        if (this.broken) {
            throw new BrokenObjectException(this);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void unexpectedBreak() {
        this.broken = true;
        for (Object obj : this.unused) {
            try {
                removeResource(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void trace() {
        System.err.println(this + "  [managed: " + this.managed.size() + ", unused: " + this.unused.size() + ']');
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v1.util.AbstractResourcePool$AcquireTask */
    /* loaded from: grasscutter.jar:com/mchange/v1/util/AbstractResourcePool$AcquireTask.class */
    public class AcquireTask implements Runnable {
        boolean success = false;

        AcquireTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (!this.success && i < AbstractResourcePool.this.num_acq_attempts) {
                if (i > 0) {
                    try {
                        Thread.sleep((long) AbstractResourcePool.this.acq_attempt_delay);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                synchronized (AbstractResourcePool.this) {
                    AbstractResourcePool.this.acquireMore();
                }
                this.success = true;
                i++;
            }
            if (!this.success) {
                AbstractResourcePool.this.unexpectedBreak();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: com.mchange.v1.util.AbstractResourcePool$TimeoutException */
    /* loaded from: grasscutter.jar:com/mchange/v1/util/AbstractResourcePool$TimeoutException.class */
    public class TimeoutException extends Exception {
        protected TimeoutException() {
        }
    }
}
