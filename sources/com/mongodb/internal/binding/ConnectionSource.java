package com.mongodb.internal.binding;

import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/ConnectionSource.class */
public interface ConnectionSource extends ReferenceCounted {
    ServerDescription getServerDescription();

    SessionContext getSessionContext();

    Connection getConnection();

    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    ConnectionSource retain();
}
