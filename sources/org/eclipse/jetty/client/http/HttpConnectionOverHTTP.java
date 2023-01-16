package org.eclipse.jetty.client.http;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.client.HttpChannel;
import org.eclipse.jetty.client.HttpConnection;
import org.eclipse.jetty.client.HttpDestination;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.client.SendFailure;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.Attachable;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Sweeper;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpConnectionOverHTTP.class */
public class HttpConnectionOverHTTP extends AbstractConnection implements Connection, Connection.UpgradeFrom, Sweeper.Sweepable, Attachable {
    private static final Logger LOG = Log.getLogger(HttpConnectionOverHTTP.class);
    private final Promise<org.eclipse.jetty.client.api.Connection> promise;
    private final Delegate delegate;
    private long idleTimeout;
    private final AtomicBoolean closed = new AtomicBoolean();
    private final AtomicInteger sweeps = new AtomicInteger();
    private final LongAdder bytesIn = new LongAdder();
    private final LongAdder bytesOut = new LongAdder();
    private final HttpChannelOverHTTP channel = newHttpChannel();

    public HttpConnectionOverHTTP(EndPoint endPoint, HttpDestination destination, Promise<org.eclipse.jetty.client.api.Connection> promise) {
        super(endPoint, destination.getHttpClient().getExecutor());
        this.promise = promise;
        this.delegate = new Delegate(destination);
    }

    protected HttpChannelOverHTTP newHttpChannel() {
        return new HttpChannelOverHTTP(this);
    }

    public HttpChannelOverHTTP getHttpChannel() {
        return this.channel;
    }

    public HttpDestinationOverHTTP getHttpDestination() {
        return (HttpDestinationOverHTTP) this.delegate.getHttpDestination();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getBytesIn() {
        return this.bytesIn.longValue();
    }

    /* access modifiers changed from: protected */
    public void addBytesIn(long bytesIn) {
        this.bytesIn.add(bytesIn);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getBytesOut() {
        return this.bytesOut.longValue();
    }

    /* access modifiers changed from: protected */
    public void addBytesOut(long bytesOut) {
        this.bytesOut.add(bytesOut);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getMessagesIn() {
        return getHttpChannel().getMessagesIn();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getMessagesOut() {
        return getHttpChannel().getMessagesOut();
    }

    @Override // org.eclipse.jetty.client.api.Connection
    public void send(Request request, Response.CompleteListener listener) {
        this.delegate.send(request, listener);
    }

    /* access modifiers changed from: protected */
    public SendFailure send(HttpExchange exchange) {
        return this.delegate.send(exchange);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public void onOpen() {
        onOpen();
        fillInterested();
        this.promise.succeeded(this);
    }

    @Override // org.eclipse.jetty.client.api.Connection
    public boolean isClosed() {
        return this.closed.get();
    }

    @Override // org.eclipse.jetty.util.Attachable
    public void setAttachment(Object obj) {
        this.delegate.setAttachment(obj);
    }

    @Override // org.eclipse.jetty.util.Attachable
    public Object getAttachment() {
        return this.delegate.getAttachment();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public boolean onIdleExpired() {
        long idleTimeout = getEndPoint().getIdleTimeout();
        if (!onIdleTimeout(idleTimeout)) {
            return false;
        }
        close(new TimeoutException("Idle timeout " + idleTimeout + " ms"));
        return false;
    }

    protected boolean onIdleTimeout(long idleTimeout) {
        return this.delegate.onIdleTimeout(idleTimeout);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillable() {
        this.channel.receive();
    }

    @Override // org.eclipse.jetty.p023io.Connection.UpgradeFrom
    public ByteBuffer onUpgradeFrom() {
        return this.channel.getHttpReceiver().onUpgradeFrom();
    }

    public void release() {
        getEndPoint().setIdleTimeout(this.idleTimeout);
        getHttpDestination().release(this);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection, java.io.Closeable, java.lang.AutoCloseable, org.eclipse.jetty.client.api.Connection
    public void close() {
        close(new AsynchronousCloseException());
    }

    /* access modifiers changed from: protected */
    public void close(Throwable failure) {
        if (this.closed.compareAndSet(false, true)) {
            getHttpDestination().remove(this);
            abort(failure);
            this.channel.destroy();
            getEndPoint().shutdownOutput();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Shutdown {}", this);
            }
            getEndPoint().close();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Closed {}", this);
            }
        }
    }

    protected boolean abort(Throwable failure) {
        HttpExchange exchange = this.channel.getHttpExchange();
        return exchange != null && exchange.getRequest().abort(failure);
    }

    @Override // org.eclipse.jetty.util.thread.Sweeper.Sweepable
    public boolean sweep() {
        return this.closed.get() && this.sweeps.incrementAndGet() >= 4;
    }

    public void remove() {
        getHttpDestination().remove(this);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public String toConnectionString() {
        return String.format("%s@%x(l:%s <-> r:%s,closed=%b)=>%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), getEndPoint().getLocalAddress(), getEndPoint().getRemoteAddress(), Boolean.valueOf(this.closed.get()), this.channel);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpConnectionOverHTTP$Delegate.class */
    public class Delegate extends HttpConnection {
        private Delegate(HttpDestination destination) {
            super(destination);
        }

        @Override // org.eclipse.jetty.client.HttpConnection
        protected Iterator<HttpChannel> getHttpChannels() {
            return Collections.singleton(HttpConnectionOverHTTP.this.channel).iterator();
        }

        @Override // org.eclipse.jetty.client.HttpConnection
        protected SendFailure send(HttpExchange exchange) {
            Request request = exchange.getRequest();
            normalizeRequest(request);
            EndPoint endPoint = HttpConnectionOverHTTP.this.getEndPoint();
            HttpConnectionOverHTTP.this.idleTimeout = endPoint.getIdleTimeout();
            long requestIdleTimeout = request.getIdleTimeout();
            if (requestIdleTimeout >= 0) {
                endPoint.setIdleTimeout(requestIdleTimeout);
            }
            return send(HttpConnectionOverHTTP.this.channel, exchange);
        }

        @Override // org.eclipse.jetty.client.api.Connection, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            HttpConnectionOverHTTP.this.close();
            destroy();
        }

        @Override // org.eclipse.jetty.client.api.Connection
        public boolean isClosed() {
            return HttpConnectionOverHTTP.this.isClosed();
        }

        @Override // org.eclipse.jetty.client.HttpConnection, java.lang.Object
        public String toString() {
            return HttpConnectionOverHTTP.this.toString();
        }
    }
}
