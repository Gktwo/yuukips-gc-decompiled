package emu.grasscutter.game.dungeons.challenge.factory;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.dungeons.challenge.trigger.InTimeTrigger;
import emu.grasscutter.game.dungeons.challenge.trigger.KillMonsterTrigger;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/factory/AirBalloonCargoChallengeFactoryHandler.class */
public class AirBalloonCargoChallengeFactoryHandler implements ChallengeFactoryHandler {
    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public boolean isThisType(int id_regional_challenge, int id_type_challenge, int param3, int param4, int param5, int param6, Scene scene, SceneGroup group) {
        return id_type_challenge == 15;
    }

    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public WorldChallenge build(int id_regional_challenge, int id_type_challenge, int param3, int param4, int param5, int param6, Scene scene, SceneGroup group) {
        Grasscutter.getLogger().warn("Start AirBalloonCargoChallengeFactoryHandler");
        return new WorldChallenge(scene, group, id_regional_challenge, id_type_challenge, List.of(Integer.valueOf(param5), Integer.valueOf(param3)), param3, param5, List.of(new KillMonsterTrigger(), new InTimeTrigger()));
    }
}
