package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.props.ItemUseOp;
import emu.grasscutter.game.systems.InventorySystem;
import java.util.Optional;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseGainAvatar.class */
public class ItemUseGainAvatar extends ItemUseInt {
    private int level;
    private int constellation;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_GAIN_AVATAR;
    }

    public ItemUseGainAvatar(String[] useParam) {
        super(useParam);
        this.level = 1;
        this.constellation = 0;
        try {
            this.level = Integer.parseInt(useParam[1]);
        } catch (NumberFormatException e) {
        }
        try {
            this.constellation = Integer.parseInt(useParam[2]);
        } catch (NumberFormatException e2) {
        }
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        int haveConstellation = InventorySystem.checkPlayerAvatarConstellationLevel(params.player, this.f589i);
        if (haveConstellation == -2 || haveConstellation >= 6) {
            return false;
        }
        if (haveConstellation == -1) {
            Avatar avatar = new Avatar(this.f589i);
            avatar.setLevel(this.level);
            avatar.forceConstellationLevel(this.constellation);
            avatar.recalcStats();
            params.player.addAvatar(avatar);
            return true;
        }
        return params.player.getInventory().addItem(((Integer) Optional.ofNullable(params.player.getAvatars().getAvatarById(this.f589i)).map((v0) -> {
            return v0.getSkillDepot();
        }).map(depot -> {
            return Integer.valueOf(depot.getTalentCostItemId());
        }).orElse(Integer.valueOf((this.f589i % 1000) + 100))).intValue());
    }
}
