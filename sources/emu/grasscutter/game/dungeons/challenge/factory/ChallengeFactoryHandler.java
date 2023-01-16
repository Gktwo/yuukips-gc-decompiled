package emu.grasscutter.game.dungeons.challenge.factory;

import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/factory/ChallengeFactoryHandler.class */
public interface ChallengeFactoryHandler {
    boolean isThisType(int i, int i2, int i3, int i4, int i5, int i6, Scene scene, SceneGroup sceneGroup);

    WorldChallenge build(int i, int i2, int i3, int i4, int i5, int i6, Scene scene, SceneGroup sceneGroup);
}
