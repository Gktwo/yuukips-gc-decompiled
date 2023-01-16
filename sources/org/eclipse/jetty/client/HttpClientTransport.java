package org.eclipse.jetty.client;

import java.net.InetSocketAddress;
import java.util.Map;
import org.eclipse.jetty.client.ConnectionPool;
import org.eclipse.jetty.p023io.ClientConnectionFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpClientTransport.class */
public interface HttpClientTransport extends ClientConnectionFactory {
    public static final String HTTP_DESTINATION_CONTEXT_KEY = "http.destination";
    public static final String HTTP_CONNECTION_PROMISE_CONTEXT_KEY = "http.connection.promise";

    void setHttpClient(HttpClient httpClient);

    HttpDestination newHttpDestination(Origin origin);

    void connect(InetSocketAddress inetSocketAddress, Map<String, Object> map);

    ConnectionPool.Factory getConnectionPoolFactory();

    void setConnectionPoolFactory(ConnectionPool.Factory factory);
}
