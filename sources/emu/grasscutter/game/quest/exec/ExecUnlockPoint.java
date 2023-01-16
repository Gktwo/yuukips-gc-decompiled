package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValue(QuestTrigger.QUEST_EXEC_UNLOCK_POINT)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecUnlockPoint.class */
public class ExecUnlockPoint extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        return quest.getOwner().getProgressManager().unlockTransPoint(Integer.parseInt(paramStr[0]), Integer.parseInt(paramStr[1]), quest.getMainQuestId() == 303 || quest.getMainQuestId() == 352);
    }
}
