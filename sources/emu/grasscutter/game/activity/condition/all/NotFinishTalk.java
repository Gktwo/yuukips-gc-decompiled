package emu.grasscutter.game.activity.condition.all;

import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.condition.ActivityCondition;
import emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler;
import emu.grasscutter.game.activity.condition.ActivityConditions;
import emu.grasscutter.game.quest.GameMainQuest;

@ActivityCondition(ActivityConditions.NEW_ACTIVITY_COND_NOT_FINISH_TALK)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/all/NotFinishTalk.class */
public class NotFinishTalk extends ActivityConditionBaseHandler {
    @Override // emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler
    public boolean execute(PlayerActivityData activityData, ActivityConfigItem activityConfig, int... params) {
        return activityData.getPlayer().getQuestManager().getMainQuests().int2ObjectEntrySet().stream().noneMatch(q -> {
            return ((GameMainQuest) q.getValue()).getTalks().get(Integer.valueOf(params[0])) != null;
        });
    }
}
