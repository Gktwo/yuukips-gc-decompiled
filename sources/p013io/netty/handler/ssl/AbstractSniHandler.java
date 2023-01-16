package p013io.netty.handler.ssl;

import java.util.Locale;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.concurrent.Future;

/* renamed from: io.netty.handler.ssl.AbstractSniHandler */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/AbstractSniHandler.class */
public abstract class AbstractSniHandler<T> extends SslClientHelloHandler<T> {
    private String hostname;

    protected abstract Future<T> lookup(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    protected abstract void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<T> future) throws Exception;

    private static String extractSniHostname(ByteBuf in) {
        int offset = in.readerIndex();
        int endOffset = in.writerIndex();
        int offset2 = offset + 34;
        if (endOffset - offset2 < 6) {
            return null;
        }
        int offset3 = offset2 + in.getUnsignedByte(offset2) + 1;
        int offset4 = offset3 + in.getUnsignedShort(offset3) + 2;
        int offset5 = offset4 + in.getUnsignedByte(offset4) + 1;
        int offset6 = offset5 + 2;
        int extensionsLimit = offset6 + in.getUnsignedShort(offset5);
        if (extensionsLimit > endOffset) {
            return null;
        }
        while (extensionsLimit - offset6 >= 4) {
            int extensionType = in.getUnsignedShort(offset6);
            int offset7 = offset6 + 2;
            int extensionLength = in.getUnsignedShort(offset7);
            int offset8 = offset7 + 2;
            if (extensionsLimit - offset8 < extensionLength) {
                return null;
            }
            if (extensionType == 0) {
                int offset9 = offset8 + 2;
                if (extensionsLimit - offset9 < 3) {
                    return null;
                }
                int serverNameType = in.getUnsignedByte(offset9);
                int offset10 = offset9 + 1;
                if (serverNameType != 0) {
                    return null;
                }
                int serverNameLength = in.getUnsignedShort(offset10);
                int offset11 = offset10 + 2;
                if (extensionsLimit - offset11 < serverNameLength) {
                    return null;
                }
                return in.toString(offset11, serverNameLength, CharsetUtil.US_ASCII).toLowerCase(Locale.US);
            }
            offset6 = offset8 + extensionLength;
        }
        return null;
    }

    @Override // p013io.netty.handler.ssl.SslClientHelloHandler
    protected Future<T> lookup(ChannelHandlerContext ctx, ByteBuf clientHello) throws Exception {
        this.hostname = clientHello == null ? null : extractSniHostname(clientHello);
        return lookup(ctx, this.hostname);
    }

    @Override // p013io.netty.handler.ssl.SslClientHelloHandler
    protected void onLookupComplete(ChannelHandlerContext ctx, Future<T> future) throws Exception {
        try {
            onLookupComplete(ctx, this.hostname, future);
        } finally {
            fireSniCompletionEvent(ctx, this.hostname, future);
        }
    }

    private static void fireSniCompletionEvent(ChannelHandlerContext ctx, String hostname, Future<?> future) {
        Throwable cause = future.cause();
        if (cause == null) {
            ctx.fireUserEventTriggered((Object) new SniCompletionEvent(hostname));
        } else {
            ctx.fireUserEventTriggered((Object) new SniCompletionEvent(hostname, cause));
        }
    }
}
