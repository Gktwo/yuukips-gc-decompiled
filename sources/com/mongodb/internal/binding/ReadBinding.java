package com.mongodb.internal.binding;

import com.mongodb.ReadPreference;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/ReadBinding.class */
public interface ReadBinding extends ReferenceCounted {
    ReadPreference getReadPreference();

    ConnectionSource getReadConnectionSource();

    @Override // com.mongodb.internal.binding.WriteBinding
    SessionContext getSessionContext();

    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    ReadBinding retain();
}
