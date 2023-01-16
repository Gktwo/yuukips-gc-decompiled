package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"WorldLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/WorldLevelData.class */
public class WorldLevelData extends GameResource {
    private int level;
    private int monsterLevel;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.level;
    }

    public int getMonsterLevel() {
        return this.monsterLevel;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
