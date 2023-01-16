package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseGainFlycloak.class */
public class ItemUseGainFlycloak extends ItemUseInt {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_GAIN_FLYCLOAK;
    }

    public ItemUseGainFlycloak(String[] useParam) {
        super(useParam);
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        if (!GameData.getAvatarFlycloakDataMap().containsKey(this.f589i)) {
            return false;
        }
        params.player.addFlycloak(this.f589i);
        return true;
    }
}
