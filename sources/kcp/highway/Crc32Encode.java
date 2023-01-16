package kcp.highway;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundHandlerAdapter;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.socket.DatagramPacket;

/* loaded from: grasscutter.jar:kcp/highway/Crc32Encode.class */
public class Crc32Encode extends ChannelOutboundHandlerAdapter {
    private CRC32 crc32 = new CRC32();

    @Override // p013io.netty.channel.ChannelOutboundHandlerAdapter, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
        DatagramPacket datagramPacket = (DatagramPacket) msg;
        ByteBuf data = (ByteBuf) datagramPacket.content();
        ByteBuffer byteBuffer = data.nioBuffer(4, data.readableBytes() - 4);
        this.crc32.reset();
        this.crc32.update(byteBuffer);
        data.setIntLE(0, (int) this.crc32.getValue());
        ctx.write(datagramPacket, promise);
    }
}
