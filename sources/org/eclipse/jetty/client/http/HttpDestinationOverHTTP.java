package org.eclipse.jetty.client.http;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.client.PoolingHttpDestination;
import org.eclipse.jetty.client.SendFailure;
import org.eclipse.jetty.client.api.Connection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpDestinationOverHTTP.class */
public class HttpDestinationOverHTTP extends PoolingHttpDestination {
    public HttpDestinationOverHTTP(HttpClient client, Origin origin) {
        super(client, origin);
    }

    @Override // org.eclipse.jetty.client.HttpDestination
    protected SendFailure send(Connection connection, HttpExchange exchange) {
        return ((HttpConnectionOverHTTP) connection).send(exchange);
    }
}
