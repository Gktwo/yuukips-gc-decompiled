package com.mongodb.internal.connection;

import com.mongodb.internal.async.SingleResultCallback;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalConnectionInitializer.class */
public interface InternalConnectionInitializer {
    InternalConnectionInitializationDescription initialize(InternalConnection internalConnection);

    void initializeAsync(InternalConnection internalConnection, SingleResultCallback<InternalConnectionInitializationDescription> singleResultCallback);
}
