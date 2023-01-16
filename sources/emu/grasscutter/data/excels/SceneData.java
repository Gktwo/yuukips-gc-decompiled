package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.SceneType;
import java.util.List;

@ResourceType(name = {"SceneExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/SceneData.class */
public class SceneData extends GameResource {

    /* renamed from: id */
    private int f553id;
    @SerializedName("type")
    private SceneType sceneType;
    private String scriptData;
    private String levelEntityConfig;
    private List<Integer> specifiedAvatarList;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f553id;
    }

    public SceneType getSceneType() {
        return this.sceneType;
    }

    public String getScriptData() {
        return this.scriptData;
    }

    public String getLevelEntityConfig() {
        return this.levelEntityConfig;
    }

    public List<Integer> getSpecifiedAvatarList() {
        return this.specifiedAvatarList;
    }
}
