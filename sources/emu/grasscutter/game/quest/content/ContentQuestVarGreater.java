package emu.grasscutter.game.quest.content;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_QUEST_VAR_GREATER)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentQuestVarGreater.class */
public class ContentQuestVarGreater extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        int questVarValue = quest.getMainQuest().getQuestVars()[params[0]];
        Grasscutter.getLogger().debug("questVar {} : {}", Integer.valueOf(params[0]), Integer.valueOf(questVarValue));
        return questVarValue > params[1];
    }
}
