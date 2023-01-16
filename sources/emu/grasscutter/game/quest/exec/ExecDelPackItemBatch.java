package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import p013io.javalin.http.sse.EmitterKt;

@QuestValue(QuestTrigger.QUEST_EXEC_DEL_PACK_ITEM_BATCH)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecDelPackItemBatch.class */
public class ExecDelPackItemBatch extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        boolean success = true;
        for (String itemString : paramStr[0].split(",")) {
            String[] itemFields = itemString.split(EmitterKt.COMMENT_PREFIX);
            if (!quest.getOwner().getInventory().removeItem((long) Integer.parseInt(itemFields[0]), Integer.parseInt(itemFields[1]))) {
                success = false;
            }
        }
        return success;
    }
}
