package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.FightPropData;
import java.util.ArrayList;

@ResourceType(name = {"AvatarTalentExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGHEST)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarTalentData.class */
public class AvatarTalentData extends GameResource {
    private int talentId;
    private int prevTalent;
    private long nameTextMapHash;
    private String icon;
    private int mainCostItemId;
    private int mainCostItemCount;
    private String openConfig;
    private FightPropData[] addProps;
    private float[] paramList;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.talentId;
    }

    public int PrevTalent() {
        return this.prevTalent;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getMainCostItemId() {
        return this.mainCostItemId;
    }

    public int getMainCostItemCount() {
        return this.mainCostItemCount;
    }

    public String getOpenConfig() {
        return this.openConfig;
    }

    public FightPropData[] getAddProps() {
        return this.addProps;
    }

    public float[] getParamList() {
        return this.paramList;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        ArrayList<FightPropData> parsed = new ArrayList<>(getAddProps().length);
        FightPropData[] addProps = getAddProps();
        for (FightPropData prop : addProps) {
            if (prop.getPropType() != null || prop.getValue() == 0.0f) {
                prop.onLoad();
                parsed.add(prop);
            }
        }
        this.addProps = (FightPropData[]) parsed.toArray(new FightPropData[parsed.size()]);
    }
}
