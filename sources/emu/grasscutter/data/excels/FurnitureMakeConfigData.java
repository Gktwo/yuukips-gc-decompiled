package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import java.util.List;

@ResourceType(name = {"FurnitureMakeExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/FurnitureMakeConfigData.class */
public class FurnitureMakeConfigData extends GameResource {
    private int configID;
    private int furnitureItemID;
    private int count;
    private int exp;
    private List<ItemParamData> materialItems;
    private int makeTime;
    private int maxAccelerateTime;
    private int quickFetchMaterialNum;

    public int getConfigID() {
        return this.configID;
    }

    public int getFurnitureItemID() {
        return this.furnitureItemID;
    }

    public int getCount() {
        return this.count;
    }

    public int getExp() {
        return this.exp;
    }

    public List<ItemParamData> getMaterialItems() {
        return this.materialItems;
    }

    public int getMakeTime() {
        return this.makeTime;
    }

    public int getMaxAccelerateTime() {
        return this.maxAccelerateTime;
    }

    public int getQuickFetchMaterialNum() {
        return this.quickFetchMaterialNum;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.configID;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.materialItems = this.materialItems.stream().filter(x -> {
            return x.getId() > 0;
        }).toList();
    }
}
