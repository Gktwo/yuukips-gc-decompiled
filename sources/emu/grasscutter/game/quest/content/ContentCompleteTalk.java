package emu.grasscutter.game.quest.content;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_COMPLETE_TALK)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentCompleteTalk.class */
public class ContentCompleteTalk extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        GameMainQuest checkMainQuest = quest.getOwner().getQuestManager().getMainQuestById(params[0] / 100);
        if (checkMainQuest == null) {
            Grasscutter.getLogger().warn("QUEST_CONTENT_COMPLETE_TALK {} not found", Integer.valueOf(params[0]));
            return false;
        } else if (checkMainQuest.getTalks() != null) {
            return checkMainQuest.getTalks().get(Integer.valueOf(condition.getParam()[0])) != null;
        } else {
            Grasscutter.getLogger().warn("QUEST_CONTENT_COMPLETE_TALK {} no talks", Integer.valueOf(params[0]));
            return false;
        }
    }
}
