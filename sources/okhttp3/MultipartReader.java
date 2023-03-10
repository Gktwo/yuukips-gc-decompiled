package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.classic.net.SyslogAppender;
import p001ch.qos.logback.core.FileAppender;

/* compiled from: MultipartReader.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018�� \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n��R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020��X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u001f"}, m373d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "response", "Lokhttp3/ResponseBody;", "(Lokhttp3/ResponseBody;)V", "source", "Lokio/BufferedSource;", "boundary", "", "(Lokio/BufferedSource;Ljava/lang/String;)V", "()Ljava/lang/String;", "closed", "", "crlfDashDashBoundary", "Lokio/ByteString;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "dashDashBoundary", "noMoreParts", "partCount", "", "close", "", "currentPartBytesRemaining", "", "maxResult", "nextPart", "Lokhttp3/MultipartReader$Part;", "Companion", "Part", "PartSource", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/MultipartReader.class */
public final class MultipartReader implements Closeable {
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final String boundary;
    @NotNull
    private final ByteString dashDashBoundary;
    @NotNull
    private final ByteString crlfDashDashBoundary;
    private int partCount;
    private boolean closed;
    private boolean noMoreParts;
    @Nullable
    private PartSource currentPart;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Options afterBoundaryOptions = Options.Companion.m46of(ByteString.Companion.encodeUtf8("\r\n"), ByteString.Companion.encodeUtf8("--"), ByteString.Companion.encodeUtf8(" "), ByteString.Companion.encodeUtf8(SyslogAppender.DEFAULT_STACKTRACE_PATTERN));

    public MultipartReader(@NotNull BufferedSource source, @NotNull String boundary) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(this.boundary).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(this.boundary).readByteString();
    }

    @JvmName(name = "boundary")
    @NotNull
    public final String boundary() {
        return this.boundary;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultipartReader(@org.jetbrains.annotations.NotNull okhttp3.ResponseBody r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r6
            r1 = r7
            okio.BufferedSource r1 = r1.source()
            r2 = r7
            okhttp3.MediaType r2 = r2.contentType()
            r3 = r2
            if (r3 != 0) goto L_0x0018
            r2 = 0
            goto L_0x001d
        L_0x0018:
            java.lang.String r3 = "boundary"
            java.lang.String r2 = r2.parameter(r3)
        L_0x001d:
            r8 = r2
            r2 = r8
            if (r2 != 0) goto L_0x002c
            java.net.ProtocolException r2 = new java.net.ProtocolException
            r3 = r2
            java.lang.String r4 = "expected the Content-Type to have a boundary parameter"
            r3.<init>(r4)
            throw r2
        L_0x002c:
            r2 = r8
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartReader.<init>(okhttp3.ResponseBody):void");
    }

    @Nullable
    public final Part nextPart() throws IOException {
        if (!this.closed) {
            if (!this.noMoreParts) {
                if (this.partCount != 0 || !this.source.rangeEquals(0, this.dashDashBoundary)) {
                    while (true) {
                        long toSkip = currentPartBytesRemaining(FileAppender.DEFAULT_BUFFER_SIZE);
                        if (toSkip == 0) {
                            break;
                        }
                        this.source.skip(toSkip);
                    }
                    this.source.skip((long) this.crlfDashDashBoundary.size());
                } else {
                    this.source.skip((long) this.dashDashBoundary.size());
                }
                boolean whitespace = false;
                while (true) {
                    switch (this.source.select(afterBoundaryOptions)) {
                        case -1:
                            throw new ProtocolException("unexpected characters after boundary");
                        case 0:
                            this.partCount++;
                            Headers headers = new HeadersReader(this.source).readHeaders();
                            PartSource partSource = new PartSource(this);
                            this.currentPart = partSource;
                            return new Part(headers, Okio.buffer(partSource));
                        case 1:
                            if (whitespace) {
                                throw new ProtocolException("unexpected characters after boundary");
                            } else if (this.partCount == 0) {
                                throw new ProtocolException("expected at least 1 part");
                            } else {
                                this.noMoreParts = true;
                                return null;
                            }
                        case 2:
                        case 3:
                            whitespace = true;
                            break;
                    }
                }
            } else {
                return null;
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    /* compiled from: MultipartReader.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\f"}, m373d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lokio/Source;", "(Lokhttp3/MultipartReader;)V", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/MultipartReader$PartSource.class */
    public final class PartSource implements Source {
        @NotNull
        private final Timeout timeout = new Timeout();
        final /* synthetic */ MultipartReader this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public PartSource(MultipartReader this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (Intrinsics.areEqual(this.this$0.currentPart, this)) {
                this.this$0.currentPart = null;
            }
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            } else if (!Intrinsics.areEqual(this.this$0.currentPart, this)) {
                throw new IllegalStateException("closed".toString());
            } else {
                Timeout this_$iv = this.this$0.source.timeout();
                Timeout other$iv = this.timeout;
                MultipartReader multipartReader = this.this$0;
                long originalTimeout$iv = this_$iv.timeoutNanos();
                this_$iv.timeout(Timeout.Companion.minTimeout(other$iv.timeoutNanos(), this_$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                if (this_$iv.hasDeadline()) {
                    long originalDeadline$iv = this_$iv.deadlineNanoTime();
                    if (other$iv.hasDeadline()) {
                        this_$iv.deadlineNanoTime(Math.min(this_$iv.deadlineNanoTime(), other$iv.deadlineNanoTime()));
                    }
                    try {
                        long limit = multipartReader.currentPartBytesRemaining(byteCount);
                        return limit == 0 ? -1 : multipartReader.source.read(sink, limit);
                    } finally {
                        this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                        if (other$iv.hasDeadline()) {
                            this_$iv.deadlineNanoTime(originalDeadline$iv);
                        }
                    }
                } else {
                    if (other$iv.hasDeadline()) {
                        this_$iv.deadlineNanoTime(other$iv.deadlineNanoTime());
                    }
                    try {
                        long limit2 = multipartReader.currentPartBytesRemaining(byteCount);
                        return limit2 == 0 ? -1 : multipartReader.source.read(sink, limit2);
                    } finally {
                        this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                        if (other$iv.hasDeadline()) {
                            this_$iv.clearDeadline();
                        }
                    }
                }
            }
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    /* access modifiers changed from: private */
    public final long currentPartBytesRemaining(long maxResult) {
        this.source.require((long) this.crlfDashDashBoundary.size());
        long delimiterIndex = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        return delimiterIndex == -1 ? Math.min(maxResult, (this.source.getBuffer().size() - ((long) this.crlfDashDashBoundary.size())) + 1) : Math.min(maxResult, delimiterIndex);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.currentPart = null;
            this.source.close();
        }
    }

    /* compiled from: MultipartReader.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n��\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0001R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\b¨\u0006\u000b"}, m373d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "headers", "Lokhttp3/Headers;", "body", "Lokio/BufferedSource;", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "()Lokio/BufferedSource;", "()Lokhttp3/Headers;", "close", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/MultipartReader$Part.class */
    public static final class Part implements Closeable {
        @NotNull
        private final Headers headers;
        @NotNull
        private final BufferedSource body;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.body.close();
        }

        public Part(@NotNull Headers headers, @NotNull BufferedSource body) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(body, "body");
            this.headers = headers;
            this.body = body;
        }

        @JvmName(name = "headers")
        @NotNull
        public final Headers headers() {
            return this.headers;
        }

        @JvmName(name = "body")
        @NotNull
        public final BufferedSource body() {
            return this.body;
        }
    }

    /* compiled from: MultipartReader.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lokhttp3/MultipartReader$Companion;", "", "()V", "afterBoundaryOptions", "Lokio/Options;", "getAfterBoundaryOptions", "()Lokio/Options;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/MultipartReader$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Options getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }
    }
}
