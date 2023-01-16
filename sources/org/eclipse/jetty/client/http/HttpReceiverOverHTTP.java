package org.eclipse.jetty.client.http;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.client.HttpReceiver;
import org.eclipse.jetty.client.HttpResponse;
import org.eclipse.jetty.client.HttpResponseException;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.RetainableByteBuffer;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpReceiverOverHTTP.class */
public class HttpReceiverOverHTTP extends HttpReceiver implements HttpParser.ResponseHandler {
    private final LongAdder inMessages = new LongAdder();
    private final HttpParser parser;
    private RetainableByteBuffer networkBuffer;
    private boolean shutdown;
    private boolean complete;
    private boolean unsolicited;
    private String method;
    private int status;

    public HttpReceiverOverHTTP(HttpChannelOverHTTP channel) {
        super(channel);
        this.parser = new HttpParser(this, -1, channel.getHttpDestination().getHttpClient().getHttpCompliance());
    }

    @Override // org.eclipse.jetty.client.HttpReceiver
    public HttpChannelOverHTTP getHttpChannel() {
        return (HttpChannelOverHTTP) getHttpChannel();
    }

    private HttpConnectionOverHTTP getHttpConnection() {
        return getHttpChannel().getHttpConnection();
    }

    protected ByteBuffer getResponseBuffer() {
        if (this.networkBuffer == null) {
            return null;
        }
        return this.networkBuffer.getBuffer();
    }

    @Override // org.eclipse.jetty.client.HttpReceiver
    public void receive() {
        if (this.networkBuffer == null) {
            acquireNetworkBuffer();
        }
        process();
    }

    private void acquireNetworkBuffer() {
        this.networkBuffer = newNetworkBuffer();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Acquired {}", this.networkBuffer);
        }
    }

    private void reacquireNetworkBuffer() {
        RetainableByteBuffer currentBuffer = this.networkBuffer;
        if (currentBuffer == null) {
            throw new IllegalStateException();
        } else if (currentBuffer.hasRemaining()) {
            throw new IllegalStateException();
        } else {
            currentBuffer.release();
            this.networkBuffer = newNetworkBuffer();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Reacquired {} <- {}", currentBuffer, this.networkBuffer);
            }
        }
    }

    private RetainableByteBuffer newNetworkBuffer() {
        HttpClient client = getHttpDestination().getHttpClient();
        return new RetainableByteBuffer(client.getByteBufferPool(), client.getResponseBufferSize(), true);
    }

    private void releaseNetworkBuffer() {
        if (this.networkBuffer != null) {
            this.networkBuffer.release();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Released {}", this.networkBuffer);
            }
            this.networkBuffer = null;
        }
    }

    /* access modifiers changed from: protected */
    public ByteBuffer onUpgradeFrom() {
        RetainableByteBuffer networkBuffer = this.networkBuffer;
        if (networkBuffer == null) {
            return null;
        }
        ByteBuffer upgradeBuffer = null;
        if (networkBuffer.hasRemaining()) {
            upgradeBuffer = BufferUtil.allocate(networkBuffer.remaining());
            BufferUtil.clearToFill(upgradeBuffer);
            BufferUtil.put(networkBuffer.getBuffer(), upgradeBuffer);
            BufferUtil.flipToFlush(upgradeBuffer, 0);
        }
        releaseNetworkBuffer();
        return upgradeBuffer;
    }

    private void process() {
        try {
            HttpConnectionOverHTTP connection = getHttpConnection();
            EndPoint endPoint = connection.getEndPoint();
            while (!parse()) {
                if (connection.isClosed()) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Closed {}", connection);
                    }
                    releaseNetworkBuffer();
                    return;
                }
                if (this.networkBuffer.getReferences() > 1) {
                    reacquireNetworkBuffer();
                }
                int read = endPoint.fill(this.networkBuffer.getBuffer());
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Read {} bytes in {} from {}", Integer.valueOf(read), this.networkBuffer, endPoint);
                }
                if (read > 0) {
                    connection.addBytesIn((long) read);
                } else if (read == 0) {
                    releaseNetworkBuffer();
                    fillInterested();
                    return;
                } else {
                    releaseNetworkBuffer();
                    shutdown();
                    return;
                }
            }
        } catch (Throwable x) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(x);
            }
            releaseNetworkBuffer();
            failAndClose(x);
        }
    }

    private boolean parse() {
        boolean complete;
        do {
            boolean handle = this.parser.parseNext(this.networkBuffer.getBuffer());
            boolean failed = isFailed();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Parse result={}, failed={}", Boolean.valueOf(handle), Boolean.valueOf(failed));
            }
            if (failed) {
                this.parser.close();
            }
            if (handle) {
                return !failed;
            }
            complete = this.complete;
            this.complete = false;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Parse complete={}, {} {}", Boolean.valueOf(complete), this.networkBuffer, this.parser);
            }
            if (complete) {
                int status = this.status;
                this.status = 0;
                if (status == 101) {
                    return true;
                }
                String method = this.method;
                this.method = null;
                if (getHttpChannel().isTunnel(method, status)) {
                    return true;
                }
            }
            if (this.networkBuffer.isEmpty()) {
                return false;
            }
        } while (!complete);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Discarding unexpected content after response: {}", this.networkBuffer);
        }
        this.networkBuffer.clear();
        return false;
    }

    protected void fillInterested() {
        getHttpConnection().fillInterested();
    }

    private void shutdown() {
        this.shutdown = true;
        this.parser.atEOF();
        this.parser.parseNext(BufferUtil.EMPTY_BUFFER);
    }

    /* access modifiers changed from: protected */
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public int getHeaderCacheSize() {
        return ((HttpClientTransportOverHTTP) getHttpDestination().getHttpClient().getTransport()).getHeaderCacheSize();
    }

    @Override // org.eclipse.jetty.http.HttpParser.ResponseHandler
    public boolean startResponse(HttpVersion version, int status, String reason) {
        HttpExchange exchange = getHttpExchange();
        this.unsolicited = exchange == null;
        if (exchange == null) {
            return false;
        }
        this.method = exchange.getRequest().getMethod();
        this.status = status;
        this.parser.setHeadResponse(HttpMethod.HEAD.m40is(this.method) || getHttpChannel().isTunnel(this.method, status));
        exchange.getResponse().version(version).status(status).reason(reason);
        return !responseBegin(exchange);
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void parsedHeader(HttpField field) {
        HttpExchange exchange = getHttpExchange();
        this.unsolicited |= exchange == null;
        if (!this.unsolicited) {
            responseHeader(exchange, field);
        }
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean headerComplete() {
        HttpExchange exchange = getHttpExchange();
        this.unsolicited |= exchange == null;
        return !this.unsolicited && !responseHeaders(exchange);
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean content(ByteBuffer buffer) {
        HttpExchange exchange = getHttpExchange();
        this.unsolicited |= exchange == null;
        if (this.unsolicited) {
            return false;
        }
        RetainableByteBuffer networkBuffer = this.networkBuffer;
        networkBuffer.retain();
        Objects.requireNonNull(networkBuffer);
        return !responseContent(exchange, buffer, Callback.from(this::release, failure -> {
            networkBuffer.release();
            failAndClose(networkBuffer);
        }));
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean contentComplete() {
        return false;
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void parsedTrailer(HttpField trailer) {
        HttpExchange exchange = getHttpExchange();
        this.unsolicited |= exchange == null;
        if (!this.unsolicited) {
            exchange.getResponse().trailer(trailer);
        }
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public boolean messageComplete() {
        HttpExchange exchange = getHttpExchange();
        if (exchange == null || this.unsolicited) {
            getHttpConnection().close();
            return false;
        }
        if (exchange.getResponse().getStatus() != 100) {
            this.inMessages.increment();
            this.complete = true;
        }
        return !responseSuccess(exchange);
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void earlyEOF() {
        HttpExchange exchange = getHttpExchange();
        HttpConnectionOverHTTP connection = getHttpConnection();
        if (exchange == null || this.unsolicited) {
            connection.close();
        } else {
            failAndClose(new EOFException(String.valueOf(connection)));
        }
    }

    @Override // org.eclipse.jetty.http.HttpParser.HttpHandler
    public void badMessage(BadMessageException failure) {
        HttpExchange exchange = getHttpExchange();
        if (exchange == null || this.unsolicited) {
            getHttpConnection().close();
            return;
        }
        HttpResponse response = exchange.getResponse();
        response.status(failure.getCode()).reason(failure.getReason());
        failAndClose(new HttpResponseException("HTTP protocol violation: bad response on " + getHttpConnection(), response, failure));
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.client.HttpReceiver
    public void reset() {
        reset();
        this.parser.reset();
    }

    private void failAndClose(Throwable failure) {
        if (responseFailure(failure)) {
            getHttpConnection().close(failure);
        }
    }

    /* access modifiers changed from: package-private */
    public long getMessagesIn() {
        return this.inMessages.longValue();
    }

    @Override // org.eclipse.jetty.client.HttpReceiver
    public String toString() {
        return String.format("%s[%s]", toString(), this.parser);
    }
}
