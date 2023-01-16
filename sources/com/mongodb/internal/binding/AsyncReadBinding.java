package com.mongodb.internal.binding;

import com.mongodb.ReadPreference;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncReadBinding.class */
public interface AsyncReadBinding extends ReferenceCounted {
    ReadPreference getReadPreference();

    @Override // com.mongodb.internal.binding.AsyncWriteBinding
    SessionContext getSessionContext();

    void getReadConnectionSource(SingleResultCallback<AsyncConnectionSource> singleResultCallback);

    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    AsyncReadBinding retain();
}
