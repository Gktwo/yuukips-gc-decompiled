package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"CityConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGH)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CityData.class */
public class CityData extends GameResource {
    private int cityId;
    private int sceneId;
    private List<Integer> areaIdVec;

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public void setAreaIdVec(List<Integer> areaIdVec) {
        this.areaIdVec = areaIdVec;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public List<Integer> getAreaIdVec() {
        return this.areaIdVec;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.cityId;
    }
}
