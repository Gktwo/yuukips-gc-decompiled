package emu.grasscutter.game.activity.condition.all;

import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.condition.ActivityCondition;
import emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler;
import emu.grasscutter.game.activity.condition.ActivityConditions;
import java.util.Date;

@ActivityCondition(ActivityConditions.NEW_ACTIVITY_COND_DAYS_GREAT_EQUAL)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/all/DaysGreatEqual.class */
public class DaysGreatEqual extends ActivityConditionBaseHandler {
    @Override // emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler
    public boolean execute(PlayerActivityData activityData, ActivityConfigItem activityConfig, int... params) {
        return ((int) ((System.currentTimeMillis() - new Date((long) activityConfig.getBeginTime()).getTime()) / 86400000)) + 1 >= params[0];
    }
}
