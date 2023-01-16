package emu.grasscutter.game.quest.content;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_TRIGGER_FIRE)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentTriggerFire.class */
public class ContentTriggerFire extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        String getid = quest.getTriggerNameById(params[0]);
        if (quest.getTriggers().containsKey(getid)) {
            return quest.getTriggers().get(getid).booleanValue();
        }
        Grasscutter.getLogger().warn("quest {} doesn't have trigger {}", Integer.valueOf(quest.getSubQuestId()), Integer.valueOf(params[0]));
        return false;
    }
}
