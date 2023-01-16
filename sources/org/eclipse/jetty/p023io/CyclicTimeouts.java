package org.eclipse.jetty.p023io;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.p023io.CyclicTimeouts.Expirable;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.CyclicTimeouts */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/CyclicTimeouts.class */
public abstract class CyclicTimeouts<T extends Expirable> implements Destroyable {
    private static final Logger LOG = Log.getLogger(CyclicTimeouts.class);
    private final AtomicLong earliestTimeout = new AtomicLong(LongCompanionObject.MAX_VALUE);
    private final CyclicTimeout cyclicTimeout;

    /* renamed from: org.eclipse.jetty.io.CyclicTimeouts$Expirable */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/CyclicTimeouts$Expirable.class */
    public interface Expirable {
        long getExpireNanoTime();
    }

    protected abstract Iterator<T> iterator();

    protected abstract boolean onExpired(T t);

    public CyclicTimeouts(Scheduler scheduler) {
        this.cyclicTimeout = new Timeouts(scheduler);
    }

    /* JADX WARN: Type inference failed for: r0v33, types: [long] */
    /* access modifiers changed from: private */
    public void onTimeoutExpired() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Timeouts check for {}", this);
        }
        long now = System.nanoTime();
        char c = 65535;
        this.earliestTimeout.set(LongCompanionObject.MAX_VALUE);
        Iterator<T> iterator = iterator();
        if (iterator != null) {
            while (iterator.hasNext()) {
                T expirable = iterator.next();
                long expiresAt = expirable.getExpireNanoTime();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Entity {} expires in {} ms for {}", expirable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(expiresAt - now)), this);
                }
                if (expiresAt != -1) {
                    if (expiresAt <= now) {
                        boolean remove = onExpired(expirable);
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Entity {} expired, remove={} for {}", expirable, Boolean.valueOf(remove), this);
                        }
                        if (remove) {
                            iterator.remove();
                        }
                    } else {
                        c = Math.min((long) c, expiresAt);
                    }
                }
            }
            if (c < LongCompanionObject.MAX_VALUE) {
                schedule(c);
            }
        }
    }

    public void schedule(T expirable) {
        long expiresAt = expirable.getExpireNanoTime();
        if (expiresAt < LongCompanionObject.MAX_VALUE) {
            schedule(expiresAt);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void schedule(long r10) {
        /*
            r9 = this;
            r0 = r9
            java.util.concurrent.atomic.AtomicLong r0 = r0.earliestTimeout
            r1 = r10
            void r1 = (v1) -> { // java.util.function.LongUnaryOperator.applyAsLong(long):long
                return lambda$schedule$0(r1, v1);
            }
            long r0 = r0.getAndUpdate(r1)
            r12 = r0
            r0 = r10
            r14 = r0
        L_0x0011:
            r0 = r14
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x006c
            r0 = 0
            r1 = r14
            long r2 = java.lang.System.nanoTime()
            long r1 = r1 - r2
            long r0 = java.lang.Math.max(r0, r1)
            r16 = r0
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.p023io.CyclicTimeouts.LOG
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x004f
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.p023io.CyclicTimeouts.LOG
            java.lang.String r1 = "Scheduling timeout in {} ms for {}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            r6 = r16
            long r5 = r5.toMillis(r6)
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r9
            r3[r4] = r5
            r0.debug(r1, r2)
        L_0x004f:
            r0 = r9
            r1 = r9
            org.eclipse.jetty.io.CyclicTimeout r1 = r1.cyclicTimeout
            r2 = r16
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            boolean r0 = r0.schedule(r1, r2, r3)
            r0 = r14
            r12 = r0
            r0 = r9
            java.util.concurrent.atomic.AtomicLong r0 = r0.earliestTimeout
            long r0 = r0.get()
            r14 = r0
            goto L_0x0011
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.CyclicTimeouts.schedule(long):void");
    }

    @Override // org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        this.cyclicTimeout.destroy();
    }

    boolean schedule(CyclicTimeout cyclicTimeout, long delay, TimeUnit unit) {
        return cyclicTimeout.schedule(delay, unit);
    }

    /* renamed from: org.eclipse.jetty.io.CyclicTimeouts$Timeouts */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/CyclicTimeouts$Timeouts.class */
    private class Timeouts extends CyclicTimeout {
        private Timeouts(Scheduler scheduler) {
            super(scheduler);
        }

        @Override // org.eclipse.jetty.p023io.CyclicTimeout
        public void onTimeoutExpired() {
            CyclicTimeouts.this.onTimeoutExpired();
        }
    }
}
