package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.tower.TowerManager;
import emu.grasscutter.game.tower.TowerSystem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerAllDataRspOuterClass;
import emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass;
import emu.grasscutter.net.proto.TowerFloorRecordOuterClass;
import emu.grasscutter.net.proto.TowerLevelRecordOuterClass;
import emu.grasscutter.utils.DateHelper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTowerAllDataRsp.class */
public class PacketTowerAllDataRsp extends BasePacket {
    public PacketTowerAllDataRsp(TowerSystem towerScheduleManager, TowerManager towerManager) {
        super(PacketOpcodes.TowerAllDataRsp);
        List<TowerFloorRecordOuterClass.TowerFloorRecord> recordList = towerManager.getRecordMap().values().stream().map(rec -> {
            return TowerFloorRecordOuterClass.TowerFloorRecord.newBuilder().setFloorId(rec.getFloorId()).setFloorStarRewardProgress(rec.getFloorStarRewardProgress()).putAllPassedLevelMap(rec.getPassedLevelMap()).addAllPassedLevelRecordList(buildFromPassedLevelMap(rec.getPassedLevelMap())).build();
        }).toList();
        setData(TowerAllDataRspOuterClass.TowerAllDataRsp.newBuilder().setTowerScheduleId(towerScheduleManager.getCurrentTowerScheduleData().getScheduleId()).addAllTowerFloorRecordList(recordList).setCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord.newBuilder().setIsEmpty(true)).setScheduleStartTime(DateHelper.getUnixTime(towerScheduleManager.getTowerScheduleConfig().getScheduleStartTime())).setNextScheduleChangeTime(DateHelper.getUnixTime(towerScheduleManager.getTowerScheduleConfig().getNextScheduleChangeTime())).putAllFloorOpenTimeMap((Map) towerScheduleManager.getScheduleFloors().stream().collect(Collectors.toMap(x -> {
            return x;
        }, y -> {
            return Integer.valueOf(DateHelper.getUnixTime(towerScheduleManager.getTowerScheduleConfig().getScheduleStartTime()));
        }))).setIsFinishedEntranceFloor(towerManager.canEnterScheduleFloor()).build());
    }

    private List<TowerLevelRecordOuterClass.TowerLevelRecord> buildFromPassedLevelMap(Map<Integer, Integer> map) {
        return map.entrySet().stream().map(item -> {
            return TowerLevelRecordOuterClass.TowerLevelRecord.newBuilder().setLevelId(((Integer) item.getKey()).intValue()).addAllSatisfiedCondList(IntStream.range(1, ((Integer) item.getValue()).intValue() + 1).boxed().toList()).build();
        }).toList();
    }
}
