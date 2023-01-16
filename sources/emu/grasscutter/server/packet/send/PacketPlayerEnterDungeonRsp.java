package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerEnterDungeonRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerEnterDungeonRsp.class */
public class PacketPlayerEnterDungeonRsp extends BasePacket {
    public PacketPlayerEnterDungeonRsp(int pointId, int dungeonId) {
        super(PacketOpcodes.PlayerEnterDungeonRsp);
        setData(PlayerEnterDungeonRspOuterClass.PlayerEnterDungeonRsp.newBuilder().setPointId(pointId).setDungeonId(dungeonId).build());
    }
}
