package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"WeaponCodexExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CodexWeaponData.class */
public class CodexWeaponData extends GameResource {

    /* renamed from: Id */
    private int f522Id;
    private int weaponId;
    private int sortOrder;

    public int getSortOrder() {
        return this.sortOrder;
    }

    public int getWeaponId() {
        return this.weaponId;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f522Id;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        GameData.getCodexWeaponDataIdMap().put(getWeaponId(), (int) this);
    }
}
