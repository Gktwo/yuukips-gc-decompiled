package emu.grasscutter.game.quest.content;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_KILL_MONSTER)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentKillMonster.class */
public class ContentKillMonster extends QuestBaseHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    public boolean execute(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        Grasscutter.getLogger().warn("QUEST_CONTENT_KILL_MONSTER: quest {} trigger params0 {} = condition0 {}", Integer.valueOf(quest.getSubQuestId()), Integer.valueOf(params[0]), Integer.valueOf(condition.getParam()[0]));
        return condition.getParam()[0] == params[0];
    }
}
