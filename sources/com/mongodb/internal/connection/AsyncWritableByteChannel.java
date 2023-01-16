package com.mongodb.internal.connection;

import com.mongodb.connection.AsyncCompletionHandler;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsyncWritableByteChannel.class */
interface AsyncWritableByteChannel {
    void write(ByteBuffer byteBuffer, AsyncCompletionHandler<Void> asyncCompletionHandler);
}
