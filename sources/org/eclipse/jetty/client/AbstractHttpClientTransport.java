package org.eclipse.jetty.client;

import org.eclipse.jetty.client.ConnectionPool;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/AbstractHttpClientTransport.class */
public abstract class AbstractHttpClientTransport extends ContainerLifeCycle implements HttpClientTransport {
    protected static final Logger LOG = Log.getLogger(HttpClientTransport.class);
    private HttpClient client;
    private ConnectionPool.Factory factory;

    protected HttpClient getHttpClient() {
        return this.client;
    }

    @Override // org.eclipse.jetty.client.HttpClientTransport
    public void setHttpClient(HttpClient client) {
        this.client = client;
    }

    @Override // org.eclipse.jetty.client.HttpClientTransport
    public ConnectionPool.Factory getConnectionPoolFactory() {
        return this.factory;
    }

    @Override // org.eclipse.jetty.client.HttpClientTransport
    public void setConnectionPoolFactory(ConnectionPool.Factory factory) {
        this.factory = factory;
    }
}
