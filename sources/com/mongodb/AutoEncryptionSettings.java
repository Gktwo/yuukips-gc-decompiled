package com.mongodb;

import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.Map;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/AutoEncryptionSettings.class */
public final class AutoEncryptionSettings {
    private final MongoClientSettings keyVaultMongoClientSettings;
    private final String keyVaultNamespace;
    private final Map<String, Map<String, Object>> kmsProviders;
    private final Map<String, BsonDocument> schemaMap;
    private final Map<String, Object> extraOptions;
    private final boolean bypassAutoEncryption;

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/AutoEncryptionSettings$Builder.class */
    public static final class Builder {
        private MongoClientSettings keyVaultMongoClientSettings;
        private String keyVaultNamespace;
        private Map<String, Map<String, Object>> kmsProviders;
        private Map<String, BsonDocument> schemaMap;
        private Map<String, Object> extraOptions;
        private boolean bypassAutoEncryption;

        public Builder keyVaultMongoClientSettings(MongoClientSettings keyVaultMongoClientSettings) {
            this.keyVaultMongoClientSettings = keyVaultMongoClientSettings;
            return this;
        }

        public Builder keyVaultNamespace(String keyVaultNamespace) {
            this.keyVaultNamespace = (String) Assertions.notNull("keyVaultNamespace", keyVaultNamespace);
            return this;
        }

        public Builder kmsProviders(Map<String, Map<String, Object>> kmsProviders) {
            this.kmsProviders = (Map) Assertions.notNull("kmsProviders", kmsProviders);
            return this;
        }

        public Builder schemaMap(Map<String, BsonDocument> schemaMap) {
            this.schemaMap = (Map) Assertions.notNull("schemaMap", schemaMap);
            return this;
        }

        public Builder extraOptions(Map<String, Object> extraOptions) {
            this.extraOptions = (Map) Assertions.notNull("extraOptions", extraOptions);
            return this;
        }

        public Builder bypassAutoEncryption(boolean bypassAutoEncryption) {
            this.bypassAutoEncryption = bypassAutoEncryption;
            return this;
        }

        public AutoEncryptionSettings build() {
            return new AutoEncryptionSettings(this);
        }

        private Builder() {
            this.schemaMap = Collections.emptyMap();
            this.extraOptions = Collections.emptyMap();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Nullable
    public MongoClientSettings getKeyVaultMongoClientSettings() {
        return this.keyVaultMongoClientSettings;
    }

    public String getKeyVaultNamespace() {
        return this.keyVaultNamespace;
    }

    public Map<String, Map<String, Object>> getKmsProviders() {
        return this.kmsProviders;
    }

    public Map<String, BsonDocument> getSchemaMap() {
        return this.schemaMap;
    }

    public Map<String, Object> getExtraOptions() {
        return this.extraOptions;
    }

    public boolean isBypassAutoEncryption() {
        return this.bypassAutoEncryption;
    }

    private AutoEncryptionSettings(Builder builder) {
        this.keyVaultMongoClientSettings = builder.keyVaultMongoClientSettings;
        this.keyVaultNamespace = (String) Assertions.notNull("keyVaultNamespace", builder.keyVaultNamespace);
        this.kmsProviders = (Map) Assertions.notNull("kmsProviders", builder.kmsProviders);
        this.schemaMap = (Map) Assertions.notNull("schemaMap", builder.schemaMap);
        this.extraOptions = (Map) Assertions.notNull("extraOptions", builder.extraOptions);
        this.bypassAutoEncryption = builder.bypassAutoEncryption;
    }
}
