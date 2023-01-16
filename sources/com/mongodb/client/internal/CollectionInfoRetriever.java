package com.mongodb.client.internal;

import com.mongodb.assertions.Assertions;
import com.mongodb.client.MongoClient;
import com.mongodb.lang.Nullable;
import org.bson.BsonDocument;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/CollectionInfoRetriever.class */
public class CollectionInfoRetriever {
    private final MongoClient client;

    /* access modifiers changed from: package-private */
    public CollectionInfoRetriever(MongoClient client) {
        this.client = (MongoClient) Assertions.notNull("client", client);
    }

    @Nullable
    public BsonDocument filter(String databaseName, BsonDocument filter) {
        return (BsonDocument) this.client.getDatabase(databaseName).listCollections(BsonDocument.class).filter(filter).first();
    }
}
