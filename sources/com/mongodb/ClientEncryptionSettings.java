package com.mongodb;

import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import java.util.Map;

/* loaded from: grasscutter.jar:com/mongodb/ClientEncryptionSettings.class */
public final class ClientEncryptionSettings {
    private final MongoClientSettings keyVaultMongoClientSettings;
    private final String keyVaultNamespace;
    private final Map<String, Map<String, Object>> kmsProviders;

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/ClientEncryptionSettings$Builder.class */
    public static final class Builder {
        private MongoClientSettings keyVaultMongoClientSettings;
        private String keyVaultNamespace;
        private Map<String, Map<String, Object>> kmsProviders;

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

        public ClientEncryptionSettings build() {
            return new ClientEncryptionSettings(this);
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public MongoClientSettings getKeyVaultMongoClientSettings() {
        return this.keyVaultMongoClientSettings;
    }

    public String getKeyVaultNamespace() {
        return this.keyVaultNamespace;
    }

    public Map<String, Map<String, Object>> getKmsProviders() {
        return this.kmsProviders;
    }

    private ClientEncryptionSettings(Builder builder) {
        this.keyVaultMongoClientSettings = builder.keyVaultMongoClientSettings;
        this.keyVaultNamespace = (String) Assertions.notNull("keyVaultNamespace", builder.keyVaultNamespace);
        this.kmsProviders = (Map) Assertions.notNull("kmsProviders", builder.kmsProviders);
    }
}
