package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.game.shop.ShopInfo;
import java.util.List;

@ResourceType(name = {"ShopGoodsExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ShopGoodsData.class */
public class ShopGoodsData extends GameResource {
    private int goodsId;
    private int shopType;
    private int itemId;
    private int itemCount;
    private int costScoin;
    private int costHcoin;
    private int costMcoin;
    private List<ItemParamData> costItems;
    private int minPlayerLevel;
    private int maxPlayerLevel;
    private int buyLimit;
    @SerializedName(value = "subTabId", alternate = {"secondarySheetId"})
    private int subTabId;
    private String refreshType;
    private transient ShopInfo.ShopRefreshType refreshTypeEnum;
    private int refreshParam;

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        ShopInfo.ShopRefreshType shopRefreshType;
        if (this.refreshType == null) {
            this.refreshTypeEnum = ShopInfo.ShopRefreshType.NONE;
            return;
        }
        String str = this.refreshType;
        char c = 65535;
        switch (str.hashCode()) {
            case -2029294100:
                if (str.equals("SHOP_REFRESH_DAILY")) {
                    c = 0;
                    break;
                }
                break;
            case -433229024:
                if (str.equals("SHOP_REFRESH_MONTHLY")) {
                    c = 2;
                    break;
                }
                break;
            case 2063919854:
                if (str.equals("SHOP_REFRESH_WEEKLY")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                shopRefreshType = ShopInfo.ShopRefreshType.SHOP_REFRESH_DAILY;
                break;
            case 1:
                shopRefreshType = ShopInfo.ShopRefreshType.SHOP_REFRESH_WEEKLY;
                break;
            case 2:
                shopRefreshType = ShopInfo.ShopRefreshType.SHOP_REFRESH_MONTHLY;
                break;
            default:
                shopRefreshType = ShopInfo.ShopRefreshType.NONE;
                break;
        }
        this.refreshTypeEnum = shopRefreshType;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return getGoodsId();
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public int getShopType() {
        return this.shopType;
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public int getCostScoin() {
        return this.costScoin;
    }

    public int getCostHcoin() {
        return this.costHcoin;
    }

    public int getCostMcoin() {
        return this.costMcoin;
    }

    public List<ItemParamData> getCostItems() {
        return this.costItems;
    }

    public int getMinPlayerLevel() {
        return this.minPlayerLevel;
    }

    public int getMaxPlayerLevel() {
        return this.maxPlayerLevel;
    }

    public int getBuyLimit() {
        return this.buyLimit;
    }

    public int getSubTabId() {
        return this.subTabId;
    }

    public ShopInfo.ShopRefreshType getRefreshType() {
        return this.refreshTypeEnum;
    }

    public int getRefreshParam() {
        return this.refreshParam;
    }
}
