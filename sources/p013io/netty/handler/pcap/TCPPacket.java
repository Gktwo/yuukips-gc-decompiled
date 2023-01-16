package p013io.netty.handler.pcap;

import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.pcap.TCPPacket */
/* loaded from: grasscutter.jar:io/netty/handler/pcap/TCPPacket.class */
final class TCPPacket {
    private static final short OFFSET = 20480;

    private TCPPacket() {
    }

    /* access modifiers changed from: package-private */
    public static void writePacket(ByteBuf byteBuf, ByteBuf payload, int segmentNumber, int ackNumber, int srcPort, int dstPort, TCPFlag... tcpFlags) {
        byteBuf.writeShort(srcPort);
        byteBuf.writeShort(dstPort);
        byteBuf.writeInt(segmentNumber);
        byteBuf.writeInt(ackNumber);
        byteBuf.writeShort(OFFSET | TCPFlag.getFlag(tcpFlags));
        byteBuf.writeShort(65535);
        byteBuf.writeShort(1);
        byteBuf.writeShort(0);
        if (payload != null) {
            byteBuf.writeBytes(payload);
        }
    }

    /* renamed from: io.netty.handler.pcap.TCPPacket$TCPFlag */
    /* loaded from: grasscutter.jar:io/netty/handler/pcap/TCPPacket$TCPFlag.class */
    enum TCPFlag {
        FIN(1),
        SYN(2),
        RST(4),
        PSH(8),
        ACK(16),
        URG(32),
        ECE(64),
        CWR(128);
        
        private final int value;

        TCPFlag(int value) {
            this.value = value;
        }

        static int getFlag(TCPFlag... tcpFlags) {
            int flags = 0;
            for (TCPFlag tcpFlag : tcpFlags) {
                flags |= tcpFlag.value;
            }
            return flags;
        }
    }
}
