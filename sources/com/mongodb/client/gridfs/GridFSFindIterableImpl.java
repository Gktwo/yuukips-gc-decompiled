package com.mongodb.client.gridfs;

import com.mongodb.Function;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/GridFSFindIterableImpl.class */
class GridFSFindIterableImpl implements GridFSFindIterable {
    private final FindIterable<GridFSFile> underlying;

    /* access modifiers changed from: package-private */
    public GridFSFindIterableImpl(FindIterable<GridFSFile> underlying) {
        this.underlying = underlying;
    }

    @Override // com.mongodb.client.gridfs.GridFSFindIterable
    public GridFSFindIterable sort(@Nullable Bson sort) {
        this.underlying.sort(sort);
        return this;
    }

    @Override // com.mongodb.client.gridfs.GridFSFindIterable
    public GridFSFindIterable skip(int skip) {
        this.underlying.skip(skip);
        return this;
    }

    @Override // com.mongodb.client.gridfs.GridFSFindIterable
    public GridFSFindIterable limit(int limit) {
        this.underlying.limit(limit);
        return this;
    }

    @Override // com.mongodb.client.gridfs.GridFSFindIterable
    public GridFSFindIterable filter(@Nullable Bson filter) {
        this.underlying.filter(filter);
        return this;
    }

    @Override // com.mongodb.client.gridfs.GridFSFindIterable
    public GridFSFindIterable maxTime(long maxTime, TimeUnit timeUnit) {
        this.underlying.maxTime(maxTime, timeUnit);
        return this;
    }

    /* Return type fixed from 'com.mongodb.client.gridfs.GridFSFindIterable' to match base method */
    @Override // com.mongodb.client.gridfs.GridFSFindIterable, com.mongodb.client.MongoIterable
    public MongoIterable<GridFSFile> batchSize(int batchSize) {
        this.underlying.batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.gridfs.GridFSFindIterable
    public GridFSFindIterable collation(@Nullable Collation collation) {
        this.underlying.collation(collation);
        return this;
    }

    @Override // com.mongodb.client.gridfs.GridFSFindIterable
    public GridFSFindIterable noCursorTimeout(boolean noCursorTimeout) {
        this.underlying.noCursorTimeout(noCursorTimeout);
        return this;
    }

    @Override // com.mongodb.client.MongoIterable, java.lang.Iterable
    public MongoCursor<GridFSFile> iterator() {
        return this.underlying.iterator();
    }

    @Override // com.mongodb.client.MongoIterable
    public MongoCursor<GridFSFile> cursor() {
        return iterator();
    }

    @Override // com.mongodb.client.MongoIterable
    @Nullable
    public GridFSFile first() {
        return this.underlying.first();
    }

    @Override // com.mongodb.client.MongoIterable
    public <U> MongoIterable<U> map(Function<GridFSFile, U> mapper) {
        return this.underlying.map(mapper);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super GridFSFile> block) {
        this.underlying.forEach(block);
    }

    @Override // com.mongodb.client.MongoIterable
    public <A extends Collection<? super GridFSFile>> A into(A target) {
        return (A) this.underlying.into(target);
    }
}
