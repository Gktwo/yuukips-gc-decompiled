package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Http2Stream.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0001\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018�� _2\u00020\u0001:\u0004_`abB1\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020#J\r\u0010C\u001a\u00020AH��¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020AH��¢\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010I\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010J\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010,\u001a\u00020QJ\u0016\u0010R\u001a\u00020A2\u0006\u00104\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010U\u001a\u00020A2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010W\u001a\u00020\nJ\u0006\u0010L\u001a\u00020\nJ\r\u0010X\u001a\u00020AH��¢\u0006\u0002\bYJ$\u0010Z\u001a\u00020A2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020QR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8@X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n��R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0004¢\u0006\u0002\n��R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0018\u0010,\u001a\u00060-R\u00020��X\u0004¢\u0006\b\n��\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u000601R\u00020��X\u0004¢\u0006\b\n��\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u000605R\u00020��X\u0004¢\u0006\b\n��\u001a\u0004\b6\u00107R$\u00108\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R$\u0010;\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u0018\u0010>\u001a\u00060-R\u00020��X\u0004¢\u0006\b\n��\u001a\u0004\b?\u0010/¨\u0006c"}, m373d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "id", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "hasResponseHeaders", "headersQueue", "Ljava/util/ArrayDeque;", "getId", "()I", "isLocallyInitiated", "()Z", "isOpen", "<set-?>", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "(J)V", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "source", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "addBytesToWriteWindow", "", "delta", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "checkOutNotClosed", "checkOutNotClosed$okhttp", "close", "rstStatusCode", "closeInternal", "closeLater", "enqueueTrailers", "trailers", "getSink", "Lokio/Sink;", "getSource", "Lokio/Source;", "Lokio/Timeout;", "receiveData", "Lokio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "takeHeaders", "waitForIo", "waitForIo$okhttp", "writeHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Stream.class */
public final class Http2Stream {
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: id */
    private final int f3077id;
    @NotNull
    private final Http2Connection connection;
    private long readBytesTotal;
    private long readBytesAcknowledged;
    private long writeBytesTotal;
    private long writeBytesMaximum;
    private boolean hasResponseHeaders;
    @NotNull
    private final FramingSource source;
    @NotNull
    private final FramingSink sink;
    @Nullable
    private ErrorCode errorCode;
    @Nullable
    private IOException errorException;
    public static final long EMIT_BUFFER_SIZE = 16384;
    @NotNull
    private final ArrayDeque<Headers> headersQueue = new ArrayDeque<>();
    @NotNull
    private final StreamTimeout readTimeout = new StreamTimeout(this);
    @NotNull
    private final StreamTimeout writeTimeout = new StreamTimeout(this);

    public Http2Stream(int id, @NotNull Http2Connection connection, boolean outFinished, boolean inFinished, @Nullable Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.f3077id = id;
        this.connection = connection;
        this.writeBytesMaximum = (long) this.connection.getPeerSettings().getInitialWindowSize();
        this.source = new FramingSource(this, (long) this.connection.getOkHttpSettings().getInitialWindowSize(), inFinished);
        this.sink = new FramingSink(this, outFinished);
        if (headers != null) {
            if (!(!isLocallyInitiated())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            this.headersQueue.add(headers);
        } else if (!isLocallyInitiated()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    public final int getId() {
        return this.f3077id;
    }

    @NotNull
    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final void setReadBytesTotal$okhttp(long j) {
        this.readBytesTotal = j;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final void setReadBytesAcknowledged$okhttp(long j) {
        this.readBytesAcknowledged = j;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final void setWriteBytesTotal$okhttp(long j) {
        this.writeBytesTotal = j;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final void setWriteBytesMaximum$okhttp(long j) {
        this.writeBytesMaximum = j;
    }

    @NotNull
    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    @NotNull
    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    @NotNull
    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    @NotNull
    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    @Nullable
    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final void setErrorCode$okhttp(@Nullable ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Nullable
    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final void setErrorException$okhttp(@Nullable IOException iOException) {
        this.errorException = iOException;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if (!this.source.getFinished$okhttp() && !this.source.getClosed$okhttp()) {
            return true;
        }
        if ((this.sink.getFinished() || this.sink.getClosed()) && this.hasResponseHeaders) {
            return false;
        }
        return true;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.f3077id & 1) == 1);
    }

    @NotNull
    public final synchronized Headers takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo$okhttp();
            } finally {
                this.readTimeout.exitAndThrowIfTimedOut();
            }
        }
        if (!this.headersQueue.isEmpty()) {
            Headers removeFirst = this.headersQueue.removeFirst();
            Intrinsics.checkNotNullExpressionValue(removeFirst, "headersQueue.removeFirst()");
            return removeFirst;
        }
        IOException iOException = this.errorException;
        if (iOException == null) {
            ErrorCode errorCode = this.errorCode;
            Intrinsics.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
        throw iOException;
    }

    @NotNull
    public final synchronized Headers trailers() throws IOException {
        if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().exhausted() && this.source.getReadBuffer().exhausted()) {
            Headers trailers = this.source.getTrailers();
            return trailers == null ? Util.EMPTY_HEADERS : trailers;
        } else if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                ErrorCode errorCode = this.errorCode;
                Intrinsics.checkNotNull(errorCode);
                throw new StreamResetException(errorCode);
            }
            throw iOException;
        } else {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
    }

    public final void writeHeaders(@NotNull List<Header> list, boolean outFinished, boolean flushHeaders) throws IOException {
        Intrinsics.checkNotNullParameter(list, "responseHeaders");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            boolean flushHeaders2 = flushHeaders;
            synchronized (this) {
                this.hasResponseHeaders = true;
                if (outFinished) {
                    getSink$okhttp().setFinished(true);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (!flushHeaders2) {
                synchronized (this.connection) {
                    flushHeaders2 = getConnection().getWriteBytesTotal() >= getConnection().getWriteBytesMaximum();
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            this.connection.writeHeaders$okhttp(this.f3077id, outFinished, list);
            if (flushHeaders2) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void enqueueTrailers(@NotNull Headers trailers) {
        Intrinsics.checkNotNullParameter(trailers, "trailers");
        synchronized (this) {
            if (!(!getSink$okhttp().getFinished())) {
                throw new IllegalStateException("already finished".toString());
            }
            if (!(trailers.size() != 0)) {
                throw new IllegalArgumentException("trailers.size() == 0".toString());
            }
            getSink$okhttp().setTrailers(trailers);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    @NotNull
    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    public final Sink getSink() {
        synchronized (this) {
            if (!(this.hasResponseHeaders || isLocallyInitiated())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return this.sink;
    }

    public final void close(@NotNull ErrorCode rstStatusCode, @Nullable IOException errorException) throws IOException {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (closeInternal(rstStatusCode, errorException)) {
            this.connection.writeSynReset$okhttp(this.f3077id, rstStatusCode);
        }
    }

    public final void closeLater(@NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.f3077id, errorCode);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException errorException) {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (getErrorCode$okhttp() != null) {
                    return false;
                }
                if (getSource$okhttp().getFinished$okhttp() && getSink$okhttp().getFinished()) {
                    return false;
                }
                setErrorCode$okhttp(errorCode);
                setErrorException$okhttp(errorException);
                notifyAll();
                Unit unit = Unit.INSTANCE;
                this.connection.removeStream$okhttp(this.f3077id);
                return true;
            }
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void receiveData(@NotNull BufferedSource source, int length) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            this.source.receive$okhttp(source, (long) length);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void receiveHeaders(@NotNull Headers headers, boolean inFinished) {
        boolean open;
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (!this.hasResponseHeaders || !inFinished) {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                } else {
                    getSource$okhttp().setTrailers(headers);
                }
                if (inFinished) {
                    getSource$okhttp().setFinished$okhttp(true);
                }
                open = isOpen();
                notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (!open) {
                this.connection.removeStream$okhttp(this.f3077id);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final synchronized void receiveRstStream(@NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018��2\u00020\u0001B\u0017\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u001d\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0003H��¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n��\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n��\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n��\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n��\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, m373d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "maxByteCount", "", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getFinished$okhttp", "setFinished$okhttp", "readBuffer", "Lokio/Buffer;", "getReadBuffer", "()Lokio/Buffer;", "receiveBuffer", "getReceiveBuffer", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "read", "sink", "byteCount", "receive", "source", "Lokio/BufferedSource;", "receive$okhttp", "timeout", "Lokio/Timeout;", "updateConnectionFlowControl", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Stream$FramingSource.class */
    public final class FramingSource implements Source {
        private final long maxByteCount;
        private boolean finished;
        @NotNull
        private final Buffer receiveBuffer = new Buffer();
        @NotNull
        private final Buffer readBuffer = new Buffer();
        @Nullable
        private Headers trailers;
        private boolean closed;
        final /* synthetic */ Http2Stream this$0;

        public FramingSource(Http2Stream this$0, long maxByteCount, boolean finished) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.maxByteCount = maxByteCount;
            this.finished = finished;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        @NotNull
        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @NotNull
        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        /* JADX WARN: Type inference failed for: r0v48, types: [long] */
        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) throws IOException {
            long readBytesDelivered;
            Object errorExceptionToDeliver;
            boolean tryAgain;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            do {
                boolean z = false;
                readBytesDelivered = -1;
                readBytesDelivered = -1;
                readBytesDelivered = -1;
                errorExceptionToDeliver = null;
                Http2Stream http2Stream = this.this$0;
                Http2Stream http2Stream2 = this.this$0;
                synchronized (http2Stream) {
                    http2Stream2.getReadTimeout$okhttp().enter();
                    if (http2Stream2.getErrorCode$okhttp() != null) {
                        errorExceptionToDeliver = http2Stream2.getErrorException$okhttp();
                        if (errorExceptionToDeliver == null) {
                            ErrorCode errorCode$okhttp = http2Stream2.getErrorCode$okhttp();
                            Intrinsics.checkNotNull(errorCode$okhttp);
                            errorExceptionToDeliver = (IOException) new StreamResetException(errorCode$okhttp);
                        }
                    }
                    if (getClosed$okhttp()) {
                        throw new IOException("stream closed");
                    }
                    if (getReadBuffer().size() > 0) {
                        char read = getReadBuffer().read(sink, Math.min(byteCount, getReadBuffer().size()));
                        http2Stream2.setReadBytesTotal$okhttp(http2Stream2.getReadBytesTotal() + read);
                        long unacknowledgedBytesRead = http2Stream2.getReadBytesTotal() - http2Stream2.getReadBytesAcknowledged();
                        tryAgain = z;
                        readBytesDelivered = read;
                        if (errorExceptionToDeliver == null) {
                            tryAgain = z;
                            readBytesDelivered = read;
                            if (unacknowledgedBytesRead >= ((long) (http2Stream2.getConnection().getOkHttpSettings().getInitialWindowSize() / 2))) {
                                http2Stream2.getConnection().writeWindowUpdateLater$okhttp(http2Stream2.getId(), unacknowledgedBytesRead);
                                http2Stream2.setReadBytesAcknowledged$okhttp(http2Stream2.getReadBytesTotal());
                                tryAgain = z;
                                readBytesDelivered = read;
                            }
                        }
                    } else {
                        tryAgain = z;
                        if (!getFinished$okhttp()) {
                            tryAgain = z;
                            if (errorExceptionToDeliver == null) {
                                http2Stream2.waitForIo$okhttp();
                                tryAgain = true;
                            }
                        }
                    }
                    http2Stream2.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                    Unit unit = Unit.INSTANCE;
                }
            } while (tryAgain);
            if ((readBytesDelivered == 1 ? 1 : 0) != -1) {
                updateConnectionFlowControl(readBytesDelivered);
                return readBytesDelivered;
            } else if (errorExceptionToDeliver == null) {
                return -1;
            } else {
                throw ((Throwable) errorExceptionToDeliver);
            }
        }

        private final void updateConnectionFlowControl(long read) {
            Object $this$assertThreadDoesntHoldLock$iv = this.this$0;
            if (!Util.assertionsEnabled || !Thread.holdsLock($this$assertThreadDoesntHoldLock$iv)) {
                this.this$0.getConnection().updateConnectionFlowControl$okhttp(read);
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x004e */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v37, types: [long] */
        public final void receive$okhttp(@NotNull BufferedSource source, long byteCount) throws IOException {
            boolean finished;
            boolean flowControlError;
            long bytesDiscarded;
            Intrinsics.checkNotNullParameter(source, "source");
            Object $this$assertThreadDoesntHoldLock$iv = this.this$0;
            if (!Util.assertionsEnabled || !Thread.holdsLock($this$assertThreadDoesntHoldLock$iv)) {
                char c = byteCount;
                while (c > 0) {
                    synchronized (this.this$0) {
                        finished = getFinished$okhttp();
                        flowControlError = c + getReadBuffer().size() > this.maxByteCount;
                        Unit unit = Unit.INSTANCE;
                    }
                    if (flowControlError) {
                        source.skip(c);
                        this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (finished) {
                        source.skip(c);
                        return;
                    } else {
                        long read = source.read(this.receiveBuffer, c);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        c -= read;
                        char c2 = 0;
                        Http2Stream http2Stream = this.this$0;
                        Object $this$notifyAll$iv = this.this$0;
                        synchronized (http2Stream) {
                            if (getClosed$okhttp()) {
                                long bytesDiscarded2 = getReceiveBuffer().size();
                                getReceiveBuffer().clear();
                                bytesDiscarded = bytesDiscarded2;
                            } else {
                                boolean wasEmpty = getReadBuffer().size() == 0;
                                getReadBuffer().writeAll(getReceiveBuffer());
                                bytesDiscarded = c2;
                                if (wasEmpty) {
                                    $this$notifyAll$iv.notifyAll();
                                    bytesDiscarded = c2;
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                        if ((bytesDiscarded == 1 ? 1 : 0) > 0) {
                            updateConnectionFlowControl(bytesDiscarded);
                        }
                    }
                }
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv);
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long bytesDiscarded;
            Http2Stream http2Stream = this.this$0;
            Object $this$notifyAll$iv = this.this$0;
            synchronized (http2Stream) {
                setClosed$okhttp(true);
                bytesDiscarded = getReadBuffer().size();
                getReadBuffer().clear();
                $this$notifyAll$iv.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (bytesDiscarded > 0) {
                updateConnectionFlowControl(bytesDiscarded);
            }
            this.this$0.cancelStreamIfNecessary$okhttp();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean cancel;
        boolean open;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                cancel = !getSource$okhttp().getFinished$okhttp() && getSource$okhttp().getClosed$okhttp() && (getSink$okhttp().getFinished() || getSink$okhttp().getClosed());
                open = isOpen();
                Unit unit = Unit.INSTANCE;
            }
            if (cancel) {
                close(ErrorCode.CANCEL, null);
            } else if (!open) {
                this.connection.removeStream$okhttp(this.f3077id);
            }
        } else {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n��\b\u0004\u0018��2\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n��R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m373d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "closed", "getClosed", "()Z", "setClosed", "(Z)V", "getFinished", "setFinished", "sendBuffer", "Lokio/Buffer;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "emitFrame", "outFinishedOnLastFrame", "flush", "timeout", "Lokio/Timeout;", "write", "source", "byteCount", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Stream$FramingSink.class */
    public final class FramingSink implements Sink {
        private boolean finished;
        @NotNull
        private final Buffer sendBuffer;
        @Nullable
        private Headers trailers;
        private boolean closed;

        public FramingSink(Http2Stream this$0, boolean finished) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Http2Stream.this = this$0;
            this.finished = finished;
            this.sendBuffer = new Buffer();
        }

        public /* synthetic */ FramingSink(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(Http2Stream.this, (i & 1) != 0 ? false : z);
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setTrailers(@Nullable Headers headers) {
            this.trailers = headers;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            Object $this$assertThreadDoesntHoldLock$iv = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock($this$assertThreadDoesntHoldLock$iv)) {
                this.sendBuffer.write(source, byteCount);
                while (this.sendBuffer.size() >= Http2Stream.EMIT_BUFFER_SIZE) {
                    emitFrame(false);
                }
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv);
        }

        private final void emitFrame(boolean outFinishedOnLastFrame) throws IOException {
            long toWrite;
            boolean outFinished;
            Http2Stream http2Stream = Http2Stream.this;
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream2.getWriteTimeout$okhttp().enter();
                while (http2Stream2.getWriteBytesTotal() >= http2Stream2.getWriteBytesMaximum() && !getFinished() && !getClosed() && http2Stream2.getErrorCode$okhttp() == null) {
                    http2Stream2.waitForIo$okhttp();
                }
                http2Stream2.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream2.checkOutNotClosed$okhttp();
                toWrite = Math.min(http2Stream2.getWriteBytesMaximum() - http2Stream2.getWriteBytesTotal(), this.sendBuffer.size());
                http2Stream2.setWriteBytesTotal$okhttp(http2Stream2.getWriteBytesTotal() + toWrite);
                outFinished = outFinishedOnLastFrame && toWrite == this.sendBuffer.size();
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), outFinished, this.sendBuffer, toWrite);
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            } catch (Throwable th) {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                throw th;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Object $this$assertThreadDoesntHoldLock$iv = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock($this$assertThreadDoesntHoldLock$iv)) {
                Http2Stream http2Stream = Http2Stream.this;
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream) {
                    http2Stream2.checkOutNotClosed$okhttp();
                    Unit unit = Unit.INSTANCE;
                }
                while (this.sendBuffer.size() > 0) {
                    emitFrame(false);
                    Http2Stream.this.getConnection().flush();
                }
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv);
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Object $this$assertThreadDoesntHoldLock$iv = Http2Stream.this;
            if (!Util.assertionsEnabled || !Thread.holdsLock($this$assertThreadDoesntHoldLock$iv)) {
                Http2Stream http2Stream = Http2Stream.this;
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream) {
                    if (!getClosed()) {
                        boolean outFinished = http2Stream2.getErrorCode$okhttp() == null;
                        Unit unit = Unit.INSTANCE;
                        if (!Http2Stream.this.getSink$okhttp().finished) {
                            boolean hasData = this.sendBuffer.size() > 0;
                            if (this.trailers != null) {
                                while (this.sendBuffer.size() > 0) {
                                    emitFrame(false);
                                }
                                Http2Connection connection = Http2Stream.this.getConnection();
                                int id = Http2Stream.this.getId();
                                Headers headers = this.trailers;
                                Intrinsics.checkNotNull(headers);
                                connection.writeHeaders$okhttp(id, outFinished, Util.toHeaderList(headers));
                            } else if (hasData) {
                                while (this.sendBuffer.size() > 0) {
                                    emitFrame(true);
                                }
                            } else if (outFinished) {
                                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0);
                            }
                        }
                        synchronized (Http2Stream.this) {
                            setClosed(true);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        Http2Stream.this.getConnection().flush();
                        Http2Stream.this.cancelStreamIfNecessary$okhttp();
                        return;
                    }
                    return;
                }
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv);
        }
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Stream$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }

    public final void addBytesToWriteWindow(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            notifyAll();
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        } else if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                ErrorCode errorCode = this.errorCode;
                Intrinsics.checkNotNull(errorCode);
                throw new StreamResetException(errorCode);
            }
            throw iOException;
        }
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* compiled from: Http2Stream.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, m373d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Stream$StreamTimeout.class */
    public final class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public StreamTimeout(Http2Stream this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }

        @Override // okio.AsyncTimeout
        @NotNull
        protected IOException newTimeoutException(@Nullable IOException cause) {
            SocketTimeoutException $this$newTimeoutException_u24lambda_u2d0 = new SocketTimeoutException("timeout");
            if (cause != null) {
                $this$newTimeoutException_u24lambda_u2d0.initCause(cause);
            }
            return $this$newTimeoutException_u24lambda_u2d0;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }
}
