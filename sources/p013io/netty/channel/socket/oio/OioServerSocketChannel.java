package p013io.netty.channel.socket.oio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelMetadata;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.oio.AbstractOioMessageChannel;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.SocketUtils;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

@Deprecated
/* renamed from: io.netty.channel.socket.oio.OioServerSocketChannel */
/* loaded from: grasscutter.jar:io/netty/channel/socket/oio/OioServerSocketChannel.class */
public class OioServerSocketChannel extends AbstractOioMessageChannel implements ServerSocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioServerSocketChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 1);
    final ServerSocket socket;
    private final OioServerSocketChannelConfig config;

    private static ServerSocket newServerSocket() {
        try {
            return new ServerSocket();
        } catch (IOException e) {
            throw new ChannelException("failed to create a server socket", e);
        }
    }

    public OioServerSocketChannel() {
        this(newServerSocket());
    }

    public OioServerSocketChannel(ServerSocket socket) {
        super(null);
        boolean success;
        try {
            ObjectUtil.checkNotNull(socket, "socket");
            success = false;
            try {
                socket.setSoTimeout(1000);
                success = true;
                if (1 == 0) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        if (logger.isWarnEnabled()) {
                            logger.warn("Failed to close a partially initialized socket.", (Throwable) e);
                        }
                    }
                }
                this.socket = socket;
                this.config = new DefaultOioServerSocketChannelConfig(this, socket);
            } catch (IOException e2) {
                throw new ChannelException("Failed to set the server socket timeout.", e2);
            }
        } catch (Throwable th) {
            if (!success) {
                try {
                    socket.close();
                } catch (IOException e3) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("Failed to close a partially initialized socket.", (Throwable) e3);
                    }
                }
            }
            throw th;
        }
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) localAddress();
    }

    @Override // p013io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // p013io.netty.channel.Channel
    public OioServerSocketChannelConfig config() {
        return this.config;
    }

    @Override // p013io.netty.channel.AbstractChannel, p013io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return null;
    }

    @Override // p013io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    @Override // p013io.netty.channel.Channel
    public boolean isActive() {
        return isOpen() && this.socket.isBound();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return SocketUtils.localSocketAddress(this.socket);
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress localAddress) throws Exception {
        this.socket.bind(localAddress, this.config.getBacklog());
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.socket.close();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0026
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.channel.oio.AbstractOioMessageChannel
    protected int doReadMessages(java.util.List<java.lang.Object> r7) throws java.lang.Exception {
        /*
            r6 = this;
            r0 = r6
            java.net.ServerSocket r0 = r0.socket
            boolean r0 = r0.isClosed()
            if (r0 == 0) goto L_0x000c
            r0 = -1
            return r0
        L_0x000c:
            r0 = r6
            java.net.ServerSocket r0 = r0.socket     // Catch: SocketTimeoutException -> 0x004a
            java.net.Socket r0 = r0.accept()     // Catch: SocketTimeoutException -> 0x004a
            r8 = r0
            r0 = r7
            io.netty.channel.socket.oio.OioSocketChannel r1 = new io.netty.channel.socket.oio.OioSocketChannel     // Catch: SocketTimeoutException -> 0x004a, Throwable -> 0x0026
            r2 = r1
            r3 = r6
            r4 = r8
            r2.<init>(r3, r4)     // Catch: SocketTimeoutException -> 0x004a, Throwable -> 0x0026
            boolean r0 = r0.add(r1)     // Catch: SocketTimeoutException -> 0x004a, Throwable -> 0x0026
            r0 = 1
            return r0
        L_0x0026:
            r9 = move-exception
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.channel.socket.oio.OioServerSocketChannel.logger     // Catch: SocketTimeoutException -> 0x004a
            java.lang.String r1 = "Failed to create a new channel from an accepted socket."
            r2 = r9
            r0.warn(r1, r2)     // Catch: SocketTimeoutException -> 0x004a
            r0 = r8
            r0.close()     // Catch: Throwable -> 0x0039, SocketTimeoutException -> 0x004a
            goto L_0x0047
        L_0x0039:
            r10 = move-exception
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.channel.socket.oio.OioServerSocketChannel.logger     // Catch: SocketTimeoutException -> 0x004a
            java.lang.String r1 = "Failed to close a socket."
            r2 = r10
            r0.warn(r1, r2)     // Catch: SocketTimeoutException -> 0x004a
        L_0x0047:
            goto L_0x004b
        L_0x004a:
            r8 = move-exception
        L_0x004b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.socket.oio.OioServerSocketChannel.doReadMessages(java.util.List):int");
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object msg) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress remoteAddress, SocketAddress localAddress) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
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
