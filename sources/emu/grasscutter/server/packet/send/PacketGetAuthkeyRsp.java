package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetAuthkeyRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetAuthkeyRsp.class */
public class PacketGetAuthkeyRsp extends BasePacket {
    public PacketGetAuthkeyRsp() {
        super(PacketOpcodes.GetAuthkeyRsp);
        setData(GetAuthkeyRspOuterClass.GetAuthkeyRsp.newBuilder().setRetcode(1).build());
    }
}
