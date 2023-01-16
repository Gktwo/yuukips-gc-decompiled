package com.mongodb.internal.connection.tlschannel;

import com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet;
import com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ClientTlsChannel.class */
public class ClientTlsChannel implements TlsChannel {
    private final ByteChannel underlying;
    private final TlsChannelImpl impl;

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ClientTlsChannel$Builder.class */
    public static class Builder extends TlsChannelBuilder<Builder> {
        private final Supplier<SSLEngine> sslEngineFactory;

        private Builder(ByteChannel underlying, SSLEngine sslEngine) {
            super(underlying);
            this.sslEngineFactory = () -> {
                return sslEngine;
            };
        }

        private Builder(ByteChannel underlying, SSLContext sslContext) {
            super(underlying);
            this.sslEngineFactory = () -> {
                return ClientTlsChannel.defaultSSLEngineFactory(sslContext);
            };
        }

        /* access modifiers changed from: package-private */
        @Override // com.mongodb.internal.connection.tlschannel.TlsChannelBuilder
        public Builder getThis() {
            return this;
        }

        public ClientTlsChannel build() {
            return new ClientTlsChannel(this.underlying, this.sslEngineFactory.get(), this.sessionInitCallback, this.runTasks, this.plainBufferAllocator, this.encryptedBufferAllocator, this.releaseBuffers, this.waitForCloseConfirmation);
        }
    }

    /* access modifiers changed from: private */
    public static SSLEngine defaultSSLEngineFactory(SSLContext sslContext) {
        SSLEngine engine = sslContext.createSSLEngine();
        engine.setUseClientMode(true);
        return engine;
    }

    public static Builder newBuilder(ByteChannel underlying, SSLEngine sslEngine) {
        return new Builder(underlying, sslEngine);
    }

    public static Builder newBuilder(ByteChannel underlying, SSLContext sslContext) {
        return new Builder(underlying, sslContext);
    }

    private ClientTlsChannel(ByteChannel underlying, SSLEngine engine, Consumer<SSLSession> sessionInitCallback, boolean runTasks, BufferAllocator plainBufAllocator, BufferAllocator encryptedBufAllocator, boolean releaseBuffers, boolean waitForCloseNotifyOnClose) {
        if (!engine.getUseClientMode()) {
            throw new IllegalArgumentException("SSLEngine must be in client mode");
        }
        this.underlying = underlying;
        this.impl = new TlsChannelImpl(underlying, underlying, engine, Optional.empty(), sessionInitCallback, runTasks, new TrackingAllocator(plainBufAllocator), new TrackingAllocator(encryptedBufAllocator), releaseBuffers, waitForCloseNotifyOnClose);
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public ByteChannel getUnderlying() {
        return this.underlying;
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public SSLEngine getSslEngine() {
        return this.impl.engine();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public Consumer<SSLSession> getSessionInitCallback() {
        return this.impl.getSessionInitCallback();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public TrackingAllocator getPlainBufferAllocator() {
        return this.impl.getPlainBufferAllocator();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public TrackingAllocator getEncryptedBufferAllocator() {
        return this.impl.getEncryptedBufferAllocator();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean getRunTasks() {
        return this.impl.getRunTasks();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] dstBuffers, int offset, int length) throws IOException {
        ByteBufferSet dest = new ByteBufferSet(dstBuffers, offset, length);
        TlsChannelImpl.checkReadBuffer(dest);
        return this.impl.read(dest);
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] dstBuffers) throws IOException {
        return read(dstBuffers, 0, dstBuffers.length);
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer dstBuffer) throws IOException {
        return (int) read(new ByteBuffer[]{dstBuffer});
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] srcBuffers, int offset, int length) throws IOException {
        return this.impl.write(new ByteBufferSet(srcBuffers, offset, length));
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] outs) throws IOException {
        return write(outs, 0, outs.length);
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer srcBuffer) throws IOException {
        return (int) write(new ByteBuffer[]{srcBuffer});
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public void renegotiate() throws IOException {
        this.impl.renegotiate();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public void handshake() throws IOException {
        this.impl.handshake();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.impl.close();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.impl.isOpen();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean shutdown() throws IOException {
        return this.impl.shutdown();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean shutdownReceived() {
        return this.impl.shutdownReceived();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean shutdownSent() {
        return this.impl.shutdownSent();
    }
}
