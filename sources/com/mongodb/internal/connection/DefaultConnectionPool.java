package com.mongodb.internal.connection;

import com.mongodb.MongoInterruptedException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ConnectionId;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerId;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.ConnectionAddedEvent;
import com.mongodb.event.ConnectionCheckOutFailedEvent;
import com.mongodb.event.ConnectionCheckOutStartedEvent;
import com.mongodb.event.ConnectionCheckedInEvent;
import com.mongodb.event.ConnectionCheckedOutEvent;
import com.mongodb.event.ConnectionClosedEvent;
import com.mongodb.event.ConnectionCreatedEvent;
import com.mongodb.event.ConnectionPoolClearedEvent;
import com.mongodb.event.ConnectionPoolClosedEvent;
import com.mongodb.event.ConnectionPoolCreatedEvent;
import com.mongodb.event.ConnectionPoolListener;
import com.mongodb.event.ConnectionPoolOpenedEvent;
import com.mongodb.event.ConnectionReadyEvent;
import com.mongodb.event.ConnectionRemovedEvent;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.connection.ConcurrentPool;
import com.mongodb.internal.event.EventListenerHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.thread.DaemonThreadFactory;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.bson.ByteBuf;
import org.bson.codecs.Decoder;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultConnectionPool.class */
public class DefaultConnectionPool implements ConnectionPool {
    private static final Logger LOGGER = Loggers.getLogger("connection");
    private final ConcurrentPool<UsageTrackingInternalConnection> pool;
    private final ConnectionPoolSettings settings;
    private ExecutorService asyncGetter;
    private final ConnectionPoolListener connectionPoolListener;
    private final ServerId serverId;
    private volatile boolean closed;
    private final AtomicInteger generation = new AtomicInteger(0);
    private final AtomicInteger lastPrunedGeneration = new AtomicInteger(0);
    private final Runnable maintenanceTask = createMaintenanceTask();
    private final ScheduledExecutorService sizeMaintenanceTimer = createMaintenanceTimer();

    /* access modifiers changed from: package-private */
    public DefaultConnectionPool(ServerId serverId, InternalConnectionFactory internalConnectionFactory, ConnectionPoolSettings settings) {
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
        this.settings = (ConnectionPoolSettings) Assertions.notNull("settings", settings);
        this.pool = new ConcurrentPool<>(settings.getMaxSize(), new UsageTrackingInternalConnectionItemFactory(internalConnectionFactory));
        this.connectionPoolListener = EventListenerHelper.getConnectionPoolListener(settings);
        connectionPoolCreated(this.connectionPoolListener, serverId, settings);
    }

    @Override // com.mongodb.internal.connection.ConnectionPool
    public void start() {
        if (this.sizeMaintenanceTimer != null) {
            this.sizeMaintenanceTimer.scheduleAtFixedRate(this.maintenanceTask, this.settings.getMaintenanceInitialDelay(TimeUnit.MILLISECONDS), this.settings.getMaintenanceFrequency(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.mongodb.internal.connection.ConnectionPool
    public InternalConnection get() {
        return get(this.settings.getMaxWaitTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
    }

    @Override // com.mongodb.internal.connection.ConnectionPool
    public InternalConnection get(long timeout, TimeUnit timeUnit) {
        try {
            this.connectionPoolListener.connectionCheckOutStarted(new ConnectionCheckOutStartedEvent(this.serverId));
            PooledConnection pooledConnection = getPooledConnection(timeout, timeUnit);
            if (!pooledConnection.opened()) {
                try {
                    pooledConnection.open();
                } catch (Throwable t) {
                    this.pool.release(pooledConnection.wrapped, true);
                    this.connectionPoolListener.connectionCheckOutFailed(new ConnectionCheckOutFailedEvent(this.serverId, ConnectionCheckOutFailedEvent.Reason.CONNECTION_ERROR));
                    throw t;
                }
            }
            this.connectionPoolListener.connectionCheckedOut(new ConnectionCheckedOutEvent(pooledConnection.getDescription().getConnectionId()));
            return pooledConnection;
        } catch (Throwable t2) {
            emitCheckOutFailedEvent(t2);
            throw t2;
        }
    }

    @Override // com.mongodb.internal.connection.ConnectionPool
    public void getAsync(SingleResultCallback<InternalConnection> callback) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(String.format("Asynchronously getting a connection from the pool for server %s", this.serverId));
        }
        final SingleResultCallback<InternalConnection> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, LOGGER);
        PooledConnection connection = null;
        try {
            this.connectionPoolListener.connectionCheckOutStarted(new ConnectionCheckOutStartedEvent(this.serverId));
            connection = getPooledConnection(0, TimeUnit.MILLISECONDS);
        } catch (MongoTimeoutException e) {
        } catch (Throwable t) {
            emitCheckOutFailedEvent(t);
            callback.onResult(null, t);
            return;
        }
        if (connection != null) {
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace(String.format("Asynchronously opening pooled connection %s to server %s", connection.getDescription().getConnectionId(), this.serverId));
            }
            openAsync(connection, errHandlingCallback);
            return;
        }
        final long startTimeMillis = System.currentTimeMillis();
        getAsyncGetter().submit(new Runnable() { // from class: com.mongodb.internal.connection.DefaultConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (getRemainingWaitTime() <= 0) {
                        errHandlingCallback.onResult(null, DefaultConnectionPool.this.createTimeoutException());
                    } else {
                        DefaultConnectionPool.this.openAsync(DefaultConnectionPool.this.getPooledConnection(getRemainingWaitTime(), TimeUnit.MILLISECONDS), errHandlingCallback);
                    }
                } catch (MongoTimeoutException e2) {
                    Exception exception = new MongoTimeoutException(String.format("Timeout waiting for a pooled connection after %d %s", Long.valueOf(DefaultConnectionPool.this.settings.getMaxWaitTime(TimeUnit.MILLISECONDS)), TimeUnit.MILLISECONDS));
                    DefaultConnectionPool.this.emitCheckOutFailedEvent(exception);
                    errHandlingCallback.onResult(null, exception);
                } catch (Throwable t2) {
                    DefaultConnectionPool.this.emitCheckOutFailedEvent(t2);
                    errHandlingCallback.onResult(null, t2);
                }
            }

            private long getRemainingWaitTime() {
                return (startTimeMillis + DefaultConnectionPool.this.settings.getMaxWaitTime(TimeUnit.MILLISECONDS)) - System.currentTimeMillis();
            }
        });
    }

    /* access modifiers changed from: private */
    public void emitCheckOutFailedEvent(Throwable t) {
        if (t instanceof MongoTimeoutException) {
            this.connectionPoolListener.connectionCheckOutFailed(new ConnectionCheckOutFailedEvent(this.serverId, ConnectionCheckOutFailedEvent.Reason.TIMEOUT));
        } else if (!(t instanceof IllegalStateException) || !t.getMessage().equals("The pool is closed")) {
            this.connectionPoolListener.connectionCheckOutFailed(new ConnectionCheckOutFailedEvent(this.serverId, ConnectionCheckOutFailedEvent.Reason.UNKNOWN));
        } else {
            this.connectionPoolListener.connectionCheckOutFailed(new ConnectionCheckOutFailedEvent(this.serverId, ConnectionCheckOutFailedEvent.Reason.POOL_CLOSED));
        }
    }

    /* access modifiers changed from: private */
    public void openAsync(final PooledConnection pooledConnection, final SingleResultCallback<InternalConnection> callback) {
        if (pooledConnection.opened()) {
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace(String.format("Pooled connection %s to server %s is already open", pooledConnection.getDescription().getConnectionId(), this.serverId));
            }
            this.connectionPoolListener.connectionCheckedOut(new ConnectionCheckedOutEvent(pooledConnection.getDescription().getConnectionId()));
            callback.onResult(pooledConnection, null);
            return;
        }
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(String.format("Pooled connection %s to server %s is not yet open", pooledConnection.getDescription().getConnectionId(), this.serverId));
        }
        pooledConnection.openAsync(new SingleResultCallback<Void>() { // from class: com.mongodb.internal.connection.DefaultConnectionPool.2
            public void onResult(Void result, Throwable t) {
                if (t != null) {
                    if (DefaultConnectionPool.LOGGER.isTraceEnabled()) {
                        DefaultConnectionPool.LOGGER.trace(String.format("Pooled connection %s to server %s failed to open", pooledConnection.getDescription().getConnectionId(), DefaultConnectionPool.this.serverId));
                    }
                    DefaultConnectionPool.this.connectionPoolListener.connectionCheckOutFailed(new ConnectionCheckOutFailedEvent(DefaultConnectionPool.this.serverId, ConnectionCheckOutFailedEvent.Reason.CONNECTION_ERROR));
                    callback.onResult(null, t);
                    DefaultConnectionPool.this.pool.release(pooledConnection.wrapped, true);
                    return;
                }
                if (DefaultConnectionPool.LOGGER.isTraceEnabled()) {
                    DefaultConnectionPool.LOGGER.trace(String.format("Pooled connection %s to server %s is now open", pooledConnection.getDescription().getConnectionId(), DefaultConnectionPool.this.serverId));
                }
                DefaultConnectionPool.this.connectionPoolListener.connectionCheckedOut(new ConnectionCheckedOutEvent(pooledConnection.getDescription().getConnectionId()));
                callback.onResult(pooledConnection, null);
            }
        });
    }

    private synchronized ExecutorService getAsyncGetter() {
        if (this.asyncGetter == null) {
            this.asyncGetter = Executors.newSingleThreadExecutor(new DaemonThreadFactory("AsyncGetter"));
        }
        return this.asyncGetter;
    }

    private synchronized void shutdownAsyncGetter() {
        if (this.asyncGetter != null) {
            this.asyncGetter.shutdownNow();
        }
    }

    @Override // com.mongodb.internal.connection.ConnectionPool
    public void invalidate() {
        LOGGER.debug("Invalidating the connection pool");
        this.generation.incrementAndGet();
        this.connectionPoolListener.connectionPoolCleared(new ConnectionPoolClearedEvent(this.serverId));
    }

    @Override // com.mongodb.internal.connection.ConnectionPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.pool.close();
            if (this.sizeMaintenanceTimer != null) {
                this.sizeMaintenanceTimer.shutdownNow();
            }
            shutdownAsyncGetter();
            this.closed = true;
            this.connectionPoolListener.connectionPoolClosed(new ConnectionPoolClosedEvent(this.serverId));
        }
    }

    @Override // com.mongodb.internal.connection.ConnectionPool
    public int getGeneration() {
        return this.generation.get();
    }

    public void doMaintenance() {
        if (this.maintenanceTask != null) {
            this.maintenanceTask.run();
        }
    }

    /* access modifiers changed from: private */
    public PooledConnection getPooledConnection(long timeout, TimeUnit timeUnit) {
        UsageTrackingInternalConnection internalConnection;
        UsageTrackingInternalConnection usageTrackingInternalConnection = this.pool.get(timeout, timeUnit);
        while (true) {
            internalConnection = usageTrackingInternalConnection;
            if (!shouldPrune(internalConnection)) {
                break;
            }
            this.pool.release(internalConnection, true);
            usageTrackingInternalConnection = this.pool.get(timeout, timeUnit);
        }
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(String.format("Checked out connection [%s] to server %s", getId(internalConnection), this.serverId.getAddress()));
        }
        return new PooledConnection(internalConnection);
    }

    /* access modifiers changed from: private */
    public MongoTimeoutException createTimeoutException() {
        return new MongoTimeoutException(String.format("Timed out after %d ms while waiting for a connection to server %s.", Long.valueOf(this.settings.getMaxWaitTime(TimeUnit.MILLISECONDS)), this.serverId.getAddress()));
    }

    ConcurrentPool<UsageTrackingInternalConnection> getPool() {
        return this.pool;
    }

    private Runnable createMaintenanceTask() {
        Runnable newMaintenanceTask = null;
        if (shouldPrune() || shouldEnsureMinSize()) {
            newMaintenanceTask = new Runnable() { // from class: com.mongodb.internal.connection.DefaultConnectionPool.3
                @Override // java.lang.Runnable
                public synchronized void run() {
                    try {
                        int curGeneration = DefaultConnectionPool.this.generation.get();
                        if (DefaultConnectionPool.this.shouldPrune() || curGeneration > DefaultConnectionPool.this.lastPrunedGeneration.get()) {
                            if (DefaultConnectionPool.LOGGER.isDebugEnabled()) {
                                DefaultConnectionPool.LOGGER.debug(String.format("Pruning pooled connections to %s", DefaultConnectionPool.this.serverId.getAddress()));
                            }
                            DefaultConnectionPool.this.pool.prune();
                        }
                        DefaultConnectionPool.this.lastPrunedGeneration.set(curGeneration);
                        if (DefaultConnectionPool.this.shouldEnsureMinSize()) {
                            if (DefaultConnectionPool.LOGGER.isDebugEnabled()) {
                                DefaultConnectionPool.LOGGER.debug(String.format("Ensuring minimum pooled connections to %s", DefaultConnectionPool.this.serverId.getAddress()));
                            }
                            DefaultConnectionPool.this.pool.ensureMinSize(DefaultConnectionPool.this.settings.getMinSize(), true);
                        }
                    } catch (MongoInterruptedException e) {
                    } catch (Exception e2) {
                        DefaultConnectionPool.LOGGER.warn("Exception thrown during connection pool background maintenance task", e2);
                    }
                }
            };
        }
        return newMaintenanceTask;
    }

    private ScheduledExecutorService createMaintenanceTimer() {
        if (this.maintenanceTask == null) {
            return null;
        }
        return Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory("MaintenanceTimer"));
    }

    /* access modifiers changed from: private */
    public boolean shouldEnsureMinSize() {
        return this.settings.getMinSize() > 0;
    }

    /* access modifiers changed from: private */
    public boolean shouldPrune() {
        return this.settings.getMaxConnectionIdleTime(TimeUnit.MILLISECONDS) > 0 || this.settings.getMaxConnectionLifeTime(TimeUnit.MILLISECONDS) > 0;
    }

    /* access modifiers changed from: private */
    public boolean shouldPrune(UsageTrackingInternalConnection connection) {
        return fromPreviousGeneration(connection) || pastMaxLifeTime(connection) || pastMaxIdleTime(connection);
    }

    /* access modifiers changed from: private */
    public boolean pastMaxIdleTime(UsageTrackingInternalConnection connection) {
        return expired(connection.getLastUsedAt(), System.currentTimeMillis(), this.settings.getMaxConnectionIdleTime(TimeUnit.MILLISECONDS));
    }

    /* access modifiers changed from: private */
    public boolean pastMaxLifeTime(UsageTrackingInternalConnection connection) {
        return expired(connection.getOpenedAt(), System.currentTimeMillis(), this.settings.getMaxConnectionLifeTime(TimeUnit.MILLISECONDS));
    }

    /* access modifiers changed from: private */
    public boolean fromPreviousGeneration(UsageTrackingInternalConnection connection) {
        return this.generation.get() > connection.getGeneration();
    }

    private boolean expired(long startTime, long curTime, long maxTime) {
        return maxTime != 0 && curTime - startTime > maxTime;
    }

    private void connectionPoolCreated(ConnectionPoolListener connectionPoolListener, ServerId serverId, ConnectionPoolSettings settings) {
        connectionPoolListener.connectionPoolCreated(new ConnectionPoolCreatedEvent(serverId, settings));
        connectionPoolListener.connectionPoolOpened(new ConnectionPoolOpenedEvent(serverId, settings));
    }

    /* access modifiers changed from: private */
    public void connectionCreated(ConnectionPoolListener connectionPoolListener, ConnectionId connectionId) {
        connectionPoolListener.connectionAdded(new ConnectionAddedEvent(connectionId));
        connectionPoolListener.connectionCreated(new ConnectionCreatedEvent(connectionId));
    }

    /* access modifiers changed from: private */
    public void connectionClosed(ConnectionPoolListener connectionPoolListener, ConnectionId connectionId, ConnectionClosedEvent.Reason reason) {
        connectionPoolListener.connectionRemoved(new ConnectionRemovedEvent(connectionId, getReasonForRemoved(reason)));
        connectionPoolListener.connectionClosed(new ConnectionClosedEvent(connectionId, reason));
    }

    private ConnectionRemovedEvent.Reason getReasonForRemoved(ConnectionClosedEvent.Reason reason) {
        ConnectionRemovedEvent.Reason removedReason = ConnectionRemovedEvent.Reason.UNKNOWN;
        switch (reason) {
            case STALE:
                removedReason = ConnectionRemovedEvent.Reason.STALE;
                break;
            case IDLE:
                removedReason = ConnectionRemovedEvent.Reason.MAX_IDLE_TIME_EXCEEDED;
                break;
            case ERROR:
                removedReason = ConnectionRemovedEvent.Reason.ERROR;
                break;
            case POOL_CLOSED:
                removedReason = ConnectionRemovedEvent.Reason.POOL_CLOSED;
                break;
        }
        return removedReason;
    }

    /* access modifiers changed from: private */
    public ConnectionId getId(InternalConnection internalConnection) {
        return internalConnection.getDescription().getConnectionId();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultConnectionPool$PooledConnection.class */
    public class PooledConnection implements InternalConnection {
        private final UsageTrackingInternalConnection wrapped;
        private final AtomicBoolean isClosed = new AtomicBoolean();

        PooledConnection(UsageTrackingInternalConnection wrapped) {
            this.wrapped = (UsageTrackingInternalConnection) Assertions.notNull("wrapped", wrapped);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public int getGeneration() {
            return this.wrapped.getGeneration();
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public void open() {
            Assertions.isTrue("open", !this.isClosed.get());
            this.wrapped.open();
            DefaultConnectionPool.this.connectionPoolListener.connectionReady(new ConnectionReadyEvent(getDescription().getConnectionId()));
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public void openAsync(final SingleResultCallback<Void> callback) {
            Assertions.isTrue("open", !this.isClosed.get());
            this.wrapped.openAsync(new SingleResultCallback<Void>() { // from class: com.mongodb.internal.connection.DefaultConnectionPool.PooledConnection.1
                public void onResult(Void result, Throwable t) {
                    if (t != null) {
                        DefaultConnectionPool.this.connectionPoolListener.connectionCheckOutFailed(new ConnectionCheckOutFailedEvent(DefaultConnectionPool.this.serverId, ConnectionCheckOutFailedEvent.Reason.CONNECTION_ERROR));
                        callback.onResult(null, t);
                        return;
                    }
                    DefaultConnectionPool.this.connectionPoolListener.connectionReady(new ConnectionReadyEvent(PooledConnection.this.getDescription().getConnectionId()));
                    callback.onResult(result, null);
                }
            });
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public void close() {
            if (!this.isClosed.getAndSet(true)) {
                DefaultConnectionPool.this.connectionPoolListener.connectionCheckedIn(new ConnectionCheckedInEvent(DefaultConnectionPool.this.getId(this.wrapped)));
                if (DefaultConnectionPool.LOGGER.isTraceEnabled()) {
                    DefaultConnectionPool.LOGGER.trace(String.format("Checked in connection [%s] to server %s", DefaultConnectionPool.this.getId(this.wrapped), DefaultConnectionPool.this.serverId.getAddress()));
                }
                DefaultConnectionPool.this.pool.release(this.wrapped, this.wrapped.isClosed() || DefaultConnectionPool.this.shouldPrune(this.wrapped));
            }
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public boolean opened() {
            Assertions.isTrue("open", !this.isClosed.get());
            return this.wrapped.opened();
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public boolean isClosed() {
            return this.isClosed.get() || this.wrapped.isClosed();
        }

        @Override // com.mongodb.connection.BufferProvider
        public ByteBuf getBuffer(int capacity) {
            return this.wrapped.getBuffer(capacity);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public void sendMessage(List<ByteBuf> byteBuffers, int lastRequestId) {
            Assertions.isTrue("open", !this.isClosed.get());
            this.wrapped.sendMessage(byteBuffers, lastRequestId);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public <T> T sendAndReceive(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext) {
            Assertions.isTrue("open", !this.isClosed.get());
            return (T) this.wrapped.sendAndReceive(message, decoder, sessionContext);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public <T> void send(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext) {
            Assertions.isTrue("open", !this.isClosed.get());
            this.wrapped.send(message, decoder, sessionContext);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public <T> T receive(Decoder<T> decoder, SessionContext sessionContext) {
            Assertions.isTrue("open", !this.isClosed.get());
            return (T) this.wrapped.receive(decoder, sessionContext);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public boolean supportsAdditionalTimeout() {
            Assertions.isTrue("open", !this.isClosed.get());
            return this.wrapped.supportsAdditionalTimeout();
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public <T> T receive(Decoder<T> decoder, SessionContext sessionContext, int additionalTimeout) {
            Assertions.isTrue("open", !this.isClosed.get());
            return (T) this.wrapped.receive(decoder, sessionContext, additionalTimeout);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public boolean hasMoreToCome() {
            Assertions.isTrue("open", !this.isClosed.get());
            return this.wrapped.hasMoreToCome();
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public <T> void sendAndReceiveAsync(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext, final SingleResultCallback<T> callback) {
            Assertions.isTrue("open", !this.isClosed.get());
            this.wrapped.sendAndReceiveAsync(message, decoder, sessionContext, new SingleResultCallback<T>() { // from class: com.mongodb.internal.connection.DefaultConnectionPool.PooledConnection.2
                @Override // com.mongodb.internal.async.SingleResultCallback
                public void onResult(T result, Throwable t) {
                    callback.onResult(result, t);
                }
            });
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public ResponseBuffers receiveMessage(int responseTo) {
            Assertions.isTrue("open", !this.isClosed.get());
            return this.wrapped.receiveMessage(responseTo);
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public void sendMessageAsync(List<ByteBuf> byteBuffers, int lastRequestId, final SingleResultCallback<Void> callback) {
            Assertions.isTrue("open", !this.isClosed.get());
            this.wrapped.sendMessageAsync(byteBuffers, lastRequestId, new SingleResultCallback<Void>() { // from class: com.mongodb.internal.connection.DefaultConnectionPool.PooledConnection.3
                public void onResult(Void result, Throwable t) {
                    callback.onResult(null, t);
                }
            });
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public void receiveMessageAsync(int responseTo, final SingleResultCallback<ResponseBuffers> callback) {
            Assertions.isTrue("open", !this.isClosed.get());
            this.wrapped.receiveMessageAsync(responseTo, new SingleResultCallback<ResponseBuffers>() { // from class: com.mongodb.internal.connection.DefaultConnectionPool.PooledConnection.4
                public void onResult(ResponseBuffers result, Throwable t) {
                    callback.onResult(result, t);
                }
            });
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public ConnectionDescription getDescription() {
            return this.wrapped.getDescription();
        }

        @Override // com.mongodb.internal.connection.InternalConnection
        public ServerDescription getInitialServerDescription() {
            Assertions.isTrue("open", !this.isClosed.get());
            return this.wrapped.getInitialServerDescription();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultConnectionPool$UsageTrackingInternalConnectionItemFactory.class */
    private class UsageTrackingInternalConnectionItemFactory implements ConcurrentPool.ItemFactory<UsageTrackingInternalConnection> {
        private final InternalConnectionFactory internalConnectionFactory;

        UsageTrackingInternalConnectionItemFactory(InternalConnectionFactory internalConnectionFactory) {
            this.internalConnectionFactory = internalConnectionFactory;
        }

        @Override // com.mongodb.internal.connection.ConcurrentPool.ItemFactory
        public UsageTrackingInternalConnection create(boolean initialize) {
            UsageTrackingInternalConnection internalConnection = new UsageTrackingInternalConnection(this.internalConnectionFactory.create(DefaultConnectionPool.this.serverId), DefaultConnectionPool.this.generation.get());
            ConnectionId id = DefaultConnectionPool.this.getId(internalConnection);
            DefaultConnectionPool.this.connectionCreated(DefaultConnectionPool.this.connectionPoolListener, id);
            if (initialize) {
                internalConnection.open();
                DefaultConnectionPool.this.connectionPoolListener.connectionReady(new ConnectionReadyEvent(id));
            }
            return internalConnection;
        }

        public void close(UsageTrackingInternalConnection connection) {
            DefaultConnectionPool.this.connectionClosed(DefaultConnectionPool.this.connectionPoolListener, DefaultConnectionPool.this.getId(connection), getReasonForClosing(connection));
            if (DefaultConnectionPool.LOGGER.isInfoEnabled()) {
                DefaultConnectionPool.LOGGER.info(String.format("Closed connection [%s] to %s because %s.", DefaultConnectionPool.this.getId(connection), DefaultConnectionPool.this.serverId.getAddress(), getReasonStringForClosing(connection)));
            }
            connection.close();
        }

        private String getReasonStringForClosing(UsageTrackingInternalConnection connection) {
            String reason;
            if (connection.isClosed()) {
                reason = "there was a socket exception raised by this connection";
            } else if (DefaultConnectionPool.this.fromPreviousGeneration(connection)) {
                reason = "there was a socket exception raised on another connection from this pool";
            } else if (DefaultConnectionPool.this.pastMaxLifeTime(connection)) {
                reason = "it is past its maximum allowed life time";
            } else if (DefaultConnectionPool.this.pastMaxIdleTime(connection)) {
                reason = "it is past its maximum allowed idle time";
            } else {
                reason = "the pool has been closed";
            }
            return reason;
        }

        private ConnectionClosedEvent.Reason getReasonForClosing(UsageTrackingInternalConnection connection) {
            ConnectionClosedEvent.Reason reason;
            if (connection.isClosed()) {
                reason = ConnectionClosedEvent.Reason.ERROR;
            } else if (DefaultConnectionPool.this.fromPreviousGeneration(connection)) {
                reason = ConnectionClosedEvent.Reason.STALE;
            } else if (DefaultConnectionPool.this.pastMaxIdleTime(connection)) {
                reason = ConnectionClosedEvent.Reason.IDLE;
            } else {
                reason = ConnectionClosedEvent.Reason.POOL_CLOSED;
            }
            return reason;
        }

        public ConcurrentPool.Prune shouldPrune(UsageTrackingInternalConnection usageTrackingConnection) {
            return DefaultConnectionPool.this.shouldPrune(usageTrackingConnection) ? ConcurrentPool.Prune.YES : ConcurrentPool.Prune.NO;
        }
    }
}
