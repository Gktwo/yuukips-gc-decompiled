package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.TTop;

/* compiled from: Http1ExchangeCodec.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018�� ?2\u00020\u0001:\u0007<=>?@ABB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020)H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0019H\u0016J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u00101\u001a\u00020\u0019H\u0016J\u000e\u00106\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0019J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n��R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n��R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001a¨\u0006C"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "isClosed", "", "()Z", TTop.STAT_STATE, "", "trailers", "Lokhttp3/Headers;", "isChunked", "Lokhttp3/Request;", "(Lokhttp3/Request;)Z", "Lokhttp3/Response;", "(Lokhttp3/Response;)Z", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "contentLength", "", "detachTimeout", "timeout", "Lokio/ForwardingTimeout;", "finishRequest", "flushRequest", "newChunkedSink", "newChunkedSource", "Lokio/Source;", "url", "Lokhttp3/HttpUrl;", "newFixedLengthSource", "length", "newKnownLengthSink", "newUnknownLengthSource", "openResponseBodySource", "response", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "skipConnectBody", "writeRequest", "headers", "requestLine", "", "writeRequestHeaders", "AbstractSource", "ChunkedSink", "ChunkedSource", "Companion", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec.class */
public final class Http1ExchangeCodec implements ExchangeCodec {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final OkHttpClient client;
    @NotNull
    private final RealConnection connection;
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final BufferedSink sink;
    private int state;
    @NotNull
    private final HeadersReader headersReader;
    @Nullable
    private Headers trailers;
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_CLOSED = 6;

    public Http1ExchangeCodec(@Nullable OkHttpClient client, @NotNull RealConnection connection, @NotNull BufferedSource source, @NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.client = client;
        this.connection = connection;
        this.source = source;
        this.sink = sink;
        this.headersReader = new HeadersReader(this.source);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    private final boolean isChunked(Response $this$isChunked) {
        return StringsKt.equals("chunked", Response.header$default($this$isChunked, "Transfer-Encoding", null, 2, null), true);
    }

    private final boolean isChunked(Request $this$isChunked) {
        return StringsKt.equals("chunked", $this$isChunked.header("Transfer-Encoding"), true);
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request request, long contentLength) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.body() != null && request.body().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if (isChunked(request)) {
            return newChunkedSink();
        } else {
            if (contentLength != -1) {
                return newKnownLengthSink();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getConnection().route().proxy().type();
        Intrinsics.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        writeRequest(request.headers(), requestLine.get(request, type));
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0;
        }
        if (isChunked(response)) {
            return -1;
        }
        return Util.headersContentLength(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        }
        long contentLength = Util.headersContentLength(response);
        if (contentLength != -1) {
            return newFixedLengthSource(contentLength);
        }
        return newUnknownLengthSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Headers trailers() {
        if (!(this.state == 6)) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        Headers headers = this.trailers;
        return headers == null ? Util.EMPTY_HEADERS : headers;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    public final void writeRequest(@NotNull Headers headers, @NotNull String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (!(this.state == 0)) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.state)).toString());
        }
        this.sink.writeUtf8(requestLine).writeUtf8("\r\n");
        int i = 0;
        int size = headers.size();
        while (i < size) {
            i++;
            this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Response.Builder readResponseHeaders(boolean expectContinue) {
        if (!(this.state == 1 || this.state == 3)) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.state)).toString());
        }
        try {
            StatusLine statusLine = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder responseBuilder = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(this.headersReader.readHeaders());
            if (expectContinue && statusLine.code == 100) {
                return null;
            }
            if (statusLine.code == 100) {
                this.state = 3;
                return responseBuilder;
            }
            this.state = 4;
            return responseBuilder;
        } catch (EOFException e) {
            throw new IOException(Intrinsics.stringPlus("unexpected end of stream on ", getConnection().route().address().url().redact()), e);
        }
    }

    private final Sink newChunkedSink() {
        if (!(this.state == 1)) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.state)).toString());
        }
        this.state = 2;
        return new ChunkedSink(this);
    }

    private final Sink newKnownLengthSink() {
        if (!(this.state == 1)) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.state)).toString());
        }
        this.state = 2;
        return new KnownLengthSink(this);
    }

    private final Source newFixedLengthSource(long length) {
        if (!(this.state == 4)) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.state)).toString());
        }
        this.state = 5;
        return new FixedLengthSource(this, length);
    }

    private final Source newChunkedSource(HttpUrl url) {
        if (!(this.state == 4)) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.state)).toString());
        }
        this.state = 5;
        return new ChunkedSource(this, url);
    }

    private final Source newUnknownLengthSource() {
        if (!(this.state == 4)) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.state)).toString());
        }
        this.state = 5;
        getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource(this);
    }

    /* access modifiers changed from: private */
    public final void detachTimeout(ForwardingTimeout timeout) {
        Timeout oldDelegate = timeout.delegate();
        timeout.setDelegate(Timeout.NONE);
        oldDelegate.clearDeadline();
        oldDelegate.clearTimeout();
    }

    public final void skipConnectBody(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long contentLength = Util.headersContentLength(response);
        if (contentLength != -1) {
            Source body = newFixedLengthSource(contentLength);
            Util.skipAll(body, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            body.close();
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\b\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0010"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "timeout", "Lokio/ForwardingTimeout;", "close", "", "flush", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink.class */
    public final class KnownLengthSink implements Sink {
        @NotNull
        private final ForwardingTimeout timeout;
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public KnownLengthSink(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Util.checkOffsetAndCount(source.size(), 0, byteCount);
            this.this$0.sink.write(source, byteCount);
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (!this.closed) {
                this.this$0.sink.flush();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.closed) {
                this.closed = true;
                this.this$0.detachTimeout(this.timeout);
                this.this$0.state = 3;
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\b\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0010"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "timeout", "Lokio/ForwardingTimeout;", "close", "", "flush", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink.class */
    public final class ChunkedSink implements Sink {
        @NotNull
        private final ForwardingTimeout timeout;
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ChunkedSink(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.timeout = new ForwardingTimeout(this.this$0.sink.timeout());
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            } else if (byteCount != 0) {
                this.this$0.sink.writeHexadecimalUnsignedLong(byteCount);
                this.this$0.sink.writeUtf8("\r\n");
                this.this$0.sink.write(source, byteCount);
                this.this$0.sink.writeUtf8("\r\n");
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (!this.closed) {
                this.this$0.sink.flush();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (!this.closed) {
                this.closed = true;
                this.this$0.sink.writeUtf8("0\r\n\r\n");
                this.this$0.detachTimeout(this.timeout);
                this.this$0.state = 3;
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n��\b¢\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\t\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokio/Source;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "timeout", "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "responseBodyComplete", "", "Lokio/Timeout;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec$AbstractSource.class */
    private abstract class AbstractSource implements Source {
        @NotNull
        private final ForwardingTimeout timeout;
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public AbstractSource(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.timeout = new ForwardingTimeout(this.this$0.source.timeout());
        }

        @NotNull
        protected final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        protected final boolean getClosed() {
            return this.closed;
        }

        protected final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return this.this$0.source.read(sink, byteCount);
            } catch (IOException e) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
                throw e;
            }
        }

        public final void responseBodyComplete() {
            if (this.this$0.state != 6) {
                if (this.this$0.state != 5) {
                    throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.this$0.state)));
                }
                this.this$0.detachTimeout(this.timeout);
                this.this$0.state = 6;
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018��2\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��¨\u0006\f"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "bytesRemaining", "", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource.class */
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec this$0, long bytesRemaining) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.bytesRemaining = bytesRemaining;
            if (this.bytesRemaining == 0) {
                responseBodyComplete();
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                long read = read(sink, Math.min(this.bytesRemaining, byteCount));
                if (read == -1) {
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    ProtocolException e = new ProtocolException("unexpected end of stream");
                    responseBodyComplete();
                    throw e;
                }
                this.bytesRemaining -= read;
                if (this.bytesRemaining == 0) {
                    responseBodyComplete();
                }
                return read;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!getClosed()) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    responseBodyComplete();
                }
                setClosed(true);
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018��2\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0011"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lokhttp3/HttpUrl;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "bytesRemainingInChunk", "", "hasMoreChunks", "", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "readChunkSize", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource.class */
    public final class ChunkedSource extends AbstractSource {
        @NotNull
        private final HttpUrl url;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(@NotNull Http1ExchangeCodec this$0, HttpUrl url) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(url, "url");
            this.this$0 = this$0;
            this.url = url;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = read(sink, Math.min(byteCount, this.bytesRemainingInChunk));
                if (read == -1) {
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    ProtocolException e = new ProtocolException("unexpected end of stream");
                    responseBodyComplete();
                    throw e;
                }
                this.bytesRemainingInChunk -= read;
                return read;
            }
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk != -1) {
                this.this$0.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.source.readHexadecimalUnsignedLong();
                String extensions = StringsKt.trim((CharSequence) this.this$0.source.readUtf8LineStrict()).toString();
                if (this.bytesRemainingInChunk >= 0) {
                    if (!(extensions.length() > 0) || StringsKt.startsWith$default(extensions, ";", false, 2, (Object) null)) {
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            this.this$0.trailers = this.this$0.headersReader.readHeaders();
                            OkHttpClient okHttpClient = this.this$0.client;
                            Intrinsics.checkNotNull(okHttpClient);
                            CookieJar cookieJar = okHttpClient.cookieJar();
                            HttpUrl httpUrl = this.url;
                            Headers headers = this.this$0.trailers;
                            Intrinsics.checkNotNull(headers);
                            HttpHeaders.receiveHeaders(cookieJar, httpUrl, headers);
                            responseBodyComplete();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + extensions + '\"');
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!getClosed()) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.this$0.getConnection().noNewExchanges$okhttp();
                    responseBodyComplete();
                }
                setClosed(true);
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018��2\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "inputExhausted", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource.class */
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1ExchangeCodec this$0) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = read(sink, byteCount);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                responseBodyComplete();
                return -1;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!getClosed()) {
                if (!this.inputExhausted) {
                    responseBodyComplete();
                }
                setClosed(true);
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "()V", "NO_CHUNK_YET", "", "STATE_CLOSED", "", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http1/Http1ExchangeCodec$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
