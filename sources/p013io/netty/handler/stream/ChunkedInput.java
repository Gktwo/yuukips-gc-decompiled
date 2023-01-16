package p013io.netty.handler.stream;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelHandlerContext;

/* renamed from: io.netty.handler.stream.ChunkedInput */
/* loaded from: grasscutter.jar:io/netty/handler/stream/ChunkedInput.class */
public interface ChunkedInput<B> {
    boolean isEndOfInput() throws Exception;

    void close() throws Exception;

    @Deprecated
    B readChunk(ChannelHandlerContext channelHandlerContext) throws Exception;

    B readChunk(ByteBufAllocator byteBufAllocator) throws Exception;

    long length();

    long progress();
}
