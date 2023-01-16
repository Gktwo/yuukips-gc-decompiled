package com.mongodb.internal.connection;

import com.mongodb.annotations.ThreadSafe;
import com.mongodb.internal.async.SingleResultCallback;

@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/Server.class */
public interface Server {
    Connection getConnection();

    void getConnectionAsync(SingleResultCallback<AsyncConnection> singleResultCallback);
}
