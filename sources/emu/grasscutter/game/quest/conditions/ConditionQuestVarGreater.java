package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_COND_QUEST_VAR_GREATER)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/conditions/ConditionQuestVarGreater.class */
public class ConditionQuestVarGreater extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        int questVarValue = quest.getMainQuest().getQuestVars()[condition.getParam()[0]];
        Grasscutter.getLogger().debug("questVar {} : {}", Integer.valueOf(condition.getParam()[0]), Integer.valueOf(questVarValue));
        return questVarValue > condition.getParam()[1];
    }
}
