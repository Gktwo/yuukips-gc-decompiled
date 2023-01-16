package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.EntityType;

@ResourceType(name = {"GadgetExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/GadgetData.class */
public class GadgetData extends GameResource {

    /* renamed from: id */
    private int f537id;
    private EntityType type;
    private String jsonName;
    private boolean isInteractive;
    private String[] tags;
    private String itemJsonName;
    private long nameTextMapHash;
    private int campID;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f537id;
    }

    public EntityType getType() {
        return this.type;
    }

    public String getJsonName() {
        return this.jsonName;
    }

    public boolean isInteractive() {
        return this.isInteractive;
    }

    public String[] getTags() {
        return this.tags;
    }

    public String getItemJsonName() {
        return this.itemJsonName;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    public int getCampID() {
        return this.campID;
    }
}
