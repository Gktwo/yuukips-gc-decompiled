package org.eclipse.jetty.client;

import java.util.List;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.p023io.CyclicTimeouts;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpExchange.class */
public class HttpExchange implements CyclicTimeouts.Expirable {
    private static final Logger LOG = Log.getLogger(HttpExchange.class);
    private final HttpDestination destination;
    private final HttpRequest request;
    private final List<Response.ResponseListener> listeners;
    private final HttpResponse response;
    private State requestState = State.PENDING;
    private State responseState = State.PENDING;
    private HttpChannel _channel;
    private Throwable requestFailure;
    private Throwable responseFailure;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpExchange$State.class */
    public enum State {
        PENDING,
        COMPLETED,
        TERMINATED
    }

    public HttpExchange(HttpDestination destination, HttpRequest request, List<Response.ResponseListener> listeners) {
        this.destination = destination;
        this.request = request;
        this.listeners = listeners;
        this.response = new HttpResponse(request, listeners);
        HttpConversation conversation = request.getConversation();
        conversation.getExchanges().offer(this);
        conversation.updateResponseListeners(null);
    }

    public HttpConversation getConversation() {
        return this.request.getConversation();
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public Throwable getRequestFailure() {
        Throwable th;
        synchronized (this) {
            th = this.requestFailure;
        }
        return th;
    }

    public List<Response.ResponseListener> getResponseListeners() {
        return this.listeners;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public Throwable getResponseFailure() {
        Throwable th;
        synchronized (this) {
            th = this.responseFailure;
        }
        return th;
    }

    @Override // org.eclipse.jetty.p023io.CyclicTimeouts.Expirable
    public long getExpireNanoTime() {
        return this.request.getTimeoutAt();
    }

    /* access modifiers changed from: package-private */
    public boolean associate(HttpChannel channel) {
        boolean result = false;
        boolean abort = false;
        synchronized (this) {
            if (this.requestState == State.PENDING && this.responseState == State.PENDING) {
                abort = this._channel != null;
                if (!abort) {
                    this._channel = channel;
                    result = true;
                }
            }
        }
        if (abort) {
            this.request.abort(new IllegalStateException(toString()));
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public void disassociate(HttpChannel channel) {
        boolean abort = false;
        synchronized (this) {
            if (!(this._channel == channel && this.requestState == State.TERMINATED && this.responseState == State.TERMINATED)) {
                abort = true;
            }
            this._channel = null;
        }
        if (abort) {
            this.request.abort(new IllegalStateException(toString()));
        }
    }

    private HttpChannel getHttpChannel() {
        HttpChannel httpChannel;
        synchronized (this) {
            httpChannel = this._channel;
        }
        return httpChannel;
    }

    public boolean requestComplete(Throwable failure) {
        boolean completeRequest;
        synchronized (this) {
            completeRequest = completeRequest(failure);
        }
        return completeRequest;
    }

    private boolean completeRequest(Throwable failure) {
        if (this.requestState != State.PENDING) {
            return false;
        }
        this.requestState = State.COMPLETED;
        this.requestFailure = failure;
        return true;
    }

    public boolean responseComplete(Throwable failure) {
        boolean completeResponse;
        synchronized (this) {
            completeResponse = completeResponse(failure);
        }
        return completeResponse;
    }

    private boolean completeResponse(Throwable failure) {
        if (this.responseState != State.PENDING) {
            return false;
        }
        this.responseState = State.COMPLETED;
        this.responseFailure = failure;
        return true;
    }

    public Result terminateRequest() {
        Result result = null;
        synchronized (this) {
            if (this.requestState == State.COMPLETED) {
                this.requestState = State.TERMINATED;
            }
            if (this.requestState == State.TERMINATED && this.responseState == State.TERMINATED) {
                result = new Result(getRequest(), this.requestFailure, getResponse(), this.responseFailure);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Terminated request for {}, result: {}", this, result);
        }
        return result;
    }

    public Result terminateResponse() {
        Result result = null;
        synchronized (this) {
            if (this.responseState == State.COMPLETED) {
                this.responseState = State.TERMINATED;
            }
            if (this.requestState == State.TERMINATED && this.responseState == State.TERMINATED) {
                result = new Result(getRequest(), this.requestFailure, getResponse(), this.responseFailure);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Terminated response for {}, result: {}", this, result);
        }
        return result;
    }

    public boolean abort(Throwable failure) {
        boolean abortRequest;
        boolean abortResponse;
        synchronized (this) {
            abortRequest = completeRequest(failure);
            abortResponse = completeResponse(failure);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Failed {}: req={}/rsp={} {}", this, Boolean.valueOf(abortRequest), Boolean.valueOf(abortResponse), failure);
        }
        if (!abortRequest && !abortResponse) {
            return false;
        }
        if (this.destination.remove(this)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Aborting while queued {}: {}", this, failure);
            }
            notifyFailureComplete(failure);
            return true;
        }
        HttpChannel channel = getHttpChannel();
        if (channel == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Aborted before association {}: {}", this, failure);
            }
            notifyFailureComplete(failure);
            return true;
        }
        boolean aborted = channel.abort(this, abortRequest ? failure : null, abortResponse ? failure : null);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Aborted ({}) while active {}: {}", Boolean.valueOf(aborted), this, failure);
        }
        return aborted;
    }

    private void notifyFailureComplete(Throwable failure) {
        this.destination.getRequestNotifier().notifyFailure(this.request, failure);
        List<Response.ResponseListener> listeners = getConversation().getResponseListeners();
        ResponseNotifier responseNotifier = this.destination.getResponseNotifier();
        responseNotifier.notifyFailure(listeners, this.response, failure);
        responseNotifier.notifyComplete(listeners, new Result(this.request, failure, this.response, failure));
    }

    public void resetResponse() {
        synchronized (this) {
            this.responseState = State.PENDING;
            this.responseFailure = null;
        }
    }

    public void proceed(Throwable failure) {
        HttpChannel channel = getHttpChannel();
        if (channel != null) {
            channel.proceed(this, failure);
        }
    }

    public String toString() {
        String format;
        synchronized (this) {
            format = String.format("%s@%x{req=%s[%s/%s] res=%s[%s/%s]}", HttpExchange.class.getSimpleName(), Integer.valueOf(hashCode()), this.request, this.requestState, this.requestFailure, this.response, this.responseState, this.responseFailure);
        }
        return format;
    }
}
