package emu.grasscutter.game.quest.handlers;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;

/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/handlers/QuestExecHandler.class */
public abstract class QuestExecHandler {
    public abstract boolean execute(GameQuest gameQuest, QuestData.QuestExecParam questExecParam, String... strArr);
}
