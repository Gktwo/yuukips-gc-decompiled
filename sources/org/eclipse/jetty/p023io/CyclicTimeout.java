package org.eclipse.jetty.p023io;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.CyclicTimeout */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/CyclicTimeout.class */
public abstract class CyclicTimeout implements Destroyable {
    private static final Logger LOG = Log.getLogger(CyclicTimeout.class);
    private static final Timeout NOT_SET = new Timeout(LongCompanionObject.MAX_VALUE, null);
    private static final Scheduler.Task DESTROYED = () -> {
        return false;
    };
    private final Scheduler _scheduler;
    private final AtomicReference<Timeout> _timeout = new AtomicReference<>(NOT_SET);

    public abstract void onTimeoutExpired();

    public CyclicTimeout(Scheduler scheduler) {
        this._scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return this._scheduler;
    }

    public boolean schedule(long delay, TimeUnit units) {
        Timeout timeout;
        boolean result;
        Wakeup wakeup;
        long now = System.nanoTime();
        long newTimeoutAt = now + units.toNanos(delay);
        Wakeup newWakeup = null;
        do {
            timeout = this._timeout.get();
            result = timeout._at != LongCompanionObject.MAX_VALUE;
            wakeup = timeout._wakeup;
            if (wakeup == null || wakeup._at > newTimeoutAt) {
                Wakeup wakeup2 = new Wakeup(newTimeoutAt, wakeup);
                newWakeup = wakeup2;
                wakeup = wakeup2;
            }
        } while (!this._timeout.compareAndSet(timeout, new Timeout(newTimeoutAt, wakeup)));
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(units.toMillis(delay));
            objArr[1] = newWakeup != null ? "new" : "existing";
            objArr[2] = Long.valueOf(TimeUnit.NANOSECONDS.toMillis(wakeup._at - now));
            logger.debug("Installed timeout in {} ms, {} wake up in {} ms", objArr);
        }
        if (newWakeup != null) {
            newWakeup.schedule(now);
        }
        return result;
    }

    public boolean cancel() {
        Timeout timeout;
        boolean result;
        Wakeup wakeup;
        do {
            timeout = this._timeout.get();
            result = timeout._at != LongCompanionObject.MAX_VALUE;
            wakeup = timeout._wakeup;
        } while (!this._timeout.compareAndSet(timeout, wakeup == null ? NOT_SET : new Timeout(LongCompanionObject.MAX_VALUE, wakeup)));
        return result;
    }

    @Override // org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        Timeout timeout = this._timeout.getAndSet(NOT_SET);
        for (Wakeup wakeup = timeout == null ? null : timeout._wakeup; wakeup != null; wakeup = wakeup._next) {
            wakeup.destroy();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.CyclicTimeout$Timeout */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/CyclicTimeout$Timeout.class */
    public static class Timeout {
        private final long _at;
        private final Wakeup _wakeup;

        private Timeout(long timeoutAt, Wakeup wakeup) {
            this._at = timeoutAt;
            this._wakeup = wakeup;
        }

        public String toString() {
            return String.format("%s@%x:%dms,%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(this._at - System.nanoTime())), this._wakeup);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.CyclicTimeout$Wakeup */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/CyclicTimeout$Wakeup.class */
    public class Wakeup implements Runnable {
        private final AtomicReference<Scheduler.Task> _task;
        private final long _at;
        private final Wakeup _next;

        private Wakeup(long wakeupAt, Wakeup next) {
            this._task = new AtomicReference<>();
            this._at = wakeupAt;
            this._next = next;
        }

        /* access modifiers changed from: private */
        public void schedule(long now) {
            this._task.compareAndSet(null, CyclicTimeout.this._scheduler.schedule(this, this._at - now, TimeUnit.NANOSECONDS));
        }

        /* access modifiers changed from: private */
        public void destroy() {
            Scheduler.Task task = this._task.getAndSet(CyclicTimeout.DESTROYED);
            if (task != null) {
                task.cancel();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Timeout timeout;
            Timeout newTimeout;
            long now = System.nanoTime();
            Wakeup newWakeup = null;
            boolean hasExpired = false;
            do {
                timeout = (Timeout) CyclicTimeout.this._timeout.get();
                Wakeup wakeup = timeout._wakeup;
                while (wakeup != null && wakeup != this) {
                    wakeup = wakeup._next;
                }
                if (wakeup != null) {
                    Wakeup wakeup2 = wakeup._next;
                    if (timeout._at <= now) {
                        hasExpired = true;
                        newTimeout = wakeup2 == null ? CyclicTimeout.NOT_SET : new Timeout(LongCompanionObject.MAX_VALUE, wakeup2);
                    } else if (timeout._at != LongCompanionObject.MAX_VALUE) {
                        if (wakeup2 == null || wakeup2._at >= timeout._at) {
                            Wakeup wakeup3 = new Wakeup(timeout._at, wakeup2);
                            newWakeup = wakeup3;
                            wakeup2 = wakeup3;
                        }
                        newTimeout = new Timeout(timeout._at, wakeup2);
                    } else {
                        newTimeout = wakeup2 == null ? CyclicTimeout.NOT_SET : new Timeout(LongCompanionObject.MAX_VALUE, wakeup2);
                    }
                } else {
                    return;
                }
            } while (!CyclicTimeout.this._timeout.compareAndSet(timeout, newTimeout));
            if (newWakeup != null) {
                newWakeup.schedule(now);
            }
            if (hasExpired) {
                CyclicTimeout.this.onTimeoutExpired();
            }
        }

        @Override // java.lang.Object
        public String toString() {
            Object[] objArr = new Object[4];
            objArr[0] = getClass().getSimpleName();
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = Long.valueOf(this._at == LongCompanionObject.MAX_VALUE ? this._at : TimeUnit.NANOSECONDS.toMillis(this._at - System.nanoTime()));
            objArr[3] = this._next;
            return String.format("%s@%x:%dms->%s", objArr);
        }
    }
}
