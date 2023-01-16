package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.dungeons.challenge.ChallengeType;

@ResourceType(name = {"DungeonChallengeConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DungeonChallengeConfigData.class */
public class DungeonChallengeConfigData extends GameResource {

    /* renamed from: id */
    private int f531id;
    private ChallengeType challengeType;
    private boolean noSuccessHint;
    private boolean noFailHint;
    private boolean isBlockTopTimer;

    public ChallengeType getChallengeType() {
        return this.challengeType;
    }

    public boolean isNoSuccessHint() {
        return this.noSuccessHint;
    }

    public boolean isNoFailHint() {
        return this.noFailHint;
    }

    public boolean isBlockTopTimer() {
        return this.isBlockTopTimer;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f531id;
    }
}
