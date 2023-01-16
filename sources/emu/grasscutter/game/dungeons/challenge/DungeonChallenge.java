package emu.grasscutter.game.dungeons.challenge;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.dungeons.DungeonPassConditionType;
import emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/DungeonChallenge.class */
public class DungeonChallenge extends WorldChallenge {
    private boolean stage;

    public DungeonChallenge(Scene scene, SceneGroup group, int challengeId, int challengeType, List<Integer> paramList, int timeLimit, int goal, List<ChallengeTrigger> challengeTriggers) {
        super(scene, group, challengeId, challengeType, paramList, timeLimit, goal, challengeTriggers);
    }

    public boolean isStage() {
        return this.stage;
    }

    public void setStage(boolean stage) {
        this.stage = stage;
    }

    @Override // emu.grasscutter.game.dungeons.challenge.WorldChallenge
    public void done() {
        done();
        getScene().triggerDungeonEvent(DungeonPassConditionType.DUNGEON_COND_FINISH_CHALLENGE, getChallengeId(), getChallengeIndex());
        if (isSuccess()) {
            settle();
        }
    }

    private void settle() {
        if (!this.stage) {
            Scene scene = getScene();
            if (isSuccess()) {
                scene.getDungeonManager().finishDungeon();
            } else {
                scene.getDungeonManager().failDungeon();
            }
        } else {
            Grasscutter.getLogger().warn("settle {} -> {}", Boolean.valueOf(this.stage), Boolean.valueOf(isSuccess()));
        }
    }
}
