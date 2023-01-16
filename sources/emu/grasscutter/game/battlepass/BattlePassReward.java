package emu.grasscutter.game.battlepass;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.data.excels.BattlePassMissionData;
import emu.grasscutter.net.proto.BattlePassRewardTagOuterClass;
import emu.grasscutter.net.proto.BattlePassUnlockStatusOuterClass;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/battlepass/BattlePassReward.class */
public class BattlePassReward {
    private int level;
    private int rewardId;
    private boolean paid;
    @Transient
    private BattlePassMissionData data;

    @Deprecated(forRemoval = true)
    public BattlePassReward() {
    }

    public BattlePassReward(int level, int rewardId, boolean paid) {
        this.level = level;
        this.rewardId = rewardId;
        this.paid = paid;
    }

    public int getLevel() {
        return this.level;
    }

    public int getRewardId() {
        return this.rewardId;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public BattlePassRewardTagOuterClass.BattlePassRewardTag toProto() {
        BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus battlePassUnlockStatus;
        BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder protoBuilder = BattlePassRewardTagOuterClass.BattlePassRewardTag.newBuilder();
        BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder rewardId = protoBuilder.setLevel(getLevel()).setRewardId(getRewardId());
        if (isPaid()) {
            battlePassUnlockStatus = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_PAID;
        } else {
            battlePassUnlockStatus = BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.BATTLE_PASS_UNLOCK_STATUS_FREE;
        }
        rewardId.setUnlockStatus(battlePassUnlockStatus);
        return protoBuilder.build();
    }
}
