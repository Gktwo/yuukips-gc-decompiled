package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddSelectItem.class */
public class ItemUseAddSelectItem extends ItemUseSelectItems {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_ADD_SELECT_ITEM;
    }

    public ItemUseAddSelectItem(String[] useParam) {
        String[] options = useParam[0].split(",");
        this.optionItemIds = new int[options.length];
        for (int i = 0; i < options.length; i++) {
            try {
                this.optionItemIds[i] = Integer.parseInt(options[i]);
            } catch (NumberFormatException e) {
                this.optionItemIds[i] = -1;
            }
        }
    }
}
