package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChooseModuleRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeChooseModuleRsp.class */
public class PacketHomeChooseModuleRsp extends BasePacket {
    public PacketHomeChooseModuleRsp(int moduleId) {
        super(PacketOpcodes.HomeChooseModuleRsp);
        setData(HomeChooseModuleRspOuterClass.HomeChooseModuleRsp.newBuilder().setRetcode(0).setModuleId(moduleId).build());
    }
}
