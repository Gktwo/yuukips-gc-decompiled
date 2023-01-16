package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddItem.class */
public class ItemUseAddItem extends ItemUseInt {
    private int count;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_ADD_ITEM;
    }

    public ItemUseAddItem(String[] useParam) {
        super(useParam);
        this.count = 0;
        try {
            this.count = Integer.parseInt(useParam[1]);
        } catch (NumberFormatException e) {
        }
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return params.player.getInventory().addItem(this.f589i, this.count * params.count);
    }
}
