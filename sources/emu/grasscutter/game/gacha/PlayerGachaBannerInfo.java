package emu.grasscutter.game.gacha;

import dev.morphia.annotations.Entity;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/gacha/PlayerGachaBannerInfo.class */
public class PlayerGachaBannerInfo {
    private int totalPulls = 0;
    private int pity5 = 0;
    private int pity4 = 0;
    private int failedFeaturedItemPulls = 0;
    private int failedFeatured4ItemPulls = 0;
    private int pity5Pool1 = 0;
    private int pity5Pool2 = 0;
    private int pity4Pool1 = 0;
    private int pity4Pool2 = 0;
    private int failedChosenItemPulls = 0;
    private int wishItemId = 0;

    public int getTotalPulls() {
        return this.totalPulls;
    }

    public void setTotalPulls(int totalPulls) {
        this.totalPulls = totalPulls;
    }

    public int getPity5() {
        return this.pity5;
    }

    public void setPity5(int pity5) {
        this.pity5 = pity5;
    }

    public int getPity4() {
        return this.pity4;
    }

    public void setPity4(int pity4) {
        this.pity4 = pity4;
    }

    public int getFailedChosenItemPulls() {
        return this.failedChosenItemPulls;
    }

    public void setFailedChosenItemPulls(int failedChosenItemPulls) {
        this.failedChosenItemPulls = failedChosenItemPulls;
    }

    public int getWishItemId() {
        return this.wishItemId;
    }

    public void setWishItemId(int wishItemId) {
        this.wishItemId = wishItemId;
    }

    public void addTotalPulls(int amount) {
        this.totalPulls += amount;
    }

    public void addPity5(int amount) {
        this.pity5 += amount;
    }

    public void addPity4(int amount) {
        this.pity4 += amount;
    }

    public void addFailedChosenItemPulls(int amount) {
        this.failedChosenItemPulls += amount;
    }

    public int getFailedFeaturedItemPulls(int rarity) {
        switch (rarity) {
            case 4:
                return this.failedFeatured4ItemPulls;
            default:
                return this.failedFeaturedItemPulls;
        }
    }

    public void setFailedFeaturedItemPulls(int rarity, int amount) {
        switch (rarity) {
            case 4:
                this.failedFeatured4ItemPulls = amount;
                return;
            default:
                this.failedFeaturedItemPulls = amount;
                return;
        }
    }

    public void addFailedFeaturedItemPulls(int rarity, int amount) {
        switch (rarity) {
            case 4:
                this.failedFeatured4ItemPulls += amount;
                return;
            default:
                this.failedFeaturedItemPulls += amount;
                return;
        }
    }

    public int getPityPool(int rarity, int pool) {
        switch (rarity) {
            case 4:
                switch (pool) {
                    case 1:
                        return this.pity4Pool1;
                    default:
                        return this.pity4Pool2;
                }
            default:
                switch (pool) {
                    case 1:
                        return this.pity5Pool1;
                    default:
                        return this.pity5Pool2;
                }
        }
    }

    public void setPityPool(int rarity, int pool, int amount) {
        switch (rarity) {
            case 4:
                switch (pool) {
                    case 1:
                        this.pity4Pool1 = amount;
                        return;
                    default:
                        this.pity4Pool2 = amount;
                        return;
                }
            case 5:
            default:
                switch (pool) {
                    case 1:
                        this.pity5Pool1 = amount;
                        return;
                    default:
                        this.pity5Pool2 = amount;
                        return;
                }
        }
    }

    public void addPityPool(int rarity, int pool, int amount) {
        switch (rarity) {
            case 4:
                switch (pool) {
                    case 1:
                        this.pity4Pool1 += amount;
                        return;
                    default:
                        this.pity4Pool2 += amount;
                        return;
                }
            case 5:
            default:
                switch (pool) {
                    case 1:
                        this.pity5Pool1 += amount;
                        return;
                    default:
                        this.pity5Pool2 += amount;
                        return;
                }
        }
    }

    public void incPityAll() {
        this.pity4++;
        this.pity5++;
        this.pity4Pool1++;
        this.pity4Pool2++;
        this.pity5Pool1++;
        this.pity5Pool2++;
    }
}
