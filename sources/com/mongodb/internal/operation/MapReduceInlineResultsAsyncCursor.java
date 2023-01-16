package com.mongodb.internal.operation;

import com.mongodb.internal.connection.QueryResult;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MapReduceInlineResultsAsyncCursor.class */
public class MapReduceInlineResultsAsyncCursor<T> extends AsyncSingleBatchQueryCursor<T> implements MapReduceAsyncBatchCursor<T> {
    private final MapReduceStatistics statistics;

    /* access modifiers changed from: package-private */
    public MapReduceInlineResultsAsyncCursor(QueryResult<T> queryResult, MapReduceStatistics statistics) {
        super(queryResult);
        this.statistics = statistics;
    }

    @Override // com.mongodb.internal.operation.MapReduceAsyncBatchCursor
    public MapReduceStatistics getStatistics() {
        return this.statistics;
    }
}
