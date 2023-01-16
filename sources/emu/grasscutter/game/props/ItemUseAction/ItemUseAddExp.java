package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddExp.class */
public class ItemUseAddExp extends C1378ItemUseAction {
    private int exp;

    public int getExp() {
        return this.exp;
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_ADD_EXP;
    }

    public ItemUseAddExp(String[] useParam) {
        this.exp = 0;
        try {
            this.exp = Integer.parseInt(useParam[0]);
        } catch (NumberFormatException e) {
        }
    }
}
