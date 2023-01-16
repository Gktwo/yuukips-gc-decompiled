package com.mongodb;

import com.mongodb.annotations.Immutable;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.gridfs.codecs.GridFSFileCodecProvider;
import com.mongodb.client.model.geojson.codecs.GeoJsonCodecProvider;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerSettings;
import com.mongodb.connection.SocketSettings;
import com.mongodb.connection.SslSettings;
import com.mongodb.connection.StreamFactoryFactory;
import com.mongodb.event.CommandListener;
import com.mongodb.lang.Nullable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.UuidRepresentation;
import org.bson.codecs.BsonCodecProvider;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.DocumentCodecProvider;
import org.bson.codecs.IterableCodecProvider;
import org.bson.codecs.JsonObjectCodecProvider;
import org.bson.codecs.MapCodecProvider;
import org.bson.codecs.ValueCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.jsr310.Jsr310CodecProvider;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/MongoClientSettings.class */
public final class MongoClientSettings {
    private static final CodecRegistry DEFAULT_CODEC_REGISTRY = CodecRegistries.fromProviders(Arrays.asList(new ValueCodecProvider(), new BsonValueCodecProvider(), new DBRefCodecProvider(), new DBObjectCodecProvider(), new DocumentCodecProvider(new DocumentToDBRefTransformer()), new IterableCodecProvider(new DocumentToDBRefTransformer()), new MapCodecProvider(new DocumentToDBRefTransformer()), new GeoJsonCodecProvider(), new GridFSFileCodecProvider(), new Jsr310CodecProvider(), new JsonObjectCodecProvider(), new BsonCodecProvider()));
    private final ReadPreference readPreference;
    private final WriteConcern writeConcern;
    private final boolean retryWrites;
    private final boolean retryReads;
    private final ReadConcern readConcern;
    private final MongoCredential credential;
    private final StreamFactoryFactory streamFactoryFactory;
    private final List<CommandListener> commandListeners;
    private final CodecRegistry codecRegistry;
    private final ClusterSettings clusterSettings;
    private final SocketSettings socketSettings;
    private final SocketSettings heartbeatSocketSettings;
    private final ConnectionPoolSettings connectionPoolSettings;
    private final ServerSettings serverSettings;
    private final SslSettings sslSettings;
    private final String applicationName;
    private final List<MongoCompressor> compressorList;
    private final UuidRepresentation uuidRepresentation;
    private final AutoEncryptionSettings autoEncryptionSettings;
    private final boolean heartbeatSocketTimeoutSetExplicitly;
    private final boolean heartbeatConnectTimeoutSetExplicitly;

    public static CodecRegistry getDefaultCodecRegistry() {
        return DEFAULT_CODEC_REGISTRY;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MongoClientSettings settings) {
        return new Builder();
    }

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/MongoClientSettings$Builder.class */
    public static final class Builder {
        private ReadPreference readPreference;
        private WriteConcern writeConcern;
        private boolean retryWrites;
        private boolean retryReads;
        private ReadConcern readConcern;
        private CodecRegistry codecRegistry;
        private StreamFactoryFactory streamFactoryFactory;
        private List<CommandListener> commandListeners;
        private final ClusterSettings.Builder clusterSettingsBuilder;
        private final SocketSettings.Builder socketSettingsBuilder;
        private final ConnectionPoolSettings.Builder connectionPoolSettingsBuilder;
        private final ServerSettings.Builder serverSettingsBuilder;
        private final SslSettings.Builder sslSettingsBuilder;
        private MongoCredential credential;
        private String applicationName;
        private List<MongoCompressor> compressorList;
        private UuidRepresentation uuidRepresentation;
        private AutoEncryptionSettings autoEncryptionSettings;
        private int heartbeatConnectTimeoutMS;
        private int heartbeatSocketTimeoutMS;

        private Builder() {
            this.readPreference = ReadPreference.primary();
            this.writeConcern = WriteConcern.ACKNOWLEDGED;
            this.retryWrites = true;
            this.retryReads = true;
            this.readConcern = ReadConcern.DEFAULT;
            this.codecRegistry = MongoClientSettings.getDefaultCodecRegistry();
            this.commandListeners = new ArrayList();
            this.clusterSettingsBuilder = ClusterSettings.builder();
            this.socketSettingsBuilder = SocketSettings.builder();
            this.connectionPoolSettingsBuilder = ConnectionPoolSettings.builder();
            this.serverSettingsBuilder = ServerSettings.builder();
            this.sslSettingsBuilder = SslSettings.builder();
            this.compressorList = Collections.emptyList();
            this.uuidRepresentation = UuidRepresentation.UNSPECIFIED;
        }

        private Builder(MongoClientSettings settings) {
            this.readPreference = ReadPreference.primary();
            this.writeConcern = WriteConcern.ACKNOWLEDGED;
            this.retryWrites = true;
            this.retryReads = true;
            this.readConcern = ReadConcern.DEFAULT;
            this.codecRegistry = MongoClientSettings.getDefaultCodecRegistry();
            this.commandListeners = new ArrayList();
            this.clusterSettingsBuilder = ClusterSettings.builder();
            this.socketSettingsBuilder = SocketSettings.builder();
            this.connectionPoolSettingsBuilder = ConnectionPoolSettings.builder();
            this.serverSettingsBuilder = ServerSettings.builder();
            this.sslSettingsBuilder = SslSettings.builder();
            this.compressorList = Collections.emptyList();
            this.uuidRepresentation = UuidRepresentation.UNSPECIFIED;
            Assertions.notNull("settings", settings);
            this.applicationName = settings.getApplicationName();
            this.commandListeners = new ArrayList(settings.getCommandListeners());
            this.compressorList = new ArrayList(settings.getCompressorList());
            this.codecRegistry = settings.getCodecRegistry();
            this.readPreference = settings.getReadPreference();
            this.writeConcern = settings.getWriteConcern();
            this.retryWrites = settings.getRetryWrites();
            this.retryReads = settings.getRetryReads();
            this.readConcern = settings.getReadConcern();
            this.credential = settings.getCredential();
            this.uuidRepresentation = settings.getUuidRepresentation();
            this.streamFactoryFactory = settings.getStreamFactoryFactory();
            this.autoEncryptionSettings = settings.getAutoEncryptionSettings();
            this.clusterSettingsBuilder.applySettings(settings.getClusterSettings());
            this.serverSettingsBuilder.applySettings(settings.getServerSettings());
            this.socketSettingsBuilder.applySettings(settings.getSocketSettings());
            this.connectionPoolSettingsBuilder.applySettings(settings.getConnectionPoolSettings());
            this.sslSettingsBuilder.applySettings(settings.getSslSettings());
            if (settings.heartbeatConnectTimeoutSetExplicitly) {
                this.heartbeatConnectTimeoutMS = settings.heartbeatSocketSettings.getConnectTimeout(TimeUnit.MILLISECONDS);
            }
            if (settings.heartbeatSocketTimeoutSetExplicitly) {
                this.heartbeatSocketTimeoutMS = settings.heartbeatSocketSettings.getReadTimeout(TimeUnit.MILLISECONDS);
            }
        }

        public Builder applyConnectionString(ConnectionString connectionString) {
            if (connectionString.getApplicationName() != null) {
                this.applicationName = connectionString.getApplicationName();
            }
            this.clusterSettingsBuilder.applyConnectionString(connectionString);
            if (!connectionString.getCompressorList().isEmpty()) {
                this.compressorList = connectionString.getCompressorList();
            }
            this.connectionPoolSettingsBuilder.applyConnectionString(connectionString);
            if (connectionString.getCredential() != null) {
                this.credential = connectionString.getCredential();
            }
            if (connectionString.getReadConcern() != null) {
                this.readConcern = connectionString.getReadConcern();
            }
            if (connectionString.getReadPreference() != null) {
                this.readPreference = connectionString.getReadPreference();
            }
            Boolean retryWritesValue = connectionString.getRetryWritesValue();
            if (retryWritesValue != null) {
                this.retryWrites = retryWritesValue.booleanValue();
            }
            if (connectionString.getUuidRepresentation() != null) {
                this.uuidRepresentation = connectionString.getUuidRepresentation();
            }
            this.serverSettingsBuilder.applyConnectionString(connectionString);
            this.socketSettingsBuilder.applyConnectionString(connectionString);
            this.sslSettingsBuilder.applyConnectionString(connectionString);
            if (connectionString.getWriteConcern() != null) {
                this.writeConcern = connectionString.getWriteConcern();
            }
            return this;
        }

        public Builder applyToClusterSettings(Block<ClusterSettings.Builder> block) {
            ((Block) Assertions.notNull("block", block)).apply(this.clusterSettingsBuilder);
            return this;
        }

        public Builder applyToSocketSettings(Block<SocketSettings.Builder> block) {
            ((Block) Assertions.notNull("block", block)).apply(this.socketSettingsBuilder);
            return this;
        }

        public Builder applyToConnectionPoolSettings(Block<ConnectionPoolSettings.Builder> block) {
            ((Block) Assertions.notNull("block", block)).apply(this.connectionPoolSettingsBuilder);
            return this;
        }

        public Builder applyToServerSettings(Block<ServerSettings.Builder> block) {
            ((Block) Assertions.notNull("block", block)).apply(this.serverSettingsBuilder);
            return this;
        }

        public Builder applyToSslSettings(Block<SslSettings.Builder> block) {
            ((Block) Assertions.notNull("block", block)).apply(this.sslSettingsBuilder);
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

        public Builder credential(MongoCredential credential) {
            this.credential = (MongoCredential) Assertions.notNull("credential", credential);
            return this;
        }

        public Builder codecRegistry(CodecRegistry codecRegistry) {
            this.codecRegistry = (CodecRegistry) Assertions.notNull("codecRegistry", codecRegistry);
            return this;
        }

        public Builder streamFactoryFactory(StreamFactoryFactory streamFactoryFactory) {
            this.streamFactoryFactory = (StreamFactoryFactory) Assertions.notNull("streamFactoryFactory", streamFactoryFactory);
            return this;
        }

        public Builder addCommandListener(CommandListener commandListener) {
            Assertions.notNull("commandListener", commandListener);
            this.commandListeners.add(commandListener);
            return this;
        }

        public Builder commandListenerList(List<CommandListener> commandListeners) {
            Assertions.notNull("commandListeners", commandListeners);
            this.commandListeners = new ArrayList(commandListeners);
            return this;
        }

        public Builder applicationName(@Nullable String applicationName) {
            if (applicationName != null) {
                Assertions.isTrueArgument("applicationName UTF-8 encoding length <= 128", applicationName.getBytes(Charset.forName("UTF-8")).length <= 128);
            }
            this.applicationName = applicationName;
            return this;
        }

        public Builder compressorList(List<MongoCompressor> compressorList) {
            Assertions.notNull("compressorList", compressorList);
            this.compressorList = new ArrayList(compressorList);
            return this;
        }

        public Builder uuidRepresentation(UuidRepresentation uuidRepresentation) {
            this.uuidRepresentation = (UuidRepresentation) Assertions.notNull("uuidRepresentation", uuidRepresentation);
            return this;
        }

        public Builder autoEncryptionSettings(@Nullable AutoEncryptionSettings autoEncryptionSettings) {
            this.autoEncryptionSettings = autoEncryptionSettings;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder heartbeatConnectTimeoutMS(int heartbeatConnectTimeoutMS) {
            this.heartbeatConnectTimeoutMS = heartbeatConnectTimeoutMS;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder heartbeatSocketTimeoutMS(int heartbeatSocketTimeoutMS) {
            this.heartbeatSocketTimeoutMS = heartbeatSocketTimeoutMS;
            return this;
        }

        public MongoClientSettings build() {
            return new MongoClientSettings(this);
        }
    }

    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Nullable
    public MongoCredential getCredential() {
        return this.credential;
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

    @Nullable
    public StreamFactoryFactory getStreamFactoryFactory() {
        return this.streamFactoryFactory;
    }

    public List<CommandListener> getCommandListeners() {
        return Collections.unmodifiableList(this.commandListeners);
    }

    @Nullable
    public String getApplicationName() {
        return this.applicationName;
    }

    public List<MongoCompressor> getCompressorList() {
        return Collections.unmodifiableList(this.compressorList);
    }

    public UuidRepresentation getUuidRepresentation() {
        return this.uuidRepresentation;
    }

    @Nullable
    public AutoEncryptionSettings getAutoEncryptionSettings() {
        return this.autoEncryptionSettings;
    }

    public ClusterSettings getClusterSettings() {
        return this.clusterSettings;
    }

    public SslSettings getSslSettings() {
        return this.sslSettings;
    }

    public SocketSettings getSocketSettings() {
        return this.socketSettings;
    }

    public SocketSettings getHeartbeatSocketSettings() {
        return this.heartbeatSocketSettings;
    }

    public ConnectionPoolSettings getConnectionPoolSettings() {
        return this.connectionPoolSettings;
    }

    public ServerSettings getServerSettings() {
        return this.serverSettings;
    }

    private MongoClientSettings(Builder builder) {
        int i;
        int i2;
        this.readPreference = builder.readPreference;
        this.writeConcern = builder.writeConcern;
        this.retryWrites = builder.retryWrites;
        this.retryReads = builder.retryReads;
        this.readConcern = builder.readConcern;
        this.credential = builder.credential;
        this.streamFactoryFactory = builder.streamFactoryFactory;
        this.codecRegistry = builder.codecRegistry;
        this.commandListeners = builder.commandListeners;
        this.applicationName = builder.applicationName;
        this.clusterSettings = builder.clusterSettingsBuilder.build();
        this.serverSettings = builder.serverSettingsBuilder.build();
        this.socketSettings = builder.socketSettingsBuilder.build();
        this.connectionPoolSettings = builder.connectionPoolSettingsBuilder.build();
        this.sslSettings = builder.sslSettingsBuilder.build();
        this.compressorList = builder.compressorList;
        this.uuidRepresentation = builder.uuidRepresentation;
        this.autoEncryptionSettings = builder.autoEncryptionSettings;
        SocketSettings.Builder builder2 = SocketSettings.builder();
        if (builder.heartbeatSocketTimeoutMS == 0) {
            i = this.socketSettings.getConnectTimeout(TimeUnit.MILLISECONDS);
        } else {
            i = builder.heartbeatSocketTimeoutMS;
        }
        SocketSettings.Builder readTimeout = builder2.readTimeout(i, TimeUnit.MILLISECONDS);
        if (builder.heartbeatConnectTimeoutMS == 0) {
            i2 = this.socketSettings.getConnectTimeout(TimeUnit.MILLISECONDS);
        } else {
            i2 = builder.heartbeatConnectTimeoutMS;
        }
        this.heartbeatSocketSettings = readTimeout.connectTimeout(i2, TimeUnit.MILLISECONDS).build();
        this.heartbeatSocketTimeoutSetExplicitly = builder.heartbeatSocketTimeoutMS != 0;
        this.heartbeatConnectTimeoutSetExplicitly = builder.heartbeatConnectTimeoutMS != 0;
    }
}
