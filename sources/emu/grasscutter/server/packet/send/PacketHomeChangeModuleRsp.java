package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChangeModuleRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeChangeModuleRsp.class */
public class PacketHomeChangeModuleRsp extends BasePacket {
    public PacketHomeChangeModuleRsp(int targetModuleId) {
        super(PacketOpcodes.HomeChangeModuleRsp);
        setData(HomeChangeModuleRspOuterClass.HomeChangeModuleRsp.newBuilder().setRetcode(0).setTargetModuleId(targetModuleId).build());
    }
}
