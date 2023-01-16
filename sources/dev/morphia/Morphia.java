package dev.morphia;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dev.morphia.mapping.MapperOptions;

/* loaded from: grasscutter.jar:dev/morphia/Morphia.class */
public final class Morphia {
    private Morphia() {
    }

    public static Datastore createDatastore(String dbName) {
        return createDatastore(dbName, MapperOptions.DEFAULT);
    }

    public static Datastore createDatastore(String dbName, MapperOptions options) {
        return createDatastore(MongoClients.create(MongoClientSettings.builder().uuidRepresentation(options.getUuidRepresentation()).build()), dbName, options);
    }

    public static Datastore createDatastore(MongoClient mongoClient, String dbName, MapperOptions options) {
        return new DatastoreImpl(mongoClient, options, dbName);
    }

    public static Datastore createDatastore(MongoClient mongoClient, String dbName) {
        return createDatastore(mongoClient, dbName, MapperOptions.DEFAULT);
    }
}
