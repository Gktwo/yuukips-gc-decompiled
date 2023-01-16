package emu.grasscutter.game.quest.content;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_QUEST_STATE_NOT_EQUAL)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentQuestStateNotEqual.class */
public class ContentQuestStateNotEqual extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        GameQuest checkQuest = quest.getOwner().getQuestManager().getQuestById(params[0]);
        return (checkQuest == null || checkQuest.getState().getValue() == params[1]) ? false : true;
    }
}
