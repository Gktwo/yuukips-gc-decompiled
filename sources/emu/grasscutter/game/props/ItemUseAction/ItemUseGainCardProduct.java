package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseGainCardProduct.class */
public class ItemUseGainCardProduct extends C1378ItemUseAction {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_GAIN_CARD_PRODUCT;
    }

    public ItemUseGainCardProduct(String[] useParam) {
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return params.player.rechargeMoonCard();
    }
}
