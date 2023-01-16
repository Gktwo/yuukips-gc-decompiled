package com.mongodb.client.internal;

import com.mongodb.Function;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.lang.Nullable;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/MongoIterableImpl.class */
public abstract class MongoIterableImpl<TResult> implements MongoIterable<TResult> {
    private final ClientSession clientSession;
    private final ReadConcern readConcern;
    private final OperationExecutor executor;
    private final ReadPreference readPreference;
    private final boolean retryReads;
    private Integer batchSize;

    public abstract ReadOperation<BatchCursor<TResult>> asReadOperation();

    public MongoIterableImpl(@Nullable ClientSession clientSession, OperationExecutor executor, ReadConcern readConcern, ReadPreference readPreference, boolean retryReads) {
        this.clientSession = clientSession;
        this.executor = (OperationExecutor) Assertions.notNull("executor", executor);
        this.readConcern = (ReadConcern) Assertions.notNull("readConcern", readConcern);
        this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
        this.retryReads = ((Boolean) Assertions.notNull("retryReads", Boolean.valueOf(retryReads))).booleanValue();
    }

    @Nullable
    ClientSession getClientSession() {
        return this.clientSession;
    }

    OperationExecutor getExecutor() {
        return this.executor;
    }

    /* access modifiers changed from: package-private */
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    protected ReadConcern getReadConcern() {
        return this.readConcern;
    }

    protected boolean getRetryReads() {
        return this.retryReads;
    }

    @Nullable
    public Integer getBatchSize() {
        return this.batchSize;
    }

    @Override // com.mongodb.client.MongoIterable
    public MongoIterable<TResult> batchSize(int batchSize) {
        this.batchSize = Integer.valueOf(batchSize);
        return this;
    }

    @Override // com.mongodb.client.MongoIterable, java.lang.Iterable
    public MongoCursor<TResult> iterator() {
        return new MongoBatchCursorAdapter(execute());
    }

    @Override // com.mongodb.client.MongoIterable
    public MongoCursor<TResult> cursor() {
        return iterator();
    }

    @Override // com.mongodb.client.MongoIterable
    @Nullable
    public TResult first() {
        MongoCursor<TResult> cursor = iterator();
        try {
            if (!cursor.hasNext()) {
                return null;
            }
            return cursor.next();
        } finally {
            cursor.close();
        }
    }

    @Override // com.mongodb.client.MongoIterable
    public <U> MongoIterable<U> map(Function<TResult, U> mapper) {
        return new MappingIterable(this, mapper);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super TResult> action) {
        MongoCursor<TResult> cursor = iterator();
        while (cursor.hasNext()) {
            try {
                action.accept(cursor.next());
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    @Override // com.mongodb.client.MongoIterable
    public <A extends Collection<? super TResult>> A into(A target) {
        Objects.requireNonNull(target);
        forEach(this::add);
        return target;
    }

    private BatchCursor<TResult> execute() {
        return (BatchCursor) this.executor.execute(asReadOperation(), this.readPreference, this.readConcern, this.clientSession);
    }
}
