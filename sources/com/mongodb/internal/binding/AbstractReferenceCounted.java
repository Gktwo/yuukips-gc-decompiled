package com.mongodb.internal.binding;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AbstractReferenceCounted.class */
public abstract class AbstractReferenceCounted implements ReferenceCounted {
    private final AtomicInteger referenceCount = new AtomicInteger(1);

    @Override // com.mongodb.internal.binding.ReferenceCounted
    public int getCount() {
        return this.referenceCount.get();
    }

    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public ReferenceCounted retain() {
        if (this.referenceCount.incrementAndGet() != 1) {
            return this;
        }
        throw new IllegalStateException("Attempted to increment the reference count when it is already 0");
    }

    @Override // com.mongodb.internal.binding.ReferenceCounted
    public void release() {
        if (this.referenceCount.decrementAndGet() < 0) {
            throw new IllegalStateException("Attempted to decrement the reference count below 0");
        }
    }
}
