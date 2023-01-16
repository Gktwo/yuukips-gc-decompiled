package com.mongodb.internal.connection;

import com.mongodb.MongoSocketException;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.AsyncCompletionHandler;
import com.mongodb.connection.SocketSettings;
import com.mongodb.connection.Stream;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousSocketChannelStream.class */
public final class AsynchronousSocketChannelStream extends AsynchronousChannelStream implements Stream {
    private final ServerAddress serverAddress;
    private final SocketSettings settings;
    private final AsynchronousChannelGroup group;

    public AsynchronousSocketChannelStream(ServerAddress serverAddress, SocketSettings settings, PowerOfTwoBufferPool bufferProvider, AsynchronousChannelGroup group) {
        super(serverAddress, settings, bufferProvider);
        this.serverAddress = serverAddress;
        this.settings = settings;
        this.group = group;
    }

    @Override // com.mongodb.connection.Stream
    public void openAsync(AsyncCompletionHandler<Void> handler) {
        Assertions.isTrue("unopened", getChannel() == null);
        try {
            initializeSocketChannel(handler, new LinkedList<>(this.serverAddress.getSocketAddresses()));
        } catch (Throwable t) {
            handler.failed(t);
        }
    }

    /* access modifiers changed from: private */
    public void initializeSocketChannel(AsyncCompletionHandler<Void> handler, Queue<SocketAddress> socketAddressQueue) {
        if (socketAddressQueue.isEmpty()) {
            handler.failed(new MongoSocketException("Exception opening socket", this.serverAddress));
            return;
        }
        SocketAddress socketAddress = socketAddressQueue.poll();
        try {
            AsynchronousSocketChannel attemptConnectionChannel = AsynchronousSocketChannel.open(this.group);
            attemptConnectionChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.TCP_NODELAY, (SocketOption) true);
            attemptConnectionChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_KEEPALIVE, (SocketOption) true);
            if (this.settings.getReceiveBufferSize() > 0) {
                attemptConnectionChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_RCVBUF, (SocketOption) Integer.valueOf(this.settings.getReceiveBufferSize()));
            }
            if (this.settings.getSendBufferSize() > 0) {
                attemptConnectionChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_SNDBUF, (SocketOption) Integer.valueOf(this.settings.getSendBufferSize()));
            }
            attemptConnectionChannel.connect(socketAddress, null, new OpenCompletionHandler(handler, socketAddressQueue, attemptConnectionChannel));
        } catch (IOException e) {
            handler.failed(new MongoSocketOpenException("Exception opening socket", this.serverAddress, e));
        } catch (Throwable t) {
            handler.failed(t);
        }
    }

    public AsynchronousChannelGroup getGroup() {
        return this.group;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousSocketChannelStream$OpenCompletionHandler.class */
    public class OpenCompletionHandler implements CompletionHandler<Void, Object> {
        private AtomicReference<AsyncCompletionHandler<Void>> handlerReference;
        private final Queue<SocketAddress> socketAddressQueue;
        private final AsynchronousSocketChannel attemptConnectionChannel;

        OpenCompletionHandler(AsyncCompletionHandler<Void> handler, Queue<SocketAddress> socketAddressQueue, AsynchronousSocketChannel attemptConnectionChannel) {
            this.handlerReference = new AtomicReference<>(handler);
            this.socketAddressQueue = socketAddressQueue;
            this.attemptConnectionChannel = attemptConnectionChannel;
        }

        public void completed(Void result, Object attachment) {
            AsynchronousSocketChannelStream.this.setChannel(new AsynchronousSocketChannelAdapter(this.attemptConnectionChannel));
            this.handlerReference.getAndSet(null).completed(null);
        }

        @Override // java.nio.channels.CompletionHandler
        public void failed(Throwable exc, Object attachment) {
            AsyncCompletionHandler<Void> localHandler = this.handlerReference.getAndSet(null);
            if (!this.socketAddressQueue.isEmpty()) {
                AsynchronousSocketChannelStream.this.initializeSocketChannel(localHandler, this.socketAddressQueue);
            } else if (exc instanceof IOException) {
                localHandler.failed(new MongoSocketOpenException("Exception opening socket", AsynchronousSocketChannelStream.this.getAddress(), exc));
            } else {
                localHandler.failed(exc);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousSocketChannelStream$AsynchronousSocketChannelAdapter.class */
    public static final class AsynchronousSocketChannelAdapter implements ExtendedAsynchronousByteChannel {
        private final AsynchronousSocketChannel channel;

        private AsynchronousSocketChannelAdapter(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
        public <A> void read(ByteBuffer dst, long timeout, TimeUnit unit, A attach, CompletionHandler<Integer, ? super A> handler) {
            this.channel.read(dst, timeout, unit, attach, handler);
        }

        @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
        public <A> void read(ByteBuffer[] dsts, int offset, int length, long timeout, TimeUnit unit, A attach, CompletionHandler<Long, ? super A> handler) {
            this.channel.read(dsts, offset, length, timeout, unit, attach, handler);
        }

        @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
        public <A> void write(ByteBuffer src, long timeout, TimeUnit unit, A attach, CompletionHandler<Integer, ? super A> handler) {
            this.channel.write(src, timeout, unit, attach, handler);
        }

        @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
        public <A> void write(ByteBuffer[] srcs, int offset, int length, long timeout, TimeUnit unit, A attach, CompletionHandler<Long, ? super A> handler) {
            this.channel.write(srcs, offset, length, timeout, unit, attach, handler);
        }

        @Override // java.nio.channels.AsynchronousByteChannel
        public <A> void read(ByteBuffer dst, A attachment, CompletionHandler<Integer, ? super A> handler) {
            this.channel.read(dst, attachment, handler);
        }

        @Override // java.nio.channels.AsynchronousByteChannel
        public Future<Integer> read(ByteBuffer dst) {
            return this.channel.read(dst);
        }

        @Override // java.nio.channels.AsynchronousByteChannel
        public <A> void write(ByteBuffer src, A attachment, CompletionHandler<Integer, ? super A> handler) {
            this.channel.write(src, attachment, handler);
        }

        @Override // java.nio.channels.AsynchronousByteChannel
        public Future<Integer> write(ByteBuffer src) {
            return this.channel.write(src);
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return this.channel.isOpen();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.AsynchronousChannel, java.nio.channels.Channel
        public void close() throws IOException {
            this.channel.close();
        }
    }
}
