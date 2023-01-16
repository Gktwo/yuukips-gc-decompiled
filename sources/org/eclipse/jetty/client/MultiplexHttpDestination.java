package org.eclipse.jetty.client;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/MultiplexHttpDestination.class */
public abstract class MultiplexHttpDestination extends HttpDestination {
    protected MultiplexHttpDestination(HttpClient client, Origin origin) {
        super(client, origin);
    }

    public int getMaxRequestsPerConnection() {
        ConnectionPool connectionPool = getConnectionPool();
        if (connectionPool instanceof AbstractConnectionPool) {
            return ((AbstractConnectionPool) connectionPool).getMaxMultiplex();
        }
        return 1;
    }

    public void setMaxRequestsPerConnection(int maxRequestsPerConnection) {
        ConnectionPool connectionPool = getConnectionPool();
        if (connectionPool instanceof AbstractConnectionPool) {
            ((AbstractConnectionPool) connectionPool).setMaxMultiplex(maxRequestsPerConnection);
        }
    }
}
