package com.mongodb.internal.connection.tlschannel;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/HeapBufferAllocator.class */
public class HeapBufferAllocator implements BufferAllocator {
    @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
    public ByteBuffer allocate(int size) {
        return ByteBuffer.allocate(size);
    }

    @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
    public void free(ByteBuffer buffer) {
    }
}
