package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddAllEnergy.class */
public class ItemUseAddAllEnergy extends ItemUseAddEnergy {
    private float energy;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_ADD_ALL_ENERGY;
    }

    public ItemUseAddAllEnergy(String[] useParam) {
        this.energy = 0.0f;
        try {
            this.energy = Float.parseFloat(useParam[0]);
        } catch (Exception e) {
        }
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.ItemUseAddEnergy
    public float getAddEnergy(ElementType avatarElement) {
        return this.energy;
    }
}
