package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.WatcherTriggerType;
import java.util.List;

@ResourceType(name = {"NewActivityWatcherConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGH)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ActivityWatcherData.class */
public class ActivityWatcherData extends GameResource {

    /* renamed from: id */
    private int f511id;
    private int rewardID;
    private int progress;
    private WatcherTrigger triggerConfig;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f511id;
    }

    public int getRewardID() {
        return this.rewardID;
    }

    public int getProgress() {
        return this.progress;
    }

    public WatcherTrigger getTriggerConfig() {
        return this.triggerConfig;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.triggerConfig.paramList = this.triggerConfig.paramList.stream().filter(x -> {
            return !x.isBlank();
        }).toList();
        this.triggerConfig.watcherTriggerType = WatcherTriggerType.getTypeByName(this.triggerConfig.triggerType);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ActivityWatcherData$WatcherTrigger.class */
    public static class WatcherTrigger {
        private String triggerType;
        private List<String> paramList;
        private transient WatcherTriggerType watcherTriggerType;

        public String getTriggerType() {
            return this.triggerType;
        }

        public List<String> getParamList() {
            return this.paramList;
        }

        public WatcherTriggerType getWatcherTriggerType() {
            return this.watcherTriggerType;
        }
    }
}
