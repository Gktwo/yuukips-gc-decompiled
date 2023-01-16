package emu.grasscutter.game.activity;

import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;

@GameActivity(ActivityType.NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/DefaultActivityHandler.class */
public class DefaultActivityHandler extends ActivityHandler {
    @Override // emu.grasscutter.game.activity.ActivityHandler
    public void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfoOuterClass.ActivityInfo.Builder activityInfo) {
    }

    @Override // emu.grasscutter.game.activity.ActivityHandler
    public void onInitPlayerActivityData(PlayerActivityData playerActivityData) {
    }
}
