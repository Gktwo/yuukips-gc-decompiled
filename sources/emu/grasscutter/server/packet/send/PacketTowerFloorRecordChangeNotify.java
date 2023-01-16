package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass;
import emu.grasscutter.net.proto.TowerFloorRecordOuterClass;
import emu.grasscutter.net.proto.TowerLevelRecordOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTowerFloorRecordChangeNotify.class */
public class PacketTowerFloorRecordChangeNotify extends BasePacket {
    public PacketTowerFloorRecordChangeNotify(int floorId, int stars, boolean canEnterScheduleFloor) {
        super(PacketOpcodes.TowerFloorRecordChangeNotify);
        setData(TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotify.newBuilder().addTowerFloorRecordList(TowerFloorRecordOuterClass.TowerFloorRecord.newBuilder().setFloorId(floorId).setFloorStarRewardProgress(stars).addPassedLevelRecordList(TowerLevelRecordOuterClass.TowerLevelRecord.newBuilder().setLevelId(1).addSatisfiedCondList(1).addSatisfiedCondList(2).addSatisfiedCondList(3).build()).build()).setIsFinishedEntranceFloor(canEnterScheduleFloor).build());
    }
}
