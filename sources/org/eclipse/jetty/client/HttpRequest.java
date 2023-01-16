package org.eclipse.jetty.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.LongConsumer;
import java.util.function.Supplier;
import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.FutureResponseListener;
import org.eclipse.jetty.client.util.PathContentProvider;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Fields;
import org.eclipse.jetty.util.StringUtil;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpRequest.class */
public class HttpRequest implements Request {
    private static final URI NULL_URI = URI.create("null:0");
    private final HttpClient client;
    private final HttpConversation conversation;
    private String scheme;
    private String host;
    private int port;
    private String path;
    private String query;
    private URI uri;
    private long timeout;
    private ContentProvider content;
    private boolean followRedirects;
    private List<HttpCookie> cookies;
    private Map<String, Object> attributes;
    private List<Request.RequestListener> requestListeners;
    private BiFunction<Request, Request, Response.CompleteListener> pushListener;
    private Supplier<HttpFields> trailers;
    private Object tag;
    private boolean normalized;
    private final HttpFields headers = new HttpFields();
    private final Fields params = new Fields(true);
    private final List<Response.ResponseListener> responseListeners = new ArrayList();
    private final AtomicReference<Throwable> aborted = new AtomicReference<>();
    private String method = HttpMethod.GET.asString();
    private HttpVersion version = HttpVersion.HTTP_1_1;
    private long idleTimeout = -1;
    private long timeoutAt = LongCompanionObject.MAX_VALUE;

    /* access modifiers changed from: protected */
    public HttpRequest(HttpClient client, HttpConversation conversation, URI uri) {
        this.client = client;
        this.conversation = conversation;
        this.scheme = uri.getScheme();
        this.host = uri.getHost();
        this.port = HttpClient.normalizePort(this.scheme, uri.getPort());
        this.path = uri.getRawPath();
        this.query = uri.getRawQuery();
        extractParams(this.query);
        followRedirects(client.isFollowRedirects());
        HttpField acceptEncodingField = client.getAcceptEncodingField();
        if (acceptEncodingField != null) {
            this.headers.put(acceptEncodingField);
        }
        HttpField userAgentField = client.getUserAgentField();
        if (userAgentField != null) {
            this.headers.put(userAgentField);
        }
    }

    public HttpConversation getConversation() {
        return this.conversation;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public String getScheme() {
        return this.scheme;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request scheme(String scheme) {
        this.scheme = scheme;
        this.uri = null;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public String getHost() {
        return this.host;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request host(String host) {
        this.host = host;
        this.uri = null;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public int getPort() {
        return this.port;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request port(int port) {
        this.port = port;
        this.uri = null;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public String getMethod() {
        return this.method;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request method(HttpMethod method) {
        return method(method.asString());
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request method(String method) {
        this.method = ((String) Objects.requireNonNull(method)).toUpperCase(Locale.ENGLISH);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public String getPath() {
        return this.path;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request path(String path) {
        URI uri = newURI(path);
        if (uri == null) {
            this.path = path;
            this.query = null;
        } else {
            String rawPath = uri.getRawPath();
            if (rawPath == null) {
                rawPath = "";
            }
            if (!rawPath.startsWith("/")) {
                rawPath = "/" + rawPath;
            }
            this.path = rawPath;
            String query = uri.getRawQuery();
            if (query != null) {
                this.query = query;
                this.params.clear();
                extractParams(query);
            }
            if (uri.isAbsolute()) {
                this.path = buildURI(false).toString();
            }
        }
        this.uri = null;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public String getQuery() {
        return this.query;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public URI getURI() {
        if (this.uri == null) {
            this.uri = buildURI(true);
        }
        if (this.uri == NULL_URI) {
            return null;
        }
        return this.uri;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public HttpVersion getVersion() {
        return this.version;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request version(HttpVersion version) {
        this.version = (HttpVersion) Objects.requireNonNull(version);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request param(String name, String value) {
        return param(name, value, false);
    }

    private Request param(String name, String value, boolean fromQuery) {
        this.params.add(name, value);
        if (!fromQuery) {
            if (this.query != null) {
                this.query += "&" + urlEncode(name) + "=" + urlEncode(value);
            } else {
                this.query = buildQuery();
            }
            this.uri = null;
        }
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Fields getParams() {
        return new Fields(this.params, true);
    }

    @Override // org.eclipse.jetty.client.api.Request
    public String getAgent() {
        return this.headers.get(HttpHeader.USER_AGENT);
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request agent(String agent) {
        this.headers.put(HttpHeader.USER_AGENT, agent);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request accept(String... accepts) {
        StringBuilder result = new StringBuilder();
        for (String accept : accepts) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(accept);
        }
        if (result.length() > 0) {
            this.headers.put(HttpHeader.ACCEPT, result.toString());
        }
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request header(String name, String value) {
        if (value == null) {
            this.headers.remove(name);
        } else {
            this.headers.add(name, value);
        }
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request header(HttpHeader header, String value) {
        if (value == null) {
            this.headers.remove(header);
        } else {
            this.headers.add(header, value);
        }
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public List<HttpCookie> getCookies() {
        return this.cookies != null ? this.cookies : Collections.emptyList();
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request cookie(HttpCookie cookie) {
        if (this.cookies == null) {
            this.cookies = new ArrayList();
        }
        this.cookies.add(cookie);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request tag(Object tag) {
        this.tag = tag;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Object getTag() {
        return this.tag;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request attribute(String name, Object value) {
        if (this.attributes == null) {
            this.attributes = new HashMap(4);
        }
        this.attributes.put(name, value);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Map<String, Object> getAttributes() {
        return this.attributes != null ? this.attributes : Collections.emptyMap();
    }

    @Override // org.eclipse.jetty.client.api.Request
    public HttpFields getHeaders() {
        return this.headers;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public <T extends Request.RequestListener> List<T> getRequestListeners(Class<T> type) {
        if (type == null || this.requestListeners == null) {
            return this.requestListeners != null ? (List<T>) this.requestListeners : Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Request.RequestListener listener : this.requestListeners) {
            if (type.isInstance(listener)) {
                arrayList.add(listener);
            }
        }
        return arrayList;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request listener(Request.Listener listener) {
        return requestListener(listener);
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onRequestQueued(final Request.QueuedListener listener) {
        return requestListener(new Request.QueuedListener() { // from class: org.eclipse.jetty.client.HttpRequest.1
            @Override // org.eclipse.jetty.client.api.Request.QueuedListener
            public void onQueued(Request request) {
                listener.onQueued(request);
            }
        });
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onRequestBegin(final Request.BeginListener listener) {
        return requestListener(new Request.BeginListener() { // from class: org.eclipse.jetty.client.HttpRequest.2
            @Override // org.eclipse.jetty.client.api.Request.BeginListener
            public void onBegin(Request request) {
                listener.onBegin(request);
            }
        });
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onRequestHeaders(final Request.HeadersListener listener) {
        return requestListener(new Request.HeadersListener() { // from class: org.eclipse.jetty.client.HttpRequest.3
            @Override // org.eclipse.jetty.client.api.Request.HeadersListener
            public void onHeaders(Request request) {
                listener.onHeaders(request);
            }
        });
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onRequestCommit(final Request.CommitListener listener) {
        return requestListener(new Request.CommitListener() { // from class: org.eclipse.jetty.client.HttpRequest.4
            @Override // org.eclipse.jetty.client.api.Request.CommitListener
            public void onCommit(Request request) {
                listener.onCommit(request);
            }
        });
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onRequestContent(final Request.ContentListener listener) {
        return requestListener(new Request.ContentListener() { // from class: org.eclipse.jetty.client.HttpRequest.5
            @Override // org.eclipse.jetty.client.api.Request.ContentListener
            public void onContent(Request request, ByteBuffer content) {
                listener.onContent(request, content);
            }
        });
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onRequestSuccess(final Request.SuccessListener listener) {
        return requestListener(new Request.SuccessListener() { // from class: org.eclipse.jetty.client.HttpRequest.6
            @Override // org.eclipse.jetty.client.api.Request.SuccessListener
            public void onSuccess(Request request) {
                listener.onSuccess(request);
            }
        });
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onRequestFailure(final Request.FailureListener listener) {
        return requestListener(new Request.FailureListener() { // from class: org.eclipse.jetty.client.HttpRequest.7
            @Override // org.eclipse.jetty.client.api.Request.FailureListener
            public void onFailure(Request request, Throwable failure) {
                listener.onFailure(request, failure);
            }
        });
    }

    private Request requestListener(Request.RequestListener listener) {
        if (this.requestListeners == null) {
            this.requestListeners = new ArrayList();
        }
        this.requestListeners.add(listener);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseBegin(final Response.BeginListener listener) {
        this.responseListeners.add(new Response.BeginListener() { // from class: org.eclipse.jetty.client.HttpRequest.8
            @Override // org.eclipse.jetty.client.api.Response.BeginListener
            public void onBegin(Response response) {
                listener.onBegin(response);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseHeader(final Response.HeaderListener listener) {
        this.responseListeners.add(new Response.HeaderListener() { // from class: org.eclipse.jetty.client.HttpRequest.9
            @Override // org.eclipse.jetty.client.api.Response.HeaderListener
            public boolean onHeader(Response response, HttpField field) {
                return listener.onHeader(response, field);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseHeaders(final Response.HeadersListener listener) {
        this.responseListeners.add(new Response.HeadersListener() { // from class: org.eclipse.jetty.client.HttpRequest.10
            @Override // org.eclipse.jetty.client.api.Response.HeadersListener
            public void onHeaders(Response response) {
                listener.onHeaders(response);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseContent(final Response.ContentListener listener) {
        this.responseListeners.add(new Response.ContentListener() { // from class: org.eclipse.jetty.client.HttpRequest.11
            @Override // org.eclipse.jetty.client.api.Response.ContentListener
            public void onContent(Response response, ByteBuffer content) {
                listener.onContent(response, content);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseContentAsync(final Response.AsyncContentListener listener) {
        this.responseListeners.add(new Response.AsyncContentListener() { // from class: org.eclipse.jetty.client.HttpRequest.12
            @Override // org.eclipse.jetty.client.api.Response.AsyncContentListener
            public void onContent(Response response, ByteBuffer content, Callback callback) {
                listener.onContent(response, content, callback);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseContentDemanded(final Response.DemandedContentListener listener) {
        this.responseListeners.add(new Response.DemandedContentListener() { // from class: org.eclipse.jetty.client.HttpRequest.13
            @Override // org.eclipse.jetty.client.api.Response.DemandedContentListener
            public void onBeforeContent(Response response, LongConsumer demand) {
                listener.onBeforeContent(response, demand);
            }

            @Override // org.eclipse.jetty.client.api.Response.DemandedContentListener
            public void onContent(Response response, LongConsumer demand, ByteBuffer content, Callback callback) {
                listener.onContent(response, demand, content, callback);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseSuccess(final Response.SuccessListener listener) {
        this.responseListeners.add(new Response.SuccessListener() { // from class: org.eclipse.jetty.client.HttpRequest.14
            @Override // org.eclipse.jetty.client.api.Response.SuccessListener
            public void onSuccess(Response response) {
                listener.onSuccess(response);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onResponseFailure(final Response.FailureListener listener) {
        this.responseListeners.add(new Response.FailureListener() { // from class: org.eclipse.jetty.client.HttpRequest.15
            @Override // org.eclipse.jetty.client.api.Response.FailureListener
            public void onFailure(Response response, Throwable failure) {
                listener.onFailure(response, failure);
            }
        });
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request onComplete(final Response.CompleteListener listener) {
        this.responseListeners.add(new Response.CompleteListener() { // from class: org.eclipse.jetty.client.HttpRequest.16
            @Override // org.eclipse.jetty.client.api.Response.CompleteListener
            public void onComplete(Result result) {
                listener.onComplete(result);
            }
        });
        return this;
    }

    public Request pushListener(BiFunction<Request, Request, Response.CompleteListener> listener) {
        this.pushListener = listener;
        return this;
    }

    public HttpRequest trailers(Supplier<HttpFields> trailers) {
        this.trailers = trailers;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public ContentProvider getContent() {
        return this.content;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request content(ContentProvider content) {
        return content(content, null);
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request content(ContentProvider content, String contentType) {
        if (contentType != null) {
            header(HttpHeader.CONTENT_TYPE, contentType);
        }
        this.content = content;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request file(Path file) throws IOException {
        return file(file, ContentType.OCTET_STREAM);
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request file(Path file, String contentType) throws IOException {
        return content(new PathContentProvider(contentType, file));
    }

    @Override // org.eclipse.jetty.client.api.Request
    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request followRedirects(boolean follow) {
        this.followRedirects = follow;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public long getIdleTimeout() {
        return this.idleTimeout;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request idleTimeout(long timeout, TimeUnit unit) {
        this.idleTimeout = unit.toMillis(timeout);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public long getTimeout() {
        return this.timeout;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Request timeout(long timeout, TimeUnit unit) {
        this.timeout = unit.toMillis(timeout);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public ContentResponse send() throws InterruptedException, TimeoutException, ExecutionException {
        FutureResponseListener listener = new FutureResponseListener(this);
        send(listener);
        try {
            return listener.get();
        } catch (ExecutionException t) {
            if (t.getCause() instanceof TimeoutException) {
                t = (TimeoutException) t.getCause();
                throw t;
            }
            throw t;
        } finally {
            abort(t);
        }
    }

    @Override // org.eclipse.jetty.client.api.Request
    public void send(Response.CompleteListener listener) {
        HttpClient httpClient = this.client;
        Objects.requireNonNull(httpClient);
        sendAsync(this::send, listener);
    }

    /* access modifiers changed from: package-private */
    public void sendAsync(HttpDestination destination, Response.CompleteListener listener) {
        Objects.requireNonNull(destination);
        sendAsync(this::send, listener);
    }

    private void sendAsync(BiConsumer<HttpRequest, List<Response.ResponseListener>> sender, Response.CompleteListener listener) {
        if (listener != null) {
            this.responseListeners.add(listener);
        }
        sent();
        sender.accept(this, this.responseListeners);
    }

    /* access modifiers changed from: package-private */
    public void sent() {
        long timeout = getTimeout();
        if (timeout > 0) {
            this.timeoutAt = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeout);
        }
    }

    /* access modifiers changed from: package-private */
    public long getTimeoutAt() {
        return this.timeoutAt;
    }

    /* access modifiers changed from: protected */
    public List<Response.ResponseListener> getResponseListeners() {
        return this.responseListeners;
    }

    public BiFunction<Request, Request, Response.CompleteListener> getPushListener() {
        return this.pushListener;
    }

    public Supplier<HttpFields> getTrailers() {
        return this.trailers;
    }

    @Override // org.eclipse.jetty.client.api.Request
    public boolean abort(Throwable cause) {
        if (!this.aborted.compareAndSet(null, (Throwable) Objects.requireNonNull(cause))) {
            return false;
        }
        if (this.content instanceof Callback) {
            ((Callback) this.content).failed(cause);
        }
        return this.conversation.abort(cause);
    }

    @Override // org.eclipse.jetty.client.api.Request
    public Throwable getAbortCause() {
        return this.aborted.get();
    }

    /* access modifiers changed from: package-private */
    public boolean normalized() {
        boolean result = this.normalized;
        this.normalized = true;
        return result;
    }

    private String buildQuery() {
        StringBuilder result = new StringBuilder();
        Iterator<Fields.Field> iterator = this.params.iterator();
        while (iterator.hasNext()) {
            Fields.Field field = iterator.next();
            List<String> values = field.getValues();
            for (int i = 0; i < values.size(); i++) {
                if (i > 0) {
                    result.append("&");
                }
                result.append(field.getName()).append("=");
                result.append(urlEncode(values.get(i)));
            }
            if (iterator.hasNext()) {
                result.append("&");
            }
        }
        return result.toString();
    }

    private String urlEncode(String value) {
        if (value == null) {
            return "";
        }
        try {
            return URLEncoder.encode(value, StringUtil.__UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(StringUtil.__UTF8);
        }
    }

    private void extractParams(String query) {
        if (query != null) {
            for (String nameValue : query.split("&")) {
                String[] parts = nameValue.split("=");
                if (parts.length > 0) {
                    String name = urlDecode(parts[0]);
                    if (name.trim().length() != 0) {
                        param(name, parts.length < 2 ? "" : urlDecode(parts[1]), true);
                    }
                }
            }
        }
    }

    private String urlDecode(String value) {
        try {
            return URLDecoder.decode(value, StringUtil.__UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(StringUtil.__UTF8);
        }
    }

    private URI buildURI(boolean withQuery) {
        String path = getPath();
        String query = getQuery();
        if (query != null && withQuery) {
            path = path + "?" + query;
        }
        URI result = newURI(path);
        if (result == null) {
            return NULL_URI;
        }
        if (!result.isAbsolute()) {
            result = URI.create(new Origin(getScheme(), getHost(), getPort()).asString() + path);
        }
        return result;
    }

    private URI newURI(String path) {
        try {
            if ("*".equals(path)) {
                return null;
            }
            URI result = new URI(path);
            if (result.isOpaque()) {
                return null;
            }
            return result;
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public String toString() {
        return String.format("%s[%s %s %s]@%x", getClass().getSimpleName(), getMethod(), getPath(), getVersion(), Integer.valueOf(hashCode()));
    }
}
