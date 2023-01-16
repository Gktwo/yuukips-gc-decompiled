package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddElemEnergy.class */
public class ItemUseAddElemEnergy extends ItemUseAddEnergy {
    private ElementType element;
    private float elemEnergy;
    private float otherEnergy;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_ADD_ELEM_ENERGY;
    }

    public ItemUseAddElemEnergy(String[] useParam) {
        this.element = ElementType.None;
        this.elemEnergy = 0.0f;
        this.otherEnergy = 0.0f;
        try {
            this.element = ElementType.getTypeByValue(Integer.parseInt(useParam[0]));
        } catch (Exception e) {
        }
        try {
            this.elemEnergy = Float.parseFloat(useParam[1]);
        } catch (Exception e2) {
        }
        try {
            this.otherEnergy = Float.parseFloat(useParam[2]);
        } catch (Exception e3) {
        }
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.ItemUseAddEnergy
    public float getAddEnergy(ElementType avatarElement) {
        return avatarElement == this.element ? this.elemEnergy : this.otherEnergy;
    }
}
