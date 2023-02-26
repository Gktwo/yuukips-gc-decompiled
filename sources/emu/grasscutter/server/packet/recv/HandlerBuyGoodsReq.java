package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.shop.ShopInfo;
import emu.grasscutter.game.shop.ShopLimit;
import emu.grasscutter.game.shop.ShopSystem;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.BuyGoodsReqOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketBuyGoodsRsp;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Opcodes(787)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerBuyGoodsReq.class */
public class HandlerBuyGoodsReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        BuyGoodsReqOuterClass.BuyGoodsReq buyGoodsReq = BuyGoodsReqOuterClass.BuyGoodsReq.parseFrom(payload);
        List<ShopInfo> configShop = session.getServer().getShopSystem().getShopData().get(buyGoodsReq.getShopType());
        if (configShop != null) {
            Player player = session.getPlayer();
            for (Integer num : List.of(Integer.valueOf(buyGoodsReq.getGoods().getGoodsId()))) {
                int goodsId = num.intValue();
                Optional<ShopInfo> sg2 = configShop.stream().filter(x -> {
                    return x.getGoodsId() == goodsId;
                }).findFirst();
                if (!sg2.isEmpty()) {
                    ShopInfo sg = sg2.get();
                    int currentTs = Utils.getCurrentSeconds();
                    ShopLimit shopLimit = player.getGoodsLimit(sg.getGoodsId());
                    int bought = 0;
                    if (shopLimit != null) {
                        if (currentTs > shopLimit.getNextRefreshTime()) {
                            shopLimit.setNextRefreshTime(ShopSystem.getShopNextRefreshTime(sg));
                        } else {
                            bought = shopLimit.getHasBoughtInPeriod();
                        }
                        player.save();
                    }
                    if (bought + buyGoodsReq.getBuyCount() <= sg.getBuyLimit() || sg.getBuyLimit() == 0) {
                        List<ItemParamData> costs = new ArrayList<>(sg.getCostItemList());
                        costs.add(new ItemParamData(202, sg.getScoin()));
                        costs.add(new ItemParamData(201, sg.getHcoin()));
                        costs.add(new ItemParamData(203, sg.getMcoin()));
                        if (player.getInventory().payItems(costs, buyGoodsReq.getBuyCount())) {
                            player.addShopLimit(sg.getGoodsId(), buyGoodsReq.getBuyCount(), ShopSystem.getShopNextRefreshTime(sg));
                            player.getInventory().addItem(new GameItem(sg.getGoodsItem().getId(), buyGoodsReq.getBuyCount() * sg.getGoodsItem().getCount()), ActionReason.Shop, true);
                            session.send(new PacketBuyGoodsRsp(buyGoodsReq.getShopType(), player.getGoodsLimit(sg.getGoodsId()).getHasBoughtInPeriod(), (ShopGoodsOuterClass.ShopGoods) Stream.of(buyGoodsReq.getGoods()).filter(x -> {
                                return x.getGoodsId() == goodsId;
                            }).findFirst().get()));
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            player.save();
        }
    }
}
