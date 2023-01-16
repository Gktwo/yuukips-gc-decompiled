package p013io.netty.handler.ssl;

import java.util.List;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.handler.codec.ByteToMessageDecoder;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.OptionalSslHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OptionalSslHandler.class */
public class OptionalSslHandler extends ByteToMessageDecoder {
    private final SslContext sslContext;

    public OptionalSslHandler(SslContext sslContext) {
        this.sslContext = (SslContext) ObjectUtil.checkNotNull(sslContext, "sslContext");
    }

    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext context, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() >= 5) {
            if (SslHandler.isEncrypted(in)) {
                handleSsl(context);
            } else {
                handleNonSsl(context);
            }
        }
    }

    private void handleSsl(ChannelHandlerContext context) {
        SslHandler sslHandler = null;
        try {
            context.pipeline().replace(this, newSslHandlerName(), newSslHandler(context, this.sslContext));
            sslHandler = null;
            if (0 != 0) {
                ReferenceCountUtil.safeRelease(sslHandler.engine());
            }
        } catch (Throwable th) {
            if (sslHandler != null) {
                ReferenceCountUtil.safeRelease(sslHandler.engine());
            }
            throw th;
        }
    }

    private void handleNonSsl(ChannelHandlerContext context) {
        ChannelHandler handler = newNonSslHandler(context);
        if (handler != null) {
            context.pipeline().replace(this, newNonSslHandlerName(), handler);
        } else {
            context.pipeline().remove(this);
        }
    }

    protected String newSslHandlerName() {
        return null;
    }

    protected SslHandler newSslHandler(ChannelHandlerContext context, SslContext sslContext) {
        return sslContext.newHandler(context.alloc());
    }

    protected String newNonSslHandlerName() {
        return null;
    }

    protected ChannelHandler newNonSslHandler(ChannelHandlerContext context) {
        return null;
    }
}
