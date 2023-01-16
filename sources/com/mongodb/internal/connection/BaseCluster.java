package com.mongodb.internal.connection;

import com.mongodb.MongoIncompatibleDriverException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ClusterType;
import com.mongodb.connection.ServerDescription;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.ClusterClosedEvent;
import com.mongodb.event.ClusterDescriptionChangedEvent;
import com.mongodb.event.ClusterListener;
import com.mongodb.event.ClusterOpeningEvent;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.event.EventListenerHelper;
import com.mongodb.selector.CompositeServerSelector;
import com.mongodb.selector.ServerSelector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/BaseCluster.class */
abstract class BaseCluster implements Cluster {
    private static final Logger LOGGER = Loggers.getLogger("cluster");
    private final ClusterableServerFactory serverFactory;
    private final ClusterId clusterId;
    private final ClusterSettings settings;
    private final ClusterListener clusterListener;
    private Thread waitQueueHandler;
    private volatile boolean isClosed;
    private volatile ClusterDescription description;
    private final AtomicReference<CountDownLatch> phase = new AtomicReference<>(new CountDownLatch(1));
    private final ThreadLocal<Random> random = new ThreadLocal<>();
    private final Deque<ServerSelectionRequest> waitQueue = new ConcurrentLinkedDeque();
    private final ClusterClock clusterClock = new ClusterClock();

    protected abstract void connect();

    protected abstract ClusterableServer getServer(ServerAddress serverAddress);

    /* access modifiers changed from: package-private */
    public BaseCluster(ClusterId clusterId, ClusterSettings settings, ClusterableServerFactory serverFactory) {
        this.clusterId = (ClusterId) Assertions.notNull("clusterId", clusterId);
        this.settings = (ClusterSettings) Assertions.notNull("settings", settings);
        this.serverFactory = (ClusterableServerFactory) Assertions.notNull("serverFactory", serverFactory);
        this.clusterListener = EventListenerHelper.getClusterListener(settings);
        this.clusterListener.clusterOpening(new ClusterOpeningEvent(clusterId));
        this.description = new ClusterDescription(settings.getMode(), ClusterType.UNKNOWN, Collections.emptyList(), settings, serverFactory.getSettings());
    }

    @Override // com.mongodb.internal.connection.Cluster
    public BsonTimestamp getClusterTime() {
        return this.clusterClock.getClusterTime();
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        throw createTimeoutException(r9, r11);
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.mongodb.internal.connection.Cluster
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mongodb.internal.connection.ServerTuple selectServer(com.mongodb.selector.ServerSelector r9) {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.BaseCluster.selectServer(com.mongodb.selector.ServerSelector):com.mongodb.internal.connection.ServerTuple");
    }

    @Override // com.mongodb.internal.connection.Cluster
    public void selectServerAsync(ServerSelector serverSelector, SingleResultCallback<ServerTuple> callback) {
        Assertions.isTrue("open", !isClosed());
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace(String.format("Asynchronously selecting server with selector %s", serverSelector));
        }
        ServerSelectionRequest request = new ServerSelectionRequest(serverSelector, getCompositeServerSelector(serverSelector), getMaxWaitTimeNanos(), callback);
        if (!handleServerSelectionRequest(request, this.phase.get(), this.description)) {
            notifyWaitQueueHandler(request);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.mongodb.internal.connection.Cluster
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mongodb.connection.ClusterDescription getDescription() {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.BaseCluster.getDescription():com.mongodb.connection.ClusterDescription");
    }

    protected ClusterId getClusterId() {
        return this.clusterId;
    }

    @Override // com.mongodb.internal.connection.Cluster
    public ClusterSettings getSettings() {
        return this.settings;
    }

    public ClusterableServerFactory getServerFactory() {
        return this.serverFactory;
    }

    @Override // com.mongodb.internal.connection.Cluster, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!isClosed()) {
            this.isClosed = true;
            this.phase.get().countDown();
            this.clusterListener.clusterClosed(new ClusterClosedEvent(this.clusterId));
            stopWaitQueueHandler();
        }
    }

    @Override // com.mongodb.internal.connection.Cluster
    public boolean isClosed() {
        return this.isClosed;
    }

    protected synchronized void updateDescription(ClusterDescription newDescription) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Updating cluster description to  %s", newDescription.getShortDescription()));
        }
        this.description = newDescription;
        updatePhase();
    }

    protected void fireChangeEvent(ClusterDescription newDescription, ClusterDescription previousDescription) {
        if (!EventHelper.wouldDescriptionsGenerateEquivalentEvents(newDescription, previousDescription)) {
            this.clusterListener.clusterDescriptionChanged(new ClusterDescriptionChangedEvent(getClusterId(), newDescription, previousDescription));
        }
    }

    @Override // com.mongodb.internal.connection.Cluster
    public ClusterDescription getCurrentDescription() {
        return this.description;
    }

    private synchronized void updatePhase() {
        this.phase.getAndSet(new CountDownLatch(1)).countDown();
    }

    private long getMaxWaitTimeNanos() {
        if (this.settings.getServerSelectionTimeout(TimeUnit.NANOSECONDS) < 0) {
            return LongCompanionObject.MAX_VALUE;
        }
        return this.settings.getServerSelectionTimeout(TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: private */
    public long getMinWaitTimeNanos() {
        return this.serverFactory.getSettings().getMinHeartbeatFrequency(TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: private */
    public boolean handleServerSelectionRequest(ServerSelectionRequest request, CountDownLatch currentPhase, ClusterDescription description) {
        try {
            if (currentPhase != request.phase) {
                CountDownLatch prevPhase = request.phase;
                request.phase = currentPhase;
                if (!description.isCompatibleWithDriver()) {
                    if (LOGGER.isTraceEnabled()) {
                        LOGGER.trace("Asynchronously failed server selection due to driver incompatibility with server");
                    }
                    request.onResult(null, createIncompatibleException(description));
                    return true;
                }
                ServerTuple serverTuple = selectRandomServer(request.compositeSelector, description);
                if (serverTuple != null) {
                    if (LOGGER.isTraceEnabled()) {
                        LOGGER.trace(String.format("Asynchronously selected server %s", serverTuple.getServerDescription().getAddress()));
                    }
                    request.onResult(serverTuple, null);
                    return true;
                } else if (prevPhase == null) {
                    logServerSelectionFailure(request.originalSelector, description);
                }
            }
            if (!request.timedOut()) {
                return false;
            }
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("Asynchronously failed server selection after timeout");
            }
            request.onResult(null, createTimeoutException(request.originalSelector, description));
            return true;
        } catch (Exception e) {
            request.onResult(null, e);
            return true;
        }
    }

    private void logServerSelectionFailure(ServerSelector serverSelector, ClusterDescription curDescription) {
        if (!LOGGER.isInfoEnabled()) {
            return;
        }
        if (this.settings.getServerSelectionTimeout(TimeUnit.MILLISECONDS) < 0) {
            LOGGER.info(String.format("No server chosen by %s from cluster description %s. Waiting indefinitely.", serverSelector, curDescription));
        } else {
            LOGGER.info(String.format("No server chosen by %s from cluster description %s. Waiting for %d ms before timing out", serverSelector, curDescription, Long.valueOf(this.settings.getServerSelectionTimeout(TimeUnit.MILLISECONDS))));
        }
    }

    private ServerTuple selectRandomServer(ServerSelector serverSelector, ClusterDescription clusterDescription) {
        List<ServerDescription> serverDescriptions = serverSelector.select(clusterDescription);
        if (!serverDescriptions.isEmpty()) {
            return getRandomServer(new ArrayList(serverDescriptions));
        }
        return null;
    }

    private ServerSelector getCompositeServerSelector(ServerSelector serverSelector) {
        if (this.settings.getServerSelector() == null) {
            return serverSelector;
        }
        return new CompositeServerSelector(Arrays.asList(serverSelector, this.settings.getServerSelector()));
    }

    private ServerTuple getRandomServer(List<ServerDescription> serverDescriptions) {
        while (!serverDescriptions.isEmpty()) {
            int serverPos = getRandom().nextInt(serverDescriptions.size());
            ServerDescription serverDescription = serverDescriptions.get(serverPos);
            Server server = getServer(serverDescription.getAddress());
            if (server != null) {
                return new ServerTuple(server, serverDescription);
            }
            serverDescriptions.remove(serverPos);
        }
        return null;
    }

    private Random getRandom() {
        Random result = this.random.get();
        if (result == null) {
            result = new Random();
            this.random.set(result);
        }
        return result;
    }

    protected ClusterableServer createServer(ServerAddress serverAddress, ServerDescriptionChangedListener serverDescriptionChangedListener) {
        return this.serverFactory.create(serverAddress, serverDescriptionChangedListener, EventListenerHelper.createServerListener(this.serverFactory.getSettings()), this.clusterClock);
    }

    private void throwIfIncompatible(ClusterDescription curDescription) {
        if (!curDescription.isCompatibleWithDriver()) {
            throw createIncompatibleException(curDescription);
        }
    }

    private MongoIncompatibleDriverException createIncompatibleException(ClusterDescription curDescription) {
        String message;
        ServerDescription incompatibleServer = curDescription.findServerIncompatiblyOlderThanDriver();
        if (incompatibleServer != null) {
            message = String.format("Server at %s reports wire version %d, but this version of the driver requires at least %d (MongoDB %s).", incompatibleServer.getAddress(), Integer.valueOf(incompatibleServer.getMaxWireVersion()), 2, ServerDescription.MIN_DRIVER_SERVER_VERSION);
        } else {
            ServerDescription incompatibleServer2 = curDescription.findServerIncompatiblyNewerThanDriver();
            if (incompatibleServer2 != null) {
                message = String.format("Server at %s requires wire version %d, but this version of the driver only supports up to %d.", incompatibleServer2.getAddress(), Integer.valueOf(incompatibleServer2.getMinWireVersion()), 9);
            } else {
                throw new IllegalStateException("Server can't be both older than the driver and newer.");
            }
        }
        return new MongoIncompatibleDriverException(message, curDescription);
    }

    private MongoTimeoutException createTimeoutException(ServerSelector serverSelector, ClusterDescription curDescription) {
        return new MongoTimeoutException(String.format("Timed out after %d ms while waiting for a server that matches %s. Client view of cluster state is %s", Long.valueOf(this.settings.getServerSelectionTimeout(TimeUnit.MILLISECONDS)), serverSelector, curDescription.getShortDescription()));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/BaseCluster$ServerSelectionRequest.class */
    public static final class ServerSelectionRequest {
        private final ServerSelector originalSelector;
        private final ServerSelector compositeSelector;
        private final long maxWaitTimeNanos;
        private final SingleResultCallback<ServerTuple> callback;
        private final long startTimeNanos = System.nanoTime();
        private CountDownLatch phase;

        ServerSelectionRequest(ServerSelector serverSelector, ServerSelector compositeSelector, long maxWaitTimeNanos, SingleResultCallback<ServerTuple> callback) {
            this.originalSelector = serverSelector;
            this.compositeSelector = compositeSelector;
            this.maxWaitTimeNanos = maxWaitTimeNanos;
            this.callback = callback;
        }

        void onResult(ServerTuple serverTuple, Throwable t) {
            try {
                this.callback.onResult(serverTuple, t);
            } catch (Throwable th) {
            }
        }

        boolean timedOut() {
            return System.nanoTime() - this.startTimeNanos > this.maxWaitTimeNanos;
        }

        long getRemainingTime() {
            return (this.startTimeNanos + this.maxWaitTimeNanos) - System.nanoTime();
        }
    }

    private synchronized void notifyWaitQueueHandler(ServerSelectionRequest request) {
        if (!this.isClosed) {
            this.waitQueue.add(request);
            if (this.waitQueueHandler == null) {
                this.waitQueueHandler = new Thread(new WaitQueueHandler(), "cluster-" + this.clusterId.getValue());
                this.waitQueueHandler.setDaemon(true);
                this.waitQueueHandler.start();
                return;
            }
            updatePhase();
        }
    }

    private synchronized void stopWaitQueueHandler() {
        if (this.waitQueueHandler != null) {
            this.waitQueueHandler.interrupt();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/BaseCluster$WaitQueueHandler.class */
    public final class WaitQueueHandler implements Runnable {
        private WaitQueueHandler() {
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0032 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0032 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.util.concurrent.CountDownLatch] */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v1, types: [long] */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v3, types: [long] */
        /* JADX WARNING: Unknown variable types count: 2 */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
            L_0x0000:
                r0 = r7
                com.mongodb.internal.connection.BaseCluster r0 = com.mongodb.internal.connection.BaseCluster.this
                boolean r0 = com.mongodb.internal.connection.BaseCluster.access$400(r0)
                if (r0 != 0) goto L_0x0097
                r0 = r7
                com.mongodb.internal.connection.BaseCluster r0 = com.mongodb.internal.connection.BaseCluster.this
                java.util.concurrent.atomic.AtomicReference r0 = com.mongodb.internal.connection.BaseCluster.access$500(r0)
                java.lang.Object r0 = r0.get()
                java.util.concurrent.CountDownLatch r0 = (java.util.concurrent.CountDownLatch) r0
                r8 = r0
                r0 = r7
                com.mongodb.internal.connection.BaseCluster r0 = com.mongodb.internal.connection.BaseCluster.this
                com.mongodb.connection.ClusterDescription r0 = com.mongodb.internal.connection.BaseCluster.access$600(r0)
                r9 = r0
                r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r10 = r0
                r0 = r7
                com.mongodb.internal.connection.BaseCluster r0 = com.mongodb.internal.connection.BaseCluster.this
                java.util.Deque r0 = com.mongodb.internal.connection.BaseCluster.access$700(r0)
                java.util.Iterator r0 = r0.iterator()
                r12 = r0
            L_0x0032:
                r0 = r12
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x0077
                r0 = r12
                java.lang.Object r0 = r0.next()
                com.mongodb.internal.connection.BaseCluster$ServerSelectionRequest r0 = (com.mongodb.internal.connection.BaseCluster.ServerSelectionRequest) r0
                r13 = r0
                r0 = r7
                com.mongodb.internal.connection.BaseCluster r0 = com.mongodb.internal.connection.BaseCluster.this
                r1 = r13
                r2 = r8
                r3 = r9
                boolean r0 = com.mongodb.internal.connection.BaseCluster.access$800(r0, r1, r2, r3)
                if (r0 == 0) goto L_0x0060
                r0 = r12
                r0.remove()
                goto L_0x0074
            L_0x0060:
                r0 = r13
                long r0 = r0.getRemainingTime()
                r1 = r7
                com.mongodb.internal.connection.BaseCluster r1 = com.mongodb.internal.connection.BaseCluster.this
                long r1 = com.mongodb.internal.connection.BaseCluster.access$900(r1)
                r2 = r10
                long r1 = java.lang.Math.min(r1, r2)
                long r0 = java.lang.Math.min(r0, r1)
                r10 = r0
            L_0x0074:
                goto L_0x0032
            L_0x0077:
                r0 = r10
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 >= 0) goto L_0x0086
                r0 = r7
                com.mongodb.internal.connection.BaseCluster r0 = com.mongodb.internal.connection.BaseCluster.this
                r0.connect()
            L_0x0086:
                r0 = r8
                r1 = r10
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: InterruptedException -> 0x0092
                boolean r0 = r0.await(r1, r2)     // Catch: InterruptedException -> 0x0092
                goto L_0x0094
            L_0x0092:
                r12 = move-exception
            L_0x0094:
                goto L_0x0000
            L_0x0097:
                r0 = r7
                com.mongodb.internal.connection.BaseCluster r0 = com.mongodb.internal.connection.BaseCluster.this
                java.util.Deque r0 = com.mongodb.internal.connection.BaseCluster.access$700(r0)
                java.util.Iterator r0 = r0.iterator()
                r8 = r0
            L_0x00a4:
                r0 = r8
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x00cc
                r0 = r8
                java.lang.Object r0 = r0.next()
                com.mongodb.internal.connection.BaseCluster$ServerSelectionRequest r0 = (com.mongodb.internal.connection.BaseCluster.ServerSelectionRequest) r0
                r1 = 0
                com.mongodb.MongoClientException r2 = new com.mongodb.MongoClientException
                r3 = r2
                java.lang.String r4 = "Shutdown in progress"
                r3.<init>(r4)
                r0.onResult(r1, r2)
                r0 = r8
                r0.remove()
                goto L_0x00a4
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.BaseCluster.WaitQueueHandler.run():void");
        }
    }
}
