package org.eclipse.jetty.client;

import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.p023io.CyclicTimeouts;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpChannel.class */
public abstract class HttpChannel implements CyclicTimeouts.Expirable {
    protected static final Logger LOG = Log.getLogger(HttpChannel.class);
    private final HttpDestination _destination;
    private HttpExchange _exchange;

    protected abstract HttpSender getHttpSender();

    protected abstract HttpReceiver getHttpReceiver();

    public abstract void send(HttpExchange httpExchange);

    public abstract void release();

    /* access modifiers changed from: protected */
    public HttpChannel(HttpDestination destination) {
        this._destination = destination;
    }

    public void destroy() {
    }

    public HttpDestination getHttpDestination() {
        return this._destination;
    }

    public boolean associate(HttpExchange exchange) {
        boolean result = false;
        boolean abort = true;
        synchronized (this) {
            if (this._exchange == null) {
                abort = false;
                result = exchange.associate(this);
                if (result) {
                    this._exchange = exchange;
                }
            }
        }
        if (abort) {
            exchange.getRequest().abort(new UnsupportedOperationException("Pipelined requests not supported"));
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("{} associated {} to {}", exchange, Boolean.valueOf(result), this);
        }
        return result;
    }

    public boolean disassociate(HttpExchange exchange) {
        boolean result = false;
        synchronized (this) {
            HttpExchange existing = this._exchange;
            this._exchange = null;
            if (existing == exchange) {
                existing.disassociate(this);
                result = true;
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} disassociated {} from {}", exchange, Boolean.valueOf(result), this);
        }
        return result;
    }

    public HttpExchange getHttpExchange() {
        HttpExchange httpExchange;
        synchronized (this) {
            httpExchange = this._exchange;
        }
        return httpExchange;
    }

    @Override // org.eclipse.jetty.p023io.CyclicTimeouts.Expirable
    public long getExpireNanoTime() {
        HttpExchange exchange = getHttpExchange();
        return exchange != null ? exchange.getExpireNanoTime() : LongCompanionObject.MAX_VALUE;
    }

    public void send() {
        HttpExchange exchange = getHttpExchange();
        if (exchange != null) {
            send(exchange);
        }
    }

    public void proceed(HttpExchange exchange, Throwable failure) {
        getHttpSender().proceed(exchange, failure);
    }

    public boolean abort(HttpExchange exchange, Throwable requestFailure, Throwable responseFailure) {
        boolean requestAborted = false;
        if (requestFailure != null) {
            requestAborted = getHttpSender().abort(exchange, requestFailure);
        }
        boolean responseAborted = false;
        if (responseFailure != null) {
            responseAborted = abortResponse(exchange, responseFailure);
        }
        return requestAborted || responseAborted;
    }

    public boolean abortResponse(HttpExchange exchange, Throwable failure) {
        return getHttpReceiver().abort(exchange, failure);
    }

    public Result exchangeTerminating(HttpExchange exchange, Result result) {
        return result;
    }

    public void exchangeTerminated(HttpExchange exchange, Result result) {
        disassociate(exchange);
    }

    public String toString() {
        return String.format("%s@%x(exchange=%s)", getClass().getSimpleName(), Integer.valueOf(hashCode()), getHttpExchange());
    }
}
