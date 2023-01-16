package com.mongodb.internal.connection;

import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.session.SessionContext;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import org.bson.ByteBuf;
import org.bson.codecs.Decoder;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/UsageTrackingInternalConnection.class */
public class UsageTrackingInternalConnection implements InternalConnection {
    private static final Logger LOGGER = Loggers.getLogger("connection");
    private volatile long openedAt = LongCompanionObject.MAX_VALUE;
    private volatile long lastUsedAt = this.openedAt;
    private final int generation;
    private final InternalConnection wrapped;

    /* access modifiers changed from: package-private */
    public UsageTrackingInternalConnection(InternalConnection wrapped, int generation) {
        this.wrapped = wrapped;
        this.generation = generation;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void open() {
        this.wrapped.open();
        this.openedAt = System.currentTimeMillis();
        this.lastUsedAt = this.openedAt;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void openAsync(final SingleResultCallback<Void> callback) {
        this.wrapped.openAsync(new SingleResultCallback<Void>() { // from class: com.mongodb.internal.connection.UsageTrackingInternalConnection.1
            public void onResult(Void result, Throwable t) {
                if (t != null) {
                    callback.onResult(null, t);
                    return;
                }
                UsageTrackingInternalConnection.this.openedAt = System.currentTimeMillis();
                UsageTrackingInternalConnection.this.lastUsedAt = UsageTrackingInternalConnection.this.openedAt;
                callback.onResult(null, null);
            }
        });
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void close() {
        this.wrapped.close();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean opened() {
        return this.wrapped.opened();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean isClosed() {
        return this.wrapped.isClosed();
    }

    @Override // com.mongodb.connection.BufferProvider
    public ByteBuf getBuffer(int size) {
        return this.wrapped.getBuffer(size);
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void sendMessage(List<ByteBuf> byteBuffers, int lastRequestId) {
        this.wrapped.sendMessage(byteBuffers, lastRequestId);
        this.lastUsedAt = System.currentTimeMillis();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> T sendAndReceive(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext) {
        T result = (T) this.wrapped.sendAndReceive(message, decoder, sessionContext);
        this.lastUsedAt = System.currentTimeMillis();
        return result;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> void send(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext) {
        this.wrapped.send(message, decoder, sessionContext);
        this.lastUsedAt = System.currentTimeMillis();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> T receive(Decoder<T> decoder, SessionContext sessionContext) {
        T result = (T) this.wrapped.receive(decoder, sessionContext);
        this.lastUsedAt = System.currentTimeMillis();
        return result;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean supportsAdditionalTimeout() {
        return this.wrapped.supportsAdditionalTimeout();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> T receive(Decoder<T> decoder, SessionContext sessionContext, int additionalTimeout) {
        T result = (T) this.wrapped.receive(decoder, sessionContext, additionalTimeout);
        this.lastUsedAt = System.currentTimeMillis();
        return result;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public boolean hasMoreToCome() {
        return this.wrapped.hasMoreToCome();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public <T> void sendAndReceiveAsync(CommandMessage message, Decoder<T> decoder, SessionContext sessionContext, final SingleResultCallback<T> callback) {
        this.wrapped.sendAndReceiveAsync(message, decoder, sessionContext, ErrorHandlingResultCallback.errorHandlingCallback(new SingleResultCallback<T>() { // from class: com.mongodb.internal.connection.UsageTrackingInternalConnection.2
            @Override // com.mongodb.internal.async.SingleResultCallback
            public void onResult(T result, Throwable t) {
                UsageTrackingInternalConnection.this.lastUsedAt = System.currentTimeMillis();
                callback.onResult(result, t);
            }
        }, LOGGER));
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public ResponseBuffers receiveMessage(int responseTo) {
        ResponseBuffers responseBuffers = this.wrapped.receiveMessage(responseTo);
        this.lastUsedAt = System.currentTimeMillis();
        return responseBuffers;
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void sendMessageAsync(List<ByteBuf> byteBuffers, int lastRequestId, final SingleResultCallback<Void> callback) {
        this.wrapped.sendMessageAsync(byteBuffers, lastRequestId, ErrorHandlingResultCallback.errorHandlingCallback(new SingleResultCallback<Void>() { // from class: com.mongodb.internal.connection.UsageTrackingInternalConnection.3
            public void onResult(Void result, Throwable t) {
                UsageTrackingInternalConnection.this.lastUsedAt = System.currentTimeMillis();
                callback.onResult(result, t);
            }
        }, LOGGER));
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public void receiveMessageAsync(int responseTo, final SingleResultCallback<ResponseBuffers> callback) {
        this.wrapped.receiveMessageAsync(responseTo, ErrorHandlingResultCallback.errorHandlingCallback(new SingleResultCallback<ResponseBuffers>() { // from class: com.mongodb.internal.connection.UsageTrackingInternalConnection.4
            public void onResult(ResponseBuffers result, Throwable t) {
                UsageTrackingInternalConnection.this.lastUsedAt = System.currentTimeMillis();
                callback.onResult(result, t);
            }
        }, LOGGER));
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public ConnectionDescription getDescription() {
        return this.wrapped.getDescription();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public ServerDescription getInitialServerDescription() {
        return this.wrapped.getInitialServerDescription();
    }

    @Override // com.mongodb.internal.connection.InternalConnection
    public int getGeneration() {
        return this.generation;
    }

    /* access modifiers changed from: package-private */
    public long getOpenedAt() {
        return this.openedAt;
    }

    /* access modifiers changed from: package-private */
    public long getLastUsedAt() {
        return this.lastUsedAt;
    }
}
