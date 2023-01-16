package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"DailyTaskLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DailyTaskLevelData.class */
public class DailyTaskLevelData extends GameResource {
    @SerializedName(value = "id", alternate = {"ID"})

    /* renamed from: id */
    private int f527id;
    private int minPlayerLevel;
    private int maxPlayerLevel;
    private int groupReviseLevel;
    private int scoreDropId;
    private int scorePreviewRewardId;

    public int getMinPlayerLevel() {
        return this.minPlayerLevel;
    }

    public int getMaxPlayerLevel() {
        return this.maxPlayerLevel;
    }

    public int getGroupReviseLevel() {
        return this.groupReviseLevel;
    }

    public int getScoreDropId() {
        return this.scoreDropId;
    }

    public int getScorePreviewRewardId() {
        return this.scorePreviewRewardId;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f527id;
    }
}
