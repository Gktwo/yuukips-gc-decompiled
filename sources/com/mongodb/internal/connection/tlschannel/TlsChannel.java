package com.mongodb.internal.connection.tlschannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.function.Consumer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/TlsChannel.class */
public interface TlsChannel extends ByteChannel, GatheringByteChannel, ScatteringByteChannel {
    public static final BufferAllocator defaultPlainBufferAllocator = new HeapBufferAllocator();
    public static final BufferAllocator defaultEncryptedBufferAllocator = new DirectBufferAllocator();

    ByteChannel getUnderlying();

    SSLEngine getSslEngine();

    Consumer<SSLSession> getSessionInitCallback();

    TrackingAllocator getPlainBufferAllocator();

    TrackingAllocator getEncryptedBufferAllocator();

    boolean getRunTasks();

    @Override // java.nio.channels.ReadableByteChannel
    int read(ByteBuffer byteBuffer) throws IOException;

    @Override // java.nio.channels.WritableByteChannel
    int write(ByteBuffer byteBuffer) throws IOException;

    void renegotiate() throws IOException;

    void handshake() throws IOException;

    @Override // java.nio.channels.GatheringByteChannel
    long write(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException;

    @Override // java.nio.channels.GatheringByteChannel
    long write(ByteBuffer[] byteBufferArr) throws IOException;

    @Override // java.nio.channels.ScatteringByteChannel
    long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException;

    @Override // java.nio.channels.ScatteringByteChannel
    long read(ByteBuffer[] byteBufferArr) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close() throws IOException;

    boolean shutdown() throws IOException;

    boolean shutdownReceived();

    boolean shutdownSent();
}
