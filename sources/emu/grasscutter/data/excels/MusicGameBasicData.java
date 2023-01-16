package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"MusicGameBasicConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/MusicGameBasicData.class */
public class MusicGameBasicData extends GameResource {

    /* renamed from: id */
    private int f545id;
    private int musicID;
    private int musicLevel;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f545id;
    }

    public int getMusicID() {
        return this.musicID;
    }

    public int getMusicLevel() {
        return this.musicLevel;
    }
}
