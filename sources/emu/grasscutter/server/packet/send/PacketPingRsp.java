package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PingRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPingRsp.class */
public class PacketPingRsp extends BasePacket {
    public PacketPingRsp(int clientSeq, int time) {
        super(43, clientSeq);
        setData(PingRspOuterClass.PingRsp.newBuilder().setClientTime(time).build().toByteArray());
    }
}
