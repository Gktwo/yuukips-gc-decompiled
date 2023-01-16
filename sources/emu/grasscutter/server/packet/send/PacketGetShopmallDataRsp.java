package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetShopmallDataRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetShopmallDataRsp.class */
public class PacketGetShopmallDataRsp extends BasePacket {
    public PacketGetShopmallDataRsp() {
        super(PacketOpcodes.GetShopmallDataRsp);
        setData(GetShopmallDataRspOuterClass.GetShopmallDataRsp.newBuilder().addAllShopTypeList(List.of(900, 1052, 902, 1001, 903)).build());
    }
}
