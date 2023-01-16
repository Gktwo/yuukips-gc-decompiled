package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"WeaponLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/WeaponLevelData.class */
public class WeaponLevelData extends GameResource {
    private int level;
    private int[] requiredExps;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.level;
    }

    public int getLevel() {
        return this.level;
    }

    public int[] getRequiredExps() {
        return this.requiredExps;
    }
}
