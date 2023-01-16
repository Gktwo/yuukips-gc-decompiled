package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"MonsterDescribeExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGH)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/MonsterDescribeData.class */
public class MonsterDescribeData extends GameResource {

    /* renamed from: id */
    private int f544id;
    private long nameTextMapHash;
    @SerializedName(value = "titleId", alternate = {"titleID"})
    private int titleId;
    @SerializedName(value = "specialNameLabId", alternate = {"specialNameLabID"})
    private int specialNameLabId;
    private MonsterSpecialNameData specialNameData;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f544id;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public int getSpecialNameLabId() {
        return this.specialNameLabId;
    }

    public MonsterSpecialNameData getSpecialNameData() {
        return this.specialNameData;
    }
}
