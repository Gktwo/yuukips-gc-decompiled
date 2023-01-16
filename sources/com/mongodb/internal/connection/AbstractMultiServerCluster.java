package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ClusterType;
import com.mongodb.connection.ServerConnectionState;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerType;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.ServerDescriptionChangedEvent;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.selector.ServerSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bson.BsonTimestamp;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AbstractMultiServerCluster.class */
public abstract class AbstractMultiServerCluster extends BaseCluster {
    private static final Logger LOGGER = Loggers.getLogger("cluster");
    private ClusterType clusterType;
    private String replicaSetName;
    private ObjectId maxElectionId;
    private Integer maxSetVersion;
    private final ConcurrentMap<ServerAddress, ServerTuple> addressToServerTupleMap = new ConcurrentHashMap();

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ClusterDescription getCurrentDescription() {
        return getCurrentDescription();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ boolean isClosed() {
        return isClosed();
    }

    @Override // com.mongodb.internal.connection.BaseCluster
    public /* bridge */ /* synthetic */ ClusterableServerFactory getServerFactory() {
        return getServerFactory();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ClusterSettings getSettings() {
        return getSettings();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ClusterDescription getDescription() {
        return getDescription();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ void selectServerAsync(ServerSelector serverSelector, SingleResultCallback singleResultCallback) {
        selectServerAsync(serverSelector, singleResultCallback);
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ServerTuple selectServer(ServerSelector serverSelector) {
        return selectServer(serverSelector);
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ BsonTimestamp getClusterTime() {
        return getClusterTime();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AbstractMultiServerCluster$ServerTuple.class */
    public static final class ServerTuple {
        private final ClusterableServer server;
        private ServerDescription description;

        private ServerTuple(ClusterableServer server, ServerDescription description) {
            this.server = server;
            this.description = description;
        }
    }

    /* access modifiers changed from: package-private */
    public AbstractMultiServerCluster(ClusterId clusterId, ClusterSettings settings, ClusterableServerFactory serverFactory) {
        super(clusterId, settings, serverFactory);
        Assertions.isTrue("connection mode is multiple", settings.getMode() == ClusterConnectionMode.MULTIPLE);
        this.clusterType = settings.getRequiredClusterType();
        this.replicaSetName = settings.getRequiredReplicaSetName();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(String.format("Cluster created with settings %s", settings.getShortDescription()));
        }
    }

    ClusterType getClusterType() {
        return this.clusterType;
    }

    MongoException getSrvResolutionException() {
        return null;
    }

    protected void initialize(Collection<ServerAddress> serverAddresses) {
        ClusterDescription newDescription;
        ClusterDescription currentDescription = getCurrentDescription();
        synchronized (this) {
            for (ServerAddress serverAddress : serverAddresses) {
                addServer(serverAddress);
            }
            newDescription = updateDescription();
        }
        fireChangeEvent(newDescription, currentDescription);
    }

    @Override // com.mongodb.internal.connection.BaseCluster
    protected void connect() {
        for (ServerTuple cur : this.addressToServerTupleMap.values()) {
            cur.server.connect();
        }
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (!isClosed()) {
                for (ServerTuple serverTuple : this.addressToServerTupleMap.values()) {
                    serverTuple.server.close();
                }
            }
            close();
        }
    }

    @Override // com.mongodb.internal.connection.BaseCluster
    protected ClusterableServer getServer(ServerAddress serverAddress) {
        Assertions.isTrue("is open", !isClosed());
        ServerTuple serverTuple = this.addressToServerTupleMap.get(serverAddress);
        if (serverTuple == null) {
            return null;
        }
        return serverTuple.server;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AbstractMultiServerCluster$DefaultServerDescriptionChangedListener.class */
    public final class DefaultServerDescriptionChangedListener implements ServerDescriptionChangedListener {
        private DefaultServerDescriptionChangedListener() {
        }

        @Override // com.mongodb.internal.connection.ServerDescriptionChangedListener
        public void serverDescriptionChanged(ServerDescriptionChangedEvent event) {
            AbstractMultiServerCluster.this.onChange(event);
        }
    }

    void onChange(Collection<ServerAddress> newHosts) {
        synchronized (this) {
            if (!isClosed()) {
                for (ServerAddress cur : newHosts) {
                    addServer(cur);
                }
                Iterator<ServerTuple> iterator = this.addressToServerTupleMap.values().iterator();
                while (iterator.hasNext()) {
                    ServerTuple cur2 = iterator.next();
                    if (!newHosts.contains(cur2.description.getAddress())) {
                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("Removing %s from client view of cluster.", cur2.description.getAddress()));
                        }
                        iterator.remove();
                        cur2.server.close();
                    }
                }
                fireChangeEvent(updateDescription(), getCurrentDescription());
            }
        }
    }

    /* access modifiers changed from: private */
    public void onChange(ServerDescriptionChangedEvent event) {
        ClusterDescription oldClusterDescription = null;
        ClusterDescription newClusterDescription = null;
        boolean shouldUpdateDescription = true;
        synchronized (this) {
            if (!isClosed()) {
                ServerDescription newDescription = event.getNewDescription();
                if (LOGGER.isTraceEnabled()) {
                    LOGGER.trace(String.format("Handling description changed event for server %s with description %s", newDescription.getAddress(), newDescription));
                }
                ServerTuple serverTuple = this.addressToServerTupleMap.get(newDescription.getAddress());
                if (serverTuple == null) {
                    if (LOGGER.isTraceEnabled()) {
                        LOGGER.trace(String.format("Ignoring description changed event for removed server %s", newDescription.getAddress()));
                    }
                    return;
                }
                if (newDescription.isOk()) {
                    if (this.clusterType == ClusterType.UNKNOWN && newDescription.getType() != ServerType.REPLICA_SET_GHOST) {
                        this.clusterType = newDescription.getClusterType();
                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("Discovered cluster type of %s", this.clusterType));
                        }
                    }
                    switch (this.clusterType) {
                        case REPLICA_SET:
                            shouldUpdateDescription = handleReplicaSetMemberChanged(newDescription);
                            break;
                        case SHARDED:
                            shouldUpdateDescription = handleShardRouterChanged(newDescription);
                            break;
                        case STANDALONE:
                            shouldUpdateDescription = handleStandAloneChanged(newDescription);
                            break;
                    }
                }
                if (shouldUpdateDescription) {
                    serverTuple.description = newDescription;
                    oldClusterDescription = getCurrentDescription();
                    newClusterDescription = updateDescription();
                }
                if (shouldUpdateDescription) {
                    fireChangeEvent(newClusterDescription, oldClusterDescription);
                }
            }
        }
    }

    private boolean handleReplicaSetMemberChanged(ServerDescription newDescription) {
        if (!newDescription.isReplicaSetMember()) {
            LOGGER.error(String.format("Expecting replica set member, but found a %s.  Removing %s from client view of cluster.", newDescription.getType(), newDescription.getAddress()));
            removeServer(newDescription.getAddress());
            return true;
        } else if (newDescription.getType() != ServerType.REPLICA_SET_GHOST) {
            if (this.replicaSetName == null) {
                this.replicaSetName = newDescription.getSetName();
            }
            if (!this.replicaSetName.equals(newDescription.getSetName())) {
                LOGGER.error(String.format("Expecting replica set member from set '%s', but found one from set '%s'.  Removing %s from client view of cluster.", this.replicaSetName, newDescription.getSetName(), newDescription.getAddress()));
                removeServer(newDescription.getAddress());
                return true;
            }
            ensureServers(newDescription);
            if (newDescription.getCanonicalAddress() != null && !newDescription.getAddress().equals(new ServerAddress(newDescription.getCanonicalAddress())) && !newDescription.isPrimary()) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info(String.format("Canonical address %s does not match server address.  Removing %s from client view of cluster", newDescription.getCanonicalAddress(), newDescription.getAddress()));
                }
                removeServer(newDescription.getAddress());
                return true;
            } else if (!newDescription.isPrimary()) {
                return true;
            } else {
                ObjectId electionId = newDescription.getElectionId();
                Integer setVersion = newDescription.getSetVersion();
                if (!(setVersion == null || electionId == null)) {
                    if (isStalePrimary(newDescription)) {
                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("Invalidating potential primary %s whose (set version, election id) tuple of (%d, %s) is less than one already seen of (%d, %s)", newDescription.getAddress(), setVersion, electionId, this.maxSetVersion, this.maxElectionId));
                        }
                        this.addressToServerTupleMap.get(newDescription.getAddress()).server.resetToConnecting();
                        return false;
                    } else if (!electionId.equals(this.maxElectionId)) {
                        if (LOGGER.isInfoEnabled()) {
                            LOGGER.info(String.format("Setting max election id to %s from replica set primary %s", electionId, newDescription.getAddress()));
                        }
                        this.maxElectionId = electionId;
                    }
                }
                if (setVersion != null && (this.maxSetVersion == null || setVersion.compareTo(this.maxSetVersion) > 0)) {
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.info(String.format("Setting max set version to %d from replica set primary %s", setVersion, newDescription.getAddress()));
                    }
                    this.maxSetVersion = setVersion;
                }
                if (isNotAlreadyPrimary(newDescription.getAddress())) {
                    LOGGER.info(String.format("Discovered replica set primary %s", newDescription.getAddress()));
                }
                invalidateOldPrimaries(newDescription.getAddress());
                return true;
            }
        } else if (!LOGGER.isInfoEnabled()) {
            return true;
        } else {
            LOGGER.info(String.format("Server %s does not appear to be a member of an initiated replica set.", newDescription.getAddress()));
            return true;
        }
    }

    private boolean isStalePrimary(ServerDescription newDescription) {
        if (this.maxSetVersion == null || this.maxElectionId == null) {
            return false;
        }
        Integer setVersion = newDescription.getSetVersion();
        return setVersion == null || this.maxSetVersion.compareTo(setVersion) > 0 || (this.maxSetVersion.equals(setVersion) && this.maxElectionId.compareTo(newDescription.getElectionId()) > 0);
    }

    private boolean isNotAlreadyPrimary(ServerAddress address) {
        ServerTuple serverTuple = this.addressToServerTupleMap.get(address);
        return serverTuple == null || !serverTuple.description.isPrimary();
    }

    private boolean handleShardRouterChanged(ServerDescription newDescription) {
        if (newDescription.isShardRouter()) {
            return true;
        }
        LOGGER.error(String.format("Expecting a %s, but found a %s.  Removing %s from client view of cluster.", ServerType.SHARD_ROUTER, newDescription.getType(), newDescription.getAddress()));
        removeServer(newDescription.getAddress());
        return true;
    }

    private boolean handleStandAloneChanged(ServerDescription newDescription) {
        if (getSettings().getHosts().size() <= 1) {
            return true;
        }
        LOGGER.error(String.format("Expecting a single %s, but found more than one.  Removing %s from client view of cluster.", ServerType.STANDALONE, newDescription.getAddress()));
        this.clusterType = ClusterType.UNKNOWN;
        removeServer(newDescription.getAddress());
        return true;
    }

    private void addServer(ServerAddress serverAddress) {
        if (!this.addressToServerTupleMap.containsKey(serverAddress)) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(String.format("Adding discovered server %s to client view of cluster", serverAddress));
            }
            this.addressToServerTupleMap.put(serverAddress, new ServerTuple(createServer(serverAddress, new DefaultServerDescriptionChangedListener()), getConnectingServerDescription(serverAddress)));
        }
    }

    private void removeServer(ServerAddress serverAddress) {
        ServerTuple removed = this.addressToServerTupleMap.remove(serverAddress);
        if (removed != null) {
            removed.server.close();
        }
    }

    private void invalidateOldPrimaries(ServerAddress newPrimary) {
        for (ServerTuple serverTuple : this.addressToServerTupleMap.values()) {
            if (!serverTuple.description.getAddress().equals(newPrimary) && serverTuple.description.isPrimary()) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info(String.format("Rediscovering type of existing primary %s", serverTuple.description.getAddress()));
                }
                serverTuple.server.invalidate();
            }
        }
    }

    private ServerDescription getConnectingServerDescription(ServerAddress serverAddress) {
        return ServerDescription.builder().state(ServerConnectionState.CONNECTING).address(serverAddress).build();
    }

    private ClusterDescription updateDescription() {
        ClusterDescription newDescription = new ClusterDescription(ClusterConnectionMode.MULTIPLE, this.clusterType, getSrvResolutionException(), getNewServerDescriptionList(), getSettings(), getServerFactory().getSettings());
        updateDescription(newDescription);
        return newDescription;
    }

    private List<ServerDescription> getNewServerDescriptionList() {
        List<ServerDescription> serverDescriptions = new ArrayList<>();
        for (ServerTuple cur : this.addressToServerTupleMap.values()) {
            serverDescriptions.add(cur.description);
        }
        return serverDescriptions;
    }

    private void ensureServers(ServerDescription description) {
        if (description.isPrimary() || !hasPrimary()) {
            addNewHosts(description.getHosts());
            addNewHosts(description.getPassives());
            addNewHosts(description.getArbiters());
        }
        if (description.isPrimary()) {
            removeExtraHosts(description);
        }
    }

    private boolean hasPrimary() {
        for (ServerTuple serverTuple : this.addressToServerTupleMap.values()) {
            if (serverTuple.description.isPrimary()) {
                return true;
            }
        }
        return false;
    }

    private void addNewHosts(Set<String> hosts) {
        for (String cur : hosts) {
            addServer(new ServerAddress(cur));
        }
    }

    private void removeExtraHosts(ServerDescription serverDescription) {
        Set<ServerAddress> allServerAddresses = getAllServerAddresses(serverDescription);
        Iterator<ServerTuple> iterator = this.addressToServerTupleMap.values().iterator();
        while (iterator.hasNext()) {
            ServerTuple cur = iterator.next();
            if (!allServerAddresses.contains(cur.description.getAddress())) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info(String.format("Server %s is no longer a member of the replica set.  Removing from client view of cluster.", cur.description.getAddress()));
                }
                iterator.remove();
                cur.server.close();
            }
        }
    }

    private Set<ServerAddress> getAllServerAddresses(ServerDescription serverDescription) {
        Set<ServerAddress> retVal = new HashSet<>();
        addHostsToSet(serverDescription.getHosts(), retVal);
        addHostsToSet(serverDescription.getPassives(), retVal);
        addHostsToSet(serverDescription.getArbiters(), retVal);
        return retVal;
    }

    private void addHostsToSet(Set<String> hosts, Set<ServerAddress> retVal) {
        for (String host : hosts) {
            retVal.add(new ServerAddress(host));
        }
    }
}
