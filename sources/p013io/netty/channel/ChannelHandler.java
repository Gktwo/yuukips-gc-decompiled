package p013io.netty.channel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* renamed from: io.netty.channel.ChannelHandler */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelHandler.class */
public interface ChannelHandler {

    @Target({ElementType.TYPE})
    @Inherited
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: io.netty.channel.ChannelHandler$Sharable */
    /* loaded from: grasscutter.jar:io/netty/channel/ChannelHandler$Sharable.class */
    public @interface Sharable {
    }

    void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception;

    void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception;

    @Override // p013io.netty.channel.ChannelInboundHandler
    @Deprecated
    void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception;
}
