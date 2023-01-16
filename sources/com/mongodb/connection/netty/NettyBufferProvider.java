package com.mongodb.connection.netty;

import com.mongodb.connection.BufferProvider;
import org.bson.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.PooledByteBufAllocator;

/* loaded from: grasscutter.jar:com/mongodb/connection/netty/NettyBufferProvider.class */
final class NettyBufferProvider implements BufferProvider {
    private final ByteBufAllocator allocator;

    NettyBufferProvider() {
        this.allocator = PooledByteBufAllocator.DEFAULT;
    }

    NettyBufferProvider(ByteBufAllocator allocator) {
        this.allocator = allocator;
    }

    @Override // com.mongodb.connection.BufferProvider
    public ByteBuf getBuffer(int size) {
        return new NettyByteBuf(this.allocator.directBuffer(size, size));
    }
}
