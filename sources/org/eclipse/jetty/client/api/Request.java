package org.eclipse.jetty.client.api;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.EventListener;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.util.Fields;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request.class */
public interface Request {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$BeginListener.class */
    public interface BeginListener extends RequestListener {
        void onBegin(Request request);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$CommitListener.class */
    public interface CommitListener extends RequestListener {
        void onCommit(Request request);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$ContentListener.class */
    public interface ContentListener extends RequestListener {
        void onContent(Request request, ByteBuffer byteBuffer);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$FailureListener.class */
    public interface FailureListener extends RequestListener {
        void onFailure(Request request, Throwable th);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$HeadersListener.class */
    public interface HeadersListener extends RequestListener {
        void onHeaders(Request request);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$QueuedListener.class */
    public interface QueuedListener extends RequestListener {
        void onQueued(Request request);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$RequestListener.class */
    public interface RequestListener extends EventListener {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$SuccessListener.class */
    public interface SuccessListener extends RequestListener {
        void onSuccess(Request request);
    }

    String getScheme();

    Request scheme(String str);

    String getHost();

    int getPort();

    String getMethod();

    Request method(HttpMethod httpMethod);

    Request method(String str);

    String getPath();

    Request path(String str);

    String getQuery();

    URI getURI();

    HttpVersion getVersion();

    Request version(HttpVersion httpVersion);

    Fields getParams();

    Request param(String str, String str2);

    HttpFields getHeaders();

    Request header(String str, String str2);

    Request header(HttpHeader httpHeader, String str);

    List<HttpCookie> getCookies();

    Request cookie(HttpCookie httpCookie);

    Request tag(Object obj);

    Object getTag();

    Request attribute(String str, Object obj);

    Map<String, Object> getAttributes();

    ContentProvider getContent();

    Request content(ContentProvider contentProvider);

    Request content(ContentProvider contentProvider, String str);

    Request file(Path path) throws IOException;

    Request file(Path path, String str) throws IOException;

    String getAgent();

    Request agent(String str);

    Request accept(String... strArr);

    long getIdleTimeout();

    Request idleTimeout(long j, TimeUnit timeUnit);

    long getTimeout();

    Request timeout(long j, TimeUnit timeUnit);

    boolean isFollowRedirects();

    Request followRedirects(boolean z);

    <T extends RequestListener> List<T> getRequestListeners(Class<T> cls);

    Request listener(Listener listener);

    Request onRequestQueued(QueuedListener queuedListener);

    Request onRequestBegin(BeginListener beginListener);

    Request onRequestHeaders(HeadersListener headersListener);

    Request onRequestCommit(CommitListener commitListener);

    Request onRequestContent(ContentListener contentListener);

    Request onRequestSuccess(SuccessListener successListener);

    Request onRequestFailure(FailureListener failureListener);

    Request onResponseBegin(Response.BeginListener beginListener);

    Request onResponseHeader(Response.HeaderListener headerListener);

    Request onResponseHeaders(Response.HeadersListener headersListener);

    Request onResponseContent(Response.ContentListener contentListener);

    Request onResponseContentAsync(Response.AsyncContentListener asyncContentListener);

    Request onResponseContentDemanded(Response.DemandedContentListener demandedContentListener);

    Request onResponseSuccess(Response.SuccessListener successListener);

    Request onResponseFailure(Response.FailureListener failureListener);

    Request onComplete(Response.CompleteListener completeListener);

    ContentResponse send() throws InterruptedException, TimeoutException, ExecutionException;

    void send(Response.CompleteListener completeListener);

    boolean abort(Throwable th);

    Throwable getAbortCause();

    default Request host(String host) {
        return this;
    }

    default Request port(int port) {
        return this;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$Listener.class */
    public interface Listener extends QueuedListener, BeginListener, HeadersListener, CommitListener, ContentListener, SuccessListener, FailureListener {

        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Request$Listener$Adapter.class */
        public static class Adapter implements Listener {
        }

        @Override // org.eclipse.jetty.client.api.Request.QueuedListener
        default void onQueued(Request request) {
        }

        @Override // org.eclipse.jetty.client.api.Request.BeginListener
        default void onBegin(Request request) {
        }

        @Override // org.eclipse.jetty.client.api.Request.HeadersListener
        default void onHeaders(Request request) {
        }

        @Override // org.eclipse.jetty.client.api.Request.CommitListener
        default void onCommit(Request request) {
        }

        @Override // org.eclipse.jetty.client.api.Request.ContentListener
        default void onContent(Request request, ByteBuffer content) {
        }

        @Override // org.eclipse.jetty.client.api.Request.SuccessListener
        default void onSuccess(Request request) {
        }

        @Override // org.eclipse.jetty.client.api.Request.FailureListener
        default void onFailure(Request request, Throwable failure) {
        }
    }
}
