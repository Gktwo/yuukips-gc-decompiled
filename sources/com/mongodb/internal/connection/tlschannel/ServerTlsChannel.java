package com.mongodb.internal.connection.tlschannel;

import com.mongodb.internal.connection.tlschannel.impl.BufferHolder;
import com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet;
import com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl;
import com.mongodb.internal.connection.tlschannel.impl.TlsExplorer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ClosedChannelException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ServerTlsChannel.class */
public class ServerTlsChannel implements TlsChannel {
    private static final Logger logger = LoggerFactory.getLogger(ServerTlsChannel.class);
    private final ByteChannel underlying;
    private final SslContextStrategy sslContextStrategy;
    private final Function<SSLContext, SSLEngine> engineFactory;
    private final Consumer<SSLSession> sessionInitCallback;
    private final boolean runTasks;
    private final TrackingAllocator plainBufAllocator;
    private final TrackingAllocator encryptedBufAllocator;
    private final boolean releaseBuffers;
    private final boolean waitForCloseConfirmation;
    private final Lock initLock;
    private BufferHolder inEncrypted;
    private volatile boolean sniRead;
    private SSLContext sslContext;
    private TlsChannelImpl impl;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ServerTlsChannel$SslContextStrategy.class */
    public interface SslContextStrategy {

        @FunctionalInterface
        /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ServerTlsChannel$SslContextStrategy$SniReader.class */
        public interface SniReader {
            Optional<SNIServerName> readSni() throws IOException, TlsChannelImpl.EofException;
        }

        SSLContext getSslContext(SniReader sniReader) throws IOException, TlsChannelImpl.EofException;
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ServerTlsChannel$SniSslContextStrategy.class */
    private static class SniSslContextStrategy implements SslContextStrategy {
        private SniSslContextFactory sniSslContextFactory;

        public SniSslContextStrategy(SniSslContextFactory sniSslContextFactory) {
            this.sniSslContextFactory = sniSslContextFactory;
        }

        @Override // com.mongodb.internal.connection.tlschannel.ServerTlsChannel.SslContextStrategy
        public SSLContext getSslContext(SslContextStrategy.SniReader sniReader) throws IOException, TlsChannelImpl.EofException {
            Optional<SNIServerName> nameOpt = sniReader.readSni();
            try {
                return this.sniSslContextFactory.getSslContext(nameOpt).orElseThrow(() -> {
                    return new SSLHandshakeException("No ssl context available for received SNI: " + nameOpt);
                });
            } catch (Exception e) {
                ServerTlsChannel.logger.trace("client code threw exception during evaluation of server name indication", (Throwable) e);
                throw new TlsChannelCallbackException("SNI callback failed", e);
            }
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ServerTlsChannel$FixedSslContextStrategy.class */
    private static class FixedSslContextStrategy implements SslContextStrategy {
        private final SSLContext sslContext;

        public FixedSslContextStrategy(SSLContext sslContext) {
            this.sslContext = sslContext;
        }

        @Override // com.mongodb.internal.connection.tlschannel.ServerTlsChannel.SslContextStrategy
        public SSLContext getSslContext(SslContextStrategy.SniReader sniReader) {
            return this.sslContext;
        }
    }

    /* access modifiers changed from: private */
    public static SSLEngine defaultSSLEngineFactory(SSLContext sslContext) {
        SSLEngine engine = sslContext.createSSLEngine();
        engine.setUseClientMode(false);
        return engine;
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/ServerTlsChannel$Builder.class */
    public static class Builder extends TlsChannelBuilder<Builder> {
        private final SslContextStrategy internalSslContextFactory;
        private Function<SSLContext, SSLEngine> sslEngineFactory;

        private Builder(ByteChannel underlying, SSLContext sslContext) {
            super(underlying);
            this.sslEngineFactory = x$0 -> {
                return ServerTlsChannel.defaultSSLEngineFactory(x$0);
            };
            this.internalSslContextFactory = new FixedSslContextStrategy(sslContext);
        }

        private Builder(ByteChannel wrapped, SniSslContextFactory sslContextFactory) {
            super(wrapped);
            this.sslEngineFactory = x$0 -> {
                return ServerTlsChannel.defaultSSLEngineFactory(x$0);
            };
            this.internalSslContextFactory = new SniSslContextStrategy(sslContextFactory);
        }

        /* access modifiers changed from: package-private */
        @Override // com.mongodb.internal.connection.tlschannel.TlsChannelBuilder
        public Builder getThis() {
            return this;
        }

        public Builder withEngineFactory(Function<SSLContext, SSLEngine> sslEngineFactory) {
            this.sslEngineFactory = sslEngineFactory;
            return this;
        }

        public ServerTlsChannel build() {
            return new ServerTlsChannel(this.underlying, this.internalSslContextFactory, this.sslEngineFactory, this.sessionInitCallback, this.runTasks, this.plainBufferAllocator, this.encryptedBufferAllocator, this.releaseBuffers, this.waitForCloseConfirmation);
        }
    }

    public static Builder newBuilder(ByteChannel underlying, SSLContext sslContext) {
        return new Builder(underlying, sslContext);
    }

    public static Builder newBuilder(ByteChannel underlying, SniSslContextFactory sslContextFactory) {
        return new Builder(underlying, sslContextFactory);
    }

    private ServerTlsChannel(ByteChannel underlying, SslContextStrategy internalSslContextFactory, Function<SSLContext, SSLEngine> engineFactory, Consumer<SSLSession> sessionInitCallback, boolean runTasks, BufferAllocator plainBufAllocator, BufferAllocator encryptedBufAllocator, boolean releaseBuffers, boolean waitForCloseConfirmation) {
        this.initLock = new ReentrantLock();
        this.sniRead = false;
        this.sslContext = null;
        this.impl = null;
        this.underlying = underlying;
        this.sslContextStrategy = internalSslContextFactory;
        this.engineFactory = engineFactory;
        this.sessionInitCallback = sessionInitCallback;
        this.runTasks = runTasks;
        this.plainBufAllocator = new TrackingAllocator(plainBufAllocator);
        this.encryptedBufAllocator = new TrackingAllocator(encryptedBufAllocator);
        this.releaseBuffers = releaseBuffers;
        this.waitForCloseConfirmation = waitForCloseConfirmation;
        this.inEncrypted = new BufferHolder("inEncrypted", Optional.empty(), encryptedBufAllocator, 4096, TlsChannelImpl.maxTlsPacketSize, false, releaseBuffers);
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public ByteChannel getUnderlying() {
        return this.underlying;
    }

    public SSLContext getSslContext() {
        return this.sslContext;
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public SSLEngine getSslEngine() {
        if (this.impl == null) {
            return null;
        }
        return this.impl.engine();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public Consumer<SSLSession> getSessionInitCallback() {
        return this.sessionInitCallback;
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean getRunTasks() {
        return this.impl.getRunTasks();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public TrackingAllocator getPlainBufferAllocator() {
        return this.plainBufAllocator;
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public TrackingAllocator getEncryptedBufferAllocator() {
        return this.encryptedBufAllocator;
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] dstBuffers, int offset, int length) throws IOException {
        ByteBufferSet dest = new ByteBufferSet(dstBuffers, offset, length);
        TlsChannelImpl.checkReadBuffer(dest);
        if (!this.sniRead) {
            try {
                initEngine();
            } catch (TlsChannelImpl.EofException e) {
                return -1;
            }
        }
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
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        ByteBufferSet source = new ByteBufferSet(srcs, offset, length);
        if (!this.sniRead) {
            try {
                initEngine();
            } catch (TlsChannelImpl.EofException e) {
                throw new ClosedChannelException();
            }
        }
        return this.impl.write(source);
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] srcs) throws IOException {
        return write(srcs, 0, srcs.length);
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer srcBuffer) throws IOException {
        return (int) write(new ByteBuffer[]{srcBuffer});
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public void renegotiate() throws IOException {
        if (!this.sniRead) {
            try {
                initEngine();
            } catch (TlsChannelImpl.EofException e) {
                throw new ClosedChannelException();
            }
        }
        this.impl.renegotiate();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public void handshake() throws IOException {
        if (!this.sniRead) {
            try {
                initEngine();
            } catch (TlsChannelImpl.EofException e) {
                throw new ClosedChannelException();
            }
        }
        this.impl.handshake();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.impl != null) {
            this.impl.close();
        }
        if (this.inEncrypted != null) {
            this.inEncrypted.dispose();
        }
        this.underlying.close();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.underlying.isOpen();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0037
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void initEngine() throws java.io.IOException, com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.EofException {
        /*
            r14 = this;
            r0 = r14
            java.util.concurrent.locks.Lock r0 = r0.initLock
            r0.lock()
            r0 = r14
            boolean r0 = r0.sniRead     // Catch: all -> 0x0097
            if (r0 != 0) goto L_0x008b
            r0 = r14
            r1 = r14
            com.mongodb.internal.connection.tlschannel.ServerTlsChannel$SslContextStrategy r1 = r1.sslContextStrategy     // Catch: all -> 0x0097
            r2 = r14
            void r2 = this::getServerNameIndication     // Catch: all -> 0x0097
            javax.net.ssl.SSLContext r1 = r1.getSslContext(r2)     // Catch: all -> 0x0097
            r0.sslContext = r1     // Catch: all -> 0x0097
            r0 = r14
            java.util.function.Function<javax.net.ssl.SSLContext, javax.net.ssl.SSLEngine> r0 = r0.engineFactory     // Catch: all -> 0x0097, Exception -> 0x0037
            r1 = r14
            javax.net.ssl.SSLContext r1 = r1.sslContext     // Catch: all -> 0x0097, Exception -> 0x0037
            java.lang.Object r0 = r0.apply(r1)     // Catch: all -> 0x0097, Exception -> 0x0037
            javax.net.ssl.SSLEngine r0 = (javax.net.ssl.SSLEngine) r0     // Catch: all -> 0x0097, Exception -> 0x0037
            r15 = r0
            goto L_0x004e
        L_0x0037:
            r16 = move-exception
            org.slf4j.Logger r0 = com.mongodb.internal.connection.tlschannel.ServerTlsChannel.logger     // Catch: all -> 0x0097
            java.lang.String r1 = "client threw exception in SSLEngine factory"
            r2 = r16
            r0.trace(r1, r2)     // Catch: all -> 0x0097
            com.mongodb.internal.connection.tlschannel.TlsChannelCallbackException r0 = new com.mongodb.internal.connection.tlschannel.TlsChannelCallbackException     // Catch: all -> 0x0097
            r1 = r0
            java.lang.String r2 = "SSLEngine creation callback failed"
            r3 = r16
            r1.<init>(r2, r3)     // Catch: all -> 0x0097
            throw r0     // Catch: all -> 0x0097
        L_0x004e:
            r0 = r14
            com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl r1 = new com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl     // Catch: all -> 0x0097
            r2 = r1
            r3 = r14
            java.nio.channels.ByteChannel r3 = r3.underlying     // Catch: all -> 0x0097
            r4 = r14
            java.nio.channels.ByteChannel r4 = r4.underlying     // Catch: all -> 0x0097
            r5 = r15
            r6 = r14
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r6 = r6.inEncrypted     // Catch: all -> 0x0097
            java.util.Optional r6 = java.util.Optional.of(r6)     // Catch: all -> 0x0097
            r7 = r14
            java.util.function.Consumer<javax.net.ssl.SSLSession> r7 = r7.sessionInitCallback     // Catch: all -> 0x0097
            r8 = r14
            boolean r8 = r8.runTasks     // Catch: all -> 0x0097
            r9 = r14
            com.mongodb.internal.connection.tlschannel.TrackingAllocator r9 = r9.plainBufAllocator     // Catch: all -> 0x0097
            r10 = r14
            com.mongodb.internal.connection.tlschannel.TrackingAllocator r10 = r10.encryptedBufAllocator     // Catch: all -> 0x0097
            r11 = r14
            boolean r11 = r11.releaseBuffers     // Catch: all -> 0x0097
            r12 = r14
            boolean r12 = r12.waitForCloseConfirmation     // Catch: all -> 0x0097
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: all -> 0x0097
            r0.impl = r1     // Catch: all -> 0x0097
            r0 = r14
            r1 = 0
            r0.inEncrypted = r1     // Catch: all -> 0x0097
            r0 = r14
            r1 = 1
            r0.sniRead = r1     // Catch: all -> 0x0097
        L_0x008b:
            r0 = r14
            java.util.concurrent.locks.Lock r0 = r0.initLock
            r0.unlock()
            goto L_0x00a3
        L_0x0097:
            r17 = move-exception
            r0 = r14
            java.util.concurrent.locks.Lock r0 = r0.initLock
            r0.unlock()
            r0 = r17
            throw r0
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.ServerTlsChannel.initEngine():void");
    }

    private Optional<SNIServerName> getServerNameIndication() throws IOException, TlsChannelImpl.EofException {
        this.inEncrypted.prepare();
        try {
            int recordHeaderSize = readRecordHeaderSize();
            while (this.inEncrypted.buffer.position() < recordHeaderSize) {
                if (!this.inEncrypted.buffer.hasRemaining()) {
                    this.inEncrypted.enlarge();
                }
                TlsChannelImpl.readFromChannel(this.underlying, this.inEncrypted.buffer);
            }
            this.inEncrypted.buffer.flip();
            Map<Integer, SNIServerName> serverNames = TlsExplorer.explore(this.inEncrypted.buffer);
            this.inEncrypted.buffer.compact();
            SNIServerName hostName = serverNames.get(0);
            if (hostName == null || !(hostName instanceof SNIHostName)) {
                Optional<SNIServerName> empty = Optional.empty();
                this.inEncrypted.release();
                return empty;
            }
            Optional<SNIServerName> of = Optional.of((SNIHostName) hostName);
            this.inEncrypted.release();
            return of;
        } catch (Throwable th) {
            this.inEncrypted.release();
            throw th;
        }
    }

    private int readRecordHeaderSize() throws IOException, TlsChannelImpl.EofException {
        while (this.inEncrypted.buffer.position() < 5) {
            if (!this.inEncrypted.buffer.hasRemaining()) {
                throw new IllegalStateException("inEncrypted too small");
            }
            TlsChannelImpl.readFromChannel(this.underlying, this.inEncrypted.buffer);
        }
        this.inEncrypted.buffer.flip();
        int recordHeaderSize = TlsExplorer.getRequiredSize(this.inEncrypted.buffer);
        this.inEncrypted.buffer.compact();
        return recordHeaderSize;
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean shutdown() throws IOException {
        return this.impl != null && this.impl.shutdown();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean shutdownReceived() {
        return this.impl != null && this.impl.shutdownReceived();
    }

    @Override // com.mongodb.internal.connection.tlschannel.TlsChannel
    public boolean shutdownSent() {
        return this.impl != null && this.impl.shutdownSent();
    }
}
