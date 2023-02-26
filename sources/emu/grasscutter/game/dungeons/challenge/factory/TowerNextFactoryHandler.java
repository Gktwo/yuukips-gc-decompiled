package emu.grasscutter.game.dungeons.challenge.factory;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.dungeons.challenge.DungeonChallenge;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.dungeons.challenge.trigger.InTimeTrigger;
import emu.grasscutter.game.dungeons.challenge.trigger.KillMonsterTrigger;
import emu.grasscutter.game.props.SceneType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/factory/TowerNextFactoryHandler.class */
public class TowerNextFactoryHandler implements ChallengeFactoryHandler {
    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public boolean isThisType(int id_challenge, int type_challenge, int timer, int id_grup, int goal_kill, int step, Scene scene, SceneGroup group) {
        return scene.getSceneType() == SceneType.SCENE_DUNGEON && id_grup == group.f922id && type_challenge == 198;
    }

    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public WorldChallenge build(int id_challenge, int type_challenge, int timer, int id_grup, int goal_kill, int step, Scene scene, SceneGroup group) {
        int realgoal = scene.getScriptManager().getGroupById(id_grup).suites.get(id_challenge - 1).monsters.size();
        Grasscutter.getLogger().info("Start Next Tower ID: {} | Goal Need Next {} (Total: {}) | Time {}", Integer.valueOf(id_challenge), Integer.valueOf(realgoal), Integer.valueOf(goal_kill), Integer.valueOf(timer));
        return new DungeonChallenge(scene, group, id_challenge, type_challenge, List.of(Integer.valueOf(realgoal), Integer.valueOf(timer)), timer, realgoal, List.of(new InTimeTrigger(), new KillMonsterTrigger()));
    }
}
