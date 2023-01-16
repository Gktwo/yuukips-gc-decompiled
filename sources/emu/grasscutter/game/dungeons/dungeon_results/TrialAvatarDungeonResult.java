package emu.grasscutter.game.dungeons.dungeon_results;

import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.game.dungeons.DungeonEndStats;
import emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult;
import emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass;
import emu.grasscutter.net.proto.TrialAvatarFirstPassDungeonNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/dungeon_results/TrialAvatarDungeonResult.class */
public class TrialAvatarDungeonResult extends BaseDungeonResult {
    int trialCharacterIndexId;

    public TrialAvatarDungeonResult(DungeonData dungeonData, DungeonEndStats dungeonStats, int trialCharacterIndexId) {
        super(dungeonData, dungeonStats);
        this.trialCharacterIndexId = trialCharacterIndexId;
    }

    @Override // emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult
    protected void onProto(DungeonSettleNotifyOuterClass.DungeonSettleNotify.Builder builder) {
        if (this.dungeonStats.getDungeonResult() == BaseDungeonResult.DungeonEndReason.COMPLETED) {
            builder.setTrialAvatarFirstPassDungeonNotify(TrialAvatarFirstPassDungeonNotifyOuterClass.TrialAvatarFirstPassDungeonNotify.newBuilder().setTrialAvatarIndexId(this.trialCharacterIndexId));
        }
    }
}
