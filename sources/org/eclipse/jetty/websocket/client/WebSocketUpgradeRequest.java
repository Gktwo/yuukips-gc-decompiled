package org.eclipse.jetty.websocket.client;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpConversation;
import org.eclipse.jetty.client.HttpRequest;
import org.eclipse.jetty.client.HttpResponse;
import org.eclipse.jetty.client.HttpResponseException;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.http.HttpConnectionOverHTTP;
import org.eclipse.jetty.client.http.HttpConnectionUpgrader;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.UrlEncoded;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.UpgradeException;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.ExtensionFactory;
import org.eclipse.jetty.websocket.client.p024io.UpgradeListener;
import org.eclipse.jetty.websocket.client.p024io.WebSocketClientConnection;
import org.eclipse.jetty.websocket.common.AcceptHash;
import org.eclipse.jetty.websocket.common.SessionFactory;
import org.eclipse.jetty.websocket.common.WebSocketSession;
import org.eclipse.jetty.websocket.common.events.EventDriver;
import org.eclipse.jetty.websocket.common.extensions.ExtensionStack;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/WebSocketUpgradeRequest.class */
public class WebSocketUpgradeRequest extends HttpRequest implements Response.CompleteListener, HttpConnectionUpgrader {
    private static final Logger LOG = Log.getLogger(WebSocketUpgradeRequest.class);
    private final WebSocketClient wsClient;
    private final EventDriver localEndpoint;
    private final CompletableFuture<Session> fut;
    private final ClientUpgradeRequestFacade apiRequestFacade;
    private UpgradeListener upgradeListener;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/WebSocketUpgradeRequest$ClientUpgradeRequestFacade.class */
    public class ClientUpgradeRequestFacade implements UpgradeRequest {
        private List<ExtensionConfig> extensions = new ArrayList();
        private List<String> subProtocols = new ArrayList();
        private Object session;

        public ClientUpgradeRequestFacade() {
        }

        public void init(ClientUpgradeRequest request) {
            this.extensions = new ArrayList(request.getExtensions());
            this.subProtocols = new ArrayList(request.getSubProtocols());
            request.getHeaders().forEach(name, values -> {
                values.forEach(value -> {
                    WebSocketUpgradeRequest.this.header(name, name);
                });
            });
            for (HttpCookie cookie : request.getCookies()) {
                WebSocketUpgradeRequest.this.cookie(cookie);
            }
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public List<ExtensionConfig> getExtensions() {
            return this.extensions;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public List<String> getSubProtocols() {
            return this.subProtocols;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void addExtensions(ExtensionConfig... configs) {
            for (ExtensionConfig config : configs) {
                this.extensions.add(config);
            }
            updateExtensionHeader();
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void addExtensions(String... configs) {
            this.extensions.addAll(ExtensionConfig.parseList(configs));
            updateExtensionHeader();
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void clearHeaders() {
            throw new UnsupportedOperationException("Clearing all headers breaks WebSocket upgrade");
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public String getHeader(String name) {
            return WebSocketUpgradeRequest.this.getHttpFields().get(name);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public int getHeaderInt(String name) {
            String value = WebSocketUpgradeRequest.this.getHttpFields().get(name);
            if (value == null) {
                return -1;
            }
            return Integer.parseInt(value);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public List<String> getHeaders(String name) {
            return WebSocketUpgradeRequest.this.getHttpFields().getValuesList(name);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public String getHttpVersion() {
            return WebSocketUpgradeRequest.this.getVersion().asString();
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public String getOrigin() {
            return WebSocketUpgradeRequest.this.getHttpFields().get(HttpHeader.ORIGIN);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public Map<String, List<String>> getParameterMap() {
            Map<String, List<String>> paramMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            String query = getQueryString();
            MultiMap<String> multimap = new MultiMap<>();
            UrlEncoded.decodeTo(query, multimap, StandardCharsets.UTF_8);
            paramMap.putAll(multimap);
            return paramMap;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public String getProtocolVersion() {
            String ver = WebSocketUpgradeRequest.this.getHttpFields().get(HttpHeader.SEC_WEBSOCKET_VERSION);
            if (ver == null) {
                return Integer.toString(13);
            }
            return ver;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public String getQueryString() {
            return WebSocketUpgradeRequest.this.getURI().getQuery();
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public URI getRequestURI() {
            return WebSocketUpgradeRequest.this.getURI();
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public Object getSession() {
            return this.session;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public Principal getUserPrincipal() {
            return null;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public boolean hasSubProtocol(String test) {
            return getSubProtocols().contains(test);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public boolean isOrigin(String test) {
            return test.equalsIgnoreCase(getOrigin());
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public boolean isSecure() {
            return "wss".equalsIgnoreCase(WebSocketUpgradeRequest.this.getURI().getScheme());
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setCookies(List<HttpCookie> cookies) {
            for (HttpCookie cookie : cookies) {
                WebSocketUpgradeRequest.this.cookie(cookie);
            }
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setExtensions(List<ExtensionConfig> configs) {
            this.extensions = configs;
            updateExtensionHeader();
        }

        private void updateExtensionHeader() {
            HttpFields headers = WebSocketUpgradeRequest.this.getHttpFields();
            headers.remove(HttpHeader.SEC_WEBSOCKET_EXTENSIONS);
            for (ExtensionConfig config : this.extensions) {
                headers.add(HttpHeader.SEC_WEBSOCKET_EXTENSIONS, config.getParameterizedName());
            }
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setHeader(String name, List<String> values) {
            WebSocketUpgradeRequest.this.getHttpFields().put(name, values);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setHeader(String name, String value) {
            WebSocketUpgradeRequest.this.getHttpFields().put(name, value);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setHeaders(Map<String, List<String>> headers) {
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                WebSocketUpgradeRequest.this.getHttpFields().put(entry.getKey(), entry.getValue());
            }
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setHttpVersion(String httpVersion) {
            WebSocketUpgradeRequest.this.version(HttpVersion.fromString(httpVersion));
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setMethod(String method) {
            WebSocketUpgradeRequest.this.method(method);
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setRequestURI(URI uri) {
            throw new UnsupportedOperationException("Cannot reset/change RequestURI");
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setSession(Object session) {
            this.session = session;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setSubProtocols(List<String> protocols) {
            this.subProtocols = protocols;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public void setSubProtocols(String... protocols) {
            this.subProtocols.clear();
            this.subProtocols.addAll(Arrays.asList(protocols));
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public List<HttpCookie> getCookies() {
            return WebSocketUpgradeRequest.this.getCookies();
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public Map<String, List<String>> getHeaders() {
            Map<String, List<String>> headersMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            HttpFields fields = WebSocketUpgradeRequest.this.getHttpFields();
            for (String name : fields.getFieldNamesCollection()) {
                headersMap.put(name, fields.getValuesList(name));
            }
            return headersMap;
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public String getHost() {
            return WebSocketUpgradeRequest.this.getHost();
        }

        @Override // org.eclipse.jetty.websocket.api.UpgradeRequest
        public String getMethod() {
            return WebSocketUpgradeRequest.this.getMethod();
        }
    }

    /* access modifiers changed from: protected */
    public WebSocketUpgradeRequest(WebSocketClient wsClient, HttpClient httpClient, ClientUpgradeRequest request) {
        this(wsClient, httpClient, request.getRequestURI(), request.getLocalEndpoint());
        this.apiRequestFacade.init(request);
    }

    public WebSocketUpgradeRequest(WebSocketClient wsClient, HttpClient httpClient, URI wsURI, Object localEndpoint) {
        super(httpClient, new HttpConversation(), wsURI);
        this.apiRequestFacade = new ClientUpgradeRequestFacade();
        if (!wsURI.isAbsolute()) {
            throw new IllegalArgumentException("WebSocket URI must be an absolute URI: " + wsURI);
        }
        String scheme = wsURI.getScheme();
        if (scheme == null || (!scheme.equalsIgnoreCase("ws") && !scheme.equalsIgnoreCase("wss"))) {
            throw new IllegalArgumentException("WebSocket URI must use 'ws' or 'wss' scheme: " + wsURI);
        }
        this.wsClient = wsClient;
        try {
            if (!this.wsClient.isRunning()) {
                this.wsClient.start();
            }
            this.localEndpoint = this.wsClient.getEventDriverFactory().wrap(localEndpoint);
            this.fut = new CompletableFuture<>();
            this.fut.whenComplete(session, throwable -> {
                if (throwable != null) {
                    abort(throwable);
                }
            });
            getConversation().setAttribute(HttpConnectionUpgrader.class.getName(), this);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to start WebSocketClient", e);
        }
    }

    private String genRandomKey() {
        byte[] bytes = new byte[16];
        ThreadLocalRandom.current().nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private ExtensionFactory getExtensionFactory() {
        return this.wsClient.getExtensionFactory();
    }

    private SessionFactory getSessionFactory() {
        return this.wsClient.getSessionFactory();
    }

    private void initWebSocketHeaders() {
        method(HttpMethod.GET);
        version(HttpVersion.HTTP_1_1);
        header(HttpHeader.UPGRADE, "websocket");
        header(HttpHeader.CONNECTION, "Upgrade");
        header(HttpHeader.SEC_WEBSOCKET_KEY, genRandomKey());
        header(HttpHeader.SEC_WEBSOCKET_VERSION, "13");
        header(HttpHeader.PRAGMA, "no-cache");
        header(HttpHeader.CACHE_CONTROL, "no-cache");
        if (!this.apiRequestFacade.getExtensions().isEmpty()) {
            for (ExtensionConfig ext : this.apiRequestFacade.getExtensions()) {
                header(HttpHeader.SEC_WEBSOCKET_EXTENSIONS, ext.getParameterizedName());
            }
        }
        if (!this.apiRequestFacade.getSubProtocols().isEmpty()) {
            for (String protocol : this.apiRequestFacade.getSubProtocols()) {
                header(HttpHeader.SEC_WEBSOCKET_SUBPROTOCOL, protocol);
            }
        }
        if (this.upgradeListener != null) {
            this.upgradeListener.onHandshakeRequest(this.apiRequestFacade);
        }
    }

    @Override // org.eclipse.jetty.client.api.Response.CompleteListener
    public void onComplete(Result result) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onComplete() - {}", result);
        }
        URI requestURI = result.getRequest().getURI();
        Response response = result.getResponse();
        int responseStatusCode = response.getStatus();
        String responseLine = responseStatusCode + " " + response.getReason();
        if (result.isFailed()) {
            if (LOG.isDebugEnabled()) {
                if (result.getFailure() != null) {
                    LOG.debug("General Failure", result.getFailure());
                }
                if (result.getRequestFailure() != null) {
                    LOG.debug("Request Failure", result.getRequestFailure());
                }
                if (result.getResponseFailure() != null) {
                    LOG.debug("Response Failure", result.getResponseFailure());
                }
            }
            Throwable failure = result.getFailure();
            if ((failure instanceof IOException) || (failure instanceof UpgradeException)) {
                handleException(failure);
            } else {
                handleException(new UpgradeException(requestURI, responseStatusCode, responseLine, failure));
            }
        } else if (responseStatusCode != 101) {
            handleException(new UpgradeException(requestURI, responseStatusCode, "Failed to upgrade to websocket: Unexpected HTTP Response Status Code: " + responseLine));
        }
    }

    private void handleException(Throwable failure) {
        try {
            this.localEndpoint.onError(failure);
        } catch (Throwable t) {
            LOG.warn("Exception while notifying onError", t);
        }
        this.fut.completeExceptionally(failure);
    }

    @Override // org.eclipse.jetty.client.HttpRequest, org.eclipse.jetty.client.api.Request
    public ContentResponse send() throws InterruptedException, TimeoutException, ExecutionException {
        throw new RuntimeException("Working with raw ContentResponse is invalid for WebSocket");
    }

    @Override // org.eclipse.jetty.client.HttpRequest, org.eclipse.jetty.client.api.Request
    public void send(Response.CompleteListener listener) {
        initWebSocketHeaders();
        send(listener);
    }

    public CompletableFuture<Session> sendAsync() {
        send(this);
        return this.fut;
    }

    @Override // org.eclipse.jetty.client.http.HttpConnectionUpgrader
    public void upgrade(HttpResponse response, HttpConnectionOverHTTP oldConn) {
        String[] extValues;
        if (!getHeaders().get(HttpHeader.UPGRADE).equalsIgnoreCase("websocket")) {
            throw new HttpResponseException("Not WebSocket Upgrade", response);
        } else if (!AcceptHash.hashKey(getHeaders().get(HttpHeader.SEC_WEBSOCKET_KEY)).equalsIgnoreCase(response.getHeaders().get(HttpHeader.SEC_WEBSOCKET_ACCEPT))) {
            throw new HttpResponseException("Invalid Sec-WebSocket-Accept hash", response);
        } else {
            EndPoint endp = oldConn.getEndPoint();
            WebSocketClientConnection connection = new WebSocketClientConnection(endp, this.wsClient.getExecutor(), this.wsClient.getScheduler(), this.localEndpoint.getPolicy(), this.wsClient.getBufferPool());
            Collection<Connection.Listener> connectionListeners = this.wsClient.getBeans(Connection.Listener.class);
            if (connectionListeners != null) {
                connectionListeners.forEach(listener -> {
                    if (!(listener instanceof WebSocketSession)) {
                        connection.addListener(listener);
                    }
                });
            }
            URI requestURI = getURI();
            ClientUpgradeResponse upgradeResponse = new ClientUpgradeResponse(response);
            WebSocketSession session = getSessionFactory().createSession(requestURI, this.localEndpoint, connection);
            session.setUpgradeRequest(new ClientUpgradeRequest(this));
            session.setUpgradeResponse(upgradeResponse);
            connection.addListener(session);
            List<ExtensionConfig> extensions = new ArrayList<>();
            HttpField extField = response.getHeaders().getField(HttpHeader.SEC_WEBSOCKET_EXTENSIONS);
            if (!(extField == null || (extValues = extField.getValues()) == null)) {
                for (String extVal : extValues) {
                    QuotedStringTokenizer tok = new QuotedStringTokenizer(extVal, ",");
                    while (tok.hasMoreTokens()) {
                        extensions.add(ExtensionConfig.parse(tok.nextToken()));
                    }
                }
            }
            ExtensionStack extensionStack = new ExtensionStack(getExtensionFactory());
            extensionStack.negotiate(extensions);
            extensionStack.configure(connection.getParser());
            extensionStack.configure(connection.getGenerator());
            connection.setNextIncomingFrames(extensionStack);
            extensionStack.setNextIncoming(session);
            session.setOutgoingHandler(extensionStack);
            extensionStack.setNextOutgoing(connection);
            session.addManaged(extensionStack);
            session.setFuture(this.fut);
            if (this.upgradeListener != null) {
                this.upgradeListener.onHandshakeResponse(upgradeResponse);
            }
            endp.upgrade(connection);
        }
    }

    public void setUpgradeListener(UpgradeListener upgradeListener) {
        this.upgradeListener = upgradeListener;
    }

    /* access modifiers changed from: private */
    public HttpFields getHttpFields() {
        return getHeaders();
    }
}
