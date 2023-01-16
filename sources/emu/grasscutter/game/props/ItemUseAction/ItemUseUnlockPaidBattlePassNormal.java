package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseUnlockPaidBattlePassNormal.class */
public class ItemUseUnlockPaidBattlePassNormal extends C1378ItemUseAction {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_UNLOCK_PAID_BATTLE_PASS_NORMAL;
    }

    public ItemUseUnlockPaidBattlePassNormal(String[] useParam) {
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return false;
    }
}
