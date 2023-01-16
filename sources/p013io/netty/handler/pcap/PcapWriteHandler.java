package p013io.netty.handler.pcap;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelDuplexHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.socket.DatagramChannel;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.channel.socket.ServerSocketChannel;
import p013io.netty.channel.socket.SocketChannel;
import p013io.netty.handler.pcap.TCPPacket;
import p013io.netty.util.NetUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.pcap.PcapWriteHandler */
/* loaded from: grasscutter.jar:io/netty/handler/pcap/PcapWriteHandler.class */
public final class PcapWriteHandler extends ChannelDuplexHandler implements Closeable {
    private final InternalLogger logger;
    private PcapWriter pCapWriter;
    private final OutputStream outputStream;
    private final boolean captureZeroByte;
    private final boolean writePcapGlobalHeader;
    private int sendSegmentNumber;
    private int receiveSegmentNumber;
    private ChannelType channelType;
    private InetSocketAddress initiatiorAddr;
    private InetSocketAddress handlerAddr;
    private boolean isServerPipeline;
    private boolean isClosed;
    private boolean initialized;

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.pcap.PcapWriteHandler$ChannelType */
    /* loaded from: grasscutter.jar:io/netty/handler/pcap/PcapWriteHandler$ChannelType.class */
    public enum ChannelType {
        TCP,
        UDP
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream) {
        this(outputStream, false, true);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream, boolean captureZeroByte, boolean writePcapGlobalHeader) {
        this.logger = InternalLoggerFactory.getInstance(PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.outputStream = (OutputStream) ObjectUtil.checkNotNull(outputStream, "OutputStream");
        this.captureZeroByte = captureZeroByte;
        this.writePcapGlobalHeader = writePcapGlobalHeader;
    }

    private PcapWriteHandler(Builder builder, OutputStream outputStream) {
        this.logger = InternalLoggerFactory.getInstance(PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.outputStream = outputStream;
        this.captureZeroByte = builder.captureZeroByte;
        this.writePcapGlobalHeader = builder.writePcapGlobalHeader;
        this.channelType = builder.channelType;
        this.handlerAddr = builder.handlerAddr;
        this.initiatiorAddr = builder.initiatiorAddr;
        this.isServerPipeline = builder.isServerPipeline;
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initializeIfNecessary(ChannelHandlerContext ctx) {
        ByteBuf tcpBuf;
        if (!this.initialized) {
            ByteBufAllocator byteBufAllocator = ctx.alloc();
            if (this.writePcapGlobalHeader) {
                try {
                    tcpBuf = byteBufAllocator.buffer();
                    try {
                        this.pCapWriter = new PcapWriter(this.outputStream, tcpBuf);
                        tcpBuf.release();
                    } catch (IOException ex) {
                        ctx.channel().close();
                        ctx.fireExceptionCaught((Throwable) ex);
                        this.logger.error("Caught Exception While Initializing PcapWriter, Closing Channel.", (Throwable) ex);
                        tcpBuf.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                this.pCapWriter = new PcapWriter(this.outputStream);
            }
            if (this.channelType == null) {
                if (ctx.channel() instanceof SocketChannel) {
                    this.channelType = ChannelType.TCP;
                    if (ctx.channel().parent() instanceof ServerSocketChannel) {
                        this.isServerPipeline = true;
                        this.initiatiorAddr = (InetSocketAddress) ctx.channel().remoteAddress();
                        this.handlerAddr = (InetSocketAddress) ctx.channel().localAddress();
                    } else {
                        this.isServerPipeline = false;
                        this.initiatiorAddr = (InetSocketAddress) ctx.channel().localAddress();
                        this.handlerAddr = (InetSocketAddress) ctx.channel().remoteAddress();
                    }
                } else if (ctx.channel() instanceof DatagramChannel) {
                    this.channelType = ChannelType.UDP;
                    if (((DatagramChannel) ctx.channel()).isConnected()) {
                        this.initiatiorAddr = (InetSocketAddress) ctx.channel().localAddress();
                        this.handlerAddr = (InetSocketAddress) ctx.channel().remoteAddress();
                    }
                }
            }
            if (this.channelType == ChannelType.TCP) {
                this.logger.debug("Initiating Fake TCP 3-Way Handshake");
                tcpBuf = byteBufAllocator.buffer();
                try {
                    TCPPacket.writePacket(tcpBuf, null, 0, 0, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.SYN);
                    completeTCPWrite(this.initiatiorAddr, this.handlerAddr, tcpBuf, byteBufAllocator, ctx);
                    TCPPacket.writePacket(tcpBuf, null, 0, 1, this.handlerAddr.getPort(), this.initiatiorAddr.getPort(), TCPPacket.TCPFlag.SYN, TCPPacket.TCPFlag.ACK);
                    completeTCPWrite(this.handlerAddr, this.initiatiorAddr, tcpBuf, byteBufAllocator, ctx);
                    TCPPacket.writePacket(tcpBuf, null, 1, 1, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.ACK);
                    completeTCPWrite(this.initiatiorAddr, this.handlerAddr, tcpBuf, byteBufAllocator, ctx);
                    tcpBuf.release();
                    this.logger.debug("Finished Fake TCP 3-Way Handshake");
                } finally {
                    tcpBuf.release();
                }
            }
            this.initialized = true;
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        initializeIfNecessary(ctx);
        channelActive(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!this.isClosed) {
            initializeIfNecessary(ctx);
            if (this.channelType == ChannelType.TCP) {
                handleTCP(ctx, msg, false);
            } else if (this.channelType == ChannelType.UDP) {
                handleUDP(ctx, msg);
            } else {
                logDiscard();
            }
        }
        channelRead(ctx, msg);
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (!this.isClosed) {
            initializeIfNecessary(ctx);
            if (this.channelType == ChannelType.TCP) {
                handleTCP(ctx, msg, true);
            } else if (this.channelType == ChannelType.UDP) {
                handleUDP(ctx, msg);
            } else {
                logDiscard();
            }
        }
        write(ctx, msg, promise);
    }

    private void logDiscard() {
        this.logger.warn("Discarding pcap write because channel type is unknown. The channel this handler is registered on is not a SocketChannel or DatagramChannel, so the inference does not work. Please call forceTcpChannel or forceUdpChannel before registering the handler.");
    }

    private void handleTCP(ChannelHandlerContext ctx, Object msg, boolean isWriteOperation) {
        InetSocketAddress dstAddr;
        InetSocketAddress srcAddr;
        InetSocketAddress dstAddr2;
        InetSocketAddress srcAddr2;
        if (!(msg instanceof ByteBuf)) {
            this.logger.debug("Discarding Pcap Write for TCP Object: {}", msg);
        } else if (((ByteBuf) msg).readableBytes() != 0 || this.captureZeroByte) {
            ByteBufAllocator byteBufAllocator = ctx.alloc();
            ByteBuf packet = ((ByteBuf) msg).duplicate();
            ByteBuf tcpBuf = byteBufAllocator.buffer();
            int bytes = packet.readableBytes();
            try {
                if (isWriteOperation) {
                    if (this.isServerPipeline) {
                        srcAddr2 = this.handlerAddr;
                        dstAddr2 = this.initiatiorAddr;
                    } else {
                        srcAddr2 = this.initiatiorAddr;
                        dstAddr2 = this.handlerAddr;
                    }
                    TCPPacket.writePacket(tcpBuf, packet, this.sendSegmentNumber, this.receiveSegmentNumber, srcAddr2.getPort(), dstAddr2.getPort(), TCPPacket.TCPFlag.ACK);
                    completeTCPWrite(srcAddr2, dstAddr2, tcpBuf, byteBufAllocator, ctx);
                    logTCP(true, bytes, this.sendSegmentNumber, this.receiveSegmentNumber, srcAddr2, dstAddr2, false);
                    this.sendSegmentNumber += bytes;
                    TCPPacket.writePacket(tcpBuf, null, this.receiveSegmentNumber, this.sendSegmentNumber, dstAddr2.getPort(), srcAddr2.getPort(), TCPPacket.TCPFlag.ACK);
                    completeTCPWrite(dstAddr2, srcAddr2, tcpBuf, byteBufAllocator, ctx);
                    logTCP(true, bytes, this.sendSegmentNumber, this.receiveSegmentNumber, dstAddr2, srcAddr2, true);
                } else {
                    if (this.isServerPipeline) {
                        srcAddr = this.initiatiorAddr;
                        dstAddr = this.handlerAddr;
                    } else {
                        srcAddr = this.handlerAddr;
                        dstAddr = this.initiatiorAddr;
                    }
                    TCPPacket.writePacket(tcpBuf, packet, this.receiveSegmentNumber, this.sendSegmentNumber, srcAddr.getPort(), dstAddr.getPort(), TCPPacket.TCPFlag.ACK);
                    completeTCPWrite(srcAddr, dstAddr, tcpBuf, byteBufAllocator, ctx);
                    logTCP(false, bytes, this.receiveSegmentNumber, this.sendSegmentNumber, srcAddr, dstAddr, false);
                    this.receiveSegmentNumber += bytes;
                    TCPPacket.writePacket(tcpBuf, null, this.sendSegmentNumber, this.receiveSegmentNumber, dstAddr.getPort(), srcAddr.getPort(), TCPPacket.TCPFlag.ACK);
                    completeTCPWrite(dstAddr, srcAddr, tcpBuf, byteBufAllocator, ctx);
                    logTCP(false, bytes, this.sendSegmentNumber, this.receiveSegmentNumber, dstAddr, srcAddr, true);
                }
            } finally {
                tcpBuf.release();
            }
        } else {
            this.logger.debug("Discarding Zero Byte TCP Packet. isWriteOperation {}", Boolean.valueOf(isWriteOperation));
        }
    }

    private void completeTCPWrite(InetSocketAddress srcAddr, InetSocketAddress dstAddr, ByteBuf tcpBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext ctx) {
        ByteBuf ipBuf;
        ByteBuf ethernetBuf;
        ByteBuf pcap;
        try {
            ipBuf = byteBufAllocator.buffer();
            ethernetBuf = byteBufAllocator.buffer();
            pcap = byteBufAllocator.buffer();
            try {
                if ((srcAddr.getAddress() instanceof Inet4Address) && (dstAddr.getAddress() instanceof Inet4Address)) {
                    IPPacket.writeTCPv4(ipBuf, tcpBuf, NetUtil.ipv4AddressToInt((Inet4Address) srcAddr.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) dstAddr.getAddress()));
                    EthernetPacket.writeIPv4(ethernetBuf, ipBuf);
                } else if (!(srcAddr.getAddress() instanceof Inet6Address) || !(dstAddr.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", srcAddr.getAddress(), dstAddr.getAddress());
                    ipBuf.release();
                    ethernetBuf.release();
                    pcap.release();
                    return;
                } else {
                    IPPacket.writeTCPv6(ipBuf, tcpBuf, srcAddr.getAddress().getAddress(), dstAddr.getAddress().getAddress());
                    EthernetPacket.writeIPv6(ethernetBuf, ipBuf);
                }
                this.pCapWriter.writePacket(pcap, ethernetBuf);
                ipBuf.release();
                ethernetBuf.release();
                pcap.release();
            } catch (IOException ex) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) ex);
                ctx.fireExceptionCaught((Throwable) ex);
                ipBuf.release();
                ethernetBuf.release();
                pcap.release();
            }
        } catch (Throwable th) {
            ipBuf.release();
            ethernetBuf.release();
            pcap.release();
            throw th;
        }
    }

    private void logTCP(boolean isWriteOperation, int bytes, int sendSegmentNumber, int receiveSegmentNumber, InetSocketAddress srcAddr, InetSocketAddress dstAddr, boolean ackOnly) {
        if (!this.logger.isDebugEnabled()) {
            return;
        }
        if (ackOnly) {
            this.logger.debug("Writing TCP ACK, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Boolean.valueOf(isWriteOperation), Integer.valueOf(sendSegmentNumber), Integer.valueOf(receiveSegmentNumber), dstAddr, srcAddr);
        } else {
            this.logger.debug("Writing TCP Data of {} Bytes, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", Integer.valueOf(bytes), Boolean.valueOf(isWriteOperation), Integer.valueOf(sendSegmentNumber), Integer.valueOf(receiveSegmentNumber), srcAddr, dstAddr);
        }
    }

    private void handleUDP(ChannelHandlerContext ctx, Object msg) {
        ByteBuf udpBuf = ctx.alloc().buffer();
        try {
            if (msg instanceof DatagramPacket) {
                if (((ByteBuf) ((DatagramPacket) msg).content()).readableBytes() != 0 || this.captureZeroByte) {
                    DatagramPacket datagramPacket = ((DatagramPacket) msg).duplicate();
                    InetSocketAddress srcAddr = datagramPacket.sender();
                    InetSocketAddress dstAddr = datagramPacket.recipient();
                    if (srcAddr == null) {
                        srcAddr = (InetSocketAddress) ctx.channel().localAddress();
                    }
                    this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(((ByteBuf) datagramPacket.content()).readableBytes()), srcAddr, dstAddr);
                    UDPPacket.writePacket(udpBuf, (ByteBuf) datagramPacket.content(), srcAddr.getPort(), dstAddr.getPort());
                    completeUDPWrite(srcAddr, dstAddr, udpBuf, ctx.alloc(), ctx);
                } else {
                    this.logger.debug("Discarding Zero Byte UDP Packet");
                    udpBuf.release();
                }
            } else if (!(msg instanceof ByteBuf) || ((ctx.channel() instanceof DatagramChannel) && !((DatagramChannel) ctx.channel()).isConnected())) {
                this.logger.debug("Discarding Pcap Write for UDP Object: {}", msg);
            } else if (((ByteBuf) msg).readableBytes() != 0 || this.captureZeroByte) {
                ByteBuf byteBuf = ((ByteBuf) msg).duplicate();
                this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", Integer.valueOf(byteBuf.readableBytes()), this.initiatiorAddr, this.handlerAddr);
                UDPPacket.writePacket(udpBuf, byteBuf, this.initiatiorAddr.getPort(), this.handlerAddr.getPort());
                completeUDPWrite(this.initiatiorAddr, this.handlerAddr, udpBuf, ctx.alloc(), ctx);
            } else {
                this.logger.debug("Discarding Zero Byte UDP Packet");
                udpBuf.release();
            }
        } finally {
            udpBuf.release();
        }
    }

    private void completeUDPWrite(InetSocketAddress srcAddr, InetSocketAddress dstAddr, ByteBuf udpBuf, ByteBufAllocator byteBufAllocator, ChannelHandlerContext ctx) {
        ByteBuf ipBuf;
        ByteBuf ethernetBuf;
        ByteBuf pcap;
        try {
            ipBuf = byteBufAllocator.buffer();
            ethernetBuf = byteBufAllocator.buffer();
            pcap = byteBufAllocator.buffer();
            try {
                if ((srcAddr.getAddress() instanceof Inet4Address) && (dstAddr.getAddress() instanceof Inet4Address)) {
                    IPPacket.writeUDPv4(ipBuf, udpBuf, NetUtil.ipv4AddressToInt((Inet4Address) srcAddr.getAddress()), NetUtil.ipv4AddressToInt((Inet4Address) dstAddr.getAddress()));
                    EthernetPacket.writeIPv4(ethernetBuf, ipBuf);
                } else if (!(srcAddr.getAddress() instanceof Inet6Address) || !(dstAddr.getAddress() instanceof Inet6Address)) {
                    this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", srcAddr.getAddress(), dstAddr.getAddress());
                    ipBuf.release();
                    ethernetBuf.release();
                    pcap.release();
                    return;
                } else {
                    IPPacket.writeUDPv6(ipBuf, udpBuf, srcAddr.getAddress().getAddress(), dstAddr.getAddress().getAddress());
                    EthernetPacket.writeIPv6(ethernetBuf, ipBuf);
                }
                this.pCapWriter.writePacket(pcap, ethernetBuf);
                ipBuf.release();
                ethernetBuf.release();
                pcap.release();
            } catch (IOException ex) {
                this.logger.error("Caught Exception While Writing Packet into Pcap", (Throwable) ex);
                ctx.fireExceptionCaught((Throwable) ex);
                ipBuf.release();
                ethernetBuf.release();
                pcap.release();
            }
        } catch (Throwable th) {
            ipBuf.release();
            ethernetBuf.release();
            pcap.release();
            throw th;
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if (this.channelType == ChannelType.TCP) {
            this.logger.debug("Starting Fake TCP FIN+ACK Flow to close connection");
            ByteBufAllocator byteBufAllocator = ctx.alloc();
            ByteBuf tcpBuf = byteBufAllocator.buffer();
            try {
                TCPPacket.writePacket(tcpBuf, null, this.sendSegmentNumber, this.receiveSegmentNumber, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.FIN, TCPPacket.TCPFlag.ACK);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, tcpBuf, byteBufAllocator, ctx);
                TCPPacket.writePacket(tcpBuf, null, this.receiveSegmentNumber, this.sendSegmentNumber, this.handlerAddr.getPort(), this.initiatiorAddr.getPort(), TCPPacket.TCPFlag.FIN, TCPPacket.TCPFlag.ACK);
                completeTCPWrite(this.handlerAddr, this.initiatiorAddr, tcpBuf, byteBufAllocator, ctx);
                TCPPacket.writePacket(tcpBuf, null, this.sendSegmentNumber + 1, this.receiveSegmentNumber + 1, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.ACK);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, tcpBuf, byteBufAllocator, ctx);
                tcpBuf.release();
                this.logger.debug("Finished Fake TCP FIN+ACK Flow to close connection");
            } catch (Throwable th) {
                tcpBuf.release();
                throw th;
            }
        }
        close();
        handlerRemoved(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (this.channelType == ChannelType.TCP) {
            ByteBuf tcpBuf = ctx.alloc().buffer();
            try {
                TCPPacket.writePacket(tcpBuf, null, this.sendSegmentNumber, this.receiveSegmentNumber, this.initiatiorAddr.getPort(), this.handlerAddr.getPort(), TCPPacket.TCPFlag.RST, TCPPacket.TCPFlag.ACK);
                completeTCPWrite(this.initiatiorAddr, this.handlerAddr, tcpBuf, ctx.alloc(), ctx);
                tcpBuf.release();
                this.logger.debug("Sent Fake TCP RST to close connection");
            } catch (Throwable th) {
                tcpBuf.release();
                throw th;
            }
        }
        close();
        ctx.fireExceptionCaught(cause);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.isClosed) {
            this.logger.debug("PcapWriterHandler is already closed");
            return;
        }
        this.isClosed = true;
        this.pCapWriter.close();
        this.logger.debug("PcapWriterHandler is now closed");
    }

    /* renamed from: io.netty.handler.pcap.PcapWriteHandler$Builder */
    /* loaded from: grasscutter.jar:io/netty/handler/pcap/PcapWriteHandler$Builder.class */
    public static final class Builder {
        private boolean captureZeroByte;
        private boolean writePcapGlobalHeader;
        private ChannelType channelType;
        private InetSocketAddress initiatiorAddr;
        private InetSocketAddress handlerAddr;
        private boolean isServerPipeline;

        private Builder() {
            this.writePcapGlobalHeader = true;
        }

        public Builder captureZeroByte(boolean captureZeroByte) {
            this.captureZeroByte = captureZeroByte;
            return this;
        }

        public Builder writePcapGlobalHeader(boolean writePcapGlobalHeader) {
            this.writePcapGlobalHeader = writePcapGlobalHeader;
            return this;
        }

        public Builder forceTcpChannel(InetSocketAddress serverAddress, InetSocketAddress clientAddress, boolean localIsServer) {
            this.channelType = ChannelType.TCP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(serverAddress, "serverAddress");
            this.initiatiorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(clientAddress, "clientAddress");
            this.isServerPipeline = localIsServer;
            return this;
        }

        public Builder forceUdpChannel(InetSocketAddress localAddress, InetSocketAddress remoteAddress) {
            this.channelType = ChannelType.UDP;
            this.handlerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(remoteAddress, "remoteAddress");
            this.initiatiorAddr = (InetSocketAddress) ObjectUtil.checkNotNull(localAddress, "localAddress");
            return this;
        }

        public PcapWriteHandler build(OutputStream outputStream) {
            ObjectUtil.checkNotNull(outputStream, "outputStream");
            return new PcapWriteHandler(this, outputStream);
        }
    }
}
