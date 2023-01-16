package emu.grasscutter.game.quest.content;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_GAME_TIME_TICK)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentGameTimeTick.class */
public class ContentGameTimeTick extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        String[] range = condition.getParamStr().split(",");
        return params[0] >= Math.min(Integer.parseInt(range[0]), Integer.parseInt(range[1])) && params[0] <= Math.max(Integer.parseInt(range[0]), Integer.parseInt(range[1])) && params[1] >= condition.getParam()[0];
    }
}
