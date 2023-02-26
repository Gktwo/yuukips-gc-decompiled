package emu.grasscutter.game.managers.blossom;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.WorldLevelData;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger;
import emu.grasscutter.game.dungeons.challenge.trigger.KillMonsterTrigger;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneBossChest;
import emu.grasscutter.scripts.data.SceneGadget;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.Utils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/blossom/BlossomActivity.class */
public class BlossomActivity {
    private final WorldChallenge challenge;
    private final EntityGadget gadget;
    private EntityGadget chest;
    private final int goal;
    private int generatedCount;
    private final int worldLevel;
    private static final int BLOOMING_GADGET_ID = 70210109;
    private boolean pass = false;
    private final List<EntityMonster> activeMonsters = new ArrayList();
    private final Queue<Integer> candidateMonsters = new ArrayDeque();
    private final SceneGroup tempSceneGroup = new SceneGroup();
    private int step = 0;

    public BlossomActivity(EntityGadget entityGadget, List<Integer> monsters, int timeout, int worldLevel) {
        this.tempSceneGroup.f922id = entityGadget.getId();
        this.gadget = entityGadget;
        this.goal = monsters.size();
        this.candidateMonsters.addAll(monsters);
        this.worldLevel = worldLevel;
        ArrayList<ChallengeTrigger> challengeTriggers = new ArrayList<>();
        this.challenge = new WorldChallenge(entityGadget.getScene(), this.tempSceneGroup, 1, 1, List.of(Integer.valueOf(this.goal), Integer.valueOf(timeout)), timeout, this.goal, challengeTriggers);
        challengeTriggers.add(new KillMonsterTrigger());
    }

    public WorldChallenge getChallenge() {
        return this.challenge;
    }

    public void setMonsters(List<EntityMonster> monsters) {
        this.activeMonsters.clear();
        this.activeMonsters.addAll(monsters);
        for (EntityMonster monster : monsters) {
            monster.setGroupId(this.tempSceneGroup.f922id);
        }
    }

    public int getAliveMonstersCount() {
        int count = 0;
        for (EntityMonster monster : this.activeMonsters) {
            if (monster.isAlive()) {
                count++;
            }
        }
        return count;
    }

    public boolean getPass() {
        return this.pass;
    }

    public void start() {
        this.challenge.start();
    }

    public void onTick() {
        Scene scene = this.gadget.getScene();
        Position pos = this.gadget.getPosition();
        if (getAliveMonstersCount() > 2) {
            return;
        }
        if (this.generatedCount < this.goal) {
            this.step++;
            WorldLevelData worldLevelData = GameData.getWorldLevelDataMap().get(this.worldLevel);
            int worldLevelOverride = 0;
            if (worldLevelData != null) {
                worldLevelOverride = worldLevelData.getMonsterLevel();
            }
            List<EntityMonster> newMonsters = new ArrayList<>();
            int willSpawn = Utils.randomRange(3, 5);
            if (this.generatedCount + willSpawn > this.goal) {
                willSpawn = this.goal - this.generatedCount;
            }
            this.generatedCount += willSpawn;
            for (int i = 0; i < willSpawn; i++) {
                EntityMonster entity = new EntityMonster(scene, GameData.getMonsterDataMap().get(this.candidateMonsters.poll().intValue()), pos.nearby2d(4.0f), scene.getEntityLevel(1, worldLevelOverride));
                scene.addEntity(entity);
                newMonsters.add(entity);
            }
            setMonsters(newMonsters);
        } else if (getAliveMonstersCount() == 0) {
            this.pass = true;
            this.challenge.done();
        }
    }

    public EntityGadget getGadget() {
        return this.gadget;
    }

    public EntityGadget getChest() {
        if (this.chest == null) {
            EntityGadget rewardGadget = new EntityGadget(this.gadget.getScene(), BLOOMING_GADGET_ID, this.gadget.getPosition());
            SceneGadget metaGadget = new SceneGadget();
            metaGadget.boss_chest = new SceneBossChest();
            metaGadget.boss_chest.resin = 20;
            rewardGadget.setFightProperty(FightProperty.FIGHT_PROP_BASE_HP, Float.POSITIVE_INFINITY);
            rewardGadget.setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, Float.POSITIVE_INFINITY);
            rewardGadget.setFightProperty(FightProperty.FIGHT_PROP_MAX_HP, Float.POSITIVE_INFINITY);
            rewardGadget.setMetaGadget(metaGadget);
            rewardGadget.buildContent();
            this.chest = rewardGadget;
        }
        return this.chest;
    }
}
