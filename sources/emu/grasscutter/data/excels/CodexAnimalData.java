package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"AnimalCodexExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CodexAnimalData.class */
public class CodexAnimalData extends GameResource {

    /* renamed from: Id */
    private int f518Id;
    private String type;
    private int describeId;
    private int sortOrder;
    @SerializedName(value = "countType", alternate = {"OCCLHPBCDGL"})
    private CountType countType;

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CodexAnimalData$CountType.class */
    public enum CountType {
        CODEX_COUNT_TYPE_KILL,
        CODEX_COUNT_TYPE_CAPTURE
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f518Id;
    }

    public String getType() {
        return this.type;
    }

    public int getDescribeId() {
        return this.describeId;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public CountType getCountType() {
        return this.countType;
    }
}
