package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import java.util.Arrays;

@QuestValue(QuestTrigger.QUEST_EXEC_ADD_QUEST_PROGRESS)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecAddQuestProgress.class */
public class ExecAddQuestProgress extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        quest.getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_ADD_QUEST_PROGRESS, Arrays.stream(paramStr).filter(i -> {
            return !i.isBlank();
        }).mapToInt(Integer::parseInt).toArray());
        return true;
    }
}
