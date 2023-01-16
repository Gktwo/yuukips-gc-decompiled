package com.mongodb.internal.connection.tlschannel.async;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/ExtendedAsynchronousByteChannel.class */
public interface ExtendedAsynchronousByteChannel extends AsynchronousByteChannel {
    <A> void read(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, A a, CompletionHandler<Integer, ? super A> completionHandler);

    <A> void read(ByteBuffer[] byteBufferArr, int i, int i2, long j, TimeUnit timeUnit, A a, CompletionHandler<Long, ? super A> completionHandler);

    <A> void write(ByteBuffer byteBuffer, long j, TimeUnit timeUnit, A a, CompletionHandler<Integer, ? super A> completionHandler);

    <A> void write(ByteBuffer[] byteBufferArr, int i, int i2, long j, TimeUnit timeUnit, A a, CompletionHandler<Long, ? super A> completionHandler);
}
