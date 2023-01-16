package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.FightPropData;
import emu.grasscutter.data.common.ItemParamData;
import java.util.ArrayList;

@ResourceType(name = {"WeaponPromoteExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/WeaponPromoteData.class */
public class WeaponPromoteData extends GameResource {
    private int weaponPromoteId;
    private int promoteLevel;
    private ItemParamData[] costItems;
    private int coinCost;
    private FightPropData[] addProps;
    private int unlockMaxLevel;
    private int requiredPlayerLevel;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return (this.weaponPromoteId << 8) + this.promoteLevel;
    }

    public int getWeaponPromoteId() {
        return this.weaponPromoteId;
    }

    public int getPromoteLevel() {
        return this.promoteLevel;
    }

    public ItemParamData[] getCostItems() {
        return this.costItems;
    }

    public int getCoinCost() {
        return this.coinCost;
    }

    public FightPropData[] getAddProps() {
        return this.addProps;
    }

    public int getUnlockMaxLevel() {
        return this.unlockMaxLevel;
    }

    public int getRequiredPlayerLevel() {
        return this.requiredPlayerLevel;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        ArrayList<ItemParamData> trim = new ArrayList<>(getAddProps().length);
        ItemParamData[] costItems = getCostItems();
        for (ItemParamData itemParam : costItems) {
            if (itemParam.getId() != 0) {
                trim.add(itemParam);
            }
        }
        this.costItems = (ItemParamData[]) trim.toArray(new ItemParamData[trim.size()]);
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
