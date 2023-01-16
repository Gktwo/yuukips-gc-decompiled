package emu.grasscutter.game.quest.handlers;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;

/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/handlers/QuestBaseHandler.class */
public abstract class QuestBaseHandler {
    public abstract boolean execute(GameQuest gameQuest, QuestData.QuestCondition questCondition, String str, int... iArr);
}
