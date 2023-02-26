package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseUnlockHomeModule.class */
public class ItemUseUnlockHomeModule extends ItemUseInt {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_UNLOCK_HOME_MODULE;
    }

    public ItemUseUnlockHomeModule(String[] useParam) {
        super(useParam);
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return true;
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean postUseItem(UseItemParams params) {
        params.player.addRealmList(this.f589i);
        return true;
    }
}
