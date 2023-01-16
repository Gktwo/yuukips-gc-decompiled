package org.eclipse.jetty.client;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.client.ProxyConfiguration;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.client.api.AuthenticationStore;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.p023io.CyclicTimeouts;
import org.eclipse.jetty.util.Attachable;
import org.eclipse.jetty.util.HttpCookieStore;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpConnection.class */
public abstract class HttpConnection implements Connection, Attachable {
    private static final Logger LOG = Log.getLogger(HttpConnection.class);
    private final HttpDestination destination;
    private final RequestTimeouts requestTimeouts;
    private Object attachment;
    private int idleTimeoutGuard;
    private long idleTimeoutStamp = System.nanoTime();

    protected abstract Iterator<HttpChannel> getHttpChannels();

    protected abstract SendFailure send(HttpExchange httpExchange);

    /* access modifiers changed from: protected */
    public HttpConnection(HttpDestination destination) {
        this.destination = destination;
        this.requestTimeouts = new RequestTimeouts(destination.getHttpClient().getScheduler());
    }

    public HttpClient getHttpClient() {
        return this.destination.getHttpClient();
    }

    public HttpDestination getHttpDestination() {
        return this.destination;
    }

    @Override // org.eclipse.jetty.client.api.Connection
    public void send(Request request, Response.CompleteListener listener) {
        HttpRequest httpRequest = (HttpRequest) request;
        ArrayList<Response.ResponseListener> listeners = new ArrayList<>(httpRequest.getResponseListeners());
        httpRequest.sent();
        if (listener != null) {
            listeners.add(listener);
        }
        SendFailure result = send(new HttpExchange(getHttpDestination(), httpRequest, listeners));
        if (result != null) {
            httpRequest.abort(result.failure);
        }
    }

    protected void normalizeRequest(Request request) {
        URI uri;
        URI uri2;
        boolean normalized = ((HttpRequest) request).normalized();
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(!normalized);
            objArr[1] = request;
            logger.debug("Normalizing {} {}", objArr);
        }
        if (!normalized) {
            HttpVersion version = request.getVersion();
            HttpFields headers = request.getHeaders();
            ContentProvider content = request.getContent();
            ProxyConfiguration.Proxy proxy = this.destination.getProxy();
            if (request.getPath().trim().length() == 0) {
                request.path("/");
            }
            if ((proxy instanceof HttpProxy) && !HttpClient.isSchemeSecure(request.getScheme()) && (uri2 = request.getURI()) != null) {
                request.path(uri2.toString());
            }
            if (version.getVersion() <= 11 && !headers.containsKey(HttpHeader.HOST.asString())) {
                URI uri3 = request.getURI();
                if (uri3 != null) {
                    headers.put(HttpHeader.HOST, uri3.getAuthority());
                } else {
                    headers.put(getHttpDestination().getHostField());
                }
            }
            if (content != null) {
                if (!headers.containsKey(HttpHeader.CONTENT_TYPE.asString())) {
                    String contentType = null;
                    if (content instanceof ContentProvider.Typed) {
                        contentType = ((ContentProvider.Typed) content).getContentType();
                    }
                    if (contentType != null) {
                        headers.put(HttpHeader.CONTENT_TYPE, contentType);
                    } else {
                        String contentType2 = getHttpClient().getDefaultRequestContentType();
                        if (contentType2 != null) {
                            headers.put(HttpHeader.CONTENT_TYPE, contentType2);
                        }
                    }
                }
                long contentLength = content.getLength();
                if (contentLength >= 0 && !headers.containsKey(HttpHeader.CONTENT_LENGTH.asString())) {
                    headers.put(HttpHeader.CONTENT_LENGTH, String.valueOf(contentLength));
                }
            }
            StringBuilder cookies = convertCookies(request.getCookies(), null);
            CookieStore cookieStore = getHttpClient().getCookieStore();
            if (!(cookieStore == null || cookieStore.getClass() == HttpCookieStore.Empty.class || (uri = request.getURI()) == null)) {
                cookies = convertCookies(HttpCookieStore.matchPath(uri, cookieStore.get(uri)), cookies);
            }
            if (cookies != null) {
                request.header(HttpHeader.COOKIE.asString(), cookies.toString());
            }
            applyProxyAuthentication(request, proxy);
            applyRequestAuthentication(request);
        }
    }

    private StringBuilder convertCookies(List<HttpCookie> cookies, StringBuilder builder) {
        for (HttpCookie cookie : cookies) {
            if (builder == null) {
                builder = new StringBuilder();
            }
            if (builder.length() > 0) {
                builder.append("; ");
            }
            builder.append(cookie.getName()).append("=").append(cookie.getValue());
        }
        return builder;
    }

    private void applyRequestAuthentication(Request request) {
        URI uri;
        Authentication.Result result;
        AuthenticationStore authenticationStore = getHttpClient().getAuthenticationStore();
        if (authenticationStore.hasAuthenticationResults() && (uri = request.getURI()) != null && (result = authenticationStore.findAuthenticationResult(uri)) != null) {
            result.apply(request);
        }
    }

    private void applyProxyAuthentication(Request request, ProxyConfiguration.Proxy proxy) {
        Authentication.Result result;
        if (proxy != null && (result = getHttpClient().getAuthenticationStore().findAuthenticationResult(proxy.getURI())) != null) {
            result.apply(request);
        }
    }

    protected SendFailure send(HttpChannel channel, HttpExchange exchange) {
        boolean send;
        SendFailure result;
        synchronized (this) {
            send = this.idleTimeoutGuard >= 0;
            if (send) {
                this.idleTimeoutGuard++;
            }
        }
        if (!send) {
            return new SendFailure(new TimeoutException(), true);
        }
        HttpRequest request = exchange.getRequest();
        if (channel.associate(exchange)) {
            this.requestTimeouts.schedule((RequestTimeouts) channel);
            channel.send();
            result = null;
        } else {
            channel.release();
            result = new SendFailure(new HttpRequestException("Could not associate request to connection", request), false);
        }
        synchronized (this) {
            this.idleTimeoutGuard--;
            this.idleTimeoutStamp = System.nanoTime();
        }
        return result;
    }

    public boolean onIdleTimeout(long idleTimeout) {
        synchronized (this) {
            if (this.idleTimeoutGuard == 0) {
                long elapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.idleTimeoutStamp);
                boolean idle = elapsed > idleTimeout / 2;
                if (idle) {
                    this.idleTimeoutGuard = -1;
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Idle timeout {}/{}ms - {}", Long.valueOf(elapsed), Long.valueOf(idleTimeout), this);
                }
                return idle;
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Idle timeout skipped - {}", this);
            }
            return false;
        }
    }

    @Override // org.eclipse.jetty.util.Attachable
    public void setAttachment(Object obj) {
        this.attachment = obj;
    }

    @Override // org.eclipse.jetty.util.Attachable
    public Object getAttachment() {
        return this.attachment;
    }

    protected void destroy() {
        this.requestTimeouts.destroy();
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("%s@%h", getClass().getSimpleName(), this);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpConnection$RequestTimeouts.class */
    private class RequestTimeouts extends CyclicTimeouts<HttpChannel> {
        private RequestTimeouts(Scheduler scheduler) {
            super(scheduler);
        }

        @Override // org.eclipse.jetty.p023io.CyclicTimeouts
        protected Iterator<HttpChannel> iterator() {
            return HttpConnection.this.getHttpChannels();
        }

        /* access modifiers changed from: protected */
        public boolean onExpired(HttpChannel channel) {
            HttpExchange exchange = channel.getHttpExchange();
            if (exchange == null) {
                return false;
            }
            HttpRequest request = exchange.getRequest();
            request.abort(new TimeoutException("Total timeout " + request.getConversation().getTimeout() + " ms elapsed"));
            return false;
        }
    }
}
