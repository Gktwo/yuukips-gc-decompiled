package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.ItemUseOp;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseOpenRandomChest.class */
public class ItemUseOpenRandomChest extends ItemUseInt {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_OPEN_RANDOM_CHEST;
    }

    public ItemUseOpenRandomChest(String[] useParam) {
        super(useParam);
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        List<ItemParamData> data = params.player.getServer().getShopSystem().getShopChestData(this.f589i);
        if (data == null) {
            return false;
        }
        List<GameItem> rewardItems = data.stream().map(GameItem::new).toList();
        if (rewardItems.isEmpty()) {
            return true;
        }
        params.player.getInventory().addItems(rewardItems, ActionReason.Shop);
        return true;
    }
}
