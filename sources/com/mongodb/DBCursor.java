package com.mongodb;

import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.internal.MongoBatchCursorAdapter;
import com.mongodb.client.internal.OperationExecutor;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.DBCollectionCountOptions;
import com.mongodb.client.model.DBCollectionFindOptions;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.FindOperation;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.bson.codecs.Decoder;

@NotThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/DBCursor.class */
public class DBCursor implements Cursor, Iterable<DBObject> {
    private final DBCollection collection;
    private final DBObject filter;
    private final DBCollectionFindOptions findOptions;
    private final OperationExecutor executor;
    private final boolean retryReads;
    private DBDecoderFactory decoderFactory;
    private Decoder<DBObject> decoder;
    private IteratorOrArray iteratorOrArray;
    private DBObject currentObject;
    private int numSeen;
    private boolean closed;
    private final List<DBObject> all;
    private MongoCursor<DBObject> cursor;
    private OptionalFinalizer optionalFinalizer;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/DBCursor$IteratorOrArray.class */
    public enum IteratorOrArray {
        ITERATOR,
        ARRAY
    }

    public DBCursor(DBCollection collection, DBObject query, @Nullable DBObject fields, @Nullable ReadPreference readPreference) {
        this(collection, query, fields, readPreference, true);
    }

    public DBCursor(DBCollection collection, DBObject query, @Nullable DBObject fields, @Nullable ReadPreference readPreference, boolean retryReads) {
        this(collection, query, new DBCollectionFindOptions().projection(fields).readPreference(readPreference), retryReads);
    }

    /* access modifiers changed from: package-private */
    public DBCursor(DBCollection collection, @Nullable DBObject filter, DBCollectionFindOptions findOptions) {
        this(collection, filter, findOptions, true);
    }

    DBCursor(DBCollection collection, @Nullable DBObject filter, DBCollectionFindOptions findOptions, boolean retryReads) {
        this(collection, filter, findOptions, collection.getExecutor(), collection.getDBDecoderFactory(), collection.getObjectCodec(), retryReads);
    }

    private DBCursor(DBCollection collection, @Nullable DBObject filter, DBCollectionFindOptions findOptions, OperationExecutor executor, DBDecoderFactory decoderFactory, Decoder<DBObject> decoder, boolean retryReads) {
        this.all = new ArrayList();
        this.collection = (DBCollection) Assertions.notNull("collection", collection);
        this.filter = filter;
        this.executor = (OperationExecutor) Assertions.notNull("executor", executor);
        this.findOptions = (DBCollectionFindOptions) Assertions.notNull("findOptions", findOptions.copy());
        this.decoderFactory = decoderFactory;
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
        this.retryReads = retryReads;
    }

    public DBCursor copy() {
        return new DBCursor(this.collection, this.filter, this.findOptions, this.executor, this.decoderFactory, this.decoder, this.retryReads);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.closed) {
            throw new IllegalStateException("Cursor has been closed");
        }
        if (this.cursor == null) {
            FindOperation<DBObject> operation = getQueryOperation(this.decoder);
            if (operation.getCursorType() == CursorType.Tailable) {
                operation.cursorType(CursorType.TailableAwait);
            }
            initializeCursor(operation);
        }
        boolean hasNext = this.cursor.hasNext();
        setServerCursorOnFinalizer(this.cursor.getServerCursor());
        return hasNext;
    }

    @Override // java.util.Iterator
    public DBObject next() {
        checkIteratorOrArray(IteratorOrArray.ITERATOR);
        if (hasNext()) {
            return nextInternal();
        }
        throw new NoSuchElementException();
    }

    @Nullable
    public DBObject tryNext() {
        if (this.cursor == null) {
            FindOperation<DBObject> operation = getQueryOperation(this.decoder);
            if (!operation.getCursorType().isTailable()) {
                throw new IllegalArgumentException("Can only be used with a tailable cursor");
            }
            initializeCursor(operation);
        }
        setServerCursorOnFinalizer(this.cursor.getServerCursor());
        return currentObject(this.cursor.tryNext());
    }

    public DBObject curr() {
        return this.currentObject;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public int getLimit() {
        return this.findOptions.getLimit();
    }

    public int getBatchSize() {
        return this.findOptions.getBatchSize();
    }

    public DBCursor comment(String comment) {
        this.findOptions.comment(comment);
        return this;
    }

    public DBCursor max(DBObject max) {
        this.findOptions.max(max);
        return this;
    }

    public DBCursor min(DBObject min) {
        this.findOptions.min(min);
        return this;
    }

    public DBCursor returnKey() {
        this.findOptions.returnKey(true);
        return this;
    }

    public DBCursor hint(DBObject indexKeys) {
        this.findOptions.hint(indexKeys);
        return this;
    }

    public DBCursor maxTime(long maxTime, TimeUnit timeUnit) {
        this.findOptions.maxTime(maxTime, timeUnit);
        return this;
    }

    @Deprecated
    public DBObject explain() {
        return (DBObject) this.executor.execute((ReadOperation<Object>) getQueryOperation(this.collection.getObjectCodec()).asExplainableOperation(null, MongoClient.getDefaultCodecRegistry().get(DBObject.class)), getReadPreference(), getReadConcern());
    }

    public DBCursor cursorType(CursorType cursorType) {
        this.findOptions.cursorType(cursorType);
        return this;
    }

    @Deprecated
    public DBCursor oplogReplay(boolean oplogReplay) {
        this.findOptions.oplogReplay(oplogReplay);
        return this;
    }

    public DBCursor noCursorTimeout(boolean noCursorTimeout) {
        this.findOptions.noCursorTimeout(noCursorTimeout);
        return this;
    }

    public DBCursor partial(boolean partial) {
        this.findOptions.partial(partial);
        return this;
    }

    private FindOperation<DBObject> getQueryOperation(Decoder<DBObject> decoder) {
        return new FindOperation(this.collection.getNamespace(), decoder).filter(this.collection.wrapAllowNull(this.filter)).batchSize(this.findOptions.getBatchSize()).skip(this.findOptions.getSkip()).limit(this.findOptions.getLimit()).maxAwaitTime(this.findOptions.getMaxAwaitTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).maxTime(this.findOptions.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).projection(this.collection.wrapAllowNull(this.findOptions.getProjection())).sort(this.collection.wrapAllowNull(this.findOptions.getSort())).collation(this.findOptions.getCollation()).comment(this.findOptions.getComment()).hint(this.collection.wrapAllowNull(this.findOptions.getHint())).min(this.collection.wrapAllowNull(this.findOptions.getMin())).max(this.collection.wrapAllowNull(this.findOptions.getMax())).cursorType(this.findOptions.getCursorType()).noCursorTimeout(this.findOptions.isNoCursorTimeout()).oplogReplay(this.findOptions.isOplogReplay()).partial(this.findOptions.isPartial()).returnKey(this.findOptions.isReturnKey()).showRecordId(this.findOptions.isShowRecordId()).retryReads(this.retryReads);
    }

    public DBCursor sort(DBObject orderBy) {
        this.findOptions.sort(orderBy);
        return this;
    }

    public DBCursor limit(int limit) {
        this.findOptions.limit(limit);
        return this;
    }

    public DBCursor batchSize(int numberOfElements) {
        this.findOptions.batchSize(numberOfElements);
        return this;
    }

    public DBCursor skip(int numberOfElements) {
        this.findOptions.skip(numberOfElements);
        return this;
    }

    @Override // com.mongodb.Cursor
    public long getCursorId() {
        ServerCursor serverCursor;
        if (this.cursor == null || (serverCursor = this.cursor.getServerCursor()) == null) {
            return 0;
        }
        return serverCursor.getId();
    }

    public int numSeen() {
        return this.numSeen;
    }

    @Override // com.mongodb.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        if (this.cursor != null) {
            this.cursor.close();
            this.cursor = null;
            setServerCursorOnFinalizer(null);
        }
        this.currentObject = null;
    }

    @Override // java.lang.Iterable
    public Iterator<DBObject> iterator() {
        return copy();
    }

    public List<DBObject> toArray() {
        return toArray(Integer.MAX_VALUE);
    }

    public List<DBObject> toArray(int max) {
        checkIteratorOrArray(IteratorOrArray.ARRAY);
        fillArray(max - 1);
        return this.all;
    }

    public int count() {
        return (int) this.collection.getCount(getQuery(), getDbCollectionCountOptions());
    }

    @Nullable
    public DBObject one() {
        DBCursor findOneCursor = copy().limit(-1);
        try {
            return findOneCursor.hasNext() ? findOneCursor.next() : null;
        } finally {
            findOneCursor.close();
        }
    }

    public int length() {
        checkIteratorOrArray(IteratorOrArray.ARRAY);
        fillArray(Integer.MAX_VALUE);
        return this.all.size();
    }

    public int itcount() {
        int n = 0;
        while (hasNext()) {
            next();
            n++;
        }
        return n;
    }

    public int size() {
        return (int) this.collection.getCount(getQuery(), getDbCollectionCountOptions().skip(this.findOptions.getSkip()).limit(this.findOptions.getLimit()));
    }

    @Nullable
    public DBObject getKeysWanted() {
        return this.findOptions.getProjection();
    }

    public DBObject getQuery() {
        return this.filter;
    }

    public DBCollection getCollection() {
        return this.collection;
    }

    @Override // com.mongodb.Cursor
    @Nullable
    public ServerAddress getServerAddress() {
        if (this.cursor != null) {
            return this.cursor.getServerAddress();
        }
        return null;
    }

    public DBCursor setReadPreference(ReadPreference readPreference) {
        this.findOptions.readPreference(readPreference);
        return this;
    }

    public ReadPreference getReadPreference() {
        ReadPreference readPreference = this.findOptions.getReadPreference();
        if (readPreference != null) {
            return readPreference;
        }
        return this.collection.getReadPreference();
    }

    DBCursor setReadConcern(@Nullable ReadConcern readConcern) {
        this.findOptions.readConcern(readConcern);
        return this;
    }

    ReadConcern getReadConcern() {
        ReadConcern readConcern = this.findOptions.getReadConcern();
        if (readConcern != null) {
            return readConcern;
        }
        return this.collection.getReadConcern();
    }

    @Nullable
    public Collation getCollation() {
        return this.findOptions.getCollation();
    }

    public DBCursor setCollation(@Nullable Collation collation) {
        this.findOptions.collation(collation);
        return this;
    }

    public DBCursor setDecoderFactory(DBDecoderFactory factory) {
        this.decoderFactory = factory;
        this.decoder = new DBDecoderAdapter(factory.create(), this.collection, getCollection().getBufferPool());
        return this;
    }

    public DBDecoderFactory getDecoderFactory() {
        return this.decoderFactory;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DBCursor{collection=" + this.collection + ", find=" + this.findOptions + (this.cursor != null ? ", cursor=" + this.cursor.getServerCursor() : "") + '}';
    }

    private void initializeCursor(FindOperation<DBObject> operation) {
        this.cursor = new MongoBatchCursorAdapter((BatchCursor) this.executor.execute(operation, getReadPreference(), getReadConcern()));
        if (isCursorFinalizerEnabled() && this.cursor.getServerCursor() != null) {
            this.optionalFinalizer = new OptionalFinalizer(this.collection.getDB().getMongoClient(), this.collection.getNamespace());
        }
    }

    private boolean isCursorFinalizerEnabled() {
        return this.collection.getDB().getMongoClient().getMongoClientOptions().isCursorFinalizerEnabled();
    }

    private void setServerCursorOnFinalizer(@Nullable ServerCursor serverCursor) {
        if (this.optionalFinalizer != null) {
            this.optionalFinalizer.setServerCursor(serverCursor);
        }
    }

    private void checkIteratorOrArray(IteratorOrArray expected) {
        if (this.iteratorOrArray == null) {
            this.iteratorOrArray = expected;
        } else if (expected != this.iteratorOrArray) {
            throw new IllegalArgumentException("Can't switch cursor access methods");
        }
    }

    private void fillArray(int n) {
        checkIteratorOrArray(IteratorOrArray.ARRAY);
        while (n >= this.all.size() && hasNext()) {
            this.all.add(nextInternal());
        }
    }

    private DBObject nextInternal() {
        if (this.iteratorOrArray == null) {
            checkIteratorOrArray(IteratorOrArray.ITERATOR);
        }
        setServerCursorOnFinalizer(this.cursor.getServerCursor());
        return currentObjectNonNull(this.cursor.next());
    }

    @Nullable
    private DBObject currentObject(@Nullable DBObject newCurrentObject) {
        if (newCurrentObject != null) {
            this.currentObject = newCurrentObject;
            this.numSeen++;
            DBObject projection = this.findOptions.getProjection();
            if (projection != null && !projection.keySet().isEmpty()) {
                this.currentObject.markAsPartialObject();
            }
        }
        return newCurrentObject;
    }

    private DBObject currentObjectNonNull(DBObject newCurrentObject) {
        this.currentObject = newCurrentObject;
        this.numSeen++;
        DBObject projection = this.findOptions.getProjection();
        if (projection != null && !projection.keySet().isEmpty()) {
            this.currentObject.markAsPartialObject();
        }
        return newCurrentObject;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/DBCursor$OptionalFinalizer.class */
    public static class OptionalFinalizer {
        private final MongoClient mongo;
        private final MongoNamespace namespace;
        private volatile ServerCursor serverCursor;

        private OptionalFinalizer(MongoClient mongo, MongoNamespace namespace) {
            this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
            this.mongo = (MongoClient) Assertions.notNull("mongo", mongo);
        }

        /* access modifiers changed from: private */
        public void setServerCursor(@Nullable ServerCursor serverCursor) {
            this.serverCursor = serverCursor;
        }

        protected void finalize() {
            if (this.serverCursor != null) {
                this.mongo.addOrphanedCursor(this.serverCursor, this.namespace);
            }
        }
    }

    private DBCollectionCountOptions getDbCollectionCountOptions() {
        return new DBCollectionCountOptions().readPreference(getReadPreference()).readConcern(getReadConcern()).collation(getCollation()).maxTime(this.findOptions.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).hint(this.findOptions.getHint());
    }
}
