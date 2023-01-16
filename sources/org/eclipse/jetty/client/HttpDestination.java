package org.eclipse.jetty.client;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.client.ProxyConfiguration;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.Destination;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.p023io.ClientConnectionFactory;
import org.eclipse.jetty.p023io.CyclicTimeouts;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.HostPort;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.util.thread.Sweeper;
import p013io.javalin.http.sse.EmitterKt;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpDestination.class */
public abstract class HttpDestination extends ContainerLifeCycle implements Destination, Closeable, Callback, Dumpable {
    private static final Logger LOG = Log.getLogger(HttpDestination.class);
    private final HttpClient client;
    private final Origin origin;
    private final Queue<HttpExchange> exchanges;
    private final RequestNotifier requestNotifier;
    private final ResponseNotifier responseNotifier = new ResponseNotifier();
    private final ProxyConfiguration.Proxy proxy;
    private final ClientConnectionFactory connectionFactory;
    private final HttpField hostField;
    private final RequestTimeouts requestTimeouts;
    private ConnectionPool connectionPool;

    protected abstract SendFailure send(Connection connection, HttpExchange httpExchange);

    public HttpDestination(HttpClient client, Origin origin) {
        this.client = client;
        this.origin = origin;
        this.exchanges = newExchangeQueue(client);
        this.requestNotifier = new RequestNotifier(client);
        this.requestTimeouts = new RequestTimeouts(client.getScheduler());
        this.proxy = client.getProxyConfiguration().match(origin);
        ClientConnectionFactory connectionFactory = client.getTransport();
        if (this.proxy != null) {
            connectionFactory = this.proxy.newClientConnectionFactory(connectionFactory);
            if (this.proxy.isSecure()) {
                connectionFactory = newSslClientConnectionFactory(this.proxy.getSslContextFactory(), connectionFactory);
            }
        } else if (isSecure()) {
            connectionFactory = newSslClientConnectionFactory(null, connectionFactory);
        }
        Object tag = origin.getTag();
        this.connectionFactory = tag instanceof ClientConnectionFactory.Decorator ? ((ClientConnectionFactory.Decorator) tag).apply(connectionFactory) : connectionFactory;
        String host = HostPort.normalizeHost(getHost());
        this.hostField = new HttpField(HttpHeader.HOST, !client.isDefaultPort(getScheme(), getPort()) ? host + EmitterKt.COMMENT_PREFIX + getPort() : host);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        this.connectionPool = newConnectionPool(this.client);
        addBean((Object) this.connectionPool, true);
        doStart();
        Sweeper sweeper = (Sweeper) this.client.getBean((Class<Object>) Sweeper.class);
        if (sweeper != null && (this.connectionPool instanceof Sweeper.Sweepable)) {
            sweeper.offer((Sweeper.Sweepable) this.connectionPool);
        }
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        Sweeper sweeper = (Sweeper) this.client.getBean((Class<Object>) Sweeper.class);
        if (sweeper != null && (this.connectionPool instanceof Sweeper.Sweepable)) {
            sweeper.remove((Sweeper.Sweepable) this.connectionPool);
        }
        doStop();
        removeBean(this.connectionPool);
    }

    protected ConnectionPool newConnectionPool(HttpClient client) {
        return client.getTransport().getConnectionPoolFactory().newConnectionPool(this);
    }

    protected Queue<HttpExchange> newExchangeQueue(HttpClient client) {
        return new BlockingArrayQueue(client.getMaxRequestsQueuedPerDestination());
    }

    @Deprecated
    protected ClientConnectionFactory newSslClientConnectionFactory(ClientConnectionFactory connectionFactory) {
        return this.client.newSslClientConnectionFactory(null, connectionFactory);
    }

    /* access modifiers changed from: protected */
    public ClientConnectionFactory newSslClientConnectionFactory(SslContextFactory sslContextFactory, ClientConnectionFactory connectionFactory) {
        if (sslContextFactory == null) {
            return newSslClientConnectionFactory(connectionFactory);
        }
        return this.client.newSslClientConnectionFactory(sslContextFactory, connectionFactory);
    }

    public boolean isSecure() {
        return HttpClient.isSchemeSecure(getScheme());
    }

    public HttpClient getHttpClient() {
        return this.client;
    }

    public Origin getOrigin() {
        return this.origin;
    }

    public Queue<HttpExchange> getHttpExchanges() {
        return this.exchanges;
    }

    public RequestNotifier getRequestNotifier() {
        return this.requestNotifier;
    }

    public ResponseNotifier getResponseNotifier() {
        return this.responseNotifier;
    }

    public ProxyConfiguration.Proxy getProxy() {
        return this.proxy;
    }

    public ClientConnectionFactory getClientConnectionFactory() {
        return this.connectionFactory;
    }

    @Override // org.eclipse.jetty.client.api.Destination
    @ManagedAttribute(value = "The destination scheme", readonly = true)
    public String getScheme() {
        return this.origin.getScheme();
    }

    @Override // org.eclipse.jetty.client.api.Destination
    @ManagedAttribute(value = "The destination host", readonly = true)
    public String getHost() {
        return this.origin.getAddress().getHost();
    }

    @Override // org.eclipse.jetty.client.api.Destination
    @ManagedAttribute(value = "The destination port", readonly = true)
    public int getPort() {
        return this.origin.getAddress().getPort();
    }

    @ManagedAttribute(value = "The number of queued requests", readonly = true)
    public int getQueuedRequestCount() {
        return this.exchanges.size();
    }

    public Origin.Address getConnectAddress() {
        return this.proxy == null ? this.origin.getAddress() : this.proxy.getAddress();
    }

    public HttpField getHostField() {
        return this.hostField;
    }

    @ManagedAttribute(value = "The connection pool", readonly = true)
    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Override // org.eclipse.jetty.util.Callback
    public void succeeded() {
        send(false);
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable x) {
        abort(x);
    }

    public void send(Request request, Response.CompleteListener listener) {
        ((HttpRequest) request).sendAsync(this, listener);
    }

    /* access modifiers changed from: protected */
    public void send(HttpRequest request, List<Response.ResponseListener> listeners) {
        send(new HttpExchange(this, request, listeners));
    }

    public void send(HttpExchange exchange) {
        HttpRequest request = exchange.getRequest();
        if (!this.client.isRunning()) {
            request.abort(new RejectedExecutionException(this.client + " is stopped"));
        } else if (enqueue(this.exchanges, exchange)) {
            this.requestTimeouts.schedule((RequestTimeouts) exchange);
            if (this.client.isRunning() || !this.exchanges.remove(exchange)) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Queued {} for {}", request, this);
                }
                this.requestNotifier.notifyQueued(request);
                send();
                return;
            }
            request.abort(new RejectedExecutionException(this.client + " is stopping"));
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Max queue size {} exceeded by {} for {}", Integer.valueOf(this.client.getMaxRequestsQueuedPerDestination()), request, this);
            }
            request.abort(new RejectedExecutionException("Max requests queued per destination " + this.client.getMaxRequestsQueuedPerDestination() + " exceeded for " + this));
        }
    }

    protected boolean enqueue(Queue<HttpExchange> queue, HttpExchange exchange) {
        return queue.offer(exchange);
    }

    public void send() {
        send(true);
    }

    private void send(boolean create) {
        if (!getHttpExchanges().isEmpty()) {
            process(create);
        }
    }

    private void process(boolean create) {
        Connection connection;
        while (true) {
            if (this.connectionPool instanceof AbstractConnectionPool) {
                connection = ((AbstractConnectionPool) this.connectionPool).acquire(create);
            } else {
                connection = this.connectionPool.acquire();
            }
            if (connection != null && process(connection)) {
                create = false;
            } else {
                return;
            }
        }
    }

    private boolean process(Connection connection) {
        HttpClient client = getHttpClient();
        HttpExchange exchange = getHttpExchanges().poll();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Processing exchange {} on {} of {}", exchange, connection, this);
        }
        if (exchange == null) {
            if (!this.connectionPool.release(connection)) {
                connection.close();
            }
            if (client.isRunning()) {
                return false;
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} is stopping", client);
            }
            connection.close();
            return false;
        }
        Request request = exchange.getRequest();
        Throwable cause = request.getAbortCause();
        if (cause != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Aborted before processing {}: {}", exchange, cause);
            }
            if (!this.connectionPool.release(connection)) {
                connection.close();
            }
            exchange.abort(cause);
            return getQueuedRequestCount() > 0;
        }
        SendFailure failure = send(connection, exchange);
        if (failure == null) {
            return getQueuedRequestCount() > 0;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Send failed {} for {}", failure, exchange);
        }
        if (failure.retry) {
            send(exchange);
            return false;
        }
        request.abort(failure.failure);
        return getQueuedRequestCount() > 0;
    }

    @Override // org.eclipse.jetty.client.api.Destination
    public void newConnection(Promise<Connection> promise) {
        createConnection(promise);
    }

    protected void createConnection(Promise<Connection> promise) {
        this.client.newConnection(this, promise);
    }

    public boolean remove(HttpExchange exchange) {
        return this.exchanges.remove(exchange);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        abort(new AsynchronousCloseException());
        if (LOG.isDebugEnabled()) {
            LOG.debug("Closed {}", this);
        }
        this.connectionPool.close();
        this.requestTimeouts.destroy();
    }

    public void release(Connection connection) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Released {}", connection);
        }
        HttpClient client = getHttpClient();
        if (!client.isRunning()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} is stopped", client);
            }
            connection.close();
        } else if (this.connectionPool.isActive(connection)) {
            if (this.connectionPool.release(connection)) {
                send(false);
                return;
            }
            connection.close();
            send(true);
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("Released explicit {}", connection);
        }
    }

    public boolean remove(Connection connection) {
        boolean removed = this.connectionPool.remove(connection);
        if (getHttpExchanges().isEmpty()) {
            tryRemoveIdleDestination();
        } else if (removed) {
            send(true);
        }
        return removed;
    }

    @Deprecated
    public void close(Connection connection) {
        remove(connection);
    }

    public void abort(Throwable cause) {
        Iterator it = new ArrayList(this.exchanges).iterator();
        while (it.hasNext()) {
            ((HttpExchange) it.next()).getRequest().abort(cause);
        }
        if (this.exchanges.isEmpty()) {
            tryRemoveIdleDestination();
        }
    }

    private void tryRemoveIdleDestination() {
        if (getHttpClient().isRemoveIdleDestinations() && this.connectionPool.isEmpty()) {
            getHttpClient().removeDestination(this);
        }
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, new DumpableCollection("exchanges", this.exchanges));
    }

    public String asString() {
        return this.origin.asString();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = HttpDestination.class.getSimpleName();
        objArr[1] = asString();
        objArr[2] = Integer.valueOf(hashCode());
        objArr[3] = this.proxy == null ? "" : "(via " + this.proxy + ")";
        objArr[4] = Integer.valueOf(getQueuedRequestCount());
        objArr[5] = getConnectionPool();
        return String.format("%s[%s]@%x%s,queue=%d,pool=%s", objArr);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpDestination$RequestTimeouts.class */
    public class RequestTimeouts extends CyclicTimeouts<HttpExchange> {
        private RequestTimeouts(Scheduler scheduler) {
            super(scheduler);
        }

        @Override // org.eclipse.jetty.p023io.CyclicTimeouts
        protected Iterator<HttpExchange> iterator() {
            return HttpDestination.this.exchanges.iterator();
        }

        /* access modifiers changed from: protected */
        public boolean onExpired(HttpExchange exchange) {
            HttpRequest request = exchange.getRequest();
            request.abort(new TimeoutException("Total timeout " + request.getConversation().getTimeout() + " ms elapsed"));
            return false;
        }
    }
}
