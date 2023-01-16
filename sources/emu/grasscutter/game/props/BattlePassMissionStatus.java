package emu.grasscutter.game.props;

import emu.grasscutter.net.proto.BattlePassMissionOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/BattlePassMissionStatus.class */
public enum BattlePassMissionStatus {
    MISSION_STATUS_INVALID(0, BattlePassMissionOuterClass.BattlePassMission.MissionStatus.MISSION_STATUS_INVALID),
    MISSION_STATUS_UNFINISHED(1, BattlePassMissionOuterClass.BattlePassMission.MissionStatus.MISSION_STATUS_UNFINISHED),
    MISSION_STATUS_FINISHED(2, BattlePassMissionOuterClass.BattlePassMission.MissionStatus.MISSION_STATUS_FINISHED),
    MISSION_STATUS_POINT_TAKEN(3, BattlePassMissionOuterClass.BattlePassMission.MissionStatus.MISSION_STATUS_POINT_TAKEN);
    
    private final int value;
    private final BattlePassMissionOuterClass.BattlePassMission.MissionStatus missionStatus;

    BattlePassMissionStatus(int value, BattlePassMissionOuterClass.BattlePassMission.MissionStatus missionStatus) {
        this.value = value;
        this.missionStatus = missionStatus;
    }

    public int getValue() {
        return this.value;
    }

    public BattlePassMissionOuterClass.BattlePassMission.MissionStatus getMissionStatus() {
        return this.missionStatus;
    }
}
