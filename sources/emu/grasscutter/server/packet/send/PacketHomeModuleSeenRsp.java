package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeModuleSeenRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeModuleSeenRsp.class */
public class PacketHomeModuleSeenRsp extends BasePacket {
    public PacketHomeModuleSeenRsp(List<Integer> seen) {
        super(PacketOpcodes.HomeModuleSeenRsp);
        setData(HomeModuleSeenRspOuterClass.HomeModuleSeenRsp.newBuilder().addAllSeenModuleIdList(seen).build());
    }
}
