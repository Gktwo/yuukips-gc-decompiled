package com.mongodb.internal.connection;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoNodeIsRecoveringException;
import com.mongodb.MongoNotPrimaryException;
import com.mongodb.MongoSecurityException;
import com.mongodb.MongoSocketException;
import com.mongodb.MongoSocketReadTimeoutException;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ServerConnectionState;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerId;
import com.mongodb.connection.TopologyVersion;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.CommandListener;
import com.mongodb.event.ServerClosedEvent;
import com.mongodb.event.ServerDescriptionChangedEvent;
import com.mongodb.event.ServerListener;
import com.mongodb.event.ServerOpeningEvent;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.connection.ClusterableServer;
import com.mongodb.internal.session.SessionContext;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultServer.class */
public class DefaultServer implements ClusterableServer {
    private static final Logger LOGGER = Loggers.getLogger("connection");
    private static final List<Integer> SHUTDOWN_CODES = Arrays.asList(91, 11600);
    private final ServerId serverId;
    private final ConnectionPool connectionPool;
    private final ClusterConnectionMode clusterConnectionMode;
    private final ConnectionFactory connectionFactory;
    private final ServerMonitor serverMonitor;
    private final ChangeListener<ServerDescription> serverStateListener = new DefaultServerStateListener();
    private final ServerDescriptionChangedListener serverDescriptionChangedListener;
    private final ServerListener serverListener;
    private final CommandListener commandListener;
    private final ClusterClock clusterClock;
    private volatile ServerDescription description;
    private volatile boolean isClosed;

    /* access modifiers changed from: package-private */
    public DefaultServer(ServerId serverId, ClusterConnectionMode clusterConnectionMode, ConnectionPool connectionPool, ConnectionFactory connectionFactory, ServerMonitorFactory serverMonitorFactory, ServerDescriptionChangedListener serverDescriptionChangedListener, ServerListener serverListener, CommandListener commandListener, ClusterClock clusterClock) {
        this.serverDescriptionChangedListener = (ServerDescriptionChangedListener) Assertions.notNull("internalServerListener", serverDescriptionChangedListener);
        this.serverListener = (ServerListener) Assertions.notNull("serverListener", serverListener);
        this.commandListener = commandListener;
        this.clusterClock = (ClusterClock) Assertions.notNull("clusterClock", clusterClock);
        Assertions.notNull("serverAddress", serverId);
        Assertions.notNull("serverMonitorFactory", serverMonitorFactory);
        this.clusterConnectionMode = (ClusterConnectionMode) Assertions.notNull("clusterConnectionMode", clusterConnectionMode);
        this.connectionFactory = (ConnectionFactory) Assertions.notNull("connectionFactory", connectionFactory);
        this.connectionPool = (ConnectionPool) Assertions.notNull("connectionPool", connectionPool);
        this.serverId = serverId;
        serverListener.serverOpening(new ServerOpeningEvent(this.serverId));
        this.description = ServerDescription.builder().state(ServerConnectionState.CONNECTING).address(serverId.getAddress()).build();
        this.serverMonitor = serverMonitorFactory.create(this.serverStateListener);
        this.serverMonitor.start();
    }

    @Override // com.mongodb.internal.connection.Server
    public Connection getConnection() {
        Assertions.isTrue("open", !isClosed());
        try {
            return this.connectionFactory.create(this.connectionPool.get(), new DefaultServerProtocolExecutor(), this.clusterConnectionMode);
        } catch (MongoSecurityException e) {
            this.connectionPool.invalidate();
            throw e;
        } catch (MongoSocketException e2) {
            invalidate(ClusterableServer.ConnectionState.BEFORE_HANDSHAKE, e2, this.connectionPool.getGeneration(), this.description.getMaxWireVersion());
            throw e2;
        }
    }

    @Override // com.mongodb.internal.connection.Server
    public void getConnectionAsync(final SingleResultCallback<AsyncConnection> callback) {
        Assertions.isTrue("open", !isClosed());
        this.connectionPool.getAsync(new SingleResultCallback<InternalConnection>() { // from class: com.mongodb.internal.connection.DefaultServer.1
            public void onResult(InternalConnection result, Throwable t) {
                if (t instanceof MongoSecurityException) {
                    DefaultServer.this.connectionPool.invalidate();
                } else if (t instanceof MongoSocketException) {
                    DefaultServer.this.invalidate(ClusterableServer.ConnectionState.BEFORE_HANDSHAKE, t, DefaultServer.this.connectionPool.getGeneration(), DefaultServer.this.description.getMaxWireVersion());
                }
                if (t != null) {
                    callback.onResult(null, t);
                } else {
                    callback.onResult(DefaultServer.this.connectionFactory.createAsync(result, new DefaultServerProtocolExecutor(), DefaultServer.this.clusterConnectionMode), null);
                }
            }
        });
    }

    @Override // com.mongodb.internal.connection.ClusterableServer
    public void resetToConnecting() {
        this.serverStateListener.stateChanged(new ChangeEvent<>(this.description, ServerDescription.builder().state(ServerConnectionState.CONNECTING).address(this.serverId.getAddress()).build()));
    }

    @Override // com.mongodb.internal.connection.ClusterableServer
    public synchronized void invalidate() {
        if (!isClosed()) {
            this.serverStateListener.stateChanged(new ChangeEvent<>(this.description, ServerDescription.builder().state(ServerConnectionState.CONNECTING).address(this.serverId.getAddress()).build()));
            connect();
            if (this.description.getMaxWireVersion() < 8) {
                this.connectionPool.invalidate();
            }
        }
    }

    @Override // com.mongodb.internal.connection.ClusterableServer
    public synchronized void invalidate(ClusterableServer.ConnectionState connectionState, Throwable t, int connectionGeneration, int maxWireVersion) {
        if (!isClosed() && connectionGeneration >= this.connectionPool.getGeneration()) {
            if ((t instanceof MongoSocketException) && (!(t instanceof MongoSocketReadTimeoutException) || connectionState == ClusterableServer.ConnectionState.BEFORE_HANDSHAKE)) {
                this.serverStateListener.stateChanged(new ChangeEvent<>(this.description, ServerDescription.builder().state(ServerConnectionState.CONNECTING).address(this.serverId.getAddress()).exception(t).build()));
                this.connectionPool.invalidate();
                this.serverMonitor.cancelCurrentCheck();
            } else if (((t instanceof MongoNotPrimaryException) || (t instanceof MongoNodeIsRecoveringException)) && !isStale((MongoCommandException) t)) {
                this.serverStateListener.stateChanged(new ChangeEvent<>(this.description, ServerDescription.builder().state(ServerConnectionState.CONNECTING).address(this.serverId.getAddress()).exception(t).build()));
                connect();
                if (maxWireVersion < 8 || SHUTDOWN_CODES.contains(Integer.valueOf(((MongoCommandException) t).getErrorCode()))) {
                    this.connectionPool.invalidate();
                }
            }
        }
    }

    private boolean isStale(MongoCommandException t) {
        if (!t.getResponse().containsKey("topologyVersion")) {
            return false;
        }
        return isStale(this.description.getTopologyVersion(), new TopologyVersion(t.getResponse().getDocument("topologyVersion")));
    }

    private boolean isStale(TopologyVersion currentTopologyVersion, TopologyVersion candidateTopologyVersion) {
        if (candidateTopologyVersion == null || currentTopologyVersion == null || !candidateTopologyVersion.getProcessId().equals(currentTopologyVersion.getProcessId()) || candidateTopologyVersion.getCounter() > currentTopologyVersion.getCounter()) {
            return false;
        }
        return true;
    }

    @Override // com.mongodb.internal.connection.ClusterableServer
    public void close() {
        if (!isClosed()) {
            this.connectionPool.close();
            this.serverMonitor.close();
            this.isClosed = true;
            this.serverListener.serverClosed(new ServerClosedEvent(this.serverId));
        }
    }

    @Override // com.mongodb.internal.connection.ClusterableServer
    public boolean isClosed() {
        return this.isClosed;
    }

    @Override // com.mongodb.internal.connection.ClusterableServer
    public void connect() {
        this.serverMonitor.connect();
    }

    ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultServer$DefaultServerProtocolExecutor.class */
    public class DefaultServerProtocolExecutor implements ProtocolExecutor {
        private DefaultServerProtocolExecutor() {
        }

        @Override // com.mongodb.internal.connection.ProtocolExecutor
        public <T> T execute(LegacyProtocol<T> protocol, InternalConnection connection) {
            try {
                protocol.setCommandListener(DefaultServer.this.commandListener);
                return protocol.execute(connection);
            } catch (MongoException e) {
                DefaultServer.this.invalidate(ClusterableServer.ConnectionState.AFTER_HANDSHAKE, e, connection.getGeneration(), connection.getDescription().getMaxWireVersion());
                throw e;
            }
        }

        @Override // com.mongodb.internal.connection.ProtocolExecutor
        public <T> void executeAsync(LegacyProtocol<T> protocol, final InternalConnection connection, final SingleResultCallback<T> callback) {
            protocol.setCommandListener(DefaultServer.this.commandListener);
            protocol.executeAsync(connection, ErrorHandlingResultCallback.errorHandlingCallback(new SingleResultCallback<T>() { // from class: com.mongodb.internal.connection.DefaultServer.DefaultServerProtocolExecutor.1
                @Override // com.mongodb.internal.async.SingleResultCallback
                public void onResult(T result, Throwable t) {
                    if (t != null) {
                        DefaultServer.this.invalidate(ClusterableServer.ConnectionState.AFTER_HANDSHAKE, t, connection.getGeneration(), connection.getDescription().getMaxWireVersion());
                    }
                    callback.onResult(result, t);
                }
            }, DefaultServer.LOGGER));
        }

        @Override // com.mongodb.internal.connection.ProtocolExecutor
        public <T> T execute(CommandProtocol<T> protocol, InternalConnection connection, SessionContext sessionContext) {
            try {
                protocol.sessionContext(new ClusterClockAdvancingSessionContext(sessionContext, DefaultServer.this.clusterClock));
                return protocol.execute(connection);
            } catch (MongoWriteConcernWithResponseException e) {
                DefaultServer.this.invalidate();
                return (T) e.getResponse();
            } catch (MongoException e2) {
                DefaultServer.this.invalidate(ClusterableServer.ConnectionState.AFTER_HANDSHAKE, e2, connection.getGeneration(), connection.getDescription().getMaxWireVersion());
                if ((e2 instanceof MongoSocketException) && sessionContext.hasSession()) {
                    sessionContext.markSessionDirty();
                }
                throw e2;
            }
        }

        @Override // com.mongodb.internal.connection.ProtocolExecutor
        public <T> void executeAsync(CommandProtocol<T> protocol, final InternalConnection connection, final SessionContext sessionContext, final SingleResultCallback<T> callback) {
            protocol.sessionContext(new ClusterClockAdvancingSessionContext(sessionContext, DefaultServer.this.clusterClock));
            protocol.executeAsync(connection, ErrorHandlingResultCallback.errorHandlingCallback(new SingleResultCallback<T>() { // from class: com.mongodb.internal.connection.DefaultServer.DefaultServerProtocolExecutor.2
                @Override // com.mongodb.internal.async.SingleResultCallback
                public void onResult(T result, Throwable t) {
                    if (t == null) {
                        callback.onResult(result, null);
                    } else if (t instanceof MongoWriteConcernWithResponseException) {
                        DefaultServer.this.invalidate();
                        callback.onResult(((MongoWriteConcernWithResponseException) t).getResponse(), null);
                    } else {
                        DefaultServer.this.invalidate(ClusterableServer.ConnectionState.AFTER_HANDSHAKE, t, connection.getGeneration(), connection.getDescription().getMaxWireVersion());
                        if ((t instanceof MongoSocketException) && sessionContext.hasSession()) {
                            sessionContext.markSessionDirty();
                        }
                        callback.onResult(null, t);
                    }
                }
            }, DefaultServer.LOGGER));
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultServer$DefaultServerStateListener.class */
    private final class DefaultServerStateListener implements ChangeListener<ServerDescription> {
        private DefaultServerStateListener() {
        }

        @Override // com.mongodb.internal.connection.ChangeListener
        public void stateChanged(ChangeEvent<ServerDescription> event) {
            ServerDescription oldDescription = DefaultServer.this.description;
            if (shouldReplace(oldDescription, event.getNewValue())) {
                DefaultServer.this.description = event.getNewValue();
                ServerDescriptionChangedEvent serverDescriptionChangedEvent = new ServerDescriptionChangedEvent(DefaultServer.this.serverId, DefaultServer.this.description, oldDescription);
                DefaultServer.this.serverDescriptionChangedListener.serverDescriptionChanged(serverDescriptionChangedEvent);
                if (!EventHelper.wouldDescriptionsGenerateEquivalentEvents(DefaultServer.this.description, oldDescription)) {
                    DefaultServer.this.serverListener.serverDescriptionChanged(serverDescriptionChangedEvent);
                }
            }
        }

        private boolean shouldReplace(ServerDescription oldDescription, ServerDescription newDescription) {
            TopologyVersion oldTopologyVersion = oldDescription.getTopologyVersion();
            TopologyVersion newTopologyVersion = newDescription.getTopologyVersion();
            if (newTopologyVersion == null || oldTopologyVersion == null || !newTopologyVersion.getProcessId().equals(oldTopologyVersion.getProcessId()) || newTopologyVersion.getCounter() >= oldTopologyVersion.getCounter()) {
                return true;
            }
            return false;
        }
    }
}
