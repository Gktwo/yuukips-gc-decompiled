package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseUnlockForge.class */
public class ItemUseUnlockForge extends ItemUseInt {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_UNLOCK_FORGE;
    }

    public ItemUseUnlockForge(String[] useParam) {
        super(useParam);
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return true;
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean postUseItem(UseItemParams params) {
        return params.player.getForgingManager().unlockForgingBlueprint(this.f589i);
    }
}
