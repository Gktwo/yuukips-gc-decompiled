package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"BattlePassRewardExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/BattlePassRewardData.class */
public class BattlePassRewardData extends GameResource {
    private int indexId;
    private int level;
    private List<Integer> freeRewardIdList;
    private List<Integer> paidRewardIdList;

    public int getIndexId() {
        return this.indexId;
    }

    public int getLevel() {
        return this.level;
    }

    public List<Integer> getFreeRewardIdList() {
        return this.freeRewardIdList;
    }

    public List<Integer> getPaidRewardIdList() {
        return this.paidRewardIdList;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return (this.indexId * 100) + this.level;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
