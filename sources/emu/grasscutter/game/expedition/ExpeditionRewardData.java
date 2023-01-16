package emu.grasscutter.game.expedition;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.utils.Utils;

/* loaded from: grasscutter.jar:emu/grasscutter/game/expedition/ExpeditionRewardData.class */
public class ExpeditionRewardData {
    private int itemId;
    private int minCount;
    private int maxCount;

    public int getItemId() {
        return this.itemId;
    }

    public int getMinCount() {
        return this.minCount;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public GameItem getReward() {
        return new GameItem(this.itemId, Utils.randomRange(this.minCount, this.maxCount));
    }
}
