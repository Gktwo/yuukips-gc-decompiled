package com.mongodb.internal.connection.tlschannel;

import com.mongodb.internal.connection.tlschannel.util.DirectBufferDeallocator;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/DirectBufferAllocator.class */
public class DirectBufferAllocator implements BufferAllocator {
    private final DirectBufferDeallocator deallocator = new DirectBufferDeallocator();

    @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
    public ByteBuffer allocate(int size) {
        return ByteBuffer.allocateDirect(size);
    }

    @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
    public void free(ByteBuffer buffer) {
        this.deallocator.deallocate(buffer);
    }
}
