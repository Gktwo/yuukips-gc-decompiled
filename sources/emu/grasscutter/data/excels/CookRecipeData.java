package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import java.util.List;

@ResourceType(name = {"CookRecipeExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CookRecipeData.class */
public class CookRecipeData extends GameResource {

    /* renamed from: id */
    private int f524id;
    private int rankLevel;
    private boolean isDefaultUnlocked;
    private int maxProficiency;
    private List<ItemParamData> qualityOutputVec;
    private List<ItemParamData> inputVec;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f524id;
    }

    public int getRankLevel() {
        return this.rankLevel;
    }

    public boolean isDefaultUnlocked() {
        return this.isDefaultUnlocked;
    }

    public int getMaxProficiency() {
        return this.maxProficiency;
    }

    public List<ItemParamData> getQualityOutputVec() {
        return this.qualityOutputVec;
    }

    public List<ItemParamData> getInputVec() {
        return this.inputVec;
    }
}
