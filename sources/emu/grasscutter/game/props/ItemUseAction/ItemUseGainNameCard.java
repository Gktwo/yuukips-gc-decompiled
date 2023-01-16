package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseGainNameCard.class */
public class ItemUseGainNameCard extends C1378ItemUseAction {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_GAIN_NAME_CARD;
    }

    public ItemUseGainNameCard(String[] useParam) {
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        params.player.addNameCard(params.usedItemId);
        return true;
    }
}
