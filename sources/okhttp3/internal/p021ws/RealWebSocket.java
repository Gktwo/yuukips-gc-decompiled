package okhttp3.internal.p021ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.p021ws.RealWebSocket;
import okhttp3.internal.p021ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.WebSocketConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.javalin.core.util.Header;

/* compiled from: RealWebSocket.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018�� `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H��¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H��¢\u0006\u0002\b[J\r\u0010\\\u001a\u000203H��¢\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n��R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n��\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n��R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n��R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0004¢\u0006\u0002\n��R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n��R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n��R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n��R\u000e\u0010'\u001a\u00020%X\u000e¢\u0006\u0002\n��R\u000e\u0010(\u001a\u00020%X\u000e¢\u0006\u0002\n��R\u000e\u0010)\u001a\u00020%X\u000e¢\u0006\u0002\n��R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n��R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n��R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n��R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n��¨\u0006d"}, m373d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", Action.KEY_ATTRIBUTE, "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", Tmux.CMD_SEND, "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "isValid", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"})
/* renamed from: okhttp3.internal.ws.RealWebSocket */
/* loaded from: grasscutter.jar:okhttp3/internal/ws/RealWebSocket.class */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    @NotNull
    private final Request originalRequest;
    @NotNull
    private final WebSocketListener listener;
    @NotNull
    private final Random random;
    private final long pingIntervalMillis;
    @Nullable
    private WebSocketExtensions extensions;
    private long minimumDeflateSize;
    @NotNull
    private final String key;
    @Nullable
    private Call call;
    @Nullable
    private Task writerTask;
    @Nullable
    private WebSocketReader reader;
    @Nullable
    private WebSocketWriter writer;
    @NotNull
    private TaskQueue taskQueue;
    @Nullable
    private String name;
    @Nullable
    private Streams streams;
    private long queueSize;
    private boolean enqueuedClose;
    @Nullable
    private String receivedCloseReason;
    private boolean failed;
    private int sentPingCount;
    private int receivedPingCount;
    private int receivedPongCount;
    private boolean awaitingPong;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    @NotNull
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    @NotNull
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull Request originalRequest, @NotNull WebSocketListener listener, @NotNull Random random, long pingIntervalMillis, @Nullable WebSocketExtensions extensions, long minimumDeflateSize) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = pingIntervalMillis;
        this.extensions = extensions;
        this.minimumDeflateSize = minimumDeflateSize;
        this.taskQueue = taskRunner.newQueue();
        if (!Intrinsics.areEqual("GET", this.originalRequest.method())) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Request must be GET: ", this.originalRequest.method()).toString());
        }
        ByteString.Companion companion = ByteString.Companion;
        byte[] $this$_init__u24lambda_u2d1 = new byte[16];
        this.random.nextBytes($this$_init__u24lambda_u2d1);
        Unit unit = Unit.INSTANCE;
        this.key = ByteString.Companion.of$default(companion, $this$_init__u24lambda_u2d1, 0, 0, 3, null).base64();
    }

    @NotNull
    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    @Override // okhttp3.WebSocket
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        Intrinsics.checkNotNull(call);
        call.cancel();
    }

    public final void connect(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        if (this.originalRequest.header(WebSocketConstants.SEC_WEBSOCKET_EXTENSIONS) != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient webSocketClient = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request request = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header(Header.SEC_WEBSOCKET_KEY, this.key).header(WebSocketConstants.SEC_WEBSOCKET_VERSION, "13").header(WebSocketConstants.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").build();
        this.call = new RealCall(webSocketClient, request, true);
        Call call = this.call;
        Intrinsics.checkNotNull(call);
        call.enqueue(new Callback(this, request) { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            final /* synthetic */ RealWebSocket this$0;
            final /* synthetic */ Request $request;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                this.$request = $request;
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call2, @NotNull Response response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Exchange exchange = response.exchange();
                try {
                    this.this$0.checkUpgradeSuccess$okhttp(response, exchange);
                    Intrinsics.checkNotNull(exchange);
                    RealWebSocket.Streams streams = exchange.newWebSocketStreams();
                    WebSocketExtensions extensions = WebSocketExtensions.Companion.parse(response.headers());
                    this.this$0.extensions = extensions;
                    if (!(this.this$0.isValid(extensions))) {
                        RealWebSocket realWebSocket = this.this$0;
                        RealWebSocket realWebSocket2 = this.this$0;
                        synchronized (realWebSocket) {
                            realWebSocket2.messageAndCloseQueue.clear();
                            realWebSocket2.close(StatusCode.REQUIRED_EXTENSION, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        this.this$0.initReaderAndWriter(Util.okHttpName + " WebSocket " + this.$request.url().redact(), streams);
                        this.this$0.getListener$okhttp().onOpen(this.this$0, response);
                        this.this$0.loopReader();
                    } catch (Exception e) {
                        this.this$0.failWebSocket(e, null);
                    }
                } catch (IOException e2) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    this.this$0.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call2, @NotNull IOException e) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.failWebSocket(e, null);
            }
        });
    }

    /* access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions $this$isValid) {
        if (!$this$isValid.unknownValues && $this$isValid.clientMaxWindowBits == null) {
            return $this$isValid.serverMaxWindowBits == null || new IntRange(8, 15).contains($this$isValid.serverMaxWindowBits.intValue());
        }
        return false;
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response response, @Nullable Exchange exchange) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String headerConnection = Response.header$default(response, "Connection", null, 2, null);
        if (!StringsKt.equals("Upgrade", headerConnection, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + ((Object) headerConnection) + '\'');
        }
        String headerUpgrade = Response.header$default(response, "Upgrade", null, 2, null);
        if (!StringsKt.equals("websocket", headerUpgrade, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + ((Object) headerUpgrade) + '\'');
        }
        String headerAccept = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        String acceptExpected = ByteString.Companion.encodeUtf8(Intrinsics.stringPlus(this.key, WebSocketProtocol.ACCEPT_MAGIC)).sha1().base64();
        if (!Intrinsics.areEqual(acceptExpected, headerAccept)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + acceptExpected + "' but was '" + ((Object) headerAccept) + '\'');
        } else if (exchange == null) {
            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
        }
    }

    public final void initReaderAndWriter(@NotNull String name, @NotNull Streams streams) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        WebSocketExtensions extensions = this.extensions;
        Intrinsics.checkNotNull(extensions);
        synchronized (this) {
            this.name = name;
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, extensions.perMessageDeflate, extensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask(this);
            if (this.pingIntervalMillis != 0) {
                long pingIntervalNanos = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                this.taskQueue.schedule(new Task(Intrinsics.stringPlus(name, " ping"), this, pingIntervalNanos) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$lambda-3$$inlined$schedule$1
                    final /* synthetic */ String $name;
                    final /* synthetic */ RealWebSocket this$0;
                    final /* synthetic */ long $pingIntervalNanos$inlined;

                    {
                        this.$name = $name;
                        this.this$0 = r8;
                        this.$pingIntervalNanos$inlined = r9;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.this$0.writePingFrame$okhttp();
                        return this.$pingIntervalNanos$inlined;
                    }
                }, pingIntervalNanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, extensions.perMessageDeflate, extensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    public final boolean processNextFrame() throws IOException {
        boolean z;
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            z = this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
            z = false;
        }
        return z;
    }

    public final void awaitTermination(long timeout, @NotNull TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(timeout, timeUnit);
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.internal.p021ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String text) throws IOException {
        Intrinsics.checkNotNullParameter(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.p021ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.internal.p021ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (this.failed) {
            return;
        }
        if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
            this.pongQueue.add(payload);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.p021ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    @Override // okhttp3.internal.p021ws.WebSocketReader.FrameCallback
    public void onReadClose(int code, @NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (!(code != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Object toClose = null;
        Object readerToClose = null;
        Object writerToClose = null;
        synchronized (this) {
            if (!(this.receivedCloseCode == -1)) {
                throw new IllegalStateException("already closed".toString());
            }
            this.receivedCloseCode = code;
            this.receivedCloseReason = reason;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                toClose = this.streams;
                this.streams = null;
                readerToClose = this.reader;
                this.reader = null;
                writerToClose = this.writer;
                this.writer = null;
                this.taskQueue.shutdown();
            }
            Unit unit = Unit.INSTANCE;
        }
        try {
            this.listener.onClosing(this, code, reason);
            if (toClose != null) {
                this.listener.onClosed(this, code, reason);
            }
            if (toClose != null) {
                Util.closeQuietly((Closeable) toClose);
            }
            if (readerToClose != null) {
                Util.closeQuietly((Closeable) readerToClose);
            }
            if (writerToClose != null) {
                Util.closeQuietly((Closeable) writerToClose);
            }
        } catch (Throwable th) {
            if (toClose != null) {
                Util.closeQuietly((Closeable) toClose);
            }
            if (readerToClose != null) {
                Util.closeQuietly((Closeable) readerToClose);
            }
            if (writerToClose != null) {
                Util.closeQuietly((Closeable) writerToClose);
            }
            throw th;
        }
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return send(bytes, 2);
    }

    private final synchronized boolean send(ByteString data, int formatOpcode) {
        if (this.failed || this.enqueuedClose) {
            return false;
        }
        if (this.queueSize + ((long) data.size()) > MAX_QUEUE_SIZE) {
            close(1001, null);
            return false;
        }
        this.queueSize += (long) data.size();
        this.messageAndCloseQueue.add(new Message(formatOpcode, data));
        runWriter();
        return true;
    }

    public final synchronized boolean pong(@NotNull ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (this.failed) {
            return false;
        }
        if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
            return false;
        }
        this.pongQueue.add(payload);
        runWriter();
        return true;
    }

    @Override // okhttp3.WebSocket
    public boolean close(int code, @Nullable String reason) {
        return close(code, reason, 60000);
    }

    public final synchronized boolean close(int code, @Nullable String reason, long cancelAfterCloseMillis) {
        WebSocketProtocol.INSTANCE.validateCloseCode(code);
        ByteString reasonBytes = null;
        if (reason != null) {
            reasonBytes = ByteString.Companion.encodeUtf8(reason);
            if (!(((long) reasonBytes.size()) <= 123)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("reason.size() > 123: ", reason).toString());
            }
        }
        if (this.failed || this.enqueuedClose) {
            return false;
        }
        this.enqueuedClose = true;
        this.messageAndCloseQueue.add(new Close(code, reasonBytes, cancelAfterCloseMillis));
        runWriter();
        return true;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task writerTask = this.writerTask;
            if (writerTask != null) {
                TaskQueue.schedule$default(this.taskQueue, writerTask, 0, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:42:0x0158
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 529
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p021ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            if (!this.failed) {
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter != null) {
                    int failedPing = this.awaitingPong ? this.sentPingCount : -1;
                    this.sentPingCount++;
                    this.awaitingPong = true;
                    Unit unit = Unit.INSTANCE;
                    if (failedPing != -1) {
                        failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (failedPing - 1) + " successful ping/pongs)"), null);
                        return;
                    }
                    try {
                        webSocketWriter.writePing(ByteString.EMPTY);
                    } catch (IOException e) {
                        failWebSocket(e, null);
                    }
                }
            }
        }
    }

    public final void failWebSocket(@NotNull Exception e, @Nullable Response response) {
        Intrinsics.checkNotNullParameter(e, "e");
        synchronized (this) {
            if (!this.failed) {
                this.failed = true;
                Object streamsToClose = this.streams;
                this.streams = null;
                Object readerToClose = this.reader;
                this.reader = null;
                Object writerToClose = this.writer;
                this.writer = null;
                this.taskQueue.shutdown();
                Unit unit = Unit.INSTANCE;
                try {
                    this.listener.onFailure(this, e, response);
                    if (streamsToClose != null) {
                        Util.closeQuietly((Closeable) streamsToClose);
                    }
                    if (readerToClose != null) {
                        Util.closeQuietly((Closeable) readerToClose);
                    }
                    if (writerToClose != null) {
                        Util.closeQuietly((Closeable) writerToClose);
                    }
                } catch (Throwable th) {
                    if (streamsToClose != null) {
                        Util.closeQuietly((Closeable) streamsToClose);
                    }
                    if (readerToClose != null) {
                        Util.closeQuietly((Closeable) readerToClose);
                    }
                    if (writerToClose != null) {
                        Util.closeQuietly((Closeable) writerToClose);
                    }
                    throw th;
                }
            }
        }
    }

    /* compiled from: RealWebSocket.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\b��\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m373d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Message */
    /* loaded from: grasscutter.jar:okhttp3/internal/ws/RealWebSocket$Message.class */
    public static final class Message {
        private final int formatOpcode;
        @NotNull
        private final ByteString data;

        public Message(int formatOpcode, @NotNull ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = formatOpcode;
            this.data = data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }
    }

    /* compiled from: RealWebSocket.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\b\b��\u0018��2\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m373d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Close */
    /* loaded from: grasscutter.jar:okhttp3/internal/ws/RealWebSocket$Close.class */
    public static final class Close {
        private final int code;
        @Nullable
        private final ByteString reason;
        private final long cancelAfterCloseMillis;

        public Close(int code, @Nullable ByteString reason, long cancelAfterCloseMillis) {
            this.code = code;
            this.reason = reason;
            this.cancelAfterCloseMillis = cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    /* compiled from: RealWebSocket.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018��2\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m373d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Streams */
    /* loaded from: grasscutter.jar:okhttp3/internal/ws/RealWebSocket$Streams.class */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        @NotNull
        private final BufferedSource source;
        @NotNull
        private final BufferedSink sink;

        public Streams(boolean client, @NotNull BufferedSource source, @NotNull BufferedSink sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.client = client;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final BufferedSource getSource() {
            return this.source;
        }

        @NotNull
        public final BufferedSink getSink() {
            return this.sink;
        }
    }

    /* compiled from: RealWebSocket.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n��\b\u0004\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m373d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$WriterTask */
    /* loaded from: grasscutter.jar:okhttp3/internal/ws/RealWebSocket$WriterTask.class */
    private final class WriterTask extends Task {
        final /* synthetic */ RealWebSocket this$0;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
        public WriterTask(RealWebSocket this$0) {
            super(Intrinsics.stringPlus(this$0.name, " writer"), false, 2, null);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return this.this$0.writeOneFrame$okhttp() ? 0 : -1;
            } catch (IOException e) {
                this.this$0.failWebSocket(e, null);
                return -1;
            }
        }
    }

    /* compiled from: RealWebSocket.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"})
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Companion */
    /* loaded from: grasscutter.jar:okhttp3/internal/ws/RealWebSocket$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
