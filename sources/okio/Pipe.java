package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Pipe.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��D\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u0010J\r\u0010\u0017\u001a\u00020\u0010H\u0007¢\u0006\u0002\b$J\r\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\b%J&\u0010&\u001a\u00020\"*\u00020\u00102\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\"0(¢\u0006\u0002\b)H\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n��\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u00108G¢\u0006\b\n��\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u0013\u0010\u001b\u001a\u00020\u001c8G¢\u0006\b\n��\u001a\u0004\b\u001b\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e¨\u0006*"}, m373d2 = {"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "cancel", "", "fold", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"})
/* loaded from: grasscutter.jar:okio/Pipe.class */
public final class Pipe {
    private final long maxBufferSize;
    @NotNull
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private boolean sinkClosed;
    private boolean sourceClosed;
    @Nullable
    private Sink foldedSink;
    @NotNull
    private final Sink sink;
    @NotNull
    private final Source source;

    public Pipe(long maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
        if (!(this.maxBufferSize >= 1)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("maxBufferSize < 1: ", Long.valueOf(getMaxBufferSize$okio())).toString());
        }
        this.sink = new Sink(this) { // from class: okio.Pipe$sink$1
            @NotNull
            private final Timeout timeout = new Timeout();
            final /* synthetic */ Pipe this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v121, types: [long] */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x011a, code lost:
                r0 = kotlin.Unit.INSTANCE;
             */
            @Override // okio.Sink
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void write(@org.jetbrains.annotations.NotNull okio.Buffer r8, long r9) {
                /*
                // Method dump skipped, instructions count: 618
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.write(okio.Buffer, long):void");
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                Sink sink = null;
                Object lock$iv = this.this$0.getBuffer$okio();
                Pipe pipe = this.this$0;
                synchronized (lock$iv) {
                    if (!(!pipe.getSinkClosed$okio())) {
                        throw new IllegalStateException("closed".toString());
                    } else if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    } else {
                        Sink it = pipe.getFoldedSink$okio();
                        if (it != null) {
                            sink = it;
                        } else if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (sink != null) {
                    Pipe this_$iv = this.this$0;
                    Timeout this_$iv$iv = sink.timeout();
                    Timeout other$iv$iv = this_$iv.sink().timeout();
                    long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                    this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (this_$iv$iv.hasDeadline()) {
                        long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.deadlineNanoTime(Math.min(this_$iv$iv.deadlineNanoTime(), other$iv$iv.deadlineNanoTime()));
                        }
                        try {
                            sink.flush();
                            Unit unit2 = Unit.INSTANCE;
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                            }
                        } catch (Throwable th) {
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                            }
                            throw th;
                        }
                    } else {
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                        }
                        try {
                            sink.flush();
                            Unit unit3 = Unit.INSTANCE;
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.clearDeadline();
                            }
                        } catch (Throwable th2) {
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.clearDeadline();
                            }
                            throw th2;
                        }
                    }
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Sink sink = null;
                Object lock$iv = this.this$0.getBuffer$okio();
                Pipe pipe = this.this$0;
                synchronized (lock$iv) {
                    if (!pipe.getSinkClosed$okio()) {
                        Sink it = pipe.getFoldedSink$okio();
                        if (it != null) {
                            sink = it;
                        } else if (!pipe.getSourceClosed$okio() || pipe.getBuffer$okio().size() <= 0) {
                            pipe.setSinkClosed$okio(true);
                            pipe.getBuffer$okio().notifyAll();
                        } else {
                            throw new IOException("source is closed");
                        }
                        Unit unit = Unit.INSTANCE;
                        if (sink != null) {
                            Pipe this_$iv = this.this$0;
                            Timeout this_$iv$iv = sink.timeout();
                            Timeout other$iv$iv = this_$iv.sink().timeout();
                            long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                            this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                            if (this_$iv$iv.hasDeadline()) {
                                long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                                if (other$iv$iv.hasDeadline()) {
                                    this_$iv$iv.deadlineNanoTime(Math.min(this_$iv$iv.deadlineNanoTime(), other$iv$iv.deadlineNanoTime()));
                                }
                                try {
                                    sink.close();
                                    Unit unit2 = Unit.INSTANCE;
                                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                    if (other$iv$iv.hasDeadline()) {
                                        this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                                    }
                                } catch (Throwable th) {
                                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                    if (other$iv$iv.hasDeadline()) {
                                        this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                                    }
                                    throw th;
                                }
                            } else {
                                if (other$iv$iv.hasDeadline()) {
                                    this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                                }
                                try {
                                    sink.close();
                                    Unit unit3 = Unit.INSTANCE;
                                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                    if (other$iv$iv.hasDeadline()) {
                                        this_$iv$iv.clearDeadline();
                                    }
                                } catch (Throwable th2) {
                                    this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                                    if (other$iv$iv.hasDeadline()) {
                                        this_$iv$iv.clearDeadline();
                                    }
                                    throw th2;
                                }
                            }
                        }
                    }
                }
            }

            @Override // okio.Sink
            @NotNull
            public Timeout timeout() {
                return this.timeout;
            }
        };
        this.source = new Source(this) { // from class: okio.Pipe$source$1
            @NotNull
            private final Timeout timeout = new Timeout();
            final /* synthetic */ Pipe this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                Object lock$iv = this.this$0.getBuffer$okio();
                Pipe pipe = this.this$0;
                synchronized (lock$iv) {
                    if (!(!pipe.getSourceClosed$okio())) {
                        throw new IllegalStateException("closed".toString());
                    } else if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    } else {
                        while (pipe.getBuffer$okio().size() == 0) {
                            if (pipe.getSinkClosed$okio()) {
                                return -1;
                            }
                            this.timeout.waitUntilNotified(pipe.getBuffer$okio());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        }
                        long result = pipe.getBuffer$okio().read(sink, byteCount);
                        pipe.getBuffer$okio().notifyAll();
                        return result;
                    }
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Object lock$iv = this.this$0.getBuffer$okio();
                Pipe pipe = this.this$0;
                synchronized (lock$iv) {
                    pipe.setSourceClosed$okio(true);
                    pipe.getBuffer$okio().notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // okio.Source
            @NotNull
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink) {
        this.foldedSink = sink;
    }

    @JvmName(name = "sink")
    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @JvmName(name = "source")
    @NotNull
    public final Source source() {
        return this.source;
    }

    public final void fold(@NotNull Sink sink) throws IOException {
        boolean closed;
        Buffer buffer;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                try {
                    if (!(getFoldedSink$okio() == null)) {
                        throw new IllegalStateException("sink already folded".toString());
                    } else if (getCanceled$okio()) {
                        setFoldedSink$okio(sink);
                        throw new IOException("canceled");
                    } else if (getBuffer$okio().exhausted()) {
                        setSourceClosed$okio(true);
                        setFoldedSink$okio(sink);
                        return;
                    } else {
                        closed = getSinkClosed$okio();
                        buffer = new Buffer();
                        buffer.write(getBuffer$okio(), getBuffer$okio().size());
                        getBuffer$okio().notifyAll();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                sink.write(buffer, buffer.size());
                if (closed) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th2) {
                synchronized (this.buffer) {
                    try {
                        setSourceClosed$okio(true);
                        getBuffer$okio().notifyAll();
                        Unit unit2 = Unit.INSTANCE;
                        throw th2;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private final void forward(Sink $this$forward, Function1<? super Sink, Unit> function1) {
        Timeout this_$iv = $this$forward.timeout();
        Timeout other$iv = sink().timeout();
        long originalTimeout$iv = this_$iv.timeoutNanos();
        this_$iv.timeout(Timeout.Companion.minTimeout(other$iv.timeoutNanos(), this_$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this_$iv.hasDeadline()) {
            long originalDeadline$iv = this_$iv.deadlineNanoTime();
            if (other$iv.hasDeadline()) {
                this_$iv.deadlineNanoTime(Math.min(this_$iv.deadlineNanoTime(), other$iv.deadlineNanoTime()));
            }
            try {
                function1.invoke($this$forward);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                if (other$iv.hasDeadline()) {
                    this_$iv.deadlineNanoTime(originalDeadline$iv);
                }
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                if (other$iv.hasDeadline()) {
                    this_$iv.deadlineNanoTime(originalDeadline$iv);
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else {
            if (other$iv.hasDeadline()) {
                this_$iv.deadlineNanoTime(other$iv.deadlineNanoTime());
            }
            try {
                function1.invoke($this$forward);
                Unit unit2 = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                if (other$iv.hasDeadline()) {
                    this_$iv.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                if (other$iv.hasDeadline()) {
                    this_$iv.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_sink")
    @NotNull
    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m9401deprecated_sink() {
        return this.sink;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_source")
    @NotNull
    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m9402deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            setCanceled$okio(true);
            getBuffer$okio().clear();
            getBuffer$okio().notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }
}
