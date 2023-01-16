package org.eclipse.jetty.client;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.client.ProxyConfiguration;
import org.eclipse.jetty.client.api.Destination;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.http.HttpConnectionOverHTTP;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.p023io.ClientConnectionFactory;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ssl.SslClientConnectionFactory;
import org.eclipse.jetty.util.Attachable;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpProxy.class */
public class HttpProxy extends ProxyConfiguration.Proxy {
    private static final Logger LOG = Log.getLogger(HttpProxy.class);

    public HttpProxy(String host, int port) {
        this(new Origin.Address(host, port), false);
    }

    public HttpProxy(Origin.Address address, boolean secure) {
        super(address, secure);
    }

    public HttpProxy(Origin.Address address, SslContextFactory.Client sslContextFactory) {
        super(address, sslContextFactory);
    }

    @Override // org.eclipse.jetty.client.ProxyConfiguration.Proxy
    public ClientConnectionFactory newClientConnectionFactory(ClientConnectionFactory connectionFactory) {
        return new HttpProxyClientConnectionFactory(connectionFactory);
    }

    @Override // org.eclipse.jetty.client.ProxyConfiguration.Proxy
    public URI getURI() {
        return URI.create(new Origin(isSecure() ? HttpScheme.HTTPS.asString() : HttpScheme.HTTP.asString(), getAddress()).asString());
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpProxy$HttpProxyClientConnectionFactory.class */
    private static class HttpProxyClientConnectionFactory implements ClientConnectionFactory {
        private final ClientConnectionFactory connectionFactory;

        private HttpProxyClientConnectionFactory(ClientConnectionFactory connectionFactory) {
            this.connectionFactory = connectionFactory;
        }

        @Override // org.eclipse.jetty.p023io.ClientConnectionFactory
        public Connection newConnection(EndPoint endPoint, Map<String, Object> context) throws IOException {
            HttpDestination destination = (HttpDestination) context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY);
            SslContextFactory sslContextFactory = destination.getHttpClient().getSslContextFactory();
            if (!destination.isSecure()) {
                return this.connectionFactory.newConnection(endPoint, context);
            }
            if (sslContextFactory != null) {
                Promise<org.eclipse.jetty.client.api.Connection> promise = (Promise) context.get(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY);
                Promise<org.eclipse.jetty.client.api.Connection> wrapped = promise;
                if (promise instanceof Promise.Wrapper) {
                    wrapped = ((Promise.Wrapper) promise).unwrap();
                }
                if (wrapped instanceof TunnelPromise) {
                    ((TunnelPromise) wrapped).setEndPoint(endPoint);
                    return this.connectionFactory.newConnection(endPoint, context);
                }
                context.put(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY, new CreateTunnelPromise(this.connectionFactory, endPoint, promise, context));
                return this.connectionFactory.newConnection(endPoint, context);
            }
            throw new IOException("Cannot tunnel request, missing " + SslContextFactory.class.getName() + " in " + HttpClient.class.getName());
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpProxy$CreateTunnelPromise.class */
    private static class CreateTunnelPromise implements Promise<org.eclipse.jetty.client.api.Connection> {
        private final ClientConnectionFactory connectionFactory;
        private final EndPoint endPoint;
        private final Promise<org.eclipse.jetty.client.api.Connection> promise;
        private final Map<String, Object> context;

        private CreateTunnelPromise(ClientConnectionFactory connectionFactory, EndPoint endPoint, Promise<org.eclipse.jetty.client.api.Connection> promise, Map<String, Object> context) {
            this.connectionFactory = connectionFactory;
            this.endPoint = endPoint;
            this.promise = promise;
            this.context = context;
        }

        public void succeeded(org.eclipse.jetty.client.api.Connection connection) {
            tunnel((HttpDestination) this.context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY), connection);
        }

        @Override // org.eclipse.jetty.util.Promise
        public void failed(Throwable x) {
            tunnelFailed(this.endPoint, x);
        }

        private void tunnel(HttpDestination destination, org.eclipse.jetty.client.api.Connection connection) {
            String target = destination.getOrigin().getAddress().asString();
            Origin.Address proxyAddress = destination.getConnectAddress();
            HttpClient httpClient = destination.getHttpClient();
            long connectTimeout = httpClient.getConnectTimeout();
            Request connect = httpClient.newRequest(proxyAddress.getHost(), proxyAddress.getPort()).method(HttpMethod.CONNECT).path(target).header(HttpHeader.HOST, target).idleTimeout(2 * connectTimeout, TimeUnit.MILLISECONDS).timeout(connectTimeout, TimeUnit.MILLISECONDS);
            ProxyConfiguration.Proxy proxy = destination.getProxy();
            if (proxy != null && proxy.isSecure()) {
                connect.scheme(HttpScheme.HTTPS.asString());
            }
            HttpConversation conversation = ((HttpRequest) connect).getConversation();
            conversation.setAttribute(EndPoint.class.getName(), this.endPoint);
            connect.attribute(org.eclipse.jetty.client.api.Connection.class.getName(), new ProxyConnection(destination, connection, this.promise));
            connection.send(connect, result -> {
                EndPoint endPoint = (EndPoint) conversation.getAttribute(EndPoint.class.getName());
                if (conversation.isSucceeded()) {
                    Response response = conversation.getResponse();
                    if (response.getStatus() == 200) {
                        tunnelSucceeded(endPoint);
                    } else {
                        tunnelFailed(endPoint, new HttpResponseException("Unexpected " + response + " for " + conversation.getRequest(), response));
                    }
                } else {
                    tunnelFailed(endPoint, conversation.getFailure());
                }
            });
        }

        private void tunnelSucceeded(EndPoint endPoint) {
            try {
                this.context.put(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY, this.promise);
                HttpDestination destination = (HttpDestination) this.context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY);
                ClientConnectionFactory sslConnectionFactory = destination.newSslClientConnectionFactory(null, this.connectionFactory);
                HttpConnectionOverHTTP oldConnection = (HttpConnectionOverHTTP) endPoint.getConnection();
                this.context.put(SslClientConnectionFactory.SSL_PEER_HOST_CONTEXT_KEY, destination.getHost());
                this.context.put(SslClientConnectionFactory.SSL_PEER_PORT_CONTEXT_KEY, Integer.valueOf(destination.getPort()));
                Connection newConnection = sslConnectionFactory.newConnection(endPoint, this.context);
                endPoint.setConnection(oldConnection);
                endPoint.upgrade(newConnection);
                if (HttpProxy.LOG.isDebugEnabled()) {
                    HttpProxy.LOG.debug("HTTP tunnel established: {} over {}", oldConnection, newConnection);
                }
            } catch (Throwable x) {
                tunnelFailed(endPoint, x);
            }
        }

        private void tunnelFailed(EndPoint endPoint, Throwable failure) {
            endPoint.close();
            this.promise.failed(failure);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpProxy$ProxyConnection.class */
    public static class ProxyConnection implements org.eclipse.jetty.client.api.Connection, Attachable {
        private final Destination destination;
        private final org.eclipse.jetty.client.api.Connection connection;
        private final Promise<org.eclipse.jetty.client.api.Connection> promise;
        private Object attachment;

        private ProxyConnection(Destination destination, org.eclipse.jetty.client.api.Connection connection, Promise<org.eclipse.jetty.client.api.Connection> promise) {
            this.destination = destination;
            this.connection = connection;
            this.promise = promise;
        }

        @Override // org.eclipse.jetty.client.api.Connection
        public void send(Request request, Response.CompleteListener listener) {
            if (this.connection.isClosed()) {
                this.destination.newConnection(new TunnelPromise(request, listener, this.promise));
            } else {
                this.connection.send(request, listener);
            }
        }

        @Override // org.eclipse.jetty.client.api.Connection, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.connection.close();
        }

        @Override // org.eclipse.jetty.client.api.Connection
        public boolean isClosed() {
            return this.connection.isClosed();
        }

        @Override // org.eclipse.jetty.util.Attachable
        public void setAttachment(Object obj) {
            this.attachment = obj;
        }

        @Override // org.eclipse.jetty.util.Attachable
        public Object getAttachment() {
            return this.attachment;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpProxy$TunnelPromise.class */
    private static class TunnelPromise implements Promise<org.eclipse.jetty.client.api.Connection> {
        private final Request request;
        private final Response.CompleteListener listener;
        private final Promise<org.eclipse.jetty.client.api.Connection> promise;

        private TunnelPromise(Request request, Response.CompleteListener listener, Promise<org.eclipse.jetty.client.api.Connection> promise) {
            this.request = request;
            this.listener = listener;
            this.promise = promise;
        }

        public void succeeded(org.eclipse.jetty.client.api.Connection connection) {
            connection.send(this.request, this.listener);
        }

        @Override // org.eclipse.jetty.util.Promise
        public void failed(Throwable x) {
            this.promise.failed(x);
        }

        /* access modifiers changed from: private */
        public void setEndPoint(EndPoint endPoint) {
            ((HttpRequest) this.request).getConversation().setAttribute(EndPoint.class.getName(), endPoint);
        }
    }
}
