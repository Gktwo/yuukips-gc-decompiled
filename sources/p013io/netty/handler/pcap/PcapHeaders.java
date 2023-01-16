package p013io.netty.handler.pcap;

import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.pcap.PcapHeaders */
/* loaded from: grasscutter.jar:io/netty/handler/pcap/PcapHeaders.class */
final class PcapHeaders {
    private static final byte[] GLOBAL_HEADER = {-95, -78, -61, -44, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 1};

    private PcapHeaders() {
    }

    public static void writeGlobalHeader(ByteBuf byteBuf) {
        byteBuf.writeBytes(GLOBAL_HEADER);
    }

    /* access modifiers changed from: package-private */
    public static void writePacketHeader(ByteBuf byteBuf, int ts_sec, int ts_usec, int incl_len, int orig_len) {
        byteBuf.writeInt(ts_sec);
        byteBuf.writeInt(ts_usec);
        byteBuf.writeInt(incl_len);
        byteBuf.writeInt(orig_len);
    }
}
