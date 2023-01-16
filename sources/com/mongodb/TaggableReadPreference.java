package com.mongodb;

import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ClusterType;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.ClusterDescriptionHelper;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/TaggableReadPreference.class */
public abstract class TaggableReadPreference extends ReadPreference {
    private static final int SMALLEST_MAX_STALENESS_MS = 90000;
    private static final int IDLE_WRITE_PERIOD_MS = 10000;
    private final List<TagSet> tagSetList;
    private final Long maxStalenessMS;
    private final ReadPreferenceHedgeOptions hedgeOptions;

    @Override // com.mongodb.ReadPreference
    public abstract TaggableReadPreference withTagSet(TagSet tagSet);

    @Override // com.mongodb.ReadPreference
    public abstract TaggableReadPreference withTagSetList(List<TagSet> list);

    @Override // com.mongodb.ReadPreference
    public abstract TaggableReadPreference withMaxStalenessMS(Long l, TimeUnit timeUnit);

    @Override // com.mongodb.ReadPreference
    public abstract TaggableReadPreference withHedgeOptions(ReadPreferenceHedgeOptions readPreferenceHedgeOptions);

    TaggableReadPreference() {
        this.tagSetList = new ArrayList();
        this.maxStalenessMS = null;
        this.hedgeOptions = null;
    }

    TaggableReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit, @Nullable ReadPreferenceHedgeOptions hedgeOptions) {
        this.tagSetList = new ArrayList();
        Assertions.notNull("tagSetList", tagSetList);
        Assertions.isTrueArgument("maxStaleness is null or >= 0", maxStaleness == null || maxStaleness.longValue() >= 0);
        this.maxStalenessMS = maxStaleness == null ? null : Long.valueOf(TimeUnit.MILLISECONDS.convert(maxStaleness.longValue(), timeUnit));
        this.tagSetList.addAll(tagSetList);
        this.hedgeOptions = hedgeOptions;
    }

    @Override // com.mongodb.ReadPreference
    public boolean isSlaveOk() {
        return true;
    }

    @Override // com.mongodb.ReadPreference
    public BsonDocument toDocument() {
        BsonDocument readPrefObject = new BsonDocument("mode", new BsonString(getName()));
        if (!this.tagSetList.isEmpty()) {
            readPrefObject.put("tags", (BsonValue) tagsListToBsonArray());
        }
        if (this.maxStalenessMS != null) {
            readPrefObject.put("maxStalenessSeconds", (BsonValue) new BsonInt64(TimeUnit.MILLISECONDS.toSeconds(this.maxStalenessMS.longValue())));
        }
        if (this.hedgeOptions != null) {
            readPrefObject.put("hedge", (BsonValue) this.hedgeOptions.toBsonDocument());
        }
        return readPrefObject;
    }

    public List<TagSet> getTagSetList() {
        return Collections.unmodifiableList(this.tagSetList);
    }

    @Nullable
    public Long getMaxStaleness(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        if (this.maxStalenessMS == null) {
            return null;
        }
        return Long.valueOf(timeUnit.convert(this.maxStalenessMS.longValue(), TimeUnit.MILLISECONDS));
    }

    @Nullable
    public ReadPreferenceHedgeOptions getHedgeOptions() {
        return this.hedgeOptions;
    }

    public String toString() {
        return "ReadPreference{name=" + getName() + (this.tagSetList.isEmpty() ? "" : ", tagSetList=" + this.tagSetList) + (this.maxStalenessMS == null ? "" : ", maxStalenessMS=" + this.maxStalenessMS) + ", hedgeOptions=" + this.hedgeOptions + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaggableReadPreference that = (TaggableReadPreference) o;
        if (this.maxStalenessMS != null) {
            if (!this.maxStalenessMS.equals(that.maxStalenessMS)) {
                return false;
            }
        } else if (that.maxStalenessMS != null) {
            return false;
        }
        if (!this.tagSetList.equals(that.tagSetList)) {
            return false;
        }
        if (this.hedgeOptions != null) {
            if (!this.hedgeOptions.equals(that.hedgeOptions)) {
                return false;
            }
            return true;
        } else if (that.hedgeOptions != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * this.tagSetList.hashCode()) + getName().hashCode())) + (this.maxStalenessMS != null ? this.maxStalenessMS.hashCode() : 0))) + (this.hedgeOptions != null ? this.hedgeOptions.hashCode() : 0);
    }

    @Override // com.mongodb.ReadPreference
    protected List<ServerDescription> chooseForNonReplicaSet(ClusterDescription clusterDescription) {
        return selectFreshServers(clusterDescription, ClusterDescriptionHelper.getAny(clusterDescription));
    }

    protected static ClusterDescription copyClusterDescription(ClusterDescription clusterDescription, List<ServerDescription> selectedServers) {
        return new ClusterDescription(clusterDescription.getConnectionMode(), clusterDescription.getType(), selectedServers, clusterDescription.getClusterSettings(), clusterDescription.getServerSettings());
    }

    protected List<ServerDescription> selectFreshServers(ClusterDescription clusterDescription, List<ServerDescription> servers) {
        Long maxStaleness = getMaxStaleness(TimeUnit.MILLISECONDS);
        if (maxStaleness == null) {
            return servers;
        }
        if (clusterDescription.getServerSettings() == null) {
            throw new MongoConfigurationException("heartbeat frequency must be provided in cluster description");
        } else if (!serversAreAllThreeDotFour(clusterDescription)) {
            throw new MongoConfigurationException("Servers must all be at least version 3.4 when max staleness is configured");
        } else if (clusterDescription.getType() != ClusterType.REPLICA_SET) {
            return servers;
        } else {
            long heartbeatFrequencyMS = clusterDescription.getServerSettings().getHeartbeatFrequency(TimeUnit.MILLISECONDS);
            if (maxStaleness.longValue() >= Math.max(90000L, heartbeatFrequencyMS + AbstractComponentTracker.LINGERING_TIMEOUT)) {
                List<ServerDescription> freshServers = new ArrayList<>(servers.size());
                ServerDescription primary = findPrimary(clusterDescription);
                if (primary != null) {
                    for (ServerDescription cur : servers) {
                        if (cur.isPrimary()) {
                            freshServers.add(cur);
                        } else if (getStalenessOfSecondaryRelativeToPrimary(primary, cur, heartbeatFrequencyMS) <= maxStaleness.longValue()) {
                            freshServers.add(cur);
                        }
                    }
                } else {
                    ServerDescription mostUpToDateSecondary = findMostUpToDateSecondary(clusterDescription);
                    if (mostUpToDateSecondary != null) {
                        for (ServerDescription cur2 : servers) {
                            if ((getLastWriteDateNonNull(mostUpToDateSecondary).getTime() - getLastWriteDateNonNull(cur2).getTime()) + heartbeatFrequencyMS <= maxStaleness.longValue()) {
                                freshServers.add(cur2);
                            }
                        }
                    }
                }
                return freshServers;
            } else if (90000 > heartbeatFrequencyMS + AbstractComponentTracker.LINGERING_TIMEOUT) {
                throw new MongoConfigurationException(String.format("Max staleness (%d sec) must be at least 90 seconds", getMaxStaleness(TimeUnit.SECONDS)));
            } else {
                throw new MongoConfigurationException(String.format("Max staleness (%d ms) must be at least the heartbeat period (%d ms) plus the idle write period (%d ms)", maxStaleness, Long.valueOf(heartbeatFrequencyMS), 10000));
            }
        }
    }

    private long getStalenessOfSecondaryRelativeToPrimary(ServerDescription primary, ServerDescription serverDescription, long heartbeatFrequencyMS) {
        return ((getLastWriteDateNonNull(primary).getTime() + (serverDescription.getLastUpdateTime(TimeUnit.MILLISECONDS) - primary.getLastUpdateTime(TimeUnit.MILLISECONDS))) - getLastWriteDateNonNull(serverDescription).getTime()) + heartbeatFrequencyMS;
    }

    @Nullable
    private ServerDescription findPrimary(ClusterDescription clusterDescription) {
        for (ServerDescription cur : clusterDescription.getServerDescriptions()) {
            if (cur.isPrimary()) {
                return cur;
            }
        }
        return null;
    }

    private ServerDescription findMostUpToDateSecondary(ClusterDescription clusterDescription) {
        ServerDescription mostUpdateToDateSecondary = null;
        for (ServerDescription cur : clusterDescription.getServerDescriptions()) {
            if (cur.isSecondary() && (mostUpdateToDateSecondary == null || getLastWriteDateNonNull(cur).getTime() > getLastWriteDateNonNull(mostUpdateToDateSecondary).getTime())) {
                mostUpdateToDateSecondary = cur;
            }
        }
        return mostUpdateToDateSecondary;
    }

    private Date getLastWriteDateNonNull(ServerDescription serverDescription) {
        Date lastWriteDate = serverDescription.getLastWriteDate();
        if (lastWriteDate != null) {
            return lastWriteDate;
        }
        throw new MongoClientException("lastWriteDate should not be null in " + serverDescription);
    }

    private boolean serversAreAllThreeDotFour(ClusterDescription clusterDescription) {
        for (ServerDescription cur : clusterDescription.getServerDescriptions()) {
            if (cur.isOk() && cur.getMaxWireVersion() < 5) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/TaggableReadPreference$SecondaryReadPreference.class */
    public static class SecondaryReadPreference extends TaggableReadPreference {
        /* access modifiers changed from: package-private */
        public SecondaryReadPreference() {
        }

        /* access modifiers changed from: package-private */
        public SecondaryReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit) {
            this(tagSetList, maxStaleness, timeUnit, null);
        }

        SecondaryReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit, @Nullable ReadPreferenceHedgeOptions hedgeOptions) {
            super(tagSetList, maxStaleness, timeUnit, hedgeOptions);
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSet(TagSet tagSet) {
            return withTagSetList(Collections.singletonList(tagSet));
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSetList(List<TagSet> tagSetList) {
            Assertions.notNull("tagSetList", tagSetList);
            return new SecondaryReadPreference(tagSetList, getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withMaxStalenessMS(@Nullable Long maxStaleness, TimeUnit timeUnit) {
            Assertions.isTrueArgument("maxStaleness is null or >= 0", maxStaleness == null || maxStaleness.longValue() >= 0);
            return new SecondaryReadPreference(getTagSetList(), maxStaleness, timeUnit, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withHedgeOptions(ReadPreferenceHedgeOptions hedgeOptions) {
            return new SecondaryReadPreference(getTagSetList(), getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, hedgeOptions);
        }

        @Override // com.mongodb.ReadPreference
        public String getName() {
            return "secondary";
        }

        @Override // com.mongodb.ReadPreference
        protected List<ServerDescription> chooseForReplicaSet(ClusterDescription clusterDescription) {
            List<ServerDescription> selectedServers = selectFreshServers(clusterDescription, ClusterDescriptionHelper.getSecondaries(clusterDescription));
            if (!getTagSetList().isEmpty()) {
                ClusterDescription nonStaleClusterDescription = copyClusterDescription(clusterDescription, selectedServers);
                selectedServers = Collections.emptyList();
                Iterator<TagSet> it = getTagSetList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    List<ServerDescription> servers = ClusterDescriptionHelper.getSecondaries(nonStaleClusterDescription, it.next());
                    if (!servers.isEmpty()) {
                        selectedServers = servers;
                        break;
                    }
                }
            }
            return selectedServers;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/TaggableReadPreference$SecondaryPreferredReadPreference.class */
    public static class SecondaryPreferredReadPreference extends SecondaryReadPreference {
        /* access modifiers changed from: package-private */
        public SecondaryPreferredReadPreference() {
        }

        /* access modifiers changed from: package-private */
        public SecondaryPreferredReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit) {
            this(tagSetList, maxStaleness, timeUnit, null);
        }

        SecondaryPreferredReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit, @Nullable ReadPreferenceHedgeOptions hedgeOptions) {
            super(tagSetList, maxStaleness, timeUnit, hedgeOptions);
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSet(TagSet tagSet) {
            return withTagSetList(Collections.singletonList(tagSet));
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSetList(List<TagSet> tagSetList) {
            Assertions.notNull("tagSetList", tagSetList);
            return new SecondaryPreferredReadPreference(tagSetList, getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withMaxStalenessMS(@Nullable Long maxStaleness, TimeUnit timeUnit) {
            Assertions.isTrueArgument("maxStaleness is null or >= 0", maxStaleness == null || maxStaleness.longValue() >= 0);
            return new SecondaryPreferredReadPreference(getTagSetList(), maxStaleness, timeUnit, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withHedgeOptions(ReadPreferenceHedgeOptions hedgeOptions) {
            return new SecondaryPreferredReadPreference(getTagSetList(), getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, hedgeOptions);
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.ReadPreference
        public String getName() {
            return "secondaryPreferred";
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.ReadPreference
        protected List<ServerDescription> chooseForReplicaSet(ClusterDescription clusterDescription) {
            List<ServerDescription> selectedServers = chooseForReplicaSet(clusterDescription);
            if (selectedServers.isEmpty()) {
                selectedServers = ClusterDescriptionHelper.getPrimaries(clusterDescription);
            }
            return selectedServers;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/TaggableReadPreference$NearestReadPreference.class */
    public static class NearestReadPreference extends TaggableReadPreference {
        /* access modifiers changed from: package-private */
        public NearestReadPreference() {
        }

        /* access modifiers changed from: package-private */
        public NearestReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit) {
            this(tagSetList, maxStaleness, timeUnit, null);
        }

        NearestReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit, @Nullable ReadPreferenceHedgeOptions hedgeOptions) {
            super(tagSetList, maxStaleness, timeUnit, hedgeOptions);
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSet(TagSet tagSet) {
            return withTagSetList(Collections.singletonList(tagSet));
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSetList(List<TagSet> tagSetList) {
            Assertions.notNull("tagSetList", tagSetList);
            return new NearestReadPreference(tagSetList, getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withMaxStalenessMS(@Nullable Long maxStaleness, TimeUnit timeUnit) {
            Assertions.isTrueArgument("maxStaleness is null or >= 0", maxStaleness == null || maxStaleness.longValue() >= 0);
            return new NearestReadPreference(getTagSetList(), maxStaleness, timeUnit, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withHedgeOptions(ReadPreferenceHedgeOptions hedgeOptions) {
            return new NearestReadPreference(getTagSetList(), getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, hedgeOptions);
        }

        @Override // com.mongodb.ReadPreference
        public String getName() {
            return "nearest";
        }

        @Override // com.mongodb.ReadPreference
        public List<ServerDescription> chooseForReplicaSet(ClusterDescription clusterDescription) {
            List<ServerDescription> selectedServers = selectFreshServers(clusterDescription, ClusterDescriptionHelper.getAnyPrimaryOrSecondary(clusterDescription));
            if (!getTagSetList().isEmpty()) {
                ClusterDescription nonStaleClusterDescription = copyClusterDescription(clusterDescription, selectedServers);
                selectedServers = Collections.emptyList();
                Iterator<TagSet> it = getTagSetList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    List<ServerDescription> servers = ClusterDescriptionHelper.getAnyPrimaryOrSecondary(nonStaleClusterDescription, it.next());
                    if (!servers.isEmpty()) {
                        selectedServers = servers;
                        break;
                    }
                }
            }
            return selectedServers;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/TaggableReadPreference$PrimaryPreferredReadPreference.class */
    public static class PrimaryPreferredReadPreference extends SecondaryReadPreference {
        /* access modifiers changed from: package-private */
        public PrimaryPreferredReadPreference() {
        }

        /* access modifiers changed from: package-private */
        public PrimaryPreferredReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit) {
            this(tagSetList, maxStaleness, timeUnit, null);
        }

        PrimaryPreferredReadPreference(List<TagSet> tagSetList, @Nullable Long maxStaleness, TimeUnit timeUnit, @Nullable ReadPreferenceHedgeOptions hedgeOptions) {
            super(tagSetList, maxStaleness, timeUnit, hedgeOptions);
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSet(TagSet tagSet) {
            return withTagSetList(Collections.singletonList(tagSet));
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withTagSetList(List<TagSet> tagSetList) {
            Assertions.notNull("tagSetList", tagSetList);
            return new PrimaryPreferredReadPreference(tagSetList, getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withMaxStalenessMS(@Nullable Long maxStaleness, TimeUnit timeUnit) {
            Assertions.isTrueArgument("maxStaleness is null or >= 0", maxStaleness == null || maxStaleness.longValue() >= 0);
            return new PrimaryPreferredReadPreference(getTagSetList(), maxStaleness, timeUnit, getHedgeOptions());
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.TaggableReadPreference, com.mongodb.ReadPreference
        public TaggableReadPreference withHedgeOptions(ReadPreferenceHedgeOptions hedgeOptions) {
            return new PrimaryPreferredReadPreference(getTagSetList(), getMaxStaleness(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, hedgeOptions);
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.ReadPreference
        public String getName() {
            return "primaryPreferred";
        }

        @Override // com.mongodb.TaggableReadPreference.SecondaryReadPreference, com.mongodb.ReadPreference
        protected List<ServerDescription> chooseForReplicaSet(ClusterDescription clusterDescription) {
            List<ServerDescription> selectedServers = selectFreshServers(clusterDescription, ClusterDescriptionHelper.getPrimaries(clusterDescription));
            if (selectedServers.isEmpty()) {
                selectedServers = chooseForReplicaSet(clusterDescription);
            }
            return selectedServers;
        }
    }

    private BsonArray tagsListToBsonArray() {
        BsonArray bsonArray = new BsonArray();
        for (TagSet tagSet : this.tagSetList) {
            bsonArray.add((BsonValue) toDocument(tagSet));
        }
        return bsonArray;
    }

    private BsonDocument toDocument(TagSet tagSet) {
        BsonDocument document = new BsonDocument();
        Iterator<Tag> it = tagSet.iterator();
        while (it.hasNext()) {
            Tag tag = it.next();
            document.put(tag.getName(), (BsonValue) new BsonString(tag.getValue()));
        }
        return document;
    }
}
