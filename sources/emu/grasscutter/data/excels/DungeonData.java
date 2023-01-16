package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.dungeons.DungeonInvolveType;
import emu.grasscutter.game.dungeons.DungeonPlayType;
import emu.grasscutter.game.dungeons.DungeonSubType;
import emu.grasscutter.game.dungeons.DungeonType;
import emu.grasscutter.game.dungeons.SettleShowType;
import java.util.List;

@ResourceType(name = {"DungeonExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DungeonData.class */
public class DungeonData extends GameResource {

    /* renamed from: id */
    private int f532id;
    private int sceneId;
    private int showLevel;
    private DungeonType type;
    private DungeonSubType subType;
    private DungeonPlayType playType;
    private DungeonInvolveType involveType;
    private int limitLevel;
    private int passCond;
    private int reviveMaxCount;
    private int settleCountdownTime;
    private int failSettleCountdownTime;
    private int quitSettleCountdownTime;
    private List<SettleShowType> settleShows;
    @SerializedName(value = "passRewardPreviewID", alternate = {"passRewardPreviewId"})
    private int passRewardPreviewID;
    private int statueCostID;
    private int statueCostCount;
    private RewardPreviewData rewardPreviewData;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f532id;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public int getShowLevel() {
        return this.showLevel;
    }

    public int getLimitLevel() {
        return this.limitLevel;
    }

    public int getPassCond() {
        return this.passCond;
    }

    public int getReviveMaxCount() {
        return this.reviveMaxCount;
    }

    public int getSettleCountdownTime() {
        return this.settleCountdownTime;
    }

    public int getFailSettleCountdownTime() {
        return this.failSettleCountdownTime;
    }

    public int getQuitSettleCountdownTime() {
        return this.quitSettleCountdownTime;
    }

    public List<SettleShowType> getSettleShows() {
        return this.settleShows;
    }

    public int getPassRewardPreviewID() {
        return this.passRewardPreviewID;
    }

    public int getStatueCostID() {
        return this.statueCostID;
    }

    public int getStatueCostCount() {
        return this.statueCostCount;
    }

    public RewardPreviewData getRewardPreviewData() {
        return this.rewardPreviewData;
    }

    public DungeonType getType() {
        if (this.type == null) {
            return DungeonType.DUNGEON_NONE;
        }
        return this.type;
    }

    public DungeonSubType getSubType() {
        if (this.subType == null) {
            return DungeonSubType.DUNGEON_SUB_NONE;
        }
        return this.subType;
    }

    public DungeonPlayType getPlayType() {
        if (this.playType == null) {
            return DungeonPlayType.DUNGEON_PLAY_TYPE_NONE;
        }
        return this.playType;
    }

    public DungeonInvolveType getInvolveType() {
        if (this.involveType == null) {
            return DungeonInvolveType.INVOLVE_NONE;
        }
        return this.involveType;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        if (this.passRewardPreviewID > 0) {
            this.rewardPreviewData = GameData.getRewardPreviewDataMap().get(this.passRewardPreviewID);
        }
    }
}
