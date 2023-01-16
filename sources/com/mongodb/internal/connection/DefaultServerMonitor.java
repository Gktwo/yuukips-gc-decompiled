package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.MongoSocketException;
import com.mongodb.ReadPreference;
import com.mongodb.annotations.ThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerConnectionState;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerId;
import com.mongodb.connection.ServerSettings;
import com.mongodb.connection.ServerType;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.ServerHeartbeatFailedEvent;
import com.mongodb.event.ServerHeartbeatStartedEvent;
import com.mongodb.event.ServerHeartbeatSucceededEvent;
import com.mongodb.event.ServerMonitorListener;
import com.mongodb.internal.event.EventListenerHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.types.ObjectId;

/* access modifiers changed from: package-private */
@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultServerMonitor.class */
public class DefaultServerMonitor implements ServerMonitor {
    private static final Logger LOGGER = Loggers.getLogger("cluster");
    private final ServerId serverId;
    private final ServerMonitorListener serverMonitorListener;
    private final ClusterClock clusterClock;
    private final ChangeListener<ServerDescription> serverStateListener;
    private final InternalConnectionFactory internalConnectionFactory;
    private final ConnectionPool connectionPool;
    private final ServerSettings serverSettings;
    private final Thread monitorThread;
    private final Thread roundTripTimeMonitorThread;
    private final ExponentiallyWeightedMovingAverage averageRoundTripTime = new ExponentiallyWeightedMovingAverage(0.2d);
    private final Lock lock = new ReentrantLock();
    private final Condition condition = this.lock.newCondition();
    private final ServerMonitorRunnable monitor = new ServerMonitorRunnable();
    private final RoundTripTimeRunnable roundTripTimeMonitor = new RoundTripTimeRunnable();
    private volatile boolean isClosed = false;

    /* access modifiers changed from: package-private */
    public DefaultServerMonitor(ServerId serverId, ServerSettings serverSettings, ClusterClock clusterClock, ChangeListener<ServerDescription> serverStateListener, InternalConnectionFactory internalConnectionFactory, ConnectionPool connectionPool) {
        this.serverSettings = (ServerSettings) Assertions.notNull("serverSettings", serverSettings);
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
        this.serverMonitorListener = EventListenerHelper.getServerMonitorListener(serverSettings);
        this.clusterClock = (ClusterClock) Assertions.notNull("clusterClock", clusterClock);
        this.serverStateListener = serverStateListener;
        this.internalConnectionFactory = (InternalConnectionFactory) Assertions.notNull("internalConnectionFactory", internalConnectionFactory);
        this.connectionPool = connectionPool;
        this.monitorThread = new Thread(this.monitor, "cluster-" + this.serverId.getClusterId() + "-" + this.serverId.getAddress());
        this.monitorThread.setDaemon(true);
        this.roundTripTimeMonitorThread = new Thread(this.roundTripTimeMonitor, "cluster-rtt-" + this.serverId.getClusterId() + "-" + this.serverId.getAddress());
        this.roundTripTimeMonitorThread.setDaemon(true);
    }

    @Override // com.mongodb.internal.connection.ServerMonitor
    public void start() {
        this.monitorThread.start();
        this.roundTripTimeMonitorThread.start();
    }

    @Override // com.mongodb.internal.connection.ServerMonitor
    public void connect() {
        this.lock.lock();
        try {
            this.condition.signal();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.mongodb.internal.connection.ServerMonitor
    public void close() {
        this.isClosed = true;
        this.monitor.close();
        this.monitorThread.interrupt();
        this.roundTripTimeMonitor.close();
        this.roundTripTimeMonitorThread.interrupt();
    }

    @Override // com.mongodb.internal.connection.ServerMonitor
    public void cancelCurrentCheck() {
        this.monitor.cancelCurrentCheck();
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultServerMonitor$ServerMonitorRunnable.class */
    class ServerMonitorRunnable implements Runnable {
        private volatile InternalConnection connection = null;
        private volatile boolean currentCheckCancelled;

        ServerMonitorRunnable() {
        }

        void close() {
            InternalConnection connection = this.connection;
            if (connection != null) {
                connection.close();
            }
        }

        /* JADX INFO: finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            ServerDescription currentServerDescription = getConnectingServerDescription(null);
            while (!DefaultServerMonitor.this.isClosed) {
                try {
                    currentServerDescription = lookupServerDescription(currentServerDescription);
                    if (!DefaultServerMonitor.this.isClosed) {
                        if (this.currentCheckCancelled) {
                            waitForNext();
                            this.currentCheckCancelled = false;
                        } else {
                            logStateChange(currentServerDescription, currentServerDescription);
                            DefaultServerMonitor.this.serverStateListener.stateChanged(new ChangeEvent(currentServerDescription, currentServerDescription));
                            if (currentServerDescription.getException() != null) {
                                DefaultServerMonitor.this.connectionPool.invalidate();
                            }
                            if ((this.connection != null && !shouldStreamResponses(currentServerDescription)) || currentServerDescription.getTopologyVersion() == null) {
                                if (this.connection == null || !this.connection.hasMoreToCome()) {
                                    if (!(currentServerDescription.getException() instanceof MongoSocketException) || currentServerDescription.getType() == ServerType.UNKNOWN) {
                                        waitForNext();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (this.connection != null) {
                        this.connection.close();
                    }
                    throw th;
                }
            }
            if (this.connection != null) {
                this.connection.close();
            }
        }

        private ServerDescription getConnectingServerDescription(Throwable exception) {
            return ServerDescription.builder().type(ServerType.UNKNOWN).state(ServerConnectionState.CONNECTING).address(DefaultServerMonitor.this.serverId.getAddress()).exception(exception).build();
        }

        private ServerDescription lookupServerDescription(ServerDescription currentServerDescription) {
            BsonDocument isMasterResult;
            try {
                if (this.connection == null || this.connection.isClosed()) {
                    this.currentCheckCancelled = false;
                    InternalConnection newConnection = DefaultServerMonitor.this.internalConnectionFactory.create(DefaultServerMonitor.this.serverId);
                    newConnection.open();
                    this.connection = newConnection;
                    DefaultServerMonitor.this.averageRoundTripTime.addSample(this.connection.getInitialServerDescription().getRoundTripTimeNanos());
                    return this.connection.getInitialServerDescription();
                }
                if (DefaultServerMonitor.LOGGER.isDebugEnabled()) {
                    DefaultServerMonitor.LOGGER.debug(String.format("Checking status of %s", DefaultServerMonitor.this.serverId.getAddress()));
                }
                DefaultServerMonitor.this.serverMonitorListener.serverHearbeatStarted(new ServerHeartbeatStartedEvent(this.connection.getDescription().getConnectionId()));
                long start = System.nanoTime();
                SessionContext sessionContext = new ClusterClockAdvancingSessionContext(NoOpSessionContext.INSTANCE, DefaultServerMonitor.this.clusterClock);
                if (!this.connection.hasMoreToCome()) {
                    BsonDocument ismaster = new BsonDocument("ismaster", new BsonInt32(1));
                    if (shouldStreamResponses(currentServerDescription)) {
                        ismaster.append("topologyVersion", currentServerDescription.getTopologyVersion().asDocument());
                        ismaster.append("maxAwaitTimeMS", new BsonInt64(DefaultServerMonitor.this.serverSettings.getHeartbeatFrequency(TimeUnit.MILLISECONDS)));
                    }
                    this.connection.send(createCommandMessage(ismaster, this.connection, currentServerDescription), new BsonDocumentCodec(), sessionContext);
                }
                try {
                    if (shouldStreamResponses(currentServerDescription)) {
                        isMasterResult = (BsonDocument) this.connection.receive(new BsonDocumentCodec(), sessionContext, Math.toIntExact(DefaultServerMonitor.this.serverSettings.getHeartbeatFrequency(TimeUnit.MILLISECONDS)));
                    } else {
                        isMasterResult = (BsonDocument) this.connection.receive(new BsonDocumentCodec(), sessionContext);
                    }
                    DefaultServerMonitor.this.serverMonitorListener.serverHeartbeatSucceeded(new ServerHeartbeatSucceededEvent(this.connection.getDescription().getConnectionId(), isMasterResult, System.nanoTime() - start, currentServerDescription.getTopologyVersion() != null));
                    return DescriptionHelper.createServerDescription(DefaultServerMonitor.this.serverId.getAddress(), isMasterResult, DefaultServerMonitor.this.averageRoundTripTime.getAverage());
                } catch (RuntimeException e) {
                    DefaultServerMonitor.this.serverMonitorListener.serverHeartbeatFailed(new ServerHeartbeatFailedEvent(this.connection.getDescription().getConnectionId(), System.nanoTime() - start, currentServerDescription.getTopologyVersion() != null, e));
                    throw e;
                }
            } catch (Throwable t) {
                DefaultServerMonitor.this.averageRoundTripTime.reset();
                synchronized (this) {
                    try {
                        InternalConnection localConnection = this.connection;
                        this.connection = null;
                        if (localConnection != null) {
                            localConnection.close();
                        }
                        return getConnectingServerDescription(t);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        private boolean shouldStreamResponses(ServerDescription currentServerDescription) {
            return currentServerDescription.getTopologyVersion() != null && this.connection.supportsAdditionalTimeout();
        }

        private CommandMessage createCommandMessage(BsonDocument ismaster, InternalConnection connection, ServerDescription currentServerDescription) {
            return new CommandMessage(new MongoNamespace("admin", MongoNamespace.COMMAND_COLLECTION_NAME), ismaster, new NoOpFieldNameValidator(), ReadPreference.primary(), MessageSettings.builder().maxWireVersion(connection.getDescription().getMaxWireVersion()).build(), shouldStreamResponses(currentServerDescription));
        }

        private void logStateChange(ServerDescription previousServerDescription, ServerDescription currentServerDescription) {
            if (!DefaultServerMonitor.shouldLogStageChange(previousServerDescription, currentServerDescription)) {
                return;
            }
            if (currentServerDescription.getException() != null) {
                DefaultServerMonitor.LOGGER.info(String.format("Exception in monitor thread while connecting to server %s", DefaultServerMonitor.this.serverId.getAddress()), currentServerDescription.getException());
            } else {
                DefaultServerMonitor.LOGGER.info(String.format("Monitor thread successfully connected to server with description %s", currentServerDescription));
            }
        }

        private void waitForNext() {
            try {
                long timeRemaining = waitForSignalOrTimeout();
                if (timeRemaining > 0) {
                    long timeWaiting = DefaultServerMonitor.this.serverSettings.getHeartbeatFrequency(TimeUnit.NANOSECONDS) - timeRemaining;
                    long minimumNanosToWait = DefaultServerMonitor.this.serverSettings.getMinHeartbeatFrequency(TimeUnit.NANOSECONDS);
                    if (timeWaiting < minimumNanosToWait) {
                        long millisToSleep = TimeUnit.MILLISECONDS.convert(minimumNanosToWait - timeWaiting, TimeUnit.NANOSECONDS);
                        if (millisToSleep > 0) {
                            Thread.sleep(millisToSleep);
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        }

        private long waitForSignalOrTimeout() throws InterruptedException {
            DefaultServerMonitor.this.lock.lock();
            try {
                return DefaultServerMonitor.this.condition.awaitNanos(DefaultServerMonitor.this.serverSettings.getHeartbeatFrequency(TimeUnit.NANOSECONDS));
            } finally {
                DefaultServerMonitor.this.lock.unlock();
            }
        }

        public void cancelCurrentCheck() {
            InternalConnection localConnection = null;
            synchronized (this) {
                if (this.connection != null && !this.currentCheckCancelled) {
                    localConnection = this.connection;
                    this.currentCheckCancelled = true;
                }
            }
            if (localConnection != null) {
                localConnection.close();
            }
        }
    }

    static boolean shouldLogStageChange(ServerDescription previous, ServerDescription current) {
        if (previous.isOk() != current.isOk() || !previous.getAddress().equals(current.getAddress())) {
            return true;
        }
        if (previous.getCanonicalAddress() != null) {
            if (!previous.getCanonicalAddress().equals(current.getCanonicalAddress())) {
                return true;
            }
        } else if (current.getCanonicalAddress() != null) {
            return true;
        }
        if (!previous.getHosts().equals(current.getHosts()) || !previous.getArbiters().equals(current.getArbiters()) || !previous.getPassives().equals(current.getPassives())) {
            return true;
        }
        if (previous.getPrimary() != null) {
            if (!previous.getPrimary().equals(current.getPrimary())) {
                return true;
            }
        } else if (current.getPrimary() != null) {
            return true;
        }
        if (previous.getSetName() != null) {
            if (!previous.getSetName().equals(current.getSetName())) {
                return true;
            }
        } else if (current.getSetName() != null) {
            return true;
        }
        if (previous.getState() != current.getState() || !previous.getTagSet().equals(current.getTagSet()) || previous.getType() != current.getType() || previous.getMaxWireVersion() != current.getMaxWireVersion()) {
            return true;
        }
        ObjectId previousElectionId = previous.getElectionId();
        if (previousElectionId != null) {
            if (!previousElectionId.equals(current.getElectionId())) {
                return true;
            }
        } else if (current.getElectionId() != null) {
            return true;
        }
        Integer setVersion = previous.getSetVersion();
        if (setVersion != null) {
            if (!setVersion.equals(current.getSetVersion())) {
                return true;
            }
        } else if (current.getSetVersion() != null) {
            return true;
        }
        Throwable previousException = previous.getException();
        Throwable currentException = current.getException();
        if (!Objects.equals(previousException != null ? previousException.getClass() : null, currentException != null ? currentException.getClass() : null)) {
            return true;
        }
        if (!Objects.equals(previousException != null ? previousException.getMessage() : null, currentException != null ? currentException.getMessage() : null)) {
            return true;
        }
        return false;
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultServerMonitor$RoundTripTimeRunnable.class */
    private class RoundTripTimeRunnable implements Runnable {
        private volatile InternalConnection connection;

        private RoundTripTimeRunnable() {
            this.connection = null;
        }

        void close() {
            InternalConnection connection = this.connection;
            if (connection != null) {
                connection.close();
            }
        }

        /* JADX INFO: finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            while (!DefaultServerMonitor.this.isClosed) {
                try {
                    if (this.connection == null) {
                        initialize();
                    } else {
                        pingServer(this.connection);
                    }
                    DefaultServerMonitor.this.waitForNext();
                } catch (Throwable th) {
                    if (this.connection != null) {
                        this.connection.close();
                    }
                    throw th;
                }
            }
            if (this.connection != null) {
                this.connection.close();
            }
        }

        private void initialize() {
            this.connection = null;
            this.connection = DefaultServerMonitor.this.internalConnectionFactory.create(DefaultServerMonitor.this.serverId);
            this.connection.open();
            DefaultServerMonitor.this.averageRoundTripTime.addSample(this.connection.getInitialServerDescription().getRoundTripTimeNanos());
        }

        private void pingServer(InternalConnection connection) {
            long start = System.nanoTime();
            CommandHelper.executeCommand("admin", new BsonDocument("ismaster", new BsonInt32(1)), DefaultServerMonitor.this.clusterClock, connection);
            DefaultServerMonitor.this.averageRoundTripTime.addSample(System.nanoTime() - start);
        }
    }

    /* access modifiers changed from: private */
    public void waitForNext() {
        try {
            Thread.sleep(this.serverSettings.getHeartbeatFrequency(TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
        }
    }
}
