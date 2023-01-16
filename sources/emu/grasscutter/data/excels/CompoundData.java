package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import java.util.List;

@ResourceType(name = {"CompoundExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CompoundData.class */
public class CompoundData extends GameResource {

    /* renamed from: id */
    private int f523id;
    private int groupId;
    private int rankLevel;
    private boolean isDefaultUnlocked;
    private int costTime;
    private int queueSize;
    private List<ItemParamData> inputVec;
    private List<ItemParamData> outputVec;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f523id;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getRankLevel() {
        return this.rankLevel;
    }

    public boolean isDefaultUnlocked() {
        return this.isDefaultUnlocked;
    }

    public int getCostTime() {
        return this.costTime;
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public List<ItemParamData> getInputVec() {
        return this.inputVec;
    }

    public List<ItemParamData> getOutputVec() {
        return this.outputVec;
    }
}
