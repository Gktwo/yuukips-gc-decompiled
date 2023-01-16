package emu.grasscutter.data.excels;

import dev.morphia.annotations.Transient;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.FightPropData;
import emu.grasscutter.data.common.ItemParamData;
import java.util.ArrayList;
import java.util.List;

@ResourceType(name = {"ProudSkillExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ProudSkillData.class */
public class ProudSkillData extends GameResource {
    private int proudSkillId;
    private int proudSkillGroupId;
    private int level;
    private int coinCost;
    private int breakLevel;
    private int proudSkillType;
    private String openConfig;
    private List<ItemParamData> costItems;
    private List<String> filterConds;
    private List<String> lifeEffectParams;
    private FightPropData[] addProps;
    private float[] paramList;
    private long[] paramDescList;
    private long nameTextMapHash;
    @Transient
    private Iterable<ItemParamData> totalCostItems;

    public int getProudSkillGroupId() {
        return this.proudSkillGroupId;
    }

    public int getLevel() {
        return this.level;
    }

    public int getCoinCost() {
        return this.coinCost;
    }

    public int getBreakLevel() {
        return this.breakLevel;
    }

    public int getProudSkillType() {
        return this.proudSkillType;
    }

    public String getOpenConfig() {
        return this.openConfig;
    }

    public List<ItemParamData> getCostItems() {
        return this.costItems;
    }

    public List<String> getFilterConds() {
        return this.filterConds;
    }

    public List<String> getLifeEffectParams() {
        return this.lifeEffectParams;
    }

    public FightPropData[] getAddProps() {
        return this.addProps;
    }

    public float[] getParamList() {
        return this.paramList;
    }

    public long[] getParamDescList() {
        return this.paramDescList;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.proudSkillId;
    }

    public Iterable<ItemParamData> getTotalCostItems() {
        ArrayList<ItemParamData> total;
        if (this.totalCostItems == null) {
            if (this.costItems != null) {
                total = new ArrayList<>(this.costItems);
            } else {
                total = new ArrayList<>(1);
            }
            if (this.coinCost > 0) {
                total.add(new ItemParamData(202, this.coinCost));
            }
            this.totalCostItems = total;
        }
        return this.totalCostItems;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        ArrayList<FightPropData> parsed = new ArrayList<>(getAddProps().length);
        FightPropData[] addProps = getAddProps();
        for (FightPropData prop : addProps) {
            if (!(prop.getPropType() == null || prop.getValue() == 0.0f)) {
                prop.onLoad();
                parsed.add(prop);
            }
        }
        this.addProps = (FightPropData[]) parsed.toArray(new FightPropData[parsed.size()]);
    }
}
