package com.mongodb.internal.connection;

import com.mongodb.connection.ServerId;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalConnectionFactory.class */
public interface InternalConnectionFactory {
    InternalConnection create(ServerId serverId);
}
