package emu.grasscutter.game.managers.blossom;

import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/blossom/BlossomConfig.class */
public class BlossomConfig {
    private int monsterFightingVolume;
    private Map<Integer, List<Integer>> monsterIdsPerDifficulty;

    public int getMonsterFightingVolume() {
        return this.monsterFightingVolume;
    }

    public Map<Integer, List<Integer>> getMonsterIdsPerDifficulty() {
        return this.monsterIdsPerDifficulty;
    }
}
