package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddServerBuff.class */
public class ItemUseAddServerBuff extends ItemUseInt {
    private int duration;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_ADD_SERVER_BUFF;
    }

    public ItemUseAddServerBuff(String[] useParam) {
        super(useParam);
        this.duration = 0;
        try {
            this.duration = Integer.parseInt(useParam[1]);
        } catch (NumberFormatException e) {
        }
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return params.player.getBuffManager().addBuff(this.f589i, (float) this.duration, params.targetAvatar);
    }
}
