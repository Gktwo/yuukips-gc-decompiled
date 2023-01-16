package com.mongodb.connection;

import org.bson.ByteBuf;

/* loaded from: grasscutter.jar:com/mongodb/connection/BufferProvider.class */
public interface BufferProvider {
    ByteBuf getBuffer(int i);
}
