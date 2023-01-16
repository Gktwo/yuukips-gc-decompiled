package emu.grasscutter.game.activity;

import emu.grasscutter.game.props.WatcherTriggerType;

@ActivityWatcherType(WatcherTriggerType.TRIGGER_NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/DefaultWatcher.class */
public class DefaultWatcher extends ActivityWatcher {
    @Override // emu.grasscutter.game.activity.ActivityWatcher
    protected boolean isMeet(String... param) {
        return false;
    }
}
