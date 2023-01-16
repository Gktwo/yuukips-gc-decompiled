package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;

/* compiled from: Timeout.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018�� \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020��H\u0016J\b\u0010\t\u001a\u00020��H\u0016J\u0016\u0010\n\u001a\u00020��2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020��2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J-\u0010\u000e\u001a\u0002H\u000f\"\u0004\b��\u0010\u000f2\u0006\u0010\u0010\u001a\u00020��2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\bø\u0001��¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020��2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, m373d2 = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "T", "other", "block", "Lkotlin/Function0;", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfReached", "", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"})
/* loaded from: grasscutter.jar:okio/Timeout.class */
public class Timeout {
    private boolean hasDeadline;
    private long deadlineNanoTime;
    private long timeoutNanos;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout$Companion$NONE$1
        @Override // okio.Timeout
        @NotNull
        public Timeout timeout(long timeout, @NotNull TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this;
        }

        @Override // okio.Timeout
        @NotNull
        public Timeout deadlineNanoTime(long deadlineNanoTime) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() {
        }
    };

    @NotNull
    public Timeout timeout(long timeout, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(timeout >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("timeout < 0: ", Long.valueOf(timeout)).toString());
        }
        this.timeoutNanos = unit.toNanos(timeout);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    @NotNull
    public Timeout deadlineNanoTime(long deadlineNanoTime) {
        this.hasDeadline = true;
        this.deadlineNanoTime = deadlineNanoTime;
        return this;
    }

    @NotNull
    public final Timeout deadline(long duration, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (duration > 0) {
            return deadlineNanoTime(System.nanoTime() + unit.toNanos(duration));
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("duration <= 0: ", Long.valueOf(duration)).toString());
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void waitUntilNotified(@org.jetbrains.annotations.NotNull java.lang.Object r11) throws java.io.InterruptedIOException {
        /*
            r10 = this;
            r0 = r11
            java.lang.String r1 = "monitor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            boolean r0 = r0.hasDeadline()     // Catch: InterruptedException -> 0x0091
            r12 = r0
            r0 = r10
            long r0 = r0.timeoutNanos()     // Catch: InterruptedException -> 0x0091
            r13 = r0
            r0 = r12
            if (r0 != 0) goto L_0x0020
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0020
            r0 = r11
            r0.wait()     // Catch: InterruptedException -> 0x0091
            return
        L_0x0020:
            long r0 = java.lang.System.nanoTime()     // Catch: InterruptedException -> 0x0091
            r15 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0044
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0044
            r0 = r10
            long r0 = r0.deadlineNanoTime()     // Catch: InterruptedException -> 0x0091
            r1 = r15
            long r0 = r0 - r1
            r19 = r0
            r0 = 0
            r21 = r0
            r0 = r13
            r1 = r19
            long r0 = java.lang.Math.min(r0, r1)     // Catch: InterruptedException -> 0x0091
            goto L_0x0053
        L_0x0044:
            r0 = r12
            if (r0 == 0) goto L_0x0052
            r0 = r10
            long r0 = r0.deadlineNanoTime()     // Catch: InterruptedException -> 0x0091
            r1 = r15
            long r0 = r0 - r1
            goto L_0x0053
        L_0x0052:
            r0 = r13
        L_0x0053:
            r17 = r0
            r0 = 0
            r19 = r0
            r0 = r17
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x007f
            r0 = r17
            r1 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r1
            r21 = r0
            r0 = r11
            r1 = r21
            r2 = r17
            r3 = r21
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 * r4
            long r2 = r2 - r3
            int r2 = (int) r2     // Catch: InterruptedException -> 0x0091
            r0.wait(r1, r2)     // Catch: InterruptedException -> 0x0091
            long r0 = java.lang.System.nanoTime()     // Catch: InterruptedException -> 0x0091
            r1 = r15
            long r0 = r0 - r1
            r19 = r0
        L_0x007f:
            r0 = r19
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00a2
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch: InterruptedException -> 0x0091
            r1 = r0
            java.lang.String r2 = "timeout"
            r1.<init>(r2)     // Catch: InterruptedException -> 0x0091
            throw r0     // Catch: InterruptedException -> 0x0091
        L_0x0091:
            r12 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException
            r1 = r0
            java.lang.String r2 = "interrupted"
            r1.<init>(r2)
            throw r0
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Timeout.waitUntilNotified(java.lang.Object):void");
    }

    /* JADX INFO: finally extract failed */
    public final <T> T intersectWith(@NotNull Timeout other, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(function0, "block");
        long originalTimeout = timeoutNanos();
        timeout(Companion.minTimeout(other.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
        if (hasDeadline()) {
            long originalDeadline = deadlineNanoTime();
            if (other.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
            }
            try {
                T t = (T) function0.invoke();
                InlineMarker.finallyStart(1);
                timeout(originalTimeout, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    deadlineNanoTime(originalDeadline);
                }
                InlineMarker.finallyEnd(1);
                return t;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                timeout(originalTimeout, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    deadlineNanoTime(originalDeadline);
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else {
            if (other.hasDeadline()) {
                deadlineNanoTime(other.deadlineNanoTime());
            }
            try {
                T t2 = (T) function0.invoke();
                InlineMarker.finallyStart(1);
                timeout(originalTimeout, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                return t2;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                timeout(originalTimeout, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    /* compiled from: Timeout.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\t"}, m373d2 = {"Lokio/Timeout$Companion;", "", "()V", Constraint.NONE, "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "okio"})
    /* loaded from: grasscutter.jar:okio/Timeout$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public final long minTimeout(long aNanos, long bNanos) {
            if (aNanos == 0) {
                return bNanos;
            }
            if (bNanos != 0 && aNanos >= bNanos) {
                return bNanos;
            }
            return aNanos;
        }
    }
}
