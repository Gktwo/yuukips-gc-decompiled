package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.server.packet.send.PacketScenePlayerLocationNotify;
import emu.grasscutter.utils.Position;
import java.util.List;

@QuestValue(QuestTrigger.QUEST_EXEC_ROLLBACK_QUEST)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecRollbackQuest.class */
public class ExecRollbackQuest extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        GameQuest targetQuest = quest.getOwner().getQuestManager().getQuestById(Integer.parseInt(paramStr[0]));
        List<Position> targetPosition = targetQuest.getMainQuest().rewindTo(targetQuest, true);
        if (targetPosition == null) {
            return false;
        }
        quest.getOwner().getPosition().set(targetPosition.get(0));
        quest.getOwner().getRotation().set(targetPosition.get(1));
        quest.getOwner().sendPacket(new PacketScenePlayerLocationNotify(quest.getOwner().getScene()));
        return true;
    }
}
