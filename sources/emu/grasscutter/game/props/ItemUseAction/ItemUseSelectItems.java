package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.props.ActionReason;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseSelectItems.class */
public abstract class ItemUseSelectItems extends C1378ItemUseAction {
    protected static final int INVALID = -1;
    protected int[] optionItemIds;

    protected int getItemId(int index) {
        if (this.optionItemIds == null || index < 0 || index > this.optionItemIds.length) {
            return -1;
        }
        return this.optionItemIds[index];
    }

    protected int getItemCount(int index) {
        return 1;
    }

    protected GameItem getItemStack(int index, int useCount) {
        ItemData item;
        int id = getItemId(index);
        int count = getItemCount(index);
        if (id == -1 || count == -1 || (item = GameData.getItemDataMap().get(id)) == null) {
            return null;
        }
        return new GameItem(item, count * useCount);
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        GameItem itemStack = getItemStack(params.optionId - 1, params.count);
        if (itemStack == null) {
            return false;
        }
        return params.player.getInventory().addItem(itemStack, ActionReason.Shop);
    }
}
