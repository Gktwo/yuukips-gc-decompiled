package com.mongodb.internal.capi;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientException;
import com.mongodb.MongoClientSettings;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.SocketSettings;
import com.mongodb.crypt.capi.MongoCryptOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.codecs.DocumentCodec;

/* loaded from: grasscutter.jar:com/mongodb/internal/capi/MongoCryptHelper.class */
public final class MongoCryptHelper {
    public static MongoCryptOptions createMongoCryptOptions(Map<String, Map<String, Object>> kmsProviders, Map<String, BsonDocument> namespaceToLocalSchemaDocumentMap) {
        MongoCryptOptions.Builder mongoCryptOptionsBuilder = MongoCryptOptions.builder();
        BsonDocument bsonKmsProviders = new BsonDocument();
        for (Map.Entry<String, Map<String, Object>> entry : kmsProviders.entrySet()) {
            bsonKmsProviders.put(entry.getKey(), (BsonValue) new BsonDocumentWrapper(new Document(entry.getValue()), new DocumentCodec()));
        }
        mongoCryptOptionsBuilder.kmsProviderOptions(bsonKmsProviders);
        mongoCryptOptionsBuilder.localSchemaMap(namespaceToLocalSchemaDocumentMap);
        return mongoCryptOptionsBuilder.build();
    }

    public static List<String> createMongocryptdSpawnArgs(Map<String, Object> options) {
        String path;
        List<String> spawnArgs = new ArrayList<>();
        if (options.containsKey("mongocryptdSpawnPath")) {
            path = (String) options.get("mongocryptdSpawnPath");
        } else {
            path = "mongocryptd";
        }
        spawnArgs.add(path);
        if (options.containsKey("mongocryptdSpawnArgs")) {
            spawnArgs.addAll((List) options.get("mongocryptdSpawnArgs"));
        }
        if (!spawnArgs.contains("--idleShutdownTimeoutSecs")) {
            spawnArgs.add("--idleShutdownTimeoutSecs");
            spawnArgs.add("60");
        }
        return spawnArgs;
    }

    public static MongoClientSettings createMongocryptdClientSettings(String connectionString) {
        return MongoClientSettings.builder().applyToClusterSettings(new Block<ClusterSettings.Builder>() { // from class: com.mongodb.internal.capi.MongoCryptHelper.2
            public void apply(ClusterSettings.Builder builder) {
                builder.serverSelectionTimeout(1, TimeUnit.SECONDS);
            }
        }).applyToSocketSettings(new Block<SocketSettings.Builder>() { // from class: com.mongodb.internal.capi.MongoCryptHelper.1
            public void apply(SocketSettings.Builder builder) {
                builder.readTimeout(1, TimeUnit.SECONDS);
                builder.connectTimeout(1, TimeUnit.SECONDS);
            }
        }).applyConnectionString(new ConnectionString(connectionString != null ? connectionString : "mongodb://localhost:27020")).build();
    }

    public static ProcessBuilder createProcessBuilder(Map<String, Object> options) {
        return new ProcessBuilder(createMongocryptdSpawnArgs(options));
    }

    public static void startProcess(ProcessBuilder processBuilder) {
        try {
            processBuilder.redirectErrorStream(true);
            processBuilder.redirectOutput(new File(System.getProperty("os.name").startsWith("Windows") ? "NUL" : "/dev/null"));
            processBuilder.start();
        } catch (Throwable t) {
            throw new MongoClientException("Exception starting mongocryptd process. Is `mongocryptd` on the system path?", t);
        }
    }

    private MongoCryptHelper() {
    }
}
