package com.mongodb;

import com.mongodb.MongoClientSettings;
import com.mongodb.annotations.Immutable;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerSettings;
import com.mongodb.connection.SocketSettings;
import com.mongodb.connection.SslSettings;
import com.mongodb.event.ClusterListener;
import com.mongodb.event.CommandListener;
import com.mongodb.event.ConnectionPoolListener;
import com.mongodb.event.ServerListener;
import com.mongodb.event.ServerMonitorListener;
import com.mongodb.lang.Nullable;
import com.mongodb.selector.CompositeServerSelector;
import com.mongodb.selector.ServerSelector;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import kcp.highway.Kcp;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistry;
import p001ch.qos.logback.classic.Level;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/MongoClientOptions.class */
public class MongoClientOptions {
    private final String applicationName;
    private final List<MongoCompressor> compressorList;
    private final ReadPreference readPreference;
    private final WriteConcern writeConcern;
    private final boolean retryWrites;
    private final boolean retryReads;
    private final ReadConcern readConcern;
    private final CodecRegistry codecRegistry;
    private final UuidRepresentation uuidRepresentation;
    private final ServerSelector serverSelector;
    private final int minConnectionsPerHost;
    private final int maxConnectionsPerHost;
    private final int serverSelectionTimeout;
    private final int maxWaitTime;
    private final int maxConnectionIdleTime;
    private final int maxConnectionLifeTime;
    private final int connectTimeout;
    private final int socketTimeout;
    private final boolean sslEnabled;
    private final boolean sslInvalidHostNameAllowed;
    private final SSLContext sslContext;
    private final int heartbeatFrequency;
    private final int minHeartbeatFrequency;
    private final int heartbeatConnectTimeout;
    private final int heartbeatSocketTimeout;
    private final int localThreshold;
    private final String requiredReplicaSetName;
    private final DBDecoderFactory dbDecoderFactory;
    private final DBEncoderFactory dbEncoderFactory;
    private final boolean cursorFinalizerEnabled;
    private final ConnectionPoolSettings connectionPoolSettings;
    private final SocketSettings socketSettings;
    private final ServerSettings serverSettings;
    private final SocketSettings heartbeatSocketSettings;
    private final SslSettings sslSettings;
    private final List<ClusterListener> clusterListeners;
    private final List<CommandListener> commandListeners;
    private final AutoEncryptionSettings autoEncryptionSettings;

    private MongoClientOptions(Builder builder) {
        this.applicationName = builder.applicationName;
        this.compressorList = builder.compressorList;
        this.minConnectionsPerHost = builder.minConnectionsPerHost;
        this.maxConnectionsPerHost = builder.maxConnectionsPerHost;
        this.serverSelectionTimeout = builder.serverSelectionTimeout;
        this.maxWaitTime = builder.maxWaitTime;
        this.maxConnectionIdleTime = builder.maxConnectionIdleTime;
        this.maxConnectionLifeTime = builder.maxConnectionLifeTime;
        this.connectTimeout = builder.connectTimeout;
        this.socketTimeout = builder.socketTimeout;
        this.readPreference = builder.readPreference;
        this.writeConcern = builder.writeConcern;
        this.retryWrites = builder.retryWrites;
        this.retryReads = builder.retryReads;
        this.readConcern = builder.readConcern;
        this.codecRegistry = builder.codecRegistry;
        this.uuidRepresentation = builder.uuidRepresentation;
        this.serverSelector = builder.serverSelector;
        this.sslEnabled = builder.sslEnabled;
        this.sslInvalidHostNameAllowed = builder.sslInvalidHostNameAllowed;
        this.sslContext = builder.sslContext;
        this.heartbeatFrequency = builder.heartbeatFrequency;
        this.minHeartbeatFrequency = builder.minHeartbeatFrequency;
        this.heartbeatConnectTimeout = builder.heartbeatConnectTimeout;
        this.heartbeatSocketTimeout = builder.heartbeatSocketTimeout;
        this.localThreshold = builder.localThreshold;
        this.requiredReplicaSetName = builder.requiredReplicaSetName;
        this.dbDecoderFactory = builder.dbDecoderFactory;
        this.dbEncoderFactory = builder.dbEncoderFactory;
        this.cursorFinalizerEnabled = builder.cursorFinalizerEnabled;
        this.clusterListeners = Collections.unmodifiableList(builder.clusterListeners);
        this.commandListeners = Collections.unmodifiableList(builder.commandListeners);
        this.autoEncryptionSettings = builder.autoEncryptionSettings;
        ConnectionPoolSettings.Builder connectionPoolSettingsBuilder = ConnectionPoolSettings.builder().minSize(getMinConnectionsPerHost()).maxSize(getConnectionsPerHost()).maxWaitTime((long) getMaxWaitTime(), TimeUnit.MILLISECONDS).maxConnectionIdleTime((long) getMaxConnectionIdleTime(), TimeUnit.MILLISECONDS).maxConnectionLifeTime((long) getMaxConnectionLifeTime(), TimeUnit.MILLISECONDS);
        for (ConnectionPoolListener connectionPoolListener : builder.connectionPoolListeners) {
            connectionPoolSettingsBuilder.addConnectionPoolListener(connectionPoolListener);
        }
        this.connectionPoolSettings = connectionPoolSettingsBuilder.build();
        this.socketSettings = SocketSettings.builder().connectTimeout(getConnectTimeout(), TimeUnit.MILLISECONDS).readTimeout(getSocketTimeout(), TimeUnit.MILLISECONDS).build();
        this.heartbeatSocketSettings = SocketSettings.builder().connectTimeout(getHeartbeatConnectTimeout(), TimeUnit.MILLISECONDS).readTimeout(getHeartbeatSocketTimeout(), TimeUnit.MILLISECONDS).build();
        ServerSettings.Builder serverSettingsBuilder = ServerSettings.builder().heartbeatFrequency((long) getHeartbeatFrequency(), TimeUnit.MILLISECONDS).minHeartbeatFrequency((long) getMinHeartbeatFrequency(), TimeUnit.MILLISECONDS);
        for (ServerListener serverListener : builder.serverListeners) {
            serverSettingsBuilder.addServerListener(serverListener);
        }
        for (ServerMonitorListener serverMonitorListener : builder.serverMonitorListeners) {
            serverSettingsBuilder.addServerMonitorListener(serverMonitorListener);
        }
        this.serverSettings = serverSettingsBuilder.build();
        this.sslSettings = SslSettings.builder().enabled(this.sslEnabled).invalidHostNameAllowed(this.sslInvalidHostNameAllowed).context(this.sslContext).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MongoClientOptions options) {
        return new Builder(options);
    }

    public static Builder builder(MongoClientSettings settings) {
        return new Builder(settings);
    }

    public MongoClientSettings asMongoClientSettings(@Nullable List<ServerAddress> hosts, @Nullable String srvHost, ClusterConnectionMode clusterConnectionMode, @Nullable MongoCredential credential) {
        MongoClientSettings.Builder mongoClientSettingsBuilder = MongoClientSettings.builder();
        Optional ofNullable = Optional.ofNullable(credential);
        Objects.requireNonNull(mongoClientSettingsBuilder);
        ofNullable.ifPresent(this::credential);
        Optional ofNullable2 = Optional.ofNullable(this.autoEncryptionSettings);
        Objects.requireNonNull(mongoClientSettingsBuilder);
        ofNullable2.ifPresent(this::autoEncryptionSettings);
        List<CommandListener> list = this.commandListeners;
        Objects.requireNonNull(mongoClientSettingsBuilder);
        list.forEach(this::addCommandListener);
        mongoClientSettingsBuilder.writeConcern(this.writeConcern).readConcern(this.readConcern).applicationName(this.applicationName).readPreference(this.readPreference).codecRegistry(this.codecRegistry).compressorList(this.compressorList).uuidRepresentation(this.uuidRepresentation).retryReads(this.retryReads).retryWrites(this.retryWrites).applyToServerSettings(builder -> {
            builder.applySettings(this.serverSettings);
        }).applyToConnectionPoolSettings(builder -> {
            builder.applySettings(this.connectionPoolSettings);
        }).applyToSocketSettings(builder -> {
            builder.applySettings(this.socketSettings);
        }).heartbeatConnectTimeoutMS(this.heartbeatConnectTimeout).heartbeatSocketTimeoutMS(this.heartbeatSocketTimeout).applyToSslSettings(builder -> {
            builder.applySettings(this.sslSettings);
        }).applyToClusterSettings(builder -> {
            hosts.mode(clusterConnectionMode);
            if (clusterConnectionMode != null) {
                hosts.srvHost(clusterConnectionMode);
            }
            if (srvHost != null) {
                hosts.hosts(srvHost);
            }
            hosts.serverSelectionTimeout((long) this.serverSelectionTimeout, TimeUnit.MILLISECONDS);
            hosts.localThreshold((long) getLocalThreshold(), TimeUnit.MILLISECONDS);
            List<ClusterListener> list2 = this.clusterListeners;
            Objects.requireNonNull(hosts);
            list2.forEach(this::addClusterListener);
            hosts.requiredReplicaSetName(this.requiredReplicaSetName);
            hosts.serverSelector(this.serverSelector);
        });
        return mongoClientSettingsBuilder.build();
    }

    @Nullable
    public String getApplicationName() {
        return this.applicationName;
    }

    public List<MongoCompressor> getCompressorList() {
        return this.compressorList;
    }

    public int getConnectionsPerHost() {
        return this.maxConnectionsPerHost;
    }

    public int getMinConnectionsPerHost() {
        return this.minConnectionsPerHost;
    }

    public int getServerSelectionTimeout() {
        return this.serverSelectionTimeout;
    }

    public int getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public int getMaxConnectionIdleTime() {
        return this.maxConnectionIdleTime;
    }

    public int getMaxConnectionLifeTime() {
        return this.maxConnectionLifeTime;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public int getHeartbeatFrequency() {
        return this.heartbeatFrequency;
    }

    public int getMinHeartbeatFrequency() {
        return this.minHeartbeatFrequency;
    }

    public int getHeartbeatConnectTimeout() {
        return this.heartbeatConnectTimeout;
    }

    public int getHeartbeatSocketTimeout() {
        return this.heartbeatSocketTimeout;
    }

    public int getLocalThreshold() {
        return this.localThreshold;
    }

    @Nullable
    public String getRequiredReplicaSetName() {
        return this.requiredReplicaSetName;
    }

    public boolean isSslEnabled() {
        return this.sslEnabled;
    }

    public boolean isSslInvalidHostNameAllowed() {
        return this.sslInvalidHostNameAllowed;
    }

    @Nullable
    public SSLContext getSslContext() {
        return this.sslContext;
    }

    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public boolean getRetryWrites() {
        return this.retryWrites;
    }

    public boolean getRetryReads() {
        return this.retryReads;
    }

    public ReadConcern getReadConcern() {
        return this.readConcern;
    }

    public CodecRegistry getCodecRegistry() {
        return this.codecRegistry;
    }

    public UuidRepresentation getUuidRepresentation() {
        return this.uuidRepresentation;
    }

    @Nullable
    public ServerSelector getServerSelector() {
        return this.serverSelector;
    }

    public List<ClusterListener> getClusterListeners() {
        return this.clusterListeners;
    }

    public List<CommandListener> getCommandListeners() {
        return this.commandListeners;
    }

    public List<ConnectionPoolListener> getConnectionPoolListeners() {
        return this.connectionPoolSettings.getConnectionPoolListeners();
    }

    public List<ServerListener> getServerListeners() {
        return this.serverSettings.getServerListeners();
    }

    public List<ServerMonitorListener> getServerMonitorListeners() {
        return this.serverSettings.getServerMonitorListeners();
    }

    public DBDecoderFactory getDbDecoderFactory() {
        return this.dbDecoderFactory;
    }

    public DBEncoderFactory getDbEncoderFactory() {
        return this.dbEncoderFactory;
    }

    public boolean isCursorFinalizerEnabled() {
        return this.cursorFinalizerEnabled;
    }

    @Nullable
    public AutoEncryptionSettings getAutoEncryptionSettings() {
        return this.autoEncryptionSettings;
    }

    ConnectionPoolSettings getConnectionPoolSettings() {
        return this.connectionPoolSettings;
    }

    SocketSettings getSocketSettings() {
        return this.socketSettings;
    }

    ServerSettings getServerSettings() {
        return this.serverSettings;
    }

    SocketSettings getHeartbeatSocketSettings() {
        return this.heartbeatSocketSettings;
    }

    SslSettings getSslSettings() {
        return this.sslSettings;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MongoClientOptions that = (MongoClientOptions) o;
        if (this.localThreshold != that.localThreshold || this.connectTimeout != that.connectTimeout || this.cursorFinalizerEnabled != that.cursorFinalizerEnabled || this.minHeartbeatFrequency != that.minHeartbeatFrequency || this.heartbeatConnectTimeout != that.heartbeatConnectTimeout || this.heartbeatFrequency != that.heartbeatFrequency || this.heartbeatSocketTimeout != that.heartbeatSocketTimeout || this.maxConnectionIdleTime != that.maxConnectionIdleTime || this.maxConnectionLifeTime != that.maxConnectionLifeTime || this.maxConnectionsPerHost != that.maxConnectionsPerHost || this.serverSelectionTimeout != that.serverSelectionTimeout || this.maxWaitTime != that.maxWaitTime || this.minConnectionsPerHost != that.minConnectionsPerHost || this.socketTimeout != that.socketTimeout || this.sslEnabled != that.sslEnabled || this.sslInvalidHostNameAllowed != that.sslInvalidHostNameAllowed) {
            return false;
        }
        if (this.sslContext != null) {
            if (!this.sslContext.equals(that.sslContext)) {
                return false;
            }
        } else if (that.sslContext != null) {
            return false;
        }
        if (this.dbDecoderFactory != null) {
            if (!this.dbDecoderFactory.equals(that.dbDecoderFactory)) {
                return false;
            }
        } else if (that.dbDecoderFactory != null) {
            return false;
        }
        if (this.dbEncoderFactory != null) {
            if (!this.dbEncoderFactory.equals(that.dbEncoderFactory)) {
                return false;
            }
        } else if (that.dbEncoderFactory != null) {
            return false;
        }
        if (this.applicationName != null) {
            if (!this.applicationName.equals(that.applicationName)) {
                return false;
            }
        } else if (that.applicationName != null) {
            return false;
        }
        if (!this.readPreference.equals(that.readPreference) || !this.writeConcern.equals(that.writeConcern) || this.retryWrites != that.retryWrites || this.retryReads != that.retryReads || !this.readConcern.equals(that.readConcern) || !this.codecRegistry.equals(that.codecRegistry) || !this.uuidRepresentation.equals(that.uuidRepresentation)) {
            return false;
        }
        if (this.serverSelector != null) {
            if (!this.serverSelector.equals(that.serverSelector)) {
                return false;
            }
        } else if (that.serverSelector != null) {
            return false;
        }
        if (!this.clusterListeners.equals(that.clusterListeners) || !this.commandListeners.equals(that.commandListeners)) {
            return false;
        }
        if (this.requiredReplicaSetName != null) {
            if (!this.requiredReplicaSetName.equals(that.requiredReplicaSetName)) {
                return false;
            }
        } else if (that.requiredReplicaSetName != null) {
            return false;
        }
        if (!this.compressorList.equals(that.compressorList)) {
            return false;
        }
        if (this.autoEncryptionSettings != null) {
            if (!this.autoEncryptionSettings.equals(that.autoEncryptionSettings)) {
                return false;
            }
            return true;
        } else if (that.autoEncryptionSettings != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * (this.applicationName != null ? this.applicationName.hashCode() : 0)) + this.readPreference.hashCode())) + this.writeConcern.hashCode())) + (this.retryWrites ? 1 : 0))) + (this.retryReads ? 1 : 0))) + (this.readConcern != null ? this.readConcern.hashCode() : 0))) + this.codecRegistry.hashCode())) + this.uuidRepresentation.hashCode())) + (this.serverSelector != null ? this.serverSelector.hashCode() : 0))) + this.clusterListeners.hashCode())) + this.commandListeners.hashCode())) + this.minConnectionsPerHost)) + this.maxConnectionsPerHost)) + this.serverSelectionTimeout)) + this.maxWaitTime)) + this.maxConnectionIdleTime)) + this.maxConnectionLifeTime)) + this.connectTimeout)) + this.socketTimeout)) + (this.sslEnabled ? 1 : 0))) + (this.sslInvalidHostNameAllowed ? 1 : 0))) + (this.sslContext != null ? this.sslContext.hashCode() : 0))) + this.heartbeatFrequency)) + this.minHeartbeatFrequency)) + this.heartbeatConnectTimeout)) + this.heartbeatSocketTimeout)) + this.localThreshold)) + (this.requiredReplicaSetName != null ? this.requiredReplicaSetName.hashCode() : 0))) + (this.dbDecoderFactory != null ? this.dbDecoderFactory.hashCode() : 0))) + (this.dbEncoderFactory != null ? this.dbEncoderFactory.hashCode() : 0))) + (this.cursorFinalizerEnabled ? 1 : 0))) + this.compressorList.hashCode())) + (this.autoEncryptionSettings != null ? this.autoEncryptionSettings.hashCode() : 0);
    }

    public String toString() {
        return "MongoClientOptions{, applicationName='" + this.applicationName + "', compressors='" + this.compressorList + "', readPreference=" + this.readPreference + ", writeConcern=" + this.writeConcern + ", retryWrites=" + this.retryWrites + ", retryReads=" + this.retryReads + ", readConcern=" + this.readConcern + ", codecRegistry=" + this.codecRegistry + ", uuidRepresentation=" + this.uuidRepresentation + ", serverSelector=" + this.serverSelector + ", clusterListeners=" + this.clusterListeners + ", commandListeners=" + this.commandListeners + ", minConnectionsPerHost=" + this.minConnectionsPerHost + ", maxConnectionsPerHost=" + this.maxConnectionsPerHost + ", serverSelectionTimeout=" + this.serverSelectionTimeout + ", maxWaitTime=" + this.maxWaitTime + ", maxConnectionIdleTime=" + this.maxConnectionIdleTime + ", maxConnectionLifeTime=" + this.maxConnectionLifeTime + ", connectTimeout=" + this.connectTimeout + ", socketTimeout=" + this.socketTimeout + ", sslEnabled=" + this.sslEnabled + ", sslInvalidHostNamesAllowed=" + this.sslInvalidHostNameAllowed + ", sslContext=" + this.sslContext + ", heartbeatFrequency=" + this.heartbeatFrequency + ", minHeartbeatFrequency=" + this.minHeartbeatFrequency + ", heartbeatConnectTimeout=" + this.heartbeatConnectTimeout + ", heartbeatSocketTimeout=" + this.heartbeatSocketTimeout + ", localThreshold=" + this.localThreshold + ", requiredReplicaSetName='" + this.requiredReplicaSetName + "', dbDecoderFactory=" + this.dbDecoderFactory + ", dbEncoderFactory=" + this.dbEncoderFactory + ", cursorFinalizerEnabled=" + this.cursorFinalizerEnabled + ", connectionPoolSettings=" + this.connectionPoolSettings + ", socketSettings=" + this.socketSettings + ", serverSettings=" + this.serverSettings + ", heartbeatSocketSettings=" + this.heartbeatSocketSettings + ", autoEncryptionSettings=" + this.autoEncryptionSettings + '}';
    }

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/MongoClientOptions$Builder.class */
    public static class Builder {
        private final List<ClusterListener> clusterListeners;
        private final List<CommandListener> commandListeners;
        private final List<ConnectionPoolListener> connectionPoolListeners;
        private final List<ServerListener> serverListeners;
        private final List<ServerMonitorListener> serverMonitorListeners;
        private String applicationName;
        private List<MongoCompressor> compressorList;
        private ReadPreference readPreference;
        private WriteConcern writeConcern;
        private boolean retryWrites;
        private boolean retryReads;
        private ReadConcern readConcern;
        private CodecRegistry codecRegistry;
        private UuidRepresentation uuidRepresentation;
        private ServerSelector serverSelector;
        private int minConnectionsPerHost;
        private int maxConnectionsPerHost;
        private int serverSelectionTimeout;
        private int maxWaitTime;
        private int maxConnectionIdleTime;
        private int maxConnectionLifeTime;
        private int connectTimeout;
        private int socketTimeout;
        private boolean sslEnabled;
        private boolean sslInvalidHostNameAllowed;
        private SSLContext sslContext;
        private int heartbeatFrequency;
        private int minHeartbeatFrequency;
        private int heartbeatConnectTimeout;
        private int heartbeatSocketTimeout;
        private int localThreshold;
        private String requiredReplicaSetName;
        private DBDecoderFactory dbDecoderFactory;
        private DBEncoderFactory dbEncoderFactory;
        private boolean cursorFinalizerEnabled;
        private AutoEncryptionSettings autoEncryptionSettings;

        public Builder() {
            this.clusterListeners = new ArrayList();
            this.commandListeners = new ArrayList();
            this.connectionPoolListeners = new ArrayList();
            this.serverListeners = new ArrayList();
            this.serverMonitorListeners = new ArrayList();
            this.compressorList = Collections.emptyList();
            this.readPreference = ReadPreference.primary();
            this.writeConcern = WriteConcern.ACKNOWLEDGED;
            this.retryWrites = true;
            this.retryReads = true;
            this.readConcern = ReadConcern.DEFAULT;
            this.codecRegistry = MongoClientSettings.getDefaultCodecRegistry();
            this.uuidRepresentation = UuidRepresentation.UNSPECIFIED;
            this.maxConnectionsPerHost = 100;
            this.serverSelectionTimeout = 30000;
            this.maxWaitTime = Kcp.IKCP_PROBE_LIMIT;
            this.connectTimeout = 10000;
            this.socketTimeout = 0;
            this.sslEnabled = false;
            this.sslInvalidHostNameAllowed = false;
            this.heartbeatFrequency = 10000;
            this.minHeartbeatFrequency = 500;
            this.heartbeatConnectTimeout = Level.INFO_INT;
            this.heartbeatSocketTimeout = Level.INFO_INT;
            this.localThreshold = 15;
            this.dbDecoderFactory = DefaultDBDecoder.FACTORY;
            this.dbEncoderFactory = DefaultDBEncoder.FACTORY;
            this.cursorFinalizerEnabled = true;
        }

        public Builder(MongoClientOptions options) {
            this.clusterListeners = new ArrayList();
            this.commandListeners = new ArrayList();
            this.connectionPoolListeners = new ArrayList();
            this.serverListeners = new ArrayList();
            this.serverMonitorListeners = new ArrayList();
            this.compressorList = Collections.emptyList();
            this.readPreference = ReadPreference.primary();
            this.writeConcern = WriteConcern.ACKNOWLEDGED;
            this.retryWrites = true;
            this.retryReads = true;
            this.readConcern = ReadConcern.DEFAULT;
            this.codecRegistry = MongoClientSettings.getDefaultCodecRegistry();
            this.uuidRepresentation = UuidRepresentation.UNSPECIFIED;
            this.maxConnectionsPerHost = 100;
            this.serverSelectionTimeout = 30000;
            this.maxWaitTime = Kcp.IKCP_PROBE_LIMIT;
            this.connectTimeout = 10000;
            this.socketTimeout = 0;
            this.sslEnabled = false;
            this.sslInvalidHostNameAllowed = false;
            this.heartbeatFrequency = 10000;
            this.minHeartbeatFrequency = 500;
            this.heartbeatConnectTimeout = Level.INFO_INT;
            this.heartbeatSocketTimeout = Level.INFO_INT;
            this.localThreshold = 15;
            this.dbDecoderFactory = DefaultDBDecoder.FACTORY;
            this.dbEncoderFactory = DefaultDBEncoder.FACTORY;
            this.cursorFinalizerEnabled = true;
            this.applicationName = options.getApplicationName();
            this.compressorList = options.getCompressorList();
            this.minConnectionsPerHost = options.getMinConnectionsPerHost();
            this.maxConnectionsPerHost = options.getConnectionsPerHost();
            this.serverSelectionTimeout = options.getServerSelectionTimeout();
            this.maxWaitTime = options.getMaxWaitTime();
            this.maxConnectionIdleTime = options.getMaxConnectionIdleTime();
            this.maxConnectionLifeTime = options.getMaxConnectionLifeTime();
            this.connectTimeout = options.getConnectTimeout();
            this.socketTimeout = options.getSocketTimeout();
            this.readPreference = options.getReadPreference();
            this.writeConcern = options.getWriteConcern();
            this.retryWrites = options.getRetryWrites();
            this.retryReads = options.getRetryReads();
            this.readConcern = options.getReadConcern();
            this.codecRegistry = options.getCodecRegistry();
            this.uuidRepresentation = options.getUuidRepresentation();
            this.serverSelector = options.getServerSelector();
            this.sslEnabled = options.isSslEnabled();
            this.sslInvalidHostNameAllowed = options.isSslInvalidHostNameAllowed();
            this.sslContext = options.getSslContext();
            this.heartbeatFrequency = options.getHeartbeatFrequency();
            this.minHeartbeatFrequency = options.getMinHeartbeatFrequency();
            this.heartbeatConnectTimeout = options.getHeartbeatConnectTimeout();
            this.heartbeatSocketTimeout = options.getHeartbeatSocketTimeout();
            this.localThreshold = options.getLocalThreshold();
            this.requiredReplicaSetName = options.getRequiredReplicaSetName();
            this.dbDecoderFactory = options.getDbDecoderFactory();
            this.dbEncoderFactory = options.getDbEncoderFactory();
            this.cursorFinalizerEnabled = options.isCursorFinalizerEnabled();
            this.clusterListeners.addAll(options.getClusterListeners());
            this.commandListeners.addAll(options.getCommandListeners());
            this.connectionPoolListeners.addAll(options.getConnectionPoolListeners());
            this.serverListeners.addAll(options.getServerListeners());
            this.serverMonitorListeners.addAll(options.getServerMonitorListeners());
            this.autoEncryptionSettings = options.getAutoEncryptionSettings();
        }

        Builder(MongoClientSettings settings) {
            this.clusterListeners = new ArrayList();
            this.commandListeners = new ArrayList();
            this.connectionPoolListeners = new ArrayList();
            this.serverListeners = new ArrayList();
            this.serverMonitorListeners = new ArrayList();
            this.compressorList = Collections.emptyList();
            this.readPreference = ReadPreference.primary();
            this.writeConcern = WriteConcern.ACKNOWLEDGED;
            this.retryWrites = true;
            this.retryReads = true;
            this.readConcern = ReadConcern.DEFAULT;
            this.codecRegistry = MongoClientSettings.getDefaultCodecRegistry();
            this.uuidRepresentation = UuidRepresentation.UNSPECIFIED;
            this.maxConnectionsPerHost = 100;
            this.serverSelectionTimeout = 30000;
            this.maxWaitTime = Kcp.IKCP_PROBE_LIMIT;
            this.connectTimeout = 10000;
            this.socketTimeout = 0;
            this.sslEnabled = false;
            this.sslInvalidHostNameAllowed = false;
            this.heartbeatFrequency = 10000;
            this.minHeartbeatFrequency = 500;
            this.heartbeatConnectTimeout = Level.INFO_INT;
            this.heartbeatSocketTimeout = Level.INFO_INT;
            this.localThreshold = 15;
            this.dbDecoderFactory = DefaultDBDecoder.FACTORY;
            this.dbEncoderFactory = DefaultDBEncoder.FACTORY;
            this.cursorFinalizerEnabled = true;
            this.applicationName = settings.getApplicationName();
            this.compressorList = settings.getCompressorList();
            this.minConnectionsPerHost = settings.getConnectionPoolSettings().getMinSize();
            this.maxConnectionsPerHost = settings.getConnectionPoolSettings().getMaxSize();
            this.serverSelectionTimeout = (int) settings.getClusterSettings().getServerSelectionTimeout(TimeUnit.MILLISECONDS);
            this.maxWaitTime = (int) settings.getConnectionPoolSettings().getMaxWaitTime(TimeUnit.MILLISECONDS);
            this.maxConnectionIdleTime = (int) settings.getConnectionPoolSettings().getMaxConnectionIdleTime(TimeUnit.MILLISECONDS);
            this.maxConnectionLifeTime = (int) settings.getConnectionPoolSettings().getMaxConnectionLifeTime(TimeUnit.MILLISECONDS);
            this.connectTimeout = settings.getSocketSettings().getConnectTimeout(TimeUnit.MILLISECONDS);
            this.socketTimeout = settings.getSocketSettings().getReadTimeout(TimeUnit.MILLISECONDS);
            this.readPreference = settings.getReadPreference();
            this.writeConcern = settings.getWriteConcern();
            this.retryWrites = settings.getRetryWrites();
            this.retryReads = settings.getRetryReads();
            this.readConcern = settings.getReadConcern();
            this.codecRegistry = settings.getCodecRegistry();
            this.uuidRepresentation = settings.getUuidRepresentation();
            ServerSelector serverSelector = settings.getClusterSettings().getServerSelector();
            this.serverSelector = serverSelector instanceof CompositeServerSelector ? ((CompositeServerSelector) serverSelector).getServerSelectors().get(0) : null;
            this.sslEnabled = settings.getSslSettings().isEnabled();
            this.sslInvalidHostNameAllowed = settings.getSslSettings().isInvalidHostNameAllowed();
            this.sslContext = settings.getSslSettings().getContext();
            this.heartbeatFrequency = (int) settings.getServerSettings().getHeartbeatFrequency(TimeUnit.MILLISECONDS);
            this.minHeartbeatFrequency = (int) settings.getServerSettings().getMinHeartbeatFrequency(TimeUnit.MILLISECONDS);
            this.heartbeatConnectTimeout = settings.getHeartbeatSocketSettings().getConnectTimeout(TimeUnit.MILLISECONDS);
            this.heartbeatSocketTimeout = settings.getHeartbeatSocketSettings().getReadTimeout(TimeUnit.MILLISECONDS);
            this.localThreshold = (int) settings.getClusterSettings().getLocalThreshold(TimeUnit.MILLISECONDS);
            this.requiredReplicaSetName = settings.getClusterSettings().getRequiredReplicaSetName();
            this.clusterListeners.addAll(settings.getClusterSettings().getClusterListeners());
            this.commandListeners.addAll(settings.getCommandListeners());
            this.connectionPoolListeners.addAll(settings.getConnectionPoolSettings().getConnectionPoolListeners());
            this.serverListeners.addAll(settings.getServerSettings().getServerListeners());
            this.serverMonitorListeners.addAll(settings.getServerSettings().getServerMonitorListeners());
            this.autoEncryptionSettings = settings.getAutoEncryptionSettings();
        }

        public Builder applicationName(@Nullable String applicationName) {
            if (applicationName != null) {
                Assertions.isTrueArgument("applicationName UTF-8 encoding length <= 128", applicationName.getBytes(StandardCharsets.UTF_8).length <= 128);
            }
            this.applicationName = applicationName;
            return this;
        }

        public Builder compressorList(List<MongoCompressor> compressorList) {
            Assertions.notNull("compressorList", compressorList);
            this.compressorList = Collections.unmodifiableList(new ArrayList(compressorList));
            return this;
        }

        public Builder minConnectionsPerHost(int minConnectionsPerHost) {
            Assertions.isTrueArgument("minConnectionsPerHost must be >= 0", minConnectionsPerHost >= 0);
            this.minConnectionsPerHost = minConnectionsPerHost;
            return this;
        }

        public Builder connectionsPerHost(int connectionsPerHost) {
            Assertions.isTrueArgument("connectionPerHost must be > 0", connectionsPerHost > 0);
            this.maxConnectionsPerHost = connectionsPerHost;
            return this;
        }

        public Builder serverSelectionTimeout(int serverSelectionTimeout) {
            this.serverSelectionTimeout = serverSelectionTimeout;
            return this;
        }

        public Builder maxWaitTime(int maxWaitTime) {
            this.maxWaitTime = maxWaitTime;
            return this;
        }

        public Builder maxConnectionIdleTime(int maxConnectionIdleTime) {
            this.maxConnectionIdleTime = maxConnectionIdleTime;
            return this;
        }

        public Builder maxConnectionLifeTime(int maxConnectionLifeTime) {
            this.maxConnectionLifeTime = maxConnectionLifeTime;
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {
            Assertions.isTrueArgument("connectTimeout must be >= 0", connectTimeout >= 0);
            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder socketTimeout(int socketTimeout) {
            this.socketTimeout = socketTimeout;
            return this;
        }

        public Builder sslEnabled(boolean sslEnabled) {
            this.sslEnabled = sslEnabled;
            return this;
        }

        public Builder sslInvalidHostNameAllowed(boolean sslInvalidHostNameAllowed) {
            this.sslInvalidHostNameAllowed = sslInvalidHostNameAllowed;
            return this;
        }

        public Builder sslContext(SSLContext sslContext) {
            this.sslContext = sslContext;
            return this;
        }

        public Builder readPreference(ReadPreference readPreference) {
            this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
            return this;
        }

        public Builder writeConcern(WriteConcern writeConcern) {
            this.writeConcern = (WriteConcern) Assertions.notNull("writeConcern", writeConcern);
            return this;
        }

        public Builder retryWrites(boolean retryWrites) {
            this.retryWrites = retryWrites;
            return this;
        }

        public Builder retryReads(boolean retryReads) {
            this.retryReads = retryReads;
            return this;
        }

        public Builder readConcern(ReadConcern readConcern) {
            this.readConcern = (ReadConcern) Assertions.notNull("readConcern", readConcern);
            return this;
        }

        public Builder codecRegistry(CodecRegistry codecRegistry) {
            this.codecRegistry = (CodecRegistry) Assertions.notNull("codecRegistry", codecRegistry);
            return this;
        }

        public Builder uuidRepresentation(UuidRepresentation uuidRepresentation) {
            this.uuidRepresentation = (UuidRepresentation) Assertions.notNull("uuidRepresentation", uuidRepresentation);
            return this;
        }

        public Builder serverSelector(ServerSelector serverSelector) {
            this.serverSelector = serverSelector;
            return this;
        }

        public Builder addCommandListener(CommandListener commandListener) {
            this.commandListeners.add((CommandListener) Assertions.notNull("commandListener", commandListener));
            return this;
        }

        public Builder addConnectionPoolListener(ConnectionPoolListener connectionPoolListener) {
            this.connectionPoolListeners.add((ConnectionPoolListener) Assertions.notNull("connectionPoolListener", connectionPoolListener));
            return this;
        }

        public Builder addClusterListener(ClusterListener clusterListener) {
            this.clusterListeners.add((ClusterListener) Assertions.notNull("clusterListener", clusterListener));
            return this;
        }

        public Builder addServerListener(ServerListener serverListener) {
            this.serverListeners.add((ServerListener) Assertions.notNull("serverListener", serverListener));
            return this;
        }

        public Builder addServerMonitorListener(ServerMonitorListener serverMonitorListener) {
            this.serverMonitorListeners.add((ServerMonitorListener) Assertions.notNull("serverMonitorListener", serverMonitorListener));
            return this;
        }

        public Builder cursorFinalizerEnabled(boolean cursorFinalizerEnabled) {
            this.cursorFinalizerEnabled = cursorFinalizerEnabled;
            return this;
        }

        public Builder dbDecoderFactory(DBDecoderFactory dbDecoderFactory) {
            if (dbDecoderFactory == null) {
                throw new IllegalArgumentException("null is not a legal value");
            }
            this.dbDecoderFactory = dbDecoderFactory;
            return this;
        }

        public Builder dbEncoderFactory(DBEncoderFactory dbEncoderFactory) {
            if (dbEncoderFactory == null) {
                throw new IllegalArgumentException("null is not a legal value");
            }
            this.dbEncoderFactory = dbEncoderFactory;
            return this;
        }

        public Builder heartbeatFrequency(int heartbeatFrequency) {
            Assertions.isTrueArgument("heartbeatFrequency must be > 0", heartbeatFrequency > 0);
            this.heartbeatFrequency = heartbeatFrequency;
            return this;
        }

        public Builder minHeartbeatFrequency(int minHeartbeatFrequency) {
            Assertions.isTrueArgument("minHeartbeatFrequency must be > 0", minHeartbeatFrequency > 0);
            this.minHeartbeatFrequency = minHeartbeatFrequency;
            return this;
        }

        public Builder heartbeatConnectTimeout(int connectTimeout) {
            this.heartbeatConnectTimeout = connectTimeout;
            return this;
        }

        public Builder heartbeatSocketTimeout(int socketTimeout) {
            this.heartbeatSocketTimeout = socketTimeout;
            return this;
        }

        public Builder localThreshold(int localThreshold) {
            Assertions.isTrueArgument("localThreshold must be >= 0", localThreshold >= 0);
            this.localThreshold = localThreshold;
            return this;
        }

        public Builder requiredReplicaSetName(String requiredReplicaSetName) {
            this.requiredReplicaSetName = requiredReplicaSetName;
            return this;
        }

        public Builder autoEncryptionSettings(AutoEncryptionSettings autoEncryptionSettings) {
            this.autoEncryptionSettings = autoEncryptionSettings;
            return this;
        }

        public MongoClientOptions build() {
            return new MongoClientOptions(this);
        }
    }
}
