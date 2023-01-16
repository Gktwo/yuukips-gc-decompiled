package emu.grasscutter.game.quest.content;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_OBTAIN_ITEM)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentObtainItem.class */
public class ContentObtainItem extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        int targetCount = condition.getCount();
        if (targetCount == 0) {
            targetCount = 1;
        }
        return condition.getParam()[0] == params[0] && targetCount <= params[1];
    }
}
