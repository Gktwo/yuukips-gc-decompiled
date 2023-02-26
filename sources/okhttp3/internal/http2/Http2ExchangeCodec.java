package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Http2ExchangeCodec.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018�� (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n��¨\u0006)"}, m373d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", Http2ExchangeCodec.CONNECTION, "Lokhttp3/internal/connection/RealConnection;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "canceled", "", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "protocol", "Lokhttp3/Protocol;", "stream", "Lokhttp3/internal/http2/Http2Stream;", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "Lokhttp3/Request;", "contentLength", "", "finishRequest", "flushRequest", "openResponseBodySource", "Lokio/Source;", "response", "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "trailers", "Lokhttp3/Headers;", "writeRequestHeaders", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2ExchangeCodec.class */
public final class Http2ExchangeCodec implements ExchangeCodec {
    @NotNull
    private final RealConnection connection;
    @NotNull
    private final RealInterceptorChain chain;
    @NotNull
    private final Http2Connection http2Connection;
    @Nullable
    private volatile Http2Stream stream;
    @NotNull
    private final Protocol protocol;
    private volatile boolean canceled;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String CONNECTION = "connection";
    @NotNull
    private static final String HOST = "host";
    @NotNull
    private static final String KEEP_ALIVE = "keep-alive";
    @NotNull
    private static final String PROXY_CONNECTION = "proxy-connection";
    @NotNull

    /* renamed from: TE */
    private static final String f3076TE = "te";
    @NotNull
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    @NotNull
    private static final String ENCODING = "encoding";
    @NotNull
    private static final String UPGRADE = "upgrade";
    @NotNull
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, f3076TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    @NotNull
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, f3076TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    public Http2ExchangeCodec(@NotNull OkHttpClient client, @NotNull RealConnection connection, @NotNull RealInterceptorChain chain, @NotNull Http2Connection http2Connection) {
        Protocol protocol;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, CONNECTION);
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.connection = connection;
        this.chain = chain;
        this.http2Connection = http2Connection;
        if (client.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.protocol = protocol;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request request, long contentLength) {
        Intrinsics.checkNotNullParameter(request, "request");
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.stream == null) {
            this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), request.body() != null);
            if (this.canceled) {
                Http2Stream http2Stream = this.stream;
                Intrinsics.checkNotNull(http2Stream);
                http2Stream.closeLater(ErrorCode.CANCEL);
                throw new IOException("Canceled");
            }
            Http2Stream http2Stream2 = this.stream;
            Intrinsics.checkNotNull(http2Stream2);
            http2Stream2.readTimeout().timeout((long) this.chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            Http2Stream http2Stream3 = this.stream;
            Intrinsics.checkNotNull(http2Stream3);
            http2Stream3.writeTimeout().timeout((long) this.chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        http2Stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Response.Builder readResponseHeaders(boolean expectContinue) {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        Response.Builder responseBuilder = Companion.readHttp2HeadersList(http2Stream.takeHeaders(), this.protocol);
        if (!expectContinue || responseBuilder.getCode$okhttp() != 100) {
            return responseBuilder;
        }
        return null;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0;
        }
        return Util.headersContentLength(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.getSource$okhttp();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Headers trailers() {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    /* compiled from: Http2ExchangeCodec.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\u0002\n��R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0019"}, m373d2 = {"Lokhttp3/internal/http2/Http2ExchangeCodec$Companion;", "", "()V", "CONNECTION", "", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "http2HeadersList", "Lokhttp3/internal/http2/Header;", "request", "Lokhttp3/Request;", "readHttp2HeadersList", "Lokhttp3/Response$Builder;", "headerBlock", "Lokhttp3/Headers;", "protocol", "Lokhttp3/Protocol;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2ExchangeCodec$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<Header> http2HeadersList(@NotNull Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Headers headers = request.headers();
            ArrayList result = new ArrayList(headers.size() + 4);
            result.add(new Header(Header.TARGET_METHOD, request.method()));
            result.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String host = request.header("Host");
            if (host != null) {
                result.add(new Header(Header.TARGET_AUTHORITY, host));
            }
            result.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int i = 0;
            int size = headers.size();
            while (i < size) {
                i++;
                String name = headers.name(i);
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String name2 = name.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(name2, "this as java.lang.String).toLowerCase(locale)");
                if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(name2) || (Intrinsics.areEqual(name2, Http2ExchangeCodec.f3076TE) && Intrinsics.areEqual(headers.value(i), "trailers"))) {
                    result.add(new Header(name2, headers.value(i)));
                }
            }
            return result;
        }

        @NotNull
        public final Response.Builder readHttp2HeadersList(@NotNull Headers headerBlock, @NotNull Protocol protocol) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            StatusLine statusLine = null;
            Headers.Builder headersBuilder = new Headers.Builder();
            int i = 0;
            int size = headerBlock.size();
            while (i < size) {
                i++;
                String name = headerBlock.name(i);
                String value = headerBlock.value(i);
                if (Intrinsics.areEqual(name, Header.RESPONSE_STATUS_UTF8)) {
                    statusLine = StatusLine.Companion.parse(Intrinsics.stringPlus("HTTP/1.1 ", value));
                } else if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    headersBuilder.addLenient$okhttp(name, value);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(headersBuilder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }
}
