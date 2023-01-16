package org.eclipse.jetty.client.http;

import java.io.IOException;
import java.util.Map;
import org.eclipse.jetty.client.AbstractConnectorHttpClientTransport;
import org.eclipse.jetty.client.DuplexConnectionPool;
import org.eclipse.jetty.client.HttpClientTransport;
import org.eclipse.jetty.client.HttpDestination;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.ProcessorUtils;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject("The HTTP/1.1 client transport")
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpClientTransportOverHTTP.class */
public class HttpClientTransportOverHTTP extends AbstractConnectorHttpClientTransport {
    private int headerCacheSize;

    public HttpClientTransportOverHTTP() {
        this(Math.max(1, ProcessorUtils.availableProcessors() / 2));
    }

    public HttpClientTransportOverHTTP(int selectors) {
        super(selectors);
        this.headerCacheSize = 1024;
        setConnectionPoolFactory(destination -> {
            return new DuplexConnectionPool(destination, getHttpClient().getMaxConnectionsPerDestination(), destination);
        });
    }

    @Override // org.eclipse.jetty.client.HttpClientTransport
    public HttpDestination newHttpDestination(Origin origin) {
        return new HttpDestinationOverHTTP(getHttpClient(), origin);
    }

    @Override // org.eclipse.jetty.p023io.ClientConnectionFactory
    public Connection newConnection(EndPoint endPoint, Map<String, Object> context) throws IOException {
        HttpConnectionOverHTTP connection = newHttpConnection(endPoint, (HttpDestination) context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY), (Promise) context.get(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY));
        if (LOG.isDebugEnabled()) {
            LOG.debug("Created {}", connection);
        }
        return customize(connection, context);
    }

    protected HttpConnectionOverHTTP newHttpConnection(EndPoint endPoint, HttpDestination destination, Promise<org.eclipse.jetty.client.api.Connection> promise) {
        return new HttpConnectionOverHTTP(endPoint, destination, promise);
    }

    @ManagedAttribute("The maximum allowed size in bytes for an HTTP header field cache")
    public int getHeaderCacheSize() {
        return this.headerCacheSize;
    }

    public void setHeaderCacheSize(int headerCacheSize) {
        this.headerCacheSize = headerCacheSize;
    }
}
