package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.shop.ShopType;
import java.util.List;

@ResourceType(name = {"ActivityShopOverallExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ActivityShopData.class */
public class ActivityShopData extends GameResource {
    private int scheduleId;
    private ShopType shopType;
    private List<Integer> sheetList;

    public int getScheduleId() {
        return this.scheduleId;
    }

    public ShopType getShopType() {
        return this.shopType;
    }

    public List<Integer> getSheetList() {
        return this.sheetList;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return getShopTypeId();
    }

    public int getShopTypeId() {
        if (this.shopType == null) {
            this.shopType = ShopType.SHOP_TYPE_NONE;
        }
        return this.shopType.shopTypeId;
    }
}
