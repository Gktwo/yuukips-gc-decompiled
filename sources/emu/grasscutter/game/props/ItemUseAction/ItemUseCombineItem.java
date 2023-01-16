package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseCombineItem.class */
public class ItemUseCombineItem extends ItemUseInt {
    private int resultId;
    private int resultCount;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_COMBINE_ITEM;
    }

    public ItemUseCombineItem(String[] useParam) {
        super(useParam);
        this.resultId = 0;
        this.resultCount = 1;
        try {
            this.resultId = Integer.parseInt(useParam[1]);
        } catch (NumberFormatException e) {
        }
        try {
            this.resultCount = Integer.parseInt(useParam[2]);
        } catch (NumberFormatException e2) {
        }
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        if (params.count != this.f589i) {
            return false;
        }
        return params.player.getInventory().addItem(this.resultId, this.resultCount);
    }
}
