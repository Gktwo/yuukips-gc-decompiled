package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddCurHp.class */
public class ItemUseAddCurHp extends ItemUseInt {
    private String icon;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_ADD_CUR_HP;
    }

    public ItemUseAddCurHp(String[] useParam) {
        super(useParam);
        this.icon = useParam[1];
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        return ((double) params.targetAvatar.getAsEntity().heal((float) (params.count * this.f589i))) > 0.01d;
    }
}
