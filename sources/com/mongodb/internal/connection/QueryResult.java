package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/QueryResult.class */
public class QueryResult<T> {
    private final MongoNamespace namespace;
    private final List<T> results;
    private final long cursorId;
    private final ServerAddress serverAddress;

    public QueryResult(MongoNamespace namespace, List<T> results, long cursorId, ServerAddress serverAddress) {
        this.namespace = namespace;
        this.results = results;
        this.cursorId = cursorId;
        this.serverAddress = serverAddress;
    }

    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    public ServerCursor getCursor() {
        if (this.cursorId == 0) {
            return null;
        }
        return new ServerCursor(this.cursorId, this.serverAddress);
    }

    public List<T> getResults() {
        return this.results;
    }

    public ServerAddress getAddress() {
        return this.serverAddress;
    }
}
