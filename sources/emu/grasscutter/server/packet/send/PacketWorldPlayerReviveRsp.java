package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.WorldPlayerReviveRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldPlayerReviveRsp.class */
public class PacketWorldPlayerReviveRsp extends BasePacket {
    public PacketWorldPlayerReviveRsp() {
        super(221);
        setData(WorldPlayerReviveRspOuterClass.WorldPlayerReviveRsp.newBuilder().build());
    }
}
