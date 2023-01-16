package com.mongodb.internal.connection;

import com.mongodb.MongoInternalException;
import com.mongodb.ServerAddress;
import com.mongodb.internal.async.SingleResultCallback;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ResponseCallback.class */
abstract class ResponseCallback implements SingleResultCallback<ResponseBuffers> {
    private volatile boolean closed;
    private final ServerAddress serverAddress;
    private final long requestId;

    protected abstract void callCallback(ResponseBuffers responseBuffers, Throwable th);

    /* access modifiers changed from: package-private */
    public ResponseCallback(long requestId, ServerAddress serverAddress) {
        this.serverAddress = serverAddress;
        this.requestId = requestId;
    }

    protected ServerAddress getServerAddress() {
        return this.serverAddress;
    }

    protected long getRequestId() {
        return this.requestId;
    }

    public void onResult(ResponseBuffers responseBuffers, Throwable t) {
        if (this.closed) {
            throw new MongoInternalException("Callback should not be invoked more than once");
        }
        this.closed = true;
        if (responseBuffers != null) {
            callCallback(responseBuffers, t);
        } else {
            callCallback(null, t);
        }
    }
}
