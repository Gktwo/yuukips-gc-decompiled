package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"DungeonEntryExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DungeonEntryData.class */
public class DungeonEntryData extends GameResource {

    /* renamed from: id */
    private int f533id;
    private int dungeonEntryId;
    private int sceneId;

    public void setId(int id) {
        this.f533id = id;
    }

    public void setDungeonEntryId(int dungeonEntryId) {
        this.dungeonEntryId = dungeonEntryId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f533id;
    }

    public int getDungeonEntryId() {
        return this.dungeonEntryId;
    }

    public int getSceneId() {
        return this.sceneId;
    }
}
