package com.mongodb.connection;

import com.mongodb.ServerAddress;
import com.mongodb.TagSet;
import com.mongodb.annotations.Immutable;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.connection.DecimalFormatHelper;
import com.mongodb.internal.connection.Time;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.bson.types.ObjectId;
import org.jline.builtins.TTop;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/ServerDescription.class */
public class ServerDescription {
    public static final String MIN_DRIVER_SERVER_VERSION = "2.6";
    public static final int MIN_DRIVER_WIRE_VERSION = 2;
    public static final int MAX_DRIVER_WIRE_VERSION = 9;
    private static final int DEFAULT_MAX_DOCUMENT_SIZE = 16777216;
    private final ServerAddress address;
    private final ServerType type;
    private final String canonicalAddress;
    private final Set<String> hosts;
    private final Set<String> passives;
    private final Set<String> arbiters;
    private final String primary;
    private final int maxDocumentSize;
    private final TagSet tagSet;
    private final String setName;
    private final long roundTripTimeNanos;

    /* renamed from: ok */
    private final boolean f449ok;
    private final ServerConnectionState state;
    private final int minWireVersion;
    private final int maxWireVersion;
    private final ObjectId electionId;
    private final Integer setVersion;
    private final TopologyVersion topologyVersion;
    private final Date lastWriteDate;
    private final long lastUpdateTimeNanos;
    private final Integer logicalSessionTimeoutMinutes;
    private final Throwable exception;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ServerDescription serverDescription) {
        return new Builder(serverDescription);
    }

    public String getCanonicalAddress() {
        return this.canonicalAddress;
    }

    @Nullable
    public Integer getLogicalSessionTimeoutMinutes() {
        return this.logicalSessionTimeoutMinutes;
    }

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/connection/ServerDescription$Builder.class */
    public static class Builder {
        private ServerAddress address;
        private ServerType type;
        private String canonicalAddress;
        private Set<String> hosts;
        private Set<String> passives;
        private Set<String> arbiters;
        private String primary;
        private int maxDocumentSize;
        private TagSet tagSet;
        private String setName;
        private long roundTripTimeNanos;

        /* renamed from: ok */
        private boolean f450ok;
        private ServerConnectionState state;
        private int minWireVersion;
        private int maxWireVersion;
        private ObjectId electionId;
        private Integer setVersion;
        private TopologyVersion topologyVersion;
        private Date lastWriteDate;
        private long lastUpdateTimeNanos;
        private Integer logicalSessionTimeoutMinutes;
        private Throwable exception;

        Builder() {
            this.type = ServerType.UNKNOWN;
            this.hosts = Collections.emptySet();
            this.passives = Collections.emptySet();
            this.arbiters = Collections.emptySet();
            this.maxDocumentSize = 16777216;
            this.tagSet = new TagSet();
            this.minWireVersion = 0;
            this.maxWireVersion = 0;
            this.lastUpdateTimeNanos = Time.nanoTime();
        }

        Builder(ServerDescription serverDescription) {
            this.type = ServerType.UNKNOWN;
            this.hosts = Collections.emptySet();
            this.passives = Collections.emptySet();
            this.arbiters = Collections.emptySet();
            this.maxDocumentSize = 16777216;
            this.tagSet = new TagSet();
            this.minWireVersion = 0;
            this.maxWireVersion = 0;
            this.lastUpdateTimeNanos = Time.nanoTime();
            this.address = serverDescription.address;
            this.type = serverDescription.type;
            this.canonicalAddress = serverDescription.canonicalAddress;
            this.hosts = serverDescription.hosts;
            this.passives = serverDescription.passives;
            this.arbiters = serverDescription.arbiters;
            this.primary = serverDescription.primary;
            this.maxDocumentSize = serverDescription.maxDocumentSize;
            this.tagSet = serverDescription.tagSet;
            this.setName = serverDescription.setName;
            this.roundTripTimeNanos = serverDescription.roundTripTimeNanos;
            this.f450ok = serverDescription.f449ok;
            this.state = serverDescription.state;
            this.minWireVersion = serverDescription.minWireVersion;
            this.maxWireVersion = serverDescription.maxWireVersion;
            this.electionId = serverDescription.electionId;
            this.setVersion = serverDescription.setVersion;
            this.topologyVersion = serverDescription.topologyVersion;
            this.lastWriteDate = serverDescription.lastWriteDate;
            this.lastUpdateTimeNanos = serverDescription.lastUpdateTimeNanos;
            this.logicalSessionTimeoutMinutes = serverDescription.logicalSessionTimeoutMinutes;
            this.exception = serverDescription.exception;
        }

        public Builder address(ServerAddress address) {
            this.address = address;
            return this;
        }

        public Builder canonicalAddress(String canonicalAddress) {
            this.canonicalAddress = canonicalAddress;
            return this;
        }

        public Builder type(ServerType type) {
            this.type = (ServerType) Assertions.notNull("type", type);
            return this;
        }

        public Builder hosts(Set<String> hosts) {
            this.hosts = hosts == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(hosts));
            return this;
        }

        public Builder passives(Set<String> passives) {
            this.passives = passives == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(passives));
            return this;
        }

        public Builder arbiters(Set<String> arbiters) {
            this.arbiters = arbiters == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(arbiters));
            return this;
        }

        public Builder primary(String primary) {
            this.primary = primary;
            return this;
        }

        public Builder maxDocumentSize(int maxDocumentSize) {
            this.maxDocumentSize = maxDocumentSize;
            return this;
        }

        public Builder tagSet(TagSet tagSet) {
            this.tagSet = tagSet == null ? new TagSet() : tagSet;
            return this;
        }

        public Builder roundTripTime(long roundTripTime, TimeUnit timeUnit) {
            this.roundTripTimeNanos = timeUnit.toNanos(roundTripTime);
            return this;
        }

        public Builder setName(String setName) {
            this.setName = setName;
            return this;
        }

        /* renamed from: ok */
        public Builder m1269ok(boolean ok) {
            this.f450ok = ok;
            return this;
        }

        public Builder state(ServerConnectionState state) {
            this.state = state;
            return this;
        }

        public Builder minWireVersion(int minWireVersion) {
            this.minWireVersion = minWireVersion;
            return this;
        }

        public Builder maxWireVersion(int maxWireVersion) {
            this.maxWireVersion = maxWireVersion;
            return this;
        }

        public Builder electionId(ObjectId electionId) {
            this.electionId = electionId;
            return this;
        }

        public Builder setVersion(Integer setVersion) {
            this.setVersion = setVersion;
            return this;
        }

        public Builder topologyVersion(TopologyVersion topologyVersion) {
            this.topologyVersion = topologyVersion;
            return this;
        }

        public Builder lastWriteDate(@Nullable Date lastWriteDate) {
            this.lastWriteDate = lastWriteDate;
            return this;
        }

        public Builder lastUpdateTimeNanos(long lastUpdateTimeNanos) {
            this.lastUpdateTimeNanos = lastUpdateTimeNanos;
            return this;
        }

        public Builder logicalSessionTimeoutMinutes(@Nullable Integer logicalSessionTimeoutMinutes) {
            this.logicalSessionTimeoutMinutes = logicalSessionTimeoutMinutes;
            return this;
        }

        public Builder exception(Throwable exception) {
            this.exception = exception;
            return this;
        }

        public ServerDescription build() {
            return new ServerDescription(this);
        }
    }

    public boolean isCompatibleWithDriver() {
        if (!isIncompatiblyOlderThanDriver() && !isIncompatiblyNewerThanDriver()) {
            return true;
        }
        return false;
    }

    public boolean isIncompatiblyNewerThanDriver() {
        return this.f449ok && this.minWireVersion > 9;
    }

    public boolean isIncompatiblyOlderThanDriver() {
        return this.f449ok && this.maxWireVersion < 2;
    }

    public static int getDefaultMaxDocumentSize() {
        return 16777216;
    }

    public static int getDefaultMinWireVersion() {
        return 0;
    }

    public static int getDefaultMaxWireVersion() {
        return 0;
    }

    public ServerAddress getAddress() {
        return this.address;
    }

    public boolean isReplicaSetMember() {
        return this.type.getClusterType() == ClusterType.REPLICA_SET;
    }

    public boolean isShardRouter() {
        return this.type == ServerType.SHARD_ROUTER;
    }

    public boolean isStandAlone() {
        return this.type == ServerType.STANDALONE;
    }

    public boolean isPrimary() {
        return this.f449ok && (this.type == ServerType.REPLICA_SET_PRIMARY || this.type == ServerType.SHARD_ROUTER || this.type == ServerType.STANDALONE);
    }

    public boolean isSecondary() {
        return this.f449ok && (this.type == ServerType.REPLICA_SET_SECONDARY || this.type == ServerType.SHARD_ROUTER || this.type == ServerType.STANDALONE);
    }

    public Set<String> getHosts() {
        return this.hosts;
    }

    public Set<String> getPassives() {
        return this.passives;
    }

    public Set<String> getArbiters() {
        return this.arbiters;
    }

    public String getPrimary() {
        return this.primary;
    }

    public int getMaxDocumentSize() {
        return this.maxDocumentSize;
    }

    public TagSet getTagSet() {
        return this.tagSet;
    }

    public int getMinWireVersion() {
        return this.minWireVersion;
    }

    public int getMaxWireVersion() {
        return this.maxWireVersion;
    }

    @Nullable
    public ObjectId getElectionId() {
        return this.electionId;
    }

    @Nullable
    public Integer getSetVersion() {
        return this.setVersion;
    }

    public TopologyVersion getTopologyVersion() {
        return this.topologyVersion;
    }

    @Nullable
    public Date getLastWriteDate() {
        return this.lastWriteDate;
    }

    public long getLastUpdateTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.lastUpdateTimeNanos, TimeUnit.NANOSECONDS);
    }

    public boolean hasTags(TagSet desiredTags) {
        if (!this.f449ok) {
            return false;
        }
        if (this.type == ServerType.STANDALONE || this.type == ServerType.SHARD_ROUTER) {
            return true;
        }
        return this.tagSet.containsAll(desiredTags);
    }

    public String getSetName() {
        return this.setName;
    }

    public boolean isOk() {
        return this.f449ok;
    }

    public ServerConnectionState getState() {
        return this.state;
    }

    public ServerType getType() {
        return this.type;
    }

    public ClusterType getClusterType() {
        return this.type.getClusterType();
    }

    public long getRoundTripTimeNanos() {
        return this.roundTripTimeNanos;
    }

    @Nullable
    public Throwable getException() {
        return this.exception;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerDescription that = (ServerDescription) o;
        if (this.maxDocumentSize != that.maxDocumentSize || this.f449ok != that.f449ok || !this.address.equals(that.address) || !this.arbiters.equals(that.arbiters)) {
            return false;
        }
        if (this.canonicalAddress != null) {
            if (!this.canonicalAddress.equals(that.canonicalAddress)) {
                return false;
            }
        } else if (that.canonicalAddress != null) {
            return false;
        }
        if (!this.hosts.equals(that.hosts) || !this.passives.equals(that.passives)) {
            return false;
        }
        if (this.primary != null) {
            if (!this.primary.equals(that.primary)) {
                return false;
            }
        } else if (that.primary != null) {
            return false;
        }
        if (this.setName != null) {
            if (!this.setName.equals(that.setName)) {
                return false;
            }
        } else if (that.setName != null) {
            return false;
        }
        if (this.state != that.state || !this.tagSet.equals(that.tagSet) || this.type != that.type || this.minWireVersion != that.minWireVersion || this.maxWireVersion != that.maxWireVersion) {
            return false;
        }
        if (this.electionId != null) {
            if (!this.electionId.equals(that.electionId)) {
                return false;
            }
        } else if (that.electionId != null) {
            return false;
        }
        if (this.setVersion != null) {
            if (!this.setVersion.equals(that.setVersion)) {
                return false;
            }
        } else if (that.setVersion != null) {
            return false;
        }
        if (this.topologyVersion != null) {
            if (!this.topologyVersion.equals(that.topologyVersion)) {
                return false;
            }
        } else if (that.topologyVersion != null) {
            return false;
        }
        if (this.lastWriteDate != null) {
            if (!this.lastWriteDate.equals(that.lastWriteDate)) {
                return false;
            }
        } else if (that.lastWriteDate != null) {
            return false;
        }
        if (this.lastUpdateTimeNanos != that.lastUpdateTimeNanos) {
            return false;
        }
        if (this.logicalSessionTimeoutMinutes != null) {
            if (!this.logicalSessionTimeoutMinutes.equals(that.logicalSessionTimeoutMinutes)) {
                return false;
            }
        } else if (that.logicalSessionTimeoutMinutes != null) {
            return false;
        }
        Class<?> thisExceptionClass = this.exception != null ? this.exception.getClass() : null;
        Class<?> thatExceptionClass = that.exception != null ? that.exception.getClass() : null;
        if (thisExceptionClass != null) {
            if (!thisExceptionClass.equals(thatExceptionClass)) {
                return false;
            }
        } else if (thatExceptionClass != null) {
            return false;
        }
        String thisExceptionMessage = this.exception != null ? this.exception.getMessage() : null;
        String thatExceptionMessage = that.exception != null ? that.exception.getMessage() : null;
        if (thisExceptionMessage != null) {
            if (!thisExceptionMessage.equals(thatExceptionMessage)) {
                return false;
            }
            return true;
        } else if (thatExceptionMessage != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * this.address.hashCode()) + this.type.hashCode())) + (this.canonicalAddress != null ? this.canonicalAddress.hashCode() : 0))) + this.hosts.hashCode())) + this.passives.hashCode())) + this.arbiters.hashCode())) + (this.primary != null ? this.primary.hashCode() : 0))) + this.maxDocumentSize)) + this.tagSet.hashCode())) + (this.setName != null ? this.setName.hashCode() : 0))) + (this.electionId != null ? this.electionId.hashCode() : 0))) + (this.setVersion != null ? this.setVersion.hashCode() : 0))) + (this.topologyVersion != null ? this.topologyVersion.hashCode() : 0))) + (this.lastWriteDate != null ? this.lastWriteDate.hashCode() : 0))) + ((int) (this.lastUpdateTimeNanos ^ (this.lastUpdateTimeNanos >>> 32))))) + (this.f449ok ? 1 : 0))) + this.state.hashCode())) + this.minWireVersion)) + this.maxWireVersion)) + (this.logicalSessionTimeoutMinutes != null ? this.logicalSessionTimeoutMinutes.hashCode() : 0))) + (this.exception == null ? 0 : this.exception.getClass().hashCode()))) + (this.exception == null ? 0 : this.exception.getMessage().hashCode());
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder append = new StringBuilder().append("ServerDescription{address=").append(this.address).append(", type=").append(this.type).append(", state=").append(this.state);
        if (this.state == ServerConnectionState.CONNECTED) {
            str = ", ok=" + this.f449ok + ", minWireVersion=" + this.minWireVersion + ", maxWireVersion=" + this.maxWireVersion + ", maxDocumentSize=" + this.maxDocumentSize + ", logicalSessionTimeoutMinutes=" + this.logicalSessionTimeoutMinutes + ", roundTripTimeNanos=" + this.roundTripTimeNanos;
        } else {
            str = "";
        }
        StringBuilder append2 = append.append(str);
        if (isReplicaSetMember()) {
            str2 = ", setName='" + this.setName + "', canonicalAddress=" + this.canonicalAddress + ", hosts=" + this.hosts + ", passives=" + this.passives + ", arbiters=" + this.arbiters + ", primary='" + this.primary + "', tagSet=" + this.tagSet + ", electionId=" + this.electionId + ", setVersion=" + this.setVersion + ", topologyVersion=" + this.topologyVersion + ", lastWriteDate=" + this.lastWriteDate + ", lastUpdateTimeNanos=" + this.lastUpdateTimeNanos;
        } else {
            str2 = "";
        }
        return append2.append(str2).append(this.exception == null ? "" : ", exception=" + translateExceptionToString()).append('}').toString();
    }

    public String getShortDescription() {
        return "{address=" + this.address + ", type=" + this.type + (!this.tagSet.iterator().hasNext() ? "" : ", " + this.tagSet) + (this.state == ServerConnectionState.CONNECTED ? ", roundTripTime=" + getRoundTripFormattedInMilliseconds() + " ms" : "") + ", state=" + this.state + (this.exception == null ? "" : ", exception=" + translateExceptionToString()) + '}';
    }

    private String translateExceptionToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(this.exception);
        builder.append("}");
        for (Throwable cur = this.exception.getCause(); cur != null; cur = cur.getCause()) {
            builder.append(", caused by ");
            builder.append("{");
            builder.append(cur);
            builder.append("}");
        }
        return builder.toString();
    }

    private String getRoundTripFormattedInMilliseconds() {
        return DecimalFormatHelper.format("#0.0", (((double) this.roundTripTimeNanos) / 1000.0d) / 1000.0d);
    }

    ServerDescription(Builder builder) {
        this.address = (ServerAddress) Assertions.notNull("address", builder.address);
        this.type = (ServerType) Assertions.notNull("type", builder.type);
        this.state = (ServerConnectionState) Assertions.notNull(TTop.STAT_STATE, builder.state);
        this.canonicalAddress = builder.canonicalAddress;
        this.hosts = builder.hosts;
        this.passives = builder.passives;
        this.arbiters = builder.arbiters;
        this.primary = builder.primary;
        this.maxDocumentSize = builder.maxDocumentSize;
        this.tagSet = builder.tagSet;
        this.setName = builder.setName;
        this.roundTripTimeNanos = builder.roundTripTimeNanos;
        this.f449ok = builder.f450ok;
        this.minWireVersion = builder.minWireVersion;
        this.maxWireVersion = builder.maxWireVersion;
        this.electionId = builder.electionId;
        this.setVersion = builder.setVersion;
        this.topologyVersion = builder.topologyVersion;
        this.lastWriteDate = builder.lastWriteDate;
        this.lastUpdateTimeNanos = builder.lastUpdateTimeNanos;
        this.logicalSessionTimeoutMinutes = builder.logicalSessionTimeoutMinutes;
        this.exception = builder.exception;
    }
}
