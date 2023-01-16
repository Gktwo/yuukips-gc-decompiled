package com.mongodb.internal.operation;

import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.connection.QueryResult;
import org.bson.codecs.Decoder;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MapReduceInlineResultsCursor.class */
public class MapReduceInlineResultsCursor<T> extends QueryBatchCursor<T> implements MapReduceBatchCursor<T> {
    private final MapReduceStatistics statistics;

    /* access modifiers changed from: package-private */
    public MapReduceInlineResultsCursor(QueryResult<T> queryResult, Decoder<T> decoder, ConnectionSource connectionSource, MapReduceStatistics statistics) {
        super(queryResult, 0, 0, decoder, connectionSource);
        this.statistics = statistics;
    }

    @Override // com.mongodb.internal.operation.MapReduceBatchCursor
    public MapReduceStatistics getStatistics() {
        return this.statistics;
    }
}
