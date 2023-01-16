package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValue(QuestTrigger.QUEST_EXEC_SET_QUEST_GLOBAL_VAR)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecSetQuestGlobalVar.class */
public class ExecSetQuestGlobalVar extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        quest.getOwner().getQuestManager().setQuestGlobalVarValue(Integer.valueOf(paramStr[0]), Integer.valueOf(paramStr[1]));
        return true;
    }
}
