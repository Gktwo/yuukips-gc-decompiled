package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_COND_COMPLETE_TALK)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/conditions/ConditionCompleteTalk.class */
public class ConditionCompleteTalk extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        GameMainQuest checkMainQuest = quest.getOwner().getQuestManager().getMainQuestById(condition.getParam()[0] / 100);
        if (checkMainQuest != null && GameData.getMainQuestDataMap().get(checkMainQuest.getParentQuestId()).getTalks() != null) {
            return (checkMainQuest.getTalks().get(Integer.valueOf(condition.getParam()[0])) == null && checkMainQuest.getChildQuestById(params[0]) == null) ? false : true;
        }
        Grasscutter.getLogger().error("Warning: mainQuest {} hasn't been started yet, or has no talks", Integer.valueOf(condition.getParam()[0] / 100));
        return false;
    }
}
