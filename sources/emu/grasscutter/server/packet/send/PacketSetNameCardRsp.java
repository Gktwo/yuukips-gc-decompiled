package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetNameCardRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetNameCardRsp.class */
public class PacketSetNameCardRsp extends BasePacket {
    public PacketSetNameCardRsp(int nameCardId) {
        super(PacketOpcodes.SetNameCardRsp);
        setData(SetNameCardRspOuterClass.SetNameCardRsp.newBuilder().setNameCardId(nameCardId).build());
    }
}
