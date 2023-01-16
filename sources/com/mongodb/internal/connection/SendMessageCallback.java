package com.mongodb.internal.connection;

import com.mongodb.event.CommandListener;
import com.mongodb.internal.async.SingleResultCallback;
import org.bson.p022io.OutputBuffer;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SendMessageCallback.class */
class SendMessageCallback<T> implements SingleResultCallback<Void> {
    private final OutputBuffer buffer;
    private final InternalConnection connection;
    private final SingleResultCallback<ResponseBuffers> receiveMessageCallback;
    private final int requestId;
    private final RequestMessage message;
    private final CommandListener commandListener;
    private final long startTimeNanos;
    private final SingleResultCallback<T> callback;
    private final String commandName;

    /* access modifiers changed from: package-private */
    public SendMessageCallback(InternalConnection connection, OutputBuffer buffer, RequestMessage message, String commandName, long startTimeNanos, CommandListener commandListener, SingleResultCallback<T> callback, SingleResultCallback<ResponseBuffers> receiveMessageCallback) {
        this(connection, buffer, message, message.getId(), commandName, startTimeNanos, commandListener, callback, receiveMessageCallback);
    }

    SendMessageCallback(InternalConnection connection, OutputBuffer buffer, RequestMessage message, int requestId, String commandName, long startTimeNanos, CommandListener commandListener, SingleResultCallback<T> callback, SingleResultCallback<ResponseBuffers> receiveMessageCallback) {
        this.buffer = buffer;
        this.connection = connection;
        this.message = message;
        this.commandName = commandName;
        this.commandListener = commandListener;
        this.startTimeNanos = startTimeNanos;
        this.callback = callback;
        this.receiveMessageCallback = receiveMessageCallback;
        this.requestId = requestId;
    }

    public void onResult(Void result, Throwable t) {
        this.buffer.close();
        if (t != null) {
            if (this.commandListener != null) {
                ProtocolHelper.sendCommandFailedEvent(this.message, this.commandName, this.connection.getDescription(), System.nanoTime() - this.startTimeNanos, t, this.commandListener);
            }
            this.callback.onResult(null, t);
            return;
        }
        this.connection.receiveMessageAsync(this.requestId, this.receiveMessageCallback);
    }
}
