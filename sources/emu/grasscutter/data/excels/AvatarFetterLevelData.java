package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"AvatarFettersLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarFetterLevelData.class */
public class AvatarFetterLevelData extends GameResource {
    private int fetterLevel;
    private int needExp;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.fetterLevel;
    }

    public int getLevel() {
        return this.fetterLevel;
    }

    public int getExp() {
        return this.needExp;
    }
}
