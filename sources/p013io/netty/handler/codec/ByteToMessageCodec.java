package p013io.netty.handler.codec;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelDuplexHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.internal.TypeParameterMatcher;

/* renamed from: io.netty.handler.codec.ByteToMessageCodec */
/* loaded from: grasscutter.jar:io/netty/handler/codec/ByteToMessageCodec.class */
public abstract class ByteToMessageCodec<I> extends ChannelDuplexHandler {
    private final TypeParameterMatcher outboundMsgMatcher;
    private final MessageToByteEncoder<I> encoder;
    private final ByteToMessageDecoder decoder;

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i, ByteBuf byteBuf) throws Exception;

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

    protected ByteToMessageCodec() {
        this(true);
    }

    protected ByteToMessageCodec(Class<? extends I> outboundMessageType) {
        this(outboundMessageType, true);
    }

    protected ByteToMessageCodec(boolean preferDirect) {
        this.decoder = new ByteToMessageDecoder() { // from class: io.netty.handler.codec.ByteToMessageCodec.1
            @Override // p013io.netty.handler.codec.ByteToMessageDecoder
            public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
                ByteToMessageCodec.this.decode(ctx, in, out);
            }

            @Override // p013io.netty.handler.codec.ByteToMessageDecoder
            protected void decodeLast(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
                ByteToMessageCodec.this.decodeLast(ctx, in, out);
            }
        };
        ensureNotSharable();
        this.outboundMsgMatcher = TypeParameterMatcher.find(this, ByteToMessageCodec.class, "I");
        this.encoder = new Encoder(preferDirect);
    }

    protected ByteToMessageCodec(Class<? extends I> outboundMessageType, boolean preferDirect) {
        this.decoder = new ByteToMessageDecoder() { // from class: io.netty.handler.codec.ByteToMessageCodec.1
            @Override // p013io.netty.handler.codec.ByteToMessageDecoder
            public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
                ByteToMessageCodec.this.decode(ctx, in, out);
            }

            @Override // p013io.netty.handler.codec.ByteToMessageDecoder
            protected void decodeLast(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
                ByteToMessageCodec.this.decodeLast(ctx, in, out);
            }
        };
        ensureNotSharable();
        this.outboundMsgMatcher = TypeParameterMatcher.get(outboundMessageType);
        this.encoder = new Encoder(preferDirect);
    }

    public boolean acceptOutboundMessage(Object msg) throws Exception {
        return this.outboundMsgMatcher.match(msg);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.decoder.channelRead(ctx, msg);
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        this.encoder.write(ctx, msg, promise);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelReadComplete(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        this.decoder.channelInactive(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        try {
            this.decoder.handlerAdded(ctx);
        } finally {
            this.encoder.handlerAdded(ctx);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        try {
            this.decoder.handlerRemoved(ctx);
        } finally {
            this.encoder.handlerRemoved(ctx);
        }
    }

    protected void decodeLast(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.isReadable()) {
            decode(ctx, in, out);
        }
    }

    /* renamed from: io.netty.handler.codec.ByteToMessageCodec$Encoder */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/ByteToMessageCodec$Encoder.class */
    private final class Encoder extends MessageToByteEncoder<I> {
        Encoder(boolean preferDirect) {
            super(preferDirect);
        }

        @Override // p013io.netty.handler.codec.MessageToByteEncoder
        public boolean acceptOutboundMessage(Object msg) throws Exception {
            return ByteToMessageCodec.this.acceptOutboundMessage(msg);
        }

        @Override // p013io.netty.handler.codec.MessageToByteEncoder
        protected void encode(ChannelHandlerContext ctx, I msg, ByteBuf out) throws Exception {
            ByteToMessageCodec.this.encode(ctx, msg, out);
        }
    }
}
