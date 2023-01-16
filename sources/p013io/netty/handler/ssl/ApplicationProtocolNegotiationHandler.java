package p013io.netty.handler.ssl;

import javax.net.ssl.SSLException;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.socket.ChannelInputShutdownEvent;
import p013io.netty.handler.codec.DecoderException;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.RecyclableArrayList;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.ssl.ApplicationProtocolNegotiationHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ApplicationProtocolNegotiationHandler.class */
public abstract class ApplicationProtocolNegotiationHandler extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ApplicationProtocolNegotiationHandler.class);
    private final String fallbackProtocol;
    private final RecyclableArrayList bufferedMessages = RecyclableArrayList.newInstance();
    private ChannelHandlerContext ctx;
    private boolean sslHandlerChecked;

    protected abstract void configurePipeline(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    protected ApplicationProtocolNegotiationHandler(String fallbackProtocol) {
        this.fallbackProtocol = (String) ObjectUtil.checkNotNull(fallbackProtocol, "fallbackProtocol");
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
        handlerAdded(ctx);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        fireBufferedMessages();
        this.bufferedMessages.recycle();
        handlerRemoved(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.bufferedMessages.add(msg);
        if (!this.sslHandlerChecked) {
            this.sslHandlerChecked = true;
            if (ctx.pipeline().get(SslHandler.class) == null) {
                removeSelfIfPresent(ctx);
            }
        }
    }

    private void fireBufferedMessages() {
        if (!this.bufferedMessages.isEmpty()) {
            for (int i = 0; i < this.bufferedMessages.size(); i++) {
                this.ctx.fireChannelRead(this.bufferedMessages.get(i));
            }
            this.ctx.fireChannelReadComplete();
            this.bufferedMessages.clear();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof SslHandshakeCompletionEvent) {
            SslHandshakeCompletionEvent handshakeEvent = (SslHandshakeCompletionEvent) evt;
            try {
                if (handshakeEvent.isSuccess()) {
                    SslHandler sslHandler = (SslHandler) ctx.pipeline().get(SslHandler.class);
                    if (sslHandler == null) {
                        throw new IllegalStateException("cannot find an SslHandler in the pipeline (required for application-level protocol negotiation)");
                    }
                    String protocol = sslHandler.applicationProtocol();
                    configurePipeline(ctx, protocol != null ? protocol : this.fallbackProtocol);
                }
                if (handshakeEvent.isSuccess()) {
                    removeSelfIfPresent(ctx);
                }
            } catch (Throwable th) {
                if (handshakeEvent.isSuccess()) {
                    removeSelfIfPresent(ctx);
                }
                throw th;
            }
        }
        if (evt instanceof ChannelInputShutdownEvent) {
            fireBufferedMessages();
        }
        ctx.fireUserEventTriggered(evt);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        fireBufferedMessages();
        channelInactive(ctx);
    }

    private void removeSelfIfPresent(ChannelHandlerContext ctx) {
        ChannelPipeline pipeline = ctx.pipeline();
        if (!ctx.isRemoved()) {
            pipeline.remove(this);
        }
    }

    protected void handshakeFailure(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warn("{} TLS handshake failed:", ctx.channel(), cause);
        ctx.close();
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof DecoderException) {
            Throwable wrapped = cause.getCause();
            if (wrapped instanceof SSLException) {
                try {
                    handshakeFailure(ctx, wrapped);
                    removeSelfIfPresent(ctx);
                    return;
                } catch (Throwable th) {
                    removeSelfIfPresent(ctx);
                    throw th;
                }
            }
        }
        logger.warn("{} Failed to select the application-level protocol:", ctx.channel(), cause);
        ctx.fireExceptionCaught(cause);
        ctx.close();
    }
}
