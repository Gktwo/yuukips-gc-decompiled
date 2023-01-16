package com.mongodb.internal.connection;

import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/CommandProtocol.class */
public interface CommandProtocol<T> {
    T execute(InternalConnection internalConnection);

    void executeAsync(InternalConnection internalConnection, SingleResultCallback<T> singleResultCallback);

    CommandProtocol<T> sessionContext(SessionContext sessionContext);
}
