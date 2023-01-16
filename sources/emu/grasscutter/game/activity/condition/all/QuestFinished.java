package emu.grasscutter.game.activity.condition.all;

import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.condition.ActivityCondition;
import emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler;
import emu.grasscutter.game.activity.condition.ActivityConditions;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.enums.QuestState;

@ActivityCondition(ActivityConditions.NEW_ACTIVITY_COND_QUEST_FINISH)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/all/QuestFinished.class */
public class QuestFinished extends ActivityConditionBaseHandler {
    @Override // emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler
    public boolean execute(PlayerActivityData activityData, ActivityConfigItem activityConfig, int... params) {
        GameQuest quest = activityData.getPlayer().getQuestManager().getQuestById(params[0]);
        return quest != null && quest.getState() == QuestState.FINISHED;
    }
}
