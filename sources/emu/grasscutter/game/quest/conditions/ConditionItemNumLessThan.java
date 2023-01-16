package emu.grasscutter.game.quest.conditions;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_COND_ITEM_NUM_LESS_THAN)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/conditions/ConditionItemNumLessThan.class */
public class ConditionItemNumLessThan extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        GameItem checkItem = quest.getOwner().getInventory().getItemByGuid((long) condition.getParam()[0]);
        return checkItem == null || checkItem.getCount() < condition.getParam()[1];
    }
}
