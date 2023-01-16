package p013io.netty.handler.pcap;

import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.pcap.UDPPacket */
/* loaded from: grasscutter.jar:io/netty/handler/pcap/UDPPacket.class */
final class UDPPacket {
    private static final short UDP_HEADER_SIZE = 8;

    private UDPPacket() {
    }

    /* access modifiers changed from: package-private */
    public static void writePacket(ByteBuf byteBuf, ByteBuf payload, int srcPort, int dstPort) {
        byteBuf.writeShort(srcPort);
        byteBuf.writeShort(dstPort);
        byteBuf.writeShort(8 + payload.readableBytes());
        byteBuf.writeShort(1);
        byteBuf.writeBytes(payload);
    }
}
