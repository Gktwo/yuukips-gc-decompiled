package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_COND_PLAYER_LEVEL_EQUAL_GREATER)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/conditions/ConditionPlayerLevelEqualGreater.class */
public class ConditionPlayerLevelEqualGreater extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        return quest.getOwner().getLevel() >= condition.getParam()[0];
    }
}
