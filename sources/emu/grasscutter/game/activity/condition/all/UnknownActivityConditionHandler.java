package emu.grasscutter.game.activity.condition.all;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/all/UnknownActivityConditionHandler.class */
public class UnknownActivityConditionHandler extends ActivityConditionBaseHandler {
    @Override // emu.grasscutter.game.activity.condition.ActivityConditionBaseHandler
    public boolean execute(PlayerActivityData activityData, ActivityConfigItem activityConfig, int... params) {
        Grasscutter.getLogger().debug("Called unknown condition handler");
        return false;
    }
}
