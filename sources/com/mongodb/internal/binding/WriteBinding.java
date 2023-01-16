package com.mongodb.internal.binding;

import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/WriteBinding.class */
public interface WriteBinding extends ReferenceCounted {
    ConnectionSource getWriteConnectionSource();

    SessionContext getSessionContext();

    WriteBinding retain();
}
