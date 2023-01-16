package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"FetterCharacterCardExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGHEST)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/FetterCharacterCardData.class */
public class FetterCharacterCardData extends GameResource {
    private int avatarId;
    private int rewardId;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.avatarId;
    }

    public int getRewardId() {
        return this.rewardId;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
