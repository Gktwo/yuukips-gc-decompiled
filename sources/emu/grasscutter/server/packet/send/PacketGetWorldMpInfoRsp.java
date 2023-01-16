package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.world.World;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetWorldMpInfoRsp.class */
public class PacketGetWorldMpInfoRsp extends BasePacket {
    public PacketGetWorldMpInfoRsp(World world) {
        super(PacketOpcodes.GetWorldMpInfoRsp);
        setData(GetWorldMpInfoRspOuterClass.GetWorldMpInfoRsp.newBuilder().setIsInMpMode(world.isMultiplayer()).build());
    }
}
