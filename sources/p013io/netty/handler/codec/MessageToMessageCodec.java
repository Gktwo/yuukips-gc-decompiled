package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.channel.ChannelDuplexHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.internal.TypeParameterMatcher;

/* renamed from: io.netty.handler.codec.MessageToMessageCodec */
/* loaded from: grasscutter.jar:io/netty/handler/codec/MessageToMessageCodec.class */
public abstract class MessageToMessageCodec<INBOUND_IN, OUTBOUND_IN> extends ChannelDuplexHandler {
    private final MessageToMessageEncoder<Object> encoder;
    private final MessageToMessageDecoder<Object> decoder;
    private final TypeParameterMatcher inboundMsgMatcher;
    private final TypeParameterMatcher outboundMsgMatcher;

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, OUTBOUND_IN outbound_in, List<Object> list) throws Exception;

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, INBOUND_IN inbound_in, List<Object> list) throws Exception;

    protected MessageToMessageCodec() {
        this.encoder = new MessageToMessageEncoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.1
            @Override // p013io.netty.handler.codec.MessageToMessageEncoder
            public boolean acceptOutboundMessage(Object msg) throws Exception {
                return MessageToMessageCodec.this.acceptOutboundMessage(msg);
            }

            /* access modifiers changed from: protected */
            @Override // p013io.netty.handler.codec.MessageToMessageEncoder
            public void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
                MessageToMessageCodec.this.encode(ctx, msg, out);
            }
        };
        this.decoder = new MessageToMessageDecoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.2
            @Override // p013io.netty.handler.codec.MessageToMessageDecoder
            public boolean acceptInboundMessage(Object msg) throws Exception {
                return MessageToMessageCodec.this.acceptInboundMessage(msg);
            }

            /* access modifiers changed from: protected */
            @Override // p013io.netty.handler.codec.MessageToMessageDecoder
            public void decode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
                MessageToMessageCodec.this.decode(ctx, msg, out);
            }
        };
        this.inboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "INBOUND_IN");
        this.outboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "OUTBOUND_IN");
    }

    protected MessageToMessageCodec(Class<? extends INBOUND_IN> inboundMessageType, Class<? extends OUTBOUND_IN> outboundMessageType) {
        this.encoder = new MessageToMessageEncoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.1
            @Override // p013io.netty.handler.codec.MessageToMessageEncoder
            public boolean acceptOutboundMessage(Object msg) throws Exception {
                return MessageToMessageCodec.this.acceptOutboundMessage(msg);
            }

            /* access modifiers changed from: protected */
            @Override // p013io.netty.handler.codec.MessageToMessageEncoder
            public void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
                MessageToMessageCodec.this.encode(ctx, msg, out);
            }
        };
        this.decoder = new MessageToMessageDecoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.2
            @Override // p013io.netty.handler.codec.MessageToMessageDecoder
            public boolean acceptInboundMessage(Object msg) throws Exception {
                return MessageToMessageCodec.this.acceptInboundMessage(msg);
            }

            /* access modifiers changed from: protected */
            @Override // p013io.netty.handler.codec.MessageToMessageDecoder
            public void decode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
                MessageToMessageCodec.this.decode(ctx, msg, out);
            }
        };
        this.inboundMsgMatcher = TypeParameterMatcher.get(inboundMessageType);
        this.outboundMsgMatcher = TypeParameterMatcher.get(outboundMessageType);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.decoder.channelRead(ctx, msg);
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        this.encoder.write(ctx, msg, promise);
    }

    public boolean acceptInboundMessage(Object msg) throws Exception {
        return this.inboundMsgMatcher.match(msg);
    }

    public boolean acceptOutboundMessage(Object msg) throws Exception {
        return this.outboundMsgMatcher.match(msg);
    }
}
