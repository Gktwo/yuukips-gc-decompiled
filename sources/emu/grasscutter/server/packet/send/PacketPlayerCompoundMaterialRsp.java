package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CompoundQueueDataOuterClass;
import emu.grasscutter.net.proto.PlayerCompoundMaterialRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerCompoundMaterialRsp.class */
public class PacketPlayerCompoundMaterialRsp extends BasePacket {
    public PacketPlayerCompoundMaterialRsp(CompoundQueueDataOuterClass.CompoundQueueData compoundQueueData) {
        super(150);
        setData(PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRsp.newBuilder().setCompoundQueueData(compoundQueueData).setRetcode(0).build());
    }

    public PacketPlayerCompoundMaterialRsp(int retcode) {
        super(150);
        setData(PlayerCompoundMaterialRspOuterClass.PlayerCompoundMaterialRsp.newBuilder().setRetcode(retcode).build());
    }
}
