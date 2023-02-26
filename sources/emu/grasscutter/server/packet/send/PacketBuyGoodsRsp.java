package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.BuyGoodsRspOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBuyGoodsRsp.class */
public class PacketBuyGoodsRsp extends BasePacket {
    public PacketBuyGoodsRsp(int shopType, int boughtNum, ShopGoodsOuterClass.ShopGoods sg) {
        super(798);
        setData(BuyGoodsRspOuterClass.BuyGoodsRsp.newBuilder().setShopType(shopType).setBuyCount(boughtNum).addGoodsList(ShopGoodsOuterClass.ShopGoods.newBuilder().mergeFrom(sg).setBoughtNum(boughtNum)).build());
    }
}
