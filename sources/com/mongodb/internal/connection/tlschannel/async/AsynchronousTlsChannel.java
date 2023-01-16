package com.mongodb.internal.connection.tlschannel.async;

import com.mongodb.internal.connection.tlschannel.TlsChannel;
import com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup;
import com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.SocketChannel;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.LongConsumer;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannel.class */
public class AsynchronousTlsChannel implements ExtendedAsynchronousByteChannel {
    private final AsynchronousTlsChannelGroup group;
    private final TlsChannel tlsChannel;
    private final AsynchronousTlsChannelGroup.RegisteredSocket registeredSocket;

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannel$FutureReadResult.class */
    private class FutureReadResult extends CompletableFuture<Integer> {

        /* renamed from: op */
        AsynchronousTlsChannelGroup.ReadOperation f457op;

        private FutureReadResult() {
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            cancel(mayInterruptIfRunning);
            return AsynchronousTlsChannel.this.group.doCancelRead(AsynchronousTlsChannel.this.registeredSocket, this.f457op);
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannel$FutureWriteResult.class */
    private class FutureWriteResult extends CompletableFuture<Integer> {

        /* renamed from: op */
        AsynchronousTlsChannelGroup.WriteOperation f458op;

        private FutureWriteResult() {
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            cancel(mayInterruptIfRunning);
            return AsynchronousTlsChannel.this.group.doCancelWrite(AsynchronousTlsChannel.this.registeredSocket, this.f458op);
        }
    }

    public AsynchronousTlsChannel(AsynchronousTlsChannelGroup channelGroup, TlsChannel tlsChannel, SocketChannel socketChannel) throws ClosedChannelException, IllegalArgumentException {
        if (!tlsChannel.isOpen() || !socketChannel.isOpen()) {
            throw new ClosedChannelException();
        } else if (socketChannel.isBlocking()) {
            throw new IllegalArgumentException("socket channel must be in non-blocking mode");
        } else {
            this.group = channelGroup;
            this.tlsChannel = tlsChannel;
            this.registeredSocket = channelGroup.registerSocket(tlsChannel, socketChannel);
        }
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public <A> void read(ByteBuffer dst, A attach, CompletionHandler<Integer, ? super A> handler) {
        checkReadOnly(dst);
        if (!dst.hasRemaining()) {
            completeWithZeroInt(attach, handler);
        } else {
            this.group.startRead(this.registeredSocket, new ByteBufferSet(dst), 0, TimeUnit.MILLISECONDS, c -> {
                this.group.executor.submit(() -> {
                    handler.completed(Integer.valueOf((int) attach), handler);
                });
            }, e -> {
                this.group.executor.submit(() -> {
                    handler.failed(attach, handler);
                });
            });
        }
    }

    @Override // com.mongodb.internal.connection.tlschannel.async.ExtendedAsynchronousByteChannel
    public <A> void read(ByteBuffer dst, long timeout, TimeUnit unit, A attach, CompletionHandler<Integer, ? super A> handler) {
        checkReadOnly(dst);
        if (!dst.hasRemaining()) {
            completeWithZeroInt(attach, handler);
        } else {
            this.group.startRead(this.registeredSocket, new ByteBufferSet(dst), timeout, unit, c -> {
                this.group.executor.submit(() -> {
                    handler.completed(Integer.valueOf((int) attach), handler);
                });
            }, e -> {
                this.group.executor.submit(() -> {
                    handler.failed(attach, handler);
                });
            });
        }
    }

    @Override // com.mongodb.internal.connection.tlschannel.async.ExtendedAsynchronousByteChannel
    public <A> void read(ByteBuffer[] dsts, int offset, int length, long timeout, TimeUnit unit, A attach, CompletionHandler<Long, ? super A> handler) {
        ByteBufferSet bufferSet = new ByteBufferSet(dsts, offset, length);
        if (bufferSet.isReadOnly()) {
            throw new IllegalArgumentException("buffer is read-only");
        } else if (!bufferSet.hasRemaining()) {
            completeWithZeroLong(attach, handler);
        } else {
            this.group.startRead(this.registeredSocket, bufferSet, timeout, unit, c -> {
                this.group.executor.submit(() -> {
                    handler.completed(Long.valueOf(attach), handler);
                });
            }, e -> {
                this.group.executor.submit(() -> {
                    handler.failed(attach, handler);
                });
            });
        }
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public Future<Integer> read(ByteBuffer dst) {
        checkReadOnly(dst);
        if (!dst.hasRemaining()) {
            return CompletableFuture.completedFuture(0);
        }
        FutureReadResult future = new FutureReadResult();
        AsynchronousTlsChannelGroup asynchronousTlsChannelGroup = this.group;
        AsynchronousTlsChannelGroup.RegisteredSocket registeredSocket = this.registeredSocket;
        ByteBufferSet byteBufferSet = new ByteBufferSet(dst);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LongConsumer r5 = c -> {
            future.complete(Integer.valueOf((int) c));
        };
        Objects.requireNonNull(future);
        future.f457op = asynchronousTlsChannelGroup.startRead(registeredSocket, byteBufferSet, 0, timeUnit, r5, this::completeExceptionally);
        return future;
    }

    private void checkReadOnly(ByteBuffer dst) {
        if (dst.isReadOnly()) {
            throw new IllegalArgumentException("buffer is read-only");
        }
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public <A> void write(ByteBuffer src, A attach, CompletionHandler<Integer, ? super A> handler) {
        if (!src.hasRemaining()) {
            completeWithZeroInt(attach, handler);
        } else {
            this.group.startWrite(this.registeredSocket, new ByteBufferSet(src), 0, TimeUnit.MILLISECONDS, c -> {
                this.group.executor.submit(() -> {
                    handler.completed(Integer.valueOf((int) attach), handler);
                });
            }, e -> {
                this.group.executor.submit(() -> {
                    handler.failed(attach, handler);
                });
            });
        }
    }

    @Override // com.mongodb.internal.connection.tlschannel.async.ExtendedAsynchronousByteChannel
    public <A> void write(ByteBuffer src, long timeout, TimeUnit unit, A attach, CompletionHandler<Integer, ? super A> handler) {
        if (!src.hasRemaining()) {
            completeWithZeroInt(attach, handler);
        } else {
            this.group.startWrite(this.registeredSocket, new ByteBufferSet(src), timeout, unit, c -> {
                this.group.executor.submit(() -> {
                    handler.completed(Integer.valueOf((int) attach), handler);
                });
            }, e -> {
                this.group.executor.submit(() -> {
                    handler.failed(attach, handler);
                });
            });
        }
    }

    @Override // com.mongodb.internal.connection.tlschannel.async.ExtendedAsynchronousByteChannel
    public <A> void write(ByteBuffer[] srcs, int offset, int length, long timeout, TimeUnit unit, A attach, CompletionHandler<Long, ? super A> handler) {
        ByteBufferSet bufferSet = new ByteBufferSet(srcs, offset, length);
        if (!bufferSet.hasRemaining()) {
            completeWithZeroLong(attach, handler);
        } else {
            this.group.startWrite(this.registeredSocket, bufferSet, timeout, unit, c -> {
                this.group.executor.submit(() -> {
                    handler.completed(Long.valueOf(attach), handler);
                });
            }, e -> {
                this.group.executor.submit(() -> {
                    handler.failed(attach, handler);
                });
            });
        }
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public Future<Integer> write(ByteBuffer src) {
        if (!src.hasRemaining()) {
            return CompletableFuture.completedFuture(0);
        }
        FutureWriteResult future = new FutureWriteResult();
        AsynchronousTlsChannelGroup asynchronousTlsChannelGroup = this.group;
        AsynchronousTlsChannelGroup.RegisteredSocket registeredSocket = this.registeredSocket;
        ByteBufferSet byteBufferSet = new ByteBufferSet(src);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LongConsumer r5 = c -> {
            future.complete(Integer.valueOf((int) c));
        };
        Objects.requireNonNull(future);
        future.f458op = asynchronousTlsChannelGroup.startWrite(registeredSocket, byteBufferSet, 0, timeUnit, r5, this::completeExceptionally);
        return future;
    }

    private <A> void completeWithZeroInt(A attach, CompletionHandler<Integer, ? super A> handler) {
        this.group.executor.submit(() -> {
            handler.completed(0, attach);
        });
    }

    private <A> void completeWithZeroLong(A attach, CompletionHandler<Long, ? super A> handler) {
        this.group.executor.submit(() -> {
            handler.completed(0L, attach);
        });
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.tlsChannel.isOpen();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.AsynchronousChannel, java.nio.channels.Channel
    public void close() throws IOException {
        this.tlsChannel.close();
        this.registeredSocket.close();
    }
}
