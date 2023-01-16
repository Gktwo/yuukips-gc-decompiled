package emu.grasscutter.game.dungeons.dungeon_results;

import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.game.dungeons.DungeonEndStats;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.tower.TowerManager;
import emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/dungeon_results/TowerResult.class */
public class TowerResult extends BaseDungeonResult {
    WorldChallenge challenge;
    boolean canJump;
    boolean hasNextLevel;
    int nextFloorId;

    public TowerResult(DungeonData dungeonData, DungeonEndStats dungeonStats, TowerManager towerManager, WorldChallenge challenge) {
        super(dungeonData, dungeonStats);
        this.challenge = challenge;
        this.canJump = towerManager.hasNextFloor();
        this.hasNextLevel = towerManager.hasNextLevel();
        this.nextFloorId = this.hasNextLevel ? 0 : towerManager.getNextFloorId();
    }

    @Override // emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult
    protected void onProto(DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder builder) {
        int continueStatus = 0;
        if (this.challenge.isSuccess() && this.canJump) {
            if (this.hasNextLevel) {
                continueStatus = 1;
            } else {
                continueStatus = 2;
            }
        }
        TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.Builder towerLevelEndNotify = TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.newBuilder().setIsSuccess(this.challenge.isSuccess()).setContinueState(continueStatus).addFinishedStarCondList(1).addFinishedStarCondList(2).addFinishedStarCondList(3).addRewardItemList(ItemParamOuterClass.ItemParam.newBuilder().setItemId(201).setCount(1000).build());
        if (this.nextFloorId > 0 && this.canJump) {
            towerLevelEndNotify.setNextFloorId(this.nextFloorId);
        }
        builder.setTowerLevelEndNotify(towerLevelEndNotify);
    }
}
