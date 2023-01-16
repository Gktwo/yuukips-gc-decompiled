package emu.grasscutter.game.expedition;

import emu.grasscutter.game.inventory.GameItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/expedition/ExpeditionRewardDataList.class */
public class ExpeditionRewardDataList {
    private int hourTime;
    private List<ExpeditionRewardData> expeditionRewardData;

    public int getHourTime() {
        return this.hourTime;
    }

    public List<ExpeditionRewardData> getExpeditionRewardData() {
        return this.expeditionRewardData;
    }

    public List<GameItem> getRewards() {
        List<GameItem> rewards = new ArrayList<>();
        if (this.expeditionRewardData != null) {
            this.expeditionRewardData.forEach(data -> {
                rewards.add(data.getReward());
            });
        }
        return rewards;
    }
}
