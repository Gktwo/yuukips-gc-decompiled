package emu.grasscutter.scripts.service;

import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.scripts.SceneScriptManager;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.scripts.data.SceneMonster;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.scripts.listener.ScriptMonsterListener;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/service/ScriptMonsterTideService.class */
public class ScriptMonsterTideService {
    private final SceneScriptManager sceneScriptManager;
    private final SceneGroup currentGroup;
    private final AtomicInteger monsterTideCount;
    private final int monsterSceneLimit;
    private final ConcurrentLinkedQueue<Integer> monsterConfigOrders;
    private final OnMonsterCreated onMonsterCreated = new OnMonsterCreated();
    private final OnMonsterDead onMonsterDead = new OnMonsterDead();
    private final AtomicInteger monsterKillCount = new AtomicInteger(0);
    private final AtomicInteger monsterAlive = new AtomicInteger(0);

    public ScriptMonsterTideService(SceneScriptManager sceneScriptManager, SceneGroup group, int tideCount, int monsterSceneLimit, Integer[] ordersConfigId) {
        this.sceneScriptManager = sceneScriptManager;
        this.currentGroup = group;
        this.monsterSceneLimit = monsterSceneLimit;
        this.monsterTideCount = new AtomicInteger(tideCount);
        this.monsterConfigOrders = new ConcurrentLinkedQueue<>(List.of((Object[]) ordersConfigId));
        this.sceneScriptManager.getScriptMonsterSpawnService().addMonsterCreatedListener(this.onMonsterCreated);
        this.sceneScriptManager.getScriptMonsterSpawnService().addMonsterDeadListener(this.onMonsterDead);
        for (int i = 0; i < this.monsterSceneLimit; i++) {
            sceneScriptManager.addEntity(this.sceneScriptManager.createMonster(group.f957id, group.block_id, getNextMonster()));
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/scripts/service/ScriptMonsterTideService$OnMonsterCreated.class */
    public class OnMonsterCreated implements ScriptMonsterListener {
        public OnMonsterCreated() {
        }

        @Override // emu.grasscutter.scripts.listener.ScriptMonsterListener
        public void onNotify(EntityMonster sceneMonster) {
            if (ScriptMonsterTideService.this.monsterSceneLimit > 0) {
                ScriptMonsterTideService.this.monsterAlive.incrementAndGet();
                ScriptMonsterTideService.this.monsterTideCount.decrementAndGet();
            }
        }
    }

    public SceneMonster getNextMonster() {
        Integer nextId = this.monsterConfigOrders.poll();
        if (this.currentGroup.monsters.containsKey(nextId)) {
            return this.currentGroup.monsters.get(nextId);
        }
        return this.currentGroup.monsters.values().stream().findFirst().orElse(null);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/scripts/service/ScriptMonsterTideService$OnMonsterDead.class */
    public class OnMonsterDead implements ScriptMonsterListener {
        public OnMonsterDead() {
        }

        @Override // emu.grasscutter.scripts.listener.ScriptMonsterListener
        public void onNotify(EntityMonster sceneMonster) {
            if (ScriptMonsterTideService.this.monsterSceneLimit > 0 && ScriptMonsterTideService.this.monsterAlive.decrementAndGet() < ScriptMonsterTideService.this.monsterSceneLimit) {
                ScriptMonsterTideService.this.monsterKillCount.incrementAndGet();
                if (ScriptMonsterTideService.this.monsterTideCount.get() > 0) {
                    ScriptMonsterTideService.this.sceneScriptManager.addEntity(ScriptMonsterTideService.this.sceneScriptManager.createMonster(ScriptMonsterTideService.this.currentGroup.f957id, ScriptMonsterTideService.this.currentGroup.block_id, ScriptMonsterTideService.this.getNextMonster()));
                }
                ScriptMonsterTideService.this.sceneScriptManager.callEvent(new ScriptArgs(37, ScriptMonsterTideService.this.monsterKillCount.get()));
            }
        }
    }

    public void unload() {
        this.sceneScriptManager.getScriptMonsterSpawnService().removeMonsterCreatedListener(this.onMonsterCreated);
        this.sceneScriptManager.getScriptMonsterSpawnService().removeMonsterDeadListener(this.onMonsterDead);
    }
}
