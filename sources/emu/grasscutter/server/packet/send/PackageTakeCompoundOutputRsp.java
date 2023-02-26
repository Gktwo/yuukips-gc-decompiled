package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.TakeCompoundOutputRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PackageTakeCompoundOutputRsp.class */
public class PackageTakeCompoundOutputRsp extends BasePacket {
    public PackageTakeCompoundOutputRsp(Iterable<ItemParamOuterClass.ItemParam> itemList, int retcode) {
        super(143);
        setData(TakeCompoundOutputRspOuterClass.TakeCompoundOutputRsp.newBuilder().addAllItemList(itemList).setRetcode(retcode).build());
    }
}
