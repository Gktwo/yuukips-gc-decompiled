package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"AvatarFlycloakExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarFlycloakData.class */
public class AvatarFlycloakData extends GameResource {
    private int flycloakId;
    private long nameTextMapHash;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.flycloakId;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
