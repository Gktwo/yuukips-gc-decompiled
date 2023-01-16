package com.mongodb.connection.netty;

import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.MongoInterruptedException;
import com.mongodb.MongoSocketException;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoSocketReadTimeoutException;
import com.mongodb.ServerAddress;
import com.mongodb.annotations.ThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.AsyncCompletionHandler;
import com.mongodb.connection.SocketSettings;
import com.mongodb.connection.SslSettings;
import com.mongodb.connection.Stream;
import com.mongodb.internal.connection.SslHelper;
import com.mongodb.lang.Nullable;
import java.io.IOException;
import java.net.SocketAddress;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import p013io.netty.bootstrap.Bootstrap;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.CompositeByteBuf;
import p013io.netty.buffer.PooledByteBufAllocator;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.channel.ChannelInitializer;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.channel.SimpleChannelInboundHandler;
import p013io.netty.channel.socket.SocketChannel;
import p013io.netty.handler.ssl.SslHandler;
import p013io.netty.handler.timeout.ReadTimeoutException;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/connection/netty/NettyStream.class */
public final class NettyStream implements Stream {
    private static final byte NO_SCHEDULE_TIME = 0;
    private final ServerAddress address;
    private final SocketSettings settings;
    private final SslSettings sslSettings;
    private final EventLoopGroup workerGroup;
    private final Class<? extends SocketChannel> socketChannelClass;
    private final ByteBufAllocator allocator;
    private boolean isClosed;
    private volatile Channel channel;
    private PendingReader pendingReader;
    private Throwable pendingException;
    @Nullable
    private ReadTimeoutTask readTimeoutTask;
    private final LinkedList<ByteBuf> pendingInboundBuffers = new LinkedList<>();
    private long readTimeoutMillis = 0;

    /* access modifiers changed from: package-private */
    public NettyStream(ServerAddress address, SocketSettings settings, SslSettings sslSettings, EventLoopGroup workerGroup, Class<? extends SocketChannel> socketChannelClass, ByteBufAllocator allocator) {
        this.address = address;
        this.settings = settings;
        this.sslSettings = sslSettings;
        this.workerGroup = workerGroup;
        this.socketChannelClass = socketChannelClass;
        this.allocator = allocator;
    }

    @Override // com.mongodb.connection.BufferProvider
    public org.bson.ByteBuf getBuffer(int size) {
        return new NettyByteBuf(this.allocator.buffer(size, size));
    }

    @Override // com.mongodb.connection.Stream
    public void open() throws IOException {
        FutureAsyncCompletionHandler<Void> handler = new FutureAsyncCompletionHandler<>();
        openAsync(handler);
        handler.get();
    }

    @Override // com.mongodb.connection.Stream
    public void openAsync(AsyncCompletionHandler<Void> handler) {
        try {
            initializeChannel(handler, new LinkedList<>(this.address.getSocketAddresses()));
        } catch (Throwable t) {
            handler.failed(t);
        }
    }

    /* access modifiers changed from: private */
    public void initializeChannel(AsyncCompletionHandler<Void> handler, Queue<SocketAddress> socketAddressQueue) {
        if (socketAddressQueue.isEmpty()) {
            handler.failed(new MongoSocketException("Exception opening socket", getAddress()));
            return;
        }
        SocketAddress nextAddress = socketAddressQueue.poll();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(this.workerGroup);
        bootstrap.channel(this.socketChannelClass);
        bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Integer.valueOf(this.settings.getConnectTimeout(TimeUnit.MILLISECONDS)));
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        if (this.settings.getReceiveBufferSize() > 0) {
            bootstrap.option(ChannelOption.SO_RCVBUF, Integer.valueOf(this.settings.getReceiveBufferSize()));
        }
        if (this.settings.getSendBufferSize() > 0) {
            bootstrap.option(ChannelOption.SO_SNDBUF, Integer.valueOf(this.settings.getSendBufferSize()));
        }
        bootstrap.option(ChannelOption.ALLOCATOR, this.allocator);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() { // from class: com.mongodb.connection.netty.NettyStream.1
            public void initChannel(SocketChannel ch) {
                ChannelPipeline pipeline = ch.pipeline();
                if (NettyStream.this.sslSettings.isEnabled()) {
                    SSLEngine engine = NettyStream.this.getSslContext().createSSLEngine(NettyStream.this.address.getHost(), NettyStream.this.address.getPort());
                    engine.setUseClientMode(true);
                    SSLParameters sslParameters = engine.getSSLParameters();
                    SslHelper.enableSni(NettyStream.this.address.getHost(), sslParameters);
                    if (!NettyStream.this.sslSettings.isInvalidHostNameAllowed()) {
                        SslHelper.enableHostNameVerification(sslParameters);
                    }
                    engine.setSSLParameters(sslParameters);
                    pipeline.addFirst("ssl", new SslHandler(engine, false));
                }
                int readTimeout = NettyStream.this.settings.getReadTimeout(TimeUnit.MILLISECONDS);
                if (readTimeout > 0) {
                    NettyStream.this.readTimeoutMillis = (long) readTimeout;
                    pipeline.addLast(new ChannelInboundHandlerAdapter());
                    NettyStream.this.readTimeoutTask = new ReadTimeoutTask(pipeline.lastContext());
                }
                pipeline.addLast(new InboundBufferHandler());
            }
        });
        ChannelFuture channelFuture = bootstrap.connect(nextAddress);
        channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new OpenChannelFutureListener(socketAddressQueue, channelFuture, handler));
    }

    @Override // com.mongodb.connection.Stream
    public void write(List<org.bson.ByteBuf> buffers) throws IOException {
        FutureAsyncCompletionHandler<Void> future = new FutureAsyncCompletionHandler<>();
        writeAsync(buffers, future);
        future.get();
    }

    @Override // com.mongodb.connection.Stream
    public org.bson.ByteBuf read(int numBytes) throws IOException {
        return read(numBytes, 0);
    }

    @Override // com.mongodb.connection.Stream
    public boolean supportsAdditionalTimeout() {
        return true;
    }

    @Override // com.mongodb.connection.Stream
    public org.bson.ByteBuf read(int numBytes, int additionalTimeoutMillis) throws IOException {
        Assertions.isTrueArgument("additionalTimeoutMillis must not be negative", additionalTimeoutMillis >= 0);
        FutureAsyncCompletionHandler<org.bson.ByteBuf> future = new FutureAsyncCompletionHandler<>();
        readAsync(numBytes, future, combinedTimeout(this.readTimeoutMillis, additionalTimeoutMillis));
        return future.get();
    }

    @Override // com.mongodb.connection.Stream
    public void writeAsync(List<org.bson.ByteBuf> buffers, final AsyncCompletionHandler<Void> handler) {
        CompositeByteBuf composite = PooledByteBufAllocator.DEFAULT.compositeBuffer();
        Iterator<org.bson.ByteBuf> it = buffers.iterator();
        while (it.hasNext()) {
            composite.addComponent(true, ((NettyByteBuf) it.next()).asByteBuf());
        }
        this.channel.writeAndFlush(composite).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: com.mongodb.connection.netty.NettyStream.2
            public void operationComplete(ChannelFuture future) throws Exception {
                if (!future.isSuccess()) {
                    handler.failed(future.cause());
                } else {
                    handler.completed(null);
                }
            }
        });
    }

    @Override // com.mongodb.connection.Stream
    public void readAsync(int numBytes, AsyncCompletionHandler<org.bson.ByteBuf> handler) {
        readAsync(numBytes, handler, this.readTimeoutMillis);
    }

    private void readAsync(int numBytes, AsyncCompletionHandler<org.bson.ByteBuf> handler, long readTimeoutMillis) {
        Throwable exceptionResult;
        org.bson.ByteBuf buffer = null;
        synchronized (this) {
            exceptionResult = this.pendingException;
            if (exceptionResult == null) {
                if (hasBytesAvailable(numBytes)) {
                    CompositeByteBuf composite = this.allocator.compositeBuffer(this.pendingInboundBuffers.size());
                    int bytesNeeded = numBytes;
                    Iterator<ByteBuf> iter = this.pendingInboundBuffers.iterator();
                    while (iter.hasNext()) {
                        ByteBuf next = iter.next();
                        int bytesNeededFromCurrentBuffer = Math.min(next.readableBytes(), bytesNeeded);
                        if (bytesNeededFromCurrentBuffer == next.readableBytes()) {
                            composite.addComponent(next);
                            iter.remove();
                        } else {
                            next.retain();
                            composite.addComponent(next.readSlice(bytesNeededFromCurrentBuffer));
                        }
                        composite.writerIndex(composite.writerIndex() + bytesNeededFromCurrentBuffer);
                        bytesNeeded -= bytesNeededFromCurrentBuffer;
                        if (bytesNeeded == 0) {
                            break;
                        }
                    }
                    buffer = new NettyByteBuf(composite).flip();
                } else if (this.pendingReader == null) {
                    this.pendingReader = new PendingReader(numBytes, handler, scheduleReadTimeout(this.readTimeoutTask, readTimeoutMillis));
                }
            }
            if (!((exceptionResult == null && buffer == null) || this.pendingReader == null)) {
                cancel(this.pendingReader.timeout);
                this.pendingReader = null;
            }
        }
        if (exceptionResult != null) {
            handler.failed(exceptionResult);
        }
        if (buffer != null) {
            handler.completed(buffer);
        }
    }

    private boolean hasBytesAvailable(int numBytes) {
        int bytesAvailable = 0;
        Iterator<ByteBuf> it = this.pendingInboundBuffers.iterator();
        while (it.hasNext()) {
            bytesAvailable += it.next().readableBytes();
            if (bytesAvailable >= numBytes) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void handleReadResponse(ByteBuf buffer, Throwable t) {
        PendingReader localPendingReader;
        synchronized (this) {
            if (buffer != null) {
                this.pendingInboundBuffers.add(buffer.retain());
            } else {
                this.pendingException = t;
            }
            localPendingReader = this.pendingReader;
        }
        if (localPendingReader != null) {
            readAsync(localPendingReader.numBytes, localPendingReader.handler, 0);
        }
    }

    @Override // com.mongodb.connection.Stream
    public ServerAddress getAddress() {
        return this.address;
    }

    @Override // com.mongodb.connection.Stream
    public synchronized void close() {
        this.isClosed = true;
        if (this.channel != null) {
            this.channel.close();
            this.channel = null;
        }
        Iterator<ByteBuf> iterator = this.pendingInboundBuffers.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            iterator.next().release();
        }
    }

    @Override // com.mongodb.connection.Stream
    public boolean isClosed() {
        return this.isClosed;
    }

    public SocketSettings getSettings() {
        return this.settings;
    }

    public SslSettings getSslSettings() {
        return this.sslSettings;
    }

    public EventLoopGroup getWorkerGroup() {
        return this.workerGroup;
    }

    public Class<? extends SocketChannel> getSocketChannelClass() {
        return this.socketChannelClass;
    }

    public ByteBufAllocator getAllocator() {
        return this.allocator;
    }

    /* access modifiers changed from: private */
    public SSLContext getSslContext() {
        try {
            return this.sslSettings.getContext() == null ? SSLContext.getDefault() : this.sslSettings.getContext();
        } catch (NoSuchAlgorithmException e) {
            throw new MongoClientException("Unable to create default SSLContext", e);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/connection/netty/NettyStream$InboundBufferHandler.class */
    public class InboundBufferHandler extends SimpleChannelInboundHandler<ByteBuf> {
        private InboundBufferHandler() {
        }

        /* access modifiers changed from: protected */
        public void channelRead0(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
            NettyStream.this.handleReadResponse(buffer, null);
        }

        @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) {
            if (t instanceof ReadTimeoutException) {
                NettyStream.this.handleReadResponse(null, new MongoSocketReadTimeoutException("Timeout while receiving message", NettyStream.this.address, t));
            } else {
                NettyStream.this.handleReadResponse(null, t);
            }
            ctx.close();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/connection/netty/NettyStream$PendingReader.class */
    public static final class PendingReader {
        private final int numBytes;
        private final AsyncCompletionHandler<org.bson.ByteBuf> handler;
        @Nullable
        private final ScheduledFuture<?> timeout;

        private PendingReader(int numBytes, AsyncCompletionHandler<org.bson.ByteBuf> handler, @Nullable ScheduledFuture<?> timeout) {
            this.numBytes = numBytes;
            this.handler = handler;
            this.timeout = timeout;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/connection/netty/NettyStream$FutureAsyncCompletionHandler.class */
    public static final class FutureAsyncCompletionHandler<T> implements AsyncCompletionHandler<T> {
        private final CountDownLatch latch = new CountDownLatch(1);

        /* renamed from: t */
        private volatile T f451t;
        private volatile Throwable throwable;

        FutureAsyncCompletionHandler() {
        }

        @Override // com.mongodb.connection.AsyncCompletionHandler
        public void completed(T t) {
            this.f451t = t;
            this.latch.countDown();
        }

        @Override // com.mongodb.connection.AsyncCompletionHandler
        public void failed(Throwable t) {
            this.throwable = t;
            this.latch.countDown();
        }

        public T get() throws IOException {
            try {
                this.latch.await();
                if (this.throwable == null) {
                    return this.f451t;
                }
                if (this.throwable instanceof IOException) {
                    throw ((IOException) this.throwable);
                } else if (this.throwable instanceof MongoException) {
                    throw ((MongoException) this.throwable);
                } else {
                    throw new MongoInternalException("Exception thrown from Netty Stream", this.throwable);
                }
            } catch (InterruptedException e) {
                throw new MongoInterruptedException("Interrupted", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/connection/netty/NettyStream$OpenChannelFutureListener.class */
    public class OpenChannelFutureListener implements ChannelFutureListener {
        private final Queue<SocketAddress> socketAddressQueue;
        private final ChannelFuture channelFuture;
        private final AsyncCompletionHandler<Void> handler;

        OpenChannelFutureListener(Queue<SocketAddress> socketAddressQueue, ChannelFuture channelFuture, AsyncCompletionHandler<Void> handler) {
            this.socketAddressQueue = socketAddressQueue;
            this.channelFuture = channelFuture;
            this.handler = handler;
        }

        public void operationComplete(ChannelFuture future) {
            synchronized (NettyStream.this) {
                if (future.isSuccess()) {
                    if (NettyStream.this.isClosed) {
                        this.channelFuture.channel().close();
                    } else {
                        NettyStream.this.channel = this.channelFuture.channel();
                        NettyStream.this.channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: com.mongodb.connection.netty.NettyStream.OpenChannelFutureListener.1
                            public void operationComplete(ChannelFuture future2) {
                                NettyStream.this.handleReadResponse(null, new IOException("The connection to the server was closed"));
                            }
                        });
                    }
                    this.handler.completed(null);
                } else if (NettyStream.this.isClosed) {
                    this.handler.completed(null);
                } else if (this.socketAddressQueue.isEmpty()) {
                    this.handler.failed(new MongoSocketOpenException("Exception opening socket", NettyStream.this.getAddress(), future.cause()));
                } else {
                    NettyStream.this.initializeChannel(this.handler, this.socketAddressQueue);
                }
            }
        }
    }

    private static void cancel(@Nullable java.util.concurrent.Future<?> f) {
        if (f != null) {
            f.cancel(false);
        }
    }

    private static long combinedTimeout(long timeout, int additionalTimeout) {
        if (timeout == 0) {
            return 0;
        }
        return Math.addExact(timeout, (long) additionalTimeout);
    }

    private static ScheduledFuture<?> scheduleReadTimeout(@Nullable ReadTimeoutTask readTimeoutTask, long timeoutMillis) {
        if (timeoutMillis == 0) {
            return null;
        }
        return readTimeoutTask.schedule(timeoutMillis);
    }

    /* access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/connection/netty/NettyStream$ReadTimeoutTask.class */
    public static final class ReadTimeoutTask implements Runnable {
        private final ChannelHandlerContext ctx;

        private ReadTimeoutTask(ChannelHandlerContext timeoutChannelHandlerContext) {
            this.ctx = timeoutChannelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.ctx.channel().isOpen()) {
                    this.ctx.fireExceptionCaught((Throwable) ReadTimeoutException.INSTANCE);
                    this.ctx.close();
                }
            } catch (Throwable t) {
                this.ctx.fireExceptionCaught(t);
            }
        }

        /* access modifiers changed from: private */
        public ScheduledFuture<?> schedule(long timeoutMillis) {
            return this.ctx.executor().schedule((Runnable) this, timeoutMillis, TimeUnit.MILLISECONDS);
        }
    }
}
