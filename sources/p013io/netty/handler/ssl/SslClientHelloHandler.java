package p013io.netty.handler.ssl;

import java.net.SocketAddress;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundHandler;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.handler.codec.ByteToMessageDecoder;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.FutureListener;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.SslClientHelloHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslClientHelloHandler.class */
public abstract class SslClientHelloHandler<T> extends ByteToMessageDecoder implements ChannelOutboundHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SslClientHelloHandler.class);
    private boolean handshakeFailed;
    private boolean suppressRead;
    private boolean readPending;
    private ByteBuf handshakeBuffer;

    protected abstract Future<T> lookup(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception;

    protected abstract void onLookupComplete(ChannelHandlerContext channelHandlerContext, Future<T> future) throws Exception;

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (!this.suppressRead && !this.handshakeFailed) {
            try {
                int readerIndex = in.readerIndex();
                int readableBytes = in.readableBytes();
                int handshakeLength = -1;
                while (readableBytes >= 5) {
                    switch (in.getUnsignedByte(readerIndex)) {
                        case 20:
                        case 21:
                            int len = SslUtils.getEncryptedPacketLength(in, readerIndex);
                            if (len == -2) {
                                this.handshakeFailed = true;
                                NotSslRecordException e = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(in));
                                in.skipBytes(in.readableBytes());
                                ctx.fireUserEventTriggered((Object) new SniCompletionEvent(e));
                                SslUtils.handleHandshakeFailure(ctx, e, true);
                                throw e;
                            } else if (len != -1) {
                                select(ctx, null);
                                return;
                            } else {
                                return;
                            }
                        case 22:
                            if (in.getUnsignedByte(readerIndex + 1) == 3) {
                                int packetLength = in.getUnsignedShort(readerIndex + 3) + 5;
                                if (readableBytes >= packetLength) {
                                    if (packetLength == 5) {
                                        select(ctx, null);
                                        return;
                                    }
                                    int endOffset = readerIndex + packetLength;
                                    if (handshakeLength == -1) {
                                        if (readerIndex + 4 <= endOffset) {
                                            if (in.getUnsignedByte(readerIndex + 5) != 1) {
                                                select(ctx, null);
                                                return;
                                            }
                                            handshakeLength = in.getUnsignedMedium(readerIndex + 5 + 1);
                                            readerIndex += 4;
                                            packetLength -= 4;
                                            if (handshakeLength + 4 + 5 <= packetLength) {
                                                select(ctx, in.retainedSlice(readerIndex + 5, handshakeLength));
                                                return;
                                            } else if (this.handshakeBuffer == null) {
                                                this.handshakeBuffer = ctx.alloc().buffer(handshakeLength);
                                            } else {
                                                this.handshakeBuffer.clear();
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    this.handshakeBuffer.writeBytes(in, readerIndex + 5, packetLength - 5);
                                    readerIndex += packetLength;
                                    readableBytes -= packetLength;
                                    if (handshakeLength <= this.handshakeBuffer.readableBytes()) {
                                        ByteBuf clientHello = this.handshakeBuffer.setIndex(0, handshakeLength);
                                        this.handshakeBuffer = null;
                                        select(ctx, clientHello);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                select(ctx, null);
                                return;
                            }
                        default:
                            select(ctx, null);
                            return;
                    }
                }
            } catch (NotSslRecordException e2) {
                throw e2;
            } catch (Exception e3) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Unexpected client hello packet: " + ByteBufUtil.hexDump(in), (Throwable) e3);
                }
                select(ctx, null);
            }
        }
    }

    private void releaseHandshakeBuffer() {
        releaseIfNotNull(this.handshakeBuffer);
        this.handshakeBuffer = null;
    }

    /* access modifiers changed from: private */
    public static void releaseIfNotNull(ByteBuf buffer) {
        if (buffer != null) {
            buffer.release();
        }
    }

    private void select(final ChannelHandlerContext ctx, final ByteBuf clientHello) throws Exception {
        try {
            Future<T> future = lookup(ctx, clientHello);
            if (future.isDone()) {
                onLookupComplete(ctx, future);
            } else {
                this.suppressRead = true;
                future.addListener(new FutureListener<T>() { // from class: io.netty.handler.ssl.SslClientHelloHandler.1
                    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x001f
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                        */
                    @Override // p013io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(p013io.netty.util.concurrent.Future<T> r6) {
                        /*
                            r5 = this;
                            r0 = r5
                            io.netty.buffer.ByteBuf r0 = r9
                            p013io.netty.handler.ssl.SslClientHelloHandler.access$000(r0)
                            r0 = r5
                            io.netty.handler.ssl.SslClientHelloHandler r0 = p013io.netty.handler.ssl.SslClientHelloHandler.this     // Catch: all -> 0x0070
                            r1 = 0
                            boolean r0 = p013io.netty.handler.ssl.SslClientHelloHandler.access$102(r0, r1)     // Catch: all -> 0x0070
                            r0 = r5
                            io.netty.handler.ssl.SslClientHelloHandler r0 = p013io.netty.handler.ssl.SslClientHelloHandler.this     // Catch: DecoderException -> 0x001f, Exception -> 0x002e, Throwable -> 0x0044, all -> 0x0070
                            r1 = r5
                            io.netty.channel.ChannelHandlerContext r1 = r8     // Catch: DecoderException -> 0x001f, Exception -> 0x002e, Throwable -> 0x0044, all -> 0x0070
                            r2 = r6
                            r0.onLookupComplete(r1, r2)     // Catch: DecoderException -> 0x001f, Exception -> 0x002e, Throwable -> 0x0044, all -> 0x0070
                            goto L_0x0050
                        L_0x001f:
                            r7 = move-exception
                            r0 = r5
                            io.netty.channel.ChannelHandlerContext r0 = r8     // Catch: all -> 0x0070
                            r1 = r7
                            io.netty.channel.ChannelHandlerContext r0 = r0.fireExceptionCaught(r1)     // Catch: all -> 0x0070
                            goto L_0x0050
                        L_0x002e:
                            r7 = move-exception
                            r0 = r5
                            io.netty.channel.ChannelHandlerContext r0 = r8     // Catch: all -> 0x0070
                            io.netty.handler.codec.DecoderException r1 = new io.netty.handler.codec.DecoderException     // Catch: all -> 0x0070
                            r2 = r1
                            r3 = r7
                            r2.<init>(r3)     // Catch: all -> 0x0070
                            io.netty.channel.ChannelHandlerContext r0 = r0.fireExceptionCaught(r1)     // Catch: all -> 0x0070
                            goto L_0x0050
                        L_0x0044:
                            r7 = move-exception
                            r0 = r5
                            io.netty.channel.ChannelHandlerContext r0 = r8     // Catch: all -> 0x0070
                            r1 = r7
                            io.netty.channel.ChannelHandlerContext r0 = r0.fireExceptionCaught(r1)     // Catch: all -> 0x0070
                        L_0x0050:
                            r0 = r5
                            io.netty.handler.ssl.SslClientHelloHandler r0 = p013io.netty.handler.ssl.SslClientHelloHandler.this
                            boolean r0 = p013io.netty.handler.ssl.SslClientHelloHandler.access$200(r0)
                            if (r0 == 0) goto L_0x0090
                            r0 = r5
                            io.netty.handler.ssl.SslClientHelloHandler r0 = p013io.netty.handler.ssl.SslClientHelloHandler.this
                            r1 = 0
                            boolean r0 = p013io.netty.handler.ssl.SslClientHelloHandler.access$202(r0, r1)
                            r0 = r5
                            io.netty.channel.ChannelHandlerContext r0 = r8
                            io.netty.channel.ChannelHandlerContext r0 = r0.read()
                            goto L_0x0090
                        L_0x0070:
                            r8 = move-exception
                            r0 = r5
                            io.netty.handler.ssl.SslClientHelloHandler r0 = p013io.netty.handler.ssl.SslClientHelloHandler.this
                            boolean r0 = p013io.netty.handler.ssl.SslClientHelloHandler.access$200(r0)
                            if (r0 == 0) goto L_0x008e
                            r0 = r5
                            io.netty.handler.ssl.SslClientHelloHandler r0 = p013io.netty.handler.ssl.SslClientHelloHandler.this
                            r1 = 0
                            boolean r0 = p013io.netty.handler.ssl.SslClientHelloHandler.access$202(r0, r1)
                            r0 = r5
                            io.netty.channel.ChannelHandlerContext r0 = r8
                            io.netty.channel.ChannelHandlerContext r0 = r0.read()
                        L_0x008e:
                            r0 = r8
                            throw r0
                        L_0x0090:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.SslClientHelloHandler.C30341.operationComplete(io.netty.util.concurrent.Future):void");
                    }
                });
                clientHello = null;
            }
        } finally {
            releaseIfNotNull(clientHello);
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext ctx) throws Exception {
        releaseHandshakeBuffer();
        handlerRemoved0(ctx);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext ctx) throws Exception {
        if (this.suppressRead) {
            this.readPending = true;
        } else {
            ctx.read();
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.bind(localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.connect(remoteAddress, localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.disconnect(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.close(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.deregister(promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.write(msg, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
