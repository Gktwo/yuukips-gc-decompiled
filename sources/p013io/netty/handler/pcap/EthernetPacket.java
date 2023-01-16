package p013io.netty.handler.pcap;

import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.pcap.EthernetPacket */
/* loaded from: grasscutter.jar:io/netty/handler/pcap/EthernetPacket.class */
final class EthernetPacket {
    private static final byte[] DUMMY_SOURCE_MAC_ADDRESS = {0, 0, 94, 0, 83, 0};
    private static final byte[] DUMMY_DESTINATION_MAC_ADDRESS = {0, 0, 94, 0, 83, -1};

    /* renamed from: V4 */
    private static final int f1012V4 = 2048;

    /* renamed from: V6 */
    private static final int f1013V6 = 34525;

    private EthernetPacket() {
    }

    /* access modifiers changed from: package-private */
    public static void writeIPv4(ByteBuf byteBuf, ByteBuf payload) {
        writePacket(byteBuf, payload, DUMMY_SOURCE_MAC_ADDRESS, DUMMY_DESTINATION_MAC_ADDRESS, 2048);
    }

    /* access modifiers changed from: package-private */
    public static void writeIPv6(ByteBuf byteBuf, ByteBuf payload) {
        writePacket(byteBuf, payload, DUMMY_SOURCE_MAC_ADDRESS, DUMMY_DESTINATION_MAC_ADDRESS, f1013V6);
    }

    private static void writePacket(ByteBuf byteBuf, ByteBuf payload, byte[] srcAddress, byte[] dstAddress, int type) {
        byteBuf.writeBytes(dstAddress);
        byteBuf.writeBytes(srcAddress);
        byteBuf.writeShort(type);
        byteBuf.writeBytes(payload);
    }
}
