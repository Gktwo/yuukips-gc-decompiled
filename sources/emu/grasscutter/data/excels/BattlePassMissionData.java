package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.BattlePassMissionRefreshType;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.net.proto.BattlePassMissionOuterClass;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@ResourceType(name = {"BattlePassMissionExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/BattlePassMissionData.class */
public class BattlePassMissionData extends GameResource {

    /* renamed from: id */
    private int f515id;
    private int addPoint;
    private int scheduleId;
    private int progress;
    private TriggerConfig triggerConfig;
    private BattlePassMissionRefreshType refreshType;
    private transient Set<Integer> mainParams;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f515id;
    }

    public int getAddPoint() {
        return this.addPoint;
    }

    public int getScheduleId() {
        return this.scheduleId;
    }

    public int getProgress() {
        return this.progress;
    }

    public TriggerConfig getTriggerConfig() {
        return this.triggerConfig;
    }

    public BattlePassMissionRefreshType getRefreshType() {
        return this.refreshType;
    }

    public Set<Integer> getMainParams() {
        return this.mainParams;
    }

    public WatcherTriggerType getTriggerType() {
        return getTriggerConfig().getTriggerType();
    }

    public boolean isCycleRefresh() {
        return getRefreshType() == null || getRefreshType() == BattlePassMissionRefreshType.BATTLE_PASS_MISSION_REFRESH_CYCLE_CROSS_SCHEDULE;
    }

    public boolean isValidRefreshType() {
        return getRefreshType() == null || getRefreshType() == BattlePassMissionRefreshType.BATTLE_PASS_MISSION_REFRESH_CYCLE_CROSS_SCHEDULE || getScheduleId() == 2701;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        if (getTriggerConfig() != null && getTriggerConfig().getParamList()[0].length() > 0) {
            this.mainParams = (Set) Arrays.stream(getTriggerConfig().getParamList()[0].split("[:;,]")).map(Integer::parseInt).collect(Collectors.toSet());
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/BattlePassMissionData$TriggerConfig.class */
    public static class TriggerConfig {
        private WatcherTriggerType triggerType;
        private String[] paramList;

        public WatcherTriggerType getTriggerType() {
            return this.triggerType;
        }

        public String[] getParamList() {
            return this.paramList;
        }
    }

    public BattlePassMissionOuterClass.BattlePassMission toProto() {
        BattlePassMissionOuterClass.BattlePassMission.Builder protoBuilder = BattlePassMissionOuterClass.BattlePassMission.newBuilder();
        protoBuilder.setMissionId(getId()).setTotalProgress(getProgress()).setRewardBattlePassPoint(getAddPoint()).setMissionStatus(BattlePassMissionOuterClass.BattlePassMission.MissionStatus.MISSION_STATUS_UNFINISHED).setMissionType(getRefreshType() == null ? 0 : getRefreshType().getValue());
        return protoBuilder.build();
    }
}
