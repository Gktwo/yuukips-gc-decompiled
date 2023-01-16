package p013io.netty.handler.ssl.ocsp;

import javax.net.ssl.SSLHandshakeException;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.handler.ssl.ReferenceCountedOpenSslEngine;
import p013io.netty.handler.ssl.SslHandshakeCompletionEvent;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.ocsp.OcspClientHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ocsp/OcspClientHandler.class */
public abstract class OcspClientHandler extends ChannelInboundHandlerAdapter {
    private final ReferenceCountedOpenSslEngine engine;

    protected abstract boolean verify(ChannelHandlerContext channelHandlerContext, ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) throws Exception;

    protected OcspClientHandler(ReferenceCountedOpenSslEngine engine) {
        this.engine = (ReferenceCountedOpenSslEngine) ObjectUtil.checkNotNull(engine, "engine");
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof SslHandshakeCompletionEvent) {
            ctx.pipeline().remove(this);
            if (((SslHandshakeCompletionEvent) evt).isSuccess() && !verify(ctx, this.engine)) {
                throw new SSLHandshakeException("Bad OCSP response");
            }
        }
        ctx.fireUserEventTriggered(evt);
    }
}
