package com.mongodb.connection;

import com.mongodb.ServerAddress;
import java.io.IOException;
import java.util.List;
import org.bson.ByteBuf;

/* loaded from: grasscutter.jar:com/mongodb/connection/Stream.class */
public interface Stream extends BufferProvider {
    void open() throws IOException;

    void openAsync(AsyncCompletionHandler<Void> asyncCompletionHandler);

    void write(List<ByteBuf> list) throws IOException;

    ByteBuf read(int i) throws IOException;

    void writeAsync(List<ByteBuf> list, AsyncCompletionHandler<Void> asyncCompletionHandler);

    void readAsync(int i, AsyncCompletionHandler<ByteBuf> asyncCompletionHandler);

    ServerAddress getAddress();

    void close();

    boolean isClosed();

    default boolean supportsAdditionalTimeout() {
        return false;
    }

    default ByteBuf read(int numBytes, int additionalTimeout) throws IOException {
        throw new UnsupportedOperationException();
    }
}
