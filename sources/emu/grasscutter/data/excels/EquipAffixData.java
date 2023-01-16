package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.FightPropData;
import java.util.ArrayList;

@ResourceType(name = {"EquipAffixExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/EquipAffixData.class */
public class EquipAffixData extends GameResource {
    private int affixId;

    /* renamed from: id */
    private int f535id;
    private int level;
    private long nameTextMapHash;
    private String openConfig;
    private FightPropData[] addProps;
    private float[] paramList;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.affixId;
    }

    public int getMainId() {
        return this.f535id;
    }

    public int getLevel() {
        return this.level;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
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
            if (!(prop.getPropType() == null || prop.getValue() == 0.0f)) {
                prop.onLoad();
                parsed.add(prop);
            }
        }
        this.addProps = (FightPropData[]) parsed.toArray(new FightPropData[parsed.size()]);
    }
}
