package com.mongodb.internal.binding;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/ReferenceCounted.class */
public interface ReferenceCounted {
    int getCount();

    @Override // com.mongodb.internal.binding.WriteBinding
    ReferenceCounted retain();

    void release();
}
