package com.mongodb.internal.connection.tlschannel;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/BufferAllocator.class */
public interface BufferAllocator {
    ByteBuffer allocate(int i);

    void free(ByteBuffer byteBuffer);
}
