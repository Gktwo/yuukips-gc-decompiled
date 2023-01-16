package emu.grasscutter.game.quest.content;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_UNLOCK_TRANS_POINT)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentUnlockTransPoint.class */
public class ContentUnlockTransPoint extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        boolean isok = quest.getOwner().getUnlockedScenePoints(condition.getParam()[0]).contains(Integer.valueOf(condition.getParam()[1]));
        Grasscutter.getLogger().warn("QUEST_CONTENT_UNLOCK_TRANS_POINT: quest {} trigger {} with params {} | condition0 {} = condition1 {}", Boolean.valueOf(isok), Integer.valueOf(quest.getSubQuestId()), Integer.valueOf(params[0]), Integer.valueOf(condition.getParam()[0]), Integer.valueOf(condition.getParam()[1]));
        return isok;
    }
}
