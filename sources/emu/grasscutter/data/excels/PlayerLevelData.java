package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"PlayerLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/PlayerLevelData.class */
public class PlayerLevelData extends GameResource {
    private int level;
    private int exp;
    private int rewardId;
    private int expeditionLimitAdd = 0;
    private int unlockWorldLevel;
    private long unlockDescTextMapHash;

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    public int getRewardId() {
        return this.rewardId;
    }

    public int getExpeditionLimitAdd() {
        return this.expeditionLimitAdd;
    }

    public int getUnlockWorldLevel() {
        return this.unlockWorldLevel;
    }

    public long getUnlockDescTextMapHash() {
        return this.unlockDescTextMapHash;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.level;
    }
}
