package org.eclipse.jetty.client;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.client.ContentDecoder;
import org.eclipse.jetty.client.GZIPContentDecoder;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.client.api.AuthenticationStore;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Destination;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.http.HttpClientTransportOverHTTP;
import org.eclipse.jetty.client.util.FormContentProvider;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.ClientConnectionFactory;
import org.eclipse.jetty.p023io.MappedByteBufferPool;
import org.eclipse.jetty.p023io.ssl.SslClientConnectionFactory;
import org.eclipse.jetty.util.Fields;
import org.eclipse.jetty.util.Jetty;
import org.eclipse.jetty.util.ProcessorUtils;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.SocketAddressResolver;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ScheduledExecutorScheduler;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.util.thread.ThreadPool;
import p013io.javalin.http.ContentType;
import p013io.netty.handler.traffic.AbstractTrafficShapingHandler;

@ManagedObject("The HTTP client")
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpClient.class */
public class HttpClient extends ContainerLifeCycle {
    private static final Logger LOG = Log.getLogger(HttpClient.class);
    private final ConcurrentMap<Origin, HttpDestination> destinations;
    private final ProtocolHandlers handlers;
    private final List<Request.Listener> requestListeners;
    private final Set<ContentDecoder.Factory> decoderFactories;
    private final ProxyConfiguration proxyConfig;
    private final HttpClientTransport transport;
    private final SslContextFactory sslContextFactory;
    private AuthenticationStore authenticationStore;
    private CookieManager cookieManager;
    private CookieStore cookieStore;
    private Executor executor;
    private ByteBufferPool byteBufferPool;
    private Scheduler scheduler;
    private SocketAddressResolver resolver;
    private HttpField agentField;
    private boolean followRedirects;
    private int maxConnectionsPerDestination;
    private int maxRequestsQueuedPerDestination;
    private int requestBufferSize;
    private int responseBufferSize;
    private int maxRedirects;
    private SocketAddress bindAddress;
    private long connectTimeout;
    private long addressResolutionTimeout;
    private long idleTimeout;
    private boolean tcpNoDelay;
    private boolean strictEventOrdering;
    private HttpField encodingField;
    private boolean removeIdleDestinations;
    private boolean connectBlocking;
    private String name;
    private HttpCompliance httpCompliance;
    private String defaultRequestContentType;

    public HttpClient() {
        this(new HttpClientTransportOverHTTP(), null);
    }

    public HttpClient(SslContextFactory sslContextFactory) {
        this(new HttpClientTransportOverHTTP(), sslContextFactory);
    }

    public HttpClient(HttpClientTransport transport) {
        this(transport, null);
    }

    public HttpClient(HttpClientTransport transport, SslContextFactory sslContextFactory) {
        this.destinations = new ConcurrentHashMap();
        this.handlers = new ProtocolHandlers();
        this.requestListeners = new ArrayList();
        this.decoderFactories = new ContentDecoderFactorySet();
        this.proxyConfig = new ProxyConfiguration();
        this.authenticationStore = new HttpAuthenticationStore();
        this.agentField = new HttpField(HttpHeader.USER_AGENT, "Jetty/" + Jetty.VERSION);
        this.followRedirects = true;
        this.maxConnectionsPerDestination = 64;
        this.maxRequestsQueuedPerDestination = 1024;
        this.requestBufferSize = 4096;
        this.responseBufferSize = 16384;
        this.maxRedirects = 8;
        this.connectTimeout = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
        this.addressResolutionTimeout = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
        this.tcpNoDelay = true;
        this.strictEventOrdering = false;
        this.removeIdleDestinations = false;
        this.connectBlocking = false;
        this.name = getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
        this.httpCompliance = HttpCompliance.RFC7230;
        this.defaultRequestContentType = ContentType.OCTET_STREAM;
        this.transport = transport;
        addBean(transport);
        this.sslContextFactory = sslContextFactory;
        addBean(sslContextFactory);
        addBean(this.handlers);
        addBean(this.decoderFactories);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, new DumpableCollection("requestListeners", this.requestListeners));
    }

    public HttpClientTransport getTransport() {
        return this.transport;
    }

    public SslContextFactory getSslContextFactory() {
        return this.sslContextFactory;
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        int i;
        if (this.executor == null) {
            QueuedThreadPool threadPool = new QueuedThreadPool();
            threadPool.setName(this.name);
            setExecutor(threadPool);
        }
        if (this.byteBufferPool == null) {
            if (this.executor instanceof ThreadPool.SizedThreadPool) {
                i = ((ThreadPool.SizedThreadPool) this.executor).getMaxThreads() / 2;
            } else {
                i = ProcessorUtils.availableProcessors() * 2;
            }
            setByteBufferPool(new MappedByteBufferPool(2048, i));
        }
        if (this.scheduler == null) {
            setScheduler(new ScheduledExecutorScheduler(this.name + "-scheduler", false));
        }
        if (this.resolver == null) {
            setSocketAddressResolver(new SocketAddressResolver.Async(this.executor, this.scheduler, getAddressResolutionTimeout()));
        }
        this.handlers.put(new ContinueProtocolHandler());
        this.handlers.put(new RedirectProtocolHandler(this));
        this.handlers.put(new WWWAuthenticationProtocolHandler(this));
        this.handlers.put(new ProxyAuthenticationProtocolHandler(this));
        this.decoderFactories.add(new GZIPContentDecoder.Factory(this.byteBufferPool));
        this.cookieManager = newCookieManager();
        this.cookieStore = this.cookieManager.getCookieStore();
        this.transport.setHttpClient(this);
        doStart();
    }

    private CookieManager newCookieManager() {
        return new CookieManager(getCookieStore(), CookiePolicy.ACCEPT_ALL);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        this.decoderFactories.clear();
        this.handlers.clear();
        for (HttpDestination destination : this.destinations.values()) {
            destination.close();
        }
        this.destinations.clear();
        this.requestListeners.clear();
        this.authenticationStore.clearAuthentications();
        this.authenticationStore.clearAuthenticationResults();
        doStop();
    }

    public List<Request.Listener> getRequestListeners() {
        return this.requestListeners;
    }

    public CookieStore getCookieStore() {
        return this.cookieStore;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = (CookieStore) Objects.requireNonNull(cookieStore);
        this.cookieManager = newCookieManager();
    }

    /* access modifiers changed from: package-private */
    public CookieManager getCookieManager() {
        return this.cookieManager;
    }

    public AuthenticationStore getAuthenticationStore() {
        return this.authenticationStore;
    }

    public void setAuthenticationStore(AuthenticationStore authenticationStore) {
        this.authenticationStore = authenticationStore;
    }

    public Set<ContentDecoder.Factory> getContentDecoderFactories() {
        return this.decoderFactories;
    }

    public ContentResponse GET(String uri) throws InterruptedException, ExecutionException, TimeoutException {
        return GET(URI.create(uri));
    }

    public ContentResponse GET(URI uri) throws InterruptedException, ExecutionException, TimeoutException {
        return newRequest(uri).send();
    }

    public ContentResponse FORM(String uri, Fields fields) throws InterruptedException, ExecutionException, TimeoutException {
        return FORM(URI.create(uri), fields);
    }

    public ContentResponse FORM(URI uri, Fields fields) throws InterruptedException, ExecutionException, TimeoutException {
        return POST(uri).content(new FormContentProvider(fields)).send();
    }

    public Request POST(String uri) {
        return POST(URI.create(uri));
    }

    public Request POST(URI uri) {
        return newRequest(uri).method(HttpMethod.POST);
    }

    public Request newRequest(String host, int port) {
        return newRequest(new Origin(URIUtil.HTTP, host, port).asString());
    }

    public Request newRequest(String uri) {
        return newRequest(URI.create(uri));
    }

    public Request newRequest(URI uri) {
        return newHttpRequest(newConversation(), uri);
    }

    /* access modifiers changed from: protected */
    public Request copyRequest(HttpRequest oldRequest, URI newURI) {
        Request newRequest = newHttpRequest(oldRequest.getConversation(), newURI);
        newRequest.method(oldRequest.getMethod()).version(oldRequest.getVersion()).content(oldRequest.getContent()).idleTimeout(oldRequest.getIdleTimeout(), TimeUnit.MILLISECONDS).timeout(oldRequest.getTimeout(), TimeUnit.MILLISECONDS).followRedirects(oldRequest.isFollowRedirects());
        Iterator<HttpField> it = oldRequest.getHeaders().iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            HttpHeader header = field.getHeader();
            if (!(HttpHeader.HOST == header || HttpHeader.EXPECT == header || HttpHeader.COOKIE == header || HttpHeader.AUTHORIZATION == header || HttpHeader.PROXY_AUTHORIZATION == header)) {
                String name = field.getName();
                String value = field.getValue();
                if (!newRequest.getHeaders().contains(name, value)) {
                    newRequest.header(name, value);
                }
            }
        }
        return newRequest;
    }

    protected HttpRequest newHttpRequest(HttpConversation conversation, URI uri) {
        return new HttpRequest(this, conversation, checkHost(uri));
    }

    private URI checkHost(URI uri) {
        if (uri.getHost() != null) {
            return uri;
        }
        throw new IllegalArgumentException(String.format("Invalid URI host: null (authority: %s)", uri.getRawAuthority()));
    }

    public Destination getDestination(String scheme, String host, int port) {
        return destinationFor(scheme, host, port);
    }

    /* access modifiers changed from: protected */
    public HttpDestination destinationFor(String scheme, String host, int port) {
        return resolveDestination(scheme, host, port, null);
    }

    protected HttpDestination resolveDestination(String scheme, String host, int port, Object tag) {
        return resolveDestination(createOrigin(scheme, host, port, tag));
    }

    protected Origin createOrigin(String scheme, String host, int port, Object tag) {
        if (HttpScheme.HTTP.m39is(scheme) || HttpScheme.HTTPS.m39is(scheme) || HttpScheme.WS.m39is(scheme) || HttpScheme.WSS.m39is(scheme)) {
            String scheme2 = scheme.toLowerCase(Locale.ENGLISH);
            return new Origin(scheme2, host.toLowerCase(Locale.ENGLISH), normalizePort(scheme2, port), tag);
        }
        throw new IllegalArgumentException("Invalid protocol " + scheme);
    }

    public HttpDestination resolveDestination(Origin origin) {
        return this.destinations.computeIfAbsent(origin, o -> {
            HttpDestination newDestination = getTransport().newHttpDestination(o);
            addManaged(newDestination);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Created {}", newDestination);
            }
            return newDestination;
        });
    }

    /* access modifiers changed from: protected */
    public boolean removeDestination(HttpDestination destination) {
        removeBean(destination);
        return this.destinations.remove(destination.getOrigin(), destination);
    }

    public List<Destination> getDestinations() {
        return new ArrayList(this.destinations.values());
    }

    /* access modifiers changed from: protected */
    public void send(HttpRequest request, List<Response.ResponseListener> listeners) {
        resolveDestination(request.getScheme(), request.getHost(), request.getPort(), request.getTag()).send(request, listeners);
    }

    /* access modifiers changed from: protected */
    public void newConnection(final HttpDestination destination, final Promise<Connection> promise) {
        Origin.Address address = destination.getConnectAddress();
        this.resolver.resolve(address.getHost(), address.getPort(), new Promise<List<InetSocketAddress>>() { // from class: org.eclipse.jetty.client.HttpClient.1
            public void succeeded(List<InetSocketAddress> socketAddresses) {
                Map<String, Object> context = new ConcurrentHashMap<>();
                context.put(ClientConnectionFactory.CONNECTOR_CONTEXT_KEY, HttpClient.this);
                context.put(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY, destination);
                connect(socketAddresses, 0, context);
            }

            @Override // org.eclipse.jetty.util.Promise
            public void failed(Throwable x) {
                promise.failed(x);
            }

            /* access modifiers changed from: private */
            public void connect(final List<InetSocketAddress> socketAddresses, final int index, final Map<String, Object> context) {
                context.put(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY, new Promise.Wrapper<Connection>(promise) { // from class: org.eclipse.jetty.client.HttpClient.1.1
                    @Override // org.eclipse.jetty.util.Promise.Wrapper, org.eclipse.jetty.util.Promise
                    public void failed(Throwable x) {
                        int nextIndex = index + 1;
                        if (nextIndex == socketAddresses.size()) {
                            failed(x);
                        } else {
                            C55691.this.connect(socketAddresses, nextIndex, context);
                        }
                    }
                });
                HttpClient.this.transport.connect(socketAddresses.get(index), context);
            }
        });
    }

    private HttpConversation newConversation() {
        return new HttpConversation();
    }

    public ProtocolHandlers getProtocolHandlers() {
        return this.handlers;
    }

    /* access modifiers changed from: protected */
    public ProtocolHandler findProtocolHandler(Request request, Response response) {
        return this.handlers.find(request, response);
    }

    public ByteBufferPool getByteBufferPool() {
        return this.byteBufferPool;
    }

    public void setByteBufferPool(ByteBufferPool byteBufferPool) {
        if (isStarted()) {
            LOG.warn("Calling setByteBufferPool() while started is deprecated", new Object[0]);
        }
        updateBean(this.byteBufferPool, byteBufferPool);
        this.byteBufferPool = byteBufferPool;
    }

    @ManagedAttribute("The name of this HttpClient")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManagedAttribute("The timeout, in milliseconds, for connect() operations")
    public long getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public long getAddressResolutionTimeout() {
        return this.addressResolutionTimeout;
    }

    public void setAddressResolutionTimeout(long addressResolutionTimeout) {
        this.addressResolutionTimeout = addressResolutionTimeout;
    }

    @ManagedAttribute("The timeout, in milliseconds, to close idle connections")
    public long getIdleTimeout() {
        return this.idleTimeout;
    }

    public void setIdleTimeout(long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public SocketAddress getBindAddress() {
        return this.bindAddress;
    }

    public void setBindAddress(SocketAddress bindAddress) {
        this.bindAddress = bindAddress;
    }

    public HttpField getUserAgentField() {
        return this.agentField;
    }

    public void setUserAgentField(HttpField agent) {
        if (agent == null || agent.getHeader() == HttpHeader.USER_AGENT) {
            this.agentField = agent;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ManagedAttribute("Whether HTTP redirects are followed")
    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public void setFollowRedirects(boolean follow) {
        this.followRedirects = follow;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public void setExecutor(Executor executor) {
        if (isStarted()) {
            LOG.warn("Calling setExecutor() while started is deprecated", new Object[0]);
        }
        updateBean(this.executor, executor);
        this.executor = executor;
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        if (isStarted()) {
            LOG.warn("Calling setScheduler() while started is deprecated", new Object[0]);
        }
        updateBean(this.scheduler, scheduler);
        this.scheduler = scheduler;
    }

    public SocketAddressResolver getSocketAddressResolver() {
        return this.resolver;
    }

    public void setSocketAddressResolver(SocketAddressResolver resolver) {
        if (isStarted()) {
            LOG.warn("Calling setSocketAddressResolver() while started is deprecated", new Object[0]);
        }
        updateBean(this.resolver, resolver);
        this.resolver = resolver;
    }

    @ManagedAttribute("The max number of connections per each destination")
    public int getMaxConnectionsPerDestination() {
        return this.maxConnectionsPerDestination;
    }

    public void setMaxConnectionsPerDestination(int maxConnectionsPerDestination) {
        this.maxConnectionsPerDestination = maxConnectionsPerDestination;
    }

    @ManagedAttribute("The max number of requests queued per each destination")
    public int getMaxRequestsQueuedPerDestination() {
        return this.maxRequestsQueuedPerDestination;
    }

    public void setMaxRequestsQueuedPerDestination(int maxRequestsQueuedPerDestination) {
        this.maxRequestsQueuedPerDestination = maxRequestsQueuedPerDestination;
    }

    @ManagedAttribute("The request buffer size")
    public int getRequestBufferSize() {
        return this.requestBufferSize;
    }

    public void setRequestBufferSize(int requestBufferSize) {
        this.requestBufferSize = requestBufferSize;
    }

    @ManagedAttribute("The response buffer size")
    public int getResponseBufferSize() {
        return this.responseBufferSize;
    }

    public void setResponseBufferSize(int responseBufferSize) {
        this.responseBufferSize = responseBufferSize;
    }

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public void setMaxRedirects(int maxRedirects) {
        this.maxRedirects = maxRedirects;
    }

    @ManagedAttribute(value = "Whether the TCP_NODELAY option is enabled", name = "tcpNoDelay")
    public boolean isTCPNoDelay() {
        return this.tcpNoDelay;
    }

    public void setTCPNoDelay(boolean tcpNoDelay) {
        this.tcpNoDelay = tcpNoDelay;
    }

    @Deprecated
    public boolean isDispatchIO() {
        return false;
    }

    @Deprecated
    public void setDispatchIO(boolean dispatchIO) {
    }

    public HttpCompliance getHttpCompliance() {
        return this.httpCompliance;
    }

    public void setHttpCompliance(HttpCompliance httpCompliance) {
        this.httpCompliance = httpCompliance;
    }

    @ManagedAttribute("Whether request/response events must be strictly ordered")
    public boolean isStrictEventOrdering() {
        return this.strictEventOrdering;
    }

    public void setStrictEventOrdering(boolean strictEventOrdering) {
        this.strictEventOrdering = strictEventOrdering;
    }

    @ManagedAttribute("Whether idle destinations are removed")
    public boolean isRemoveIdleDestinations() {
        return this.removeIdleDestinations;
    }

    public void setRemoveIdleDestinations(boolean removeIdleDestinations) {
        this.removeIdleDestinations = removeIdleDestinations;
    }

    @ManagedAttribute("Whether the connect() operation is blocking")
    public boolean isConnectBlocking() {
        return this.connectBlocking;
    }

    public void setConnectBlocking(boolean connectBlocking) {
        this.connectBlocking = connectBlocking;
    }

    @ManagedAttribute("The default content type for request content")
    public String getDefaultRequestContentType() {
        return this.defaultRequestContentType;
    }

    public void setDefaultRequestContentType(String contentType) {
        this.defaultRequestContentType = contentType;
    }

    public ProxyConfiguration getProxyConfiguration() {
        return this.proxyConfig;
    }

    /* access modifiers changed from: protected */
    public HttpField getAcceptEncodingField() {
        return this.encodingField;
    }

    @Deprecated
    protected String normalizeHost(String host) {
        return host;
    }

    public static int normalizePort(String scheme, int port) {
        if (port > 0) {
            return port;
        }
        if (isSchemeSecure(scheme)) {
            return PacketOpcodes.PersonalLineAllDataRsp;
        }
        return 80;
    }

    public boolean isDefaultPort(String scheme, int port) {
        return isSchemeSecure(scheme) ? port == 443 : port == 80;
    }

    /* access modifiers changed from: package-private */
    public static boolean isSchemeSecure(String scheme) {
        return HttpScheme.HTTPS.m39is(scheme) || HttpScheme.WSS.m39is(scheme);
    }

    @Deprecated
    protected ClientConnectionFactory newSslClientConnectionFactory(ClientConnectionFactory connectionFactory) {
        return new SslClientConnectionFactory(getSslContextFactory(), getByteBufferPool(), getExecutor(), connectionFactory);
    }

    /* access modifiers changed from: protected */
    public ClientConnectionFactory newSslClientConnectionFactory(SslContextFactory sslContextFactory, ClientConnectionFactory connectionFactory) {
        if (sslContextFactory == null) {
            return newSslClientConnectionFactory(connectionFactory);
        }
        return new SslClientConnectionFactory(sslContextFactory, getByteBufferPool(), getExecutor(), connectionFactory);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpClient$ContentDecoderFactorySet.class */
    private class ContentDecoderFactorySet implements Set<ContentDecoder.Factory> {
        private final Set<ContentDecoder.Factory> set;

        private ContentDecoderFactorySet() {
            this.set = new HashSet();
        }

        public boolean add(ContentDecoder.Factory e) {
            boolean result = this.set.add(e);
            invalidate();
            return result;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends ContentDecoder.Factory> c) {
            boolean result = this.set.addAll(c);
            invalidate();
            return result;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object o) {
            boolean result = this.set.remove(o);
            invalidate();
            return result;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            boolean result = this.set.removeAll(c);
            invalidate();
            return result;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            boolean result = this.set.retainAll(c);
            invalidate();
            return result;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.set.clear();
            invalidate();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.set.size();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object o) {
            return this.set.contains(o);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> c) {
            return this.set.containsAll(c);
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<ContentDecoder.Factory> iterator() {
            final Iterator<ContentDecoder.Factory> iterator = this.set.iterator();
            return new Iterator<ContentDecoder.Factory>() { // from class: org.eclipse.jetty.client.HttpClient.ContentDecoderFactorySet.1
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return iterator.hasNext();
                }

                @Override // java.util.Iterator
                public ContentDecoder.Factory next() {
                    return (ContentDecoder.Factory) iterator.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    iterator.remove();
                    ContentDecoderFactorySet.this.invalidate();
                }
            };
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return this.set.toArray();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] a) {
            return (T[]) this.set.toArray(a);
        }

        /* access modifiers changed from: private */
        public void invalidate() {
            if (this.set.isEmpty()) {
                HttpClient.this.encodingField = null;
                return;
            }
            StringBuilder value = new StringBuilder();
            Iterator<ContentDecoder.Factory> iterator = this.set.iterator();
            while (iterator.hasNext()) {
                value.append(iterator.next().getEncoding());
                if (iterator.hasNext()) {
                    value.append(",");
                }
            }
            HttpClient.this.encodingField = new HttpField(HttpHeader.ACCEPT_ENCODING, value.toString());
        }
    }
}
