package org.eclipse.jetty.server;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.Channel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.EventListener;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.ChannelEndPoint;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ManagedSelector;
import org.eclipse.jetty.p023io.SelectorManager;
import org.eclipse.jetty.p023io.SocketChannelEndPoint;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.Scheduler;

@ManagedObject("HTTP connector using NIO ByteChannels and Selectors")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ServerConnector.class */
public class ServerConnector extends AbstractNetworkConnector {
    private final SelectorManager _manager;
    private final AtomicReference<Closeable> _acceptor;
    private volatile ServerSocketChannel _acceptChannel;
    private volatile boolean _inheritChannel;
    private volatile int _localPort;
    private volatile int _acceptQueueSize;
    private volatile boolean _reuseAddress;
    private volatile boolean _acceptedTcpNoDelay;
    private volatile int _acceptedReceiveBufferSize;
    private volatile int _acceptedSendBufferSize;

    public ServerConnector(@Name("server") Server server) {
        this(server, null, null, null, -1, -1, new HttpConnectionFactory());
    }

    public ServerConnector(@Name("server") Server server, @Name("acceptors") int acceptors, @Name("selectors") int selectors) {
        this(server, null, null, null, acceptors, selectors, new HttpConnectionFactory());
    }

    public ServerConnector(@Name("server") Server server, @Name("acceptors") int acceptors, @Name("selectors") int selectors, @Name("factories") ConnectionFactory... factories) {
        this(server, null, null, null, acceptors, selectors, factories);
    }

    public ServerConnector(@Name("server") Server server, @Name("factories") ConnectionFactory... factories) {
        this(server, null, null, null, -1, -1, factories);
    }

    public ServerConnector(@Name("server") Server server, @Name("sslContextFactory") SslContextFactory sslContextFactory) {
        this(server, null, null, null, -1, -1, AbstractConnectionFactory.getFactories(sslContextFactory, new HttpConnectionFactory()));
    }

    public ServerConnector(@Name("server") Server server, @Name("acceptors") int acceptors, @Name("selectors") int selectors, @Name("sslContextFactory") SslContextFactory sslContextFactory) {
        this(server, null, null, null, acceptors, selectors, AbstractConnectionFactory.getFactories(sslContextFactory, new HttpConnectionFactory()));
    }

    public ServerConnector(@Name("server") Server server, @Name("sslContextFactory") SslContextFactory sslContextFactory, @Name("factories") ConnectionFactory... factories) {
        this(server, null, null, null, -1, -1, AbstractConnectionFactory.getFactories(sslContextFactory, factories));
    }

    public ServerConnector(@Name("server") Server server, @Name("executor") Executor executor, @Name("scheduler") Scheduler scheduler, @Name("bufferPool") ByteBufferPool bufferPool, @Name("acceptors") int acceptors, @Name("selectors") int selectors, @Name("factories") ConnectionFactory... factories) {
        super(server, executor, scheduler, bufferPool, acceptors, factories);
        this._acceptor = new AtomicReference<>();
        this._inheritChannel = false;
        this._localPort = -1;
        this._acceptQueueSize = 0;
        this._reuseAddress = true;
        this._acceptedTcpNoDelay = true;
        this._acceptedReceiveBufferSize = -1;
        this._acceptedSendBufferSize = -1;
        this._manager = newSelectorManager(getExecutor(), getScheduler(), selectors);
        addBean((Object) this._manager, true);
        setAcceptorPriorityDelta(-2);
    }

    protected SelectorManager newSelectorManager(Executor executor, Scheduler scheduler, int selectors) {
        return new ServerConnectorManager(executor, scheduler, selectors);
    }

    @Override // org.eclipse.jetty.server.AbstractNetworkConnector, org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        for (EventListener l : getBeans(EventListener.class)) {
            this._manager.addEventListener(l);
        }
        doStart();
        if (getAcceptors() == 0) {
            this._acceptChannel.configureBlocking(false);
            this._acceptor.set(this._manager.acceptor(this._acceptChannel));
        }
    }

    @Override // org.eclipse.jetty.server.AbstractNetworkConnector, org.eclipse.jetty.server.AbstractConnector, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        doStop();
        for (EventListener l : getBeans(EventListener.class)) {
            this._manager.removeEventListener(l);
        }
    }

    @Override // org.eclipse.jetty.server.NetworkConnector
    public boolean isOpen() {
        ServerSocketChannel channel = this._acceptChannel;
        return channel != null && channel.isOpen();
    }

    public boolean isInheritChannel() {
        return this._inheritChannel;
    }

    public void setInheritChannel(boolean inheritChannel) {
        this._inheritChannel = inheritChannel;
    }

    public void open(ServerSocketChannel acceptChannel) throws IOException {
        if (isStarted()) {
            throw new IllegalStateException(getState());
        }
        updateBean(this._acceptChannel, acceptChannel);
        this._acceptChannel = acceptChannel;
        this._localPort = this._acceptChannel.socket().getLocalPort();
        if (this._localPort <= 0) {
            throw new IOException("Server channel not bound");
        }
    }

    @Override // org.eclipse.jetty.server.AbstractNetworkConnector, org.eclipse.jetty.server.NetworkConnector
    public void open() throws IOException {
        if (this._acceptChannel == null) {
            this._acceptChannel = openAcceptChannel();
            this._acceptChannel.configureBlocking(true);
            this._localPort = this._acceptChannel.socket().getLocalPort();
            if (this._localPort <= 0) {
                throw new IOException("Server channel not bound");
            }
            addBean(this._acceptChannel);
        }
    }

    protected ServerSocketChannel openAcceptChannel() throws IOException {
        ServerSocketChannel serverChannel = null;
        if (isInheritChannel()) {
            Channel channel = System.inheritedChannel();
            if (channel instanceof ServerSocketChannel) {
                serverChannel = (ServerSocketChannel) channel;
            } else {
                LOG.warn("Unable to use System.inheritedChannel() [{}]. Trying a new ServerSocketChannel at {}:{}", channel, getHost(), Integer.valueOf(getPort()));
            }
        }
        if (serverChannel == null) {
            InetSocketAddress bindAddress = getHost() == null ? new InetSocketAddress(getPort()) : new InetSocketAddress(getHost(), getPort());
            serverChannel = ServerSocketChannel.open();
            try {
                serverChannel.socket().setReuseAddress(getReuseAddress());
                serverChannel.socket().bind(bindAddress, getAcceptQueueSize());
            } catch (Throwable e) {
                C5739IO.close(serverChannel);
                throw new IOException("Failed to bind to " + bindAddress, e);
            }
        }
        return serverChannel;
    }

    @Override // org.eclipse.jetty.server.AbstractNetworkConnector, org.eclipse.jetty.server.NetworkConnector, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close();
        ServerSocketChannel serverChannel = this._acceptChannel;
        this._acceptChannel = null;
        if (serverChannel != null) {
            removeBean(serverChannel);
            if (serverChannel.isOpen()) {
                try {
                    serverChannel.close();
                } catch (IOException e) {
                    LOG.warn(e);
                }
            }
        }
        this._localPort = -2;
    }

    @Override // org.eclipse.jetty.server.AbstractConnector
    public void accept(int acceptorID) throws IOException {
        ServerSocketChannel serverChannel = this._acceptChannel;
        if (serverChannel != null && serverChannel.isOpen()) {
            accepted(serverChannel.accept());
        }
    }

    /* access modifiers changed from: private */
    public void accepted(SocketChannel channel) throws IOException {
        channel.configureBlocking(false);
        configure(channel.socket());
        this._manager.accept(channel);
    }

    protected void configure(Socket socket) {
        try {
            socket.setTcpNoDelay(this._acceptedTcpNoDelay);
            if (this._acceptedReceiveBufferSize > -1) {
                socket.setReceiveBufferSize(this._acceptedReceiveBufferSize);
            }
            if (this._acceptedSendBufferSize > -1) {
                socket.setSendBufferSize(this._acceptedSendBufferSize);
            }
        } catch (SocketException e) {
            LOG.ignore(e);
        }
    }

    @ManagedAttribute("The Selector Manager")
    public SelectorManager getSelectorManager() {
        return this._manager;
    }

    @Override // org.eclipse.jetty.server.Connector
    public Object getTransport() {
        return this._acceptChannel;
    }

    @Override // org.eclipse.jetty.server.AbstractNetworkConnector, org.eclipse.jetty.server.NetworkConnector
    @ManagedAttribute("local port")
    public int getLocalPort() {
        return this._localPort;
    }

    protected ChannelEndPoint newEndPoint(SocketChannel channel, ManagedSelector selectSet, SelectionKey key) throws IOException {
        SocketChannelEndPoint endpoint = new SocketChannelEndPoint(channel, selectSet, key, getScheduler());
        endpoint.setIdleTimeout(getIdleTimeout());
        return endpoint;
    }

    @ManagedAttribute(value = "Socket close linger time. Deprecated, always returns -1", readonly = true)
    @Deprecated
    public int getSoLingerTime() {
        return -1;
    }

    @Deprecated
    public void setSoLingerTime(int lingerTime) {
        LOG.warn("Ignoring deprecated socket close linger time", new Object[0]);
    }

    @ManagedAttribute("Accept Queue size")
    public int getAcceptQueueSize() {
        return this._acceptQueueSize;
    }

    public void setAcceptQueueSize(int acceptQueueSize) {
        this._acceptQueueSize = acceptQueueSize;
    }

    @ManagedAttribute("Server Socket SO_REUSEADDR")
    public boolean getReuseAddress() {
        return this._reuseAddress;
    }

    public void setReuseAddress(boolean reuseAddress) {
        this._reuseAddress = reuseAddress;
    }

    @ManagedAttribute("Accepted Socket TCP_NODELAY")
    public boolean getAcceptedTcpNoDelay() {
        return this._acceptedTcpNoDelay;
    }

    public void setAcceptedTcpNoDelay(boolean tcpNoDelay) {
        this._acceptedTcpNoDelay = tcpNoDelay;
    }

    @ManagedAttribute("Accepted Socket SO_RCVBUF")
    public int getAcceptedReceiveBufferSize() {
        return this._acceptedReceiveBufferSize;
    }

    public void setAcceptedReceiveBufferSize(int receiveBufferSize) {
        this._acceptedReceiveBufferSize = receiveBufferSize;
    }

    @ManagedAttribute("Accepted Socket SO_SNDBUF")
    public int getAcceptedSendBufferSize() {
        return this._acceptedSendBufferSize;
    }

    public void setAcceptedSendBufferSize(int sendBufferSize) {
        this._acceptedSendBufferSize = sendBufferSize;
    }

    @Override // org.eclipse.jetty.server.AbstractConnector
    public void setAccepting(boolean accepting) {
        setAccepting(accepting);
        if (getAcceptors() <= 0) {
            try {
                if (!accepting) {
                    Closeable acceptor = this._acceptor.get();
                    if (acceptor != null && this._acceptor.compareAndSet(acceptor, null)) {
                        acceptor.close();
                    }
                } else if (this._acceptor.get() == null) {
                    Closeable acceptor2 = this._manager.acceptor(this._acceptChannel);
                    if (!this._acceptor.compareAndSet(null, acceptor2)) {
                        acceptor2.close();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ServerConnector$ServerConnectorManager.class */
    public class ServerConnectorManager extends SelectorManager {
        public ServerConnectorManager(Executor executor, Scheduler scheduler, int selectors) {
            super(executor, scheduler, selectors);
        }

        @Override // org.eclipse.jetty.p023io.SelectorManager
        protected void accepted(SelectableChannel channel) throws IOException {
            ServerConnector.this.accepted((SocketChannel) channel);
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.p023io.SelectorManager
        public ChannelEndPoint newEndPoint(SelectableChannel channel, ManagedSelector selectSet, SelectionKey selectionKey) throws IOException {
            return ServerConnector.this.newEndPoint((SocketChannel) channel, selectSet, selectionKey);
        }

        @Override // org.eclipse.jetty.p023io.SelectorManager
        public Connection newConnection(SelectableChannel channel, EndPoint endpoint, Object attachment) throws IOException {
            return ServerConnector.this.getDefaultConnectionFactory().newConnection(ServerConnector.this, endpoint);
        }

        @Override // org.eclipse.jetty.p023io.SelectorManager
        protected void endPointOpened(EndPoint endpoint) {
            endPointOpened(endpoint);
            ServerConnector.this.onEndPointOpened(endpoint);
        }

        @Override // org.eclipse.jetty.p023io.SelectorManager
        protected void endPointClosed(EndPoint endpoint) {
            ServerConnector.this.onEndPointClosed(endpoint);
            endPointClosed(endpoint);
        }

        @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
        public String toString() {
            return String.format("SelectorManager@%s", ServerConnector.this);
        }
    }
}
