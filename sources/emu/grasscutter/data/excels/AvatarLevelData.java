package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"AvatarLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarLevelData.class */
public class AvatarLevelData extends GameResource {
    private int level;
    private int exp;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.level;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }
}
