package com.mongodb.client.internal;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.MongoClient;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonDocument;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/KeyRetriever.class */
public class KeyRetriever {
    private final MongoClient client;
    private final MongoNamespace namespace;

    /* access modifiers changed from: package-private */
    public KeyRetriever(MongoClient client, MongoNamespace namespace) {
        this.client = (MongoClient) Assertions.notNull("client", client);
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
    }

    public List<BsonDocument> find(BsonDocument keyFilter) {
        return (List) this.client.getDatabase(this.namespace.getDatabaseName()).getCollection(this.namespace.getCollectionName(), BsonDocument.class).withReadConcern(ReadConcern.MAJORITY).find(keyFilter).into(new ArrayList());
    }
}
