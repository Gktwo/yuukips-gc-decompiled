package com.mongodb.connection;

import com.mongodb.ConnectionString;
import com.mongodb.ServerAddress;
import com.mongodb.annotations.Immutable;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.event.ClusterListener;
import com.mongodb.internal.connection.ServerAddressHelper;
import com.mongodb.internal.selector.LatencyMinimizingServerSelector;
import com.mongodb.lang.Nullable;
import com.mongodb.selector.CompositeServerSelector;
import com.mongodb.selector.ServerSelector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import p013io.javalin.http.sse.EmitterKt;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/ClusterSettings.class */
public final class ClusterSettings {
    private final String srvHost;
    private final List<ServerAddress> hosts;
    private final ClusterConnectionMode mode;
    private final ClusterType requiredClusterType;
    private final String requiredReplicaSetName;
    private final ServerSelector serverSelector;
    private final long localThresholdMS;
    private final long serverSelectionTimeoutMS;
    private final List<ClusterListener> clusterListeners;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ClusterSettings clusterSettings) {
        return builder().applySettings(clusterSettings);
    }

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/connection/ClusterSettings$Builder.class */
    public static final class Builder {
        private static final List<ServerAddress> DEFAULT_HOSTS = Collections.singletonList(new ServerAddress());
        private String srvHost;
        private List<ServerAddress> hosts;
        private ClusterConnectionMode mode;
        private ClusterType requiredClusterType;
        private String requiredReplicaSetName;
        private ServerSelector serverSelector;
        private long serverSelectionTimeoutMS;
        private long localThresholdMS;
        private List<ClusterListener> clusterListeners;

        private Builder() {
            this.hosts = DEFAULT_HOSTS;
            this.requiredClusterType = ClusterType.UNKNOWN;
            this.serverSelectionTimeoutMS = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);
            this.localThresholdMS = TimeUnit.MILLISECONDS.convert(15, TimeUnit.MILLISECONDS);
            this.clusterListeners = new ArrayList();
        }

        public Builder applySettings(ClusterSettings clusterSettings) {
            Assertions.notNull("clusterSettings", clusterSettings);
            this.srvHost = clusterSettings.srvHost;
            this.hosts = clusterSettings.hosts;
            this.mode = clusterSettings.mode;
            this.requiredReplicaSetName = clusterSettings.requiredReplicaSetName;
            this.requiredClusterType = clusterSettings.requiredClusterType;
            this.localThresholdMS = clusterSettings.localThresholdMS;
            this.serverSelectionTimeoutMS = clusterSettings.serverSelectionTimeoutMS;
            this.clusterListeners = new ArrayList(clusterSettings.clusterListeners);
            this.serverSelector = unpackServerSelector(clusterSettings.serverSelector);
            return this;
        }

        public Builder srvHost(String srvHost) {
            if (this.hosts != DEFAULT_HOSTS) {
                throw new IllegalArgumentException("Can not set both hosts and srvHost");
            }
            this.srvHost = srvHost;
            return this;
        }

        public Builder hosts(List<ServerAddress> hosts) {
            Assertions.notNull("hosts", hosts);
            if (hosts.isEmpty()) {
                throw new IllegalArgumentException("hosts list may not be empty");
            } else if (this.srvHost != null) {
                throw new IllegalArgumentException("srvHost must be null");
            } else {
                Set<ServerAddress> hostsSet = new LinkedHashSet<>(hosts.size());
                for (ServerAddress serverAddress : hosts) {
                    Assertions.notNull("serverAddress", serverAddress);
                    hostsSet.add(ServerAddressHelper.createServerAddress(serverAddress.getHost(), serverAddress.getPort()));
                }
                this.hosts = Collections.unmodifiableList(new ArrayList(hostsSet));
                return this;
            }
        }

        public Builder mode(ClusterConnectionMode mode) {
            this.mode = (ClusterConnectionMode) Assertions.notNull("mode", mode);
            return this;
        }

        public Builder requiredReplicaSetName(String requiredReplicaSetName) {
            this.requiredReplicaSetName = requiredReplicaSetName;
            return this;
        }

        public Builder requiredClusterType(ClusterType requiredClusterType) {
            this.requiredClusterType = (ClusterType) Assertions.notNull("requiredClusterType", requiredClusterType);
            return this;
        }

        public Builder localThreshold(long localThreshold, TimeUnit timeUnit) {
            Assertions.isTrueArgument("localThreshold must be >= 0", localThreshold >= 0);
            this.localThresholdMS = TimeUnit.MILLISECONDS.convert(localThreshold, timeUnit);
            return this;
        }

        public Builder serverSelector(ServerSelector serverSelector) {
            this.serverSelector = serverSelector;
            return this;
        }

        public Builder serverSelectionTimeout(long serverSelectionTimeout, TimeUnit timeUnit) {
            this.serverSelectionTimeoutMS = TimeUnit.MILLISECONDS.convert(serverSelectionTimeout, timeUnit);
            return this;
        }

        public Builder addClusterListener(ClusterListener clusterListener) {
            Assertions.notNull("clusterListener", clusterListener);
            this.clusterListeners.add(clusterListener);
            return this;
        }

        public Builder applyConnectionString(ConnectionString connectionString) {
            Boolean directConnection = connectionString.isDirectConnection();
            if (connectionString.isSrvProtocol()) {
                mode(ClusterConnectionMode.MULTIPLE);
                srvHost(connectionString.getHosts().get(0));
            } else if ((directConnection == null || !directConnection.booleanValue()) && !(directConnection == null && connectionString.getHosts().size() == 1 && connectionString.getRequiredReplicaSetName() == null)) {
                mode(ClusterConnectionMode.MULTIPLE).hosts((List) connectionString.getHosts().stream().map(ServerAddressHelper::createServerAddress).collect(Collectors.toList()));
            } else {
                mode(ClusterConnectionMode.SINGLE).hosts(Collections.singletonList(ServerAddressHelper.createServerAddress(connectionString.getHosts().get(0))));
            }
            requiredReplicaSetName(connectionString.getRequiredReplicaSetName());
            Integer serverSelectionTimeout = connectionString.getServerSelectionTimeout();
            if (serverSelectionTimeout != null) {
                serverSelectionTimeout((long) serverSelectionTimeout.intValue(), TimeUnit.MILLISECONDS);
            }
            Integer localThreshold = connectionString.getLocalThreshold();
            if (localThreshold != null) {
                localThreshold((long) localThreshold.intValue(), TimeUnit.MILLISECONDS);
            }
            return this;
        }

        private ServerSelector unpackServerSelector(ServerSelector serverSelector) {
            if (serverSelector instanceof CompositeServerSelector) {
                return ((CompositeServerSelector) serverSelector).getServerSelectors().get(0);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public ServerSelector packServerSelector() {
            ServerSelector latencyMinimizingServerSelector = new LatencyMinimizingServerSelector(this.localThresholdMS, TimeUnit.MILLISECONDS);
            if (this.serverSelector == null) {
                return latencyMinimizingServerSelector;
            }
            return new CompositeServerSelector(Arrays.asList(this.serverSelector, latencyMinimizingServerSelector));
        }

        public ClusterSettings build() {
            return new ClusterSettings(this);
        }
    }

    @Nullable
    public String getSrvHost() {
        return this.srvHost;
    }

    public List<ServerAddress> getHosts() {
        return this.hosts;
    }

    public ClusterConnectionMode getMode() {
        return this.mode;
    }

    public ClusterType getRequiredClusterType() {
        return this.requiredClusterType;
    }

    public String getRequiredReplicaSetName() {
        return this.requiredReplicaSetName;
    }

    @Nullable
    public ServerSelector getServerSelector() {
        return this.serverSelector;
    }

    public long getServerSelectionTimeout(TimeUnit timeUnit) {
        return timeUnit.convert(this.serverSelectionTimeoutMS, TimeUnit.MILLISECONDS);
    }

    public long getLocalThreshold(TimeUnit timeUnit) {
        return timeUnit.convert(this.localThresholdMS, TimeUnit.MILLISECONDS);
    }

    public List<ClusterListener> getClusterListeners() {
        return this.clusterListeners;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterSettings that = (ClusterSettings) o;
        if (this.serverSelectionTimeoutMS != that.serverSelectionTimeoutMS || this.localThresholdMS != that.localThresholdMS) {
            return false;
        }
        if (this.srvHost != null) {
            if (!this.srvHost.equals(that.srvHost)) {
                return false;
            }
        } else if (that.srvHost != null) {
            return false;
        }
        if (!this.hosts.equals(that.hosts) || this.mode != that.mode || this.requiredClusterType != that.requiredClusterType) {
            return false;
        }
        if (this.requiredReplicaSetName != null) {
            if (!this.requiredReplicaSetName.equals(that.requiredReplicaSetName)) {
                return false;
            }
        } else if (that.requiredReplicaSetName != null) {
            return false;
        }
        if (this.serverSelector != null) {
            if (!this.serverSelector.equals(that.serverSelector)) {
                return false;
            }
        } else if (that.serverSelector != null) {
            return false;
        }
        if (!this.clusterListeners.equals(that.clusterListeners)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * this.hosts.hashCode()) + (this.srvHost != null ? this.srvHost.hashCode() : 0))) + this.mode.hashCode())) + this.requiredClusterType.hashCode())) + (this.requiredReplicaSetName != null ? this.requiredReplicaSetName.hashCode() : 0))) + (this.serverSelector != null ? this.serverSelector.hashCode() : 0))) + ((int) (this.serverSelectionTimeoutMS ^ (this.serverSelectionTimeoutMS >>> 32))))) + ((int) (this.localThresholdMS ^ (this.localThresholdMS >>> 32))))) + this.clusterListeners.hashCode();
    }

    public String toString() {
        return "{" + (this.hosts.isEmpty() ? "" : "hosts=" + this.hosts) + (this.srvHost == null ? "" : ", srvHost=" + this.srvHost) + ", mode=" + this.mode + ", requiredClusterType=" + this.requiredClusterType + ", requiredReplicaSetName='" + this.requiredReplicaSetName + "', serverSelector='" + this.serverSelector + "', clusterListeners='" + this.clusterListeners + "', serverSelectionTimeout='" + this.serverSelectionTimeoutMS + " ms', localThreshold='" + this.serverSelectionTimeoutMS + " ms'}";
    }

    public String getShortDescription() {
        return "{" + (this.hosts.isEmpty() ? "" : "hosts=" + this.hosts) + (this.srvHost == null ? "" : ", srvHost=" + this.srvHost) + ", mode=" + this.mode + ", requiredClusterType=" + this.requiredClusterType + ", serverSelectionTimeout='" + this.serverSelectionTimeoutMS + " ms'" + (this.requiredReplicaSetName == null ? "" : ", requiredReplicaSetName='" + this.requiredReplicaSetName + '\'') + '}';
    }

    private ClusterSettings(Builder builder) {
        ClusterConnectionMode clusterConnectionMode;
        if (builder.srvHost != null) {
            if (builder.srvHost.contains(EmitterKt.COMMENT_PREFIX)) {
                throw new IllegalArgumentException("The srvHost can not contain a host name that specifies a port");
            } else if (builder.srvHost.split("\\.").length < 3) {
                throw new IllegalArgumentException(String.format("An SRV host name '%s' was provided that does not contain at least three parts. It must contain a hostname, domain name and a top level domain.", ((ServerAddress) builder.hosts.get(0)).getHost()));
            }
        }
        if (builder.hosts.size() <= 1 || builder.requiredClusterType != ClusterType.STANDALONE) {
            if (builder.requiredReplicaSetName != null) {
                if (builder.requiredClusterType == ClusterType.UNKNOWN) {
                    builder.requiredClusterType = ClusterType.REPLICA_SET;
                } else if (builder.requiredClusterType != ClusterType.REPLICA_SET) {
                    throw new IllegalArgumentException("When specifying a replica set name, only ClusterType.UNKNOWN and ClusterType.REPLICA_SET are valid.");
                }
            }
            this.srvHost = builder.srvHost;
            this.hosts = builder.hosts;
            if (this.srvHost != null) {
                if (builder.mode == ClusterConnectionMode.SINGLE) {
                    throw new IllegalArgumentException("An SRV host name was provided but the connection mode is not MULTIPLE");
                }
                this.mode = ClusterConnectionMode.MULTIPLE;
            } else if (builder.mode != ClusterConnectionMode.SINGLE || builder.hosts.size() <= 1) {
                if (builder.mode != null) {
                    clusterConnectionMode = builder.mode;
                } else {
                    clusterConnectionMode = this.hosts.size() == 1 ? ClusterConnectionMode.SINGLE : ClusterConnectionMode.MULTIPLE;
                }
                this.mode = clusterConnectionMode;
            } else {
                throw new IllegalArgumentException("Can not directly connect to more than one server");
            }
            this.requiredReplicaSetName = builder.requiredReplicaSetName;
            this.requiredClusterType = builder.requiredClusterType;
            this.localThresholdMS = builder.localThresholdMS;
            this.serverSelector = builder.packServerSelector();
            this.serverSelectionTimeoutMS = builder.serverSelectionTimeoutMS;
            this.clusterListeners = Collections.unmodifiableList(builder.clusterListeners);
            return;
        }
        throw new IllegalArgumentException("Multiple hosts cannot be specified when using ClusterType.STANDALONE.");
    }
}
