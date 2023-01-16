package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.SceneScriptManager;
import emu.grasscutter.scripts.data.ScriptArgs;

@QuestValue(QuestTrigger.QUEST_EXEC_NOTIFY_GROUP_LUA)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/exec/ExecNotifyGroupLua.class */
public class ExecNotifyGroupLua extends QuestExecHandler {
    @Override // emu.grasscutter.game.quest.handlers.QuestExecHandler
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        int sceneId = Integer.parseInt(paramStr[0]);
        int groupId = Integer.parseInt(paramStr[1]);
        Scene scene = quest.getOwner().getScene();
        SceneScriptManager scriptManager = scene.getScriptManager();
        if (scene.getId() != sceneId) {
            return false;
        }
        scene.runWhenFinished(() -> {
            int eventType;
            scriptManager.refreshGroup(scriptManager.getGroupById(groupId));
            if (quest.getState() == QuestState.QUEST_STATE_FINISHED) {
                eventType = 21;
            } else {
                eventType = 28;
            }
            scriptManager.callEvent(new ScriptArgs(eventType, quest.getSubQuestId()));
        });
        return true;
    }
}
