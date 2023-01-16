package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.common.PointData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DungeonEntryInfoOuterClass;
import emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDungeonEntryInfoRsp.class */
public class PacketDungeonEntryInfoRsp extends BasePacket {
    public PacketDungeonEntryInfoRsp(Player player, PointData pointData) {
        super(930);
        DungeonEntryInfoRspOuterClass.DungeonEntryInfoRsp.Builder proto = DungeonEntryInfoRspOuterClass.DungeonEntryInfoRsp.newBuilder().setPointId(pointData.getId());
        if (pointData.getDungeonIds() != null) {
            for (int dungeonId : pointData.getDungeonIds()) {
                proto.addDungeonEntryList(DungeonEntryInfoOuterClass.DungeonEntryInfo.newBuilder().setDungeonId(dungeonId).build());
            }
        }
        setData(proto);
    }

    public PacketDungeonEntryInfoRsp() {
        super(930);
        setData(DungeonEntryInfoRspOuterClass.DungeonEntryInfoRsp.newBuilder().setRetcode(1).build());
    }
}
