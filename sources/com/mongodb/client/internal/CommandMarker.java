package com.mongodb.client.internal;

import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.internal.capi.MongoCryptHelper;
import java.io.Closeable;
import java.util.Map;
import org.bson.RawBsonDocument;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/CommandMarker.class */
public class CommandMarker implements Closeable {
    private MongoClient client;
    private final ProcessBuilder processBuilder;

    /* access modifiers changed from: package-private */
    public CommandMarker(boolean isBypassAutoEncryption, Map<String, Object> options) {
        if (isBypassAutoEncryption) {
            this.processBuilder = null;
            this.client = null;
            return;
        }
        if (!options.containsKey("mongocryptdBypassSpawn") || !((Boolean) options.get("mongocryptdBypassSpawn")).booleanValue()) {
            this.processBuilder = MongoCryptHelper.createProcessBuilder(options);
            MongoCryptHelper.startProcess(this.processBuilder);
        } else {
            this.processBuilder = null;
        }
        this.client = MongoClients.create(MongoCryptHelper.createMongocryptdClientSettings((String) options.get("mongocryptdURI")));
    }

    /* access modifiers changed from: package-private */
    public RawBsonDocument mark(String databaseName, RawBsonDocument command) {
        if (this.client == null) {
            return command;
        }
        try {
            try {
                return executeCommand(databaseName, command);
            } catch (MongoTimeoutException e) {
                if (this.processBuilder == null) {
                    throw e;
                }
                MongoCryptHelper.startProcess(this.processBuilder);
                return executeCommand(databaseName, command);
            }
        } catch (MongoException e2) {
            throw wrapInClientException(e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.client != null) {
            this.client.close();
        }
    }

    private RawBsonDocument executeCommand(String databaseName, RawBsonDocument markableCommand) {
        return (RawBsonDocument) this.client.getDatabase(databaseName).withReadConcern(ReadConcern.DEFAULT).withReadPreference(ReadPreference.primary()).runCommand(markableCommand, RawBsonDocument.class);
    }

    private MongoClientException wrapInClientException(MongoException e) {
        return new MongoClientException("Exception in encryption library: " + e.getMessage(), e);
    }
}
