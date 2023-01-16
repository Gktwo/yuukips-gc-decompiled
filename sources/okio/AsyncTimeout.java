package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;

/* compiled from: AsyncTimeout.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018�� \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J%\u0010\u0016\u001a\u0002H\u0017\"\u0004\b��\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\bø\u0001��¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0005\u001a\u0004\u0018\u00010��X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n��\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, m373d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", Tmux.CMD_NEXT, "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"})
/* loaded from: grasscutter.jar:okio/AsyncTimeout.class */
public class AsyncTimeout extends Timeout {
    private boolean inQueue;
    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    @Nullable
    private static AsyncTimeout head;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            Companion.scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.cancelScheduledTimeout(this);
    }

    /* access modifiers changed from: private */
    public final long remainingNanos(long now) {
        return this.timeoutAt - now;
    }

    protected void timedOut() {
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Sink(this, sink) { // from class: okio.AsyncTimeout$sink$1
            final /* synthetic */ AsyncTimeout this$0;
            final /* synthetic */ Sink $sink;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.$sink = $sink;
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0061 */
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0078 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r9v0, types: [long] */
            /* JADX WARN: Type inference failed for: r0v50, types: [long] */
            /* JADX WARN: Type inference failed for: r0v58 */
            @Override // okio.Sink
            public void write(@NotNull Buffer source, long j) {
                Intrinsics.checkNotNullParameter(source, "source");
                _UtilKt.checkOffsetAndCount(source.size(), 0, j);
                char c = j;
                while ((c == 1 ? 1 : 0) > 0) {
                    char c2 = 0;
                    Segment s = source.head;
                    Intrinsics.checkNotNull(s);
                    while (true) {
                        if (c2 >= 65536) {
                            break;
                        }
                        char c3 = c2 + ((long) (s.limit - s.pos));
                        if (c3 >= c) {
                            c2 = c == 1 ? 1 : 0;
                            break;
                        }
                        s = s.next;
                        Intrinsics.checkNotNull(s);
                        c2 = c3;
                    }
                    AsyncTimeout this_$iv = this.this$0;
                    Sink sink2 = this.$sink;
                    boolean throwOnTimeout$iv = false;
                    this_$iv.enter();
                    try {
                        try {
                            sink2.write(source, c2);
                            Unit unit = Unit.INSTANCE;
                            throwOnTimeout$iv = true;
                            if (this_$iv.exit()) {
                                throw this_$iv.access$newTimeoutException(null);
                            }
                            c -= c2;
                        } catch (IOException e$iv) {
                            if (this_$iv.exit()) {
                                throw this_$iv.access$newTimeoutException(e$iv);
                            }
                            throw e$iv;
                        }
                    } catch (Throwable th) {
                        if (!this_$iv.exit() || !throwOnTimeout$iv) {
                            throw th;
                        }
                        throw this_$iv.access$newTimeoutException(null);
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                boolean throwOnTimeout$iv;
                AsyncTimeout this_$iv;
                try {
                    this_$iv = this.this$0;
                    Sink sink2 = this.$sink;
                    throwOnTimeout$iv = false;
                    this_$iv.enter();
                    try {
                        sink2.flush();
                        Unit unit = Unit.INSTANCE;
                        throwOnTimeout$iv = true;
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                    }
                } catch (Throwable th) {
                    if (!this_$iv.exit() || !throwOnTimeout$iv) {
                        throw th;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                boolean throwOnTimeout$iv;
                AsyncTimeout this_$iv;
                try {
                    this_$iv = this.this$0;
                    Sink sink2 = this.$sink;
                    throwOnTimeout$iv = false;
                    this_$iv.enter();
                    try {
                        sink2.close();
                        Unit unit = Unit.INSTANCE;
                        throwOnTimeout$iv = true;
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                    }
                } catch (Throwable th) {
                    if (!this_$iv.exit() || !throwOnTimeout$iv) {
                        throw th;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                }
            }

            @Override // okio.Sink
            @NotNull
            public AsyncTimeout timeout() {
                return this.this$0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return "AsyncTimeout.sink(" + this.$sink + ')';
            }
        };
    }

    @NotNull
    public final Source source(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Source(this, source) { // from class: okio.AsyncTimeout$source$1
            final /* synthetic */ AsyncTimeout this$0;
            final /* synthetic */ Source $source;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.$source = $source;
            }

            @Override // okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                boolean throwOnTimeout$iv;
                AsyncTimeout this_$iv;
                try {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    this_$iv = this.this$0;
                    Source source2 = this.$source;
                    throwOnTimeout$iv = false;
                    this_$iv.enter();
                    try {
                        long result$iv = source2.read(sink, byteCount);
                        throwOnTimeout$iv = true;
                        if (!this_$iv.exit()) {
                            return result$iv;
                        }
                        throw this_$iv.access$newTimeoutException(null);
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    if (!this_$iv.exit() || !throwOnTimeout$iv) {
                        throw th;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                boolean throwOnTimeout$iv;
                AsyncTimeout this_$iv;
                try {
                    this_$iv = this.this$0;
                    Source source2 = this.$source;
                    throwOnTimeout$iv = false;
                    this_$iv.enter();
                    try {
                        source2.close();
                        Unit unit = Unit.INSTANCE;
                        throwOnTimeout$iv = true;
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                    }
                } catch (Throwable th) {
                    if (!this_$iv.exit() || !throwOnTimeout$iv) {
                        throw th;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                }
            }

            @Override // okio.Source
            @NotNull
            public AsyncTimeout timeout() {
                return this.this$0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return "AsyncTimeout.source(" + this.$source + ')';
            }
        };
    }

    public final <T> T withTimeout(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean throwOnTimeout = false;
        enter();
        try {
            try {
                T t = (T) function0.invoke();
                throwOnTimeout = true;
                InlineMarker.finallyStart(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                InlineMarker.finallyEnd(1);
                return t;
            } catch (IOException e) {
                if (!exit()) {
                    throw e;
                }
                throw access$newTimeoutException(e);
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!exit() || !throwOnTimeout) {
                InlineMarker.finallyEnd(1);
                throw th;
            }
            throw access$newTimeoutException(null);
        }
    }

    @PublishedApi
    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException cause) {
        return newTimeoutException(cause);
    }

    @NotNull
    protected IOException newTimeoutException(@Nullable IOException cause) {
        InterruptedIOException e = new InterruptedIOException("timeout");
        if (cause != null) {
            e.initCause(cause);
        }
        return e;
    }

    /* compiled from: AsyncTimeout.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\b\u0002\u0018��2\u00020\u0001B\u0007\b��¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m373d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"})
    /* loaded from: grasscutter.jar:okio/AsyncTimeout$Watchdog.class */
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout awaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        awaitTimeout$okio = AsyncTimeout.Companion.awaitTimeout$okio();
                        if (awaitTimeout$okio == AsyncTimeout.head) {
                            Companion companion = AsyncTimeout.Companion;
                            AsyncTimeout.head = null;
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (awaitTimeout$okio != null) {
                        awaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* compiled from: AsyncTimeout.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH��¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n��R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n��¨\u0006\u0013"}, m373d2 = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"})
    /* loaded from: grasscutter.jar:okio/AsyncTimeout$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout node, long timeoutNanos, boolean hasDeadline) {
            synchronized (AsyncTimeout.class) {
                if (!(!node.inQueue)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                node.inQueue = true;
                if (AsyncTimeout.head == null) {
                    Companion companion = AsyncTimeout.Companion;
                    AsyncTimeout.head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long now = System.nanoTime();
                if (timeoutNanos != 0 && hasDeadline) {
                    node.timeoutAt = now + Math.min(timeoutNanos, node.deadlineNanoTime() - now);
                } else if (timeoutNanos != 0) {
                    node.timeoutAt = now + timeoutNanos;
                } else if (hasDeadline) {
                    node.timeoutAt = node.deadlineNanoTime();
                } else {
                    throw new AssertionError();
                }
                long remainingNanos = node.remainingNanos(now);
                AsyncTimeout asyncTimeout = AsyncTimeout.head;
                Intrinsics.checkNotNull(asyncTimeout);
                AsyncTimeout prev = asyncTimeout;
                while (prev.next != null) {
                    AsyncTimeout asyncTimeout2 = prev.next;
                    Intrinsics.checkNotNull(asyncTimeout2);
                    if (remainingNanos < asyncTimeout2.remainingNanos(now)) {
                        break;
                    }
                    AsyncTimeout asyncTimeout3 = prev.next;
                    Intrinsics.checkNotNull(asyncTimeout3);
                    prev = asyncTimeout3;
                }
                node.next = prev.next;
                prev.next = node;
                if (prev == AsyncTimeout.head) {
                    AsyncTimeout.class.notify();
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        /* access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout node) {
            synchronized (AsyncTimeout.class) {
                if (!node.inQueue) {
                    return false;
                }
                node.inQueue = false;
                for (AsyncTimeout prev = AsyncTimeout.head; prev != null; prev = prev.next) {
                    if (prev.next == node) {
                        prev.next = node.next;
                        node.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        @Nullable
        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout node = asyncTimeout.next;
            if (node == null) {
                long startNanos = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                Intrinsics.checkNotNull(asyncTimeout2);
                if (asyncTimeout2.next != null || System.nanoTime() - startNanos < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long waitNanos = node.remainingNanos(System.nanoTime());
            if (waitNanos > 0) {
                long waitMillis = waitNanos / 1000000;
                AsyncTimeout.class.wait(waitMillis, (int) (waitNanos - (waitMillis * 1000000)));
                return null;
            }
            AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout3);
            asyncTimeout3.next = node.next;
            node.next = null;
            return node;
        }
    }
}
