package okhttp3.internal.http2;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Http2Connection.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018�� \u00012\u00020\u0001:\b\u0001\u0001\u0001\u0001B\u000f\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020QH\u0016J'\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WH��¢\u0006\u0002\bXJ\u0012\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010WH\u0002J\u0006\u0010[\u001a\u00020QJ\u0010\u0010\\\u001a\u0004\u0018\u00010B2\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0006J&\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010`\u001a\u00020B2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020\u0012J-\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\tH��¢\u0006\u0002\bmJ+\u0010n\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010l\u001a\u00020\tH��¢\u0006\u0002\boJ#\u0010p\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH��¢\u0006\u0002\bqJ\u001d\u0010r\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH��¢\u0006\u0002\btJ$\u0010u\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0015\u0010v\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0012H��¢\u0006\u0002\bwJ\u0017\u0010x\u001a\u0004\u0018\u00010B2\u0006\u0010h\u001a\u00020\u0012H��¢\u0006\u0002\byJ\r\u0010z\u001a\u00020QH��¢\u0006\u0002\b{J\u000e\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020&J\u000e\u0010~\u001a\u00020Q2\u0006\u0010\u001a\u00020TJ\u001e\u0010\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0001\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020FH\u0007J\u0018\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\u0006H��¢\u0006\u0003\b\u0001J,\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\t2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010k\u001a\u00020\u0006J/\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\t2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020d0cH��¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020QJ\"\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0012J\u0007\u0010\u0001\u001a\u00020QJ\u001f\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010\u001a\u00020TH��¢\u0006\u0003\b\u0001J\u001f\u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH��¢\u0006\u0003\b\u0001J \u0010\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0001\u001a\u00020\u0006H��¢\u0006\u0003\b\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n��R\u001a\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n��\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0012X\u000e¢\u0006\u000e\n��\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020&¢\u0006\b\n��\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020&X\u000e¢\u0006\u000e\n��\u001a\u0004\b*\u0010(\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n��R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n��R\u001e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n��\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n��\u001a\u0004\b6\u00104R\u0015\u00107\u001a\u000608R\u00020��¢\u0006\b\n��\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u000200X\u0004¢\u0006\u0002\n��R\u0014\u0010<\u001a\u00020=X\u0004¢\u0006\b\n��\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020B0AX\u0004¢\u0006\b\n��\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0004¢\u0006\u0002\n��R\u001e\u0010G\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n��\u001a\u0004\bH\u00104R\u001e\u0010I\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u000e¢\u0006\b\n��\u001a\u0004\bJ\u00104R\u0011\u0010K\u001a\u00020L¢\u0006\b\n��\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u000200X\u0004¢\u0006\u0002\n��¨\u0006\u0001"}, m373d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitPingsSent", "", "awaitPongsReceived", "client", "", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "awaitPong", "", "close", "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "flush", "getStream", "id", "isHealthy", "nowNs", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", "source", "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", "errorCode", "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "setSettings", "settings", "shutdown", "statusCode", "start", "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection.class */
public final class Http2Connection implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean client;
    @NotNull
    private final Listener listener;
    @NotNull
    private final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    @NotNull
    private final String connectionName;
    private int lastGoodStreamId;
    private int nextStreamId;
    private boolean isShutdown;
    @NotNull
    private final TaskRunner taskRunner;
    @NotNull
    private final TaskQueue writerQueue;
    @NotNull
    private final TaskQueue pushQueue;
    @NotNull
    private final TaskQueue settingsListenerQueue;
    @NotNull
    private final PushObserver pushObserver;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private long degradedPingsSent;
    private long degradedPongsReceived;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private long degradedPongDeadlineNs;
    @NotNull
    private final Settings okHttpSettings;
    @NotNull
    private Settings peerSettings;
    private long readBytesTotal;
    private long readBytesAcknowledged;
    private long writeBytesTotal;
    private long writeBytesMaximum;
    @NotNull
    private final Socket socket;
    @NotNull
    private final Http2Writer writer;
    @NotNull
    private final ReaderRunnable readerRunnable;
    @NotNull
    private final Set<Integer> currentPushRequests;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE;
    @NotNull
    private static final Settings DEFAULT_SETTINGS;
    public static final int INTERVAL_PING;
    public static final int DEGRADED_PING;
    public static final int AWAIT_PING;
    public static final int DEGRADED_PONG_TIMEOUT_NS;

    @JvmOverloads
    public final void start(boolean sendConnectionPreface) throws IOException {
        start$default(this, sendConnectionPreface, null, 2, null);
    }

    @JvmOverloads
    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    public Http2Connection(@NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.client = builder.getClient$okhttp();
        this.listener = builder.getListener$okhttp();
        this.connectionName = builder.getConnectionName$okhttp();
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        this.taskRunner = builder.getTaskRunner$okhttp();
        this.writerQueue = this.taskRunner.newQueue();
        this.pushQueue = this.taskRunner.newQueue();
        this.settingsListenerQueue = this.taskRunner.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings $this$okHttpSettings_u24lambda_u2d0 = new Settings();
        if (builder.getClient$okhttp()) {
            $this$okHttpSettings_u24lambda_u2d0.set(7, 16777216);
        }
        this.okHttpSettings = $this$okHttpSettings_u24lambda_u2d0;
        this.peerSettings = DEFAULT_SETTINGS;
        this.writeBytesMaximum = (long) this.peerSettings.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), this.client);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), this.client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long pingIntervalNanos = TimeUnit.MILLISECONDS.toNanos((long) builder.getPingIntervalMillis$okhttp());
            this.writerQueue.schedule(new Task(Intrinsics.stringPlus(this.connectionName, " ping"), this, pingIntervalNanos) { // from class: okhttp3.internal.http2.Http2Connection$special$$inlined$schedule$1
                final /* synthetic */ String $name;
                final /* synthetic */ Http2Connection this$0;
                final /* synthetic */ long $pingIntervalNanos$inlined;

                {
                    this.$name = $name;
                    this.this$0 = r8;
                    this.$pingIntervalNanos$inlined = r9;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    boolean failDueToMissingPong;
                    synchronized (this.this$0) {
                        if (this.this$0.intervalPongsReceived < this.this$0.intervalPingsSent) {
                            failDueToMissingPong = true;
                        } else {
                            this.this$0.intervalPingsSent++;
                            failDueToMissingPong = false;
                        }
                    }
                    if (failDueToMissingPong) {
                        Http2Connection.access$failConnection(this.this$0, null);
                        return -1;
                    }
                    this.this$0.writePing(false, 1, 0);
                    return this.$pingIntervalNanos$inlined;
                }
            }, pingIntervalNanos);
        }
    }

    public static final /* synthetic */ void access$failConnection(Http2Connection $this, IOException e) {
        $this.failConnection(e);
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    @NotNull
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final void setPeerSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "<set-?>");
        this.peerSettings = settings;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    @NotNull
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    @Nullable
    public final synchronized Http2Stream getStream(int id) {
        return this.streams.get(Integer.valueOf(id));
    }

    @Nullable
    public final synchronized Http2Stream removeStream$okhttp(int streamId) {
        Http2Stream stream = this.streams.remove(Integer.valueOf(streamId));
        notifyAll();
        return stream;
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long read) {
        this.readBytesTotal += read;
        long readBytesToAcknowledge = this.readBytesTotal - this.readBytesAcknowledged;
        if (readBytesToAcknowledge >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater$okhttp(0, readBytesToAcknowledge);
            this.readBytesAcknowledged += readBytesToAcknowledge;
        }
    }

    @NotNull
    public final Http2Stream pushStream(int associatedStreamId, @NotNull List<Header> list, boolean out) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        if (!this.client) {
            return newStream(associatedStreamId, list, out);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List<Header> list, boolean out) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        return newStream(0, list, out);
    }

    private final Http2Stream newStream(int associatedStreamId, List<Header> list, boolean out) throws IOException {
        int streamId;
        Http2Stream http2Stream;
        boolean flushHeaders;
        boolean outFinished = !out;
        synchronized (this.writer) {
            synchronized (this) {
                if (getNextStreamId$okhttp() > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                streamId = getNextStreamId$okhttp();
                setNextStreamId$okhttp(getNextStreamId$okhttp() + 2);
                http2Stream = new Http2Stream(streamId, this, outFinished, false, null);
                flushHeaders = !out || getWriteBytesTotal() >= getWriteBytesMaximum() || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
                if (http2Stream.isOpen()) {
                    getStreams$okhttp().put(Integer.valueOf(streamId), http2Stream);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (associatedStreamId == 0) {
                getWriter().headers(outFinished, streamId, list);
            } else {
                if (!(!getClient$okhttp())) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                }
                getWriter().pushPromise(associatedStreamId, streamId, list);
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (flushHeaders) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public final void writeHeaders$okhttp(int streamId, boolean outFinished, @NotNull List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "alternating");
        this.writer.headers(outFinished, streamId, list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        r0 = java.lang.Math.min((int) java.lang.Math.min((long) r18, getWriteBytesMaximum() - getWriteBytesTotal()), getWriter().maxDataLength());
        r7.writeBytesTotal = getWriteBytesTotal() + ((long) r0);
        r0 = kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeData(int r8, boolean r9, @org.jetbrains.annotations.Nullable okio.Buffer r10, long r11) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 221
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public final void writeSynResetLater$okhttp(int streamId, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.writerQueue.schedule(new Task(this.connectionName + '[' + streamId + "] writeSynReset", true, this, streamId, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$default$1
            final /* synthetic */ String $name;
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ ErrorCode $errorCode$inlined;

            {
                this.$name = $name;
                this.$cancelable = $cancelable;
                this.this$0 = r7;
                this.$streamId$inlined = r8;
                this.$errorCode$inlined = r9;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
                    return -1;
                } catch (IOException e) {
                    Http2Connection.access$failConnection(this.this$0, e);
                    return -1;
                }
            }
        }, 0);
    }

    public final void writeSynReset$okhttp(int streamId, @NotNull ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.writer.rstStream(streamId, statusCode);
    }

    public final void writeWindowUpdateLater$okhttp(int streamId, long unacknowledgedBytesRead) {
        this.writerQueue.schedule(new Task(this.connectionName + '[' + streamId + "] windowUpdate", true, this, streamId, unacknowledgedBytesRead) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1
            final /* synthetic */ String $name;
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ long $unacknowledgedBytesRead$inlined;

            {
                this.$name = $name;
                this.$cancelable = $cancelable;
                this.this$0 = r7;
                this.$streamId$inlined = r8;
                this.$unacknowledgedBytesRead$inlined = r9;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
                    return -1;
                } catch (IOException e) {
                    Http2Connection.access$failConnection(this.this$0, e);
                    return -1;
                }
            }
        }, 0);
    }

    public final void writePing(boolean reply, int payload1, int payload2) {
        try {
            this.writer.ping(reply, payload1, payload2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final void shutdown(@NotNull ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.writer) {
            Ref.IntRef lastGoodStreamId = new Ref.IntRef();
            synchronized (this) {
                if (!this.isShutdown) {
                    this.isShutdown = true;
                    lastGoodStreamId.element = getLastGoodStreamId$okhttp();
                    Unit unit = Unit.INSTANCE;
                    getWriter().goAway(lastGoodStreamId.element, statusCode, Util.EMPTY_BYTE_ARRAY);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void close$okhttp(@NotNull ErrorCode connectionCode, @NotNull ErrorCode streamCode, @Nullable IOException cause) {
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            try {
                shutdown(connectionCode);
            } catch (IOException e) {
            }
            Object streamsToClose = null;
            synchronized (this) {
                if (!getStreams$okhttp().isEmpty()) {
                    Object array = getStreams$okhttp().values().toArray(new Http2Stream[0]);
                    if (array == 0) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                    streamsToClose = array;
                    getStreams$okhttp().clear();
                }
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) streamsToClose;
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    try {
                        http2Stream.close(streamCode, cause);
                    } catch (IOException e2) {
                    }
                }
            }
            try {
                getWriter().close();
            } catch (IOException e3) {
            }
            try {
                getSocket$okhttp().close();
            } catch (IOException e4) {
            }
            this.writerQueue.shutdown();
            this.pushQueue.shutdown();
            this.settingsListenerQueue.shutdown();
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    private final void failConnection(IOException e) {
        close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, e);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, TaskRunner taskRunner, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(z, taskRunner);
    }

    @JvmOverloads
    public final void start(boolean sendConnectionPreface, @NotNull TaskRunner taskRunner) throws IOException {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        if (sendConnectionPreface) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int windowSize = this.okHttpSettings.getInitialWindowSize();
            if (windowSize != 65535) {
                this.writer.windowUpdate(0, (long) (windowSize - 65535));
            }
        }
        taskRunner.newQueue().schedule(new TaskQueue$execute$1(this.connectionName, true, this.readerRunnable), 0);
    }

    public final void setSettings(@NotNull Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                getOkHttpSettings().merge(settings);
                Unit unit = Unit.INSTANCE;
            }
            getWriter().settings(settings);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final synchronized boolean isHealthy(long nowNs) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || nowNs < this.degradedPongDeadlineNs;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            if (this.degradedPongsReceived >= this.degradedPingsSent) {
                this.degradedPingsSent++;
                this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);
                Unit unit = Unit.INSTANCE;
                this.writerQueue.schedule(new Task(Intrinsics.stringPlus(this.connectionName, " ping"), true, this) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$default$1
                    final /* synthetic */ String $name;
                    final /* synthetic */ boolean $cancelable;
                    final /* synthetic */ Http2Connection this$0;

                    {
                        this.$name = $name;
                        this.$cancelable = $cancelable;
                        this.this$0 = r7;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long runOnce() {
                        this.this$0.writePing(false, 2, 0);
                        return -1;
                    }
                }, 0);
            }
        }
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��X\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00107\u001a\u000208J\u000e\u0010\u0011\u001a\u00020��2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020��2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020��2\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010)\u001a\u00020��2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010#\u001a\u00020$H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n��\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n��\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n��\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n��\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b5\u00106¨\u0006:"}, m373d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/internal/http2/Http2Connection;", "peerName", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$Builder.class */
    public static final class Builder {
        private boolean client;
        @NotNull
        private final TaskRunner taskRunner;
        public Socket socket;
        public String connectionName;
        public BufferedSource source;
        public BufferedSink sink;
        @NotNull
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        @NotNull
        private PushObserver pushObserver = PushObserver.CANCEL;
        private int pingIntervalMillis;

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName, @NotNull BufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            return socket$default(this, socket, peerName, source, null, 8, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            return socket$default(this, socket, peerName, null, null, 12, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public Builder(boolean client, @NotNull TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = client;
            this.taskRunner = taskRunner;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final void setSocket$okhttp(@NotNull Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.socket = socket;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final void setConnectionName$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final void setSource$okhttp(@NotNull BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<set-?>");
            this.source = bufferedSource;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final void setSink$okhttp(@NotNull BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSink, "<set-?>");
            this.sink = bufferedSink;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final void setListener$okhttp(@NotNull Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "<set-?>");
            this.listener = listener;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i, Object obj) throws IOException {
            if ((i & 2) != 0) {
                str = Util.peerName(socket);
            }
            if ((i & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((i & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, str, bufferedSource, bufferedSink);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName, @NotNull BufferedSource source, @NotNull BufferedSink sink) throws IOException {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            Builder $this$socket_u24lambda_u2d0 = this;
            $this$socket_u24lambda_u2d0.setSocket$okhttp(socket);
            $this$socket_u24lambda_u2d0.setConnectionName$okhttp($this$socket_u24lambda_u2d0.getClient$okhttp() ? Util.okHttpName + ' ' + peerName : Intrinsics.stringPlus("MockWebServer ", peerName));
            $this$socket_u24lambda_u2d0.setSource$okhttp(source);
            $this$socket_u24lambda_u2d0.setSink$okhttp(sink);
            return this;
        }

        @NotNull
        public final Builder listener(@NotNull Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            setListener$okhttp(listener);
            return this;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter(pushObserver, "pushObserver");
            setPushObserver$okhttp(pushObserver);
            return this;
        }

        @NotNull
        public final Builder pingIntervalMillis(int pingIntervalMillis) {
            setPingIntervalMillis$okhttp(pingIntervalMillis);
            return this;
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0004\u0018��2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\b��\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J.\u0010$\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\t\u0010)\u001a\u00020\u0003H\u0002J \u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0016J(\u0010.\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0017H\u0016J&\u00102\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\b¨\u00068"}, m373d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "alternateService", "streamId", "", HttpHeaders.ReferrerPolicyValues.ORIGIN, "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "invoke", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "windowUpdate", "windowSizeIncrement", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$ReaderRunnable.class */
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        @NotNull
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(@NotNull Http2Connection this$0, Http2Reader reader) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.this$0 = this$0;
            this.reader = reader;
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // kotlin.jvm.functions.Function0
        public void invoke() {
            ErrorCode connectionErrorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode streamErrorCode = ErrorCode.INTERNAL_ERROR;
            IOException errorException = null;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    connectionErrorCode = ErrorCode.NO_ERROR;
                    streamErrorCode = ErrorCode.CANCEL;
                    this.this$0.close$okhttp(connectionErrorCode, streamErrorCode, null);
                    Util.closeQuietly(this.reader);
                } catch (IOException e) {
                    errorException = e;
                    connectionErrorCode = ErrorCode.PROTOCOL_ERROR;
                    streamErrorCode = ErrorCode.PROTOCOL_ERROR;
                    this.this$0.close$okhttp(connectionErrorCode, streamErrorCode, errorException);
                    Util.closeQuietly(this.reader);
                }
            } catch (Throwable th) {
                this.this$0.close$okhttp(connectionErrorCode, streamErrorCode, errorException);
                Util.closeQuietly(this.reader);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean inFinished, int streamId, @NotNull BufferedSource source, int length) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushDataLater$okhttp(streamId, source, length, inFinished);
                return;
            }
            Http2Stream dataStream = this.this$0.getStream(streamId);
            if (dataStream == null) {
                this.this$0.writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
                this.this$0.updateConnectionFlowControl$okhttp((long) length);
                source.skip((long) length);
                return;
            }
            dataStream.receiveData(source, length);
            if (inFinished) {
                dataStream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean inFinished, int streamId, int associatedStreamId, @NotNull List<Header> list) {
            Intrinsics.checkNotNullParameter(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushHeadersLater$okhttp(streamId, list, inFinished);
                return;
            }
            Http2Connection http2Connection = this.this$0;
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection2.getStream(streamId);
                if (stream != null) {
                    Unit unit = Unit.INSTANCE;
                    stream.receiveHeaders(Util.toHeaders(list), inFinished);
                } else if (!http2Connection2.isShutdown) {
                    if (streamId > http2Connection2.getLastGoodStreamId$okhttp()) {
                        if (streamId % 2 != http2Connection2.getNextStreamId$okhttp() % 2) {
                            Http2Stream newStream = new Http2Stream(streamId, http2Connection2, false, inFinished, Util.toHeaders(list));
                            http2Connection2.setLastGoodStreamId$okhttp(streamId);
                            http2Connection2.getStreams$okhttp().put(Integer.valueOf(streamId), newStream);
                            http2Connection2.taskRunner.newQueue().schedule(new C5522x74e0874(http2Connection2.getConnectionName$okhttp() + '[' + streamId + "] onStream", true, http2Connection2, newStream), 0);
                        }
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int streamId, @NotNull ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(streamId)) {
                this.this$0.pushResetLater$okhttp(streamId, errorCode);
                return;
            }
            Http2Stream rstStream = this.this$0.removeStream$okhttp(streamId);
            if (rstStream != null) {
                rstStream.receiveRstStream(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean clearPrevious, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.this$0.writerQueue.schedule(new C5523x8b30c3bb(Intrinsics.stringPlus(this.this$0.getConnectionName$okhttp(), " applyAndAckSettings"), true, this, clearPrevious, settings), 0);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x0142
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        public final void applyAndAckSettings(boolean r9, @org.jetbrains.annotations.NotNull okhttp3.internal.http2.Settings r10) {
            /*
            // Method dump skipped, instructions count: 422
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.applyAndAckSettings(boolean, okhttp3.internal.http2.Settings):void");
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean ack, int payload1, int payload2) {
            Object obj;
            if (ack) {
                Http2Connection http2Connection = this.this$0;
                Http2Connection http2Connection2 = this.this$0;
                synchronized (http2Connection) {
                    switch (payload1) {
                        case 1:
                            long j = http2Connection2.intervalPongsReceived;
                            http2Connection2.intervalPongsReceived = j + 1;
                            obj = Long.valueOf(j);
                            break;
                        case 2:
                            long j2 = http2Connection2.degradedPongsReceived;
                            http2Connection2.degradedPongsReceived = j2 + 1;
                            obj = Long.valueOf(j2);
                            break;
                        case 3:
                            http2Connection2.awaitPongsReceived++;
                            http2Connection2.notifyAll();
                            obj = Unit.INSTANCE;
                            break;
                        default:
                            obj = Unit.INSTANCE;
                            break;
                    }
                }
                return;
            }
            this.this$0.writerQueue.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1(Intrinsics.stringPlus(this.this$0.getConnectionName$okhttp(), " ping"), true, this.this$0, payload1, payload2), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int lastGoodStreamId, @NotNull ErrorCode errorCode, @NotNull ByteString debugData) {
            Object streamsCopy;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            if (debugData.size() > 0) {
            }
            Http2Connection http2Connection = this.this$0;
            Http2Connection http2Connection2 = this.this$0;
            synchronized (http2Connection) {
                streamsCopy = http2Connection2.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (streamsCopy == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                http2Connection2.isShutdown = true;
                Unit unit = Unit.INSTANCE;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) streamsCopy;
            int i = 0;
            int length = http2StreamArr.length;
            while (i < length) {
                Http2Stream http2Stream = http2StreamArr[i];
                i++;
                if (http2Stream.getId() > lastGoodStreamId && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                Http2Connection http2Connection = this.this$0;
                Http2Connection http2Connection2 = this.this$0;
                synchronized (http2Connection) {
                    http2Connection2.writeBytesMaximum = http2Connection2.getWriteBytesMaximum() + windowSizeIncrement;
                    http2Connection2.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            Http2Stream stream = this.this$0.getStream(streamId);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(windowSizeIncrement);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int streamId, int promisedStreamId, @NotNull List<Header> list) {
            Intrinsics.checkNotNullParameter(list, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(promisedStreamId, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int streamId, @NotNull String origin, @NotNull ByteString protocol, @NotNull String host, int port, long maxAge) {
            Intrinsics.checkNotNullParameter(origin, HttpHeaders.ReferrerPolicyValues.ORIGIN);
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Intrinsics.checkNotNullParameter(host, "host");
        }
    }

    public final boolean pushedStream$okhttp(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    public final void pushRequestLater$okhttp(int streamId, @NotNull List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(streamId));
            this.pushQueue.schedule(new Task(this.connectionName + '[' + streamId + "] onRequest", true, this, streamId, list) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$default$1
                final /* synthetic */ String $name;
                final /* synthetic */ boolean $cancelable;
                final /* synthetic */ Http2Connection this$0;
                final /* synthetic */ int $streamId$inlined;
                final /* synthetic */ List $requestHeaders$inlined;

                {
                    this.$name = $name;
                    this.$cancelable = $cancelable;
                    this.this$0 = r7;
                    this.$streamId$inlined = r8;
                    this.$requestHeaders$inlined = r9;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x005a
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                    */
                @Override // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    /*
                        r4 = this;
                        r0 = 0
                        r5 = r0
                        r0 = r4
                        okhttp3.internal.http2.Http2Connection r0 = r0.this$0
                        okhttp3.internal.http2.PushObserver r0 = okhttp3.internal.http2.Http2Connection.access$getPushObserver$p(r0)
                        r1 = r4
                        int r1 = r1.$streamId$inlined
                        r2 = r4
                        java.util.List r2 = r2.$requestHeaders$inlined
                        boolean r0 = r0.onRequest(r1, r2)
                        r6 = r0
                        r0 = 0
                        r7 = r0
                        r0 = 0
                        r8 = r0
                        r0 = r6
                        if (r0 == 0) goto L_0x0062
                        r0 = r4
                        okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x0066
                        okhttp3.internal.http2.Http2Writer r0 = r0.getWriter()     // Catch: IOException -> 0x0066
                        r1 = r4
                        int r1 = r1.$streamId$inlined     // Catch: IOException -> 0x0066
                        okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: IOException -> 0x0066
                        r0.rstStream(r1, r2)     // Catch: IOException -> 0x0066
                        r0 = r4
                        okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x0066
                        r9 = r0
                        r0 = r9
                        monitor-enter(r0)     // Catch: IOException -> 0x0066
                        r0 = 0
                        r10 = r0
                        r0 = r4
                        okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x0066, all -> 0x005a
                        java.util.Set r0 = okhttp3.internal.http2.Http2Connection.access$getCurrentPushRequests$p(r0)     // Catch: IOException -> 0x0066, all -> 0x005a
                        r1 = r4
                        int r1 = r1.$streamId$inlined     // Catch: IOException -> 0x0066, all -> 0x005a
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: IOException -> 0x0066, all -> 0x005a
                        boolean r0 = r0.remove(r1)     // Catch: IOException -> 0x0066, all -> 0x005a
                        r10 = r0
                        r0 = r9
                        monitor-exit(r0)     // Catch: IOException -> 0x0066
                        goto L_0x0062
                    L_0x005a:
                        r10 = move-exception
                        r0 = r9
                        monitor-exit(r0)     // Catch: IOException -> 0x0066
                        r0 = r10
                        throw r0     // Catch: IOException -> 0x0066
                    L_0x0062:
                        goto L_0x0068
                    L_0x0066:
                        r11 = move-exception
                    L_0x0068:
                        r0 = -1
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$default$1.runOnce():long");
                }
            }, 0);
        }
    }

    public final void pushHeadersLater$okhttp(int streamId, @NotNull List<Header> list, boolean inFinished) {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        this.pushQueue.schedule(new Task(this.connectionName + '[' + streamId + "] onHeaders", true, this, streamId, list, inFinished) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$default$1
            final /* synthetic */ String $name;
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ List $requestHeaders$inlined;
            final /* synthetic */ boolean $inFinished$inlined;

            {
                this.$name = $name;
                this.$cancelable = $cancelable;
                this.this$0 = r7;
                this.$streamId$inlined = r8;
                this.$requestHeaders$inlined = r9;
                this.$inFinished$inlined = r10;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x0069
                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                */
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                /*
                    r5 = this;
                    r0 = 0
                    r6 = r0
                    r0 = r5
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0
                    okhttp3.internal.http2.PushObserver r0 = okhttp3.internal.http2.Http2Connection.access$getPushObserver$p(r0)
                    r1 = r5
                    int r1 = r1.$streamId$inlined
                    r2 = r5
                    java.util.List r2 = r2.$requestHeaders$inlined
                    r3 = r5
                    boolean r3 = r3.$inFinished$inlined
                    boolean r0 = r0.onHeaders(r1, r2, r3)
                    r7 = r0
                    r0 = 0
                    r8 = r0
                    r0 = 0
                    r9 = r0
                    r0 = r7
                    if (r0 == 0) goto L_0x0036
                    r0 = r5
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x0075
                    okhttp3.internal.http2.Http2Writer r0 = r0.getWriter()     // Catch: IOException -> 0x0075
                    r1 = r5
                    int r1 = r1.$streamId$inlined     // Catch: IOException -> 0x0075
                    okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: IOException -> 0x0075
                    r0.rstStream(r1, r2)     // Catch: IOException -> 0x0075
                L_0x0036:
                    r0 = r7
                    if (r0 != 0) goto L_0x0041
                    r0 = r5
                    boolean r0 = r0.$inFinished$inlined     // Catch: IOException -> 0x0075
                    if (r0 == 0) goto L_0x0071
                L_0x0041:
                    r0 = r5
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x0075
                    r10 = r0
                    r0 = r10
                    monitor-enter(r0)     // Catch: IOException -> 0x0075
                    r0 = 0
                    r11 = r0
                    r0 = r5
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x0075, all -> 0x0069
                    java.util.Set r0 = okhttp3.internal.http2.Http2Connection.access$getCurrentPushRequests$p(r0)     // Catch: IOException -> 0x0075, all -> 0x0069
                    r1 = r5
                    int r1 = r1.$streamId$inlined     // Catch: IOException -> 0x0075, all -> 0x0069
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: IOException -> 0x0075, all -> 0x0069
                    boolean r0 = r0.remove(r1)     // Catch: IOException -> 0x0075, all -> 0x0069
                    r11 = r0
                    r0 = r10
                    monitor-exit(r0)     // Catch: IOException -> 0x0075
                    goto L_0x0071
                L_0x0069:
                    r11 = move-exception
                    r0 = r10
                    monitor-exit(r0)     // Catch: IOException -> 0x0075
                    r0 = r11
                    throw r0     // Catch: IOException -> 0x0075
                L_0x0071:
                    goto L_0x0077
                L_0x0075:
                    r12 = move-exception
                L_0x0077:
                    r0 = -1
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$default$1.runOnce():long");
            }
        }, 0);
    }

    public final void pushDataLater$okhttp(int streamId, @NotNull BufferedSource source, int byteCount, boolean inFinished) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Buffer buffer = new Buffer();
        source.require((long) byteCount);
        source.read(buffer, (long) byteCount);
        this.pushQueue.schedule(new Task(this.connectionName + '[' + streamId + "] onData", true, this, streamId, buffer, byteCount, inFinished) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1
            final /* synthetic */ String $name;
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Buffer $buffer$inlined;
            final /* synthetic */ int $byteCount$inlined;
            final /* synthetic */ boolean $inFinished$inlined;

            {
                this.$name = $name;
                this.$cancelable = $cancelable;
                this.this$0 = r7;
                this.$streamId$inlined = r8;
                this.$buffer$inlined = r9;
                this.$byteCount$inlined = r10;
                this.$inFinished$inlined = r11;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x0072
                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                */
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                /*
                    r6 = this;
                    r0 = 0
                    r7 = r0
                    r0 = 0
                    r8 = r0
                    r0 = 0
                    r9 = r0
                    r0 = r6
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x007e
                    okhttp3.internal.http2.PushObserver r0 = okhttp3.internal.http2.Http2Connection.access$getPushObserver$p(r0)     // Catch: IOException -> 0x007e
                    r1 = r6
                    int r1 = r1.$streamId$inlined     // Catch: IOException -> 0x007e
                    r2 = r6
                    okio.Buffer r2 = r2.$buffer$inlined     // Catch: IOException -> 0x007e
                    okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch: IOException -> 0x007e
                    r3 = r6
                    int r3 = r3.$byteCount$inlined     // Catch: IOException -> 0x007e
                    r4 = r6
                    boolean r4 = r4.$inFinished$inlined     // Catch: IOException -> 0x007e
                    boolean r0 = r0.onData(r1, r2, r3, r4)     // Catch: IOException -> 0x007e
                    r10 = r0
                    r0 = r10
                    if (r0 == 0) goto L_0x003e
                    r0 = r6
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x007e
                    okhttp3.internal.http2.Http2Writer r0 = r0.getWriter()     // Catch: IOException -> 0x007e
                    r1 = r6
                    int r1 = r1.$streamId$inlined     // Catch: IOException -> 0x007e
                    okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: IOException -> 0x007e
                    r0.rstStream(r1, r2)     // Catch: IOException -> 0x007e
                L_0x003e:
                    r0 = r10
                    if (r0 != 0) goto L_0x004a
                    r0 = r6
                    boolean r0 = r0.$inFinished$inlined     // Catch: IOException -> 0x007e
                    if (r0 == 0) goto L_0x007a
                L_0x004a:
                    r0 = r6
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x007e
                    r11 = r0
                    r0 = r11
                    monitor-enter(r0)     // Catch: IOException -> 0x007e
                    r0 = 0
                    r12 = r0
                    r0 = r6
                    okhttp3.internal.http2.Http2Connection r0 = r0.this$0     // Catch: IOException -> 0x007e, all -> 0x0072
                    java.util.Set r0 = okhttp3.internal.http2.Http2Connection.access$getCurrentPushRequests$p(r0)     // Catch: IOException -> 0x007e, all -> 0x0072
                    r1 = r6
                    int r1 = r1.$streamId$inlined     // Catch: IOException -> 0x007e, all -> 0x0072
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: IOException -> 0x007e, all -> 0x0072
                    boolean r0 = r0.remove(r1)     // Catch: IOException -> 0x007e, all -> 0x0072
                    r12 = r0
                    r0 = r11
                    monitor-exit(r0)     // Catch: IOException -> 0x007e
                    goto L_0x007a
                L_0x0072:
                    r12 = move-exception
                    r0 = r11
                    monitor-exit(r0)     // Catch: IOException -> 0x007e
                    r0 = r12
                    throw r0     // Catch: IOException -> 0x007e
                L_0x007a:
                    goto L_0x0080
                L_0x007e:
                    r13 = move-exception
                L_0x0080:
                    r0 = -1
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1.runOnce():long");
            }
        }, 0);
    }

    public final void pushResetLater$okhttp(int streamId, @NotNull ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.pushQueue.schedule(new Task(this.connectionName + '[' + streamId + "] onReset", true, this, streamId, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$default$1
            final /* synthetic */ String $name;
            final /* synthetic */ boolean $cancelable;
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ ErrorCode $errorCode$inlined;

            {
                this.$name = $name;
                this.$cancelable = $cancelable;
                this.this$0 = r7;
                this.$streamId$inlined = r8;
                this.$errorCode$inlined = r9;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                this.this$0.pushObserver.onReset(this.$streamId$inlined, this.$errorCode$inlined);
                synchronized (this.this$0) {
                    this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                    Unit unit = Unit.INSTANCE;
                }
                return -1;
            }
        }, 0);
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018�� \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, m373d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$Listener.class */
    public static abstract class Listener {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @JvmField
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public abstract void onStream(@NotNull Http2Stream http2Stream) throws IOException;

        public void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        /* compiled from: Http2Connection.kt */
        @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"})
        /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$Listener$Companion.class */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: Http2Connection.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "AWAIT_PING", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    static {
        Settings $this$DEFAULT_SETTINGS_u24lambda_u2d35 = new Settings();
        $this$DEFAULT_SETTINGS_u24lambda_u2d35.set(7, 65535);
        $this$DEFAULT_SETTINGS_u24lambda_u2d35.set(5, 16384);
        DEFAULT_SETTINGS = $this$DEFAULT_SETTINGS_u24lambda_u2d35;
    }
}
