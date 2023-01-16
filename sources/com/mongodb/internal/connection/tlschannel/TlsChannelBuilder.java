package com.mongodb.internal.connection.tlschannel;

import com.mongodb.internal.connection.tlschannel.TlsChannelBuilder;
import java.nio.channels.ByteChannel;
import java.util.function.Consumer;
import javax.net.ssl.SSLSession;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/TlsChannelBuilder.class */
public abstract class TlsChannelBuilder<T extends TlsChannelBuilder<T>> {
    final ByteChannel underlying;
    Consumer<SSLSession> sessionInitCallback = session -> {
    };
    boolean runTasks = true;
    BufferAllocator plainBufferAllocator = TlsChannel.defaultPlainBufferAllocator;
    BufferAllocator encryptedBufferAllocator = TlsChannel.defaultEncryptedBufferAllocator;
    boolean releaseBuffers = true;
    boolean waitForCloseConfirmation = false;

    abstract T getThis();

    /* access modifiers changed from: package-private */
    public TlsChannelBuilder(ByteChannel underlying) {
        this.underlying = underlying;
    }

    public T withRunTasks(boolean runTasks) {
        this.runTasks = runTasks;
        return getThis();
    }

    public T withPlainBufferAllocator(BufferAllocator bufferAllocator) {
        this.plainBufferAllocator = bufferAllocator;
        return getThis();
    }

    public T withEncryptedBufferAllocator(BufferAllocator bufferAllocator) {
        this.encryptedBufferAllocator = bufferAllocator;
        return getThis();
    }

    public T withSessionInitCallback(Consumer<SSLSession> sessionInitCallback) {
        this.sessionInitCallback = sessionInitCallback;
        return getThis();
    }

    public T withReleaseBuffers(boolean releaseBuffers) {
        this.releaseBuffers = releaseBuffers;
        return getThis();
    }

    public T withWaitForCloseConfirmation(boolean waitForCloseConfirmation) {
        this.waitForCloseConfirmation = waitForCloseConfirmation;
        return getThis();
    }
}
