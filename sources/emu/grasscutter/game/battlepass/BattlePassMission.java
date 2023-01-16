package emu.grasscutter.game.battlepass;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.BattlePassMissionData;
import emu.grasscutter.game.props.BattlePassMissionStatus;
import emu.grasscutter.net.proto.BattlePassMissionOuterClass;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/battlepass/BattlePassMission.class */
public class BattlePassMission {

    /* renamed from: id */
    private int f566id;
    private int progress;
    private BattlePassMissionStatus status;
    @Transient
    private BattlePassMissionData data;

    @Deprecated(forRemoval = true)
    public BattlePassMission() {
    }

    public BattlePassMission(int id) {
        this.f566id = id;
    }

    public int getId() {
        return this.f566id;
    }

    public BattlePassMissionData getData() {
        if (this.data == null) {
            this.data = GameData.getBattlePassMissionDataMap().get(getId());
        }
        return this.data;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int value) {
        this.progress = value;
    }

    public void addProgress(int addProgress, int maxProgress) {
        this.progress = Math.min(addProgress + this.progress, maxProgress);
    }

    public BattlePassMissionStatus getStatus() {
        if (this.status == null) {
            this.status = BattlePassMissionStatus.MISSION_STATUS_UNFINISHED;
        }
        return this.status;
    }

    public void setStatus(BattlePassMissionStatus status) {
        this.status = status;
    }

    public boolean isFinshed() {
        return getStatus().getValue() >= 2;
    }

    public BattlePassMissionOuterClass.BattlePassMission toProto() {
        BattlePassMissionOuterClass.BattlePassMission.Builder protoBuilder = BattlePassMissionOuterClass.BattlePassMission.newBuilder();
        protoBuilder.setMissionId(getId()).setCurProgress(getProgress()).setTotalProgress(getData().getProgress()).setRewardBattlePassPoint(getData().getAddPoint()).setMissionStatus(getStatus().getMissionStatus()).setMissionType(getData().getRefreshType() == null ? 0 : getData().getRefreshType().getValue());
        return protoBuilder.build();
    }
}
