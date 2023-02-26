package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CombineReqOuterClass;
import emu.grasscutter.net.proto.CombineRspOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCombineRsp.class */
public class PacketCombineRsp extends BasePacket {
    public PacketCombineRsp() {
        super(630);
        setData(CombineRspOuterClass.CombineRsp.newBuilder().setRetcode(1).build());
    }

    public PacketCombineRsp(int retcode) {
        super(630);
        setData(CombineRspOuterClass.CombineRsp.newBuilder().setRetcode(retcode).build());
    }

    public PacketCombineRsp(CombineReqOuterClass.CombineReq combineReq, Iterable<ItemParamOuterClass.ItemParam> costItemList, Iterable<ItemParamOuterClass.ItemParam> resultItemList, Iterable<ItemParamOuterClass.ItemParam> totalRandomItemList, Iterable<ItemParamOuterClass.ItemParam> totalReturnItemList, Iterable<ItemParamOuterClass.ItemParam> totalExtraItemList) {
        super(630);
        setData(CombineRspOuterClass.CombineRsp.newBuilder().setRetcode(0).setCombineId(combineReq.getCombineId()).setCombineCount(combineReq.getCombineCount()).setAvatarGuid(combineReq.getAvatarGuid()).addAllCostItemList(costItemList).addAllResultItemList(resultItemList).addAllTotalRandomItemList(totalRandomItemList).addAllTotalReturnItemList(totalReturnItemList).addAllTotalExtraItemList(totalExtraItemList).build());
    }
}
