package emu.grasscutter.game.dungeons.dungeon_results;

import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.game.dungeons.DungeonEndStats;
import emu.grasscutter.game.dungeons.SettleShowType;
import emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass;
import emu.grasscutter.net.proto.ParamListOuterClass;
import emu.grasscutter.utils.Utils;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/dungeon_results/BaseDungeonResult.class */
public class BaseDungeonResult {
    DungeonData dungeonData;
    DungeonEndStats dungeonStats;

    public DungeonData getDungeonData() {
        return this.dungeonData;
    }

    public DungeonEndStats getDungeonStats() {
        return this.dungeonStats;
    }

    public BaseDungeonResult(DungeonData dungeonData, DungeonEndStats dungeonStats) {
        this.dungeonData = dungeonData;
        this.dungeonStats = dungeonStats;
    }

    protected void onProto(DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder builder) {
    }

    public final DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder getProto() {
        ParamListOuterClass.ParamList paramList;
        boolean success = this.dungeonStats.getDungeonResult().isSuccess();
        DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder builder = DungeonSettleNotifyOuterClass.DungeonSettleNotify.newBuilder().setDungeonId(this.dungeonData.getId()).setIsSuccess(success).setCloseTime(getCloseTime()).setResult(success ? 1 : 0);
        if (this.dungeonData.getSettleShows() != null) {
            for (int i = 0; i < this.dungeonData.getSettleShows().size(); i++) {
                SettleShowType settle = this.dungeonData.getSettleShows().get(i);
                int i2 = i + 1;
                switch (settle) {
                    case SETTLE_SHOW_TIME_COST:
                        paramList = ParamListOuterClass.ParamList.newBuilder().addParamList(settle.getId()).addParamList(this.dungeonStats.getTimeTaken()).build();
                        break;
                    case SETTLE_SHOW_KILL_MONSTER_COUNT:
                        paramList = ParamListOuterClass.ParamList.newBuilder().addParamList(settle.getId()).addParamList(this.dungeonStats.getKilledMonsters()).build();
                        break;
                    default:
                        paramList = ParamListOuterClass.ParamList.newBuilder().addParamList(settle.getId()).build();
                        break;
                }
                builder.putSettleShow(i2, paramList);
            }
        }
        onProto(builder);
        return builder;
    }

    public int getCloseTime() {
        int i;
        int currentSeconds = Utils.getCurrentSeconds();
        switch (this.dungeonStats.getDungeonResult()) {
            case COMPLETED:
                i = this.dungeonData.getSettleCountdownTime();
                break;
            case FAILED:
                i = this.dungeonData.getFailSettleCountdownTime();
                break;
            case QUIT:
                i = this.dungeonData.getQuitSettleCountdownTime();
                break;
            default:
                throw new IncompatibleClassChangeError();
        }
        return currentSeconds + i;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/dungeon_results/BaseDungeonResult$DungeonEndReason.class */
    public enum DungeonEndReason {
        COMPLETED,
        FAILED,
        QUIT;

        public boolean isSuccess() {
            return this == COMPLETED;
        }
    }
}
