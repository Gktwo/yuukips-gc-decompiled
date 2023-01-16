package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseReliveAvatar.class */
public class ItemUseReliveAvatar extends C1378ItemUseAction {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_RELIVE_AVATAR;
    }

    public ItemUseReliveAvatar(String[] useParam) {
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return params.player.getTeamManager().reviveAvatar(params.targetAvatar);
    }
}
