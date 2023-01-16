package com.mongodb.internal.connection;

import com.mongodb.event.CommandListener;
import com.mongodb.internal.async.SingleResultCallback;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/LegacyProtocol.class */
public interface LegacyProtocol<T> {
    T execute(InternalConnection internalConnection);

    void executeAsync(InternalConnection internalConnection, SingleResultCallback<T> singleResultCallback);

    void setCommandListener(CommandListener commandListener);
}
