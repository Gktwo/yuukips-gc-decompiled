package com.mongodb.client.internal;

import com.mongodb.Function;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.lang.Nullable;
import java.util.Collection;
import java.util.function.Consumer;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/MappingIterable.class */
class MappingIterable<U, V> implements MongoIterable<V> {
    private final MongoIterable<U> iterable;
    private final Function<U, V> mapper;

    /* access modifiers changed from: package-private */
    public MappingIterable(MongoIterable<U> iterable, Function<U, V> mapper) {
        this.iterable = iterable;
        this.mapper = mapper;
    }

    @Override // com.mongodb.client.MongoIterable, java.lang.Iterable
    public MongoCursor<V> iterator() {
        return new MongoMappingCursor(this.iterable.iterator(), this.mapper);
    }

    @Override // com.mongodb.client.MongoIterable
    public MongoCursor<V> cursor() {
        return iterator();
    }

    @Override // com.mongodb.client.MongoIterable
    @Nullable
    public V first() {
        U first = this.iterable.first();
        if (first == null) {
            return null;
        }
        return this.mapper.apply(first);
    }

    @Override // java.lang.Iterable
    public void forEach(final Consumer<? super V> block) {
        this.iterable.forEach(new Consumer<U>() { // from class: com.mongodb.client.internal.MappingIterable.1
            @Override // java.util.function.Consumer
            public void accept(U document) {
                block.accept(MappingIterable.this.mapper.apply(document));
            }
        });
    }

    @Override // com.mongodb.client.MongoIterable
    public <A extends Collection<? super V>> A into(final A target) {
        forEach(new Consumer<V>() { // from class: com.mongodb.client.internal.MappingIterable.2
            @Override // java.util.function.Consumer
            public void accept(V v) {
                target.add(v);
            }
        });
        return target;
    }

    @Override // com.mongodb.client.MongoIterable
    public MappingIterable<U, V> batchSize(int batchSize) {
        this.iterable.batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.MongoIterable
    public <W> MongoIterable<W> map(Function<V, W> newMap) {
        return new MappingIterable(this, newMap);
    }

    MongoIterable<U> getMapped() {
        return this.iterable;
    }
}
