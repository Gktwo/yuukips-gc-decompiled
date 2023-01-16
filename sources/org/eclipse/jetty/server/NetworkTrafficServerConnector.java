package org.eclipse.jetty.server;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.ChannelEndPoint;
import org.eclipse.jetty.p023io.ManagedSelector;
import org.eclipse.jetty.p023io.NetworkTrafficListener;
import org.eclipse.jetty.p023io.NetworkTrafficSocketChannelEndPoint;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/NetworkTrafficServerConnector.class */
public class NetworkTrafficServerConnector extends ServerConnector {
    private final List<NetworkTrafficListener> listeners;

    public NetworkTrafficServerConnector(Server server) {
        this(server, null, null, null, 0, 0, new HttpConnectionFactory());
    }

    public NetworkTrafficServerConnector(Server server, ConnectionFactory connectionFactory, SslContextFactory sslContextFactory) {
        super(server, sslContextFactory, connectionFactory);
        this.listeners = new CopyOnWriteArrayList();
    }

    public NetworkTrafficServerConnector(Server server, ConnectionFactory connectionFactory) {
        super(server, connectionFactory);
        this.listeners = new CopyOnWriteArrayList();
    }

    public NetworkTrafficServerConnector(Server server, Executor executor, Scheduler scheduler, ByteBufferPool pool, int acceptors, int selectors, ConnectionFactory... factories) {
        super(server, executor, scheduler, pool, acceptors, selectors, factories);
        this.listeners = new CopyOnWriteArrayList();
    }

    public NetworkTrafficServerConnector(Server server, SslContextFactory sslContextFactory) {
        super(server, sslContextFactory);
        this.listeners = new CopyOnWriteArrayList();
    }

    public void addNetworkTrafficListener(NetworkTrafficListener listener) {
        this.listeners.add(listener);
    }

    public void removeNetworkTrafficListener(NetworkTrafficListener listener) {
        this.listeners.remove(listener);
    }

    @Override // org.eclipse.jetty.server.ServerConnector
    protected ChannelEndPoint newEndPoint(SocketChannel channel, ManagedSelector selectSet, SelectionKey key) {
        return new NetworkTrafficSocketChannelEndPoint(channel, selectSet, key, getScheduler(), getIdleTimeout(), this.listeners);
    }
}
