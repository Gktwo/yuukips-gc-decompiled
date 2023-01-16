package com.mongodb;

import com.mongodb.MongoClientOptions;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.List;
import org.bson.UuidRepresentation;

/* loaded from: grasscutter.jar:com/mongodb/MongoClientURI.class */
public class MongoClientURI {
    private final ConnectionString proxied;
    private final MongoClientOptions.Builder builder;

    public MongoClientURI(String uri) {
        this(uri, new MongoClientOptions.Builder());
    }

    public MongoClientURI(String uri, MongoClientOptions.Builder builder) {
        this.builder = (MongoClientOptions.Builder) Assertions.notNull("builder", builder);
        this.proxied = new ConnectionString(uri);
    }

    /* access modifiers changed from: package-private */
    public ConnectionString getProxied() {
        return this.proxied;
    }

    @Nullable
    public String getUsername() {
        return this.proxied.getUsername();
    }

    @Nullable
    public char[] getPassword() {
        return this.proxied.getPassword();
    }

    public List<String> getHosts() {
        return this.proxied.getHosts();
    }

    @Nullable
    public String getDatabase() {
        return this.proxied.getDatabase();
    }

    @Nullable
    public String getCollection() {
        return this.proxied.getCollection();
    }

    public String getURI() {
        return this.proxied.getConnectionString();
    }

    @Nullable
    public MongoCredential getCredentials() {
        return this.proxied.getCredential();
    }

    public MongoClientOptions getOptions() {
        ReadPreference readPreference = this.proxied.getReadPreference();
        if (readPreference != null) {
            this.builder.readPreference(readPreference);
        }
        ReadConcern readConcern = this.proxied.getReadConcern();
        if (readConcern != null) {
            this.builder.readConcern(readConcern);
        }
        WriteConcern writeConcern = this.proxied.getWriteConcern();
        if (writeConcern != null) {
            this.builder.writeConcern(writeConcern);
        }
        Boolean retryWritesValue = this.proxied.getRetryWritesValue();
        if (retryWritesValue != null) {
            this.builder.retryWrites(retryWritesValue.booleanValue());
        }
        Boolean retryReads = this.proxied.getRetryReads();
        if (retryReads != null) {
            this.builder.retryReads(retryReads.booleanValue());
        }
        Integer maxConnectionPoolSize = this.proxied.getMaxConnectionPoolSize();
        if (maxConnectionPoolSize != null) {
            this.builder.connectionsPerHost(maxConnectionPoolSize.intValue());
        }
        Integer integer = this.proxied.getMinConnectionPoolSize();
        if (integer != null) {
            this.builder.minConnectionsPerHost(integer.intValue());
        }
        Integer maxWaitTime = this.proxied.getMaxWaitTime();
        if (maxWaitTime != null) {
            this.builder.maxWaitTime(maxWaitTime.intValue());
        }
        Integer maxConnectionIdleTime = this.proxied.getMaxConnectionIdleTime();
        if (maxConnectionIdleTime != null) {
            this.builder.maxConnectionIdleTime(maxConnectionIdleTime.intValue());
        }
        Integer maxConnectionLifeTime = this.proxied.getMaxConnectionLifeTime();
        if (maxConnectionLifeTime != null) {
            this.builder.maxConnectionLifeTime(maxConnectionLifeTime.intValue());
        }
        Integer socketTimeout = this.proxied.getSocketTimeout();
        if (socketTimeout != null) {
            this.builder.socketTimeout(socketTimeout.intValue());
        }
        Integer connectTimeout = this.proxied.getConnectTimeout();
        if (connectTimeout != null) {
            this.builder.connectTimeout(connectTimeout.intValue());
        }
        String requiredReplicaSetName = this.proxied.getRequiredReplicaSetName();
        if (requiredReplicaSetName != null) {
            this.builder.requiredReplicaSetName(requiredReplicaSetName);
        }
        Boolean sslEnabled = this.proxied.getSslEnabled();
        if (sslEnabled != null) {
            this.builder.sslEnabled(sslEnabled.booleanValue());
        }
        Boolean sslInvalidHostnameAllowed = this.proxied.getSslInvalidHostnameAllowed();
        if (sslInvalidHostnameAllowed != null) {
            this.builder.sslInvalidHostNameAllowed(sslInvalidHostnameAllowed.booleanValue());
        }
        Integer serverSelectionTimeout = this.proxied.getServerSelectionTimeout();
        if (serverSelectionTimeout != null) {
            this.builder.serverSelectionTimeout(serverSelectionTimeout.intValue());
        }
        Integer localThreshold = this.proxied.getLocalThreshold();
        if (localThreshold != null) {
            this.builder.localThreshold(localThreshold.intValue());
        }
        Integer heartbeatFrequency = this.proxied.getHeartbeatFrequency();
        if (heartbeatFrequency != null) {
            this.builder.heartbeatFrequency(heartbeatFrequency.intValue());
        }
        String applicationName = this.proxied.getApplicationName();
        if (applicationName != null) {
            this.builder.applicationName(applicationName);
        }
        if (!this.proxied.getCompressorList().isEmpty()) {
            this.builder.compressorList(this.proxied.getCompressorList());
        }
        UuidRepresentation uuidRepresentation = this.proxied.getUuidRepresentation();
        if (uuidRepresentation != null) {
            this.builder.uuidRepresentation(uuidRepresentation);
        }
        return this.builder.build();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MongoClientURI that = (MongoClientURI) o;
        if (!getHosts().equals(that.getHosts())) {
            return false;
        }
        String database = getDatabase();
        if (database != null) {
            if (!database.equals(that.getDatabase())) {
                return false;
            }
        } else if (that.getDatabase() != null) {
            return false;
        }
        String collection = getCollection();
        if (collection != null) {
            if (!collection.equals(that.getCollection())) {
                return false;
            }
        } else if (that.getCollection() != null) {
            return false;
        }
        MongoCredential credentials = getCredentials();
        if (credentials != null) {
            if (!credentials.equals(that.getCredentials())) {
                return false;
            }
        } else if (that.getCredentials() != null) {
            return false;
        }
        if (!getOptions().equals(that.getOptions())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int result = (31 * getOptions().hashCode()) + getHosts().hashCode();
        MongoCredential credentials = getCredentials();
        int result2 = (31 * result) + (credentials != null ? credentials.hashCode() : 0);
        String database = getDatabase();
        int result3 = (31 * result2) + (database != null ? database.hashCode() : 0);
        String collection = getCollection();
        return (31 * result3) + (collection != null ? collection.hashCode() : 0);
    }

    public String toString() {
        return this.proxied.toString();
    }
}
