package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import java.util.List;

@ResourceType(name = {"ForgeExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGHEST)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ForgeData.class */
public class ForgeData extends GameResource {

    /* renamed from: id */
    private int f536id;
    private int playerLevel;
    private int forgeType;
    private int showItemId;
    private int resultItemId;
    private int resultItemCount;
    private int forgeTime;
    private int queueNum;
    private int scoinCost;
    private int priority;
    private int forgePoint;
    private List<ItemParamData> materialItems;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f536id;
    }

    public int getPlayerLevel() {
        return this.playerLevel;
    }

    public int getForgeType() {
        return this.forgeType;
    }

    public int getShowItemId() {
        return this.showItemId;
    }

    public int getResultItemId() {
        return this.resultItemId;
    }

    public int getResultItemCount() {
        return this.resultItemCount;
    }

    public int getForgeTime() {
        return this.forgeTime;
    }

    public int getQueueNum() {
        return this.queueNum;
    }

    public int getScoinCost() {
        return this.scoinCost;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getForgePoint() {
        return this.forgePoint;
    }

    public List<ItemParamData> getMaterialItems() {
        return this.materialItems;
    }
}
