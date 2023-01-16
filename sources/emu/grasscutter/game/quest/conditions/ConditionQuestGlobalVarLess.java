package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_COND_QUEST_GLOBAL_VAR_LESS)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/conditions/ConditionQuestGlobalVarLess.class */
public class ConditionQuestGlobalVarLess extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        Integer questGlobalVarValue = quest.getMainQuest().getQuestManager().getQuestGlobalVarValue(Integer.valueOf(condition.getParam()[0]));
        Grasscutter.getLogger().debug("questGlobarVar {} : {}", Integer.valueOf(condition.getParam()[0]), questGlobalVarValue);
        return questGlobalVarValue.intValue() < condition.getParam()[1];
    }
}
