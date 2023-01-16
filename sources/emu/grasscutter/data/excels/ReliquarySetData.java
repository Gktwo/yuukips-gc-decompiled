package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"ReliquarySetExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ReliquarySetData.class */
public class ReliquarySetData extends GameResource {
    private int setId;
    private int[] setNeedNum;
    @SerializedName(value = "equipAffixId", alternate = {"EquipAffixId"})
    private int equipAffixId;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.setId;
    }

    public int[] getSetNeedNum() {
        return this.setNeedNum;
    }

    public int getEquipAffixId() {
        return this.equipAffixId;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
