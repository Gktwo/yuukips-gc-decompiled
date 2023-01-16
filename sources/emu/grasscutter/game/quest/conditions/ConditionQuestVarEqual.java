package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_COND_QUEST_VAR_EQUAL)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/conditions/ConditionQuestVarEqual.class */
public class ConditionQuestVarEqual extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        try {
            int index = condition.getParam()[0];
            int[] questVars = quest.getMainQuest().getQuestVars();
            if (index >= questVars.length) {
                Grasscutter.getLogger().error("questVar out of bounds for {} index {} size {}", Integer.valueOf(quest.getSubQuestId()), Integer.valueOf(index), Integer.valueOf(questVars.length));
                return false;
            }
            int questVarValue = questVars[index];
            Grasscutter.getLogger().debug("questVar {} : {}", Integer.valueOf(index), Integer.valueOf(questVarValue));
            return questVarValue == condition.getParam()[1];
        } catch (Exception e) {
            Grasscutter.getLogger().debug("Error ConditionQuestVarEqual: ", (Throwable) e);
            return false;
        }
    }
}
