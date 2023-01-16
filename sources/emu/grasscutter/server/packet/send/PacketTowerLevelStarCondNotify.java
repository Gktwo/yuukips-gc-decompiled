package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerLevelStarCondDataOuterClass;
import emu.grasscutter.net.proto.TowerLevelStarCondNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTowerLevelStarCondNotify.class */
public class PacketTowerLevelStarCondNotify extends BasePacket {
    public PacketTowerLevelStarCondNotify(int floorId, int levelIndex) {
        super(PacketOpcodes.TowerLevelStarCondNotify);
        setData(TowerLevelStarCondNotifyOuterClass.TowerLevelStarCondNotify.newBuilder().setFloorId(floorId).setLevelIndex(levelIndex).addCondDataList(TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.newBuilder().build()).addCondDataList(TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.newBuilder().build()).addCondDataList(TowerLevelStarCondDataOuterClass.TowerLevelStarCondData.newBuilder().build()).build());
    }
}
