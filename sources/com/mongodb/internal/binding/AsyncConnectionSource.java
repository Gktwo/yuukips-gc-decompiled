package com.mongodb.internal.binding;

import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncConnectionSource.class */
public interface AsyncConnectionSource extends ReferenceCounted {
    ServerDescription getServerDescription();

    SessionContext getSessionContext();

    void getConnection(SingleResultCallback<AsyncConnection> singleResultCallback);

    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    AsyncConnectionSource retain();
}
