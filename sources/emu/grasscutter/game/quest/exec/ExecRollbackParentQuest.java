package emu.grasscutter.game.quest.exec;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.server.packet.send.PacketScenePlayerLocationNotify;
import emu.grasscutter.utils.Position;
import java.util.List;

@QuestValue(QuestTrigger.QUEST_EXEC_ROLLBACK_PARENT_QUEST)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecRollbackParentQuest.class */
public class ExecRollbackParentQuest extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        if (quest == null) {
            return false;
        }
        Grasscutter.getLogger().warn("QUEST_EXEC_ROLLBACK_PARENT_QUEST: Sub_id {} ", Integer.valueOf(quest.getSubQuestId()));
        List<Position> targetPosition = quest.getMainQuest().rewind();
        if (targetPosition == null) {
            return false;
        }
        quest.getOwner().getPosition().set(targetPosition.get(0));
        quest.getOwner().getRotation().set(targetPosition.get(1));
        quest.getOwner().sendPacket(new PacketScenePlayerLocationNotify(quest.getOwner().getScene()));
        return true;
    }
}
