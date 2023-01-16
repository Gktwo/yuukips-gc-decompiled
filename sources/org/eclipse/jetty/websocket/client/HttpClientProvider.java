package org.eclipse.jetty.websocket.client;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/HttpClientProvider.class */
public final class HttpClientProvider {
    public static HttpClient get(WebSocketContainerScope scope) {
        HttpClient httpClient = XmlBasedHttpClientProvider.get(scope);
        if (httpClient != null) {
            return httpClient;
        }
        return DefaultHttpClientProvider.newHttpClient(scope);
    }
}
