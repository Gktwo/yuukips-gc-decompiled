package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.ClimateType;

@ResourceType(name = {"WeatherExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/WeatherData.class */
public class WeatherData extends GameResource {
    private int areaID;
    private int weatherAreaId;
    private String maxHeightStr;
    private int gadgetID;
    private boolean isDefaultValid;
    private String templateName;
    private int priority;
    private String profileName;
    private ClimateType defaultClimate;
    private boolean isUseDefault;
    @SerializedName(value = "sceneID", alternate = {"SceneID", "SceneId", "sceneId"})
    private int sceneID;

    public int getAreaID() {
        return this.areaID;
    }

    public int getWeatherAreaId() {
        return this.weatherAreaId;
    }

    public String getMaxHeightStr() {
        return this.maxHeightStr;
    }

    public int getGadgetID() {
        return this.gadgetID;
    }

    public boolean isDefaultValid() {
        return this.isDefaultValid;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProfileName() {
        return this.profileName;
    }

    public ClimateType getDefaultClimate() {
        return this.defaultClimate;
    }

    public boolean isUseDefault() {
        return this.isUseDefault;
    }

    public int getSceneID() {
        return this.sceneID;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.areaID;
    }
}
