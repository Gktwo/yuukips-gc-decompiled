package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.FileAppender;

/* compiled from: Throttler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018��2\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b��\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H��¢\u0006\u0002\b\fJ$\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H��¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u0018"}, m373d2 = {"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "okio"})
/* loaded from: grasscutter.jar:okio/Throttler.class */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long waitByteCount;
    private long maxByteCount;

    @JvmOverloads
    public final void bytesPerSecond(long bytesPerSecond, long waitByteCount) {
        bytesPerSecond$default(this, bytesPerSecond, waitByteCount, 0, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long bytesPerSecond) {
        bytesPerSecond$default(this, bytesPerSecond, 0, 0, 6, null);
    }

    public Throttler(long allocatedUntil) {
        this.allocatedUntil = allocatedUntil;
        this.waitByteCount = FileAppender.DEFAULT_BUFFER_SIZE;
        this.maxByteCount = 262144;
    }

    public Throttler() {
        this(System.nanoTime());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void bytesPerSecond$default(okio.Throttler r8, long r9, long r11, long r13, int r15, java.lang.Object r16) {
        /*
            r0 = r15
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x000c
            r0 = r8
            long r0 = r0.waitByteCount
            r11 = r0
        L_0x000c:
            r0 = r15
            r1 = 4
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0019
            r0 = r8
            long r0 = r0.maxByteCount
            r13 = r0
        L_0x0019:
            r0 = r8
            r1 = r9
            r2 = r11
            r3 = r13
            r0.bytesPerSecond(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Throttler.bytesPerSecond$default(okio.Throttler, long, long, long, int, java.lang.Object):void");
    }

    @JvmOverloads
    public final void bytesPerSecond(long bytesPerSecond, long waitByteCount, long maxByteCount) {
        synchronized (this) {
            if (!(bytesPerSecond >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(waitByteCount > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(maxByteCount >= waitByteCount)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.bytesPerSecond = bytesPerSecond;
            this.waitByteCount = waitByteCount;
            this.maxByteCount = maxByteCount;
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final long take$okio(long byteCount) {
        long byteCountOrWaitNanos;
        if (!(byteCount > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            while (true) {
                byteCountOrWaitNanos = byteCountOrWaitNanos$okio(System.nanoTime(), byteCount);
                if (byteCountOrWaitNanos < 0) {
                    waitNanos(-byteCountOrWaitNanos);
                }
            }
        }
        return byteCountOrWaitNanos;
    }

    public final long byteCountOrWaitNanos$okio(long now, long byteCount) {
        if (this.bytesPerSecond == 0) {
            return byteCount;
        }
        long idleInNanos = Math.max(this.allocatedUntil - now, 0L);
        long immediateBytes = this.maxByteCount - nanosToBytes(idleInNanos);
        if (immediateBytes >= byteCount) {
            this.allocatedUntil = now + idleInNanos + bytesToNanos(byteCount);
            return byteCount;
        } else if (immediateBytes >= this.waitByteCount) {
            this.allocatedUntil = now + bytesToNanos(this.maxByteCount);
            return immediateBytes;
        } else {
            long minByteCount = Math.min(this.waitByteCount, byteCount);
            long minWaitNanos = idleInNanos + bytesToNanos(minByteCount - this.maxByteCount);
            if (minWaitNanos != 0) {
                return -minWaitNanos;
            }
            this.allocatedUntil = now + bytesToNanos(this.maxByteCount);
            return minByteCount;
        }
    }

    private final long nanosToBytes(long $this$nanosToBytes) {
        return ($this$nanosToBytes * this.bytesPerSecond) / 1000000000;
    }

    private final long bytesToNanos(long $this$bytesToNanos) {
        return ($this$bytesToNanos * 1000000000) / this.bytesPerSecond;
    }

    private final void waitNanos(long nanosToWait) {
        long millisToWait = nanosToWait / 1000000;
        wait(millisToWait, (int) (nanosToWait - (millisToWait * 1000000)));
    }

    @NotNull
    public final Source source(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new ForwardingSource(this, source) { // from class: okio.Throttler$source$1
            final /* synthetic */ Throttler this$0;
            final /* synthetic */ Source $source;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.$source = $source;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    return read(sink, this.this$0.take$okio(byteCount));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new ForwardingSink(this, sink) { // from class: okio.Throttler$sink$1
            final /* synthetic */ Throttler this$0;
            final /* synthetic */ Sink $sink;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.$sink = $sink;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v11, types: [long] */
            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer source, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(source, "source");
                char c = byteCount;
                while (c > 0) {
                    try {
                        long toWrite = this.this$0.take$okio(c);
                        write(source, toWrite);
                        c -= toWrite;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }
}
