package org.eclipse.jetty.websocket.client;

import java.util.concurrent.Executor;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.MappedByteBufferPool;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/DefaultHttpClientProvider.class */
class DefaultHttpClientProvider {
    DefaultHttpClientProvider() {
    }

    public static HttpClient newHttpClient(WebSocketContainerScope scope) {
        SslContextFactory sslContextFactory = null;
        Executor executor = null;
        ByteBufferPool bufferPool = null;
        if (scope != null) {
            sslContextFactory = scope.getSslContextFactory();
            executor = scope.getExecutor();
            bufferPool = scope.getBufferPool();
        }
        if (sslContextFactory == null) {
            sslContextFactory = new SslContextFactory.Client();
            sslContextFactory.setTrustAll(false);
            sslContextFactory.setEndpointIdentificationAlgorithm("HTTPS");
        }
        HttpClient client = new HttpClient(sslContextFactory);
        if (executor == null) {
            QueuedThreadPool threadPool = new QueuedThreadPool();
            threadPool.setName("WebSocketClient@" + client.hashCode());
            threadPool.setDaemon(true);
            executor = threadPool;
        }
        client.setExecutor(executor);
        if (bufferPool == null) {
            bufferPool = new MappedByteBufferPool();
        }
        client.setByteBufferPool(bufferPool);
        return client;
    }
}
