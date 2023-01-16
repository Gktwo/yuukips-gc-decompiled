package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.WorldPlayerReviveRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldPlayerReviveRsp.class */
public class PacketWorldPlayerReviveRsp extends BasePacket {
    public PacketWorldPlayerReviveRsp() {
        super(PacketOpcodes.WorldPlayerReviveRsp);
        setData(WorldPlayerReviveRspOuterClass.WorldPlayerReviveRsp.newBuilder().build());
    }
}
