package com.mongodb.internal.binding;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncReadWriteBinding.class */
public interface AsyncReadWriteBinding extends AsyncReadBinding, AsyncWriteBinding, ReferenceCounted {
    @Override // com.mongodb.internal.binding.AsyncReadBinding, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    AsyncReadWriteBinding retain();
}
