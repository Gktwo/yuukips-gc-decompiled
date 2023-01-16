package emu.grasscutter.game.quest.exec;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestGroupSuite;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.scripts.SceneScriptManager;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.server.packet.send.PacketGroupSuiteNotify;

@QuestValue(QuestTrigger.QUEST_EXEC_REFRESH_GROUP_SUITE)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecRefreshGroupSuite.class */
public class ExecRefreshGroupSuite extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        int sceneId = Integer.parseInt(paramStr[0]);
        String[] entries = paramStr[1].split(";");
        for (String entry : entries) {
            int groupId = Integer.parseInt(entry.split(",")[0]);
            int suiteId = Integer.parseInt(entry.split(",")[1]);
            SceneScriptManager scriptManager = quest.getOwner().getScene().getScriptManager();
            quest.getMainQuest().getQuestGroupSuites().add(QuestGroupSuite.m1195of().scene(sceneId).group(groupId).suite(suiteId).build());
            if (quest.getOwner().getScene().getId() == sceneId) {
                SceneGroup targetGroup = scriptManager.getGroupById(groupId);
                if (targetGroup == null) {
                    Grasscutter.getLogger().warn("trying to load unknown group {} in scene {}", Integer.valueOf(groupId), Integer.valueOf(sceneId));
                } else {
                    scriptManager.refreshGroup(targetGroup, suiteId);
                    quest.getOwner().sendPacket(new PacketGroupSuiteNotify(groupId, suiteId));
                }
            }
        }
        return true;
    }
}
