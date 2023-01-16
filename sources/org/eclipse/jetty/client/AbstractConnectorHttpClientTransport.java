package org.eclipse.jetty.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ManagedSelector;
import org.eclipse.jetty.p023io.SelectorManager;
import org.eclipse.jetty.p023io.SocketChannelEndPoint;
import org.eclipse.jetty.p023io.ssl.SslClientConnectionFactory;
import org.eclipse.jetty.util.Promise;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/AbstractConnectorHttpClientTransport.class */
public abstract class AbstractConnectorHttpClientTransport extends AbstractHttpClientTransport {
    private final int selectors;
    private SelectorManager selectorManager;

    /* access modifiers changed from: protected */
    public AbstractConnectorHttpClientTransport(int selectors) {
        this.selectors = selectors;
    }

    @ManagedAttribute(value = "The number of selectors", readonly = true)
    public int getSelectors() {
        return this.selectors;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        HttpClient httpClient = getHttpClient();
        this.selectorManager = newSelectorManager(httpClient);
        this.selectorManager.setConnectTimeout(httpClient.getConnectTimeout());
        addBean(this.selectorManager);
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        removeBean(this.selectorManager);
    }

    @Override // org.eclipse.jetty.client.HttpClientTransport
    public void connect(InetSocketAddress address, Map<String, Object> context) {
        SocketChannel channel = null;
        try {
            SocketChannel channel2 = SocketChannel.open();
            HttpClient client = ((HttpDestination) context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY)).getHttpClient();
            SocketAddress bindAddress = client.getBindAddress();
            if (bindAddress != null) {
                channel2.bind(bindAddress);
            }
            configure(client, channel2);
            context.put(SslClientConnectionFactory.SSL_PEER_HOST_CONTEXT_KEY, address.getHostString());
            context.put(SslClientConnectionFactory.SSL_PEER_PORT_CONTEXT_KEY, Integer.valueOf(address.getPort()));
            boolean connected = true;
            if (client.isConnectBlocking()) {
                channel2.socket().connect(address, (int) client.getConnectTimeout());
                channel2.configureBlocking(false);
            } else {
                channel2.configureBlocking(false);
                connected = channel2.connect(address);
            }
            if (connected) {
                this.selectorManager.accept(channel2, context);
            } else {
                this.selectorManager.connect(channel2, context);
            }
        } catch (Throwable th) {
            x = th;
            if (x.getClass() == SocketException.class) {
                x = new SocketException("Could not connect to " + address).initCause(x);
            }
            try {
                if (0 != 0) {
                    try {
                        channel.close();
                    } catch (IOException ignored) {
                        LOG.ignore(ignored);
                        connectFailed(context, x);
                        return;
                    }
                }
                connectFailed(context, x);
            } catch (Throwable th2) {
                connectFailed(context, x);
                throw th2;
            }
        }
    }

    protected void connectFailed(Map<String, Object> context, Throwable x) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Could not connect to {}", context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY));
        }
        ((Promise) context.get(HttpClientTransport.HTTP_CONNECTION_PROMISE_CONTEXT_KEY)).failed(x);
    }

    protected void configure(HttpClient client, SocketChannel channel) throws IOException {
        channel.socket().setTcpNoDelay(client.isTCPNoDelay());
    }

    protected SelectorManager newSelectorManager(HttpClient client) {
        return new ClientSelectorManager(client, getSelectors());
    }

    protected SelectorManager getSelectorManager() {
        return this.selectorManager;
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/AbstractConnectorHttpClientTransport$ClientSelectorManager.class */
    public class ClientSelectorManager extends SelectorManager {
        private final HttpClient client;

        protected ClientSelectorManager(HttpClient client, int selectors) {
            super(client.getExecutor(), client.getScheduler(), selectors);
            this.client = client;
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.p023io.SelectorManager
        public EndPoint newEndPoint(SelectableChannel channel, ManagedSelector selector, SelectionKey key) {
            SocketChannelEndPoint endp = new SocketChannelEndPoint(channel, selector, key, getScheduler());
            endp.setIdleTimeout(this.client.getIdleTimeout());
            return endp;
        }

        @Override // org.eclipse.jetty.p023io.SelectorManager
        public Connection newConnection(SelectableChannel channel, EndPoint endPoint, Object attachment) throws IOException {
            Map<String, Object> context = (Map) attachment;
            return ((HttpDestination) context.get(HttpClientTransport.HTTP_DESTINATION_CONTEXT_KEY)).getClientConnectionFactory().newConnection(endPoint, context);
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.p023io.SelectorManager
        public void connectionFailed(SelectableChannel channel, Throwable x, Object attachment) {
            AbstractConnectorHttpClientTransport.this.connectFailed((Map) attachment, x);
        }
    }
}
