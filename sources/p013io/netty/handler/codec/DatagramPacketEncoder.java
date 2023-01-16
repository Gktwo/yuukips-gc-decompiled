package p013io.netty.handler.codec;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.AddressedEnvelope;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.socket.DatagramPacket;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.handler.codec.DatagramPacketEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/DatagramPacketEncoder.class */
public class DatagramPacketEncoder<M> extends MessageToMessageEncoder<AddressedEnvelope<M, InetSocketAddress>> {
    private final MessageToMessageEncoder<? super M> encoder;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, Object obj, List list) throws Exception {
        encode(channelHandlerContext, (AddressedEnvelope) ((AddressedEnvelope) obj), (List<Object>) list);
    }

    static {
        $assertionsDisabled = !DatagramPacketEncoder.class.desiredAssertionStatus();
    }

    public DatagramPacketEncoder(MessageToMessageEncoder<? super M> encoder) {
        this.encoder = (MessageToMessageEncoder) ObjectUtil.checkNotNull(encoder, "encoder");
    }

    @Override // p013io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object msg) throws Exception {
        if (!acceptOutboundMessage(msg)) {
            return false;
        }
        AddressedEnvelope envelope = (AddressedEnvelope) msg;
        return this.encoder.acceptOutboundMessage(envelope.content()) && ((envelope.sender() instanceof InetSocketAddress) || envelope.sender() == null) && (envelope.recipient() instanceof InetSocketAddress);
    }

    protected void encode(ChannelHandlerContext ctx, AddressedEnvelope<M, InetSocketAddress> msg, List<Object> out) throws Exception {
        if ($assertionsDisabled || out.isEmpty()) {
            this.encoder.encode(ctx, msg.content(), out);
            if (out.size() != 1) {
                throw new EncoderException(StringUtil.simpleClassName(this.encoder) + " must produce only one message.");
            }
            Object content = out.get(0);
            if (content instanceof ByteBuf) {
                out.set(0, new DatagramPacket((ByteBuf) content, msg.recipient(), msg.sender()));
                return;
            }
            throw new EncoderException(StringUtil.simpleClassName(this.encoder) + " must produce only ByteBuf.");
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        this.encoder.bind(ctx, localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        this.encoder.connect(ctx, remoteAddress, localAddress, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        this.encoder.disconnect(ctx, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        this.encoder.close(ctx, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        this.encoder.deregister(ctx, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext ctx) throws Exception {
        this.encoder.read(ctx);
    }

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext ctx) throws Exception {
        this.encoder.flush(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.encoder.handlerAdded(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.encoder.handlerRemoved(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        this.encoder.exceptionCaught(ctx, cause);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return this.encoder.isSharable();
    }
}
