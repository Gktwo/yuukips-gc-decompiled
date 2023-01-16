package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"HomeworldLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/HomeWorldLevelData.class */
public class HomeWorldLevelData extends GameResource {
    private int level;
    private int exp;
    private int homeCoinStoreLimit;
    private int homeFetterExpStoreLimit;
    private int rewardId;
    private int furnitureMakeSlotCount;
    private int outdoorUnlockBlockCount;
    private int freeUnlockModuleCount;
    private int deployNpcCount;
    private int limitShopGoodsCount;
    private List<String> levelFuncs;

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    public int getHomeCoinStoreLimit() {
        return this.homeCoinStoreLimit;
    }

    public int getHomeFetterExpStoreLimit() {
        return this.homeFetterExpStoreLimit;
    }

    public int getRewardId() {
        return this.rewardId;
    }

    public int getFurnitureMakeSlotCount() {
        return this.furnitureMakeSlotCount;
    }

    public int getOutdoorUnlockBlockCount() {
        return this.outdoorUnlockBlockCount;
    }

    public int getFreeUnlockModuleCount() {
        return this.freeUnlockModuleCount;
    }

    public int getDeployNpcCount() {
        return this.deployNpcCount;
    }

    public int getLimitShopGoodsCount() {
        return this.limitShopGoodsCount;
    }

    public List<String> getLevelFuncs() {
        return this.levelFuncs;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.level;
    }
}
