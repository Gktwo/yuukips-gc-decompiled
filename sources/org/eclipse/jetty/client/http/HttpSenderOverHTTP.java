package org.eclipse.jetty.client.http;

import java.nio.ByteBuffer;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpContent;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.client.HttpRequest;
import org.eclipse.jetty.client.HttpRequestException;
import org.eclipse.jetty.client.HttpSender;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpSenderOverHTTP.class */
public class HttpSenderOverHTTP extends HttpSender {
    private final HttpGenerator generator = new HttpGenerator();
    private final HttpClient httpClient;
    private boolean shutdown;

    public HttpSenderOverHTTP(HttpChannelOverHTTP channel) {
        super(channel);
        this.httpClient = channel.getHttpDestination().getHttpClient();
    }

    @Override // org.eclipse.jetty.client.HttpSender
    public HttpChannelOverHTTP getHttpChannel() {
        return (HttpChannelOverHTTP) getHttpChannel();
    }

    @Override // org.eclipse.jetty.client.HttpSender
    protected void sendHeaders(HttpExchange exchange, HttpContent content, Callback callback) {
        try {
            new HeadersCallback(exchange, content, callback).iterate();
        } catch (Throwable x) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(x);
            }
            callback.failed(x);
        }
    }

    @Override // org.eclipse.jetty.client.HttpSender
    protected void sendContent(HttpExchange exchange, HttpContent content, Callback callback) {
        try {
            ByteBufferPool bufferPool = this.httpClient.getByteBufferPool();
            ByteBuffer chunk = null;
            while (true) {
                ByteBuffer contentBuffer = content.getByteBuffer();
                boolean lastContent = content.isLast();
                HttpGenerator.Result result = this.generator.generateRequest(null, null, chunk, contentBuffer, lastContent);
                if (LOG.isDebugEnabled()) {
                    Logger logger = LOG;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(contentBuffer == null ? -1 : contentBuffer.remaining());
                    objArr[1] = result;
                    objArr[2] = this.generator;
                    logger.debug("Generated content ({} bytes) - {}/{}", objArr);
                }
                switch (result) {
                    case NEED_CHUNK:
                        chunk = bufferPool.acquire(12, false);
                        break;
                    case NEED_CHUNK_TRAILER:
                        chunk = bufferPool.acquire(this.httpClient.getRequestBufferSize(), false);
                        break;
                    case FLUSH:
                        EndPoint endPoint = getHttpChannel().getHttpConnection().getEndPoint();
                        if (chunk != null) {
                            endPoint.write(new ByteBufferRecyclerCallback(callback, bufferPool, new ByteBuffer[]{chunk}), chunk, contentBuffer);
                            return;
                        } else {
                            endPoint.write(callback, contentBuffer);
                            return;
                        }
                    case SHUTDOWN_OUT:
                        shutdownOutput();
                        break;
                    case CONTINUE:
                        if (lastContent) {
                            break;
                        } else {
                            callback.succeeded();
                            return;
                        }
                    case DONE:
                        callback.succeeded();
                        return;
                    default:
                        throw new IllegalStateException(result.toString());
                }
            }
        } catch (Throwable x) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(x);
            }
            callback.failed(x);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.client.HttpSender
    public void reset() {
        this.generator.reset();
        reset();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.client.HttpSender
    public void dispose() {
        this.generator.abort();
        dispose();
        shutdownOutput();
    }

    /* access modifiers changed from: private */
    public void shutdownOutput() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request shutdown output {}", getHttpExchange().getRequest());
        }
        this.shutdown = true;
    }

    /* access modifiers changed from: protected */
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override // org.eclipse.jetty.client.HttpSender, java.lang.Object
    public String toString() {
        return String.format("%s[%s]", toString(), this.generator);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpSenderOverHTTP$HeadersCallback.class */
    private class HeadersCallback extends IteratingCallback {
        private final HttpExchange exchange;
        private final Callback callback;
        private final MetaData.Request metaData;
        private ByteBuffer headerBuffer;
        private ByteBuffer chunkBuffer;
        private ByteBuffer contentBuffer;
        private boolean lastContent;
        private boolean generated;

        public HeadersCallback(HttpExchange exchange, HttpContent content, Callback callback) {
            super(false);
            this.exchange = exchange;
            this.callback = callback;
            HttpRequest request = exchange.getRequest();
            ContentProvider requestContent = request.getContent();
            long contentLength = requestContent == null ? -1 : requestContent.getLength();
            String path = request.getPath();
            String query = request.getQuery();
            this.metaData = new MetaData.Request(request.getMethod(), new HttpURI(query != null ? path + "?" + query : path), request.getVersion(), request.getHeaders(), contentLength);
            this.metaData.setTrailerSupplier(request.getTrailers());
            if (!HttpSenderOverHTTP.this.expects100Continue(request)) {
                content.advance();
                this.contentBuffer = content.getByteBuffer();
                this.lastContent = content.isLast();
            }
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            while (true) {
                HttpGenerator.Result result = HttpSenderOverHTTP.this.generator.generateRequest(this.metaData, this.headerBuffer, this.chunkBuffer, this.contentBuffer, this.lastContent);
                if (HttpSenderOverHTTP.LOG.isDebugEnabled()) {
                    Logger logger = HttpSenderOverHTTP.LOG;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.headerBuffer == null ? -1 : this.headerBuffer.remaining());
                    objArr[1] = Integer.valueOf(this.chunkBuffer == null ? -1 : this.chunkBuffer.remaining());
                    objArr[2] = Integer.valueOf(this.contentBuffer == null ? -1 : this.contentBuffer.remaining());
                    objArr[3] = result;
                    objArr[4] = HttpSenderOverHTTP.this.generator;
                    logger.debug("Generated headers ({} bytes), chunk ({} bytes), content ({} bytes) - {}/{}", objArr);
                }
                switch (result) {
                    case NEED_CHUNK:
                        this.chunkBuffer = HttpSenderOverHTTP.this.httpClient.getByteBufferPool().acquire(12, false);
                        break;
                    case NEED_CHUNK_TRAILER:
                        this.chunkBuffer = HttpSenderOverHTTP.this.httpClient.getByteBufferPool().acquire(HttpSenderOverHTTP.this.httpClient.getRequestBufferSize(), false);
                        break;
                    case FLUSH:
                        EndPoint endPoint = HttpSenderOverHTTP.this.getHttpChannel().getHttpConnection().getEndPoint();
                        if (this.headerBuffer == null) {
                            this.headerBuffer = BufferUtil.EMPTY_BUFFER;
                        }
                        if (this.chunkBuffer == null) {
                            this.chunkBuffer = BufferUtil.EMPTY_BUFFER;
                        }
                        if (this.contentBuffer == null) {
                            this.contentBuffer = BufferUtil.EMPTY_BUFFER;
                        }
                        HttpSenderOverHTTP.this.getHttpChannel().getHttpConnection().addBytesOut((long) (this.headerBuffer.remaining() + this.chunkBuffer.remaining() + this.contentBuffer.remaining()));
                        endPoint.write(this, this.headerBuffer, this.chunkBuffer, this.contentBuffer);
                        this.generated = true;
                        return IteratingCallback.Action.SCHEDULED;
                    case SHUTDOWN_OUT:
                        HttpSenderOverHTTP.this.shutdownOutput();
                        return IteratingCallback.Action.SUCCEEDED;
                    case CONTINUE:
                        if (!this.generated) {
                            break;
                        } else {
                            return IteratingCallback.Action.SUCCEEDED;
                        }
                    case DONE:
                        if (this.generated) {
                            return IteratingCallback.Action.SUCCEEDED;
                        }
                        throw new HttpRequestException("Could not generate headers", this.exchange.getRequest());
                    case NEED_HEADER:
                        this.headerBuffer = HttpSenderOverHTTP.this.httpClient.getByteBufferPool().acquire(HttpSenderOverHTTP.this.httpClient.getRequestBufferSize(), false);
                        break;
                    case HEADER_OVERFLOW:
                        HttpSenderOverHTTP.this.httpClient.getByteBufferPool().release(this.headerBuffer);
                        this.headerBuffer = null;
                        throw new BadMessageException(500, "Request header too large");
                    default:
                        throw new IllegalStateException(result.toString());
                }
            }
        }

        @Override // org.eclipse.jetty.util.IteratingCallback, org.eclipse.jetty.util.Callback
        public void succeeded() {
            release();
            succeeded();
        }

        @Override // org.eclipse.jetty.util.IteratingCallback, org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            release();
            failed(x);
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteSuccess() {
            onCompleteSuccess();
            this.callback.succeeded();
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable cause) {
            onCompleteFailure(cause);
            this.callback.failed(cause);
        }

        private void release() {
            ByteBufferPool bufferPool = HttpSenderOverHTTP.this.httpClient.getByteBufferPool();
            if (!BufferUtil.isTheEmptyBuffer(this.headerBuffer)) {
                bufferPool.release(this.headerBuffer);
            }
            this.headerBuffer = null;
            if (!BufferUtil.isTheEmptyBuffer(this.chunkBuffer)) {
                bufferPool.release(this.chunkBuffer);
            }
            this.chunkBuffer = null;
            this.contentBuffer = null;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpSenderOverHTTP$ByteBufferRecyclerCallback.class */
    private class ByteBufferRecyclerCallback extends Callback.Nested {
        private final ByteBufferPool pool;
        private final ByteBuffer[] buffers;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !HttpSenderOverHTTP.class.desiredAssertionStatus();
        }

        private ByteBufferRecyclerCallback(Callback callback, ByteBufferPool pool, ByteBuffer... buffers) {
            super(callback);
            this.pool = pool;
            this.buffers = buffers;
        }

        @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
        public void succeeded() {
            ByteBuffer[] byteBufferArr = this.buffers;
            for (ByteBuffer buffer : byteBufferArr) {
                if ($assertionsDisabled || !buffer.hasRemaining()) {
                    this.pool.release(buffer);
                } else {
                    throw new AssertionError();
                }
            }
            succeeded();
        }

        @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            for (ByteBuffer buffer : this.buffers) {
                this.pool.release(buffer);
            }
            failed(x);
        }
    }
}
