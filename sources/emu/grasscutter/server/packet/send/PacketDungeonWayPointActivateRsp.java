package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonWayPointActivateRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDungeonWayPointActivateRsp.class */
public class PacketDungeonWayPointActivateRsp extends BasePacket {
    public PacketDungeonWayPointActivateRsp(boolean success, int pointId) {
        super(PacketOpcodes.DungeonWayPointActivateRsp);
        setData(DungeonWayPointActivateRspOuterClass.DungeonWayPointActivateRsp.newBuilder().setWayPointId(pointId).setRetcode(success ? 0 : -1));
    }
}
