package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseChestSelectItem.class */
public class ItemUseChestSelectItem extends ItemUseSelectItems {
    private int[] optionItemCounts;

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_CHEST_SELECT_ITEM;
    }

    public ItemUseChestSelectItem(String[] useParam) {
        String[] options = useParam[0].split(",");
        this.optionItemIds = new int[options.length];
        this.optionItemCounts = new int[options.length];
        for (int i = 0; i < options.length; i++) {
            String[] optionParts = options[i].split(EmitterKt.COMMENT_PREFIX);
            try {
                this.optionItemIds[i] = Integer.parseInt(optionParts[0]);
            } catch (NumberFormatException e) {
                this.optionItemIds[i] = -1;
            }
            try {
                this.optionItemCounts[i] = Integer.parseInt(optionParts[1]);
            } catch (NumberFormatException e2) {
                this.optionItemCounts[i] = -1;
            }
        }
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.ItemUseSelectItems
    protected int getItemCount(int index) {
        if (this.optionItemCounts == null || index < 0 || index > this.optionItemCounts.length) {
            return -1;
        }
        return this.optionItemCounts[index];
    }
}
