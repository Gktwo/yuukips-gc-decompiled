package com.mongodb.internal.connection;

import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ProtocolExecutor.class */
public interface ProtocolExecutor {
    <T> T execute(LegacyProtocol<T> legacyProtocol, InternalConnection internalConnection);

    <T> void executeAsync(LegacyProtocol<T> legacyProtocol, InternalConnection internalConnection, SingleResultCallback<T> singleResultCallback);

    <T> T execute(CommandProtocol<T> commandProtocol, InternalConnection internalConnection, SessionContext sessionContext);

    <T> void executeAsync(CommandProtocol<T> commandProtocol, InternalConnection internalConnection, SessionContext sessionContext, SingleResultCallback<T> singleResultCallback);
}
