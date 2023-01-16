package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"DailyTaskExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DailyTaskData.class */
public class DailyTaskData extends GameResource {
    @SerializedName(value = "id", alternate = {"ID"})

    /* renamed from: id */
    private int f526id;
    private int cityId;
    private int poolId;
    private String type;
    private int rarity;
    private List<Integer> oldGroupVec;
    private List<Integer> newGroupVec;
    private String finishType;
    private int finishParam1;
    private int finishParam2;
    private int finishProgress;
    private int taskRewardId;
    private String centerPosition;
    private int enterDistance;
    private int exitDistance;
    private long titleTextMapHash;
    private long descriptionTextMapHash;
    private long targetTextMapHash;
    private int radarRadius;

    public int getCityId() {
        return this.cityId;
    }

    public int getPoolId() {
        return this.poolId;
    }

    public String getType() {
        return this.type;
    }

    public int getRarity() {
        return this.rarity;
    }

    public List<Integer> getOldGroupVec() {
        return this.oldGroupVec;
    }

    public List<Integer> getNewGroupVec() {
        return this.newGroupVec;
    }

    public String getFinishType() {
        return this.finishType;
    }

    public int getFinishParam1() {
        return this.finishParam1;
    }

    public int getFinishParam2() {
        return this.finishParam2;
    }

    public int getFinishProgress() {
        return this.finishProgress;
    }

    public int getTaskRewardId() {
        return this.taskRewardId;
    }

    public String getCenterPosition() {
        return this.centerPosition;
    }

    public int getEnterDistance() {
        return this.enterDistance;
    }

    public int getExitDistance() {
        return this.exitDistance;
    }

    public long getTitleTextMapHash() {
        return this.titleTextMapHash;
    }

    public long getDescriptionTextMapHash() {
        return this.descriptionTextMapHash;
    }

    public long getTargetTextMapHash() {
        return this.targetTextMapHash;
    }

    public int getRadarRadius() {
        return this.radarRadius;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f526id;
    }
}
