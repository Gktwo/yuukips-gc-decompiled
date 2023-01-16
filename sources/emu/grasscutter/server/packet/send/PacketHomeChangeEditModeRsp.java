package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChangeEditModeRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeChangeEditModeRsp.class */
public class PacketHomeChangeEditModeRsp extends BasePacket {
    public PacketHomeChangeEditModeRsp(boolean enterEditMode) {
        super(PacketOpcodes.HomeChangeEditModeRsp);
        HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.Builder proto = HomeChangeEditModeRspOuterClass.HomeChangeEditModeRsp.newBuilder();
        proto.setIsEnterEditMode(enterEditMode);
        setData(proto);
    }
}
