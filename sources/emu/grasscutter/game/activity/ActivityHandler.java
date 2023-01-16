package emu.grasscutter.game.activity;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.ActivityData;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.condition.ActivityConditionExecutor;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/ActivityHandler.class */
public abstract class ActivityHandler {
    private ActivityConfigItem activityConfigItem;
    private ActivityData activityData;
    private Map<WatcherTriggerType, List<ActivityWatcher>> watchersMap = new HashMap();

    public abstract void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfoOuterClass.ActivityInfo.Builder builder);

    public abstract void onInitPlayerActivityData(PlayerActivityData playerActivityData);

    public void setActivityConfigItem(ActivityConfigItem activityConfigItem) {
        this.activityConfigItem = activityConfigItem;
    }

    public void setActivityData(ActivityData activityData) {
        this.activityData = activityData;
    }

    public void setWatchersMap(Map<WatcherTriggerType, List<ActivityWatcher>> watchersMap) {
        this.watchersMap = watchersMap;
    }

    public ActivityConfigItem getActivityConfigItem() {
        return this.activityConfigItem;
    }

    public ActivityData getActivityData() {
        return this.activityData;
    }

    public Map<WatcherTriggerType, List<ActivityWatcher>> getWatchersMap() {
        return this.watchersMap;
    }

    public void initWatchers(Map<WatcherTriggerType, ConstructorAccess<?>> activityWatcherTypeMap) {
        this.activityData = GameData.getActivityDataMap().get(this.activityConfigItem.getActivityId());
        this.activityData.getWatcherDataList().forEach(watcherData -> {
            ActivityWatcher watcher;
            ConstructorAccess<?> watcherType = (ConstructorAccess) activityWatcherTypeMap.get(activityWatcherTypeMap.getTriggerConfig().getWatcherTriggerType());
            if (watcherType != null) {
                watcher = (ActivityWatcher) watcherType.newInstance();
            } else {
                watcher = new DefaultWatcher();
            }
            watcher.setWatcherId(activityWatcherTypeMap.getId());
            watcher.setActivityHandler(this);
            watcher.setActivityWatcherData(activityWatcherTypeMap);
            this.watchersMap.computeIfAbsent(activityWatcherTypeMap.getTriggerConfig().getWatcherTriggerType(), k -> {
                return new ArrayList();
            });
            this.watchersMap.get(activityWatcherTypeMap.getTriggerConfig().getWatcherTriggerType()).add(watcher);
        });
    }

    private Map<Integer, PlayerActivityData.WatcherInfo> initWatchersDataForPlayer() {
        return (Map) this.watchersMap.values().stream().flatMap((v0) -> {
            return v0.stream();
        }).map(PlayerActivityData.WatcherInfo::init).collect(Collectors.toMap((v0) -> {
            return v0.getWatcherId();
        }, y -> {
            return y;
        }));
    }

    public PlayerActivityData initPlayerActivityData(Player player) {
        PlayerActivityData playerActivityData = PlayerActivityData.m1213of().activityId(this.activityConfigItem.getActivityId()).uid(player.getUid()).watcherInfoMap(initWatchersDataForPlayer()).build();
        onInitPlayerActivityData(playerActivityData);
        return playerActivityData;
    }

    public ActivityInfoOuterClass.ActivityInfo toProto(PlayerActivityData playerActivityData, ActivityConditionExecutor conditionExecutor) {
        ActivityInfoOuterClass.ActivityInfo.Builder proto = ActivityInfoOuterClass.ActivityInfo.newBuilder();
        proto.setActivityId(this.activityConfigItem.getActivityId()).setActivityType(this.activityConfigItem.getActivityType()).setScheduleId(this.activityConfigItem.getScheduleId()).setBeginTime(this.activityConfigItem.getBeginTime()).setFirstDayStartTime(this.activityConfigItem.getBeginTime()).setEndTime(this.activityConfigItem.getEndTime()).addAllMeetCondList(conditionExecutor.getMeetActivitiesConditions(this.activityConfigItem.getMeetCondList()));
        if (playerActivityData != null) {
            proto.addAllWatcherInfoList(playerActivityData.getAllWatcherInfoList());
        }
        onProtoBuild(playerActivityData, proto);
        return proto.build();
    }
}
