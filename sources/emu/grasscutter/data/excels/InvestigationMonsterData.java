package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"InvestigationMonsterConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/InvestigationMonsterData.class */
public class InvestigationMonsterData extends GameResource {

    /* renamed from: id */
    private int f540id;
    private int cityId;
    private List<Integer> monsterIdList;
    private List<Integer> groupIdList;
    private int rewardPreviewId;
    private String mapMarkCreateType;
    private String monsterCategory;
    private CityData cityData;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f540id;
    }

    public int getCityId() {
        return this.cityId;
    }

    public List<Integer> getMonsterIdList() {
        return this.monsterIdList;
    }

    public List<Integer> getGroupIdList() {
        return this.groupIdList;
    }

    public int getRewardPreviewId() {
        return this.rewardPreviewId;
    }

    public String getMapMarkCreateType() {
        return this.mapMarkCreateType;
    }

    public String getMonsterCategory() {
        return this.monsterCategory;
    }

    public CityData getCityData() {
        return this.cityData;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.cityData = GameData.getCityDataMap().get(this.cityId);
    }
}
