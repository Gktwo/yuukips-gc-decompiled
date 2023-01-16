package com.mongodb.internal.connection;

import com.mongodb.connection.BufferProvider;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;
import java.util.List;
import org.bson.ByteBuf;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalConnection.class */
public interface InternalConnection extends BufferProvider {
    ConnectionDescription getDescription();

    ServerDescription getInitialServerDescription();

    void open();

    void openAsync(SingleResultCallback<Void> singleResultCallback);

    void close();

    boolean opened();

    boolean isClosed();

    <T> T sendAndReceive(CommandMessage commandMessage, Decoder<T> decoder, SessionContext sessionContext);

    <T> void send(CommandMessage commandMessage, Decoder<T> decoder, SessionContext sessionContext);

    <T> T receive(Decoder<T> decoder, SessionContext sessionContext);

    boolean hasMoreToCome();

    <T> void sendAndReceiveAsync(CommandMessage commandMessage, Decoder<T> decoder, SessionContext sessionContext, SingleResultCallback<T> singleResultCallback);

    void sendMessage(List<ByteBuf> list, int i);

    ResponseBuffers receiveMessage(int i);

    void sendMessageAsync(List<ByteBuf> list, int i, SingleResultCallback<Void> singleResultCallback);

    void receiveMessageAsync(int i, SingleResultCallback<ResponseBuffers> singleResultCallback);

    default int getGeneration() {
        throw new UnsupportedOperationException();
    }

    default boolean supportsAdditionalTimeout() {
        return false;
    }

    default <T> T receive(Decoder<T> decoder, SessionContext sessionContext, int additionalTimeout) {
        throw new UnsupportedOperationException();
    }
}
