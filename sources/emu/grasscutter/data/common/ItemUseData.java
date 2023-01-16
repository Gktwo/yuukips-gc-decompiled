package emu.grasscutter.data.common;

import emu.grasscutter.game.props.ItemUseOp;

/* loaded from: grasscutter.jar:emu/grasscutter/data/common/ItemUseData.class */
public class ItemUseData {
    private ItemUseOp useOp;
    private String[] useParam;

    public ItemUseOp getUseOp() {
        if (this.useOp == null) {
            this.useOp = ItemUseOp.ITEM_USE_NONE;
        }
        return this.useOp;
    }

    public String[] getUseParam() {
        return this.useParam;
    }
}
