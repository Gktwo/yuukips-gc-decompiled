package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import java.util.List;

@ResourceType(name = {"RewardExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/RewardData.class */
public class RewardData extends GameResource {
    public int rewardId;
    public List<ItemParamData> rewardItemList;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.rewardId;
    }

    public List<ItemParamData> getRewardItemList() {
        return this.rewardItemList;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.rewardItemList = this.rewardItemList.stream().filter(i -> {
            return i.getId() > 0;
        }).toList();
    }
}
