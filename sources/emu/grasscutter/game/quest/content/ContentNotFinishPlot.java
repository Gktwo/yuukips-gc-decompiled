package emu.grasscutter.game.quest.content;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_NOT_FINISH_PLOT)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentNotFinishPlot.class */
public class ContentNotFinishPlot extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        GameMainQuest checkMainQuest = quest.getOwner().getQuestManager().getMainQuestById(params[0] / 100);
        if (checkMainQuest != null) {
            return checkMainQuest.getTalks().get(Integer.valueOf(params[0])) == null;
        }
        Grasscutter.getLogger().warn("QUEST_CONTENT_NOT_FINISH_PLOT {} no quest found", Integer.valueOf(params[0]));
        return false;
    }
}
