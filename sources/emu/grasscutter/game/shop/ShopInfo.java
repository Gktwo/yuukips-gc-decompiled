package emu.grasscutter.game.shop;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.ShopGoodsData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/shop/ShopInfo.class */
public class ShopInfo {
    @SerializedName(value = "goodsId", alternate = {"goods_id"})
    private int goodsId;
    @SerializedName(value = "goodsItem", alternate = {"goods_item"})
    private ItemParamData goodsItem;
    private int scoin;
    @SerializedName(value = "costItemList", alternate = {"cost_item_list"})
    private List<ItemParamData> costItemList;
    @SerializedName(value = "buyLimit", alternate = {"buy_limit"})
    private int buyLimit;
    @SerializedName(value = "minLevel", alternate = {"min_level"})
    private int minLevel;
    @SerializedName(value = "maxLevel", alternate = {"max_level"})
    private int maxLevel;
    private int mcoin;
    private int hcoin;
    private int secondarySheetId;
    private String refreshType;
    private transient ShopRefreshType shopRefreshType;
    private int shopRefreshParam;
    private int boughtNum = 0;
    @SerializedName(value = "beginTime", alternate = {"begin_time"})
    private int beginTime = 0;
    @SerializedName(value = "endTime", alternate = {"end_time"})
    private int endTime = 1924992000;
    @SerializedName(value = "preGoodsIdList", alternate = {"pre_goods_id_list"})
    private List<Integer> preGoodsIdList = new ArrayList();
    private int disableType = 0;

    public int getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public ItemParamData getGoodsItem() {
        return this.goodsItem;
    }

    public void setGoodsItem(ItemParamData goodsItem) {
        this.goodsItem = goodsItem;
    }

    public int getScoin() {
        return this.scoin;
    }

    public void setScoin(int scoin) {
        this.scoin = scoin;
    }

    public List<ItemParamData> getCostItemList() {
        return this.costItemList;
    }

    public void setCostItemList(List<ItemParamData> costItemList) {
        this.costItemList = costItemList;
    }

    public int getBoughtNum() {
        return this.boughtNum;
    }

    public void setBoughtNum(int boughtNum) {
        this.boughtNum = boughtNum;
    }

    public int getBuyLimit() {
        return this.buyLimit;
    }

    public void setBuyLimit(int buyLimit) {
        this.buyLimit = buyLimit;
    }

    public int getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getMinLevel() {
        return this.minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public List<Integer> getPreGoodsIdList() {
        return this.preGoodsIdList;
    }

    public void setPreGoodsIdList(List<Integer> preGoodsIdList) {
        this.preGoodsIdList = preGoodsIdList;
    }

    public int getMcoin() {
        return this.mcoin;
    }

    public void setMcoin(int mcoin) {
        this.mcoin = mcoin;
    }

    public int getHcoin() {
        return this.hcoin;
    }

    public void setHcoin(int hcoin) {
        this.hcoin = hcoin;
    }

    public int getDisableType() {
        return this.disableType;
    }

    public void setDisableType(int disableType) {
        this.disableType = disableType;
    }

    public int getSecondarySheetId() {
        return this.secondarySheetId;
    }

    public void setSecondarySheetId(int secondarySheetId) {
        this.secondarySheetId = secondarySheetId;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/shop/ShopInfo$ShopRefreshType.class */
    public enum ShopRefreshType {
        NONE(0),
        SHOP_REFRESH_DAILY(1),
        SHOP_REFRESH_WEEKLY(2),
        SHOP_REFRESH_MONTHLY(3);
        
        private final int value;

        ShopRefreshType(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public void setShopRefreshType(ShopRefreshType shopRefreshType) {
        this.shopRefreshType = shopRefreshType;
    }

    public int getShopRefreshParam() {
        return this.shopRefreshParam;
    }

    public void setShopRefreshParam(int shopRefreshParam) {
        this.shopRefreshParam = shopRefreshParam;
    }

    public ShopInfo(ShopGoodsData sgd) {
        this.goodsId = 0;
        this.scoin = 0;
        this.buyLimit = 0;
        this.minLevel = 0;
        this.maxLevel = 61;
        this.mcoin = 0;
        this.hcoin = 0;
        this.secondarySheetId = 0;
        this.goodsId = sgd.getGoodsId();
        this.goodsItem = new ItemParamData(sgd.getItemId(), sgd.getItemCount());
        this.scoin = sgd.getCostScoin();
        this.mcoin = sgd.getCostMcoin();
        this.hcoin = sgd.getCostHcoin();
        this.buyLimit = sgd.getBuyLimit();
        this.minLevel = sgd.getMinPlayerLevel();
        this.maxLevel = sgd.getMaxPlayerLevel();
        this.costItemList = sgd.getCostItems().stream().filter(x -> {
            return x.getId() != 0;
        }).map(x -> {
            return new ItemParamData(x.getId(), x.getCount());
        }).toList();
        this.secondarySheetId = sgd.getSubTabId();
        this.shopRefreshType = sgd.getRefreshType();
        this.shopRefreshParam = sgd.getRefreshParam();
    }

    public ShopRefreshType getShopRefreshType() {
        if (this.refreshType == null) {
            return ShopRefreshType.NONE;
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
                return ShopRefreshType.SHOP_REFRESH_DAILY;
            case 1:
                return ShopRefreshType.SHOP_REFRESH_WEEKLY;
            case 2:
                return ShopRefreshType.SHOP_REFRESH_MONTHLY;
            default:
                return ShopRefreshType.NONE;
        }
    }

    private boolean evaluateVirtualCost(ItemParamData item) {
        switch (item.getId()) {
            case 201:
                this.hcoin += item.getCount();
                return true;
            case 203:
                this.mcoin += item.getCount();
                return true;
            default:
                return false;
        }
    }

    public void removeVirtualCosts() {
        if (this.costItemList != null) {
            this.costItemList.removeIf(item -> {
                return evaluateVirtualCost(item);
            });
        }
    }
}
