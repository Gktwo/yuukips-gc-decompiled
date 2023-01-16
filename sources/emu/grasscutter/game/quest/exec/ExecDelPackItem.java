package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValue(QuestTrigger.QUEST_EXEC_DEL_PACK_ITEM)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecDelPackItem.class */
public class ExecDelPackItem extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        int itemId = Integer.parseInt(paramStr[0]);
        return quest.getOwner().getInventory().removeItem((long) itemId, Integer.parseInt(paramStr[1]));
    }
}
