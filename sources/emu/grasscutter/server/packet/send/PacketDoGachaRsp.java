package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.game.gacha.GachaBanner;
import emu.grasscutter.game.gacha.PlayerGachaBannerInfo;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DoGachaRspOuterClass;
import emu.grasscutter.net.proto.GachaItemOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDoGachaRsp.class */
public class PacketDoGachaRsp extends BasePacket {
    public PacketDoGachaRsp(GachaBanner banner, List<GachaItemOuterClass.GachaItem> list, PlayerGachaBannerInfo gachaInfo) {
        super(1598);
        int leftGachaTimes;
        ItemParamData costItem = banner.getCost(1);
        ItemParamData costItem10 = banner.getCost(10);
        int gachaTimesLimit = banner.getGachaTimesLimit();
        switch (gachaTimesLimit) {
            case Integer.MAX_VALUE:
                leftGachaTimes = Integer.MAX_VALUE;
                break;
            default:
                leftGachaTimes = Math.max(gachaTimesLimit - gachaInfo.getTotalPulls(), 0);
                break;
        }
        DoGachaRspOuterClass.DoGachaRsp.Builder rsp = DoGachaRspOuterClass.DoGachaRsp.newBuilder().setGachaType(banner.getGachaType()).setGachaScheduleId(banner.getScheduleId()).setGachaTimes(list.size()).setNewGachaRandom(12345).setLeftGachaTimes(leftGachaTimes).setGachaTimesLimit(gachaTimesLimit).setCostItemId(costItem.getId()).setCostItemNum(costItem.getCount()).setTenCostItemId(costItem10.getId()).setTenCostItemNum(costItem10.getCount()).addAllGachaItemList(list);
        if (banner.hasEpitomized()) {
            rsp.setWishItemId(gachaInfo.getWishItemId()).setWishProgress(gachaInfo.getFailedChosenItemPulls()).setWishMaxProgress(banner.getWishMaxProgress());
        }
        setData(rsp.build());
    }

    public PacketDoGachaRsp() {
        super(1598);
        setData(DoGachaRspOuterClass.DoGachaRsp.newBuilder().setRetcode(1).build());
    }

    public PacketDoGachaRsp(RetcodeOuterClass.Retcode retcode) {
        super(1598);
        setData(DoGachaRspOuterClass.DoGachaRsp.newBuilder().setRetcode(retcode.getNumber()).build());
    }
}
