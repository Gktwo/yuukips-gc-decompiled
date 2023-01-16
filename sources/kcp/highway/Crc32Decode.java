package kcp.highway;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import kcp.highway.erasure.fec.Snmp;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.channel.socket.DatagramPacket;

/* loaded from: grasscutter.jar:kcp/highway/Crc32Decode.class */
public class Crc32Decode extends ChannelInboundHandlerAdapter {
    private CRC32 crc32 = new CRC32();

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof DatagramPacket) {
            ByteBuf data = (ByteBuf) ((DatagramPacket) msg).content();
            long checksum = data.readUnsignedIntLE();
            ByteBuffer byteBuffer = data.nioBuffer(data.readerIndex(), data.readableBytes());
            this.crc32.reset();
            this.crc32.update(byteBuffer);
            if (checksum != this.crc32.getValue()) {
                Snmp.snmp.getInCsumErrors().increment();
                return;
            }
        }
        ctx.fireChannelRead(msg);
    }
}
