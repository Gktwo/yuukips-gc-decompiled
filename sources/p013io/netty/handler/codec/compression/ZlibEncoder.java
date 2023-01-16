package p013io.netty.handler.codec.compression;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.handler.codec.MessageToByteEncoder;

/* renamed from: io.netty.handler.codec.compression.ZlibEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/ZlibEncoder.class */
public abstract class ZlibEncoder extends MessageToByteEncoder<ByteBuf> {
    public abstract boolean isClosed();

    public abstract ChannelFuture close();

    public abstract ChannelFuture close(ChannelPromise channelPromise);

    /* access modifiers changed from: protected */
    public ZlibEncoder() {
        super(false);
    }
}
