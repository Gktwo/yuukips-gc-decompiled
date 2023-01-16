package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.FightProperty;

@ResourceType(name = {"ReliquaryAffixExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ReliquaryAffixData.class */
public class ReliquaryAffixData extends GameResource {

    /* renamed from: id */
    private int f549id;
    private int depotId;
    private int groupId;
    @SerializedName("propType")
    private FightProperty fightProp;
    private float propValue;
    private int weight;
    private int upgradeWeight;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f549id;
    }

    public int getDepotId() {
        return this.depotId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public FightProperty getFightProp() {
        return this.fightProp;
    }

    public float getPropValue() {
        return this.propValue;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getUpgradeWeight() {
        return this.upgradeWeight;
    }
}
