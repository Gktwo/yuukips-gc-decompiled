package emu.grasscutter.game.quest.exec;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

@QuestValue(QuestTrigger.QUEST_EXEC_ADD_CUR_AVATAR_ENERGY)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecAddCurAvatarEnergy.class */
public class ExecAddCurAvatarEnergy extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        Grasscutter.getLogger().info("Energy refilled");
        return quest.getOwner().getEnergyManager().refillEntityAvatarEnergy();
    }
}
