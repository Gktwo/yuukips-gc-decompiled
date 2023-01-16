package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.FightProperty;

@ResourceType(name = {"ReliquaryMainPropExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ReliquaryMainPropData.class */
public class ReliquaryMainPropData extends GameResource {

    /* renamed from: id */
    private int f551id;
    private int propDepotId;
    @SerializedName("propType")
    private FightProperty fightProp;
    private int weight;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f551id;
    }

    public int getPropDepotId() {
        return this.propDepotId;
    }

    public FightProperty getFightProp() {
        return this.fightProp;
    }

    public int getWeight() {
        return this.weight;
    }
}
