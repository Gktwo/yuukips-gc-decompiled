package org.eclipse.jetty.p023io;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.IdleTimeout */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/IdleTimeout.class */
public abstract class IdleTimeout {
    private static final Logger LOG = Log.getLogger(IdleTimeout.class);
    private final Scheduler _scheduler;
    private volatile long _idleTimeout;
    private final AtomicReference<Scheduler.Task> _timeout = new AtomicReference<>();
    private volatile long _idleTimestamp = System.nanoTime();

    protected abstract void onIdleExpired(TimeoutException timeoutException);

    @Override // org.eclipse.jetty.p023io.EndPoint
    public abstract boolean isOpen();

    public IdleTimeout(Scheduler scheduler) {
        this._scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return this._scheduler;
    }

    public long getIdleFor() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._idleTimestamp);
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public long getIdleTimeout() {
        return this._idleTimeout;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public void setIdleTimeout(long idleTimeout) {
        long old = this._idleTimeout;
        this._idleTimeout = idleTimeout;
        if (old > 0) {
            if (old > idleTimeout) {
                deactivate();
            } else {
                return;
            }
        }
        if (isOpen()) {
            activate();
        }
    }

    public void notIdle() {
        this._idleTimestamp = System.nanoTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void idleCheck() {
        /*
            r6 = this;
            r0 = r6
            long r0 = r0.checkIdleTimeout()
            r7 = r0
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x001d
            r0 = r6
            r1 = r7
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0016
            r1 = r7
            goto L_0x001a
        L_0x0016:
            r1 = r6
            long r1 = r1.getIdleTimeout()
        L_0x001a:
            r0.scheduleIdleTimeout(r1)
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.IdleTimeout.idleCheck():void");
    }

    private void scheduleIdleTimeout(long delay) {
        Scheduler.Task newTimeout = null;
        if (isOpen() && delay > 0 && this._scheduler != null) {
            newTimeout = this._scheduler.schedule(this::idleCheck, delay, TimeUnit.MILLISECONDS);
        }
        Scheduler.Task oldTimeout = this._timeout.getAndSet(newTimeout);
        if (oldTimeout != null) {
            oldTimeout.cancel();
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public void onOpen() {
        activate();
    }

    private void activate() {
        if (this._idleTimeout > 0) {
            idleCheck();
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public void onClose() {
        deactivate();
    }

    private void deactivate() {
        Scheduler.Task oldTimeout = this._timeout.getAndSet(null);
        if (oldTimeout != null) {
            oldTimeout.cancel();
        }
    }

    protected long checkIdleTimeout() {
        if (!isOpen()) {
            return -1;
        }
        long idleElapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._idleTimestamp);
        long idleTimeout = getIdleTimeout();
        long idleLeft = idleTimeout - idleElapsed;
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} idle timeout check, elapsed: {} ms, remaining: {} ms", this, Long.valueOf(idleElapsed), Long.valueOf(idleLeft));
        }
        if (idleTimeout > 0 && idleLeft <= 0) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} idle timeout expired", this);
            }
            try {
                onIdleExpired(new TimeoutException("Idle timeout expired: " + idleElapsed + "/" + idleTimeout + " ms"));
                notIdle();
            } catch (Throwable th) {
                notIdle();
                throw th;
            }
        }
        if (idleLeft >= 0) {
            return idleLeft;
        }
        return 0;
    }
}
