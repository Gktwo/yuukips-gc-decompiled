package emu.grasscutter.game.tower;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import java.util.Map;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/tower/TowerData.class */
public class TowerData {
    int currentFloorId;
    int currentLevel;
    @Transient
    int currentLevelId;
    Map<Integer, TowerLevelRecord> recordMap;
    @Transient
    int entryScene;
}
