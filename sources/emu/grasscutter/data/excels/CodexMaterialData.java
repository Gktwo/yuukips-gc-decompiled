package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"MaterialCodexExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CodexMaterialData.class */
public class CodexMaterialData extends GameResource {

    /* renamed from: Id */
    private int f519Id;
    private int materialId;
    private int sortOrder;

    public int getSortOrder() {
        return this.sortOrder;
    }

    public int getMaterialId() {
        return this.materialId;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f519Id;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        GameData.getCodexMaterialDataIdMap().put(getMaterialId(), (int) this);
    }
}
