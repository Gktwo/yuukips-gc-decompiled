package com.mongodb;

import com.mongodb.annotations.ThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.internal.MongoIterableImpl;
import com.mongodb.client.internal.OperationExecutor;
import com.mongodb.client.model.DBCreateViewOptions;
import com.mongodb.connection.BufferProvider;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.CommandReadOperation;
import com.mongodb.internal.operation.CreateViewOperation;
import com.mongodb.internal.operation.DropDatabaseOperation;
import com.mongodb.internal.operation.ListCollectionsOperation;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Codec;

@ThreadSafe
/* renamed from: com.mongodb.DB */
/* loaded from: grasscutter.jar:com/mongodb/DB.class */
public class C0961DB {
    private final MongoClient mongo;
    private final String name;
    private final OperationExecutor executor;
    private final ConcurrentHashMap<String, DBCollection> collectionCache = new ConcurrentHashMap<>();
    private final Codec<DBObject> commandCodec = new DBObjectCodec(MongoClientSettings.getDefaultCodecRegistry());
    private volatile ReadPreference readPreference;
    private volatile WriteConcern writeConcern;
    private volatile ReadConcern readConcern;
    private static final Set<String> OBEDIENT_COMMANDS = new HashSet();

    /* access modifiers changed from: package-private */
    public C0961DB(MongoClient mongo, String name, OperationExecutor executor) {
        MongoNamespace.checkDatabaseNameValidity(name);
        this.mongo = mongo;
        this.name = name;
        this.executor = executor;
    }

    public MongoClient getMongoClient() {
        return this.mongo;
    }

    public void setReadPreference(ReadPreference readPreference) {
        this.readPreference = readPreference;
    }

    public void setWriteConcern(WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
    }

    public ReadPreference getReadPreference() {
        return this.readPreference != null ? this.readPreference : this.mongo.getReadPreference();
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern != null ? this.writeConcern : this.mongo.getWriteConcern();
    }

    public void setReadConcern(ReadConcern readConcern) {
        this.readConcern = readConcern;
    }

    public ReadConcern getReadConcern() {
        return this.readConcern != null ? this.readConcern : this.mongo.getReadConcern();
    }

    public DBCollection getCollection(String name) {
        DBCollection collection = this.collectionCache.get(name);
        if (collection != null) {
            return collection;
        }
        DBCollection collection2 = new DBCollection(name, this, this.executor);
        if (this.mongo.getMongoClientOptions().getDbDecoderFactory() != DefaultDBDecoder.FACTORY) {
            collection2.setDBDecoderFactory(this.mongo.getMongoClientOptions().getDbDecoderFactory());
        }
        if (this.mongo.getMongoClientOptions().getDbEncoderFactory() != DefaultDBEncoder.FACTORY) {
            collection2.setDBEncoderFactory(this.mongo.getMongoClientOptions().getDbEncoderFactory());
        }
        DBCollection old = this.collectionCache.putIfAbsent(name, collection2);
        return old != null ? old : collection2;
    }

    public void dropDatabase() {
        try {
            getExecutor().execute(new DropDatabaseOperation(getName(), getWriteConcern()), getReadConcern());
        } catch (MongoWriteConcernException e) {
            throw DBCollection.createWriteConcernException(e);
        }
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getCollectionNames() {
        List<String> collectionNames = (List) new MongoIterableImpl<DBObject>(null, this.executor, ReadConcern.DEFAULT, ReadPreference.primary(), this.mongo.getMongoClientOptions().getRetryReads()) { // from class: com.mongodb.DB.2
            @Override // com.mongodb.client.internal.MongoIterableImpl
            public ReadOperation<BatchCursor<DBObject>> asReadOperation() {
                return new ListCollectionsOperation(C0961DB.this.name, C0961DB.this.commandCodec).nameOnly(true);
            }
        }.map(new Function<DBObject, String>() { // from class: com.mongodb.DB.1
            public String apply(DBObject result) {
                return (String) result.get("name");
            }
        }).into(new ArrayList());
        Collections.sort(collectionNames);
        return new LinkedHashSet(collectionNames);
    }

    public DBCollection createCollection(String collectionName, @Nullable DBObject options) {
        if (options != null) {
            try {
                this.executor.execute(getCreateCollectionOperation(collectionName, options), getReadConcern());
            } catch (MongoWriteConcernException e) {
                throw DBCollection.createWriteConcernException(e);
            }
        }
        return getCollection(collectionName);
    }

    public DBCollection createView(String viewName, String viewOn, List<? extends DBObject> pipeline) {
        return createView(viewName, viewOn, pipeline, new DBCreateViewOptions());
    }

    public DBCollection createView(String viewName, String viewOn, List<? extends DBObject> pipeline, DBCreateViewOptions options) {
        try {
            Assertions.notNull("options", options);
            DBCollection view = getCollection(viewName);
            this.executor.execute(new CreateViewOperation(this.name, viewName, viewOn, view.preparePipeline(pipeline), this.writeConcern).collation(options.getCollation()), getReadConcern());
            return view;
        } catch (MongoWriteConcernException e) {
            throw DBCollection.createWriteConcernException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mongodb.internal.operation.CreateCollectionOperation getCreateCollectionOperation(java.lang.String r7, com.mongodb.DBObject r8) {
        /*
        // Method dump skipped, instructions count: 658
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.C0961DB.getCreateCollectionOperation(java.lang.String, com.mongodb.DBObject):com.mongodb.internal.operation.CreateCollectionOperation");
    }

    public CommandResult command(String command) {
        return command(new BasicDBObject(command, Boolean.TRUE), getReadPreference());
    }

    public CommandResult command(DBObject command) {
        return command(command, getReadPreference());
    }

    public CommandResult command(DBObject command, DBEncoder encoder) {
        return command(command, getReadPreference(), encoder);
    }

    public CommandResult command(DBObject command, ReadPreference readPreference, @Nullable DBEncoder encoder) {
        try {
            return executeCommand(wrap(command, encoder), getCommandReadPreference(command, readPreference));
        } catch (MongoCommandException ex) {
            return new CommandResult(ex.getResponse(), ex.getServerAddress());
        }
    }

    public CommandResult command(DBObject command, ReadPreference readPreference) {
        return command(command, readPreference, null);
    }

    public CommandResult command(String command, ReadPreference readPreference) {
        return command(new BasicDBObject(command, true), readPreference);
    }

    public C0961DB getSisterDB(String name) {
        return this.mongo.getDB(name);
    }

    public boolean collectionExists(String collectionName) {
        for (String name : getCollectionNames()) {
            if (name.equalsIgnoreCase(collectionName)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "DB{name='" + this.name + "'}";
    }

    /* access modifiers changed from: package-private */
    public CommandResult executeCommand(BsonDocument commandDocument, ReadPreference readPreference) {
        return new CommandResult((BsonDocument) this.executor.execute(new CommandReadOperation(getName(), commandDocument, new BsonDocumentCodec()), readPreference, getReadConcern()));
    }

    /* access modifiers changed from: package-private */
    public OperationExecutor getExecutor() {
        return this.executor;
    }

    /* access modifiers changed from: package-private */
    public BufferProvider getBufferPool() {
        return getMongoClient().getBufferProvider();
    }

    private BsonDocument wrap(DBObject document) {
        return new BsonDocumentWrapper(document, this.commandCodec);
    }

    private BsonDocument wrap(DBObject document, @Nullable DBEncoder encoder) {
        if (encoder == null) {
            return wrap(document);
        }
        return new BsonDocumentWrapper(document, new DBEncoderAdapter(encoder));
    }

    ReadPreference getCommandReadPreference(DBObject command, @Nullable ReadPreference requestedPreference) {
        if (!OBEDIENT_COMMANDS.contains(command.keySet().iterator().next().toLowerCase())) {
            return ReadPreference.primary();
        }
        if (requestedPreference == null) {
            return ReadPreference.primary();
        }
        return requestedPreference;
    }

    static {
        OBEDIENT_COMMANDS.add("aggregate");
        OBEDIENT_COMMANDS.add("collstats");
        OBEDIENT_COMMANDS.add("count");
        OBEDIENT_COMMANDS.add("dbstats");
        OBEDIENT_COMMANDS.add("distinct");
        OBEDIENT_COMMANDS.add("geonear");
        OBEDIENT_COMMANDS.add("geosearch");
        OBEDIENT_COMMANDS.add("geowalk");
        OBEDIENT_COMMANDS.add("group");
        OBEDIENT_COMMANDS.add("listcollections");
        OBEDIENT_COMMANDS.add("listindexes");
        OBEDIENT_COMMANDS.add("parallelcollectionscan");
        OBEDIENT_COMMANDS.add("text");
    }
}
