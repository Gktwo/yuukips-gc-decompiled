package com.mongodb.internal.binding;

import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncWriteBinding.class */
public interface AsyncWriteBinding extends ReferenceCounted {
    void getWriteConnectionSource(SingleResultCallback<AsyncConnectionSource> singleResultCallback);

    SessionContext getSessionContext();

    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    AsyncWriteBinding retain();
}
