package emu.grasscutter.game.activity;

import emu.grasscutter.data.excels.ActivityWatcherData;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/ActivityWatcher.class */
public abstract class ActivityWatcher {
    private int watcherId;
    private ActivityWatcherData activityWatcherData;
    private ActivityHandler activityHandler;

    protected abstract boolean isMeet(String... strArr);

    public void setWatcherId(int watcherId) {
        this.watcherId = watcherId;
    }

    public void setActivityWatcherData(ActivityWatcherData activityWatcherData) {
        this.activityWatcherData = activityWatcherData;
    }

    public void setActivityHandler(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }

    public int getWatcherId() {
        return this.watcherId;
    }

    public ActivityWatcherData getActivityWatcherData() {
        return this.activityWatcherData;
    }

    public ActivityHandler getActivityHandler() {
        return this.activityHandler;
    }

    public void trigger(PlayerActivityData playerActivityData, String... param) {
        if (isMeet(param)) {
            playerActivityData.addWatcherProgress(this.watcherId);
            playerActivityData.save();
        }
    }
}
