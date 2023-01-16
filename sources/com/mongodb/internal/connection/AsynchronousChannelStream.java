package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.MongoInterruptedException;
import com.mongodb.MongoSocketReadException;
import com.mongodb.MongoSocketReadTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.AsyncCompletionHandler;
import com.mongodb.connection.SocketSettings;
import com.mongodb.connection.Stream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.bson.ByteBuf;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousChannelStream.class */
public abstract class AsynchronousChannelStream implements Stream {
    private final ServerAddress serverAddress;
    private final SocketSettings settings;
    private final PowerOfTwoBufferPool bufferProvider;
    private volatile ExtendedAsynchronousByteChannel channel;
    private volatile boolean isClosed;

    public AsynchronousChannelStream(ServerAddress serverAddress, SocketSettings settings, PowerOfTwoBufferPool bufferProvider) {
        this.serverAddress = serverAddress;
        this.settings = settings;
        this.bufferProvider = bufferProvider;
    }

    public ServerAddress getServerAddress() {
        return this.serverAddress;
    }

    public SocketSettings getSettings() {
        return this.settings;
    }

    public PowerOfTwoBufferPool getBufferProvider() {
        return this.bufferProvider;
    }

    public synchronized ExtendedAsynchronousByteChannel getChannel() {
        return this.channel;
    }

    protected synchronized void setChannel(ExtendedAsynchronousByteChannel channel) {
        Assertions.isTrue("current channel is null", this.channel == null);
        if (this.isClosed) {
            closeChannel(channel);
        } else {
            this.channel = channel;
        }
    }

    @Override // com.mongodb.connection.Stream
    public void writeAsync(List<ByteBuf> buffers, final AsyncCompletionHandler<Void> handler) {
        final AsyncWritableByteChannelAdapter byteChannel = new AsyncWritableByteChannelAdapter();
        final Iterator<ByteBuf> iter = buffers.iterator();
        pipeOneBuffer(byteChannel, iter.next(), new AsyncCompletionHandler<Void>() { // from class: com.mongodb.internal.connection.AsynchronousChannelStream.1
            public void completed(Void t) {
                if (iter.hasNext()) {
                    AsynchronousChannelStream.this.pipeOneBuffer(byteChannel, (ByteBuf) iter.next(), this);
                } else {
                    handler.completed(null);
                }
            }

            @Override // com.mongodb.connection.AsyncCompletionHandler
            public void failed(Throwable t) {
                handler.failed(t);
            }
        });
    }

    @Override // com.mongodb.connection.Stream
    public void readAsync(int numBytes, AsyncCompletionHandler<ByteBuf> handler) {
        readAsync(numBytes, 0, handler);
    }

    private void readAsync(int numBytes, int additionalTimeout, AsyncCompletionHandler<ByteBuf> handler) {
        ByteBuf buffer = this.bufferProvider.getBuffer(numBytes);
        int timeout = this.settings.getReadTimeout(TimeUnit.MILLISECONDS);
        if (timeout > 0 && additionalTimeout > 0) {
            timeout += additionalTimeout;
        }
        this.channel.read(buffer.asNIO(), (long) timeout, TimeUnit.MILLISECONDS, null, new BasicCompletionHandler(buffer, handler));
    }

    @Override // com.mongodb.connection.Stream
    public void open() throws IOException {
        FutureAsyncCompletionHandler<Void> handler = new FutureAsyncCompletionHandler<>();
        openAsync(handler);
        handler.getOpen();
    }

    @Override // com.mongodb.connection.Stream
    public void write(List<ByteBuf> buffers) throws IOException {
        FutureAsyncCompletionHandler<Void> handler = new FutureAsyncCompletionHandler<>();
        writeAsync(buffers, handler);
        handler.getWrite();
    }

    @Override // com.mongodb.connection.Stream
    public ByteBuf read(int numBytes) throws IOException {
        FutureAsyncCompletionHandler<ByteBuf> handler = new FutureAsyncCompletionHandler<>();
        readAsync(numBytes, handler);
        return handler.getRead();
    }

    @Override // com.mongodb.connection.Stream
    public boolean supportsAdditionalTimeout() {
        return true;
    }

    @Override // com.mongodb.connection.Stream
    public ByteBuf read(int numBytes, int additionalTimeout) throws IOException {
        FutureAsyncCompletionHandler<ByteBuf> handler = new FutureAsyncCompletionHandler<>();
        readAsync(numBytes, additionalTimeout, handler);
        return handler.getRead();
    }

    @Override // com.mongodb.connection.Stream
    public ServerAddress getAddress() {
        return this.serverAddress;
    }

    @Override // com.mongodb.connection.Stream
    public synchronized void close() {
        this.isClosed = true;
        try {
            closeChannel(this.channel);
        } finally {
            this.channel = null;
        }
    }

    private void closeChannel(ExtendedAsynchronousByteChannel channel) {
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.mongodb.connection.Stream
    public boolean isClosed() {
        return this.isClosed;
    }

    @Override // com.mongodb.connection.BufferProvider
    public ByteBuf getBuffer(int size) {
        return this.bufferProvider.getBuffer(size);
    }

    /* access modifiers changed from: private */
    public void pipeOneBuffer(final AsyncWritableByteChannelAdapter byteChannel, final ByteBuf byteBuffer, final AsyncCompletionHandler<Void> outerHandler) {
        byteChannel.write(byteBuffer.asNIO(), new AsyncCompletionHandler<Void>() { // from class: com.mongodb.internal.connection.AsynchronousChannelStream.2
            public void completed(Void t) {
                if (byteBuffer.hasRemaining()) {
                    byteChannel.write(byteBuffer.asNIO(), this);
                } else {
                    outerHandler.completed(null);
                }
            }

            @Override // com.mongodb.connection.AsyncCompletionHandler
            public void failed(Throwable t) {
                outerHandler.failed(t);
            }
        });
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousChannelStream$AsyncWritableByteChannelAdapter.class */
    public class AsyncWritableByteChannelAdapter {
        private AsyncWritableByteChannelAdapter() {
        }

        void write(ByteBuffer src, AsyncCompletionHandler<Void> handler) {
            AsynchronousChannelStream.this.channel.write(src, null, new WriteCompletionHandler(handler));
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousChannelStream$AsyncWritableByteChannelAdapter$WriteCompletionHandler.class */
        public class WriteCompletionHandler extends BaseCompletionHandler<Void, Integer, Object> {
            WriteCompletionHandler(AsyncCompletionHandler<Void> handler) {
                super(handler);
            }

            public void completed(Integer result, Object attachment) {
                getHandlerAndClear().completed(null);
            }

            @Override // java.nio.channels.CompletionHandler
            public void failed(Throwable exc, Object attachment) {
                getHandlerAndClear().failed(exc);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousChannelStream$BasicCompletionHandler.class */
    public final class BasicCompletionHandler extends BaseCompletionHandler<ByteBuf, Integer, Void> {
        private final AtomicReference<ByteBuf> byteBufReference;

        private BasicCompletionHandler(ByteBuf dst, AsyncCompletionHandler<ByteBuf> handler) {
            super(handler);
            this.byteBufReference = new AtomicReference<>(dst);
        }

        public void completed(Integer result, Void attachment) {
            AsyncCompletionHandler<ByteBuf> localHandler = getHandlerAndClear();
            ByteBuf localByteBuf = this.byteBufReference.getAndSet(null);
            if (result.intValue() == -1) {
                localByteBuf.release();
                localHandler.failed(new MongoSocketReadException("Prematurely reached end of stream", AsynchronousChannelStream.this.serverAddress));
            } else if (!localByteBuf.hasRemaining()) {
                localByteBuf.flip();
                localHandler.completed(localByteBuf);
            } else {
                AsynchronousChannelStream.this.channel.read(localByteBuf.asNIO(), (long) AsynchronousChannelStream.this.settings.getReadTimeout(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS, null, new BasicCompletionHandler(localByteBuf, localHandler));
            }
        }

        public void failed(Throwable t, Void attachment) {
            AsyncCompletionHandler<ByteBuf> localHandler = getHandlerAndClear();
            this.byteBufReference.getAndSet(null).release();
            if (t instanceof InterruptedByTimeoutException) {
                localHandler.failed(new MongoSocketReadTimeoutException("Timeout while receiving message", AsynchronousChannelStream.this.serverAddress, t));
            } else {
                localHandler.failed(t);
            }
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousChannelStream$BaseCompletionHandler.class */
    private static abstract class BaseCompletionHandler<T, V, A> implements CompletionHandler<V, A> {
        private final AtomicReference<AsyncCompletionHandler<T>> handlerReference;

        BaseCompletionHandler(AsyncCompletionHandler<T> handler) {
            this.handlerReference = new AtomicReference<>(handler);
        }

        AsyncCompletionHandler<T> getHandlerAndClear() {
            return this.handlerReference.getAndSet(null);
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsynchronousChannelStream$FutureAsyncCompletionHandler.class */
    static class FutureAsyncCompletionHandler<T> implements AsyncCompletionHandler<T> {
        private final CountDownLatch latch = new CountDownLatch(1);
        private volatile T result;
        private volatile Throwable error;

        FutureAsyncCompletionHandler() {
        }

        @Override // com.mongodb.connection.AsyncCompletionHandler
        public void completed(T result) {
            this.result = result;
            this.latch.countDown();
        }

        @Override // com.mongodb.connection.AsyncCompletionHandler
        public void failed(Throwable t) {
            this.error = t;
            this.latch.countDown();
        }

        void getOpen() throws IOException {
            get("Opening");
        }

        void getWrite() throws IOException {
            get("Writing to");
        }

        T getRead() throws IOException {
            return get("Reading from");
        }

        private T get(String prefix) throws IOException {
            try {
                this.latch.await();
                if (this.error == null) {
                    return this.result;
                }
                if (this.error instanceof IOException) {
                    throw ((IOException) this.error);
                } else if (this.error instanceof MongoException) {
                    throw ((MongoException) this.error);
                } else {
                    throw new MongoInternalException(prefix + " the TlsChannelStream failed", this.error);
                }
            } catch (InterruptedException e) {
                throw new MongoInterruptedException(prefix + " the AsynchronousSocketChannelStream failed", e);
            }
        }
    }
}
