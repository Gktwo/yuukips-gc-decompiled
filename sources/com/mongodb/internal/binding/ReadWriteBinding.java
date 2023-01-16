package com.mongodb.internal.binding;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/ReadWriteBinding.class */
public interface ReadWriteBinding extends ReadBinding, WriteBinding, ReferenceCounted {
    @Override // com.mongodb.internal.binding.ReadBinding, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    ReadWriteBinding retain();
}
