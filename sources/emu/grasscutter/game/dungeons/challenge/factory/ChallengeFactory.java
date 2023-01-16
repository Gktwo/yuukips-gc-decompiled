package emu.grasscutter.game.dungeons.challenge.factory;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/factory/ChallengeFactory.class */
public class ChallengeFactory {
    private static final List<ChallengeFactoryHandler> challengeFactoryHandlers = new ArrayList();

    static {
        challengeFactoryHandlers.add(new TimeChallengeKeepingGadgetFactoryHandler());
        challengeFactoryHandlers.add(new TowerNextFactoryHandler());
        challengeFactoryHandlers.add(new DungeonChallengeFactoryHandler());
        challengeFactoryHandlers.add(new DungeonGuardChallengeFactoryHandler());
        challengeFactoryHandlers.add(new KillGadgetChallengeFactoryHandler());
        challengeFactoryHandlers.add(new KillMonsterChallengeFactoryHandler());
        challengeFactoryHandlers.add(new AirBalloonCargoChallengeFactoryHandler());
    }

    public static WorldChallenge getChallenge(int param1, int param2, int param3, int param4, int param5, int param6, Scene scene, SceneGroup group) {
        Grasscutter.getLogger().info("Challenge: ID Scene {} (Group {}) -> Regional Challenge {} | Type Challenge {} | {},{},{},{} ", Integer.valueOf(scene.getId()), Integer.valueOf(group.f957id), Integer.valueOf(param1), Integer.valueOf(param2), Integer.valueOf(param3), Integer.valueOf(param4), Integer.valueOf(param5), Integer.valueOf(param6));
        for (ChallengeFactoryHandler handler : challengeFactoryHandlers) {
            if (handler.isThisType(param1, param2, param3, param4, param5, param6, scene, group)) {
                return handler.build(param1, param2, param3, param4, param5, param6, scene, group);
            }
        }
        return null;
    }
}
