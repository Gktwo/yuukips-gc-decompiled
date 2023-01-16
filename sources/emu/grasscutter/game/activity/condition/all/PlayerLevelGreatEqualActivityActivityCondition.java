package emu.grasscutter.game.activity.condition.all;

import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.condition.ActivityCondition;
import emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler;
import emu.grasscutter.game.activity.condition.ActivityConditions;

@ActivityCondition(ActivityConditions.NEW_ACTIVITY_COND_PLAYER_LEVEL_GREAT_EQUAL)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/all/PlayerLevelGreatEqualActivityActivityCondition.class */
public class PlayerLevelGreatEqualActivityActivityCondition extends ActivityConditionBaseHandler {
    @Override // emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler
    public boolean execute(PlayerActivityData activityData, ActivityConfigItem activityConfig, int... params) {
        return activityData.getPlayer().getLevel() >= params[0];
    }
}
