package emu.grasscutter.server.packet.send;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.shop.ShopInfo;
import emu.grasscutter.game.shop.ShopLimit;
import emu.grasscutter.game.shop.ShopSystem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetShopRspOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import emu.grasscutter.net.proto.ShopOuterClass;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetShopRsp.class */
public class PacketGetShopRsp extends BasePacket {
    public PacketGetShopRsp(Player inv, int shopType) {
        super(PacketOpcodes.GetShopRsp);
        ShopOuterClass.Shop.Builder shop = ShopOuterClass.Shop.newBuilder().setShopType(shopType).setCityId(1).setCityReputationLevel(10);
        ShopSystem manager = Grasscutter.getGameServer().getShopSystem();
        if (manager.getShopData().get(shopType) != null) {
            List<ShopInfo> list = manager.getShopData().get(shopType);
            List<ShopGoodsOuterClass.ShopGoods> goodsList = new ArrayList<>();
            for (ShopInfo info : list) {
                if (info.getGoodsItem() != null) {
                    ShopGoodsOuterClass.ShopGoods.Builder goods = ShopGoodsOuterClass.ShopGoods.newBuilder().setGoodsId(info.getGoodsId()).setGoodsItem(ItemParamOuterClass.ItemParam.newBuilder().setItemId(info.getGoodsItem().getId()).setCount(info.getGoodsItem().getCount()).build()).setScoin(info.getScoin()).setHcoin(info.getHcoin()).setBuyLimit(info.getBuyLimit()).setBeginTime(info.getBeginTime()).setEndTime(info.getEndTime()).setMinLevel(info.getMinLevel()).setMaxLevel(info.getMaxLevel()).setMcoin(info.getMcoin()).setDisableType(info.getDisableType()).setSecondarySheetId(info.getSecondarySheetId());
                    if (info.getCostItemList() != null) {
                        goods.addAllCostItemList((Iterable) info.getCostItemList().stream().map(x -> {
                            return ItemParamOuterClass.ItemParam.newBuilder().setItemId(x.getId()).setCount(x.getCount()).build();
                        }).collect(Collectors.toList()));
                    }
                    if (info.getPreGoodsIdList() != null) {
                        goods.addAllPreGoodsIdList(info.getPreGoodsIdList());
                    }
                    int currentTs = Utils.getCurrentSeconds();
                    ShopLimit currentShopLimit = inv.getGoodsLimit(info.getGoodsId());
                    int nextRefreshTime = ShopSystem.getShopNextRefreshTime(info);
                    if (currentShopLimit != null) {
                        if (currentShopLimit.getNextRefreshTime() < currentTs) {
                            currentShopLimit.setHasBoughtInPeriod(0);
                            currentShopLimit.setNextRefreshTime(nextRefreshTime);
                        }
                        goods.setBoughtNum(currentShopLimit.getHasBoughtInPeriod());
                        goods.setNextRefreshTime(currentShopLimit.getNextRefreshTime());
                    } else {
                        inv.addShopLimit(goods.getGoodsId(), 0, nextRefreshTime);
                        goods.setNextRefreshTime(nextRefreshTime);
                    }
                    goodsList.add(goods.build());
                }
            }
            shop.addAllGoodsList(goodsList);
        }
        inv.save();
        setData(GetShopRspOuterClass.GetShopRsp.newBuilder().setShop(shop).build());
    }
}
