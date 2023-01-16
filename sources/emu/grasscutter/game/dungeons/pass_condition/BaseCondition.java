package emu.grasscutter.game.dungeons.pass_condition;

import emu.grasscutter.data.excels.DungeonPassConfigData;
import emu.grasscutter.game.dungeons.DungeonPassConditionType;
import emu.grasscutter.game.dungeons.DungeonValue;
import emu.grasscutter.game.dungeons.handlers.DungeonBaseHandler;

@DungeonValue(DungeonPassConditionType.DUNGEON_COND_NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/pass_condition/BaseCondition.class */
public class BaseCondition extends DungeonBaseHandler {
    @Override // emu.grasscutter.game.dungeons.handlers.DungeonBaseHandler
    public boolean execute(DungeonPassConfigData.DungeonPassCondition condition, int... params) {
        return false;
    }
}
