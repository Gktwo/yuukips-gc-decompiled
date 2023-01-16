package emu.grasscutter.game.dungeons.pass_condition;

import emu.grasscutter.data.excels.DungeonPassConfigData;
import emu.grasscutter.game.dungeons.DungeonPassConditionType;
import emu.grasscutter.game.dungeons.DungeonValue;
import emu.grasscutter.game.dungeons.handlers.DungeonBaseHandler;

@DungeonValue(DungeonPassConditionType.DUNGEON_COND_FINISH_CHALLENGE)
/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/pass_condition/ConditionFinishChallenge.class */
public class ConditionFinishChallenge extends DungeonBaseHandler {
    @Override // emu.grasscutter.game.dungeons.handlers.DungeonBaseHandler
    public boolean execute(DungeonPassConfigData.DungeonPassCondition condition, int... params) {
        return params[0] == condition.getParam()[0] || params[1] == condition.getParam()[0];
    }
}
