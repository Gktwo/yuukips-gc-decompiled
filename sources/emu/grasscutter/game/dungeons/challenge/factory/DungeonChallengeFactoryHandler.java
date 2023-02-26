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

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/factory/DungeonChallengeFactoryHandler.class */
public class DungeonChallengeFactoryHandler implements ChallengeFactoryHandler {
    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public boolean isThisType(int id_challenge, int type_challenge, int time, int grup_id, int goal_kill, int unknown1, Scene scene, SceneGroup group) {
        return scene.getSceneType() == SceneType.SCENE_DUNGEON && grup_id == group.f922id;
    }

    @Override // emu.grasscutter.game.dungeons.challenge.factory.ChallengeFactoryHandler
    public WorldChallenge build(int id_challenge, int type_challenge, int time, int grup_id, int goal_kill, int unknown1, Scene scene, SceneGroup group) {
        Grasscutter.getLogger().info("Start Dungeon ({}->{}): Grup {} | Time {} | Need kill {} | ?? {}", Integer.valueOf(id_challenge), Integer.valueOf(type_challenge), Integer.valueOf(grup_id), Integer.valueOf(time), Integer.valueOf(goal_kill), Integer.valueOf(unknown1));
        return new DungeonChallenge(scene, group, id_challenge, type_challenge, List.of(Integer.valueOf(goal_kill), Integer.valueOf(time)), time, goal_kill, List.of(new InTimeTrigger(), new KillMonsterTrigger()));
    }
}
