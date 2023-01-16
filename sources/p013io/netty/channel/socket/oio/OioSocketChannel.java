package p013io.netty.channel.socket.oio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.ConnectTimeoutException;
import p013io.netty.channel.EventLoop;
import p013io.netty.channel.oio.OioByteStreamChannel;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.socket.SocketChannel;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.SocketUtils;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.OioSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/OioSocketChannel.class */
public class OioSocketChannel extends OioByteStreamChannel implements SocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioSocketChannel.class);
    private final Socket socket;
    private final OioSocketChannelConfig config;

    public OioSocketChannel() {
        this(new Socket());
    }

    public OioSocketChannel(Socket socket) {
        this(null, socket);
    }

    public OioSocketChannel(Channel parent, Socket socket) {
        super(parent);
        boolean success;
        try {
            this.socket = socket;
            this.config = new DefaultOioSocketChannelConfig(this, socket);
            success = false;
            try {
                if (socket.isConnected()) {
                    activate(socket.getInputStream(), socket.getOutputStream());
                }
                socket.setSoTimeout(1000);
                success = true;
                if (1 == 0) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        logger.warn("Failed to close a socket.", (Throwable) e);
                    }
                }
            } catch (Exception e2) {
                throw new ChannelException("failed to initialize a socket", e2);
            }
        } catch (Throwable th) {
            if (!success) {
                try {
                    socket.close();
                } catch (IOException e3) {
                    logger.warn("Failed to close a socket.", (Throwable) e3);
                }
            }
            throw th;
        }
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) parent();
    }

    @Override // p013io.netty.channel.Channel
    public OioSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    @Override // p013io.netty.channel.oio.OioByteStreamChannel, p013io.netty.channel.Channel
    public boolean isActive() {
        return !this.socket.isClosed() && this.socket.isConnected();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown() || !isActive();
    }

    @Override // p013io.netty.channel.oio.AbstractOioByteChannel, p013io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown() || !isActive();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return (this.socket.isInputShutdown() && this.socket.isOutputShutdown()) || !isActive();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected final void doShutdownOutput() throws Exception {
        shutdownOutput0();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    @Override // p013io.netty.channel.oio.AbstractOioByteChannel, p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.oio.OioByteStreamChannel, p013io.netty.channel.oio.AbstractOioByteChannel
    public int doReadBytes(ByteBuf buf) throws Exception {
        if (this.socket.isClosed()) {
            return -1;
        }
        try {
            return doReadBytes(buf);
        } catch (SocketTimeoutException e) {
            return 0;
        }
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise promise) {
        EventLoop loop = eventLoop();
        if (loop.inEventLoop()) {
            shutdownOutput0(promise);
        } else {
            loop.execute(new Runnable() { // from class: io.netty.channel.socket.oio.OioSocketChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    OioSocketChannel.this.shutdownOutput0(promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void shutdownOutput0(ChannelPromise promise) {
        try {
            shutdownOutput0();
            promise.setSuccess();
        } catch (Throwable t) {
            promise.setFailure(t);
        }
    }

    private void shutdownOutput0() throws IOException {
        this.socket.shutdownOutput();
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise promise) {
        EventLoop loop = eventLoop();
        if (loop.inEventLoop()) {
            shutdownInput0(promise);
        } else {
            loop.execute(new Runnable() { // from class: io.netty.channel.socket.oio.OioSocketChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    OioSocketChannel.this.shutdownInput0(promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise promise) {
        try {
            this.socket.shutdownInput();
            promise.setSuccess();
        } catch (Throwable t) {
            promise.setFailure(t);
        }
    }

    @Override // p013io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise promise) {
        ChannelFuture shutdownOutputFuture = shutdownOutput();
        if (shutdownOutputFuture.isDone()) {
            shutdownOutputDone(shutdownOutputFuture, promise);
        } else {
            shutdownOutputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.socket.oio.OioSocketChannel.3
                public void operationComplete(ChannelFuture shutdownOutputFuture2) throws Exception {
                    OioSocketChannel.this.shutdownOutputDone(shutdownOutputFuture2, promise);
                }
            });
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture shutdownOutputFuture, final ChannelPromise promise) {
        ChannelFuture shutdownInputFuture = shutdownInput();
        if (shutdownInputFuture.isDone()) {
            shutdownDone(shutdownOutputFuture, shutdownInputFuture, promise);
        } else {
            shutdownInputFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.socket.oio.OioSocketChannel.4
                public void operationComplete(ChannelFuture shutdownInputFuture2) throws Exception {
                    OioSocketChannel.shutdownDone(shutdownOutputFuture, shutdownInputFuture2, promise);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture shutdownOutputFuture, ChannelFuture shutdownInputFuture, ChannelPromise promise) {
        Throwable shutdownOutputCause = shutdownOutputFuture.cause();
        Throwable shutdownInputCause = shutdownInputFuture.cause();
        if (shutdownOutputCause != null) {
            if (shutdownInputCause != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", shutdownInputCause);
            }
            promise.setFailure(shutdownOutputCause);
        } else if (shutdownInputCause != null) {
            promise.setFailure(shutdownInputCause);
        } else {
            promise.setSuccess();
        }
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) remoteAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        SocketUtils.bind(this.socket, localAddress);
    }

    @Override // p013io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        if (localAddress != null) {
            SocketUtils.bind(this.socket, localAddress);
        }
        boolean success = false;
        try {
            try {
                SocketUtils.connect(this.socket, remoteAddress, config().getConnectTimeoutMillis());
                activate(this.socket.getInputStream(), this.socket.getOutputStream());
                success = true;
                if (1 == 0) {
                    doClose();
                }
            } catch (SocketTimeoutException e) {
                ConnectTimeoutException cause = new ConnectTimeoutException("connection timed out: " + remoteAddress);
                cause.setStackTrace(e.getStackTrace());
                throw cause;
            }
        } catch (Throwable th) {
            if (!success) {
                doClose();
            }
            throw th;
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // p013io.netty.channel.oio.OioByteStreamChannel, p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.socket.close();
    }

    protected boolean checkInputShutdown() {
        if (!isInputShutdown()) {
            return false;
        }
        try {
            Thread.sleep((long) config().getSoTimeout());
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    @Override // p013io.netty.channel.oio.AbstractOioChannel
    @Deprecated
    protected void setReadPending(boolean readPending) {
        setReadPending(readPending);
    }

    /* access modifiers changed from: package-private */
    public final void clearReadPending0() {
        clearReadPending();
    }
}
