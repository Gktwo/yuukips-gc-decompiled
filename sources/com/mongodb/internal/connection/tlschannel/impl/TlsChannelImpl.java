package com.mongodb.internal.connection.tlschannel.impl;

import com.mongodb.internal.connection.tlschannel.NeedsReadException;
import com.mongodb.internal.connection.tlschannel.NeedsTaskException;
import com.mongodb.internal.connection.tlschannel.NeedsWriteException;
import com.mongodb.internal.connection.tlschannel.TrackingAllocator;
import com.mongodb.internal.connection.tlschannel.WouldBlockException;
import com.mongodb.internal.connection.tlschannel.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p013io.netty.handler.ssl.SslProtocols;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/TlsChannelImpl.class */
public class TlsChannelImpl implements ByteChannel {
    private static final Logger logger = LoggerFactory.getLogger(TlsChannelImpl.class);
    public static final int buffersInitialSize = 4096;
    public static final int maxTlsPacketSize = 17408;
    private final ReadableByteChannel readChannel;
    private final WritableByteChannel writeChannel;
    private final SSLEngine engine;
    private BufferHolder inEncrypted;
    private final Consumer<SSLSession> initSessionCallback;
    private final boolean runTasks;
    private final TrackingAllocator encryptedBufAllocator;
    private final TrackingAllocator plainBufAllocator;
    private final boolean waitForCloseConfirmation;
    private BufferHolder inPlain;
    private BufferHolder outEncrypted;
    private final Lock initLock = new ReentrantLock();
    private final Lock readLock = new ReentrantLock();
    private final Lock writeLock = new ReentrantLock();
    private volatile boolean negotiated = false;
    private volatile boolean invalid = false;
    private volatile boolean shutdownSent = false;
    private volatile boolean shutdownReceived = false;
    private final ByteBufferSet dummyOut = new ByteBufferSet(new ByteBuffer[]{ByteBuffer.allocate(0)});

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/TlsChannelImpl$UnwrapResult.class */
    public static class UnwrapResult {
        public final int bytesProduced;
        public final SSLEngineResult.HandshakeStatus lastHandshakeStatus;
        public final boolean wasClosed;

        public UnwrapResult(int bytesProduced, SSLEngineResult.HandshakeStatus lastHandshakeStatus, boolean wasClosed) {
            this.bytesProduced = bytesProduced;
            this.lastHandshakeStatus = lastHandshakeStatus;
            this.wasClosed = wasClosed;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/TlsChannelImpl$WrapResult.class */
    public static class WrapResult {
        public final int bytesConsumed;
        public final SSLEngineResult.HandshakeStatus lastHandshakeStatus;

        public WrapResult(int bytesConsumed, SSLEngineResult.HandshakeStatus lastHandshakeStatus) {
            this.bytesConsumed = bytesConsumed;
            this.lastHandshakeStatus = lastHandshakeStatus;
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/TlsChannelImpl$EofException.class */
    public static class EofException extends Exception {
        private static final long serialVersionUID = -3859156713994602991L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public TlsChannelImpl(ReadableByteChannel readChannel, WritableByteChannel writeChannel, SSLEngine engine, Optional<BufferHolder> inEncrypted, Consumer<SSLSession> initSessionCallback, boolean runTasks, TrackingAllocator plainBufAllocator, TrackingAllocator encryptedBufAllocator, boolean releaseBuffers, boolean waitForCloseConfirmation) {
        this.readChannel = readChannel;
        this.writeChannel = writeChannel;
        this.engine = engine;
        this.inEncrypted = inEncrypted.orElseGet(() -> {
            return new BufferHolder("inEncrypted", Optional.empty(), encryptedBufAllocator, 4096, maxTlsPacketSize, false, releaseBuffers);
        });
        this.initSessionCallback = initSessionCallback;
        this.runTasks = runTasks;
        this.plainBufAllocator = plainBufAllocator;
        this.encryptedBufAllocator = encryptedBufAllocator;
        this.waitForCloseConfirmation = waitForCloseConfirmation;
        this.inPlain = new BufferHolder("inPlain", Optional.empty(), plainBufAllocator, 4096, maxTlsPacketSize, true, releaseBuffers);
        this.outEncrypted = new BufferHolder("outEncrypted", Optional.empty(), encryptedBufAllocator, 4096, maxTlsPacketSize, false, releaseBuffers);
    }

    public Consumer<SSLSession> getSessionInitCallback() {
        return this.initSessionCallback;
    }

    public TrackingAllocator getPlainBufferAllocator() {
        return this.plainBufAllocator;
    }

    public TrackingAllocator getEncryptedBufferAllocator() {
        return this.encryptedBufAllocator;
    }

    public long read(ByteBufferSet dest) throws IOException, NeedsTaskException {
        checkReadBuffer(dest);
        if (!dest.hasRemaining()) {
            return 0;
        }
        handshake();
        this.readLock.lock();
        try {
            if (this.invalid || this.shutdownSent) {
                throw new ClosedChannelException();
            }
            SSLEngineResult.HandshakeStatus handshakeStatus = this.engine.getHandshakeStatus();
            int bytesToReturn = this.inPlain.nullOrEmpty() ? 0 : this.inPlain.buffer.position();
            while (bytesToReturn <= 0) {
                if (this.shutdownReceived) {
                    this.readLock.unlock();
                    return -1;
                }
                Util.assertTrue(this.inPlain.nullOrEmpty());
                switch (C10951.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()]) {
                    case 1:
                    case 2:
                        bytesToReturn = handshake(Optional.of(dest), Optional.of(handshakeStatus));
                        handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                        break;
                    case 3:
                    case 4:
                        UnwrapResult res = readAndUnwrap(Optional.of(dest));
                        if (!res.wasClosed) {
                            bytesToReturn = res.bytesProduced;
                            handshakeStatus = res.lastHandshakeStatus;
                            break;
                        } else {
                            this.readLock.unlock();
                            return -1;
                        }
                    case 5:
                        handleTask();
                        handshakeStatus = this.engine.getHandshakeStatus();
                        break;
                    default:
                        this.readLock.unlock();
                        return -1;
                }
            }
            if (this.inPlain.nullOrEmpty()) {
                long j = (long) bytesToReturn;
                this.readLock.unlock();
                return j;
            }
            long transferPendingPlain = (long) transferPendingPlain(dest);
            this.readLock.unlock();
            return transferPendingPlain;
        } catch (EofException e) {
            this.readLock.unlock();
            return -1;
        } catch (Throwable th) {
            this.readLock.unlock();
            throw th;
        }
    }

    private void handleTask() throws NeedsTaskException {
        if (this.runTasks) {
            this.engine.getDelegatedTask().run();
            return;
        }
        throw new NeedsTaskException(this.engine.getDelegatedTask());
    }

    private int transferPendingPlain(ByteBufferSet dstBuffers) {
        this.inPlain.buffer.flip();
        int bytes = dstBuffers.putRemaining(this.inPlain.buffer);
        this.inPlain.buffer.compact();
        if (!this.inPlain.release()) {
            this.inPlain.zeroRemaining();
        }
        return bytes;
    }

    private UnwrapResult unwrapLoop(Optional<ByteBufferSet> dest, SSLEngineResult.HandshakeStatus originalStatus) throws SSLException {
        SSLEngineResult result;
        ByteBufferSet effDest = dest.orElseGet(() -> {
            this.inPlain.prepare();
            return new ByteBufferSet(this.inPlain.buffer);
        });
        while (true) {
            Util.assertTrue(this.inPlain.nullOrEmpty());
            result = callEngineUnwrap(effDest);
            if (result.bytesProduced() > 0 || result.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW || result.getStatus() == SSLEngineResult.Status.CLOSED || result.getHandshakeStatus() != originalStatus) {
                break;
            } else if (result.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                if (!dest.isPresent() || effDest != dest.get()) {
                    this.inPlain.enlarge();
                } else {
                    this.inPlain.prepare();
                    ensureInPlainCapacity(Math.min(((int) dest.get().remaining()) * 2, (int) maxTlsPacketSize));
                }
                effDest = new ByteBufferSet(this.inPlain.buffer);
            }
        }
        return new UnwrapResult(result.bytesProduced(), result.getHandshakeStatus(), result.getStatus() == SSLEngineResult.Status.CLOSED);
    }

    private SSLEngineResult callEngineUnwrap(ByteBufferSet dest) throws SSLException {
        this.inEncrypted.buffer.flip();
        try {
            try {
                SSLEngineResult result = this.engine.unwrap(this.inEncrypted.buffer, dest.array, dest.offset, dest.length);
                if (logger.isTraceEnabled()) {
                    logger.trace("engine.unwrap() result [{}]. Engine status: {}; inEncrypted {}; inPlain: {}", Util.resultToString(result), result.getHandshakeStatus(), this.inEncrypted, dest);
                }
                return result;
            } catch (SSLException e) {
                this.invalid = true;
                throw e;
            }
        } finally {
            this.inEncrypted.buffer.compact();
        }
    }

    private int readFromChannel() throws IOException, EofException {
        try {
            return readFromChannel(this.readChannel, this.inEncrypted.buffer);
        } catch (WouldBlockException e) {
            throw e;
        } catch (IOException e2) {
            this.invalid = true;
            throw e2;
        }
    }

    public static int readFromChannel(ReadableByteChannel readChannel, ByteBuffer buffer) throws IOException, EofException {
        Util.assertTrue(buffer.hasRemaining());
        logger.trace("Reading from channel");
        int c = readChannel.read(buffer);
        logger.trace("Read from channel; response: {}, buffer: {}", Integer.valueOf(c), buffer);
        if (c == -1) {
            throw new EofException();
        } else if (c != 0) {
            return c;
        } else {
            throw new NeedsReadException();
        }
    }

    public long write(ByteBufferSet source) throws IOException {
        handshake();
        this.writeLock.lock();
        try {
            if (this.invalid || this.shutdownSent) {
                throw new ClosedChannelException();
            }
            long wrapAndWrite = wrapAndWrite(source);
            this.writeLock.unlock();
            return wrapAndWrite;
        } catch (Throwable th) {
            this.writeLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    private long wrapAndWrite(ByteBufferSet source) throws IOException {
        long bytesToConsume = source.remaining();
        char c = 0;
        this.outEncrypted.prepare();
        while (true) {
            try {
                writeToChannel();
                if (c == bytesToConsume) {
                    return bytesToConsume;
                }
                c += (long) wrapLoop(source).bytesConsumed;
            } finally {
                this.outEncrypted.release();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl$1 */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/TlsChannelImpl$1.class */
    public static /* synthetic */ class C10951 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status = new int[SSLEngineResult.Status.values().length];

        static {
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = new int[SSLEngineResult.HandshakeStatus.values().length];
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    private WrapResult wrapLoop(ByteBufferSet source) throws SSLException {
        while (true) {
            SSLEngineResult result = callEngineWrap(source);
            switch (C10951.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[result.getStatus().ordinal()]) {
                case 1:
                case 2:
                    return new WrapResult(result.bytesConsumed(), result.getHandshakeStatus());
                case 3:
                    Util.assertTrue(result.bytesConsumed() == 0);
                    this.outEncrypted.enlarge();
                    break;
                case 4:
                    throw new IllegalStateException();
            }
        }
    }

    private SSLEngineResult callEngineWrap(ByteBufferSet source) throws SSLException {
        try {
            SSLEngineResult result = this.engine.wrap(source.array, source.offset, source.length, this.outEncrypted.buffer);
            if (logger.isTraceEnabled()) {
                logger.trace("engine.wrap() result: [{}]; engine status: {}; srcBuffer: {}, outEncrypted: {}", Util.resultToString(result), result.getHandshakeStatus(), source, this.outEncrypted);
            }
            return result;
        } catch (SSLException e) {
            this.invalid = true;
            throw e;
        }
    }

    private void ensureInPlainCapacity(int newCapacity) {
        if (this.inPlain.buffer.capacity() < newCapacity) {
            logger.trace("inPlain buffer too small, increasing from {} to {}", Integer.valueOf(this.inPlain.buffer.capacity()), Integer.valueOf(newCapacity));
            this.inPlain.resize(newCapacity);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x002a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void writeToChannel() throws java.io.IOException {
        /*
            r3 = this;
            r0 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted
            java.nio.ByteBuffer r0 = r0.buffer
            int r0 = r0.position()
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            r0 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted
            java.nio.ByteBuffer r0 = r0.buffer
            java.nio.Buffer r0 = r0.flip()
            r0 = r3
            java.nio.channels.WritableByteChannel r0 = r0.writeChannel     // Catch: all -> 0x0043, WouldBlockException -> 0x002a, IOException -> 0x002d
            r1 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r1 = r1.outEncrypted     // Catch: all -> 0x0043, WouldBlockException -> 0x002a, IOException -> 0x002d
            java.nio.ByteBuffer r1 = r1.buffer     // Catch: all -> 0x0043, WouldBlockException -> 0x002a, IOException -> 0x002d
            writeToChannel(r0, r1)     // Catch: all -> 0x0043, WouldBlockException -> 0x002a, IOException -> 0x002d
            goto L_0x0035
        L_0x002a:
            r4 = move-exception
            r0 = r4
            throw r0     // Catch: all -> 0x0043
        L_0x002d:
            r4 = move-exception
            r0 = r3
            r1 = 1
            r0.invalid = r1     // Catch: all -> 0x0043
            r0 = r4
            throw r0     // Catch: all -> 0x0043
        L_0x0035:
            r0 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted
            java.nio.ByteBuffer r0 = r0.buffer
            java.nio.ByteBuffer r0 = r0.compact()
            goto L_0x0051
        L_0x0043:
            r5 = move-exception
            r0 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted
            java.nio.ByteBuffer r0 = r0.buffer
            java.nio.ByteBuffer r0 = r0.compact()
            r0 = r5
            throw r0
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.writeToChannel():void");
    }

    private static void writeToChannel(WritableByteChannel channel, ByteBuffer src) throws IOException {
        while (src.hasRemaining()) {
            logger.trace("Writing to channel: {}", src);
            if (channel.write(src) == 0) {
                throw new NeedsWriteException();
            }
        }
    }

    public void renegotiate() throws IOException {
        if (this.engine.getSession().getProtocol().compareTo(SslProtocols.TLS_v1_3) >= 0) {
            throw new SSLException("renegotiation not supported in TLS 1.3 or latter");
        }
        try {
            doHandshake(true);
        } catch (EofException e) {
            throw new ClosedChannelException();
        }
    }

    public void handshake() throws IOException {
        try {
            doHandshake(false);
        } catch (EofException e) {
            throw new ClosedChannelException();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x0065
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void doHandshake(boolean r6) throws java.io.IOException, com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.EofException {
        /*
            r5 = this;
            r0 = r6
            if (r0 != 0) goto L_0x000c
            r0 = r5
            boolean r0 = r0.negotiated
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.initLock
            r0.lock()
            r0 = r5
            boolean r0 = r0.invalid     // Catch: all -> 0x008d
            if (r0 != 0) goto L_0x0023
            r0 = r5
            boolean r0 = r0.shutdownSent     // Catch: all -> 0x008d
            if (r0 == 0) goto L_0x002b
        L_0x0023:
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException     // Catch: all -> 0x008d
            r1 = r0
            r1.<init>()     // Catch: all -> 0x008d
            throw r0     // Catch: all -> 0x008d
        L_0x002b:
            r0 = r6
            if (r0 != 0) goto L_0x0036
            r0 = r5
            boolean r0 = r0.negotiated     // Catch: all -> 0x008d
            if (r0 != 0) goto L_0x0081
        L_0x0036:
            r0 = r5
            javax.net.ssl.SSLEngine r0 = r0.engine     // Catch: all -> 0x008d
            r0.beginHandshake()     // Catch: all -> 0x008d
            org.slf4j.Logger r0 = com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.logger     // Catch: all -> 0x008d
            java.lang.String r1 = "Called engine.beginHandshake()"
            r0.trace(r1)     // Catch: all -> 0x008d
            r0 = r5
            java.util.Optional r1 = java.util.Optional.empty()     // Catch: all -> 0x008d
            java.util.Optional r2 = java.util.Optional.empty()     // Catch: all -> 0x008d
            int r0 = r0.handshake(r1, r2)     // Catch: all -> 0x008d
            r0 = r5
            java.util.function.Consumer<javax.net.ssl.SSLSession> r0 = r0.initSessionCallback     // Catch: all -> 0x008d, Exception -> 0x0065
            r1 = r5
            javax.net.ssl.SSLEngine r1 = r1.engine     // Catch: all -> 0x008d, Exception -> 0x0065
            javax.net.ssl.SSLSession r1 = r1.getSession()     // Catch: all -> 0x008d, Exception -> 0x0065
            r0.accept(r1)     // Catch: all -> 0x008d, Exception -> 0x0065
            goto L_0x007c
        L_0x0065:
            r7 = move-exception
            org.slf4j.Logger r0 = com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.logger     // Catch: all -> 0x008d
            java.lang.String r1 = "client code threw exception in session initialization callback"
            r2 = r7
            r0.trace(r1, r2)     // Catch: all -> 0x008d
            com.mongodb.internal.connection.tlschannel.TlsChannelCallbackException r0 = new com.mongodb.internal.connection.tlschannel.TlsChannelCallbackException     // Catch: all -> 0x008d
            r1 = r0
            java.lang.String r2 = "session initialization callback failed"
            r3 = r7
            r1.<init>(r2, r3)     // Catch: all -> 0x008d
            throw r0     // Catch: all -> 0x008d
        L_0x007c:
            r0 = r5
            r1 = 1
            r0.negotiated = r1     // Catch: all -> 0x008d
        L_0x0081:
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.initLock
            r0.unlock()
            goto L_0x0099
        L_0x008d:
            r8 = move-exception
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.initLock
            r0.unlock()
            r0 = r8
            throw r0
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.doHandshake(boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x004a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private int handshake(java.util.Optional<com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet> r5, java.util.Optional<javax.net.ssl.SSLEngineResult.HandshakeStatus> r6) throws java.io.IOException, com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.EofException {
        /*
            r4 = this;
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.lock()
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0.writeLock     // Catch: all -> 0x0065
            r0.lock()     // Catch: all -> 0x0065
            r0 = r4
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.inPlain     // Catch: all -> 0x0065, all -> 0x0057
            boolean r0 = r0.nullOrEmpty()     // Catch: all -> 0x0065, all -> 0x0057
            com.mongodb.internal.connection.tlschannel.util.Util.assertTrue(r0)     // Catch: all -> 0x0065, all -> 0x0057
            r0 = r4
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted     // Catch: all -> 0x0065, all -> 0x0057
            r0.prepare()     // Catch: all -> 0x0065, all -> 0x0057
            r0 = r4
            r0.writeToChannel()     // Catch: all -> 0x0065, all -> 0x0057, all -> 0x004a
            r0 = r4
            r1 = r5
            r2 = r6
            int r0 = r0.handshakeLoop(r1, r2)     // Catch: all -> 0x0065, all -> 0x0057, all -> 0x004a
            r7 = r0
            r0 = r4
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted     // Catch: all -> 0x0065, all -> 0x0057
            boolean r0 = r0.release()     // Catch: all -> 0x0065, all -> 0x0057
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0.writeLock     // Catch: all -> 0x0065
            r0.unlock()     // Catch: all -> 0x0065
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r7
            return r0
        L_0x004a:
            r8 = move-exception
            r0 = r4
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted     // Catch: all -> 0x0057, all -> 0x0065
            boolean r0 = r0.release()     // Catch: all -> 0x0057, all -> 0x0065
            r0 = r8
            throw r0     // Catch: all -> 0x0057, all -> 0x0065
        L_0x0057:
            r9 = move-exception
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0.writeLock     // Catch: all -> 0x0065
            r0.unlock()     // Catch: all -> 0x0065
            r0 = r9
            throw r0     // Catch: all -> 0x0065
        L_0x0065:
            r10 = move-exception
            r0 = r4
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.handshake(java.util.Optional, java.util.Optional):int");
    }

    private int handshakeLoop(Optional<ByteBufferSet> dest, Optional<SSLEngineResult.HandshakeStatus> handshakeStatus) throws IOException, EofException {
        Util.assertTrue(this.inPlain.nullOrEmpty());
        SSLEngineResult.HandshakeStatus status = handshakeStatus.orElseGet(() -> {
            return this.engine.getHandshakeStatus();
        });
        while (true) {
            switch (C10951.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[status.ordinal()]) {
                case 1:
                    UnwrapResult res = readAndUnwrap(dest);
                    status = res.lastHandshakeStatus;
                    if (res.bytesProduced <= 0) {
                        break;
                    } else {
                        return res.bytesProduced;
                    }
                case 2:
                    Util.assertTrue(this.outEncrypted.nullOrEmpty());
                    status = wrapLoop(this.dummyOut).lastHandshakeStatus;
                    writeToChannel();
                    break;
                case 3:
                    return 0;
                case 4:
                    return 0;
                case 5:
                    handleTask();
                    status = this.engine.getHandshakeStatus();
                    break;
                default:
                    return 0;
            }
        }
    }

    private UnwrapResult readAndUnwrap(Optional<ByteBufferSet> dest) throws IOException, EofException {
        UnwrapResult res;
        SSLEngineResult.HandshakeStatus orig = this.engine.getHandshakeStatus();
        this.inEncrypted.prepare();
        while (true) {
            try {
                Util.assertTrue(this.inPlain.nullOrEmpty());
                res = unwrapLoop(dest, orig);
                if (res.bytesProduced > 0 || res.lastHandshakeStatus != orig || res.wasClosed) {
                    break;
                }
                if (!this.inEncrypted.buffer.hasRemaining()) {
                    this.inEncrypted.enlarge();
                }
                readFromChannel();
            } finally {
                this.inEncrypted.release();
            }
        }
        if (res.wasClosed) {
            this.shutdownReceived = true;
        }
        return res;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        tryShutdown();
        this.writeChannel.close();
        this.readChannel.close();
        this.readLock.lock();
        try {
            this.writeLock.lock();
            freeBuffers();
            this.writeLock.unlock();
        } finally {
            this.readLock.unlock();
        }
    }

    private void tryShutdown() {
        if (this.readLock.tryLock()) {
            try {
                if (this.writeLock.tryLock()) {
                    if (!this.shutdownSent) {
                        try {
                            if (!shutdown() && this.waitForCloseConfirmation) {
                                shutdown();
                            }
                        } catch (Throwable e) {
                            logger.debug("error doing TLS shutdown on close(), continuing: {}", e.getMessage());
                        }
                    }
                    this.writeLock.unlock();
                }
            } finally {
                this.readLock.unlock();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0057
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public boolean shutdown() throws java.io.IOException {
        /*
            r3 = this;
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.lock()
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.writeLock     // Catch: all -> 0x00ce
            r0.lock()     // Catch: all -> 0x00ce
            r0 = r3
            boolean r0 = r0.invalid     // Catch: all -> 0x00c2, all -> 0x00ce
            if (r0 == 0) goto L_0x0021
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException     // Catch: all -> 0x00c2, all -> 0x00ce
            r1 = r0
            r1.<init>()     // Catch: all -> 0x00c2, all -> 0x00ce
            throw r0     // Catch: all -> 0x00c2, all -> 0x00ce
        L_0x0021:
            r0 = r3
            boolean r0 = r0.shutdownSent     // Catch: all -> 0x00c2, all -> 0x00ce
            if (r0 != 0) goto L_0x0086
            r0 = r3
            r1 = 1
            r0.shutdownSent = r1     // Catch: all -> 0x00c2, all -> 0x00ce
            r0 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted     // Catch: all -> 0x00c2, all -> 0x00ce
            r0.prepare()     // Catch: all -> 0x00c2, all -> 0x00ce
            r0 = r3
            r0.writeToChannel()     // Catch: all -> 0x00c2, all -> 0x0057, all -> 0x00ce
            r0 = r3
            javax.net.ssl.SSLEngine r0 = r0.engine     // Catch: all -> 0x00c2, all -> 0x0057, all -> 0x00ce
            r0.closeOutbound()     // Catch: all -> 0x00c2, all -> 0x0057, all -> 0x00ce
            r0 = r3
            r1 = r3
            com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet r1 = r1.dummyOut     // Catch: all -> 0x00c2, all -> 0x0057, all -> 0x00ce
            com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl$WrapResult r0 = r0.wrapLoop(r1)     // Catch: all -> 0x00c2, all -> 0x0057, all -> 0x00ce
            r0 = r3
            r0.writeToChannel()     // Catch: all -> 0x00c2, all -> 0x0057, all -> 0x00ce
            r0 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted     // Catch: all -> 0x00c2, all -> 0x00ce
            boolean r0 = r0.release()     // Catch: all -> 0x00c2, all -> 0x00ce
            goto L_0x0062
        L_0x0057:
            r4 = move-exception
            r0 = r3
            com.mongodb.internal.connection.tlschannel.impl.BufferHolder r0 = r0.outEncrypted     // Catch: all -> 0x00c2, all -> 0x00ce
            boolean r0 = r0.release()     // Catch: all -> 0x00c2, all -> 0x00ce
            r0 = r4
            throw r0     // Catch: all -> 0x00c2, all -> 0x00ce
        L_0x0062:
            r0 = r3
            boolean r0 = r0.shutdownReceived     // Catch: all -> 0x00c2, all -> 0x00ce
            if (r0 == 0) goto L_0x006d
            r0 = r3
            r0.freeBuffers()     // Catch: all -> 0x00c2, all -> 0x00ce
        L_0x006d:
            r0 = r3
            boolean r0 = r0.shutdownReceived     // Catch: all -> 0x00c2, all -> 0x00ce
            r4 = r0
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.writeLock     // Catch: all -> 0x00ce
            r0.unlock()     // Catch: all -> 0x00ce
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r4
            return r0
        L_0x0086:
            r0 = r3
            boolean r0 = r0.shutdownReceived     // Catch: all -> 0x00c2, all -> 0x00ce
            if (r0 != 0) goto L_0x00a8
            r0 = r3
            java.util.Optional r1 = java.util.Optional.empty()     // Catch: all -> 0x00c2, EofException -> 0x009f, all -> 0x00ce
            com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl$UnwrapResult r0 = r0.readAndUnwrap(r1)     // Catch: all -> 0x00c2, EofException -> 0x009f, all -> 0x00ce
            r0 = r3
            boolean r0 = r0.shutdownReceived     // Catch: all -> 0x00c2, EofException -> 0x009f, all -> 0x00ce
            com.mongodb.internal.connection.tlschannel.util.Util.assertTrue(r0)     // Catch: all -> 0x00c2, EofException -> 0x009f, all -> 0x00ce
            goto L_0x00a8
        L_0x009f:
            r4 = move-exception
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException     // Catch: all -> 0x00c2, all -> 0x00ce
            r1 = r0
            r1.<init>()     // Catch: all -> 0x00c2, all -> 0x00ce
            throw r0     // Catch: all -> 0x00c2, all -> 0x00ce
        L_0x00a8:
            r0 = r3
            r0.freeBuffers()     // Catch: all -> 0x00c2, all -> 0x00ce
            r0 = 1
            r4 = r0
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.writeLock     // Catch: all -> 0x00ce
            r0.unlock()     // Catch: all -> 0x00ce
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r4
            return r0
        L_0x00c2:
            r5 = move-exception
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.writeLock     // Catch: all -> 0x00ce
            r0.unlock()     // Catch: all -> 0x00ce
            r0 = r5
            throw r0     // Catch: all -> 0x00ce
        L_0x00ce:
            r6 = move-exception
            r0 = r3
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.impl.TlsChannelImpl.shutdown():boolean");
    }

    private void freeBuffers() {
        if (this.inEncrypted != null) {
            this.inEncrypted.dispose();
            this.inEncrypted = null;
        }
        if (this.inPlain != null) {
            this.inPlain.dispose();
            this.inPlain = null;
        }
        if (this.outEncrypted != null) {
            this.outEncrypted.dispose();
            this.outEncrypted = null;
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.invalid && this.writeChannel.isOpen() && this.readChannel.isOpen();
    }

    public static void checkReadBuffer(ByteBufferSet dest) {
        if (dest.isReadOnly()) {
            throw new IllegalArgumentException();
        }
    }

    public SSLEngine engine() {
        return this.engine;
    }

    public boolean getRunTasks() {
        return this.runTasks;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer dst) throws IOException {
        return (int) read(new ByteBufferSet(dst));
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws IOException {
        return (int) write(new ByteBufferSet(src));
    }

    public boolean shutdownReceived() {
        return this.shutdownReceived;
    }

    public boolean shutdownSent() {
        return this.shutdownSent;
    }

    public ReadableByteChannel plainReadableChannel() {
        return this.readChannel;
    }

    public WritableByteChannel plainWritableChannel() {
        return this.writeChannel;
    }
}
