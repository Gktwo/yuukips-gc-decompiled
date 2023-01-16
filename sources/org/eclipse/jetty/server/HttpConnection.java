package org.eclipse.jetty.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritePendingException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.EofException;
import org.eclipse.jetty.p023io.WriteFlusher;
import org.eclipse.jetty.server.HttpInput;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpConnection.class */
public class HttpConnection extends AbstractConnection implements Runnable, HttpTransport, WriteFlusher.Listener, Connection.UpgradeFrom, Connection.UpgradeTo {
    public static final String UPGRADE_CONNECTION_ATTRIBUTE = "org.eclipse.jetty.server.HttpConnection.UPGRADE";
    private static final boolean REQUEST_BUFFER_DIRECT = false;
    private static final boolean HEADER_BUFFER_DIRECT = false;
    private static final boolean CHUNK_BUFFER_DIRECT = false;
    private final HttpConfiguration _config;
    private final Connector _connector;
    private final ByteBufferPool _bufferPool;
    private final HttpParser _parser;
    private final boolean _recordHttpComplianceViolations;
    private static final Logger LOG = Log.getLogger(HttpConnection.class);
    public static final HttpField CONNECTION_CLOSE = new PreEncodedHttpField(HttpHeader.CONNECTION, HttpHeaderValue.CLOSE.asString());
    private static final ThreadLocal<HttpConnection> __currentConnection = new ThreadLocal<>();
    private final AtomicInteger _contentBufferReferences = new AtomicInteger();
    private volatile ByteBuffer _requestBuffer = null;
    private final BlockingReadCallback _blockingReadCallback = new BlockingReadCallback();
    private final AsyncReadCallback _asyncReadCallback = new AsyncReadCallback();
    private final SendCallback _sendCallback = new SendCallback();
    private final LongAdder bytesIn = new LongAdder();
    private final LongAdder bytesOut = new LongAdder();
    private final HttpGenerator _generator = newHttpGenerator();
    private final HttpChannelOverHttp _channel = newHttpChannel();
    private final HttpInput _input = this._channel.getRequest().getHttpInput();

    public static HttpConnection getCurrentConnection() {
        return __currentConnection.get();
    }

    protected static HttpConnection setCurrentConnection(HttpConnection connection) {
        HttpConnection last = __currentConnection.get();
        __currentConnection.set(connection);
        return last;
    }

    public HttpConnection(HttpConfiguration config, Connector connector, EndPoint endPoint, HttpCompliance compliance, boolean recordComplianceViolations) {
        super(endPoint, connector.getExecutor());
        this._config = config;
        this._connector = connector;
        this._bufferPool = this._connector.getByteBufferPool();
        this._parser = newHttpParser(compliance);
        this._recordHttpComplianceViolations = recordComplianceViolations;
        if (LOG.isDebugEnabled()) {
            LOG.debug("New HTTP Connection {}", this);
        }
    }

    @Deprecated
    public HttpCompliance getHttpCompliance() {
        return this._parser.getHttpCompliance();
    }

    public HttpConfiguration getHttpConfiguration() {
        return this._config;
    }

    public boolean isRecordHttpComplianceViolations() {
        return this._recordHttpComplianceViolations;
    }

    protected HttpGenerator newHttpGenerator() {
        return new HttpGenerator(this._config.getSendServerVersion(), this._config.getSendXPoweredBy());
    }

    protected HttpChannelOverHttp newHttpChannel() {
        return new HttpChannelOverHttp(this, this._connector, this._config, getEndPoint(), this);
    }

    protected HttpParser newHttpParser(HttpCompliance compliance) {
        return new HttpParser(newRequestHandler(), getHttpConfiguration().getRequestHeaderSize(), compliance);
    }

    protected HttpParser.RequestHandler newRequestHandler() {
        return this._channel;
    }

    public Server getServer() {
        return this._connector.getServer();
    }

    public Connector getConnector() {
        return this._connector;
    }

    public HttpChannel getHttpChannel() {
        return this._channel;
    }

    public HttpParser getParser() {
        return this._parser;
    }

    public HttpGenerator getGenerator() {
        return this._generator;
    }

    @Override // org.eclipse.jetty.server.HttpTransport
    public boolean isOptimizedForDirectBuffers() {
        return getEndPoint().isOptimizedForDirectBuffers();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getMessagesIn() {
        return getHttpChannel().getRequests();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getMessagesOut() {
        return getHttpChannel().getRequests();
    }

    @Override // org.eclipse.jetty.p023io.Connection.UpgradeFrom
    public ByteBuffer onUpgradeFrom() {
        if (!BufferUtil.hasContent(this._requestBuffer)) {
            return null;
        }
        ByteBuffer unconsumed = ByteBuffer.allocateDirect(this._requestBuffer.remaining());
        unconsumed.put(this._requestBuffer);
        unconsumed.flip();
        releaseRequestBuffer();
        return unconsumed;
    }

    @Override // org.eclipse.jetty.p023io.Connection.UpgradeTo
    public void onUpgradeTo(ByteBuffer buffer) {
        BufferUtil.append(getRequestBuffer(), buffer);
    }

    @Override // org.eclipse.jetty.p023io.WriteFlusher.Listener
    public void onFlushed(long bytes) throws IOException {
        this._channel.getResponse().getHttpOutput().onFlushed(bytes);
    }

    void releaseRequestBuffer() {
        if (this._requestBuffer != null && !this._requestBuffer.hasRemaining()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("releaseRequestBuffer {}", this);
            }
            ByteBuffer buffer = this._requestBuffer;
            this._requestBuffer = null;
            this._bufferPool.release(buffer);
        }
    }

    public ByteBuffer getRequestBuffer() {
        if (this._requestBuffer == null) {
            this._requestBuffer = this._bufferPool.acquire(getInputBufferSize(), false);
        }
        return this._requestBuffer;
    }

    public boolean isRequestBufferEmpty() {
        return BufferUtil.isEmpty(this._requestBuffer);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillable() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} onFillable enter {} {}", this, this._channel.getState(), BufferUtil.toDetailString(this._requestBuffer));
        }
        HttpConnection last = setCurrentConnection(this);
        while (true) {
            try {
                if (getEndPoint().isOpen()) {
                    int filled = fillRequestBuffer();
                    if (filled < 0 && getEndPoint().isOutputShutdown()) {
                        close();
                    }
                    boolean handle = parseRequestBuffer();
                    if (getEndPoint().getConnection() != this) {
                        break;
                    } else if (handle) {
                        if ((!this._channel.handle()) || getEndPoint().getConnection() != this) {
                            break;
                        }
                    } else if (filled == 0) {
                        fillInterested();
                        break;
                    } else if (filled < 0) {
                        if (this._channel.getState().isIdle()) {
                            getEndPoint().shutdownOutput();
                        }
                    }
                } else {
                    break;
                }
            } catch (Throwable th) {
                setCurrentConnection(last);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} onFillable exit {} {}", this, this._channel.getState(), BufferUtil.toDetailString(this._requestBuffer));
                }
                throw th;
            }
        }
        setCurrentConnection(last);
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} onFillable exit {} {}", this, this._channel.getState(), BufferUtil.toDetailString(this._requestBuffer));
        }
    }

    /* access modifiers changed from: protected */
    public boolean fillAndParseForContent() {
        if (this._parser.isTerminated()) {
            throw new IllegalStateException("Parser is terminated: " + this._parser);
        }
        boolean handled = false;
        while (this._parser.inContentState()) {
            int filled = fillRequestBuffer();
            handled = parseRequestBuffer();
            if (!handled) {
                if (filled > 0) {
                    if (this._input.hasContent()) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return handled;
    }

    private int fillRequestBuffer() {
        if (this._contentBufferReferences.get() > 0) {
            throw new IllegalStateException("fill with unconsumed content on " + this);
        } else if (!BufferUtil.isEmpty(this._requestBuffer)) {
            return 0;
        } else {
            this._requestBuffer = getRequestBuffer();
            try {
                int filled = getEndPoint().fill(this._requestBuffer);
                if (filled == 0) {
                    filled = getEndPoint().fill(this._requestBuffer);
                }
                if (filled > 0) {
                    this.bytesIn.add((long) filled);
                } else if (filled < 0) {
                    this._parser.atEOF();
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} filled {} {}", this, Integer.valueOf(filled), BufferUtil.toDetailString(this._requestBuffer));
                }
                return filled;
            } catch (IOException e) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(e);
                }
                this._parser.atEOF();
                return -1;
            }
        }
    }

    private boolean parseRequestBuffer() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} parse {} {}", this, BufferUtil.toDetailString(this._requestBuffer));
        }
        boolean handle = this._parser.parseNext(this._requestBuffer == null ? BufferUtil.EMPTY_BUFFER : this._requestBuffer);
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} parsed {} {}", this, Boolean.valueOf(handle), this._parser);
        }
        if (this._contentBufferReferences.get() == 0) {
            releaseRequestBuffer();
        }
        return handle;
    }

    @Override // org.eclipse.jetty.server.HttpTransport
    public void onCompleted() {
        Connection connection;
        if (isFillInterested()) {
            LOG.warn("Pending read in onCompleted {} {}", this, getEndPoint());
            this._channel.abort(new IOException("Pending read in onCompleted"));
        } else if (this._channel.getResponse().getStatus() == 101 && (connection = (Connection) this._channel.getRequest().getAttribute(UPGRADE_CONNECTION_ATTRIBUTE)) != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Upgrade from {} to {}", this, connection);
            }
            this._channel.getState().upgrade();
            getEndPoint().upgrade(connection);
            this._channel.recycle();
            this._parser.reset();
            this._generator.reset();
            if (this._contentBufferReferences.get() == 0) {
                releaseRequestBuffer();
                return;
            }
            LOG.warn("{} lingering content references?!?!", this);
            this._requestBuffer = null;
            this._contentBufferReferences.set(0);
            return;
        }
        boolean complete = this._input.consumeAll();
        if (this._channel.isExpecting100Continue()) {
            this._parser.close();
        } else if (this._generator.isPersistent() && !complete) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("unconsumed input {} {}", this, this._parser);
            }
            this._channel.abort(new IOException("unconsumed input"));
        }
        this._channel.recycle();
        if (!this._parser.isClosed()) {
            if (this._generator.isPersistent()) {
                this._parser.reset();
            } else {
                this._parser.close();
            }
        }
        this._generator.reset();
        if (getCurrentConnection() == this) {
            return;
        }
        if (this._parser.isStart()) {
            if (BufferUtil.isEmpty(this._requestBuffer)) {
                fillInterested();
            } else if (getConnector().isRunning()) {
                try {
                    getExecutor().execute(this);
                } catch (RejectedExecutionException e) {
                    if (getConnector().isRunning()) {
                        LOG.warn(e);
                    } else {
                        LOG.ignore(e);
                    }
                    getEndPoint().close();
                }
            } else {
                getEndPoint().close();
            }
        } else if (getEndPoint().isOpen()) {
            fillInterested();
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    protected boolean onReadTimeout(Throwable timeout) {
        return this._channel.onIdleTimeout(timeout);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillInterestedFailed(Throwable cause) {
        this._parser.close();
        onFillInterestedFailed(cause);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public void onOpen() {
        onOpen();
        if (isRequestBufferEmpty()) {
            fillInterested();
        } else {
            getExecutor().execute(this);
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public void onClose() {
        this._sendCallback.close();
        onClose();
    }

    @Override // java.lang.Runnable
    public void run() {
        onFillable();
    }

    @Override // org.eclipse.jetty.server.HttpTransport
    public void send(MetaData.Response info, boolean head, ByteBuffer content, boolean lastContent, Callback callback) {
        if (info == null) {
            if (!lastContent && BufferUtil.isEmpty(content)) {
                callback.succeeded();
                return;
            }
        } else if (this._channel.isExpecting100Continue()) {
            this._generator.setPersistent(false);
        }
        if (this._sendCallback.reset(info, head, content, lastContent, callback)) {
            this._sendCallback.iterate();
        }
    }

    /* access modifiers changed from: package-private */
    public HttpInput.Content newContent(ByteBuffer c) {
        return new Content(c);
    }

    @Override // org.eclipse.jetty.server.HttpTransport
    public void abort(Throwable failure) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("abort {} {}", this, failure);
        }
        getEndPoint().close();
    }

    @Override // org.eclipse.jetty.server.HttpTransport
    public boolean isPushSupported() {
        return false;
    }

    @Override // org.eclipse.jetty.server.HttpTransport
    public void push(MetaData.Request request) {
        LOG.debug("ignore push in {}", this);
    }

    public void asyncReadFillInterested() {
        getEndPoint().fillInterested(this._asyncReadCallback);
    }

    public void blockingReadFillInterested() {
        getEndPoint().tryFillInterested(this._blockingReadCallback);
    }

    public void blockingReadFailure(Throwable e) {
        this._blockingReadCallback.failed(e);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getBytesIn() {
        return this.bytesIn.longValue();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getBytesOut() {
        return this.bytesOut.longValue();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public String toConnectionString() {
        return String.format("%s@%x[p=%s,g=%s]=>%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._parser, this._generator, this._channel);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpConnection$Content.class */
    private class Content extends HttpInput.Content {
        public Content(ByteBuffer content) {
            super(content);
            HttpConnection.this._contentBufferReferences.incrementAndGet();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            if (HttpConnection.this._contentBufferReferences.decrementAndGet() == 0) {
                HttpConnection.this.releaseRequestBuffer();
            }
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            succeeded();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpConnection$BlockingReadCallback.class */
    private class BlockingReadCallback implements Callback {
        private BlockingReadCallback() {
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            HttpConnection.this._input.unblock();
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            HttpConnection.this._input.failed(x);
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpConnection$AsyncReadCallback.class */
    private class AsyncReadCallback implements Callback {
        private AsyncReadCallback() {
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            if (HttpConnection.this._channel.getState().onReadPossible()) {
                HttpConnection.this._channel.handle();
            }
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            if (HttpConnection.this._input.failed(x)) {
                HttpConnection.this._channel.handle();
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpConnection$SendCallback.class */
    private class SendCallback extends IteratingCallback {
        private MetaData.Response _info;
        private boolean _head;
        private ByteBuffer _content;
        private boolean _lastContent;
        private Callback _callback;
        private ByteBuffer _header;
        private ByteBuffer _chunk;
        private boolean _shutdownOut;

        private SendCallback() {
            super(true);
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return this._callback.getInvocationType();
        }

        /* access modifiers changed from: private */
        public boolean reset(MetaData.Response info, boolean head, ByteBuffer content, boolean last, Callback callback) {
            if (reset()) {
                this._info = info;
                this._head = head;
                this._content = content;
                this._lastContent = last;
                this._callback = callback;
                this._header = null;
                this._shutdownOut = false;
                if (!HttpConnection.this.getConnector().isShutdown()) {
                    return true;
                }
                HttpConnection.this._generator.setPersistent(false);
                return true;
            } else if (isClosed()) {
                callback.failed(new EofException());
                return false;
            } else {
                callback.failed(new WritePendingException());
                return false;
            }
        }

        /* JADX WARN: Type inference failed for: r0v70, types: [long] */
        /* JADX WARN: Type inference failed for: r0v75, types: [long] */
        /* JADX WARN: Type inference failed for: r0v80, types: [long] */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public IteratingCallback.Action process() throws Exception {
            if (this._callback == null) {
                throw new IllegalStateException();
            }
            while (true) {
                HttpGenerator.Result result = HttpConnection.this._generator.generateResponse(this._info, this._head, this._header, this._chunk, this._content, this._lastContent);
                if (HttpConnection.LOG.isDebugEnabled()) {
                    HttpConnection.LOG.debug("generate: {} for {} ({},{},{})@{}", result, this, BufferUtil.toSummaryString(this._header), BufferUtil.toSummaryString(this._content), Boolean.valueOf(this._lastContent), HttpConnection.this._generator.getState());
                }
                switch (result) {
                    case NEED_INFO:
                        throw new EofException("request lifecycle violation");
                    case NEED_HEADER:
                        this._header = HttpConnection.this._bufferPool.acquire(Math.min(HttpConnection.this._config.getResponseHeaderSize(), HttpConnection.this._config.getOutputBufferSize()), false);
                        break;
                    case HEADER_OVERFLOW:
                        if (this._header.capacity() < HttpConnection.this._config.getResponseHeaderSize()) {
                            releaseHeader();
                            this._header = HttpConnection.this._bufferPool.acquire(HttpConnection.this._config.getResponseHeaderSize(), false);
                            break;
                        } else {
                            throw new BadMessageException(500, "Response header too large");
                        }
                    case NEED_CHUNK:
                        this._chunk = HttpConnection.this._bufferPool.acquire(12, false);
                        break;
                    case NEED_CHUNK_TRAILER:
                        releaseChunk();
                        this._chunk = HttpConnection.this._bufferPool.acquire(HttpConnection.this._config.getResponseHeaderSize(), false);
                        break;
                    case FLUSH:
                        if (this._head || HttpConnection.this._generator.isNoContent()) {
                            BufferUtil.clear(this._chunk);
                            BufferUtil.clear(this._content);
                        }
                        byte gatherWrite = 0;
                        char c = 0;
                        if (BufferUtil.hasContent(this._header)) {
                            gatherWrite = (byte) (0 + 4);
                            c = 0 + ((long) this._header.remaining());
                        }
                        if (BufferUtil.hasContent(this._chunk)) {
                            gatherWrite = (byte) (gatherWrite + 2);
                            c += (long) this._chunk.remaining();
                        }
                        if (BufferUtil.hasContent(this._content)) {
                            gatherWrite = (byte) (gatherWrite + 1);
                            c += (long) this._content.remaining();
                        }
                        HttpConnection.this.bytesOut.add(c);
                        switch (gatherWrite) {
                            case 1:
                                HttpConnection.this.getEndPoint().write(this, this._content);
                                break;
                            case 2:
                                HttpConnection.this.getEndPoint().write(this, this._chunk);
                                break;
                            case 3:
                                HttpConnection.this.getEndPoint().write(this, this._chunk, this._content);
                                break;
                            case 4:
                                HttpConnection.this.getEndPoint().write(this, this._header);
                                break;
                            case 5:
                                HttpConnection.this.getEndPoint().write(this, this._header, this._content);
                                break;
                            case 6:
                                HttpConnection.this.getEndPoint().write(this, this._header, this._chunk);
                                break;
                            case 7:
                                HttpConnection.this.getEndPoint().write(this, this._header, this._chunk, this._content);
                                break;
                            default:
                                succeeded();
                                break;
                        }
                        return IteratingCallback.Action.SCHEDULED;
                    case SHUTDOWN_OUT:
                        this._shutdownOut = true;
                        break;
                    case DONE:
                        if (HttpConnection.this.getConnector().isShutdown() && HttpConnection.this._generator.isEnd() && HttpConnection.this._generator.isPersistent()) {
                            this._shutdownOut = true;
                        }
                        return IteratingCallback.Action.SUCCEEDED;
                    case CONTINUE:
                        break;
                    default:
                        throw new IllegalStateException("generateResponse=" + result);
                }
            }
        }

        private Callback release() {
            Callback complete = this._callback;
            this._callback = null;
            this._info = null;
            this._content = null;
            releaseHeader();
            releaseChunk();
            return complete;
        }

        private void releaseHeader() {
            if (this._header != null) {
                HttpConnection.this._bufferPool.release(this._header);
            }
            this._header = null;
        }

        private void releaseChunk() {
            if (this._chunk != null) {
                HttpConnection.this._bufferPool.release(this._chunk);
            }
            this._chunk = null;
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteSuccess() {
            release().succeeded();
            if (this._shutdownOut) {
                HttpConnection.this.getEndPoint().shutdownOutput();
            }
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable x) {
            HttpConnection.this.failedCallback(release(), x);
            if (this._shutdownOut) {
                HttpConnection.this.getEndPoint().shutdownOutput();
            }
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        public String toString() {
            return String.format("%s[i=%s,cb=%s]", toString(), this._info, this._callback);
        }
    }
}
