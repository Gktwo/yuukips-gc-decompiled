package emu.grasscutter.game.tower;

import dev.morphia.annotations.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/tower/TowerLevelRecord.class */
public class TowerLevelRecord {
    private int floorId;
    private Map<Integer, Integer> passedLevelMap;
    private int floorStarRewardProgress;

    public TowerLevelRecord setLevelStars(int levelId, int stars) {
        this.passedLevelMap.put(Integer.valueOf(levelId), Integer.valueOf(stars));
        return this;
    }

    public int getStarCount() {
        return this.passedLevelMap.values().stream().mapToInt((v0) -> {
            return v0.intValue();
        }).sum();
    }

    public TowerLevelRecord() {
    }

    public TowerLevelRecord(int floorId) {
        this.floorId = floorId;
        this.passedLevelMap = new HashMap();
        this.floorStarRewardProgress = 0;
    }

    public int getFloorId() {
        return this.floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public Map<Integer, Integer> getPassedLevelMap() {
        return this.passedLevelMap;
    }

    public void setPassedLevelMap(Map<Integer, Integer> passedLevelMap) {
        this.passedLevelMap = passedLevelMap;
    }

    public int getFloorStarRewardProgress() {
        return this.floorStarRewardProgress;
    }

    public void setFloorStarRewardProgress(int floorStarRewardProgress) {
        this.floorStarRewardProgress = floorStarRewardProgress;
    }
}
