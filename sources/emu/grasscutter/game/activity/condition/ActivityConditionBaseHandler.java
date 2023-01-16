package emu.grasscutter.game.activity.condition;

import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.PlayerActivityData;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/ActivityConditionBaseHandler.class */
public abstract class ActivityConditionBaseHandler {
    public abstract boolean execute(PlayerActivityData playerActivityData, ActivityConfigItem activityConfigItem, int... iArr);
}
