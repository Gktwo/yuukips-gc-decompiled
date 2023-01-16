package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.ElementType;

@ResourceType(name = {"WorldAreaConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/WorldAreaData.class */
public class WorldAreaData extends GameResource {
    @SerializedName(value = "id", alternate = {"ID", "Id"})

    /* renamed from: id */
    private int f555id;
    @SerializedName(value = "areaID1", alternate = {"AreaID1"})
    private int areaID1;
    @SerializedName(value = "areaID2", alternate = {"AreaID2"})
    private int areaID2;
    @SerializedName(value = "sceneID", alternate = {"SceneID", "SceneId", "sceneId"})
    private int sceneID;
    private ElementType elementType;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return (this.areaID2 << 16) + this.areaID1;
    }

    public int getSceneID() {
        return this.sceneID;
    }

    public ElementType getElementType() {
        return this.elementType;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
