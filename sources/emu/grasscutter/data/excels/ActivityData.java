package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;
import java.util.Objects;

@ResourceType(name = {"NewActivityExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ActivityData.class */
public class ActivityData extends GameResource {
    private int activityId;
    private String activityType;
    private List<Integer> condGroupId;
    private List<Integer> watcherId;
    private List<ActivityWatcherData> watcherDataList;

    public int getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public List<Integer> getCondGroupId() {
        return this.condGroupId;
    }

    public List<Integer> getWatcherId() {
        return this.watcherId;
    }

    public List<ActivityWatcherData> getWatcherDataList() {
        return this.watcherDataList;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.activityId;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.watcherDataList = this.watcherId.stream().map(item -> {
            return GameData.getActivityWatcherDataMap().get(item.intValue());
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList();
    }
}
